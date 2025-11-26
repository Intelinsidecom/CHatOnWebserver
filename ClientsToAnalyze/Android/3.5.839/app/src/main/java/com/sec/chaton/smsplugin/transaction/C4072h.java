package com.sec.chaton.smsplugin.transaction;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Telephony;
import com.sec.chaton.p055d.C2097bc;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.util.C4904y;
import com.sec.google.android.p134a.C5111c;
import java.util.HashMap;

/* compiled from: FreeSmsSender.java */
/* renamed from: com.sec.chaton.smsplugin.transaction.h */
/* loaded from: classes.dex */
class C4072h extends C4052ac {

    /* renamed from: k */
    private static HashMap<Integer, C4072h> f14673k = new HashMap<>();

    /* renamed from: a */
    C2097bc f14674a;

    /* renamed from: b */
    Handler f14675b;

    /* renamed from: i */
    private final String f14676i;

    /* renamed from: j */
    private final Uri f14677j;

    /* renamed from: l */
    private final int f14678l;

    public C4072h(Context context, String str, String str2, long j, Uri uri) {
        super(context, null, str2, j);
        this.f14675b = new HandlerC4073i(this, Looper.getMainLooper());
        this.f14676i = str;
        this.f14677j = uri;
        this.f14678l = hashCode();
        this.f14674a = new C2097bc(this.f14675b);
        f14673k.put(Integer.valueOf(this.f14678l), this);
        if (C4904y.f17872b) {
            C4904y.m18639b("instanceObjects put - mMessageText : " + this.f14616e + " mHashIndex : " + this.f14678l, "FreeSmsSender");
        }
    }

    @Override // com.sec.chaton.smsplugin.transaction.C4052ac, com.sec.chaton.smsplugin.transaction.InterfaceC4075k
    /* renamed from: a */
    public boolean mo15606a(long j) throws C5111c {
        if (this.f14616e == null) {
            throw new C5111c("Null message body or have multiple destinations.");
        }
        if (!Telephony.Sms.moveMessageToFolder(this.f14614c, this.f14677j, 4, 0)) {
            throw new C5111c("SmsMessageSender.sendMessage: couldn't move message to outbox: " + this.f14677j);
        }
        try {
            this.f14674a.m9375b();
            if (C4904y.f17872b) {
                C4904y.m18639b("control.getFreeMSGToken()- mMessageText : " + this.f14616e, "FreeSmsSender");
            }
            return false;
        } catch (Exception e) {
            C3890m.m14995a("FreeSmsSender", "SmsMessageSender.sendMessage: caught", e);
            throw new C5111c("SmsMessageSender.sendMessage: caught " + e + " from SmsManager.sendTextMessage()");
        }
    }
}
