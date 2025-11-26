package com.sec.chaton.block;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.UnBlock;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.widget.C3641ai;

/* compiled from: BlockBuddyAdapter.java */
/* renamed from: com.sec.chaton.block.d */
/* loaded from: classes.dex */
class HandlerC0478d extends Handler {

    /* renamed from: a */
    final /* synthetic */ C0472a f1589a;

    HandlerC0478d(C0472a c0472a) {
        this.f1589a = c0472a;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0267d c0267d = (C0267d) message.obj;
        switch (message.what) {
            case 317:
                if (this.f1589a.f1577h != null && this.f1589a.f1577h.isShowing() && !((Activity) this.f1589a.f1572c).isFinishing()) {
                    this.f1589a.f1577h.dismiss();
                }
                if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                    this.f1589a.notifyDataSetChanged();
                    break;
                }
                break;
            case 603:
                if (this.f1589a.f1577h != null && this.f1589a.f1577h.isShowing() && !((Activity) this.f1589a.f1572c).isFinishing()) {
                    this.f1589a.f1577h.dismiss();
                }
                if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                    C3641ai.m13210a(this.f1589a.f1572c, R.string.dev_network_error, 0).show();
                    break;
                } else {
                    UnBlock unBlock = (UnBlock) c0267d.m1354e();
                    for (int i = 0; i < this.f1589a.f1570a.size(); i++) {
                        if (unBlock.buddyid.equals(this.f1589a.f1570a.get(i).f1584a)) {
                            C3641ai.m13211a(this.f1589a.f1572c, this.f1589a.f1572c.getResources().getString(R.string.setting_buddy_removed_from_block_list, this.f1589a.f1574e), 0).show();
                            this.f1589a.f1570a.remove(i);
                        }
                    }
                    this.f1589a.notifyDataSetChanged();
                    this.f1589a.f1579j.mo3129a(c0267d.m1351b());
                    break;
                }
                break;
        }
    }
}
