package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3164af;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3243r;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.LinkedHashMap;

/* compiled from: UpdateProfileImageHistoryTask.java */
/* renamed from: com.sec.chaton.d.a.ee */
/* loaded from: classes.dex */
public class C1258ee extends AbstractC1145a {

    /* renamed from: b */
    private String f4828b;

    public C1258ee(Handler handler, C1580h c1580h, String str) {
        super(handler, c1580h);
        this.f4828b = str;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        C3164af c3164af = new C3164af();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.f4828b != null) {
            linkedHashMap.put("profileimageid", this.f4828b);
        }
        String strM11026a = c3164af.m11026a((Object) linkedHashMap);
        C3250y.m11456e(strM11026a, getClass().getSimpleName());
        return strM11026a;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) throws Throwable {
        if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
            String str = C3223ck.m11329c() + "/profilehistory/";
            String str2 = CommonApplication.m11493l().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/";
            String strM10979a = C3159aa.m10962a().m10979a("chaton_id", "");
            C3159aa.m10966a("profile_image_status", "updated");
            String str3 = str + "profile_t_mine_" + this.f4828b;
            String str4 = str + "profile_f_mine_" + this.f4828b;
            String str5 = str2 + "myprofile.png_";
            C3205bt.m11182a(CommonApplication.m11493l()).m11227b(strM10979a);
            C3243r.m11420a(str3, str2 + strM10979a + ".jpeg_");
            C3243r.m11420a(str4, str5);
            return;
        }
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000004", "0103", c0267d);
        }
    }
}
