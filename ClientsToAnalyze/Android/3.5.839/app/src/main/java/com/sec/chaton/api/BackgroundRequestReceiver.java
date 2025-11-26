package com.sec.chaton.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.common.CommonApplication;

/* loaded from: classes.dex */
public class BackgroundRequestReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            CommonApplication.m18732r().startService(new Intent(CommonApplication.m18732r(), (Class<?>) BackgroundRequestService.class).setAction(intent.getAction()).putExtras(intent));
        }
    }
}
