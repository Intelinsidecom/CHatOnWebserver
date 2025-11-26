package com.sec.chaton.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.service.PushRegistrationService;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class PushRegistrationReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f11523a = PushRegistrationReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null) {
            C4904y.m18639b("PushRegistrationReceiver.onReceive()", f11523a);
            context.startService(new Intent(context, (Class<?>) PushRegistrationService.class));
        }
    }
}
