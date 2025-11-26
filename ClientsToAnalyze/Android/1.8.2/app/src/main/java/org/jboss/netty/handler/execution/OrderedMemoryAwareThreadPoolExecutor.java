package org.jboss.netty.handler.execution;

import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelState;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.util.ObjectSizeEstimator;
import org.jboss.netty.util.internal.ConcurrentIdentityWeakKeyHashMap;

/* loaded from: classes.dex */
public class OrderedMemoryAwareThreadPoolExecutor extends MemoryAwareThreadPoolExecutor {
    private final ConcurrentMap childExecutors;

    public OrderedMemoryAwareThreadPoolExecutor(int i, long j, long j2) {
        super(i, j, j2);
        this.childExecutors = newChildExecutorMap();
    }

    public OrderedMemoryAwareThreadPoolExecutor(int i, long j, long j2, long j3, TimeUnit timeUnit) {
        super(i, j, j2, j3, timeUnit);
        this.childExecutors = newChildExecutorMap();
    }

    public OrderedMemoryAwareThreadPoolExecutor(int i, long j, long j2, long j3, TimeUnit timeUnit, ThreadFactory threadFactory) {
        super(i, j, j2, j3, timeUnit, threadFactory);
        this.childExecutors = newChildExecutorMap();
    }

    public OrderedMemoryAwareThreadPoolExecutor(int i, long j, long j2, long j3, TimeUnit timeUnit, ObjectSizeEstimator objectSizeEstimator, ThreadFactory threadFactory) {
        super(i, j, j2, j3, timeUnit, objectSizeEstimator, threadFactory);
        this.childExecutors = newChildExecutorMap();
    }

    protected ConcurrentMap newChildExecutorMap() {
        return new ConcurrentIdentityWeakKeyHashMap();
    }

    protected Object getChildExecutorKey(ChannelEvent channelEvent) {
        return channelEvent.getChannel();
    }

    protected Set getChildExecutorKeySet() {
        return this.childExecutors.keySet();
    }

    protected boolean removeChildExecutor(Object obj) {
        return this.childExecutors.remove(obj) != null;
    }

    @Override // org.jboss.netty.handler.execution.MemoryAwareThreadPoolExecutor
    protected void doExecute(Runnable runnable) {
        if (!(runnable instanceof ChannelEventRunnable)) {
            doUnorderedExecute(runnable);
        } else {
            getChildExecutor(((ChannelEventRunnable) runnable).getEvent()).execute(runnable);
        }
    }

    private Executor getChildExecutor(ChannelEvent channelEvent) {
        Object childExecutorKey = getChildExecutorKey(channelEvent);
        Executor executor = (Executor) this.childExecutors.get(childExecutorKey);
        if (executor == null) {
            ChildExecutor childExecutor = new ChildExecutor();
            executor = (Executor) this.childExecutors.putIfAbsent(childExecutorKey, childExecutor);
            if (executor == null) {
                executor = childExecutor;
            }
        }
        if (channelEvent instanceof ChannelStateEvent) {
            Channel channel = channelEvent.getChannel();
            if (((ChannelStateEvent) channelEvent).getState() == ChannelState.OPEN && !channel.isOpen()) {
                this.childExecutors.remove(channel);
            }
        }
        return executor;
    }

    @Override // org.jboss.netty.handler.execution.MemoryAwareThreadPoolExecutor
    protected boolean shouldCount(Runnable runnable) {
        if (runnable instanceof ChildExecutor) {
            return false;
        }
        return super.shouldCount(runnable);
    }

    void onAfterExecute(Runnable runnable, Throwable th) {
        afterExecute(runnable, th);
    }

    final class ChildExecutor implements Runnable, Executor {
        private final LinkedList tasks = new LinkedList();

        ChildExecutor() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            boolean zIsEmpty;
            synchronized (this.tasks) {
                zIsEmpty = this.tasks.isEmpty();
                this.tasks.add(runnable);
            }
            if (zIsEmpty) {
                OrderedMemoryAwareThreadPoolExecutor.this.doUnorderedExecute(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable;
            Thread threadCurrentThread = Thread.currentThread();
            while (true) {
                synchronized (this.tasks) {
                    runnable = (Runnable) this.tasks.getFirst();
                }
                boolean z = false;
                OrderedMemoryAwareThreadPoolExecutor.this.beforeExecute(threadCurrentThread, runnable);
                try {
                    try {
                        runnable.run();
                        z = true;
                        OrderedMemoryAwareThreadPoolExecutor.this.onAfterExecute(runnable, null);
                        synchronized (this.tasks) {
                            this.tasks.removeFirst();
                            if (this.tasks.isEmpty()) {
                                return;
                            }
                        }
                    } catch (RuntimeException e) {
                        if (!z) {
                            OrderedMemoryAwareThreadPoolExecutor.this.onAfterExecute(runnable, e);
                        }
                        throw e;
                    }
                } catch (Throwable th) {
                    synchronized (this.tasks) {
                        this.tasks.removeFirst();
                        if (!this.tasks.isEmpty()) {
                            throw th;
                        }
                        return;
                    }
                }
            }
        }
    }
}
