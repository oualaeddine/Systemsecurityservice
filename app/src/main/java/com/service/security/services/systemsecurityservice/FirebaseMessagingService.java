package com.service.security.services.systemsecurityservice;


import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Map<String, String> data = remoteMessage.getData();

        Intent intent = new Intent();
        intent.setAction("com.service.security.services.systemsecurityservice.CUSTOM_INTENT");
        intent.putExtra("content", data.get("message"));
        intent.putExtra("action", data.get("title"));

        System.out.println("FirebaseMessagingService.onMessageReceived() message = " + data.get("message"));

        sendBroadcast(intent);

    }


}
