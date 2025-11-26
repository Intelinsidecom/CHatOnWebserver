package com.sec.chaton.multimedia.emoticon;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.sec.chaton.R;

/* compiled from: EmoticonAdapter.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.e */
/* loaded from: classes.dex */
class C1830e extends BaseAdapter {

    /* renamed from: a */
    private Context f6819a;

    /* renamed from: b */
    private String[] f6820b;

    C1830e(Context context, String[] strArr) {
        this.f6819a = context;
        this.f6820b = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f6820b.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(C1833h.m7503a(this.f6820b[i]));
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView = (ImageView) view;
        if (imageView == null) {
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, this.f6819a.getResources().getDimensionPixelOffset(R.dimen.emoticon_gridview_item_height));
            imageView = new ImageView(this.f6819a);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        }
        imageView.setImageResource(C1833h.m7503a(this.f6820b[i]));
        imageView.setTag(this.f6820b[i]);
        return imageView;
    }
}
