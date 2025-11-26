package com.sec.chaton.buddy;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ca */
/* loaded from: classes.dex */
class HandlerC1164ca extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4383a;

    HandlerC1164ca(BuddyFragment buddyFragment) {
        this.f4383a = buddyFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 302:
                C0778b c0778b = (C0778b) message.obj;
                this.f4383a.m6327W();
                if (c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.SUCCESS) {
                    C4809aa.m18104a().m18125b("Is Group Uploaded", (Boolean) true);
                    C4904y.m18641c("local group info upload to server", getClass().getSimpleName());
                    if (!C4809aa.m18104a().m18119a("Is Group Profile Image Name Changed", (Boolean) false).booleanValue()) {
                        this.f4383a.m6299I();
                        break;
                    }
                } else {
                    if (System.currentTimeMillis() - C4809aa.m18104a().m18118a("Is group sync last call time", 0L) > 600000) {
                        this.f4383a.m6296G();
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        C4809aa.m18104a().m18124a("Is group sync last call time", Long.valueOf(jCurrentTimeMillis));
                        C4904y.m18641c("group info upload fail and retry, last sync call time : " + jCurrentTimeMillis, getClass().getSimpleName());
                    }
                    C4904y.m18641c("group info upload fail, last sync call time interval invaild", getClass().getSimpleName());
                    break;
                }
                break;
        }
    }
}
