package com.sec.chaton.multimedia.vcard;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ContactStruct.java */
/* renamed from: com.sec.chaton.multimedia.vcard.b */
/* loaded from: classes.dex */
public class C2897b {

    /* renamed from: a */
    public String f10712a;

    /* renamed from: b */
    public String f10713b;

    /* renamed from: c */
    public String f10714c;

    /* renamed from: d */
    public String f10715d;

    /* renamed from: e */
    public String f10716e;

    /* renamed from: f */
    public List<C2901f> f10717f;

    /* renamed from: g */
    public List<C2899d> f10718g;

    /* renamed from: h */
    public List<C2902g> f10719h;

    /* renamed from: i */
    public List<C2900e> f10720i;

    /* renamed from: j */
    public List<C2898c> f10721j;

    /* renamed from: a */
    public void m12091a(int i, String str, String str2, boolean z) {
        if (this.f10717f == null) {
            this.f10717f = new ArrayList();
        }
        this.f10717f.add(new C2901f(i, str.trim(), str2, z));
    }

    /* renamed from: b */
    public void m12092b(int i, String str, String str2, boolean z) {
        if (this.f10718g == null) {
            this.f10718g = new ArrayList();
        }
        this.f10718g.add(new C2899d(i, str, str2, z));
    }
}
