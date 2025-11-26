package com.sec.chaton.poston;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import com.sec.chaton.multimedia.image.C2844d;
import com.sec.chaton.multimedia.multisend.C2875i;
import com.sec.chaton.multimedia.multisend.PreviewData;
import com.sec.common.p132g.C5007c;
import java.util.ArrayList;

/* compiled from: PostONContentsAdapter.java */
/* renamed from: com.sec.chaton.poston.r */
/* loaded from: classes.dex */
public class C3023r extends BaseAdapter {

    /* renamed from: a */
    InterfaceC3026u f11201a;

    /* renamed from: b */
    private Context f11202b;

    /* renamed from: c */
    private ArrayList<PreviewData> f11203c;

    /* renamed from: d */
    private LayoutInflater f11204d;

    /* renamed from: e */
    private C5007c f11205e;

    /* renamed from: f */
    private int f11206f;

    /* renamed from: g */
    private boolean f11207g = false;

    /* renamed from: a */
    public void m12388a(InterfaceC3026u interfaceC3026u) {
        this.f11201a = interfaceC3026u;
    }

    /* renamed from: a */
    public void m12389a(boolean z) {
        this.f11207g = z;
    }

    public C3023r(Context context, int i, ArrayList<PreviewData> arrayList, C5007c c5007c) {
        this.f11202b = context;
        this.f11203c = arrayList;
        this.f11205e = c5007c;
        this.f11206f = i;
        this.f11204d = (LayoutInflater) this.f11202b.getSystemService("layout_inflater");
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PreviewData getItem(int i) {
        return this.f11203c.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C3027v c3027v;
        C2875i c2875i;
        PreviewData item = getItem(i);
        if (view == null) {
            View viewInflate = this.f11204d.inflate(this.f11206f, viewGroup, false);
            c3027v = new C3027v((RelativeLayout) viewInflate);
            view = viewInflate;
        } else {
            c3027v = (C3027v) view.getTag();
        }
        if (this.f11207g) {
            c3027v.f11215d = item.m11976a();
            this.f11205e.m19023b(c3027v.f11213b, new C2844d(c3027v.f11215d, c3027v.f11215d, false, false));
        } else {
            c3027v.f11215d = item.m11976a();
            c3027v.f11216e = item.m11978b();
            c3027v.f11217f = item.m11982d();
            c3027v.f11218g = item.m11983e();
            if (c3027v.f11217f == null) {
                c2875i = new C2875i(c3027v.f11215d, c3027v.f11216e, false, false, c3027v.f11218g, null, null);
            } else if (c3027v.f11216e == null) {
                c2875i = new C2875i(c3027v.f11217f, null, false, true, c3027v.f11218g, null, null);
            } else {
                c2875i = new C2875i(c3027v.f11217f, c3027v.f11216e, false, true, c3027v.f11218g, null, null);
            }
            this.f11205e.m19023b(c3027v.f11213b, c2875i);
            c3027v.f11213b.setOnClickListener(new ViewOnClickListenerC3024s(this, i));
        }
        c3027v.f11214c.setOnClickListener(new ViewOnClickListenerC3025t(this, i));
        view.setTag(c3027v);
        return view;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f11203c.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
