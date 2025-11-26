package com.sec.chaton.settings;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.UpgradeDialog;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.AvaliableApps;
import com.sec.chaton.p035io.entry.GetVersionNotice;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3250y;

/* compiled from: AboutServiceFragment.java */
/* renamed from: com.sec.chaton.settings.d */
/* loaded from: classes.dex */
class HandlerC2493d extends Handler {

    /* renamed from: a */
    final /* synthetic */ AboutServiceFragment f9383a;

    HandlerC2493d(AboutServiceFragment aboutServiceFragment) {
        this.f9383a = aboutServiceFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f9383a.getActivity() != null) {
            C0267d c0267d = (C0267d) message.obj;
            switch (message.what) {
                case 1104:
                    if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                        GetVersionNotice getVersionNotice = (GetVersionNotice) c0267d.m1354e();
                        if (getVersionNotice != null && getVersionNotice.uptodate != null) {
                            if (getVersionNotice.uptodate.booleanValue()) {
                                C3171am.m11081s();
                                this.f9383a.m8922c();
                                break;
                            } else {
                                if (getVersionNotice.critical != null && getVersionNotice.critical.booleanValue()) {
                                    Intent intent = new Intent(this.f9383a.getActivity(), (Class<?>) UpgradeDialog.class);
                                    intent.putExtra("isCritical", true);
                                    this.f9383a.startActivity(intent);
                                }
                                View childAt = this.f9383a.f8920k.getChildAt(0);
                                if (childAt != null && this.f9383a.getActivity() != null) {
                                    this.f9383a.f8927s[0] = (TextView) childAt.findViewById(R.id.service_current_ver);
                                    this.f9383a.f8928t[0] = (TextView) childAt.findViewById(R.id.service_latest_ver);
                                    this.f9383a.f8929u[0] = (Button) childAt.findViewById(R.id.button_update);
                                    this.f9383a.f8927s[0].setText(this.f9383a.getActivity().getResources().getString(R.string.setting_about_current_ver) + " " + this.f9383a.f8912a[0]);
                                    this.f9383a.f8928t[0].setText(this.f9383a.getActivity().getResources().getString(R.string.setting_about_latest_ver) + " " + (this.f9383a.f8913b[0].length() > 0 ? this.f9383a.f8913b[0] : this.f9383a.f8912a[0]));
                                    this.f9383a.f8929u[0].setEnabled(true);
                                    this.f9383a.m8915a(0);
                                }
                                C3159aa.m10962a().m10986b("UpdateTargetVersion", getVersionNotice.newversion);
                                C3159aa.m10962a().m10983b("UpdateIsCritical", getVersionNotice.critical);
                                C3159aa.m10962a().m10983b("UpdateIsNormal", getVersionNotice.uptodate);
                                C3159aa.m10962a().m10986b("UpdateUrl", getVersionNotice.downloadurl);
                                C3159aa.m10962a().m10986b("SamsungappsUrl", getVersionNotice.samsungappsurl);
                                LocalBroadcastManager.getInstance(this.f9383a.f8922m).sendBroadcast(new Intent("more_tab_badge_update"));
                                break;
                            }
                        }
                    } else if (C3250y.f11734b) {
                        C3250y.m11450b("network fail to get version", AboutServiceFragment.f8911o);
                        break;
                    }
                    break;
                case 1106:
                    AvaliableApps avaliableApps = (AvaliableApps) c0267d.m1354e();
                    if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR && avaliableApps.resultCode.equals("2")) {
                        C3159aa.m10963a("spp_update_is", (Boolean) true);
                        View childAt2 = C3214cb.m11256a(this.f9383a.f8922m) ? this.f9383a.f8920k.getChildAt(2) : this.f9383a.f8920k.getChildAt(1);
                        if (childAt2 != null && this.f9383a.getActivity() != null) {
                            this.f9383a.f8927s[AboutServiceFragment.f8910e] = (TextView) childAt2.findViewById(R.id.service_current_ver);
                            if (this.f9383a.f8927s[AboutServiceFragment.f8910e] != null) {
                                this.f9383a.f8928t[AboutServiceFragment.f8910e] = (TextView) childAt2.findViewById(R.id.service_latest_ver);
                                this.f9383a.f8929u[AboutServiceFragment.f8910e] = (Button) childAt2.findViewById(R.id.button_update);
                                if (TextUtils.isEmpty(avaliableApps.version)) {
                                    this.f9383a.f8928t[AboutServiceFragment.f8910e].setVisibility(8);
                                } else {
                                    C3159aa.m10966a("spp_latest_ver", avaliableApps.version);
                                    this.f9383a.f8928t[AboutServiceFragment.f8910e].setText(this.f9383a.getActivity().getResources().getString(R.string.setting_about_latest_ver) + " " + avaliableApps.version);
                                }
                                this.f9383a.f8929u[AboutServiceFragment.f8910e].setEnabled(true);
                                this.f9383a.m8915a(AboutServiceFragment.f8910e);
                                break;
                            }
                        }
                    } else {
                        C3250y.m11450b("There is no update of SPPPushClient.", AboutServiceFragment.f8911o);
                        break;
                    }
                    break;
            }
        }
    }
}
