package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bu */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1157bu implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4376a;

    DialogInterfaceOnClickListenerC1157bu(BuddyFragment buddyFragment) {
        this.f4376a = buddyFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i + 11) {
            case 11:
                this.f4376a.f3658am = 11;
                this.f4376a.m6289D();
                if (this.f4376a.f3659an != this.f4376a.f3658am) {
                    this.f4376a.m6574x();
                    break;
                }
                break;
            case 12:
            case 13:
                this.f4376a.f3658am = 13;
                this.f4376a.m6289D();
                if (this.f4376a.f3659an != this.f4376a.f3658am) {
                    this.f4376a.m6574x();
                    break;
                }
                break;
        }
        this.f4376a.f3626aG.dismiss();
    }
}
