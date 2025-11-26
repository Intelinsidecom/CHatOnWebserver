package org.jboss.netty.channel.group;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;
import org.jboss.netty.util.internal.DeadLockProofWorker;

/* loaded from: classes.dex */
public class DefaultChannelGroupFuture implements ChannelGroupFuture {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(DefaultChannelGroupFuture.class);
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
    final Map futures;
    private final ChannelGroup group;
    private List otherListeners;
    int successCount;
    private int waiters;

    public DefaultChannelGroupFuture(ChannelGroup channelGroup, Collection collection) {
        if (channelGroup == null) {
            throw new NullPointerException("group");
        }
        if (collection == null) {
            throw new NullPointerException("futures");
        }
        this.group = channelGroup;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            ChannelFuture channelFuture = (ChannelFuture) it.next();
            linkedHashMap.put(channelFuture.getChannel().getId(), channelFuture);
        }
        this.futures = Collections.unmodifiableMap(linkedHashMap);
        Iterator it2 = this.futures.values().iterator();
        while (it2.hasNext()) {
            ((ChannelFuture) it2.next()).addListener(this.childListener);
        }
        if (this.futures.isEmpty()) {
            setDone();
        }
    }

    DefaultChannelGroupFuture(ChannelGroup channelGroup, Map map) {
        this.group = channelGroup;
        this.futures = Collections.unmodifiableMap(map);
        Iterator it = this.futures.values().iterator();
        while (it.hasNext()) {
            ((ChannelFuture) it.next()).addListener(this.childListener);
        }
        if (this.futures.isEmpty()) {
            setDone();
        }
    }

    @Override // org.jboss.netty.channel.group.ChannelGroupFuture
    public ChannelGroup getGroup() {
        return this.group;
    }

    @Override // org.jboss.netty.channel.group.ChannelGroupFuture
    public ChannelFuture find(Integer num) {
        return (ChannelFuture) this.futures.get(num);
    }

    @Override // org.jboss.netty.channel.group.ChannelGroupFuture
    public ChannelFuture find(Channel channel) {
        return (ChannelFuture) this.futures.get(channel.getId());
    }

    @Override // org.jboss.netty.channel.group.ChannelGroupFuture, java.lang.Iterable
    public Iterator iterator() {
        return this.futures.values().iterator();
    }

    @Override // org.jboss.netty.channel.group.ChannelGroupFuture
    public synchronized boolean isDone() {
        return this.done;
    }

    @Override // org.jboss.netty.channel.group.ChannelGroupFuture
    public synchronized boolean isCompleteSuccess() {
        return this.successCount == this.futures.size();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0012  */
    @Override // org.jboss.netty.channel.group.ChannelGroupFuture
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean isPartialSuccess() {
        /*
            r2 = this;
            monitor-enter(r2)
            int r0 = r2.successCount     // Catch: java.lang.Throwable -> L14
            if (r0 == 0) goto L12
            int r0 = r2.successCount     // Catch: java.lang.Throwable -> L14
            java.util.Map r1 = r2.futures     // Catch: java.lang.Throwable -> L14
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L14
            if (r0 == r1) goto L12
            r0 = 1
        L10:
            monitor-exit(r2)
            return r0
        L12:
            r0 = 0
            goto L10
        L14:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.group.DefaultChannelGroupFuture.isPartialSuccess():boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0012  */
    @Override // org.jboss.netty.channel.group.ChannelGroupFuture
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean isPartialFailure() {
        /*
            r2 = this;
            monitor-enter(r2)
            int r0 = r2.failureCount     // Catch: java.lang.Throwable -> L14
            if (r0 == 0) goto L12
            int r0 = r2.failureCount     // Catch: java.lang.Throwable -> L14
            java.util.Map r1 = r2.futures     // Catch: java.lang.Throwable -> L14
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L14
            if (r0 == r1) goto L12
            r0 = 1
        L10:
            monitor-exit(r2)
            return r0
        L12:
            r0 = 0
            goto L10
        L14:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.group.DefaultChannelGroupFuture.isPartialFailure():boolean");
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
            java.util.Map r0 = r2.futures     // Catch: java.lang.Throwable -> L12
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
    public void removeListener(ChannelGroupFutureListener channelGroupFutureListener) {
        if (channelGroupFutureListener == null) {
            throw new NullPointerException("listener");
        }
        synchronized (this) {
            if (!this.done) {
                if (channelGroupFutureListener == this.firstListener) {
                    if (this.otherListeners != null && !this.otherListeners.isEmpty()) {
                        this.firstListener = (ChannelGroupFutureListener) this.otherListeners.remove(0);
                    } else {
                        this.firstListener = null;
                    }
                } else if (this.otherListeners != null) {
                    this.otherListeners.remove(channelGroupFutureListener);
                }
            }
        }
    }

    @Override // org.jboss.netty.channel.group.ChannelGroupFuture
    public ChannelGroupFuture await() throws InterruptedException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        synchronized (this) {
            while (!this.done) {
                checkDeadLock();
                this.waiters++;
                try {
                    wait();
                    this.waiters--;
                } catch (Throwable th) {
                    this.waiters--;
                    throw th;
                }
            }
        }
        return this;
    }

    @Override // org.jboss.netty.channel.group.ChannelGroupFuture
    public boolean await(long j, TimeUnit timeUnit) {
        return await0(timeUnit.toNanos(j), true);
    }

    @Override // org.jboss.netty.channel.group.ChannelGroupFuture
    public boolean await(long j) {
        return await0(TimeUnit.MILLISECONDS.toNanos(j), true);
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

    @Override // org.jboss.netty.channel.group.ChannelGroupFuture
    public boolean awaitUninterruptibly(long j, TimeUnit timeUnit) {
        try {
            return await0(timeUnit.toNanos(j), false);
        } catch (InterruptedException e) {
            throw new InternalError();
        }
    }

    @Override // org.jboss.netty.channel.group.ChannelGroupFuture
    public boolean awaitUninterruptibly(long j) {
        try {
            return await0(TimeUnit.MILLISECONDS.toNanos(j), false);
        } catch (InterruptedException e) {
            throw new InternalError();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x008b, code lost:
    
        r0 = r12.done;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x008d, code lost:
    
        r12.waiters--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0094, code lost:
    
        if (r2 == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0096, code lost:
    
        java.lang.Thread.currentThread().interrupt();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean await0(long r13, boolean r15) throws java.lang.InterruptedException {
        /*
            r12 = this;
            if (r15 == 0) goto Le
            boolean r0 = java.lang.Thread.interrupted()
            if (r0 == 0) goto Le
            java.lang.InterruptedException r0 = new java.lang.InterruptedException
            r0.<init>()
            throw r0
        Le:
            r0 = 0
            int r0 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r0 > 0) goto L20
            r0 = 0
        L16:
            r2 = 0
            monitor-enter(r12)     // Catch: java.lang.Throwable -> L32
            boolean r3 = r12.done     // Catch: java.lang.Throwable -> L2f
            if (r3 == 0) goto L25
            boolean r0 = r12.done     // Catch: java.lang.Throwable -> L2f
            monitor-exit(r12)     // Catch: java.lang.Throwable -> L2f
        L1f:
            return r0
        L20:
            long r0 = java.lang.System.nanoTime()
            goto L16
        L25:
            r3 = 0
            int r3 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r3 > 0) goto L3d
            boolean r0 = r12.done     // Catch: java.lang.Throwable -> L2f
            monitor-exit(r12)     // Catch: java.lang.Throwable -> L2f
            goto L1f
        L2f:
            r0 = move-exception
        L30:
            monitor-exit(r12)     // Catch: java.lang.Throwable -> L2f
            throw r0     // Catch: java.lang.Throwable -> L32
        L32:
            r0 = move-exception
            if (r2 == 0) goto L3c
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            r1.interrupt()
        L3c:
            throw r0
        L3d:
            r12.checkDeadLock()     // Catch: java.lang.Throwable -> L2f
            int r3 = r12.waiters     // Catch: java.lang.Throwable -> L2f
            int r3 = r3 + 1
            r12.waiters = r3     // Catch: java.lang.Throwable -> L2f
            r3 = r2
            r4 = r13
        L48:
            r6 = 1000000(0xf4240, double:4.940656E-318)
            long r6 = r4 / r6
            r8 = 1000000(0xf4240, double:4.940656E-318)
            long r4 = r4 % r8
            int r2 = (int) r4     // Catch: java.lang.InterruptedException -> L6c java.lang.Throwable -> L70
            r12.wait(r6, r2)     // Catch: java.lang.InterruptedException -> L6c java.lang.Throwable -> L70
            r2 = r3
        L56:
            boolean r3 = r12.done     // Catch: java.lang.Throwable -> L9e
            if (r3 == 0) goto L7e
            r0 = 1
            int r1 = r12.waiters     // Catch: java.lang.Throwable -> L2f
            int r1 = r1 + (-1)
            r12.waiters = r1     // Catch: java.lang.Throwable -> L2f
            monitor-exit(r12)     // Catch: java.lang.Throwable -> L2f
            if (r2 == 0) goto L1f
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            r1.interrupt()
            goto L1f
        L6c:
            r2 = move-exception
            if (r15 == 0) goto L7c
            throw r2     // Catch: java.lang.Throwable -> L70
        L70:
            r0 = move-exception
            r1 = r3
        L72:
            int r2 = r12.waiters     // Catch: java.lang.Throwable -> L79
            int r2 = r2 + (-1)
            r12.waiters = r2     // Catch: java.lang.Throwable -> L79
            throw r0     // Catch: java.lang.Throwable -> L79
        L79:
            r0 = move-exception
            r2 = r1
            goto L30
        L7c:
            r2 = 1
            goto L56
        L7e:
            long r3 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L9e
            long r3 = r3 - r0
            long r3 = r13 - r3
            r5 = 0
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 > 0) goto La1
            boolean r0 = r12.done     // Catch: java.lang.Throwable -> L9e
            int r1 = r12.waiters     // Catch: java.lang.Throwable -> L2f
            int r1 = r1 + (-1)
            r12.waiters = r1     // Catch: java.lang.Throwable -> L2f
            monitor-exit(r12)     // Catch: java.lang.Throwable -> L2f
            if (r2 == 0) goto L1f
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            r1.interrupt()
            goto L1f
        L9e:
            r0 = move-exception
            r1 = r2
            goto L72
        La1:
            r10 = r3
            r4 = r10
            r3 = r2
            goto L48
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.group.DefaultChannelGroupFuture.await0(long, boolean):boolean");
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
                Iterator it = this.otherListeners.iterator();
                while (it.hasNext()) {
                    notifyListener((ChannelGroupFutureListener) it.next());
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
