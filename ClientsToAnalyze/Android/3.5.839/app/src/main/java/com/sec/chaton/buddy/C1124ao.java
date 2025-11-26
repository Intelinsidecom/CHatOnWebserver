package com.sec.chaton.buddy;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import com.sec.chaton.R;

/* compiled from: BuddyAdapter.java */
/* renamed from: com.sec.chaton.buddy.ao */
/* loaded from: classes.dex */
public class C1124ao {

    /* renamed from: a */
    CheckBox f4329a;

    /* renamed from: b */
    ImageView f4330b;

    /* renamed from: c */
    TextView f4331c;

    /* renamed from: d */
    TextView f4332d;

    /* renamed from: e */
    ViewGroup f4333e;

    /* renamed from: f */
    ImageView f4334f;

    /* renamed from: g */
    FrameLayout f4335g;

    /* renamed from: h */
    ImageView f4336h;

    /* renamed from: i */
    ImageView f4337i;

    /* renamed from: j */
    ImageView f4338j;

    /* renamed from: k */
    ImageView f4339k;

    /* renamed from: l */
    TableLayout f4340l;

    /* renamed from: m */
    LinearLayout f4341m;

    /* renamed from: n */
    TextView f4342n;

    public C1124ao(ViewGroup viewGroup, Context context) {
        this.f4333e = viewGroup;
        this.f4340l = (TableLayout) this.f4333e.findViewById(R.id.content);
        this.f4330b = (ImageView) this.f4333e.findViewById(R.id.image1);
        this.f4331c = (TextView) this.f4333e.findViewById(R.id.text1);
        this.f4332d = (TextView) this.f4333e.findViewById(R.id.text2);
        this.f4342n = (TextView) this.f4333e.findViewById(R.id.invite_sent);
        this.f4332d.setSingleLine();
        this.f4332d.setEllipsize(TextUtils.TruncateAt.END);
        this.f4332d.setGravity(16);
        this.f4335g = (FrameLayout) this.f4333e.findViewById(R.id.space2);
        this.f4329a = new CheckBox(context);
        this.f4329a.setClickable(false);
        this.f4329a.setFocusable(false);
        this.f4329a.setPadding(0, 0, 0, 0);
        this.f4336h = new ImageView(context);
        this.f4337i = new ImageView(context);
        this.f4338j = new ImageView(context);
        this.f4339k = new ImageView(context);
        this.f4334f = new ImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.f4341m = new LinearLayout(context);
        this.f4341m.setGravity(16);
        this.f4336h.setLayoutParams(layoutParams);
        this.f4336h.setBackgroundResource(R.drawable.buddies_webonly);
        this.f4336h.setVisibility(8);
        this.f4337i.setLayoutParams(layoutParams);
        this.f4337i.setBackgroundResource(R.drawable.buddies_videocall);
        this.f4337i.setVisibility(8);
        this.f4338j.setLayoutParams(layoutParams);
        this.f4338j.setBackgroundResource(R.drawable.buddies_like);
        this.f4338j.setVisibility(8);
        this.f4339k.setLayoutParams(layoutParams);
        this.f4339k.setBackgroundResource(R.drawable.buddies_contact);
        this.f4339k.setVisibility(8);
        this.f4341m.addView(this.f4336h);
        this.f4341m.addView(this.f4337i);
        this.f4341m.addView(this.f4338j);
        this.f4341m.addView(this.f4339k);
        this.f4335g.addView(C1113ad.m7107b(context, this.f4329a, this.f4336h, this.f4337i, this.f4338j, this.f4334f));
    }
}
