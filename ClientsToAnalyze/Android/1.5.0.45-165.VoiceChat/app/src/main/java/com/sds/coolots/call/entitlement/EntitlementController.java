package com.sds.coolots.call.entitlement;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.controller.PhoneManager;
import com.sds.coolots.common.util.Log;
import java.util.List;

/* loaded from: classes.dex */
public class EntitlementController implements IEntitlementController {

    /* renamed from: a */
    private List f2406a;

    /* renamed from: c */
    private HandlerC1177d f2408c;

    /* renamed from: b */
    private IEntitlement f2407b = null;

    /* renamed from: d */
    private Context f2409d = MainApplication.mContext;

    public EntitlementController() {
        m2201a("EntitlementController create");
        this.f2406a = C1174a.m2203a();
        m2201a("AT&T: MCCMNC - " + this.f2406a);
    }

    /* renamed from: a */
    private IEntitlement m2198a() {
        if (!MainApplication.mConfig.isApplyEntitlement()) {
            m2201a("All entitlement will be ignored.");
            return null;
        }
        String networkOperator = ((TelephonyManager) this.f2409d.getSystemService("phone")).getNetworkOperator();
        if (networkOperator == null || networkOperator.isEmpty()) {
            return null;
        }
        m2201a("getEntitlement()  networkOperator: " + networkOperator + ", model name: " + Build.MODEL);
        if (!this.f2406a.contains(networkOperator)) {
            return null;
        }
        if (C1174a.m2213b()) {
            m2202b("skip AT&T entitlement check");
            return null;
        }
        m2201a("AT&T entitlement");
        return new C1174a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2201a(String str) {
        Log.m2963i("[EntitlementController]" + str);
    }

    /* renamed from: b */
    private void m2202b(String str) {
        Log.m2963i("[EntitlementController]" + str);
    }

    public static boolean isATNTDevice() {
        String networkOperator = ((TelephonyManager) MainApplication.mContext.getSystemService("phone")).getNetworkOperator();
        if (networkOperator == null || networkOperator.isEmpty()) {
            return false;
        }
        return C1174a.m2203a().contains(networkOperator);
    }

    public static void removeAllData(Context context) {
        C1174a.m2211b(context);
        C1174a.m2204a(context);
    }

    @Override // com.sds.coolots.call.entitlement.IEntitlementController
    public void checkEntitlement(IEntitlementResultListener iEntitlementResultListener) {
        if (iEntitlementResultListener == null) {
            return;
        }
        if (this.f2407b == null) {
            iEntitlementResultListener.onReceiveEntitlementResult(0);
        } else {
            m2201a("checkEntitlement()");
            this.f2407b.checkEntitlement(iEntitlementResultListener, null);
        }
    }

    @Override // com.sds.coolots.call.entitlement.IEntitlementController
    public int checkEntitlementDirect() {
        m2201a("checkEntitlementDirect()");
        if (PhoneManager.isWifiNetworkConnected(this.f2409d)) {
            m2201a("no mobile network connection");
            return 0;
        }
        if (this.f2407b == null) {
            this.f2407b = m2198a();
        }
        if (this.f2407b == null) {
            return 0;
        }
        if (this.f2407b.isWifiOnlyMode()) {
            return 3;
        }
        if (this.f2407b.canICheckDirect(this.f2409d)) {
            return this.f2407b.checkEntitlementDirect(this.f2409d) ? 1 : 2;
        }
        return 4;
    }

    @Override // com.sds.coolots.call.entitlement.IEntitlementController
    public void dispose() {
        m2201a("dispose()");
        if (this.f2407b != null) {
            this.f2407b.dispose();
            this.f2407b = null;
        }
        if (this.f2408c != null) {
            this.f2408c.removeMessages(0);
            this.f2408c.m2219a();
            this.f2408c = null;
        }
    }

    @Override // com.sds.coolots.call.entitlement.IEntitlementController
    public boolean isWifiOnlyMode() {
        m2201a("isWifiOnlyMode()");
        if (this.f2407b == null) {
            this.f2407b = m2198a();
        }
        return this.f2407b != null && this.f2407b.isWifiOnlyMode();
    }

    @Override // com.sds.coolots.call.entitlement.IEntitlementController
    public void startTimer(IEntitlementHangupListener iEntitlementHangupListener) {
        m2201a("startTimer");
        if (this.f2407b == null) {
            m2201a("mEntitlement is null");
            return;
        }
        if (iEntitlementHangupListener == null) {
            m2202b("startTimer() hangupListener is null");
        } else {
            if (this.f2407b.getTimerDuration() == 0) {
                m2201a("mEntitlement.getTimerDuration() is 0");
                return;
            }
            if (this.f2408c == null) {
                this.f2408c = new HandlerC1177d(this, iEntitlementHangupListener);
            }
            this.f2408c.sendEmptyMessageDelayed(0, this.f2407b.getTimerDuration());
        }
    }
}
