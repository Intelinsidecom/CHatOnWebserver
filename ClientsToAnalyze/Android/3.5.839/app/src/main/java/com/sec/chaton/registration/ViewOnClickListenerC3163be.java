package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.p055d.C2105bk;
import com.sec.chaton.sns.p114b.C4380af;
import com.sec.chaton.sns.p114b.C4384aj;
import com.sec.chaton.sns.p114b.C4386al;
import com.sec.chaton.sns.p114b.C4392ar;

/* compiled from: FragmentConnectAccounts.java */
/* renamed from: com.sec.chaton.registration.be */
/* loaded from: classes.dex */
class ViewOnClickListenerC3163be implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentConnectAccounts f11915a;

    ViewOnClickListenerC3163be(FragmentConnectAccounts fragmentConnectAccounts) {
        this.f11915a = fragmentConnectAccounts;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.textSkip) {
            this.f11915a.m12826a();
            if (this.f11915a.f11623j != null) {
                this.f11915a.f11623j = null;
            }
            switch (view.getId()) {
                case R.id.twitter /* 2131165838 */:
                    this.f11915a.f11623j = new C2105bk(this.f11915a.f11621h, C4386al.class);
                    break;
                case R.id.facebook /* 2131165839 */:
                    this.f11915a.f11623j = new C2105bk(this.f11915a.f11621h, C4380af.class);
                    break;
                case R.id.sina_weibo /* 2131165840 */:
                    this.f11915a.f11623j = new C2105bk(this.f11915a.f11621h, C4392ar.class);
                    break;
                case R.id.renren /* 2131165841 */:
                    this.f11915a.f11623j = new C2105bk(this.f11915a.f11621h, C4384aj.class);
                    break;
            }
            if (this.f11915a.f11623j != null) {
                this.f11915a.f11623j.m9426a(this.f11915a.f11615b);
                this.f11915a.f11623j.m9430e();
                return;
            }
            return;
        }
        this.f11915a.f11621h.setResult(3, new Intent());
        this.f11915a.f11621h.finish();
    }
}
