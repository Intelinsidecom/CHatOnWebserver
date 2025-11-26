package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.widget.ProgressDialogC3265l;

/* compiled from: SamsungAccountLoginDialog.java */
/* renamed from: com.sec.chaton.samsungaccount.bh */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2346bh implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2342bd f8799a;

    DialogInterfaceOnClickListenerC2346bh(HandlerC2342bd handlerC2342bd) {
        this.f8799a = handlerC2342bd;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f8799a.f8795a.f8789o != null && !this.f8799a.f8795a.f8789o.isShowing()) {
            this.f8799a.f8795a.f8789o = ProgressDialogC3265l.m11489a(this.f8799a.f8795a.f8787m, null, this.f8799a.f8795a.f8787m.getResources().getString(R.string.dialog_provision_ing));
        }
        this.f8799a.f8795a.f8785k.m5616a(this.f8799a.f8795a.f8775a.get(0), "fs24s8z0hh", "8F23805C79D7D4EBAAC5CE705A87371D");
    }
}
