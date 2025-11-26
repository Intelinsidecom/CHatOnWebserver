package com.sec.chaton.poston;

import android.view.View;
import com.sec.chaton.util.C3250y;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.be */
/* loaded from: classes.dex */
class ViewOnClickListenerC1992be implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONWriteFragment f7707a;

    ViewOnClickListenerC1992be(PostONWriteFragment postONWriteFragment) {
        this.f7707a = postONWriteFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C3250y.m11456e("mLocationDelete Click", "PostONWriteFragment");
        this.f7707a.f7575A = "";
        this.f7707a.f7576B = null;
        this.f7707a.f7628t.setSelected(false);
        if (this.f7707a.f7632x.getVisibility() == 0) {
            this.f7707a.f7632x.setVisibility(8);
        }
        if (this.f7707a.f7630v.getText().length() > 0 || this.f7707a.f7591Q.size() >= 1) {
            this.f7707a.f7598Z = true;
            this.f7707a.f7584J.setEnabled(true);
        } else {
            this.f7707a.f7598Z = false;
            this.f7707a.f7584J.setEnabled(false);
        }
    }
}
