package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.widget.ProgressDialogC4926s;

/* compiled from: SamsungAccountLoginDialog.java */
/* renamed from: com.sec.chaton.samsungaccount.ca */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3376ca implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3371bw f12333a;

    DialogInterfaceOnClickListenerC3376ca(HandlerC3371bw handlerC3371bw) {
        this.f12333a = handlerC3371bw;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f12333a.f12328a.f12321o != null && !this.f12333a.f12328a.f12321o.isShowing()) {
            this.f12333a.f12328a.f12321o = ProgressDialogC4926s.m18727a(this.f12333a.f12328a.f12319m, null, this.f12333a.f12328a.f12319m.getResources().getString(R.string.dialog_provision_ing));
        }
        this.f12333a.f12328a.f12317k.m9389a(this.f12333a.f12328a.f12307a.get(0), "fs24s8z0hh", "8F23805C79D7D4EBAAC5CE705A87371D");
    }
}
