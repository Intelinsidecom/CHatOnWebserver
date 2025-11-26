package com.sec.chaton.push.network;

import android.os.Handler;
import com.google.protobuf.MessageLite;

/* loaded from: classes.dex */
public class MessageContext {

    /* renamed from: a */
    private MessageLite f2734a;

    /* renamed from: b */
    private ICallback f2735b;

    /* renamed from: c */
    private Handler f2736c;

    /* renamed from: d */
    private boolean f2737d;

    public interface ICallback {
        /* renamed from: a */
        void mo2959a(int i, MessageLite messageLite);

        /* renamed from: a */
        void mo2960a(MessageLite messageLite, MessageLite messageLite2);
    }

    public MessageContext() {
        this(null, null, null);
    }

    public MessageContext(MessageLite messageLite, ICallback iCallback, Handler handler) {
        this.f2734a = messageLite;
        this.f2735b = iCallback;
        this.f2736c = handler;
        this.f2737d = false;
    }

    /* renamed from: a */
    public MessageLite m2969a() {
        return this.f2734a;
    }

    /* renamed from: a */
    public void m2970a(int i) {
        synchronized (this) {
            if (this.f2737d) {
                return;
            }
            this.f2737d = true;
            if (this.f2735b != null) {
                this.f2736c.post(new RunnableC0393b(this, i));
            }
        }
    }

    /* renamed from: a */
    public void m2971a(Handler handler) {
        this.f2736c = handler;
    }

    /* renamed from: a */
    public void m2972a(MessageLite messageLite) {
        this.f2734a = messageLite;
    }

    /* renamed from: a */
    public void m2973a(ICallback iCallback) {
        this.f2735b = iCallback;
    }

    /* renamed from: b */
    public void m2974b(MessageLite messageLite) {
        synchronized (this) {
            if (this.f2737d) {
                return;
            }
            this.f2737d = true;
            if (this.f2735b != null) {
                this.f2736c.post(new RunnableC0392a(this, messageLite));
            }
        }
    }
}
