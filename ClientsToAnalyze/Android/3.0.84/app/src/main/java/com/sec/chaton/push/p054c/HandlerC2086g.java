package com.sec.chaton.push.p054c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.push.p050a.C2054k;
import com.sec.chaton.push.util.C2115g;

/* compiled from: MessageTaskDispatcher.java */
/* renamed from: com.sec.chaton.push.c.g */
/* loaded from: classes.dex */
class HandlerC2086g extends Handler {

    /* renamed from: a */
    final /* synthetic */ C2084e f7988a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC2086g(C2084e c2084e, Looper looper) {
        super(looper);
        this.f7988a = c2084e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private void m8234a(Message message) {
        Thread.yield();
        AbstractC2072a abstractC2072a = (AbstractC2072a) message.obj;
        if (C2115g.f8048a) {
            C2115g.m8359a(C2084e.f7977a, String.format("Dispath message task. %s", abstractC2072a));
        }
        if (abstractC2072a instanceof InterfaceC2083d) {
            if (C2115g.f8048a) {
                C2115g.m8359a(C2084e.f7977a, "This message task needs response message.");
            }
            this.f7988a.f7984h = (InterfaceC2083d) abstractC2072a;
        } else {
            if (C2115g.f8048a) {
                C2115g.m8359a(C2084e.f7977a, "This message task doesn't need response message.");
            }
            this.f7988a.f7984h = null;
        }
        C2087h c2087hMo8194c = abstractC2072a.mo8194c();
        if (C2115g.f8048a) {
            C2115g.m8359a(C2084e.f7977a, String.format("TaskOperation is %s.", c2087hMo8194c));
        }
        if (c2087hMo8194c == null) {
            this.f7988a.f7984h = null;
        } else if (c2087hMo8194c.m8237a() == null || c2087hMo8194c.m8240b() == null) {
            if (C2115g.f8051d) {
                C2115g.m8364d(C2084e.f7977a, String.format("The TaskOperation is invaild.( ConnectionManager: %s. requestMessage: %s )", c2087hMo8194c.m8237a(), c2087hMo8194c.m8240b()));
            }
            this.f7988a.f7984h = null;
        } else {
            try {
                c2087hMo8194c.m8237a().m8182a(c2087hMo8194c.m8240b());
            } catch (C2054k e) {
                this.f7988a.f7984h = null;
                if (C2115g.f8051d) {
                    C2115g.m8360a(C2084e.f7977a, e.getMessage(), e);
                }
            }
        }
        if (this.f7988a.f7984h != null) {
            if (C2115g.f8048a) {
                C2115g.m8359a(C2084e.f7977a, String.format("Setting message response timeout countdown wait %d seconds.", 180L));
            }
            this.f7988a.f7983g.sendEmptyMessageDelayed(-1, 180000L);
            this.f7988a.m8226f();
            return;
        }
        if (C2115g.f8048a) {
            C2115g.m8359a(C2084e.f7977a, "Wake up MessageTaskDispatchThread.");
        }
        synchronized (this.f7988a.f7981e) {
            this.f7988a.f7981e.notify();
        }
    }

    /* renamed from: b */
    private void m8235b(Message message) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) message.obj;
        if (C2115g.f8048a) {
            C2115g.m8359a(C2084e.f7977a, String.format("Received response message. %s", generatedMessageLite.getClass()));
        }
        if (this.f7988a.f7985i.containsKey(generatedMessageLite.getClass())) {
            ((InterfaceC2082c) this.f7988a.f7985i.get(generatedMessageLite.getClass())).mo8206a(generatedMessageLite);
            return;
        }
        if (this.f7988a.f7984h != null && this.f7988a.f7984h.mo8197f_().equals(generatedMessageLite.getClass())) {
            if (C2115g.f8048a) {
                C2115g.m8359a(C2084e.f7977a, String.format("ResponseMessageTask.getHandleMessageClass() == %s", generatedMessageLite.getClass()));
            }
            this.f7988a.f7983g.removeMessages(-1);
            InterfaceC2083d interfaceC2083d = this.f7988a.f7984h;
            this.f7988a.f7984h = null;
            try {
                interfaceC2083d.mo8195a(0, generatedMessageLite);
                this.f7988a.m8229g();
                if (C2115g.f8048a) {
                    C2115g.m8359a(C2084e.f7977a, "Wake up MessageTaskDispatchThread.");
                }
                synchronized (this.f7988a.f7981e) {
                    this.f7988a.f7981e.notify();
                }
                return;
            } catch (Throwable th) {
                this.f7988a.m8229g();
                throw th;
            }
        }
        if (C2115g.f8050c) {
            C2115g.m8363c(C2084e.f7977a, String.format("ResponseMessageTask.getHandleMessageClass() != %s", generatedMessageLite.getClass()));
            C2115g.m8363c(C2084e.f7977a, "Throw away this response message.");
        }
    }

    /* renamed from: c */
    private void m8236c(Message message) {
        if (C2115g.f8048a) {
            C2115g.m8359a(C2084e.f7977a, "Timeout.");
        }
        if (this.f7988a.f7984h != null) {
            InterfaceC2083d interfaceC2083d = this.f7988a.f7984h;
            this.f7988a.f7984h = null;
            try {
                interfaceC2083d.mo8195a(-1, null);
                this.f7988a.m8229g();
                if (C2115g.f8048a) {
                    C2115g.m8359a(C2084e.f7977a, "Wake up MessageTaskDispatchThread.");
                }
                synchronized (this.f7988a.f7981e) {
                    this.f7988a.f7981e.notify();
                }
                return;
            } catch (Throwable th) {
                this.f7988a.m8229g();
                throw th;
            }
        }
        if (C2115g.f8050c) {
            C2115g.m8359a(C2084e.f7977a, "The response message task is gone.");
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        synchronized (this.f7988a.f7979b) {
            if (this.f7988a.f7983g == this) {
                try {
                    this.f7988a.m8226f();
                    switch (message.what) {
                        case -1:
                            m8236c(message);
                            break;
                        case 0:
                            m8234a(message);
                            break;
                        case 1:
                            m8235b(message);
                            break;
                        default:
                            if (C2115g.f8050c) {
                                C2115g.m8363c(C2084e.f7977a, String.format("Unknown message.what => %d", Integer.valueOf(message.what)));
                                break;
                            }
                            break;
                    }
                    return;
                } finally {
                    this.f7988a.m8229g();
                }
            }
            if (C2115g.f8050c) {
                C2115g.m8363c(C2084e.f7977a, "This MessageTaskExecuteHandler is dead.");
            }
        }
    }
}
