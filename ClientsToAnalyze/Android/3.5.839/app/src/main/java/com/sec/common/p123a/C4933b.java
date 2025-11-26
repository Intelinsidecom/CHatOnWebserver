package com.sec.common.p123a;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.sec.common.C4969b;

/* compiled from: AlertDialogBuilderImpl.java */
/* renamed from: com.sec.common.a.b */
/* loaded from: classes.dex */
class C4933b extends AbstractC4932a {

    /* renamed from: A */
    DialogInterface.OnClickListener f17994A;

    /* renamed from: B */
    DialogInterface.OnCancelListener f17995B;

    /* renamed from: a */
    Context f17996a;

    /* renamed from: b */
    int f17997b;

    /* renamed from: c */
    boolean f17998c;

    /* renamed from: d */
    CharSequence[] f17999d;

    /* renamed from: e */
    ListAdapter f18000e;

    /* renamed from: f */
    Cursor f18001f;

    /* renamed from: g */
    String f18002g;

    /* renamed from: h */
    String f18003h;

    /* renamed from: i */
    int f18004i;

    /* renamed from: j */
    boolean[] f18005j;

    /* renamed from: k */
    boolean f18006k;

    /* renamed from: l */
    boolean f18007l;

    /* renamed from: m */
    DialogInterface.OnClickListener f18008m;

    /* renamed from: n */
    DialogInterface.OnMultiChoiceClickListener f18009n;

    /* renamed from: o */
    AdapterView.OnItemSelectedListener f18010o;

    /* renamed from: p */
    DialogInterface.OnKeyListener f18011p;

    /* renamed from: q */
    boolean f18012q;

    /* renamed from: r */
    CharSequence f18013r;

    /* renamed from: s */
    View f18014s;

    /* renamed from: t */
    CharSequence f18015t;

    /* renamed from: u */
    View f18016u;

    /* renamed from: v */
    CharSequence f18017v;

    /* renamed from: w */
    DialogInterface.OnClickListener f18018w;

    /* renamed from: x */
    CharSequence f18019x;

    /* renamed from: y */
    DialogInterface.OnClickListener f18020y;

    /* renamed from: z */
    CharSequence f18021z;

    C4933b(Context context) {
        this(context, m18757b(context));
    }

    C4933b(Context context, int i) {
        super(context, i);
        this.f17996a = context;
        this.f17997b = i;
        this.f18012q = true;
    }

    /* renamed from: b */
    private static int m18757b(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C4969b.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: a */
    public InterfaceC4936e mo18745a() {
        DialogC4937f dialogC4937f = new DialogC4937f(this);
        dialogC4937f.m18783c();
        if (this.f18016u != null) {
            dialogC4937f.mo18759a(this.f18016u, 0, 0, 0, 0);
        }
        return dialogC4937f;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: b */
    public InterfaceC4936e mo18752b() {
        InterfaceC4936e interfaceC4936eMo18745a = mo18745a();
        interfaceC4936eMo18745a.mo18758a().show();
        return interfaceC4936eMo18745a;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: a */
    public AbstractC4932a mo18740a(CharSequence charSequence) {
        this.f18013r = charSequence;
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: a */
    public AbstractC4932a mo18734a(int i) {
        this.f18013r = this.f17996a.getString(i);
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: a */
    public AbstractC4932a mo18738a(View view) {
        this.f18014s = view;
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: b */
    public AbstractC4932a mo18749b(CharSequence charSequence) {
        this.f18015t = charSequence;
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: b */
    public AbstractC4932a mo18746b(int i) {
        this.f18015t = this.f17996a.getString(i);
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: b */
    public AbstractC4932a mo18748b(View view) {
        this.f18016u = view;
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: c */
    public AbstractC4932a mo18753c(int i) {
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: a */
    public AbstractC4932a mo18736a(int i, DialogInterface.OnClickListener onClickListener) {
        this.f17999d = this.f17996a.getResources().getTextArray(i);
        this.f18008m = onClickListener;
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: a */
    public AbstractC4932a mo18744a(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
        this.f17999d = charSequenceArr;
        this.f18008m = onClickListener;
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: a */
    public AbstractC4932a mo18743a(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
        this.f17999d = charSequenceArr;
        this.f18004i = i;
        this.f18008m = onClickListener;
        this.f18006k = true;
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: a */
    public AbstractC4932a mo18739a(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
        this.f18000e = listAdapter;
        this.f18004i = i;
        this.f18008m = onClickListener;
        this.f18006k = true;
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: a */
    public AbstractC4932a mo18735a(int i, int i2, DialogInterface.OnClickListener onClickListener) {
        this.f17999d = this.f17996a.getResources().getTextArray(i);
        this.f18004i = i2;
        this.f18008m = onClickListener;
        this.f18006k = true;
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: a */
    public AbstractC4932a mo18742a(boolean z) {
        this.f17998c = z;
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: a */
    public AbstractC4932a mo18741a(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        if (Build.VERSION.SDK_INT < 11) {
            this.f18021z = charSequence;
            this.f17994A = onClickListener;
        } else {
            this.f18017v = charSequence;
            this.f18018w = onClickListener;
        }
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: b */
    public AbstractC4932a mo18747b(int i, DialogInterface.OnClickListener onClickListener) {
        if (Build.VERSION.SDK_INT < 11) {
            this.f18021z = this.f17996a.getString(i);
            this.f17994A = onClickListener;
        } else {
            this.f18017v = this.f17996a.getString(i);
            this.f18018w = onClickListener;
        }
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: b */
    public AbstractC4932a mo18750b(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.f18019x = charSequence;
        this.f18020y = onClickListener;
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: c */
    public AbstractC4932a mo18754c(int i, DialogInterface.OnClickListener onClickListener) {
        this.f18019x = this.f17996a.getString(i);
        this.f18020y = onClickListener;
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: c */
    public AbstractC4932a mo18755c(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        if (Build.VERSION.SDK_INT < 14) {
            this.f18017v = charSequence;
            this.f18018w = onClickListener;
        } else {
            this.f18021z = charSequence;
            this.f17994A = onClickListener;
        }
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: d */
    public AbstractC4932a mo18756d(int i, DialogInterface.OnClickListener onClickListener) {
        if (Build.VERSION.SDK_INT < 14) {
            this.f18017v = this.f17996a.getString(i);
            this.f18018w = onClickListener;
        } else {
            this.f18021z = this.f17996a.getString(i);
            this.f17994A = onClickListener;
        }
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: a */
    public AbstractC4932a mo18737a(DialogInterface.OnCancelListener onCancelListener) {
        this.f17995B = onCancelListener;
        return this;
    }

    @Override // com.sec.common.p123a.AbstractC4932a
    /* renamed from: b */
    public AbstractC4932a mo18751b(boolean z) {
        this.f18012q = z;
        return this;
    }
}
