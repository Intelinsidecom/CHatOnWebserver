package com.sec.chaton.poston;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.util.C3250y;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.bu */
/* loaded from: classes.dex */
class ViewOnClickListenerC2008bu implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONWriteFragment f7723a;

    ViewOnClickListenerC2008bu(PostONWriteFragment postONWriteFragment) {
        this.f7723a = postONWriteFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C3250y.m11456e("mGalleryButton Click", "PostONWriteFragment");
        if (this.f7723a.f7591Q.size() >= 1) {
            if (this.f7723a.f7632x.getVisibility() == 8) {
                this.f7723a.f7595U.setVisibility(0);
                this.f7723a.f7631w.setVisibility(8);
                this.f7723a.f7632x.setVisibility(0);
            } else if (this.f7723a.f7595U.getVisibility() == 0) {
                this.f7723a.f7632x.setVisibility(8);
            } else {
                this.f7723a.f7631w.setVisibility(8);
                this.f7723a.f7595U.setVisibility(0);
            }
        } else {
            Intent intent = new Intent("android.intent.action.PICK");
            intent.setType("image/*");
            this.f7723a.startActivityForResult(intent, 2);
        }
        this.f7723a.m7986a(this.f7723a.f7630v, false);
    }
}
