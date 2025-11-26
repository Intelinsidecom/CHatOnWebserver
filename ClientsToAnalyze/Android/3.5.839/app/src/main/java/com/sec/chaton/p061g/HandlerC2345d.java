package com.sec.chaton.p061g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.GetNumberFreeSMS;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4809aa;

/* compiled from: FreeSmsInviteSenderHelper.java */
/* renamed from: com.sec.chaton.g.d */
/* loaded from: classes.dex */
class HandlerC2345d extends Handler {

    /* renamed from: a */
    final /* synthetic */ C2344c f8348a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC2345d(C2344c c2344c, Looper looper) {
        super(looper);
        this.f8348a = c2344c;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        GetNumberFreeSMS getNumberFreeSMS;
        C0778b c0778b = (C0778b) message.obj;
        if (message.what == 1305 && c0778b != null && c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR && (getNumberFreeSMS = (GetNumberFreeSMS) c0778b.m3110e()) != null) {
            try {
                C4809aa.m18105a("free_sms_is_available", (Boolean) true);
                C4809aa.m18106a("free_sms_remain_count", Integer.valueOf(Integer.parseInt(getNumberFreeSMS.remain)));
                C4809aa.m18106a("free_sms_max_count", Integer.valueOf(Integer.parseInt(getNumberFreeSMS.used) + Integer.parseInt(getNumberFreeSMS.remain)));
                C4809aa.m18106a("free_sms_invitation_count", Integer.valueOf(Integer.parseInt(getNumberFreeSMS.invitation)));
                C4809aa.m18106a("free_sms_reward_base", Integer.valueOf(Integer.parseInt(getNumberFreeSMS.rewardbase)));
                C4809aa.m18106a("free_sms_reward_per_base", Integer.valueOf(Integer.parseInt(getNumberFreeSMS.reward)));
                C4809aa.m18106a("free_sms_international_deduct_count", Integer.valueOf(Integer.parseInt(getNumberFreeSMS.overseasbrt)));
            } catch (NumberFormatException e) {
                Log.d("FreeSmsInviteSenderHelper", "caught Exception:" + e);
                e.printStackTrace();
            }
        }
    }
}
