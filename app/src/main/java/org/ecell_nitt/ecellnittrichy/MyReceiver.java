package org.ecell_nitt.ecellnittrichy;

/**
 * Created by S on 3/7/2015.
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent)
    {
        Log.i("----------------", "IN THE RECEIVER!");
        Intent service1 = new Intent(context, MyAlarmService.class);
        context.startService(service1);

    }
}
