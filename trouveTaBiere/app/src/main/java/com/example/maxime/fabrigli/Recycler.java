package com.example.maxime.fabrigli;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by maxime on 31/12/2015.
 */
public class Recycler extends AppCompatActivity {

    private RecyclerView.Adapter myadapter;
    private RecyclerView mRecyclerView;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        myadapter = new BiersAdapter(getBiersFromFile());

        mRecyclerView.setAdapter(myadapter);

    }



    public JSONArray getBiersFromFile() {
        try {
            InputStream is = new FileInputStream(getCacheDir() + "/" + "bieres.json");
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            return new JSONArray(new String(buffer, "UTF-8"));
        } catch (JSONException e) {
            e.printStackTrace();
            return new JSONArray();
        } catch (IOException e) {
            e.printStackTrace();
            return new JSONArray();
        }

    }


    private class BiersAdapter extends RecyclerView.Adapter<BierHolder> {
        JSONArray jArray = null;

        public BiersAdapter(JSONArray array) {
            this.jArray=array;
        }


        @Override
        public BierHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_bier_element, parent, false);
            BierHolder x = new BierHolder(v);
            return x;

        }

        @Override
        public void onBindViewHolder(BierHolder holder, int position) {
            JSONObject labiere;
            String nomBier;
            try {
                labiere=jArray.getJSONObject(position);
                nomBier=labiere.getString("name");
                holder.name.setText(nomBier);
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }

        @Override
        public int getItemCount() {
            return jArray.length();
        }
    }

    /*

    public class BierHolder extends RecyclerView.ViewHolder {
        public TextView name;


        public BierHolder(View itemView) {

            super(itemView);
            name=(TextView)itemView.findViewById(R.id.rv_bier_element_name);

        }


    }

*/
}




