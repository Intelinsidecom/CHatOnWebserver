package com.sec.chaton.buddy;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.GetLiveGroupFollowerList;
import com.sec.chaton.p065io.entry.inner.LiveGroupFollower;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;
import java.util.ArrayList;

/* compiled from: BuddyLiveGroupFragment.java */
/* renamed from: com.sec.chaton.buddy.fk */
/* loaded from: classes.dex */
class HandlerC1304fk extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyLiveGroupFragment f4840a;

    HandlerC1304fk(BuddyLiveGroupFragment buddyLiveGroupFragment) {
        this.f4840a = buddyLiveGroupFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0778b c0778b = (C0778b) message.obj;
        if (this.f4840a.f3886e != null) {
            switch (message.what) {
                case 2001:
                    if (this.f4840a.f3888g != null && this.f4840a.f3888g.isShowing()) {
                        try {
                            this.f4840a.m6740b();
                        } catch (IllegalArgumentException e) {
                            C4904y.m18635a(e, getClass().getSimpleName());
                        }
                    }
                    if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                        if (this.f4840a.f3886e != null) {
                            C5179v.m19810a(this.f4840a.f3886e, R.string.popup_no_network_connection, 1).show();
                            this.f4840a.f3886e.finish();
                            break;
                        }
                    } else {
                        ArrayList arrayList = new ArrayList();
                        if (c0778b.m3107b() != EnumC2464o.NO_CONTENT) {
                            this.f4840a.f3887f = ((GetLiveGroupFollowerList) c0778b.m3110e()).follower;
                            if (this.f4840a.f3887f != null && this.f4840a.f3887f.size() != 0) {
                                arrayList.addAll(this.f4840a.f3887f);
                                int i = 0;
                                while (true) {
                                    int i2 = i;
                                    if (i2 < this.f4840a.f3887f.size()) {
                                        if (TextUtils.isEmpty(((LiveGroupFollower) this.f4840a.f3887f.get(i2)).name) || ((LiveGroupFollower) this.f4840a.f3887f.get(i2)).name.contains("\n")) {
                                            arrayList.remove(this.f4840a.f3887f.get(i2));
                                        }
                                        C4904y.m18646e("NO : " + ((LiveGroupFollower) this.f4840a.f3887f.get(i2)).chatonid + ", Name : " + ((LiveGroupFollower) this.f4840a.f3887f.get(i2)).name + ", msgstatus : " + ((LiveGroupFollower) this.f4840a.f3887f.get(i2)).msgstatus, getClass().getSimpleName());
                                        i = i2 + 1;
                                    }
                                }
                            }
                        }
                        BuddyFragment buddyFragment = new BuddyFragment();
                        buddyFragment.setArguments(this.f4840a.f3886e.getIntent().getExtras());
                        buddyFragment.getArguments().putSerializable("live_group_followers", arrayList);
                        this.f4840a.getActivity().m50e().mo183a().mo96a(R.id.fragment_controller, buddyFragment, "com.sec.chaton:single_pane_fragment").mo99b();
                        break;
                    }
                    break;
            }
        }
    }
}
