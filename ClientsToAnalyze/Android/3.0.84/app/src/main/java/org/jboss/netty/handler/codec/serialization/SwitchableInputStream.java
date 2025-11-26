package org.jboss.netty.handler.codec.serialization;

import java.io.FilterInputStream;
import java.io.InputStream;

/* loaded from: classes.dex */
final class SwitchableInputStream extends FilterInputStream {
    SwitchableInputStream() {
        super(null);
    }

    void switchStream(InputStream inputStream) {
        this.in = inputStream;
    }
}
