package com.sec.chaton.chat.p054a;

import android.content.Context;
import android.content.res.Resources;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5034k;

/* compiled from: HugeFileBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.aa */
/* loaded from: classes.dex */
public class C1507aa extends AbstractViewOnClickListenerC1514ah implements InterfaceC1544q {

    /* renamed from: L */
    private static final String f5880L = C1507aa.class.getSimpleName();

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah
    /* renamed from: a */
    public String mo8368a(Context context) {
        return context.getString(R.string.hugefile_large_file);
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah
    /* renamed from: g_ */
    protected void mo8372g_() {
        super.mo8372g_();
        if (!m8366b(this.f5869p) && this.f5840A == 0) {
            this.f5861h.f6394L.setVisibility(0);
            this.f5861h.f6394L.setOnClickListener(new ViewOnClickListenerC1508ab(this));
        } else {
            this.f5861h.f6394L.setVisibility(8);
        }
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah
    /* renamed from: e */
    protected String mo8370e() {
        return "";
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah, com.sec.chaton.chat.p054a.AbstractC1506a
    /* renamed from: a */
    protected void mo8357a() throws Resources.NotFoundException {
        super.mo8357a();
        if (m8404s()) {
            this.f5861h.f6410aA.setVisibility(0);
            this.f5861h.f6455ay.setText(m8367h());
            this.f5861h.f6410aA.setText(m8365a(this.f5869p));
            this.f5861h.f6411aB.setVisibility(8);
            this.f5861h.f6413aD.setVisibility(0);
            if (!m8366b(this.f5869p) && this.f5840A == 0) {
                this.f5861h.f6412aC.setVisibility(0);
            } else {
                this.f5861h.f6412aC.setVisibility(8);
            }
            this.f5861h.f6454ax.setVisibility(0);
            return;
        }
        this.f5861h.f6415aF.setText(m8367h());
        this.f5861h.f6417aH.setText(m8365a(this.f5869p));
        this.f5861h.f6418aI.setVisibility(8);
        this.f5861h.f6419aJ.setVisibility(0);
        this.f5861h.f6414aE.setVisibility(0);
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah, com.sec.chaton.chat.p054a.AbstractC1506a
    /* renamed from: a */
    public void mo8361a(boolean z) {
        super.mo8361a(z);
        if (m8404s()) {
            this.f5861h.f6454ax.setVisibility(8);
            this.f5861h.f6456az.setVisibility(0);
            this.f5861h.f6456az.setOnClickListener(null);
            this.f5861h.f6411aB.setVisibility(0);
            this.f5861h.f6413aD.setVisibility(8);
            this.f5861h.f6412aC.setVisibility(8);
            return;
        }
        this.f5861h.f6414aE.setVisibility(8);
        this.f5861h.f6416aG.setVisibility(0);
        this.f5861h.f6416aG.setOnClickListener(null);
        this.f5861h.f6418aI.setVisibility(0);
        this.f5861h.f6419aJ.setVisibility(8);
    }

    /* renamed from: h */
    private String m8367h() {
        return "[" + CommonApplication.m18732r().getString(R.string.hugefile_large_file) + "]";
    }

    /* renamed from: a */
    private String m8365a(String str) {
        if (str != null) {
            String[] strArrSplit = str.split("\n");
            StringBuilder sb = new StringBuilder();
            if (strArrSplit.length > 6) {
                for (int i = 6; i < strArrSplit.length; i++) {
                    sb.append(strArrSplit[i] + "\n");
                }
                if (C4904y.f17872b) {
                    C4904y.m18639b("getHugefileMessage: " + sb.toString().substring(0, sb.length() - 1), f5880L);
                }
                return sb.toString().substring(0, sb.length() - 1);
            }
        }
        return null;
    }

    /* renamed from: b */
    private boolean m8366b(String str) {
        if (str != null) {
            String[] strArrSplit = str.split("\n");
            if (strArrSplit.length > 6 && strArrSplit[strArrSplit.length - 1] != null && strArrSplit[strArrSplit.length - 1].startsWith("http")) {
                return true;
            }
        }
        return false;
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah
    /* renamed from: g */
    protected void mo8371g() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4 = null;
        float fM19096b = C5034k.m19096b() - this.f5856c.getResources().getDimensionPixelSize(R.dimen.bubble_largefile_width);
        if (m8404s()) {
            textView = this.f5861h.f6455ay;
            textView2 = this.f5861h.f6410aA;
            textView3 = this.f5861h.f6435ae;
            textView4 = this.f5861h.f6462g;
        } else {
            textView = this.f5861h.f6415aF;
            textView2 = this.f5861h.f6417aH;
            textView3 = this.f5861h.f6388F;
        }
        float fA = m8398a(fM19096b - m8399a(textView3, textView4));
        textView.setMaxWidth((int) fA);
        textView2.setMaxWidth((int) (fA - C5034k.m19088a(45.0f)));
    }

    @Override // com.sec.chaton.chat.p054a.InterfaceC1544q
    /* renamed from: i */
    public boolean mo8373i() {
        return this.f5840A == 1 || this.f5840A == 2;
    }

    @Override // com.sec.chaton.chat.p054a.InterfaceC1544q
    /* renamed from: j */
    public C1546s mo8374j() {
        return new C1546s(this.f5874u, this.f5869p, null);
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah, com.sec.chaton.chat.p054a.InterfaceC1542o
    /* renamed from: b */
    public boolean mo8369b() {
        return this.f5840A != 0;
    }
}
