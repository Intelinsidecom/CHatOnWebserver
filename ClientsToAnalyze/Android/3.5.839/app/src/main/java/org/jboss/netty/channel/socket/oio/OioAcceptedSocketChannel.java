package org.jboss.netty.channel.socket.oio;

import java.io.OutputStream;
import java.io.PushbackInputStream;

/* loaded from: classes.dex */
class OioAcceptedSocketChannel extends OioSocketChannel {

    /* renamed from: in */
    private final PushbackInputStream f19096in;
    private final OutputStream out;

    @Override // org.jboss.netty.channel.socket.oio.OioSocketChannel
    PushbackInputStream getInputStream() {
        return this.f19096in;
    }

    @Override // org.jboss.netty.channel.socket.oio.OioSocketChannel
    OutputStream getOutputStream() {
        return this.out;
    }
}
