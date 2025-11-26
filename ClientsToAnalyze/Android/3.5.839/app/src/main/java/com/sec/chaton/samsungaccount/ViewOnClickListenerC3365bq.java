package com.sec.chaton.samsungaccount;

import android.app.Activity;
import android.view.View;
import com.sec.chaton.p055d.C2105bk;
import com.sec.chaton.sns.p114b.C4382ah;
import com.sec.chaton.util.C4847bl;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.bq */
/* loaded from: classes.dex */
class ViewOnClickListenerC3365bq implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MainActivity f12303a;

    ViewOnClickListenerC3365bq(MainActivity mainActivity) {
        this.f12303a = mainActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C4847bl.m18334a(400L)) {
            this.f12303a.f12193C = new C2105bk((Activity) this.f12303a.f12192B, C4382ah.class);
            this.f12303a.m13191s();
        }
    }
}
