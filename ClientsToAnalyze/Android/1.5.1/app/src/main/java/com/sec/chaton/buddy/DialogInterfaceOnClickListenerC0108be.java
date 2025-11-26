package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* renamed from: com.sec.chaton.buddy.be */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0108be implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f651a;

    DialogInterfaceOnClickListenerC0108be(BuddyFragment buddyFragment) {
        this.f651a = buddyFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i + 11) {
            case 11:
                this.f651a.m503k();
                this.f651a.f417H = 11;
                if (this.f651a.f418I != this.f651a.f417H) {
                    this.f651a.m498i();
                    break;
                }
                break;
            case 12:
                this.f651a.m503k();
                this.f651a.f417H = 12;
                if (this.f651a.f418I != this.f651a.f417H) {
                    this.f651a.m498i();
                    break;
                }
                break;
        }
        this.f651a.f436aa.dismiss();
    }
}
