package com.sec.chaton.settings;

import android.content.DialogInterface;

/* renamed from: com.sec.chaton.settings.k */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0500k implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC0465an f3192a;

    DialogInterfaceOnClickListenerC0500k(ViewOnClickListenerC0465an viewOnClickListenerC0465an) {
        this.f3192a = viewOnClickListenerC0465an;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3192a.f3157a.f2990e.m2074a();
        this.f3192a.f3157a.f2992g.show();
    }
}
