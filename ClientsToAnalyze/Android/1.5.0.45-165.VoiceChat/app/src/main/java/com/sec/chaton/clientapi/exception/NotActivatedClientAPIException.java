package com.sec.chaton.clientapi.exception;

/* loaded from: classes.dex */
public class NotActivatedClientAPIException extends ClientAPIException {
    private static final long serialVersionUID = 6761129676067614963L;

    public NotActivatedClientAPIException() {
    }

    public NotActivatedClientAPIException(String detailMessage) {
        super(detailMessage);
    }

    public NotActivatedClientAPIException(Throwable throwable) {
        super(throwable);
    }

    public NotActivatedClientAPIException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }
}
