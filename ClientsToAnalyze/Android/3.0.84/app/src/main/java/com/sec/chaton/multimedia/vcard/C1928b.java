package com.sec.chaton.multimedia.vcard;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ContactStruct.java */
/* renamed from: com.sec.chaton.multimedia.vcard.b */
/* loaded from: classes.dex */
public class C1928b {

    /* renamed from: a */
    public String f7391a;

    /* renamed from: b */
    public String f7392b;

    /* renamed from: c */
    public String f7393c;

    /* renamed from: d */
    public String f7394d;

    /* renamed from: e */
    public String f7395e;

    /* renamed from: f */
    public List<C1932f> f7396f;

    /* renamed from: g */
    public List<C1930d> f7397g;

    /* renamed from: h */
    public List<C1933g> f7398h;

    /* renamed from: i */
    public List<C1931e> f7399i;

    /* renamed from: j */
    public List<C1929c> f7400j;

    /* renamed from: a */
    public void m7864a(int i, String str, String str2, boolean z) {
        if (this.f7396f == null) {
            this.f7396f = new ArrayList();
        }
        this.f7396f.add(new C1932f(i, str.trim(), str2, z));
    }

    /* renamed from: b */
    public void m7865b(int i, String str, String str2, boolean z) {
        if (this.f7397g == null) {
            this.f7397g = new ArrayList();
        }
        this.f7397g.add(new C1930d(i, str, str2, z));
    }
}
