package com.sec.chaton.buddy;

import android.view.View;
import com.sec.chaton.buddy.p050a.C1106c;

/* compiled from: BuddyAdapter.java */
/* renamed from: com.sec.chaton.buddy.af */
/* loaded from: classes.dex */
class ViewOnClickListenerC1115af implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1106c f4322a;

    /* renamed from: b */
    final /* synthetic */ C1113ad f4323b;

    ViewOnClickListenerC1115af(C1113ad c1113ad, C1106c c1106c) {
        this.f4323b = c1113ad;
        this.f4322a = c1106c;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4323b.f4313t.mo6583a(this.f4322a);
    }
}
