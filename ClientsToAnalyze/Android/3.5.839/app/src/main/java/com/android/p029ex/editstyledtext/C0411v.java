package com.android.p029ex.editstyledtext;

import android.util.Log;

/* compiled from: EditStyledText.java */
/* renamed from: com.android.ex.editstyledtext.v */
/* loaded from: classes.dex */
public class C0411v extends C0400k {

    /* renamed from: c */
    final /* synthetic */ C0392c f997c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0411v(C0392c c0392c) {
        super(c0392c);
        this.f997c = c0392c;
    }

    @Override // com.android.p029ex.editstyledtext.C0400k
    /* renamed from: b */
    protected boolean mo1305b() {
        if (this.f997c.f954c.m1410n() == 0 || this.f997c.f954c.m1410n() == 5) {
            this.f997c.f954c.m1367f(this.f997c.f956e);
            this.f997c.f954c.m1360c(this.f997c.f953b.getSelectionStart(), this.f997c.f953b.getSelectionEnd());
            m1466f();
            this.f997c.m1460b();
            return true;
        }
        if (this.f997c.f954c.m1410n() == this.f997c.f956e) {
            return false;
        }
        Log.d("EditModeActions", "--- setspanactionbase" + this.f997c.f954c.m1410n() + "," + this.f997c.f956e);
        if (!this.f997c.f954c.m1408l()) {
            this.f997c.f954c.m1332I();
            this.f997c.f954c.m1367f(this.f997c.f956e);
        } else {
            this.f997c.f954c.m1367f(0);
            this.f997c.f954c.m1369g(0);
        }
        this.f997c.m1460b();
        return true;
    }

    @Override // com.android.p029ex.editstyledtext.C0400k
    /* renamed from: e */
    protected boolean mo1465e() {
        if (this.f997c.f954c.m1410n() != 0 && this.f997c.f954c.m1410n() != 5) {
            return mo1305b();
        }
        this.f997c.f954c.m1367f(this.f997c.f956e);
        this.f997c.m1457a();
        return true;
    }

    @Override // com.android.p029ex.editstyledtext.C0400k
    /* renamed from: d */
    protected boolean mo1304d() {
        if (this.f997c.f954c.m1410n() != 0 && this.f997c.f954c.m1410n() != 5) {
            return mo1465e();
        }
        this.f997c.f954c.m1367f(this.f997c.f956e);
        m1466f();
        this.f997c.m1460b();
        return true;
    }

    @Override // com.android.p029ex.editstyledtext.C0400k
    /* renamed from: a */
    protected boolean mo1303a() {
        if (!mo1304d()) {
            this.f997c.f953b.m1264b(0);
            return false;
        }
        return true;
    }
}
