package org.jboss.netty.channel.socket.oio;

import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.MulticastSocket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.Channels;

/* loaded from: classes.dex */
class OioDatagramWorker implements Runnable {
    private final OioDatagramChannel channel;

    OioDatagramWorker(OioDatagramChannel oioDatagramChannel) {
        this.channel = oioDatagramChannel;
    }

    static void close(OioDatagramChannel oioDatagramChannel, ChannelFuture channelFuture) {
        boolean zIsConnected = oioDatagramChannel.isConnected();
        boolean zIsBound = oioDatagramChannel.isBound();
        try {
            oioDatagramChannel.socket.close();
            if (!oioDatagramChannel.setClosed()) {
                channelFuture.setSuccess();
                return;
            }
            channelFuture.setSuccess();
            if (zIsConnected) {
                Thread threadCurrentThread = Thread.currentThread();
                Thread thread = oioDatagramChannel.workerThread;
                if (thread != null && threadCurrentThread != thread) {
                    thread.interrupt();
                }
                Channels.fireChannelDisconnected(oioDatagramChannel);
            }
            if (zIsBound) {
                Channels.fireChannelUnbound(oioDatagramChannel);
            }
            Channels.fireChannelClosed(oioDatagramChannel);
        } catch (Throwable th) {
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught(oioDatagramChannel, th);
        }
    }

    static void disconnect(OioDatagramChannel oioDatagramChannel, ChannelFuture channelFuture) {
        boolean zIsConnected = oioDatagramChannel.isConnected();
        try {
            oioDatagramChannel.socket.disconnect();
            channelFuture.setSuccess();
            if (zIsConnected) {
                Thread thread = oioDatagramChannel.workerThread;
                if (thread != null) {
                    try {
                        thread.setName("Old I/O datagram worker (" + oioDatagramChannel + ')');
                    } catch (SecurityException e) {
                    }
                }
                Channels.fireChannelDisconnected(oioDatagramChannel);
            }
        } catch (Throwable th) {
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught(oioDatagramChannel, th);
        }
    }

    static void setInterestOps(OioDatagramChannel oioDatagramChannel, ChannelFuture channelFuture, int i) {
        boolean z;
        int interestOps = (i & (-5)) | (oioDatagramChannel.getInterestOps() & 4);
        try {
            if (oioDatagramChannel.getInterestOps() != interestOps) {
                if ((interestOps & 1) != 0) {
                    oioDatagramChannel.setInterestOpsNow(1);
                } else {
                    oioDatagramChannel.setInterestOpsNow(0);
                }
                z = true;
            } else {
                z = false;
            }
            channelFuture.setSuccess();
            if (z) {
                synchronized (oioDatagramChannel.interestOpsLock) {
                    oioDatagramChannel.setInterestOpsNow(interestOps);
                    Thread threadCurrentThread = Thread.currentThread();
                    Thread thread = oioDatagramChannel.workerThread;
                    if (thread != null && threadCurrentThread != thread) {
                        thread.interrupt();
                    }
                }
                Channels.fireChannelInterestChanged(oioDatagramChannel);
            }
        } catch (Throwable th) {
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught(oioDatagramChannel, th);
        }
    }

    static void write(OioDatagramChannel oioDatagramChannel, ChannelFuture channelFuture, Object obj, SocketAddress socketAddress) {
        DatagramPacket datagramPacket;
        try {
            ChannelBuffer channelBuffer = (ChannelBuffer) obj;
            int i = channelBuffer.readerIndex();
            int i2 = channelBuffer.readableBytes();
            ByteBuffer byteBuffer = channelBuffer.toByteBuffer();
            if (byteBuffer.hasArray()) {
                datagramPacket = new DatagramPacket(byteBuffer.array(), i + byteBuffer.arrayOffset(), i2);
            } else {
                byte[] bArr = new byte[i2];
                channelBuffer.getBytes(0, bArr);
                datagramPacket = new DatagramPacket(bArr, i2);
            }
            if (socketAddress != null) {
                datagramPacket.setSocketAddress(socketAddress);
            }
            oioDatagramChannel.socket.send(datagramPacket);
            Channels.fireWriteComplete(oioDatagramChannel, i2);
            channelFuture.setSuccess();
        } catch (Throwable th) {
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught(oioDatagramChannel, th);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.channel.workerThread = Thread.currentThread();
        MulticastSocket multicastSocket = this.channel.socket;
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
            byte[] bArr = new byte[this.channel.getConfig().getReceiveBufferSizePredictor().nextReceiveBufferSize()];
            DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length);
            try {
                multicastSocket.receive(datagramPacket);
                Channels.fireMessageReceived(this.channel, this.channel.getConfig().getBufferFactory().getBuffer(bArr, 0, datagramPacket.getLength()), datagramPacket.getSocketAddress());
            } catch (InterruptedIOException e2) {
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
