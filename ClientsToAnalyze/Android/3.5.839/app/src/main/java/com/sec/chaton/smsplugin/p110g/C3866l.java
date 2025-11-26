package com.sec.chaton.smsplugin.p110g;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Model.java */
/* renamed from: com.sec.chaton.smsplugin.g.l */
/* loaded from: classes.dex */
public class C3866l {

    /* renamed from: l */
    protected ArrayList<InterfaceC3860f> f13899l = new ArrayList<>();

    /* renamed from: c */
    public void m14834c(InterfaceC3860f interfaceC3860f) {
        if (!this.f13899l.contains(interfaceC3860f)) {
            this.f13899l.add(interfaceC3860f);
            mo14789a(interfaceC3860f);
        }
    }

    /* renamed from: d */
    public void m14835d(InterfaceC3860f interfaceC3860f) {
        this.f13899l.remove(interfaceC3860f);
        mo14791b(interfaceC3860f);
    }

    /* renamed from: E */
    public void m14832E() {
        mo14797t_();
        this.f13899l.clear();
    }

    /* renamed from: a */
    protected void m14833a(boolean z) {
        Iterator<InterfaceC3860f> it = this.f13899l.iterator();
        while (it.hasNext()) {
            it.next().onModelChanged(this, z);
        }
    }

    /* renamed from: a */
    protected void mo14789a(InterfaceC3860f interfaceC3860f) {
    }

    /* renamed from: b */
    protected void mo14791b(InterfaceC3860f interfaceC3860f) {
    }

    /* renamed from: t_ */
    protected void mo14797t_() {
    }
}
