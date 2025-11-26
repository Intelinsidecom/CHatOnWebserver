package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.hardware.motion.MREvent;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.b */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0392b implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1362a;

    DialogInterfaceOnClickListenerC0392b(BuddyFragment buddyFragment) {
        this.f1362a = buddyFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i + 11) {
            case 11:
                this.f1362a.m2174r();
                this.f1362a.f1101K = 11;
                if (this.f1362a.f1102L != this.f1362a.f1101K) {
                    this.f1362a.m2169o();
                    break;
                }
                break;
            case MREvent.TILT_PORTRAIT_BACK /* 12 */:
                this.f1362a.m2174r();
                this.f1362a.f1101K = 12;
                if (this.f1362a.f1102L != this.f1362a.f1101K) {
                    this.f1362a.m2169o();
                    break;
                }
                break;
        }
        this.f1362a.f1119ab.dismiss();
    }
}
