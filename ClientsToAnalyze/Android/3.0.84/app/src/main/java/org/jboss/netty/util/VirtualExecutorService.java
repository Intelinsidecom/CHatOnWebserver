package org.jboss.netty.util;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class VirtualExecutorService extends AbstractExecutorService {

    /* renamed from: e */
    private final Executor f13715e;

    /* renamed from: s */
    private final ExecutorService f13716s;
    volatile boolean shutdown;
    final Object startStopLock = new Object();
    Set<Thread> activeThreads = new MapBackedSet(new IdentityHashMap());

    public VirtualExecutorService(Executor executor) {
        if (executor == null) {
            throw new NullPointerException("parent");
        }
        if (executor instanceof ExecutorService) {
            this.f13715e = null;
            this.f13716s = (ExecutorService) executor;
        } else {
            this.f13715e = executor;
            this.f13716s = null;
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        boolean z;
        synchronized (this.startStopLock) {
            z = this.shutdown;
        }
        return z;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        boolean z;
        synchronized (this.startStopLock) {
            z = this.shutdown && this.activeThreads.isEmpty();
        }
        return z;
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        synchronized (this.startStopLock) {
            if (!this.shutdown) {
                this.shutdown = true;
            }
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        synchronized (this.startStopLock) {
            if (!isTerminated()) {
                shutdown();
                Iterator<Thread> it = this.activeThreads.iterator();
                while (it.hasNext()) {
                    it.next().interrupt();
                }
            }
        }
        return Collections.emptyList();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        boolean zIsTerminated;
        synchronized (this.startStopLock) {
            while (!isTerminated()) {
                this.startStopLock.wait(TimeUnit.MILLISECONDS.convert(j, timeUnit));
            }
            zIsTerminated = isTerminated();
        }
        return zIsTerminated;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("command");
        }
        if (this.shutdown) {
            throw new RejectedExecutionException();
        }
        if (this.f13716s != null) {
            this.f13716s.execute(new ChildExecutorRunnable(runnable));
        } else {
            this.f13715e.execute(new ChildExecutorRunnable(runnable));
        }
    }

    class ChildExecutorRunnable implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled;
        private final Runnable runnable;

        static {
            $assertionsDisabled = !VirtualExecutorService.class.desiredAssertionStatus();
        }

        ChildExecutorRunnable(Runnable runnable) {
            this.runnable = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread threadCurrentThread = Thread.currentThread();
            synchronized (VirtualExecutorService.this.startStopLock) {
                VirtualExecutorService.this.activeThreads.add(threadCurrentThread);
            }
            try {
                this.runnable.run();
                synchronized (VirtualExecutorService.this.startStopLock) {
                    boolean zRemove = VirtualExecutorService.this.activeThreads.remove(threadCurrentThread);
                    if (!$assertionsDisabled && !zRemove) {
                        throw new AssertionError();
                    }
                    if (VirtualExecutorService.this.isTerminated()) {
                        VirtualExecutorService.this.startStopLock.notifyAll();
                    }
                }
            } catch (Throwable th) {
                synchronized (VirtualExecutorService.this.startStopLock) {
                    boolean zRemove2 = VirtualExecutorService.this.activeThreads.remove(threadCurrentThread);
                    if (!$assertionsDisabled && !zRemove2) {
                        throw new AssertionError();
                    }
                    if (VirtualExecutorService.this.isTerminated()) {
                        VirtualExecutorService.this.startStopLock.notifyAll();
                    }
                    throw th;
                }
            }
        }
    }
}
