package org.jboss.netty.util;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.IdentityHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class CharsetUtil {
    public static final Charset UTF_16 = Charset.forName("UTF-16");
    public static final Charset UTF_16BE = Charset.forName("UTF-16BE");
    public static final Charset UTF_16LE = Charset.forName("UTF-16LE");
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Charset US_ASCII = Charset.forName("US-ASCII");
    private static final ThreadLocal encoders = new ThreadLocal() { // from class: org.jboss.netty.util.CharsetUtil.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Map initialValue() {
            return new IdentityHashMap();
        }
    };
    private static final ThreadLocal decoders = new ThreadLocal() { // from class: org.jboss.netty.util.CharsetUtil.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Map initialValue() {
            return new IdentityHashMap();
        }
    };

    private CharsetUtil() {
    }

    public static CharsetDecoder getDecoder(Charset charset) {
        if (charset == null) {
            throw new NullPointerException("charset");
        }
        Map map = (Map) decoders.get();
        CharsetDecoder charsetDecoder = (CharsetDecoder) map.get(charset);
        if (charsetDecoder != null) {
            charsetDecoder.reset();
            charsetDecoder.onMalformedInput(CodingErrorAction.REPLACE);
            charsetDecoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
            return charsetDecoder;
        }
        CharsetDecoder charsetDecoderNewDecoder = charset.newDecoder();
        charsetDecoderNewDecoder.onMalformedInput(CodingErrorAction.REPLACE);
        charsetDecoderNewDecoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
        map.put(charset, charsetDecoderNewDecoder);
        return charsetDecoderNewDecoder;
    }

    public static CharsetEncoder getEncoder(Charset charset) {
        if (charset == null) {
            throw new NullPointerException("charset");
        }
        Map map = (Map) encoders.get();
        CharsetEncoder charsetEncoder = (CharsetEncoder) map.get(charset);
        if (charsetEncoder != null) {
            charsetEncoder.reset();
            charsetEncoder.onMalformedInput(CodingErrorAction.REPLACE);
            charsetEncoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
            return charsetEncoder;
        }
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        charsetEncoderNewEncoder.onMalformedInput(CodingErrorAction.REPLACE);
        charsetEncoderNewEncoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
        map.put(charset, charsetEncoderNewEncoder);
        return charsetEncoderNewEncoder;
    }
}
