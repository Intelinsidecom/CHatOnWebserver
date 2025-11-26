package com.sec.spp.push;

/* loaded from: classes.dex */
public class Config {
    public static final String ACTION_LOG_SERVICE_NOTIFICATION = "com.sec.spp.action.LOG_SERVICE_NOTIFICATION";
    public static final String ACTION_LOG_SERVICE_REPLY = "com.sec.spp.action.LOG_SERVICE_REPLY";
    public static final String ACTION_LOG_SERVICE_REQUEST = "com.sec.spp.action.LOG_SERVICE_REQUEST";
    public static final String APP_SYNC_ALARM_INTENT_EXTRA = "android.intent.extra.ALARM_TARGET_TIME";
    public static final String CHATON_PACKAGE_NAME = "com.sec.chaton";
    public static final String COLUMN_CURRENT_VERSION = "current_version";
    public static final String COLUMN_LATEST_VERSION = "latest_version";
    public static final String COLUMN_NEED_UPDATE = "need_update";
    public static final String COLUMN_PORT = "port";
    public static final String DEFAULT_DEREGISTRATION_ID = "com.sec.spp.DeRegistrationFail";
    public static final String DEFAULT_REGISTRATION_ID = "com.sec.spp.RegistrationFail";
    public static final String EXTRA_APPID = "appId";
    public static final String EXTRA_APP_PACKAGE_NAME = "com.sec.spp.intent.extra.APP_PACKAGE_NAME";
    public static final String EXTRA_ERROR = "Error";
    public static final String EXTRA_ERROR_CODE = "ErrorCode";
    public static final String EXTRA_ERROR_MESSAGE = "ErrorMessage";
    public static final String EXTRA_LOG_DATA = "com.sec.spp.intent.extra.LOG_DATA";
    public static final String EXTRA_LOG_ID = "com.sec.spp.intent.extra.LOG_ID";
    public static final String EXTRA_LOG_MAX_SIZE = "com.sec.spp.intent.extra.LOG_MAX_SIZE";
    public static final String EXTRA_LOG_PREFIX = "com.sec.spp.intent.extra.LOG_PREFIX";
    public static final String EXTRA_LOG_UNLIMITED_SENDING = "com.sec.spp.intent.extra.LOG_SENDER_UNLIMITED";
    public static final String EXTRA_PUSH_STATUS = "com.sec.spp.Status";
    public static final String EXTRA_REGID = "RegistrationID";
    public static final String EXTRA_REQTYPE = "reqType";
    public static final String EXTRA_RESULT_CODE = "com.sec.spp.intent.extra.RESULT_CODE";
    public static final String EXTRA_USERDATA = "userdata";
    public static final int FLAG_INCLUDE_STOPPED_PACKAGES = 32;
    public static final String KEYVALUE_PACKAGENAME = "packageName=";
    public static final String KEYVALUE_SPLIT = ";";
    public static final int LOG_MAX_ROW_SIZE = 64;
    public static final int LOG_MAX_SIZE_DEFAULT = 1024;
    public static final String NOTIFICATION_ACK_RESULT_ACTION = "com.sec.spp.NotificationAckResultAction";
    public static final String NOTIFICATION_INTENT_ACK = "ack";
    public static final String NOTIFICATION_INTENT_ACK_RESULT = "ackResult";
    public static final String NOTIFICATION_INTENT_APPID = "appId";
    public static final String NOTIFICATION_INTENT_APP_DATA = "appData";
    public static final String NOTIFICATION_INTENT_CONNECTION_TERM = "connectionTerm";
    public static final String NOTIFICATION_INTENT_MSG = "msg";
    public static final String NOTIFICATION_INTENT_NOTIID = "notificationId";
    public static final String NOTIFICATION_INTENT_SENDER = "sender";
    public static final String NOTIFICATION_INTENT_SESSION_INFO = "sessionInfo";
    public static final String NOTIFICATION_INTENT_TIMESTAMP = "timeStamp";
    public static final String PERMISSION_LOG_SERVICE_RECEIVER = "com.sec.spp.permission.LOG_SERVICE_RECEIVER";
    public static final String PERMISSION_PUSH_SERVICE_PROVIDER = "com.sec.spp.permission.PUSH_SERVICE_PROVIDER";
    public static final String PROVIDER_AUTHORITY = "com.sec.spp.provider";
    public static final String PROVIDER_PATH_VERSION_INFO = "version_info";
    public static final String PROVIDER_PATH_WIFI_PORT = "wifi_port";
    public static final int PUSH_DEREGISTRATION_FAIL = 3;
    public static final int PUSH_DEREGISTRATION_SUCCESS = 2;
    public static final String PUSH_DUPLICATION_DEVICEID_ERROR = "com.sec.spp.push.DuplicationDeviceIdError";
    public static final String PUSH_REGISTRATION_CHANGED_ACTION = "com.sec.spp.RegistrationChangedAction";
    public static final int PUSH_REGISTRATION_FAIL = 1;
    public static final int PUSH_REGISTRATION_SUCCESS = 0;
    public static final int PUSH_REQ_TYPE_ACTIVATE = 101;
    public static final int PUSH_REQ_TYPE_DEACTIVATE = 102;
    public static final int PUSH_REQ_TYPE_DEFAULT = 0;
    public static final int PUSH_REQ_TYPE_DEREGISTRATION = 2;
    public static final int PUSH_REQ_TYPE_GET_TERMS = 105;
    public static final int PUSH_REQ_TYPE_MAX = 3;
    public static final int PUSH_REQ_TYPE_REGISTRATION = 1;
    public static final int PUSH_REQ_TYPE_SEND_LOG_DATA = 104;
    public static final int PUSH_REQ_TYPE_TURN_TO_SEND = 103;
    public static final String PUSH_SERVICE_REQUEST = "com.sec.spp.action.SPP_REQUEST";
    public static final String PUSH_SERVICE_STOP_ACTION = "PushServiceStopAction";
    public static final String PUSH_VERSION_CHECK = "com.sec.spp.push.VersionCheck";
    public static final String SERVICE_ABNORMALLY_STOPPED_ACTION = "com.sec.spp.ServiceAbnormallyStoppedAction";
    public static final String SERVICE_DATA_DELETED_ACTION = "com.sec.spp.ServiceDataDeletedAction";
    public static final String SS_ACCOUNT_PACKAGE_NAME = "com.sec.sso";
    public static final String WIFI_PORT_CHANGE_NOTI_ACTION = "com.sec.spp.WifiPortChangeNotiAction";

    public enum SppService {
        SPP_PUSH_SERVICE,
        SPP_LOG_SERVICE,
        SPP_UNKNOWN_SERVICE;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static SppService[] valuesCustom() {
            SppService[] sppServiceArrValuesCustom = values();
            int length = sppServiceArrValuesCustom.length;
            SppService[] sppServiceArr = new SppService[length];
            System.arraycopy(sppServiceArrValuesCustom, 0, sppServiceArr, 0, length);
            return sppServiceArr;
        }
    }

    public static SppService getService(int i) {
        if (i > 0 && i < 101) {
            return SppService.SPP_PUSH_SERVICE;
        }
        if (i >= 101 && i < 3) {
            return SppService.SPP_LOG_SERVICE;
        }
        return SppService.SPP_UNKNOWN_SERVICE;
    }
}
