package com.sec.common.p063a;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.view.View;

/* compiled from: AlertDialogBuilderWrapper.java */
/* renamed from: com.sec.common.a.c */
/* loaded from: classes.dex */
public class C3273c extends AbstractC3271a {

    /* renamed from: a */
    private AlertDialog.Builder f11824a;

    /* renamed from: b */
    private View f11825b;

    C3273c(Context context) {
        super(context);
        this.f11824a = new AlertDialog.Builder(context);
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: a */
    public InterfaceC3274d mo11505a() {
        C3283m c3283m = new C3283m(this.f11824a.create());
        if (this.f11825b != null) {
            c3283m.mo11518a(this.f11825b, 0, 0, 0, 0);
        }
        return c3283m;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: b */
    public InterfaceC3274d mo11512b() {
        InterfaceC3274d interfaceC3274dMo11505a = mo11505a();
        interfaceC3274dMo11505a.show();
        return interfaceC3274dMo11505a;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: a */
    public AbstractC3271a mo11500a(CharSequence charSequence) {
        this.f11824a.setTitle(charSequence);
        return this;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: a */
    public AbstractC3271a mo11495a(int i) {
        this.f11824a.setTitle(i);
        return this;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: a */
    public AbstractC3271a mo11499a(View view) {
        this.f11824a.setCustomTitle(view);
        return this;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: b */
    public AbstractC3271a mo11509b(CharSequence charSequence) {
        this.f11824a.setMessage(charSequence);
        return this;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: b */
    public AbstractC3271a mo11506b(int i) {
        this.f11824a.setMessage(i);
        return this;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: b */
    public AbstractC3271a mo11508b(View view) {
        this.f11825b = view;
        return this;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: c */
    public AbstractC3271a mo11513c(int i) {
        this.f11824a.setIcon(i);
        return this;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: a */
    public AbstractC3271a mo11497a(int i, DialogInterface.OnClickListener onClickListener) {
        this.f11824a.setItems(i, onClickListener);
        return this;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: a */
    public AbstractC3271a mo11504a(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
        this.f11824a.setItems(charSequenceArr, onClickListener);
        return this;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: a */
    public AbstractC3271a mo11503a(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
        this.f11824a.setSingleChoiceItems(charSequenceArr, i, onClickListener);
        return this;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: a */
    public AbstractC3271a mo11496a(int i, int i2, DialogInterface.OnClickListener onClickListener) {
        this.f11824a.setSingleChoiceItems(i, i2, onClickListener);
        return this;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: a */
    public AbstractC3271a mo11502a(boolean z) {
        this.f11824a.setInverseBackgroundForced(z);
        return this;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: a */
    public AbstractC3271a mo11501a(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        if (Build.VERSION.SDK_INT < 11) {
            this.f11824a.setNegativeButton(charSequence, onClickListener);
        } else {
            this.f11824a.setPositiveButton(charSequence, onClickListener);
        }
        return this;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: b */
    public AbstractC3271a mo11507b(int i, DialogInterface.OnClickListener onClickListener) {
        if (Build.VERSION.SDK_INT < 11) {
            this.f11824a.setNegativeButton(i, onClickListener);
        } else {
            this.f11824a.setPositiveButton(i, onClickListener);
        }
        return this;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: c */
    public AbstractC3271a mo11514c(int i, DialogInterface.OnClickListener onClickListener) {
        this.f11824a.setNeutralButton(i, onClickListener);
        return this;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: b */
    public AbstractC3271a mo11510b(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        if (Build.VERSION.SDK_INT < 11) {
            this.f11824a.setPositiveButton(charSequence, onClickListener);
        } else {
            this.f11824a.setNegativeButton(charSequence, onClickListener);
        }
        return this;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: d */
    public AbstractC3271a mo11515d(int i, DialogInterface.OnClickListener onClickListener) {
        if (Build.VERSION.SDK_INT < 11) {
            this.f11824a.setPositiveButton(i, onClickListener);
        } else {
            this.f11824a.setNegativeButton(i, onClickListener);
        }
        return this;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: a */
    public AbstractC3271a mo11498a(DialogInterface.OnCancelListener onCancelListener) {
        this.f11824a.setOnCancelListener(onCancelListener);
        return this;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: b */
    public AbstractC3271a mo11511b(boolean z) {
        this.f11824a.setCancelable(z);
        return this;
    }
}
