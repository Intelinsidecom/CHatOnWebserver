package com.sds.coolots.call;

import android.app.KeyguardManager;
import android.os.Message;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.view.CallActivity;
import com.sds.coolots.common.util.Log;

/* renamed from: com.sds.coolots.call.f */
/* loaded from: classes.dex */
public class C1178f implements KeyGuardManagerInterface {

    /* renamed from: a */
    private static final String f2422a = "coolots_lock_for_keyguard";

    /* renamed from: d */
    private static final String f2423d = "[KeyGuardLock]";

    /* renamed from: b */
    private KeyguardManager f2424b = null;

    /* renamed from: c */
    private KeyguardManager.KeyguardLock f2425c = null;

    public C1178f() {
        m2220a();
    }

    /* renamed from: a */
    private void m2220a() {
        if (this.f2424b == null) {
            this.f2424b = (KeyguardManager) MainApplication.mContext.getSystemService("keyguard");
        }
    }

    /* renamed from: a */
    private void m2221a(String str) {
        Log.m2958e(f2423d + str);
    }

    /* renamed from: b */
    private void m2222b(String str) {
        Log.m2963i(f2423d + str);
    }

    @Override // com.sds.coolots.call.KeyGuardManagerInterface
    public void disableKeyguardLock() {
        m2222b("disableKeyguardLock()");
        if (this.f2425c == null) {
            this.f2425c = this.f2424b.newKeyguardLock(f2422a);
        }
        this.f2425c.disableKeyguard();
    }

    @Override // com.sds.coolots.call.KeyGuardManagerInterface
    public void reenableKeyguardLock() {
        m2222b("reenableKeyguardLock()");
        if (this.f2425c != null) {
            this.f2425c.reenableKeyguard();
        }
    }

    @Override // com.sds.coolots.call.KeyGuardManagerInterface
    public void updateKeyguardLock(boolean z) {
        m2222b("updateKeyguardLock() dismiss" + z);
        CallActivity callActivity = (CallActivity) MainApplication.mPhoneManager.getPhoneStateMachine().getCallingActivity();
        if (callActivity == null) {
            return;
        }
        Message message = new Message();
        if (z) {
            message.what = 31;
        } else {
            message.what = 32;
        }
        callActivity.sendHandlerMessage(message, 0L);
    }

    @Override // com.sds.coolots.call.KeyGuardManagerInterface
    public void updateKeyguardPolicy(boolean z) {
        m2222b("updateKeyguardPolicy() dismiss?" + z);
        CallActivity callActivity = (CallActivity) MainApplication.mPhoneManager.getPhoneStateMachine().getCallingActivity();
        if (callActivity == null) {
            return;
        }
        if (z) {
            callActivity.getWindow().addFlags(524288);
        } else {
            callActivity.getWindow().clearFlags(524288);
        }
    }
}
