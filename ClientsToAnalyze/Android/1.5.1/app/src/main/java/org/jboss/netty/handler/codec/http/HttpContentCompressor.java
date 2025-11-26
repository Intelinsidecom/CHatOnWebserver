package org.jboss.netty.handler.codec.http;

import org.jboss.netty.handler.codec.compression.ZlibEncoder;
import org.jboss.netty.handler.codec.compression.ZlibWrapper;
import org.jboss.netty.handler.codec.embedder.EncoderEmbedder;

/* loaded from: classes.dex */
public class HttpContentCompressor extends HttpContentEncoder {
    private final int compressionLevel;

    public HttpContentCompressor() {
        this(6);
    }

    public HttpContentCompressor(int i) {
        if (i < 0 || i > 9) {
            throw new IllegalArgumentException("compressionLevel: " + i + " (expected: 0-9)");
        }
        this.compressionLevel = i;
    }

    private ZlibWrapper determineWrapper(String str) {
        if (str.indexOf("gzip") >= 0) {
            return ZlibWrapper.GZIP;
        }
        if (str.indexOf("deflate") >= 0) {
            return ZlibWrapper.ZLIB;
        }
        return null;
    }

    @Override // org.jboss.netty.handler.codec.http.HttpContentEncoder
    protected String getTargetContentEncoding(String str) {
        ZlibWrapper zlibWrapperDetermineWrapper = determineWrapper(str);
        if (zlibWrapperDetermineWrapper == null) {
            return null;
        }
        switch (zlibWrapperDetermineWrapper) {
            case GZIP:
                return "gzip";
            case ZLIB:
                return "deflate";
            default:
                throw new Error();
        }
    }

    @Override // org.jboss.netty.handler.codec.http.HttpContentEncoder
    protected EncoderEmbedder newContentEncoder(String str) {
        ZlibWrapper zlibWrapperDetermineWrapper = determineWrapper(str);
        if (zlibWrapperDetermineWrapper == null) {
            return null;
        }
        return new EncoderEmbedder(new ZlibEncoder(zlibWrapperDetermineWrapper, this.compressionLevel));
    }
}
