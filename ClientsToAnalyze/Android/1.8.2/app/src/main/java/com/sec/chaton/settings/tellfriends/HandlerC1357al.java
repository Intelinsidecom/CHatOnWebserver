package com.sec.chaton.settings.tellfriends;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.GetBuddyList;
import com.sec.chaton.p028io.entry.inner.Buddy;
import com.sec.chaton.util.C1786r;
import com.sec.widget.C2153y;
import java.util.Iterator;

/* compiled from: SnsFriendsUsingChatOnActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.al */
/* loaded from: classes.dex */
class HandlerC1357al extends Handler {

    /* renamed from: a */
    final /* synthetic */ SnsFriendsUsingChatOnActivity f5175a;

    HandlerC1357al(SnsFriendsUsingChatOnActivity snsFriendsUsingChatOnActivity) {
        this.f5175a = snsFriendsUsingChatOnActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0101b c0101b = (C0101b) message.obj;
        if (c0101b.m664a()) {
            if (message.what == 311) {
                if (c0101b.m665b() == EnumC0803m.SUCCESS) {
                    this.f5175a.f4988f.clear();
                    C2153y.m7535a(this.f5175a.getApplicationContext(), R.string.tellfriends_added, 0).show();
                } else {
                    C2153y.m7535a(this.f5175a.getApplicationContext(), R.string.buddy_list_dialog_addbuddy_network_failed, 0).show();
                    this.f5175a.finish();
                }
            } else if (message.what == 303) {
                if (c0101b.m665b() == EnumC0803m.SUCCESS) {
                    if (c0101b.m671d() != null) {
                        Iterator it = ((GetBuddyList) c0101b.m671d()).buddy.iterator();
                        while (it.hasNext()) {
                            Buddy buddy = (Buddy) it.next();
                            int i = 0;
                            while (true) {
                                if (i >= this.f5175a.f4988f.getCount()) {
                                    break;
                                }
                                if (buddy.value.equals(this.f5175a.f4988f.getItem(i).m5069c())) {
                                    this.f5175a.f4988f.remove(this.f5175a.f4988f.getItem(i));
                                    break;
                                }
                                i++;
                            }
                        }
                    }
                    C2153y.m7535a(this.f5175a.getApplicationContext(), R.string.tellfriends_added, 0).show();
                } else {
                    C1786r.m6067f("ADD BUDDY RESULT : " + c0101b.m673f(), null);
                    if (c0101b.m673f() == 16003) {
                        C2153y.m7535a(this.f5175a.getApplicationContext(), R.string.buddy_list_dialog_addbuddy_failed_your_self, 0).show();
                    } else if (c0101b.m673f() == 16004) {
                        C2153y.m7535a(this.f5175a.getApplicationContext(), R.string.buddy_list_dialog_addbuddy_failed_already_added, 0).show();
                    } else if (c0101b.m673f() == 16005) {
                        C2153y.m7535a(this.f5175a.getApplicationContext(), R.string.buddy_list_dialog_addbuddy_failed_block_buddy, 0).show();
                    } else {
                        C2153y.m7535a(this.f5175a.getApplicationContext(), R.string.buddy_list_dialog_addbuddy_network_failed, 0).show();
                        this.f5175a.finish();
                    }
                }
            }
        } else {
            C2153y.m7535a(this.f5175a.getApplicationContext(), R.string.buddy_list_dialog_addbuddy_network_failed, 0).show();
            this.f5175a.finish();
        }
        this.f5175a.m4857j();
    }
}
