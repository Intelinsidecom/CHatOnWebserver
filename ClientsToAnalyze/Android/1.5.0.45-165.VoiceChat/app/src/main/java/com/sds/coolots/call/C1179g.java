package com.sds.coolots.call;

import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.provider.Settings;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.CallState;
import com.sds.coolots.call.model.CallStatusData;
import com.sds.coolots.common.util.Log;
import java.util.HashMap;

/* renamed from: com.sds.coolots.call.g */
/* loaded from: classes.dex */
public class C1179g implements ScreenLockManagerInterface {

    /* renamed from: a */
    private static final String f2426a = "[ScreenLockManager]";

    /* renamed from: b */
    private static final int f2427b = 32;

    /* renamed from: d */
    private static final String f2428d = "coolots_lock_for_calling_state";

    /* renamed from: e */
    private static final String f2429e = "coolots_lock_for_connected_state";

    /* renamed from: j */
    private static final int f2430j = 3000;

    /* renamed from: k */
    private static final int f2431k = 100;

    /* renamed from: l */
    private static final int f2432l = 101;

    /* renamed from: c */
    private HashMap f2433c;

    /* renamed from: f */
    private PowerManager f2434f = null;

    /* renamed from: g */
    private PowerManager.WakeLock f2435g = null;

    /* renamed from: h */
    private PowerManager.WakeLock f2436h = null;

    /* renamed from: i */
    private PowerManager.WakeLock f2437i = null;

    /* renamed from: m */
    private final Handler f2438m = new HandlerC1180h(this);

    public C1179g() {
        m2226b();
    }

