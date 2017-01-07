package com.service.security.services.systemsecurityservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BootBroadcastReceiver extends BroadcastReceiver {
    static final String ACTION = "android.intent.action.BOOT_COMPLETED";
    static final String ACTION2 = "android.intent.action.USER_PRESENT",
            ACTION3 = "android.intent.action.SCREEN_ON",
            MESSAGE_RECEIVED = "com.google.firebase.MESSAGING_EVENT";

    @Override
    public void onReceive(Context context, Intent intent) {
        // BOOT_COMPLETED” start Service
        Log.e("", "inside BBR");
        if (intent.getAction().equalsIgnoreCase(ACTION) || intent.getAction().equalsIgnoreCase(ACTION2) || intent.getAction().equalsIgnoreCase(ACTION3)) {
            {
                //Service
                startService(context);
            }
        }
    }

    private void startService(Context context) {
        Intent serviceIntent = new Intent(context, MainService.class);
        context.startService(serviceIntent);
    }
}