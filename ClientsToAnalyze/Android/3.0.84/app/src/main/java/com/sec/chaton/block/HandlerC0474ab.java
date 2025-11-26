package com.sec.chaton.block;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.UnBlock;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;

/* compiled from: BlockListFragment.java */
/* renamed from: com.sec.chaton.block.ab */
/* loaded from: classes.dex */
class HandlerC0474ab extends Handler {

    /* renamed from: a */
    final /* synthetic */ BlockListFragment f1583a;

    HandlerC0474ab(BlockListFragment blockListFragment) {
        this.f1583a = blockListFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0267d c0267d = (C0267d) message.obj;
        switch (message.what) {
            case 603:
                BlockListFragment.f1558b.dismiss();
                if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                    UnBlock unBlock = (UnBlock) c0267d.m1354e();
                    for (int i = 0; i < this.f1583a.f1563g.size(); i++) {
                        if (unBlock.buddyid.equals(((C0475ac) this.f1583a.f1563g.get(i)).f1584a)) {
                            C3641ai.m13211a(CommonApplication.m11493l(), CommonApplication.m11493l().getResources().getString(R.string.block_list_removed_toast), 0).show();
                            this.f1583a.f1563g.remove(i);
                        }
                    }
                    break;
                } else {
                    C3641ai.m13210a(CommonApplication.m11493l(), R.string.dev_network_error, 0).show();
                    this.f1583a.m3118a();
                    break;
                }
                break;
        }
    }
}
