package com.sec.chaton.p018c.p020b;

import android.os.PowerManager;
import com.google.protobuf.CodedOutputStream;
import com.sec.chaton.util.C1322br;
import com.sec.chaton.util.C1341p;
import java.nio.ByteOrder;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBufferOutputStream;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

/* compiled from: EnvelopeStreamEncoder.java */
/* renamed from: com.sec.chaton.c.b.b */
/* loaded from: classes.dex */
public class C0481b extends OneToOneEncoder {

    /* renamed from: a */
    private PowerManager.WakeLock f1549a;

    public C0481b(PowerManager.WakeLock wakeLock) {
        this.f1549a = wakeLock;
    }

    @Override // org.jboss.netty.handler.codec.oneone.OneToOneEncoder
    protected Object encode(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) {
        ChannelBuffer channelBufferBuffer;
        PowerManager.WakeLock wakeLock;
        if (this.f1549a != null) {
            this.f1549a.acquire();
        }
        try {
            try {
                C0488i c0488i = (C0488i) obj;
                byte[] bArrM2487d = c0488i.m2487d();
                int length = bArrM2487d.length;
                if (C1341p.f4578b) {
                    C1341p.m4658b("UID : " + c0488i.m2484a(), getClass().getSimpleName());
                    C1341p.m4658b("reserved : " + String.valueOf(c0488i.m2485b()), getClass().getSimpleName());
                    C1341p.m4658b("type : " + String.valueOf(c0488i.m2486c()), getClass().getSimpleName());
                    C1341p.m4658b("encodedDataLength : " + String.valueOf(bArrM2487d.length), getClass().getSimpleName());
                    C1341p.m4658b("encodedDataRaw : " + C1322br.m4567a(bArrM2487d), getClass().getSimpleName());
                }
                ChannelBufferOutputStream channelBufferOutputStream = new ChannelBufferOutputStream(ChannelBuffers.dynamicBuffer(ByteOrder.BIG_ENDIAN, length + 4 + 36, channelHandlerContext.getChannel().getConfig().getBufferFactory()));
                CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(channelBufferOutputStream);
                byte[] bArr = new byte[36];
                System.arraycopy(c0488i.m2484a().getBytes("UTF-8"), 0, bArr, 0, 36);
                codedOutputStreamNewInstance.writeRawBytes(bArr);
                codedOutputStreamNewInstance.writeRawByte(c0488i.m2485b());
                codedOutputStreamNewInstance.writeRawByte(c0488i.m2486c());
                codedOutputStreamNewInstance.writeRawByte((byte) (length >> 8));
                codedOutputStreamNewInstance.writeRawByte((byte) length);
                codedOutputStreamNewInstance.writeRawBytes(bArrM2487d);
                codedOutputStreamNewInstance.flush();
                channelBufferBuffer = channelBufferOutputStream.buffer();
            } catch (Exception e) {
                C1341p.m4653a(e, getClass().getSimpleName());
                channelBufferBuffer = null;
                if (this.f1549a != null) {
                    wakeLock = this.f1549a;
                }
            }
            if (this.f1549a != null) {
                wakeLock = this.f1549a;
                wakeLock.release();
            }
            return channelBufferBuffer;
        } catch (Throwable th) {
            if (this.f1549a != null) {
                this.f1549a.release();
            }
            throw th;
        }
    }
}
