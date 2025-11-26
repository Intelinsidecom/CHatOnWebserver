package com.sec.chaton.samsungaccount;

import android.app.Activity;
import android.view.View;
import com.sec.chaton.p055d.C2105bk;
import com.sec.chaton.sns.p114b.C4388an;
import com.sec.chaton.util.C4847bl;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.br */
/* loaded from: classes.dex */
class ViewOnClickListenerC3366br implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MainActivity f12304a;

    ViewOnClickListenerC3366br(MainActivity mainActivity) {
        this.f12304a = mainActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C4847bl.m18334a(400L)) {
            this.f12304a.f12193C = new C2105bk((Activity) this.f12304a.f12192B, C4388an.class);
            this.f12304a.m13191s();
        }
    }
}
