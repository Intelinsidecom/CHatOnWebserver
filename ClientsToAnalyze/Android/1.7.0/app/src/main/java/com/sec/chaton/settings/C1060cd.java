package com.sec.chaton.settings;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.util.C1341p;

/* compiled from: FragmentSkinChange2.java */
/* renamed from: com.sec.chaton.settings.cd */
/* loaded from: classes.dex */
class C1060cd extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ FragmentSkinChange2 f3703a;

    /* renamed from: b */
    private String[] f3704b;

    /* renamed from: c */
    private LayoutInflater f3705c;

    public C1060cd(FragmentSkinChange2 fragmentSkinChange2, Context context, String[] strArr) {
        this.f3703a = fragmentSkinChange2;
        this.f3704b = strArr;
        this.f3705c = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    /* renamed from: a */
    public void m3952a(String[] strArr) {
        this.f3704b = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f3704b.length;
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String getItem(int i) {
        if (i < this.f3704b.length) {
            return this.f3704b[i];
        }
        C1341p.m4651a("array index is out of bound", getClass().getSimpleName());
        return "";
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f3705c.inflate(R.layout.item_skin_bg, viewGroup, false);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.skin_bg);
        imageView.setImageDrawable(this.f3703a.m3863b(getItem(i)));
        if (getItem(i).equals(this.f3703a.f3545j)) {
            imageView.setSelected(true);
            imageView.setBackgroundDrawable(this.f3703a.getResources().getDrawable(R.drawable.thumb_skin_bg_frame_press));
        } else {
            imageView.setSelected(false);
        }
        return view;
    }
}
