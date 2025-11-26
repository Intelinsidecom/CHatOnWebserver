package com.sec.chaton.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.service.PushRegistrationService;
import com.sec.chaton.util.C1786r;

/* loaded from: classes.dex */
public class PushRegistrationReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f4157a = PushRegistrationReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C1786r.m6061b("PushRegistrationReceiver.onReceive()", f4157a);
        context.startService(new Intent(context, (Class<?>) PushRegistrationService.class));
    }
}
