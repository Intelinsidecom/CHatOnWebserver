package com.sec.chaton.poston;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.widget.SelectableImageView;

/* compiled from: PostONAdapter.java */
/* renamed from: com.sec.chaton.poston.l */
/* loaded from: classes.dex */
public class C3017l {

    /* renamed from: a */
    public SelectableImageView f11166a;

    /* renamed from: b */
    public TextView f11167b;

    /* renamed from: c */
    public TextView f11168c;

    /* renamed from: d */
    public TextView f11169d;

    /* renamed from: e */
    public ViewGroup f11170e;

    /* renamed from: f */
    public TextView f11171f;

    /* renamed from: g */
    public RelativeLayout f11172g;

    /* renamed from: h */
    public RelativeLayout f11173h;

    /* renamed from: i */
    public ImageView f11174i;

    /* renamed from: j */
    public FrameLayout f11175j;

    /* renamed from: k */
    public TextView f11176k;

    /* renamed from: l */
    public FrameLayout f11177l;

    /* renamed from: m */
    public FrameLayout f11178m;

    /* renamed from: n */
    public ImageView f11179n;

    /* renamed from: o */
    public ImageView f11180o;

    public C3017l(ViewGroup viewGroup) {
        this.f11170e = viewGroup;
        this.f11166a = (SelectableImageView) this.f11170e.findViewById(R.id.image1);
        this.f11167b = (TextView) this.f11170e.findViewById(R.id.text1);
        this.f11169d = (TextView) this.f11170e.findViewById(R.id.text3);
        this.f11168c = (TextView) this.f11170e.findViewById(R.id.text4);
        this.f11171f = (TextView) this.f11170e.findViewById(R.id.text6);
        this.f11174i = (ImageView) this.f11170e.findViewById(R.id.image2);
        this.f11177l = (FrameLayout) this.f11170e.findViewById(R.id.space2);
        this.f11174i.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f11172g = (RelativeLayout) this.f11170e.findViewById(R.id.content_layout);
        this.f11173h = (RelativeLayout) this.f11170e.findViewById(R.id.comment_layout);
        this.f11175j = (FrameLayout) this.f11170e.findViewById(R.id.space1);
        this.f11176k = (TextView) this.f11170e.findViewById(R.id.location);
        this.f11179n = (ImageView) this.f11170e.findViewById(R.id.image4);
        this.f11168c.setAutoLinkMask(15);
        this.f11180o = (ImageView) this.f11170e.findViewById(R.id.image5);
        this.f11178m = (FrameLayout) this.f11170e.findViewById(R.id.image_layout);
        if (C4822an.m18218a()) {
            this.f11178m.setBackgroundResource(R.drawable.circle_background);
            this.f11166a.setSelector(R.drawable.circle_selector);
        }
    }
}
