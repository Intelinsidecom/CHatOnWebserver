package android.support.v4.widget;

import android.database.DataSetObserver;

/* renamed from: android.support.v4.widget.c */
/* loaded from: classes.dex */
class C0045c extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ CursorAdapter f188a;

    private C0045c(CursorAdapter cursorAdapter) {
        this.f188a = cursorAdapter;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        this.f188a.mDataValid = true;
        this.f188a.notifyDataSetChanged();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.f188a.mDataValid = false;
        this.f188a.notifyDataSetInvalidated();
    }
}
