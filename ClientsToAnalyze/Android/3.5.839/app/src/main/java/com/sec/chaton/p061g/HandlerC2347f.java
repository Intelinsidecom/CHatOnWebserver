package com.sec.chaton.p061g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.GetNumberFreeSMS;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.util.C4809aa;

/* compiled from: InviteHelper.java */
/* renamed from: com.sec.chaton.g.f */
/* loaded from: classes.dex */
class HandlerC2347f extends Handler {

    /* renamed from: a */
    final /* synthetic */ C2346e f8354a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC2347f(C2346e c2346e, Looper looper) {
        super(looper);
        this.f8354a = c2346e;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0778b c0778b = (C0778b) message.obj;
        if (message.what == 1305 && c0778b != null) {
            if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                GetNumberFreeSMS getNumberFreeSMS = (GetNumberFreeSMS) c0778b.m3110e();
                if (getNumberFreeSMS != null) {
                    try {
                        C4809aa.m18105a("free_sms_is_available", (Boolean) true);
                        C4809aa.m18106a("free_sms_remain_count", Integer.valueOf(Integer.parseInt(getNumberFreeSMS.remain)));
                        C4809aa.m18106a("free_sms_max_count", Integer.valueOf(Integer.parseInt(getNumberFreeSMS.used) + Integer.parseInt(getNumberFreeSMS.remain)));
                        C4809aa.m18106a("free_sms_invitation_count", Integer.valueOf(Integer.parseInt(getNumberFreeSMS.invitation)));
                        C4809aa.m18106a("free_sms_reward_base", Integer.valueOf(Integer.parseInt(getNumberFreeSMS.rewardbase)));
                        C4809aa.m18106a("free_sms_reward_per_base", Integer.valueOf(Integer.parseInt(getNumberFreeSMS.reward)));
                        C4809aa.m18106a("free_sms_international_deduct_count", Integer.valueOf(Integer.parseInt(getNumberFreeSMS.overseasbrt)));
                        return;
                    } catch (NumberFormatException e) {
                        C3890m.m14996b(this.f8354a.f8350a, "caught Exception:" + e);
                        e.printStackTrace();
                        return;
                    }
                }
                return;
            }
            if (c0778b.m3111f() == 42000 || c0778b.m3111f() == 42001) {
                C4809aa.m18105a("free_sms_is_available", (Boolean) false);
                C4809aa.m18105a("pref_key_is_free_sms_enable", (Boolean) false);
            }
        }
    }
}
