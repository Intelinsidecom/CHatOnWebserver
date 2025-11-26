package com.sec.chaton.chat;

import android.view.View;
import com.sec.chaton.util.C4904y;

/* compiled from: DuringCallController.java */
/* renamed from: com.sec.chaton.chat.gs */
/* loaded from: classes.dex */
class ViewOnClickListenerC1746gs implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1743gp f6563a;

    ViewOnClickListenerC1746gs(C1743gp c1743gp) {
        this.f6563a = c1743gp;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C4904y.m18639b("end call", C1743gp.f6550a);
        if (this.f6563a.f6558i != null && !this.f6563a.f6558i.m1499h(this.f6563a.f6551b)) {
            C4904y.m18634a("[ChatONV] failed to end call", C1743gp.f6550a);
        }
    }
}
