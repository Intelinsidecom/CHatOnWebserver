package com.sec.chaton.chat.p054a;

import com.sec.chaton.chat.InterfaceC1773hs;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.util.C4904y;
import org.p138a.p139a.p140a.AbstractC5219b;

/* compiled from: BubbleDrawerFactory.java */
/* renamed from: com.sec.chaton.chat.a.i */
/* loaded from: classes.dex */
public class C1536i extends AbstractC5219b<EnumC2214ab, AbstractC1506a> {
    @Override // org.p138a.p139a.p140a.InterfaceC5222e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractC1506a mo8431a(EnumC2214ab enumC2214ab) {
        switch (C1537j.f5948a[enumC2214ab.ordinal()]) {
            case 1:
                return new C1517ak();
            case 2:
                return new C1524ar();
            case 3:
                return new C1529b();
            case 4:
                return new C1509ac();
            case 5:
                return new C1530c();
            case 6:
                return new C1551x();
            case 7:
                return new C1538k();
            case 8:
                return new C1534g();
            case 9:
                return new C1528av();
            case 10:
                return new C1539l();
            case 11:
            case 12:
                return new C1550w();
            case 13:
                return new C1533f();
            case 14:
                return new C1513ag();
            case 15:
                return new C1512af();
            case 16:
            case 18:
            default:
                return null;
            case 17:
                return new C1516aj();
            case 19:
                return new C1507aa();
            case 20:
                return new C1553z();
            case 21:
                return new C1527au();
        }
    }

    @Override // org.p138a.p139a.p140a.AbstractC5219b, org.p138a.p139a.p140a.InterfaceC5222e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo8433a(EnumC2214ab enumC2214ab, AbstractC1506a abstractC1506a) {
        super.mo8433a((C1536i) enumC2214ab, (EnumC2214ab) abstractC1506a);
        C4904y.m18639b("PASSIVE OBJECT: " + abstractC1506a, C1536i.class.getSimpleName());
        abstractC1506a.m8360a((InterfaceC1773hs) null);
        abstractC1506a.mo8361a(false);
    }
}
