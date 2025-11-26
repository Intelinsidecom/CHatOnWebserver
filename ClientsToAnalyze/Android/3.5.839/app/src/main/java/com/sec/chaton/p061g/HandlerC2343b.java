package com.sec.chaton.p061g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.GetSMSAuthToken;
import com.sec.chaton.p065io.entry.SendInvitationEntry;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.util.C4809aa;
import java.util.ArrayList;

/* compiled from: FreeSmsInviteSender.java */
/* renamed from: com.sec.chaton.g.b */
/* loaded from: classes.dex */
class HandlerC2343b extends Handler {

    /* renamed from: a */
    final /* synthetic */ C2342a f8335a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC2343b(C2342a c2342a, Looper looper) {
        super(looper);
        this.f8335a = c2342a;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        boolean z2;
        C0778b c0778b = (C0778b) message.obj;
        C3890m.m14996b("FreeSmsInviteSender", "sendMessage handleMessage: " + message.what);
        switch (message.what) {
            case 1306:
                if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                    if (this.f8335a.f8333i != null) {
                        this.f8335a.f8333i.m10267a(true, 0, 0);
                    }
                    if (c0778b.m3111f() == 42000 || c0778b.m3111f() == 42001) {
                        C4809aa.m18105a("free_sms_is_available", (Boolean) false);
                        C4809aa.m18105a("pref_key_is_free_sms_enable", (Boolean) false);
                    }
                    z = true;
                } else {
                    synchronized (c0778b) {
                        GetSMSAuthToken getSMSAuthToken = (GetSMSAuthToken) c0778b.m3110e();
                        if (getSMSAuthToken != null) {
                            this.f8335a.f8326a.m9373a(getSMSAuthToken.token, this.f8335a.f8330f, this.f8335a.f8331g);
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                    }
                    z = z2;
                }
                if (z) {
                    C2342a.f8325c.remove(Integer.valueOf(this.f8335a.f8328d));
                    return;
                }
                return;
            case 1307:
            default:
                C2342a.f8325c.remove(Integer.valueOf(this.f8335a.f8328d));
                return;
            case 1308:
                C3890m.m14996b("FreeSmsInviteSender", "sendMessage METHOD_REQUEST_SEND_INVITATION: ");
                if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                    if (this.f8335a.f8333i != null) {
                        this.f8335a.f8333i.m10267a(true, 0, 0);
                    }
                    if (c0778b.m3111f() == 42000 || c0778b.m3111f() == 42001) {
                        C4809aa.m18105a("free_sms_is_available", (Boolean) false);
                        C4809aa.m18105a("pref_key_is_free_sms_enable", (Boolean) false);
                    }
                } else {
                    SendInvitationEntry sendInvitationEntry = (SendInvitationEntry) c0778b.m3110e();
                    C4809aa.m18104a().m18126b("free_sms_remain_count", Integer.valueOf(sendInvitationEntry.remain));
                    C4809aa.m18104a().m18126b("free_sms_invitation_count", Integer.valueOf(sendInvitationEntry.invitation));
                    C4809aa.m18104a().m18126b("free_sms_max_count", Integer.valueOf(sendInvitationEntry.max));
                    ArrayList arrayList = new ArrayList();
                    int length = this.f8335a.f8330f.length < this.f8335a.f8331g.length ? this.f8335a.f8330f.length : this.f8335a.f8331g.length;
                    for (int i = 0; i < length; i++) {
                        arrayList.add("+" + this.f8335a.f8330f[i] + this.f8335a.f8331g[i]);
                    }
                    String[] strArrSplit = sendInvitationEntry.failnumber != null ? sendInvitationEntry.failnumber.split(",") : null;
                    String[] strArrSplit2 = sendInvitationEntry.failcountrycallingcode != null ? sendInvitationEntry.failcountrycallingcode.split(",") : null;
                    if (strArrSplit != null && strArrSplit2 != null) {
                        ArrayList arrayList2 = new ArrayList();
                        int length2 = strArrSplit.length < strArrSplit2.length ? strArrSplit2.length : strArrSplit2.length;
                        for (int i2 = 0; i2 < length2; i2++) {
                            arrayList2.add("+" + strArrSplit2[i2] + strArrSplit[i2]);
                        }
                        arrayList.removeAll(arrayList2);
                    }
                    if (arrayList.size() > 0) {
                        C2346e.m10271a().m10274a((String[]) arrayList.toArray(new String[arrayList.size()]));
                    }
                    if (this.f8335a.f8333i != null) {
                        this.f8335a.f8333i.m10267a(false, arrayList.size(), Integer.valueOf(sendInvitationEntry.reward).intValue());
                    }
                }
                C2342a.f8325c.remove(Integer.valueOf(this.f8335a.f8328d));
                return;
        }
    }
}
