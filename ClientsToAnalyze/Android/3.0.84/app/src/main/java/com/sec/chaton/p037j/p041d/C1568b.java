package com.sec.chaton.p037j.p041d;

import android.os.PowerManager;
import com.google.protobuf.CodedOutputStream;
import com.sec.chaton.util.C3158a;
import com.sec.chaton.util.C3250y;
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
public class C1568b extends OneToOneEncoder {

    /* renamed from: a */
    private PowerManager.WakeLock f5825a;

    public C1568b(PowerManager.WakeLock wakeLock) {
        this.f5825a = wakeLock;
    }

    @Override // org.jboss.netty.handler.codec.oneone.OneToOneEncoder
    protected Object encode(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) {
        ChannelBuffer channelBufferBuffer;
        PowerManager.WakeLock wakeLock;
        if (this.f5825a != null) {
            this.f5825a.acquire();
        }
        try {
            try {
                C1567a c1567a = (C1567a) obj;
                byte[] bArrM6670d = c1567a.m6670d();
                int length = bArrM6670d.length;
                if (C3250y.f11734b) {
                    C3250y.m11450b("UID : " + c1567a.m6667a(), getClass().getSimpleName());
                    C3250y.m11450b("reserved : " + String.valueOf(c1567a.m6668b()), getClass().getSimpleName());
                    C3250y.m11450b("type : " + String.valueOf(c1567a.m6669c()), getClass().getSimpleName());
                    C3250y.m11450b("encodedDataLength : " + String.valueOf(bArrM6670d.length), getClass().getSimpleName());
                    C3250y.m11450b("encodedDataRaw : " + C3158a.m10954a(bArrM6670d), getClass().getSimpleName());
                }
                ChannelBufferOutputStream channelBufferOutputStream = new ChannelBufferOutputStream(ChannelBuffers.dynamicBuffer(ByteOrder.BIG_ENDIAN, length + 4 + 36, channelHandlerContext.getChannel().getConfig().getBufferFactory()));
                CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(channelBufferOutputStream);
                byte[] bArr = new byte[36];
                System.arraycopy(c1567a.m6667a().getBytes("UTF-8"), 0, bArr, 0, 36);
                codedOutputStreamNewInstance.writeRawBytes(bArr);
                codedOutputStreamNewInstance.writeRawByte(c1567a.m6668b());
                codedOutputStreamNewInstance.writeRawByte(c1567a.m6669c());
                codedOutputStreamNewInstance.writeRawByte((byte) (length >> 8));
                codedOutputStreamNewInstance.writeRawByte((byte) length);
                codedOutputStreamNewInstance.writeRawBytes(bArrM6670d);
                codedOutputStreamNewInstance.flush();
                channelBufferBuffer = channelBufferOutputStream.buffer();
            } catch (Exception e) {
                C3250y.m11443a(e, getClass().getSimpleName());
                channelBufferBuffer = null;
                if (this.f5825a != null) {
                    wakeLock = this.f5825a;
                }
            }
            if (this.f5825a != null) {
                wakeLock = this.f5825a;
                wakeLock.release();
            }
            return channelBufferBuffer;
        } catch (Throwable th) {
            if (this.f5825a != null) {
                this.f5825a.release();
            }
            throw th;
        }
    }
}
