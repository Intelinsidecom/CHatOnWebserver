package com.sec.chaton.buddy.dialog;

import android.content.DialogInterface;
import android.widget.Toast;
import com.sec.chaton.R;

/* compiled from: SpamConfirmDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.y */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0643y implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SpamConfirmDialog f2863a;

    DialogInterfaceOnClickListenerC0643y(SpamConfirmDialog spamConfirmDialog) {
        this.f2863a = spamConfirmDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2863a.m4278a();
        Toast.makeText(this.f2863a.getApplicationContext(), R.string.spammer_report_toast, 1).show();
        this.f2863a.finish();
    }
}
