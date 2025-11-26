package com.sec.chaton.samsungaccount;

import android.app.Activity;
import android.view.View;
import com.sec.chaton.p055d.C2105bk;
import com.sec.chaton.sns.p114b.C4380af;
import com.sec.chaton.util.C4847bl;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.bp */
/* loaded from: classes.dex */
class ViewOnClickListenerC3364bp implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MainActivity f12302a;

    ViewOnClickListenerC3364bp(MainActivity mainActivity) {
        this.f12302a = mainActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C4847bl.m18334a(400L)) {
            this.f12302a.f12193C = new C2105bk((Activity) this.f12302a.f12192B, C4380af.class);
            this.f12302a.m13191s();
        }
    }
}
