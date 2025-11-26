package p010b.p014d.p015a;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

/* compiled from: HttpClientImpl.java */
/* renamed from: b.d.a.g */
/* loaded from: classes.dex */
class C0292g extends Authenticator {

    /* renamed from: a */
    final /* synthetic */ C0291f f648a;

    C0292g(C0291f c0291f) {
        this.f648a = c0291f;
    }

    @Override // java.net.Authenticator
    protected PasswordAuthentication getPasswordAuthentication() {
        if (getRequestorType().equals(Authenticator.RequestorType.PROXY)) {
            return new PasswordAuthentication(this.f648a.f643a.m997o(), this.f648a.f643a.m998p().toCharArray());
        }
        return null;
    }
}
