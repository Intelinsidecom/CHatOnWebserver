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

/* compiled from: ShopMultiDownloadRingTone.java */
/* renamed from: com.sec.chaton.shop.x */
/* loaded from: classes.dex */
class HandlerC3775x extends Handler {

    /* renamed from: a */
    final /* synthetic */ C3773v f13539a;

    HandlerC3775x(C3773v c3773v) {
        this.f13539a = c3773v;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0778b c0778b = (C0778b) message.obj;
        if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
            if (C4904y.f17872b) {
                C4904y.m18639b("MultiDownloadRingToneTask is succeedcount : " + this.f13539a.f13527e, C3773v.f13523b);
            }
            this.f13539a.m14167a((DownloadRequestEntry) c0778b.m3110e());
        } else {
            if (C4904y.f17875e) {
                C4904y.m18634a("MultiDownloadRingToneTask is failcount : " + this.f13539a.f13527e, C3773v.f13523b);
            }
            int iM10677a = C2471v.m10677a(this.f13539a.f13525c);
            if (-3 == iM10677a || -2 == iM10677a) {
                C5179v.m19810a(this.f13539a.f13525c, R.string.popup_no_network_connection, 0).show();
            } else {
                C5179v.m19810a(this.f13539a.f13525c, R.string.toast_network_unable, 0).show();
            }
            if (this.f13539a.f13529g != null) {
                this.f13539a.f13529g.dismiss();
            }
            Message message2 = new Message();
            Bundle bundle = new Bundle();
            message2.what = 9;
            message2.obj = new MultiDownloadResponse(this.f13539a.f13533k);
            bundle.putString("itemmultidownload_result", this.f13539a.f13535m.error);
            message2.setData(bundle);
            this.f13539a.f13530h.sendMessage(message2);
        }
        C3773v.m14182i(this.f13539a);
    }
}
