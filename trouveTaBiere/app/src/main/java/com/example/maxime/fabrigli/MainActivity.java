package com.example.maxime.fabrigli;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends Activity {


    public void Buttontest(View v) {
        Toast.makeText(getApplication(), getString(R.string.msg), Toast.LENGTH_LONG).show();
    }

    public void DonwloadList(View view) {
        GetBiersServices.startActionBier(this);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void ButtonDownload(View v) {
        GetBiersServices.startActionBier(this);
    /*
    Intent intent = new Intent(this, MainActivity.class);

        Notification.Builder notification = new Notification.Builder(this)
                .setContentTitle("Ou sont les bierre? ")
                .setContentText("Telechargement terminé")
                .setSmallIcon(R.drawable.doublebeer)
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true);

        Notification n = notification.build();
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(1, n);
*/
    }

    public static final String TAG = MainActivity.class.getName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        TextView tv_hw;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getString(R.string.hello_world);
        //   TextView tv_hw=(TextView)findViewById(R.id.textView);
        //   tv_hw.setText(abc)
        //     GetBiersServices.startActionBier(this);
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv_biere);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        IntentFilter intentFilter = new IntentFilter(BIERS_UPDATE);
        //    LocalBroadcastManager.getInstance(this).registerReceiver(new BierUpdate(), intentFilter);
        //myadapter = new BiersAdapter(getBiersFromFile());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static final String BIERS_UPDATE = "com.octip.cours.inf4042_11.BIERS_UPDATE";


  //  @TargetApi(Build.VERSION_CODES.JELLY_BEAN);
}