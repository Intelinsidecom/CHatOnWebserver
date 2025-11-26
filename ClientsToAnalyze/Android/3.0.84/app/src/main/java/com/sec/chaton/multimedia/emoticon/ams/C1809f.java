package com.sec.chaton.multimedia.emoticon.ams;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.common.p069e.C3326c;

/* compiled from: AmsRecentListAdapter.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.ams.f */
/* loaded from: classes.dex */
public class C1809f extends CursorAdapter {

    /* renamed from: a */
    private int f6749a;

    /* renamed from: b */
    private C3326c f6750b;

    public C1809f(Context context, Cursor cursor, int i, C3326c c3326c) {
        super(context, cursor, i);
        this.f6750b = c3326c;
        this.f6749a = context.getResources().getDimensionPixelOffset(R.dimen.theme_gridview_item_width);
    }

    @Override // android.support.v4.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(this.mContext);
        imageView.setLayoutParams(new AbsListView.LayoutParams(-1, this.f6749a));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setBackgroundResource(R.drawable.ams_item_border);
        return imageView;
    }

    @Override // android.support.v4.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        this.f6750b.m11730a(view, new C1808e(cursor.getString(cursor.getColumnIndex("ams_path"))));
    }
}
