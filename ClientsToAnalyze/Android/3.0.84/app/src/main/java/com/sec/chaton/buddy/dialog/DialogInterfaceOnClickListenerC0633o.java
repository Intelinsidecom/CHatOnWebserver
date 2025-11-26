package com.sec.chaton.buddy.dialog;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.widget.ProgressDialogC3265l;

/* compiled from: ChatONVInstallDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.o */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0633o implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0631m f2853a;

    DialogInterfaceOnClickListenerC0633o(HandlerC0631m handlerC0631m) {
        this.f2853a = handlerC0631m;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2853a.f2851a.f2692d = ProgressDialogC3265l.m11489a(this.f2853a.f2851a.f2690a, null, this.f2853a.f2851a.getResources().getString(R.string.buddy_list_progress_dialog_message));
        this.f2853a.f2851a.f2693e.m5723a("voip", 1, false);
    }
}
