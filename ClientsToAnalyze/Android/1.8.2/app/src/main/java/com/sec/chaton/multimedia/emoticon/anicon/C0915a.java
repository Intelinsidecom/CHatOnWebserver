package com.sec.chaton.multimedia.emoticon.anicon;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.common.p056b.p059c.C1821b;

/* compiled from: AniconAdapter.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.a */
/* loaded from: classes.dex */
public class C0915a extends CursorAdapter {

    /* renamed from: a */
    private int f3454a;

    /* renamed from: b */
    private int f3455b;

    /* renamed from: c */
    private C1821b f3456c;

    public C0915a(Context context, Cursor cursor, int i, C1821b c1821b) {
        super(context, cursor, i);
        m3765a(c1821b);
    }

    /* renamed from: a */
    private void m3765a(C1821b c1821b) {
        Resources resources = this.mContext.getResources();
        this.f3456c = c1821b;
        this.f3454a = resources.getDimensionPixelOffset(R.dimen.anicon_gridview_item_width);
        this.f3455b = resources.getDimensionPixelOffset(R.dimen.anicon_gridview_item_height);
    }

    @Override // android.support.v4.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, this.f3455b);
        ImageView imageView = new ImageView(this.mContext);
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        return imageView;
    }

    @Override // android.support.v4.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        String string = cursor.getString(cursor.getColumnIndex("anicon_id"));
        if (string == String.valueOf(Integer.MIN_VALUE)) {
            this.f3456c.m6192a(view);
            ((ImageView) view).setImageResource(R.drawable.chatting_emotion_download);
            view.setTag(string);
        } else {
            CallableC0918ac callableC0918ac = new CallableC0918ac(string, this.f3454a, this.f3455b);
            callableC0918ac.m6172a(view);
            this.f3456c.m6190a(view, callableC0918ac);
        }
    }
}
