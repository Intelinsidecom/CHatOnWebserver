package com.sec.chaton.push.network.pipeline;

import android.os.PowerManager;
import com.google.protobuf.MessageLite;
import com.sec.chaton.push.util.PushLog;
import com.sec.pns.msg.frontend.MsgFrontendCommon;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

/* loaded from: classes.dex */
public class MessageEncoder extends OneToOneEncoder {

    /* renamed from: a */
    private static final String f2756a = MessageEncoder.class.getSimpleName();

    /* renamed from: b */
    private PowerManager.WakeLock f2757b;

    public MessageEncoder(PowerManager.WakeLock wakeLock) {
        this.f2757b = wakeLock;
    }

    @Override // org.jboss.netty.handler.codec.oneone.OneToOneEncoder
    protected Object encode(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) {
        PushLog.m3025a(f2756a, "MessageEncoder.encode()");
        if (this.f2757b != null) {
            this.f2757b.acquire();
        }
        try {
            byte[] byteArray = ((MessageLite) obj).toByteArray();
            ChannelBuffer channelBufferBuffer = ChannelBuffers.buffer(byteArray.length + 4);
            channelBufferBuffer.writeByte(0);
            channelBufferBuffer.writeByte(MsgFrontendCommon.getMessageType(obj));
            channelBufferBuffer.writeShort(byteArray.length);
            channelBufferBuffer.writeBytes(byteArray);
            return channelBufferBuffer;
        } finally {
            if (this.f2757b != null) {
                this.f2757b.release();
            }
        }
    }
}
