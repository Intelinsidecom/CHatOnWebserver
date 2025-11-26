package com.sec.chaton.poston;

import android.view.View;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4904y;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.aq */
/* loaded from: classes.dex */
class ViewOnClickListenerC2972aq implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONDetailFragment f11069a;

    ViewOnClickListenerC2972aq(PostONDetailFragment postONDetailFragment) {
        this.f11069a = postONDetailFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f11069a.f10923ae.getText().toString() != null) {
            C4904y.m18646e("PostONCommentItem: " + this.f11069a.f10923ae.getText().toString(), getClass().getSimpleName());
            if (!C4847bl.m18333a()) {
                this.f11069a.f10906U.m9289a(this.f11069a.f10890E, new C3021p(this.f11069a.f10900O, this.f11069a.f10891F, this.f11069a.f10923ae.getText().toString(), this.f11069a.f10892G, "-1", null), this.f11069a.f10896K);
                this.f11069a.f10924af.hideSoftInputFromWindow(this.f11069a.f10923ae.getWindowToken(), 0);
                this.f11069a.f10910Y.show();
            }
        }
    }
}
