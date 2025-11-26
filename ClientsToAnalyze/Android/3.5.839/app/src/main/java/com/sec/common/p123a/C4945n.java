package com.sec.common.p123a;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ListView;

/* compiled from: AlertDialogWrapper.java */
/* renamed from: com.sec.common.a.n */
/* loaded from: classes.dex */
class C4945n implements InterfaceC4936e {

    /* renamed from: a */
    private AlertDialog f18085a;

    public C4945n(AlertDialog alertDialog) {
        this.f18085a = alertDialog;
    }

    @Override // com.sec.common.p123a.InterfaceC4936e
    /* renamed from: a */
    public Dialog mo18758a() {
        return this.f18085a;
    }

    @Override // com.sec.common.p123a.InterfaceC4936e
    public void show() {
        this.f18085a.show();
    }

    @Override // com.sec.common.p123a.InterfaceC4936e
    public void dismiss() {
        this.f18085a.dismiss();
    }

    @Override // com.sec.common.p123a.InterfaceC4936e
    public boolean isShowing() {
        return this.f18085a.isShowing();
    }

    @Override // com.sec.common.p123a.InterfaceC4936e
    public void setCancelable(boolean z) {
        this.f18085a.setCancelable(z);
    }

    @Override // com.sec.common.p123a.InterfaceC4936e
    public void setCanceledOnTouchOutside(boolean z) {
        this.f18085a.setCanceledOnTouchOutside(z);
    }

    @Override // com.sec.common.p123a.InterfaceC4936e
    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.f18085a.setOnCancelListener(onCancelListener);
    }

    @Override // com.sec.common.p123a.InterfaceC4936e
    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.f18085a.setOnDismissListener(onDismissListener);
    }

    @Override // com.sec.common.p123a.InterfaceC4936e
    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.f18085a.setOnKeyListener(onKeyListener);
    }

    @Override // com.sec.common.p123a.InterfaceC4936e
    /* renamed from: b */
    public ListView mo18760b() {
        return this.f18085a.getListView();
    }

    @Override // com.sec.common.p123a.InterfaceC4936e
    /* renamed from: a */
    public void mo18759a(View view, int i, int i2, int i3, int i4) {
        this.f18085a.setView(view, i, i2, i3, i4);
    }
}
