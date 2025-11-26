package com.sec.chaton.receiver;

import android.content.Context;
import android.content.Intent;
import com.sec.chaton.push.receiver.PublicPushClientMoniter;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;

/* loaded from: classes.dex */
public class PublicPushClientChangedReceiver extends PublicPushClientMoniter {

    /* renamed from: a */
    private static final String f11517a = PublicPushClientChangedReceiver.class.getSimpleName();

    @Override // com.sec.chaton.push.receiver.PublicPushClientMoniter, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction() != null && intent.getData() != null) {
            String action = intent.getAction();
            if (intent.getData().toString().split(":")[1].equals("com.sec.spp.push")) {
                if (action.equals("android.intent.action.PACKAGE_ADDED")) {
                    C4904y.m18639b("Common push is installed. Clear get_version_push_registration_id", f11517a);
                    C4809aa.m18104a().m18123a("get_version_push_reg_id");
                } else if (action.equals("android.intent.action.PACKAGE_REMOVED")) {
                    C4904y.m18639b("Common push is uninstalled. Clear get_version_push_registration_id", f11517a);
                    C4809aa.m18104a().m18123a("get_version_push_reg_id");
                }
            }
            super.onReceive(context, intent);
        }
    }

    @Override // com.sec.chaton.push.receiver.PublicPushClientMoniter
    /* renamed from: a */
    protected Intent mo12665a() {
        return new Intent(CommonApplication.m18732r(), (Class<?>) PushRegistrationReceiver.class);
    }

    @Override // com.sec.chaton.push.receiver.PublicPushClientMoniter
    /* renamed from: b */
    protected int mo12666b() {
        return 5000;
    }
}
