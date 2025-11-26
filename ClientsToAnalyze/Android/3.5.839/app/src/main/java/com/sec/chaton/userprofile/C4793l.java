package com.sec.chaton.userprofile;

import android.widget.FrameLayout;
import android.widget.ImageView;
import com.sec.chaton.R;

/* compiled from: CoverStorySampleAdapter.java */
/* renamed from: com.sec.chaton.userprofile.l */
/* loaded from: classes.dex */
public class C4793l {

    /* renamed from: a */
    public FrameLayout f17521a;

    /* renamed from: b */
    public ImageView f17522b;

    /* renamed from: c */
    public FrameLayout f17523c;

    /* renamed from: d */
    public ImageView f17524d;

    /* renamed from: e */
    public ImageView f17525e;

    /* renamed from: f */
    public ImageView f17526f;

    public C4793l(FrameLayout frameLayout) {
        this.f17521a = frameLayout;
        this.f17522b = (ImageView) this.f17521a.findViewById(R.id.profile_image_bg);
        this.f17523c = (FrameLayout) this.f17521a.findViewById(R.id.profile_image_item_layout);
        this.f17524d = (ImageView) this.f17521a.findViewById(R.id.profile_image_selctor);
        this.f17525e = (ImageView) this.f17521a.findViewById(R.id.profile_image_select_layout);
        this.f17526f = (ImageView) this.f17521a.findViewById(R.id.profile_image_loading);
    }
}
