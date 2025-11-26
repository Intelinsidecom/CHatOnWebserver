package com.sds.coolots.call.model;

import android.graphics.Point;
import android.widget.Toast;
import com.coolots.p2pmsg.model.NotifyBoardDataAsk;
import com.coolots.p2pmsg.model.NotifyConsentAsk;
import com.coolots.p2pmsg.model.NotifyFinishShareCameraAsk;
import com.coolots.p2pmsg.model.ProposeConsentAsk;
import com.coolots.p2pmsg.model.ProposeConsentRep;
import com.coolots.p2pmsg.model.RequestConsentAsk;
import com.coolots.p2pmsg.model.RequestConsentRep;
import com.sds.coolots.EngineInterface;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.PhoneStateMachine;
import com.sds.coolots.common.model.EventCode;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.util.StrUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/* renamed from: com.sds.coolots.call.model.M */
/* loaded from: classes.dex */
public class C1198M extends Call {

    /* renamed from: F */
    private static final String f2640F = "[SIPCall]";

    public C1198M(Destination destination, CallState callState, boolean z, CallInstanceInterface callInstanceInterface) {
        super(destination, callState, z, callInstanceInterface);
        this.f2538g = false;
    }

    /* renamed from: e */
    private void m2437e(String str) {
        Log.m2958e(f2640F + str);
    }

