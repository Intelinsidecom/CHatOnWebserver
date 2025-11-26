package com.sec.chaton.settings.theme;

import android.util.SparseArray;
import android.view.View;

/* renamed from: com.sec.chaton.settings.theme.g */
/* loaded from: classes.dex */
class C0516g {

    /* renamed from: a */
    final /* synthetic */ CarouselSpinner f3293a;

    /* renamed from: b */
    private final SparseArray f3294b = new SparseArray();

    C0516g(CarouselSpinner carouselSpinner) {
        this.f3293a = carouselSpinner;
    }

    /* renamed from: a */
    View m3285a(int i) {
        View view = (View) this.f3294b.get(i);
        if (view != null) {
            this.f3294b.delete(i);
        }
        return view;
    }

    /* renamed from: a */
    void m3286a() {
        SparseArray sparseArray = this.f3294b;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View view = (View) sparseArray.valueAt(i);
            if (view != null) {
                this.f3293a.removeDetachedView(view, true);
            }
        }
        sparseArray.clear();
    }

    /* renamed from: a */
    public void m3287a(int i, View view) {
        this.f3294b.put(i, view);
    }
}
