package com.sec.chaton.clientapi.exception;

/* loaded from: classes.dex */
public class NotAvailableClientAPIException extends ClientAPIException {
    private static final long serialVersionUID = -8681400935810869767L;

    public NotAvailableClientAPIException() {
    }

    public NotAvailableClientAPIException(String detailMessage) {
        super(detailMessage);
    }

    public NotAvailableClientAPIException(Throwable throwable) {
        super(throwable);
    }

    public NotAvailableClientAPIException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }
}
