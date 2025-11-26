package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3164af;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.LinkedHashMap;

/* compiled from: SetPrivacyTask.java */
/* renamed from: com.sec.chaton.d.a.ds */
/* loaded from: classes.dex */
public class C1245ds extends AbstractC1145a {

    /* renamed from: b */
    private String f4808b;

    /* renamed from: c */
    private boolean f4809c;

    public C1245ds(Handler handler, C1580h c1580h, String str, boolean z) {
        super(handler, c1580h);
        this.f4808b = str;
        this.f4809c = z;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        C3164af c3164af = new C3164af();
        LinkedHashMap linkedHashMap = new LinkedHashMap(5);
        linkedHashMap.put("privacy", this.f4808b);
        linkedHashMap.put("value", this.f4809c ? "true" : "false");
        String strM11026a = c3164af.m11026a((Object) linkedHashMap);
        C3250y.m11456e(strM11026a, getClass().getSimpleName());
        return strM11026a;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        if (c0267d.m11704n() && c0267d.m1351b() == EnumC1587o.SUCCESS) {
            if (this.f4808b != null && this.f4808b.equals("phonenumber")) {
                C3159aa.m10963a("show_phone_number_to_all", Boolean.valueOf(this.f4809c));
                return;
            }
            if (this.f4808b != null && this.f4808b.equals("showprofileimage")) {
                C3159aa.m10963a("samsung_profile_image_show", Boolean.valueOf(this.f4809c));
                return;
            }
            if (this.f4808b != null && this.f4808b.equals("emailsamsung")) {
                C3159aa.m10963a("samsung_account_show", Boolean.valueOf(this.f4809c));
                return;
            } else {
                if (this.f4808b != null && this.f4808b.equals("typingindication")) {
                    C3159aa.m10963a("Typing status", Boolean.valueOf(this.f4809c));
                    return;
                }
                return;
            }
        }
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000099", "0002", c0267d);
        }
    }
}
