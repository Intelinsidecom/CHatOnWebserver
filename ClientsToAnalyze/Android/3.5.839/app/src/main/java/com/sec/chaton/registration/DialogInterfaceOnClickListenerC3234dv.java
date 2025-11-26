package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.widget.ProgressDialogC4926s;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.dv */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3234dv implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3233du f12000a;

    DialogInterfaceOnClickListenerC3234dv(HandlerC3233du handlerC3233du) {
        this.f12000a = handlerC3233du;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f12000a.f11999a.f11731T != null) {
            this.f12000a.f11999a.f11729R = ProgressDialogC4926s.m18728a(this.f12000a.f11999a.f11731T, null, this.f12000a.f11999a.getResources().getString(R.string.buddy_list_progress_dialog_message), true);
        }
        this.f12000a.f11999a.m12927d();
    }
}
