package com.sec.chaton.trunk;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.trunk.entry.GetCommentListEntry;
import com.sec.chaton.trunk.entry.GetItemEntry;
import com.sec.chaton.trunk.p060b.C2990d;
import com.sec.chaton.trunk.p060b.C2991e;
import com.sec.chaton.trunk.p060b.C2992f;
import com.sec.chaton.trunk.p061c.C3025f;
import com.sec.chaton.trunk.p061c.EnumC3026g;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;

/* compiled from: TrunkItemView.java */
/* renamed from: com.sec.chaton.trunk.bh */
/* loaded from: classes.dex */
class HandlerC3000bh extends Handler {

    /* renamed from: a */
    final /* synthetic */ TrunkItemView f10846a;

    HandlerC3000bh(TrunkItemView trunkItemView) {
        this.f10846a = trunkItemView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f10846a.isDetached()) {
            if (C3250y.f11736d) {
                C3250y.m11455d("Fragment had been detached.", TrunkItemView.f10565a);
            }
            return;
        }
        switch (message.what) {
            case 2:
                C2991e c2991e = (C2991e) message.obj;
                String str = (String) c2991e.m10491a();
                if (this.f10846a.f10573H != null && this.f10846a.f10573H.equals(str)) {
                    this.f10846a.f10579N = false;
                    ViewOnClickListenerC3064r.m10592a(this.f10846a.f10570E, c2991e.m10494b(), c2991e.m10496c(), false);
                    this.f10846a.mo10317a(this.f10846a.f10572G, null, this.f10846a.f10573H);
                }
                this.f10846a.m10293l();
                break;
            case 3:
                String str2 = (String) ((C2990d) message.obj).m10491a();
                if (this.f10846a.f10573H != null && this.f10846a.f10573H.equals(str2)) {
                    this.f10846a.f10579N = false;
                }
                this.f10846a.m10293l();
                break;
            case 4:
                String str3 = (String) ((C2992f) message.obj).m10491a();
                if (this.f10846a.f10573H != null && this.f10846a.f10573H.equals(str3)) {
                    this.f10846a.f10578M = true;
                    this.f10846a.f10579N = false;
                    this.f10846a.f10616m.setImageBitmap(null);
                    this.f10846a.m10269b(false);
                    if (this.f10846a.f10572G == EnumC3026g.IMAGE || this.f10846a.f10572G == EnumC3026g.AMS) {
                        this.f10846a.f10616m.setImageResource(R.drawable.turnk_no_image_default);
                        if (this.f10846a.f10572G == EnumC3026g.AMS || C3025f.m10540b(this.f10846a.f10573H)) {
                            this.f10846a.f10617n.setImageResource(R.drawable.chat_btn_ams_play);
                            this.f10846a.f10617n.setVisibility(0);
                        }
                    } else if (this.f10846a.f10572G == EnumC3026g.VIDEO) {
                        this.f10846a.f10616m.setImageResource(R.drawable.turnk_no_veido_default);
                        this.f10846a.f10617n.setImageResource(R.drawable.chat_btn_play);
                        this.f10846a.f10617n.setVisibility(0);
                    }
                    C3641ai.m13211a(this.f10846a.f10608e, this.f10846a.f10608e.getResources().getString(R.string.media_download_fail), 1).show();
                }
                this.f10846a.m10293l();
                break;
            case 901:
                C0267d c0267d = (C0267d) message.obj;
                if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
                    this.f10846a.f10577L = false;
                    if (TextUtils.isEmpty(this.f10846a.f10571F)) {
                        GetItemEntry getItemEntry = (GetItemEntry) c0267d.m1354e();
                        this.f10846a.f10571F = getItemEntry.item.itemid;
                        TrunkDetailActivity trunkDetailActivity = (TrunkDetailActivity) this.f10846a.f10608e;
                        if (trunkDetailActivity != null) {
                            trunkDetailActivity.f10518a = this.f10846a.f10571F;
                        }
                    }
                    if (!this.f10846a.f10582Q) {
                        this.f10846a.f10629z.setOnScrollListener(new C3001bi(this));
                        this.f10846a.f10582Q = true;
                    }
                    this.f10846a.f10602ak = true;
                    this.f10846a.f10588W.mo10500a();
                } else {
                    this.f10846a.f10577L = true;
                    if (c0267d.m1355f() == 86411) {
                        this.f10846a.m10300o();
                    } else {
                        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
                        if (-3 == iM6733a || -2 == iM6733a) {
                            this.f10846a.m10264a(EnumC3010br.Nonetwork);
                        } else {
                            this.f10846a.m10264a(EnumC3010br.NetworkErr);
                        }
                    }
                }
                this.f10846a.m10296m();
                break;
            case 903:
                C0267d c0267d2 = (C0267d) message.obj;
                if (c0267d2.m1351b() == EnumC1587o.SUCCESS) {
                    if (((GetCommentListEntry) c0267d2.m1354e()).comments.size() >= 100 && this.f10846a.f10576K + 100 < this.f10846a.f10575J) {
                        this.f10846a.f10581P = false;
                    } else {
                        this.f10846a.f10581P = true;
                    }
                } else {
                    int iM6733a2 = C1594v.m6733a(CommonApplication.m11493l());
                    if (-3 == iM6733a2 || -2 == iM6733a2) {
                        this.f10846a.m10264a(EnumC3010br.Nonetwork);
                    } else {
                        this.f10846a.m10264a(EnumC3010br.NetworkErr);
                    }
                }
                this.f10846a.m10296m();
                break;
            case 905:
                C0267d c0267d3 = (C0267d) message.obj;
                if (this.f10846a.f10566A != null) {
                    this.f10846a.f10566A.dismiss();
                }
                if (c0267d3.m1351b() == EnumC1587o.SUCCESS) {
                    C3641ai.m13210a(this.f10846a.f10608e, R.string.trunk_toast_deleted, 1).show();
                    if (this.f10846a.f10609f != null) {
                        this.f10846a.f10609f.mo10204a(true, this.f10846a.f10602ak);
                        break;
                    }
                } else {
                    int iM6733a3 = C1594v.m6733a(CommonApplication.m11493l());
                    if (-3 == iM6733a3 || -2 == iM6733a3) {
                        this.f10846a.m10264a(EnumC3010br.Nonetwork);
                        break;
                    } else if (c0267d3.m1355f() == 80210) {
                        C3641ai.m13210a(this.f10846a.f10608e, R.string.buddy_information_changed, 1).show();
                        this.f10846a.f10598ag = false;
                        if ("ME".equals(this.f10846a.f10574I)) {
                            this.f10846a.f10607d.findItem(R.id.trunkitem_delete).setEnabled(false);
                            break;
                        }
                    } else {
                        this.f10846a.m10264a(EnumC3010br.NetworkErr);
                        break;
                    }
                }
                break;
            case 906:
                C0267d c0267d4 = (C0267d) message.obj;
                if (this.f10846a.f10566A != null) {
                    this.f10846a.f10566A.dismiss();
                }
                if (c0267d4.m1351b() != EnumC1587o.SUCCESS) {
                    int iM6733a4 = C1594v.m6733a(CommonApplication.m11493l());
                    if (-3 == iM6733a4 || -2 == iM6733a4) {
                        this.f10846a.m10264a(EnumC3010br.Nonetwork);
                        break;
                    } else if (c0267d4.m1355f() == 80210) {
                        C3641ai.m13210a(this.f10846a.f10608e, R.string.buddy_information_changed, 1).show();
                        this.f10846a.f10598ag = false;
                        if ("ME".equals(this.f10846a.f10574I)) {
                            this.f10846a.f10607d.findItem(R.id.trunkitem_delete).setEnabled(false);
                            break;
                        }
                    } else {
                        this.f10846a.m10264a(EnumC3010br.NetworkErr);
                        break;
                    }
                }
                break;
        }
    }
}
