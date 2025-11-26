package com.coolots.chaton.profile.adaptor;

import android.os.Handler;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.P2PMsg;
import com.coolots.p2pmsg.model.ProfileInfo;
import com.coolots.p2pmsg.model.UpdateProfileAsk;
import com.coolots.p2pmsg.model.UpdateProfileRep;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class UpdateProfileAdaptor extends HttpAdaptor {
    public static final String CLASSNAME = "[UpdateProfileAdaptor]";

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public UpdateProfileAdaptor(ProfileInfo profile, Handler handler) {
        super(MessageInfo.UpdateProfileAsk, null, handler, 6000);
        UpdateProfileAsk ask = new UpdateProfileAsk();
        if (profile.getExcludeMe() != null) {
            Log.m2958e("BUDDY_TRACE UpdateProfileAsk ExcludeMe : " + profile.getExcludeMe());
        }
        if (profile.getBuddySuggestion() != null) {
            Log.m2958e("BUDDY_TRACE UpdateProfileAsk BuddySuggestion : " + profile.getBuddySuggestion());
        }
        ask.setProfileInfo(profile);
        this.mMsgBody = ask;
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE UpdateProfileAdaptor UpdateProfileAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2pMsg) {
        if (p2pMsg.getMsgBody() instanceof UpdateProfileRep) {
            ProfileInfo profile = ((UpdateProfileRep) p2pMsg.getMsgBody()).getProfileInfo();
            if (profile == null) {
                sendEvent(-2, 0, null);
                return;
            }
            if (profile.getExcludeMe() != null) {
                Log.m2958e("BUDDY_TRACE UpdateProfileRep ExcludeMe : " + profile.getExcludeMe());
            }
            if (profile.getBuddySuggestion() != null) {
                Log.m2958e("BUDDY_TRACE UpdateProfileRep BuddySuggestion : " + profile.getBuddySuggestion());
            }
            ((VAppPhoneManager) MainApplication.mPhoneManager).getProfileManager().saveProfileInfoForUpdate(profile);
            sendEvent(0, 0, null);
        }
    }
}
