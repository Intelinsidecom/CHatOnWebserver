package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import com.sec.chaton.util.C4904y;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.be */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4746be implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC4740az f17410a;

    DialogInterfaceOnClickListenerC4746be(HandlerC4740az handlerC4740az) {
        this.f17410a = handlerC4740az;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.f17410a.f17404a.f17251at.m9539a(this.f17410a.f17404a.f17250as.f17435a, this.f17410a.f17404a.f17250as.f17436b);
            this.f17410a.f17404a.f17278y.show();
        } catch (Exception e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, getClass().getSimpleName());
            }
        }
    }
}
