package com.sec.chaton.block;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.UnBlock;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: BlockListFragment.java */
/* renamed from: com.sec.chaton.block.t */
/* loaded from: classes.dex */
class HandlerC1092t extends Handler {

    /* renamed from: a */
    final /* synthetic */ BlockListFragment f3483a;

    HandlerC1092t(BlockListFragment blockListFragment) {
        this.f3483a = blockListFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0778b c0778b = (C0778b) message.obj;
        switch (message.what) {
            case 603:
                BlockListFragment.f3426b.dismiss();
                if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                    UnBlock unBlock = (UnBlock) c0778b.m3110e();
                    for (int i = 0; i < this.f3483a.f3431g.size(); i++) {
                        if (unBlock.buddyid.equals(((C1093u) this.f3483a.f3431g.get(i)).f3484a)) {
                            C5179v.m19811a(CommonApplication.m18732r(), CommonApplication.m18732r().getResources().getString(R.string.contact_unblocked_toast), 0).show();
                            this.f3483a.f3431g.remove(i);
                        }
                    }
                    break;
                } else {
                    C5179v.m19810a(CommonApplication.m18732r(), R.string.dev_network_error, 0).show();
                    this.f3483a.m6211a();
                    break;
                }
                break;
        }
    }
}
