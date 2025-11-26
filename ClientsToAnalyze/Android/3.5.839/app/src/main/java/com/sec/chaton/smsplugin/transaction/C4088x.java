package com.sec.chaton.smsplugin.transaction;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.provider.Telephony;
import com.sec.chaton.smsplugin.p112ui.C4149cd;
import com.sec.google.android.p134a.C5111c;
import com.sec.google.android.p134a.p135a.C5082e;
import com.sec.google.android.p134a.p135a.C5087j;
import com.sec.google.android.p134a.p135a.C5097t;
import com.sec.google.android.p134a.p135a.C5100w;
import java.io.IOException;

/* compiled from: ReadRecTransaction.java */
@SuppressLint({"NewApi"})
/* renamed from: com.sec.chaton.smsplugin.transaction.x */
/* loaded from: classes.dex */
public class C4088x extends AbstractC4059aj {

    /* renamed from: a */
    private final Uri f14719a;

    public C4088x(Context context, int i, C4064ao c4064ao, String str) {
        super(context, i, c4064ao);
        this.f14719a = Uri.parse(str);
        this.f14640c = str;
        m15695a(C4090z.m15708a(context));
    }

    @Override // com.sec.chaton.smsplugin.transaction.AbstractC4059aj
    /* renamed from: a */
    public void mo15597a() {
        C5097t c5097tM19426a = C5097t.m19426a(this.f14639b);
        try {
            C5100w c5100w = (C5100w) c5097tM19426a.m19449a(this.f14719a);
            c5100w.mo19318a(new C5082e(C4149cd.m16391a()));
            m15617a(new C5087j(this.f14639b, c5100w).m19352a());
            Uri uriM19444a = c5097tM19426a.m19444a(this.f14719a, Telephony.Mms.Sent.CONTENT_URI);
            this.f14641d.m15642a(1);
            this.f14641d.m15643a(uriM19444a);
            if (this.f14641d.m15641a() != 1) {
                this.f14641d.m15642a(2);
                this.f14641d.m15643a(this.f14719a);
            }
        } catch (C5111c e) {
            if (this.f14641d.m15641a() != 1) {
                this.f14641d.m15642a(2);
                this.f14641d.m15643a(this.f14719a);
            }
        } catch (IOException e2) {
            if (this.f14641d.m15641a() != 1) {
                this.f14641d.m15642a(2);
                this.f14641d.m15643a(this.f14719a);
            }
        } catch (RuntimeException e3) {
            if (this.f14641d.m15641a() != 1) {
                this.f14641d.m15642a(2);
                this.f14641d.m15643a(this.f14719a);
            }
        } catch (Throwable th) {
            if (this.f14641d.m15641a() != 1) {
                this.f14641d.m15642a(2);
                this.f14641d.m15643a(this.f14719a);
            }
            m15697d();
            throw th;
        }
        m15697d();
    }

    @Override // com.sec.chaton.smsplugin.transaction.AbstractC4059aj
    /* renamed from: b */
    public int mo15598b() {
        return 3;
    }
}
