package com.sec.chaton.block;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.UnBlock;

/* compiled from: BlockBuddyAdapter.java */
/* renamed from: com.sec.chaton.block.g */
/* loaded from: classes.dex */
class HandlerC0247g extends Handler {

    /* renamed from: a */
    final /* synthetic */ C0245e f827a;

    HandlerC0247g(C0245e c0245e) {
        this.f827a = c0245e;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0101b c0101b = (C0101b) message.obj;
        switch (message.what) {
            case 317:
                if (this.f827a.f820g != null && !this.f827a.f820g.isShowing()) {
                    this.f827a.f820g.dismiss();
                }
                if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
                    this.f827a.notifyDataSetChanged();
                    break;
                }
                break;
            case 603:
                this.f827a.f820g.dismiss();
                if (!c0101b.m664a() || c0101b.m665b() == EnumC0803m.ERROR) {
                    Toast.makeText(this.f827a.f816c, R.string.dev_network_error, 0).show();
                    break;
                } else {
                    UnBlock unBlock = (UnBlock) c0101b.m671d();
                    for (int i = 0; i < this.f827a.f814a.size(); i++) {
                        if (unBlock.buddyid.equals(((C0253m) this.f827a.f814a.get(i)).f837b)) {
                            Toast.makeText(this.f827a.f816c, this.f827a.f816c.getResources().getString(R.string.setting_buddy_unblocked, this.f827a.f818e), 0).show();
                            this.f827a.f814a.remove(i);
                        }
                    }
                    if (this.f827a.f814a.size() > 0) {
                        this.f827a.f823j.setVisibility(0);
                        this.f827a.f822i.setVisibility(8);
                    } else {
                        this.f827a.f823j.setVisibility(8);
                        this.f827a.f822i.setVisibility(0);
                    }
                    this.f827a.notifyDataSetChanged();
                    break;
                }
                break;
        }
    }
}
