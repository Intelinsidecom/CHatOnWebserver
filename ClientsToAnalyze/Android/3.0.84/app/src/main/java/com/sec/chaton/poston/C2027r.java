package com.sec.chaton.poston;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import com.sec.chaton.multimedia.image.C1874c;
import com.sec.chaton.multimedia.multisend.C1906i;
import com.sec.chaton.multimedia.multisend.PreviewData;
import com.sec.common.p069e.C3326c;
import java.util.ArrayList;

/* compiled from: PostONContentsAdapter.java */
/* renamed from: com.sec.chaton.poston.r */
/* loaded from: classes.dex */
public class C2027r extends BaseAdapter {

    /* renamed from: a */
    InterfaceC2030u f7803a;

    /* renamed from: b */
    private Context f7804b;

    /* renamed from: c */
    private ArrayList<PreviewData> f7805c;

    /* renamed from: d */
    private LayoutInflater f7806d;

    /* renamed from: e */
    private C3326c f7807e;

    /* renamed from: f */
    private int f7808f;

    /* renamed from: g */
    private boolean f7809g = false;

    /* renamed from: a */
    public void m8068a(InterfaceC2030u interfaceC2030u) {
        this.f7803a = interfaceC2030u;
    }

    /* renamed from: a */
    public void m8069a(boolean z) {
        this.f7809g = z;
    }

    public C2027r(Context context, int i, ArrayList<PreviewData> arrayList, C3326c c3326c) {
        this.f7804b = context;
        this.f7805c = arrayList;
        this.f7807e = c3326c;
        this.f7808f = i;
        this.f7806d = (LayoutInflater) this.f7804b.getSystemService("layout_inflater");
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PreviewData getItem(int i) {
        return this.f7805c.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C2031v c2031v;
        C1906i c1906i;
        PreviewData item = getItem(i);
        if (view == null) {
            View viewInflate = this.f7806d.inflate(this.f7808f, viewGroup, false);
            c2031v = new C2031v((RelativeLayout) viewInflate);
            view = viewInflate;
        } else {
            c2031v = (C2031v) view.getTag();
        }
        if (this.f7809g) {
            c2031v.f7817d = item.m7746a();
            this.f7807e.m11730a(c2031v.f7815b, new C1874c(c2031v.f7817d, c2031v.f7817d, false, false));
        } else {
            c2031v.f7817d = item.m7746a();
            c2031v.f7818e = item.m7748b();
            c2031v.f7819f = item.m7752d();
            c2031v.f7820g = item.m7753e();
            if (c2031v.f7819f == null) {
                c1906i = new C1906i(c2031v.f7817d, c2031v.f7818e, false, false, c2031v.f7820g, null, null);
            } else if (c2031v.f7818e == null) {
                c1906i = new C1906i(c2031v.f7819f, null, false, true, c2031v.f7820g, null, null);
            } else {
                c1906i = new C1906i(c2031v.f7819f, c2031v.f7818e, false, true, c2031v.f7820g, null, null);
            }
            this.f7807e.m11730a(c2031v.f7815b, c1906i);
            c2031v.f7815b.setOnClickListener(new ViewOnClickListenerC2028s(this, i));
        }
        c2031v.f7816c.setOnClickListener(new ViewOnClickListenerC2029t(this, i));
        view.setTag(c2031v);
        return view;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f7805c.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
