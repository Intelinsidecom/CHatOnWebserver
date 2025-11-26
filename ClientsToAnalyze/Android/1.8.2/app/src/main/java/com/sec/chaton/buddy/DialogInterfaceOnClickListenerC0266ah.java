package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.C0229at;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ah */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0266ah implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1361a;

    DialogInterfaceOnClickListenerC0266ah(BuddyFragment buddyFragment) {
        this.f1361a = buddyFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i + 11) {
            case 11:
                this.f1361a.m1911G();
                this.f1361a.f967ad = 11;
                if (this.f1361a.f968ae != this.f1361a.f967ad) {
                    this.f1361a.m1901B();
                    break;
                }
                break;
            case C0229at.HorizontalSrollView_android_background /* 12 */:
                this.f1361a.m1911G();
                this.f1361a.f967ad = 12;
                if (this.f1361a.f968ae != this.f1361a.f967ad) {
                    this.f1361a.m1901B();
                    break;
                }
                break;
        }
        if (this.f1361a.f939aA != null && this.f1361a.f939aA.isShowing()) {
            this.f1361a.f939aA.dismiss();
        }
    }
}
