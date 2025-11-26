package com.sec.chaton;

import android.os.Handler;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C1342t;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.InterfaceC3204bs;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.az */
/* loaded from: classes.dex */
class C0451az implements InterfaceC3204bs {

    /* renamed from: a */
    final /* synthetic */ TabActivity f1519a;

    C0451az(TabActivity tabActivity) {
        this.f1519a = tabActivity;
    }

    @Override // com.sec.chaton.util.InterfaceC3204bs
    /* renamed from: a */
    public boolean mo3063a() {
        if (!C3159aa.m10962a().m10987b("uid")) {
            return false;
        }
        new C1342t(new Handler()).m5909a();
        C3250y.m11450b("Start mMoreAppTask", GlobalApplication.class.getSimpleName());
        return true;
    }
}
