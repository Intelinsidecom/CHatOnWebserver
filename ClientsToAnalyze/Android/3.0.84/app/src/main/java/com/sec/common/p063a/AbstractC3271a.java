package com.sec.common.p063a;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.view.View;

/* compiled from: AlertDialogBuilderCompat.java */
/* renamed from: com.sec.common.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC3271a {
    /* renamed from: a */
    public abstract AbstractC3271a mo11495a(int i);

    /* renamed from: a */
    public abstract AbstractC3271a mo11496a(int i, int i2, DialogInterface.OnClickListener onClickListener);

    /* renamed from: a */
    public abstract AbstractC3271a mo11497a(int i, DialogInterface.OnClickListener onClickListener);

    /* renamed from: a */
    public abstract AbstractC3271a mo11498a(DialogInterface.OnCancelListener onCancelListener);

    /* renamed from: a */
    public abstract AbstractC3271a mo11499a(View view);

    /* renamed from: a */
    public abstract AbstractC3271a mo11500a(CharSequence charSequence);

    /* renamed from: a */
    public abstract AbstractC3271a mo11501a(CharSequence charSequence, DialogInterface.OnClickListener onClickListener);

    /* renamed from: a */
    public abstract AbstractC3271a mo11502a(boolean z);

    /* renamed from: a */
    public abstract AbstractC3271a mo11503a(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener);

    /* renamed from: a */
    public abstract AbstractC3271a mo11504a(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener);

    /* renamed from: a */
    public abstract InterfaceC3274d mo11505a();

    /* renamed from: b */
    public abstract AbstractC3271a mo11506b(int i);

    /* renamed from: b */
    public abstract AbstractC3271a mo11507b(int i, DialogInterface.OnClickListener onClickListener);

    /* renamed from: b */
    public abstract AbstractC3271a mo11508b(View view);

    /* renamed from: b */
    public abstract AbstractC3271a mo11509b(CharSequence charSequence);

    /* renamed from: b */
    public abstract AbstractC3271a mo11510b(CharSequence charSequence, DialogInterface.OnClickListener onClickListener);

    /* renamed from: b */
    public abstract AbstractC3271a mo11511b(boolean z);

    /* renamed from: b */
    public abstract InterfaceC3274d mo11512b();

    /* renamed from: c */
    public abstract AbstractC3271a mo11513c(int i);

    /* renamed from: c */
    public abstract AbstractC3271a mo11514c(int i, DialogInterface.OnClickListener onClickListener);

    /* renamed from: d */
    public abstract AbstractC3271a mo11515d(int i, DialogInterface.OnClickListener onClickListener);

    /* renamed from: a */
    public static AbstractC3271a m11494a(Context context) {
        return Build.VERSION.SDK_INT < 11 ? new C3272b(context) : new C3273c(context);
    }

    AbstractC3271a(Context context) {
    }

    AbstractC3271a(Context context, int i) {
    }
}
