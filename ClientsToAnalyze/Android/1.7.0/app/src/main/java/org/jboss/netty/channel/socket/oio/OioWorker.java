package org.jboss.netty.channel.socket.oio;

import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.net.SocketException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.WritableByteChannel;
import java.util.regex.Pattern;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.DefaultFileRegion;
import org.jboss.netty.channel.FileRegion;

/* loaded from: classes.dex */
class OioWorker implements Runnable {
    private static final Pattern SOCKET_CLOSED_MESSAGE = Pattern.compile("^.*(?:Socket.*closed).*$", 2);
    private final OioSocketChannel channel;

    OioWorker(OioSocketChannel oioSocketChannel) {
        this.channel = oioSocketChannel;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.channel.workerThread = Thread.currentThread();
        PushbackInputStream inputStream = this.channel.getInputStream();
        boolean z = this.channel instanceof OioAcceptedSocketChannel;
        while (this.channel.isOpen()) {
            if (z) {
                Channels.fireChannelConnected(this.channel, this.channel.getRemoteAddress());
                z = false;
            }
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

    static void write(OioSocketChannel oioSocketChannel, ChannelFuture channelFuture, Object obj) {
        int i;
        OutputStream outputStream = oioSocketChannel.getOutputStream();
        if (outputStream == null) {
            ClosedChannelException closedChannelException = new ClosedChannelException();
            channelFuture.setFailure(closedChannelException);
            Channels.fireExceptionCaught(oioSocketChannel, closedChannelException);
            return;
        }
        int i2 = 0;
        try {
            if (obj instanceof FileRegion) {
                FileRegion fileRegion = (FileRegion) obj;
                try {
                    synchronized (outputStream) {
                        WritableByteChannel writableByteChannelNewChannel = java.nio.channels.Channels.newChannel(outputStream);
                        do {
                            long jTransferTo = fileRegion.transferTo(writableByteChannelNewChannel, i2);
                            if (jTransferTo <= 0) {
                                break;
                            } else {
                                i2 = (int) (jTransferTo + i2);
                            }
                        } while (i2 < fileRegion.getCount());
                    }
                    if ((fileRegion instanceof DefaultFileRegion) && ((DefaultFileRegion) fileRegion).releaseAfterTransfer()) {
                        fileRegion.releaseExternalResources();
                    }
                    i = i2;
                } finally {
                }
            } else {
                ChannelBuffer channelBuffer = (ChannelBuffer) obj;
                i = channelBuffer.readableBytes();
                synchronized (outputStream) {
                    channelBuffer.getBytes(channelBuffer.readerIndex(), outputStream, i);
                }
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

    static void setInterestOps(OioSocketChannel oioSocketChannel, ChannelFuture channelFuture, int i) {
        boolean z = true;
        int interestOps = (i & (-5)) | (oioSocketChannel.getInterestOps() & 4);
        try {
            if (oioSocketChannel.getInterestOps() == interestOps) {
                z = false;
            } else if ((interestOps & 1) != 0) {
                oioSocketChannel.setInterestOpsNow(1);
            } else {
                oioSocketChannel.setInterestOpsNow(0);
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

    static void close(OioSocketChannel oioSocketChannel, ChannelFuture channelFuture) {
        boolean zIsConnected = oioSocketChannel.isConnected();
        boolean zIsBound = oioSocketChannel.isBound();
        try {
            oioSocketChannel.socket.close();
            if (oioSocketChannel.setClosed()) {
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
                return;
            }
            channelFuture.setSuccess();
        } catch (Throwable th) {
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught(oioSocketChannel, th);
        }
    }
}
