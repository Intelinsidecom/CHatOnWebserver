package com.sec.chaton.settings;

import android.content.Intent;
import com.sec.chaton.R;
import com.sec.chaton.util.C4822an;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: ActivityManageAccounts.java */
/* renamed from: com.sec.chaton.settings.az */
/* loaded from: classes.dex */
class C3508az implements InterfaceC3650gc {

    /* renamed from: a */
    final /* synthetic */ ActivityManageAccounts f12996a;

    C3508az(ActivityManageAccounts activityManageAccounts) {
        this.f12996a = activityManageAccounts;
    }

    @Override // com.sec.chaton.settings.InterfaceC3650gc
    /* renamed from: a */
    public void mo13848a() {
        this.f12996a.m13402d();
        this.f12996a.f12529l.mo16641a(new C3510ba(this));
    }

    @Override // com.sec.chaton.settings.InterfaceC3650gc
    /* renamed from: b */
    public void mo13849b() {
        if (this.f12996a.m13397b()) {
            AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f12996a.f12526i);
            abstractC4932aM18733a.mo18751b(true);
            abstractC4932aM18733a.mo18734a(R.string.sns_account_sign_out).mo18749b(this.f12996a.getString(R.string.disconnect_sns_account_pop_q, new Object[]{this.f12996a.getString(this.f12996a.m13393a(C4822an.m18198H()))})).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC3512bc(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3511bb(this));
            if (!this.f12996a.f12533p) {
                abstractC4932aM18733a.mo18752b();
                return;
            }
            return;
        }
        this.f12996a.startActivity(new Intent(this.f12996a.f12526i, (Class<?>) ActivityDeregister.class));
    }
}
