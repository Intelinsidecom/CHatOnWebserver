package com.sec.chaton.buddy;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: BuddyAdapter.java */
/* renamed from: com.sec.chaton.buddy.as */
/* loaded from: classes.dex */
public class C0534as {

    /* renamed from: a */
    CheckBox f2475a;

    /* renamed from: b */
    ImageView f2476b;

    /* renamed from: c */
    TextView f2477c;

    /* renamed from: d */
    TextView f2478d;

    /* renamed from: e */
    ViewGroup f2479e;

    /* renamed from: f */
    ImageView f2480f;

    /* renamed from: g */
    FrameLayout f2481g;

    /* renamed from: h */
    FrameLayout f2482h;

    /* renamed from: i */
    ImageView f2483i;

    /* renamed from: j */
    ImageView f2484j;

    /* renamed from: k */
    ImageView f2485k;

    /* renamed from: l */
    TableLayout f2486l;

    /* renamed from: m */
    LinearLayout f2487m;

    /* renamed from: n */
    View f2488n;

    /* renamed from: o */
    View f2489o;

    /* renamed from: p */
    TableLayout f2490p;

    public C0534as(ViewGroup viewGroup, Context context) {
        this.f2479e = viewGroup;
        this.f2486l = (TableLayout) this.f2479e.findViewById(R.id.content);
        this.f2476b = (ImageView) this.f2479e.findViewById(R.id.image1);
        this.f2477c = (TextView) this.f2479e.findViewById(R.id.text1);
        this.f2478d = (TextView) this.f2479e.findViewById(R.id.text2);
        if (GlobalApplication.m6456e()) {
            this.f2478d.setMaxLines(2);
        } else {
            this.f2478d.setSingleLine();
        }
        this.f2478d.setEllipsize(TextUtils.TruncateAt.END);
        this.f2478d.setGravity(16);
        if (!GlobalApplication.m6456e()) {
            this.f2481g = (FrameLayout) this.f2479e.findViewById(R.id.space2);
            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(-1, -1);
            layoutParams.gravity = 21;
            this.f2481g.setLayoutParams(layoutParams);
            this.f2490p = (TableLayout) this.f2479e.findViewById(R.id.content);
            this.f2490p.setGravity(5);
            this.f2475a = new CheckBox(context);
            this.f2475a.setClickable(false);
            this.f2475a.setFocusable(false);
            this.f2475a.setPadding(0, 0, 0, 0);
            this.f2483i = new ImageView(context);
            this.f2484j = new ImageView(context);
            this.f2485k = new ImageView(context);
            this.f2480f = new ImageView(context);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            this.f2487m = new LinearLayout(context);
            this.f2487m.setGravity(16);
            this.f2483i.setLayoutParams(layoutParams2);
            this.f2483i.setBackgroundResource(R.drawable.buddies_webonly);
            this.f2483i.setVisibility(8);
            this.f2484j.setLayoutParams(layoutParams2);
            this.f2484j.setBackgroundResource(R.drawable.buddies_videocall);
            this.f2484j.setVisibility(8);
            this.f2485k.setLayoutParams(layoutParams2);
            this.f2485k.setBackgroundResource(R.drawable.buddies_like);
            this.f2485k.setVisibility(8);
            this.f2487m.addView(this.f2483i);
            this.f2487m.addView(this.f2484j);
            this.f2487m.addView(this.f2485k);
            this.f2481g.addView(C0522ag.m4020b(context, this.f2475a, this.f2483i, this.f2484j, this.f2485k, this.f2480f));
            return;
        }
        this.f2481g = (FrameLayout) this.f2479e.findViewById(R.id.space3);
        this.f2482h = (FrameLayout) this.f2479e.findViewById(R.id.space4);
        this.f2475a = new CheckBox(context);
        this.f2475a.setClickable(false);
        this.f2475a.setFocusable(false);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 5;
        this.f2475a.setLayoutParams(layoutParams3);
        this.f2483i = new ImageView(context);
        this.f2484j = new ImageView(context);
        this.f2485k = new ImageView(context);
        this.f2481g.addView(this.f2475a);
        this.f2482h.addView(C0522ag.m4021b(context, this.f2483i, this.f2484j, this.f2485k));
        this.f2488n = this.f2479e.findViewById(R.id.chat_selector);
        this.f2489o = this.f2479e.findViewById(R.id.chat_unselector);
    }
}
