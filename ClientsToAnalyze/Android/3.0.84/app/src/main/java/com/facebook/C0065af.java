package com.facebook;

/* compiled from: FacebookServiceException.java */
/* renamed from: com.facebook.af */
/* loaded from: classes.dex */
public class C0065af extends C0180y {

    /* renamed from: a */
    private final C0061ab f94a;

    public C0065af(C0061ab c0061ab, String str) {
        super(str);
        this.f94a = c0061ab;
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return "{FacebookServiceException: httpResponseCode: " + this.f94a.m112a() + ", facebookErrorCode: " + this.f94a.m113b() + ", facebookErrorType: " + this.f94a.m114c() + ", message: " + this.f94a.m115d() + "}";
    }
}
