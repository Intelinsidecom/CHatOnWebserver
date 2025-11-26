package com.sec.chaton.push.message.processer;

import android.content.Context;
import android.os.Handler;
import com.sec.chaton.push.network.MessageContext;
import com.sec.chaton.push.provisioning.ProvisioningManager;
import com.sec.chaton.push.util.PushLog;
import com.sec.pns.msg.frontend.MsgFrontend;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class NotiAcksMessageProcesser extends AbstractMessageProcesser {

    /* renamed from: d */
    private static final String f2654d = NotiAcksMessageProcesser.class.getSimpleName();

    /* renamed from: e */
    private Context f2655e;

    public NotiAcksMessageProcesser(MessageController messageController, Handler handler) {
        super(messageController, handler);
        this.f2655e = messageController.m2934g();
    }

    /* renamed from: a */
    public synchronized void m2944a(List list) {
        PushLog.m3025a(f2654d, "NotiAcksMessageProcesser.process()");
        if (this.f2623b.m2931d()) {
            MsgFrontend.NotiAcks.Builder builderNewBuilder = MsgFrontend.NotiAcks.newBuilder();
            builderNewBuilder.setDeviceToken(ProvisioningManager.m3002d(this.f2655e));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                builderNewBuilder.addNotiIds((String) it.next());
            }
            MessageContext messageContext = new MessageContext();
            messageContext.m2971a(this.f2624c);
            messageContext.m2973a(new C0387v(this));
            messageContext.m2972a(builderNewBuilder.build());
            this.f2623b.m2935h().m2979a(messageContext);
        } else {
            PushLog.m3025a(f2654d, "Connection isn't initialized, add this task to pending queue");
            this.f2623b.m2917a(new C0386u(this, list));
            if (!this.f2623b.m2930c()) {
                PushLog.m3025a(f2654d, "Execute initialization");
                this.f2623b.m2929b((ICallback) null);
            }
        }
    }
}
