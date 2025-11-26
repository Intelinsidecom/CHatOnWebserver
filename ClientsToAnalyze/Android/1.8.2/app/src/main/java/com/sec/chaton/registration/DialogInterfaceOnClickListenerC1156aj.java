package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.widget.ProgressDialogC1806j;

/* compiled from: ActivityRegist.java */
/* renamed from: com.sec.chaton.registration.aj */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1156aj implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1155ai f4358a;

    DialogInterfaceOnClickListenerC1156aj(HandlerC1155ai handlerC1155ai) {
        this.f4358a = handlerC1155ai;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4358a.f4357a.f4256z = ProgressDialogC1806j.m6141a(this.f4358a.f4357a.f4215A, null, this.f4358a.f4357a.getResources().getString(R.string.buddy_list_progress_dialog_message), true);
        this.f4358a.f4357a.m4379c();
    }
}
