package org.jboss.netty.handler.codec.http;

import android.hardware.motion.MREvent;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import org.jboss.netty.handler.codec.http.HttpHeaders;
import org.jboss.netty.util.CharsetUtil;

/* loaded from: classes.dex */
class HttpCodecUtil {
    static final byte COLON = 58;
    static final byte COMMA = 44;

    /* renamed from: CR */
    static final byte f5801CR = 13;
    static final byte[] CRLF = {13, 10};
    static final Charset DEFAULT_CHARSET = CharsetUtil.UTF_8;
    static final byte DOUBLE_QUOTE = 34;
    static final byte EQUALS = 61;

    /* renamed from: HT */
    static final byte f5802HT = 9;

    /* renamed from: LF */
    static final byte f5803LF = 10;
    static final byte SEMICOLON = 59;

    /* renamed from: SP */
    static final byte f5804SP = 32;

    private HttpCodecUtil() {
    }

    static void validateHeaderName(String str) {
        if (str == null) {
            throw new NullPointerException("name");
        }
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt > 127) {
                throw new IllegalArgumentException("name contains non-ascii character: " + str);
            }
            switch (cCharAt) {
                case '\t':
                case '\n':
                case 11:
                case MREvent.TILT_PORTRAIT_BACK /* 12 */:
                case MREvent.TILT_PORTRAIT_FRONT_BACK_STOP /* 13 */:
                case ' ':
                case MREvent.BT_SHARING_SEND_STOP /* 44 */:
                case MREvent.SNAP2_Z_NEGATIVE /* 58 */:
                case MREvent.SNAP_LEFT /* 59 */:
                case MREvent.PANNING_GYRO /* 61 */:
                    throw new IllegalArgumentException("name contains one of the following prohibited characters: =,;: \\t\\r\\n\\v\\f: " + str);
                default:
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void validateHeaderValue(java.lang.String r5) {
        /*
            r3 = 2
            r1 = 0
            if (r5 != 0) goto Lc
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "value"
            r0.<init>(r1)
            throw r0
        Lc:
            r0 = r1
            r2 = r1
        Le:
            int r4 = r5.length()
            if (r0 >= r4) goto L97
            char r4 = r5.charAt(r0)
            switch(r4) {
                case 11: goto L21;
                case 12: goto L3a;
                default: goto L1b;
            }
        L1b:
            switch(r2) {
                case 0: goto L53;
                case 1: goto L5b;
                case 2: goto L79;
                default: goto L1e;
            }
        L1e:
            int r0 = r0 + 1
            goto Le
        L21:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "value contains a prohibited character '\\v': "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r5)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L3a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "value contains a prohibited character '\\f': "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r5)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L53:
            switch(r4) {
                case 10: goto L57;
                case 11: goto L56;
                case 12: goto L56;
                case 13: goto L59;
                default: goto L56;
            }
        L56:
            goto L1e
        L57:
            r2 = r3
            goto L1e
        L59:
            r2 = 1
            goto L1e
        L5b:
            switch(r4) {
                case 10: goto L77;
                default: goto L5e;
            }
        L5e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Only '\\n' is allowed after '\\r': "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r5)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L77:
            r2 = r3
            goto L1e
        L79:
            switch(r4) {
                case 9: goto L95;
                case 32: goto L95;
                default: goto L7c;
            }
        L7c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Only ' ' and '\\t' are allowed after '\\n': "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r5)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L95:
            r2 = r1
            goto L1e
        L97:
            if (r2 == 0) goto Lb2
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "value must not end with '\\r' or '\\n':"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r5)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        Lb2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.handler.codec.http.HttpCodecUtil.validateHeaderValue(java.lang.String):void");
    }

    static boolean isTransferEncodingChunked(HttpMessage httpMessage) {
        List headers = httpMessage.getHeaders(HttpHeaders.Names.TRANSFER_ENCODING);
        if (headers.isEmpty()) {
            return false;
        }
        Iterator it = headers.iterator();
        while (it.hasNext()) {
            if (((String) it.next()).equalsIgnoreCase(HttpHeaders.Values.CHUNKED)) {
                return true;
            }
        }
        return false;
    }
}
