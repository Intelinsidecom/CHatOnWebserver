package com.sec.chaton.multimedia.p034a;

import java.io.Serializable;

/* compiled from: EmoticonUsage.java */
/* renamed from: com.sec.chaton.multimedia.a.e */
/* loaded from: classes.dex */
public class C0762e implements Serializable, Comparable {

    /* renamed from: a */
    public String f2595a;

    /* renamed from: b */
    public int f2596b;

    /* renamed from: c */
    public long f2597c;

    /* renamed from: d */
    final /* synthetic */ C0761d f2598d;

    public C0762e(C0761d c0761d, String str, int i, long j) {
        this.f2598d = c0761d;
        this.f2595a = str;
        this.f2596b = i;
        this.f2597c = j;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C0762e c0762e) {
        long j = this.f2597c;
        if (j > c0762e.f2597c) {
            return -1;
        }
        if (j < c0762e.f2597c) {
            return 1;
        }
        return 0;
    }
}
