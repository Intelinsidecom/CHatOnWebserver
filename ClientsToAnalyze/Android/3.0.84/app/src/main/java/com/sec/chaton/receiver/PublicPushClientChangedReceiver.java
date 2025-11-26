package com.sec.chaton.receiver;

import android.content.Context;
import android.content.Intent;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.push.receiver.PublicPushClientMoniter;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;

/* loaded from: classes.dex */
public class PublicPushClientChangedReceiver extends PublicPushClientMoniter {

    /* renamed from: a */
    private static final String f8064a = PublicPushClientChangedReceiver.class.getSimpleName();

    @Override // com.sec.chaton.push.receiver.PublicPushClientMoniter, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (intent.getData().toString().split(":")[1].equals("com.sec.spp.push")) {
            if (action.equals("android.intent.action.PACKAGE_ADDED")) {
                C3250y.m11450b("Common push is installed. Clear get_version_push_registration_id", f8064a);
                C3159aa.m10962a().m10981a("get_version_push_reg_id");
                GlobalApplication.m6455d();
            } else if (action.equals("android.intent.action.PACKAGE_REMOVED")) {
                C3250y.m11450b("Common push is uninstalled. Clear get_version_push_registration_id", f8064a);
                C3159aa.m10962a().m10981a("get_version_push_reg_id");
            }
        }
        super.onReceive(context, intent);
    }

    @Override // com.sec.chaton.push.receiver.PublicPushClientMoniter
    /* renamed from: a */
    protected Intent mo8323a() {
        return new Intent(CommonApplication.m11493l(), (Class<?>) PushRegistrationReceiver.class);
    }

    @Override // com.sec.chaton.push.receiver.PublicPushClientMoniter
    /* renamed from: b */
    protected int mo8324b() {
        return 5000;
    }
}
