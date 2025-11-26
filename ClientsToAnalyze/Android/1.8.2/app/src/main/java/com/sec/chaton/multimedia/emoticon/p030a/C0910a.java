package com.sec.chaton.multimedia.emoticon.p030a;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import com.sec.chaton.multimedia.emoticon.entry.DownloadEmoticonEntry;
import com.sec.chaton.multimedia.emoticon.entry.GetPackageListEntry;
import com.sec.chaton.multimedia.emoticon.entry.InstallPackageEntry;
import com.sec.chaton.multimedia.emoticon.p030a.p031a.C0912b;
import com.sec.chaton.multimedia.emoticon.p030a.p031a.C0913c;
import com.sec.chaton.multimedia.emoticon.p030a.p031a.C0914d;
import com.sec.chaton.multimedia.emoticon.p034c.C0955b;
import com.sec.chaton.multimedia.emoticon.p034c.C0956c;
import com.sec.chaton.multimedia.emoticon.p034c.C0957d;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.C0800j;
import com.sec.chaton.p022h.C0802l;
import com.sec.chaton.p022h.EnumC0801k;
import com.sec.chaton.util.C1721ad;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.EnumC1765bu;
import java.net.URLEncoder;

/* compiled from: EmoticonMessageControl.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.a.a */
/* loaded from: classes.dex */
public class C0910a {

    /* renamed from: a */
    private Context f3376a;

    /* renamed from: b */
    private Handler f3377b;

    public C0910a(Context context, Handler handler) {
        this.f3376a = context;
        this.f3377b = handler;
    }

    /* renamed from: a */
    public C0913c m3669a(String str, String str2, int i) {
        C0913c c0913c = new C0913c(this.f3377b, new C0800j(EnumC1765bu.CONTACT, "/anicon/list-package").m3406a(EnumC0801k.GET).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3409a("lang", C1721ad.m5879f()).m3409a("platform", "android").m3409a("osversion", Build.VERSION.SDK).m3409a("model", URLEncoder.encode(C1721ad.m5876c())).m3409a("categoryid", str).m3409a("pixelsize", String.valueOf(i)).m3405a(1002).m3410b(C0956c.class).m3407a(GetPackageListEntry.class).m3404a());
        C0802l.m3412a().offer(c0913c);
        return c0913c;
    }

    /* renamed from: b */
    public C0914d m3670b(String str, String str2, int i) {
        C0914d c0914d = new C0914d(this.f3377b, new C0800j(EnumC1765bu.CONTACT, "/anicon/install-package").m3406a(EnumC0801k.GET).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3409a("lang", C1721ad.m5879f()).m3409a("platform", "android").m3409a("osversion", Build.VERSION.SDK).m3409a("model", URLEncoder.encode(C1721ad.m5876c())).m3409a("packageid", str).m3409a("filetype", str2).m3409a("pixelsize", String.valueOf(i)).m3409a("compressiontype", "zip").m3405a(1001).m3410b(C0957d.class).m3407a(InstallPackageEntry.class).m3404a());
        C0802l.m3412a().offer(c0914d);
        return c0914d;
    }

    /* renamed from: c */
    public C0101b m3671c(String str, String str2, int i) {
        return new C0912b(this.f3377b, new C0800j(EnumC1765bu.CONTACT, "/anicon/download").m3406a(EnumC0801k.GET).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3409a("lang", C1721ad.m5879f()).m3409a("platform", "android").m3409a("osversion", Build.VERSION.SDK).m3409a("aniconid", str).m3409a("filetype", str2).m3409a("pixelsize", String.valueOf(i)).m3409a("compressiontype", "zip").m3410b(C0955b.class).m3407a(DownloadEmoticonEntry.class).m3404a()).m2712e();
    }
}
