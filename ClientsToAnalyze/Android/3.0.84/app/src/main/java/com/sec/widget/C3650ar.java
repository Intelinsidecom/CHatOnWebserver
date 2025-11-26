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
/* renamed from: com.sec.widget.ar */
/* loaded from: classes.dex */
class C3650ar extends ArrayAdapter<Preference> {

    /* renamed from: a */
    private ArrayList<C3651as> f13526a;

    /* renamed from: b */
    private C3651as f13527b;

    public C3650ar(Context context, int i, List<Preference> list) {
        super(context, i, list);
        this.f13526a = new ArrayList<>();
        this.f13527b = new C3651as();
        Iterator<Preference> it = list.iterator();
        while (it.hasNext()) {
            m13214a(it.next());
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Preference item = getItem(i);
        this.f13527b = m13213a(item, this.f13527b);
        if (Collections.binarySearch(this.f13526a, this.f13527b) < 0) {
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
        this.f13527b = m13213a(getItem(i), this.f13527b);
        int iBinarySearch = Collections.binarySearch(this.f13526a, this.f13527b);
        if (iBinarySearch < 0) {
            return -1;
        }
        return iBinarySearch;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return Math.max(1, this.f13526a.size());
    }

    /* renamed from: a */
    private C3651as m13213a(Preference preference, C3651as c3651as) {
        if (c3651as == null) {
            c3651as = new C3651as();
        }
        c3651as.f13530c = preference.getClass().getName();
        c3651as.f13528a = preference.getLayoutResource();
        c3651as.f13529b = preference.getWidgetLayoutResource();
        return c3651as;
    }

    /* renamed from: a */
    private void m13214a(Preference preference) {
        C3651as c3651asM13213a = m13213a(preference, null);
        if (Collections.binarySearch(this.f13526a, c3651asM13213a) < 0) {
            this.f13526a.add((r1 * (-1)) - 1, c3651asM13213a);
        }
    }
}
