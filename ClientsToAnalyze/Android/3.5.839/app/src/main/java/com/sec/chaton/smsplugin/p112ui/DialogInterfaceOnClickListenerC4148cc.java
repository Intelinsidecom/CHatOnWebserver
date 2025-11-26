package com.sec.chaton.smsplugin.p112ui;

import android.content.DialogInterface;
import com.sec.chaton.smsplugin.p102b.C3790i;

/* compiled from: MessageOptions.java */
/* renamed from: com.sec.chaton.smsplugin.ui.cc */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4148cc implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4132bn f15435a;

    /* renamed from: b */
    private final C4108aq f15436b;

    /* renamed from: c */
    private final String[] f15437c;

    /* renamed from: d */
    private final C3790i f15438d;

    /* renamed from: e */
    private final boolean f15439e;

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f15435a.m16360a(this.f15436b, this.f15437c, this.f15438d);
        if (this.f15439e) {
            this.f15435a.f15387c.finish();
        }
    }

    DialogInterfaceOnClickListenerC4148cc(C4132bn c4132bn, C4108aq c4108aq, String[] strArr, C3790i c3790i, boolean z) {
        this.f15435a = c4132bn;
        this.f15436b = c4108aq;
        this.f15437c = (String[]) strArr.clone();
        this.f15438d = c3790i;
        this.f15439e = z;
    }
}
