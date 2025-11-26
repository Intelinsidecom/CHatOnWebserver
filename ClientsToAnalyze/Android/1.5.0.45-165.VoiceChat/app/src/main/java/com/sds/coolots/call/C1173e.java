package com.sds.coolots.call;

import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;

/* renamed from: com.sds.coolots.call.e */
/* loaded from: classes.dex */
public class C1173e implements HardwareManagerInterface {

    /* renamed from: a */
    private static final String f2403a = "[HardwareManager]";

    /* renamed from: b */
    private final HandlerC1227o f2404b;

    /* renamed from: c */
    private final C1179g f2405c;

    public C1173e() {
        m2197b("HardwareManager()");
        this.f2404b = new HandlerC1227o();
        this.f2405c = new C1179g();
    }

    /* renamed from: a */
    private void m2196a(String str) {
        Log.m2958e(f2403a + str);
    }

    /* renamed from: b */
    private void m2197b(String str) {
        Log.m2963i(f2403a + str);
    }

    @Override // com.sds.coolots.call.HardwareManagerInterface
    public ScreenLockManagerInterface getScreenLockManager() {
        return this.f2405c;
    }

    @Override // com.sds.coolots.call.HardwareManagerInterface
    public SoundManagerInterface getSoundManager() {
        return this.f2404b;
    }

    @Override // com.sds.coolots.call.HardwareManagerInterface
    public void releaseAll(boolean z, boolean z2) throws Throwable {
        m2196a("releaseAll()");
        if (z) {
            this.f2404b.m2799h();
        }
        if (z2) {
            this.f2405c.m2232a();
        }
    }

    @Override // com.sds.coolots.call.SetModeInterface
    public void setModeBusy() throws Throwable {
        m2197b("setMode_disconnected");
        if (!MainApplication.mPhoneManager.getPhoneStateMachine().isCurrentMobileCall()) {
            this.f2404b.setModeBusy();
        }
        if (MainApplication.mPhoneManager.getPhoneStateMachine().isCurrentMobileCall()) {
            return;
        }
        this.f2405c.setModeBusy();
    }

    @Override // com.sds.coolots.call.SetModeInterface
    public void setModeCalling(boolean z, boolean z2) {
        m2197b("setMode_calling");
        if (MainApplication.mPhoneManager.getPhoneStateMachine().isCurrentMobileCall()) {
            m2196a("<setModeCalling> invalid state!!! VoIP call is impossible during 3G call!");
            return;
        }
        this.f2404b.setModeCalling(z, z2);
        if (MainApplication.mPhoneManager.getPhoneStateMachine().isCurrentMobileCall()) {
            return;
        }
        m2196a("setMode_calling : Current3GHardwareOccupied not");
        this.f2405c.setModeCalling(z, z2);
    }

    @Override // com.sds.coolots.call.SetModeInterface
    public void setModeConnected(boolean z) throws Throwable {
        m2197b("setMode_connected");
        if (MainApplication.mPhoneManager.getPhoneStateMachine().isCurrentMobileCall()) {
            m2196a("<setModeCalling> invalid state!!! VoIP call is impossible during 3G call!");
        } else {
            this.f2404b.setModeConnected(z);
            this.f2405c.setModeConnected(z);
        }
    }

    @Override // com.sds.coolots.call.SetModeInterface
    public void setModeConnectedFor3GIdleMode(boolean z) throws Throwable {
        m2197b("setModeConnectedFor3GIdleMode");
        if (MainApplication.mPhoneManager.getPhoneStateMachine().isCurrentMobileCall()) {
            m2196a("<setModeCalling> invalid state!!! VoIP call is impossible during 3G call!");
        } else {
            this.f2404b.setModeConnectedFor3GIdleMode(z);
            this.f2405c.setModeConnected(z);
        }
    }

    @Override // com.sds.coolots.call.SetModeInterface
    public void setModeDisconnected(boolean z) throws Throwable {
        m2197b("setMode_disconnected");
        if (!MainApplication.mPhoneManager.getPhoneStateMachine().isCurrentMobileCall()) {
            this.f2404b.setModeDisconnected(z);
            this.f2405c.setModeDisconnected(z);
        } else {
            this.f2404b.m2795d();
            this.f2404b.stopRingBackTone();
            this.f2404b.stopRingStream();
            this.f2404b.m2793b();
        }
    }

    @Override // com.sds.coolots.call.SetModeInterface
    public void setModeError(boolean z) throws Throwable {
        m2197b("setMode_disconnected");
        if (!MainApplication.mPhoneManager.getPhoneStateMachine().isCurrentMobileCall()) {
            this.f2404b.setModeError(z);
            this.f2405c.setModeError(z);
        } else {
            this.f2404b.m2795d();
            this.f2404b.stopRingBackTone();
            this.f2404b.stopRingStream();
        }
    }

    @Override // com.sds.coolots.call.SetModeInterface
    public void setModeForMinuteMinder(boolean z) throws Throwable {
        m2197b("setModeForMinuteMinder");
        if (MainApplication.mPhoneManager.getPhoneStateMachine().isCurrentMobileCall()) {
            m2196a("<setModeCalling> invalid state!!! VoIP call is impossible during 3G call!");
        } else {
            this.f2404b.setModeForMinuteMinder(z);
            this.f2405c.setModeConnected(z);
        }
    }

    @Override // com.sds.coolots.call.SetModeInterface
    public void setModeStartHold() throws Throwable {
        m2197b("setMode_starthold");
        switch (MainApplication.mPhoneManager.getPhoneStateMachine().getCurrentMobilePhoneState()) {
            case 0:
                this.f2404b.setModeStartHold();
                break;
            case 1:
            case 2:
                this.f2404b.m2795d();
                break;
        }
    }

    @Override // com.sds.coolots.call.SetModeInterface
    public void setModeStopHold(boolean z) throws Throwable {
        m2197b("setMode_stophold");
        switch (MainApplication.mPhoneManager.getPhoneStateMachine().getCurrentMobilePhoneState()) {
            case 0:
            case 1:
            case 2:
                this.f2404b.setModeStopHold(z);
                break;
        }
    }
}
