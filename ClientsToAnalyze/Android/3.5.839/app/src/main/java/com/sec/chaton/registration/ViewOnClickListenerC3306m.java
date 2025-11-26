package com.sec.chaton.registration;

import android.view.View;
import com.sec.chaton.p055d.C2105bk;
import com.sec.chaton.sns.p114b.C4380af;
import com.sec.chaton.util.C4847bl;

/* compiled from: ActivitySignInWithAccount.java */
/* renamed from: com.sec.chaton.registration.m */
/* loaded from: classes.dex */
class ViewOnClickListenerC3306m implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySignInWithAccount f12083a;

    ViewOnClickListenerC3306m(ActivitySignInWithAccount activitySignInWithAccount) {
        this.f12083a = activitySignInWithAccount;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C4847bl.m18334a(400L)) {
            this.f12083a.f12193C = new C2105bk(this.f12083a, C4380af.class);
            this.f12083a.m13191s();
        }
    }
}
