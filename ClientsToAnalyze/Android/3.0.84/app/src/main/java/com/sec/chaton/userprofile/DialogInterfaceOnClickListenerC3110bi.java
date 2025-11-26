package com.sec.chaton.userprofile;

import android.content.DialogInterface;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.bi */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3110bi implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f11323a;

    DialogInterfaceOnClickListenerC3110bi(MyPageFragment myPageFragment) {
        this.f11323a = myPageFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                this.f11323a.m10734f("coverstory");
                break;
            case 1:
                this.f11323a.m10732e("coverstory");
                break;
            case 2:
                this.f11323a.m10762t();
                break;
        }
    }
}
