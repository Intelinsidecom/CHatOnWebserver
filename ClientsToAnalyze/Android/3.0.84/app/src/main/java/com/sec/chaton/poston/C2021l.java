package com.sec.chaton.poston;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.R;

/* compiled from: PostONAdapter.java */
/* renamed from: com.sec.chaton.poston.l */
/* loaded from: classes.dex */
public class C2021l {

    /* renamed from: a */
    public ImageView f7770a;

    /* renamed from: b */
    public TextView f7771b;

    /* renamed from: c */
    public TextView f7772c;

    /* renamed from: d */
    public TextView f7773d;

    /* renamed from: e */
    public ViewGroup f7774e;

    /* renamed from: f */
    public TextView f7775f;

    /* renamed from: g */
    public RelativeLayout f7776g;

    /* renamed from: h */
    public RelativeLayout f7777h;

    /* renamed from: i */
    public ImageView f7778i;

    /* renamed from: j */
    public FrameLayout f7779j;

    /* renamed from: k */
    public TextView f7780k;

    /* renamed from: l */
    public FrameLayout f7781l;

    /* renamed from: m */
    public ImageView f7782m;

    /* renamed from: n */
    public ImageView f7783n;

    public C2021l(ViewGroup viewGroup) {
        this.f7774e = viewGroup;
        this.f7770a = (ImageView) this.f7774e.findViewById(R.id.image1);
        this.f7771b = (TextView) this.f7774e.findViewById(R.id.text1);
        this.f7773d = (TextView) this.f7774e.findViewById(R.id.text3);
        this.f7772c = (TextView) this.f7774e.findViewById(R.id.text4);
        this.f7775f = (TextView) this.f7774e.findViewById(R.id.text6);
        this.f7778i = (ImageView) this.f7774e.findViewById(R.id.image2);
        this.f7781l = (FrameLayout) this.f7774e.findViewById(R.id.space2);
        this.f7778i.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f7776g = (RelativeLayout) this.f7774e.findViewById(R.id.content_layout);
        this.f7777h = (RelativeLayout) this.f7774e.findViewById(R.id.comment_layout);
        this.f7779j = (FrameLayout) this.f7774e.findViewById(R.id.space1);
        this.f7780k = (TextView) this.f7774e.findViewById(R.id.location);
        this.f7782m = (ImageView) this.f7774e.findViewById(R.id.image4);
        this.f7772c.setAutoLinkMask(15);
        this.f7783n = (ImageView) this.f7774e.findViewById(R.id.image5);
    }
}
