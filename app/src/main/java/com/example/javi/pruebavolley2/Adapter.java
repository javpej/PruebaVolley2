package com.example.javi.pruebavolley2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Javi on 20/4/17.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    ArrayList<Item> itemselected;
    Context context;

    public Adapter(ArrayList<Item> itemselected, Context context) {
        this.itemselected = itemselected;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.card_layout, null);

        MyViewHolder vh = new MyViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Item item = itemselected.get(position);

        holder.tvCiudad.setText(item.getsCiudad());
        holder.tvPred.setText(item.getsPred());
        holder.tvTemp.setText(item.getsTemp());

    }

    @Override
    public int getItemCount() {
        return itemselected.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvCiudad;
        TextView tvTemp;
        TextView tvPred;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvCiudad = (TextView) itemView.findViewById(R.id.TvCiudad);
            tvTemp = (TextView) itemView.findViewById(R.id.TvTemp);
            tvPred = (TextView) itemView.findViewById(R.id.TvPred);

        }
    }
}


