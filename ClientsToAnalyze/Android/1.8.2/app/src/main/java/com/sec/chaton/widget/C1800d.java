package com.sec.chaton.widget;

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
/* renamed from: com.sec.chaton.widget.d */
/* loaded from: classes.dex */
class C1800d extends ArrayAdapter {

    /* renamed from: a */
    private ArrayList f6489a;

    /* renamed from: b */
    private C1801e f6490b;

    public C1800d(Context context, int i, List list) {
        super(context, i, list);
        this.f6489a = new ArrayList();
        this.f6490b = new C1801e(null);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            m6133a((Preference) it.next());
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Preference preference = (Preference) getItem(i);
        this.f6490b = m6132a(preference, this.f6490b);
        if (Collections.binarySearch(this.f6489a, this.f6490b) < 0) {
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
        this.f6490b = m6132a((Preference) getItem(i), this.f6490b);
        int iBinarySearch = Collections.binarySearch(this.f6489a, this.f6490b);
        if (iBinarySearch < 0) {
            return -1;
        }
        return iBinarySearch;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return Math.max(1, this.f6489a.size());
    }

    /* renamed from: a */
    private C1801e m6132a(Preference preference, C1801e c1801e) {
        if (c1801e == null) {
            c1801e = new C1801e(null);
        }
        c1801e.f6493c = preference.getClass().getName();
        c1801e.f6491a = preference.getLayoutResource();
        c1801e.f6492b = preference.getWidgetLayoutResource();
        return c1801e;
    }

    /* renamed from: a */
    private void m6133a(Preference preference) {
        C1801e c1801eM6132a = m6132a(preference, null);
        if (Collections.binarySearch(this.f6489a, c1801eM6132a) < 0) {
            this.f6489a.add((r1 * (-1)) - 1, c1801eM6132a);
        }
    }
}
