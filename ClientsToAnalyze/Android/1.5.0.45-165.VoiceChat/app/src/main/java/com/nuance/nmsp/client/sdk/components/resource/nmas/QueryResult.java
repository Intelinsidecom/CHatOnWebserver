package com.nuance.nmsp.client.sdk.components.resource.nmas;

/* loaded from: classes.dex */
public interface QueryResult extends Dictionary {
    byte[] getRawInput();

    String getResultType();

    boolean isFinalResponse();
}
