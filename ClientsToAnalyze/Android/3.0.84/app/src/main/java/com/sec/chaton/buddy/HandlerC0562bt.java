package com.sec.chaton.buddy;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bt */
/* loaded from: classes.dex */
class HandlerC0562bt extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2521a;

    HandlerC0562bt(BuddyFragment buddyFragment) {
        this.f2521a = buddyFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case HttpResponseCode.FOUND /* 302 */:
                C0267d c0267d = (C0267d) message.obj;
                this.f2521a.m3264Z();
                if (c0267d.m11704n() && c0267d.m1351b() == EnumC1587o.SUCCESS) {
                    C3159aa.m10962a().m10983b("Is Group Uploaded", (Boolean) true);
                    C3250y.m11453c("local group info upload to server", getClass().getSimpleName());
                    if (!C3159aa.m10962a().m10977a("Is Group Profile Image Name Changed", (Boolean) false).booleanValue()) {
                        this.f2521a.m3235L();
                        break;
                    }
                } else {
                    if (System.currentTimeMillis() - C3159aa.m10962a().m10976a("Is group sync last call time", 0L) > 600000) {
                        this.f2521a.m3234K();
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        C3159aa.m10962a().m10982a("Is group sync last call time", Long.valueOf(jCurrentTimeMillis));
                        C3250y.m11453c("group info upload fail and retry, last sync call time : " + jCurrentTimeMillis, getClass().getSimpleName());
                    }
                    C3250y.m11453c("group info upload fail, last sync call time interval invaild", getClass().getSimpleName());
                    break;
                }
                break;
        }
    }
}
