package com.sds.coolots.call.consent.handler;

import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.MsgHeader;
import com.coolots.p2pmsg.model.NotifyConsentAsk;
import com.coolots.p2pmsg.model.ProposeConsentRep;
import com.coolots.p2pmsg.model.PushTargetInfo;
import com.coolots.p2pmsg.model.RequestConsentAsk;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.consent.handler.CallConsentHandler;
import com.sds.coolots.call.consent.register.C1168b;
import com.sds.coolots.call.consent.register.C1171e;
import com.sds.coolots.call.consent.register.HandlerC1167a;
import com.sds.coolots.call.consent.register.HandlerC1169c;
import com.sds.coolots.call.consent.register.HandlerC1170d;
import com.sds.coolots.call.consent.register.RegisterCallbackInterface;
import com.sds.coolots.call.consent.register.RegisterInterface;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.call.p014b.C1149a;
import com.sds.coolots.common.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.sds.coolots.call.consent.handler.f */
/* loaded from: classes.dex */
public abstract class AbstractHandlerC1163f extends CallConsentHandler implements RegisterCallbackInterface {

    /* renamed from: k */
    private static final String f2385k = "[ConferenceCallConsentHandler]";

    /* renamed from: h */
    protected final RegisterInterface f2386h;

    /* renamed from: i */
    protected ArrayList f2387i;

    /* renamed from: j */
    protected ArrayList f2388j;

    public AbstractHandlerC1163f(Destination destination, CallConsentHandler.CallConsentCallback callConsentCallback, C1162e c1162e, C1162e c1162e2, int i) {
        super(destination, -1, callConsentCallback, c1162e, c1162e2, i);
        this.f2387i = new ArrayList();
        this.f2388j = new ArrayList();
        switch (c1162e.f2383a) {
            case 2:
                this.f2386h = new HandlerC1169c();
                break;
            case 3:
                this.f2386h = new HandlerC1170d();
                break;
            case 4:
                this.f2386h = new C1168b();
                break;
            case 5:
                this.f2386h = new C1171e();
                break;
            default:
                this.f2386h = new HandlerC1167a();
                break;
        }
    }

    /* renamed from: c */
    private void m2167c(String str) {
        Log.m2963i(f2385k + str);
    }

    /* renamed from: a */
    protected void m2168a(List list, String str) {
        m2167c("sendRequestConsentAsk!!");
        RequestConsentAsk requestConsentAsk = new RequestConsentAsk();
        requestConsentAsk.setConferenceNo(this.f2363a.getPhoneNo());
        requestConsentAsk.setConsentType(this.f2365c.f2383a);
        requestConsentAsk.setOption(this.f2365c.f2384b);
        requestConsentAsk.setRequesterID(str);
        requestConsentAsk.setRequestKey(this.f2368f);
        C1149a.m2141a(C1149a.m2140a(MessageInfo.RequestConsentAsk.getServiceCode(), MessageInfo.RequestConsentAsk.getMessageCode()), requestConsentAsk, list);
    }

    /* renamed from: b */
    protected void m2169b(String str) {
        this.f2387i.remove(str);
    }

    /* renamed from: b */
    protected void m2170b(boolean z, String str) {
        m2167c("sendProposeConsentRep!! result:" + z + ", destID:" + str);
        if (str == null) {
            return;
        }
        ProposeConsentRep proposeConsentRep = new ProposeConsentRep();
        proposeConsentRep.setConferenceNo(this.f2363a.getPhoneNo());
        proposeConsentRep.setConsentType(this.f2365c.f2383a);
        proposeConsentRep.setOption(this.f2365c.f2384b);
        proposeConsentRep.setRequestKey(this.f2368f);
        proposeConsentRep.setRequestResult(z);
        MsgHeader msgHeaderM2140a = C1149a.m2140a(MessageInfo.ProposeConsentRep.getServiceCode(), MessageInfo.ProposeConsentRep.getMessageCode());
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f2363a.getConferenceMember().iterator();
        while (it.hasNext()) {
            SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
            if (str.equals(simpleUserInfo.getUserID())) {
                PushTargetInfo pushTargetInfo = new PushTargetInfo();
                pushTargetInfo.setReceiverUserID(simpleUserInfo.getUserID());
                pushTargetInfo.setReceiverUserNo(simpleUserInfo.getUserNo());
                pushTargetInfo.setReceiverDeviceID(simpleUserInfo.getDeviceID());
                arrayList.add(pushTargetInfo);
            }
        }
        C1149a.m2141a(msgHeaderM2140a, proposeConsentRep, arrayList);
    }

