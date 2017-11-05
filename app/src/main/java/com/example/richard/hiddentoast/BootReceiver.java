package com.example.richard.hiddentoast;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Calendar;

public class BootReceiver extends BroadcastReceiver {

    /**
     * This broadcast receiver will setup the periodic calls to ToastDeliver.
     *
     * @param
     * @param
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
            Helper.registerIntoAlarmManager(context);
        }
    }
}
