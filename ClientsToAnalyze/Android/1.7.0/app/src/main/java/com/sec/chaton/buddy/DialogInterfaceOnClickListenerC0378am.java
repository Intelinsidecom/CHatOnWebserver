package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.p025d.p026a.C0627g;
import com.sec.chaton.p025d.p027b.C0646i;

/* compiled from: BuddyGroupProfileActivity.java */
/* renamed from: com.sec.chaton.buddy.am */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0378am implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupProfileActivity f1346a;

    DialogInterfaceOnClickListenerC0378am(BuddyGroupProfileActivity buddyGroupProfileActivity) {
        this.f1346a = buddyGroupProfileActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C0627g.m2858a(new C0627g(), 1, new C0646i(this.f1346a.f1177b, this.f1346a.f1181f.m2347a()));
    }
}
