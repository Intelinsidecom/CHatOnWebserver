package com.sec.chaton.registration;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.GetVersionNotice;
import com.sec.chaton.registration.ActivityNonSelfSMS;

/* compiled from: ActivityNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.g */
/* loaded from: classes.dex */
class HandlerC1194g extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivityNonSelfSMS.NonSelfSMSFragment f4409a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC1194g(ActivityNonSelfSMS.NonSelfSMSFragment nonSelfSMSFragment, Looper looper) {
        super(looper);
        this.f4409a = nonSelfSMSFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        GetVersionNotice getVersionNotice;
        C0101b c0101b = (C0101b) message.obj;
        if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR && (getVersionNotice = (GetVersionNotice) c0101b.m671d()) != null) {
            if (getVersionNotice.uptodate.booleanValue() || !getVersionNotice.critical.booleanValue()) {
                this.f4409a.m4360j();
                this.f4409a.m4342b();
            }
        }
    }
}
