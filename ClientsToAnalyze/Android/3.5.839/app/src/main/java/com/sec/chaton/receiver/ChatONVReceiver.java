package com.sec.chaton.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.api.access_token.AccessTokenProvider;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.service.ChatONVService;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class ChatONVReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private final String f11514a = ChatONVReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context != null) {
            String action = intent.getAction();
            if (action.equals("com.sec.chaton.action.CREATE_ACCOUNT_CHATONV")) {
                String stringExtra = intent.getStringExtra("password");
                if (C4904y.f17872b) {
                    C4904y.m18639b("action : " + action + " password : " + stringExtra, this.f11514a);
                }
                if (!AccessTokenProvider.m6136a(context, stringExtra)) {
                    if (C4904y.f17874d) {
                        C4904y.m18645d("Access token is invalid.", this.f11514a);
                    }
                } else {
                    Intent intent2 = new Intent(GlobalApplication.m18732r(), (Class<?>) ChatONVService.class);
                    intent2.putExtra("request_type", 1);
                    GlobalApplication.m18732r().startService(intent2);
                }
            }
        }
    }
}
