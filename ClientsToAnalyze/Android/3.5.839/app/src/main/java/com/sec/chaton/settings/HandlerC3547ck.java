package com.sec.chaton.settings;

import android.os.Message;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.HandlerC4826ar;

/* compiled from: ActivityPasswordLockSet.java */
/* renamed from: com.sec.chaton.settings.ck */
/* loaded from: classes.dex */
class HandlerC3547ck extends HandlerC4826ar {

    /* renamed from: a */
    final /* synthetic */ ActivityPasswordLockSet f13036a;

    HandlerC3547ck(ActivityPasswordLockSet activityPasswordLockSet) {
        this.f13036a = activityPasswordLockSet;
    }

    @Override // com.sec.chaton.util.HandlerC4826ar
    /* renamed from: a */
    public void mo6050a(Message message) {
        if (message.what == 1002) {
            if (((Boolean) message.obj).booleanValue()) {
                C4904y.m18639b("Push deregistration is success. execute chaton deregistration.", this.f13036a.f12594g);
            } else {
                C4904y.m18639b("Push deregistration is fail", this.f13036a.f12594g);
            }
            new AsyncTaskC3549cm(this.f13036a, null).execute(new Void[0]);
        }
    }
}
