package com.sec.chaton.trunk;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.trunk.p120b.C4606d;
import com.sec.chaton.trunk.p120b.C4607e;
import com.sec.chaton.trunk.p120b.C4608f;
import com.sec.chaton.trunk.p121c.C4641f;
import com.sec.chaton.trunk.p121c.EnumC4642g;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: TrunkFullView.java */
/* renamed from: com.sec.chaton.trunk.at */
/* loaded from: classes.dex */
class HandlerC4595at extends Handler {

    /* renamed from: a */
    final /* synthetic */ TrunkFullView f16725a;

    HandlerC4595at(TrunkFullView trunkFullView) {
        this.f16725a = trunkFullView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f16725a.isDetached()) {
            if (C4904y.f17874d) {
                C4904y.m18645d("Fragment had been detached.", TrunkFullView.f16468b);
            }
            return;
        }
        switch (message.what) {
            case 2:
                C4607e c4607e = (C4607e) message.obj;
                String str = (String) c4607e.m17563a();
                if (this.f16725a.f16505t != null && this.f16725a.f16505t.equals(str)) {
                    this.f16725a.f16508w = false;
                    ViewOnClickListenerC4684r.m17686a(this.f16725a.f16499n, c4607e.m17566b(), c4607e.m17568c(), false);
                    this.f16725a.mo17339a(this.f16725a.f16501p, null, this.f16725a.f16505t);
                }
                this.f16725a.f16489d.mo17461d_(this.f16725a.f16480L);
                this.f16725a.m17328k();
                break;
            case 3:
                String str2 = (String) ((C4606d) message.obj).m17563a();
                if (this.f16725a.f16505t != null && this.f16725a.f16505t.equals(str2)) {
                    this.f16725a.f16508w = false;
                }
                this.f16725a.m17328k();
                break;
            case 4:
                String str3 = (String) ((C4608f) message.obj).m17563a();
                if (this.f16725a.f16505t != null && this.f16725a.f16505t.equals(str3)) {
                    this.f16725a.f16507v = true;
                    this.f16725a.f16508w = false;
                    this.f16725a.f16487a.setImageBitmap(null);
                    if (this.f16725a.f16501p == EnumC4642g.IMAGE) {
                        this.f16725a.f16493h.setVisibility(8);
                        this.f16725a.f16492g.setVisibility(0);
                        if (C4641f.m17617b(this.f16725a.f16505t)) {
                            this.f16725a.m17310b(true);
                        } else {
                            this.f16725a.m17310b(false);
                        }
                    } else if (this.f16725a.f16501p == EnumC4642g.VIDEO) {
                        this.f16725a.f16492g.setVisibility(8);
                        this.f16725a.f16493h.setVisibility(0);
                        this.f16725a.m17310b(true);
                    }
                    C5179v.m19811a(this.f16725a.m17321h(), this.f16725a.m17321h().getResources().getString(R.string.toast_network_unable), 1).show();
                }
                this.f16725a.m17328k();
                break;
            case 901:
                C0778b c0778b = (C0778b) message.obj;
                if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
                    this.f16725a.f16506u = false;
                    break;
                } else {
                    this.f16725a.f16506u = true;
                    if (c0778b.m3111f() == 86411) {
                        this.f16725a.m17332m();
                        break;
                    } else {
                        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
                        if (-3 == iM10677a || -2 == iM10677a) {
                            this.f16725a.m17330l();
                            break;
                        } else {
                            C5179v.m19810a(this.f16725a.m17321h(), R.string.toast_network_unable, 1).show();
                            break;
                        }
                    }
                }
            case 905:
                C0778b c0778b2 = (C0778b) message.obj;
                if (this.f16725a.f16496k != null) {
                    this.f16725a.f16496k.dismiss();
                }
                if (c0778b2.m3107b() == EnumC2464o.SUCCESS) {
                    C5179v.m19810a(this.f16725a.m17321h(), R.string.trunk_toast_deleted, 1).show();
                    if (this.f16725a.f16489d != null) {
                        this.f16725a.f16489d.mo17457a();
                        break;
                    }
                } else {
                    int iM10677a2 = C2471v.m10677a(CommonApplication.m18732r());
                    if (-3 == iM10677a2 || -2 == iM10677a2) {
                        this.f16725a.m17330l();
                        break;
                    } else if (c0778b2.m3111f() == 80210) {
                        C5179v.m19810a(this.f16725a.m17321h(), R.string.buddy_information_changed, 1).show();
                        break;
                    } else {
                        C5179v.m19810a(this.f16725a.m17321h(), R.string.toast_network_unable, 1).show();
                        break;
                    }
                }
                break;
        }
    }
}
