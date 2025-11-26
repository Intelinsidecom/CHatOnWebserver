package com.sec.chaton.userprofile;

import android.content.DialogInterface;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.au */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4735au implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f17399a;

    DialogInterfaceOnClickListenerC4735au(MyPageFragment myPageFragment) {
        this.f17399a = myPageFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                this.f17399a.m17894b("coverstory");
                break;
            case 1:
                this.f17399a.m17898c("coverstory");
                break;
            case 2:
                this.f17399a.m17916l();
                break;
        }
    }
}
