package com.sec.chaton.sns.p115ui;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.GetBuddyList;
import com.sec.chaton.p065io.entry.GetSnsFriendsList;
import com.sec.chaton.p065io.entry.inner.Buddy;
import com.sec.chaton.p065io.entry.inner.GetSnsFriends;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.sns.p114b.C4379ae;
import com.sec.widget.C5179v;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: SnsFriendsPickerFragment.java */
/* renamed from: com.sec.chaton.sns.ui.y */
/* loaded from: classes.dex */
class HandlerC4522y extends Handler {

    /* renamed from: a */
    final /* synthetic */ SnsFriendsPickerFragment f16278a;

    HandlerC4522y(SnsFriendsPickerFragment snsFriendsPickerFragment) {
        this.f16278a = snsFriendsPickerFragment;
    }

    @Override // android.os.Handler
    @SuppressLint({"NewApi"})
    public void handleMessage(Message message) {
        C0778b c0778b = (C0778b) message.obj;
        switch (message.what) {
            case 303:
                if (c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.SUCCESS) {
                    if (c0778b.m3110e() != null) {
                        Iterator<Buddy> it = ((GetBuddyList) c0778b.m3110e()).buddy.iterator();
                        while (it.hasNext()) {
                            Buddy next = it.next();
                            if (this.f16278a.f16035t.containsKey(next.value)) {
                                this.f16278a.f16016a.remove((C4379ae) this.f16278a.f16035t.get(next.value));
                            }
                        }
                    }
                    C5179v.m19810a(this.f16278a.f16019d, R.string.buddy_suggestion_added_to_list, 0).show();
                    break;
                } else if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.SUCCESS) {
                    C5179v.m19810a(this.f16278a.f16019d, R.string.buddy_list_dialog_addbuddy_network_failed, 0).show();
                    this.f16278a.f16019d.finish();
                    break;
                } else {
                    this.f16278a.m16852a(c0778b.m3111f());
                    break;
                }
                break;
            case 311:
                if (c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.SUCCESS) {
                    this.f16278a.f16016a.clear();
                    C5179v.m19810a(this.f16278a.f16019d, R.string.tellfriends_added, 0).show();
                    break;
                } else if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.SUCCESS) {
                    C5179v.m19810a(this.f16278a.f16019d, R.string.buddy_list_dialog_addbuddy_network_failed, 0).show();
                    this.f16278a.f16019d.finish();
                    break;
                } else {
                    this.f16278a.m16852a(c0778b.m3111f());
                    break;
                }
                break;
            case 313:
                if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                    this.f16278a.m16883l();
                    break;
                } else {
                    this.f16278a.f16033r.m9502a(this.f16278a.m16885n(), this.f16278a.f16018c);
                    break;
                }
                break;
            case 314:
                if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                    this.f16278a.m16884m();
                } else if (c0778b.m3107b() != EnumC2464o.NO_CONTENT) {
                    ArrayList<GetSnsFriends> arrayList = ((GetSnsFriendsList) c0778b.m3110e()).sns;
                    this.f16278a.f16035t.clear();
                    if (arrayList != null && !arrayList.isEmpty()) {
                        for (GetSnsFriends getSnsFriends : arrayList) {
                            Iterator it2 = this.f16278a.f16034s.iterator();
                            while (it2.hasNext()) {
                                C4379ae c4379ae = (C4379ae) it2.next();
                                if (getSnsFriends.snsid.equals(c4379ae.m16625a())) {
                                    c4379ae.m16626a(getSnsFriends.snsid);
                                    this.f16278a.f16035t.put(getSnsFriends.userid, c4379ae);
                                }
                            }
                        }
                    }
                    this.f16278a.f16016a.addAll(this.f16278a.f16035t.values());
                    this.f16278a.f16016a.notifyDataSetChanged();
                }
                this.f16278a.m16877i();
                break;
        }
    }
}
