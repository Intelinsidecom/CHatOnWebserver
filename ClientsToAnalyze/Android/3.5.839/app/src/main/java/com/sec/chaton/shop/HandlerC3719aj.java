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

/* compiled from: ShopMultiDownloadSticker.java */
/* renamed from: com.sec.chaton.shop.aj */
/* loaded from: classes.dex */
class HandlerC3719aj extends Handler {

    /* renamed from: a */
    final /* synthetic */ C3717ah f13386a;

    HandlerC3719aj(C3717ah c3717ah) {
        this.f13386a = c3717ah;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0778b c0778b = (C0778b) message.obj;
        if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
            if (C4904y.f17872b) {
                C4904y.m18639b("MultiDownloadStickerTask is succeedcount : " + this.f13386a.f13377h, C3717ah.f13370b);
            }
            this.f13386a.m14034b((DownloadRequestEntry) c0778b.m3110e());
        } else {
            if (C4904y.f17875e) {
                C4904y.m18634a("MultiDownloadStickerTask is failcount : " + this.f13386a.f13377h, C3717ah.f13370b);
            }
            int iM10677a = C2471v.m10677a(this.f13386a.f13372c);
            if (-3 == iM10677a || -2 == iM10677a) {
                C5179v.m19810a(this.f13386a.f13372c, R.string.popup_no_network_connection, 1).show();
            } else {
                C5179v.m19810a(this.f13386a.f13372c, R.string.toast_network_unable, 1).show();
            }
            if (this.f13386a.f13375f != null) {
                this.f13386a.f13375f.dismiss();
            }
            Message message2 = new Message();
            Bundle bundle = new Bundle();
            message2.what = 9;
            message2.obj = new MultiDownloadResponse(this.f13386a.f13380k);
            bundle.putString("itemmultidownload_result", this.f13386a.f13382m.error);
            message2.setData(bundle);
            this.f13386a.f13376g.sendMessage(message2);
        }
        C3717ah.m14043i(this.f13386a);
    }
}
