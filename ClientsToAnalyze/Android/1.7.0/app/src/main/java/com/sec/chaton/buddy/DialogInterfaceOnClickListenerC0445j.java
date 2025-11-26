package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.p025d.C0662o;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.j */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0445j implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1438a;

    DialogInterfaceOnClickListenerC0445j(BuddyFragment buddyFragment) {
        this.f1438a = buddyFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1438a.f1132ao.startDelete(1, null, C0662o.f2289a, "message_inbox_no = ? AND message_type != ? AND message_type != ?", new String[]{this.f1438a.f1168z, Integer.toString(0), Integer.toString(3)});
    }
}
