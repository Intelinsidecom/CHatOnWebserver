package com.sds.coolots.call.p014b;

import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.MsgHeader;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.p017a.C1240a;
import com.sds.coolots.common.util.Log;
import java.util.List;

/* renamed from: com.sds.coolots.call.b.a */
/* loaded from: classes.dex */
public class C1149a {
    /* renamed from: a */
    public static MsgHeader m2140a(int i, int i2) {
        MsgHeader msgHeader = new MsgHeader();
        msgHeader.setVersion("0.90");
        msgHeader.setFromID(MainApplication.mConfig.getProfileUserID());
        msgHeader.setFromDeviceID(MainApplication.mConfig.getProfileDeviceID());
        msgHeader.setSvcCode(i);
        msgHeader.setMsgCode(i2);
        msgHeader.setPasswd(MainApplication.mConfig.getProfilePasswd());
        return msgHeader;
    }

    /* renamed from: a */
    public static void m2141a(MsgHeader msgHeader, MsgBody msgBody, List list) {
        Log.m2963i("[PushUtil] sendPushMessage!!");
        new C1240a(msgHeader, msgBody, list, null).start();
    }
}
