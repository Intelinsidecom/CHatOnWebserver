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
/* renamed from: com.sec.chaton.settings.b */
/* loaded from: classes.dex */
class C1029b extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ FragmentSkinChange2 f3630a;

    /* renamed from: b */
    private LayoutInflater f3631b;

    /* renamed from: c */
    private String[] f3632c;

    /* renamed from: d */
    private String f3633d;

    public C1029b(FragmentSkinChange2 fragmentSkinChange2, Context context, String[] strArr, String str) {
        this.f3630a = fragmentSkinChange2;
        this.f3631b = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f3632c = strArr;
        this.f3633d = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f3632c.length;
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String getItem(int i) {
        if (i < this.f3632c.length) {
            return this.f3632c[i];
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
            view = this.f3631b.inflate(R.layout.item_skin_bubble, viewGroup, false);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.skin_bubble);
        if (this.f3633d.equals("send_bubble")) {
            imageView.setImageDrawable(this.f3630a.getResources().getDrawable(this.f3630a.m3872e(getItem(i))));
        } else {
            imageView.setImageDrawable(this.f3630a.getResources().getDrawable(this.f3630a.m3876f(getItem(i))));
        }
        if (view.findViewById(R.id.skin_bubble_text) != null) {
        }
        if (getItem(i).equals(this.f3633d.equals("send_bubble") ? this.f3630a.f3546k : this.f3630a.f3547l)) {
            imageView.setSelected(true);
        } else {
            imageView.setSelected(false);
        }
        return view;
    }
}
