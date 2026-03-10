package com.example.broadcastreceiverapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class PowerBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String message;
        String intentAction = intent.getAction();

        switch (intentAction) {
            case Intent.ACTION_POWER_CONNECTED:
                message = "Phone has been connected to a power outlet";
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                message = "Phone has been disconnected from a power outlet";
                break;
            default:
                message = "I have no idea what happened";
        }

        Toast.makeText(context, message, Toast.LENGTH_LONG).show();



    }
}