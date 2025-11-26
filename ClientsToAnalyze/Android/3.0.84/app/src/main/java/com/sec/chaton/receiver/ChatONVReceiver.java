package com.sec.chaton.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.api.access_token.AccessTokenProvider;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.service.ChatONVService;
import com.sec.chaton.util.C3250y;
import twitter4j.conf.PropertyConfiguration;

/* loaded from: classes.dex */
public class ChatONVReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private final String f8062a = ChatONVReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context != null) {
            String action = intent.getAction();
            if (action.equals("com.sec.chaton.action.CREATE_ACCOUNT_CHATONV")) {
                String stringExtra = intent.getStringExtra(PropertyConfiguration.PASSWORD);
                if (C3250y.f11734b) {
                    C3250y.m11450b("action : " + action + " password : " + stringExtra, this.f8062a);
                }
                if (!AccessTokenProvider.m3068a(context, stringExtra)) {
                    if (C3250y.f11736d) {
                        C3250y.m11455d("Access token is invalid.", this.f8062a);
                    }
                } else {
                    Intent intent2 = new Intent(GlobalApplication.m11493l(), (Class<?>) ChatONVService.class);
                    intent2.putExtra("request_type", 1);
                    GlobalApplication.m11493l().startService(intent2);
                }
            }
        }
    }
}
