package org.jboss.netty.handler.execution;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelState;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.WriteCompletionEvent;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;
import org.jboss.netty.util.DefaultObjectSizeEstimator;
import org.jboss.netty.util.ObjectSizeEstimator;
import org.jboss.netty.util.internal.ConcurrentIdentityHashMap;
import org.jboss.netty.util.internal.LinkedTransferQueue;
import org.jboss.netty.util.internal.SharedResourceMisuseDetector;

/* loaded from: classes.dex */
public class MemoryAwareThreadPoolExecutor extends ThreadPoolExecutor {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(MemoryAwareThreadPoolExecutor.class);
    private static final SharedResourceMisuseDetector misuseDetector = new SharedResourceMisuseDetector(MemoryAwareThreadPoolExecutor.class);
    private final ConcurrentMap channelCounters;
    private volatile Settings settings;
    private final Limiter totalLimiter;

    class Limiter {
        private long counter;
        final long limit;
        private int waiters;

        Limiter(long j) {
            this.limit = j;
        }

        synchronized void decrease(long j) {
            this.counter -= j;
            if (this.counter < this.limit && this.waiters > 0) {
                notifyAll();
            }
        }

        synchronized void increase(long j) {
            while (this.counter >= this.limit) {
                this.waiters++;
                try {
                    wait();
                    this.waiters--;
                } catch (InterruptedException e) {
                    this.waiters--;
                } catch (Throwable th) {
                    this.waiters--;
                    throw th;
                }
            }
            this.counter += j;
        }
    }

    final class MemoryAwareRunnable implements Runnable {
        int estimatedSize;
        final Runnable task;

        MemoryAwareRunnable(Runnable runnable) {
            this.task = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.task.run();
        }
    }

