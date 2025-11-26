package com.vlingo.sdk.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.vlingo.sdk.internal.deviceinfo.PhoneInfo;
import com.vlingo.sdk.internal.http.HttpCallback;
import com.vlingo.sdk.internal.http.HttpRequest;
import com.vlingo.sdk.internal.http.HttpResponse;
import com.vlingo.sdk.internal.http.URL;
import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.util.StringUtils;
import com.vlingo.sdk.internal.vlservice.VLHttpServiceRequest;
import com.vlingo.sdk.internal.vlservice.response.Action;
import com.vlingo.sdk.internal.vlservice.response.ActionList;
import com.vlingo.sdk.internal.vlservice.response.VLServiceResponse;
import com.vlingo.sdk.recognition.VLAction;
import com.vlingo.sdk.services.VLServices;
import com.vlingo.sdk.services.VLServicesErrors;
import com.vlingo.sdk.services.VLServicesListener;
import com.vlingo.sdk.services.userlogging.VLUserLoggerLogRecord;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class VLServicesImpl extends VLComponentImpl implements VLServices, HttpCallback {
    private static final String HELLO_REQUEST = "VVHello";
    private static final int TYPE_HELLO = 2;
    private static final int TYPE_UAL = 1;
    private static final String UAL_REQUEST = "ActivityLog";
    private final Logger log;
    private VLServicesListener mHelloListener;
    private NotificationHandler mNotificationHandler;
    private VLServicesListener mUserActivityListener;

    @Override // com.vlingo.sdk.internal.VLComponentImpl, com.vlingo.sdk.VLComponent
    public /* bridge */ /* synthetic */ void destroy() {
        super.destroy();
    }

    @Override // com.vlingo.sdk.internal.VLComponentImpl, com.vlingo.sdk.VLComponent
    public /* bridge */ /* synthetic */ boolean isValid() {
        return super.isValid();
    }

    private class NotificationHandler extends Handler {
        static final int HELLO_ERROR = 2;
        static final int HELLO_SUCCESS = 1;
        static final int UAL_ERROR = 4;
        static final int UAL_SUCCESS = 3;

        NotificationHandler() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (msg.what == 3 || msg.what == 4) {
                if (VLServicesImpl.this.mUserActivityListener != null) {
                    VLServicesListener l = VLServicesImpl.this.mUserActivityListener;
                    VLServicesImpl.this.mUserActivityListener = null;
                    if (msg.what == 3) {
                        l.onSuccess(null);
                        return;
                    }
                    VLServicesErrors errorCode = (VLServicesErrors) ((Object[]) msg.obj)[0];
                    String errorMsg = (String) ((Object[]) msg.obj)[1];
                    l.onError(errorCode, errorMsg);
                    return;
                }
                return;
            }
            if ((msg.what == 1 || msg.what == 2) && VLServicesImpl.this.mHelloListener != null) {
                VLServicesListener l2 = VLServicesImpl.this.mHelloListener;
                VLServicesImpl.this.mHelloListener = null;
                if (msg.what == 1) {
                    List<VLAction> actionList = (List) msg.obj;
                    l2.onSuccess(actionList);
                } else {
                    VLServicesErrors errorCode2 = (VLServicesErrors) ((Object[]) msg.obj)[0];
                    String errorMsg2 = (String) ((Object[]) msg.obj)[1];
                    l2.onError(errorCode2, errorMsg2);
                }
            }
        }

        synchronized void notifySuccess(int type, List<VLAction> actionList) {
            if (type == 2) {
                VLServicesImpl.this.mNotificationHandler.obtainMessage(1, actionList).sendToTarget();
            } else if (type == 1) {
                VLServicesImpl.this.mNotificationHandler.obtainMessage(3).sendToTarget();
            }
        }

        synchronized void notifyError(int type, VLServicesErrors error, String message) {
            if (type == 2) {
                VLServicesImpl.this.mNotificationHandler.obtainMessage(2, new Object[]{error, message}).sendToTarget();
            } else if (type == 1) {
                VLServicesImpl.this.mNotificationHandler.obtainMessage(4, new Object[]{error, message}).sendToTarget();
            }
        }
    }

    public VLServicesImpl(VLComponentManager manager, Handler handler) {
        super(manager, handler);
        this.log = Logger.getLogger(VLServicesImpl.class);
        this.log.debug("VLServicesImpl()");
        this.mNotificationHandler = new NotificationHandler();
    }

    @Override // com.vlingo.sdk.internal.VLComponentImpl
    void onDestroy() {
        this.log.debug("onDestroy()");
        this.mUserActivityListener = null;
        this.mHelloListener = null;
    }

    @Override // com.vlingo.sdk.services.VLServices
    public void sendHello(String language, VLServicesListener listener) {
        this.log.debug("sendHello()");
        validateInstance();
        if (StringUtils.isNullOrWhiteSpace(language)) {
            throw new IllegalArgumentException("language cannot be null or empty");
        }
        if (listener == null) {
            throw new IllegalArgumentException("listener must be specifed");
        }
        if (this.mHelloListener != null) {
            throw new IllegalStateException("Hello request already in progress");
        }
        this.mHelloListener = listener;
        this.log.debug("sending hello request");
        String body = "<Hello PhoneHash=\"" + PhoneInfo.getInstance().getPhoneNumberHash() + "\"/>";
        URL url = AndroidServerDetails.getHelloURL();
        VLHttpServiceRequest helloRequest = VLHttpServiceRequest.createVLRequest(HELLO_REQUEST, this, url, body, language);
        helloRequest.schedule(50L, false, false);
    }

    @Override // com.vlingo.sdk.services.VLServices
    public void sendActivityLog(String language, VLUserLoggerLogRecord userLog, VLServicesListener listener) {
        this.log.debug("sendActivityLog()");
        validateInstance();
        if (StringUtils.isNullOrWhiteSpace(language)) {
            throw new IllegalArgumentException("language cannot be null or empty");
        }
        if (userLog == null) {
            throw new IllegalArgumentException("userLog cannot be null or empty");
        }
        if (listener == null) {
            throw new IllegalArgumentException("listener must be specifed");
        }
        if (this.mUserActivityListener != null) {
            throw new IllegalStateException("UserActivity request already in progress");
        }
        this.mUserActivityListener = listener;
        this.log.debug("transmitting user activity data");
        URL url = AndroidServerDetails.getUserLoggingURL();
        VLHttpServiceRequest scheduledRequest = VLHttpServiceRequest.createVLRequest(UAL_REQUEST, this, url, userLog.getXML(), language);
        scheduledRequest.setGzipPostData(true);
        scheduledRequest.schedule(50L, false, false);
    }

    @Override // com.vlingo.sdk.internal.http.HttpCallback
    public void onWillExecuteRequest(HttpRequest request) {
    }

    @Override // com.vlingo.sdk.internal.http.HttpCallback
    public void onResponse(HttpRequest request, HttpResponse response) {
        if (response.responseCode == 200) {
            String data = response.getDataAsString();
            this.log.debug("server response: " + response.responseCode + " - " + data);
            if (UAL_REQUEST.equals(request.getTaskName())) {
                this.log.debug("recv user log response");
                this.mNotificationHandler.notifySuccess(getType(request.getTaskName()), null);
                return;
            }
            if (HELLO_REQUEST.equals(request.getTaskName())) {
                this.log.debug("recv hello response");
                VLServiceResponse vlResponse = VLServiceResponse.createFromXml(response.getDataAsString());
                if (!vlResponse.isError()) {
                    ArrayList<VLAction> vlActionList = null;
                    if (vlResponse.hasActions()) {
                        ActionList actionList = vlResponse.getActionList();
                        int listSize = actionList.size();
                        vlActionList = new ArrayList<>(listSize);
                        for (int i = 0; i < listSize; i++) {
                            Action action = actionList.elementAt(i);
                            vlActionList.add(new VLActionImpl(action));
                        }
                    }
                    this.mNotificationHandler.notifySuccess(getType(request.getTaskName()), vlActionList);
                    return;
                }
            }
        }
        this.log.debug("Bad server response");
        this.mNotificationHandler.notifyError(getType(request.getTaskName()), VLServicesErrors.ERROR_SERVER, response.getDataAsString());
    }

    @Override // com.vlingo.sdk.internal.http.HttpCallback
    public boolean onTimeout(HttpRequest request) {
        this.mNotificationHandler.notifyError(getType(request.getTaskName()), VLServicesErrors.ERROR_NETWORK_TIMEOUT, Strings.client_core_NETWORK_TIMEOUT);
        return true;
    }

    @Override // com.vlingo.sdk.internal.http.HttpCallback
    public void onFailure(HttpRequest request) {
        this.mNotificationHandler.notifyError(getType(request.getTaskName()), VLServicesErrors.ERROR_NETWORK, Strings.client_core_network_error);
    }

    @Override // com.vlingo.sdk.internal.http.HttpCallback
    public void onCancelled(HttpRequest request) {
    }

    private int getType(String requestName) {
        if (UAL_REQUEST.equals(requestName)) {
            return 1;
        }
        if (HELLO_REQUEST.equals(requestName)) {
            return 2;
        }
        return -1;
    }
}
