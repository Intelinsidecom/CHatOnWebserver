package com.sec.chaton.block;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.p000io.entry.UnBlock;

/* renamed from: com.sec.chaton.block.c */
/* loaded from: classes.dex */
class HandlerC0073c extends Handler {

    /* renamed from: a */
    final /* synthetic */ BlockBuddyAdapter f377a;

    HandlerC0073c(BlockBuddyAdapter blockBuddyAdapter) {
        this.f377a = blockBuddyAdapter;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        HttpEntry httpEntry = (HttpEntry) message.obj;
        switch (message.what) {
            case 603:
                this.f377a.f363i.dismiss();
                if (!httpEntry.m1950a() || httpEntry.m1951b() == HttpResultCode.ERROR) {
                    Toast.makeText(this.f377a.f357c, C0062R.string.dev_network_error, 0).show();
                    break;
                } else {
                    UnBlock unBlock = (UnBlock) httpEntry.m1955d();
                    for (int i = 0; i < this.f377a.f355a.size(); i++) {
                        if (unBlock.buddyid.equals(((C0071a) this.f377a.f355a.get(i)).f372b)) {
                            Toast.makeText(this.f377a.f357c, this.f377a.f357c.getResources().getString(C0062R.string.setting_buddy_unblocked, this.f377a.f360f), 0).show();
                            this.f377a.f355a.remove(i);
                        }
                    }
                    if (this.f377a.f355a.size() > 0) {
                        this.f377a.f366l.setVisibility(0);
                        this.f377a.f365k.setVisibility(8);
                        this.f377a.notifyDataSetChanged();
                        break;
                    } else {
                        this.f377a.f366l.setVisibility(8);
                        this.f377a.f365k.setVisibility(0);
                        break;
                    }
                }
                break;
        }
    }
}
