package com.sec.chaton.userprofile;

import android.content.DialogInterface;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.aw */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4737aw implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f17401a;

    DialogInterfaceOnClickListenerC4737aw(MyPageFragment myPageFragment) {
        this.f17401a = myPageFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                this.f17401a.m17894b("coverstory");
                break;
            case 2:
                this.f17401a.m17916l();
                break;
        }
    }
}
