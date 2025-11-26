package com.sec.chaton.poston;

import android.view.View;
import com.sec.chaton.util.C4904y;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.bu */
/* loaded from: classes.dex */
class ViewOnClickListenerC3003bu implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONWriteFragment f11118a;

    ViewOnClickListenerC3003bu(PostONWriteFragment postONWriteFragment) {
        this.f11118a = postONWriteFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C4904y.m18646e("mCameraButton Click", "PostONWriteFragment");
        this.f11118a.m12322f();
    }
}
