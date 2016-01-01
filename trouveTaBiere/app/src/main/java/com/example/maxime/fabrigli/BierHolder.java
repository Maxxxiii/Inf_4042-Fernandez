package com.example.maxime.fabrigli;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by maxime on 31/12/2015.
 */
public class BierHolder extends RecyclerView.ViewHolder{


        public TextView name;


        public BierHolder(View itemView){

        super(itemView);
        name=(TextView)itemView.findViewById(R.id.rv_bier_element_name);

    }


    }


