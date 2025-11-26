package com.sec.chaton;

import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p020c.C0816a;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.InterfaceC3204bs;
import com.sec.common.util.C3364o;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.bc */
/* loaded from: classes.dex */
class C0462bc implements InterfaceC3204bs {

    /* renamed from: a */
    final /* synthetic */ TabActivity f1530a;

    C0462bc(TabActivity tabActivity) {
        this.f1530a = tabActivity;
    }

    @Override // com.sec.chaton.util.InterfaceC3204bs
    /* renamed from: a */
    public boolean mo3063a() {
        if (C3250y.f11734b) {
            C3250y.m11450b(C3364o.m11849a("UID : ", Boolean.valueOf(C3159aa.m10962a().m10987b("uid")), ", compatibility : ", C3159aa.m10962a().m10979a("compatibility", ""), ", version : ", C0816a.f3112a), TabActivity.f732f);
        }
        if (!C3159aa.m10962a().m10987b("uid") || (!TextUtils.isEmpty(C3159aa.m10962a().m10979a("compatibility", "")) && C0816a.f3112a.equals(C3159aa.m10962a().m10979a("compatibility", "")))) {
            return false;
        }
        new C1330h(this.f1530a.f775ap).m5755h();
        C3250y.m11450b("Start CompatibilityTask", GlobalApplication.class.getSimpleName());
        return true;
    }
}
