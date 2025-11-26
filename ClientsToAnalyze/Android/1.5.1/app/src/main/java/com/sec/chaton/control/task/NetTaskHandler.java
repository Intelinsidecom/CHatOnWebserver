package com.sec.chaton.control.task;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes.dex */
public class NetTaskHandler {

    /* renamed from: a */
    private static NetTaskHandler f1634a = null;

    /* renamed from: b */
    private HandlerThread f1635b = new HandlerThread("AsyncNetTask");

    /* renamed from: c */
    private MyHandler f1636c;

    /* renamed from: d */
    private Looper f1637d;

    public class MyHandler extends Handler {
        public MyHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            AbstractNetTask abstractNetTask = (AbstractNetTask) message.obj;
            abstractNetTask.m2109a(abstractNetTask);
        }
    }

    private NetTaskHandler() {
        this.f1635b.start();
        this.f1637d = this.f1635b.getLooper();
        this.f1636c = new MyHandler(this.f1637d);
    }

    /* renamed from: a */
    public static NetTaskHandler m2152a() {
        if (f1634a == null) {
            f1634a = new NetTaskHandler();
        }
        return f1634a;
    }

    /* renamed from: b */
    public Handler m2153b() {
        return this.f1636c;
    }
}
