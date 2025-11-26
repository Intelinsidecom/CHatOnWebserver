package com.sec.chaton.shop;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.shop.entrys.DownloadRequestEntry;
import com.sec.chaton.shop.entrys.MultiDownloadResponse;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;

/* compiled from: ShopMultiDownloadSkin.java */
/* renamed from: com.sec.chaton.shop.ad */
/* loaded from: classes.dex */
class HandlerC3713ad extends Handler {

    /* renamed from: a */
    final /* synthetic */ C3711ab f13364a;

    HandlerC3713ad(C3711ab c3711ab) {
        this.f13364a = c3711ab;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0778b c0778b = (C0778b) message.obj;
        if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
            if (C4904y.f17872b) {
                C4904y.m18639b("MultiDownloadSkin is succeedcount : " + this.f13364a.f13352e, C3711ab.f13348b);
            }
            this.f13364a.m14012b((DownloadRequestEntry) c0778b.m3110e());
        } else {
            if (C4904y.f17875e) {
                C4904y.m18634a("MultiDownloadSkin is failcount : " + this.f13364a.f13352e, C3711ab.f13348b);
            }
            int iM10677a = C2471v.m10677a(this.f13364a.f13350c);
            if (-3 == iM10677a || -2 == iM10677a) {
                C5179v.m19810a(this.f13364a.f13350c, R.string.popup_no_network_connection, 0).show();
            } else {
                C5179v.m19810a(this.f13364a.f13350c, R.string.toast_network_unable, 0).show();
            }
            if (this.f13364a.f13354g != null) {
                this.f13364a.f13354g.dismiss();
            }
            Message message2 = new Message();
            Bundle bundle = new Bundle();
            message2.what = 9;
            message2.obj = new MultiDownloadResponse(this.f13364a.f13358k);
            bundle.putString("itemmultidownload_result", this.f13364a.f13360m.error);
            message2.setData(bundle);
            this.f13364a.f13355h.sendMessage(message2);
        }
        C3711ab.m14021i(this.f13364a);
    }
}
