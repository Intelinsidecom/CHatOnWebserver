package com.sec.chaton.push.p041b.p043b;

import android.os.PowerManager;
import com.google.protobuf.MessageLite;
import com.sec.chaton.push.util.C1139g;
import com.sec.p004a.p005a.p006a.C0072ap;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

/* compiled from: MessageEncoder.java */
/* renamed from: com.sec.chaton.push.b.b.h */
/* loaded from: classes.dex */
public class C1095h extends OneToOneEncoder {

    /* renamed from: a */
    private static final String f4029a = C1095h.class.getSimpleName();

    /* renamed from: b */
    private PowerManager.WakeLock f4030b;

    public C1095h(PowerManager.WakeLock wakeLock) {
        this.f4030b = wakeLock;
    }

    @Override // org.jboss.netty.handler.codec.oneone.OneToOneEncoder
    protected Object encode(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) {
        C1139g.m4308a(f4029a, "MessageEncoder.encode()");
        if (this.f4030b != null) {
            this.f4030b.acquire();
        }
        try {
            byte[] byteArray = ((MessageLite) obj).toByteArray();
            ChannelBuffer channelBufferBuffer = ChannelBuffers.buffer(byteArray.length + 4);
            channelBufferBuffer.writeByte(0);
            channelBufferBuffer.writeByte(C0072ap.m282a(obj));
            channelBufferBuffer.writeShort(byteArray.length);
            channelBufferBuffer.writeBytes(byteArray);
            return channelBufferBuffer;
        } finally {
            if (this.f4030b != null) {
                this.f4030b.release();
            }
        }
    }
}
