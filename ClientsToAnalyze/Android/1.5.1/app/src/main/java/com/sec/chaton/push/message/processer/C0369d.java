package com.sec.chaton.push.message.processer;

import com.google.protobuf.MessageLite;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.exception.ConnectionException;
import com.sec.chaton.push.exception.PushClientException;
import com.sec.chaton.push.heartbeat.HeartBeat;
import com.sec.chaton.push.network.MessageContext;
import com.sec.chaton.push.provisioning.ProvisioningManager;
import com.sec.chaton.push.util.PushLog;
import com.sec.pns.msg.frontend.MsgFrontend;

/* renamed from: com.sec.chaton.push.message.processer.d */
/* loaded from: classes.dex */
class C0369d implements MessageContext.ICallback {

    /* renamed from: a */
    final /* synthetic */ ICallback f2682a;

    /* renamed from: b */
    final /* synthetic */ int f2683b;

    /* renamed from: c */
    final /* synthetic */ InitMessageProcesser f2684c;

    C0369d(InitMessageProcesser initMessageProcesser, ICallback iCallback, int i) {
        this.f2684c = initMessageProcesser;
        this.f2682a = iCallback;
        this.f2683b = i;
    }

    @Override // com.sec.chaton.push.network.MessageContext.ICallback
    /* renamed from: a */
    public synchronized void mo2959a(int i, MessageLite messageLite) {
        PushLog.m3031d(InitMessageProcesser.f2628d, "OnFailed: ErrorCode(" + i + ")");
        this.f2684c.f2623b.m2921a(false);
        this.f2684c.m2883a(this.f2682a, -104);
        PushLog.m3025a(InitMessageProcesser.f2628d, "Cancel pending tasks");
        this.f2684c.f2623b.m2915a(-104);
        this.f2684c.f2623b.m2933f();
        if (i == -1) {
            try {
                this.f2684c.f2630f.m2982b();
            } catch (ConnectionException e) {
            }
            if (this.f2683b < 20) {
                PushLog.m3028b(InitMessageProcesser.f2628d, "Retry initialize after wait time(retry count: " + this.f2683b + ")");
                this.f2684c.m2881a(this.f2683b + 1);
            } else {
                PushLog.m3031d(InitMessageProcesser.f2628d, "Initialize retry count is over");
            }
        }
    }

    @Override // com.sec.chaton.push.network.MessageContext.ICallback
    /* renamed from: a */
    public synchronized void mo2960a(MessageLite messageLite, MessageLite messageLite2) {
        int resultCode = ((MsgFrontend.InitReply) messageLite2).getResultCode();
        if (resultCode == 1000) {
            this.f2684c.f2623b.m2921a(true);
            if (((PushClientApplication) this.f2684c.f2629e.getApplicationContext()).m2857a()) {
                PushLog.m3025a(InitMessageProcesser.f2628d, "Start heart beat.");
                HeartBeat.m2871a(this.f2684c.f2629e);
            } else {
                PushLog.m3025a(InitMessageProcesser.f2628d, "Service isn't started, HeartBeat will not be started.");
            }
            this.f2684c.m2884a(this.f2682a, (Object) null);
            PushLog.m3025a(InitMessageProcesser.f2628d, "Execute pending tasks");
            this.f2684c.f2623b.m2932e();
            this.f2684c.f2623b.m2933f();
        } else {
            PushLog.m3031d(InitMessageProcesser.f2628d, "Result code is error");
            this.f2684c.f2623b.m2921a(false);
            if (resultCode == 4002 || resultCode == 4006) {
                if (this.f2684c.f2630f.m2984d()) {
                    try {
                        this.f2684c.f2630f.m2982b();
                    } catch (PushClientException e) {
                    }
                }
                PushLog.m3028b(InitMessageProcesser.f2628d, "Execute re-provisioning");
                ProvisioningManager.m3000b(this.f2684c.f2629e);
                this.f2684c.m2883a(this.f2682a, -104);
                this.f2684c.m2882a(0, true);
            } else if (resultCode == 2002) {
                PushLog.m3031d(InitMessageProcesser.f2628d, "Server error: internal server error");
                if (this.f2684c.f2623b.m2939l() == EnumC0374i.Primary) {
                    PushLog.m3031d(InitMessageProcesser.f2628d, " > Disconnect connection");
                    try {
                        this.f2684c.f2630f.m2982b();
                    } catch (ConnectionException e2) {
                    }
                    PushLog.m3031d(InitMessageProcesser.f2628d, " > Retry initialize using 2nd push server");
                    this.f2684c.f2623b.m2940m();
                    this.f2684c.m2883a(this.f2682a, -104);
                    this.f2684c.f2623b.m2928b(this.f2683b + 1, (ICallback) null);
                } else if (this.f2684c.f2623b.m2939l() == EnumC0374i.Secondary) {
                    PushLog.m3031d(InitMessageProcesser.f2628d, " > Disconnect connection");
                    try {
                        this.f2684c.f2630f.m2982b();
                    } catch (ConnectionException e3) {
                    }
                    PushLog.m3031d(InitMessageProcesser.f2628d, " > Execute re-provisioning");
                    ProvisioningManager.m3000b(this.f2684c.f2629e);
                    this.f2684c.m2883a(this.f2682a, -104);
                    this.f2684c.m2882a(0, true);
                }
            } else if (resultCode == 2003) {
                try {
                    this.f2684c.f2630f.m2982b();
                } catch (ConnectionException e4) {
                }
                this.f2684c.m2883a(this.f2682a, -104);
                if (this.f2683b < 20) {
                    PushLog.m3028b(InitMessageProcesser.f2628d, "Retry initialize after wait time(retry count: " + this.f2683b + ")");
                    this.f2684c.m2881a(this.f2683b + 1);
                } else {
                    PushLog.m3031d(InitMessageProcesser.f2628d, "Initialize retry count is over");
                }
            }
            PushLog.m3025a(InitMessageProcesser.f2628d, "Cancel pending tasks");
            this.f2684c.f2623b.m2915a(-104);
            this.f2684c.f2623b.m2933f();
        }
    }
}
