package com.sec.chaton.widget;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

/* compiled from: StrongProgressDialog.java */
/* renamed from: com.sec.chaton.widget.l */
/* loaded from: classes.dex */
public class ProgressDialogC3265l extends ProgressDialog {
    public ProgressDialogC3265l(Context context) {
        this(context, true);
    }

    public ProgressDialogC3265l(Context context, boolean z) {
        super(context);
        setCancelable(z);
        setOnKeyListener(new DialogInterfaceOnKeyListenerC3266m(this));
    }

    /* renamed from: a */
    public static ProgressDialog m11489a(Context context, CharSequence charSequence, CharSequence charSequence2) {
        return m11490a(context, charSequence, charSequence2, false);
    }

    /* renamed from: a */
    public static ProgressDialog m11490a(Context context, CharSequence charSequence, CharSequence charSequence2, boolean z) {
        return m11492a(context, charSequence, charSequence2, z, false, null);
    }

    /* renamed from: a */
    public static ProgressDialog m11491a(Context context, CharSequence charSequence, CharSequence charSequence2, boolean z, boolean z2) {
        return m11492a(context, charSequence, charSequence2, z, z2, null);
    }

    /* renamed from: a */
    public static ProgressDialog m11492a(Context context, CharSequence charSequence, CharSequence charSequence2, boolean z, boolean z2, DialogInterface.OnCancelListener onCancelListener) {
        ProgressDialogC3265l progressDialogC3265l = new ProgressDialogC3265l(context);
        progressDialogC3265l.setTitle(charSequence);
        progressDialogC3265l.setMessage(charSequence2);
        progressDialogC3265l.setIndeterminate(z);
        progressDialogC3265l.setCancelable(z2);
        progressDialogC3265l.setOnCancelListener(onCancelListener);
        progressDialogC3265l.show();
        return progressDialogC3265l;
    }
}
