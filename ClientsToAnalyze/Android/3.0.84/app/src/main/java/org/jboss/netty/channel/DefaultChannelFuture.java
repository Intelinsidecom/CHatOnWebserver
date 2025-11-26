package org.jboss.netty.channel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;
import org.jboss.netty.util.internal.DeadLockProofWorker;

/* loaded from: classes.dex */
public class DefaultChannelFuture implements ChannelFuture {
    private static boolean disabledDeadLockCheckerOnce;
    private final boolean cancellable;
    private Throwable cause;
    private final Channel channel;
    private boolean done;
    private ChannelFutureListener firstListener;
    private List<ChannelFutureListener> otherListeners;
    private List<ChannelFutureProgressListener> progressListeners;
    private int waiters;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) DefaultChannelFuture.class);
    private static final Throwable CANCELLED = new Throwable();
    private static volatile boolean useDeadLockChecker = true;

    public static boolean isUseDeadLockChecker() {
        return useDeadLockChecker;
    }

    public static void setUseDeadLockChecker(boolean z) {
        if (!z && !disabledDeadLockCheckerOnce) {
            disabledDeadLockCheckerOnce = true;
            logger.debug("The dead lock checker in " + DefaultChannelFuture.class.getSimpleName() + " has been disabled as requested at your own risk.");
        }
        useDeadLockChecker = z;
    }

    public DefaultChannelFuture(Channel channel, boolean z) {
        this.channel = channel;
        this.cancellable = z;
    }

    @Override // org.jboss.netty.channel.ChannelFuture
    public Channel getChannel() {
        return this.channel;
    }

    @Override // org.jboss.netty.channel.ChannelFuture
    public synchronized boolean isDone() {
        return this.done;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x000c  */
    @Override // org.jboss.netty.channel.ChannelFuture
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean isSuccess() {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.done     // Catch: java.lang.Throwable -> Le
            if (r0 == 0) goto Lc
            java.lang.Throwable r0 = r1.cause     // Catch: java.lang.Throwable -> Le
            if (r0 != 0) goto Lc
            r0 = 1
        La:
            monitor-exit(r1)
            return r0
        Lc:
            r0 = 0
            goto La
        Le:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.DefaultChannelFuture.isSuccess():boolean");
    }

    @Override // org.jboss.netty.channel.ChannelFuture
    public synchronized Throwable getCause() {
        return this.cause != CANCELLED ? this.cause : null;
    }

    @Override // org.jboss.netty.channel.ChannelFuture
    public synchronized boolean isCancelled() {
        return this.cause == CANCELLED;
    }

    @Override // org.jboss.netty.channel.ChannelFuture
    public void addListener(ChannelFutureListener channelFutureListener) {
        boolean z = true;
        if (channelFutureListener == null) {
            throw new NullPointerException("listener");
        }
        synchronized (this) {
            if (!this.done) {
                if (this.firstListener == null) {
                    this.firstListener = channelFutureListener;
                } else {
                    if (this.otherListeners == null) {
                        this.otherListeners = new ArrayList(1);
                    }
                    this.otherListeners.add(channelFutureListener);
                }
                if (channelFutureListener instanceof ChannelFutureProgressListener) {
                    if (this.progressListeners == null) {
                        this.progressListeners = new ArrayList(1);
                    }
                    this.progressListeners.add((ChannelFutureProgressListener) channelFutureListener);
                }
                z = false;
            }
        }
        if (z) {
            notifyListener(channelFutureListener);
        }
    }

    @Override // org.jboss.netty.channel.ChannelFuture
    public void removeListener(ChannelFutureListener channelFutureListener) {
        if (channelFutureListener == null) {
            throw new NullPointerException("listener");
        }
        synchronized (this) {
            if (!this.done) {
                if (channelFutureListener == this.firstListener) {
                    if (this.otherListeners != null && !this.otherListeners.isEmpty()) {
                        this.firstListener = this.otherListeners.remove(0);
                    } else {
                        this.firstListener = null;
                    }
                } else if (this.otherListeners != null) {
                    this.otherListeners.remove(channelFutureListener);
                }
                if (channelFutureListener instanceof ChannelFutureProgressListener) {
                    this.progressListeners.remove(channelFutureListener);
                }
            }
        }
    }

    @Override // org.jboss.netty.channel.ChannelFuture
    public ChannelFuture await() throws InterruptedException {
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

    @Override // org.jboss.netty.channel.ChannelFuture
    public boolean await(long j, TimeUnit timeUnit) {
        return await0(timeUnit.toNanos(j), true);
    }

    @Override // org.jboss.netty.channel.ChannelFuture
    public boolean await(long j) {
        return await0(TimeUnit.MILLISECONDS.toNanos(j), true);
    }

    @Override // org.jboss.netty.channel.ChannelFuture
    public ChannelFuture awaitUninterruptibly() {
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

    @Override // org.jboss.netty.channel.ChannelFuture
    public boolean awaitUninterruptibly(long j, TimeUnit timeUnit) {
        try {
            return await0(timeUnit.toNanos(j), false);
        } catch (InterruptedException e) {
            throw new InternalError();
        }
    }

    @Override // org.jboss.netty.channel.ChannelFuture
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
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.DefaultChannelFuture.await0(long, boolean):boolean");
    }

    private void checkDeadLock() {
        if (isUseDeadLockChecker() && DeadLockProofWorker.PARENT.get() != null) {
            throw new IllegalStateException("await*() in I/O thread causes a dead lock or sudden performance drop. Use addListener() instead or call await*() from a different thread.");
        }
    }

    @Override // org.jboss.netty.channel.ChannelFuture
    public boolean setSuccess() {
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

    @Override // org.jboss.netty.channel.ChannelFuture
    public boolean setFailure(Throwable th) {
        boolean z = true;
        synchronized (this) {
            if (this.done) {
                z = false;
            } else {
                this.cause = th;
                this.done = true;
                if (this.waiters > 0) {
                    notifyAll();
                }
                notifyListeners();
            }
        }
        return z;
    }

    @Override // org.jboss.netty.channel.ChannelFuture
    public boolean cancel() {
        if (!this.cancellable) {
            return false;
        }
        synchronized (this) {
            if (this.done) {
                return false;
            }
            this.cause = CANCELLED;
            this.done = true;
            if (this.waiters > 0) {
                notifyAll();
            }
            notifyListeners();
            return true;
        }
    }

    private void notifyListeners() {
        if (this.firstListener != null) {
            notifyListener(this.firstListener);
            this.firstListener = null;
            if (this.otherListeners != null) {
                Iterator<ChannelFutureListener> it = this.otherListeners.iterator();
                while (it.hasNext()) {
                    notifyListener(it.next());
                }
                this.otherListeners = null;
            }
        }
    }

    private void notifyListener(ChannelFutureListener channelFutureListener) {
        try {
            channelFutureListener.operationComplete(this);
        } catch (Throwable th) {
            logger.warn("An exception was thrown by " + ChannelFutureListener.class.getSimpleName() + ".", th);
        }
    }

    @Override // org.jboss.netty.channel.ChannelFuture
    public boolean setProgress(long j, long j2, long j3) {
        synchronized (this) {
            if (this.done) {
                return false;
            }
            List<ChannelFutureProgressListener> list = this.progressListeners;
            if (list == null || list.isEmpty()) {
                return true;
            }
            for (ChannelFutureProgressListener channelFutureProgressListener : (ChannelFutureProgressListener[]) list.toArray(new ChannelFutureProgressListener[list.size()])) {
                notifyProgressListener(channelFutureProgressListener, j, j2, j3);
            }
            return true;
        }
    }

    private void notifyProgressListener(ChannelFutureProgressListener channelFutureProgressListener, long j, long j2, long j3) {
        try {
            channelFutureProgressListener.operationProgressed(this, j, j2, j3);
        } catch (Throwable th) {
            logger.warn("An exception was thrown by " + ChannelFutureProgressListener.class.getSimpleName() + ".", th);
        }
    }
}
