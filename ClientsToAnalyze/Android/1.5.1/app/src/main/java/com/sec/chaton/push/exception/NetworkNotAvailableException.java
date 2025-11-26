package com.sec.chaton.push.exception;

/* loaded from: classes.dex */
public class NetworkNotAvailableException extends ConnectionException {
    public NetworkNotAvailableException() {
    }

    public NetworkNotAvailableException(String str) {
        super(str);
    }

    public NetworkNotAvailableException(String str, Throwable th) {
        super(str, th);
    }

    public NetworkNotAvailableException(Throwable th) {
        super(th);
    }
}
