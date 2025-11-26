package com.vlingo.sdk.internal.http.custom;

import com.vlingo.sdk.internal.http.URL;
import com.vlingo.sdk.internal.logging.Logger;
import java.io.IOException;

/* loaded from: classes.dex */
public class VConnectionFactory {
    private static Logger log = Logger.getLogger(VConnectionFactory.class);

    public static AndroidVStreamConnection createConnection(URL url) throws IOException {
        log.debug("In createConnection host " + url.host);
        AndroidVStreamConnection connection = new AndroidVStreamConnection(url);
        log.debug("Got connection " + connection);
        return connection;
    }

    public static AndroidVStreamConnection createConnection(String url) throws IOException {
        log.debug("In createConnection host " + url);
        AndroidVStreamConnection connection = new AndroidVStreamConnection(url);
        log.debug("Got connection " + connection);
        return connection;
    }
}
