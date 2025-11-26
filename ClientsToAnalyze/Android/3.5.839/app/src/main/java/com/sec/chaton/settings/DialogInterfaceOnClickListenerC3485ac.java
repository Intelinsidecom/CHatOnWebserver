package com.sec.chaton.settings;

import android.content.DialogInterface;
import com.sec.chaton.sns.p113a.C4368e;

/* compiled from: AccountFragment.java */
/* renamed from: com.sec.chaton.settings.ac */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3485ac implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC3483aa f12973a;

    DialogInterfaceOnClickListenerC3485ac(ViewOnClickListenerC3483aa viewOnClickListenerC3483aa) {
        this.f12973a = viewOnClickListenerC3483aa;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f12973a.f12971a.f13282a.m13345f();
        this.f12973a.f12971a.f13282a.m13330a(C4368e.f15815a, (Integer) 201);
    }
}
