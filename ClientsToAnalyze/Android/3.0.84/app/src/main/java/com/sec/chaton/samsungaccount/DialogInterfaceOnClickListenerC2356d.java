package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.widget.ProgressDialogC3265l;

/* compiled from: FragmentSamsungAccountLogin.java */
/* renamed from: com.sec.chaton.samsungaccount.d */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2356d implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2338b f8811a;

    DialogInterfaceOnClickListenerC2356d(HandlerC2338b handlerC2338b) {
        this.f8811a = handlerC2338b;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8811a.f8774a.f8638e = ProgressDialogC3265l.m11489a(this.f8811a.f8774a.f8637d, null, this.f8811a.f8774a.getResources().getString(R.string.dialog_provision_ing));
        this.f8811a.f8774a.f8640g.m5619b(this.f8811a.f8774a.f8641h, "fs24s8z0hh", this.f8811a.f8774a.f8642i);
    }
}
