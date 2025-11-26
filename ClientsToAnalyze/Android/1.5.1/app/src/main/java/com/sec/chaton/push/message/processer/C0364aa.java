package com.sec.chaton.push.message.processer;

import android.content.Intent;
import com.google.protobuf.MessageLite;
import com.sec.chaton.push.exception.ConnectionException;
import com.sec.chaton.push.heartbeat.HeartBeat;
import com.sec.chaton.push.network.MessageContext;
import com.sec.chaton.push.provisioning.ProvisioningManager;
import com.sec.chaton.push.registration.RegistrationManager;
import com.sec.chaton.push.util.PushLog;
import com.sec.pns.msg.frontend.MsgFrontend;

/* renamed from: com.sec.chaton.push.message.processer.aa */
/* loaded from: classes.dex */
class C0364aa implements MessageContext.ICallback {

    /* renamed from: a */
    final /* synthetic */ String f2669a;

    /* renamed from: b */
    final /* synthetic */ ICallback f2670b;

    /* renamed from: c */
    final /* synthetic */ RegistrationMessageProcesser f2671c;

    C0364aa(RegistrationMessageProcesser registrationMessageProcesser, String str, ICallback iCallback) {
        this.f2671c = registrationMessageProcesser;
        this.f2669a = str;
        this.f2670b = iCallback;
    }

    @Override // com.sec.chaton.push.network.MessageContext.ICallback
    /* renamed from: a */
    public void mo2959a(int i, MessageLite messageLite) {
        PushLog.m3031d(RegistrationMessageProcesser.f2665d, "OnFailed: ErrorCode(" + i + ")");
        this.f2671c.m2883a(this.f2670b, i);
    }

    @Override // com.sec.chaton.push.network.MessageContext.ICallback
    /* renamed from: a */
    public void mo2960a(MessageLite messageLite, MessageLite messageLite2) {
        MsgFrontend.RegistrationReply registrationReply = (MsgFrontend.RegistrationReply) messageLite2;
        int resultCode = registrationReply.getResultCode();
        if (resultCode == 1000) {
            RegistrationManager.m3011a(this.f2671c.f2666e, this.f2669a);
            RegistrationManager.m3013b(this.f2671c.f2666e, registrationReply.getRegId());
            PushLog.m3025a(RegistrationMessageProcesser.f2665d, "Start HeartBeat.");
            HeartBeat.m2871a(this.f2671c.f2666e.getApplicationContext());
            this.f2671c.f2666e.startService(new Intent("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION"));
            this.f2671c.m2884a(this.f2670b, (Object) null);
            return;
        }
        if (resultCode == 4002) {
            PushLog.m3031d(RegistrationMessageProcesser.f2665d, "Server error: empty device token");
            PushLog.m3031d(RegistrationMessageProcesser.f2665d, " > Disconnect");
            try {
                this.f2671c.f2667f.m2982b();
            } catch (ConnectionException e) {
            }
            PushLog.m3031d(RegistrationMessageProcesser.f2665d, " > Execute re-provisioning after wait time");
            ProvisioningManager.m3000b(this.f2671c.f2666e);
            this.f2671c.m2883a(this.f2670b, resultCode);
            this.f2671c.m2882a(0, true);
            return;
        }
        if (resultCode == 4003) {
            PushLog.m3031d(RegistrationMessageProcesser.f2665d, "Server error: empty application id");
            PushLog.m3031d(RegistrationMessageProcesser.f2665d, " > Do not anything");
            this.f2671c.m2883a(this.f2670b, resultCode);
        } else {
            if (resultCode == 4001) {
                PushLog.m3031d(RegistrationMessageProcesser.f2665d, "Server error: invalid state");
                PushLog.m3031d(RegistrationMessageProcesser.f2665d, " > 1) Disconnect");
                try {
                    this.f2671c.f2667f.m2982b();
                } catch (Exception e2) {
                }
                this.f2671c.m2883a(this.f2670b, resultCode);
                PushLog.m3031d(RegistrationMessageProcesser.f2665d, " > 2) Execute initialization");
                this.f2671c.m2881a(0);
                return;
            }
            if (resultCode != 4007) {
                this.f2671c.m2883a(this.f2670b, resultCode);
                return;
            }
            PushLog.m3031d(RegistrationMessageProcesser.f2665d, "Server error: registration failed");
            PushLog.m3031d(RegistrationMessageProcesser.f2665d, " > Do not anything");
            this.f2671c.m2883a(this.f2670b, resultCode);
        }
    }
}
