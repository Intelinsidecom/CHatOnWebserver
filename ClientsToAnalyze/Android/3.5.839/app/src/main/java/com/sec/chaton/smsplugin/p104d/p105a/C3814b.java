package com.sec.chaton.smsplugin.p104d.p105a;

import com.sec.chaton.smsplugin.p111h.C3890m;
import java.util.ArrayList;
import org.p146b.p147a.p148a.C5238c;
import org.p146b.p147a.p148a.InterfaceC5237b;
import org.p146b.p147a.p148a.InterfaceC5239d;
import org.p146b.p147a.p148a.InterfaceC5240e;

/* compiled from: EventTargetImpl.java */
/* renamed from: com.sec.chaton.smsplugin.d.a.b */
/* loaded from: classes.dex */
public class C3814b implements InterfaceC5240e {

    /* renamed from: a */
    private ArrayList<C3815c> f13689a;

    /* renamed from: b */
    private InterfaceC5240e f13690b;

    public C3814b(InterfaceC5240e interfaceC5240e) {
        this.f13690b = interfaceC5240e;
    }

    @Override // org.p146b.p147a.p148a.InterfaceC5240e
    /* renamed from: a */
    public void mo14500a(String str, InterfaceC5239d interfaceC5239d, boolean z) {
        if (str != null && !str.equals("") && interfaceC5239d != null) {
            mo14502b(str, interfaceC5239d, z);
            if (this.f13689a == null) {
                this.f13689a = new ArrayList<>();
            }
            this.f13689a.add(new C3815c(str, interfaceC5239d, z));
        }
    }

    @Override // org.p146b.p147a.p148a.InterfaceC5240e
    /* renamed from: a */
    public boolean mo14501a(InterfaceC5237b interfaceC5237b) {
        int i = 0;
        C3813a c3813a = (C3813a) interfaceC5237b;
        if (!c3813a.m14496c()) {
            throw new C5238c((short) 0, "Event not initialized");
        }
        if (c3813a.mo14494b() == null || c3813a.mo14494b().equals("")) {
            throw new C5238c((short) 0, "Unspecified even type");
        }
        c3813a.m14491a(this.f13690b);
        c3813a.m14492a((short) 2);
        c3813a.m14495b(this.f13690b);
        if (!c3813a.m14498e() && this.f13689a != null) {
            while (true) {
                int i2 = i;
                if (i2 >= this.f13689a.size()) {
                    break;
                }
                C3815c c3815c = this.f13689a.get(i2);
                if (!c3815c.f13693c && c3815c.f13691a.equals(c3813a.mo14494b())) {
                    try {
                        c3815c.f13692b.mo14745a(c3813a);
                    } catch (Exception e) {
                        C3890m.m14995a("EventTargetImpl", "Catched EventListener exception", e);
                    }
                }
                i = i2 + 1;
            }
        }
        if (c3813a.m14493a()) {
        }
        return c3813a.m14497d();
    }

    @Override // org.p146b.p147a.p148a.InterfaceC5240e
    /* renamed from: b */
    public void mo14502b(String str, InterfaceC5239d interfaceC5239d, boolean z) {
        if (this.f13689a != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f13689a.size()) {
                    C3815c c3815c = this.f13689a.get(i2);
                    if (c3815c.f13693c != z || c3815c.f13692b != interfaceC5239d || !c3815c.f13691a.equals(str)) {
                        i = i2 + 1;
                    } else {
                        this.f13689a.remove(i2);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }
}
