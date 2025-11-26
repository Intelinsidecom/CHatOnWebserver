package com.sec.common.p123a;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ListView;

/* compiled from: AlertDialogCompat.java */
/* renamed from: com.sec.common.a.e */
/* loaded from: classes.dex */
public interface InterfaceC4936e {
    /* renamed from: a */
    Dialog mo18758a();

    /* renamed from: a */
    void mo18759a(View view, int i, int i2, int i3, int i4);

    /* renamed from: b */
    ListView mo18760b();

    void dismiss();

    boolean isShowing();

    void setCancelable(boolean z);

    void setCanceledOnTouchOutside(boolean z);

    void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener);

    void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener);

    void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener);

    void show();
}
