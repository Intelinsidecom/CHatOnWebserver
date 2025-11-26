package p010b.p014d.p015a;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import p010b.p014d.p017c.AbstractC0307a;

/* compiled from: HttpClientBase.java */
/* renamed from: b.d.a.c */
/* loaded from: classes.dex */
public abstract class AbstractC0288c implements InterfaceC0287b, Serializable {

    /* renamed from: b */
    private static final AbstractC0307a f642b = AbstractC0307a.m1036a(AbstractC0288c.class);

    /* renamed from: a */
    protected final InterfaceC0289d f643a;

    public AbstractC0288c(InterfaceC0289d interfaceC0289d) {
        this.f643a = interfaceC0289d;
    }

    /* renamed from: a */
    protected boolean m994a() {
        return (this.f643a.m995m() == null || this.f643a.m995m().equals("")) ? false : true;
    }

    /* renamed from: a */
    public void m993a(DataOutputStream dataOutputStream, String str) throws IOException {
        dataOutputStream.writeBytes(str);
        f642b.mo1038a(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AbstractC0288c) && this.f643a.equals(((AbstractC0288c) obj).f643a);
    }

    public int hashCode() {
        return this.f643a.hashCode();
    }

    public String toString() {
        return "HttpClientBase{CONF=" + this.f643a + '}';
    }
}
