package org.jboss.netty.channel.group;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;
import org.jboss.netty.util.internal.DeadLockProofWorker;

/* loaded from: classes.dex */
public class DefaultChannelGroupFuture implements ChannelGroupFuture {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) DefaultChannelGroupFuture.class);
    private final ChannelFutureListener childListener = new ChannelFutureListener() { // from class: org.jboss.netty.channel.group.DefaultChannelGroupFuture.1
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !DefaultChannelGroupFuture.class.desiredAssertionStatus();
        }

        @Override // org.jboss.netty.channel.ChannelFutureListener
        public void operationComplete(ChannelFuture channelFuture) {
            boolean z;
            boolean zIsSuccess = channelFuture.isSuccess();
            synchronized (DefaultChannelGroupFuture.this) {
                if (zIsSuccess) {
                    DefaultChannelGroupFuture.this.successCount++;
                } else {
                    DefaultChannelGroupFuture.this.failureCount++;
                }
                z = DefaultChannelGroupFuture.this.successCount + DefaultChannelGroupFuture.this.failureCount == DefaultChannelGroupFuture.this.futures.size();
                if (!$assertionsDisabled && DefaultChannelGroupFuture.this.successCount + DefaultChannelGroupFuture.this.failureCount > DefaultChannelGroupFuture.this.futures.size()) {
                    throw new AssertionError();
                }
            }
            if (z) {
                DefaultChannelGroupFuture.this.setDone();
            }
        }
    };
    private boolean done;
    int failureCount;
    private ChannelGroupFutureListener firstListener;
    final Map<Integer, ChannelFuture> futures;
    private final ChannelGroup group;
    private List<ChannelGroupFutureListener> otherListeners;
    int successCount;
    private int waiters;

    DefaultChannelGroupFuture(ChannelGroup channelGroup, Map<Integer, ChannelFuture> map) {
        this.group = channelGroup;
        this.futures = Collections.unmodifiableMap(map);
        Iterator<ChannelFuture> it = this.futures.values().iterator();
        while (it.hasNext()) {
            it.next().addListener(this.childListener);
        }
        if (this.futures.isEmpty()) {
            setDone();
        }
    }

    @Override // java.lang.Iterable
    public Iterator<ChannelFuture> iterator() {
        return this.futures.values().iterator();
    }

    @Override // org.jboss.netty.channel.group.ChannelGroupFuture
    public synchronized boolean isCompleteSuccess() {
        return this.successCount == this.futures.size();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0010  */
    @Override // org.jboss.netty.channel.group.ChannelGroupFuture
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean isCompleteFailure() {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.Map<java.lang.Integer, org.jboss.netty.channel.ChannelFuture> r0 = r2.futures     // Catch: java.lang.Throwable -> L12
            int r0 = r0.size()     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L10
            int r1 = r2.failureCount     // Catch: java.lang.Throwable -> L12
            if (r1 != r0) goto L10
            r0 = 1
        Le:
            monitor-exit(r2)
            return r0
        L10:
            r0 = 0
            goto Le
        L12:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.group.DefaultChannelGroupFuture.isCompleteFailure():boolean");
    }

    @Override // org.jboss.netty.channel.group.ChannelGroupFuture
    public void addListener(ChannelGroupFutureListener channelGroupFutureListener) {
        boolean z = true;
        if (channelGroupFutureListener == null) {
            throw new NullPointerException("listener");
        }
        synchronized (this) {
            if (!this.done) {
                if (this.firstListener == null) {
                    this.firstListener = channelGroupFutureListener;
                    z = false;
                } else {
                    if (this.otherListeners == null) {
                        this.otherListeners = new ArrayList(1);
                    }
                    this.otherListeners.add(channelGroupFutureListener);
                    z = false;
                }
            }
        }
        if (z) {
            notifyListener(channelGroupFutureListener);
        }
    }

    @Override // org.jboss.netty.channel.group.ChannelGroupFuture
    public ChannelGroupFuture awaitUninterruptibly() {
        boolean z = false;
        synchronized (this) {
            while (!this.done) {
                checkDeadLock();
                this.waiters++;
                try {
                    wait();
                    this.waiters--;
                } catch (InterruptedException e) {
                    z = true;
                    this.waiters--;
                } catch (Throwable th) {
                    this.waiters--;
                    throw th;
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return this;
    }

    private void checkDeadLock() {
        if (DeadLockProofWorker.PARENT.get() != null) {
            throw new IllegalStateException("await*() in I/O thread causes a dead lock or sudden performance drop. Use addListener() instead or call await*() from a different thread.");
        }
    }

    boolean setDone() {
        boolean z = true;
        synchronized (this) {
            if (this.done) {
                z = false;
            } else {
                this.done = true;
                if (this.waiters > 0) {
                    notifyAll();
                }
                notifyListeners();
            }
        }
        return z;
    }

    private void notifyListeners() {
        if (this.firstListener != null) {
            notifyListener(this.firstListener);
            this.firstListener = null;
            if (this.otherListeners != null) {
                Iterator<ChannelGroupFutureListener> it = this.otherListeners.iterator();
                while (it.hasNext()) {
                    notifyListener(it.next());
                }
                this.otherListeners = null;
            }
        }
    }

    private void notifyListener(ChannelGroupFutureListener channelGroupFutureListener) {
        try {
            channelGroupFutureListener.operationComplete(this);
        } catch (Throwable th) {
            logger.warn("An exception was thrown by " + ChannelFutureListener.class.getSimpleName() + ".", th);
        }
    }
}
