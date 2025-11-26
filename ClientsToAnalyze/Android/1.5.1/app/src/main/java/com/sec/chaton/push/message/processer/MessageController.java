package com.sec.chaton.push.message.processer;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PowerManager;
import com.sec.chaton.push.network.connection.ProvConnectionManager;
import com.sec.chaton.push.network.connection.PushConnectionManager;
import com.sec.chaton.push.provisioning.ProvisioningManager;
import com.sec.chaton.push.util.PushLog;
import com.sec.pns.msg.frontend.MsgFrontend;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class MessageController {

    /* renamed from: a */
    private static final String f2631a = MessageController.class.getSimpleName();

    /* renamed from: w */
    private static MessageController f2632w = null;

    /* renamed from: b */
    private HandlerThread f2633b;

    /* renamed from: c */
    private Handler f2634c;

    /* renamed from: e */
    private boolean f2636e;

    /* renamed from: f */
    private boolean f2637f;

    /* renamed from: g */
    private boolean f2638g;

    /* renamed from: h */
    private List f2639h;

    /* renamed from: i */
    private Context f2640i;

    /* renamed from: j */
    private EnumC0374i f2641j;

    /* renamed from: k */
    private PushConnectionManager f2642k;

    /* renamed from: l */
    private ProvConnectionManager f2643l;

    /* renamed from: m */
    private InitMessageProcesser f2644m;

    /* renamed from: n */
    private RegistrationMessageProcesser f2645n;

    /* renamed from: o */
    private DeregistrationMessageProcesser f2646o;

    /* renamed from: p */
    private PingMessageProcesser f2647p;

    /* renamed from: q */
    private NotiAcksMessageProcesser f2648q;

    /* renamed from: r */
    private ProvMessageProcesser f2649r;

    /* renamed from: s */
    private NotiGroupMessageProcesser f2650s;

    /* renamed from: t */
    private PowerManager.WakeLock f2651t;

    /* renamed from: d */
    private boolean f2635d = false;

    /* renamed from: u */
    private final String f2652u = ProvMessageProcesser.class.getSimpleName();

    /* renamed from: v */
    private final String f2653v = InitMessageProcesser.class.getSimpleName();

    private MessageController() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m2903b(boolean z) {
        this.f2636e = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m2905c(boolean z) {
        this.f2638g = z;
    }

    /* renamed from: p */
    public static MessageController m2911p() {
        if (f2632w == null) {
            f2632w = new MessageController();
        }
        return f2632w;
    }

    /* renamed from: q */
    private void m2912q() {
        try {
            if (this.f2651t != null) {
                this.f2651t.acquire();
            }
        } catch (Throwable th) {
            PushLog.m3026a(f2631a, th.getMessage(), th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public void m2913r() {
        try {
            if (this.f2651t != null) {
                this.f2651t.release();
            }
        } catch (Throwable th) {
            PushLog.m3026a(f2631a, th.getMessage(), th);
        }
    }

    /* renamed from: a */
    public synchronized Handler m2914a() {
        return this.f2634c;
    }

    /* renamed from: a */
    public synchronized void m2915a(int i) {
        if (this.f2635d) {
            Iterator it = this.f2639h.iterator();
            while (it.hasNext()) {
                ((IPendingTask) it.next()).mo2894a(i);
            }
        }
    }

    /* renamed from: a */
    public synchronized void m2916a(Context context, ProvConnectionManager provConnectionManager, PushConnectionManager pushConnectionManager) {
        if (!this.f2635d) {
            this.f2635d = true;
            this.f2633b = new HandlerThread("MessageProcesserThread");
            this.f2633b.start();
            this.f2634c = new Handler(this.f2633b.getLooper());
            this.f2640i = context;
            this.f2643l = provConnectionManager;
            this.f2642k = pushConnectionManager;
            this.f2636e = false;
            this.f2638g = false;
            this.f2639h = new ArrayList();
            this.f2641j = EnumC0374i.Primary;
            this.f2651t = ((PowerManager) context.getSystemService("power")).newWakeLock(1, MessageController.class.getSimpleName());
            this.f2644m = new InitMessageProcesser(this, this.f2634c);
            this.f2645n = new RegistrationMessageProcesser(this, this.f2634c);
            this.f2646o = new DeregistrationMessageProcesser(this, this.f2634c);
            this.f2647p = new PingMessageProcesser(this, this.f2634c);
            this.f2648q = new NotiAcksMessageProcesser(this, this.f2634c);
            this.f2649r = new ProvMessageProcesser(this, this.f2634c);
            this.f2650s = new NotiGroupMessageProcesser(this, this.f2634c);
        }
    }

    /* renamed from: a */
    public synchronized void m2917a(IPendingTask iPendingTask) {
        if (this.f2635d) {
            this.f2639h.add(iPendingTask);
        }
    }

    /* renamed from: a */
    public synchronized void m2918a(MsgFrontend.NotiGroup notiGroup) {
        if (this.f2635d) {
            m2912q();
            if (!this.f2634c.post(new RunnableC0382q(this, notiGroup))) {
                m2913r();
            }
        } else {
            PushLog.m3030c(f2631a, "MessageController isn't prepared.");
        }
    }

    /* renamed from: a */
    public synchronized void m2919a(String str, ICallback iCallback) {
        if (this.f2635d) {
            m2912q();
            if (!this.f2634c.post(new RunnableC0379n(this, str, iCallback))) {
                m2913r();
            }
        } else {
            PushLog.m3030c(f2631a, "MessageController isn't prepared.");
        }
    }

    /* renamed from: a */
    public synchronized void m2920a(List list) {
        if (this.f2635d) {
            m2912q();
            if (!this.f2634c.post(new RunnableC0385t(this, list))) {
                m2913r();
            }
        } else {
            PushLog.m3030c(f2631a, "MessageController isn't prepared.");
        }
    }

    /* renamed from: a */
    public void m2921a(boolean z) {
        this.f2637f = z;
    }

    /* renamed from: a */
    public synchronized void m2922a(boolean z, ICallback iCallback) {
        if (this.f2635d) {
            m2912q();
            if (!this.f2634c.post(new RunnableC0384s(this, z, iCallback))) {
                m2913r();
            }
        } else {
            PushLog.m3030c(f2631a, "MessageController isn't prepared.");
        }
    }

    /* renamed from: a */
    synchronized boolean m2923a(int i, ICallback iCallback) {
        boolean z;
        synchronized (this) {
            if (this.f2635d) {
                try {
                    m2912q();
                    if (m2927b()) {
                        z = false;
                    } else {
                        m2903b(true);
                        if (!this.f2634c.post(new RunnableC0381p(this, i, iCallback))) {
                            m2913r();
                        }
                        z = true;
                    }
                } finally {
                    if (0 == 0) {
                        m2913r();
                    }
                }
            } else {
                PushLog.m3030c(f2631a, "MessageController isn't prepared.");
                z = false;
            }
        }
        return z;
    }

    /* renamed from: a */
    public boolean m2924a(ICallback iCallback) {
        return m2923a(0, iCallback);
    }

    /* renamed from: a */
    synchronized boolean m2925a(boolean z, int i, ICallback iCallback) {
        boolean z2;
        synchronized (this) {
            if (this.f2635d) {
                try {
                    m2912q();
                    if (z || !m2930c()) {
                        m2905c(true);
                        if (!this.f2634c.post(new RunnableC0380o(this, i, iCallback))) {
                            m2913r();
                        }
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } finally {
                    if (0 == 0) {
                        m2913r();
                    }
                }
            } else {
                PushLog.m3030c(f2631a, "MessageController isn't prepared.");
                z2 = false;
            }
        }
        return z2;
    }

    /* renamed from: b */
    public synchronized void m2926b(String str, ICallback iCallback) {
        if (this.f2635d) {
            m2912q();
            if (!this.f2634c.post(new RunnableC0378m(this, str, iCallback))) {
                m2913r();
            }
        } else {
            PushLog.m3030c(f2631a, "MessageController isn't prepared.");
        }
    }

    /* renamed from: b */
    public boolean m2927b() {
        return this.f2636e;
    }

    /* renamed from: b */
    public boolean m2928b(int i, ICallback iCallback) {
        return m2925a(false, i, iCallback);
    }

    /* renamed from: b */
    public boolean m2929b(ICallback iCallback) {
        return m2925a(false, 0, iCallback);
    }

    /* renamed from: c */
    public boolean m2930c() {
        return this.f2638g;
    }

    /* renamed from: d */
    public boolean m2931d() {
        return this.f2637f;
    }

    /* renamed from: e */
    public synchronized void m2932e() {
        if (this.f2635d) {
            Iterator it = this.f2639h.iterator();
            while (it.hasNext()) {
                ((IPendingTask) it.next()).mo2893a();
            }
        }
    }

    /* renamed from: f */
    public synchronized void m2933f() {
        if (this.f2635d) {
            this.f2639h.clear();
        }
    }

    /* renamed from: g */
    public Context m2934g() {
        return this.f2640i;
    }

    /* renamed from: h */
    public PushConnectionManager m2935h() {
        return this.f2642k;
    }

    /* renamed from: i */
    public ProvConnectionManager m2936i() {
        return this.f2643l;
    }

    /* renamed from: j */
    protected String m2937j() {
        switch (C0383r.f2718a[this.f2641j.ordinal()]) {
            case 1:
                return ProvisioningManager.m3003e(this.f2640i);
            case 2:
                return ProvisioningManager.m3005g(this.f2640i);
            default:
                throw new Error("Sholudn't reach this code");
        }
    }

    /* renamed from: k */
    protected int m2938k() {
        switch (C0383r.f2718a[this.f2641j.ordinal()]) {
            case 1:
                return ProvisioningManager.m3004f(this.f2640i);
            case 2:
                return ProvisioningManager.m3006h(this.f2640i);
            default:
                throw new Error("Sholudn't reach this code");
        }
    }

    /* renamed from: l */
    protected EnumC0374i m2939l() {
        return this.f2641j;
    }

    /* renamed from: m */
    protected void m2940m() {
        switch (C0383r.f2718a[this.f2641j.ordinal()]) {
            case 1:
                this.f2641j = EnumC0374i.Secondary;
                return;
            case 2:
                this.f2641j = EnumC0374i.Primary;
                return;
            default:
                throw new Error("Sholudn't reach this code");
        }
    }

    /* renamed from: n */
    public String m2941n() {
        return this.f2652u;
    }

    /* renamed from: o */
    public String m2942o() {
        return this.f2653v;
    }
}
