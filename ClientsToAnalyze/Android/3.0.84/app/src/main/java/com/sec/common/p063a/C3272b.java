package com.sec.common.p063a;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.sec.common.C3307b;

/* compiled from: AlertDialogBuilderImpl.java */
/* renamed from: com.sec.common.a.b */
/* loaded from: classes.dex */
class C3272b extends AbstractC3271a {

    /* renamed from: A */
    DialogInterface.OnClickListener f11796A;

    /* renamed from: B */
    DialogInterface.OnCancelListener f11797B;

    /* renamed from: a */
    Context f11798a;

    /* renamed from: b */
    int f11799b;

    /* renamed from: c */
    boolean f11800c;

    /* renamed from: d */
    CharSequence[] f11801d;

    /* renamed from: e */
    ListAdapter f11802e;

    /* renamed from: f */
    Cursor f11803f;

    /* renamed from: g */
    String f11804g;

    /* renamed from: h */
    String f11805h;

    /* renamed from: i */
    int f11806i;

    /* renamed from: j */
    boolean[] f11807j;

    /* renamed from: k */
    boolean f11808k;

    /* renamed from: l */
    boolean f11809l;

    /* renamed from: m */
    DialogInterface.OnClickListener f11810m;

    /* renamed from: n */
    DialogInterface.OnMultiChoiceClickListener f11811n;

    /* renamed from: o */
    AdapterView.OnItemSelectedListener f11812o;

    /* renamed from: p */
    DialogInterface.OnKeyListener f11813p;

    /* renamed from: q */
    boolean f11814q;

    /* renamed from: r */
    CharSequence f11815r;

    /* renamed from: s */
    View f11816s;

    /* renamed from: t */
    CharSequence f11817t;

    /* renamed from: u */
    View f11818u;

    /* renamed from: v */
    CharSequence f11819v;

    /* renamed from: w */
    DialogInterface.OnClickListener f11820w;

    /* renamed from: x */
    CharSequence f11821x;

    /* renamed from: y */
    DialogInterface.OnClickListener f11822y;

    /* renamed from: z */
    CharSequence f11823z;

    C3272b(Context context) {
        this(context, m11516b(context));
    }

    C3272b(Context context, int i) {
        super(context, i);
        this.f11798a = context;
        this.f11799b = i;
        this.f11814q = true;
    }

    /* renamed from: b */
    private static int m11516b(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C3307b.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: a */
    public InterfaceC3274d mo11505a() {
        DialogC3275e dialogC3275e = new DialogC3275e(this);
        dialogC3275e.m11542c();
        if (this.f11818u != null) {
            dialogC3275e.mo11518a(this.f11818u, 0, 0, 0, 0);
        }
        return dialogC3275e;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: b */
    public InterfaceC3274d mo11512b() {
        InterfaceC3274d interfaceC3274dMo11505a = mo11505a();
        interfaceC3274dMo11505a.mo11517a().show();
        return interfaceC3274dMo11505a;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: a */
    public AbstractC3271a mo11500a(CharSequence charSequence) {
        this.f11815r = charSequence;
        return this;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: a */
    public AbstractC3271a mo11495a(int i) {
        this.f11815r = this.f11798a.getString(i);
        return this;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: a */
    public AbstractC3271a mo11499a(View view) {
        this.f11816s = view;
        return this;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: b */
    public AbstractC3271a mo11509b(CharSequence charSequence) {
        this.f11817t = charSequence;
        return this;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: b */
    public AbstractC3271a mo11506b(int i) {
        this.f11817t = this.f11798a.getString(i);
        return this;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: b */
    public AbstractC3271a mo11508b(View view) {
        this.f11818u = view;
        return this;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: c */
    public AbstractC3271a mo11513c(int i) {
        return this;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: a */
    public AbstractC3271a mo11497a(int i, DialogInterface.OnClickListener onClickListener) {
        this.f11801d = this.f11798a.getResources().getTextArray(i);
        this.f11810m = onClickListener;
        return this;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: a */
    public AbstractC3271a mo11504a(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
        this.f11801d = charSequenceArr;
        this.f11810m = onClickListener;
        return this;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: a */
    public AbstractC3271a mo11503a(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
        this.f11801d = charSequenceArr;
        this.f11806i = i;
        this.f11810m = onClickListener;
        this.f11808k = true;
        return this;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: a */
    public AbstractC3271a mo11496a(int i, int i2, DialogInterface.OnClickListener onClickListener) {
        this.f11801d = this.f11798a.getResources().getTextArray(i);
        this.f11806i = i2;
        this.f11810m = onClickListener;
        this.f11808k = true;
        return this;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: a */
    public AbstractC3271a mo11502a(boolean z) {
        this.f11800c = z;
        return this;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: a */
    public AbstractC3271a mo11501a(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        if (Build.VERSION.SDK_INT < 11) {
            this.f11823z = charSequence;
            this.f11796A = onClickListener;
        } else {
            this.f11819v = charSequence;
            this.f11820w = onClickListener;
        }
        return this;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: b */
    public AbstractC3271a mo11507b(int i, DialogInterface.OnClickListener onClickListener) {
        if (Build.VERSION.SDK_INT < 11) {
            this.f11823z = this.f11798a.getString(i);
            this.f11796A = onClickListener;
        } else {
            this.f11819v = this.f11798a.getString(i);
            this.f11820w = onClickListener;
        }
        return this;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: c */
    public AbstractC3271a mo11514c(int i, DialogInterface.OnClickListener onClickListener) {
        this.f11821x = this.f11798a.getString(i);
        this.f11822y = onClickListener;
        return this;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: b */
    public AbstractC3271a mo11510b(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        if (Build.VERSION.SDK_INT < 14) {
            this.f11819v = charSequence;
            this.f11820w = onClickListener;
        } else {
            this.f11823z = charSequence;
            this.f11796A = onClickListener;
        }
        return this;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: d */
    public AbstractC3271a mo11515d(int i, DialogInterface.OnClickListener onClickListener) {
        if (Build.VERSION.SDK_INT < 14) {
            this.f11819v = this.f11798a.getString(i);
            this.f11820w = onClickListener;
        } else {
            this.f11823z = this.f11798a.getString(i);
            this.f11796A = onClickListener;
        }
        return this;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: a */
    public AbstractC3271a mo11498a(DialogInterface.OnCancelListener onCancelListener) {
        this.f11797B = onCancelListener;
        return this;
    }

    @Override // com.sec.common.p063a.AbstractC3271a
    /* renamed from: b */
    public AbstractC3271a mo11511b(boolean z) {
        this.f11814q = z;
        return this;
    }
}
