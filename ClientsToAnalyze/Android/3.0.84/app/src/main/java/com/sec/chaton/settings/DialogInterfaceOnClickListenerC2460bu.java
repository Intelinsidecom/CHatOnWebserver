package com.sec.chaton.settings;

import android.content.DialogInterface;

/* compiled from: ActivityPrivacy.java */
/* renamed from: com.sec.chaton.settings.bu */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2460bu implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C2459bt f9320a;

    DialogInterfaceOnClickListenerC2460bu(C2459bt c2459bt) {
        this.f9320a = c2459bt;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                this.f9320a.f9319a.f9077o.m5747e(false);
                this.f9320a.f9319a.f9068f.show();
                break;
            case 1:
                this.f9320a.f9319a.f9077o.m5747e(true);
                this.f9320a.f9319a.f9068f.show();
                break;
        }
        this.f9320a.f9319a.f9087y.dismiss();
    }
}
