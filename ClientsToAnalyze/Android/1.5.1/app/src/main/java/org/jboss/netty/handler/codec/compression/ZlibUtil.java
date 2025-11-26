package org.jboss.netty.handler.codec.compression;

import org.jboss.netty.util.internal.jzlib.JZlib;
import org.jboss.netty.util.internal.jzlib.ZStream;

/* loaded from: classes.dex */
final class ZlibUtil {
    private ZlibUtil() {
    }

    static Enum convertWrapperType(ZlibWrapper zlibWrapper) {
        switch (zlibWrapper) {
            case NONE:
                return JZlib.W_NONE;
            case ZLIB:
                return JZlib.W_ZLIB;
            case GZIP:
                return JZlib.W_GZIP;
            default:
                throw new Error();
        }
    }

    static CompressionException exception(ZStream zStream, String str, int i) {
        return new CompressionException(str + " (" + i + ")" + (zStream.msg != null ? ": " + zStream.msg : ""));
    }

    static void fail(ZStream zStream, String str, int i) {
        throw exception(zStream, str, i);
    }
}
