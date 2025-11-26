package com.google.p034a;

import com.google.p034a.p036b.C0660w;
import java.util.Map;
import java.util.Set;

/* compiled from: JsonObject.java */
/* renamed from: com.google.a.w */
/* loaded from: classes.dex */
public final class C0689w extends AbstractC0686t {

    /* renamed from: a */
    private final C0660w<String, AbstractC0686t> f1624a = new C0660w<>();

    /* renamed from: a */
    public void m2190a(String str, AbstractC0686t abstractC0686t) {
        if (abstractC0686t == null) {
            abstractC0686t = C0688v.f1623a;
        }
        this.f1624a.put(str, abstractC0686t);
    }

    /* renamed from: o */
    public Set<Map.Entry<String, AbstractC0686t>> m2191o() {
        return this.f1624a.entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof C0689w) && ((C0689w) obj).f1624a.equals(this.f1624a));
    }

    public int hashCode() {
        return this.f1624a.hashCode();
    }
}
