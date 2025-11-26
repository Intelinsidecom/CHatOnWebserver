package com.sds.coolots.common.httpAdaptor;

import android.os.Handler;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.Error;
import com.coolots.p2pmsg.model.LogReportRep;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.P2PMsg;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.model.EventCode;

/* loaded from: classes.dex */
public class LogReportAdaptor extends HttpAdaptor {
    public static final String RESULT_FAIL = "0";
    public static final String RESULT_SUCCESS = "1";

    public LogReportAdaptor(MsgBody msgBody, Handler handler) {
        super(MessageInfo.LogReportAsk, msgBody, handler, 6000);
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE LogReportAdaptor LogReportAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2PMsg) {
        MsgBody msgBody = p2PMsg.getMsgBody();
        if (!(msgBody instanceof LogReportRep)) {
            if (msgBody instanceof Error) {
                sendEvent(-1, 0, null);
                return;
            }
            return;
        }
        LogReportRep logReportRep = (LogReportRep) msgBody;
        if (logReportRep.getResult().equals("1")) {
            sendEvent(EventCode.EVENT_LOG_REPORT_SUCCESS, 0, null);
        } else if (logReportRep.getResult().equals("0")) {
            sendEvent(EventCode.EVENT_LOG_REPORT_FAIL, 0, null);
        } else {
            sendEvent(-1, 0, null);
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processTimeOutError() {
        logE("ADAPTOR_TRACE LogReportAdaptor's processTimeOutError");
        super.processTimeOutError();
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void setServerInfo() {
        super.setServerInfo();
        this.mUriScheme = 1;
        this.mPath = this.mUriScheme == 1 ? HttpAdaptor.HTTPS_DO_PATH : HttpAdaptor.HTTP_DO_PATH;
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void setUserInfo() {
        if (MainApplication.mConfig.getProfileUserID() != null) {
            this.mUserID = MainApplication.mConfig.getProfileUserID();
        }
    }
}
