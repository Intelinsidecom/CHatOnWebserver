package com.sec.chaton.trunk;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.trunk.entry.GetCommentListEntry;
import com.sec.chaton.trunk.p050c.C1572d;
import com.sec.chaton.trunk.p050c.C1573e;
import com.sec.chaton.trunk.p050c.C1574f;
import com.sec.chaton.trunk.p053e.EnumC1599h;
import com.sec.chaton.util.C1786r;
import com.sec.widget.C2153y;

/* compiled from: TrunkItemView.java */
/* renamed from: com.sec.chaton.trunk.ao */
/* loaded from: classes.dex */
class HandlerC1529ao extends Handler {

    /* renamed from: a */
    final /* synthetic */ TrunkItemView f5578a;

    HandlerC1529ao(TrunkItemView trunkItemView) {
        this.f5578a = trunkItemView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f5578a.isDetached()) {
            if (C1786r.f6454d) {
                C1786r.m6065d("Fragment had been detached.", TrunkItemView.f5448e);
            }
            return;
        }
        switch (message.what) {
            case 2:
                String str = (String) ((C1573e) message.obj).m5439a();
                if (this.f5578a.f5456H != null && this.f5578a.f5456H.equals(str)) {
                    this.f5578a.f5462N = false;
                    this.f5578a.mo5307a(this.f5578a.f5455G, null, this.f5578a.f5456H);
                }
                this.f5578a.m5283k();
                break;
            case 3:
                String str2 = (String) ((C1572d) message.obj).m5439a();
                if (this.f5578a.f5456H != null && this.f5578a.f5456H.equals(str2)) {
                    this.f5578a.f5462N = false;
                }
                this.f5578a.m5283k();
                break;
            case 4:
                String str3 = (String) ((C1574f) message.obj).m5439a();
                if (this.f5578a.f5456H != null && this.f5578a.f5456H.equals(str3)) {
                    this.f5578a.f5461M = true;
                    this.f5578a.f5462N = false;
                    this.f5578a.m5260a(EnumC1552ba.Hidden);
                    if (this.f5578a.f5455G == EnumC1599h.IMAGE) {
                        this.f5578a.f5494m.setImageResource(R.drawable.trunk_image_default);
                    } else if (this.f5578a.f5455G == EnumC1599h.VIDEO) {
                        this.f5578a.f5494m.setImageResource(R.drawable.trunk_video_default);
                    }
                    C2153y.m7536a(this.f5578a.f5487f, this.f5578a.f5487f.getResources().getString(R.string.toast_network_unable), 1).show();
                }
                this.f5578a.m5283k();
                break;
            case 901:
                C0101b c0101b = (C0101b) message.obj;
                if (c0101b.m665b() == EnumC0803m.SUCCESS) {
                    this.f5578a.f5460L = false;
                } else {
                    this.f5578a.f5460L = true;
                    if (c0101b.m673f() == 86411) {
                        this.f5578a.m5259a(EnumC1540az.Refresh);
                        this.f5578a.m5291o();
                    } else {
                        this.f5578a.getActivity().findViewById(R.id.trunkCommentSendBtn).setVisibility(4);
                        this.f5578a.getActivity().findViewById(R.id.trunkCommentEdit).setVisibility(4);
                        this.f5578a.f5505x.setVisibility(0);
                        this.f5578a.f5503v.setVisibility(8);
                        this.f5578a.f5451C.setVisibility(8);
                    }
                }
                this.f5578a.f5471W.mo5390a();
                this.f5578a.m5287m();
                break;
            case 903:
                C0101b c0101b2 = (C0101b) message.obj;
                if (c0101b2.m665b() != EnumC0803m.SUCCESS) {
                    C2153y.m7535a(this.f5578a.f5487f, R.string.toast_network_unable, 1).show();
                } else if (((GetCommentListEntry) c0101b2.m671d()).comments.size() >= 20 && this.f5578a.f5459K + 20 < this.f5578a.f5458J) {
                    this.f5578a.f5464P = false;
                } else {
                    this.f5578a.f5464P = true;
                }
                this.f5578a.m5287m();
                break;
            case 905:
                C0101b c0101b3 = (C0101b) message.obj;
                if (this.f5578a.f5507z != null && this.f5578a.f5507z.isShowing()) {
                    this.f5578a.f5507z.dismiss();
                }
                if (c0101b3.m665b() == EnumC0803m.SUCCESS) {
                    C2153y.m7535a(this.f5578a.f5487f, R.string.trunk_toast_deleted, 1).show();
                    if (this.f5578a.f5488g != null) {
                        this.f5578a.f5488g.mo5224b_();
                        break;
                    }
                } else {
                    C2153y.m7535a(this.f5578a.f5487f, R.string.toast_network_unable, 1).show();
                    break;
                }
                break;
            case 906:
                C0101b c0101b4 = (C0101b) message.obj;
                if (this.f5578a.f5507z != null && this.f5578a.f5507z.isShowing()) {
                    this.f5578a.f5507z.dismiss();
                }
                if (c0101b4.m665b() != EnumC0803m.SUCCESS) {
                    C2153y.m7535a(this.f5578a.f5487f, R.string.toast_network_unable, 1).show();
                    break;
                }
                break;
        }
    }
}
