package com.sec.common.p063a;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ListView;

/* compiled from: AlertDialogWrapper.java */
/* renamed from: com.sec.common.a.m */
/* loaded from: classes.dex */
class C3283m implements InterfaceC3274d {

    /* renamed from: a */
    private AlertDialog f11886a;

    public C3283m(AlertDialog alertDialog) {
        this.f11886a = alertDialog;
    }

    @Override // com.sec.common.p063a.InterfaceC3274d
    /* renamed from: a */
    public Dialog mo11517a() {
        return this.f11886a;
    }

    @Override // com.sec.common.p063a.InterfaceC3274d
    public void show() {
        this.f11886a.show();
    }

    @Override // com.sec.common.p063a.InterfaceC3274d
    public void dismiss() {
        this.f11886a.dismiss();
    }

    @Override // com.sec.common.p063a.InterfaceC3274d
    public boolean isShowing() {
        return this.f11886a.isShowing();
    }

    @Override // com.sec.common.p063a.InterfaceC3274d
    public void setCancelable(boolean z) {
        this.f11886a.setCancelable(z);
    }

    @Override // com.sec.common.p063a.InterfaceC3274d
    public void setCanceledOnTouchOutside(boolean z) {
        this.f11886a.setCanceledOnTouchOutside(z);
    }

    @Override // com.sec.common.p063a.InterfaceC3274d
    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.f11886a.setOnCancelListener(onCancelListener);
    }

    @Override // com.sec.common.p063a.InterfaceC3274d
    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.f11886a.setOnDismissListener(onDismissListener);
    }

    @Override // com.sec.common.p063a.InterfaceC3274d
    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.f11886a.setOnKeyListener(onKeyListener);
    }

    @Override // com.sec.common.p063a.InterfaceC3274d
    /* renamed from: b */
    public ListView mo11519b() {
        return this.f11886a.getListView();
    }

    @Override // com.sec.common.p063a.InterfaceC3274d
    /* renamed from: a */
    public void mo11518a(View view, int i, int i2, int i3, int i4) {
        this.f11886a.setView(view, i, i2, i3, i4);
    }
}
