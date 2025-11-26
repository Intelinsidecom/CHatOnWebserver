package com.sec.chaton.widget;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;

/* compiled from: SMSProgressBar.java */
/* renamed from: com.sec.chaton.widget.j */
/* loaded from: classes.dex */
public class C3263j {

    /* renamed from: a */
    private Context f11784a;

    public C3263j(Context context) {
        this.f11784a = context;
    }

    /* renamed from: a */
    public Dialog m11487a(int i) {
        ProgressDialog progressDialog = (ProgressDialog) m11486a();
        progressDialog.setMessage(this.f11784a.getString(i));
        return progressDialog;
    }

    /* renamed from: a */
    private Dialog m11486a() {
        return new ProgressDialogC3265l(this.f11784a, false);
    }
}
