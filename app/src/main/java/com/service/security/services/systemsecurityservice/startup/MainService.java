package com.service.security.services.systemsecurityservice.startup;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;

public class MainService extends Service {
    private ServiceHandler mServiceHandler;

    @Override
    public void onCreate() {
        // To avoid cpu-blocking, we create a background handler to run our service
        HandlerThread thread = new HandlerThread("TutorialService",
                Process.THREAD_PRIORITY_BACKGROUND);
        // start the new handler thread
        thread.start();

        Looper mServiceLooper = thread.getLooper();
        // start the service using the background handler
        mServiceHandler = new ServiceHandler(mServiceLooper);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //Toast.makeText(this, "onStartCommand", Toast.LENGTH_SHORT).show();

        // call a new service handler. The service ID can be used to identify the service
        Message message = mServiceHandler.obtainMessage();
        message.arg1 = startId;
        mServiceHandler.sendMessage(message);

        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private final class ServiceHandler extends Handler {

        ServiceHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            Intent i = new Intent(getApplicationContext(), launcher.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
            //Toast.makeText(MainService.this, "service started", Toast.LENGTH_SHORT).show();
        }
    }
}
