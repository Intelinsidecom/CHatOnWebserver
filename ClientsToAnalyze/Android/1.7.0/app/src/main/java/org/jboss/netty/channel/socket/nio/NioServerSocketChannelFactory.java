package org.jboss.netty.channel.socket.nio;

import java.util.concurrent.Executor;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelSink;
import org.jboss.netty.channel.socket.ServerSocketChannel;
import org.jboss.netty.channel.socket.ServerSocketChannelFactory;
import org.jboss.netty.util.internal.ExecutorUtil;

/* loaded from: classes.dex */
public class NioServerSocketChannelFactory implements ServerSocketChannelFactory {
    final Executor bossExecutor;
    private final ChannelSink sink;
    private final Executor workerExecutor;

    public NioServerSocketChannelFactory(Executor executor, Executor executor2) {
        this(executor, executor2, SelectorUtil.DEFAULT_IO_THREADS);
    }

    public NioServerSocketChannelFactory(Executor executor, Executor executor2, int i) {
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
        this.sink = new NioServerSocketPipelineSink(executor2, i);
    }

    @Override // org.jboss.netty.channel.ServerChannelFactory, org.jboss.netty.channel.ChannelFactory
    public ServerSocketChannel newChannel(ChannelPipeline channelPipeline) {
        return new NioServerSocketChannel(this, channelPipeline, this.sink);
    }

    @Override // org.jboss.netty.channel.ChannelFactory, org.jboss.netty.util.ExternalResourceReleasable
    public void releaseExternalResources() {
        ExecutorUtil.terminate(this.bossExecutor, this.workerExecutor);
    }
}
