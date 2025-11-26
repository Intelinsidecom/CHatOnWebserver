package com.sds.coolots.call.p013a;

import android.os.Handler;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.Error;
import com.coolots.p2pmsg.model.MakeConferenceAsk;
import com.coolots.p2pmsg.model.MakeConferenceRep;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.P2PMsg;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.coolots.p2pmsg.parser.ProtoBufHandler;
import com.coolots.p2pmsg.parser.ProtoBufHandlerException;
import com.google.protobuf.ByteString;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.httpAdaptor.HttpAdaptorTimeOutValue;
import com.sds.coolots.common.model.ErrorCode;
import com.sds.coolots.common.model.EventCode;
import com.sds.coolots.common.util.C1260a;
import com.sds.coolots.common.util.EncodingUtil;
import com.sds.coolots.common.util.ModelInfoUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.sds.coolots.call.a.i */
/* loaded from: classes.dex */
public class C1143i extends HttpAdaptor {
    public C1143i(ArrayList arrayList, boolean z, Handler handler) {
        super(MessageInfo.MakeConferenceAsk, null, handler, HttpAdaptorTimeOutValue.HTTP_CONNECTION_TIMEOUT_MAKECONFERENCE);
        MakeConferenceAsk makeConferenceAsk = new MakeConferenceAsk();
        byte[] byteArray = (byte[]) null;
        try {
            logI("<CIH> toByteArray() in JoinConferenceAdaptor()");
            byteArray = ProtoBufHandler.toByteArray(C1260a.m2985a());
        } catch (ProtoBufHandlerException e) {
            e.printStackTrace();
        }
        if (byteArray != null) {
            makeConferenceAsk.setFeatureSet(ByteString.copyFrom(byteArray));
        }
        makeConferenceAsk.setSimpleUserInfoList(arrayList);
        if (z) {
            makeConferenceAsk.setConferenceType("V");
            makeConferenceAsk.setVideoConference("Y");
        } else {
            makeConferenceAsk.setConferenceType("A");
            makeConferenceAsk.setVideoConference("N");
        }
        makeConferenceAsk.setAppId(MainApplication.mPhoneManager.getApplicationID());
        if (MainApplication.mPhoneManager.getClientType() == 2) {
            makeConferenceAsk.setAppVersion(null);
        } else {
            makeConferenceAsk.setAppVersion(ModelInfoUtil.getAppVersion(MainApplication.mContext));
        }
        makeConferenceAsk.setCellularNetwork(MainApplication.mPhoneManager.checkNetworkType(MainApplication.mContext));
        makeConferenceAsk.setP2PKey(m2136a());
        this.mMsgBody = makeConferenceAsk;
        logD("<<YHT2>> MAKE USER INFO!!---------------------------------key: " + makeConferenceAsk.getP2PKey());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
            logD("<<YHT2>> ID:" + simpleUserInfo.getUserID() + ", STATUS:" + simpleUserInfo.getStatus() + ", NAME:" + simpleUserInfo.getUserName());
            if (simpleUserInfo.getInviteUserID() == null || simpleUserInfo.getInviteUserID().isEmpty()) {
                simpleUserInfo.setInviteUserID(MainApplication.mConfig.getProfileUserID());
            }
        }
        logD("<<YHT2>> MAKE USER INFO!!---------------------------------");
    }

    /* renamed from: a */
    private String m2136a() {
        String sHAHash = EncodingUtil.getSHAHash(EncodingUtil.getCipherKey(16));
        return sHAHash.length() > 30 ? sHAHash.substring(0, 29) : sHAHash;
    }

    /* renamed from: a */
    private void m2137a(MakeConferenceRep makeConferenceRep) {
        String appVersion = ModelInfoUtil.getAppVersion(MainApplication.mContext);
        String latestVersion = makeConferenceRep.getLatestVersion();
        String result = makeConferenceRep.getResult();
        logI("current version: " + appVersion + "last version: " + latestVersion + ", type: " + result);
        if (latestVersion != null && !latestVersion.isEmpty() && result != null && !result.isEmpty() && appVersion != null && !appVersion.isEmpty() && !appVersion.equals(latestVersion) && result.equals("3")) {
            MainApplication.mApkUpdateInterface.setDownLoadURL(MainApplication.mApkUpdateInterface.change2StringArrayServer(makeConferenceRep.getDownloadUrlList()));
            sendEvent(ErrorCode.ERR_NEED_TO_CRITICAL_UPDATE, 0, makeConferenceRep);
            return;
        }
        List<SimpleUserInfo> simpleUserInfoList = makeConferenceRep.getSimpleUserInfoList();
        if (simpleUserInfoList != null) {
            Iterator<SimpleUserInfo> it = simpleUserInfoList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SimpleUserInfo next = it.next();
                if (MainApplication.mConfig.getProfileUserID().equals(next.getUserID())) {
                    simpleUserInfoList.remove(next);
                    break;
                }
            }
        }
        makeConferenceRep.setSimpleUserInfoList(simpleUserInfoList);
        sendEvent(0, EventCode.EVENT_CONF_MAKE_SUCCESS, makeConferenceRep);
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void handleNetworkError(int i) {
        if (i == -4) {
            processTimeOutError();
        } else {
            sendEvent(i, 0, null);
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void handleNormalError(P2PMsg p2PMsg) {
        sendEvent(-1, EventCode.EVENT_CONF_MAKE_FAILURE, null);
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE MakeConferenceAdaptor MakeConferenceAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processErrorMessage(P2PMsg p2PMsg) {
        Error error = (Error) p2PMsg.getMsgBody();
        logE("Error code: " + error.getErrorCode());
        switch (error.getErrorCode()) {
            case 10001:
            case 10005:
            case 10009:
            case ErrorCode.ERR_CENTER_NO_REMAIND_PHONE_NO /* 10036 */:
            case ErrorCode.ERR_CENTER_MCU /* 10087 */:
            case ErrorCode.ERR_CENTER_MAKE_CONFERENCE /* 10090 */:
            case ErrorCode.ERR_CENTER_ADD_PARTICIPANT_FAIL /* 10091 */:
            case ErrorCode.ERR_CENTER_TOO_MANY_MEMBER /* 10094 */:
            case ErrorCode.ERR_CENTER_LACK_OF_MCU_RESOURCE /* 10123 */:
                sendEvent(error.getErrorCode(), EventCode.EVENT_CONF_MAKE_FAILURE, null);
                break;
            default:
                super.processErrorMessage(p2PMsg);
                break;
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2PMsg) {
        MsgBody msgBody = p2PMsg.getMsgBody();
        if (msgBody instanceof MakeConferenceRep) {
            m2137a((MakeConferenceRep) msgBody);
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processTimeOutError() {
        logE("ADAPTOR_TRACE MakeConferenceAdaptor's processTimeOutError");
        super.processTimeOutError();
    }
}
