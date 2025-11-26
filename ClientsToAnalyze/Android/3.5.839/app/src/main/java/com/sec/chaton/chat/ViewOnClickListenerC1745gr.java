package com.sec.chaton.chat;

import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;

/* compiled from: DuringCallController.java */
/* renamed from: com.sec.chaton.chat.gr */
/* loaded from: classes.dex */
class ViewOnClickListenerC1745gr implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1743gp f6562a;

    ViewOnClickListenerC1745gr(C1743gp c1743gp) {
        this.f6562a = c1743gp;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C4904y.m18639b("switch to V call", C1743gp.f6550a);
        if (!C4822an.m18245m()) {
            C5179v.m19810a(this.f6562a.f6551b, R.string.chatonv_unable_to_make_call, 0).show();
            C4904y.m18639b("can not switch to V call due to phone online", C1743gp.f6550a);
        } else if (this.f6562a.f6558i != null) {
            this.f6562a.f6558i.m1498g(this.f6562a.f6551b);
        }
    }
}
