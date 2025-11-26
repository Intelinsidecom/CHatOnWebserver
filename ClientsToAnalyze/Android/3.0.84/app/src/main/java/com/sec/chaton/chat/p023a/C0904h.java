package com.sec.chaton.chat.p023a;

import android.content.Context;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: CalendarBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.h */
/* loaded from: classes.dex */
public class C0904h extends AbstractC0894af {
    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x
    /* renamed from: a */
    public String mo5092a(Context context) {
        return context.getString(R.string.media_calendar);
    }

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x
    /* renamed from: c */
    protected String mo5103c() {
        return null;
    }

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x, com.sec.chaton.chat.p023a.AbstractC0888a
    /* renamed from: a */
    protected void mo5087a() {
        super.mo5087a();
        if (m5123n()) {
            this.f3794h.f4229R.setImageResource(R.drawable.co_attach_p_calendar_normal);
            this.f3794h.f4228Q.setVisibility(0);
            this.f3794h.f4229R.setOnClickListener(this);
            this.f3794h.f4230S.setText(this.f3810x);
            this.f3794h.f4229R.setVisibility(0);
            this.f3794h.f4230S.setVisibility(0);
            return;
        }
        this.f3794h.f4293w.setImageResource(R.drawable.co_attach_p_calendar_normal);
        this.f3794h.f4292v.setVisibility(0);
        this.f3794h.f4293w.setOnClickListener(this);
        this.f3794h.f4294x.setText(this.f3810x);
        this.f3794h.f4293w.setVisibility(0);
        this.f3794h.f4294x.setVisibility(0);
    }

    @Override // com.sec.chaton.chat.p023a.AbstractC0894af, com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x, com.sec.chaton.chat.p023a.AbstractC0888a
    /* renamed from: a */
    public void mo5090a(boolean z) {
        super.mo5090a(z);
        if (m5123n()) {
            this.f3794h.f4228Q.setVisibility(8);
            this.f3794h.f4229R.setOnClickListener(null);
        } else {
            this.f3794h.f4292v.setVisibility(8);
            this.f3794h.f4293w.setOnClickListener(null);
        }
    }

    @Override // com.sec.chaton.chat.p023a.AbstractC0894af, com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (!this.f3791e.isClosed()) {
            if ((view == this.f3794h.f4229R || view == this.f3794h.f4293w) && this.f3791e.moveToPosition(this.f3792f)) {
                this.f3797k.mo4993c(m5123n(), this.f3791e, this.f3794h.f4238a);
            }
        }
    }
}
