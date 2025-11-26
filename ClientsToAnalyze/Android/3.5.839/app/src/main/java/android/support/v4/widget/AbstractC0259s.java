package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: ResourceCursorAdapter.java */
/* renamed from: android.support.v4.widget.s */
/* loaded from: classes.dex */
public abstract class AbstractC0259s extends AbstractC0243c {

    /* renamed from: j */
    private int f598j;

    /* renamed from: k */
    private int f599k;

    /* renamed from: l */
    private LayoutInflater f600l;

    @Deprecated
    public AbstractC0259s(Context context, int i, Cursor cursor) {
        super(context, cursor);
        this.f599k = i;
        this.f598j = i;
        this.f600l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public AbstractC0259s(Context context, int i, Cursor cursor, int i2) {
        super(context, cursor, i2);
        this.f599k = i;
        this.f598j = i;
        this.f600l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // android.support.v4.widget.AbstractC0243c
    /* renamed from: a */
    public View mo873a(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f600l.inflate(this.f598j, viewGroup, false);
    }

    @Override // android.support.v4.widget.AbstractC0243c
    /* renamed from: b */
    public View mo878b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f600l.inflate(this.f599k, viewGroup, false);
    }
}
