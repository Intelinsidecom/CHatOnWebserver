package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.widget.ProgressDialogC1354a;

/* compiled from: ActivityRegist.java */
/* renamed from: com.sec.chaton.registration.h */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0976h implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0992x f3373a;

    DialogInterfaceOnClickListenerC0976h(HandlerC0992x handlerC0992x) {
        this.f3373a = handlerC0992x;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f3373a.f3388a.f3231z != null) {
            this.f3373a.f3388a.f3230y = ProgressDialogC1354a.m4724a(this.f3373a.f3388a.f3231z, null, this.f3373a.f3388a.getResources().getString(R.string.buddy_list_progress_dialog_message), true);
        }
        this.f3373a.f3388a.m3695c();
    }
}