    /* renamed from: f */
    private void m2438f(String str) {
        Log.m2963i(f2640F + str);
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: D */
    protected void mo2285D() {
        int i = m2366i();
        String strConvertDateToyyyyMMddHHmmss = StrUtil.convertDateToyyyyMMddHHmmss(this.f2537f.getCallConnectedTime());
        m2438f("first connected time: " + strConvertDateToyyyyMMddHHmmss);
        if (this.f2524C) {
            return;
        }
        int i2 = this.f2545n ? 1 : 0;
        if (this.f2535d) {
            i2 = 2;
        }
        if (this.f2534c) {
            i2 = 3;
        }
        MainApplication.mPhoneManager.getCallLogManager().addCallLogSIP(this.f2546o ? 4 : i2, this.f2539h != 1, strConvertDateToyyyyMMddHHmmss, this.f2537f.getCallDuration(), Integer.toString(this.f2542k.getCountryCode()), null, null, this.f2542k.getPhoneNo(), i, false);
        this.f2524C = true;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: E */
    protected void mo2286E() {
        String strConvertDateToyyyyMMddHHmmss = StrUtil.convertDateToyyyyMMddHHmmss(this.f2537f.getCallConnectedTime());
        m2438f("first connected time: " + strConvertDateToyyyyMMddHHmmss);
        MainApplication.mPhoneManager.getCallLogManager().updateCallLog(this.f2542k.getString(), strConvertDateToyyyyMMddHHmmss, this.f2537f.getCallDuration());
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: F */
    public int mo2287F() {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: H */
    public int mo2289H() {
        return 0;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: I */
    public void mo2290I() {
        if (this.f2541j != -1) {
            EngineInterface.getInstance().hangUpSIPCall(this.f2541j);
        }
        this.f2540i.setCallState(-1);
        this.f2537f.setActivityStatus(EventCode.EVENT_CALL_ERROR, 0, 0, null);
        if (MainApplication.mMainActivity != null) {
            MainApplication.mMainActivity.hideCallProgressDialog();
        }
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: O */
    public void mo2296O() {
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2298a(int i, String str) {
        m2348c(i);
        m2438f("remoteHangupCall()");
        if (this.f2541j == -1) {
            mo2290I();
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (this.f2540i.getCallState() == 0 || this.f2540i.getCallState() == 3) {
            m2437e("remoteHangupCall State Check Error!!! current state:" + this.f2540i.getStateDescription());
            this.f2537f.setActivityStatus(EventCode.EVENT_CALL_HANGUP, 0, 0, null);
            if (MainApplication.mMainActivity == null) {
                return 0;
            }
            MainApplication.mMainActivity.hideCallProgressDialog();
            return 0;
        }
        if (!this.f2545n && this.f2540i.getCallState() == 1) {
            this.f2535d = true;
        }
        if (!this.f2540i.setCallState(3)) {
            this.f2537f.setActivityStatus(EventCode.EVENT_CALL_HANGUP, 0, 0, null);
            if (MainApplication.mMainActivity != null) {
                MainApplication.mMainActivity.hideCallProgressDialog();
            }
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        this.f2537f.setActivityStatus(EventCode.EVENT_CALL_HANGUP, 0, 0, null);
        if (MainApplication.mMainActivity != null) {
            MainApplication.mMainActivity.hideCallProgressDialog();
        }
        this.f2537f.updateVoipCallState();
        this.f2537f.unregistVoipCallState();
        return 0;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2299a(int i, Date date) {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2300a(int i, byte[] bArr) {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2301a(Point point, boolean z) {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2304a(NotifyBoardDataAsk notifyBoardDataAsk) {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2305a(String str) {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2306a(String str, String str2, int i, String str3) {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2308a(ArrayList arrayList, ArrayList arrayList2) {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2309a(short s, boolean z, int i, boolean z2, boolean z3, String str) {
        return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2310a(boolean z, int i) {
        m2348c(i);
        m2438f("localHangupCall()");
        if (this.f2541j == -1) {
            mo2290I();
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (this.f2540i.getCallState() == 0 || this.f2540i.getCallState() == 3) {
            m2437e("localHangupCall() State Check Error!!! current state:" + this.f2540i.getStateDescription());
            mo2290I();
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (!this.f2540i.setCallState(3)) {
            m2437e("localHangupCall() State Setting Error!!! current state:" + this.f2540i.getStateDescription());
            mo2290I();
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        this.f2537f.updateVoipCallState();
        if (z) {
            m2437e("localHangupCall() : hangUpSIPCall()");
            int iHangUpSIPCall = EngineInterface.getInstance().hangUpSIPCall(this.f2541j);
            if (iHangUpSIPCall != 1) {
                m2437e("localHangupCall meet engine error!! code:" + iHangUpSIPCall);
                mo2290I();
                this.f2537f.setActivityStatus(EventCode.EVENT_CALL_HANGUP, 0, 0, null);
                return iHangUpSIPCall;
            }
        }
        this.f2537f.unregistVoipCallState();
        return 0;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2311a(boolean z, int i, boolean z2, String str) {
        if (this.f2541j == -1) {
            m2348c(1001);
            mo2290I();
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (this.f2540i.getCallState() != 1) {
            m2348c(1001);
            m2437e("connectCall State Check Error!!! current state:" + this.f2540i.getStateDescription());
            mo2290I();
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (z) {
            if (!this.f2540i.setCallState(2)) {
                m2348c(1001);
                m2437e("connectCall State Setting Error!!! current state:" + this.f2540i.getStateDescription());
                mo2290I();
                return PhoneStateMachine.ERROR_INVALID_STATE;
            }
            if (!this.f2545n && EngineInterface.getInstance().receiveSIPCall(this.f2541j, this.f2537f.isUseVideo()) != 1) {
                return -1001;
            }
            this.f2537f.setCallConnectedTime(new Date());
            this.f2537f.setActivityStatus(EventCode.EVENT_CALL_CONNECTED, 0, 0, null);
            this.f2537f.updateVoipCallState();
        } else {
            if (!this.f2540i.setCallState(3)) {
                m2348c(1001);
                m2437e("connectCall State Setting Error!!! current state:" + this.f2540i.getStateDescription());
                mo2290I();
                return PhoneStateMachine.ERROR_INVALID_STATE;
            }
            m2348c(i);
            if (!this.f2545n) {
                this.f2534c = true;
                EngineInterface.getInstance().hangUpSIPCall(this.f2541j);
            }
            this.f2537f.setActivityStatus(EventCode.EVENT_CALL_HANGUP, 0, 0, null);
            this.f2537f.updateVoipCallState();
        }
        return 0;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2312a(boolean z, boolean z2, String str) {
        this.f2545n = true;
        this.f2537f.setUseVideo(z);
        this.f2537f.getCallOptionData().f2720u = z2;
        if (this.f2540i.getCallState() != 0) {
            m2437e("startOutGoingCall State Getting Error!!! current state:" + this.f2540i.getStateDescription());
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (!this.f2540i.setCallState(1)) {
            m2437e("startOutGoingCall State Setting Error!!! current state:" + this.f2540i.getStateDescription());
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (!MainApplication.mConfig.getSipIdSendOnly().equals("")) {
            Toast.makeText(MainApplication.mContext, "반환되지 않은 SIP 번호를 반환합니다. 잠시 후 다시 시도해 주세요.", 0).show();
            MainApplication.mPhoneManager.getConfigManager().requestReturnPhoneNoAsk();
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (!this.f2537f.registVoipCallState()) {
            m2437e("startOutGoingCall registVoipCallState error!!!!");
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        this.f2541j = EngineInterface.getInstance().placeSIPCall(this.f2542k.getString(), this.f2537f.isUseVideo());
        if (this.f2541j < 0) {
            if (this.f2541j == -1) {
                return -1001;
            }
            return this.f2541j;
        }
        m2295N();
        this.f2537f.setActivityStatus(EventCode.EVENT_CALL_CALLING, 0, 0, null);
        this.f2537f.updateVoipCallState();
        return 0;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public void mo2317a(int i, boolean z, boolean z2) {
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public void mo2320a(NotifyConsentAsk notifyConsentAsk) {
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public void mo2321a(NotifyFinishShareCameraAsk notifyFinishShareCameraAsk) {
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public void mo2322a(ProposeConsentAsk proposeConsentAsk) {
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public void mo2323a(ProposeConsentRep proposeConsentRep) {
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public void mo2325a(RequestConsentAsk requestConsentAsk) {
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public void mo2326a(RequestConsentRep requestConsentRep) {
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public void mo2328a(String str, String str2) {
        m2438f("notiCloseCall");
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: b */
    protected void mo2338b(int i, int i2, String str) {
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: b */
    public void mo2342b(boolean z, int i) {
        this.f2546o = true;
        this.f2537f.setUseVideo(z);
        this.f2541j = i;
        this.f2540i.setCallState(-1);
        mo2285D();
        EngineInterface.getInstance().hangUpSIPCall(i);
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: c */
    public int mo2345c(int i, int i2) {
        return 0;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: c */
    public int mo2347c(boolean z) throws IOException {
        m2438f("setHoldCall() : " + this.f2540i.getStateDescription());
        if (this.f2541j == -1) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (!CallState.isConnected(this.f2540i.getCallState())) {
            m2437e("setHoldCall State Setting Error!!! current state:" + this.f2540i.getStateDescription());
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (z) {
            if (!this.f2540i.setCallState(4)) {
                m2437e("setHoldCall State Setting Error!!! current state:" + this.f2540i.getStateDescription());
                return PhoneStateMachine.ERROR_INVALID_STATE;
            }
            this.f2537f.getCallOptionData().f2714o = true;
            if (MainApplication.mPhoneManager.getClientType() == 2) {
                this.f2537f.getCallOptionData().f2716q = true;
                EngineInterface.getInstance().holdVideoSIPCall(this.f2541j, z);
            } else {
                EngineInterface.getInstance().holdSIPCall(this.f2541j, z);
            }
            this.f2537f.setActivityStatus(EventCode.EVENT_CALL_HOLD, 0, 0, null);
        } else {
            if (!this.f2540i.setCallState(2)) {
                m2437e("setHoldCall State Setting Error!!! current state:" + this.f2540i.getStateDescription());
                return PhoneStateMachine.ERROR_INVALID_STATE;
            }
            this.f2537f.getCallOptionData().f2714o = false;
            if (MainApplication.mPhoneManager.getClientType() == 2) {
                this.f2537f.getCallOptionData().f2716q = true;
                EngineInterface.getInstance().holdVideoSIPCall(this.f2541j, z);
            } else {
                EngineInterface.getInstance().holdSIPCall(this.f2541j, z);
            }
            this.f2537f.setActivityStatus(EventCode.EVENT_CALL_UNHOLD, 0, 0, null);
        }
        if (this.f2549r != null) {
            this.f2549r.onCallHoldState(z);
        }
        this.f2537f.updateVoipCallState();
        return 0;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: c */
    public boolean mo2350c(String str) {
        return false;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: f */
    public int mo2358f(int i) {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: g */
    public int mo2361g(boolean z) {
        return 0;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: g */
    public void mo2363g(int i) {
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: h */
    public void mo2365h(int i) {
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: m */
    public int mo2372m() {
        if (CallState.isDisconnected(this.f2540i.getCallState())) {
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (!this.f2537f.isUseVideo()) {
            return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
        }
        this.f2537f.getCallOptionData().f2711l = true;
        return EngineInterface.getInstance().startAvatar(true, this.f2541j);
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: n */
    public int mo2373n() {
        if (CallState.isDisconnected(this.f2540i.getCallState())) {
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (!this.f2537f.isUseVideo()) {
            return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
        }
        this.f2537f.getCallOptionData().f2711l = false;
        return EngineInterface.getInstance().stopAvatar(true, this.f2541j);
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: o */
    public int mo2374o() {
        if (CallState.isDisconnected(this.f2540i.getCallState())) {
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (!this.f2537f.isUseVideo()) {
            return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
        }
        if (!this.f2537f.getCallOptionData().f2711l) {
            return PhoneStateMachine.ERROR_NOT_AVATAR_MODE;
        }
        m2437e("<<YHT67>> createCustomAvatar!!!");
        return EngineInterface.getInstance().createCustomAvatar(false, this.f2541j);
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: p */
    public int mo2375p() {
        if (CallState.isDisconnected(this.f2540i.getCallState())) {
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (!this.f2537f.isUseVideo()) {
            return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
        }
        if (!this.f2537f.getCallOptionData().f2711l) {
            return PhoneStateMachine.ERROR_NOT_AVATAR_MODE;
        }
        m2437e("<<YHT67>> changeAvatarHair!!!");
        return EngineInterface.getInstance().changeAvatarHair(false, this.f2541j);
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: q */
    public int mo2376q() {
        if (CallState.isDisconnected(this.f2540i.getCallState())) {
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (!this.f2537f.isUseVideo()) {
            return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
        }
        if (!this.f2537f.getCallOptionData().f2711l) {
            return PhoneStateMachine.ERROR_NOT_AVATAR_MODE;
        }
        m2437e("<<YHT67>> changeAvatarGlasses!!!");
        return EngineInterface.getInstance().changeAvatarGlasses(false, this.f2541j);
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: t */
    public boolean mo2379t() {
        return false;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: x */
    protected void mo2383x() {
    }
}
