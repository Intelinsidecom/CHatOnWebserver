package com.sec.vip.amschaton.fragment;

import android.content.DialogInterface;
import com.sec.chaton.util.C3250y;

/* compiled from: AMSStampSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.cf */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3512cf implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f12907a;

    /* renamed from: b */
    final /* synthetic */ int f12908b;

    /* renamed from: c */
    final /* synthetic */ AMSStampSelectionFragment f12909c;

    DialogInterfaceOnClickListenerC3512cf(AMSStampSelectionFragment aMSStampSelectionFragment, int i, int i2) {
        this.f12909c = aMSStampSelectionFragment;
        this.f12907a = i;
        this.f12908b = i2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (!this.f12909c.m12608b(this.f12907a, this.f12908b)) {
            C3250y.m11442a("Selected item was not deleted!", getClass().getSimpleName());
        }
    }
}
