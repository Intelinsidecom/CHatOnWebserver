package com.sec.chaton.smsplugin.transaction;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Messenger;
import android.provider.Telephony;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p111h.C3896s;
import com.sec.chaton.smsplugin.p111h.C3903z;
import com.sec.google.android.p134a.C5104b;
import com.sec.google.android.p134a.C5111c;
import com.sec.google.android.p134a.p135a.C5082e;
import com.sec.google.android.p134a.p135a.C5095r;
import com.sec.google.android.p134a.p135a.C5097t;
import com.sec.google.android.p134a.p135a.C5100w;
import com.sec.google.android.p134a.p135a.C5103z;

/* compiled from: MmsMessageSender.java */
@SuppressLint({"NewApi"})
/* renamed from: com.sec.chaton.smsplugin.transaction.q */
/* loaded from: classes.dex */
public class C4081q implements InterfaceC4075k {

    /* renamed from: a */
    private final Context f14695a;

    /* renamed from: b */
    private final Uri f14696b;

    /* renamed from: c */
    private final long f14697c;

    /* renamed from: d */
    private final int f14698d;

    /* renamed from: e */
    private final Messenger f14699e;

    public C4081q(Context context, Uri uri, long j) {
        this.f14695a = context;
        this.f14696b = uri;
        this.f14697c = j;
        this.f14698d = -1;
        this.f14699e = null;
        if (this.f14696b == null) {
            throw new IllegalArgumentException("Null message URI.");
        }
    }

    public C4081q(Context context, Uri uri, int i, int i2, Messenger messenger) {
        this.f14695a = context;
        this.f14696b = uri;
        this.f14697c = i;
        this.f14698d = i2;
        this.f14699e = messenger;
    }

    @Override // com.sec.chaton.smsplugin.transaction.InterfaceC4075k
    /* renamed from: a */
    public boolean mo15606a(long j) throws C5111c {
        C5097t c5097tM19426a = C5097t.m19426a(this.f14695a);
        C5095r c5095rM19449a = c5097tM19426a.m19449a(this.f14696b);
        if (c5095rM19449a.m19403h() != 128) {
            throw new C5111c("Invalid message: " + c5095rM19449a.m19403h());
        }
        C5103z c5103z = (C5103z) c5095rM19449a;
        m15692a(c5103z);
        c5103z.m19468b("personal".getBytes());
        c5103z.m19311a(System.currentTimeMillis() / 1000);
        c5103z.m19469c(this.f14697c);
        c5097tM19426a.m19451a(this.f14696b, c5103z);
        c5097tM19426a.m19444a(this.f14696b, Telephony.Mms.Outbox.CONTENT_URI);
        C3903z.m15074a(Long.valueOf(ContentUris.parseId(this.f14696b)), j);
        Intent intent = new Intent(this.f14695a, (Class<?>) TransactionService.class);
        C3896s.m15045c("SentIntent BG token == " + this.f14698d, "MmsMessageSender");
        if (this.f14698d != -1) {
            intent.putExtra("extra_bg_token", this.f14698d);
            intent.putExtra("extra_bg_cb_messenger", this.f14699e);
        }
        this.f14695a.startService(intent);
        return true;
    }

    /* renamed from: a */
    private void m15692a(C5103z c5103z) throws C5104b {
        c5103z.m19467b(604800L);
        c5103z.m19310a(129);
        c5103z.m19471d(129);
        c5103z.m19472e(129);
    }

    /* renamed from: a */
    public static void m15691a(Context context, String str, String str2, int i) {
        try {
            C5100w c5100w = new C5100w(new C5082e("insert-address-token".getBytes()), str2.getBytes(), 18, i, new C5082e[]{new C5082e(str)});
            c5100w.m19455a(System.currentTimeMillis() / 1000);
            C5097t.m19426a(context).m19447a(c5100w, Telephony.Mms.Outbox.CONTENT_URI);
            context.startService(new Intent(context, (Class<?>) TransactionService.class));
        } catch (C5104b e) {
            C3890m.m14995a("MmsMessageSender", "Invalide header value", e);
        } catch (C5111c e2) {
            C3890m.m14995a("MmsMessageSender", "Persist message failed", e2);
        }
    }
}
