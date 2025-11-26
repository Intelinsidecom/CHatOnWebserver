package com.sec.chaton.chat.p023a;

import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.p035io.entry.specialbuddy.SpecialBuddyRecommendBuddyEntry;
import com.sec.chaton.specialbuddy.C2930k;
import com.sec.common.CommonApplication;

/* compiled from: LiveRecommendBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.v */
/* loaded from: classes.dex */
public class C0918v extends C0917u implements InterfaceC0907k, InterfaceC0909m {

    /* renamed from: G */
    SpecialBuddyRecommendBuddyEntry f3847G;

    /* renamed from: H */
    boolean f3848H = false;

    /* renamed from: I */
    boolean f3849I = false;

    @Override // com.sec.chaton.chat.p023a.C0917u, com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x, com.sec.chaton.chat.p023a.AbstractC0888a
    /* renamed from: a */
    public void mo5090a(boolean z) {
        super.mo5090a(z);
        this.f3847G = null;
        this.f3848H = false;
        this.f3849I = false;
    }

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x
    /* renamed from: b_ */
    protected void mo5114b_() {
        RelativeLayout relativeLayout;
        TextView textView;
        TextView textView2;
        super.mo5114b_();
        if (!TextUtils.isEmpty(this.f3802p)) {
            String strM5117m = m5117m();
            if (TextUtils.isEmpty(strM5117m)) {
                if (m5123n()) {
                    this.f3794h.f4279i.setVisibility(8);
                    this.f3794h.f4279i.setOnClickListener(null);
                    return;
                } else {
                    this.f3794h.f4280j.setVisibility(8);
                    this.f3794h.f4280j.setOnClickListener(null);
                    return;
                }
            }
            float f = this.f3795i;
            if (m5123n()) {
                relativeLayout = this.f3794h.f4256ak;
                textView = this.f3794h.f4257al;
                textView2 = this.f3794h.f4258am;
            } else {
                relativeLayout = this.f3794h.f4253ah;
                textView = this.f3794h.f4254ai;
                textView2 = this.f3794h.f4255aj;
            }
            relativeLayout.setOnClickListener(this);
            relativeLayout.setVisibility(0);
            textView.setTextSize(0, f);
            textView2.setTextSize(0, f);
            textView.setText(R.string.live_partner_bubble_title_recommend);
            textView.setVisibility(0);
            textView2.setText(strM5117m);
            textView2.setVisibility(0);
        }
    }

    /* renamed from: f */
    boolean m5115f() {
        this.f3847G = C2930k.m10159c(this.f3802p);
        if (this.f3847G != null) {
            this.f3849I = true;
        } else {
            this.f3849I = false;
        }
        this.f3848H = true;
        return this.f3849I;
    }

    /* renamed from: k */
    String m5116k() {
        if (!this.f3848H) {
            m5115f();
        }
        if (this.f3849I) {
            return this.f3847G.f5657id;
        }
        return null;
    }

    /* renamed from: m */
    String m5117m() {
        if (!this.f3848H) {
            m5115f();
        }
        if (this.f3849I) {
            return this.f3847G.name;
        }
        return null;
    }

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (!this.f3791e.isClosed()) {
            if ((view == this.f3794h.f4256ak || view == this.f3794h.f4253ah) && this.f3791e.moveToPosition(this.f3792f)) {
                this.f3797k.mo5005f(m5123n(), this.f3791e);
            }
        }
    }

    @Override // com.sec.chaton.chat.p023a.InterfaceC0909m
    /* renamed from: g */
    public boolean mo5096g() {
        return C2930k.m10159c(this.f3802p) != null;
    }

    @Override // com.sec.chaton.chat.p023a.InterfaceC0909m
    /* renamed from: h */
    public C0910n mo5097h() {
        return new C0910n(this.f3807u, this.f3802p, null);
    }

    @Override // com.sec.chaton.chat.p023a.InterfaceC0907k
    /* renamed from: i */
    public boolean mo5098i() {
        return (TextUtils.isEmpty(m5116k()) || TextUtils.isEmpty(m5117m())) ? false : true;
    }

    @Override // com.sec.chaton.chat.p023a.InterfaceC0907k
    /* renamed from: j */
    public String mo5099j() {
        return String.format("%s\n%s", CommonApplication.m11493l().getString(R.string.live_partner_bubble_title_recommend), m5117m());
    }
}
