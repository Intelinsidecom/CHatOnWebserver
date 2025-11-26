package com.sec.chaton.trunk;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0502i;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.trunk.entry.GetCommentListEntry;
import com.sec.chaton.trunk.p042b.C1134e;
import com.sec.chaton.trunk.p042b.C1135f;
import com.sec.chaton.trunk.p042b.C1136g;
import com.sec.chaton.trunk.p045d.EnumC1168f;
import com.sec.chaton.util.C1341p;
import com.sec.widget.C1619g;

/* compiled from: TrunkItemView.java */
/* renamed from: com.sec.chaton.trunk.av */
/* loaded from: classes.dex */
class HandlerC1124av extends Handler {

    /* renamed from: a */
    final /* synthetic */ TrunkItemView f3935a;

    HandlerC1124av(TrunkItemView trunkItemView) {
        this.f3935a = trunkItemView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f3935a.isDetached()) {
            if (C1341p.f4580d) {
                C1341p.m4661d("Fragment had been detached.", TrunkItemView.f3767a);
            }
            return;
        }
        switch (message.what) {
            case 2:
                C1136g c1136g = (C1136g) message.obj;
                String str = (String) c1136g.m4164a();
                if (this.f3935a.f3776I != null && this.f3935a.f3776I.equals(str)) {
                    this.f3935a.f3782O = false;
                    C1109ag.m4145a(this.f3935a.f3773F, c1136g.m4167b(), c1136g.m4169c(), false);
                    this.f3935a.mo4044a(this.f3935a.f3775H, null, this.f3935a.f3776I);
                }
                this.f3935a.m4017i();
                break;
            case 3:
                String str2 = (String) ((C1135f) message.obj).m4164a();
                if (this.f3935a.f3776I != null && this.f3935a.f3776I.equals(str2)) {
                    this.f3935a.f3782O = false;
                }
                this.f3935a.m4017i();
                break;
            case 4:
                String str3 = (String) ((C1134e) message.obj).m4164a();
                if (this.f3935a.f3776I != null && this.f3935a.f3776I.equals(str3)) {
                    this.f3935a.f3781N = true;
                    this.f3935a.f3782O = false;
                    this.f3935a.m3996a(EnumC1194t.Hidden);
                    if (this.f3935a.f3775H == EnumC1168f.IMAGE) {
                        this.f3935a.f3811n.setImageResource(R.drawable.turnk_no_image_default);
                    } else if (this.f3935a.f3775H == EnumC1168f.VIDEO) {
                        this.f3935a.f3811n.setImageResource(R.drawable.turnk_no_veido_default);
                    }
                    C1619g.m5888a(this.f3935a.f3802e, R.string.toast_network_unable, 1).show();
                }
                this.f3935a.m4017i();
                break;
            case 901:
                C0259g c0259g = (C0259g) message.obj;
                if (c0259g.m928b() == EnumC0518y.SUCCESS) {
                    this.f3935a.f3780M = false;
                } else {
                    this.f3935a.f3780M = true;
                    this.f3935a.m3995a(EnumC1110ah.Refresh);
                    if (c0259g.m934f() == 86411) {
                        this.f3935a.m4027n();
                    } else {
                        int iM2526a = C0502i.m2526a(GlobalApplication.m3100a());
                        if (-3 == iM2526a || -2 == iM2526a) {
                            this.f3935a.m4023l();
                        } else {
                            C1619g.m5888a(this.f3935a.f3802e, R.string.toast_network_unable, 1).show();
                        }
                    }
                }
                this.f3935a.f3792Y.mo4087a();
                this.f3935a.m4021k();
                break;
            case 903:
                C0259g c0259g2 = (C0259g) message.obj;
                if (c0259g2.m928b() == EnumC0518y.SUCCESS) {
                    if (((GetCommentListEntry) c0259g2.m932d()).comments.size() >= 30 && this.f3935a.f3779L + 30 < this.f3935a.f3778K) {
                        this.f3935a.f3784Q = false;
                    } else {
                        this.f3935a.f3784Q = true;
                    }
                } else {
                    int iM2526a2 = C0502i.m2526a(GlobalApplication.m3100a());
                    if (-3 == iM2526a2 || -2 == iM2526a2) {
                        this.f3935a.m4023l();
                    } else {
                        C1619g.m5888a(this.f3935a.f3802e, R.string.toast_network_unable, 1).show();
                    }
                }
                this.f3935a.m4021k();
                break;
            case 905:
                C0259g c0259g3 = (C0259g) message.obj;
                if (this.f3935a.f3768A != null) {
                    this.f3935a.f3768A.dismiss();
                }
                if (c0259g3.m928b() == EnumC0518y.SUCCESS) {
                    C1619g.m5888a(this.f3935a.f3802e, R.string.trunk_toast_deleted, 1).show();
                    if (this.f3935a.f3803f != null) {
                        this.f3935a.f3803f.mo3965b_();
                        break;
                    }
                } else {
                    int iM2526a3 = C0502i.m2526a(GlobalApplication.m3100a());
                    if (-3 == iM2526a3 || -2 == iM2526a3) {
                        this.f3935a.m4023l();
                        break;
                    } else {
                        C1619g.m5888a(this.f3935a.f3802e, R.string.toast_network_unable, 1).show();
                        break;
                    }
                }
                break;
            case 906:
                C0259g c0259g4 = (C0259g) message.obj;
                if (this.f3935a.f3768A != null) {
                    this.f3935a.f3768A.dismiss();
                }
                if (c0259g4.m928b() != EnumC0518y.SUCCESS) {
                    int iM2526a4 = C0502i.m2526a(GlobalApplication.m3100a());
                    if (-3 == iM2526a4 || -2 == iM2526a4) {
                        this.f3935a.m4023l();
                        break;
                    } else {
                        C1619g.m5888a(this.f3935a.f3802e, R.string.toast_network_unable, 1).show();
                        break;
                    }
                }
                break;
        }
    }
}
