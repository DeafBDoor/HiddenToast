package com.example.richard.hiddentoast;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.util.Calendar;

public class ToastDeliver extends BroadcastReceiver {

    /**
     * Broadcast receiver which will be responsible for displaying the toast message on screen.
     * @param
     * @param
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().
                equals(Constants.TOAST_INTENT)) {
            Toast toast = Toast.makeText(context,
                    context.getString(R.string.toast_text), Toast.LENGTH_LONG);
            toast.show();
            Log.d(Constants.TAG, "onReceive: Delivering toast");
        }

    }
}
