package com.sec.chaton.multimedia.doc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.sec.common.p069e.C3326c;
import java.util.ArrayList;

/* compiled from: FileListAdapter.java */
/* renamed from: com.sec.chaton.multimedia.doc.g */
/* loaded from: classes.dex */
public class C1800g extends BaseAdapter {

    /* renamed from: a */
    private Context f6681a;

    /* renamed from: b */
    private LayoutInflater f6682b;

    /* renamed from: c */
    private int f6683c;

    /* renamed from: d */
    private ArrayList<C1799f> f6684d;

    /* renamed from: e */
    private C3326c f6685e;

    public C1800g(Context context, int i, ArrayList<C1799f> arrayList, C3326c c3326c) {
        this.f6681a = context;
        this.f6682b = (LayoutInflater) this.f6681a.getSystemService("layout_inflater");
        this.f6684d = arrayList;
        this.f6683c = i;
        this.f6685e = c3326c;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f6684d.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f6684d.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1801h c1801h;
        if (view == null) {
            view = this.f6682b.inflate(this.f6683c, viewGroup, false);
            C1801h c1801h2 = new C1801h(view);
            view.setTag(c1801h2);
            c1801h = c1801h2;
        } else {
            c1801h = (C1801h) view.getTag();
        }
        C1799f c1799f = this.f6684d.get(i);
        this.f6685e.m11730a(c1801h.f6686a, new C1798e(c1799f.m7422e(), c1799f));
        c1801h.f6687b.setText(c1799f.m7417b());
        c1801h.f6688c.setText(c1799f.m7421d() + "  " + c1799f.m7420c());
        if (c1799f.m7412a() == EnumC1794a.DIRECTORY) {
            c1801h.f6688c.setVisibility(8);
        } else {
            c1801h.f6688c.setVisibility(0);
        }
        return view;
    }
}
