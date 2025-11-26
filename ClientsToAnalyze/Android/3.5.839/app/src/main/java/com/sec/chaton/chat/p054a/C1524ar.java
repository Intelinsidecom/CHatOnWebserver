package com.sec.chaton.chat.p054a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.p057e.EnumC2300t;

/* compiled from: TextBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.ar */
/* loaded from: classes.dex */
public class C1524ar extends AbstractViewOnClickListenerC1514ah implements InterfaceC1541n, InterfaceC1544q, InterfaceC1545r, InterfaceC1548u {
    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah
    /* renamed from: a */
    public String mo8368a(Context context) {
        return context.getString(R.string.dialog_header_text);
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah
    /* renamed from: g_ */
    protected void mo8372g_() {
        super.mo8372g_();
        if (this.f5840A == -1 && this.f5860g && this.f5865l == EnumC2300t.ONETOONE) {
            this.f5861h.f6441ak.setOnClickListener(this);
        }
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.equals(this.f5861h.f6441ak)) {
            this.f5864k.mo8224a(view, this.f5868o, true);
        } else {
            super.onClick(view);
        }
    }

    @Override // com.sec.chaton.chat.p054a.InterfaceC1541n
    /* renamed from: k */
    public boolean mo8390k() {
        return true;
    }

    @Override // com.sec.chaton.chat.p054a.InterfaceC1541n
    /* renamed from: l */
    public String mo8391l() {
        return TextUtils.isEmpty(m8407v()) ? this.f5869p : this.f5869p + m8407v();
    }

    @Override // com.sec.chaton.chat.p054a.InterfaceC1544q
    /* renamed from: i */
    public boolean mo8373i() {
        return true;
    }

    @Override // com.sec.chaton.chat.p054a.InterfaceC1544q
    /* renamed from: j */
    public C1546s mo8374j() {
        return TextUtils.isEmpty(m8407v()) ? new C1546s(this.f5874u, this.f5869p, null) : new C1546s(this.f5874u, this.f5869p + m8407v(), null);
    }

    @Override // com.sec.chaton.chat.p054a.InterfaceC1548u
    /* renamed from: h */
    public boolean mo8412h() {
        return true;
    }

    @Override // com.sec.chaton.chat.p054a.InterfaceC1548u
    /* renamed from: b_ */
    public C1546s mo8387b_() {
        return TextUtils.isEmpty(m8407v()) ? new C1546s(this.f5874u, this.f5869p, null) : new C1546s(this.f5874u, this.f5869p + m8407v(), null);
    }

    @Override // com.sec.chaton.chat.p054a.InterfaceC1545r
    /* renamed from: o */
    public boolean mo8413o() {
        return C2349a.m10301a("sms_feature");
    }

    @Override // com.sec.chaton.chat.p054a.InterfaceC1545r
    /* renamed from: d_ */
    public C1546s mo8411d_() {
        return new C1546s(this.f5874u, null, this.f5869p);
    }
}
