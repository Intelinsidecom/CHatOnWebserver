package com.sec.chaton.buddy;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.GetBlockBuddyList;
import com.sec.chaton.p028io.entry.inner.BlockBuddy;
import com.sec.chaton.util.C1786r;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.dd */
/* loaded from: classes.dex */
class HandlerC0346dd extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileFragment f1489a;

    HandlerC0346dd(BuddyProfileFragment buddyProfileFragment) {
        this.f1489a = buddyProfileFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0101b c0101b = (C0101b) message.obj;
        if (message.what == 601) {
            if (c0101b.m664a() && c0101b.m665b() == EnumC0803m.SUCCESS) {
                for (BlockBuddy blockBuddy : ((GetBlockBuddyList) c0101b.m671d()).buddy) {
                    C1786r.m6061b("******* BLOCKED BUDDY : " + blockBuddy.value, null);
                    if (blockBuddy.value.equals(this.f1489a.f1159u)) {
                        this.f1489a.f1109R.setVisibility(8);
                        this.f1489a.f1107P.setVisibility(8);
                        this.f1489a.f1108Q.setVisibility(0);
                        this.f1489a.f1110S.setVisibility(0);
                        this.f1489a.f1111T.setText(String.format(this.f1489a.f1157s.getString(R.string.new_buddy_information_unblock), this.f1489a.f1164z.getText().toString()));
                        if (this.f1489a.f1112U != null && this.f1489a.f1112U.isShowing()) {
                            this.f1489a.f1112U.dismiss();
                            return;
                        }
                        return;
                    }
                }
            }
            this.f1489a.f1109R.setVisibility(0);
            this.f1489a.f1107P.setVisibility(0);
            this.f1489a.f1108Q.setVisibility(8);
            this.f1489a.f1110S.setVisibility(8);
            this.f1489a.f1111T.setText(String.format(this.f1489a.f1157s.getString(R.string.new_buddy_information), this.f1489a.f1164z.getText().toString()));
        }
        if (this.f1489a.f1112U != null && this.f1489a.f1112U.isShowing()) {
            this.f1489a.f1112U.dismiss();
        }
    }
}
