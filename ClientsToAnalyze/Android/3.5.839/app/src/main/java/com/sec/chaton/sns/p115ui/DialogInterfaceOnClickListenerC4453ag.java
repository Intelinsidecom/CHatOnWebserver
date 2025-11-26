package com.sec.chaton.sns.p115ui;

import android.content.DialogInterface;

/* compiled from: SnsSubMenuFragment.java */
/* renamed from: com.sec.chaton.sns.ui.ag */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4453ag implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f16095a;

    /* renamed from: b */
    final /* synthetic */ SnsSubMenuFragment f16096b;

    DialogInterfaceOnClickListenerC4453ag(SnsSubMenuFragment snsSubMenuFragment, boolean z) {
        this.f16096b = snsSubMenuFragment;
        this.f16095a = z;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f16095a) {
            this.f16096b.f16057h.finish();
        }
    }
}
