package com.sec.chaton.settings.tellfriends;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.GetSnsFriendsList;
import com.sec.chaton.p028io.entry.inner.GetSnsFriends;
import com.sec.chaton.util.C1786r;
import java.util.ArrayList;

/* compiled from: SnsFriendsUsingChatOnActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.ak */
/* loaded from: classes.dex */
class HandlerC1356ak extends Handler {

    /* renamed from: a */
    final /* synthetic */ SnsFriendsUsingChatOnActivity f5174a;

    HandlerC1356ak(SnsFriendsUsingChatOnActivity snsFriendsUsingChatOnActivity) {
        this.f5174a = snsFriendsUsingChatOnActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0101b c0101b = (C0101b) message.obj;
        switch (message.what) {
            case 314:
                if (!c0101b.m664a() || c0101b.m665b() == EnumC0803m.ERROR) {
                    this.f5174a.m4863m();
                    break;
                } else if (c0101b.m665b() != EnumC0803m.NO_CONTENT) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = ((GetSnsFriendsList) c0101b.m671d()).sns;
                    if (arrayList2 != null) {
                        for (int i = 0; i < arrayList2.size(); i++) {
                            C1786r.m6066e("sp : " + ((GetSnsFriends) arrayList2.get(i)).f3050sp + ", snsid : " + ((GetSnsFriends) arrayList2.get(i)).snsid + ", userid : " + ((GetSnsFriends) arrayList2.get(i)).userid + ", userid : " + ((GetSnsFriends) arrayList2.get(i)).username, getClass().getSimpleName());
                            arrayList.add(new C1363ar(this.f5174a, ((GetSnsFriends) arrayList2.get(i)).f3050sp, ((GetSnsFriends) arrayList2.get(i)).snsid, ((GetSnsFriends) arrayList2.get(i)).userid, ((GetSnsFriends) arrayList2.get(i)).username));
                        }
                    }
                    this.f5174a.f4996n.clear();
                    this.f5174a.f4996n.addAll(arrayList);
                    if (this.f5174a.f4996n.size() > 0) {
                        if (this.f5174a.f4993k.equals("facebook")) {
                            for (int i2 = 0; i2 < this.f5174a.f4996n.size(); i2++) {
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= this.f5174a.f4990h.size()) {
                                        break;
                                    }
                                    if (((C1363ar) this.f5174a.f4996n.get(i2)).f5190b.equals(((C1342a) this.f5174a.f4990h.get(i3)).m5066a())) {
                                        this.f5174a.f4991i.add(new C1342a(((C1342a) this.f5174a.f4990h.get(i3)).m5066a(), ((C1342a) this.f5174a.f4990h.get(i3)).m5068b(), ((C1342a) this.f5174a.f4990h.get(i3)).m5070d()));
                                        ((C1342a) this.f5174a.f4991i.get(this.f5174a.f4991i.size() - 1)).m5067a(((C1363ar) this.f5174a.f4996n.get(i2)).f5191c);
                                        this.f5174a.f4990h.remove(i3);
                                    } else {
                                        i3++;
                                    }
                                }
                            }
                        } else if (this.f5174a.f4993k.equals("twitter")) {
                            if (this.f5174a.f5005w == null) {
                                AsyncTaskC1365at asyncTaskC1365at = new AsyncTaskC1365at(this.f5174a);
                                if (this.f5174a.f5004v) {
                                    asyncTaskC1365at.execute(new Void[0]);
                                } else {
                                    asyncTaskC1365at.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                }
                            }
                        } else if (this.f5174a.f4993k.equals("weibo") && this.f5174a.f4997o == null) {
                            AsyncTaskC1366au asyncTaskC1366au = new AsyncTaskC1366au(this.f5174a);
                            if (this.f5174a.f5004v) {
                                asyncTaskC1366au.execute(new Void[0]);
                            } else {
                                asyncTaskC1366au.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                            }
                        }
                        this.f5174a.f4988f.notifyDataSetChanged();
                        break;
                    }
                }
                break;
        }
        this.f5174a.m4857j();
        this.f5174a.f4989g.m5094b();
    }
}
