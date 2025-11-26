package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import com.sec.chaton.util.C4904y;

/* compiled from: MyInfoFragment.java */
/* renamed from: com.sec.chaton.userprofile.ai */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4723ai implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC4721ag f17387a;

    DialogInterfaceOnClickListenerC4723ai(HandlerC4721ag handlerC4721ag) {
        this.f17387a = handlerC4721ag;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.f17387a.f17385a.f17152H.m9539a(this.f17387a.f17385a.f17159O.f17435a, this.f17387a.f17385a.f17159O.f17436b);
            this.f17387a.f17385a.f17153I.show();
        } catch (Exception e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, getClass().getSimpleName());
            }
        }
    }
}
