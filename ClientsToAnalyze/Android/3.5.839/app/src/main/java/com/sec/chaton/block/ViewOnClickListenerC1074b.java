package com.sec.chaton.block;

import android.view.View;
import com.sec.chaton.p055d.C2126g;

/* compiled from: BlockBuddyAdapter.java */
/* renamed from: com.sec.chaton.block.b */
/* loaded from: classes.dex */
class ViewOnClickListenerC1074b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1073a f3453a;

    ViewOnClickListenerC1074b(C1073a c1073a) {
        this.f3453a = c1073a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int iIntValue = ((Integer) view.getTag()).intValue();
        this.f3453a.f3447f = this.f3453a.f3442a.get(iIntValue).f3484a;
        this.f3453a.f3446e = this.f3453a.f3442a.get(iIntValue).f3485b;
        this.f3453a.f3445d = C2126g.m9476a(this.f3453a.f3443b);
        this.f3453a.f3445d.m9478a(this.f3453a.f3447f);
        this.f3453a.f3449h.show();
    }
}
