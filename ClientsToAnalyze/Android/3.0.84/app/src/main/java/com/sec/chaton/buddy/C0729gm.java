package com.sec.chaton.buddy;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;

/* compiled from: BuddyRecommendFragment.java */
/* renamed from: com.sec.chaton.buddy.gm */
/* loaded from: classes.dex */
public class C0729gm {

    /* renamed from: a */
    ImageView f2978a;

    /* renamed from: b */
    TextView f2979b;

    /* renamed from: c */
    ImageView f2980c;

    /* renamed from: d */
    View f2981d;

    /* renamed from: e */
    Drawable f2982e;

    /* renamed from: f */
    ColorStateList f2983f;

    C0729gm(View view) {
        this.f2978a = (ImageView) view.findViewById(R.id.image1);
        this.f2979b = (TextView) view.findViewById(R.id.text1);
        this.f2980c = (ImageView) view.findViewById(R.id.image2);
        this.f2981d = view;
        this.f2982e = view.getBackground();
        this.f2983f = this.f2979b.getTextColors();
    }
}
