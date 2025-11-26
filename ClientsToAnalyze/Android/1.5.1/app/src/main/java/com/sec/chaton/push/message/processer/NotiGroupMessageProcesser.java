package com.sec.chaton.push.message.processer;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.sec.chaton.push.exception.ConnectionException;
import com.sec.chaton.push.network.connection.PushConnectionManager;
import com.sec.chaton.push.provisioning.ProvisioningManager;
import com.sec.chaton.push.registration.RegistrationManager;
import com.sec.chaton.push.util.MessageUtil;
import com.sec.chaton.push.util.PushLog;
import com.sec.pns.msg.MsgResultCode;
import com.sec.pns.msg.frontend.MsgFrontend;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class NotiGroupMessageProcesser extends AbstractMessageProcesser {

    /* renamed from: d */
    private static final String f2656d = NotiGroupMessageProcesser.class.getSimpleName();

    /* renamed from: e */
    private Context f2657e;

    /* renamed from: f */
    private PushConnectionManager f2658f;

    public NotiGroupMessageProcesser(MessageController messageController, Handler handler) {
        super(messageController, handler);
        this.f2657e = messageController.m2934g();
        this.f2658f = messageController.m2935h();
    }

    /* renamed from: a */
    private void m2945a(Context context, MsgFrontend.NotiElement notiElement) {
        Intent intent = new Intent("com.sec.chaton.push.NOTIFICATION_ACTION");
        boolean z = notiElement.getReliableLevel() == 2;
        intent.putExtra("notificationId", notiElement.getNotiId());
        intent.putExtra("sender", notiElement.getSender());
        intent.putExtra("msg", notiElement.getMessage());
        intent.putExtra("appData", notiElement.getAppData());
        intent.putExtra("timeStamp", notiElement.getTimeStamp());
        intent.putExtra("sessionInfo", notiElement.getSessionInfo());
        intent.putExtra("connectionTerm", notiElement.getConnectionTerm());
        intent.putExtra("ack", z);
        context.sendBroadcast(intent, "com.sec.chaton.push.BROADCAST_PUSH_MESSAGE");
    }

    /* renamed from: a */
    private void m2946a(Context context, String str) {
        String[] strArrSplit = str.split("#");
        PushLog.m3025a(f2656d, "ResultCode : " + strArrSplit[0]);
        PushLog.m3025a(f2656d, "Message : " + strArrSplit[1]);
        switch (Integer.parseInt(strArrSplit[0])) {
            case MsgResultCode.UNKNOWN_MESSAGE_TYPE /* 2000 */:
            case MsgResultCode.UNEXPECTED_MESSAGE /* 2001 */:
            case MsgResultCode.CONNECTION_MAX_EXCEEDED /* 4000 */:
                break;
            case MsgResultCode.RESET_BY_NEW_INITIALIZATION /* 4005 */:
                PushLog.m3031d(f2656d, "Server error: internal server error");
                if (this.f2623b.m2939l() != EnumC0374i.Primary) {
                    if (this.f2623b.m2939l() == EnumC0374i.Secondary) {
                        PushLog.m3031d(f2656d, " > Disconnect connection");
                        try {
                            this.f2658f.m2982b();
                        } catch (ConnectionException e) {
                        }
                        ProvisioningManager.m3000b(context);
                        PushLog.m3025a(f2656d, " > Execute re-provisioning");
                        m2882a(0, true);
                        break;
                    }
                } else {
                    PushLog.m3031d(f2656d, " > Disconnect connection");
                    try {
                        this.f2658f.m2982b();
                    } catch (ConnectionException e2) {
                    }
                    PushLog.m3031d(f2656d, " > Change target server");
                    this.f2623b.m2940m();
                    PushLog.m3031d(f2656d, " > Execute initialize");
                    this.f2623b.m2929b((ICallback) null);
                    break;
                }
                break;
            default:
                PushLog.m3031d(f2656d, "Unknown ResultCode");
                break;
        }
    }

    /* renamed from: a */
    public void m2947a(MsgFrontend.NotiGroup notiGroup) {
        PushLog.m3025a(f2656d, "NotiGroupMessageProcesser.process()");
        PushLog.m3028b(f2656d, "NotiGroup");
        PushLog.m3025a(f2656d, "NotiElement count: " + notiGroup.getNotiElementsCount());
        PushLog.m3025a(f2656d, "==========================");
        Iterator it = notiGroup.getNotiElementsList().iterator();
        while (it.hasNext()) {
            PushLog.m3025a(f2656d, MessageUtil.m3020a((MsgFrontend.NotiElement) it.next()));
        }
        PushLog.m3025a(f2656d, "==========================");
        ArrayList arrayList = new ArrayList();
        for (MsgFrontend.NotiElement notiElement : notiGroup.getNotiElementsList()) {
            int type = notiElement.getType();
            int reliableLevel = notiElement.getReliableLevel();
            String appId = notiElement.getAppId();
            String notiId = notiElement.getNotiId();
            String strM3012b = RegistrationManager.m3012b(this.f2657e);
            if (type == 2) {
                m2946a(this.f2657e, notiElement.getMessage());
            } else if (strM3012b == null || !strM3012b.equals(appId)) {
                PushLog.m3030c(f2656d, "The application id of notification isn't registered in device");
            } else {
                if (reliableLevel == 2) {
                    PushLog.m3025a(f2656d, "This notification needs acknowledgement by application level");
                } else if (reliableLevel == 1) {
                    PushLog.m3025a(f2656d, "This notification needs acknowledgement by system level");
                    arrayList.add(notiId);
                } else if (reliableLevel == 0) {
                    PushLog.m3025a(f2656d, "This notification doesn't need acknowledgement");
                }
                if (type == 1 || type == 2) {
                    PushLog.m3025a(f2656d, "Broadcast notification will not be sent to application");
                } else {
                    PushLog.m3025a(f2656d, "Broadcast notification will be sent to application");
                    m2945a(this.f2657e, notiElement);
                }
            }
        }
        if (arrayList.size() != 0) {
            PushLog.m3025a(f2656d, "Send system level NotiAcks to push server");
            this.f2623b.m2920a(arrayList);
        }
    }
}
