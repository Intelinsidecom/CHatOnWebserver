package com.sec.chaton.memo;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.R;

/* compiled from: MemoAdapter.java */
/* renamed from: com.sec.chaton.memo.h */
/* loaded from: classes.dex */
public class C0735h {

    /* renamed from: a */
    public ImageView f2481a;

    /* renamed from: b */
    public TextView f2482b;

    /* renamed from: c */
    public TextView f2483c;

    /* renamed from: d */
    public TextView f2484d;

    /* renamed from: e */
    public RelativeLayout f2485e;

    public C0735h(RelativeLayout relativeLayout) {
        this.f2485e = relativeLayout;
        this.f2481a = (ImageView) this.f2485e.findViewById(R.id.memo_profile_image);
        this.f2482b = (TextView) this.f2485e.findViewById(R.id.memo_profile_name);
        this.f2483c = (TextView) this.f2485e.findViewById(R.id.memo_content);
        this.f2484d = (TextView) this.f2485e.findViewById(R.id.memo_time);
    }
}
