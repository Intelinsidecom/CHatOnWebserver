package com.sec.chaton.shop.p099a;

import android.os.Build;
import android.os.Handler;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p051c.C1428b;
import com.sec.chaton.p067j.C2456g;
import com.sec.chaton.p067j.C2472w;
import com.sec.chaton.p067j.EnumC2457h;
import com.sec.chaton.settings.p096a.C3474r;
import com.sec.chaton.shop.entrys.DownloadRequestEntry;
import com.sec.chaton.shop.entrys.ItemCharacterEntry;
import com.sec.chaton.shop.entrys.UploadPurchaseListEntry;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.EnumC4868cf;
import com.sec.common.util.C5034k;
import java.net.URLEncoder;
import java.util.concurrent.Future;

/* compiled from: ShopControl.java */
/* renamed from: com.sec.chaton.shop.a.e */
/* loaded from: classes.dex */
public class C3707e {

    /* renamed from: a */
    private Handler f13345a;

    /* renamed from: a */
    public static C3707e m13998a(Handler handler) {
        return new C3707e(handler);
    }

    private C3707e(Handler handler) {
        this.f13345a = handler;
    }

    /* renamed from: a */
    public C3708f m13999a() {
        C3708f c3708f = new C3708f(new C2456g(EnumC4868cf.SHOP, C1428b.f5101g).m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10639a(UploadPurchaseListEntry.class).m10643b(C3709g.class).m10640a("application/json").m10635a());
        C2472w.m10687a().m10691c().m10662a(c3708f, 0, this.f13345a);
        return c3708f;
    }

    /* renamed from: b */
    public C3703a m14002b() {
        C3703a c3703a = new C3703a(new C2456g(EnumC4868cf.CONTACT, C1428b.f5103i).m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a(C1428b.f5093I, C4822an.m18248p()).m10641a("countrycd", C4822an.m18257y()).m10639a(ItemCharacterEntry.class).m10643b(C3704b.class).m10640a("application/json").m10635a());
        C2472w.m10687a().m10691c().m10662a(c3703a, 1, this.f13345a);
        return c3703a;
    }

    /* renamed from: a */
    public Future<C0778b> m14001a(String str, String str2) {
        return C2472w.m10687a().m10691c().m10662a(new C3705c(new C2456g(EnumC4868cf.CONTACT, C1428b.f5104j).m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a(C1428b.f5093I, C4822an.m18248p()).m10641a(C1428b.f5094J, C4822an.m18257y()).m10641a(C1428b.f5092H, str).m10641a("dvwidth", Integer.toString(C5034k.m19100e())).m10641a("dvheight", Integer.toString(C5034k.m19101f())).m10641a("platform", "android").m10641a("osversion", Build.VERSION.SDK).m10641a("model", URLEncoder.encode(C4822an.m18231e())).m10639a(DownloadRequestEntry.class).m10643b(C3706d.class).m10640a("application/json").m10635a()), 2, this.f13345a);
    }

    /* renamed from: a */
    public Future<C0778b> m14000a(String str) {
        return C2472w.m10687a().m10691c().m10662a(new C3705c(new C2456g(EnumC4868cf.CONTACT, C1428b.f5105k).m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a(C1428b.f5092H, str).m10641a(C1428b.f5093I, C4822an.m18248p()).m10641a(C1428b.f5094J, C4822an.m18257y()).m10641a("stWidth", Integer.toString(C3474r.m13810a())).m10641a("stHeight", Integer.toString(C3474r.m13810a())).m10641a("dvLandscape", Integer.toString(C5034k.m19100e())).m10641a("dvPortrait", Integer.toString(C5034k.m19101f())).m10641a("bgtype", Integer.toString(2)).m10641a("platform", "android").m10641a("osversion", Build.VERSION.SDK).m10641a("model", URLEncoder.encode(C4822an.m18231e())).m10639a(DownloadRequestEntry.class).m10643b(C3706d.class).m10640a("application/json").m10635a()), 3, this.f13345a);
    }

    /* renamed from: b */
    public Future<C0778b> m14003b(String str) {
        return C2472w.m10687a().m10691c().m10662a(new C3705c(new C2456g(EnumC4868cf.CONTACT, C1428b.f5106l).m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a(C1428b.f5092H, str).m10641a(C1428b.f5093I, C4822an.m18248p()).m10641a(C1428b.f5094J, C4822an.m18257y()).m10641a("fileType", "mp3").m10641a("platform", "android").m10641a("osversion", Build.VERSION.SDK).m10641a("model", URLEncoder.encode(C4822an.m18231e())).m10639a(DownloadRequestEntry.class).m10643b(C3706d.class).m10640a("application/json").m10635a()), 4, this.f13345a);
    }
}
