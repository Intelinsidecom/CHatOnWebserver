package com.sec.chaton.multimedia.emoticon;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.sec.chaton.multimedia.emoticon.EmoticonUsage;
import com.sec.chaton.util.Dip;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class EmoticonAdapter extends BaseAdapter {

    /* renamed from: a */
    private Context f2119a;

    /* renamed from: b */
    private int f2120b;

    /* renamed from: c */
    private int f2121c;

    /* renamed from: d */
    private int f2122d = (int) Dip.m3571a(37.0f);

    /* renamed from: e */
    private List f2123e;

    /* renamed from: f */
    private EmoticonUsageManager f2124f;

    public EmoticonAdapter(Context context, int i, EmoticonUsageManager emoticonUsageManager, int i2) {
        this.f2120b = -1;
        this.f2123e = new ArrayList();
        this.f2119a = context;
        this.f2121c = i2;
        this.f2124f = emoticonUsageManager;
        this.f2123e = this.f2124f.m2515a();
        if (i < 0 || i >= RichString.f2135c.length) {
            return;
        }
        this.f2120b = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f2120b > -1) {
            if (this.f2121c != 1) {
                return this.f2124f.m2518c();
            }
            if (this.f2124f.m2518c() > 7) {
                return 7;
            }
            this.f2124f.m2518c();
        }
        return this.f2124f.m2518c();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f2120b > -1 ? Integer.valueOf(RichString.m2527b(RichString.f2135c[this.f2120b][i])) : Integer.valueOf(RichString.m2527b(i));
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.f2120b > -1 ? RichString.f2135c[this.f2120b][i] : i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView;
        if (view == null) {
            imageView = new ImageView(this.f2119a);
            imageView.setLayoutParams(new AbsListView.LayoutParams(this.f2122d, this.f2122d));
            imageView.setAdjustViewBounds(false);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(9, 0, 9, 0);
        } else {
            imageView = (ImageView) view;
        }
        if (this.f2124f.m2518c() != 0 && this.f2123e.size() > i) {
            imageView.setImageResource(((EmoticonUsage.EmoticonUsageItem) this.f2123e.get(i)).f2127b);
        }
        return imageView;
    }
}
