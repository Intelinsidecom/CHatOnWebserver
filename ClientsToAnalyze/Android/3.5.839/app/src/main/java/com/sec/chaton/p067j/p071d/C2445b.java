package com.sec.chaton.p067j.p071d;

import android.os.PowerManager;
import com.google.protobuf.CodedOutputStream;
import com.sec.chaton.util.C4808a;
import com.sec.chaton.util.C4904y;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBufferOutputStream;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

/* compiled from: EnvelopeStreamEncoder.java */
/* renamed from: com.sec.chaton.j.d.b */
/* loaded from: classes.dex */
public class C2445b extends OneToOneEncoder {

    /* renamed from: a */
    private PowerManager.WakeLock f8769a;

    public C2445b(PowerManager.WakeLock wakeLock) {
        this.f8769a = wakeLock;
    }

    @Override // org.jboss.netty.handler.codec.oneone.OneToOneEncoder
    protected Object encode(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) {
        ChannelBuffer channelBufferBuffer;
        PowerManager.WakeLock wakeLock;
        if (this.f8769a != null) {
            this.f8769a.acquire();
        }
        try {
            try {
                C2444a c2444a = (C2444a) obj;
                byte[] bArrM10614d = c2444a.m10614d();
                int length = bArrM10614d.length;
                if (C4904y.f17872b) {
                    C4904y.m18639b("UID : " + c2444a.m10611a(), getClass().getSimpleName());
                    C4904y.m18639b("reserved : " + String.valueOf(c2444a.m10612b()), getClass().getSimpleName());
                    C4904y.m18639b("type : " + String.valueOf(c2444a.m10613c()), getClass().getSimpleName());
                    C4904y.m18639b("encodedDataLength : " + String.valueOf(bArrM10614d.length), getClass().getSimpleName());
                    C4904y.m18639b("encodedDataRaw : " + C4808a.m18098a(bArrM10614d), getClass().getSimpleName());
                }
                ChannelBufferOutputStream channelBufferOutputStream = new ChannelBufferOutputStream(ChannelBuffers.dynamicBuffer(ByteOrder.BIG_ENDIAN, length + 6 + 36, channelHandlerContext.getChannel().getConfig().getBufferFactory()));
                CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(channelBufferOutputStream);
                byte[] bArr = new byte[36];
                System.arraycopy(c2444a.m10611a().getBytes("UTF-8"), 0, bArr, 0, 36);
                codedOutputStreamNewInstance.writeRawBytes(bArr);
                codedOutputStreamNewInstance.writeRawByte(c2444a.m10612b());
                codedOutputStreamNewInstance.writeRawByte(c2444a.m10613c());
                codedOutputStreamNewInstance.writeRawBytes(ByteBuffer.allocate(4).putInt(length).array());
                codedOutputStreamNewInstance.writeRawBytes(bArrM10614d);
                codedOutputStreamNewInstance.flush();
                channelBufferBuffer = channelBufferOutputStream.buffer();
            } catch (Exception e) {
                C4904y.m18635a(e, getClass().getSimpleName());
                channelBufferBuffer = null;
                if (this.f8769a != null) {
                    wakeLock = this.f8769a;
                }
            }
            if (this.f8769a != null) {
                wakeLock = this.f8769a;
                wakeLock.release();
            }
            return channelBufferBuffer;
        } catch (Throwable th) {
            if (this.f8769a != null) {
                this.f8769a.release();
            }
            throw th;
        }
    }
}
