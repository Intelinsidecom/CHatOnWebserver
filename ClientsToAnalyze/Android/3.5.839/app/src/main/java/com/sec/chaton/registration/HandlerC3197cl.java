package com.sec.chaton.registration;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;

/* compiled from: FragmentDisclaimerUpdate.java */
/* renamed from: com.sec.chaton.registration.cl */
/* loaded from: classes.dex */
class HandlerC3197cl extends Handler {

    /* renamed from: a */
    final /* synthetic */ FragmentDisclaimerUpdate f11961a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC3197cl(FragmentDisclaimerUpdate fragmentDisclaimerUpdate, Looper looper) {
        super(looper);
        this.f11961a = fragmentDisclaimerUpdate;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f11961a.f11662e != null) {
            C0778b c0778b = (C0778b) message.obj;
            if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                C4904y.m18639b("Success in accpet disclaimer", getClass().getSimpleName());
                C4809aa.m18108a("update_disclaimer_status", "DONE");
                C4822an.m18216a("agree_disclaimer", (Object) true);
                this.f11961a.f11662e.finish();
            } else if (c0778b.m3111f() == 42001) {
                C4904y.m18634a("Update Accept Disclaimer was failed by already accpeted disclaimer", getClass().getSimpleName());
                C4809aa.m18108a("update_disclaimer_status", "DONE");
                C4822an.m18216a("agree_disclaimer", (Object) true);
                this.f11961a.f11662e.finish();
            } else if (c0778b.m3111f() == 42002) {
                C4904y.m18634a("Update Accept Disclaimer was failed by iso was not matching", getClass().getSimpleName());
                C4809aa.m18108a("update_disclaimer_status", "DONE");
                C4822an.m18216a("agree_disclaimer", (Object) true);
                this.f11961a.f11662e.finish();
            } else {
                C4904y.m18639b("failed to accpet disclaimer", getClass().getSimpleName());
                C5179v.m19810a(this.f11961a.f11661d, R.string.toast_network_unable, 0).show();
            }
            this.f11961a.f11659b.dismiss();
        }
    }
}
