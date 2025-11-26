package com.sec.chaton.userprofile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.sec.chaton.poston.C2955a;
import com.sec.chaton.util.C4809aa;
import com.sec.common.p132g.C5007c;
import java.util.ArrayList;

/* compiled from: CoverStorySampleAdapter.java */
/* renamed from: com.sec.chaton.userprofile.h */
/* loaded from: classes.dex */
public class C4789h extends BaseAdapter {

    /* renamed from: a */
    private ArrayList<C4792k> f17509a;

    /* renamed from: b */
    private LayoutInflater f17510b;

    /* renamed from: c */
    private int f17511c;

    /* renamed from: d */
    private C5007c f17512d;

    /* renamed from: e */
    private Context f17513e;

    /* renamed from: f */
    private String f17514f;

    /* renamed from: g */
    private InterfaceC4791j f17515g;

    /* renamed from: a */
    public void m18082a(InterfaceC4791j interfaceC4791j) {
        this.f17515g = interfaceC4791j;
    }

    public C4789h(Context context, int i, ArrayList<C4792k> arrayList, C5007c c5007c) {
        this.f17509a = arrayList;
        this.f17511c = i;
        this.f17512d = c5007c;
        this.f17510b = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f17513e = context;
        this.f17514f = context.getApplicationContext().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/coverstory/thumb/";
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f17509a.size();
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C4792k getItem(int i) {
        return this.f17509a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C4793l c4793l;
        if (view == null) {
            View viewInflate = this.f17510b.inflate(this.f17511c, viewGroup, false);
            C4793l c4793l2 = new C4793l((FrameLayout) viewInflate);
            c4793l2.f17523c.setFocusable(true);
            c4793l2.f17523c.setClickable(true);
            c4793l2.f17523c.setOnClickListener(new ViewOnClickListenerC4790i(this, i));
            c4793l = c4793l2;
            view = viewInflate;
        } else {
            c4793l = (C4793l) view.getTag();
        }
        c4793l.f17522b.setScaleType(ImageView.ScaleType.FIT_XY);
        c4793l.f17524d.setVisibility(8);
        if (C4809aa.m18104a().m18121a("coverstory_contentid", "").compareTo(this.f17509a.get(i).f17518a) == 0) {
            c4793l.f17524d.setVisibility(0);
        } else {
            c4793l.f17524d.setVisibility(8);
        }
        this.f17512d.m19023b(c4793l.f17522b, new C2955a(this.f17509a.get(i).f17519b, null, C2955a.f11032a, this.f17513e, this.f17514f, this.f17509a.get(i).f17520c, this.f17509a.get(i).f17518a));
        view.setTag(c4793l);
        return view;
    }
}
