package com.sec.common.widget;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;

/* compiled from: IcsSpinner.java */
/* renamed from: com.sec.common.widget.r */
/* loaded from: classes.dex */
class C5073r implements ListAdapter, SpinnerAdapter {

    /* renamed from: a */
    private SpinnerAdapter f18507a;

    /* renamed from: b */
    private ListAdapter f18508b;

    private C5073r(SpinnerAdapter spinnerAdapter) {
        this.f18507a = spinnerAdapter;
        if (spinnerAdapter instanceof ListAdapter) {
            this.f18508b = (ListAdapter) spinnerAdapter;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f18507a == null) {
            return 0;
        }
        return this.f18507a.getCount();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.f18507a == null) {
            return null;
        }
        return this.f18507a.getItem(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.f18507a == null) {
            return -1L;
        }
        return this.f18507a.getItemId(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getDropDownView(i, view, viewGroup);
    }

    @Override // android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (this.f18507a == null) {
            return null;
        }
        return this.f18507a.getDropDownView(i, view, viewGroup);
    }

    @Override // android.widget.Adapter
    public boolean hasStableIds() {
        return this.f18507a != null && this.f18507a.hasStableIds();
    }

    @Override // android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.f18507a != null) {
            this.f18507a.registerDataSetObserver(dataSetObserver);
        }
    }

    @Override // android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.f18507a != null) {
            this.f18507a.unregisterDataSetObserver(dataSetObserver);
        }
    }

    @Override // android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        ListAdapter listAdapter = this.f18508b;
        if (listAdapter != null) {
            return listAdapter.areAllItemsEnabled();
        }
        return true;
    }

    @Override // android.widget.ListAdapter
    public boolean isEnabled(int i) {
        ListAdapter listAdapter = this.f18508b;
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
