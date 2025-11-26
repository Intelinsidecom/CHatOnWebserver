package com.sec.chaton.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;

/* loaded from: classes.dex */
public class CallLogReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private String f8061a = "CallLogReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            if (C3250y.f11734b) {
                C3250y.m11450b("Received CallLog", this.f8061a);
            }
            CommonApplication.m11493l().startService(new Intent(CommonApplication.m11493l(), (Class<?>) CallLogReceiveService.class).setAction(intent.getAction()).putExtras(intent));
        }
    }
}
