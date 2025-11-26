package com.sec.chaton.widget;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

/* compiled from: StrongProgressDialog.java */
/* renamed from: com.sec.chaton.widget.s */
/* loaded from: classes.dex */
public class ProgressDialogC4926s extends ProgressDialog {
    /* renamed from: a */
    public static ProgressDialogC4926s m18730a(Context context) {
        return new ProgressDialogC4926s(context);
    }

    /* renamed from: a */
    public static ProgressDialogC4926s m18731a(Context context, boolean z) {
        return new ProgressDialogC4926s(context, z);
    }

    public ProgressDialogC4926s(Context context) {
        this(context, true);
    }

    public ProgressDialogC4926s(Context context, boolean z) {
        super(context);
        setCancelable(z);
        setOnKeyListener(new DialogInterfaceOnKeyListenerC4927t(this));
    }

    /* renamed from: a */
    public static ProgressDialog m18727a(Context context, CharSequence charSequence, CharSequence charSequence2) {
        return m18728a(context, charSequence, charSequence2, false);
    }

    /* renamed from: a */
    public static ProgressDialog m18728a(Context context, CharSequence charSequence, CharSequence charSequence2, boolean z) {
        return m18729a(context, charSequence, charSequence2, z, false, null);
    }

    /* renamed from: a */
    public static ProgressDialog m18729a(Context context, CharSequence charSequence, CharSequence charSequence2, boolean z, boolean z2, DialogInterface.OnCancelListener onCancelListener) {
        ProgressDialogC4926s progressDialogC4926s = new ProgressDialogC4926s(context);
        progressDialogC4926s.setTitle(charSequence);
        progressDialogC4926s.setMessage(charSequence2);
        progressDialogC4926s.setIndeterminate(z);
        progressDialogC4926s.setCancelable(z2);
        progressDialogC4926s.setOnCancelListener(onCancelListener);
        progressDialogC4926s.show();
        return progressDialogC4926s;
    }
}
