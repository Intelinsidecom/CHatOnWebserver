package com.sds.coolots.join.adaptor;

import android.os.Handler;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.MsgHeader;
import com.coolots.p2pmsg.model.P2PMsg;
import com.coolots.p2pmsg.model.RegionInfoAsk;
import com.coolots.p2pmsg.model.RegionInfoRep;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;

/* loaded from: classes.dex */
public class RegionInfoAdaptor extends HttpAdaptor {
    public RegionInfoAdaptor(String str, String str2, Handler handler) throws Exception {
        super(MessageInfo.RegionInfoAsk, null, handler, 6000);
        RegionInfoAsk regionInfoAsk = new RegionInfoAsk();
        regionInfoAsk.setIso2NationCode(str.toUpperCase());
        this.mMsgBody = regionInfoAsk;
        if (str2 == null || str2.isEmpty()) {
            return;
        }
        this.mUserID = str2;
        setHeaderInformation();
    }

    public RegionInfoAdaptor(String str, String str2, String str3, Handler handler) throws Exception {
        super(MessageInfo.RegionInfoAsk, null, handler, 6000);
        RegionInfoAsk regionInfoAsk = new RegionInfoAsk();
        regionInfoAsk.setIso2NationCode(str.toUpperCase());
        regionInfoAsk.setSamsungAccountID(str3);
        this.mMsgBody = regionInfoAsk;
        if (str2 == null || str2.isEmpty()) {
            return;
        }
        this.mUserID = str2;
        setHeaderInformation();
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE RegionInfoAdaptor RegionInfoAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2PMsg) {
        MsgBody msgBody = p2PMsg.getMsgBody();
        if (msgBody instanceof RegionInfoRep) {
            logE("LOCAL CENTER SERVER : " + ((RegionInfoRep) msgBody).getDomain() + ", Region:" + ((int) ((RegionInfoRep) msgBody).getRegion()));
            sendEvent(0, 0, (RegionInfoRep) msgBody);
        }
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
            if (this.mUserID == null || this.mUserID.isEmpty()) {
                this.mMsgHeader.setFromID("Client");
            } else {
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
}
