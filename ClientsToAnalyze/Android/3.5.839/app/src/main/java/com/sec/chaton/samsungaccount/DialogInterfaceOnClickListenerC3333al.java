package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.widget.ProgressDialogC4926s;

/* compiled from: FragmentSamsungAccountLogin.java */
/* renamed from: com.sec.chaton.samsungaccount.al */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3333al implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3331aj f12268a;

    DialogInterfaceOnClickListenerC3333al(HandlerC3331aj handlerC3331aj) {
        this.f12268a = handlerC3331aj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f12268a.f12266a.f12182e = ProgressDialogC4926s.m18727a(this.f12268a.f12266a.f12181d, null, this.f12268a.f12266a.getResources().getString(R.string.dialog_provision_ing));
        this.f12268a.f12266a.f12184g.m9392b(this.f12268a.f12266a.f12185h, "fs24s8z0hh", this.f12268a.f12266a.f12186i);
    }
}
