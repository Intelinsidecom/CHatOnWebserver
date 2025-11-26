package org.jboss.netty.channel.socket.nio;

import java.util.concurrent.Executor;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.socket.DatagramChannel;
import org.jboss.netty.channel.socket.DatagramChannelFactory;
import org.jboss.netty.util.internal.ExecutorUtil;

/* loaded from: classes.dex */
public class NioDatagramChannelFactory implements DatagramChannelFactory {
    private final NioDatagramPipelineSink sink;
    private final Executor workerExecutor;

    public NioDatagramChannelFactory(Executor executor) {
        this(executor, SelectorUtil.DEFAULT_IO_THREADS);
    }

    public NioDatagramChannelFactory(Executor executor, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(String.format("workerCount (%s) must be a positive integer.", Integer.valueOf(i)));
        }
        if (executor == null) {
            throw new NullPointerException("workerExecutor argument must not be null");
        }
        this.workerExecutor = executor;
        this.sink = new NioDatagramPipelineSink(executor, i);
    }

    @Override // org.jboss.netty.channel.ChannelFactory
    public DatagramChannel newChannel(ChannelPipeline channelPipeline) {
        return new NioDatagramChannel(this, channelPipeline, this.sink, this.sink.nextWorker());
    }

    @Override // org.jboss.netty.channel.ChannelFactory, org.jboss.netty.util.ExternalResourceReleasable
    public void releaseExternalResources() {
        ExecutorUtil.terminate(this.workerExecutor);
    }
}
