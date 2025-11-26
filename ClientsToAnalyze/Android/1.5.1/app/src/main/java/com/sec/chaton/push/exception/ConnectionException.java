package com.sec.chaton.push.exception;

/* loaded from: classes.dex */
public class ConnectionException extends PushClientException {
    public ConnectionException() {
    }

    public ConnectionException(String str) {
        super(str);
    }

    public ConnectionException(String str, Throwable th) {
        super(str, th);
    }

    public ConnectionException(Throwable th) {
        super(th);
    }
}
