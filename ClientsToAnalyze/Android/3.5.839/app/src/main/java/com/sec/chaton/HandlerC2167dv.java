package com.sec.chaton;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.C2122ca;
import com.sec.chaton.p065io.entry.AvaliableApps;
import com.sec.chaton.p065io.entry.GetVersionNotice;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.dv */
/* loaded from: classes.dex */
class HandlerC2167dv extends Handler {

    /* renamed from: a */
    final /* synthetic */ TabActivity f7796a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC2167dv(TabActivity tabActivity, Looper looper) {
        super(looper);
        this.f7796a = tabActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Throwable {
        GetVersionNotice getVersionNotice;
        if (!this.f7796a.f2044M) {
            C0778b c0778b = (C0778b) message.obj;
            if (message.what == 1104) {
                if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR && (getVersionNotice = (GetVersionNotice) c0778b.m3110e()) != null && getVersionNotice.uptodate != null) {
                    if (getVersionNotice.uptodate.booleanValue()) {
                        this.f7796a.m3007K();
                    } else if (C4859bx.m18393b()) {
                        this.f7796a.f2043L = getVersionNotice;
                        new C2122ca(this.f7796a.f2092r).m9472c();
                    } else if (this.f7796a.m3004H()) {
                        this.f7796a.f2046O = true;
                        this.f7796a.f2043L = getVersionNotice;
                    } else {
                        C4822an.m18214a(getVersionNotice, this.f7796a, true, "NO", false);
                    }
                    String strM3006J = this.f7796a.m3006J();
                    C4904y.m18639b("Disclaimer statue : " + strM3006J, TabActivity.f2029t);
                    if (getVersionNotice.uptodate.booleanValue() || !getVersionNotice.critical.booleanValue()) {
                        if (!strM3006J.equals("RUN")) {
                            if (getVersionNotice.needPopup.booleanValue() && getVersionNotice.disclaimerUID != null) {
                                if (!this.f7796a.m3004H()) {
                                    this.f7796a.m3030b(getVersionNotice.disclaimerUID);
                                } else {
                                    this.f7796a.f2049R = true;
                                    this.f7796a.f2043L = getVersionNotice;
                                }
                            } else {
                                C4904y.m18639b("needPopup or disclaimerUID is null", TabActivity.f2029t);
                            }
                        } else {
                            C4904y.m18645d("Disclaimer State is running", TabActivity.f2029t);
                        }
                        if (!C4809aa.m18104a().m18129b("is_first_accept")) {
                            C4904y.m18639b("Accept time : " + C4809aa.m18104a().m18121a("accept_time", "") + " Server time: " + C4809aa.m18104a().m18121a("server_time", ""), TabActivity.f2029t);
                            if (C4809aa.m18104a().m18121a("server_time", (String) null) != null) {
                                C4809aa.m18108a("accept_time", C4809aa.m18104a().m18121a("server_time", ""));
                            }
                            C4809aa.m18105a("is_first_accept", (Boolean) true);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            if (message.what == 1106) {
                AvaliableApps avaliableApps = (AvaliableApps) c0778b.m3110e();
                if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR || avaliableApps.resultCode == null || !avaliableApps.resultCode.equals(Spam.ACTIVITY_CHECK)) {
                    if (!this.f7796a.m3004H()) {
                        C4822an.m18214a(this.f7796a.f2043L, this.f7796a, true, "NO", false);
                    } else {
                        this.f7796a.f2046O = true;
                    }
                    if (C4904y.f17872b) {
                        C4904y.m18639b("Samsung apps is NOT ready to upgrade chaton", TabActivity.f2029t);
                        return;
                    }
                    return;
                }
                C4809aa.m18104a().m18128b("UpdateAppsReady", "YES");
                if (!this.f7796a.m3004H()) {
                    C4822an.m18214a(this.f7796a.f2043L, this.f7796a, true, "YES", false);
                } else {
                    this.f7796a.f2046O = true;
                }
                if (C4904y.f17872b) {
                    C4904y.m18639b("Samsung apps is ready to upgrade chaton", TabActivity.f2029t);
                    return;
                }
                return;
            }
            if (message.what == 1105) {
                if (c0778b.m18954n() && (c0778b.m3107b() != EnumC2464o.ERROR || c0778b.m3111f() == 42001)) {
                    C4809aa.m18104a().m18128b("first_disclaimer_status", "DONE");
                    if (C4904y.f17872b) {
                        C4904y.m18639b("Success - AcceptDisclaimer in Lite User", TabActivity.f2029t);
                        return;
                    }
                    return;
                }
                if (C4904y.f17872b) {
                    C4904y.m18639b("Fail - AcceptDisclaimer in Lite User", TabActivity.f2029t);
                }
            }
        }
    }
}
