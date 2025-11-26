package com.sec.widget;

import android.content.Context;
import android.preference.Preference;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: PreferenceListFragment.java */
/* renamed from: com.sec.widget.ae */
/* loaded from: classes.dex */
class C5142ae extends ArrayAdapter<Preference> {

    /* renamed from: a */
    private ArrayList<C5143af> f18833a;

    /* renamed from: b */
    private C5143af f18834b;

    public C5142ae(Context context, int i, List<Preference> list) {
        super(context, i, list);
        this.f18833a = new ArrayList<>();
        this.f18834b = new C5143af();
        Iterator<Preference> it = list.iterator();
        while (it.hasNext()) {
            m19704a(it.next());
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Preference item = getItem(i);
        this.f18834b = m19703a(item, this.f18834b);
        if (Collections.binarySearch(this.f18833a, this.f18834b) < 0) {
            view = null;
        }
        return item.getView(view, viewGroup);
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (i < 0 || i >= getCount()) {
            return true;
        }
        return getItem(i).isSelectable();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        this.f18834b = m19703a(getItem(i), this.f18834b);
        int iBinarySearch = Collections.binarySearch(this.f18833a, this.f18834b);
        if (iBinarySearch < 0) {
            return -1;
        }
        return iBinarySearch;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return Math.max(1, this.f18833a.size());
    }

    /* renamed from: a */
    private C5143af m19703a(Preference preference, C5143af c5143af) {
        if (c5143af == null) {
            c5143af = new C5143af();
        }
        c5143af.f18837c = preference.getClass().getName();
        c5143af.f18835a = preference.getLayoutResource();
        c5143af.f18836b = preference.getWidgetLayoutResource();
        return c5143af;
    }

    /* renamed from: a */
    private void m19704a(Preference preference) {
        C5143af c5143afM19703a = m19703a(preference, null);
        if (Collections.binarySearch(this.f18833a, c5143afM19703a) < 0) {
            this.f18833a.add((r1 * (-1)) - 1, c5143afM19703a);
        }
    }
}
