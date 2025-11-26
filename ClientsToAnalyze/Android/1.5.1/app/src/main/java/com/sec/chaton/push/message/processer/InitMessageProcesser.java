package com.sec.chaton.push.message.processer;

import android.content.Context;
import android.os.Handler;
import com.sec.chaton.push.exception.ConnectionException;
import com.sec.chaton.push.exception.NetworkNotAvailableException;
import com.sec.chaton.push.network.MessageContext;
import com.sec.chaton.push.network.connection.PushConnectionManager;
import com.sec.chaton.push.provisioning.ProvisioningManager;
import com.sec.chaton.push.util.PushLog;
import com.sec.pns.msg.frontend.MsgFrontend;

/* loaded from: classes.dex */
public class InitMessageProcesser extends AbstractMessageProcesser {

    /* renamed from: d */
    private static final String f2628d = InitMessageProcesser.class.getSimpleName();

    /* renamed from: e */
    private Context f2629e;

    /* renamed from: f */
    private PushConnectionManager f2630f;

    public InitMessageProcesser(MessageController messageController, Handler handler) {
        super(messageController, handler);
        this.f2629e = messageController.m2934g();
        this.f2630f = messageController.m2935h();
        this.f2630f.m2980a(new C0368c(this));
    }

    /* renamed from: a */
    public synchronized void m2898a(int i, ICallback iCallback) {
        PushLog.m3025a(f2628d, "InitMessageProcesser.process()");
        m2888e();
        if (ProvisioningManager.m2999a(this.f2629e)) {
            if (this.f2623b.m2931d()) {
                PushLog.m3030c(f2628d, "Initialization is already completed. This code shouldn't be executed.");
                m2883a(iCallback, -102);
            } else if (this.f2630f.m2984d()) {
                MsgFrontend.InitRequest.Builder builderNewBuilder = MsgFrontend.InitRequest.newBuilder();
                builderNewBuilder.setAsyncId(m2885b());
                builderNewBuilder.setDeviceToken(ProvisioningManager.m3002d(this.f2629e));
                MessageContext messageContext = new MessageContext();
                messageContext.m2971a(this.f2624c);
                messageContext.m2973a(new C0369d(this, iCallback, i));
                messageContext.m2972a(builderNewBuilder.build());
                this.f2623b.m2935h().m2979a(messageContext);
            } else {
                String strM2937j = this.f2623b.m2937j();
                int iM2938k = this.f2623b.m2938k();
                PushLog.m3028b(f2628d, "Connect to push server(" + strM2937j + ":" + iM2938k + ")");
                try {
                    this.f2630f.m2981a(strM2937j, iM2938k, true);
                } catch (NetworkNotAvailableException e) {
                    PushLog.m3031d(f2628d, "There isn't available network in device");
                    m2883a(iCallback, -2);
                    PushLog.m3025a(f2628d, "Cancel pending tasks");
                    this.f2623b.m2915a(-104);
                    this.f2623b.m2933f();
                } catch (ConnectionException e2) {
                    PushLog.m3026a(f2628d, "Can't connect to push server", e2);
                    PushLog.m3028b(f2628d, "Switch push server address");
                    this.f2623b.m2940m();
                    String strM2937j2 = this.f2623b.m2937j();
                    int iM2938k2 = this.f2623b.m2938k();
                    PushLog.m3028b(f2628d, "Connect to push server(" + strM2937j2 + ":" + iM2938k2 + ")");
                    try {
                        this.f2630f.m2981a(strM2937j2, iM2938k2, true);
                    } catch (NetworkNotAvailableException e3) {
                        PushLog.m3031d(f2628d, "There isn't available network in device");
                        this.f2623b.m2940m();
                        m2883a(iCallback, -2);
                        PushLog.m3025a(f2628d, "Cancel pending tasks");
                        this.f2623b.m2915a(-104);
                        this.f2623b.m2933f();
                    } catch (ConnectionException e4) {
                        PushLog.m3026a(f2628d, "Can't connect to push server", e4);
                        this.f2623b.m2940m();
                        PushLog.m3026a(f2628d, "Execute re-provisioning", e4);
                        ProvisioningManager.m3000b(this.f2629e);
                        m2883a(iCallback, -104);
                        PushLog.m3025a(f2628d, "Cancel pending tasks");
                        this.f2623b.m2915a(-104);
                        this.f2623b.m2933f();
                        m2882a(0, true);
                    }
                }
                MsgFrontend.InitRequest.Builder builderNewBuilder2 = MsgFrontend.InitRequest.newBuilder();
                builderNewBuilder2.setAsyncId(m2885b());
                builderNewBuilder2.setDeviceToken(ProvisioningManager.m3002d(this.f2629e));
                MessageContext messageContext2 = new MessageContext();
                messageContext2.m2971a(this.f2624c);
                messageContext2.m2973a(new C0369d(this, iCallback, i));
                messageContext2.m2972a(builderNewBuilder2.build());
                this.f2623b.m2935h().m2979a(messageContext2);
            }
        } else if (this.f2623b.m2927b()) {
            PushLog.m3025a(f2628d, "Now provisioning is progressing, add this task to pending queue: " + iCallback);
            this.f2623b.m2917a(new C0367b(this, i, iCallback));
        } else {
            PushLog.m3025a(f2628d, "Provisioning isn't executed, execute provisioning and add this task to pending queue");
            this.f2623b.m2924a(new C0370e(this, i, iCallback));
        }
    }
}
