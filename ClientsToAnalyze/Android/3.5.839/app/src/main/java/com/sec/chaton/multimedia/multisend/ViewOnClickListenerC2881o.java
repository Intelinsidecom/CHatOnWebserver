package com.sec.chaton.multimedia.multisend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.common.p132g.C5007c;
import java.util.ArrayList;

/* compiled from: PreviewPageAdapter.java */
/* renamed from: com.sec.chaton.multimedia.multisend.o */
/* loaded from: classes.dex */
class ViewOnClickListenerC2881o extends ArrayAdapter<PreviewData> implements View.OnClickListener {

    /* renamed from: a */
    int f10598a;

    /* renamed from: b */
    private Context f10599b;

    /* renamed from: c */
    private LayoutInflater f10600c;

    /* renamed from: d */
    private C5007c f10601d;

    /* renamed from: e */
    private InterfaceC2882p f10602e;

    public ViewOnClickListenerC2881o(Context context, int i, ArrayList<PreviewData> arrayList, C5007c c5007c, PreviewPageView previewPageView) {
        super(context, 0, arrayList);
        this.f10599b = context;
        this.f10601d = c5007c;
        this.f10598a = i;
        this.f10600c = (LayoutInflater) this.f10599b.getSystemService("layout_inflater");
        this.f10602e = previewPageView;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C2883q c2883q;
        C2875i c2875i;
        if (view == null) {
            view = this.f10600c.inflate(this.f10598a, (ViewGroup) null);
            C2883q c2883q2 = new C2883q();
            c2883q2.f10603a = (ImageView) view.findViewById(R.id.thumbnailPreivew);
            c2883q2.f10604b = (ImageView) view.findViewById(R.id.deleteCheck);
            c2883q2.f10604b.setOnClickListener(this);
            view.setTag(c2883q2);
            c2883q = c2883q2;
        } else {
            c2883q = (C2883q) view.getTag();
        }
        PreviewData item = getItem(i);
        c2883q.f10605c = item.m11976a();
        c2883q.f10606d = item.m11978b();
        c2883q.f10607e = item.m11982d();
        c2883q.f10608f = item.m11983e();
        if (c2883q.f10607e == null) {
            c2875i = new C2875i(c2883q.f10605c, c2883q.f10606d, false, false, c2883q.f10608f, null, null);
        } else {
            c2875i = new C2875i(c2883q.f10607e, c2883q.f10606d, false, true, c2883q.f10608f, null, null);
        }
        this.f10601d.m19023b(c2883q.f10603a, c2875i);
        c2883q.f10604b.setTag(c2883q);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f10602e.mo12000a(((C2883q) view.getTag()).f10605c);
    }
}
