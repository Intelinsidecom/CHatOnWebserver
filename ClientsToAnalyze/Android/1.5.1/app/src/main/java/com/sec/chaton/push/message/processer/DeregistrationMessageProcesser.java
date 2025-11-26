package com.sec.chaton.push.message.processer;

import android.content.Context;
import android.os.Handler;
import com.sec.chaton.push.network.MessageContext;
import com.sec.chaton.push.network.connection.PushConnectionManager;
import com.sec.chaton.push.provisioning.ProvisioningManager;
import com.sec.chaton.push.registration.RegistrationManager;
import com.sec.chaton.push.util.PushLog;
import com.sec.pns.msg.frontend.MsgFrontend;
import java.util.Random;

/* loaded from: classes.dex */
public class DeregistrationMessageProcesser extends AbstractMessageProcesser {

    /* renamed from: d */
    private static final String f2625d = DeregistrationMessageProcesser.class.getSimpleName();

    /* renamed from: e */
    private Context f2626e;

    /* renamed from: f */
    private PushConnectionManager f2627f;

    public DeregistrationMessageProcesser(MessageController messageController, Handler handler) {
        super(messageController, handler);
        this.f2626e = messageController.m2934g();
        this.f2627f = messageController.m2935h();
    }

    /* renamed from: a */
    public synchronized void m2892a(String str, ICallback iCallback) {
        PushLog.m3025a(f2625d, "DeregistrationMessageProcesser.process()");
        if (this.f2623b.m2931d()) {
            MsgFrontend.DeregistrationRequest.Builder builderNewBuilder = MsgFrontend.DeregistrationRequest.newBuilder();
            builderNewBuilder.setAsyncId(new Random(System.currentTimeMillis()).nextInt());
            builderNewBuilder.setDeviceToken(ProvisioningManager.m3002d(this.f2626e));
            builderNewBuilder.setRegId(RegistrationManager.m3015d(this.f2626e));
            builderNewBuilder.setUserData("");
            MessageContext messageContext = new MessageContext();
            messageContext.m2971a(this.f2624c);
            messageContext.m2973a(new C0366ac(this, iCallback, str));
            messageContext.m2972a(builderNewBuilder.build());
            this.f2623b.m2935h().m2983c().write(messageContext);
        } else {
            PushLog.m3025a(f2625d, "Connection isn't initialized, add this task to pending queue");
            this.f2623b.m2917a(new C0365ab(this, str, iCallback));
            if (!this.f2623b.m2930c()) {
                PushLog.m3025a(f2625d, "Execute initialization");
                this.f2623b.m2929b((ICallback) null);
            }
        }
    }
}
