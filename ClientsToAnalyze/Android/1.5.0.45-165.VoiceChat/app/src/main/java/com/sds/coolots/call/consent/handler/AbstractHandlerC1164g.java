package com.sds.coolots.call.consent.handler;

import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.MsgHeader;
import com.coolots.p2pmsg.model.NotifyConsentAsk;
import com.coolots.p2pmsg.model.ProposeConsentAsk;
import com.coolots.p2pmsg.model.ProposeConsentRep;
import com.coolots.p2pmsg.model.RequestConsentAsk;
import com.coolots.p2pmsg.model.RequestConsentRep;
import com.sds.coolots.EngineInterface;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.consent.handler.CallConsentHandler;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.call.model.P2PUserInfo;
import com.sds.coolots.call.p014b.C1149a;
import com.sds.coolots.common.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.sds.coolots.call.consent.handler.g */
/* loaded from: classes.dex */
public abstract class AbstractHandlerC1164g extends CallConsentHandler {

    /* renamed from: l */
    private static final String f2389l = "[P2PCallConsentHandler]";

    /* renamed from: h */
    protected String f2390h;

    /* renamed from: i */
    protected ArrayList f2391i;

    /* renamed from: j */
    protected ArrayList f2392j;

    /* renamed from: k */
    protected boolean f2393k;

    public AbstractHandlerC1164g(Destination destination, int i, CallConsentHandler.CallConsentCallback callConsentCallback, C1162e c1162e, C1162e c1162e2) {
        super(destination, i, callConsentCallback, c1162e, c1162e2, -1);
        this.f2391i = new ArrayList();
        this.f2392j = new ArrayList();
        this.f2393k = false;
        if (MainApplication.mPhoneManager.isConfTest() && destination.getDestinationType() == 5) {
            this.f2393k = true;
        }
    }

    /* renamed from: d */
    private void m2175d(String str) {
        Log.m2963i(f2389l + str);
    }

    /* renamed from: e */
    private void m2176e(String str) {
        Log.m2958e(f2389l + str);
    }

    /* renamed from: a */
    protected void m2177a(MsgHeader msgHeader, MsgBody msgBody) {
        m2175d("sendPushMessage!!");
        EngineInterface.getInstance().sendPushMessageByP2P(this.f2364b, msgHeader, msgBody);
    }

    /* renamed from: a */
    protected void m2178a(MsgHeader msgHeader, MsgBody msgBody, String str) {
        m2175d("sendPushMessage!!");
        EngineInterface.getInstance().sendPushMessageByP2P(this.f2364b, msgHeader, msgBody, str);
    }

    /* renamed from: a */
    protected void m2179a(boolean z, int i, int i2) {
        m2175d("RequestConsentRep!!! result:" + z);
        RequestConsentRep requestConsentRep = new RequestConsentRep();
        requestConsentRep.setConferenceNo(null);
        requestConsentRep.setCallSessionID(this.f2364b);
        requestConsentRep.setAccept(z);
        requestConsentRep.setCanceledByTimer(false);
        requestConsentRep.setConsentType(i);
        requestConsentRep.setOption(i2);
        requestConsentRep.setRequesterID(MainApplication.mConfig.getProfileUserID());
        requestConsentRep.setRequestKey(this.f2368f);
        m2175d("RequestConsentRep!!! msg:" + requestConsentRep.toString());
        m2178a(C1149a.m2140a(MessageInfo.RequestConsentRep.getServiceCode(), MessageInfo.RequestConsentRep.getMessageCode()), requestConsentRep, this.f2390h);
    }

    /* renamed from: a */
    protected void m2180a(boolean z, String str, int i, int i2, int i3) {
        m2175d("RequestConsentRep!!! result:" + z);
        RequestConsentRep requestConsentRep = new RequestConsentRep();
        requestConsentRep.setConferenceNo(null);
        requestConsentRep.setCallSessionID(this.f2364b);
        requestConsentRep.setAccept(z);
        requestConsentRep.setCanceledByTimer(false);
        requestConsentRep.setConsentType(i2);
        requestConsentRep.setOption(i3);
        requestConsentRep.setRequesterID(MainApplication.mConfig.getProfileUserID());
        requestConsentRep.setRequestKey(i);
        m2175d("RequestConsentRep!!! msg:" + requestConsentRep.toString());
        EngineInterface.getInstance().sendPushMessageByP2P(this.f2364b, C1149a.m2140a(MessageInfo.RequestConsentRep.getServiceCode(), MessageInfo.RequestConsentRep.getMessageCode()), requestConsentRep, str);
    }

    /* renamed from: b */
    protected void m2181b(String str) {
        if (this.f2393k) {
            this.f2391i.remove(str);
        }
    }

