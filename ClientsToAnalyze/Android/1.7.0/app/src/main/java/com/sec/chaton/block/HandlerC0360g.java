package com.sec.chaton.block;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.p033io.entry.UnBlock;
import com.sec.widget.C1619g;

/* compiled from: BlockBuddyAdapter.java */
/* renamed from: com.sec.chaton.block.g */
/* loaded from: classes.dex */
class HandlerC0360g extends Handler {

    /* renamed from: a */
    final /* synthetic */ C0358e f1056a;

    HandlerC0360g(C0358e c0358e) {
        this.f1056a = c0358e;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0259g c0259g = (C0259g) message.obj;
        switch (message.what) {
            case 603:
                this.f1056a.f1049h.dismiss();
                if (!c0259g.m927a() || c0259g.m928b() == EnumC0518y.ERROR) {
                    C1619g.m5888a(this.f1056a.f1044c, R.string.dev_network_error, 0).show();
                    break;
                } else {
                    UnBlock unBlock = (UnBlock) c0259g.m932d();
                    for (int i = 0; i < this.f1056a.f1042a.size(); i++) {
                        if (unBlock.buddyid.equals(((C0359f) this.f1056a.f1042a.get(i)).f1052a)) {
                            C1619g.m5889a(this.f1056a.f1044c, this.f1056a.f1044c.getResources().getString(R.string.setting_buddy_unblocked, this.f1056a.f1046e), 0).show();
                            this.f1056a.f1042a.remove(i);
                        }
                    }
                    this.f1056a.notifyDataSetChanged();
                    break;
                }
                break;
        }
    }
}
