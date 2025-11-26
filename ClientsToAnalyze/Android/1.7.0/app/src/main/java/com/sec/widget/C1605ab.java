package com.sec.widget;

/* compiled from: PreferenceListFragment.java */
/* renamed from: com.sec.widget.ab */
/* loaded from: classes.dex */
class C1605ab implements Comparable {

    /* renamed from: a */
    private int f5695a;

    /* renamed from: b */
    private int f5696b;

    /* renamed from: c */
    private String f5697c;

    private C1605ab() {
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1605ab c1605ab) {
        int iCompareTo = this.f5697c.compareTo(c1605ab.f5697c);
        if (iCompareTo == 0) {
            if (this.f5695a == c1605ab.f5695a) {
                if (this.f5696b == c1605ab.f5696b) {
                    return 0;
                }
                return this.f5696b - c1605ab.f5696b;
            }
            return this.f5695a - c1605ab.f5695a;
        }
        return iCompareTo;
    }
}
