package com.sds.coolots.call.model;

import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class CallState {
    public static final int STATE_BUSY = 6;
    public static final int STATE_CALLING = 1;
    public static final int STATE_CHANGE_TO_CONFERENCE = 101;
    public static final int STATE_CHANGE_TO_P2P = 100;
    public static final int STATE_CONNECTED = 2;
    public static final int STATE_DISCONNECTED = 3;
    public static final int STATE_ERROR = -1;
    public static final int STATE_HOLD = 4;
    public static final int STATE_INIT = 0;
    public static final int STATE_MUTE = 5;

    /* renamed from: a */
    private CallStateCallback f2557a;

    /* renamed from: b */
    private int f2558b = 0;

    /* renamed from: c */
    private boolean f2559c = false;

    public interface CallStateCallback {
        void onCallStateChanged(int i);
    }

    /* renamed from: a */
    private void m2386a(String str) {
        Log.m2958e("[CallState]" + str);
    }

    /* renamed from: b */
    private void m2387b(String str) {
        Log.m2963i("[CallState]" + str);
    }

    public static String getCallStateDescription(int i) {
        switch (i) {
            case 0:
                return "STATE_INIT";
            case 1:
                return "STATE_CALLING";
            case 2:
                return "STATE_CONNECTED";
            case 3:
                return "STATE_DISCONNECTED";
            case 4:
                return "STATE_HOLD";
            case 5:
                return "STATE_MUTE";
            case 6:
                return "STATE_BUSY";
            default:
                return "INVALID_STATE";
        }
    }

    public static boolean isCalling(int i) {
        return i == 0 || i == 1;
    }

    public static boolean isConnected(int i) {
        switch (i) {
            case 2:
            case 4:
            case 5:
                return true;
            case 3:
            default:
                return false;
        }
    }

    public static boolean isDisconnected(int i) {
        switch (i) {
            case -1:
            case 3:
            case 6:
                return true;
            default:
                return false;
        }
    }

    public static boolean isNotConnected(int i) {
        return i == 0 || i == 1;
    }

    public int getCallState() {
        m2387b("CallState: " + getCallStateDescription(this.f2558b));
        return this.f2558b;
    }

    public String getStateDescription() {
        return getCallStateDescription(this.f2558b);
    }

    public boolean isCallAccept() {
        return this.f2559c;
    }

    public boolean setCallState(int i) {
        boolean z = false;
        switch (this.f2558b) {
            case -1:
                if (i == 0 || i == -1) {
                    z = true;
                    break;
                }
            case 0:
                if (i == 1 || i == -1) {
                    z = true;
                    break;
                }
            case 1:
                if (i == 2 || i == 3 || i == 6 || i == -1) {
                    z = true;
                    break;
                }
            case 2:
                if (i == 3 || i == 4 || i == 5 || i == -1) {
                    this.f2559c = true;
                    z = true;
                    break;
                }
                break;
            case 3:
                if (i == 0 || i == -1) {
                    z = true;
                    break;
                }
            case 4:
            case 5:
                if (i == 2 || i == 3 || i == -1) {
                    z = true;
                    break;
                }
        }
        if (z) {
            m2387b("setCallState: " + getCallStateDescription(this.f2558b) + " => " + getCallStateDescription(i));
            this.f2558b = i;
            if (this.f2557a != null) {
                this.f2557a.onCallStateChanged(this.f2558b);
            }
        }
        return z;
    }

    public void setCallStateCallback(CallStateCallback callStateCallback) {
        this.f2557a = callStateCallback;
    }
}
