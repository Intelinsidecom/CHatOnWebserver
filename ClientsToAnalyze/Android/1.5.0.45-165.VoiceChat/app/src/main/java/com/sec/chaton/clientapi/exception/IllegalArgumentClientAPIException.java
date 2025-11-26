package com.sec.chaton.clientapi.exception;

/* loaded from: classes.dex */
public class IllegalArgumentClientAPIException extends ClientAPIException {
    private static final long serialVersionUID = -7863075487100621067L;

    public IllegalArgumentClientAPIException() {
    }

    public IllegalArgumentClientAPIException(String detailMessage) {
        super(detailMessage);
    }

    public IllegalArgumentClientAPIException(Throwable throwable) {
        super(throwable);
    }

    public IllegalArgumentClientAPIException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }
}
