package com.sec.chaton.poston;

import android.view.View;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.bs */
/* loaded from: classes.dex */
class ViewOnClickListenerC2006bs implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONWriteFragment f7721a;

    ViewOnClickListenerC2006bs(PostONWriteFragment postONWriteFragment) {
        this.f7721a = postONWriteFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f7721a.f7630v.hasFocus()) {
            this.f7721a.f7632x.setVisibility(8);
        } else if (this.f7721a.f7632x.getVisibility() == 8 && !this.f7721a.f7591Q.isEmpty()) {
            this.f7721a.f7632x.setVisibility(0);
        }
    }
}
