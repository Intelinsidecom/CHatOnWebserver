package com.sec.chaton.push.heartbeat;

import android.content.Context;
import com.sec.chaton.push.message.processer.ICallback;
import com.sec.chaton.push.message.processer.MessageController;
import com.sec.chaton.push.util.PushLog;

/* renamed from: com.sec.chaton.push.heartbeat.a */
/* loaded from: classes.dex */
class C0361a implements ICallback {

    /* renamed from: a */
    private Context f2619a;

    public C0361a(Context context) {
        this.f2619a = context;
    }

    @Override // com.sec.chaton.push.message.processer.ICallback
    /* renamed from: a */
    public void mo2865a(int i) {
        synchronized (HeartBeat.class) {
            if (HeartBeat.f2618f) {
                PushLog.m3031d(HeartBeat.f2613a, "Fail send ping");
                PushLog.m3025a(HeartBeat.f2613a, "Execute initialize");
                MessageController.m2911p().m2929b((ICallback) null);
                HeartBeat.m2873b(false);
                HeartBeat.m2877d(this.f2619a);
            }
        }
    }

    @Override // com.sec.chaton.push.message.processer.ICallback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2866a(Integer num) {
        synchronized (HeartBeat.class) {
            if (HeartBeat.f2618f) {
                PushLog.m3025a(HeartBeat.f2613a, "Success send ping");
                HeartBeat.m2873b(true);
                HeartBeat.m2877d(this.f2619a);
            }
        }
    }
}
