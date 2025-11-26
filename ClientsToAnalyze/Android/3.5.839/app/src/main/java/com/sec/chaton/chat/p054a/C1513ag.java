package com.sec.chaton.chat.p054a;

import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.p065io.entry.specialbuddy.SpecialBuddyShareContentsEntry;
import com.sec.chaton.specialbuddy.C4542g;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;

/* compiled from: LiveShareBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.ag */
/* loaded from: classes.dex */
public class C1513ag extends C1511ae implements InterfaceC1541n, InterfaceC1544q {

    /* renamed from: M */
    public static final String f5897M = C1513ag.class.getSimpleName();

    /* renamed from: N */
    SpecialBuddyShareContentsEntry f5898N;

    /* renamed from: O */
    boolean f5899O = false;

    /* renamed from: P */
    boolean f5900P = false;

    @Override // com.sec.chaton.chat.p054a.C1511ae, com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah, com.sec.chaton.chat.p054a.AbstractC1506a
    /* renamed from: a */
    public void mo8361a(boolean z) {
        super.mo8361a(z);
        this.f5898N = null;
        this.f5899O = false;
        this.f5900P = false;
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah
    /* renamed from: i_ */
    protected void mo8389i_() {
        RelativeLayout relativeLayout;
        TextView textView;
        TextView textView2;
        super.mo8389i_();
        if (!TextUtils.isEmpty(this.f5869p)) {
            String strM8395m = m8395m();
            String strM8396o = m8396o();
            if (TextUtils.isEmpty(strM8395m) || TextUtils.isEmpty(strM8396o)) {
                if (m8404s()) {
                    this.f5861h.f6464i.setVisibility(8);
                    this.f5861h.f6464i.setOnClickListener(null);
                    return;
                } else {
                    this.f5861h.f6465j.setVisibility(8);
                    this.f5861h.f6465j.setOnClickListener(null);
                    return;
                }
            }
            float f = this.f5862i;
            if (m8404s()) {
                relativeLayout = this.f5861h.f6449as;
                textView = this.f5861h.f6450at;
                textView2 = this.f5861h.f6451au;
            } else {
                relativeLayout = this.f5861h.f6446ap;
                textView = this.f5861h.f6447aq;
                textView2 = this.f5861h.f6448ar;
            }
            relativeLayout.setOnClickListener(this);
            relativeLayout.setVisibility(0);
            textView.setTextSize(0, f);
            textView2.setTextSize(0, f);
            textView.setText(strM8395m);
            textView.setVisibility(0);
            textView2.setText(strM8396o);
            textView2.setVisibility(0);
        }
    }

    /* renamed from: h */
    boolean m8394h() {
        this.f5898N = C4542g.m17227a(this.f5869p);
        if (this.f5898N != null) {
            this.f5900P = true;
            this.f5899O = true;
        } else {
            this.f5900P = false;
        }
        return this.f5900P;
    }

    /* renamed from: m */
    String m8395m() {
        if (!this.f5899O) {
            m8394h();
        }
        if (this.f5900P) {
            return this.f5898N.title;
        }
        return null;
    }

    /* renamed from: o */
    String m8396o() {
        if (!this.f5899O) {
            m8394h();
        }
        if (this.f5900P) {
            return this.f5898N.name;
        }
        return null;
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (!this.f5858e.isClosed()) {
            if ((view.equals(this.f5861h.f6449as) || view.equals(this.f5861h.f6446ap)) && this.f5858e.moveToPosition(this.f5859f)) {
                this.f5864k.mo8255e(m8404s(), this.f5858e);
            }
        }
    }

    @Override // com.sec.chaton.chat.p054a.InterfaceC1544q
    /* renamed from: i */
    public boolean mo8373i() {
        return C4542g.m17227a(this.f5869p) != null;
    }

    @Override // com.sec.chaton.chat.p054a.InterfaceC1544q
    /* renamed from: j */
    public C1546s mo8374j() {
        return new C1546s(this.f5874u, this.f5869p, null);
    }

    @Override // com.sec.chaton.chat.p054a.InterfaceC1541n
    /* renamed from: k */
    public boolean mo8390k() {
        return (TextUtils.isEmpty(m8395m()) || TextUtils.isEmpty(m8396o())) ? false : true;
    }

    @Override // com.sec.chaton.chat.p054a.InterfaceC1541n
    /* renamed from: l */
    public String mo8391l() {
        String strM8395m = m8395m();
        if (strM8395m == null) {
            if (C4904y.f17873c) {
                C4904y.m18641c("onCopy() - title is null", "LiveShareBubbleDrawer");
            }
            strM8395m = CommonApplication.m18732r().getString(R.string.unknown);
        }
        String strM8396o = m8396o();
        if (strM8396o == null) {
            if (C4904y.f17873c) {
                C4904y.m18641c("onCopy() - name is null", "LiveShareBubbleDrawer");
            }
            strM8396o = CommonApplication.m18732r().getString(R.string.unknown);
        }
        return String.format("%s\n%s", strM8395m, strM8396o);
    }
}
