package com.sec.spp.push;

/* loaded from: classes.dex */
public class Config {
    public static final String DEFAULT_DEREGISTRATION_ID = "com.sec.spp.DeRegistrationFail";
    public static final String DEFAULT_REGISTRATION_ID = "com.sec.spp.RegistrationFail";
    public static final String EXTRA_APPID = "appId";
    public static final String EXTRA_ERROR = "Error";
    public static final String EXTRA_ERROR_CODE = "ErrorCode";
    public static final String EXTRA_ERROR_MESSAGE = "ErrorMessage";
    public static final String EXTRA_PUSH_STATUS = "com.sec.spp.Status";
    public static final String EXTRA_REGID = "RegistrationID";
    public static final String EXTRA_REQTYPE = "reqType";
    public static final String EXTRA_USERDATA = "userdata";
    public static final String NOTIFICATION_INTENT_ACK = "ack";
    public static final String NOTIFICATION_INTENT_APPID = "appId";
    public static final String NOTIFICATION_INTENT_APP_DATA = "appData";
    public static final String NOTIFICATION_INTENT_CONNECTION_TERM = "connectionTerm";
    public static final String NOTIFICATION_INTENT_MSG = "msg";
    public static final String NOTIFICATION_INTENT_NOTIID = "notificationId";
    public static final String NOTIFICATION_INTENT_SENDER = "sender";
    public static final String NOTIFICATION_INTENT_SESSION_INFO = "sessionInfo";
    public static final String NOTIFICATION_INTENT_TIMESTAMP = "timeStamp";
    public static final int PUSH_DEREGISTRATION_FAIL = 3;
    public static final int PUSH_DEREGISTRATION_SUCCESS = 2;
    public static final String PUSH_REGISTRATION_CHANGED_ACTION = "com.sec.spp.RegistrationChangedAction";
    public static final int PUSH_REGISTRATION_FAIL = 1;
    public static final int PUSH_REGISTRATION_SUCCESS = 0;
    public static final int PUSH_REQ_TYPE_DEFAULT = 0;
    public static final int PUSH_REQ_TYPE_DEREGISTRATION = 2;
    public static final int PUSH_REQ_TYPE_MAX = 3;
    public static final int PUSH_REQ_TYPE_REGISTRATION = 1;
    public static final String PUSH_SERVICE_REQUEST = "com.sec.spp.action.SPP_REQUEST";
}
