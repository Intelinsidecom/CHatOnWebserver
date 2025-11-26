package com.sds.coolots.call.p013a;

import android.os.Handler;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.ConferenceInfoAsk;
import com.coolots.p2pmsg.model.ConferenceInfoRep;
import com.coolots.p2pmsg.model.Error;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.P2PMsg;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.C1192G;
import com.sds.coolots.call.model.C1224z;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.model.ErrorCode;
import com.sds.coolots.common.model.EventCode;
import com.sds.coolots.common.util.ModelInfoUtil;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.sds.coolots.call.a.e */
/* loaded from: classes.dex */
public class C1139e extends HttpAdaptor {

    /* renamed from: a */
    private final boolean f2351a;

    public C1139e(String str, boolean z, Handler handler, boolean z2) {
        super(MessageInfo.ConferenceInfoAsk, null, handler, 16000);
        ConferenceInfoAsk conferenceInfoAsk = new ConferenceInfoAsk();
        conferenceInfoAsk.setConferenceNo(str);
        if (z2) {
            conferenceInfoAsk.setAppId(MainApplication.mPhoneManager.getApplicationID());
            conferenceInfoAsk.setAppVersion(ModelInfoUtil.getAppVersion(MainApplication.mContext));
        }
        this.mMsgBody = conferenceInfoAsk;
        this.f2351a = z;
    }

    /* renamed from: a */
    private void m2133a(ConferenceInfoRep conferenceInfoRep) {
        Date startTime;
        boolean z;
        String appVersion = ModelInfoUtil.getAppVersion(MainApplication.mContext);
        String latestVersion = conferenceInfoRep.getLatestVersion();
        String result = conferenceInfoRep.getResult();
        logI("current version: " + appVersion + "last version: " + latestVersion + ", type: " + result);
        if (latestVersion != null && !latestVersion.isEmpty() && result != null && !result.isEmpty() && appVersion != null && !appVersion.isEmpty() && !appVersion.equals(latestVersion) && result.equals("3")) {
            MainApplication.mApkUpdateInterface.setDownLoadURL(MainApplication.mApkUpdateInterface.change2StringArrayServer(conferenceInfoRep.getDownloadUrlList()));
            sendEvent(ErrorCode.ERR_NEED_TO_CRITICAL_UPDATE, 0, null);
            return;
        }
        List<SimpleUserInfo> simpleUserInfoList = conferenceInfoRep.getSimpleUserInfoList();
        C1224z c1224z = new C1224z();
        logI("111 memberList: " + simpleUserInfoList);
        if (simpleUserInfoList != null) {
            Iterator<SimpleUserInfo> it = simpleUserInfoList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    startTime = null;
                    z = false;
                    break;
                }
                SimpleUserInfo next = it.next();
                logI("A member: " + next);
                if (next.getP2PUserInfo() == null) {
                    logI("A member p2pInfo is null!!");
                }
                if (MainApplication.mConfig.getProfileUserID().equals(next.getUserID())) {
                    if (this.f2351a && !"0".equals(next.getStatus()) && !SimpleUserInfo.STATE_MOVETO_CONFERENCE.equals(next.getStatus())) {
                        sendEvent(0, EventCode.EVENT_CONF_REMOVED_MEMBER, null);
                        return;
                    }
                    startTime = next.getStartTime();
                    logI("B myStartTime: " + startTime);
                    z = next.getP2PUserInfo() != null;
                    c1224z.m2750a(next.getInviteUserID());
                    simpleUserInfoList.remove(next);
                }
            }
            conferenceInfoRep.setSimpleUserInfoList(simpleUserInfoList);
            logD("<<YHT2>> UPDATE USER INFO!!---------------------------------my start time:" + startTime + " my p2p info: " + z);
            for (SimpleUserInfo simpleUserInfo : simpleUserInfoList) {
                logD("<<YHT2>> ID:" + simpleUserInfo.getUserID() + ", STATUS:" + simpleUserInfo.getStatus() + ", NAME:" + simpleUserInfo.getUserName() + ", isHold:" + simpleUserInfo.getHoldYn() + ", sipID:" + simpleUserInfo.getPhoneNo());
            }
            logD("<<YHT2>> UPDATE USER INFO!!---------------------------------");
        } else {
            startTime = null;
            z = false;
        }
        if (z) {
            C1192G c1192g = new C1192G();
            c1192g.f2622b = z;
            c1192g.f2621a = startTime;
            c1224z.m2749a(c1192g);
        }
        c1224z.m2748a(conferenceInfoRep);
        sendEvent(0, EventCode.EVENT_CONF_UPDATE_MEMBER, c1224z);
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE ConferenceInfoAdaptor ConferenceInfoAsk");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000a. Please report as an issue. */
    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processErrorMessage(P2PMsg p2PMsg) {
        switch (((Error) p2PMsg.getMsgBody()).getErrorCode()) {
        }
        super.processErrorMessage(p2PMsg);
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2PMsg) {
        MsgBody msgBody = p2PMsg.getMsgBody();
        if (msgBody instanceof ConferenceInfoRep) {
            m2133a((ConferenceInfoRep) msgBody);
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processTimeOutError() {
        logE("ADAPTOR_TRACE ConferenceInfoAdaptor's processTimeOutError");
        super.processTimeOutError();
    }
}
