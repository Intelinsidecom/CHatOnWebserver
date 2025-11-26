package com.sec.chaton.settings;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.C0096i;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.sec.chaton.R;
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

/* compiled from: AboutServiceFragment.java */
/* renamed from: com.sec.chaton.settings.d */
/* loaded from: classes.dex */
class HandlerC3563d extends Handler {

    /* renamed from: a */
    final /* synthetic */ AboutServiceFragment f13052a;

    HandlerC3563d(AboutServiceFragment aboutServiceFragment) {
        this.f13052a = aboutServiceFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Throwable {
        if (this.f13052a.getActivity() != null) {
            C0778b c0778b = (C0778b) message.obj;
            switch (message.what) {
                case 1104:
                    if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                        GetVersionNotice getVersionNotice = (GetVersionNotice) c0778b.m3110e();
                        if (getVersionNotice != null && getVersionNotice.uptodate != null) {
                            if (getVersionNotice.uptodate.booleanValue()) {
                                C4822an.m18256x();
                                this.f13052a.m13309c();
                                break;
                            } else {
                                if (getVersionNotice.critical != null && getVersionNotice.critical.booleanValue()) {
                                    new C2122ca(this.f13052a.f12446g).m9472c();
                                    this.f13052a.f12463y = getVersionNotice;
                                    this.f13052a.f12464z = true;
                                }
                                View childAt = this.f13052a.f12450k.getChildAt(0);
                                if (childAt != null && this.f13052a.getActivity() != null) {
                                    this.f13052a.f12443b[0] = getVersionNotice.newversion;
                                    this.f13052a.f12457s[0] = (TextView) childAt.findViewById(R.id.service_current_ver);
                                    this.f13052a.f12458t[0] = (TextView) childAt.findViewById(R.id.service_latest_ver);
                                    this.f13052a.f12459u[0] = (Button) childAt.findViewById(R.id.button_update);
                                    this.f13052a.f12457s[0].setText(this.f13052a.getActivity().getResources().getString(R.string.setting_about_current_ver) + " " + this.f13052a.f12442a[0]);
                                    this.f13052a.f12458t[0].setText(this.f13052a.getActivity().getResources().getString(R.string.setting_about_latest_ver) + " " + (this.f13052a.f12443b[0].length() > 0 ? this.f13052a.f12443b[0] : this.f13052a.f12442a[0]));
                                    this.f13052a.f12459u[0].setEnabled(true);
                                    this.f13052a.m13302a(0);
                                }
                                C4809aa.m18104a().m18128b("UpdateTargetVersion", getVersionNotice.newversion);
                                C4809aa.m18104a().m18125b("UpdateIsCritical", getVersionNotice.critical);
                                C4809aa.m18104a().m18125b("UpdateIsNormal", getVersionNotice.uptodate);
                                C4809aa.m18104a().m18128b("UpdateUrl", getVersionNotice.downloadurl);
                                C4809aa.m18104a().m18128b("SamsungappsUrl", getVersionNotice.samsungappsurl);
                                C0096i.m358a(this.f13052a.f12452m).m363a(new Intent("more_tab_badge_update"));
                                break;
                            }
                        }
                    } else if (C4904y.f17872b) {
                        C4904y.m18639b("network fail to get version", AboutServiceFragment.f12441o);
                        break;
                    }
                    break;
                case 1106:
                    AvaliableApps avaliableApps = (AvaliableApps) c0778b.m3110e();
                    if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR && avaliableApps.resultCode.equals(Spam.ACTIVITY_CHECK)) {
                        C4809aa.m18105a("spp_update_is", (Boolean) true);
                        View childAt2 = C4859bx.m18386a(this.f13052a.f12452m) ? this.f13052a.f12450k.getChildAt(2) : this.f13052a.f12450k.getChildAt(1);
                        if (childAt2 != null && this.f13052a.getActivity() != null) {
                            this.f13052a.f12457s[AboutServiceFragment.f12440e] = (TextView) childAt2.findViewById(R.id.service_current_ver);
                            if (this.f13052a.f12457s[AboutServiceFragment.f12440e] != null) {
                                this.f13052a.f12458t[AboutServiceFragment.f12440e] = (TextView) childAt2.findViewById(R.id.service_latest_ver);
                                this.f13052a.f12459u[AboutServiceFragment.f12440e] = (Button) childAt2.findViewById(R.id.button_update);
                                if (TextUtils.isEmpty(avaliableApps.version)) {
                                    this.f13052a.f12458t[AboutServiceFragment.f12440e].setVisibility(8);
                                } else {
                                    C4809aa.m18108a("spp_latest_ver", avaliableApps.version);
                                    this.f13052a.f12458t[AboutServiceFragment.f12440e].setText(this.f13052a.getActivity().getResources().getString(R.string.setting_about_latest_ver) + " " + avaliableApps.version);
                                }
                                this.f13052a.f12459u[AboutServiceFragment.f12440e].setEnabled(true);
                                this.f13052a.m13302a(AboutServiceFragment.f12440e);
                                break;
                            }
                        }
                    } else {
                        C4904y.m18639b("There is no update of SPPPushClient.", AboutServiceFragment.f12441o);
                        break;
                    }
                    break;
            }
        }
    }
}
