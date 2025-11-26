package com.sec.widget;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: SeparatorCursorAdapter.java */
/* renamed from: com.sec.widget.q */
/* loaded from: classes.dex */
public abstract class AbstractC1629q extends SimpleCursorAdapter {

    /* renamed from: a */
    private ArrayList f5747a;

    /* renamed from: b */
    private ArrayList f5748b;

    /* renamed from: c */
    private String f5749c;

    /* renamed from: a */
    protected abstract View mo2369a(int i, int i2, View view, ViewGroup viewGroup);

    public AbstractC1629q(Context context, int i, Cursor cursor, String str) throws IllegalArgumentException {
        super(context, i, cursor, new String[0], new int[0], 2);
        this.f5747a = new ArrayList();
        this.f5748b = new ArrayList();
        this.f5749c = str;
        m5912a();
    }

    /* renamed from: a */
    private void m5912a() throws IllegalArgumentException {
        Cursor cursor = this.mCursor;
        this.f5747a.clear();
        this.f5748b.clear();
        if (cursor != null && cursor.getCount() != 0) {
            cursor.moveToLast();
            int columnIndexOrThrow = cursor.getColumnIndexOrThrow(this.f5749c);
            int i = cursor.getInt(columnIndexOrThrow);
            int i2 = i + 1;
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                int i3 = cursor.getInt(columnIndexOrThrow);
                if (i2 != i3) {
                    this.f5747a.add(Integer.valueOf(cursor.getPosition() + this.f5747a.size()));
                    this.f5748b.add(Integer.valueOf(i3));
                    if (i3 == i) {
                        return;
                    }
                }
                i2 = i3;
            }
        }
    }

    /* renamed from: b */
    private int m5913b(int i) {
        int iBinarySearch = Collections.binarySearch(this.f5747a, Integer.valueOf(i));
        return iBinarySearch < 0 ? iBinarySearch + i + 1 : (-iBinarySearch) - 1;
    }

    @Override // android.support.v4.widget.CursorAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int iIntValue;
        int iM5913b = m5913b(i);
        if (iM5913b < 0) {
            int i2 = (-iM5913b) - 1;
            int iIntValue2 = ((Integer) this.f5748b.get(i2)).intValue();
            if (i2 == this.f5747a.size() - 1) {
                iIntValue = (getCount() - ((Integer) this.f5747a.get(i2)).intValue()) - 1;
            } else {
                iIntValue = (((Integer) this.f5747a.get(i2 + 1)).intValue() - ((Integer) this.f5747a.get(i2)).intValue()) - 1;
            }
            return mo2369a(iIntValue2, iIntValue, view, viewGroup);
        }
        return super.getView(iM5913b, view, viewGroup);
    }

    @Override // android.support.v4.widget.CursorAdapter, android.widget.Adapter
    public int getCount() {
        return super.getCount() + this.f5747a.size();
    }

    @Override // android.support.v4.widget.CursorAdapter, android.widget.Adapter
    public Object getItem(int i) {
        int iM5913b = m5913b(i);
        if (iM5913b < 0) {
            return null;
        }
        return super.getItem(iM5913b);
    }

    @Override // android.support.v4.widget.CursorAdapter, android.widget.Adapter
    public long getItemId(int i) {
        int iM5913b = m5913b(i);
        if (iM5913b < 0) {
            return -1L;
        }
        return super.getItemId(iM5913b);
    }

    @Override // android.support.v4.widget.SimpleCursorAdapter, android.support.v4.widget.CursorAdapter
    public Cursor swapCursor(Cursor cursor) throws IllegalArgumentException {
        Cursor cursorSwapCursor = super.swapCursor(cursor);
        m5912a();
        return cursorSwapCursor;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return super.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return true;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return m5914a(i) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    /* renamed from: a */
    public boolean m5914a(int i) {
        return m5913b(i) < 0;
    }
}
