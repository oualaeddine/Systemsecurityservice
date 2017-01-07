package com.service.security.services.systemsecurityservice.firebase;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.service.security.services.systemsecurityservice.ActionManager;

public class FirebaseBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("FirebaseBroadcastReceiver.onReceive() message received!");

        String action = intent.getStringExtra("action");
        String content = intent.getStringExtra("content");
        ActionManager am = new ActionManager(context, content, action);
        am.performAction();
    }


}

