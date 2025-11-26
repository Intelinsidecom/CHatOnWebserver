package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.p017e.p018a.C0668l;
import com.sec.chaton.p017e.p019b.C0681h;

/* compiled from: BuddyGroupEditActivity.java */
/* renamed from: com.sec.chaton.buddy.bz */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0314bz implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupEditActivity f1433a;

    DialogInterfaceOnClickListenerC0314bz(BuddyGroupEditActivity buddyGroupEditActivity) {
        this.f1433a = buddyGroupEditActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C0668l.m3077a(new C0668l(), 4, new C0681h(this.f1433a.f1060m, this.f1433a.f1057j.m2313a()));
    }
}
