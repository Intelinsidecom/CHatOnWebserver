package com.sec.chaton.widget;

/* compiled from: PreferenceListFragment.java */
/* renamed from: com.sec.chaton.widget.e */
/* loaded from: classes.dex */
class C1801e implements Comparable {

    /* renamed from: a */
    private int f6491a;

    /* renamed from: b */
    private int f6492b;

    /* renamed from: c */
    private String f6493c;

    private C1801e() {
    }

    /* synthetic */ C1801e(HandlerC1799c handlerC1799c) {
        this();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1801e c1801e) {
        int iCompareTo = this.f6493c.compareTo(c1801e.f6493c);
        if (iCompareTo == 0) {
            if (this.f6491a == c1801e.f6491a) {
                if (this.f6492b == c1801e.f6492b) {
                    return 0;
                }
                return this.f6492b - c1801e.f6492b;
            }
            return this.f6491a - c1801e.f6491a;
        }
        return iCompareTo;
    }
}
