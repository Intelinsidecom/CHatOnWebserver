package com.sec.chaton.settings;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.p033io.entry.GetVersion;
import com.sec.chaton.util.C1341p;
import com.sec.widget.C1619g;

/* compiled from: AboutFragment.java */
/* renamed from: com.sec.chaton.settings.ag */
/* loaded from: classes.dex */
class HandlerC1009ag extends Handler {

    /* renamed from: a */
    final /* synthetic */ AboutFragment f3613a;

    HandlerC1009ag(AboutFragment aboutFragment) {
        this.f3613a = aboutFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f3613a.f3414k.dismiss();
        C0259g c0259g = (C0259g) message.obj;
        switch (message.what) {
            case 1101:
                if (c0259g.m927a() && c0259g.m928b() != EnumC0518y.ERROR) {
                    GetVersion getVersion = (GetVersion) c0259g.m932d();
                    this.f3613a.f3405b = getVersion.newversion;
                    this.f3613a.f3406c = getVersion.critical;
                    this.f3613a.f3407d = getVersion.uptodate;
                    this.f3613a.f3408e = getVersion.downloadurl;
                    C1341p.m4662e("str_current_version : " + this.f3613a.f3404a + ",   :str_upgrade_version : " + this.f3613a.f3405b + "  :critical :" + this.f3613a.f3406c + "  :update :" + this.f3613a.f3407d + "  :downloadurl :" + this.f3613a.f3408e, getClass().getSimpleName());
                    this.f3613a.f3412i.setOnClickListener(new ViewOnClickListenerC1070cn(this));
                    if (this.f3613a.f3405b != null && !this.f3613a.f3404a.equals(this.f3613a.f3405b)) {
                        this.f3613a.f3411h.setVisibility(0);
                        this.f3613a.f3412i.setVisibility(0);
                        if (this.f3613a.f3406c.booleanValue()) {
                            this.f3613a.f3411h.setTextColor(-65536);
                            this.f3613a.f3411h.setText(this.f3613a.getString(R.string.setting_about_latest_ver) + " " + this.f3613a.f3405b + " (Critical)");
                            break;
                        } else {
                            this.f3613a.f3411h.setTextColor(-1);
                            this.f3613a.f3411h.setText(this.f3613a.getString(R.string.setting_about_latest_ver) + " " + this.f3613a.f3405b);
                            break;
                        }
                    }
                } else {
                    C1619g.m5889a(this.f3613a.getActivity(), "[Dev]Get  Version Failed", 0).show();
                    break;
                }
                break;
        }
    }
}
