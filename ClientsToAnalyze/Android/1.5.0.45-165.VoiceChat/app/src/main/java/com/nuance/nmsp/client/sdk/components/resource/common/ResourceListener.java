package com.nuance.nmsp.client.sdk.components.resource.common;

import java.util.Vector;

/* loaded from: classes.dex */
public interface ResourceListener {
    public static final short COMPLETION_CAUSE_3RD_PARTY_APP_ERROR = 608;
    public static final short COMPLETION_CAUSE_EMPTY = Short.MAX_VALUE;
    public static final short COMPLETION_CAUSE_INVALID_REQUEST = 600;
    public static final short COMPLETION_CAUSE_RESOURCE_UNAVAILABLE = 14;
    public static final short EVENT_CODE_APP_SERVER_SESSION_TERMINATED_ERROR = 8;
    public static final short EVENT_CODE_APP_SERVER_SESSION_TERMINATED_NORMALLY = 7;
    public static final short EVENT_CODE_CLIENT_DISCONNECTED_NORMALLY = 0;
    public static final short EVENT_CODE_CLIENT_IDLE_TIMEOUT = 3;
    public static final short EVENT_CODE_CLIENT_PING_TIMEOUT = 2;
    public static final short EVENT_CODE_CLIENT_SOCKET_SHUTDOWN_UNEXPECTEDLY = 1;
    public static final short EVENT_CODE_GW_TERMINATED_SESSION_ERROR = 6;
    public static final short EVENT_CODE_NSS_TERMINATED_SESSION_ERROR = 5;
    public static final short EVENT_CODE_NSS_TERMINATED_SESSION_TIMEOUT = 4;
    public static final short STATUS_CODE_ILLEGAL_VALUE_FOR_PARAMETER = 404;
    public static final short STATUS_CODE_MANDATORY_PARAMETER_MISSING = 406;
    public static final short STATUS_CODE_MESSAGE_TOO_LARGE = 504;
    public static final short STATUS_CODE_METHOD_NOT_ALLOWED = 401;
    public static final short STATUS_CODE_METHOD_NOT_VALID_IN_THIS_STATE = 402;
    public static final short STATUS_CODE_METHOD_OR_OPERATION_FAILED = 407;
    public static final short STATUS_CODE_NOT_FOUND = 405;
    public static final short STATUS_CODE_OUT_OF_ORDER_NUMBER_ID = 410;
    public static final short STATUS_CODE_PARTIAL_SUCCESS = 201;
    public static final short STATUS_CODE_PROTOCOL_VERSION_NOT_SUPPORTED = 502;
    public static final short STATUS_CODE_PROXY_TIMEOUT = 503;
    public static final short STATUS_CODE_SERVER_INTERNAL_ERROR = 501;
    public static final short STATUS_CODE_SUCCESS = 200;
    public static final short STATUS_CODE_UNRECOGNIZED_MESSAGE_ENTITY = 408;
    public static final short STATUS_CODE_UNSUPPORTED_PARAMETER = 403;
    public static final short STATUS_CODE_UNSUPPORTED_PARAMETER_VALUE = 409;

    void getParameterCompleted(short s, Vector vector, long j);

    void getParameterFailed(short s, short s2, long j);

    void resourceUnloaded(short s);

    void setParameterCompleted(short s, Vector vector, long j);

    void setParameterFailed(short s, short s2, long j);
}
