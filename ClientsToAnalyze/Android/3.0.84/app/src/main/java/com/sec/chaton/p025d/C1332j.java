package com.sec.chaton.p025d;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.p025d.p026a.C1166au;
import com.sec.chaton.p025d.p026a.C1198bz;
import com.sec.chaton.p025d.p026a.C1223cx;
import com.sec.chaton.p025d.p026a.C1264ek;
import com.sec.chaton.p025d.p026a.EnumC1172b;
import com.sec.chaton.p035io.entry.DownloadEmoticonEntry;
import com.sec.chaton.p035io.entry.GetPackageListEntry;
import com.sec.chaton.p035io.entry.InstallPackageEntry;
import com.sec.chaton.p035io.entry.ViewPackageEntry;
import com.sec.chaton.p035io.p036a.C1537b;
import com.sec.chaton.p037j.C1582j;
import com.sec.chaton.p037j.C1595w;
import com.sec.chaton.p037j.EnumC1583k;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.EnumC3219cg;
import java.net.URLEncoder;

/* compiled from: EmoticonMessageControl.java */
/* renamed from: com.sec.chaton.d.j */
/* loaded from: classes.dex */
public class C1332j {

    /* renamed from: a */
    private Handler f5031a;

    public C1332j(Context context, Handler handler) {
        this.f5031a = handler;
    }

    /* renamed from: a */
    public C1198bz m5767a(EnumC1172b enumC1172b, String str, String str2, int i) {
        C1198bz c1198bz = new C1198bz(this.f5031a, new C1582j(EnumC3219cg.CONTACT, "/anicon/list-package").m6710a(EnumC1583k.GET).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("lang", C3171am.m11074l()).m6714a("platform", "android").m6714a("osversion", Build.VERSION.SDK).m6714a("model", URLEncoder.encode(C3171am.m11055b())).m6714a("categoryid", str).m6714a("pixelsize", String.valueOf(i)).m6714a("anicontype", "1").m6709a(1002).m6717b(C1537b.class).m6712a(GetPackageListEntry.class).m6708a(), enumC1172b);
        C1595w.m6742a().m6746c().m6723a(c1198bz);
        return c1198bz;
    }

    /* renamed from: a */
    public C1264ek m5768a(EnumC1172b enumC1172b, String str, int i) {
        C1264ek c1264ek = new C1264ek(this.f5031a, new C1582j(EnumC3219cg.CONTACT, "/anicon/view-package").m6710a(EnumC1583k.GET).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("lang", C3171am.m11074l()).m6714a("platform", "android").m6714a("osversion", Build.VERSION.SDK).m6714a("model", URLEncoder.encode(C3171am.m11055b())).m6714a("packageid", str).m6714a("anicontype", "1").m6714a("pixelsize", String.valueOf(i)).m6709a(1000).m6717b(C1537b.class).m6712a(ViewPackageEntry.class).m6708a(), enumC1172b);
        C1595w.m6742a().m6746c().m6723a(c1264ek);
        return c1264ek;
    }

    /* renamed from: a */
    public C1264ek m5769a(String str, String str2, int i) {
        C1582j c1582jM6712a = new C1582j(EnumC3219cg.CONTACT, "/anicon/view-package").m6710a(EnumC1583k.GET).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("lang", C3171am.m11074l()).m6714a("platform", "android").m6714a("osversion", Build.VERSION.SDK).m6714a("model", URLEncoder.encode(C3171am.m11055b())).m6714a("symbol", str2).m6714a("pixelsize", String.valueOf(i)).m6709a(1000).m6717b(C1537b.class).m6712a(ViewPackageEntry.class);
        if (TextUtils.isEmpty(str)) {
            c1582jM6712a.m6714a("packageid", "-1");
        }
        C1264ek c1264ek = new C1264ek(this.f5031a, c1582jM6712a.m6708a());
        C1595w.m6742a().m6746c().m6723a(c1264ek);
        return c1264ek;
    }

    /* renamed from: b */
    public C1223cx m5770b(EnumC1172b enumC1172b, String str, String str2, int i) {
        C1223cx c1223cx = new C1223cx(this.f5031a, new C1582j(EnumC3219cg.CONTACT, "/anicon/install-package").m6710a(EnumC1583k.GET).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("lang", C3171am.m11074l()).m6714a("platform", "android").m6714a("osversion", Build.VERSION.SDK).m6714a("model", URLEncoder.encode(C3171am.m11055b())).m6714a("packageid", str).m6714a("filetype", str2).m6714a("pixelsize", String.valueOf(i)).m6714a("compressiontype", "zip").m6714a("anicontype", "1").m6709a(1001).m6717b(C1537b.class).m6712a(InstallPackageEntry.class).m6708a(), enumC1172b);
        C1595w.m6742a().m6746c().m6723a(c1223cx);
        return c1223cx;
    }

    /* renamed from: c */
    public C1166au m5771c(EnumC1172b enumC1172b, String str, String str2, int i) {
        C1166au c1166au = new C1166au(this.f5031a, new C1582j(EnumC3219cg.CONTACT, "/anicon/download").m6710a(EnumC1583k.GET).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("lang", C3171am.m11074l()).m6714a("platform", "android").m6714a("osversion", Build.VERSION.SDK).m6714a("aniconid", str).m6714a("filetype", str2).m6714a("pixelsize", String.valueOf(i)).m6714a("compressiontype", "zip").m6714a("anicontype", "1").m6717b(C1537b.class).m6712a(DownloadEmoticonEntry.class).m6708a(), enumC1172b);
        C1595w.m6742a().m6746c().m6723a(c1166au);
        return c1166au;
    }
}
