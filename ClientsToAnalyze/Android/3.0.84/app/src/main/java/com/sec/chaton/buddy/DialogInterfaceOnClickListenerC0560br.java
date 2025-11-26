package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.msgsend.C1756p;
import com.sec.chaton.p027e.C1454v;
import java.util.ArrayList;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.br */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0560br implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2519a;

    DialogInterfaceOnClickListenerC0560br(BuddyFragment buddyFragment) {
        this.f2519a = buddyFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0);
        arrayList.add(3);
        C1756p.m7240b(this.f2519a.f1752P, arrayList);
        this.f2519a.f1773aK.startDelete(1, null, C1454v.f5393a, "message_inbox_no = ? AND message_type != ? AND message_type != ?", new String[]{this.f2519a.f1752P, Integer.toString(0), Integer.toString(3)});
    }
}
