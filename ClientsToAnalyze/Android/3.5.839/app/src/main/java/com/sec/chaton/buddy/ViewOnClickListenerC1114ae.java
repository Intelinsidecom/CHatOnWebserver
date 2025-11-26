package com.sec.chaton.buddy;

import android.view.View;
import com.sec.chaton.buddy.p050a.C1106c;

/* compiled from: BuddyAdapter.java */
/* renamed from: com.sec.chaton.buddy.ae */
/* loaded from: classes.dex */
class ViewOnClickListenerC1114ae implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1106c f4320a;

    /* renamed from: b */
    final /* synthetic */ C1113ad f4321b;

    ViewOnClickListenerC1114ae(C1113ad c1113ad, C1106c c1106c) {
        this.f4321b = c1113ad;
        this.f4320a = c1106c;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4321b.f4314u.mo6584a(this.f4320a, view);
    }
}
