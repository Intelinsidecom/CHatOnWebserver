package com.sec.chaton.chat.p023a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.p027e.EnumC1450r;

/* compiled from: TextBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.ae */
/* loaded from: classes.dex */
public class C0893ae extends AbstractViewOnClickListenerC0920x implements InterfaceC0907k, InterfaceC0909m, InterfaceC0912p {
    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x
    /* renamed from: a */
    public String mo5092a(Context context) {
        return context.getString(R.string.dialog_header_text);
    }

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x
    /* renamed from: a_ */
    protected void mo5093a_() {
        super.mo5093a_();
        if (this.f3780A == -1 && this.f3793g && this.f3798l == EnumC1450r.ONETOONE) {
            this.f3794h.f4248ac.setOnClickListener(this);
        }
    }

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f3794h.f4248ac) {
            this.f3797k.mo4967a(view, this.f3801o, true);
        } else {
            super.onClick(view);
        }
    }

    @Override // com.sec.chaton.chat.p023a.InterfaceC0907k
    /* renamed from: i */
    public boolean mo5098i() {
        return true;
    }

    @Override // com.sec.chaton.chat.p023a.InterfaceC0907k
    /* renamed from: j */
    public String mo5099j() {
        return TextUtils.isEmpty(m5126q()) ? this.f3802p : this.f3802p + m5126q();
    }

    @Override // com.sec.chaton.chat.p023a.InterfaceC0909m
    /* renamed from: g */
    public boolean mo5096g() {
        return true;
    }

    @Override // com.sec.chaton.chat.p023a.InterfaceC0909m
    /* renamed from: h */
    public C0910n mo5097h() {
        return TextUtils.isEmpty(m5126q()) ? new C0910n(this.f3807u, this.f3802p, null) : new C0910n(this.f3807u, this.f3802p + m5126q(), null);
    }

    @Override // com.sec.chaton.chat.p023a.InterfaceC0912p
    /* renamed from: e */
    public boolean mo5094e() {
        return true;
    }

    @Override // com.sec.chaton.chat.p023a.InterfaceC0912p
    /* renamed from: f */
    public C0910n mo5095f() {
        return TextUtils.isEmpty(m5126q()) ? new C0910n(this.f3807u, this.f3802p, null) : new C0910n(this.f3807u, this.f3802p + m5126q(), null);
    }
}
