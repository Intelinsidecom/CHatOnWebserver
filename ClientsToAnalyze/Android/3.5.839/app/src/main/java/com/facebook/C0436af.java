package com.facebook;

/* compiled from: FacebookServiceException.java */
/* renamed from: com.facebook.af */
/* loaded from: classes.dex */
public class C0436af extends C0551y {

    /* renamed from: a */
    private final C0432ab f1063a;

    public C0436af(C0432ab c0432ab, String str) {
        super(str);
        this.f1063a = c0432ab;
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return "{FacebookServiceException: httpResponseCode: " + this.f1063a.m1556b() + ", facebookErrorCode: " + this.f1063a.m1557c() + ", facebookErrorType: " + this.f1063a.m1558d() + ", message: " + this.f1063a.m1559e() + "}";
    }
}
