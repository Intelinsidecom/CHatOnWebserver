package com.sds.coolots.call.model;

import android.os.Message;
import com.sds.coolots.EngineInterface;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.PhoneStateMachine;
import com.sds.coolots.common.model.EventCode;
import com.sds.coolots.common.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.sds.coolots.call.model.K */
/* loaded from: classes.dex */
public class C1196K extends C1193H {

    /* renamed from: F */
    private static final String f2635F = "[P2PConferenceCall]";

    public C1196K(Destination destination, CallState callState, boolean z, CallInstanceInterface callInstanceInterface) {
        super(destination, callState, z, callInstanceInterface);
    }

    /* renamed from: d */
    private int m2431d(ArrayList arrayList) throws IOException {
        boolean z;
        if (this.f2542k.getDestinationType() == 2) {
            return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
        }
        if (this.f2541j == -1) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (!CallState.isConnected(this.f2540i.getCallState())) {
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        ArrayList p2PConferenceMember = this.f2542k.getP2PConferenceMember();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            P2PUserInfo p2PUserInfo = (P2PUserInfo) it.next();
            Iterator it2 = p2PConferenceMember.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = true;
                    break;
                }
                P2PUserInfo p2PUserInfo2 = (P2PUserInfo) it2.next();
                if (p2PUserInfo2.userID.equals(p2PUserInfo.userID)) {
                    p2PUserInfo2.userState = p2PUserInfo.userState;
                    p2PUserInfo2.surfaceID = p2PUserInfo.surfaceID;
                    z = false;
                    break;
                }
            }
            if (z) {
                p2PConferenceMember.add(p2PUserInfo);
            }
        }
        this.f2542k.setP2PConferenceMember(p2PConferenceMember);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            P2PUserInfo p2PUserInfo3 = (P2PUserInfo) it3.next();
            arrayList2.add(p2PUserInfo3.userID);
            arrayList3.add(p2PUserInfo3.userName);
        }
        EngineInterface.getInstance().placeP2PCall(arrayList2, this.f2537f.isUseVideo(), MainApplication.mConfig.isSecureCommunication(), arrayList3, "", true);
        return 0;
    }

    /* renamed from: g */
    private void m2432g(String str) {
        Log.m2958e(f2635F + str);
    }

    /* renamed from: h */
    private void m2433h(String str) {
        Log.m2963i(f2635F + str);
    }

    @Override // com.sds.coolots.call.model.C1193H, com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2305a(String str) {
        if (this.f2542k.getDestinationType() == 2) {
            return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
        }
        if (this.f2541j == -1) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (!this.f2545n) {
        }
        EngineInterface.getInstance().removeP2PConfMember(this.f2541j, str);
        return 0;
    }

    @Override // com.sds.coolots.call.model.C1193H, com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2308a(ArrayList arrayList, ArrayList arrayList2) throws IOException {
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ConferenceMember conferenceMember = (ConferenceMember) it.next();
            P2PUserInfo p2PUserInfo = new P2PUserInfo();
            p2PUserInfo.userID = conferenceMember.userID;
            p2PUserInfo.userName = conferenceMember.userName;
            p2PUserInfo.userState = 0;
            arrayList3.add(p2PUserInfo);
        }
        int iM2431d = m2431d(arrayList3);
        if (iM2431d != 0) {
            m2432g("addConferenceMember Handling Error!!! Error Code:" + iM2431d);
        }
        return iM2431d;
    }

    @Override // com.sds.coolots.call.model.C1193H
    /* renamed from: a */
    protected int mo2426a(boolean z, String str) throws IOException {
        if (this.f2542k.getDestinationType() == 2) {
            return super.mo2426a(z, str);
        }
        ArrayList<P2PUserInfo> p2PConferenceMember = this.f2542k.getP2PConferenceMember();
        if (p2PConferenceMember == null || p2PConferenceMember.isEmpty()) {
            return -1;
        }
        if (!MainApplication.mPhoneManager.isConfTest() && p2PConferenceMember.size() == 1) {
            return EngineInterface.getInstance().placeCall(((P2PUserInfo) p2PConferenceMember.get(0)).userID, this.f2537f.isUseVideo(), MainApplication.mConfig.isSecureCommunication(), z, str);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (P2PUserInfo p2PUserInfo : p2PConferenceMember) {
            arrayList.add(p2PUserInfo.userID);
            arrayList2.add(p2PUserInfo.userName);
        }
        int iPlaceP2PCall = EngineInterface.getInstance().placeP2PCall(arrayList, this.f2537f.isUseVideo(), MainApplication.mConfig.isSecureCommunication(), arrayList2, str, false);
        if (iPlaceP2PCall < 0) {
            return iPlaceP2PCall;
        }
        this.f2542k.setP2PConferenceNo(iPlaceP2PCall);
        return iPlaceP2PCall;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: b */
    public int mo2336b(ArrayList arrayList) {
        boolean z;
        boolean z2;
        if (this.f2542k.getDestinationType() != 5) {
            return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
        }
        if (this.f2541j == -1) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        ArrayList p2PConferenceMember = this.f2542k.getP2PConferenceMember();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            P2PUserInfo p2PUserInfo = (P2PUserInfo) it.next();
            Iterator it2 = p2PConferenceMember.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z2 = true;
                    break;
                }
                P2PUserInfo p2PUserInfo2 = (P2PUserInfo) it2.next();
                if (p2PUserInfo2.userID.equals(p2PUserInfo.userID)) {
                    p2PUserInfo2.userState = p2PUserInfo.userState;
                    p2PUserInfo2.surfaceID = p2PUserInfo.surfaceID;
                    z2 = false;
                    break;
                }
            }
            if (z2) {
                p2PConferenceMember.add(p2PUserInfo);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it3 = p2PConferenceMember.iterator();
        while (it3.hasNext()) {
            P2PUserInfo p2PUserInfo3 = (P2PUserInfo) it3.next();
            Iterator it4 = arrayList.iterator();
            while (true) {
                if (!it4.hasNext()) {
                    z = true;
                    break;
                }
                if (p2PUserInfo3.userID.equals(((P2PUserInfo) it4.next()).userID)) {
                    z = false;
                    break;
                }
            }
            if (z) {
                p2PUserInfo3.userState = 2;
            } else {
                arrayList2.add(p2PUserInfo3);
            }
        }
        m2433h("<<YHT10>> ---------------- update conference member------------------------");
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            m2433h(((P2PUserInfo) it5.next()).toString());
        }
        m2433h("<<YHT10>> -----------------------------------------------------------------");
        this.f2542k.setP2PConferenceMember(arrayList2);
        this.f2537f.setActivityStatus(EventCode.EVENT_CONF_UPDATE_MEMBER, 0, 0, null);
        return 0;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: j */
    public int mo2368j(int i) {
        if (this.f2542k.getDestinationType() != 5) {
            return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
        }
        if (this.f2541j == -1) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        this.f2537f.setActivityStatus(EventCode.EVENT_CONF_UPDATE_MEMBER, 0, 0, null);
        Message message = new Message();
        message.what = EventCode.EVENT_VOICE_ACTIVITY_CHANGE;
        message.arg1 = i;
        synchronized (this.f2537f.getCallActivityMutex()) {
            if (this.f2537f.getCallingActivity() != null) {
                m2433h("notifyVoiceActivity!!!!! msg.whar:" + message.what);
                if (MainApplication.mPhoneManager.getCoolotsEventListener() == null) {
                    this.f2537f.getCallingActivity().sendHandlerMessage(message, 0L);
                } else {
                    MainApplication.mPhoneManager.getCoolotsEventListener().onCallEvent(message);
                }
            }
        }
        return 0;
    }
}
