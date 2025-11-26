package com.sec.chaton.chat.p054a;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p067j.p070c.C2438e;
import com.sec.chaton.p067j.p070c.RunnableC2440g;
import com.sec.chaton.util.C4873ck;
import com.sec.common.util.C5034k;

/* compiled from: TransportBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.as */
/* loaded from: classes.dex */
public abstract class AbstractC1525as extends AbstractViewOnClickListenerC1514ah implements InterfaceC1544q, InterfaceC1545r, InterfaceC1547t, InterfaceC1548u {

    /* renamed from: L */
    private Handler f5915L = new HandlerC1526at(this);

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah
    /* renamed from: g */
    protected void mo8371g() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4 = null;
        C5034k.m19088a(this.f5856c.getResources().getDimension(R.dimen.chat_bubble_profile_image_width));
        float fM19096b = C5034k.m19096b() - this.f5856c.getResources().getDimensionPixelSize(R.dimen.bubble_default_subtraction_width);
        if (m8404s()) {
            textView = this.f5861h.f6397O;
            textView3 = this.f5861h.f6435ae;
            textView2 = this.f5861h.f6399Q;
            textView4 = this.f5861h.f6462g;
        } else {
            textView = this.f5861h.f6472q;
            textView2 = this.f5861h.f6474s;
            textView3 = this.f5861h.f6388F;
        }
        float fA = m8399a(textView3, textView4);
        if (m8404s()) {
            float dimensionPixelSize = this.f5856c.getResources().getDimensionPixelSize(R.dimen.upload_progressbar_width) + this.f5856c.getResources().getDimensionPixelSize(R.dimen.bubble_icon_width);
            if (fA <= dimensionPixelSize) {
                fA = dimensionPixelSize;
            }
        } else {
            float dimensionPixelSize2 = this.f5856c.getResources().getDimensionPixelSize(R.dimen.download_progressbar_width) + this.f5856c.getResources().getDimensionPixelSize(R.dimen.bubble_icon_width);
            if (fA <= dimensionPixelSize2) {
                fA = dimensionPixelSize2;
            }
        }
        float fA2 = m8398a(fM19096b - fA);
        textView.setMaxWidth((int) fA2);
        if (this.f5861h.f6475t != null && this.f5861h.f6475t.getVisibility() == 0) {
            textView2.setMaxWidth((int) (fA2 - C5034k.m19088a(41.0f)));
        } else {
            textView2.setMaxWidth((int) fA2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00f5  */
    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah
    /* renamed from: g_ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void mo8372g_() {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.p054a.AbstractC1525as.mo8372g_():void");
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah, com.sec.chaton.chat.p054a.AbstractC1506a
    /* renamed from: a */
    public void mo8361a(boolean z) {
        RunnableC2440g runnableC2440gM10573a;
        super.mo8361a(z);
        if (m8404s()) {
            this.f5861h.f6394L.setOnClickListener(null);
            this.f5861h.f6394L.setBackgroundResource(R.drawable.anicon_package_item_downloading_event_xml);
            if (this.f5840A == 0 && (runnableC2440gM10573a = C2438e.m10572a().m10573a(this.f5868o)) != null) {
                runnableC2440gM10573a.m10593a((Handler) null);
                return;
            }
            return;
        }
        this.f5861h.f6392J.setOnClickListener(null);
        this.f5861h.f6443am.setOnClickListener(null);
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.equals(this.f5861h.f6394L)) {
            this.f5861h.f6394L.setBackgroundResource(R.drawable.download_ic_cancel_press);
            this.f5864k.mo8226a(view, this.f5867n, this.f5868o, this.f5874u);
        } else if (view.equals(this.f5861h.f6392J)) {
            this.f5864k.mo8223a(view, this.f5866m);
        } else if (view.equals(this.f5861h.f6443am) && !this.f5858e.isClosed() && this.f5858e.moveToPosition(this.f5859f)) {
            this.f5864k.mo8238a(m8404s(), this.f5858e, this.f5857d);
        }
    }

    @Override // com.sec.chaton.chat.p054a.InterfaceC1544q
    /* renamed from: i */
    public boolean mo8373i() {
        return (TextUtils.isEmpty(this.f5876w) || C1427a.f5066d.equals(this.f5876w) || this.f5876w.contains("thumbnail") || !C4873ck.m18500a() || this.f5869p == null || this.f5840A == -1 || this.f5840A == 0) ? false : true;
    }

    @Override // com.sec.chaton.chat.p054a.InterfaceC1544q
    /* renamed from: j */
    public C1546s mo8374j() {
        return (TextUtils.isEmpty(m8407v()) || !(this.f5874u == EnumC2214ab.IMAGE || this.f5874u == EnumC2214ab.VIDEO)) ? new C1546s(this.f5874u, this.f5869p, this.f5876w) : new C1546s(this.f5874u, this.f5869p + m8407v(), this.f5876w);
    }

    @Override // com.sec.chaton.chat.p054a.InterfaceC1548u
    /* renamed from: h */
    public boolean mo8412h() {
        return mo8373i();
    }

    /* renamed from: b_ */
    public C1546s mo8387b_() {
        return new C1546s(this.f5874u, this.f5876w, this.f5877x);
    }

    @Override // com.sec.chaton.chat.p054a.InterfaceC1547t
    /* renamed from: m */
    public boolean mo8415m() {
        return false;
    }

    @Override // com.sec.chaton.chat.p054a.InterfaceC1547t
    /* renamed from: c_ */
    public C1546s mo8414c_() {
        return new C1546s(this.f5874u, this.f5876w, mo8401n());
    }

    @Override // com.sec.chaton.chat.p054a.InterfaceC1545r
    /* renamed from: o */
    public boolean mo8413o() {
        return C2349a.m10301a("sms_feature") && mo8373i();
    }

    @Override // com.sec.chaton.chat.p054a.InterfaceC1545r
    /* renamed from: d_ */
    public C1546s mo8411d_() {
        return (this.f5874u == EnumC2214ab.IMAGE || this.f5874u == EnumC2214ab.VIDEO) ? new C1546s(this.f5874u, this.f5876w, mo8370e()) : new C1546s(this.f5874u, this.f5876w, this.f5877x);
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah, com.sec.chaton.chat.p054a.InterfaceC1542o
    /* renamed from: b */
    public boolean mo8369b() {
        return this.f5840A != 0;
    }
}
