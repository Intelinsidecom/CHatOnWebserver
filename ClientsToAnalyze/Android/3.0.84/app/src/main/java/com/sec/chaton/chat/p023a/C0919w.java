package com.sec.chaton.chat.p023a;

import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.p035io.entry.specialbuddy.SpecialBuddyShareContentsEntry;
import com.sec.chaton.specialbuddy.C2930k;

/* compiled from: LiveShareBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.w */
/* loaded from: classes.dex */
public class C0919w extends C0917u implements InterfaceC0907k, InterfaceC0909m {

    /* renamed from: G */
    public static final String f3850G = C0919w.class.getSimpleName();

    /* renamed from: H */
    SpecialBuddyShareContentsEntry f3851H;

    /* renamed from: I */
    boolean f3852I = false;

    /* renamed from: J */
    boolean f3853J = false;

    @Override // com.sec.chaton.chat.p023a.C0917u, com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x, com.sec.chaton.chat.p023a.AbstractC0888a
    /* renamed from: a */
    public void mo5090a(boolean z) {
        super.mo5090a(z);
        this.f3851H = null;
        this.f3852I = false;
        this.f3853J = false;
    }

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x
    /* renamed from: b_ */
    protected void mo5114b_() {
        RelativeLayout relativeLayout;
        TextView textView;
        TextView textView2;
        super.mo5114b_();
        if (!TextUtils.isEmpty(this.f3802p)) {
            String strM5119k = m5119k();
            String strM5120m = m5120m();
            if (TextUtils.isEmpty(strM5119k) || TextUtils.isEmpty(strM5120m)) {
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
            textView.setText(strM5119k);
            textView.setVisibility(0);
            textView2.setText(strM5120m);
            textView2.setVisibility(0);
        }
    }

    /* renamed from: f */
    boolean m5118f() {
        this.f3851H = C2930k.m10151a(this.f3802p);
        if (this.f3851H != null) {
            this.f3853J = true;
            this.f3852I = true;
        } else {
            this.f3853J = false;
        }
        return this.f3853J;
    }

    /* renamed from: k */
    String m5119k() {
        if (!this.f3852I) {
            m5118f();
        }
        if (this.f3853J) {
            return this.f3851H.title;
        }
        return null;
    }

    /* renamed from: m */
    String m5120m() {
        if (!this.f3852I) {
            m5118f();
        }
        if (this.f3853J) {
            return this.f3851H.name;
        }
        return null;
    }

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (!this.f3791e.isClosed()) {
            if ((view == this.f3794h.f4256ak || view == this.f3794h.f4253ah) && this.f3791e.moveToPosition(this.f3792f)) {
                this.f3797k.mo5001e(m5123n(), this.f3791e);
            }
        }
    }

    @Override // com.sec.chaton.chat.p023a.InterfaceC0909m
    /* renamed from: g */
    public boolean mo5096g() {
        return C2930k.m10151a(this.f3802p) != null;
    }

    @Override // com.sec.chaton.chat.p023a.InterfaceC0909m
    /* renamed from: h */
    public C0910n mo5097h() {
        return new C0910n(this.f3807u, this.f3802p, null);
    }

    @Override // com.sec.chaton.chat.p023a.InterfaceC0907k
    /* renamed from: i */
    public boolean mo5098i() {
        return (TextUtils.isEmpty(m5119k()) || TextUtils.isEmpty(m5120m())) ? false : true;
    }

    @Override // com.sec.chaton.chat.p023a.InterfaceC0907k
    /* renamed from: j */
    public String mo5099j() {
        return String.format("%s\n%s", m5119k(), m5120m());
    }
}
