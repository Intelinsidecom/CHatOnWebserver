package com.coolots.chaton.profile.adaptor;

import android.os.Handler;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.P2PMsg;
import com.coolots.p2pmsg.model.PhoneNoInfo;
import com.coolots.p2pmsg.model.ProfileInfo;
import com.coolots.p2pmsg.model.UnregisterPhoneNoAsk;
import com.coolots.p2pmsg.model.UnregisterPhoneNoRep;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class UnRegisterPhoneNoAdaptor extends HttpAdaptor {
    public UnRegisterPhoneNoAdaptor(ArrayList<PhoneNoInfo> phoneNoList, Handler handler) {
        super(MessageInfo.UnregisterPhoneNoAsk, null, handler, 6000);
        UnregisterPhoneNoAsk ask = new UnregisterPhoneNoAsk();
        ask.setPhoneNoList(phoneNoList);
        this.mMsgBody = ask;
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2pMsg) {
        if (p2pMsg.getMsgBody() instanceof UnregisterPhoneNoRep) {
            ProfileInfo profile = ((UnregisterPhoneNoRep) p2pMsg.getMsgBody()).getProfileInfo();
            if (profile == null) {
                sendEvent(-2, 0, null);
            } else {
                ((VAppPhoneManager) MainApplication.mPhoneManager).getProfileManager().saveProfileInfoForUpdate(profile);
                sendEvent(0, 0, null);
            }
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE UnRegisterPhoneNoAdaptor UnRegisterPhoneNoAsk");
    }
}
