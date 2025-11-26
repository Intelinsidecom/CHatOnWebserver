package com.sec.chaton.p055d.p056a;

import android.text.TextUtils;
import com.sec.chaton.chat.translate.EnumC1860m;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.TranslationAuthEntry;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;

/* compiled from: GetUserInfoTask.java */
/* renamed from: com.sec.chaton.d.a.cq */
/* loaded from: classes.dex */
public class C1971cq extends AbstractC1900a {

    /* renamed from: b */
    private String f7262b;

    public C1971cq(C2454e c2454e) {
        super(c2454e);
        this.f7262b = "GetUserInfoTask";
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        TranslationAuthEntry translationAuthEntry;
        int iM3114i = c0778b.m3114i();
        EnumC2464o enumC2464oM3107b = c0778b.m3107b();
        boolean zN = c0778b.m18954n();
        if (enumC2464oM3107b == EnumC2464o.SUCCESS) {
            translationAuthEntry = (TranslationAuthEntry) c0778b.m3110e();
        } else {
            translationAuthEntry = (TranslationAuthEntry) c0778b.mo18927o();
        }
        if (C4904y.f17872b) {
            C4904y.m18639b(String.format("afterRequest(), connectionSuccess(%s), httpResultCode(%s), httpStatus(%d), resultEntry(%s)", Boolean.valueOf(zN), enumC2464oM3107b, Integer.valueOf(iM3114i), translationAuthEntry), this.f7262b);
        }
        if (iM3114i == 200 && enumC2464oM3107b == EnumC2464o.SUCCESS) {
            String urlPrimary = translationAuthEntry.getUrlPrimary();
            if (!TextUtils.isEmpty(urlPrimary)) {
                C4809aa.m18104a().m18128b("primary_translation_address", urlPrimary);
            }
            String urlSecondary = translationAuthEntry.getUrlSecondary();
            if (!TextUtils.isEmpty(urlSecondary)) {
                C4809aa.m18104a().m18128b("secondary_translation_address", urlSecondary);
            }
            String str = translationAuthEntry.access_token;
            if (!TextUtils.isEmpty(str)) {
                C4809aa.m18104a().m18128b("translation_access_token", str);
            }
            c0778b.m3106a(new C1974ct(this, EnumC1860m.SUCCESS, translationAuthEntry));
            return;
        }
        c0778b.m3106a(new C1974ct(this, EnumC1860m.ERROR_FAILED_ABNORMAL, translationAuthEntry));
    }
}