    /* renamed from: c */
    protected void m2171c() {
        Iterator it = this.f2363a.getConferenceMember().iterator();
        while (it.hasNext()) {
            SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
            if ("1".equals(simpleUserInfo.getStatus()) || SimpleUserInfo.STATE_MOVETO_CONFERENCE.equals(simpleUserInfo.getStatus())) {
                this.f2387i.add(simpleUserInfo.getUserID());
                this.f2388j.add(simpleUserInfo.getUserID());
            }
        }
    }

    /* renamed from: c */
    protected void m2172c(boolean z, String str) {
        m2167c("sendNotifyConsentAsk!! bSuccess:" + z);
        NotifyConsentAsk notifyConsentAsk = new NotifyConsentAsk();
        notifyConsentAsk.setConferenceNo(this.f2363a.getPhoneNo());
        notifyConsentAsk.setAccept(z);
        notifyConsentAsk.setConsentType(this.f2365c.f2383a);
        notifyConsentAsk.setOption(this.f2365c.f2384b);
        notifyConsentAsk.setRejectUserID(str);
        notifyConsentAsk.setRequestKey(this.f2368f);
        MsgHeader msgHeaderM2140a = C1149a.m2140a(MessageInfo.NotifyConsentAsk.getServiceCode(), MessageInfo.NotifyConsentAsk.getMessageCode());
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f2363a.getConferenceMember().iterator();
        while (it.hasNext()) {
            SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
            if ("1".equals(simpleUserInfo.getStatus()) || SimpleUserInfo.STATE_MOVETO_CONFERENCE.equals(simpleUserInfo.getStatus())) {
                m2167c("<CIH> userInfo.getUserID() = " + simpleUserInfo.getUserID());
                m2167c("<CIH> userInfo.getUserName() = " + simpleUserInfo.getUserName());
                PushTargetInfo pushTargetInfo = new PushTargetInfo();
                pushTargetInfo.setReceiverUserID(simpleUserInfo.getUserID());
                pushTargetInfo.setReceiverUserNo(simpleUserInfo.getUserNo());
                pushTargetInfo.setReceiverDeviceID(simpleUserInfo.getDeviceID());
                arrayList.add(pushTargetInfo);
            }
        }
        C1149a.m2141a(msgHeaderM2140a, notifyConsentAsk, arrayList);
    }

    /* renamed from: d */
    protected List m2173d() {
        boolean z;
        boolean z2;
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f2363a.getConferenceMember().iterator();
        while (it.hasNext()) {
            SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
            if ("1".equals(simpleUserInfo.getStatus()) || SimpleUserInfo.STATE_MOVETO_CONFERENCE.equals(simpleUserInfo.getStatus())) {
                Iterator it2 = this.f2388j.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z = false;
                        break;
                    }
                    if (((String) it2.next()).equals(simpleUserInfo.getUserID())) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    arrayList.add(simpleUserInfo.getUserID());
                    this.f2387i.add(simpleUserInfo.getUserID());
                    this.f2388j.add(simpleUserInfo.getUserID());
                }
            } else {
                Iterator it3 = this.f2388j.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        z2 = false;
                        break;
                    }
                    if (((String) it3.next()).equals(simpleUserInfo.getUserID())) {
                        z2 = true;
                        break;
                    }
                }
                if (z2) {
                    this.f2388j.remove(simpleUserInfo.getUserID());
                    this.f2387i.remove(simpleUserInfo.getUserID());
                }
            }
        }
        return arrayList;
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentHandler, com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        Log.m2958e("<<YHT10>> DISPOSED!!!!");
        super.dispose();
        this.f2363a = null;
        this.f2387i.clear();
        this.f2387i = null;
        this.f2388j.clear();
        this.f2388j = null;
    }

    /* renamed from: e */
    protected boolean m2174e() {
        return this.f2387i.isEmpty();
    }

    @Override // com.sds.coolots.call.consent.register.RegisterCallbackInterface
    public void onRegisterResult(boolean z, String str) {
        if (z) {
            m2172c(z, "");
            if (MainApplication.mConfig.getProfileUserID().equals(str)) {
                m2148a(true, str);
            } else {
                m2148a(false, str);
            }
        } else {
            m2172c(z, str);
            if (MainApplication.mConfig.getProfileUserID().equals(str)) {
                m2149a(true, true, "");
            } else {
                m2149a(false, true, "");
            }
        }
        dispose();
    }
}
