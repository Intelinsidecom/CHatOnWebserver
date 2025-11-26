package com.sec.common.p123a;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.view.View;
import android.widget.ListAdapter;

/* compiled from: AlertDialogBuilderWrapper.java */
@TargetApi(11)
/* renamed from: com.sec.common.a.c */
/* loaded from: classes.dex */
public class C4934c extends AbstractC4932a {

    /* renamed from: a */
    private AlertDialog.Builder f18022a;

    /* renamed from: b */
    private View f18023b;

    C4934c(Context context) {
        super(context);
        this.f18022a = new AlertDialog.Builder(context);
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: a */
    public InterfaceC4936e mo18745a() {
        AlertDialog alertDialogCreate = this.f18022a.create();
        alertDialogCreate.setOnShowListener(new DialogInterfaceOnShowListenerC4935d(this));
        C4945n c4945n = new C4945n(alertDialogCreate);
        if (this.f18023b != null) {
            c4945n.mo18759a(this.f18023b, 0, 0, 0, 0);
        }
        return c4945n;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: b */
    public InterfaceC4936e mo18752b() {
        InterfaceC4936e interfaceC4936eMo18745a = mo18745a();
        interfaceC4936eMo18745a.show();
        return interfaceC4936eMo18745a;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: a */
    public AbstractC4932a mo18740a(CharSequence charSequence) {
        this.f18022a.setTitle(charSequence);
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: a */
    public AbstractC4932a mo18734a(int i) {
        this.f18022a.setTitle(i);
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: a */
    public AbstractC4932a mo18738a(View view) {
        this.f18022a.setCustomTitle(view);
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: b */
    public AbstractC4932a mo18749b(CharSequence charSequence) {
        this.f18022a.setMessage(charSequence);
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: b */
    public AbstractC4932a mo18746b(int i) {
        this.f18022a.setMessage(i);
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: b */
    public AbstractC4932a mo18748b(View view) {
        this.f18023b = view;
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: c */
    public AbstractC4932a mo18753c(int i) {
        this.f18022a.setIcon(i);
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: a */
    public AbstractC4932a mo18736a(int i, DialogInterface.OnClickListener onClickListener) {
        this.f18022a.setItems(i, onClickListener);
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: a */
    public AbstractC4932a mo18744a(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
        this.f18022a.setItems(charSequenceArr, onClickListener);
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: a */
    public AbstractC4932a mo18743a(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
        this.f18022a.setSingleChoiceItems(charSequenceArr, i, onClickListener);
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: a */
    public AbstractC4932a mo18739a(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
        this.f18022a.setSingleChoiceItems(listAdapter, i, onClickListener);
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: a */
    public AbstractC4932a mo18735a(int i, int i2, DialogInterface.OnClickListener onClickListener) {
        this.f18022a.setSingleChoiceItems(i, i2, onClickListener);
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: a */
    public AbstractC4932a mo18742a(boolean z) {
        this.f18022a.setInverseBackgroundForced(z);
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: a */
    public AbstractC4932a mo18741a(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        if (Build.VERSION.SDK_INT < 11) {
            this.f18022a.setNegativeButton(charSequence, onClickListener);
        } else {
            this.f18022a.setPositiveButton(charSequence, onClickListener);
        }
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: b */
    public AbstractC4932a mo18747b(int i, DialogInterface.OnClickListener onClickListener) {
        if (Build.VERSION.SDK_INT < 11) {
            this.f18022a.setNegativeButton(i, onClickListener);
        } else {
            this.f18022a.setPositiveButton(i, onClickListener);
        }
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: b */
    public AbstractC4932a mo18750b(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.f18022a.setNeutralButton(charSequence, onClickListener);
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: c */
    public AbstractC4932a mo18754c(int i, DialogInterface.OnClickListener onClickListener) {
        this.f18022a.setNeutralButton(i, onClickListener);
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: c */
    public AbstractC4932a mo18755c(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        if (Build.VERSION.SDK_INT < 11) {
            this.f18022a.setPositiveButton(charSequence, onClickListener);
        } else {
            this.f18022a.setNegativeButton(charSequence, onClickListener);
        }
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: d */
    public AbstractC4932a mo18756d(int i, DialogInterface.OnClickListener onClickListener) {
        if (Build.VERSION.SDK_INT < 11) {
            this.f18022a.setPositiveButton(i, onClickListener);
        } else {
            this.f18022a.setNegativeButton(i, onClickListener);
        }
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: a */
    public AbstractC4932a mo18737a(DialogInterface.OnCancelListener onCancelListener) {
        this.f18022a.setOnCancelListener(onCancelListener);
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: b */
    public AbstractC4932a mo18751b(boolean z) {
        this.f18022a.setCancelable(z);
        return this;
    }
}
