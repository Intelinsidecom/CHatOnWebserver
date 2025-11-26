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
    private List otherListeners;
    private List progressListeners;
    private int waiters;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(DefaultChannelFuture.class);
    private static final Throwable CANCELLED = new Throwable();
    private static volatile boolean useDeadLockChecker = true;

    public DefaultChannelFuture(Channel channel, boolean z) {
        this.channel = channel;
        this.cancellable = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x001f, code lost:
    
        if (0 == 0) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0021, code lost:
    
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0028, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0035, code lost:
    
        if (0 == 0) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0037, code lost:
    
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0060, code lost:
    
        if (r2 == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0062, code lost:
    
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x009a, code lost:
    
        if (r2 == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009c, code lost:
    
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:?, code lost:
    
        return r0;
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
    /* JADX WARN: Code restructure failed: missing block: B:80:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x007d  */
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
            monitor-enter(r12)     // Catch: java.lang.Throwable -> La4
            boolean r3 = r12.done     // Catch: java.lang.Throwable -> La7
            if (r3 == 0) goto L2e
            boolean r0 = r12.done     // Catch: java.lang.Throwable -> La7
            monitor-exit(r12)     // Catch: java.lang.Throwable -> La7
            if (r2 == 0) goto L28
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            r1.interrupt()
        L28:
            return r0
        L29:
            long r0 = java.lang.System.nanoTime()
            goto L16
        L2e:
            int r3 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r3 > 0) goto L3f
            boolean r0 = r12.done     // Catch: java.lang.Throwable -> La7
            monitor-exit(r12)     // Catch: java.lang.Throwable -> La7
            if (r2 == 0) goto L28
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            r1.interrupt()
            goto L28
        L3f:
            r12.checkDeadLock()     // Catch: java.lang.Throwable -> La7
            int r3 = r12.waiters     // Catch: java.lang.Throwable -> La7
            int r3 = r3 + 1
            r12.waiters = r3     // Catch: java.lang.Throwable -> La7
            r3 = r13
        L49:
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r5 = r3 / r5
            r7 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = r3 % r7
            int r3 = (int) r3     // Catch: java.lang.InterruptedException -> L6b java.lang.Throwable -> L6f
            r12.wait(r5, r3)     // Catch: java.lang.InterruptedException -> L6b java.lang.Throwable -> L6f
        L56:
            boolean r3 = r12.done     // Catch: java.lang.Throwable -> L6f
            if (r3 == 0) goto L87
            int r0 = r12.waiters     // Catch: java.lang.Throwable -> La7
            int r0 = r0 - r9
            r12.waiters = r0     // Catch: java.lang.Throwable -> La7
            monitor-exit(r12)     // Catch: java.lang.Throwable -> La7
            if (r2 == 0) goto L69
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L69:
            r0 = r9
            goto L28
        L6b:
            r3 = move-exception
            if (r15 == 0) goto L85
            throw r3     // Catch: java.lang.Throwable -> L6f
        L6f:
            r0 = move-exception
            r1 = r2
            int r2 = r12.waiters     // Catch: java.lang.Throwable -> L77
            int r2 = r2 - r9
            r12.waiters = r2     // Catch: java.lang.Throwable -> L77
            throw r0     // Catch: java.lang.Throwable -> L77
        L77:
            r0 = move-exception
        L78:
            monitor-exit(r12)     // Catch: java.lang.Throwable -> L77
            throw r0     // Catch: java.lang.Throwable -> L7a
        L7a:
            r0 = move-exception
        L7b:
            if (r1 == 0) goto L84
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            r1.interrupt()
        L84:
            throw r0
        L85:
            r2 = r9
            goto L56
        L87:
            long r3 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L6f
            long r3 = r3 - r0
            long r3 = r13 - r3
            int r5 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r5 > 0) goto L49
            boolean r0 = r12.done     // Catch: java.lang.Throwable -> L6f
            int r1 = r12.waiters     // Catch: java.lang.Throwable -> La7
            int r1 = r1 - r9
            r12.waiters = r1     // Catch: java.lang.Throwable -> La7
            monitor-exit(r12)     // Catch: java.lang.Throwable -> La7
            if (r2 == 0) goto L28
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            r1.interrupt()
            goto L28
        La4:
            r0 = move-exception
            r1 = r2
            goto L7b
        La7:
            r0 = move-exception
            r1 = r2
            goto L78
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.DefaultChannelFuture.await0(long, boolean):boolean");
    }

    private void checkDeadLock() {
        if (isUseDeadLockChecker() && DeadLockProofWorker.PARENT.get() != null) {
            throw new IllegalStateException("await*() in I/O thread causes a dead lock or sudden performance drop. Use addListener() instead or call await*() from a different thread.");
        }
    }

    public static boolean isUseDeadLockChecker() {
        return useDeadLockChecker;
    }

    private void notifyListener(ChannelFutureListener channelFutureListener) {
        try {
            channelFutureListener.operationComplete(this);
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
                    notifyListener((ChannelFutureListener) it.next());
                }
                this.otherListeners = null;
            }
        }
    }

    private void notifyProgressListener(ChannelFutureProgressListener channelFutureProgressListener, long j, long j2, long j3) {
        try {
            channelFutureProgressListener.operationProgressed(this, j, j2, j3);
        } catch (Throwable th) {
            logger.warn("An exception was thrown by " + ChannelFutureProgressListener.class.getSimpleName() + ".", th);
        }
    }

    public static void setUseDeadLockChecker(boolean z) {
        if (!z && !disabledDeadLockCheckerOnce) {
            disabledDeadLockCheckerOnce = true;
            logger.debug("The dead lock checker in " + DefaultChannelFuture.class.getSimpleName() + " has been disabled as requested at your own risk.");
        }
        useDeadLockChecker = z;
    }

    @Override // org.jboss.netty.channel.ChannelFuture
    public void addListener(ChannelFutureListener channelFutureListener) {
        boolean z;
        if (channelFutureListener == null) {
            throw new NullPointerException("listener");
        }
        synchronized (this) {
            if (this.done) {
                z = true;
            } else {
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
    public boolean await(long j) {
        return await0(TimeUnit.MILLISECONDS.toNanos(j), true);
    }

    @Override // org.jboss.netty.channel.ChannelFuture
    public boolean await(long j, TimeUnit timeUnit) {
        return await0(timeUnit.toNanos(j), true);
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

    @Override // org.jboss.netty.channel.ChannelFuture
    public boolean awaitUninterruptibly(long j) {
        try {
            return await0(TimeUnit.MILLISECONDS.toNanos(j), false);
        } catch (InterruptedException e) {
            throw new InternalError();
        }
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

    @Override // org.jboss.netty.channel.ChannelFuture
    public synchronized Throwable getCause() {
        return this.cause != CANCELLED ? this.cause : null;
    }

    @Override // org.jboss.netty.channel.ChannelFuture
    public Channel getChannel() {
        return this.channel;
    }

    @Override // org.jboss.netty.channel.ChannelFuture
    public synchronized boolean isCancelled() {
        return this.cause == CANCELLED;
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
    public void removeListener(ChannelFutureListener channelFutureListener) {
        if (channelFutureListener == null) {
            throw new NullPointerException("listener");
        }
        synchronized (this) {
            if (!this.done) {
                if (channelFutureListener == this.firstListener) {
                    if (this.otherListeners == null || this.otherListeners.isEmpty()) {
                        this.firstListener = null;
                    } else {
                        this.firstListener = (ChannelFutureListener) this.otherListeners.remove(0);
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
    public boolean setFailure(Throwable th) {
        synchronized (this) {
            if (this.done) {
                return false;
            }
            this.cause = th;
            this.done = true;
            if (this.waiters > 0) {
                notifyAll();
            }
            notifyListeners();
            return true;
        }
    }

    @Override // org.jboss.netty.channel.ChannelFuture
    public boolean setProgress(long j, long j2, long j3) {
        synchronized (this) {
            if (this.done) {
                return false;
            }
            List list = this.progressListeners;
            if (list == null || list.isEmpty()) {
                return true;
            }
            for (ChannelFutureProgressListener channelFutureProgressListener : (ChannelFutureProgressListener[]) list.toArray(new ChannelFutureProgressListener[list.size()])) {
                notifyProgressListener(channelFutureProgressListener, j, j2, j3);
            }
            return true;
        }
    }

    @Override // org.jboss.netty.channel.ChannelFuture
    public boolean setSuccess() {
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
