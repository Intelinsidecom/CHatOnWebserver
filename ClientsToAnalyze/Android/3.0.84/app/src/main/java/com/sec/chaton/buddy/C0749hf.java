package com.sec.chaton.buddy;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;

/* compiled from: BuddyRecommendListFragment.java */
/* renamed from: com.sec.chaton.buddy.hf */
/* loaded from: classes.dex */
public class C0749hf {

    /* renamed from: a */
    ImageView f3009a;

    /* renamed from: b */
    TextView f3010b;

    /* renamed from: c */
    ImageView f3011c;

    /* renamed from: d */
    View f3012d;

    /* renamed from: e */
    Drawable f3013e;

    /* renamed from: f */
    int[] f3014f;

    /* renamed from: g */
    ColorStateList f3015g;

    C0749hf(View view) {
        this.f3009a = (ImageView) view.findViewById(R.id.image1);
        this.f3010b = (TextView) view.findViewById(R.id.text1);
        this.f3011c = (ImageView) view.findViewById(R.id.image2);
        this.f3012d = view;
        this.f3013e = view.getBackground();
        this.f3014f = view.getDrawableState();
        this.f3015g = this.f3010b.getTextColors();
    }
}
