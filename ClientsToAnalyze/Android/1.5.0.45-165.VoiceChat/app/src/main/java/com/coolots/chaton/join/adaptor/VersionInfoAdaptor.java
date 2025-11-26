package com.coolots.chaton.join.adaptor;

import android.os.Handler;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.P2PMsg;
import com.coolots.p2pmsg.model.VersionInfoRep;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class VersionInfoAdaptor extends HttpAdaptor implements DisposeInterface {
    public VersionInfoAdaptor(MsgBody msgBody, Handler handler) {
        super(MessageInfo.VersionInfoAsk, msgBody, handler, 6000);
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void setServerInfo() {
        super.setServerInfo();
        if (isCipherKey()) {
            this.mUriScheme = 0;
            this.mPath = HttpAdaptor.HTTP_DO_PATH;
        } else {
            this.mUriScheme = 1;
            this.mPath = HttpAdaptor.HTTPS_DO_PATH;
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void setUserInfo() {
        this.mUserID = "Client";
        this.mDeviceID = MainApplication.mConfig.getProfileDeviceID();
        this.mPasswd = MainApplication.mConfig.getProfilePasswd();
        this.mUserNo = MainApplication.mConfig.getProfileUserNo();
    }

    private boolean isCipherKey() {
        String mSessionID = MainApplication.mConfig.getSessionID();
        byte[] mCipherKey = MainApplication.mConfig.getDecodedCipherKey();
        return (mSessionID == null || mSessionID.isEmpty() || mCipherKey == null || mCipherKey.length == 0) ? false : true;
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE VersionInfoAdaptor VersionInfoAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2pMsg) {
        MsgBody msgBody = p2pMsg.getMsgBody();
        if (msgBody instanceof VersionInfoRep) {
            sendEvent(0, 0, msgBody);
        }
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
    }
}
