package com.sec.chaton.push.p094c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.push.p090a.C3054k;
import com.sec.chaton.push.util.C3115g;

/* compiled from: MessageTaskDispatcher.java */
/* renamed from: com.sec.chaton.push.c.g */
/* loaded from: classes.dex */
class HandlerC3086g extends Handler {

    /* renamed from: a */
    final /* synthetic */ C3084e f11398a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC3086g(C3084e c3084e, Looper looper) {
        super(looper);
        this.f11398a = c3084e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private void m12577a(Message message) {
        Thread.yield();
        AbstractC3072a abstractC3072a = (AbstractC3072a) message.obj;
        if (C3115g.f11458a) {
            C3115g.m12701a(C3084e.f11387a, String.format("Dispath message task. %s", abstractC3072a));
        }
        if (abstractC3072a instanceof InterfaceC3083d) {
            if (C3115g.f11458a) {
                C3115g.m12701a(C3084e.f11387a, "This message task needs response message.");
            }
            this.f11398a.f11394h = (InterfaceC3083d) abstractC3072a;
        } else {
            if (C3115g.f11458a) {
                C3115g.m12701a(C3084e.f11387a, "This message task doesn't need response message.");
            }
            this.f11398a.f11394h = null;
        }
        C3087h c3087hMo12537c = abstractC3072a.mo12537c();
        if (C3115g.f11458a) {
            C3115g.m12701a(C3084e.f11387a, String.format("TaskOperation is %s.", c3087hMo12537c));
        }
        if (c3087hMo12537c == null) {
            this.f11398a.f11394h = null;
        } else if (c3087hMo12537c.m12580a() == null || c3087hMo12537c.m12583b() == null) {
            if (C3115g.f11461d) {
                C3115g.m12706d(C3084e.f11387a, String.format("The TaskOperation is invaild.( ConnectionManager: %s. requestMessage: %s )", c3087hMo12537c.m12580a(), c3087hMo12537c.m12583b()));
            }
            this.f11398a.f11394h = null;
        } else {
            try {
                c3087hMo12537c.m12580a().m12525a(c3087hMo12537c.m12583b());
            } catch (C3054k e) {
                this.f11398a.f11394h = null;
                if (C3115g.f11461d) {
                    C3115g.m12702a(C3084e.f11387a, e.getMessage(), e);
                }
            }
        }
        if (this.f11398a.f11394h != null) {
            if (C3115g.f11458a) {
                C3115g.m12701a(C3084e.f11387a, String.format("Setting message response timeout countdown wait %d seconds.", 180L));
            }
            this.f11398a.f11393g.sendEmptyMessageDelayed(-1, 180000L);
            this.f11398a.m12569f();
            return;
        }
        if (C3115g.f11458a) {
            C3115g.m12701a(C3084e.f11387a, "Wake up MessageTaskDispatchThread.");
        }
        synchronized (this.f11398a.f11391e) {
            this.f11398a.f11391e.notify();
        }
    }

    /* renamed from: b */
    private void m12578b(Message message) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) message.obj;
        if (C3115g.f11458a) {
            C3115g.m12701a(C3084e.f11387a, String.format("Received response message. %s", generatedMessageLite.getClass()));
        }
        if (this.f11398a.f11395i.containsKey(generatedMessageLite.getClass())) {
            ((InterfaceC3082c) this.f11398a.f11395i.get(generatedMessageLite.getClass())).mo12549a(generatedMessageLite);
            return;
        }
        if (this.f11398a.f11394h != null && this.f11398a.f11394h.mo12540n_().equals(generatedMessageLite.getClass())) {
            if (C3115g.f11458a) {
                C3115g.m12701a(C3084e.f11387a, String.format("ResponseMessageTask.getHandleMessageClass() == %s", generatedMessageLite.getClass()));
            }
            this.f11398a.f11393g.removeMessages(-1);
            InterfaceC3083d interfaceC3083d = this.f11398a.f11394h;
            this.f11398a.f11394h = null;
            try {
                interfaceC3083d.mo12538a(0, generatedMessageLite);
                this.f11398a.m12572g();
                if (C3115g.f11458a) {
                    C3115g.m12701a(C3084e.f11387a, "Wake up MessageTaskDispatchThread.");
                }
                synchronized (this.f11398a.f11391e) {
                    this.f11398a.f11391e.notify();
                }
                return;
            } catch (Throwable th) {
                this.f11398a.m12572g();
                throw th;
            }
        }
        if (C3115g.f11460c) {
            C3115g.m12705c(C3084e.f11387a, String.format("ResponseMessageTask.getHandleMessageClass() != %s", generatedMessageLite.getClass()));
            C3115g.m12705c(C3084e.f11387a, "Throw away this response message.");
        }
    }

    /* renamed from: c */
    private void m12579c(Message message) {
        if (C3115g.f11458a) {
            C3115g.m12701a(C3084e.f11387a, "Timeout.");
        }
        if (this.f11398a.f11394h != null) {
            InterfaceC3083d interfaceC3083d = this.f11398a.f11394h;
            this.f11398a.f11394h = null;
            try {
                interfaceC3083d.mo12538a(-1, null);
                this.f11398a.m12572g();
                if (C3115g.f11458a) {
                    C3115g.m12701a(C3084e.f11387a, "Wake up MessageTaskDispatchThread.");
                }
                synchronized (this.f11398a.f11391e) {
                    this.f11398a.f11391e.notify();
                }
                return;
            } catch (Throwable th) {
                this.f11398a.m12572g();
                throw th;
            }
        }
        if (C3115g.f11460c) {
            C3115g.m12701a(C3084e.f11387a, "The response message task is gone.");
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        synchronized (this.f11398a.f11389b) {
            if (this.f11398a.f11393g == this) {
                try {
                    this.f11398a.m12569f();
                    switch (message.what) {
                        case -1:
                            m12579c(message);
                            break;
                        case 0:
                            m12577a(message);
                            break;
                        case 1:
                            m12578b(message);
                            break;
                        default:
                            if (C3115g.f11460c) {
                                C3115g.m12705c(C3084e.f11387a, String.format("Unknown message.what => %d", Integer.valueOf(message.what)));
                                break;
                            }
                            break;
                    }
                    return;
                } finally {
                    this.f11398a.m12572g();
                }
            }
            if (C3115g.f11460c) {
                C3115g.m12705c(C3084e.f11387a, "This MessageTaskExecuteHandler is dead.");
            }
        }
    }
}
