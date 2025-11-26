package com.sec.chaton.settings;

import android.view.View;
import com.sec.chaton.p027e.p028a.C1360d;
import com.sec.common.CommonApplication;

/* compiled from: PostONHideAdapter.java */
/* renamed from: com.sec.chaton.settings.el */
/* loaded from: classes.dex */
class ViewOnClickListenerC2675el implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f9959a;

    /* renamed from: b */
    final /* synthetic */ C2674ek f9960b;

    ViewOnClickListenerC2675el(C2674ek c2674ek, int i) {
        this.f9960b = c2674ek;
        this.f9959a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f9960b.f9957e = this.f9960b.f9953a.get(this.f9959a);
        this.f9960b.f9956d = C1360d.m6037b(CommonApplication.m11493l().getContentResolver(), this.f9960b.f9953a.get(this.f9959a));
        if (this.f9960b.f9954b != null) {
            this.f9960b.f9954b.onItemClicked(this.f9960b.f9956d, this.f9960b.f9957e);
        }
    }
}
