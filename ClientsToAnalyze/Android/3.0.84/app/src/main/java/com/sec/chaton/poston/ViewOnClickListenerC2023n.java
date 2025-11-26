package com.sec.chaton.poston;

import android.view.View;
import com.sec.chaton.util.C3159aa;

/* compiled from: PostONCommentAdapter.java */
/* renamed from: com.sec.chaton.poston.n */
/* loaded from: classes.dex */
class ViewOnClickListenerC2023n implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f7790a;

    /* renamed from: b */
    final /* synthetic */ C2022m f7791b;

    ViewOnClickListenerC2023n(C2022m c2022m, int i) {
        this.f7791b = c2022m;
        this.f7790a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!((C2025p) this.f7791b.f7785b.get(this.f7790a)).m8062a().equals(C3159aa.m10962a().m10979a("chaton_id", ""))) {
            if ((this.f7791b.f7788e == null || !((C2025p) this.f7791b.f7785b.get(this.f7790a)).m8062a().equals(this.f7791b.f7788e)) && this.f7791b.f7789f != null) {
                this.f7791b.f7789f.mo7970a(((C2025p) this.f7791b.f7785b.get(this.f7790a)).m8062a(), ((C2025p) this.f7791b.f7785b.get(this.f7790a)).m8063b());
            }
        }
    }
}
