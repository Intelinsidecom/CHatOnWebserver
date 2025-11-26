package com.coolots.chaton.profile.adaptor;

import android.os.Handler;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.P2PMsg;
import com.coolots.p2pmsg.model.ProfileAsk;
import com.coolots.p2pmsg.model.ProfileInfo;
import com.coolots.p2pmsg.model.ProfileRep;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class ProfileAdaptor extends HttpAdaptor {
    public static final String CLASSNAME = "[ProfileAdaptor]";

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public ProfileAdaptor(Handler handler) {
        super(MessageInfo.ProfileAsk, null, handler, 6000);
        ProfileAsk ask = new ProfileAsk();
        this.mMsgBody = ask;
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE ProfileAdaptor ProfileAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2pMsg) {
        if (p2pMsg.getMsgBody() instanceof ProfileRep) {
            ProfileInfo profile = ((ProfileRep) p2pMsg.getMsgBody()).getProfileInfo();
            if (profile == null) {
                sendEvent(-2, 0, null);
                return;
            }
            ((VAppPhoneManager) MainApplication.mPhoneManager).getProfileManager().saveProfileInfo(profile);
            if (this.mHandler != null) {
                sendEvent(0, 0, null);
            }
        }
    }
}
