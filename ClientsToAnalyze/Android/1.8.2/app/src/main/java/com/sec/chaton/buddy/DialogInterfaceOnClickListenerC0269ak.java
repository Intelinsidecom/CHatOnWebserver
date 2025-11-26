package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.C0229at;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ak */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0269ak implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0268aj f1364a;

    DialogInterfaceOnClickListenerC0269ak(C0268aj c0268aj) {
        this.f1364a = c0268aj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i + 11) {
            case 11:
                this.f1364a.f1363a.m1911G();
                this.f1364a.f1363a.f967ad = 11;
                if (this.f1364a.f1363a.f968ae != this.f1364a.f1363a.f967ad) {
                    this.f1364a.f1363a.m1901B();
                    break;
                }
                break;
            case C0229at.HorizontalSrollView_android_background /* 12 */:
                this.f1364a.f1363a.m1911G();
                this.f1364a.f1363a.f967ad = 12;
                if (this.f1364a.f1363a.f968ae != this.f1364a.f1363a.f967ad) {
                    this.f1364a.f1363a.m1901B();
                    break;
                }
                break;
        }
        if (this.f1364a.f1363a.f939aA != null && this.f1364a.f1363a.f939aA.isShowing()) {
            this.f1364a.f1363a.f939aA.dismiss();
        }
    }
}
