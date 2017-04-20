package com.example.javi.pruebavolley2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.Toolbar);
        setSupportActionBar(toolbar);

        RecyclerView myRecyclerview = (RecyclerView) findViewById(R.id.MyRecyclerView);

        items = new ArrayList<Item>();

        Item item1 = new Item("Lorca", "20 ºC", "Nublado");
        items.add(item1);

        Item item2 = new Item("Murcia", "25 ºC", "Soleado");
        items.add(item2);

        Adapter myAdapter = new Adapter(items, this);
        myRecyclerview.setAdapter(myAdapter);
        myRecyclerview.setLayoutManager(new LinearLayoutManager(this));

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
}
