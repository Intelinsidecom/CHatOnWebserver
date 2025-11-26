package com.android.p029ex.editstyledtext;

import android.util.Log;

/* compiled from: EditStyledText.java */
/* renamed from: com.android.ex.editstyledtext.t */
/* loaded from: classes.dex */
public class C0409t extends C0400k {

    /* renamed from: a */
    final /* synthetic */ C0392c f995a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0409t(C0392c c0392c) {
        super(c0392c);
        this.f995a = c0392c;
    }

    @Override // com.android.p029ex.editstyledtext.C0400k
    /* renamed from: b */
    protected boolean mo1305b() {
        if (this.f995a.f954c.m1340Q()) {
            Log.e("EditModeActions", "Selection is off, but selected");
        }
        this.f995a.f954c.m1335L();
        this.f995a.f953b.m1264b(3);
        return true;
    }

    @Override // com.android.p029ex.editstyledtext.C0400k
    /* renamed from: e */
    protected boolean mo1465e() {
        if (this.f995a.f954c.m1340Q()) {
            Log.e("EditModeActions", "Selection now start, but selected");
        }
        this.f995a.f954c.m1336M();
        this.f995a.f953b.m1264b(4);
        if (this.f995a.f954c.m1410n() != 5) {
            this.f995a.m1461b(this.f995a.f954c.m1410n());
            return true;
        }
        return true;
    }

    @Override // com.android.p029ex.editstyledtext.C0400k
    /* renamed from: a */
    protected boolean mo1303a() {
        return false;
    }
}
