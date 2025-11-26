package com.sec.chaton.multimedia.multisend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.common.p069e.C3326c;
import java.util.ArrayList;

/* compiled from: PreviewPageAdapter.java */
/* renamed from: com.sec.chaton.multimedia.multisend.l */
/* loaded from: classes.dex */
class ViewOnClickListenerC1909l extends ArrayAdapter<PreviewData> implements View.OnClickListener {

    /* renamed from: a */
    int f7276a;

    /* renamed from: b */
    private Context f7277b;

    /* renamed from: c */
    private LayoutInflater f7278c;

    /* renamed from: d */
    private C3326c f7279d;

    /* renamed from: e */
    private InterfaceC1911n f7280e;

    public ViewOnClickListenerC1909l(Context context, int i, ArrayList<PreviewData> arrayList, C3326c c3326c, PreviewPageView previewPageView) {
        super(context, 0, arrayList);
        this.f7277b = context;
        this.f7279d = c3326c;
        this.f7276a = i;
        this.f7278c = (LayoutInflater) this.f7277b.getSystemService("layout_inflater");
        this.f7280e = previewPageView;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1910m c1910m;
        C1906i c1906i;
        if (view == null) {
            view = this.f7278c.inflate(this.f7276a, (ViewGroup) null);
            C1910m c1910m2 = new C1910m();
            c1910m2.f7281a = (ImageView) view.findViewById(R.id.thumbnailPreivew);
            c1910m2.f7282b = (ImageView) view.findViewById(R.id.deleteCheck);
            c1910m2.f7282b.setOnClickListener(this);
            view.setTag(c1910m2);
            c1910m = c1910m2;
        } else {
            c1910m = (C1910m) view.getTag();
        }
        PreviewData item = getItem(i);
        c1910m.f7283c = item.m7746a();
        c1910m.f7284d = item.m7748b();
        c1910m.f7285e = item.m7752d();
        c1910m.f7286f = item.m7753e();
        if (c1910m.f7285e == null) {
            c1906i = new C1906i(c1910m.f7283c, c1910m.f7284d, false, false, c1910m.f7286f, null, null);
        } else {
            c1906i = new C1906i(c1910m.f7285e, c1910m.f7284d, false, true, c1910m.f7286f, null, null);
        }
        this.f7279d.m11730a(c1910m.f7281a, c1906i);
        c1910m.f7282b.setTag(c1910m);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f7280e.mo7770a(((C1910m) view.getTag()).f7283c);
    }
}
