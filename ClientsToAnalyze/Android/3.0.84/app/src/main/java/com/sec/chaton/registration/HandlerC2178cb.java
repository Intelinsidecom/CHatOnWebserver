package com.sec.chaton.registration;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.AvaliableApps;
import com.sec.chaton.p035io.entry.GetVersionNotice;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;

/* compiled from: FragmentGlobalDisclaimer.java */
/* renamed from: com.sec.chaton.registration.cb */
/* loaded from: classes.dex */
class HandlerC2178cb extends Handler {

    /* renamed from: a */
    final /* synthetic */ FragmentGlobalDisclaimer f8464a;

    HandlerC2178cb(FragmentGlobalDisclaimer fragmentGlobalDisclaimer) {
        this.f8464a = fragmentGlobalDisclaimer;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Throwable {
        if (this.f8464a.getActivity() != null) {
            C0267d c0267d = (C0267d) message.obj;
            switch (message.what) {
                case 104:
                    if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                        this.f8464a.f8217e.m5694b();
                        break;
                    } else if (c0267d.m1355f() == 44002 || c0267d.m1355f() == 44001) {
                        this.f8464a.m8524c();
                        C3250y.m11455d("server sent error cause by WRONG_PARAMETER_VALUE", FragmentGlobalDisclaimer.f8212g);
                        AbstractC3271a.m11494a(this.f8464a.getActivity()).mo11500a(this.f8464a.getResources().getString(R.string.toast_error)).mo11509b(this.f8464a.getResources().getString(R.string.toast_network_unable)).mo11515d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC2179cc(this)).mo11505a().show();
                        break;
                    } else if (this.f8464a.getActivity() != null) {
                        AbstractC3271a.m11494a(this.f8464a.getActivity()).mo11500a(this.f8464a.getResources().getString(R.string.toast_error)).mo11509b(this.f8464a.getResources().getString(R.string.toast_network_unable)).mo11515d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC2180cd(this)).mo11505a().show();
                        C3250y.m11442a("[Dev]GLD failed. httpStatus: " + c0267d.m1358i() + ", FaultCode: " + c0267d.m1355f() + ", Message: " + c0267d.m1357h(), FragmentGlobalDisclaimer.f8212g);
                        this.f8464a.m8524c();
                        break;
                    }
                    break;
                case 1104:
                    if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                        this.f8464a.m8521a(EnumC2187ck.version_for_upgrade, c0267d.m1356g());
                        break;
                    } else {
                        GetVersionNotice getVersionNotice = (GetVersionNotice) c0267d.m1354e();
                        if (getVersionNotice == null) {
                            this.f8464a.m8521a(EnumC2187ck.version_for_upgrade, c0267d.m1356g());
                            break;
                        } else if (getVersionNotice.uptodate == null || getVersionNotice.uptodate.booleanValue()) {
                            this.f8464a.f8217e.m5693a("FIRST");
                            break;
                        } else if (C3214cb.m11261b()) {
                            this.f8464a.f8218f = getVersionNotice;
                            this.f8464a.f8217e.m5695c();
                            break;
                        } else {
                            this.f8464a.m8524c();
                            C3171am.m11049a(getVersionNotice, this.f8464a.getActivity(), false, "NO");
                            break;
                        }
                    }
                case 1105:
                    if (this.f8464a.f8215c != null && this.f8464a.f8215c.isShowing()) {
                        this.f8464a.f8215c.dismiss();
                    }
                    if ((c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) || c0267d.m1355f() == 42001) {
                        C3159aa.m10966a("first_disclaimer_status", "DONE");
                        try {
                            this.f8464a.f8214b.execute(new Void[0]);
                        } catch (IllegalStateException e) {
                            C3250y.m11450b("the task is already running or finished", FragmentGlobalDisclaimer.f8212g);
                        }
                        C3159aa.m10962a().m10986b("provisioning_disclaimer_status", "DONE");
                        if (C3171am.m11060d() != null) {
                            C3159aa.m10962a().m10986b("accept_disclaimer_iso", C3171am.m11060d().toUpperCase());
                        }
                        this.f8464a.getActivity().setResult(-1, new Intent());
                        this.f8464a.getActivity().finish();
                        break;
                    } else if (this.f8464a.getActivity() != null) {
                        AbstractC3271a.m11494a(this.f8464a.getActivity()).mo11500a(this.f8464a.getResources().getString(R.string.toast_error)).mo11509b(this.f8464a.getResources().getString(R.string.toast_network_unable)).mo11515d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC2181ce(this)).mo11505a().show();
                        C3250y.m11442a("[Dev]Accept Disclaimer failed. httpStatus: " + c0267d.m1358i() + ", FaultCode: " + c0267d.m1355f() + ", Message: " + c0267d.m1357h(), FragmentGlobalDisclaimer.f8212g);
                        break;
                    }
                    break;
                case 1106:
                    AvaliableApps avaliableApps = (AvaliableApps) c0267d.m1354e();
                    if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR || avaliableApps.resultCode == null || !avaliableApps.resultCode.equals("2")) {
                        C3171am.m11049a(this.f8464a.f8218f, this.f8464a.getActivity(), false, "NO");
                        if (C3250y.f11734b) {
                            C3250y.m11450b("Samsung apps is NOT ready to upgrade chaton", FragmentGlobalDisclaimer.f8212g);
                            break;
                        }
                    } else {
                        C3171am.m11049a(this.f8464a.f8218f, this.f8464a.getActivity(), false, "YES");
                        if (C3250y.f11734b) {
                            C3250y.m11450b("Samsung apps is ready to upgrade chaton", FragmentGlobalDisclaimer.f8212g);
                            break;
                        }
                    }
                    break;
            }
        }
    }
}
