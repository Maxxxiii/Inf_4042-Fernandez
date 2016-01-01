package com.example.maxime.fabrigli;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.util.Log;

/**
 * Created by maxime on 31/12/2015.
 */
public class Notif extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
      //  Log.d(TAG, "ok!!" + getIntent().getAction());
        PendingIntent pi= PendingIntent.getActivity(context,0,new Intent(context,Recycler.class),0);

     NotificationCompat.Builder notification=new NotificationCompat.Builder(context);
        notification.setContentTitle(context.getString(R.string.NotifTitle));
        notification.setContentText(context.getString(R.string.NotifDL));
        notification.setSmallIcon(R.drawable.doublebeer);
        notification.setWhen(System.currentTimeMillis());
        notification.setContentIntent(pi);
        notification.setAutoCancel(true);



        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(28, notification.build());





    }

}
