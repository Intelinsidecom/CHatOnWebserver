package com.sec.chaton.poston;

import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.widget.CheckableRelativeLayout;

/* compiled from: PostONCommentAdapter.java */
/* renamed from: com.sec.chaton.poston.q */
/* loaded from: classes.dex */
class C3022q {

    /* renamed from: a */
    public ImageView f11195a;

    /* renamed from: b */
    public TextView f11196b;

    /* renamed from: c */
    public TextView f11197c;

    /* renamed from: d */
    public TextView f11198d;

    /* renamed from: e */
    public CheckableRelativeLayout f11199e;

    /* renamed from: f */
    public int f11200f;

    /* synthetic */ C3022q(CheckableRelativeLayout checkableRelativeLayout, int i, ViewOnClickListenerC3019n viewOnClickListenerC3019n) {
        this(checkableRelativeLayout, i);
    }

    private C3022q(CheckableRelativeLayout checkableRelativeLayout, int i) {
        this.f11199e = checkableRelativeLayout;
        this.f11195a = (ImageView) this.f11199e.findViewById(R.id.image1);
        this.f11196b = (TextView) this.f11199e.findViewById(R.id.text1);
        this.f11197c = (TextView) this.f11199e.findViewById(R.id.text2);
        this.f11198d = (TextView) this.f11199e.findViewById(R.id.text3);
        if (C4822an.m18218a()) {
            this.f11195a.setBackgroundResource(R.drawable.circle_background);
        }
        this.f11200f = i;
    }
}
