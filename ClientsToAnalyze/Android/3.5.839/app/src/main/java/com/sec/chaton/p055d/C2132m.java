package com.sec.chaton.p055d;

import android.os.Build;
import android.os.Handler;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p055d.p056a.C1931bd;
import com.sec.chaton.p055d.p056a.C1978cx;
import com.sec.chaton.p065io.entry.GLDFeaturePolicyEntry;
import com.sec.chaton.p065io.entry.GetSSMServerAddress4;
import com.sec.chaton.p065io.p066a.C2407b;
import com.sec.chaton.p067j.C2456g;
import com.sec.chaton.p067j.C2472w;
import com.sec.chaton.p067j.EnumC2457h;
import com.sec.chaton.p067j.EnumC2463n;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.EnumC4868cf;
import java.net.URLEncoder;

/* compiled from: GLDControl.java */
/* renamed from: com.sec.chaton.d.m */
/* loaded from: classes.dex */
public class C2132m {

    /* renamed from: a */
    private Handler f7736a;

    public C2132m(Handler handler) {
        this.f7736a = handler;
    }

    /* renamed from: a */
    public void m9552a() {
        C2472w.m10687a().m10690b().m10664a(m9555b(), EnumC2463n.SYSTEM, 104, this.f7736a);
    }

    /* renamed from: a */
    public void m9553a(String str) {
        C2472w.m10687a().m10690b().m10664a(m9556b(str), EnumC2463n.SYSTEM, 104, this.f7736a);
    }

    /* renamed from: b */
    public C1931bd m9556b(String str) {
        return new C1931bd(new C2456g(EnumC4868cf.GLD, "/prov4").m10641a("imei", C4822an.m18228d()).m10641a("imsi", C4822an.m18238h()).m10641a("model", URLEncoder.encode(C4822an.m18231e())).m10641a("clientversion", C1427a.f5063a + str).m10641a("platform", "android").m10641a("osversion", Build.VERSION.SDK).m10641a("screensize", C4822an.m18250r()).m10639a(GetSSMServerAddress4.class).m10637a(EnumC2457h.GET).m10635a());
    }

    /* renamed from: b */
    public C1931bd m9555b() {
        String strM18121a = C4809aa.m18104a().m18121a("operation", ".NONE");
        String str = C1427a.f5063a;
        if (!strM18121a.equals(".NONE")) {
            str = str + strM18121a;
        }
        return new C1931bd(new C2456g(EnumC4868cf.GLD, "/prov4").m10641a("imei", C4822an.m18228d()).m10641a("imsi", C4822an.m18238h()).m10641a("model", URLEncoder.encode(C4822an.m18231e())).m10641a("clientversion", str).m10641a("platform", "android").m10641a("osversion", Build.VERSION.SDK).m10641a("screensize", C4822an.m18250r()).m10639a(GetSSMServerAddress4.class).m10637a(EnumC2457h.GET).m10635a());
    }

    /* renamed from: a */
    public void m9554a(String str, String str2) {
        C2472w.m10687a().m10690b().m10662a(new C1931bd(new C2456g(EnumC4868cf.GLD, "/prov4").m10641a("imei", C4822an.m18228d()).m10641a("countrycallingcode", str).m10641a("phonenumber", str2).m10641a("imsi", C4822an.m18238h()).m10641a("model", URLEncoder.encode(C4822an.m18231e())).m10641a("clientversion", C1427a.f5063a).m10641a("platform", "android").m10641a("osversion", Build.VERSION.SDK).m10641a("screensize", C4822an.m18250r()).m10639a(GetSSMServerAddress4.class).m10637a(EnumC2457h.GET).m10635a()), 104, this.f7736a);
    }

    /* renamed from: c */
    public void m9557c() {
        C2472w.m10687a().m10690b().m10662a(new C1978cx(new C2456g(EnumC4868cf.GLD, "/featurepolicy").m10637a(EnumC2457h.GET).m10641a("imsi", C4822an.m18238h()).m10641a("model", URLEncoder.encode(C4822an.m18231e())).m10641a("clientversion", C1427a.f5063a).m10641a("platform", "android").m10641a("osversion", Build.VERSION.SDK).m10641a("screensize", C4822an.m18250r()).m10641a("density", C4822an.m18192B()).m10639a(GLDFeaturePolicyEntry.class).m10643b(C2407b.class).m10635a()), 150, this.f7736a);
    }
}
