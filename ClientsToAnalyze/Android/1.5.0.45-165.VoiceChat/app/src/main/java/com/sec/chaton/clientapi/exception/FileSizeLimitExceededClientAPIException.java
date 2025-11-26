package com.sec.chaton.clientapi.exception;

/* loaded from: classes.dex */
public class FileSizeLimitExceededClientAPIException extends IllegalArgumentClientAPIException {
    private static final long serialVersionUID = 7405190903241383983L;

    public FileSizeLimitExceededClientAPIException() {
    }

    public FileSizeLimitExceededClientAPIException(String detailMessage) {
        super(detailMessage);
    }

    public FileSizeLimitExceededClientAPIException(Throwable throwable) {
        super(throwable);
    }

    public FileSizeLimitExceededClientAPIException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }
}
