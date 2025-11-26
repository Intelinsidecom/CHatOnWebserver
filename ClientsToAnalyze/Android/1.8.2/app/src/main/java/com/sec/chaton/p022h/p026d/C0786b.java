package com.sec.chaton.p022h.p026d;

import android.os.PowerManager;
import com.google.protobuf.CodedOutputStream;
import com.sec.chaton.util.C1786r;
import java.nio.ByteOrder;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBufferOutputStream;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

/* compiled from: EnvelopeStreamEncoder.java */
/* renamed from: com.sec.chaton.h.d.b */
/* loaded from: classes.dex */
public class C0786b extends OneToOneEncoder {

    /* renamed from: a */
    private PowerManager.WakeLock f2892a;

    public C0786b(PowerManager.WakeLock wakeLock) {
        this.f2892a = wakeLock;
    }

    @Override // org.jboss.netty.handler.codec.oneone.OneToOneEncoder
    protected Object encode(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) {
        ChannelBuffer channelBufferBuffer;
        PowerManager.WakeLock wakeLock;
        if (this.f2892a != null) {
            this.f2892a.acquire();
        }
        try {
            try {
                C0785a c0785a = (C0785a) obj;
                byte[] bArrM3369d = c0785a.m3369d();
                int length = bArrM3369d.length;
                ChannelBufferOutputStream channelBufferOutputStream = new ChannelBufferOutputStream(ChannelBuffers.dynamicBuffer(ByteOrder.BIG_ENDIAN, length + 4 + 36, channelHandlerContext.getChannel().getConfig().getBufferFactory()));
                CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(channelBufferOutputStream);
                byte[] bArr = new byte[36];
                System.arraycopy(c0785a.m3366a().getBytes("UTF-8"), 0, bArr, 0, 36);
                codedOutputStreamNewInstance.writeRawBytes(bArr);
                codedOutputStreamNewInstance.writeRawByte(c0785a.m3367b());
                codedOutputStreamNewInstance.writeRawByte(c0785a.m3368c());
                codedOutputStreamNewInstance.writeRawByte((byte) (length >> 8));
                codedOutputStreamNewInstance.writeRawByte((byte) length);
                codedOutputStreamNewInstance.writeRawBytes(bArrM3369d);
                codedOutputStreamNewInstance.flush();
                channelBufferBuffer = channelBufferOutputStream.buffer();
            } catch (Exception e) {
                C1786r.m6056a(e, getClass().getSimpleName());
                channelBufferBuffer = null;
                if (this.f2892a != null) {
                    wakeLock = this.f2892a;
                }
            }
            if (this.f2892a != null) {
                wakeLock = this.f2892a;
                wakeLock.release();
            }
            return channelBufferBuffer;
        } catch (Throwable th) {
            if (this.f2892a != null) {
                this.f2892a.release();
            }
            throw th;
        }
    }
}
