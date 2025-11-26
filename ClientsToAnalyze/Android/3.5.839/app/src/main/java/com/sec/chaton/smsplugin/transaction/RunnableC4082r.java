package com.sec.chaton.smsplugin.transaction;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SqliteWrapper;
import android.net.Uri;
import android.provider.Telephony;
import com.google.android.mms.pdu.PduParser;
import com.google.android.mms.pdu.PduPersister;
import com.sec.chaton.chat.notification.C1828q;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p111h.AbstractC3900w;
import com.sec.chaton.smsplugin.p111h.C3881d;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p111h.C3896s;
import com.sec.chaton.smsplugin.p112ui.C4149cd;
import com.sec.chaton.smsplugin.provider.C3964v;
import com.sec.chaton.smsplugin.spam.C4015bs;
import com.sec.google.android.p134a.C5111c;
import com.sec.google.android.p134a.p135a.C5084g;
import com.sec.google.android.p134a.p135a.C5085h;
import com.sec.google.android.p134a.p135a.C5087j;
import com.sec.google.android.p134a.p135a.C5095r;
import com.sec.google.android.p134a.p135a.C5096s;
import com.sec.google.android.p134a.p135a.C5097t;
import java.io.IOException;

/* compiled from: NotificationTransaction.java */
@SuppressLint({"NewApi"})
/* renamed from: com.sec.chaton.smsplugin.transaction.r */
/* loaded from: classes.dex */
public class RunnableC4082r extends AbstractC4059aj implements Runnable {

    /* renamed from: a */
    private Uri f14700a;

    /* renamed from: f */
    private C5084g f14701f;

    /* renamed from: g */
    private String f14702g;

    public RunnableC4082r(Context context, int i, C4064ao c4064ao, String str) {
        super(context, i, c4064ao);
        this.f14700a = Uri.parse(str);
        try {
            this.f14701f = (C5084g) C5097t.m19426a(context).m19449a(this.f14700a);
            this.f14640c = new String(this.f14701f.m19323f());
            this.f14702g = new String(this.f14701f.m19320a());
            m15695a(C4090z.m15708a(context));
        } catch (C5111c e) {
            C3890m.m14995a("NotificationTransaction", "Failed to load NotificationInd from: " + str, e);
            throw new IllegalArgumentException();
        }
    }

    public RunnableC4082r(Context context, int i, C4064ao c4064ao, C5084g c5084g) {
        super(context, i, c4064ao);
        try {
            this.f14700a = C5097t.m19426a(context).m19447a(c5084g, Telephony.Mms.Inbox.CONTENT_URI);
            this.f14701f = c5084g;
            this.f14640c = new String(c5084g.m19323f());
        } catch (C5111c e) {
            C3890m.m14995a("NotificationTransaction", "Failed to save NotificationInd in constructor.", e);
            throw new IllegalArgumentException();
        }
    }

    @Override // com.sec.chaton.smsplugin.transaction.AbstractC4059aj
    /* renamed from: a */
    public void mo15597a() {
        new Thread(this).start();
    }

