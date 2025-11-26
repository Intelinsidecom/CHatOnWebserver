package com.sec.chaton.push.message.processer;

import android.content.Context;
import android.os.Handler;
import com.sec.chaton.push.network.MessageContext;
import com.sec.chaton.push.network.connection.PushConnectionManager;
import com.sec.chaton.push.provisioning.ProvisioningManager;
import com.sec.chaton.push.util.PushLog;
import com.sec.pns.msg.frontend.MsgFrontend;
import java.util.Random;

/* loaded from: classes.dex */
public class PingMessageProcesser extends AbstractMessageProcesser {

    /* renamed from: d */
    private static final String f2659d = PingMessageProcesser.class.getSimpleName();

    /* renamed from: e */
    private Context f2660e;

    /* renamed from: f */
    private PushConnectionManager f2661f;

    public PingMessageProcesser(MessageController messageController, Handler handler) {
        super(messageController, handler);
        this.f2660e = messageController.m2934g();
        this.f2661f = messageController.m2935h();
    }

    /* renamed from: a */
    public synchronized void m2949a(boolean z, ICallback iCallback) {
        PushLog.m3025a(f2659d, "PingMessageProcesser.process()");
        if (this.f2623b.m2931d()) {
            MsgFrontend.PingRequest.Builder builderNewBuilder = MsgFrontend.PingRequest.newBuilder();
            builderNewBuilder.setAsyncId(new Random(System.currentTimeMillis()).nextInt());
            builderNewBuilder.setCreatedTime(System.currentTimeMillis());
            if (z) {
                builderNewBuilder.setInterval(ProvisioningManager.m3007i(this.f2660e));
            }
            MessageContext messageContext = new MessageContext();
            messageContext.m2971a(this.f2624c);
            messageContext.m2973a(new C0371f(this, iCallback));
            messageContext.m2972a(builderNewBuilder.build());
            this.f2623b.m2935h().m2983c().write(messageContext);
        } else {
            PushLog.m3025a(f2659d, "Connection isn't initialized, add this task to pending queue");
            this.f2623b.m2917a(new C0372g(this, z, iCallback));
            if (!this.f2623b.m2930c()) {
                PushLog.m3025a(f2659d, "Execute initialization");
                this.f2623b.m2929b((ICallback) null);
            }
        }
    }
}
