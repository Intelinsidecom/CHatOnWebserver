package com.sec.chaton.userprofile;

import android.widget.FrameLayout;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: CoverStorySampleAdapter.java */
/* renamed from: com.sec.chaton.userprofile.q */
/* loaded from: classes.dex */
public class C3148q {

    /* renamed from: a */
    public FrameLayout f11412a;

    /* renamed from: b */
    public ImageView f11413b;

    /* renamed from: c */
    public FrameLayout f11414c;

    /* renamed from: d */
    public ImageView f11415d;

    /* renamed from: e */
    public ImageView f11416e;

    /* renamed from: f */
    public ImageView f11417f;

    public C3148q(FrameLayout frameLayout) {
        this.f11412a = frameLayout;
        if (GlobalApplication.m6456e()) {
            this.f11413b = (ImageView) this.f11412a.findViewById(R.id.sample_image_bg);
        } else {
            this.f11413b = (ImageView) this.f11412a.findViewById(R.id.profile_image_bg);
        }
        this.f11414c = (FrameLayout) this.f11412a.findViewById(R.id.profile_image_item_layout);
        this.f11415d = (ImageView) this.f11412a.findViewById(R.id.profile_image_selctor);
        this.f11416e = (ImageView) this.f11412a.findViewById(R.id.profile_image_select_layout);
        this.f11417f = (ImageView) this.f11412a.findViewById(R.id.profile_image_loading);
    }
}
