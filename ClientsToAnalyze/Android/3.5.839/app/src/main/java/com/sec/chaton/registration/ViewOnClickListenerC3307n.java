package com.sec.chaton.registration;

import android.view.View;
import com.sec.chaton.p055d.C2105bk;
import com.sec.chaton.sns.p114b.C4382ah;
import com.sec.chaton.util.C4847bl;

/* compiled from: ActivitySignInWithAccount.java */
/* renamed from: com.sec.chaton.registration.n */
/* loaded from: classes.dex */
class ViewOnClickListenerC3307n implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySignInWithAccount f12084a;

    ViewOnClickListenerC3307n(ActivitySignInWithAccount activitySignInWithAccount) {
        this.f12084a = activitySignInWithAccount;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C4847bl.m18334a(400L)) {
            this.f12084a.f12193C = new C2105bk(this.f12084a, C4382ah.class);
            this.f12084a.m13191s();
        }
    }
}
