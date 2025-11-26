package com.sec.chaton.registration;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: ActivitySyncSignInPopup.java */
/* renamed from: com.sec.chaton.registration.aa */
/* loaded from: classes.dex */
class HandlerC2123aa extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivitySyncSignInPopup f8389a;

    HandlerC2123aa(ActivitySyncSignInPopup activitySyncSignInPopup) {
        this.f8389a = activitySyncSignInPopup;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (!this.f8389a.f8101F) {
            switch (message.what) {
                case HttpResponseCode.FOUND /* 302 */:
                    C0267d c0267d = (C0267d) message.obj;
                    if (!c0267d.m11704n()) {
                        this.f8389a.m8398a(EnumC2124ab.upload_all_group, c0267d.m1356g());
                        break;
                    } else {
                        C3159aa.m10962a().m10983b("Is Group Uploaded", (Boolean) true);
                        C3250y.m11453c("local group info upload to server", getClass().getSimpleName());
                        this.f8389a.f8127p.m5614a();
                        break;
                    }
            }
        }
    }
}
