package com.coolots.chaton.buddy.adaptor;

import android.os.Handler;
import com.coolots.chaton.buddy.util.BuddyImageUtil;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.DeleteImageAsk;
import com.coolots.p2pmsg.model.DeleteImageRep;
import com.coolots.p2pmsg.model.P2PMsg;
import com.coolots.sse.common.view.ConfigActivity;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.util.Log;
import java.util.Date;

/* loaded from: classes.dex */
public class DeleteImageAdaptor extends HttpAdaptor {
    public static final String CLASSNAME = "[DeleteProfileImgAdaptor]";

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public DeleteImageAdaptor(int imageType, long groupCode, Handler handler) {
        super(MessageInfo.DeleteImageAsk, null, handler, 6000);
        DeleteImageAsk ask = new DeleteImageAsk();
        ask.setImageType(imageType);
        if (imageType == 2) {
            ask.setBuddyGroupCode(groupCode);
        }
        this.mMsgBody = ask;
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE DeleteProfileImgAdaptor DeleteProfileImgAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2pMsg) {
        if (p2pMsg.getMsgBody() instanceof DeleteImageRep) {
            if (((DeleteImageRep) p2pMsg.getMsgBody()).getImageType() == 2) {
                Date resetDate = new Date();
                resetDate.setTime(0L);
                ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().setGroupImageUpdateDate(((DeleteImageRep) p2pMsg.getMsgBody()).getBuddyGroupCode(), resetDate);
                BuddyImageUtil.deleteGroupThumbnailImage(((DeleteImageRep) p2pMsg.getMsgBody()).getBuddyGroupCode());
            } else if (((DeleteImageRep) p2pMsg.getMsgBody()).getImageType() == 1) {
                Date resetDate2 = new Date();
                resetDate2.setTime(0L);
                ConfigActivity.setProfileImgUpdateDate(resetDate2);
                BuddyImageUtil.deleteMyImageInLocal();
            } else if (((DeleteImageRep) p2pMsg.getMsgBody()).getImageType() == 3) {
                BuddyImageUtil.deleteVideoCallPortraitImage();
                BuddyImageUtil.deleteVideoCallLandscapeImage();
            }
            sendEvent(0, 0, null);
        }
    }
}
