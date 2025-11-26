package org.jboss.netty.channel.socket.oio;

import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.net.SocketException;
import java.nio.channels.ClosedChannelException;
import java.util.regex.Pattern;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.Channels;

/* loaded from: classes.dex */
class OioWorker implements Runnable {
    private static final Pattern SOCKET_CLOSED_MESSAGE = Pattern.compile("^.*(?:Socket.*closed).*$", 2);
    private final OioSocketChannel channel;

    OioWorker(OioSocketChannel oioSocketChannel) {
        this.channel = oioSocketChannel;
    }

    static void close(OioSocketChannel oioSocketChannel, ChannelFuture channelFuture) {
        boolean zIsConnected = oioSocketChannel.isConnected();
        boolean zIsBound = oioSocketChannel.isBound();
        try {
            oioSocketChannel.socket.close();
            if (!oioSocketChannel.setClosed()) {
                channelFuture.setSuccess();
                return;
            }
            channelFuture.setSuccess();
            if (zIsConnected) {
                Thread threadCurrentThread = Thread.currentThread();
                Thread thread = oioSocketChannel.workerThread;
                if (thread != null && threadCurrentThread != thread) {
                    thread.interrupt();
                }
                Channels.fireChannelDisconnected(oioSocketChannel);
            }
            if (zIsBound) {
                Channels.fireChannelUnbound(oioSocketChannel);
            }
            Channels.fireChannelClosed(oioSocketChannel);
        } catch (Throwable th) {
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught(oioSocketChannel, th);
        }
    }

    static void setInterestOps(OioSocketChannel oioSocketChannel, ChannelFuture channelFuture, int i) {
        boolean z;
        int interestOps = (i & (-5)) | (oioSocketChannel.getInterestOps() & 4);
        try {
            if (oioSocketChannel.getInterestOps() != interestOps) {
                if ((interestOps & 1) != 0) {
                    oioSocketChannel.setInterestOpsNow(1);
                } else {
                    oioSocketChannel.setInterestOpsNow(0);
                }
                z = true;
            } else {
                z = false;
            }
            channelFuture.setSuccess();
            if (z) {
                synchronized (oioSocketChannel.interestOpsLock) {
                    oioSocketChannel.setInterestOpsNow(interestOps);
                    Thread threadCurrentThread = Thread.currentThread();
                    Thread thread = oioSocketChannel.workerThread;
                    if (thread != null && threadCurrentThread != thread) {
                        thread.interrupt();
                    }
                }
                Channels.fireChannelInterestChanged(oioSocketChannel);
            }
        } catch (Throwable th) {
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught(oioSocketChannel, th);
        }
    }

    static void write(OioSocketChannel oioSocketChannel, ChannelFuture channelFuture, Object obj) {
        OutputStream outputStream = oioSocketChannel.getOutputStream();
        if (outputStream == null) {
            ClosedChannelException closedChannelException = new ClosedChannelException();
            channelFuture.setFailure(closedChannelException);
            Channels.fireExceptionCaught(oioSocketChannel, closedChannelException);
            return;
        }
        try {
            ChannelBuffer channelBuffer = (ChannelBuffer) obj;
            int i = channelBuffer.readableBytes();
            synchronized (outputStream) {
                channelBuffer.getBytes(channelBuffer.readerIndex(), outputStream, i);
            }
            Channels.fireWriteComplete(oioSocketChannel, i);
            channelFuture.setSuccess();
        } catch (Throwable th) {
            th = th;
            if ((th instanceof SocketException) && SOCKET_CLOSED_MESSAGE.matcher(String.valueOf(th.getMessage())).matches()) {
                th = new ClosedChannelException();
            }
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught(oioSocketChannel, th);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.channel.workerThread = Thread.currentThread();
        PushbackInputStream inputStream = this.channel.getInputStream();
        while (this.channel.isOpen()) {
            synchronized (this.channel.interestOpsLock) {
                while (!this.channel.isReadable()) {
                    try {
                        this.channel.interestOpsLock.wait();
                    } catch (InterruptedException e) {
                        if (!this.channel.isOpen()) {
                            break;
                        }
                    }
                }
            }
            try {
                int iAvailable = inputStream.available();
                if (iAvailable > 0) {
                    byte[] bArr = new byte[iAvailable];
                    Channels.fireMessageReceived(this.channel, this.channel.getConfig().getBufferFactory().getBuffer(bArr, 0, inputStream.read(bArr)));
                } else {
                    int i = inputStream.read();
                    if (i < 0) {
                        break;
                    } else {
                        inputStream.unread(i);
                    }
                }
            } catch (Throwable th) {
                if (!this.channel.socket.isClosed()) {
                    Channels.fireExceptionCaught(this.channel, th);
                }
            }
        }
        this.channel.workerThread = null;
        close(this.channel, Channels.succeededFuture(this.channel));
    }
}
