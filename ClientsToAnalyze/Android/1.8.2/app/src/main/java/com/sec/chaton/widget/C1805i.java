package com.sec.chaton.widget;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;

/* compiled from: SMSProgressBar.java */
/* renamed from: com.sec.chaton.widget.i */
/* loaded from: classes.dex */
public class C1805i {

    /* renamed from: a */
    private Context f6497a;

    public C1805i(Context context) {
        this.f6497a = context;
    }

    /* renamed from: a */
    public Dialog m6139a(int i) {
        ProgressDialog progressDialog = (ProgressDialog) m6138a();
        progressDialog.setMessage(this.f6497a.getString(i));
        return progressDialog;
    }

    /* renamed from: a */
    private Dialog m6138a() {
        return new ProgressDialogC1806j(this.f6497a, false);
    }
}