    @Override // java.lang.Runnable
    public void run() {
        byte[] bArrA;
        boolean zM15440a;
        C3881d c3881dM14970b = C3881d.m14970b();
        boolean zM14978a = c3881dM14970b.m14978a();
        boolean z = GlobalApplication.m10279a().m10295j().getDataState() == 3;
        try {
            try {
                C3890m.m14994a("NotificationTransaction", "Notification transaction launched: " + this);
                int i = 131;
                if (!zM14978a || z) {
                    c3881dM14970b.m14977a(this.f14700a, 128);
                    m15693a(131);
                } else {
                    c3881dM14970b.m14977a(this.f14700a, 129);
                    C3890m.m14994a("NotificationTransaction", "Content-Location: " + this.f14702g);
                    try {
                        bArrA = m15616a(this.f14702g);
                    } catch (IOException e) {
                        this.f14641d.m15642a(2);
                        bArrA = null;
                    }
                    if (bArrA != null) {
                        C5095r c5095rM19425a = new C5096s(bArrA).m19425a();
                        if (C3847e.m14676ah()) {
                            new PduParser(bArrA).parse();
                        }
                        if (c5095rM19425a == null || c5095rM19425a.m19403h() != 132) {
                            C3890m.m14999e("NotificationTransaction", "Invalid M-RETRIEVE.CONF PDU. " + (c5095rM19425a != null ? "message type: " + c5095rM19425a.m19403h() : "null pdu"));
                            this.f14641d.m15642a(2);
                            i = 132;
                        } else {
                            if (C3847e.m14674af()) {
                                zM15440a = C4149cd.m16424b(this.f14639b, c5095rM19425a.mo19324w_().m19308c(), c5095rM19425a.mo19314b() != null ? c5095rM19425a.mo19314b().m19308c() : null);
                            } else {
                                zM15440a = C4015bs.m15440a(this.f14639b, c5095rM19425a.mo19324w_(), c5095rM19425a.mo19314b());
                                if (!zM15440a) {
                                    zM15440a = C4015bs.m15441a(this.f14639b, c5095rM19425a);
                                }
                            }
                            C5097t c5097tM19426a = C5097t.m19426a(this.f14639b);
                            if (C3847e.m14676ah()) {
                                PduPersister.getPduPersister(this.f14639b);
                            }
                            Uri uriM19448a = zM15440a ? c5097tM19426a.m19448a(c5095rM19425a, C3964v.f14265a, zM15440a) : c5097tM19426a.m19447a(c5095rM19425a, Telephony.Mms.Inbox.CONTENT_URI);
                            String lastPathSegment = this.f14700a.getLastPathSegment();
                            String lastPathSegment2 = uriM19448a.getLastPathSegment();
                            C3896s.m15044b("Old msg id = " + lastPathSegment + " New msg Id = " + lastPathSegment2, "NotificationTransaction");
                            C1828q.m8956a().m8962a(lastPathSegment, lastPathSegment2, false);
                            ContentValues contentValues = new ContentValues(1);
                            contentValues.put("date", Long.valueOf(System.currentTimeMillis() / 1000));
                            SqliteWrapper.update(this.f14639b, this.f14639b.getContentResolver(), uriM19448a, contentValues, (String) null, (String[]) null);
                            SqliteWrapper.delete(this.f14639b, this.f14639b.getContentResolver(), this.f14700a, (String) null, (String[]) null);
                            this.f14700a = uriM19448a;
                            i = 129;
                        }
                    }
                    C3890m.m14994a("NotificationTransaction", "status=0x" + Integer.toHexString(i));
                    switch (i) {
                        case 129:
                            this.f14641d.m15642a(1);
                            break;
                        case 131:
                            if (this.f14641d.m15641a() == 0) {
                                this.f14641d.m15642a(1);
                                break;
                            }
                            break;
                    }
                    m15693a(i);
                    AbstractC3900w.m15067b().m15072a(this.f14639b, this.f14700a);
                    this.f14641d.m15643a(this.f14700a);
                    if (!zM14978a || z) {
                        this.f14641d.m15642a(1);
                    }
                    if (this.f14641d.m15641a() != 1) {
                        this.f14641d.m15642a(2);
                        C3890m.m14999e("NotificationTransaction", "NotificationTransaction failed.");
                    }
                }
            } catch (Throwable th) {
                C3890m.m14999e("NotificationTransaction", C3890m.m14993a(th));
                this.f14641d.m15643a(this.f14700a);
                if (!zM14978a || z) {
                    this.f14641d.m15642a(1);
                }
                if (this.f14641d.m15641a() != 1) {
                    this.f14641d.m15642a(2);
                    C3890m.m14999e("NotificationTransaction", "NotificationTransaction failed.");
                }
            }
        } finally {
            this.f14641d.m15643a(this.f14700a);
            if (!zM14978a || z) {
                this.f14641d.m15642a(1);
            }
            if (this.f14641d.m15641a() != 1) {
                this.f14641d.m15642a(2);
                C3890m.m14999e("NotificationTransaction", "NotificationTransaction failed.");
            }
            m15697d();
        }
    }

    /* renamed from: a */
    private void m15693a(int i) {
        C5085h c5085h = new C5085h(18, this.f14701f.m19323f(), i);
        if (C3847e.m14715u()) {
            m15618a(new C5087j(this.f14639b, c5085h).m19352a(), this.f14702g);
        } else {
            m15617a(new C5087j(this.f14639b, c5085h).m19352a());
        }
    }

    @Override // com.sec.chaton.smsplugin.transaction.AbstractC4059aj
    /* renamed from: b */
    public int mo15598b() {
        return 0;
    }

    /* renamed from: c */
    public String m15694c() {
        return this.f14702g;
    }
}
