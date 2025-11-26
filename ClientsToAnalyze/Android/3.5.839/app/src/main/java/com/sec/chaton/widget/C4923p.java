package com.sec.chaton.widget;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;

/* compiled from: SMSProgressBar.java */
/* renamed from: com.sec.chaton.widget.p */
/* loaded from: classes.dex */
public class C4923p {

    /* renamed from: a */
    private Context f17981a;

    /* renamed from: a */
    public static C4923p m18723a(Context context) {
        return new C4923p(context);
    }

    public C4923p(Context context) {
        this.f17981a = context;
    }

    /* renamed from: a */
    public Dialog m18724a(int i) {
        ProgressDialog progressDialog = (ProgressDialog) m18722a();
        progressDialog.setMessage(this.f17981a.getString(i));
        return progressDialog;
    }

    /* renamed from: a */
    private Dialog m18722a() {
        return new ProgressDialogC4926s(this.f17981a, false);
    }
}
