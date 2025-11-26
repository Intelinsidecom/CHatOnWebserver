package com.sec.chaton.poston;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.sec.chaton.R;

/* compiled from: PostONContentsAdapter.java */
/* renamed from: com.sec.chaton.poston.v */
/* loaded from: classes.dex */
public class C3027v {

    /* renamed from: a */
    public RelativeLayout f11212a;

    /* renamed from: b */
    public ImageView f11213b;

    /* renamed from: c */
    public ImageView f11214c;

    /* renamed from: d */
    public String f11215d;

    /* renamed from: e */
    public String f11216e;

    /* renamed from: f */
    public String f11217f;

    /* renamed from: g */
    public String f11218g;

    public C3027v(RelativeLayout relativeLayout) {
        this.f11212a = relativeLayout;
        this.f11213b = (ImageView) this.f11212a.findViewById(R.id.poston_preview_content_item);
        this.f11214c = (ImageView) this.f11212a.findViewById(R.id.poston_preview_item_delete_button);
    }
}
