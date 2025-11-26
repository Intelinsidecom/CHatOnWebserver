package com.sec.chaton.settings.tellfriends.common;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.GetBuddyList;
import com.sec.chaton.p035io.entry.GetSnsFriendsList;
import com.sec.chaton.p035io.entry.inner.Buddy;
import com.sec.chaton.p035io.entry.inner.GetSnsFriends;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.settings.tellfriends.C2732ai;
import com.sec.widget.C3641ai;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: SnsFriendsPickerFragment.java */
/* renamed from: com.sec.chaton.settings.tellfriends.common.l */
/* loaded from: classes.dex */
class HandlerC2796l extends Handler {

    /* renamed from: a */
    final /* synthetic */ SnsFriendsPickerFragment f10291a;

    HandlerC2796l(SnsFriendsPickerFragment snsFriendsPickerFragment) {
        this.f10291a = snsFriendsPickerFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0267d c0267d = (C0267d) message.obj;
        switch (message.what) {
            case 303:
                if (c0267d.m11704n() && c0267d.m1351b() == EnumC1587o.SUCCESS) {
                    if (c0267d.m1354e() != null) {
                        Iterator<Buddy> it = ((GetBuddyList) c0267d.m1354e()).buddy.iterator();
                        while (it.hasNext()) {
                            Buddy next = it.next();
                            if (this.f10291a.f10233o.containsKey(next.value)) {
                                this.f10291a.f10219a.remove((C2732ai) this.f10291a.f10233o.get(next.value));
                            }
                        }
                    }
                    C3641ai.m13210a(this.f10291a.f10222d, R.string.buddy_suggestion_added_to_list, 0).show();
                    break;
                } else if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.SUCCESS) {
                    C3641ai.m13210a(this.f10291a.f10222d, R.string.buddy_list_dialog_addbuddy_network_failed, 0).show();
                    this.f10291a.f10222d.finish();
                    break;
                } else {
                    this.f10291a.m9928a(c0267d.m1355f());
                    break;
                }
                break;
            case 311:
                if (c0267d.m11704n() && c0267d.m1351b() == EnumC1587o.SUCCESS) {
                    this.f10291a.f10219a.clear();
                    C3641ai.m13210a(this.f10291a.f10222d, R.string.tellfriends_added, 0).show();
                    break;
                } else if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.SUCCESS) {
                    C3641ai.m13210a(this.f10291a.f10222d, R.string.buddy_list_dialog_addbuddy_network_failed, 0).show();
                    this.f10291a.f10222d.finish();
                    break;
                } else {
                    this.f10291a.m9928a(c0267d.m1355f());
                    break;
                }
                break;
            case 313:
                if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                    this.f10291a.m9959l();
                    break;
                } else {
                    this.f10291a.f10231m.m5725a(this.f10291a.m9961n(), this.f10291a.f10221c);
                    break;
                }
                break;
            case 314:
                if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                    this.f10291a.m9960m();
                } else if (c0267d.m1351b() != EnumC1587o.NO_CONTENT) {
                    ArrayList<GetSnsFriends> arrayList = ((GetSnsFriendsList) c0267d.m1354e()).sns;
                    this.f10291a.f10233o.clear();
                    if (arrayList != null && !arrayList.isEmpty()) {
                        for (GetSnsFriends getSnsFriends : arrayList) {
                            Iterator it2 = this.f10291a.f10232n.iterator();
                            while (it2.hasNext()) {
                                C2732ai c2732ai = (C2732ai) it2.next();
                                if (getSnsFriends.snsid.equals(c2732ai.m9783a())) {
                                    c2732ai.m9784a(getSnsFriends.snsid);
                                    this.f10291a.f10233o.put(getSnsFriends.userid, c2732ai);
                                }
                            }
                        }
                    }
                    this.f10291a.f10219a.addAll(this.f10291a.f10233o.values());
                    this.f10291a.f10219a.notifyDataSetChanged();
                }
                this.f10291a.m9953i();
                break;
        }
    }
}
