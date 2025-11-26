package com.sec.chaton.block;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.UnBlock;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.widget.C5179v;

/* compiled from: BlockBuddyAdapter.java */
/* renamed from: com.sec.chaton.block.c */
/* loaded from: classes.dex */
class HandlerC1075c extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1073a f3454a;

    HandlerC1075c(C1073a c1073a) {
        this.f3454a = c1073a;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0778b c0778b = (C0778b) message.obj;
        switch (message.what) {
            case 317:
                if (this.f3454a.f3449h != null && this.f3454a.f3449h.isShowing() && !((Activity) this.f3454a.f3444c).isFinishing()) {
                    this.f3454a.f3449h.dismiss();
                }
                if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                    this.f3454a.notifyDataSetChanged();
                    break;
                }
                break;
            case 603:
                if (this.f3454a.f3449h != null && this.f3454a.f3449h.isShowing() && !((Activity) this.f3454a.f3444c).isFinishing()) {
                    this.f3454a.f3449h.dismiss();
                }
                if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                    C5179v.m19810a(this.f3454a.f3444c, R.string.dev_network_error, 0).show();
                    break;
                } else {
                    UnBlock unBlock = (UnBlock) c0778b.m3110e();
                    for (int i = 0; i < this.f3454a.f3442a.size(); i++) {
                        if (unBlock.buddyid.equals(this.f3454a.f3442a.get(i).f3484a)) {
                            C5179v.m19811a(this.f3454a.f3444c, this.f3454a.f3444c.getResources().getString(R.string.setting_buddy_unblocked, this.f3454a.f3446e), 0).show();
                            this.f3454a.f3442a.remove(i);
                        }
                    }
                    this.f3454a.notifyDataSetChanged();
                    this.f3454a.f3451j.mo6222a(c0778b.m3107b());
                    break;
                }
                break;
        }
    }
}
