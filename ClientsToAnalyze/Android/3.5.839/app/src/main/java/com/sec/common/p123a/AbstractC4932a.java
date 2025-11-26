package com.sec.common.p123a;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.view.View;
import android.widget.ListAdapter;

/* compiled from: AlertDialogBuilderCompat.java */
/* renamed from: com.sec.common.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC4932a {
    /* renamed from: a */
    public abstract AbstractC4932a mo18734a(int i);

    /* renamed from: a */
    public abstract AbstractC4932a mo18735a(int i, int i2, DialogInterface.OnClickListener onClickListener);

    /* renamed from: a */
    public abstract AbstractC4932a mo18736a(int i, DialogInterface.OnClickListener onClickListener);

    /* renamed from: a */
    public abstract AbstractC4932a mo18737a(DialogInterface.OnCancelListener onCancelListener);

    /* renamed from: a */
    public abstract AbstractC4932a mo18738a(View view);

    /* renamed from: a */
    public abstract AbstractC4932a mo18739a(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener);

    /* renamed from: a */
    public abstract AbstractC4932a mo18740a(CharSequence charSequence);

    /* renamed from: a */
    public abstract AbstractC4932a mo18741a(CharSequence charSequence, DialogInterface.OnClickListener onClickListener);

    /* renamed from: a */
    public abstract AbstractC4932a mo18742a(boolean z);

    /* renamed from: a */
    public abstract AbstractC4932a mo18743a(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener);

    /* renamed from: a */
    public abstract AbstractC4932a mo18744a(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener);

    /* renamed from: a */
    public abstract InterfaceC4936e mo18745a();

    /* renamed from: b */
    public abstract AbstractC4932a mo18746b(int i);

    /* renamed from: b */
    public abstract AbstractC4932a mo18747b(int i, DialogInterface.OnClickListener onClickListener);

    /* renamed from: b */
    public abstract AbstractC4932a mo18748b(View view);

    /* renamed from: b */
    public abstract AbstractC4932a mo18749b(CharSequence charSequence);

    /* renamed from: b */
    public abstract AbstractC4932a mo18750b(CharSequence charSequence, DialogInterface.OnClickListener onClickListener);

    /* renamed from: b */
    public abstract AbstractC4932a mo18751b(boolean z);

    /* renamed from: b */
    public abstract InterfaceC4936e mo18752b();

    /* renamed from: c */
    public abstract AbstractC4932a mo18753c(int i);

    /* renamed from: c */
    public abstract AbstractC4932a mo18754c(int i, DialogInterface.OnClickListener onClickListener);

    /* renamed from: c */
    public abstract AbstractC4932a mo18755c(CharSequence charSequence, DialogInterface.OnClickListener onClickListener);

    /* renamed from: d */
    public abstract AbstractC4932a mo18756d(int i, DialogInterface.OnClickListener onClickListener);

    /* renamed from: a */
    public static AbstractC4932a m18733a(Context context) {
        return Build.VERSION.SDK_INT < 11 ? new C4933b(context) : new C4934c(context);
    }

    AbstractC4932a(Context context) {
    }

    AbstractC4932a(Context context, int i) {
    }
}
