package com.sec.chaton.push.p039c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.push.p038b.C0874g;
import com.sec.chaton.push.util.C0921g;

/* compiled from: MessageTaskDispatcher.java */
/* renamed from: com.sec.chaton.push.c.k */
/* loaded from: classes.dex */
class HandlerC0899k extends Handler {

    /* renamed from: a */
    final /* synthetic */ C0893e f3072a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC0899k(C0893e c0893e, Looper looper) {
        super(looper);
        this.f3072a = c0893e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private void m3533a(Message message) {
        Thread.yield();
        AbstractC0894f abstractC0894f = (AbstractC0894f) message.obj;
        if (C0921g.f3116a) {
            C0921g.m3637a(C0893e.f3054a, String.format("Dispath message task. %s", abstractC0894f));
        }
        if (abstractC0894f instanceof InterfaceC0890b) {
            if (C0921g.f3116a) {
                C0921g.m3637a(C0893e.f3054a, "This message task needs response message.");
            }
            this.f3072a.f3060g = (InterfaceC0890b) abstractC0894f;
        } else {
            if (C0921g.f3116a) {
                C0921g.m3637a(C0893e.f3054a, "This message task doesn't need response message.");
            }
            this.f3072a.f3060g = null;
        }
        C0881a c0881aMo3488d = abstractC0894f.mo3488d();
        if (C0921g.f3116a) {
            C0921g.m3637a(C0893e.f3054a, String.format("TaskOperation is %s.", c0881aMo3488d));
        }
        if (c0881aMo3488d == null) {
            this.f3072a.f3060g = null;
        } else if (c0881aMo3488d.m3476a() == null || c0881aMo3488d.m3479b() == null) {
            if (C0921g.f3119d) {
                C0921g.m3642d(C0893e.f3054a, String.format("The TaskOperation is invaild.( ConnectionManager: %s. requestMessage: %s )", c0881aMo3488d.m3476a(), c0881aMo3488d.m3479b()));
            }
            this.f3072a.f3060g = null;
        } else {
            try {
                c0881aMo3488d.m3476a().m3459a(c0881aMo3488d.m3479b());
            } catch (C0874g e) {
                this.f3072a.f3060g = null;
                if (C0921g.f3119d) {
                    C0921g.m3638a(C0893e.f3054a, e.getMessage(), e);
                }
            }
        }
        if (this.f3072a.f3060g != null) {
            if (C0921g.f3116a) {
                C0921g.m3637a(C0893e.f3054a, String.format("Setting message response timeout countdown wait %d seconds.", 180L));
            }
            this.f3072a.f3059f.sendEmptyMessageDelayed(-1, 180000L);
            this.f3072a.m3510g();
            return;
        }
        if (C0921g.f3116a) {
            C0921g.m3637a(C0893e.f3054a, "Wake up MessageTaskDispatchThread.");
        }
        synchronized (this.f3072a.f3057d) {
            this.f3072a.f3057d.notify();
        }
    }

    /* renamed from: b */
    private void m3534b(Message message) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) message.obj;
        if (C0921g.f3116a) {
            C0921g.m3637a(C0893e.f3054a, String.format("Received response message. %s", generatedMessageLite.getClass()));
        }
        if (this.f3072a.f3061h.containsKey(generatedMessageLite.getClass())) {
            ((InterfaceC0895g) this.f3072a.f3061h.get(generatedMessageLite.getClass())).mo3494a(generatedMessageLite);
            return;
        }
        if (this.f3072a.f3060g != null && this.f3072a.f3060g.mo3487c().equals(generatedMessageLite.getClass())) {
            if (C0921g.f3116a) {
                C0921g.m3637a(C0893e.f3054a, String.format("ResponseMessageTask.getHandleMessageClass() == %s", generatedMessageLite.getClass()));
            }
            this.f3072a.f3059f.removeMessages(-1);
            InterfaceC0890b interfaceC0890b = this.f3072a.f3060g;
            this.f3072a.f3060g = null;
            try {
                interfaceC0890b.mo3486a(0, generatedMessageLite);
                this.f3072a.m3511h();
                if (C0921g.f3116a) {
                    C0921g.m3637a(C0893e.f3054a, "Wake up MessageTaskDispatchThread.");
                }
                synchronized (this.f3072a.f3057d) {
                    this.f3072a.f3057d.notify();
                }
                return;
            } catch (Throwable th) {
                this.f3072a.m3511h();
                throw th;
            }
        }
        if (C0921g.f3118c) {
            C0921g.m3641c(C0893e.f3054a, String.format("ResponseMessageTask.getHandleMessageClass() != %s", generatedMessageLite.getClass()));
            C0921g.m3641c(C0893e.f3054a, "Throw away this response message.");
        }
    }

    /* renamed from: c */
    private void m3535c(Message message) {
        if (C0921g.f3116a) {
            C0921g.m3637a(C0893e.f3054a, "Timeout.");
        }
        if (this.f3072a.f3060g != null) {
            InterfaceC0890b interfaceC0890b = this.f3072a.f3060g;
            this.f3072a.f3060g = null;
            try {
                interfaceC0890b.mo3486a(-1, null);
                this.f3072a.m3511h();
                if (C0921g.f3116a) {
                    C0921g.m3637a(C0893e.f3054a, "Wake up MessageTaskDispatchThread.");
                }
                synchronized (this.f3072a.f3057d) {
                    this.f3072a.f3057d.notify();
                }
                return;
            } catch (Throwable th) {
                this.f3072a.m3511h();
                throw th;
            }
        }
        if (C0921g.f3118c) {
            C0921g.m3637a(C0893e.f3054a, "The response message task is gone.");
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        synchronized (C0893e.f3055b) {
            if (this.f3072a.f3059f == this) {
                try {
                    this.f3072a.m3510g();
                    switch (message.what) {
                        case -1:
                            m3535c(message);
                            break;
                        case 0:
                            m3533a(message);
                            break;
                        case 1:
                            m3534b(message);
                            break;
                        default:
                            if (C0921g.f3118c) {
                                C0921g.m3641c(C0893e.f3054a, String.format("Unknown message.what => %d", Integer.valueOf(message.what)));
                                break;
                            }
                            break;
                    }
                    return;
                } finally {
                    this.f3072a.m3511h();
                }
            }
            if (C0921g.f3118c) {
                C0921g.m3641c(C0893e.f3054a, "This MessageTaskExecuteHandler is dead.");
            }
        }
    }
}
