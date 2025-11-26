package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.buddy.AddBuddyActivity;

/* compiled from: AddBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.h */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0417h implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyActivity.AddBuddyFragment f1578a;

    DialogInterfaceOnClickListenerC0417h(AddBuddyActivity.AddBuddyFragment addBuddyFragment) {
        this.f1578a = addBuddyFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
