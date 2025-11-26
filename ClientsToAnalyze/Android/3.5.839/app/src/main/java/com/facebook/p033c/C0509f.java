package com.facebook.p033c;

import java.net.URL;

/* compiled from: ImageDownloader.java */
/* renamed from: com.facebook.c.f */
/* loaded from: classes.dex */
class C0509f {

    /* renamed from: a */
    URL f1281a;

    /* renamed from: b */
    Object f1282b;

    C0509f(URL url, Object obj) {
        this.f1281a = url;
        this.f1282b = obj;
    }

    public int hashCode() {
        return ((this.f1281a.hashCode() + 1073) * 37) + this.f1282b.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C0509f)) {
            return false;
        }
        C0509f c0509f = (C0509f) obj;
        return c0509f.f1281a == this.f1281a && c0509f.f1282b == this.f1282b;
    }
}
