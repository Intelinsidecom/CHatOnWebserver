package com.sec.chaton.widget;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

/* compiled from: StrongProgressDialog.java */
/* renamed from: com.sec.chaton.widget.a */
/* loaded from: classes.dex */
public class ProgressDialogC1354a extends ProgressDialog {
    public ProgressDialogC1354a(Context context) {
        this(context, true);
    }

    public ProgressDialogC1354a(Context context, boolean z) {
        super(context);
        setCancelable(z);
        setOnKeyListener(new DialogInterfaceOnKeyListenerC1355b(this));
    }

    /* renamed from: a */
    public static ProgressDialog m4723a(Context context, CharSequence charSequence, CharSequence charSequence2) {
        return m4724a(context, charSequence, charSequence2, false);
    }

    /* renamed from: a */
    public static ProgressDialog m4724a(Context context, CharSequence charSequence, CharSequence charSequence2, boolean z) {
        return m4726a(context, charSequence, charSequence2, z, false, null);
    }

    /* renamed from: a */
    public static ProgressDialog m4725a(Context context, CharSequence charSequence, CharSequence charSequence2, boolean z, boolean z2) {
        return m4726a(context, charSequence, charSequence2, z, z2, null);
    }

    /* renamed from: a */
    public static ProgressDialog m4726a(Context context, CharSequence charSequence, CharSequence charSequence2, boolean z, boolean z2, DialogInterface.OnCancelListener onCancelListener) {
        ProgressDialogC1354a progressDialogC1354a = new ProgressDialogC1354a(context);
        progressDialogC1354a.setTitle(charSequence);
        progressDialogC1354a.setMessage(charSequence2);
        progressDialogC1354a.setIndeterminate(z);
        progressDialogC1354a.setCancelable(z2);
        progressDialogC1354a.setOnCancelListener(onCancelListener);
        progressDialogC1354a.show();
        return progressDialogC1354a;
    }
}
