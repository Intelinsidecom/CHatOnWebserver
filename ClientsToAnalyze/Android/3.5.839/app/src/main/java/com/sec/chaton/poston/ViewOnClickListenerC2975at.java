package com.sec.chaton.poston;

import android.view.View;
import com.sec.chaton.util.C4809aa;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.at */
/* loaded from: classes.dex */
class ViewOnClickListenerC2975at implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONDetailFragment f11072a;

    ViewOnClickListenerC2975at(PostONDetailFragment postONDetailFragment) {
        this.f11072a = postONDetailFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f11072a.f10900O == null || (!this.f11072a.f10890E.equals(this.f11072a.f10900O) && !this.f11072a.f10900O.equals(C4809aa.m18104a().m18121a("chaton_id", "")))) {
            this.f11072a.mo12278a(this.f11072a.f10900O, this.f11072a.f10891F);
        }
    }
}
