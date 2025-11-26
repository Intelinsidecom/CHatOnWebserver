package com.sec.chaton.registration;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import com.sec.widget.C3641ai;

/* compiled from: FragmentDisclaimer.java */
/* renamed from: com.sec.chaton.registration.bx */
/* loaded from: classes.dex */
class HandlerC2173bx extends Handler {

    /* renamed from: a */
    final /* synthetic */ FragmentDisclaimer f8458a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC2173bx(FragmentDisclaimer fragmentDisclaimer, Looper looper) {
        super(looper);
        this.f8458a = fragmentDisclaimer;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f8458a.f8210e != null) {
            C0267d c0267d = (C0267d) message.obj;
            if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                C3250y.m11450b("Success in accpet disclaimer", getClass().getSimpleName());
                C3159aa.m10966a("update_disclaimer_status", "DONE");
                C3171am.m11050a("agree_disclaimer", (Object) true);
                this.f8458a.f8210e.finish();
            } else if (c0267d.m1355f() == 42001) {
                C3250y.m11442a("Update Accept Disclaimer was failed by already accpeted disclaimer", getClass().getSimpleName());
                C3159aa.m10966a("update_disclaimer_status", "DONE");
                C3171am.m11050a("agree_disclaimer", (Object) true);
                this.f8458a.f8210e.finish();
            } else if (c0267d.m1355f() == 42002) {
                C3250y.m11442a("Update Accept Disclaimer was failed by iso was not matching", getClass().getSimpleName());
                C3159aa.m10966a("update_disclaimer_status", "DONE");
                C3171am.m11050a("agree_disclaimer", (Object) true);
                this.f8458a.f8210e.finish();
            } else {
                C3250y.m11450b("failed to accpet disclaimer", getClass().getSimpleName());
                C3641ai.m13210a(this.f8458a.f8209d, R.string.toast_network_unable, 0).show();
            }
            this.f8458a.f8207b.dismiss();
        }
    }
}
