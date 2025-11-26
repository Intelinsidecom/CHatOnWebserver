package com.sec.chaton.multimedia.multisend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3172an;
import com.sec.common.p069e.C3326c;
import java.util.ArrayList;

/* compiled from: GalleryAdapater.java */
/* renamed from: com.sec.chaton.multimedia.multisend.g */
/* loaded from: classes.dex */
class C1904g extends ArrayAdapter<C1908k> {

    /* renamed from: a */
    int f7250a;

    /* renamed from: b */
    private Context f7251b;

    /* renamed from: c */
    private LayoutInflater f7252c;

    /* renamed from: d */
    private C3326c f7253d;

    /* renamed from: e */
    private ArrayList<PreviewData> f7254e;

    /* renamed from: f */
    private int f7255f;

    public C1904g(Context context, int i, ArrayList<C1908k> arrayList, C3326c c3326c) {
        super(context, 0, arrayList);
        this.f7251b = context;
        this.f7253d = c3326c;
        this.f7250a = i;
        this.f7252c = (LayoutInflater) this.f7251b.getSystemService("layout_inflater");
        this.f7255f = ((WindowManager) GlobalApplication.m6447a().getSystemService("window")).getDefaultDisplay().getWidth();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1905h c1905h;
        if (view == null) {
            view = this.f7252c.inflate(this.f7250a, (ViewGroup) null);
            C1905h c1905h2 = new C1905h();
            c1905h2.f7256a = (ImageView) view.findViewById(R.id.galleryThumbnail);
            c1905h2.f7257b = (TextView) view.findViewById(R.id.categoryName);
            c1905h2.f7258c = (TextView) view.findViewById(R.id.numberOfimages);
            view.setTag(c1905h2);
            c1905h = c1905h2;
        } else {
            c1905h = (C1905h) view.getTag();
        }
        C1908k item = getItem(i);
        c1905h.f7257b.setText(item.f7270a);
        c1905h.f7258c.setText("(" + item.f7271b + ")");
        c1905h.f7259d = (RelativeLayout) view.findViewById(R.id.countWidth);
        c1905h.f7257b.setMaxWidth((int) (this.f7255f - C3172an.m11085a(165.0f)));
        c1905h.f7260e = item.f7275f;
        this.f7253d.m11730a(c1905h.f7256a, new C1906i(item.f7272c, item.f7273d, true, false, c1905h.f7260e, null, null));
        return view;
    }

    /* renamed from: a */
    void m7777a(ArrayList<PreviewData> arrayList) {
        this.f7254e = arrayList;
    }

    /* renamed from: a */
    public void m7776a() {
        if (this.f7254e != null && !this.f7254e.isEmpty()) {
            this.f7254e.clear();
        }
    }
}
