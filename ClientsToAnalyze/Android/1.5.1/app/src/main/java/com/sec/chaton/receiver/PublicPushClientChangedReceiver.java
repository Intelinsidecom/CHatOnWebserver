package com.sec.chaton.receiver;

import android.content.Context;
import android.content.Intent;
import com.sec.chaton.push.PublicPushClientMoniter;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;

/* loaded from: classes.dex */
public class PublicPushClientChangedReceiver extends PublicPushClientMoniter {

    /* renamed from: a */
    private static final String f2798a = PublicPushClientChangedReceiver.class.getSimpleName();

    @Override // com.sec.chaton.push.PublicPushClientMoniter, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ChatONLogWriter.m3506b("Clear last_sync_time_on_start to 0", f2798a);
        ChatONPref.m3519a().edit().putLong("last_sync_time_on_start", 0L).commit();
        super.onReceive(context, intent);
    }
}
