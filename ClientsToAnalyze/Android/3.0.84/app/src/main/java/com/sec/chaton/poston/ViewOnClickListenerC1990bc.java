package com.sec.chaton.poston;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.util.C3250y;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.bc */
/* loaded from: classes.dex */
class ViewOnClickListenerC1990bc implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONWriteFragment f7705a;

    ViewOnClickListenerC1990bc(PostONWriteFragment postONWriteFragment) {
        this.f7705a = postONWriteFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C3250y.m11456e("mVideoButton Click", "PostONWriteFragment");
        if (this.f7705a.f7591Q.size() >= 1) {
            if (this.f7705a.f7632x.getVisibility() == 8) {
                this.f7705a.f7595U.setVisibility(0);
                this.f7705a.f7631w.setVisibility(8);
                this.f7705a.f7632x.setVisibility(0);
            } else if (this.f7705a.f7595U.getVisibility() == 0) {
                this.f7705a.f7632x.setVisibility(8);
            } else {
                this.f7705a.f7631w.setVisibility(8);
                this.f7705a.f7595U.setVisibility(0);
            }
        } else {
            Intent intent = new Intent("android.intent.action.PICK");
            intent.setType("video/*");
            this.f7705a.startActivityForResult(intent, 6);
        }
        this.f7705a.m7986a(this.f7705a.f7630v, false);
    }
}
