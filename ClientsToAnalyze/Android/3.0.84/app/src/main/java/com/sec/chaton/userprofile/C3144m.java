package com.sec.chaton.userprofile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.sec.chaton.poston.C1960a;
import com.sec.chaton.util.C3159aa;
import com.sec.common.p069e.C3326c;
import java.util.ArrayList;

/* compiled from: CoverStorySampleAdapter.java */
/* renamed from: com.sec.chaton.userprofile.m */
/* loaded from: classes.dex */
public class C3144m extends BaseAdapter {

    /* renamed from: a */
    private ArrayList<C3147p> f11400a;

    /* renamed from: b */
    private LayoutInflater f11401b;

    /* renamed from: c */
    private int f11402c;

    /* renamed from: d */
    private C3326c f11403d;

    /* renamed from: e */
    private Context f11404e;

    /* renamed from: f */
    private String f11405f;

    /* renamed from: g */
    private InterfaceC3146o f11406g;

    /* renamed from: a */
    public void m10934a(InterfaceC3146o interfaceC3146o) {
        this.f11406g = interfaceC3146o;
    }

    public C3144m(Context context, int i, ArrayList<C3147p> arrayList, C3326c c3326c) {
        this.f11400a = arrayList;
        this.f11402c = i;
        this.f11403d = c3326c;
        this.f11401b = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f11404e = context;
        this.f11405f = context.getApplicationContext().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/coverstory/thumb/";
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f11400a.size();
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C3147p getItem(int i) {
        return this.f11400a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C3148q c3148q;
        if (view == null) {
            View viewInflate = this.f11401b.inflate(this.f11402c, viewGroup, false);
            C3148q c3148q2 = new C3148q((FrameLayout) viewInflate);
            c3148q2.f11414c.setFocusable(true);
            c3148q2.f11414c.setClickable(true);
            c3148q2.f11414c.setOnClickListener(new ViewOnClickListenerC3145n(this, i));
            c3148q = c3148q2;
            view = viewInflate;
        } else {
            c3148q = (C3148q) view.getTag();
        }
        c3148q.f11413b.setScaleType(ImageView.ScaleType.FIT_XY);
        c3148q.f11415d.setVisibility(8);
        if (C3159aa.m10962a().m10979a("coverstory_contentid", "").compareTo(this.f11400a.get(i).f11409a) == 0) {
            c3148q.f11415d.setVisibility(0);
        } else {
            c3148q.f11415d.setVisibility(8);
        }
        this.f11403d.m11730a(c3148q.f11413b, new C1960a(this.f11400a.get(i).f11410b, null, C1960a.f7635a, this.f11404e, this.f11405f, this.f11400a.get(i).f11411c, this.f11400a.get(i).f11409a));
        view.setTag(c3148q);
        return view;
    }
}
