package com.sec.chaton.updates;

import android.view.View;

/* compiled from: UpdatesAdapter.java */
/* renamed from: com.sec.chaton.updates.b */
/* loaded from: classes.dex */
class ViewOnClickListenerC4695b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f17007a;

    /* renamed from: b */
    final /* synthetic */ C4694a f17008b;

    ViewOnClickListenerC4695b(C4694a c4694a, int i) {
        this.f17008b = c4694a;
        this.f17007a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f17008b.f17006e != null) {
            this.f17008b.f17006e.mo17738a(((C4709p) this.f17008b.f17005d.get(this.f17007a)).m17763a(0), ((C4709p) this.f17008b.f17005d.get(this.f17007a)).m17765b(0));
        }
    }
}
