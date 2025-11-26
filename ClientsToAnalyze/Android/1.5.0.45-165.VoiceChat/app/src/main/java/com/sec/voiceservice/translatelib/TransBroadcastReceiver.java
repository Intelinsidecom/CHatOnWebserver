package com.sec.voiceservice.translatelib;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.sds.coolots.login.p018a.C1268d;
import com.sec.chaton.clientapi.NotificationAPI;

/* loaded from: classes.dex */
public class TransBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "TransLib";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String accessToken;
        String clientId;
        String country3name;
        if ("com.msc.action.ACCESSTOKEN_V02_RESPONSE".equals(intent.getAction())) {
            int resultCode = intent.getIntExtra(NotificationAPI.RESULT_CODE, -999);
            String errorMessage = null;
            try {
                if (resultCode == -1) {
                    accessToken = intent.getStringExtra("access_token");
                    clientId = intent.getStringExtra("client_id");
                    country3name = intent.getStringExtra(C1268d.f3197g);
                    Log.e(TAG, "country3name: " + country3name);
                } else {
                    accessToken = "";
                    clientId = intent.getStringExtra("client_id");
                    errorMessage = intent.getStringExtra("error_message");
                    country3name = "";
                    Log.e(TAG, "BroadcastReceiver error: " + errorMessage);
                }
            } catch (Exception e) {
                e.printStackTrace();
                accessToken = "";
                clientId = "";
                country3name = "";
                Log.e(TAG, "BroadcastReceiver Exception");
            }
            Translate.setToken(accessToken, clientId, country3name, errorMessage);
        }
    }
}
