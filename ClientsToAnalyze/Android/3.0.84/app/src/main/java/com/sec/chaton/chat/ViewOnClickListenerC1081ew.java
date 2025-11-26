package com.sec.chaton.chat;

import android.view.View;
import com.sec.chaton.util.C3250y;

/* compiled from: DuringCallController.java */
/* renamed from: com.sec.chaton.chat.ew */
/* loaded from: classes.dex */
class ViewOnClickListenerC1081ew implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1078et f4332a;

    ViewOnClickListenerC1081ew(C1078et c1078et) {
        this.f4332a = c1078et;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C3250y.m11450b("end call", C1078et.f4319a);
        if (this.f4332a.f4327i != null && !this.f4332a.f4327i.m59h(this.f4332a.f4320b)) {
            C3250y.m11442a("[ChatONV] failed to end call", C1078et.f4319a);
        }
    }
}
