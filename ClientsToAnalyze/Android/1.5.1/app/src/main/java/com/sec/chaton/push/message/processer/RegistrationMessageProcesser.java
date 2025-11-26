package com.sec.chaton.push.message.processer;

import android.content.Context;
import android.os.Handler;
import com.sec.chaton.push.network.MessageContext;
import com.sec.chaton.push.network.connection.PushConnectionManager;
import com.sec.chaton.push.provisioning.ProvisioningManager;
import com.sec.chaton.push.util.PushLog;
import com.sec.pns.msg.frontend.MsgFrontend;

/* loaded from: classes.dex */
public class RegistrationMessageProcesser extends AbstractMessageProcesser {

    /* renamed from: d */
    private static final String f2665d = RegistrationMessageProcesser.class.getSimpleName();

    /* renamed from: e */
    private Context f2666e;

    /* renamed from: f */
    private PushConnectionManager f2667f;

    public RegistrationMessageProcesser(MessageController messageController, Handler handler) {
        super(messageController, handler);
        this.f2666e = messageController.m2934g();
        this.f2667f = messageController.m2935h();
    }

    /* renamed from: a */
    public synchronized void m2957a(String str, ICallback iCallback) {
        PushLog.m3025a(f2665d, "RegistrationMessageProcesser.process()");
        if (this.f2623b.m2931d()) {
            MsgFrontend.RegistrationRequest.Builder builderNewBuilder = MsgFrontend.RegistrationRequest.newBuilder();
            builderNewBuilder.setAsyncId(m2885b());
            builderNewBuilder.setDeviceToken(ProvisioningManager.m3002d(this.f2666e));
            builderNewBuilder.setAppId(str);
            builderNewBuilder.setUserData("");
            MessageContext messageContext = new MessageContext();
            messageContext.m2971a(this.f2624c);
            messageContext.m2973a(new C0364aa(this, str, iCallback));
            messageContext.m2972a(builderNewBuilder.build());
            this.f2623b.m2935h().m2983c().write(messageContext);
        } else {
            PushLog.m3025a(f2665d, "Connection isn't initialized, add this task to pending queue");
            this.f2623b.m2917a(new C0391z(this, str, iCallback));
            if (!this.f2623b.m2930c()) {
                PushLog.m3025a(f2665d, "Execute initialization");
                this.f2623b.m2929b((ICallback) null);
            }
        }
    }
}
