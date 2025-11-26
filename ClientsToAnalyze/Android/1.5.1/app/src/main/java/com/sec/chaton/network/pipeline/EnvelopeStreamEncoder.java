package com.sec.chaton.network.pipeline;

import android.os.PowerManager;
import com.google.protobuf.CodedOutputStream;
import com.sec.chaton.util.ChatONLogWriter;
import java.nio.ByteOrder;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBufferOutputStream;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

/* loaded from: classes.dex */
public class EnvelopeStreamEncoder extends OneToOneEncoder {

    /* renamed from: a */
    private PowerManager.WakeLock f2553a;

    public EnvelopeStreamEncoder(PowerManager.WakeLock wakeLock) {
        this.f2553a = wakeLock;
    }

    @Override // org.jboss.netty.handler.codec.oneone.OneToOneEncoder
    protected Object encode(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) {
        ChannelBuffer channelBufferBuffer;
        PowerManager.WakeLock wakeLock;
        if (this.f2553a != null) {
            this.f2553a.acquire();
        }
        try {
            try {
                Envelope envelope = (Envelope) obj;
                byte[] bArrM2829d = envelope.m2829d();
                int length = bArrM2829d.length;
                ChannelBufferOutputStream channelBufferOutputStream = new ChannelBufferOutputStream(ChannelBuffers.dynamicBuffer(ByteOrder.BIG_ENDIAN, length + 4 + 36, channelHandlerContext.getChannel().getConfig().getBufferFactory()));
                CodedOutputStream codedOutputStreamM297a = CodedOutputStream.m297a(channelBufferOutputStream);
                byte[] bArr = new byte[36];
                System.arraycopy(envelope.m2826a().getBytes("UTF-8"), 0, bArr, 0, 36);
                codedOutputStreamM297a.m331b(bArr);
                codedOutputStreamM297a.m337f(envelope.m2827b());
                codedOutputStreamM297a.m337f(envelope.m2828c());
                codedOutputStreamM297a.m318a((byte) (length >> 8));
                codedOutputStreamM297a.m318a((byte) length);
                codedOutputStreamM297a.m331b(bArrM2829d);
                codedOutputStreamM297a.m317a();
                channelBufferBuffer = channelBufferOutputStream.buffer();
            } catch (Exception e) {
                ChatONLogWriter.m3501a(e, getClass().getSimpleName());
                channelBufferBuffer = null;
                if (this.f2553a != null) {
                    wakeLock = this.f2553a;
                }
            }
            if (this.f2553a != null) {
                wakeLock = this.f2553a;
                wakeLock.release();
            }
            return channelBufferBuffer;
        } catch (Throwable th) {
            if (this.f2553a != null) {
                this.f2553a.release();
            }
            throw th;
        }
    }
}
