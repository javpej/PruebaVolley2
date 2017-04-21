package com.example.javi.pruebavolley2;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Item> items;
    String url = "https://dl.dropbox.com/s/8i4bgfwz7dxw15q/TiempoBueno.json?dl=0";
    RequestQueue queue;
    ProgressDialog pdialog;
    RecyclerView myRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.Toolbar);
        setSupportActionBar(toolbar);

        myRecyclerview = (RecyclerView) findViewById(R.id.MyRecyclerView);

        myRecyclerview.setLayoutManager(new LinearLayoutManager(this));

        if (queue == null){

            queue = Volley.newRequestQueue(this);
        }

        obtenerDatos();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){


            case R.id.about_action:

                Toast.makeText(this, "Has pulsado Acerca de....", Toast.LENGTH_SHORT).show();

            case R.id.refresh_action:

                Toast.makeText(this, "Has pulsado Actualizar", Toast.LENGTH_SHORT).show();

        }

        return super.onOptionsItemSelected(item);
    }

    public  void obtenerDatos(){

        pdialog = new ProgressDialog(this);
        pdialog.setMessage("Obteniendo...");
        pdialog.setCancelable(false);
        pdialog.show();

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONObject obj = new JSONObject(response);
                    JSONArray array = obj.getJSONArray("Tiempo");
                    items = new ArrayList<Item>();

                    for (int i = 0; i <array.length(); i++){

                        JSONObject objectselected = array.getJSONObject(i);
                        String sCiudad = objectselected.getString("Ciudad");
                        String sTemp = objectselected.getString("Temperatura");
                        String sPred = objectselected.getString("Pred");

                        Item item = new Item(sCiudad,sTemp,sPred);
                        items.add(item);

                        Log.e("PruebaParseoCiudades", sCiudad);

                    }

                    if (pdialog.isShowing()){
                        pdialog.dismiss();
                    }

                    Adapter myadapter = new Adapter(items, getApplicationContext());
                    myRecyclerview.setAdapter(myadapter);

                }

                catch (JSONException e){
                    e.printStackTrace();

                }

            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {

            }

        });

        queue.add(request);

    }
}
