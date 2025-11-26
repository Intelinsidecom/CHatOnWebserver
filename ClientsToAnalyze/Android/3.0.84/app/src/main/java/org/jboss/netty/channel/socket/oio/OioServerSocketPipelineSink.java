package org.jboss.netty.channel.socket.oio;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.util.concurrent.Executor;
import org.jboss.netty.channel.AbstractChannelSink;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelState;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;
import org.jboss.netty.util.ThreadRenamingRunnable;
import org.jboss.netty.util.internal.DeadLockProofWorker;

/* loaded from: classes.dex */
class OioServerSocketPipelineSink extends AbstractChannelSink {
    static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) OioServerSocketPipelineSink.class);
    final Executor workerExecutor;

    OioServerSocketPipelineSink(Executor executor) {
        this.workerExecutor = executor;
    }

    @Override // org.jboss.netty.channel.ChannelSink
    public void eventSunk(ChannelPipeline channelPipeline, ChannelEvent channelEvent) {
        Channel channel = channelEvent.getChannel();
        if (channel instanceof OioServerSocketChannel) {
            handleServerSocket(channelEvent);
        } else if (channel instanceof OioAcceptedSocketChannel) {
            handleAcceptedSocket(channelEvent);
        }
    }

    private void handleServerSocket(ChannelEvent channelEvent) {
        if (channelEvent instanceof ChannelStateEvent) {
            ChannelStateEvent channelStateEvent = (ChannelStateEvent) channelEvent;
            OioServerSocketChannel oioServerSocketChannel = (OioServerSocketChannel) channelStateEvent.getChannel();
            ChannelFuture future = channelStateEvent.getFuture();
            ChannelState state = channelStateEvent.getState();
            Object value = channelStateEvent.getValue();
            switch (state) {
                case OPEN:
                    if (Boolean.FALSE.equals(value)) {
                        close(oioServerSocketChannel, future);
                        break;
                    }
                    break;
                case BOUND:
                    if (value != null) {
                        bind(oioServerSocketChannel, future, (SocketAddress) value);
                        break;
                    } else {
                        close(oioServerSocketChannel, future);
                        break;
                    }
            }
        }
    }

    private void handleAcceptedSocket(ChannelEvent channelEvent) {
        if (channelEvent instanceof ChannelStateEvent) {
            ChannelStateEvent channelStateEvent = (ChannelStateEvent) channelEvent;
            OioAcceptedSocketChannel oioAcceptedSocketChannel = (OioAcceptedSocketChannel) channelStateEvent.getChannel();
            ChannelFuture future = channelStateEvent.getFuture();
            ChannelState state = channelStateEvent.getState();
            Object value = channelStateEvent.getValue();
            switch (state) {
                case OPEN:
                    if (Boolean.FALSE.equals(value)) {
                        OioWorker.close(oioAcceptedSocketChannel, future);
                        break;
                    }
                    break;
                case BOUND:
                case CONNECTED:
                    if (value == null) {
                        OioWorker.close(oioAcceptedSocketChannel, future);
                        break;
                    }
                    break;
                case INTEREST_OPS:
                    OioWorker.setInterestOps(oioAcceptedSocketChannel, future, ((Integer) value).intValue());
                    break;
            }
            return;
        }
        if (channelEvent instanceof MessageEvent) {
            MessageEvent messageEvent = (MessageEvent) channelEvent;
            OioWorker.write((OioSocketChannel) messageEvent.getChannel(), messageEvent.getFuture(), messageEvent.getMessage());
        }
    }

    private void bind(OioServerSocketChannel oioServerSocketChannel, ChannelFuture channelFuture, SocketAddress socketAddress) {
        boolean z = false;
        try {
            try {
                oioServerSocketChannel.socket.bind(socketAddress, oioServerSocketChannel.getConfig().getBacklog());
                z = true;
                channelFuture.setSuccess();
                Channels.fireChannelBound(oioServerSocketChannel, oioServerSocketChannel.getLocalAddress());
                DeadLockProofWorker.start(((OioServerSocketChannelFactory) oioServerSocketChannel.getFactory()).bossExecutor, new ThreadRenamingRunnable(new Boss(oioServerSocketChannel), "Old I/O server boss (" + oioServerSocketChannel + ')'));
            } catch (Throwable th) {
                channelFuture.setFailure(th);
                Channels.fireExceptionCaught(oioServerSocketChannel, th);
                if (z) {
                    close(oioServerSocketChannel, channelFuture);
                }
            }
        } catch (Throwable th2) {
            if (z) {
                close(oioServerSocketChannel, channelFuture);
            }
            throw th2;
        }
    }

    private void close(OioServerSocketChannel oioServerSocketChannel, ChannelFuture channelFuture) {
        boolean zIsBound = oioServerSocketChannel.isBound();
        try {
            oioServerSocketChannel.socket.close();
            oioServerSocketChannel.shutdownLock.lock();
            try {
                if (oioServerSocketChannel.setClosed()) {
                    channelFuture.setSuccess();
                    if (zIsBound) {
                        Channels.fireChannelUnbound(oioServerSocketChannel);
                    }
                    Channels.fireChannelClosed(oioServerSocketChannel);
                } else {
                    channelFuture.setSuccess();
                }
            } finally {
                oioServerSocketChannel.shutdownLock.unlock();
            }
        } catch (Throwable th) {
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught(oioServerSocketChannel, th);
        }
    }

    final class Boss implements Runnable {
        private final OioServerSocketChannel channel;

        Boss(OioServerSocketChannel oioServerSocketChannel) {
            this.channel = oioServerSocketChannel;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.channel.shutdownLock.lock();
            while (this.channel.isBound()) {
                try {
                    try {
                        Socket socketAccept = this.channel.socket.accept();
                        try {
                            DeadLockProofWorker.start(OioServerSocketPipelineSink.this.workerExecutor, new ThreadRenamingRunnable(new OioWorker(new OioAcceptedSocketChannel(this.channel, this.channel.getFactory(), this.channel.getConfig().getPipelineFactory().getPipeline(), OioServerSocketPipelineSink.this, socketAccept)), "Old I/O server worker (parentId: " + this.channel.getId() + ", " + this.channel + ')'));
                        } catch (Exception e) {
                            OioServerSocketPipelineSink.logger.warn("Failed to initialize an accepted socket.", e);
                            try {
                                socketAccept.close();
                            } catch (IOException e2) {
                                OioServerSocketPipelineSink.logger.warn("Failed to close a partially accepted socket.", e2);
                            }
                        }
                    } catch (SocketTimeoutException e3) {
                    } catch (Throwable th) {
                        if (!this.channel.socket.isBound() || this.channel.socket.isClosed()) {
                            break;
                        }
                        OioServerSocketPipelineSink.logger.warn("Failed to accept a connection.", th);
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e4) {
                        }
                    }
                } finally {
                    this.channel.shutdownLock.unlock();
                }
            }
        }
    }
}
