package com.sec.chaton.registration;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.registration.f */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0430f implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0421as f2943a;

    DialogInterfaceOnClickListenerC0430f(HandlerC0421as handlerC0421as) {
        this.f2943a = handlerC0421as;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2943a.f2932a.f2874s = ProgressDialog.show(this.f2943a.f2932a.f2875t, null, this.f2943a.f2932a.getResources().getString(C0062R.string.buddy_list_progress_dialog_message), true);
        this.f2943a.f2932a.m3077a();
    }
}
