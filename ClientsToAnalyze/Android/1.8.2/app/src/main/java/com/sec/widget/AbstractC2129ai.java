package com.sec.widget;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: SeparatorCursorAdapter.java */
/* renamed from: com.sec.widget.ai */
/* loaded from: classes.dex */
public abstract class AbstractC2129ai extends SimpleCursorAdapter {

    /* renamed from: a */
    private ArrayList f7771a;

    /* renamed from: b */
    private ArrayList f7772b;

    /* renamed from: c */
    private String f7773c;

    /* renamed from: a */
    protected abstract View mo2410a(int i, int i2, View view, ViewGroup viewGroup);

    public AbstractC2129ai(Context context, int i, Cursor cursor, String str) throws IllegalArgumentException {
        super(context, i, cursor, new String[0], new int[0], 2);
        this.f7771a = new ArrayList();
        this.f7772b = new ArrayList();
        this.f7773c = str;
        m7482a();
    }

    /* renamed from: a */
    private void m7482a() throws IllegalArgumentException {
        Cursor cursor = this.mCursor;
        this.f7771a.clear();
        this.f7772b.clear();
        if (cursor != null && cursor.getCount() != 0) {
            cursor.moveToLast();
            int columnIndexOrThrow = cursor.getColumnIndexOrThrow(this.f7773c);
            int i = cursor.getInt(columnIndexOrThrow);
            int i2 = i + 1;
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                int i3 = cursor.getInt(columnIndexOrThrow);
                if (i2 != i3) {
                    this.f7771a.add(Integer.valueOf(cursor.getPosition() + this.f7771a.size()));
                    this.f7772b.add(Integer.valueOf(i3));
                    if (i3 == i) {
                        return;
                    }
                }
                i2 = i3;
            }
        }
    }

    /* renamed from: b */
    private int m7483b(int i) {
        int iBinarySearch = Collections.binarySearch(this.f7771a, Integer.valueOf(i));
        return iBinarySearch < 0 ? iBinarySearch + i + 1 : (-iBinarySearch) - 1;
    }

    @Override // android.support.v4.widget.CursorAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int iIntValue;
        int iM7483b = m7483b(i);
        if (iM7483b < 0) {
            int i2 = (-iM7483b) - 1;
            int iIntValue2 = ((Integer) this.f7772b.get(i2)).intValue();
            if (i2 == this.f7771a.size() - 1) {
                iIntValue = (getCount() - ((Integer) this.f7771a.get(i2)).intValue()) - 1;
            } else {
                iIntValue = (((Integer) this.f7771a.get(i2 + 1)).intValue() - ((Integer) this.f7771a.get(i2)).intValue()) - 1;
            }
            return mo2410a(iIntValue2, iIntValue, view, viewGroup);
        }
        return super.getView(iM7483b, view, viewGroup);
    }

    @Override // android.support.v4.widget.CursorAdapter, android.widget.Adapter
    public int getCount() {
        return super.getCount() + this.f7771a.size();
    }

    @Override // android.support.v4.widget.CursorAdapter, android.widget.Adapter
    public Object getItem(int i) {
        int iM7483b = m7483b(i);
        if (iM7483b < 0) {
            return null;
        }
        return super.getItem(iM7483b);
    }

    @Override // android.support.v4.widget.CursorAdapter, android.widget.Adapter
    public long getItemId(int i) {
        int iM7483b = m7483b(i);
        if (iM7483b < 0) {
            return -1L;
        }
        return super.getItemId(iM7483b);
    }

    @Override // android.support.v4.widget.SimpleCursorAdapter, android.support.v4.widget.CursorAdapter
    public Cursor swapCursor(Cursor cursor) throws IllegalArgumentException {
        Cursor cursorSwapCursor = super.swapCursor(cursor);
        m7482a();
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
        return m7484a(i) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    /* renamed from: a */
    public boolean m7484a(int i) {
        return m7483b(i) < 0;
    }

    @Override // android.support.v4.widget.CursorAdapter, android.support.v4.widget.CursorFilter.CursorFilterClient
    public Cursor getCursor() {
        return this.mCursor;
    }
}
