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
/* renamed from: com.sec.widget.aj */
/* loaded from: classes.dex */
class C1613aj extends ArrayAdapter {

    /* renamed from: a */
    private ArrayList f5707a;

    /* renamed from: b */
    private C1605ab f5708b;

    public C1613aj(Context context, int i, List list) {
        super(context, i, list);
        this.f5707a = new ArrayList();
        this.f5708b = new C1605ab();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            m5887a((Preference) it.next());
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Preference preference = (Preference) getItem(i);
        this.f5708b = m5886a(preference, this.f5708b);
        if (Collections.binarySearch(this.f5707a, this.f5708b) < 0) {
            view = null;
        }
        return preference.getView(view, viewGroup);
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (i < 0 || i >= getCount()) {
            return true;
        }
        return ((Preference) getItem(i)).isSelectable();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        this.f5708b = m5886a((Preference) getItem(i), this.f5708b);
        int iBinarySearch = Collections.binarySearch(this.f5707a, this.f5708b);
        if (iBinarySearch < 0) {
            return -1;
        }
        return iBinarySearch;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return Math.max(1, this.f5707a.size());
    }

    /* renamed from: a */
    private C1605ab m5886a(Preference preference, C1605ab c1605ab) {
        if (c1605ab == null) {
            c1605ab = new C1605ab();
        }
        c1605ab.f5697c = preference.getClass().getName();
        c1605ab.f5695a = preference.getLayoutResource();
        c1605ab.f5696b = preference.getWidgetLayoutResource();
        return c1605ab;
    }

    /* renamed from: a */
    private void m5887a(Preference preference) {
        C1605ab c1605abM5886a = m5886a(preference, null);
        if (Collections.binarySearch(this.f5707a, c1605abM5886a) < 0) {
            this.f5707a.add((r1 * (-1)) - 1, c1605abM5886a);
        }
    }
}
