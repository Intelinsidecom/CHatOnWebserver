package org.jboss.netty.handler.codec.rtsp;

import org.jboss.netty.handler.codec.http.HttpVersion;

/* loaded from: classes.dex */
public final class RtspVersions {
    public static final HttpVersion RTSP_1_0 = new HttpVersion("RTSP", 1, 0, true);

    private RtspVersions() {
    }

    public static HttpVersion valueOf(String str) {
        if (str == null) {
            throw new NullPointerException("text");
        }
        String upperCase = str.trim().toUpperCase();
        return upperCase.equals("RTSP/1.0") ? RTSP_1_0 : new HttpVersion(upperCase, true);
    }
}
