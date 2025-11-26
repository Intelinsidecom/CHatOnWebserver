package com.sec.chaton.buddy.dialog;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.widget.ProgressDialogC4926s;

/* compiled from: ChatONVInstallDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.u */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1243u implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1238p f4743a;

    DialogInterfaceOnClickListenerC1243u(HandlerC1238p handlerC1238p) {
        this.f4743a = handlerC1238p;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws Throwable {
        this.f4743a.f4738a.f4535d = ProgressDialogC4926s.m18727a(this.f4743a.f4738a.f4533a, null, this.f4743a.f4738a.getResources().getString(R.string.buddy_list_progress_dialog_message));
        this.f4743a.f4738a.f4540i.m9312c(null);
    }
}
