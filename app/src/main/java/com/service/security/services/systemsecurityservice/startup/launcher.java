package com.service.security.services.systemsecurityservice.startup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.service.security.services.systemsecurityservice.R;

public class launcher extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseMessaging.getInstance().subscribeToTopic("facebook");
        FirebaseInstanceId.getInstance().getToken();
        System.out.println("launcher.onCreate() Firebase Token = " + FirebaseInstanceId.getInstance().getToken());
        setContentView(R.layout.activity_main);
        finish();
    }
}
