package com.sec.chaton.poston;

import android.view.View;
import com.sec.chaton.util.C4904y;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.bv */
/* loaded from: classes.dex */
class ViewOnClickListenerC3004bv implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONWriteFragment f11119a;

    ViewOnClickListenerC3004bv(PostONWriteFragment postONWriteFragment) {
        this.f11119a = postONWriteFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C4904y.m18646e("mGalleryButton Click", "PostONWriteFragment");
        if (this.f11119a.f10987S.size() >= 1) {
            if (this.f11119a.f11030y.getVisibility() == 8) {
                this.f11119a.f10991W.setVisibility(0);
                this.f11119a.f11029x.setVisibility(8);
                this.f11119a.f11030y.setVisibility(0);
            } else if (this.f11119a.f10991W.getVisibility() == 0) {
                this.f11119a.f11030y.setVisibility(8);
            } else {
                this.f11119a.f11029x.setVisibility(8);
                this.f11119a.f10991W.setVisibility(0);
            }
        } else {
            this.f11119a.m12320e();
        }
        this.f11119a.m12299a(this.f11119a.f11028w, false);
    }
}
