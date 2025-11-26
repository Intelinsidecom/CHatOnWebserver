package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.widget.ProgressDialogC4926s;

/* compiled from: SamsungAccountLoginDialog.java */
/* renamed from: com.sec.chaton.samsungaccount.by */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3373by implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3371bw f12330a;

    DialogInterfaceOnClickListenerC3373by(HandlerC3371bw handlerC3371bw) {
        this.f12330a = handlerC3371bw;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f12330a.f12328a.f12321o = ProgressDialogC4926s.m18727a(this.f12330a.f12328a.f12319m, null, this.f12330a.f12328a.f12319m.getResources().getString(R.string.dialog_provision_ing));
        this.f12330a.f12328a.f12317k.m9392b(this.f12330a.f12328a.f12314h, "fs24s8z0hh", this.f12330a.f12328a.f12315i);
    }
}
