package com.nuance.nmsp.client.sdk.components.resource.nmas;

/* loaded from: classes.dex */
public interface PDXCommandListener {
    public static final short COMMAND_ENDED = 4;
    public static final short COMMAND_IDLE_FOR_TOO_LONG = 5;
    public static final short REMOTE_DISCONNECTION = 3;
    public static final short TIMED_OUT_WAITING_FOR_RESULT = 1;

    void PDXCommandEvent(short s);

    void PDXQueryErrorReturned(QueryError queryError);

    void PDXQueryResultReturned(QueryResult queryResult);

    void PDXQueryRetryReturned(QueryRetry queryRetry);
}
