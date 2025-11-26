package com.sec.chaton.poston;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.sec.chaton.R;

/* compiled from: PostONContentsAdapter.java */
/* renamed from: com.sec.chaton.poston.v */
/* loaded from: classes.dex */
public class C2031v {

    /* renamed from: a */
    public RelativeLayout f7814a;

    /* renamed from: b */
    public ImageView f7815b;

    /* renamed from: c */
    public ImageView f7816c;

    /* renamed from: d */
    public String f7817d;

    /* renamed from: e */
    public String f7818e;

    /* renamed from: f */
    public String f7819f;

    /* renamed from: g */
    public String f7820g;

    public C2031v(RelativeLayout relativeLayout) {
        this.f7814a = relativeLayout;
        this.f7815b = (ImageView) this.f7814a.findViewById(R.id.poston_preview_content_item);
        this.f7816c = (ImageView) this.f7814a.findViewById(R.id.poston_preview_item_delete_button);
    }
}
