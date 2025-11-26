package com.android.p029ex.editstyledtext;

/* compiled from: EditStyledText.java */
/* renamed from: com.android.ex.editstyledtext.h */
/* loaded from: classes.dex */
public class C0397h extends C0411v {

    /* renamed from: a */
    final /* synthetic */ C0392c f982a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0397h(C0392c c0392c) {
        super(c0392c);
        this.f982a = c0392c;
    }

    @Override // com.android.p029ex.editstyledtext.C0411v, com.android.p029ex.editstyledtext.C0400k
    /* renamed from: a */
    protected boolean mo1303a() {
        if (!super.mo1303a()) {
            this.f982a.f955d.m1437e();
        }
        return true;
    }

    @Override // com.android.p029ex.editstyledtext.C0400k
    /* renamed from: c */
    protected boolean mo1462c() {
        if (!super.mo1462c()) {
            int iM1414r = this.f982a.f954c.m1414r();
            this.f982a.f954c.m1398c(this.f982a.f954c.m1415s(), false);
            if (!this.f982a.f954c.m1408l()) {
                this.f982a.f954c.m1393b(iM1414r, false);
                this.f982a.f954c.m1332I();
            } else {
                m1466f();
                this.f982a.f955d.m1437e();
            }
        }
        return true;
    }
}
