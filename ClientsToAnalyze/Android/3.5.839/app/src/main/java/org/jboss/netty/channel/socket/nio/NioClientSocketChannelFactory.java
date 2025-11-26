package org.jboss.netty.channel.socket.nio;

import java.util.concurrent.Executor;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.socket.ClientSocketChannelFactory;
import org.jboss.netty.channel.socket.SocketChannel;
import org.jboss.netty.util.internal.ExecutorUtil;

/* loaded from: classes.dex */
public class NioClientSocketChannelFactory implements ClientSocketChannelFactory {
    private final Executor bossExecutor;
    private final NioClientSocketPipelineSink sink;
    private final Executor workerExecutor;

    public NioClientSocketChannelFactory(Executor executor, Executor executor2) {
        this(executor, executor2, SelectorUtil.DEFAULT_IO_THREADS);
    }

    public NioClientSocketChannelFactory(Executor executor, Executor executor2, int i) {
        if (executor == null) {
            throw new NullPointerException("bossExecutor");
        }
        if (executor2 == null) {
            throw new NullPointerException("workerExecutor");
        }
        if (i <= 0) {
            throw new IllegalArgumentException("workerCount (" + i + ") must be a positive integer.");
        }
        this.bossExecutor = executor;
        this.workerExecutor = executor2;
        this.sink = new NioClientSocketPipelineSink(executor, executor2, i);
    }

    @Override // org.jboss.netty.channel.ChannelFactory
    public SocketChannel newChannel(ChannelPipeline channelPipeline) {
        return new NioClientSocketChannel(this, channelPipeline, this.sink, this.sink.nextWorker());
    }

    @Override // org.jboss.netty.channel.ChannelFactory, org.jboss.netty.util.ExternalResourceReleasable
    public void releaseExternalResources() {
        ExecutorUtil.terminate(this.bossExecutor, this.workerExecutor);
    }
}
