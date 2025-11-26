package com.sec.chaton.widget;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;

/* compiled from: SMSProgressBar.java */
/* renamed from: com.sec.chaton.widget.c */
/* loaded from: classes.dex */
public class C1356c {

    /* renamed from: a */
    private Context f4615a;

    public C1356c(Context context) {
        this.f4615a = context;
    }

    /* renamed from: a */
    public Dialog m4728a(int i) {
        ProgressDialog progressDialog = (ProgressDialog) m4727a();
        progressDialog.setMessage(this.f4615a.getString(i));
        return progressDialog;
    }

    /* renamed from: a */
    private Dialog m4727a() {
        return new ProgressDialogC1354a(this.f4615a, false);
    }
}
