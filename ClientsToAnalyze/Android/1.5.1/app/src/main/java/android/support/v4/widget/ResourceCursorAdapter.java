package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class ResourceCursorAdapter extends CursorAdapter {

    /* renamed from: a */
    private int f178a;

    /* renamed from: b */
    private int f179b;

    /* renamed from: c */
    private LayoutInflater f180c;

    public ResourceCursorAdapter(Context context, int i, Cursor cursor, int i2) {
        super(context, cursor, i2);
        this.f179b = i;
        this.f178a = i;
        this.f180c = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // android.support.v4.widget.CursorAdapter
    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f180c.inflate(this.f179b, viewGroup, false);
    }

    @Override // android.support.v4.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f180c.inflate(this.f178a, viewGroup, false);
    }
}
