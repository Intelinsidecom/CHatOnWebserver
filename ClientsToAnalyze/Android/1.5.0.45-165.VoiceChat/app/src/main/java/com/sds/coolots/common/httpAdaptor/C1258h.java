package com.sds.coolots.common.httpAdaptor;

import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.MessageInfoR;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.MsgHeader;
import com.coolots.p2pmsg.model.P2PMsg;
import com.coolots.p2pmsg.parser.ProtoBufHandler;
import com.coolots.p2pmsg.parser.ProtoBufHandlerException;
import com.coolots.sso.util.ChatONVAPII;
import com.sds.coolots.common.util.Log;
import java.io.IOException;

/* renamed from: com.sds.coolots.common.httpAdaptor.h */
/* loaded from: classes.dex */
public final class C1258h {

    /* renamed from: a */
    public static final String f3053a = "UTF-8";

    /* renamed from: b */
    private static final String f3054b = "com.coolots.p2pmsg.model";

    private C1258h() {
    }

    /* renamed from: a */
    public static P2PMsg m2946a(byte[] bArr, byte[] bArr2, StringBuilder sb) {
        if (bArr == null || bArr2 == null) {
            Log.m2958e("parseString() byteHeader or byteBody is null");
            return null;
        }
        try {
            MsgHeader msgHeader = new MsgHeader();
            ProtoBufHandler.parseMsgHeader(bArr, msgHeader);
            MessageInfo messageInfo = MessageInfoR.getMessageInfo(msgHeader.getSvcCode(), msgHeader.getMsgCode());
            Log.m2954d("SVC Code: " + msgHeader.getSvcCode() + ", Msg Code:" + msgHeader.getMsgCode());
            if (messageInfo == null) {
                throw new ProtoBufHandlerException("MessageInfo not found " + msgHeader.getSvcCode() + ChatONVAPII.USERID_DELEMETER + msgHeader.getMsgCode());
            }
            MsgBody msgBody = (MsgBody) Class.forName("com.coolots.p2pmsg.model." + messageInfo.name()).getConstructor(new Class[0]).newInstance(new Object[0]);
            ProtoBufHandler.parseMsgBody(bArr2, msgBody);
            P2PMsg p2PMsg = new P2PMsg();
            p2PMsg.setMsgHeader(msgHeader);
            p2PMsg.setMsgBody(msgBody);
            return p2PMsg;
        } catch (Exception e) {
            Log.m2960e((Throwable) e);
            return null;
        }
    }

    /* renamed from: a */
    public static byte[][] m2947a(P2PMsg p2PMsg) throws IOException {
        if (p2PMsg == null || p2PMsg.getMsgBody() == null || p2PMsg.getMsgHeader() == null) {
            Log.m2958e("toString() byteHeader or byteBody is null");
            return null;
        }
        try {
            return new byte[][]{ProtoBufHandler.toByteArray(p2PMsg.getMsgHeader()), ProtoBufHandler.toByteArray(p2PMsg.getMsgBody())};
        } catch (Exception e) {
            Log.m2960e((Throwable) e);
            return null;
        }
    }
}
