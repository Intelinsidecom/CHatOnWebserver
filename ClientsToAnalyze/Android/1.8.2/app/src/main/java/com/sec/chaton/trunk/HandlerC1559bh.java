package com.sec.chaton.trunk;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.util.C1786r;

/* compiled from: TrunkView.java */
/* renamed from: com.sec.chaton.trunk.bh */
/* loaded from: classes.dex */
class HandlerC1559bh extends Handler {

    /* renamed from: a */
    final /* synthetic */ TrunkView f5636a;

    HandlerC1559bh(TrunkView trunkView) {
        this.f5636a = trunkView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f5636a.f5536x) {
            if (C1786r.f6454d) {
                C1786r.m6065d("TrunkView is destoried.", TrunkView.f5509c);
            }
            return;
        }
        C0101b c0101b = (C0101b) message.obj;
        this.f5636a.f5533u = null;
        switch (message.what) {
            case 902:
                if (C1786r.f6452b) {
                    C1786r.m6061b("Response: TrunkMessageControl.METHOD_GET_ITEM_LIST", TrunkView.f5509c);
                }
                if (c0101b.m665b() == EnumC0803m.SUCCESS) {
                    if (this.f5636a.f5530r) {
                        this.f5636a.m5336g();
                    }
                } else {
                    this.f5636a.m5342j();
                    if (this.f5636a.f5527o.getCount() == 0) {
                        this.f5636a.m5324a(EnumC1567bp.NetworkError);
                    }
                    Toast.makeText(this.f5636a.f5518f, this.f5636a.f5518f.getResources().getString(R.string.toast_network_unable), 1).show();
                }
                this.f5636a.f5530r = false;
                break;
        }
    }
}
