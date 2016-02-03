package hari.custombroadcastreceiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.NotificationCompat;

/**
 * Created by Hari on 31/01/16.
 */
public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Intent notificationActivityIntent = new Intent(context, NotificationActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationActivityIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder b = new NotificationCompat.Builder(context);


        Notification notification = new Notification.Builder(context)
                .setTicker("That is displayed in the status bar")
                .setContentTitle("Title (first row) of the notification, in a standard notification")
                .setContentText("Text (second row) of the notification, in a standard notification")
                .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_SOUND)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(),
                        R.mipmap.ic_launcher))
                .setStyle(new Notification.BigPictureStyle()
                        .bigPicture(BitmapFactory.decodeResource(context.getResources(),
                                R.mipmap.ic_launcher)))
                .setContentIntent(contentIntent)
                .build();

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
    }
}
