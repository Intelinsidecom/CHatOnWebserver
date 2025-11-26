package com.sec.chaton.chat.p054a;

import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.common.util.C5034k;

/* compiled from: LiveBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.ae */
/* loaded from: classes.dex */
public class C1511ae extends AbstractViewOnClickListenerC1514ah {

    /* renamed from: L */
    public static final String f5893L = C1511ae.class.getSimpleName();

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah, com.sec.chaton.chat.p054a.AbstractC1506a
    /* renamed from: a */
    public void mo8361a(boolean z) {
        super.mo8361a(z);
        if (m8404s()) {
            this.f5861h.f6449as.setVisibility(8);
            this.f5861h.f6449as.setOnClickListener(null);
        } else {
            this.f5861h.f6446ap.setVisibility(8);
            this.f5861h.f6446ap.setOnClickListener(null);
        }
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah
    /* renamed from: e */
    protected String mo8370e() {
        return "";
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah
    /* renamed from: g */
    protected void mo8371g() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4 = null;
        float fM19096b = C5034k.m19096b() - this.f5856c.getResources().getDimensionPixelSize(R.dimen.bubble_default_subtraction_width);
        if (m8404s()) {
            textView2 = this.f5861h.f6450at;
            textView3 = this.f5861h.f6451au;
            textView = this.f5861h.f6435ae;
            textView4 = this.f5861h.f6462g;
        } else {
            textView = this.f5861h.f6388F;
            textView2 = this.f5861h.f6447aq;
            textView3 = this.f5861h.f6448ar;
        }
        float fA = m8398a(fM19096b - m8399a(textView, textView4));
        float fM19088a = fA - C5034k.m19088a(29.0f);
        if (fA > 0.0f) {
            textView2.setMaxWidth((int) fA);
        }
        if (fM19088a > 0.0f) {
            textView3.setMaxWidth((int) fM19088a);
        }
    }
}
