package p021c.p022a;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

/* compiled from: HttpClient.java */
/* renamed from: c.a.d */
/* loaded from: classes.dex */
class C0329d extends Authenticator {

    /* renamed from: a */
    final /* synthetic */ C0328c f747a;

    C0329d(C0328c c0328c) {
        this.f747a = c0328c;
    }

    @Override // java.net.Authenticator
    protected PasswordAuthentication getPasswordAuthentication() {
        if (getRequestorType().equals(Authenticator.RequestorType.PROXY)) {
            return new PasswordAuthentication(this.f747a.f734i, this.f747a.f735j.toCharArray());
        }
        return null;
    }
}
