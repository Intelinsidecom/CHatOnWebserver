package com.sec.chaton.widget;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;
import com.sec.chaton.R;

/* compiled from: StrongProgressDialog.java */
/* renamed from: com.sec.chaton.widget.j */
/* loaded from: classes.dex */
public class ProgressDialogC1806j extends ProgressDialog {

    /* renamed from: a */
    private String f6498a;

    public ProgressDialogC1806j(Context context) {
        this(context, true);
    }

    public ProgressDialogC1806j(Context context, boolean z) {
        super(context, R.style.ProgressDialogTheme);
        setCancelable(z);
        setOnKeyListener(new DialogInterfaceOnKeyListenerC1807k(this));
    }

    @Override // android.app.ProgressDialog, android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.customprogressview);
        ((TextView) findViewById(R.id.progressText)).setText(this.f6498a);
    }

    @Override // android.app.ProgressDialog, android.app.AlertDialog
    public void setMessage(CharSequence charSequence) {
        super.setMessage(charSequence);
        this.f6498a = charSequence.toString();
    }

    /* renamed from: a */
    public static ProgressDialog m6140a(Context context, CharSequence charSequence, CharSequence charSequence2) {
        return m6141a(context, charSequence, charSequence2, false);
    }

    /* renamed from: a */
    public static ProgressDialog m6141a(Context context, CharSequence charSequence, CharSequence charSequence2, boolean z) {
        return m6143a(context, charSequence, charSequence2, z, false, null);
    }

    /* renamed from: a */
    public static ProgressDialog m6142a(Context context, CharSequence charSequence, CharSequence charSequence2, boolean z, boolean z2) {
        return m6143a(context, charSequence, charSequence2, z, z2, null);
    }

    /* renamed from: a */
    public static ProgressDialog m6143a(Context context, CharSequence charSequence, CharSequence charSequence2, boolean z, boolean z2, DialogInterface.OnCancelListener onCancelListener) {
        ProgressDialogC1806j progressDialogC1806j = new ProgressDialogC1806j(context);
        progressDialogC1806j.setTitle(charSequence);
        progressDialogC1806j.setMessage(charSequence2);
        progressDialogC1806j.setIndeterminate(z);
        progressDialogC1806j.setCancelable(z2);
        progressDialogC1806j.setOnCancelListener(onCancelListener);
        progressDialogC1806j.show();
        return progressDialogC1806j;
    }
}
