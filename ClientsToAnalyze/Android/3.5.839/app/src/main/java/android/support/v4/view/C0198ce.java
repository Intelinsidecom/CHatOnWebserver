package android.support.v4.view;

import android.database.DataSetObserver;

/* compiled from: ViewPager.java */
/* renamed from: android.support.v4.view.ce */
/* loaded from: classes.dex */
class C0198ce extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ ViewPager f480a;

    private C0198ce(ViewPager viewPager) {
        this.f480a = viewPager;
    }

    /* synthetic */ C0198ce(ViewPager viewPager, C0188bv c0188bv) {
        this(viewPager);
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        this.f480a.m426d();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.f480a.m426d();
    }
}
