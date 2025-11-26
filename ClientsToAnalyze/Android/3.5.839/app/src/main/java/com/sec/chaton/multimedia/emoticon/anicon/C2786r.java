package com.sec.chaton.multimedia.emoticon.anicon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.p055d.C2131l;
import com.sec.common.p132g.C5007c;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: DynamicAdapter.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.r */
/* loaded from: classes.dex */
public class C2786r extends ArrayAdapter<Object> {

    /* renamed from: a */
    final int f10082a;

    /* renamed from: b */
    HashMap<C2785q, Integer> f10083b;

    /* renamed from: c */
    LayoutInflater f10084c;

    /* renamed from: d */
    C5007c f10085d;

    /* renamed from: e */
    C2131l f10086e;

    /* renamed from: f */
    int f10087f;

    /* renamed from: g */
    Context f10088g;

    public C2786r(Context context, int i, ArrayList<Object> arrayList, C5007c c5007c, C2131l c2131l) {
        super(context, i, arrayList);
        this.f10082a = -1;
        this.f10083b = new HashMap<>();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < arrayList.size()) {
                this.f10083b.put((C2785q) arrayList.get(i3), Integer.valueOf(i3));
                i2 = i3 + 1;
            } else {
                this.f10087f = i;
                this.f10088g = context;
                this.f10084c = (LayoutInflater) context.getSystemService("layout_inflater");
                this.f10085d = c5007c;
                this.f10086e = c2131l;
                return;
            }
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C2787s c2787s;
        if (view == null) {
            view = this.f10084c.inflate(this.f10087f, (ViewGroup) null);
            c2787s = new C2787s(this);
            c2787s.f10090b = (ImageView) view.findViewById(R.id.image1);
            c2787s.f10091c = (TextView) view.findViewById(R.id.text1);
            view.setTag(c2787s);
        } else {
            c2787s = (C2787s) view.getTag();
        }
        C2785q c2785q = (C2785q) getItem(i);
        c2787s.f10091c.setText(c2785q.f10081c);
        this.f10085d.m19023b(c2787s.f10090b, new C2779k(c2785q.f10079a, c2785q.f10080b, this.f10086e));
        return view;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int i) {
        if (i < 0 || i >= this.f10083b.size()) {
            return -1L;
        }
        return this.f10083b.get((C2785q) getItem(i)).intValue();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }
}
