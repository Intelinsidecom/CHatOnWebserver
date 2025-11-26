package com.sec.chaton.control.task;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.control.MessageControl;
import com.sec.chaton.control.task.NetTaskHandler;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.NetResultReceiver;
import com.sec.chaton.network.TcpContext;
import com.sec.chaton.network.TcpEnvelope;
import com.sec.chaton.util.AesCipher;
import com.sec.chaton.util.ChatONLogWriter;

/* loaded from: classes.dex */
public abstract class AbstractNetTask {

    /* renamed from: a */
    protected static int f1453a = 2;

    /* renamed from: b */
    protected Handler f1454b;

    /* renamed from: c */
    protected TcpContext f1455c;

    /* renamed from: e */
    protected long f1457e;

    /* renamed from: g */
    private TcpEnvelope f1459g;

    /* renamed from: h */
    private NetTaskHandler.MyHandler f1460h = (NetTaskHandler.MyHandler) NetTaskHandler.m2152a().m2153b();

    /* renamed from: d */
    protected int f1456d = 0;

    /* renamed from: f */
    protected MessageControl f1458f = null;

    public AbstractNetTask(Handler handler) {
        this.f1454b = handler;
    }

    /* renamed from: a */
    protected abstract TcpEnvelope mo2107a();

    /* renamed from: a */
    protected abstract void mo2108a(int i, Object obj, Object obj2);

    /* renamed from: a */
    protected void m2109a(AbstractNetTask abstractNetTask) {
        this.f1456d++;
        TcpEnvelope tcpEnvelopeMo2107a = mo2107a();
        if (this.f1455c.m2790f() == null) {
            String strM3477a = GlobalApplication.m2390h().m3477a();
            if (!TextUtils.isEmpty(strM3477a)) {
                byte[] bArrM3469b = AesCipher.m3469b(strM3477a);
                byte[] bArrM3470c = AesCipher.m3470c(strM3477a);
                if (bArrM3469b != null && bArrM3470c != null) {
                    try {
                        this.f1455c.m2786a(bArrM3469b, bArrM3470c);
                    } catch (Exception e) {
                        ChatONLogWriter.m3499a(e.getMessage(), "AesCipher");
                    }
                }
            }
        }
        if (this.f1455c.m2790f() == null) {
            mo2108a(-1, null, null);
            return;
        }
        if (tcpEnvelopeMo2107a == null) {
            mo2108a(-1, null, null);
            return;
        }
        this.f1459g = tcpEnvelopeMo2107a;
        C0196e c0196e = new C0196e(this, this.f1459g, this.f1455c);
        this.f1459g.m2801a(new NetResultReceiver(this.f1460h, c0196e));
        c0196e.m2159a();
    }

    /* renamed from: a */
    public void m2110a(TcpContext tcpContext) {
        Message message = new Message();
        message.obj = this;
        this.f1455c = tcpContext;
        this.f1460h.sendMessage(message);
    }

    /* renamed from: b */
    public boolean m2111b() {
        return this.f1456d < 2;
    }
}
