package com.android.p029ex.editstyledtext;

/* compiled from: EditStyledText.java */
/* renamed from: com.android.ex.editstyledtext.ad */
/* loaded from: classes.dex */
public class C0364ad extends C0400k {

    /* renamed from: c */
    final /* synthetic */ C0392c f881c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0364ad(C0392c c0392c) {
        super(c0392c);
        this.f881c = c0392c;
    }

    @Override // com.android.p029ex.editstyledtext.C0400k
    /* renamed from: b */
    protected boolean mo1305b() {
        if (this.f881c.f954c.m1410n() != 0 && this.f881c.f954c.m1410n() != 5) {
            return false;
        }
        this.f881c.f954c.m1367f(this.f881c.f956e);
        this.f881c.m1457a();
        return true;
    }

    @Override // com.android.p029ex.editstyledtext.C0400k
    /* renamed from: d */
    protected boolean mo1304d() {
        if (this.f881c.f954c.m1410n() == 0 || this.f881c.f954c.m1410n() == 5) {
            this.f881c.f954c.m1367f(this.f881c.f956e);
            m1466f();
            this.f881c.m1460b();
            return true;
        }
        if (this.f881c.f954c.m1410n() != this.f881c.f956e) {
            this.f881c.f954c.m1332I();
            this.f881c.f954c.m1367f(this.f881c.f956e);
            this.f881c.m1460b();
            return true;
        }
        return false;
    }
}
