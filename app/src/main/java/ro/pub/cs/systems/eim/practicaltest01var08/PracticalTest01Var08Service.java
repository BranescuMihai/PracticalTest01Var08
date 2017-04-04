package ro.pub.cs.systems.eim.practicaltest01var08;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Copyright © 2017 Deutsche Bank. All rights reserved.
 */
public class PracticalTest01Var08Service extends Service
{
    private static Timer timer = new Timer();
    private Context ctx;
    public static final String FIRST_VALUE = "FIRST_VALUE";
    public static final String SECOND_VALUE = "SECOND_VALUE";
    public static final String THIRD_VALUE = "THIRD_VALUE";
    public static final String FORTH_VALUE = "FORTH_VALUE";

    static final String ACTION_BROAD = "ro.pub.cs.systems.eim.practicaltest01var08.action.ACTION_BROAD";

    public IBinder onBind(Intent arg0)
    {
        return null;
    }

    public void onCreate()
    {
        super.onCreate();
        ctx = this;
        startService();
    }

    private void startService()
    {
        timer.scheduleAtFixedRate(new mainTask(), 0, 10000);
    }

    private class mainTask extends TimerTask
    {
        public void run()
        {
            int min = 0;
            int max = 100;

            Random r = new Random();
            int i1 = r.nextInt(max - min + 1) + min;
            int i2 = r.nextInt(max - min + 1) + min;
            int i3 = r.nextInt(max - min + 1) + min;
            int i4 = r.nextInt(max - min + 1) + min;

            Intent intent = new Intent();
            intent.putExtra(FIRST_VALUE, i1);
            intent.putExtra(SECOND_VALUE, i2);
            intent.putExtra(THIRD_VALUE, i3);
            intent.putExtra(FORTH_VALUE, i4);
            intent.setAction(ACTION_BROAD);
            sendBroadcast(intent);
        }
    }

    public void onDestroy()
    {
        super.onDestroy();
        Toast.makeText(this, "Service Stopped ...", Toast.LENGTH_SHORT).show();
    }
}