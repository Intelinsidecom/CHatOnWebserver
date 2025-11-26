package com.android.p029ex.editstyledtext;

/* compiled from: EditStyledText.java */
/* renamed from: com.android.ex.editstyledtext.x */
/* loaded from: classes.dex */
public class C0413x extends C0411v {

    /* renamed from: a */
    final /* synthetic */ C0392c f999a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0413x(C0392c c0392c) {
        super(c0392c);
        this.f999a = c0392c;
    }

    @Override // com.android.p029ex.editstyledtext.C0411v, com.android.p029ex.editstyledtext.C0400k
    /* renamed from: a */
    protected boolean mo1303a() {
        if (!super.mo1303a()) {
            this.f999a.f955d.m1441g();
        }
        return true;
    }

    @Override // com.android.p029ex.editstyledtext.C0400k
    /* renamed from: c */
    protected boolean mo1462c() {
        if (!super.mo1462c()) {
            int iM1415s = this.f999a.f954c.m1415s();
            this.f999a.f954c.m1393b(this.f999a.f954c.m1414r(), false);
            if (!this.f999a.f954c.m1408l()) {
                this.f999a.f954c.m1398c(iM1415s, false);
                this.f999a.f954c.m1332I();
            } else {
                m1466f();
                this.f999a.f955d.m1441g();
            }
        }
        return true;
    }
}
