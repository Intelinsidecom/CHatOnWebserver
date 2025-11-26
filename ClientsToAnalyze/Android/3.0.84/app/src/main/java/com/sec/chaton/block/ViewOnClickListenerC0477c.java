package com.sec.chaton.block;

import android.view.View;
import com.sec.chaton.p025d.C1328f;

/* compiled from: BlockBuddyAdapter.java */
/* renamed from: com.sec.chaton.block.c */
/* loaded from: classes.dex */
class ViewOnClickListenerC0477c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0472a f1588a;

    ViewOnClickListenerC0477c(C0472a c0472a) {
        this.f1588a = c0472a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int iIntValue = ((Integer) view.getTag()).intValue();
        this.f1588a.f1575f = this.f1588a.f1570a.get(iIntValue).f1584a;
        this.f1588a.f1574e = this.f1588a.f1570a.get(iIntValue).f1585b;
        this.f1588a.f1573d = new C1328f(this.f1588a.f1571b);
        this.f1588a.f1573d.m5705a(this.f1588a.f1575f);
        this.f1588a.f1577h.show();
    }
}
