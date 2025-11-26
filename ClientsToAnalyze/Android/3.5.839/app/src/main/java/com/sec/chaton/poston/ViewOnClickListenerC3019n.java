package com.sec.chaton.poston;

import android.view.View;
import com.sec.chaton.util.C4809aa;

/* compiled from: PostONCommentAdapter.java */
/* renamed from: com.sec.chaton.poston.n */
/* loaded from: classes.dex */
class ViewOnClickListenerC3019n implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C3022q f11187a;

    /* renamed from: b */
    final /* synthetic */ C3018m f11188b;

    ViewOnClickListenerC3019n(C3018m c3018m, C3022q c3022q) {
        this.f11188b = c3018m;
        this.f11187a = c3022q;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C4809aa.m18104a().m18121a("chaton_id", "").equals(((C3021p) this.f11188b.f11182b.get(this.f11187a.f11200f)).m12382a())) {
            if ((this.f11188b.f11185e == null || !this.f11188b.f11185e.equals(((C3021p) this.f11188b.f11182b.get(this.f11187a.f11200f)).m12382a())) && this.f11188b.f11186f != null) {
                this.f11188b.f11186f.mo12278a(((C3021p) this.f11188b.f11182b.get(this.f11187a.f11200f)).m12382a(), ((C3021p) this.f11188b.f11182b.get(this.f11187a.f11200f)).m12383b());
            }
        }
    }
}
