package com.sec.chaton.poston;

import android.view.View;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.bt */
/* loaded from: classes.dex */
class ViewOnClickListenerC3002bt implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONWriteFragment f11117a;

    ViewOnClickListenerC3002bt(PostONWriteFragment postONWriteFragment) {
        this.f11117a = postONWriteFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f11117a.f11028w.hasFocus()) {
            this.f11117a.f11030y.setVisibility(8);
        } else if (this.f11117a.f11030y.getVisibility() == 8 && !this.f11117a.f10987S.isEmpty()) {
            this.f11117a.f11030y.setVisibility(0);
        }
    }
}
