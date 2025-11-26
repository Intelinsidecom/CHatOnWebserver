package com.sds.coolots.call.p013a;

import android.os.Handler;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.AddConferenceMemberAsk;
import com.coolots.p2pmsg.model.AddConferenceMemberRep;
import com.coolots.p2pmsg.model.Error;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.P2PMsg;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.model.ErrorCode;
import com.sds.coolots.common.model.EventCode;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.sds.coolots.call.a.a */
/* loaded from: classes.dex */
public class C1135a extends HttpAdaptor {
    public C1135a(String str, boolean z, ArrayList arrayList, String str2, Handler handler) {
        super(MessageInfo.AddConferenceMemberAsk, null, handler, 26000);
        AddConferenceMemberAsk addConferenceMemberAsk = new AddConferenceMemberAsk();
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                if (MainApplication.mConfig.getProfileUserID().equals(((SimpleUserInfo) arrayList.get(i2)).getUserID())) {
                    arrayList.remove(i2);
                    break;
                }
                i = i2 + 1;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
                if (simpleUserInfo.getInviteUserID() == null || simpleUserInfo.getInviteUserID().isEmpty()) {
                    simpleUserInfo.setInviteUserID(MainApplication.mConfig.getProfileUserID());
                }
            }
        }
        if (z) {
            addConferenceMemberAsk.setVideoConference("Y");
        } else {
            addConferenceMemberAsk.setVideoConference("N");
        }
        addConferenceMemberAsk.setP2PKey(str2);
        addConferenceMemberAsk.setConferenceNo(str);
        addConferenceMemberAsk.setSimpleUserInfoList(arrayList);
        this.mMsgBody = addConferenceMemberAsk;
    }

    /* renamed from: a */
    private void m2129a(AddConferenceMemberRep addConferenceMemberRep) {
        sendEvent(0, EventCode.EVENT_CONF_ADD_SUCCESS, addConferenceMemberRep.getSimpleUserInfoList());
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void handleNormalError(P2PMsg p2PMsg) {
        sendEvent(-1, EventCode.EVENT_CONF_ADD_FAILURE, p2PMsg.getMsgBody());
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE AddConferenceMemberAdaptor AddConferenceMemberAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processErrorMessage(P2PMsg p2PMsg) {
        Error error = (Error) p2PMsg.getMsgBody();
        switch (error.getErrorCode()) {
            case 10001:
            case ErrorCode.ERR_CENTER_INVALID_CONFNO /* 10092 */:
            case ErrorCode.ERR_CENTER_NOT_HOST /* 10093 */:
                sendEvent(error.getErrorCode(), EventCode.EVENT_CONF_ADD_FAILURE, p2PMsg.getMsgBody());
                break;
            default:
                super.processErrorMessage(p2PMsg);
                break;
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2PMsg) {
        MsgBody msgBody = p2PMsg.getMsgBody();
        if (msgBody instanceof AddConferenceMemberRep) {
            m2129a((AddConferenceMemberRep) msgBody);
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processTimeOutError() {
        logE("ADAPTOR_TRACE AddConferenceMemberAdaptor's processTimeOutError");
        super.processTimeOutError();
    }

    @Override // java.lang.Thread
    public synchronized void start() {
        super.start();
    }
}
