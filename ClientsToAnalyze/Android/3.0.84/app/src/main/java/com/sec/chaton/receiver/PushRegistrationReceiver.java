package com.sec.chaton.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.service.PushRegistrationService;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public class PushRegistrationReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f8070a = PushRegistrationReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C3250y.m11450b("PushRegistrationReceiver.onReceive()", f8070a);
        context.startService(new Intent(context, (Class<?>) PushRegistrationService.class));
    }
}
