package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.msgsend.C2716x;
import com.sec.chaton.p057e.C2306z;
import java.util.ArrayList;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bw */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1159bw implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4378a;

    DialogInterfaceOnClickListenerC1159bw(BuddyFragment buddyFragment) {
        this.f4378a = buddyFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0);
        arrayList.add(3);
        C2716x.m11385b(this.f4378a.f3619Z, arrayList);
        this.f4378a.f3643aX.startDelete(1, null, C2306z.f8229a, "message_inbox_no = ? AND message_type != ? AND message_type != ?", new String[]{this.f4378a.f3619Z, Integer.toString(0), Integer.toString(3)});
    }
}
