package org.ecell_nitt.ecellnittrichy;

/**
 * Created by S on 3/7/2015.
 */
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class MyAlarmService extends Service
{
    private static final int NOTIFICATION_ID1=1;
    private static final int NOTIFICATION_ID2=2;
    private static final int NOTIFICATION_ID3=3;
    private static final int NOTIFICATION_ID4=4;
    private static final int NOTIFICATION_ID5=5;
    private static final int NOTIFICATION_ID6=6;
    private static final int NOTIFICATION_ID7=7;
    private NotificationManager mManager;
    private PendingIntent pendingIntent;
    int apilevel =  android.os.Build.VERSION.SDK_INT;

    @Override
    public IBinder onBind(Intent arg0)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onCreate()
    {
        // TODO Auto-generated method stub
        super.onCreate();
    }

    @SuppressWarnings("static-access")
    @Override
    public void onStart(Intent intent, int startId)
    {
        super.onStart(intent, startId);
        Log.i("----------------", "IN THE ONSTART!");

        mManager = (NotificationManager) this.getApplicationContext().getSystemService(this.getApplicationContext().NOTIFICATION_SERVICE);
        //mManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        /*Calendar c = Calendar.getInstance();
        if((c.MONTH==2)&&(c.DATE==7)&&(c.YEAR==2015))
        {
            if((c.MINUTE==5)&&(c.HOUR_OF_DAY==1))
            {
                displaynotif("This is at 1:05", "Content 1", NOTIFICATION_ID1, MainActivity.class);
            }
            else if((c.MINUTE==10)&&(c.HOUR_OF_DAY==1))
            {
                displaynotif("This is at 1:10", "Content 2", NOTIFICATION_ID2, MainActivity.class);
            }
        }*/

        String yourTime1 = "3:00";
        String yourTime2 = "2:45";
        String yourTime3 = "4:30";
        String yourTime4 = "5:00";
        String yourTime5 = "10:30";
        String yourTime6 = "1:30";
        String yourTime7 = "3:13";

//get your today date as string
        String today = (String) android.text.format.DateFormat.format(
                "hh:mm", new java.util.Date());
        Log.i("------------", "Constructing the time");
//Convert the two time string to date formate
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        Date date1 = null;
        Date date2 = null;
        Date date3 = null;
        Date date4 = null;
        Date date5 = null;
        Date date6 = null;
        Date date7 = null;
        Date date8 = null;
        try {
            date1 = sdf.parse(today);
            date2 = sdf.parse(yourTime1);
            date3 = sdf.parse(yourTime2);
            date4 = sdf.parse(yourTime3);
            date5 = sdf.parse(yourTime4);
            date6 = sdf.parse(yourTime5);
            date7 = sdf.parse(yourTime6);
            date8 = sdf.parse(yourTime7);
            Log.i("------------", "ABOVE THE COMPARISON");
            Log.i("------------", date1.toString() + " " + date2.toString());
            //do the comparison
            if (date1.equals(date2)) {
                    Log.i("------------", "IN THE COMPARISON");

                displaynotif("Idea Camp", "Starts at 3:30PM, 7th March", NOTIFICATION_ID1, MainActivity.class);
            }
            if (date1.equals(date3)) {
                Log.i("------------", "IN THE COMPARISON");
                displaynotif("Guest Lecture- Founder of Naturals", "Starts at 3:30PM, 8th March", NOTIFICATION_ID2, MainActivity.class);
            }
            if (date1.equals(date4)) {
                Log.i("------------", "IN THE COMPARISON");
                displaynotif("Stock Hunt Workshop", "Starts at 9:00AM, 8th March", NOTIFICATION_ID3, MainActivity.class);
            }
            if (date1.equals(date5)) {
                Log.i("------------", "IN THE COMPARISON");
                displaynotif("Logo Quiz", "Ongoing event- Don't miss out!", NOTIFICATION_ID4, MainActivity.class);
            }
            if (date1.equals(date6)) {
                Log.i("------------", "IN THE COMPARISON");
                displaynotif("Startup Quiz", "Starts at 11:00AM, 8th March", NOTIFICATION_ID5, MainActivity.class);
            }
            if (date1.equals(date7)) {
                Log.i("------------", "IN THE COMPARISON");
                displaynotif("Number Poker", "Starts at 2:00PM, 8th March", NOTIFICATION_ID6, MainActivity.class);
            }
            if (date1.equals(date8)) {
                Log.i("------------", "IN THE COMPARISON");
                displaynotif("E-Summit", "Welcome to E-Summit!", NOTIFICATION_ID7, MainActivity.class);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }



        /*Notification notification = new Notification(R.drawable.ic_launcher,"The Summit is ON!", System.currentTimeMillis());
        intent1.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP| Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingNotificationIntent = PendingIntent.getActivity( this.getApplicationContext(),0, intent1,PendingIntent.FLAG_UPDATE_CURRENT);
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notification.setLatestEventInfo(this.getApplicationContext(), "The Summit is ON!", "This is a test message!", pendingNotificationIntent);

        mManager.notify(0, notification);*/


        /*if(apilevel>=16)
            createNotification1();

        else
            createNotification2();*/
    }

    public void displaynotif(String title, String content, int id, Class<?> cls)
    {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle(title);
        builder.setContentText(content);
        Intent intent1 = new Intent(this.getApplicationContext(),cls);

        builder.setSmallIcon(R.drawable.ic_launcher);

        builder.setAutoCancel(true);
        pendingIntent = PendingIntent.getActivity(this.getApplicationContext(), id, intent1, PendingIntent.FLAG_CANCEL_CURRENT);
        builder.setContentIntent(pendingIntent);

        mManager.notify(id, builder.build());
    }

    @Override
    public void onDestroy()
    {
        // TODO Auto-generated method stub
        super.onDestroy();
    }

    /*@TargetApi(16)
    public void createNotification1()
    {
        Intent intent = new Intent(this.getApplicationContext(), MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Notification noti = new Notification.Builder(this)
                .setContentTitle("The Summit is on")
                .setContentText("Here's the description!").setSmallIcon(R.drawable.ic_launcher).setContentIntent(pIntent).build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        noti.flags |= Notification.FLAG_AUTO_CANCEL;

        notificationManager.notify(0, noti);
    }

    public void createNotification2()
    {
        final NotificationManager mgr=
                (NotificationManager)this.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification note=new Notification(R.drawable.ic_launcher,
                "The Summit is on!",
                System.currentTimeMillis());

        PendingIntent i=PendingIntent.getActivity(this, 0,
                new Intent(this, MainActivity.class),
                0);

        note.setLatestEventInfo(this, "The Summit is on!",
                "It's starting!", i);

        mgr.notify(NOTIFICATION_ID, note);
    }*/

}
