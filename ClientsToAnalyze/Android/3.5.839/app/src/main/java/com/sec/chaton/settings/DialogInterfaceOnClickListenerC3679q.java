package com.sec.chaton.settings;

import android.content.DialogInterface;
import com.sec.chaton.p055d.EnumC2111bq;

/* compiled from: AccountFragment.java */
/* renamed from: com.sec.chaton.settings.q */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3679q implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AccountFragment f13279a;

    DialogInterfaceOnClickListenerC3679q(AccountFragment accountFragment) {
        this.f13279a = accountFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f13279a.m13345f();
        EnumC2111bq.m9446a(EnumC2111bq.STARTING);
        this.f13279a.f12490q.m9432g();
    }
}
