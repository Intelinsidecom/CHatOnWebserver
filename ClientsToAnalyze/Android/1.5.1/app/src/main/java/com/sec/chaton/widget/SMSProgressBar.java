package com.sec.chaton.widget;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;

/* loaded from: classes.dex */
public class SMSProgressBar {

    /* renamed from: a */
    private Context f3802a;

    public SMSProgressBar(Context context) {
        this.f3802a = context;
    }

    private Dialog setDialogAttribute() {
        ProgressDialog progressDialog = new ProgressDialog(this.f3802a);
        progressDialog.setCancelable(false);
        progressDialog.setOnKeyListener(new DialogInterfaceOnKeyListenerC0620a(this));
        return progressDialog;
    }

    public Dialog onCreate(int i) {
        ProgressDialog progressDialog = (ProgressDialog) setDialogAttribute();
        progressDialog.setMessage(this.f3802a.getString(i));
        return progressDialog;
    }

    public Dialog onCreate(String str) {
        ProgressDialog progressDialog = (ProgressDialog) setDialogAttribute();
        progressDialog.setMessage(str);
        return progressDialog;
    }
}
