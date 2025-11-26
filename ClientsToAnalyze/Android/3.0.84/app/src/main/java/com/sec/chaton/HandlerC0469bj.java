package com.sec.chaton;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.C1324bj;
import com.sec.chaton.p035io.entry.AvaliableApps;
import com.sec.chaton.p035io.entry.GetVersionNotice;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3250y;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.bj */
/* loaded from: classes.dex */
class HandlerC0469bj extends Handler {

    /* renamed from: a */
    final /* synthetic */ TabActivity f1537a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC0469bj(TabActivity tabActivity, Looper looper) {
        super(looper);
        this.f1537a = tabActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Throwable {
        GetVersionNotice getVersionNotice;
        if (!this.f1537a.f802z) {
            C0267d c0267d = (C0267d) message.obj;
            if (message.what == 1104) {
                if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR && (getVersionNotice = (GetVersionNotice) c0267d.m1354e()) != null && getVersionNotice.uptodate != null) {
                    if (getVersionNotice.uptodate.booleanValue()) {
                        this.f1537a.m1206G();
                    } else if (C3214cb.m11261b()) {
                        this.f1537a.f801y = getVersionNotice;
                        new C1324bj(this.f1537a.f782d).m5695c();
                    } else if (this.f1537a.m1201D()) {
                        this.f1537a.f745L = true;
                        this.f1537a.f801y = getVersionNotice;
                    } else {
                        C3171am.m11049a(getVersionNotice, this.f1537a, true, "NO");
                    }
                    String strM1204F = this.f1537a.m1204F();
                    C3250y.m11450b("Disclaimer statue : " + strM1204F, TabActivity.f732f);
                    if (getVersionNotice.uptodate.booleanValue() || !getVersionNotice.critical.booleanValue()) {
                        if (!strM1204F.equals("RUN")) {
                            if (getVersionNotice.needPopup.booleanValue() && getVersionNotice.disclaimerUID != null) {
                                if (!this.f1537a.m1201D()) {
                                    this.f1537a.m1242a(getVersionNotice.disclaimerUID);
                                } else {
                                    this.f1537a.f748O = true;
                                    this.f1537a.f801y = getVersionNotice;
                                }
                            } else {
                                C3250y.m11450b("needPopup or disclaimerUID is null", TabActivity.f732f);
                            }
                        } else {
                            C3250y.m11455d("Disclaimer State is running", TabActivity.f732f);
                        }
                        if (!C3159aa.m10962a().m10987b("is_first_accept")) {
                            C3250y.m11450b("Accept time : " + C3159aa.m10962a().m10979a("accept_time", "") + " Server time: " + C3159aa.m10962a().m10979a("server_time", ""), TabActivity.f732f);
                            C3159aa.m10966a("accept_time", C3159aa.m10962a().m10979a("server_time", ""));
                            C3159aa.m10963a("is_first_accept", (Boolean) true);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            if (message.what == 1106) {
                AvaliableApps avaliableApps = (AvaliableApps) c0267d.m1354e();
                if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR || avaliableApps.resultCode == null || !avaliableApps.resultCode.equals("2")) {
                    if (!this.f1537a.m1201D()) {
                        C3171am.m11049a(this.f1537a.f801y, this.f1537a, true, "NO");
                    } else {
                        this.f1537a.f745L = true;
                    }
                    if (C3250y.f11734b) {
                        C3250y.m11450b("Samsung apps is NOT ready to upgrade chaton", TabActivity.f732f);
                        return;
                    }
                    return;
                }
                C3159aa.m10962a().m10986b("UpdateAppsReady", "YES");
                if (!this.f1537a.m1201D()) {
                    C3171am.m11049a(this.f1537a.f801y, this.f1537a, true, "YES");
                } else {
                    this.f1537a.f745L = true;
                }
                if (C3250y.f11734b) {
                    C3250y.m11450b("Samsung apps is ready to upgrade chaton", TabActivity.f732f);
                }
            }
        }
    }
}
