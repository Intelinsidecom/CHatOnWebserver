package com.sec.chaton.poston;

import android.view.View;
import com.sec.chaton.util.C3159aa;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.w */
/* loaded from: classes.dex */
class ViewOnClickListenerC2032w implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONDetailFragment f7821a;

    ViewOnClickListenerC2032w(PostONDetailFragment postONDetailFragment) {
        this.f7821a = postONDetailFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.f7821a.f7516N.equals(C3159aa.m10962a().m10979a("chaton_id", ""))) {
            if (this.f7821a.f7516N == null || !this.f7821a.f7505C.equals(this.f7821a.f7516N)) {
                this.f7821a.mo7970a(this.f7821a.f7516N, this.f7821a.f7507E);
            }
        }
    }
}
