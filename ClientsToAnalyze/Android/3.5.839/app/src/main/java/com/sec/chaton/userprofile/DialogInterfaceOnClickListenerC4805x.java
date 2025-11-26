package com.sec.chaton.userprofile;

import android.content.DialogInterface;

/* compiled from: MyInfoFragment.java */
/* renamed from: com.sec.chaton.userprofile.x */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4805x implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyInfoFragment f17537a;

    DialogInterfaceOnClickListenerC4805x(MyInfoFragment myInfoFragment) {
        this.f17537a = myInfoFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                this.f17537a.m17857h();
                break;
            case 2:
                this.f17537a.m17861j();
                break;
        }
    }
}