    final class NewThreadRunsPolicy implements RejectedExecutionHandler {
        NewThreadRunsPolicy() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            try {
                new Thread(runnable, "Temporary task executor").start();
            } catch (Throwable th) {
                throw new RejectedExecutionException("Failed to start a new thread", th);
            }
        }
    }

    final class Settings {
        final long maxChannelMemorySize;
        final ObjectSizeEstimator objectSizeEstimator;

        Settings(ObjectSizeEstimator objectSizeEstimator, long j) {
            this.objectSizeEstimator = objectSizeEstimator;
            this.maxChannelMemorySize = j;
        }
    }

    public MemoryAwareThreadPoolExecutor(int i, long j, long j2) {
        this(i, j, j2, 30L, TimeUnit.SECONDS);
    }

    public MemoryAwareThreadPoolExecutor(int i, long j, long j2, long j3, TimeUnit timeUnit) {
        this(i, j, j2, j3, timeUnit, Executors.defaultThreadFactory());
    }

    public MemoryAwareThreadPoolExecutor(int i, long j, long j2, long j3, TimeUnit timeUnit, ThreadFactory threadFactory) {
        this(i, j, j2, j3, timeUnit, new DefaultObjectSizeEstimator(), threadFactory);
    }

    public MemoryAwareThreadPoolExecutor(int i, long j, long j2, long j3, TimeUnit timeUnit, ObjectSizeEstimator objectSizeEstimator, ThreadFactory threadFactory) {
        super(i, i, j3, timeUnit, new LinkedTransferQueue(), threadFactory, new NewThreadRunsPolicy());
        this.channelCounters = new ConcurrentIdentityHashMap();
        if (objectSizeEstimator == null) {
            throw new NullPointerException("objectSizeEstimator");
        }
        if (j < 0) {
            throw new IllegalArgumentException("maxChannelMemorySize: " + j);
        }
        if (j2 < 0) {
            throw new IllegalArgumentException("maxTotalMemorySize: " + j2);
        }
        try {
            getClass().getMethod("allowCoreThreadTimeOut", Boolean.TYPE).invoke(this, Boolean.TRUE);
        } catch (Throwable th) {
            logger.debug("ThreadPoolExecutor.allowCoreThreadTimeOut() is not supported in this platform.");
        }
        this.settings = new Settings(objectSizeEstimator, j);
        if (j2 == 0) {
            this.totalLimiter = null;
        } else {
            this.totalLimiter = new Limiter(j2);
        }
        misuseDetector.increase();
    }

    private AtomicLong getChannelCounter(Channel channel) {
        AtomicLong atomicLong = (AtomicLong) this.channelCounters.get(channel);
        if (atomicLong == null) {
            AtomicLong atomicLong2 = new AtomicLong();
            atomicLong = (AtomicLong) this.channelCounters.putIfAbsent(channel, atomicLong2);
            if (atomicLong == null) {
                atomicLong = atomicLong2;
            }
        }
        if (!channel.isOpen()) {
            this.channelCounters.remove(channel);
        }
        return atomicLong;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        decreaseCounter(runnable);
    }

    protected void decreaseCounter(Runnable runnable) {
        if (shouldCount(runnable)) {
            long j = this.settings.maxChannelMemorySize;
            int i = runnable instanceof ChannelEventRunnable ? ((ChannelEventRunnable) runnable).estimatedSize : ((MemoryAwareRunnable) runnable).estimatedSize;
            if (this.totalLimiter != null) {
                this.totalLimiter.decrease(i);
            }
            if (runnable instanceof ChannelEventRunnable) {
                ChannelEventRunnable channelEventRunnable = (ChannelEventRunnable) runnable;
                Channel channel = channelEventRunnable.getEvent().getChannel();
                long jAddAndGet = getChannelCounter(channel).addAndGet(-i);
                if (j == 0 || jAddAndGet >= j || !channel.isOpen() || channel.isReadable()) {
                    return;
                }
                ChannelHandlerContext context = channelEventRunnable.getContext();
                if (context.getHandler() instanceof ExecutionHandler) {
                    context.setAttachment(null);
                }
                channel.setReadable(true);
            }
        }
    }

    protected void doExecute(Runnable runnable) {
        doUnorderedExecute(runnable);
    }

    protected final void doUnorderedExecute(Runnable runnable) {
        super.execute(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        Runnable memoryAwareRunnable = !(runnable instanceof ChannelEventRunnable) ? new MemoryAwareRunnable(runnable) : runnable;
        increaseCounter(memoryAwareRunnable);
        doExecute(memoryAwareRunnable);
    }

    public long getMaxChannelMemorySize() {
        return this.settings.maxChannelMemorySize;
    }

    public long getMaxTotalMemorySize() {
        return this.totalLimiter.limit;
    }

    public ObjectSizeEstimator getObjectSizeEstimator() {
        return this.settings.objectSizeEstimator;
    }

    protected void increaseCounter(Runnable runnable) {
        if (shouldCount(runnable)) {
            Settings settings = this.settings;
            long j = settings.maxChannelMemorySize;
            int iEstimateSize = settings.objectSizeEstimator.estimateSize(runnable);
            if (runnable instanceof ChannelEventRunnable) {
                ChannelEventRunnable channelEventRunnable = (ChannelEventRunnable) runnable;
                channelEventRunnable.estimatedSize = iEstimateSize;
                Channel channel = channelEventRunnable.getEvent().getChannel();
                long jAddAndGet = getChannelCounter(channel).addAndGet(iEstimateSize);
                if (j != 0 && jAddAndGet >= j && channel.isOpen() && channel.isReadable()) {
                    ChannelHandlerContext context = channelEventRunnable.getContext();
                    if (context.getHandler() instanceof ExecutionHandler) {
                        context.setAttachment(Boolean.TRUE);
                    }
                    channel.setReadable(false);
                }
            } else {
                ((MemoryAwareRunnable) runnable).estimatedSize = iEstimateSize;
            }
            if (this.totalLimiter != null) {
                this.totalLimiter.increase(iEstimateSize);
            }
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public boolean remove(Runnable runnable) {
        boolean zRemove = super.remove(runnable);
        if (zRemove) {
            decreaseCounter(runnable);
        }
        return zRemove;
    }

    public void setMaxChannelMemorySize(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("maxChannelMemorySize: " + j);
        }
        if (getTaskCount() > 0) {
            throw new IllegalStateException("can't be changed after a task is executed");
        }
        this.settings = new Settings(this.settings.objectSizeEstimator, j);
    }

    @Deprecated
    public void setMaxTotalMemorySize(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("maxTotalMemorySize: " + j);
        }
        if (getTaskCount() > 0) {
            throw new IllegalStateException("can't be changed after a task is executed");
        }
    }

    public void setObjectSizeEstimator(ObjectSizeEstimator objectSizeEstimator) {
        if (objectSizeEstimator == null) {
            throw new NullPointerException("objectSizeEstimator");
        }
        this.settings = new Settings(objectSizeEstimator, this.settings.maxChannelMemorySize);
    }

    protected boolean shouldCount(Runnable runnable) {
        if (runnable instanceof ChannelEventRunnable) {
            ChannelEvent event = ((ChannelEventRunnable) runnable).getEvent();
            if (event instanceof WriteCompletionEvent) {
                return false;
            }
            if ((event instanceof ChannelStateEvent) && ((ChannelStateEvent) event).getState() == ChannelState.INTEREST_OPS) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void terminated() {
        super.terminated();
        misuseDetector.decrease();
    }
}
