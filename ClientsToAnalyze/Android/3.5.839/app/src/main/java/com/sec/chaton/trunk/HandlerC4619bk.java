package com.sec.chaton.trunk;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.trunk.entry.GetCommentListEntry;
import com.sec.chaton.trunk.entry.GetItemEntry;
import com.sec.chaton.trunk.p120b.C4606d;
import com.sec.chaton.trunk.p120b.C4607e;
import com.sec.chaton.trunk.p120b.C4608f;
import com.sec.chaton.trunk.p121c.C4641f;
import com.sec.chaton.trunk.p121c.EnumC4642g;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: TrunkItemView.java */
/* renamed from: com.sec.chaton.trunk.bk */
/* loaded from: classes.dex */
class HandlerC4619bk extends Handler {

    /* renamed from: a */
    final /* synthetic */ TrunkItemView f16794a;

    HandlerC4619bk(TrunkItemView trunkItemView) {
        this.f16794a = trunkItemView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f16794a.isDetached()) {
            if (C4904y.f17874d) {
                C4904y.m18645d("Fragment had been detached.", TrunkItemView.f16512a);
            }
            return;
        }
        switch (message.what) {
            case 2:
                C4607e c4607e = (C4607e) message.obj;
                String str = (String) c4607e.m17563a();
                if (this.f16794a.f16518F != null && this.f16794a.f16518F.equals(str)) {
                    this.f16794a.f16524L = false;
                    ViewOnClickListenerC4684r.m17686a(this.f16794a.f16515C, c4607e.m17566b(), c4607e.m17568c(), false);
                    this.f16794a.mo17412a(this.f16794a.f16517E, null, this.f16794a.f16518F);
                }
                this.f16794a.m17391m();
                break;
            case 3:
                String str2 = (String) ((C4606d) message.obj).m17563a();
                if (this.f16794a.f16518F != null && this.f16794a.f16518F.equals(str2)) {
                    this.f16794a.f16524L = false;
                }
                this.f16794a.m17391m();
                break;
            case 4:
                String str3 = (String) ((C4608f) message.obj).m17563a();
                if (this.f16794a.f16518F != null && this.f16794a.f16518F.equals(str3)) {
                    this.f16794a.f16523K = true;
                    this.f16794a.f16524L = false;
                    this.f16794a.f16561m.setImageBitmap(null);
                    this.f16794a.m17366b(false);
                    if (this.f16794a.f16517E == EnumC4642g.IMAGE || this.f16794a.f16517E == EnumC4642g.AMS) {
                        this.f16794a.f16561m.setImageResource(R.drawable.turnk_no_image_default);
                        if (this.f16794a.f16517E == EnumC4642g.AMS || C4641f.m17617b(this.f16794a.f16518F)) {
                            this.f16794a.f16562n.setImageResource(R.drawable.chat_btn_ams_play_selector);
                            this.f16794a.f16562n.setVisibility(0);
                        }
                    } else if (this.f16794a.f16517E == EnumC4642g.VIDEO) {
                        this.f16794a.f16561m.setImageResource(R.drawable.turnk_no_veido_default);
                        this.f16794a.f16562n.setImageResource(R.drawable.chat_btn_play);
                        this.f16794a.f16562n.setVisibility(0);
                    }
                    C5179v.m19811a(this.f16794a.f16553e, this.f16794a.f16553e.getResources().getString(R.string.media_download_fail), 1).show();
                }
                this.f16794a.m17391m();
                break;
            case 901:
                C0778b c0778b = (C0778b) message.obj;
                if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
                    this.f16794a.f16522J = false;
                    if (TextUtils.isEmpty(this.f16794a.f16516D)) {
                        GetItemEntry getItemEntry = (GetItemEntry) c0778b.m3110e();
                        this.f16794a.f16516D = getItemEntry.item.itemid;
                        TrunkDetailActivity trunkDetailActivity = (TrunkDetailActivity) this.f16794a.f16553e;
                        if (trunkDetailActivity != null) {
                            trunkDetailActivity.f16459n = this.f16794a.f16516D;
                        }
                    }
                    if (!this.f16794a.f16527O) {
                        this.f16794a.f16572x.setOnScrollListener(new C4620bl(this));
                        this.f16794a.f16527O = true;
                    }
                    this.f16794a.f16547ai = true;
                    this.f16794a.f16533U.mo17598a();
                } else {
                    this.f16794a.f16522J = true;
                    if (c0778b.m3111f() == 86411) {
                        this.f16794a.m17396p();
                    } else {
                        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
                        if (-3 == iM10677a || -2 == iM10677a) {
                            this.f16794a.m17361a(EnumC4629bu.Nonetwork);
                        } else {
                            this.f16794a.m17361a(EnumC4629bu.NetworkErr);
                        }
                    }
                }
                this.f16794a.m17393n();
                break;
            case 903:
                C0778b c0778b2 = (C0778b) message.obj;
                if (c0778b2.m3107b() == EnumC2464o.SUCCESS) {
                    if (((GetCommentListEntry) c0778b2.m3110e()).comments.size() >= 100 && this.f16794a.f16521I + 100 < this.f16794a.f16520H) {
                        this.f16794a.f16526N = false;
                    } else {
                        this.f16794a.f16526N = true;
                    }
                } else {
                    int iM10677a2 = C2471v.m10677a(CommonApplication.m18732r());
                    if (-3 == iM10677a2 || -2 == iM10677a2) {
                        this.f16794a.m17361a(EnumC4629bu.Nonetwork);
                    } else {
                        this.f16794a.m17361a(EnumC4629bu.NetworkErr);
                    }
                }
                this.f16794a.m17393n();
                break;
            case 905:
                C0778b c0778b3 = (C0778b) message.obj;
                if (this.f16794a.f16573y != null) {
                    this.f16794a.f16573y.dismiss();
                }
                if (c0778b3.m3107b() == EnumC2464o.SUCCESS) {
                    C5179v.m19810a(this.f16794a.f16553e, R.string.trunk_toast_deleted, 1).show();
                    if (this.f16794a.f16554f != null) {
                        this.f16794a.f16554f.mo17302a(true, this.f16794a.f16547ai);
                        break;
                    }
                } else {
                    this.f16794a.m17357a(c0778b3);
                    break;
                }
                break;
            case 906:
                C0778b c0778b4 = (C0778b) message.obj;
                if (this.f16794a.f16573y != null) {
                    this.f16794a.f16573y.dismiss();
                }
                if (c0778b4.m3107b() == EnumC2464o.SUCCESS) {
                    C5179v.m19810a(this.f16794a.f16553e, R.string.trunk_toast_deleted, 1).show();
                    break;
                } else {
                    this.f16794a.m17357a(c0778b4);
                    break;
                }
        }
    }
}
