package com.sec.chaton.push.message.processer;

import android.content.Context;
import android.os.Handler;
import com.sec.chaton.push.network.connection.ProvConnectionManager;

/* loaded from: classes.dex */
public class ProvMessageProcesser extends AbstractMessageProcesser {

    /* renamed from: d */
    private static final String f2662d = ProvMessageProcesser.class.getSimpleName();

    /* renamed from: e */
    private Context f2663e;

    /* renamed from: f */
    private ProvConnectionManager f2664f;

    public ProvMessageProcesser(MessageController messageController, Handler handler) {
        super(messageController, handler);
        this.f2663e = messageController.m2934g();
        this.f2664f = messageController.m2936i();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x007e A[Catch: all -> 0x0198, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x0014, B:9:0x0022, B:11:0x002a, B:12:0x0031, B:31:0x019c, B:33:0x01ab, B:35:0x01bb, B:36:0x01e1, B:13:0x003b, B:15:0x005d, B:17:0x0069, B:18:0x0077, B:20:0x007e, B:22:0x0084, B:24:0x0090, B:25:0x009b, B:38:0x01f6, B:37:0x01ea), top: B:40:0x0002, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01ea A[Catch: all -> 0x0198, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x0014, B:9:0x0022, B:11:0x002a, B:12:0x0031, B:31:0x019c, B:33:0x01ab, B:35:0x01bb, B:36:0x01e1, B:13:0x003b, B:15:0x005d, B:17:0x0069, B:18:0x0077, B:20:0x007e, B:22:0x0084, B:24:0x0090, B:25:0x009b, B:38:0x01f6, B:37:0x01ea), top: B:40:0x0002, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01f6 A[Catch: all -> 0x0198, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x0014, B:9:0x0022, B:11:0x002a, B:12:0x0031, B:31:0x019c, B:33:0x01ab, B:35:0x01bb, B:36:0x01e1, B:13:0x003b, B:15:0x005d, B:17:0x0069, B:18:0x0077, B:20:0x007e, B:22:0x0084, B:24:0x0090, B:25:0x009b, B:38:0x01f6, B:37:0x01ea), top: B:40:0x0002, inners: #1, #2 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void m2953a(int r12, com.sec.chaton.push.message.processer.ICallback r13) {
        /*
            Method dump skipped, instructions count: 540
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.push.message.processer.ProvMessageProcesser.m2953a(int, com.sec.chaton.push.message.processer.ICallback):void");
    }
}
