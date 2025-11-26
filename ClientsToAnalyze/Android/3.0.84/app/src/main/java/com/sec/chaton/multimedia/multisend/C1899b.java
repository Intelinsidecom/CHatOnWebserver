package com.sec.chaton.multimedia.multisend;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.common.p069e.C3326c;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: CategoryAdapter.java */
/* renamed from: com.sec.chaton.multimedia.multisend.b */
/* loaded from: classes.dex */
class C1899b extends ArrayAdapter<C1902e> {

    /* renamed from: a */
    int f7234a;

    /* renamed from: b */
    private Context f7235b;

    /* renamed from: c */
    private LayoutInflater f7236c;

    /* renamed from: d */
    private C3326c f7237d;

    /* renamed from: e */
    private HashMap<String, String> f7238e;

    public C1899b(Context context, int i, ArrayList<C1902e> arrayList, C3326c c3326c, HashMap<String, String> map) {
        super(context, 0, arrayList);
        this.f7235b = context;
        this.f7237d = c3326c;
        this.f7234a = i;
        this.f7238e = map;
        this.f7236c = (LayoutInflater) this.f7235b.getSystemService("layout_inflater");
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1900c c1900c;
        if (view == null) {
            view = this.f7236c.inflate(this.f7234a, (ViewGroup) null);
            C1900c c1900c2 = new C1900c();
            c1900c2.f7239a = (ImageView) view.findViewById(R.id.dimId);
            c1900c2.f7240b = (ImageView) view.findViewById(R.id.thumbnailCategory);
            c1900c2.f7241c = (CheckBox) view.findViewById(R.id.smiCheck);
            view.setTag(c1900c2);
            c1900c = c1900c2;
        } else {
            c1900c = (C1900c) view.getTag();
        }
        C1902e item = getItem(i);
        c1900c.f7242d = item.f7246a;
        c1900c.f7243e = item.f7247b;
        c1900c.f7244f = item.f7248c;
        this.f7237d.m11730a(c1900c.f7240b, new C1906i(item.f7246a, item.f7247b, false, false, c1900c.f7244f, c1900c.f7241c, c1900c.f7239a));
        m7774a(c1900c);
        return view;
    }

    /* renamed from: a */
    private void m7774a(C1900c c1900c) {
        if (!TextUtils.isEmpty(c1900c.f7242d)) {
            if (!this.f7238e.isEmpty() && this.f7238e.containsKey(c1900c.f7242d)) {
                c1900c.f7241c.setChecked(true);
            } else {
                c1900c.f7241c.setChecked(false);
            }
        }
    }

    /* renamed from: a */
    public void m7775a(C1900c c1900c, boolean z) {
        if (z) {
            this.f7238e.put(c1900c.f7242d, c1900c.f7243e);
        } else if (this.f7238e.containsKey(c1900c.f7242d)) {
            this.f7238e.remove(c1900c.f7242d);
        }
    }
}
