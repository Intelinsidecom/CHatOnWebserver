package com.sec.common.widget;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;

/* compiled from: IcsSpinner.java */
/* renamed from: com.sec.common.widget.u */
/* loaded from: classes.dex */
class C3388u implements ListAdapter, SpinnerAdapter {

    /* renamed from: a */
    private SpinnerAdapter f12261a;

    /* renamed from: b */
    private ListAdapter f12262b;

    public C3388u(SpinnerAdapter spinnerAdapter) {
        this.f12261a = spinnerAdapter;
        if (spinnerAdapter instanceof ListAdapter) {
            this.f12262b = (ListAdapter) spinnerAdapter;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f12261a == null) {
            return 0;
        }
        return this.f12261a.getCount();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.f12261a == null) {
            return null;
        }
        return this.f12261a.getItem(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.f12261a == null) {
            return -1L;
        }
        return this.f12261a.getItemId(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getDropDownView(i, view, viewGroup);
    }

    @Override // android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (this.f12261a == null) {
            return null;
        }
        return this.f12261a.getDropDownView(i, view, viewGroup);
    }

    @Override // android.widget.Adapter
    public boolean hasStableIds() {
        return this.f12261a != null && this.f12261a.hasStableIds();
    }

    @Override // android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.f12261a != null) {
            this.f12261a.registerDataSetObserver(dataSetObserver);
        }
    }

    @Override // android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.f12261a != null) {
            this.f12261a.unregisterDataSetObserver(dataSetObserver);
        }
    }

    @Override // android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        ListAdapter listAdapter = this.f12262b;
        if (listAdapter != null) {
            return listAdapter.areAllItemsEnabled();
        }
        return true;
    }

    @Override // android.widget.ListAdapter
    public boolean isEnabled(int i) {
        ListAdapter listAdapter = this.f12262b;
        if (listAdapter != null) {
            return listAdapter.isEnabled(i);
        }
        return true;
    }

    @Override // android.widget.Adapter
    public int getItemViewType(int i) {
        return 0;
    }

    @Override // android.widget.Adapter
    public int getViewTypeCount() {
        return 1;
    }

    @Override // android.widget.Adapter
    public boolean isEmpty() {
        return getCount() == 0;
    }
}
