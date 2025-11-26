package com.sec.chaton.trunk;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.trunk.p060b.C2990d;
import com.sec.chaton.trunk.p060b.C2991e;
import com.sec.chaton.trunk.p060b.C2992f;
import com.sec.chaton.trunk.p061c.EnumC3026g;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;

/* compiled from: TrunkFullView.java */
/* renamed from: com.sec.chaton.trunk.aq */
/* loaded from: classes.dex */
class HandlerC2976aq extends Handler {

    /* renamed from: a */
    final /* synthetic */ TrunkFullView f10776a;

    HandlerC2976aq(TrunkFullView trunkFullView) {
        this.f10776a = trunkFullView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f10776a.isDetached()) {
            if (C3250y.f11736d) {
                C3250y.m11455d("Fragment had been detached.", TrunkFullView.f10521c);
            }
            return;
        }
        switch (message.what) {
            case 2:
                C2991e c2991e = (C2991e) message.obj;
                String str = (String) c2991e.m10491a();
                if (this.f10776a.f10559u != null && this.f10776a.f10559u.equals(str)) {
                    this.f10776a.f10562x = false;
                    ViewOnClickListenerC3064r.m10592a(this.f10776a.f10553o, c2991e.m10494b(), c2991e.m10496c(), false);
                    this.f10776a.mo10241a(this.f10776a.f10555q, null, this.f10776a.f10559u);
                }
                this.f10776a.m10230k();
                break;
            case 3:
                String str2 = (String) ((C2990d) message.obj).m10491a();
                if (this.f10776a.f10559u != null && this.f10776a.f10559u.equals(str2)) {
                    this.f10776a.f10562x = false;
                }
                this.f10776a.m10230k();
                break;
            case 4:
                String str3 = (String) ((C2992f) message.obj).m10491a();
                if (this.f10776a.f10559u != null && this.f10776a.f10559u.equals(str3)) {
                    this.f10776a.f10561w = true;
                    this.f10776a.f10562x = false;
                    this.f10776a.f10540a.setImageBitmap(null);
                    this.f10776a.m10212b(false);
                    if (this.f10776a.f10555q == EnumC3026g.IMAGE) {
                        this.f10776a.f10547i.setVisibility(8);
                        this.f10776a.f10546h.setVisibility(0);
                    } else if (this.f10776a.f10555q == EnumC3026g.VIDEO) {
                        this.f10776a.f10546h.setVisibility(8);
                        this.f10776a.f10547i.setVisibility(0);
                    }
                    C3641ai.m13211a(this.f10776a.m10223h(), this.f10776a.m10223h().getResources().getString(R.string.toast_network_unable), 1).show();
                }
                this.f10776a.m10230k();
                break;
            case 901:
                C0267d c0267d = (C0267d) message.obj;
                if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
                    this.f10776a.f10560v = false;
                    break;
                } else {
                    this.f10776a.f10560v = true;
                    if (c0267d.m1355f() == 86411) {
                        this.f10776a.m10233m();
                        break;
                    } else {
                        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
                        if (-3 == iM6733a || -2 == iM6733a) {
                            this.f10776a.m10232l();
                            break;
                        } else {
                            C3641ai.m13210a(this.f10776a.m10223h(), R.string.toast_network_unable, 1).show();
                            break;
                        }
                    }
                }
            case 905:
                C0267d c0267d2 = (C0267d) message.obj;
                if (this.f10776a.f10550l != null) {
                    this.f10776a.f10550l.dismiss();
                }
                if (c0267d2.m1351b() == EnumC1587o.SUCCESS) {
                    C3641ai.m13210a(this.f10776a.m10223h(), R.string.trunk_toast_deleted, 1).show();
                    if (this.f10776a.f10543e != null) {
                        this.f10776a.f10543e.mo10359a();
                        break;
                    }
                } else {
                    int iM6733a2 = C1594v.m6733a(CommonApplication.m11493l());
                    if (-3 == iM6733a2 || -2 == iM6733a2) {
                        this.f10776a.m10232l();
                        break;
                    } else if (c0267d2.m1355f() == 80210) {
                        C3641ai.m13210a(this.f10776a.m10223h(), R.string.buddy_information_changed, 1).show();
                        break;
                    } else {
                        C3641ai.m13210a(this.f10776a.m10223h(), R.string.toast_network_unable, 1).show();
                        break;
                    }
                }
                break;
        }
    }
}
