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
class C3067u {

    /* renamed from: a */
    View f10980a;

    /* renamed from: b */
    ImageView f10981b;

    /* renamed from: c */
    CheckBox f10982c;

    /* renamed from: d */
    ProgressBar f10983d;

    /* renamed from: e */
    TextView f10984e;

    /* renamed from: f */
    ImageView f10985f;

    /* renamed from: g */
    ImageView f10986g;

    /* renamed from: h */
    ImageView f10987h;

    /* renamed from: i */
    final /* synthetic */ ViewOnClickListenerC3064r f10988i;

    /* synthetic */ C3067u(ViewOnClickListenerC3064r viewOnClickListenerC3064r, View view, HandlerC3065s handlerC3065s) {
        this(viewOnClickListenerC3064r, view);
    }

    private C3067u(ViewOnClickListenerC3064r viewOnClickListenerC3064r, View view) {
        this.f10988i = viewOnClickListenerC3064r;
        this.f10980a = view;
        this.f10981b = (ImageView) view.findViewById(R.id.thumbnail);
        this.f10982c = (CheckBox) view.findViewById(R.id.multiCheck);
        this.f10983d = (ProgressBar) view.findViewById(R.id.downloadProgressbar);
        this.f10984e = (TextView) view.findViewById(R.id.totalCommentCountTextView);
        this.f10985f = (ImageView) view.findViewById(R.id.totalCommentCountImageView);
        this.f10986g = (ImageView) view.findViewById(R.id.dimId);
        this.f10987h = (ImageView) view.findViewById(R.id.playbtn);
    }
}
