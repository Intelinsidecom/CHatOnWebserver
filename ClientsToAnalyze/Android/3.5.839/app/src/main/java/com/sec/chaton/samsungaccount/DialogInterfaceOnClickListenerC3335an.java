package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.widget.ProgressDialogC4926s;

/* compiled from: FragmentSamsungAccountLogin.java */
/* renamed from: com.sec.chaton.samsungaccount.an */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3335an implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3331aj f12270a;

    DialogInterfaceOnClickListenerC3335an(HandlerC3331aj handlerC3331aj) {
        this.f12270a = handlerC3331aj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f12270a.f12266a.f12182e != null && !this.f12270a.f12266a.f12182e.isShowing()) {
            this.f12270a.f12266a.f12182e = ProgressDialogC4926s.m18727a(this.f12270a.f12266a.f12181d, null, this.f12270a.f12266a.getResources().getString(R.string.dialog_provision_ing));
        }
        this.f12270a.f12266a.f12184g.m9389a(this.f12270a.f12266a.f12178a.get(0), "fs24s8z0hh", "8F23805C79D7D4EBAAC5CE705A87371D");
    }
}
