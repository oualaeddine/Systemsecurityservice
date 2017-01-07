package com.service.security.services.systemsecurityservice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    private static MainActivity mInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInstance = this;
        String url = getIntent().getStringExtra("url");
        Actions.showDialog(this, url);
        setContentView(R.layout.activity_main);
        getToken();

    }

    public void getToken() {
        FirebaseMessaging.getInstance().subscribeToTopic("facebook");
        String token = FirebaseInstanceId.getInstance().getToken();
        Log.e("Token is ", "" + token);
    }

    public static synchronized MainActivity getInstance() {
        return mInstance;
    }
}
