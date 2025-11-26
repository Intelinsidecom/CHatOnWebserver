package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.p017e.p018a.C0668l;
import com.sec.chaton.p017e.p019b.C0681h;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ay */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0283ay implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f1379a;

    /* renamed from: b */
    final /* synthetic */ BuddyFragment f1380b;

    DialogInterfaceOnClickListenerC0283ay(BuddyFragment buddyFragment, String str) {
        this.f1380b = buddyFragment;
        this.f1379a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C0668l.m3077a(new C0668l(), 4, new C0681h(this.f1380b.f1005g, Integer.parseInt(this.f1379a)));
        this.f1380b.f1010l.show();
    }
}
