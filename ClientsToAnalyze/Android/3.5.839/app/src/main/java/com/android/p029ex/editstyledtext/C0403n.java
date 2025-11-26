package com.android.p029ex.editstyledtext;

import android.net.Uri;

/* compiled from: EditStyledText.java */
/* renamed from: com.android.ex.editstyledtext.n */
/* loaded from: classes.dex */
public class C0403n extends C0400k {

    /* renamed from: a */
    final /* synthetic */ C0392c f989a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0403n(C0392c c0392c) {
        super(c0392c);
        this.f989a = c0392c;
    }

    @Override // com.android.p029ex.editstyledtext.C0400k
    /* renamed from: b */
    protected boolean mo1305b() {
        Object objA = m1463a(0);
        if (objA == null) {
            this.f989a.f953b.m1279t();
            return true;
        }
        if (objA instanceof Uri) {
            this.f989a.f954c.m1345a((Uri) objA);
            return true;
        }
        if (objA instanceof Integer) {
            this.f989a.f954c.m1365e(((Integer) objA).intValue());
            return true;
        }
        return true;
    }
}
