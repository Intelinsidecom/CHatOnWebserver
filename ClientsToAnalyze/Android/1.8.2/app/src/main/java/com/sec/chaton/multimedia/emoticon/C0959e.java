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
class C0959e extends BaseAdapter {

    /* renamed from: a */
    private Context f3534a;

    /* renamed from: b */
    private String[] f3535b;

    C0959e(Context context, String[] strArr) {
        this.f3534a = context;
        this.f3535b = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f3535b.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(C0962h.m3818a(this.f3535b[i]));
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView = (ImageView) view;
        if (imageView == null) {
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, this.f3534a.getResources().getDimensionPixelOffset(R.dimen.emoticon_gridview_item_height));
            imageView = new ImageView(this.f3534a);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        }
        imageView.setImageResource(C0962h.m3818a(this.f3535b[i]));
        imageView.setTag(this.f3535b[i]);
        return imageView;
    }
}
