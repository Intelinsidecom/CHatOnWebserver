package com.sec.chaton.memo;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.R;

/* compiled from: MemoAdapter.java */
/* renamed from: com.sec.chaton.memo.d */
/* loaded from: classes.dex */
public class C0840d {

    /* renamed from: a */
    public ImageView f3087a;

    /* renamed from: b */
    public TextView f3088b;

    /* renamed from: c */
    public TextView f3089c;

    /* renamed from: d */
    public TextView f3090d;

    /* renamed from: e */
    public RelativeLayout f3091e;

    public C0840d(RelativeLayout relativeLayout) {
        this.f3091e = relativeLayout;
        this.f3087a = (ImageView) this.f3091e.findViewById(R.id.memo_profile_image);
        this.f3088b = (TextView) this.f3091e.findViewById(R.id.memo_profile_name);
        this.f3089c = (TextView) this.f3091e.findViewById(R.id.memo_content);
        this.f3090d = (TextView) this.f3091e.findViewById(R.id.memo_time);
    }
}
