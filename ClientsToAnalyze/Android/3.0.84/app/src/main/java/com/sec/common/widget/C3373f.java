package com.sec.common.widget;

import android.util.SparseArray;
import android.view.View;

/* compiled from: IcsAbsSpinner.java */
/* renamed from: com.sec.common.widget.f */
/* loaded from: classes.dex */
class C3373f {

    /* renamed from: a */
    final /* synthetic */ IcsAbsSpinner f12246a;

    /* renamed from: b */
    private final SparseArray<View> f12247b = new SparseArray<>();

    C3373f(IcsAbsSpinner icsAbsSpinner) {
        this.f12246a = icsAbsSpinner;
    }

    /* renamed from: a */
    public void m11956a(int i, View view) {
        this.f12247b.put(i, view);
    }

    /* renamed from: a */
    View m11954a(int i) {
        View view = this.f12247b.get(i);
        if (view != null) {
            this.f12247b.delete(i);
        }
        return view;
    }

    /* renamed from: a */
    void m11955a() {
        SparseArray<View> sparseArray = this.f12247b;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View viewValueAt = sparseArray.valueAt(i);
            if (viewValueAt != null) {
                this.f12246a.removeDetachedView(viewValueAt, true);
            }
        }
        sparseArray.clear();
    }
}
