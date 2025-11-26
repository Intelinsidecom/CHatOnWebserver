package com.sec.chaton.receiver;

import android.content.Context;
import android.content.Intent;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.push.receiver.PublicPushClientMoniter;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;

/* loaded from: classes.dex */
public class PublicPushClientChangedReceiver extends PublicPushClientMoniter {

    /* renamed from: a */
    private static final String f3129a = PublicPushClientChangedReceiver.class.getSimpleName();

    @Override // com.sec.chaton.push.receiver.PublicPushClientMoniter, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (intent.getData().toString().split(":")[1].equals("com.sec.spp.push")) {
            if (action.equals("android.intent.action.PACKAGE_ADDED")) {
                C1341p.m4658b("Common push is installed. Clear get_version_push_registration_id", f3129a);
                C1323bs.m4575a().edit().remove("get_version_push_reg_id").commit();
            } else if (action.equals("android.intent.action.PACKAGE_REMOVED")) {
                C1341p.m4658b("Common push is uninstalled. Clear get_version_push_registration_id", f3129a);
                C1323bs.m4575a().edit().remove("get_version_push_reg_id").commit();
            }
        }
        super.onReceive(context, intent);
    }

    @Override // com.sec.chaton.push.receiver.PublicPushClientMoniter
    /* renamed from: a */
    protected Intent mo3597a() {
        return new Intent(GlobalApplication.m3100a(), (Class<?>) PushRegistrationReceiver.class);
    }

    @Override // com.sec.chaton.push.receiver.PublicPushClientMoniter
    /* renamed from: b */
    protected int mo3598b() {
        return 5000;
    }
}
