package com.sec.chaton.settings;

import android.content.DialogInterface;
import com.sec.chaton.sns.p113a.C4368e;

/* compiled from: AccountFragment.java */
/* renamed from: com.sec.chaton.settings.w */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3685w implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC3683u f13290a;

    DialogInterfaceOnClickListenerC3685w(ViewOnClickListenerC3683u viewOnClickListenerC3683u) {
        this.f13290a = viewOnClickListenerC3683u;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f13290a.f13288a.f13282a.m13345f();
        this.f13290a.f13288a.f13282a.m13330a(C4368e.f15818d, (Integer) 203);
    }
}
