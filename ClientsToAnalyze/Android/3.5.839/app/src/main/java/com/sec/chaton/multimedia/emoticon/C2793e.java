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
public class C2793e extends BaseAdapter {

    /* renamed from: a */
    private Context f10105a;

    /* renamed from: b */
    private String[] f10106b;

    public C2793e(Context context, String[] strArr) {
        this.f10105a = context;
        this.f10106b = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f10106b.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(C2797i.m11704a(this.f10106b[i]));
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView = (ImageView) view;
        if (imageView == null) {
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, this.f10105a.getResources().getDimensionPixelOffset(R.dimen.emoticon_gridview_item_height));
            imageView = new ImageView(this.f10105a);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        }
        imageView.setImageResource(C2797i.m11704a(this.f10106b[i]));
        imageView.setTag(this.f10106b[i]);
        imageView.setContentDescription(this.f10105a.getResources().getStringArray(R.array.emoticon_talkback)[i]);
        return imageView;
    }
}
