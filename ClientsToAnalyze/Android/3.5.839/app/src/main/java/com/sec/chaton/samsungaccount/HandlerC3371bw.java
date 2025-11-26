package com.sec.chaton.samsungaccount;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.SSOAccessTokenEntry;
import com.sec.chaton.p065io.entry.SSOUserInformationEntry;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;

/* compiled from: SamsungAccountLoginDialog.java */
/* renamed from: com.sec.chaton.samsungaccount.bw */
/* loaded from: classes.dex */
class HandlerC3371bw extends Handler {

    /* renamed from: a */
    final /* synthetic */ DialogC3368bt f12328a;

    HandlerC3371bw(DialogC3368bt dialogC3368bt) {
        this.f12328a = dialogC3368bt;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0778b c0778b = (C0778b) message.obj;
        if (message.what == 2003) {
            if (this.f12328a.f12321o != null && this.f12328a.f12321o.isShowing()) {
                this.f12328a.f12321o.dismiss();
            }
            if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                SSOUserInformationEntry sSOUserInformationEntry = (SSOUserInformationEntry) c0778b.m3110e();
                C4904y.m18639b("userInfo : " + sSOUserInformationEntry, getClass().getSimpleName());
                if (TextUtils.isEmpty(sSOUserInformationEntry.loginID) || TextUtils.isEmpty(sSOUserInformationEntry.countryCode)) {
                    MainActivity.m13076a(this.f12328a.f12319m, EnumC3327af.normal);
                    return;
                }
                C4809aa.m18108a("samsung_account_email", sSOUserInformationEntry.loginID);
                C4809aa.m18108a("samsung_account_faimly_name", sSOUserInformationEntry.familyName);
                C4809aa.m18108a("samsung_account_given_name", sSOUserInformationEntry.givenName);
                this.f12328a.f12320n.clearCache(true);
                this.f12328a.dismiss();
                this.f12328a.f12316j.mo13213a(sSOUserInformationEntry.countryCode);
                return;
            }
            C4904y.m18639b("fail to get to user information", getClass().getSimpleName());
            if (GlobalApplication.m18732r() != null) {
                InterfaceC4936e interfaceC4936eMo18745a = AbstractC4932a.m18733a(this.f12328a.f12319m).mo18740a(this.f12328a.f12319m.getResources().getString(R.string.toast_error)).mo18749b(this.f12328a.f12319m.getResources().getString(R.string.toast_network_unable)).mo18756d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC3373by(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3372bx(this)).mo18745a();
                interfaceC4936eMo18745a.setCancelable(false);
                if (!this.f12328a.f12324r) {
                    interfaceC4936eMo18745a.show();
                    return;
                }
                return;
            }
            return;
        }
        if (message.what == 2002) {
            if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                if (this.f12328a.f12321o != null && this.f12328a.f12321o.isShowing()) {
                    this.f12328a.f12321o.dismiss();
                }
                C4904y.m18639b("fail to get to access token", getClass().getSimpleName());
                if (GlobalApplication.m18732r() != null) {
                    InterfaceC4936e interfaceC4936eMo18745a2 = AbstractC4932a.m18733a(this.f12328a.f12319m).mo18740a(this.f12328a.f12319m.getResources().getString(R.string.toast_error)).mo18749b(this.f12328a.f12319m.getResources().getString(R.string.toast_network_unable)).mo18756d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC3376ca(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3374bz(this)).mo18745a();
                    interfaceC4936eMo18745a2.setCancelable(false);
                    if (!this.f12328a.f12324r) {
                        interfaceC4936eMo18745a2.show();
                        return;
                    }
                    return;
                }
                return;
            }
            SSOAccessTokenEntry sSOAccessTokenEntry = (SSOAccessTokenEntry) c0778b.m3110e();
            C4904y.m18639b("accessToken : " + sSOAccessTokenEntry, getClass().getSimpleName());
            if (TextUtils.isEmpty(sSOAccessTokenEntry.access_token) || TextUtils.isEmpty(sSOAccessTokenEntry.userId)) {
                if (this.f12328a.f12321o != null && this.f12328a.f12321o.isShowing()) {
                    this.f12328a.f12321o.dismiss();
                }
                MainActivity.m13076a(this.f12328a.f12319m, EnumC3327af.normal);
                return;
            }
            this.f12328a.f12314h = sSOAccessTokenEntry.access_token;
            this.f12328a.f12315i = sSOAccessTokenEntry.userId;
            C4809aa.m18108a("samsung_account_token", this.f12328a.f12314h);
            this.f12328a.f12317k.m9392b(this.f12328a.f12314h, "fs24s8z0hh", this.f12328a.f12315i);
        }
    }
}
