package com.sec.chaton.smsplugin.p112ui;

import com.sec.chaton.smsplugin.p104d.p106b.RunnableC3832m;
import com.sec.chaton.smsplugin.p110g.C3862h;
import com.sec.chaton.smsplugin.p110g.C3868n;
import com.sec.chaton.smsplugin.p110g.C3870p;
import com.sec.chaton.smsplugin.p110g.C3871q;
import org.p146b.p147a.p148a.InterfaceC5240e;

/* compiled from: SlideshowActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ii */
/* loaded from: classes.dex */
class RunnableC4316ii implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C3870p f15711a;

    /* renamed from: b */
    final /* synthetic */ SlideshowActivity f15712b;

    RunnableC4316ii(SlideshowActivity slideshowActivity, C3870p c3870p) {
        this.f15712b = slideshowActivity;
        this.f15711a = c3870p;
    }

    /* renamed from: a */
    private boolean m16486a() {
        return this.f15712b.f15148b.m14574c() || this.f15712b.f15148b.m14572a() || this.f15712b.f15148b.m14573b();
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        int iM14842d;
        int iM14841c;
        this.f15712b.f15148b = new RunnableC3832m();
        if (C4149cd.m16389a(this.f15711a) == 4) {
            this.f15712b.m16224a();
            this.f15712b.f15151e.setMediaController(this.f15712b.f15147a);
        }
        this.f15712b.f15150d = C3871q.m14926a(this.f15711a);
        if (SlideshowActivity.m16227b(this.f15712b.f15150d)) {
            C3862h c3862hM14913d = this.f15711a.m14913d();
            if (c3862hM14913d != null) {
                C3868n c3868nM14786a = c3862hM14913d.m14786a();
                if (c3868nM14786a != null) {
                    iM14841c = c3868nM14786a.m14841c();
                    iM14842d = c3868nM14786a.m14842d();
                } else {
                    iM14842d = 0;
                    iM14841c = 0;
                }
                C3868n c3868nM14790b = c3862hM14913d.m14790b();
                if (c3868nM14790b != null) {
                    int iM14841c2 = c3868nM14790b.m14841c();
                    int iM14842d2 = c3868nM14790b.m14842d();
                    i3 = iM14842d;
                    i = iM14842d2;
                    i4 = iM14841c;
                    i2 = iM14841c2;
                } else {
                    i3 = iM14842d;
                    i4 = iM14841c;
                    i = 0;
                    i2 = 0;
                }
            } else {
                i = 0;
                i2 = 0;
                i3 = 0;
                i4 = 0;
            }
            this.f15712b.f15151e.m16220a(i2, i, i4, i3);
        }
        ((InterfaceC5240e) this.f15712b.f15150d).mo14500a("SimlDocumentEnd", this.f15712b, false);
        ((InterfaceC5240e) this.f15712b.f15150d).mo14500a("SmilDocumentStart", this.f15712b, false);
        this.f15712b.f15148b.m14571a(this.f15712b.f15150d);
        if (m16486a()) {
            this.f15712b.f15148b.m14581j();
        } else {
            this.f15712b.f15148b.m14576e();
        }
    }
}
