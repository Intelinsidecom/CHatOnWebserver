package com.sec.chaton.settings.moreapps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.C0429ag;
import com.sec.chaton.PlusFragment;
import com.sec.chaton.R;
import com.sec.chaton.trunk.p061c.C3025f;
import com.sec.chaton.util.C3250y;
import com.sec.common.p069e.C3326c;
import java.net.MalformedURLException;
import java.util.ArrayList;

/* compiled from: MoreAppsAdapter.java */
/* renamed from: com.sec.chaton.settings.moreapps.a */
/* loaded from: classes.dex */
public class C2710a extends ArrayAdapter<C0429ag> {

    /* renamed from: a */
    private static final String f10018a = C2710a.class.getSimpleName();

    /* renamed from: b */
    private Context f10019b;

    /* renamed from: c */
    private LayoutInflater f10020c;

    /* renamed from: d */
    private C3326c f10021d;

    public C2710a(Context context, PlusFragment plusFragment, ArrayList<C0429ag> arrayList, C3326c c3326c) {
        super(context, 0, arrayList);
        this.f10019b = context;
        this.f10021d = c3326c;
        this.f10020c = (LayoutInflater) this.f10019b.getSystemService("layout_inflater");
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C2712b c2712b;
        if (view == null) {
            view = this.f10020c.inflate(R.layout.layout_moreapps_item, viewGroup, false);
            c2712b = new C2712b();
            c2712b.f10022a = (ImageView) view.findViewById(R.id.imgItem);
            c2712b.f10023b = (TextView) view.findViewById(R.id.txtItem);
            c2712b.f10024c = (ImageView) view.findViewById(R.id.imgDownload);
            c2712b.f10025d = (FrameLayout) view.findViewById(R.id.imagelayout);
            view.setTag(c2712b);
        } else {
            c2712b = (C2712b) view.getTag();
        }
        C0429ag item = getItem(i);
        c2712b.f10023b.setText(item.f1487c);
        m9701a(c2712b, item);
        return view;
    }

    /* renamed from: a */
    private void m9701a(C2712b c2712b, C0429ag c0429ag) {
        try {
            C3025f.m10538a(c0429ag.f1488d);
            this.f10021d.m11730a(c2712b.f10025d, new CallableC2713c(c0429ag.f1488d, this.f10019b, c0429ag.f1489e, c2712b));
        } catch (MalformedURLException e) {
            C3250y.m11442a("MoreAppsAdapter.ExtractFileNameFromUrl", f10018a);
            C3250y.m11443a(e, f10018a);
        }
    }
}
