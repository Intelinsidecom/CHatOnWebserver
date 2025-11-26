package com.sec.chaton.userprofile;

import android.content.DialogInterface;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.aj */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3084aj implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f11296a;

    DialogInterfaceOnClickListenerC3084aj(MyPageFragment myPageFragment) {
        this.f11296a = myPageFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 1:
                this.f11296a.m10732e("coverstory");
                break;
            case 2:
                this.f11296a.m10762t();
                break;
        }
    }
}
