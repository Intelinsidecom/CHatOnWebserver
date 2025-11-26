package com.sec.chaton.trunk;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.sec.chaton.R;

/* compiled from: TrunkAdapter.java */
/* renamed from: com.sec.chaton.trunk.u */
/* loaded from: classes.dex */
class C4687u {

    /* renamed from: a */
    View f16929a;

    /* renamed from: b */
    ImageView f16930b;

    /* renamed from: c */
    CheckBox f16931c;

    /* renamed from: d */
    ProgressBar f16932d;

    /* renamed from: e */
    TextView f16933e;

    /* renamed from: f */
    ImageView f16934f;

    /* renamed from: g */
    ImageView f16935g;

    /* renamed from: h */
    ImageView f16936h;

    /* renamed from: i */
    final /* synthetic */ ViewOnClickListenerC4684r f16937i;

    /* synthetic */ C4687u(ViewOnClickListenerC4684r viewOnClickListenerC4684r, View view, HandlerC4685s handlerC4685s) {
        this(viewOnClickListenerC4684r, view);
    }

    private C4687u(ViewOnClickListenerC4684r viewOnClickListenerC4684r, View view) {
        this.f16937i = viewOnClickListenerC4684r;
        this.f16929a = view;
        this.f16930b = (ImageView) view.findViewById(R.id.thumbnail);
        this.f16931c = (CheckBox) view.findViewById(R.id.multiCheck);
        this.f16932d = (ProgressBar) view.findViewById(R.id.downloadProgressbar);
        this.f16933e = (TextView) view.findViewById(R.id.totalCommentCountTextView);
        this.f16934f = (ImageView) view.findViewById(R.id.totalCommentCountImageView);
        this.f16935g = (ImageView) view.findViewById(R.id.dimId);
        this.f16936h = (ImageView) view.findViewById(R.id.playbtn);
    }
}
