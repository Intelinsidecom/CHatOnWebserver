package com.sec.chaton.userprofile;

import android.content.DialogInterface;

/* compiled from: UserProfileDetail.java */
/* renamed from: com.sec.chaton.userprofile.ca */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1678ca implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1676bz f6175a;

    DialogInterfaceOnClickListenerC1678ca(HandlerC1676bz handlerC1676bz) {
        this.f6175a = handlerC1676bz;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f6175a.f6173a.f6022E.isShowing()) {
            this.f6175a.f6173a.f6071r = false;
            this.f6175a.f6173a.f6022E.dismiss();
        }
    }
}
