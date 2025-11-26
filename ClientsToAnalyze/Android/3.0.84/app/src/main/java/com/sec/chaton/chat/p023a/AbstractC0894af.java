package com.sec.chaton.chat.p023a;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.msgsend.C1757q;
import com.sec.chaton.p020c.C0816a;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p037j.p040c.AsyncTaskC1557c;
import com.sec.chaton.p037j.p040c.C1555a;
import com.sec.chaton.p037j.p040c.C1561g;
import com.sec.chaton.p037j.p040c.RunnableC1563i;
import com.sec.chaton.util.C3172an;
import com.sec.chaton.util.C3223ck;
import com.sec.common.util.C3347i;

/* compiled from: TransportBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.af */
/* loaded from: classes.dex */
public abstract class AbstractC0894af extends AbstractViewOnClickListenerC0920x implements InterfaceC0909m, InterfaceC0911o, InterfaceC0912p {

    /* renamed from: F */
    private Handler f3819F = new HandlerC0895ag(this);

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x
    /* renamed from: d */
    protected void mo5100d() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4 = null;
        float fM11779b = C3347i.m11779b() - C3172an.m11085a(105.0f);
        if (m5123n()) {
            textView = this.f3794h.f4223L;
            textView3 = this.f3794h.f4233V;
            textView2 = this.f3794h.f4225N;
            textView4 = this.f3794h.f4277g;
        } else {
            textView = this.f3794h.f4287q;
            textView2 = this.f3794h.f4289s;
            textView3 = this.f3794h.f4214C;
        }
        float fMeasureText = textView3.getPaint().measureText(textView3.getText().toString());
        float fMeasureText2 = textView4 != null ? textView4.getPaint().measureText(textView4.getText().toString()) + fMeasureText : fMeasureText;
        if (m5123n()) {
            float dimensionPixelSize = this.f3789c.getResources().getDimensionPixelSize(R.dimen.upload_progressbar_width) + this.f3789c.getResources().getDimensionPixelSize(R.dimen.bubble_icon_width);
            if (fMeasureText2 <= dimensionPixelSize) {
                fMeasureText2 = dimensionPixelSize;
            }
        } else {
            float dimensionPixelSize2 = this.f3789c.getResources().getDimensionPixelSize(R.dimen.download_progressbar_width) + this.f3789c.getResources().getDimensionPixelSize(R.dimen.bubble_icon_width);
            if (fMeasureText2 <= dimensionPixelSize2) {
                fMeasureText2 = dimensionPixelSize2;
            }
        }
        float fA = m5122a(fM11779b - fMeasureText2);
        textView.setMaxWidth((int) fA);
        if (this.f3794h.f4290t != null && this.f3794h.f4290t.getVisibility() == 0) {
            textView2.setMaxWidth((int) (fA - C3172an.m11085a(41.0f)));
        } else {
            textView2.setMaxWidth((int) fA);
        }
    }

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x
    /* renamed from: a_ */
    protected void mo5093a_() {
        super.mo5093a_();
        if (m5123n()) {
            if (this.f3780A == 0) {
                RunnableC1563i runnableC1563iM6629a = C1561g.m6628a().m6629a(this.f3801o);
                if (runnableC1563iM6629a != null) {
                    this.f3794h.f4237Z.setVisibility(0);
                    ProgressBar progressBar = this.f3794h.f4237Z;
                    runnableC1563iM6629a.m6649a(this.f3819F);
                    progressBar.setProgress(runnableC1563iM6629a.m6663l());
                    this.f3794h.f4246aa.setVisibility(8);
                    this.f3794h.f4236Y.setVisibility(8);
                    this.f3794h.f4247ab.setVisibility(8);
                    this.f3794h.f4220I.setVisibility(0);
                } else {
                    this.f3794h.f4237Z.setVisibility(8);
                    if (this.f3812z == 1) {
                        if (C1757q.m7251b()) {
                            this.f3794h.f4246aa.setVisibility(0);
                            this.f3794h.f4236Y.setVisibility(8);
                        } else {
                            this.f3794h.f4246aa.setVisibility(8);
                            this.f3794h.f4236Y.setVisibility(0);
                        }
                    } else {
                        this.f3794h.f4236Y.setVisibility(8);
                        this.f3794h.f4246aa.setVisibility(8);
                        this.f3794h.f4247ab.setVisibility(8);
                    }
                    this.f3794h.f4220I.setVisibility(8);
                }
                this.f3794h.f4220I.setOnClickListener(this);
                return;
            }
            return;
        }
        if (this.f3780A == 3) {
            AsyncTaskC1557c asyncTaskC1557cM6601b = C1555a.m6596a().m6601b(this.f3799m);
            if (asyncTaskC1557cM6601b != null) {
                this.f3794h.f4216E.setVisibility(0);
                this.f3794h.f4217F.setVisibility(8);
                this.f3794h.f4218G.setVisibility(0);
                this.f3794h.f4218G.setOnClickListener(this);
                asyncTaskC1557cM6601b.m6609a(this.f3790d);
            } else {
                this.f3794h.f4216E.setVisibility(8);
                this.f3794h.f4217F.setVisibility(8);
                this.f3794h.f4218G.setVisibility(8);
            }
        }
        if (this.f3780A != 4 && this.f3780A != 3) {
            this.f3794h.f4250ae.setVisibility(0);
            this.f3794h.f4250ae.setOnClickListener(this);
        } else {
            this.f3794h.f4250ae.setVisibility(8);
        }
    }

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x, com.sec.chaton.chat.p023a.AbstractC0888a
    /* renamed from: a */
    public void mo5090a(boolean z) {
        RunnableC1563i runnableC1563iM6629a;
        super.mo5090a(z);
        if (m5123n()) {
            this.f3794h.f4220I.setOnClickListener(null);
            if (this.f3780A == 0 && (runnableC1563iM6629a = C1561g.m6628a().m6629a(this.f3801o)) != null) {
                runnableC1563iM6629a.m6649a((Handler) null);
                return;
            }
            return;
        }
        this.f3794h.f4218G.setOnClickListener(null);
        this.f3794h.f4250ae.setOnClickListener(null);
    }

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.f3794h.f4220I) {
            this.f3797k.mo4969a(view, this.f3800n, this.f3801o, this.f3807u);
            return;
        }
        if (view == this.f3794h.f4218G) {
            this.f3797k.mo4966a(view, this.f3799m);
        } else if (view == this.f3794h.f4250ae && !this.f3791e.isClosed() && this.f3791e.moveToPosition(this.f3792f)) {
            this.f3797k.mo4981a(m5123n(), this.f3791e, this.f3790d);
        }
    }

    @Override // com.sec.chaton.chat.p023a.InterfaceC0909m
    /* renamed from: g */
    public boolean mo5096g() {
        return (TextUtils.isEmpty(this.f3809w) || C0816a.f3113b.equals(this.f3809w) || this.f3809w.contains("thumbnail") || !C3223ck.m11327a() || this.f3802p == null || this.f3780A == -1) ? false : true;
    }

    @Override // com.sec.chaton.chat.p023a.InterfaceC0909m
    /* renamed from: h */
    public C0910n mo5097h() {
        return (TextUtils.isEmpty(m5126q()) || !(this.f3807u == EnumC1455w.IMAGE || this.f3807u == EnumC1455w.VIDEO)) ? new C0910n(this.f3807u, this.f3802p, this.f3809w) : new C0910n(this.f3807u, this.f3802p + m5126q(), this.f3809w);
    }

    @Override // com.sec.chaton.chat.p023a.InterfaceC0912p
    /* renamed from: e */
    public boolean mo5094e() {
        return mo5096g();
    }

    @Override // com.sec.chaton.chat.p023a.InterfaceC0912p
    /* renamed from: f */
    public C0910n mo5095f() {
        return new C0910n(this.f3807u, this.f3809w, this.f3810x);
    }

    @Override // com.sec.chaton.chat.p023a.InterfaceC0911o
    /* renamed from: k */
    public boolean mo5102k() {
        return false;
    }

    @Override // com.sec.chaton.chat.p023a.InterfaceC0911o
    /* renamed from: e_ */
    public C0910n mo5101e_() {
        return new C0910n(this.f3807u, this.f3809w, mo5107l());
    }
}
