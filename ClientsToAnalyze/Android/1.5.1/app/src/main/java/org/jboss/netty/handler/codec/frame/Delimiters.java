package org.jboss.netty.handler.codec.frame;

import com.sec.amsoma.AMSLibs;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

/* loaded from: classes.dex */
public class Delimiters {
    private Delimiters() {
    }

    public static ChannelBuffer[] lineDelimiter() {
        return new ChannelBuffer[]{ChannelBuffers.wrappedBuffer(new byte[]{AMSLibs.ENUM_VIP_AMS_DIAGRAM_OBJECT_NUM_FULL, 10}), ChannelBuffers.wrappedBuffer(new byte[]{10})};
    }

    public static ChannelBuffer[] nulDelimiter() {
        return new ChannelBuffer[]{ChannelBuffers.wrappedBuffer(new byte[]{0})};
    }
}
