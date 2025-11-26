package com.sec.chaton.poston;

import android.view.View;
import com.sec.chaton.util.C4904y;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.bf */
/* loaded from: classes.dex */
class ViewOnClickListenerC2988bf implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONWriteFragment f11103a;

    ViewOnClickListenerC2988bf(PostONWriteFragment postONWriteFragment) {
        this.f11103a = postONWriteFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C4904y.m18646e("mLocationDelete Click", "PostONWriteFragment");
        this.f11103a.f10970B = "";
        this.f11103a.f10971C = null;
        this.f11103a.f11025t.setSelected(false);
        if (this.f11103a.f11030y.getVisibility() == 0) {
            this.f11103a.f11030y.setVisibility(8);
        }
        if (this.f11103a.f11028w.getText().length() > 0 || this.f11103a.f10987S.size() >= 1) {
            this.f11103a.f10995ab = true;
            this.f11103a.f10980L.setEnabled(true);
        } else {
            this.f11103a.f10995ab = false;
            this.f11103a.f10980L.setEnabled(false);
        }
    }
}
