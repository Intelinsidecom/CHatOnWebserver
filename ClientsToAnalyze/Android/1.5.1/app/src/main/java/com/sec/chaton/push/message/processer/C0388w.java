package com.sec.chaton.push.message.processer;

import com.google.protobuf.MessageLite;
import com.sec.chaton.push.exception.ConnectionException;
import com.sec.chaton.push.network.MessageContext;
import com.sec.chaton.push.provisioning.ProvisioningManager;
import com.sec.chaton.push.util.PushLog;
import com.sec.pns.msg.frontend.MsgFrontend;

/* renamed from: com.sec.chaton.push.message.processer.w */
/* loaded from: classes.dex */
class C0388w implements MessageContext.ICallback {

    /* renamed from: a */
    final /* synthetic */ ICallback f2727a;

    /* renamed from: b */
    final /* synthetic */ ProvMessageProcesser f2728b;

    C0388w(ProvMessageProcesser provMessageProcesser, ICallback iCallback) {
        this.f2728b = provMessageProcesser;
        this.f2727a = iCallback;
    }

    @Override // com.sec.chaton.push.network.MessageContext.ICallback
    /* renamed from: a */
    public void mo2959a(int i, MessageLite messageLite) {
        PushLog.m3031d(ProvMessageProcesser.f2662d, "onFailed. ErrorCode: " + i);
        try {
            this.f2728b.f2664f.m2982b();
        } catch (ConnectionException e) {
        }
        this.f2728b.m2883a(this.f2727a, -103);
    }

    @Override // com.sec.chaton.push.network.MessageContext.ICallback
    /* renamed from: a */
    public void mo2960a(MessageLite messageLite, MessageLite messageLite2) {
        int i;
        MsgFrontend.ProvisionReply provisionReply = (MsgFrontend.ProvisionReply) messageLite2;
        int resultCode = provisionReply.getResultCode();
        try {
            this.f2728b.f2664f.m2982b();
        } catch (ConnectionException e) {
        }
        if (resultCode != 1000) {
            if (resultCode != 3001 && resultCode != 3000) {
                this.f2728b.m2883a(this.f2727a, -103);
                return;
            } else {
                this.f2728b.m2883a(this.f2727a, -103);
                PushLog.m3031d(ProvMessageProcesser.f2662d, "Restart device");
                return;
            }
        }
        String deviceToken = provisionReply.getDeviceToken();
        String primaryIp = provisionReply.getPrimaryIp();
        int primaryPort = provisionReply.getPrimaryPort();
        String secondaryIp = provisionReply.getSecondaryIp();
        int secondaryPort = provisionReply.getSecondaryPort();
        int pingInterval = provisionReply.getPingInterval();
        if (pingInterval == 0) {
            PushLog.m3030c(ProvMessageProcesser.f2662d, "Server sent PingInterval to 0, rearrange this value to 8");
            i = 8;
        } else {
            i = pingInterval;
        }
        ProvisioningManager.m2998a(this.f2728b.f2663e, deviceToken, primaryIp, primaryPort, secondaryIp, secondaryPort, i);
        this.f2728b.m2884a(this.f2727a, (Object) null);
    }
}
