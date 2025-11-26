package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.chat.p024b.EnumC0962m;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.TranslationAuthEntry;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;

/* compiled from: GetUserInfoTask.java */
/* renamed from: com.sec.chaton.d.a.ck */
/* loaded from: classes.dex */
public class C1210ck extends AbstractC1145a {

    /* renamed from: b */
    private String f4715b;

    public C1210ck(Handler handler, C1580h c1580h) {
        super(handler, c1580h);
        this.f4715b = "GetUserInfoTask";
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        TranslationAuthEntry translationAuthEntry;
        int iM1358i = c0267d.m1358i();
        EnumC1587o enumC1587oM1351b = c0267d.m1351b();
        boolean zN = c0267d.m11704n();
        if (enumC1587oM1351b == EnumC1587o.SUCCESS) {
            translationAuthEntry = (TranslationAuthEntry) c0267d.m1354e();
        } else {
            translationAuthEntry = (TranslationAuthEntry) c0267d.mo11666o();
        }
        if (C3250y.f11734b) {
            C3250y.m11450b(String.format("afterRequest(), connectionSuccess(%s), httpResultCode(%s), httpStatus(%d), resultEntry(%s)", Boolean.valueOf(zN), enumC1587oM1351b, Integer.valueOf(iM1358i), translationAuthEntry), this.f4715b);
        }
        if (iM1358i == 200 && enumC1587oM1351b == EnumC1587o.SUCCESS) {
            String urlPrimary = translationAuthEntry.getUrlPrimary();
            String urlSecondary = translationAuthEntry.getUrlSecondary();
            if (!TextUtils.isEmpty(urlPrimary)) {
                C3159aa.m10962a().m10986b("primary_translation_address", urlPrimary);
            }
            if (!TextUtils.isEmpty(urlSecondary)) {
                C3159aa.m10962a().m10986b("secondary_translation_address", urlSecondary);
            }
            c0267d.m1349a(new C1213cn(this, EnumC0962m.SUCCESS, translationAuthEntry));
            return;
        }
        c0267d.m1349a(new C1213cn(this, EnumC0962m.ERROR_FAILED_ABNORMAL, translationAuthEntry));
    }
}
