package com.sec.chaton.p055d.p056a;

import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p063i.p064a.C2404a;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4815ag;
import com.sec.chaton.util.C4904y;
import java.util.LinkedHashMap;

/* compiled from: SetPrivacyTask.java */
/* renamed from: com.sec.chaton.d.a.eq */
/* loaded from: classes.dex */
public class C2025eq extends AbstractC1900a {

    /* renamed from: b */
    private String f7423b;

    /* renamed from: c */
    private boolean f7424c;

    public C2025eq(C2454e c2454e, String str, boolean z) {
        super(c2454e);
        this.f7423b = str;
        this.f7424c = z;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        C4815ag c4815ag = new C4815ag();
        LinkedHashMap linkedHashMap = new LinkedHashMap(5);
        linkedHashMap.put("privacy", this.f7423b);
        linkedHashMap.put("value", this.f7424c ? "true" : "false");
        String strM18172a = c4815ag.m18172a((Object) linkedHashMap);
        C4904y.m18646e(strM18172a, getClass().getSimpleName());
        return strM18172a;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        if (c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.SUCCESS) {
            if (this.f7423b != null && this.f7423b.equals("phonenumber")) {
                C4809aa.m18105a("show_phone_number_to_all", Boolean.valueOf(this.f7424c));
                return;
            }
            if (this.f7423b != null && this.f7423b.equals("showprofileimage")) {
                C4809aa.m18105a("samsung_profile_image_show", Boolean.valueOf(this.f7424c));
                return;
            }
            if (this.f7423b != null && this.f7423b.equals("emailsamsung")) {
                C4809aa.m18105a("samsung_account_show", Boolean.valueOf(this.f7424c));
                return;
            }
            if (this.f7423b != null && this.f7423b.equals("typingindication")) {
                C4809aa.m18105a("Typing status", Boolean.valueOf(this.f7424c));
                return;
            }
            if (this.f7423b != null && this.f7423b.equals("showsnsid")) {
                C4809aa.m18105a("sns_account_show", Boolean.valueOf(this.f7424c));
                return;
            }
            if (this.f7423b != null && this.f7423b.equals("ignorerecommendation")) {
                C4809aa.m18105a("exclude_me", Boolean.valueOf(this.f7424c));
                return;
            } else {
                if (this.f7423b != null && this.f7423b.equals("recommendationbuddy")) {
                    C4809aa.m18105a("recomned_receive", Boolean.valueOf(this.f7424c));
                    return;
                }
                return;
            }
        }
        C2404a.m10430a("01000099", "0002", c0778b);
    }
}
