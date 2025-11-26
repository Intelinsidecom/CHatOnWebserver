package com.sec.chaton.chat;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;

/* compiled from: ChatInfoAdapter.java */
/* renamed from: com.sec.chaton.chat.eu */
/* loaded from: classes.dex */
public class C1694eu {

    /* renamed from: a */
    public ViewGroup f6289a;

    /* renamed from: b */
    public ImageView f6290b;

    /* renamed from: c */
    public TextView f6291c;

    /* renamed from: d */
    public TextView f6292d;

    /* renamed from: e */
    public FrameLayout f6293e;

    /* renamed from: f */
    public String f6294f;

    /* renamed from: g */
    public String f6295g;

    /* renamed from: h */
    public String f6296h;

    public C1694eu(ViewGroup viewGroup, Context context) {
        this.f6289a = viewGroup;
        this.f6290b = (ImageView) this.f6289a.findViewById(R.id.image1);
        this.f6291c = (TextView) this.f6289a.findViewById(R.id.text1);
        this.f6292d = (TextView) this.f6289a.findViewById(R.id.text2);
        this.f6293e = (FrameLayout) this.f6289a.findViewById(R.id.space2);
    }
}
