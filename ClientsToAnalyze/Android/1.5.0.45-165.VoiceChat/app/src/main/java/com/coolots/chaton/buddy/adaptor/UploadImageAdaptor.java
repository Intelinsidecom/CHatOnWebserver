package com.coolots.chaton.buddy.adaptor;

import android.os.Handler;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.view.ConfigActivity;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.P2PMsg;
import com.coolots.p2pmsg.model.UploadImageAsk;
import com.coolots.p2pmsg.model.UploadImageRep;
import com.google.protobuf.ByteString;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.httpAdaptor.HttpAdaptorTimeOutValue;
import com.sds.coolots.common.httpAdaptor.MsgKeyGenerator;
import com.sds.coolots.common.util.Log;
import java.util.Date;

/* loaded from: classes.dex */
public class UploadImageAdaptor extends HttpAdaptor {
    public static final String CLASSNAME = "[UploadProfileImgAdaptor]";
    private boolean isFirst;

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public UploadImageAdaptor(int imageType, ByteString profileImage, ByteString thumbnailImage, long groupCode, Handler handler) {
        super(MessageInfo.UploadImageAsk, null, handler, HttpAdaptorTimeOutValue.HTTP_CONNECTION_TIMEOUT_PROFILEIMGUPLOAD);
        this.isFirst = true;
        UploadImageAsk ask = new UploadImageAsk();
        if (profileImage != null) {
            ask.setImageByteString(profileImage);
        }
        if (thumbnailImage != null) {
            ask.setThumbnailImageByteString(thumbnailImage);
        }
        ask.setImageType(imageType);
        if (imageType == 2) {
            ask.setBuddyGroupCode(groupCode);
        }
        this.mMsgBody = ask;
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE UploadProfileImgAdaptor UploadImageAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void handleFinishEncode() {
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2pMsg) {
        if (this.isFirst) {
            this.isFirst = false;
            this.mMsgHeader.setMsgKey(Integer.valueOf(MsgKeyGenerator.getInstance().getKey()));
            runProcess();
            return;
        }
        if (p2pMsg.getMsgBody() instanceof UploadImageRep) {
            if (((UploadImageRep) p2pMsg.getMsgBody()).getImageType() == 1) {
                if (((UploadImageRep) p2pMsg.getMsgBody()).getUpdateDate() == null) {
                    Date resetDate = new Date();
                    resetDate.setTime(0L);
                    ConfigActivity.setProfileImgUpdateDate(resetDate);
                } else {
                    ConfigActivity.setProfileImgUpdateDate(((UploadImageRep) p2pMsg.getMsgBody()).getUpdateDate());
                }
            } else if (((UploadImageRep) p2pMsg.getMsgBody()).getImageType() == 2) {
                if (((UploadImageRep) p2pMsg.getMsgBody()).getUpdateDate() == null) {
                    Date resetDate2 = new Date();
                    resetDate2.setTime(0L);
                    ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().setGroupImageUpdateDate(((UploadImageRep) p2pMsg.getMsgBody()).getBuddyGroupCode(), resetDate2);
                } else {
                    ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().setGroupImageUpdateDate(((UploadImageRep) p2pMsg.getMsgBody()).getBuddyGroupCode(), ((UploadImageRep) p2pMsg.getMsgBody()).getUpdateDate());
                }
            } else if (((UploadImageRep) p2pMsg.getMsgBody()).getImageType() == 3) {
                if (((UploadImageRep) p2pMsg.getMsgBody()).getUpdateDate() == null) {
                    Date resetDate3 = new Date();
                    resetDate3.setTime(0L);
                    ConfigActivity.setVideoCallImgUpdateDate(resetDate3);
                } else {
                    ConfigActivity.setVideoCallImgUpdateDate(((UploadImageRep) p2pMsg.getMsgBody()).getUpdateDate());
                }
            }
            if (this.mHandler != null) {
                sendEvent(0, ((UploadImageRep) p2pMsg.getMsgBody()).getImageType(), null);
            }
        }
    }
}
