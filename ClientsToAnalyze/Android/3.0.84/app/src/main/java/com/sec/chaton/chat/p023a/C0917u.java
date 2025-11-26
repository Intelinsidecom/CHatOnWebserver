package com.sec.chaton.chat.p023a;

import android.widget.TextView;
import com.sec.chaton.util.C3172an;
import com.sec.common.util.C3347i;

/* compiled from: LiveBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.u */
/* loaded from: classes.dex */
public class C0917u extends AbstractViewOnClickListenerC0920x {

    /* renamed from: F */
    public static final String f3846F = C0917u.class.getSimpleName();

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x, com.sec.chaton.chat.p023a.AbstractC0888a
    /* renamed from: a */
    public void mo5090a(boolean z) {
        super.mo5090a(z);
        if (m5123n()) {
            this.f3794h.f4256ak.setVisibility(8);
            this.f3794h.f4256ak.setOnClickListener(null);
        } else {
            this.f3794h.f4253ah.setVisibility(8);
            this.f3794h.f4253ah.setOnClickListener(null);
        }
    }

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x
    /* renamed from: c */
    protected String mo5103c() {
        return null;
    }

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x
    /* renamed from: d */
    protected void mo5100d() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4 = null;
        float fM11779b = C3347i.m11779b() - C3172an.m11085a(105.0f);
        if (m5123n()) {
            textView2 = this.f3794h.f4257al;
            textView3 = this.f3794h.f4258am;
            textView = this.f3794h.f4233V;
            textView4 = this.f3794h.f4277g;
        } else {
            textView = this.f3794h.f4214C;
            textView2 = this.f3794h.f4254ai;
            textView3 = this.f3794h.f4255aj;
        }
        float fMeasureText = fM11779b - textView.getPaint().measureText(textView.getText().toString());
        float fA = m5122a(textView4 != null ? fMeasureText - textView4.getPaint().measureText(textView4.getText().toString()) : fMeasureText);
        float fM11085a = fA - C3172an.m11085a(29.0f);
        if (fA > 0.0f) {
            textView2.setMaxWidth((int) fA);
        }
        if (fM11085a > 0.0f) {
            textView3.setMaxWidth((int) fM11085a);
        }
    }
}
