package com.nuance.nmsp.client.sdk.oem;

import com.nuance.nmsp.client.sdk.common.oem.api.LogFactory;
import com.nuance.nmsp.client.sdk.common.oem.api.TimerSystem;
import java.util.Vector;

/* loaded from: classes.dex */
public class TimerSystemOEM implements TimerSystem, Runnable {

    /* renamed from: a */
    private static final LogFactory.Log f344a = LogFactory.getLog(TimerSystemOEM.class);

    /* renamed from: b */
    private Vector f345b = new Vector();

    /* renamed from: c */
    private Object f346c = new Object();

    /* renamed from: d */
    private boolean f347d = false;

    /* renamed from: com.nuance.nmsp.client.sdk.oem.TimerSystemOEM$a */
    static class C0525a {

        /* renamed from: a */
        public long f348a;

        /* renamed from: b */
        public TimerSystem.TimerSystemTask f349b;

        public C0525a(TimerSystem.TimerSystemTask timerSystemTask, long j) {
            this.f348a = j;
            this.f349b = timerSystemTask;
        }
    }

    public TimerSystemOEM() {
        new Thread(this).start();
    }

    public static void terminate() {
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.TimerSystem
    public boolean cancel(TimerSystem.TimerSystemTask timerSystemTask) {
        boolean z;
        if (f344a.isDebugEnabled()) {
            f344a.debug("Canceling task");
        }
        synchronized (this.f346c) {
            int i = 0;
            while (true) {
                if (i >= this.f345b.size()) {
                    z = false;
                    break;
                }
                if (((C0525a) this.f345b.elementAt(i)).f349b == timerSystemTask) {
                    z = true;
                    this.f345b.removeElementAt(i);
                    break;
                }
                i++;
            }
        }
        return z;
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException {
        while (!this.f347d) {
            synchronized (this.f346c) {
                if (this.f345b.size() > 0) {
                    C0525a c0525a = (C0525a) this.f345b.elementAt(0);
                    if (c0525a.f348a < System.currentTimeMillis()) {
                        this.f345b.removeElementAt(0);
                        if (f344a.isTraceEnabled()) {
                            f344a.trace("Removed a task from the queue");
                        }
                        if (c0525a != null) {
                            try {
                                if (f344a.isDebugEnabled()) {
                                    f344a.debug("Executing timer task");
                                }
                                c0525a.f349b.run();
                                if (f344a.isDebugEnabled()) {
                                    f344a.debug("Done executing timer task");
                                }
                            } catch (Exception e) {
                                f344a.error("TimerSystemJ2me caught an exception:" + e);
                            }
                        } else {
                            Thread.sleep(20L);
                        }
                    } else {
                        try {
                            long jCurrentTimeMillis = c0525a.f348a - System.currentTimeMillis();
                            if (jCurrentTimeMillis > 0) {
                                if (f344a.isTraceEnabled()) {
                                    f344a.trace("Waiting on condition for " + jCurrentTimeMillis);
                                }
                                this.f346c.wait(jCurrentTimeMillis);
                            }
                        } catch (InterruptedException e2) {
                            if (f344a.isWarnEnabled()) {
                                f344a.warn("Waiting on syncObj threw an exception: ", e2);
                            }
                        }
                    }
                } else {
                    try {
                        if (f344a.isTraceEnabled()) {
                            f344a.trace("No task in queue. Waiting.");
                        }
                        this.f346c.wait();
                    } catch (InterruptedException e3) {
                        if (f344a.isWarnEnabled()) {
                            f344a.warn("Waiting on syncObj threw an exception: ", e3);
                        }
                    }
                }
            }
        }
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.TimerSystem
    public void schedule(TimerSystem.TimerSystemTask timerSystemTask, long j) {
        long jCurrentTimeMillis = System.currentTimeMillis() + j;
        if (f344a.isDebugEnabled()) {
            f344a.debug("Scheduling TimerSystemTask for time: " + jCurrentTimeMillis);
        }
        C0525a c0525a = new C0525a(timerSystemTask, jCurrentTimeMillis);
        synchronized (this.f346c) {
            int size = this.f345b.size();
            for (int i = 0; i < size; i++) {
                if (((C0525a) this.f345b.elementAt(i)).f348a > c0525a.f348a) {
                    if (f344a.isTraceEnabled()) {
                        f344a.trace("Inserting new timer task at index " + i);
                    }
                    this.f345b.insertElementAt(c0525a, i);
                    this.f346c.notify();
                    return;
                }
            }
            if (f344a.isTraceEnabled()) {
                f344a.trace("Inserting new timer task at index 0");
            }
            this.f345b.addElement(c0525a);
            this.f346c.notify();
        }
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.TimerSystem
    public void stop() {
        this.f347d = true;
        synchronized (this.f346c) {
            this.f346c.notify();
        }
    }
}
