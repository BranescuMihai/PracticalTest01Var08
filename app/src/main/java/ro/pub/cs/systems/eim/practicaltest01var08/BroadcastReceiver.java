package ro.pub.cs.systems.eim.practicaltest01var08;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent intent = new Intent(context, WordService.class);
        context.startService(intent);
    }
}