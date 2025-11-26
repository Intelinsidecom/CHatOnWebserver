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
import com.sec.common.p132g.C5007c;
import com.sec.common.util.C5034k;
import java.util.ArrayList;

/* compiled from: GalleryAdapter.java */
/* renamed from: com.sec.chaton.multimedia.multisend.g */
/* loaded from: classes.dex */
class C2873g extends ArrayAdapter<C2877k> {

    /* renamed from: a */
    int f10571a;

    /* renamed from: b */
    private Context f10572b;

    /* renamed from: c */
    private LayoutInflater f10573c;

    /* renamed from: d */
    private C5007c f10574d;

    /* renamed from: e */
    private ArrayList<PreviewData> f10575e;

    /* renamed from: f */
    private int f10576f;

    public C2873g(Context context, int i, ArrayList<C2877k> arrayList, C5007c c5007c) {
        super(context, 0, arrayList);
        this.f10572b = context;
        this.f10574d = c5007c;
        this.f10571a = i;
        this.f10573c = (LayoutInflater) this.f10572b.getSystemService("layout_inflater");
        this.f10576f = ((WindowManager) GlobalApplication.m10279a().getSystemService("window")).getDefaultDisplay().getWidth();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C2874h c2874h;
        if (view == null) {
            view = this.f10573c.inflate(this.f10571a, (ViewGroup) null);
            C2874h c2874h2 = new C2874h();
            c2874h2.f10577a = (ImageView) view.findViewById(R.id.galleryThumbnail);
            c2874h2.f10578b = (TextView) view.findViewById(R.id.categoryName);
            c2874h2.f10579c = (TextView) view.findViewById(R.id.numberOfimages);
            view.setTag(c2874h2);
            c2874h = c2874h2;
        } else {
            c2874h = (C2874h) view.getTag();
        }
        C2877k item = getItem(i);
        c2874h.f10578b.setText(item.f10591a);
        c2874h.f10579c.setText("(" + item.f10592b + ")");
        c2874h.f10580d = (RelativeLayout) view.findViewById(R.id.countWidth);
        c2874h.f10578b.setMaxWidth((int) (this.f10576f - C5034k.m19088a(165.0f)));
        c2874h.f10581e = item.f10596f;
        this.f10574d.m19023b(c2874h.f10577a, new C2875i(item.f10593c, item.f10594d, true, false, c2874h.f10581e, null, null));
        return view;
    }

    /* renamed from: a */
    void m12007a(ArrayList<PreviewData> arrayList) {
        this.f10575e = arrayList;
    }

    /* renamed from: a */
    public void m12006a() {
        if (this.f10575e != null && !this.f10575e.isEmpty()) {
            this.f10575e.clear();
        }
    }
}
