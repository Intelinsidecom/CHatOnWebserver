package com.sec.chaton.updates;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;

/* compiled from: UpdatesAdapter.java */
/* renamed from: com.sec.chaton.updates.h */
/* loaded from: classes.dex */
public class C4701h {

    /* renamed from: a */
    public ImageView f17041a;

    /* renamed from: b */
    public LinearLayout f17042b;

    /* renamed from: c */
    public LinearLayout f17043c;

    /* renamed from: d */
    public TextView f17044d;

    /* renamed from: e */
    public TextView f17045e;

    /* renamed from: f */
    public TextView f17046f;

    /* renamed from: g */
    public TextView f17047g;

    /* renamed from: h */
    public ImageView f17048h;

    /* renamed from: i */
    public ImageView f17049i;

    public C4701h(ViewGroup viewGroup) {
        this.f17041a = (ImageView) viewGroup.findViewById(R.id.image1);
        this.f17044d = (TextView) viewGroup.findViewById(R.id.text1);
        this.f17045e = (TextView) viewGroup.findViewById(R.id.text2);
        this.f17042b = (LinearLayout) viewGroup.findViewById(R.id.floor2);
        this.f17042b.setVisibility(8);
        this.f17048h = (ImageView) viewGroup.findViewById(R.id.icon1);
        this.f17049i = (ImageView) viewGroup.findViewById(R.id.icon2);
        this.f17043c = (LinearLayout) viewGroup.findViewById(R.id.floor3);
        this.f17043c.setVisibility(8);
        this.f17046f = (TextView) viewGroup.findViewById(R.id.text3);
        this.f17047g = (TextView) viewGroup.findViewById(R.id.text4);
    }
}
