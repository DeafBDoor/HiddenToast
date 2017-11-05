package com.example.richard.hiddentoast;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Calendar;

/**
 * Created by richard on 04/11/17.
 */

class Helper {
    /**
     * Helper function to start periodical calls to ToastDeliver Receiver.
     *
     * @param context
     */
    static void registerIntoAlarmManager(Context context) {
        Intent toastIntent = new Intent(context, ToastDeliver.class);
        toastIntent.setAction(Constants.TOAST_INTENT);

        // PendingIntent which will be used by the alarm manager to make calls to the
        // ToastDeliver Broadcast Receiver
        PendingIntent pendingIntent =
                PendingIntent.getBroadcast(context, 1, toastIntent,
                        PendingIntent.FLAG_CANCEL_CURRENT);

        // I use the alarm manager in order to let the Android system call efficiently choose
        // when to trigger the alarm (and deliver the associated intent), thus reducing
        // battery consumption.
        // The use of RTC without the WAKE suffix, avoids waking up the phone when its screen
        // is off.
        Calendar current = Calendar.getInstance();
        AlarmManager am = context.getSystemService(AlarmManager.class);
        am.setInexactRepeating(AlarmManager.RTC,
                current.getTimeInMillis() +1000, 30000, pendingIntent);

        Log.d(Constants.TAG, "Registering ToastDeliver PendingIntent " +
                "into alarm manager");
    }
}
