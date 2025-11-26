package com.sec.chaton.push.message.processer;

import android.content.Intent;
import com.google.protobuf.MessageLite;
import com.sec.chaton.push.exception.ConnectionException;
import com.sec.chaton.push.heartbeat.HeartBeat;
import com.sec.chaton.push.network.MessageContext;
import com.sec.chaton.push.provisioning.ProvisioningManager;
import com.sec.chaton.push.registration.RegistrationManager;
import com.sec.chaton.push.util.PushLog;
import com.sec.pns.msg.MsgResultCode;
import com.sec.pns.msg.frontend.MsgFrontend;

/* renamed from: com.sec.chaton.push.message.processer.ac */
/* loaded from: classes.dex */
class C0366ac implements MessageContext.ICallback {

    /* renamed from: a */
    final /* synthetic */ ICallback f2675a;

    /* renamed from: b */
    final /* synthetic */ String f2676b;

    /* renamed from: c */
    final /* synthetic */ DeregistrationMessageProcesser f2677c;

    C0366ac(DeregistrationMessageProcesser deregistrationMessageProcesser, ICallback iCallback, String str) {
        this.f2677c = deregistrationMessageProcesser;
        this.f2675a = iCallback;
        this.f2676b = str;
    }

    @Override // com.sec.chaton.push.network.MessageContext.ICallback
    /* renamed from: a */
    public void mo2959a(int i, MessageLite messageLite) {
        PushLog.m3031d(DeregistrationMessageProcesser.f2625d, "onFailed. ErrorCode: " + i);
        this.f2677c.m2883a(this.f2675a, i);
    }

    @Override // com.sec.chaton.push.network.MessageContext.ICallback
    /* renamed from: a */
    public void mo2960a(MessageLite messageLite, MessageLite messageLite2) {
        int resultCode = ((MsgFrontend.DeregistrationReply) messageLite2).getResultCode();
        if (resultCode == 1000) {
            RegistrationManager.m3010a(this.f2677c.f2626e);
            RegistrationManager.m3014c(this.f2677c.f2626e);
            try {
                PushLog.m3025a(DeregistrationMessageProcesser.f2625d, "Disconnect push connection");
                this.f2677c.f2623b.m2935h().m2982b();
            } catch (ConnectionException e) {
            }
            PushLog.m3025a(DeregistrationMessageProcesser.f2625d, "Stop HeartBeat");
            HeartBeat.m2874b(this.f2677c.f2626e);
            this.f2677c.f2626e.stopService(new Intent("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION"));
            this.f2677c.m2884a(this.f2675a, (Object) null);
            return;
        }
        if (resultCode == 4002 || resultCode == 4009) {
            switch (resultCode) {
                case MsgResultCode.EMPTY_DEVICE_TOKEN /* 4002 */:
                    PushLog.m3031d(DeregistrationMessageProcesser.f2625d, "Server error: empty device token");
                    break;
                case MsgResultCode.WRONG_DEVICE_TOKEN /* 4009 */:
                    PushLog.m3031d(DeregistrationMessageProcesser.f2625d, "Server error: wrong device token");
                    break;
            }
            PushLog.m3031d(DeregistrationMessageProcesser.f2625d, " > Disconnect");
            try {
                this.f2677c.f2627f.m2982b();
            } catch (ConnectionException e2) {
            }
            PushLog.m3031d(DeregistrationMessageProcesser.f2625d, " > Execute re-provisioning");
            ProvisioningManager.m3000b(this.f2677c.f2626e);
            this.f2677c.m2883a(this.f2675a, resultCode);
            this.f2677c.m2882a(0, true);
            return;
        }
        if (resultCode == 4004) {
            PushLog.m3031d(DeregistrationMessageProcesser.f2625d, "Server error: empty registration id");
            PushLog.m3031d(DeregistrationMessageProcesser.f2625d, " > Do not anything");
            this.f2677c.m2883a(this.f2675a, resultCode);
            return;
        }
        if (resultCode == 4001) {
            PushLog.m3031d(DeregistrationMessageProcesser.f2625d, "Server error: invalid state");
            PushLog.m3031d(DeregistrationMessageProcesser.f2625d, " > 1) Disconnect");
            try {
                this.f2677c.f2627f.m2982b();
            } catch (ConnectionException e3) {
            }
            this.f2677c.m2883a(this.f2675a, resultCode);
            PushLog.m3031d(DeregistrationMessageProcesser.f2625d, " > 2) Execute initialization");
            this.f2677c.m2881a(0);
            return;
        }
        if (resultCode != 4008) {
            PushLog.m3031d(DeregistrationMessageProcesser.f2625d, "Unknown error code: " + resultCode);
            this.f2677c.m2883a(this.f2675a, resultCode);
            return;
        }
        PushLog.m3031d(DeregistrationMessageProcesser.f2625d, "Server error: deregistration failed");
        PushLog.m3031d(DeregistrationMessageProcesser.f2625d, " > 1) Disconnect");
        try {
            this.f2677c.f2627f.m2982b();
        } catch (ConnectionException e4) {
        }
        if (this.f2677c.f2623b.m2939l() == EnumC0374i.Primary) {
            PushLog.m3031d(DeregistrationMessageProcesser.f2625d, " > 2) Try to process with another push server");
            this.f2677c.f2623b.m2940m();
            this.f2677c.f2623b.m2926b(this.f2676b, this.f2675a);
        } else {
            PushLog.m3031d(DeregistrationMessageProcesser.f2625d, " > 2) Re-execute provisioning");
            ProvisioningManager.m3000b(this.f2677c.f2626e);
            this.f2677c.m2883a(this.f2675a, resultCode);
            this.f2677c.m2882a(0, true);
        }
    }
}
