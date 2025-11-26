package com.sec.common.p063a;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ListView;

/* compiled from: AlertDialogCompat.java */
/* renamed from: com.sec.common.a.d */
/* loaded from: classes.dex */
public interface InterfaceC3274d {
    /* renamed from: a */
    Dialog mo11517a();

    /* renamed from: a */
    void mo11518a(View view, int i, int i2, int i3, int i4);

    /* renamed from: b */
    ListView mo11519b();

    void dismiss();

    boolean isShowing();

    void setCancelable(boolean z);

    void setCanceledOnTouchOutside(boolean z);

    void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener);

    void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener);

    void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener);

    void show();
}
