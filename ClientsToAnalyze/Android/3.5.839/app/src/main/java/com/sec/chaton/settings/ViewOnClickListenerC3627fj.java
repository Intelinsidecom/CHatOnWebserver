package com.sec.chaton.settings;

import android.view.View;
import com.sec.chaton.p057e.p058a.C2190d;
import com.sec.common.CommonApplication;

/* compiled from: PostONHideAdapter.java */
/* renamed from: com.sec.chaton.settings.fj */
/* loaded from: classes.dex */
class ViewOnClickListenerC3627fj implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f13179a;

    /* renamed from: b */
    final /* synthetic */ C3626fi f13180b;

    ViewOnClickListenerC3627fj(C3626fi c3626fi, int i) {
        this.f13180b = c3626fi;
        this.f13179a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f13180b.f13177e = this.f13180b.f13173a.get(this.f13179a);
        this.f13180b.f13176d = C2190d.m9827c(CommonApplication.m18732r().getContentResolver(), this.f13180b.f13173a.get(this.f13179a));
        if (this.f13180b.f13174b != null) {
            this.f13180b.f13174b.mo13655a(this.f13180b.f13176d, this.f13180b.f13177e);
        }
    }
}