    /* renamed from: a */
    private PowerManager.WakeLock m2223a(int i, int i2, String str) {
        try {
            return this.f2434f.newWakeLock(i | i2 | 536870912, str);
        } catch (Exception e) {
            m2225a("Error occurred during getting new WakeLock");
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private void m2225a(String str) {
        Log.m2958e(f2426a + str);
    }

    /* renamed from: b */
    private void m2226b() {
        if (this.f2434f == null) {
            this.f2434f = (PowerManager) MainApplication.mContext.getSystemService("power");
        }
        this.f2433c = new HashMap();
    }

    /* renamed from: b */
    private void m2227b(String str) {
        Log.m2963i(f2426a + str);
    }

    /* renamed from: c */
    private void m2228c() {
        m2227b("acquireLockForCallingState()");
        if (this.f2435g == null) {
            this.f2435g = m2223a(10, 805306368, f2428d);
            if (this.f2435g == null) {
                return;
            }
        }
        if (this.f2435g.isHeld()) {
            return;
        }
        this.f2435g.acquire();
        this.f2438m.removeMessages(100);
    }

    /* renamed from: d */
    private void m2229d() {
        m2227b("releaseLockForCallingState()");
        if (this.f2435g == null || !this.f2435g.isHeld()) {
            return;
        }
        try {
            this.f2435g.release();
            this.f2438m.removeMessages(100);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    private void m2230e() {
        if (this.f2433c.isEmpty()) {
            return;
        }
        for (PowerManager.WakeLock wakeLock : this.f2433c.values()) {
            if (wakeLock.isHeld()) {
                try {
                    wakeLock.release();
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }
        }
        this.f2433c.clear();
    }

    /* renamed from: f */
    private void m2231f() {
        m2227b("acquireLockForEnd()");
        if (this.f2437i == null) {
            this.f2437i = this.f2434f.newWakeLock(268435466, f2428d);
            if (this.f2437i == null) {
                return;
            }
        }
        if (this.f2437i.isHeld()) {
            return;
        }
        this.f2437i.acquire();
        this.f2438m.removeMessages(100);
        this.f2438m.sendEmptyMessageDelayed(100, 3000L);
    }

    /* renamed from: a */
    public void m2232a() {
        m2229d();
        releaseLockForProximity(true);
        m2230e();
    }

    @Override // com.sds.coolots.call.ScreenLockManagerInterface
    public void acquireLockForProximity() {
        m2227b("acquireLockForProximity() - PRECONDITION CHECK");
        CallStatusData callStatusData = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callStatusData);
        if (MainApplication.mPhoneManager.isUseProxymity() && MainApplication.mConfig.isUseProximity() && MainApplication.mPhoneManager.getPhoneStateMachine().getCurrentCoolotsPhoneState() != 4 && callStatusData.getCallFunctionController().getCallSwitchingProcessing() != 2 && !MainApplication.mPhoneManager.getHardwareManager().getSoundManager().isSpeakerOn(MainApplication.mContext) && MainApplication.mPhoneManager.getPhoneStateMachine().isClearCoverOpen()) {
            if (this.f2436h == null) {
                this.f2436h = m2223a(32, 0, f2429e);
                if (this.f2436h == null) {
                    return;
                }
            }
            if (this.f2436h.isHeld() || !isProximitySensorActive() || callStatusData.isUseVideo() || MainApplication.mPhoneManager.getPhoneStateMachine().isEarPhone()) {
                return;
            }
            m2227b("haeri=acquireLockForProximity() - ACTUAL ACQUIRE");
            this.f2436h.acquire();
        }
    }

    @Override // com.sds.coolots.call.ScreenLockManagerInterface
    public void acquireLockForShareScreenProximity() {
        CallStatusData callStatusData = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callStatusData);
        if (MainApplication.mPhoneManager.isUseProxymity() && MainApplication.mConfig.isUseProximity()) {
            m2227b("acquireLockForShareScreenProximity()");
            if (this.f2436h == null) {
                this.f2436h = m2223a(32, 0, f2429e);
                if (this.f2436h == null) {
                    return;
                }
            }
            if (this.f2436h.isHeld() || !isProximitySensorActive() || callStatusData.isUseVideo() || MainApplication.mPhoneManager.getPhoneStateMachine().isEarPhone()) {
                return;
            }
            this.f2436h.acquire();
        }
    }

    @Override // com.sds.coolots.call.ScreenLockManagerInterface
    public void acquirePartialWakeLock(String str) {
        m2227b("<WAKELOCK> aquirePartialWakeLock:" + str);
        PowerManager.WakeLock wakeLockNewWakeLock = (PowerManager.WakeLock) this.f2433c.get(str);
        if (wakeLockNewWakeLock == null) {
            wakeLockNewWakeLock = this.f2434f.newWakeLock(1, str);
            this.f2433c.put(str, wakeLockNewWakeLock);
        }
        if (wakeLockNewWakeLock.isHeld()) {
            return;
        }
        m2227b("<WAKELOCK> ACQUIRE!!!");
        wakeLockNewWakeLock.acquire();
    }

    @Override // com.sds.coolots.call.ScreenLockManagerInterface
    public void acquireScreenBrightWakeLock(String str) {
        m2227b("<WAKELOCK> aquirePartialWakeLock:" + str);
        PowerManager.WakeLock wakeLockNewWakeLock = (PowerManager.WakeLock) this.f2433c.get(str);
        if (wakeLockNewWakeLock == null) {
            wakeLockNewWakeLock = this.f2434f.newWakeLock(10, str);
            this.f2433c.put(str, wakeLockNewWakeLock);
        }
        if (wakeLockNewWakeLock.isHeld()) {
            return;
        }
        m2227b("<WAKELOCK> ACQUIRE!!!");
        wakeLockNewWakeLock.acquire();
    }

    @Override // com.sds.coolots.call.ScreenLockManagerInterface
    public void acquireTimeoutLockForConsentDialog(String str) {
        m2227b("<WAKELOCK>acquireTimeoutLockForConsentDialog:" + str);
        PowerManager.WakeLock wakeLockNewWakeLock = (PowerManager.WakeLock) this.f2433c.get(str);
        if (wakeLockNewWakeLock == null) {
            wakeLockNewWakeLock = this.f2434f.newWakeLock(268435466, str);
            this.f2433c.put(str, wakeLockNewWakeLock);
        }
        if (wakeLockNewWakeLock.isHeld()) {
            return;
        }
        m2227b("<WAKELOCK> ACQUIRE!!!");
        wakeLockNewWakeLock.acquire(3000L);
        Message message = new Message();
        message.what = 101;
        message.obj = str;
        this.f2438m.sendMessageDelayed(message, 3000L);
    }

    @Override // com.sds.coolots.call.ScreenLockManagerInterface
    public PowerManager.WakeLock getWakeLockForConnectedState() {
        return this.f2436h;
    }

    @Override // com.sds.coolots.call.ScreenLockManagerInterface
    public boolean isProximitySensorActive() {
        return Settings.System.getInt(MainApplication.mContext.getContentResolver(), "proximity_sensor", 1) == 1;
    }

    @Override // com.sds.coolots.call.ScreenLockManagerInterface
    public void releaseLockForEnd() {
        m2227b("releaseLockForEnd()");
        if (this.f2437i == null || !this.f2437i.isHeld()) {
            return;
        }
        try {
            this.f2437i.release();
            this.f2438m.removeMessages(100);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    @Override // com.sds.coolots.call.ScreenLockManagerInterface
    public void releaseLockForProximity(boolean z) {
        m2227b("<HAHAHA> releaseLockForProximity()");
        CallStatusData callStatusData = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callStatusData);
        if (MainApplication.mPhoneManager.isUseProxymity() && MainApplication.mConfig.isUseProximity()) {
            boolean zIsBlueToothOn = callStatusData.getAudioPathController() != null ? callStatusData.getAudioPathController().isBlueToothOn() : false;
            if ((this.f2436h != null && this.f2436h.isHeld() && (z || this.f2434f.isScreenOn() || MainApplication.mPhoneManager.getPhoneStateMachine().isEarPhone())) || zIsBlueToothOn) {
                try {
                    this.f2436h.release();
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // com.sds.coolots.call.ScreenLockManagerInterface
    public void releaseLockForProximityOnlyVideoCall() {
        if (this.f2435g == null) {
            this.f2435g = m2223a(10, 805306368, f2428d);
            if (this.f2435g == null) {
                return;
            }
        }
        m2227b(" releaseLockForProximityOnlyVideoCall()");
        this.f2435g.acquire();
        this.f2438m.removeMessages(100);
        if (this.f2436h == null) {
            this.f2436h = m2223a(32, 0, f2429e);
            if (this.f2436h == null) {
                return;
            }
        }
        if (this.f2436h != null) {
            try {
                this.f2436h.release();
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.sds.coolots.call.ScreenLockManagerInterface
    public void releasePartialWakeLock(String str) {
        m2227b("<WAKELOCK> releasePartialWakeLock:" + str);
        PowerManager.WakeLock wakeLockNewWakeLock = (PowerManager.WakeLock) this.f2433c.get(str);
        if (wakeLockNewWakeLock == null) {
            wakeLockNewWakeLock = this.f2434f.newWakeLock(1, str);
        }
        if (wakeLockNewWakeLock.isHeld()) {
            m2227b("<WAKELOCK> RELEASE!!!");
            try {
                wakeLockNewWakeLock.release();
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
        this.f2433c.remove(str);
    }

    @Override // com.sds.coolots.call.ScreenLockManagerInterface
    public void releaseScreenBrightWakeLock(String str) {
        releasePartialWakeLock(str);
    }

    @Override // com.sds.coolots.call.ScreenLockManagerInterface
    public void setEarPhoneScreenLock() {
        m2227b("setEarPhoneScreenLock()");
        CallStatusData callStatusData = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callStatusData);
        if (MainApplication.mPhoneManager.getPhoneStateMachine().isEarPhone()) {
            m2227b("setEarPhone true");
            releaseLockForProximity(false);
            m2229d();
            if (this.f2434f.isScreenOn() || MainApplication.mPhoneManager.getPhoneStateMachine().getCallingActivity() == null) {
                return;
            }
            m2231f();
            return;
        }
        m2227b("setEarPhone false");
        releaseLockForEnd();
        if (!CallState.isCalling(callStatusData.getCallState())) {
            setModeConnected(false);
        }
        if (MainApplication.mPhoneManager.getHardwareManager().getSoundManager().isSpeakerOn(MainApplication.mContext)) {
            return;
        }
        acquireLockForProximity();
    }

    @Override // com.sds.coolots.call.ScreenLockManagerInterface
    public void setEarPhoneScreenLockCallEnd() {
        m2227b("setEarPhoneScreenLockCallEnd()");
        releaseLockForEnd();
    }

    @Override // com.sds.coolots.call.SetModeInterface
    public void setModeBusy() {
        m2227b("setMode_busy()");
        releaseLockForProximity(true);
        m2229d();
    }

    @Override // com.sds.coolots.call.SetModeInterface
    public void setModeCalling(boolean z, boolean z2) {
        m2227b("setMode_calling()");
        releaseLockForEnd();
        if (!z || z2) {
            m2228c();
        } else {
            acquireLockForProximity();
        }
    }

    @Override // com.sds.coolots.call.SetModeInterface
    public void setModeConnected(boolean z) {
        m2227b("setMode_connected()");
        m2229d();
        if (z) {
            return;
        }
        acquireLockForProximity();
    }

    @Override // com.sds.coolots.call.SetModeInterface
    public void setModeConnectedFor3GIdleMode(boolean z) {
    }

    @Override // com.sds.coolots.call.SetModeInterface
    public void setModeDisconnected(boolean z) {
        m2227b("setMode_disconnected() forceTurnOnScreen?" + z);
        CallStatusData callStatusData = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callStatusData);
        releaseLockForProximity(true);
        m2229d();
        if (z || !(this.f2434f.isScreenOn() || MainApplication.mPhoneManager.getPhoneStateMachine().getCallingActivity() == null || !callStatusData.isCallAccept())) {
            m2231f();
        }
    }

    @Override // com.sds.coolots.call.SetModeInterface
    public void setModeError(boolean z) {
        m2227b("setMode_error()");
        releaseLockForProximity(true);
        m2229d();
        if (z || !(this.f2434f.isScreenOn() || MainApplication.mPhoneManager.getPhoneStateMachine().getCallingActivity() == null)) {
            m2231f();
        }
    }

    @Override // com.sds.coolots.call.SetModeInterface
    public void setModeForMinuteMinder(boolean z) {
    }

    @Override // com.sds.coolots.call.SetModeInterface
    public void setModeStartHold() {
    }

    @Override // com.sds.coolots.call.SetModeInterface
    public void setModeStopHold(boolean z) {
    }
}
