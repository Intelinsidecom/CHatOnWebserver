package com.sec.chaton.p009b;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import com.sec.widget.AlertDialogBuilderC2120a;

/* compiled from: ProgressDialog.java */
/* renamed from: com.sec.chaton.b.b */
/* loaded from: classes.dex */
public class ProgressDialogC0238b extends ProgressDialog implements DialogInterface.OnShowListener {
    @Override // android.app.AlertDialog, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(AlertDialogBuilderC2120a.m7478a(charSequence));
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        setTitle(getContext().getResources().getString(i));
    }

    @Override // android.app.ProgressDialog, android.app.AlertDialog
    public void setMessage(CharSequence charSequence) {
        super.setMessage(AlertDialogBuilderC2120a.m7478a(charSequence));
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        setOnShowListener(null);
        AlertDialogBuilderC2120a.m7479a(this);
    }
}
