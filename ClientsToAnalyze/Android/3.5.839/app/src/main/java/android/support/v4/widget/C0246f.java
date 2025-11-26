package android.support.v4.widget;

import android.database.DataSetObserver;

/* compiled from: CursorAdapter.java */
/* renamed from: android.support.v4.widget.f */
/* loaded from: classes.dex */
class C0246f extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ AbstractC0243c f587a;

    private C0246f(AbstractC0243c abstractC0243c) {
        this.f587a = abstractC0243c;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        this.f587a.f577a = true;
        this.f587a.notifyDataSetChanged();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.f587a.f577a = false;
        this.f587a.notifyDataSetInvalidated();
    }
}
