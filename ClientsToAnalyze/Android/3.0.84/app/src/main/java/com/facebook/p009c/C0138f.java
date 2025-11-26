package com.facebook.p009c;

import java.net.URL;

/* compiled from: ImageDownloader.java */
/* renamed from: com.facebook.c.f */
/* loaded from: classes.dex */
class C0138f {

    /* renamed from: a */
    URL f312a;

    /* renamed from: b */
    Object f313b;

    C0138f(URL url, Object obj) {
        this.f312a = url;
        this.f313b = obj;
    }

    public int hashCode() {
        return ((this.f312a.hashCode() + 1073) * 37) + this.f313b.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C0138f)) {
            return false;
        }
        C0138f c0138f = (C0138f) obj;
        return c0138f.f312a == this.f312a && c0138f.f313b == this.f313b;
    }
}
