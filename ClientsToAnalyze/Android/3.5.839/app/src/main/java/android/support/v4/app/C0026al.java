package android.support.v4.app;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/* compiled from: ListFragment.java */
/* renamed from: android.support.v4.app.al */
/* loaded from: classes.dex */
class C0026al implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ ListFragment f106a;

    C0026al(ListFragment listFragment) {
        this.f106a = listFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f106a.mo62a((ListView) adapterView, view, i, j);
    }
}