    /* renamed from: b */
    protected void m2182b(boolean z) {
        m2175d("RequestConsentRep!!! result:" + z);
        RequestConsentRep requestConsentRep = new RequestConsentRep();
        requestConsentRep.setConferenceNo(null);
        requestConsentRep.setCallSessionID(this.f2364b);
        requestConsentRep.setAccept(z);
        requestConsentRep.setCanceledByTimer(false);
        requestConsentRep.setConsentType(this.f2365c.f2383a);
        requestConsentRep.setOption(this.f2365c.f2384b);
        requestConsentRep.setRequesterID(MainApplication.mConfig.getProfileUserID());
        requestConsentRep.setRequestKey(this.f2368f);
        m2175d("RequestConsentRep!!! msg:" + requestConsentRep.toString());
        m2178a(C1149a.m2140a(MessageInfo.RequestConsentRep.getServiceCode(), MessageInfo.RequestConsentRep.getMessageCode()), requestConsentRep, this.f2390h);
    }

    /* renamed from: b */
    protected void m2183b(boolean z, String str) {
        m2175d("sendNotifyConsentAsk!! bSuccess:" + z);
        NotifyConsentAsk notifyConsentAsk = new NotifyConsentAsk();
        notifyConsentAsk.setCallSessionID(this.f2364b);
        notifyConsentAsk.setConferenceNo(null);
        notifyConsentAsk.setAccept(z);
        notifyConsentAsk.setConsentType(this.f2365c.f2383a);
        notifyConsentAsk.setOption(this.f2365c.f2384b);
        notifyConsentAsk.setRejectUserID(str);
        notifyConsentAsk.setRequestKey(this.f2368f);
        m2177a(C1149a.m2140a(MessageInfo.NotifyConsentAsk.getServiceCode(), MessageInfo.NotifyConsentAsk.getMessageCode()), notifyConsentAsk);
    }

    /* renamed from: c */
    protected void m2184c() {
        if (this.f2393k) {
            Iterator it = this.f2363a.getP2PConferenceMember().iterator();
            while (it.hasNext()) {
                P2PUserInfo p2PUserInfo = (P2PUserInfo) it.next();
                if (p2PUserInfo.userState == 1) {
                    this.f2391i.add(p2PUserInfo.userID);
                    this.f2392j.add(p2PUserInfo.userID);
                }
            }
        }
    }

    /* renamed from: c */
    protected void m2185c(String str) {
        m2175d("sendRequestConsentAsk!!");
        RequestConsentAsk requestConsentAsk = new RequestConsentAsk();
        requestConsentAsk.setCallSessionID(this.f2364b);
        requestConsentAsk.setConferenceNo(null);
        requestConsentAsk.setConsentType(this.f2365c.f2383a);
        requestConsentAsk.setOption(this.f2365c.f2384b);
        requestConsentAsk.setRequesterID(str);
        requestConsentAsk.setRequestKey(this.f2368f);
        m2177a(C1149a.m2140a(MessageInfo.RequestConsentAsk.getServiceCode(), MessageInfo.RequestConsentAsk.getMessageCode()), requestConsentAsk);
    }

    /* renamed from: d */
    protected List m2186d() {
        boolean z;
        boolean z2;
        if (!this.f2393k) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f2363a.getP2PConferenceMember().iterator();
        while (it.hasNext()) {
            P2PUserInfo p2PUserInfo = (P2PUserInfo) it.next();
            if (p2PUserInfo.userState == 1) {
                Iterator it2 = this.f2392j.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z = false;
                        break;
                    }
                    if (((String) it2.next()).equals(p2PUserInfo.userID)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    arrayList.add(p2PUserInfo.userID);
                    this.f2391i.add(p2PUserInfo.userID);
                    this.f2392j.add(p2PUserInfo.userID);
                }
            } else {
                Iterator it3 = this.f2392j.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        z2 = false;
                        break;
                    }
                    if (((String) it3.next()).equals(p2PUserInfo.userID)) {
                        z2 = true;
                        break;
                    }
                }
                if (z2) {
                    this.f2392j.remove(p2PUserInfo.userID);
                    this.f2391i.remove(p2PUserInfo.userID);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    protected boolean m2187e() {
        if (this.f2393k) {
            return this.f2391i.isEmpty();
        }
        return true;
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public void handleProposeConsentAsk(ProposeConsentAsk proposeConsentAsk) {
        m2176e("handleProposeConsentAsk!!! invalid state!!!");
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public void handleProposeConsentRep(ProposeConsentRep proposeConsentRep) {
        m2176e("handleProposeConsentRep!!! invalid state!!!");
    }
}
