package com.sec.chaton.p055d;

import android.os.Handler;
import com.sec.chaton.p055d.p056a.C1983db;
import com.sec.chaton.p067j.C2456g;
import com.sec.chaton.p067j.C2472w;
import com.sec.chaton.p067j.EnumC2457h;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.EnumC4868cf;
import java.util.ArrayList;

/* compiled from: IgnoreControl.java */
/* renamed from: com.sec.chaton.d.p */
/* loaded from: classes.dex */
public class C2135p {

    /* renamed from: a */
    private Handler f7738a;

    /* renamed from: a */
    public static C2135p m9578a(Handler handler) {
        return new C2135p(handler);
    }

    private C2135p(Handler handler) {
        this.f7738a = handler;
    }

    /* renamed from: a */
    public void m9579a(String str, ArrayList<String> arrayList) {
        C2472w.m10687a().m10690b().m10662a(new C1983db(new C2456g(EnumC4868cf.CONTACT, "/buddyrecommendee/ignorelist").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10635a(), str, arrayList), 100, this.f7738a);
    }

    /* renamed from: a */
    public void m9580a(ArrayList<String> arrayList) {
        if (arrayList.size() > 0) {
            C2472w.m10687a().m10690b().m10662a(new C1983db(new C2456g(EnumC4868cf.CONTACT, "/buddyrecommendee/ignorelist").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10635a(), "true", arrayList), 103, this.f7738a);
        }
    }
}
