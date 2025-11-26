package com.sec.widget;

/* compiled from: PreferenceListFragment.java */
/* renamed from: com.sec.widget.as */
/* loaded from: classes.dex */
class C3651as implements Comparable<C3651as> {

    /* renamed from: a */
    private int f13528a;

    /* renamed from: b */
    private int f13529b;

    /* renamed from: c */
    private String f13530c;

    private C3651as() {
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C3651as c3651as) {
        int iCompareTo = this.f13530c.compareTo(c3651as.f13530c);
        if (iCompareTo == 0) {
            if (this.f13528a == c3651as.f13528a) {
                if (this.f13529b == c3651as.f13529b) {
                    return 0;
                }
                return this.f13529b - c3651as.f13529b;
            }
            return this.f13528a - c3651as.f13528a;
        }
        return iCompareTo;
    }
}
