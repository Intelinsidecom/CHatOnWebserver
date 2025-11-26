package com.sds.coolots.common.p017a;

import android.os.Handler;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.MsgHeader;
import com.coolots.p2pmsg.model.P2PMsg;
import com.coolots.p2pmsg.model.PushMultiNotificationAsk;
import com.coolots.p2pmsg.model.PushMultiNotificationRep;
import com.coolots.p2pmsg.parser.ProtoBufHandler;
import com.coolots.p2pmsg.parser.ProtoBufHandlerException;
import com.google.protobuf.ByteString;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import java.util.List;

/* renamed from: com.sds.coolots.common.a.a */
/* loaded from: classes.dex */
public class C1240a extends HttpAdaptor {
    public C1240a(MsgHeader msgHeader, MsgBody msgBody, List list, Handler handler) {
        super(MessageInfo.PushMultiNotificationAsk, null, handler, 26000);
        byte[] byteArray = (byte[]) null;
        byte[] byteArray2 = (byte[]) null;
        try {
            byteArray = ProtoBufHandler.toByteArray(msgHeader);
            byteArray2 = ProtoBufHandler.toByteArray(msgBody);
        } catch (ProtoBufHandlerException e) {
            e.printStackTrace();
        }
        PushMultiNotificationAsk pushMultiNotificationAsk = new PushMultiNotificationAsk();
        pushMultiNotificationAsk.setSenderDeviceID(MainApplication.mConfig.getProfileDeviceID());
        pushMultiNotificationAsk.setSenderUserNo(MainApplication.mConfig.getProfileUserNo());
        if (byteArray != null && byteArray2 != null) {
            pushMultiNotificationAsk.setNestedMsgHeader(ByteString.copyFrom(byteArray));
            pushMultiNotificationAsk.setNestedMsgBody(ByteString.copyFrom(byteArray2));
        }
        pushMultiNotificationAsk.setPushGuaranteeType(0);
        pushMultiNotificationAsk.setPushKey("1");
        pushMultiNotificationAsk.setPushType(1);
        pushMultiNotificationAsk.setPushTargetInfoList(list);
        this.mMsgBody = pushMultiNotificationAsk;
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE PushMultiNotificationAdaptor PushMultiNotificationAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2PMsg) {
        if (p2PMsg.getMsgBody() instanceof PushMultiNotificationRep) {
            sendEvent(0, 0, null);
        } else {
            sendEvent(-1, 0, null);
        }
    }
}
