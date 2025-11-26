package com.google.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public class UninitializedMessageException extends RuntimeException {

    /* renamed from: a */
    private final List f241a;

    public UninitializedMessageException(MessageLite messageLite) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.f241a = null;
    }

    /* renamed from: a */
    public InvalidProtocolBufferException m350a() {
        return new InvalidProtocolBufferException(getMessage());
    }
}
