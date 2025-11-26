package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.widget.ProgressDialogC3265l;

/* compiled from: FragmentSamsungAccountLogin.java */
/* renamed from: com.sec.chaton.samsungaccount.f */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2358f implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2338b f8813a;

    DialogInterfaceOnClickListenerC2358f(HandlerC2338b handlerC2338b) {
        this.f8813a = handlerC2338b;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f8813a.f8774a.f8638e != null && !this.f8813a.f8774a.f8638e.isShowing()) {
            this.f8813a.f8774a.f8638e = ProgressDialogC3265l.m11489a(this.f8813a.f8774a.f8637d, null, this.f8813a.f8774a.getResources().getString(R.string.dialog_provision_ing));
        }
        if (TextUtils.isEmpty(this.f8813a.f8774a.f8646m)) {
            this.f8813a.f8774a.f8640g.m5616a(this.f8813a.f8774a.f8634a.get(0), "fs24s8z0hh", "8F23805C79D7D4EBAAC5CE705A87371D");
        } else {
            this.f8813a.f8774a.f8640g.m5616a(this.f8813a.f8774a.f8646m, "fs24s8z0hh", "8F23805C79D7D4EBAAC5CE705A87371D");
        }
    }
}
