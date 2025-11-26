package com.sec.chaton.clientapi.exception;

/* loaded from: classes.dex */
public class ClientAPIException extends Exception {
    private static final long serialVersionUID = -8034902676692708446L;

    public ClientAPIException() {
    }

    public ClientAPIException(String detailMessage) {
        super(detailMessage);
    }

    public ClientAPIException(Throwable throwable) {
        super(throwable);
    }

    public ClientAPIException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }
}
