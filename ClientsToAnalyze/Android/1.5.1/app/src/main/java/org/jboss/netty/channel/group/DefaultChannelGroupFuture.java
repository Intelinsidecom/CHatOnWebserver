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

    /* JADX WARN: Code restructure failed: missing block: B:17:0x001f, code lost:
    
        if (0 == 0) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0021, code lost:
    
        r1 = java.lang.Thread.currentThread();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0035, code lost:
    
        if (0 == 0) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0037, code lost:
    
        r1 = java.lang.Thread.currentThread();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005d, code lost:
    
        if (r2 == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x005f, code lost:
    
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0097, code lost:
    
        if (r2 == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0099, code lost:
    
        r1 = java.lang.Thread.currentThread();
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:?, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean await0(long r13, boolean r15) throws java.lang.Throwable {
        /*
            r12 = this;
            r10 = 0
            r9 = 1
            if (r15 == 0) goto L11
            boolean r0 = java.lang.Thread.interrupted()
            if (r0 == 0) goto L11
            java.lang.InterruptedException r0 = new java.lang.InterruptedException
            r0.<init>()
            throw r0
        L11:
            int r0 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r0 > 0) goto L29
            r0 = r10
        L16:
            r2 = 0
            monitor-enter(r12)     // Catch: java.lang.Throwable -> L9e
            boolean r3 = r12.done     // Catch: java.lang.Throwable -> La1
            if (r3 == 0) goto L2e
            boolean r0 = r12.done     // Catch: java.lang.Throwable -> La1
            monitor-exit(r12)     // Catch: java.lang.Throwable -> La1
            if (r2 == 0) goto L28
            java.lang.Thread r1 = java.lang.Thread.currentThread()
        L25:
            r1.interrupt()
        L28:
            return r0
        L29:
            long r0 = java.lang.System.nanoTime()
            goto L16
        L2e:
            int r3 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r3 > 0) goto L3c
            boolean r0 = r12.done     // Catch: java.lang.Throwable -> La1
            monitor-exit(r12)     // Catch: java.lang.Throwable -> La1
            if (r2 == 0) goto L28
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            goto L25
        L3c:
            r12.checkDeadLock()     // Catch: java.lang.Throwable -> La1
            int r3 = r12.waiters     // Catch: java.lang.Throwable -> La1
            int r3 = r3 + 1
            r12.waiters = r3     // Catch: java.lang.Throwable -> La1
            r3 = r13
        L46:
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r5 = r3 / r5
            r7 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = r3 % r7
            int r3 = (int) r3     // Catch: java.lang.InterruptedException -> L68 java.lang.Throwable -> L6c
            r12.wait(r5, r3)     // Catch: java.lang.InterruptedException -> L68 java.lang.Throwable -> L6c
        L53:
            boolean r3 = r12.done     // Catch: java.lang.Throwable -> L6c
            if (r3 == 0) goto L84
            int r0 = r12.waiters     // Catch: java.lang.Throwable -> La1
            int r0 = r0 - r9
            r12.waiters = r0     // Catch: java.lang.Throwable -> La1
            monitor-exit(r12)     // Catch: java.lang.Throwable -> La1
            if (r2 == 0) goto L66
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L66:
            r0 = r9
            goto L28
        L68:
            r3 = move-exception
            if (r15 == 0) goto L82
            throw r3     // Catch: java.lang.Throwable -> L6c
        L6c:
            r0 = move-exception
            r1 = r2
            int r2 = r12.waiters     // Catch: java.lang.Throwable -> L74
            int r2 = r2 - r9
            r12.waiters = r2     // Catch: java.lang.Throwable -> L74
            throw r0     // Catch: java.lang.Throwable -> L74
        L74:
            r0 = move-exception
        L75:
            monitor-exit(r12)     // Catch: java.lang.Throwable -> L74
            throw r0     // Catch: java.lang.Throwable -> L77
        L77:
            r0 = move-exception
        L78:
            if (r1 == 0) goto L81
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            r1.interrupt()
        L81:
            throw r0
        L82:
            r2 = r9
            goto L53
        L84:
            long r3 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L6c
            long r3 = r3 - r0
            long r3 = r13 - r3
            int r5 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r5 > 0) goto L46
            boolean r0 = r12.done     // Catch: java.lang.Throwable -> L6c
            int r1 = r12.waiters     // Catch: java.lang.Throwable -> La1
            int r1 = r1 - r9
            r12.waiters = r1     // Catch: java.lang.Throwable -> La1
            monitor-exit(r12)     // Catch: java.lang.Throwable -> La1
            if (r2 == 0) goto L28
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            goto L25
        L9e:
            r0 = move-exception
            r1 = r2
            goto L78
        La1:
            r0 = move-exception
            r1 = r2
            goto L75
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.group.DefaultChannelGroupFuture.await0(long, boolean):boolean");
    }

    private void checkDeadLock() {
        if (DeadLockProofWorker.PARENT.get() != null) {
            throw new IllegalStateException("await*() in I/O thread causes a dead lock or sudden performance drop. Use addListener() instead or call await*() from a different thread.");
        }
    }

    private void notifyListener(ChannelGroupFutureListener channelGroupFutureListener) {
        try {
            channelGroupFutureListener.operationComplete(this);
        } catch (Throwable th) {
            logger.warn("An exception was thrown by " + ChannelFutureListener.class.getSimpleName() + ".", th);
        }
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

    @Override // org.jboss.netty.channel.group.ChannelGroupFuture
    public void addListener(ChannelGroupFutureListener channelGroupFutureListener) {
        if (channelGroupFutureListener == null) {
            throw new NullPointerException("listener");
        }
        boolean z = false;
        synchronized (this) {
            if (this.done) {
                z = true;
            } else if (this.firstListener == null) {
                this.firstListener = channelGroupFutureListener;
            } else {
                if (this.otherListeners == null) {
                    this.otherListeners = new ArrayList(1);
                }
                this.otherListeners.add(channelGroupFutureListener);
            }
        }
        if (z) {
            notifyListener(channelGroupFutureListener);
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
    public boolean await(long j) {
        return await0(TimeUnit.MILLISECONDS.toNanos(j), true);
    }

    @Override // org.jboss.netty.channel.group.ChannelGroupFuture
    public boolean await(long j, TimeUnit timeUnit) {
        return await0(timeUnit.toNanos(j), true);
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
                    this.waiters--;
                    z = true;
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
    public boolean awaitUninterruptibly(long j) {
        try {
            return await0(TimeUnit.MILLISECONDS.toNanos(j), false);
        } catch (InterruptedException e) {
            throw new InternalError();
        }
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
    public ChannelFuture find(Integer num) {
        return (ChannelFuture) this.futures.get(num);
    }

    @Override // org.jboss.netty.channel.group.ChannelGroupFuture
    public ChannelFuture find(Channel channel) {
        return (ChannelFuture) this.futures.get(channel.getId());
    }

    @Override // org.jboss.netty.channel.group.ChannelGroupFuture
    public ChannelGroup getGroup() {
        return this.group;
    }

    @Override // org.jboss.netty.channel.group.ChannelGroupFuture
    public synchronized boolean isCompleteFailure() {
        return this.failureCount == this.futures.size();
    }

    @Override // org.jboss.netty.channel.group.ChannelGroupFuture
    public synchronized boolean isCompleteSuccess() {
        return this.successCount == this.futures.size();
    }

    @Override // org.jboss.netty.channel.group.ChannelGroupFuture
    public synchronized boolean isDone() {
        return this.done;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0010  */
    @Override // org.jboss.netty.channel.group.ChannelGroupFuture
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean isPartialFailure() {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.Map r0 = r1.futures     // Catch: java.lang.Throwable -> L12
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L12
            if (r0 != 0) goto L10
            int r0 = r1.failureCount     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L10
            r0 = 1
        Le:
            monitor-exit(r1)
            return r0
        L10:
            r0 = 0
            goto Le
        L12:
            r0 = move-exception
            monitor-exit(r1)
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
    public synchronized boolean isPartialSuccess() {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.Map r0 = r1.futures     // Catch: java.lang.Throwable -> L12
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L12
            if (r0 != 0) goto L10
            int r0 = r1.successCount     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L10
            r0 = 1
        Le:
            monitor-exit(r1)
            return r0
        L10:
            r0 = 0
            goto Le
        L12:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.group.DefaultChannelGroupFuture.isPartialSuccess():boolean");
    }

    @Override // org.jboss.netty.channel.group.ChannelGroupFuture, java.lang.Iterable
    public Iterator iterator() {
        return this.futures.values().iterator();
    }

    @Override // org.jboss.netty.channel.group.ChannelGroupFuture
    public void removeListener(ChannelGroupFutureListener channelGroupFutureListener) {
        if (channelGroupFutureListener == null) {
            throw new NullPointerException("listener");
        }
        synchronized (this) {
            if (!this.done) {
                if (channelGroupFutureListener == this.firstListener) {
                    if (this.otherListeners == null || this.otherListeners.isEmpty()) {
                        this.firstListener = null;
                    } else {
                        this.firstListener = (ChannelGroupFutureListener) this.otherListeners.remove(0);
                    }
                } else if (this.otherListeners != null) {
                    this.otherListeners.remove(channelGroupFutureListener);
                }
            }
        }
    }

    boolean setDone() {
        synchronized (this) {
            if (this.done) {
                return false;
            }
            this.done = true;
            if (this.waiters > 0) {
                notifyAll();
            }
            notifyListeners();
            return true;
        }
    }
}
