package com.sec.widget;

/* compiled from: PreferenceListFragment.java */
/* renamed from: com.sec.widget.af */
/* loaded from: classes.dex */
class C5143af implements Comparable<C5143af> {

    /* renamed from: a */
    private int f18835a;

    /* renamed from: b */
    private int f18836b;

    /* renamed from: c */
    private String f18837c;

    private C5143af() {
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C5143af c5143af) {
        int iCompareTo = this.f18837c.compareTo(c5143af.f18837c);
        if (iCompareTo == 0) {
            if (this.f18835a == c5143af.f18835a) {
                if (this.f18836b == c5143af.f18836b) {
                    return 0;
                }
                return this.f18836b - c5143af.f18836b;
            }
            return this.f18835a - c5143af.f18835a;
        }
        return iCompareTo;
    }
}
