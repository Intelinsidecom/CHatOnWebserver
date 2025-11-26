package com.sec.chaton.push.p044c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.push.p040a.C1081k;
import com.sec.chaton.push.util.C1139g;

/* compiled from: MessageTaskDispatcher.java */
/* renamed from: com.sec.chaton.push.c.g */
/* loaded from: classes.dex */
class HandlerC1113g extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1111e f4084a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC1113g(C1111e c1111e, Looper looper) {
        super(looper);
        this.f4084a = c1111e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private void m4189a(Message message) {
        Thread.yield();
        AbstractC1099a abstractC1099a = (AbstractC1099a) message.obj;
        if (C1139g.f4142a) {
            C1139g.m4308a(C1111e.f4074a, String.format("Dispath message task. %s", abstractC1099a));
        }
        if (abstractC1099a instanceof InterfaceC1110d) {
            if (C1139g.f4142a) {
                C1139g.m4308a(C1111e.f4074a, "This message task needs response message.");
            }
            this.f4084a.f4080g = (InterfaceC1110d) abstractC1099a;
        } else {
            if (C1139g.f4142a) {
                C1139g.m4308a(C1111e.f4074a, "This message task doesn't need response message.");
            }
            this.f4084a.f4080g = null;
        }
        C1114h c1114hMo4150c = abstractC1099a.mo4150c();
        if (C1139g.f4142a) {
            C1139g.m4308a(C1111e.f4074a, String.format("TaskOperation is %s.", c1114hMo4150c));
        }
        if (c1114hMo4150c == null) {
            this.f4084a.f4080g = null;
        } else if (c1114hMo4150c.m4192a() == null || c1114hMo4150c.m4195b() == null) {
            if (C1139g.f4145d) {
                C1139g.m4313d(C1111e.f4074a, String.format("The TaskOperation is invaild.( ConnectionManager: %s. requestMessage: %s )", c1114hMo4150c.m4192a(), c1114hMo4150c.m4195b()));
            }
            this.f4084a.f4080g = null;
        } else {
            try {
                c1114hMo4150c.m4192a().m4139a(c1114hMo4150c.m4195b());
            } catch (C1081k e) {
                this.f4084a.f4080g = null;
                if (C1139g.f4145d) {
                    C1139g.m4309a(C1111e.f4074a, e.getMessage(), e);
                }
            }
        }
        if (this.f4084a.f4080g != null) {
            if (C1139g.f4142a) {
                C1139g.m4308a(C1111e.f4074a, String.format("Setting message response timeout countdown wait %d seconds.", 180L));
            }
            this.f4084a.f4079f.sendEmptyMessageDelayed(-1, 180000L);
            this.f4084a.m4182g();
            return;
        }
        if (C1139g.f4142a) {
            C1139g.m4308a(C1111e.f4074a, "Wake up MessageTaskDispatchThread.");
        }
        synchronized (this.f4084a.f4077d) {
            this.f4084a.f4077d.notify();
        }
    }

    /* renamed from: b */
    private void m4190b(Message message) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) message.obj;
        if (C1139g.f4142a) {
            C1139g.m4308a(C1111e.f4074a, String.format("Received response message. %s", generatedMessageLite.getClass()));
        }
        if (this.f4084a.f4081h.containsKey(generatedMessageLite.getClass())) {
            ((InterfaceC1109c) this.f4084a.f4081h.get(generatedMessageLite.getClass())).mo4161a(generatedMessageLite);
            return;
        }
        if (this.f4084a.f4080g != null && this.f4084a.f4080g.mo4153a_().equals(generatedMessageLite.getClass())) {
            if (C1139g.f4142a) {
                C1139g.m4308a(C1111e.f4074a, String.format("ResponseMessageTask.getHandleMessageClass() == %s", generatedMessageLite.getClass()));
            }
            this.f4084a.f4079f.removeMessages(-1);
            InterfaceC1110d interfaceC1110d = this.f4084a.f4080g;
            this.f4084a.f4080g = null;
            try {
                interfaceC1110d.mo4151a(0, generatedMessageLite);
                this.f4084a.m4183h();
                if (C1139g.f4142a) {
                    C1139g.m4308a(C1111e.f4074a, "Wake up MessageTaskDispatchThread.");
                }
                synchronized (this.f4084a.f4077d) {
                    this.f4084a.f4077d.notify();
                }
                return;
            } catch (Throwable th) {
                this.f4084a.m4183h();
                throw th;
            }
        }
        if (C1139g.f4144c) {
            C1139g.m4312c(C1111e.f4074a, String.format("ResponseMessageTask.getHandleMessageClass() != %s", generatedMessageLite.getClass()));
            C1139g.m4312c(C1111e.f4074a, "Throw away this response message.");
        }
    }

    /* renamed from: c */
    private void m4191c(Message message) {
        if (C1139g.f4142a) {
            C1139g.m4308a(C1111e.f4074a, "Timeout.");
        }
        if (this.f4084a.f4080g != null) {
            InterfaceC1110d interfaceC1110d = this.f4084a.f4080g;
            this.f4084a.f4080g = null;
            try {
                interfaceC1110d.mo4151a(-1, null);
                this.f4084a.m4183h();
                if (C1139g.f4142a) {
                    C1139g.m4308a(C1111e.f4074a, "Wake up MessageTaskDispatchThread.");
                }
                synchronized (this.f4084a.f4077d) {
                    this.f4084a.f4077d.notify();
                }
                return;
            } catch (Throwable th) {
                this.f4084a.m4183h();
                throw th;
            }
        }
        if (C1139g.f4144c) {
            C1139g.m4308a(C1111e.f4074a, "The response message task is gone.");
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        synchronized (C1111e.f4075b) {
            if (this.f4084a.f4079f == this) {
                try {
                    this.f4084a.m4182g();
                    switch (message.what) {
                        case -1:
                            m4191c(message);
                            break;
                        case 0:
                            m4189a(message);
                            break;
                        case 1:
                            m4190b(message);
                            break;
                        default:
                            if (C1139g.f4144c) {
                                C1139g.m4312c(C1111e.f4074a, String.format("Unknown message.what => %d", Integer.valueOf(message.what)));
                                break;
                            }
                            break;
                    }
                    return;
                } finally {
                    this.f4084a.m4183h();
                }
            }
            if (C1139g.f4144c) {
                C1139g.m4312c(C1111e.f4074a, "This MessageTaskExecuteHandler is dead.");
            }
        }
    }
}
