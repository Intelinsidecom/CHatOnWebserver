package com.sec.chaton.registration;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.AvaliableApps;
import com.sec.chaton.p065io.entry.GetVersionNotice;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: FragmentDisclaimerGlobal.java */
/* renamed from: com.sec.chaton.registration.bu */
/* loaded from: classes.dex */
class HandlerC3179bu extends Handler {

    /* renamed from: a */
    final /* synthetic */ FragmentDisclaimerGlobal f11931a;

    HandlerC3179bu(FragmentDisclaimerGlobal fragmentDisclaimerGlobal) {
        this.f11931a = fragmentDisclaimerGlobal;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Throwable {
        if (this.f11931a.getActivity() != null) {
            C0778b c0778b = (C0778b) message.obj;
            switch (message.what) {
                case 104:
                    if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                        this.f11931a.m12846b();
                        break;
                    } else if (c0778b.m3111f() == 44002 || c0778b.m3111f() == 44001) {
                        this.f11931a.m12843f();
                        C4904y.m18645d("server sent error cause by WRONG_PARAMETER_VALUE", FragmentDisclaimerGlobal.f11626q);
                        AbstractC4932a.m18733a(this.f11931a.getActivity()).mo18740a(this.f11931a.getResources().getString(R.string.toast_error)).mo18749b(this.f11931a.getResources().getString(R.string.toast_network_unable)).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC3180bv(this)).mo18745a().show();
                        break;
                    } else {
                        this.f11931a.m12837a(EnumC3184bz.get_server_address, c0778b.m3112g());
                        C4904y.m18634a("[Dev]GLD failed. httpStatus: " + c0778b.m3114i() + ", FaultCode: " + c0778b.m3111f() + ", Message: " + c0778b.m3113h(), FragmentDisclaimerGlobal.f11626q);
                        break;
                    }
                    break;
                case 1104:
                    if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                        this.f11931a.m12837a(EnumC3184bz.version_for_upgrade, c0778b.m3112g());
                        break;
                    } else {
                        GetVersionNotice getVersionNotice = (GetVersionNotice) c0778b.m3110e();
                        if (getVersionNotice == null) {
                            this.f11931a.m12837a(EnumC3184bz.version_for_upgrade, c0778b.m3112g());
                            break;
                        } else if (getVersionNotice.uptodate == null || getVersionNotice.uptodate.booleanValue()) {
                            this.f11931a.f11641o.m9470a("FIRST");
                            break;
                        } else if (C4859bx.m18393b()) {
                            this.f11931a.f11642p = getVersionNotice;
                            this.f11931a.f11641o.m9472c();
                            break;
                        } else {
                            this.f11931a.m12843f();
                            C4822an.m18213a(getVersionNotice, this.f11931a.getActivity(), false, "NO");
                            break;
                        }
                    }
                    break;
                case 1105:
                    if (this.f11931a.f11640n != null && this.f11931a.f11640n.isShowing()) {
                        this.f11931a.f11640n.dismiss();
                    }
                    if ((c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) || c0778b.m3111f() == 42001) {
                        try {
                            this.f11931a.f11635i.execute(new Void[0]);
                        } catch (IllegalStateException e) {
                            C4904y.m18639b("the task is already running or finished", FragmentDisclaimerGlobal.f11626q);
                        }
                        if (C4822an.m18236g() != null) {
                            C4809aa.m18104a().m18128b("accept_disclaimer_iso", C4822an.m18236g().toUpperCase());
                        }
                        this.f11931a.m12848d();
                        if (!C4809aa.m18104a().m18129b("country_letter") && C4822an.m18236g() != null) {
                            C4809aa.m18108a("country_letter", C4822an.m18236g().toUpperCase());
                        }
                        C4809aa.m18104a().m18128b("provisioning_disclaimer_status", "DONE");
                        this.f11931a.getActivity().setResult(-1, new Intent());
                        this.f11931a.getActivity().finish();
                        break;
                    } else if (this.f11931a.getActivity() != null) {
                        this.f11931a.m12837a(EnumC3184bz.accept_disclaimer, c0778b.m3112g());
                        C4904y.m18634a("[Dev]Accept Disclaimer failed. httpStatus: " + c0778b.m3114i() + ", FaultCode: " + c0778b.m3111f() + ", Message: " + c0778b.m3113h(), FragmentDisclaimerGlobal.f11626q);
                        break;
                    }
                    break;
                case 1106:
                    AvaliableApps avaliableApps = (AvaliableApps) c0778b.m3110e();
                    if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR || avaliableApps.resultCode == null || !avaliableApps.resultCode.equals(Spam.ACTIVITY_CHECK)) {
                        C4822an.m18213a(this.f11931a.f11642p, this.f11931a.getActivity(), false, "NO");
                        if (C4904y.f17872b) {
                            C4904y.m18639b("Samsung apps is NOT ready to upgrade chaton", FragmentDisclaimerGlobal.f11626q);
                            break;
                        }
                    } else {
                        C4822an.m18213a(this.f11931a.f11642p, this.f11931a.getActivity(), false, "YES");
                        if (C4904y.f17872b) {
                            C4904y.m18639b("Samsung apps is ready to upgrade chaton", FragmentDisclaimerGlobal.f11626q);
                            break;
                        }
                    }
                    break;
            }
        }
    }
}
