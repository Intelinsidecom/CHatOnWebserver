package com.sec.chaton.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;

/* loaded from: classes.dex */
public class CallLogReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private String f11513a = "CallLogReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            if (C4904y.f17872b) {
                C4904y.m18639b("Received CallLog", this.f11513a);
            }
            CommonApplication.m18732r().startService(new Intent(CommonApplication.m18732r(), (Class<?>) CallLogReceiveService.class).setAction(intent.getAction()).putExtras(intent));
        }
    }
}
