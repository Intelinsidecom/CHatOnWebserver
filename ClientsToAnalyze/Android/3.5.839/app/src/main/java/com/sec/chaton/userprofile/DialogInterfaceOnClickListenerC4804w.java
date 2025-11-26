package com.sec.chaton.userprofile;

import android.content.DialogInterface;

/* compiled from: MyInfoFragment.java */
/* renamed from: com.sec.chaton.userprofile.w */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4804w implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyInfoFragment f17536a;

    DialogInterfaceOnClickListenerC4804w(MyInfoFragment myInfoFragment) {
        this.f17536a = myInfoFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                this.f17536a.m17857h();
                break;
            case 1:
                this.f17536a.m17859i();
                break;
            case 2:
                this.f17536a.m17861j();
                break;
        }
    }
}
