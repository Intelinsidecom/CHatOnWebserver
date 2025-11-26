package com.sec.chaton.multimedia.doc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.sec.common.p132g.C5007c;
import java.util.ArrayList;

/* compiled from: FileListAdapter.java */
/* renamed from: com.sec.chaton.multimedia.doc.h */
/* loaded from: classes.dex */
public class C2764h extends BaseAdapter {

    /* renamed from: a */
    private Context f9973a;

    /* renamed from: b */
    private LayoutInflater f9974b;

    /* renamed from: c */
    private int f9975c;

    /* renamed from: d */
    private ArrayList<C2763g> f9976d;

    /* renamed from: e */
    private C5007c f9977e;

    /* renamed from: a */
    public static C2764h m11618a(Context context, int i, ArrayList<C2763g> arrayList, C5007c c5007c) {
        return new C2764h(context, i, arrayList, c5007c);
    }

    private C2764h(Context context, int i, ArrayList<C2763g> arrayList, C5007c c5007c) {
        this.f9973a = context;
        this.f9974b = (LayoutInflater) this.f9973a.getSystemService("layout_inflater");
        this.f9976d = arrayList;
        this.f9975c = i;
        this.f9977e = c5007c;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f9976d.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f9976d.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C2765i c2765i;
        if (view == null) {
            view = this.f9974b.inflate(this.f9975c, viewGroup, false);
            C2765i c2765i2 = new C2765i(view);
            view.setTag(c2765i2);
            c2765i = c2765i2;
        } else {
            c2765i = (C2765i) view.getTag();
        }
        C2763g c2763g = this.f9976d.get(i);
        this.f9977e.m19023b(c2765i.f9978a, new C2762f(c2763g.m11616e(), c2763g));
        c2765i.f9979b.setText(c2763g.m11611b());
        c2765i.f9980c.setText(c2763g.m11615d() + "  " + c2763g.m11614c());
        if (c2763g.m11606a() == EnumC2758b.DIRECTORY) {
            c2765i.f9980c.setVisibility(8);
        } else {
            c2765i.f9980c.setVisibility(0);
        }
        return view;
    }
}
