package com.sec.chaton.receiver;

import android.content.Context;
import android.content.Intent;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.push.receiver.PublicPushClientMoniter;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;

/* loaded from: classes.dex */
public class PublicPushClientChangedReceiver extends PublicPushClientMoniter {

    /* renamed from: a */
    private static final String f4151a = PublicPushClientChangedReceiver.class.getSimpleName();

    @Override // com.sec.chaton.push.receiver.PublicPushClientMoniter, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (intent.getData().toString().split(":")[1].equals("com.sec.spp.push")) {
            if (action.equals("android.intent.action.PACKAGE_ADDED")) {
                C1786r.m6061b("Common push is installed. Clear get_version_push_registration_id", f4151a);
                C1789u.m6075a().edit().remove("get_version_push_reg_id").commit();
            } else if (action.equals("android.intent.action.PACKAGE_REMOVED")) {
                C1786r.m6061b("Common push is uninstalled. Clear get_version_push_registration_id", f4151a);
                C1789u.m6075a().edit().remove("get_version_push_reg_id").commit();
            }
        }
        super.onReceive(context, intent);
    }

    @Override // com.sec.chaton.push.receiver.PublicPushClientMoniter
    /* renamed from: a */
    protected Intent mo4270a() {
        return new Intent(GlobalApplication.m3260b(), (Class<?>) PushRegistrationReceiver.class);
    }

    @Override // com.sec.chaton.push.receiver.PublicPushClientMoniter
    /* renamed from: b */
    protected int mo4271b() {
        return 5000;
    }
}
