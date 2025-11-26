package com.sec.chaton.settings;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1058ba;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.mobileweb.C2602p;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4894o;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;

/* compiled from: DeregisterFragment.java */
/* renamed from: com.sec.chaton.settings.eb */
/* loaded from: classes.dex */
class HandlerC3592eb extends Handler {

    /* renamed from: a */
    final /* synthetic */ DeregisterFragment f13113a;

    HandlerC3592eb(DeregisterFragment deregisterFragment) {
        this.f13113a = deregisterFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f13113a.getActivity() != null) {
            C0778b c0778b = (C0778b) message.obj;
            switch (message.what) {
                case 202:
                    this.f13113a.m13549c();
                    if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR || this.f13113a.f12673j == null || !this.f13113a.f12673j.m9091e()) {
                        this.f13113a.m13552d();
                        C4904y.m18634a("ChatON deregistration is fail.", DeregisterFragment.f12663p);
                        break;
                    } else {
                        C4904y.m18639b("ChatON deregistration is success.", DeregisterFragment.f12663p);
                        C2602p.m11022d();
                        if (this.f13113a.f12677n) {
                            C5179v.m19811a(this.f13113a.getActivity(), this.f13113a.getResources().getString(R.string.toast_account_deleted2), 0).show();
                        } else {
                            C5179v.m19811a(this.f13113a.getActivity(), this.f13113a.getResources().getString(R.string.toast_account_deleted), 0).show();
                        }
                        C4894o.m18606a(GlobalApplication.m18732r().getApplicationInfo().dataDir);
                        C0991aa.m6037a().m18962d(new C1058ba());
                        break;
                    }
                case 2007:
                case 2008:
                    this.f13113a.m13549c();
                    if (c0778b == null || !c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                        this.f13113a.m13552d();
                        break;
                    } else if (this.f13113a.getActivity() != null) {
                        this.f13113a.getActivity().setResult(-1);
                        this.f13113a.getActivity().finish();
                        break;
                    }
                    break;
            }
        }
    }
}
