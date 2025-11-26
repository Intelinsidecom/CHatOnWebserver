package android.support.v4.app;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/* renamed from: android.support.v4.app.j */
/* loaded from: classes.dex */
class C0009j implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ ListFragment f47a;

    C0009j(ListFragment listFragment) {
        this.f47a = listFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f47a.mo34a((ListView) adapterView, view, i, j);
    }
}
