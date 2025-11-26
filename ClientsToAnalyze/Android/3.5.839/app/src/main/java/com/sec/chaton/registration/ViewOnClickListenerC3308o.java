package com.sec.chaton.registration;

import android.view.View;
import com.sec.chaton.p055d.C2105bk;
import com.sec.chaton.sns.p114b.C4388an;
import com.sec.chaton.util.C4847bl;

/* compiled from: ActivitySignInWithAccount.java */
/* renamed from: com.sec.chaton.registration.o */
/* loaded from: classes.dex */
class ViewOnClickListenerC3308o implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySignInWithAccount f12085a;

    ViewOnClickListenerC3308o(ActivitySignInWithAccount activitySignInWithAccount) {
        this.f12085a = activitySignInWithAccount;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C4847bl.m18334a(400L)) {
            this.f12085a.f12193C = new C2105bk(this.f12085a, C4388an.class);
            this.f12085a.m13191s();
        }
    }
}
