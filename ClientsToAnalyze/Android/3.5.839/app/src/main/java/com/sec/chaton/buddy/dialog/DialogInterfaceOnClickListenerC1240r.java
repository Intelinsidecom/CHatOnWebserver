package com.sec.chaton.buddy.dialog;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.widget.ProgressDialogC4926s;

/* compiled from: ChatONVInstallDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.r */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1240r implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1238p f4740a;

    DialogInterfaceOnClickListenerC1240r(HandlerC1238p handlerC1238p) {
        this.f4740a = handlerC1238p;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4740a.f4738a.f4535d = ProgressDialogC4926s.m18727a(this.f4740a.f4738a.f4533a, null, this.f4740a.f4738a.getResources().getString(R.string.buddy_list_progress_dialog_message));
        this.f4740a.f4738a.f4536e.m9499a("voip", 1, false);
    }
}
