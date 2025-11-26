package com.sec.common.widget;

import android.util.SparseArray;
import android.view.View;

/* compiled from: IcsAbsSpinner.java */
/* renamed from: com.sec.common.widget.b */
/* loaded from: classes.dex */
class C5057b {

    /* renamed from: a */
    final /* synthetic */ IcsAbsSpinner f18492a;

    /* renamed from: b */
    private final SparseArray<View> f18493b = new SparseArray<>();

    C5057b(IcsAbsSpinner icsAbsSpinner) {
        this.f18492a = icsAbsSpinner;
    }

    /* renamed from: a */
    public void m19278a(int i, View view) {
        this.f18493b.put(i, view);
    }

    /* renamed from: a */
    View m19276a(int i) {
        View view = this.f18493b.get(i);
        if (view != null) {
            this.f18493b.delete(i);
        }
        return view;
    }

    /* renamed from: a */
    void m19277a() {
        SparseArray<View> sparseArray = this.f18493b;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View viewValueAt = sparseArray.valueAt(i);
            if (viewValueAt != null) {
                this.f18492a.removeDetachedView(viewValueAt, true);
            }
        }
        sparseArray.clear();
    }
}
