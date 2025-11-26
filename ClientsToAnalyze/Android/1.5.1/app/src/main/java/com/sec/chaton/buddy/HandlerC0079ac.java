package com.sec.chaton.buddy;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.C0062R;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.p000io.entry.GetBlockBuddyList;
import com.sec.chaton.p000io.entry.inner.BlockBuddy;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.buddy.ac */
/* loaded from: classes.dex */
class HandlerC0079ac extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileActivity f613a;

    HandlerC0079ac(BuddyProfileActivity buddyProfileActivity) {
        this.f613a = buddyProfileActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        HttpEntry httpEntry = (HttpEntry) message.obj;
        if (message.what == 601) {
            if (httpEntry.m1950a() && httpEntry.m1951b() == HttpResultCode.SUCCESS) {
                for (BlockBuddy blockBuddy : ((GetBlockBuddyList) httpEntry.m1955d()).buddy) {
                    ChatONLogWriter.m3506b("******* BLOCKED BUDDY : " + blockBuddy.value, null);
                    if (blockBuddy.value.equals(this.f613a.f586k)) {
                        this.f613a.f558E.setVisibility(8);
                        this.f613a.f556C.setVisibility(8);
                        this.f613a.f557D.setVisibility(0);
                        this.f613a.f559F.setVisibility(0);
                        this.f613a.f560G.setText(String.format(this.f613a.getResources().getString(C0062R.string.new_buddy_information_unblock), this.f613a.f590o.getText().toString()));
                        if (this.f613a.f561H != null) {
                            this.f613a.f561H.dismiss();
                            return;
                        }
                        return;
                    }
                }
            }
            this.f613a.f558E.setVisibility(0);
            this.f613a.f556C.setVisibility(0);
            this.f613a.f557D.setVisibility(8);
            this.f613a.f559F.setVisibility(8);
            this.f613a.f560G.setText(String.format(this.f613a.getResources().getString(C0062R.string.new_buddy_information), this.f613a.f590o.getText().toString()));
        }
        if (this.f613a.f561H != null) {
            this.f613a.f561H.dismiss();
        }
    }
}
