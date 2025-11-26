package com.sec.chaton.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.service.PushRegistrationService;
import com.sec.chaton.util.C1341p;

/* loaded from: classes.dex */
public class PushRegistrationReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f3135a = PushRegistrationReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C1341p.m4658b("PushRegistrationReceiver.onReceive()", f3135a);
        context.startService(new Intent(context, (Class<?>) PushRegistrationService.class));
    }
}
