package p010b.p014d.p015a;

import java.io.Serializable;
import java.util.Map;
import p010b.C0320g;
import p010b.p012b.InterfaceC0273b;
import p010b.p013c.C0283b;

/* compiled from: HttpClientWrapper.java */
/* renamed from: b.d.a.h */
/* loaded from: classes.dex */
public final class C0293h implements Serializable {

    /* renamed from: a */
    private final InterfaceC0294i f649a;

    /* renamed from: b */
    private InterfaceC0287b f650b;

    /* renamed from: c */
    private final Map<String, String> f651c;

    /* renamed from: d */
    private InterfaceC0300o f652d;

    public C0293h(InterfaceC0294i interfaceC0294i) {
        this.f649a = interfaceC0294i;
        this.f651c = interfaceC0294i.m1008u();
        this.f650b = C0290e.m1003a(interfaceC0294i);
    }

    public C0293h() {
        this.f649a = C0283b.m989a();
        this.f651c = this.f649a.m1008u();
        this.f650b = C0290e.m1003a(this.f649a);
    }

    /* renamed from: a */
    private AbstractC0297l m1006a(C0296k c0296k) throws C0320g {
        try {
            AbstractC0297l abstractC0297lMo992a = this.f650b.mo992a(c0296k);
            if (this.f652d != null) {
                this.f652d.m1030a(new C0298m(c0296k, abstractC0297lMo992a, null));
            }
            return abstractC0297lMo992a;
        } catch (C0320g e) {
            if (this.f652d != null) {
                this.f652d.m1030a(new C0298m(c0296k, null, e));
            }
            throw e;
        }
    }

    /* renamed from: a */
    public AbstractC0297l m1007a(String str, C0295j[] c0295jArr, InterfaceC0273b interfaceC0273b) {
        return m1006a(new C0296k(EnumC0301p.POST, str, c0295jArr, interfaceC0273b, this.f651c));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0293h c0293h = (C0293h) obj;
        return this.f650b.equals(c0293h.f650b) && this.f651c.equals(c0293h.f651c) && this.f649a.equals(c0293h.f649a);
    }

    public int hashCode() {
        return (((this.f649a.hashCode() * 31) + this.f650b.hashCode()) * 31) + this.f651c.hashCode();
    }

    public String toString() {
        return "HttpClientWrapper{wrapperConf=" + this.f649a + ", http=" + this.f650b + ", requestHeaders=" + this.f651c + ", httpResponseListener=" + this.f652d + '}';
    }
}
