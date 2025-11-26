package com.sec.widget;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: SeparatorCursorAdapter.java */
/* renamed from: com.sec.widget.ax */
/* loaded from: classes.dex */
public abstract class AbstractC3656ax extends SimpleCursorAdapter {

    /* renamed from: a */
    private ArrayList<Integer> f13537a;

    /* renamed from: b */
    private ArrayList<Integer> f13538b;

    /* renamed from: c */
    private String f13539c;

    /* renamed from: a */
    protected abstract View mo4350a(int i, int i2, View view, ViewGroup viewGroup);

    public AbstractC3656ax(Context context, int i, Cursor cursor, String str) throws IllegalArgumentException {
        super(context, i, cursor, new String[0], new int[0], 2);
        this.f13537a = new ArrayList<>();
        this.f13538b = new ArrayList<>();
        this.f13539c = str;
        m13222a();
    }

    /* renamed from: a */
    private void m13222a() throws IllegalArgumentException {
        Cursor cursor = this.mCursor;
        this.f13537a.clear();
        this.f13538b.clear();
        if (this.f13539c != null && cursor != null && cursor.getCount() != 0) {
            cursor.moveToLast();
            int columnIndexOrThrow = cursor.getColumnIndexOrThrow(this.f13539c);
            int i = cursor.getInt(columnIndexOrThrow);
            int i2 = i + 1;
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                int i3 = cursor.getInt(columnIndexOrThrow);
                if (i2 != i3) {
                    this.f13537a.add(Integer.valueOf(cursor.getPosition() + this.f13537a.size()));
                    this.f13538b.add(Integer.valueOf(i3));
                    if (i3 == i) {
                        return;
                    }
                }
                i2 = i3;
            }
        }
    }

    /* renamed from: b */
    private int m13223b(int i) {
        int iBinarySearch = Collections.binarySearch(this.f13537a, Integer.valueOf(i));
        return iBinarySearch < 0 ? iBinarySearch + i + 1 : (-iBinarySearch) - 1;
    }

    @Override // android.support.v4.widget.CursorAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int iIntValue;
        int iM13223b = m13223b(i);
        if (iM13223b < 0) {
            int i2 = (-iM13223b) - 1;
            int iIntValue2 = this.f13538b.get(i2).intValue();
            if (i2 == this.f13537a.size() - 1) {
                iIntValue = (getCount() - this.f13537a.get(i2).intValue()) - 1;
            } else {
                iIntValue = (this.f13537a.get(i2 + 1).intValue() - this.f13537a.get(i2).intValue()) - 1;
            }
            return mo4350a(iIntValue2, iIntValue, view, viewGroup);
        }
        return super.getView(iM13223b, view, viewGroup);
    }

    @Override // android.support.v4.widget.CursorAdapter, android.widget.Adapter
    public int getCount() {
        return super.getCount() + this.f13537a.size();
    }

    @Override // android.support.v4.widget.CursorAdapter, android.widget.Adapter
    public Object getItem(int i) {
        int iM13223b = m13223b(i);
        if (iM13223b < 0) {
            return null;
        }
        return super.getItem(iM13223b);
    }

    @Override // android.support.v4.widget.CursorAdapter, android.widget.Adapter
    public long getItemId(int i) {
        int iM13223b = m13223b(i);
        if (iM13223b < 0) {
            return -1L;
        }
        return super.getItemId(iM13223b);
    }

    @Override // android.support.v4.widget.SimpleCursorAdapter, android.support.v4.widget.CursorAdapter
    public Cursor swapCursor(Cursor cursor) throws IllegalArgumentException {
        Cursor cursorSwapCursor = super.swapCursor(cursor);
        m13222a();
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
        return m13224a(i) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    /* renamed from: a */
    public boolean m13224a(int i) {
        return m13223b(i) < 0;
    }
}
