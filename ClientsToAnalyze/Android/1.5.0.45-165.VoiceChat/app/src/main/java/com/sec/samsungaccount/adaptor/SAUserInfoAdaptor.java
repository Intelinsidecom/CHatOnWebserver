package com.sec.samsungaccount.adaptor;

import android.os.Handler;
import com.coolots.chaton.common.view.ConfigActivity;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.MsgHeader;
import com.coolots.p2pmsg.model.P2PMsg;
import com.coolots.p2pmsg.model.SAUserInfoAsk;
import com.coolots.p2pmsg.model.SAUserInfoRep;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.httpAdaptor.HttpAdaptorTimeOutValue;

/* loaded from: classes.dex */
public class SAUserInfoAdaptor extends HttpAdaptor {
    public SAUserInfoAdaptor(String accountID, String accessToken, Handler handler) throws Exception {
        super(MessageInfo.SAUserInfoAsk, null, handler, HttpAdaptorTimeOutValue.HTTP_CONNECTION_TIMEOUT_SAMSUNGACCOUNT);
        SAUserInfoAsk msg = new SAUserInfoAsk();
        msg.setSamsungAccountID(accountID);
        msg.setAppID(ConfigActivity.getSamsungAccountClient_id());
        msg.setAccessToken(accessToken);
        this.mMsgBody = msg;
        this.mUserID = accountID;
        setHeaderInformation();
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void setHeaderInformation() throws Exception {
        try {
            if (this.mDispathInfo == null) {
                throw new Exception(String.valueOf(getName()) + " mDispathInfo is null!!");
            }
            this.mMsgHeader = new MsgHeader();
            this.mMsgHeader.setVersion("0.90");
            this.mMsgHeader.setSvcCode(this.mDispathInfo.getServiceCode());
            this.mMsgHeader.setMsgCode(this.mDispathInfo.getMessageCode());
            if (this.mUserID != null && !this.mUserID.isEmpty()) {
                this.mMsgHeader.setFromID(this.mUserID);
            }
            this.mMsgHeader.setToID("SVR");
            this.mMsgHeader.setFromDeviceID(this.mDeviceID);
            this.mMsgHeader.setPasswd(this.mPasswd);
        } catch (Exception e) {
            logE(e.getMessage());
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void setServerInfo() {
        this.mUriScheme = 1;
        this.mHost = MainApplication.mConfig.getMasterCenterDomain();
        this.mPath = this.mUriScheme == 1 ? HttpAdaptor.HTTPS_DO_PATH : HttpAdaptor.HTTP_DO_PATH;
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2pMsg) {
        if (p2pMsg.getMsgBody() instanceof SAUserInfoRep) {
            sendEvent(0, 0, (SAUserInfoRep) p2pMsg.getMsgBody());
        } else {
            sendEvent(-1, 0, null);
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE SAUserInfoAdaptor SAUserInfoAsk");
    }
}
