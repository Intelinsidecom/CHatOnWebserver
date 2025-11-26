package com.sec.chaton.chat.p054a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.global.C2349a;
import com.sec.common.CommonApplication;

/* compiled from: GeoBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.x */
/* loaded from: classes.dex */
public class C1551x extends AbstractViewOnClickListenerC1514ah implements InterfaceC1544q, InterfaceC1545r {
    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah
    /* renamed from: a */
    public String mo8368a(Context context) {
        return context.getString(R.string.media_map);
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah
    /* renamed from: e */
    protected String mo8370e() {
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0175  */
    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah, com.sec.chaton.chat.p054a.AbstractC1506a
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void mo8357a() throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 376
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.p054a.C1551x.mo8357a():void");
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah, com.sec.chaton.chat.p054a.AbstractC1506a
    /* renamed from: a */
    public void mo8361a(boolean z) {
        super.mo8361a(z);
        if (m8404s()) {
            this.f5861h.f6407Y.setVisibility(8);
            this.f5861h.f6408Z.setOnClickListener(null);
        } else {
            this.f5861h.f6480y.setVisibility(8);
            this.f5861h.f6481z.setOnClickListener(null);
        }
    }

    @Override // com.sec.chaton.chat.p054a.InterfaceC1544q
    /* renamed from: i */
    public boolean mo8373i() {
        return true;
    }

    @Override // com.sec.chaton.chat.p054a.InterfaceC1544q
    /* renamed from: j */
    public C1546s mo8374j() {
        return new C1546s(this.f5874u, this.f5869p, null);
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (!this.f5858e.isClosed()) {
            if ((view.equals(this.f5861h.f6408Z) || view.equals(this.f5861h.f6481z)) && this.f5858e.moveToPosition(this.f5859f)) {
                this.f5864k.mo8248c(m8404s(), this.f5858e);
            }
        }
    }

    @Override // com.sec.chaton.chat.p054a.InterfaceC1545r
    /* renamed from: o */
    public boolean mo8413o() {
        return C2349a.m10301a("sms_feature");
    }

    @Override // com.sec.chaton.chat.p054a.InterfaceC1545r
    /* renamed from: d_ */
    public C1546s mo8411d_() {
        String strSubstring;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[" + CommonApplication.m18732r().getString(R.string.media_map) + "] ");
        if (!TextUtils.isEmpty(this.f5869p)) {
            String[] strArrSplit = this.f5869p.split("\n");
            if (strArrSplit.length > 5) {
                if (strArrSplit.length > 6) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    for (int i = 6; i < strArrSplit.length; i++) {
                        stringBuffer2.append(strArrSplit[i] + "\n");
                    }
                    strSubstring = stringBuffer2.toString().substring(0, stringBuffer2.length() - 1);
                } else {
                    strSubstring = null;
                }
                stringBuffer.append("http://maps.google.com/maps?f=q&geocode=&q=");
                stringBuffer.append(strArrSplit[5]);
                if (strSubstring != null) {
                    stringBuffer.append(" " + strSubstring);
                }
            }
        }
        return new C1546s(this.f5874u, null, stringBuffer.toString());
    }
}
