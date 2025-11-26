package com.coolots.p000fs.presence;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.GetCallPresenceAsk;
import com.coolots.p2pmsg.model.GetCallPresenceListAsk;
import com.coolots.p2pmsg.model.GetCallPresenceListRep;
import com.coolots.p2pmsg.model.GetCallPresenceRep;
import com.coolots.p2pmsg.model.MemberSimpleInfo;
import com.coolots.sse.presence.adaptor.PresenceAdaptor;
import com.coolots.sse.presence.adaptor.PresenceListAdaptor;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.model.EventCode;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.presence.PresenceManagerInterface;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class FSPresenceManager implements PresenceManagerInterface {
    public static final String CLASSNAME = "[FSPresenceManager]";
    private static final int PROCESS_IDLE = 0;
    private static final int PROCESS_REQ_Presence = 1;
    private static final int PROCESS_REQ_PresenceList = 2;
    public static final String USER_OBJ_IDENTIFIER = "UserObject";
    private final boolean isPresenceProcessRun = false;
    private int mPresenceProcessID = 0;
    private final Handler mHandler = new PresenceHandler(null);

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private static class PresenceHandler extends Handler {
        private PresenceHandler() {
        }

        /* synthetic */ PresenceHandler(PresenceHandler presenceHandler) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message repMsg) {
            if (repMsg.what != MessageInfo.GetCallPresenceAsk.getDispatchCode()) {
                if (repMsg.what != MessageInfo.GetCallPresenceListAsk.getDispatchCode()) {
                    return;
                }
                FSPresenceManager.handleGetCallPresenceListRep(repMsg);
                return;
            }
            FSPresenceManager.handleGetCallPresenceRep(repMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleGetCallPresenceRep(Message repMsg) {
        Message msg = new Message();
        if (repMsg.arg1 == 0) {
            if (repMsg.obj instanceof GetCallPresenceRep) {
                msg.what = EventCode.EVENT_PRESENCE_SUCCESS;
                msg.obj = repMsg.obj;
            } else {
                msg.what = EventCode.EVENT_PRESENCE_FAIL;
                msg.arg1 = -5;
            }
        } else if (repMsg.arg1 != 0) {
            msg.what = EventCode.EVENT_PRESENCE_FAIL;
            msg.arg1 = repMsg.arg1;
        } else {
            msg.what = EventCode.EVENT_PRESENCE_FAIL;
            msg.arg1 = -5;
        }
        MainApplication.mPhoneManager.getCoolotsEventListener().onCallEvent(msg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleGetCallPresenceListRep(Message repMsg) {
        Message msg = new Message();
        if (repMsg.arg1 == 0) {
            if (repMsg.obj instanceof GetCallPresenceListRep) {
                msg.what = EventCode.EVENT_PRESENCE_LIST_SUCCESS;
                msg.obj = repMsg.obj;
            } else {
                msg.what = EventCode.EVENT_PRESENCE_LIST_FAIL;
                msg.arg1 = -5;
            }
        } else if (repMsg.arg1 != 0) {
            msg.what = EventCode.EVENT_PRESENCE_LIST_FAIL;
            msg.arg1 = repMsg.arg1;
        } else {
            msg.what = EventCode.EVENT_PRESENCE_LIST_FAIL;
            msg.arg1 = -5;
        }
        MainApplication.mPhoneManager.getCoolotsEventListener().onCallEvent(msg);
    }

    @Override // com.sds.coolots.presence.PresenceManagerInterface
    public void RequestPresence(String userID, String deviceID) {
        sendVPresenceAsk(userID, deviceID);
    }

    private void sendVPresenceAsk(String userID, String deviceID) {
        this.mPresenceProcessID = 1;
        GetCallPresenceAsk ask = new GetCallPresenceAsk();
        ask.setUserID(userID);
        if (!deviceID.equals("")) {
            ask.setDeviceID(Short.parseShort(deviceID));
        }
        PresenceAdaptor adaptor = new PresenceAdaptor(ask, this.mHandler);
        adaptor.start();
    }

    @Override // com.sds.coolots.presence.PresenceManagerInterface
    public void RequestPresenceList(Object listUserID) {
        Bundle bundle = (Bundle) listUserID;
        List<String> presenceList = extracted(bundle);
        sendVPresenceAsk(presenceList);
    }

    private List<String> extracted(Bundle bundle) {
        return (List) bundle.get("UserObject");
    }

    private void sendVPresenceAsk(List<String> listUserID) {
        List<MemberSimpleInfo> memberSimpleInfoList = new ArrayList<>();
        logE("memberSimpleInfo listUserID.size : " + listUserID.size());
        for (int i = 0; i < listUserID.size(); i++) {
            String userID = listUserID.get(i);
            MemberSimpleInfo memberSimpleInfo = new MemberSimpleInfo();
            memberSimpleInfo.setUserID(userID);
            memberSimpleInfoList.add(memberSimpleInfo);
        }
        if (!listUserID.isEmpty()) {
            logE("listUserID is empty");
        }
        this.mPresenceProcessID = 2;
        GetCallPresenceListAsk ask = new GetCallPresenceListAsk();
        ask.setMemberSimpleInfoList(memberSimpleInfoList);
        PresenceListAdaptor adaptor = new PresenceListAdaptor(ask, this.mHandler);
        adaptor.start();
    }
}
