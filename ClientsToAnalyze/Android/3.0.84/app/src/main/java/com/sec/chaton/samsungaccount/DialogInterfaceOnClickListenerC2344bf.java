package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.widget.ProgressDialogC3265l;

/* compiled from: SamsungAccountLoginDialog.java */
/* renamed from: com.sec.chaton.samsungaccount.bf */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2344bf implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2342bd f8797a;

    DialogInterfaceOnClickListenerC2344bf(HandlerC2342bd handlerC2342bd) {
        this.f8797a = handlerC2342bd;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8797a.f8795a.f8789o = ProgressDialogC3265l.m11489a(this.f8797a.f8795a.f8787m, null, this.f8797a.f8795a.f8787m.getResources().getString(R.string.dialog_provision_ing));
        this.f8797a.f8795a.f8785k.m5619b(this.f8797a.f8795a.f8782h, "fs24s8z0hh", this.f8797a.f8795a.f8783i);
    }
}
