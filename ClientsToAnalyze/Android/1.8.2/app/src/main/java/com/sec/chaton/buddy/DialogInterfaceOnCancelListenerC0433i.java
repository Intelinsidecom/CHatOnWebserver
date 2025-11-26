package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.buddy.AddBuddyActivity;

/* compiled from: AddBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.i */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC0433i implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyActivity.AddBuddyFragment f1649a;

    DialogInterfaceOnCancelListenerC0433i(AddBuddyActivity.AddBuddyFragment addBuddyFragment) {
        this.f1649a = addBuddyFragment;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        if (this.f1649a.f859P != null) {
            this.f1649a.f859P.m2710c();
        }
        this.f1649a.f863b = true;
    }
}
