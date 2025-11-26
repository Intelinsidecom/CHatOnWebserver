package com.sec.chaton.settings.moreapps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.C1501ce;
import com.sec.chaton.PlusFragment;
import com.sec.chaton.R;
import com.sec.chaton.trunk.p121c.C4641f;
import com.sec.chaton.util.C4904y;
import com.sec.common.p132g.C5007c;
import java.net.MalformedURLException;
import java.util.ArrayList;

/* compiled from: MoreAppsAdapter.java */
/* renamed from: com.sec.chaton.settings.moreapps.d */
/* loaded from: classes.dex */
public class C3672d extends ArrayAdapter<C1501ce> {

    /* renamed from: a */
    private static final String f13256a = C3672d.class.getSimpleName();

    /* renamed from: b */
    private Context f13257b;

    /* renamed from: c */
    private LayoutInflater f13258c;

    /* renamed from: d */
    private C5007c f13259d;

    public C3672d(Context context, PlusFragment plusFragment, ArrayList<C1501ce> arrayList, C5007c c5007c) {
        super(context, 0, arrayList);
        this.f13257b = context;
        this.f13259d = c5007c;
        this.f13258c = (LayoutInflater) this.f13257b.getSystemService("layout_inflater");
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C3673e c3673e;
        if (view == null) {
            view = this.f13258c.inflate(R.layout.layout_moreapps_item, viewGroup, false);
            c3673e = new C3673e();
            c3673e.f13260a = (ImageView) view.findViewById(R.id.imgItem);
            c3673e.f13261b = (TextView) view.findViewById(R.id.txtItem);
            c3673e.f13262c = (ImageView) view.findViewById(R.id.imgDownload);
            c3673e.f13263d = (FrameLayout) view.findViewById(R.id.imagelayout);
            view.setTag(c3673e);
        } else {
            c3673e = (C3673e) view.getTag();
        }
        C1501ce item = getItem(i);
        c3673e.f13261b.setText(item.f5435c);
        m13941a(c3673e, item);
        return view;
    }

    /* renamed from: a */
    private void m13941a(C3673e c3673e, C1501ce c1501ce) {
        try {
            C4641f.m17615a(c1501ce.f5436d);
            this.f13259d.m19023b(c3673e.f13263d, new CallableC3674f(c1501ce.f5436d, this.f13257b, c1501ce.f5437e, c3673e));
        } catch (MalformedURLException e) {
            C4904y.m18634a("MoreAppsAdapter.ExtractFileNameFromUrl", f13256a);
            C4904y.m18635a(e, f13256a);
        }
    }
}
