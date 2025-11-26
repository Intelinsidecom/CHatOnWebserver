package com.sec.chaton.p055d;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.p056a.C1921au;
import com.sec.chaton.p055d.p056a.C2045fj;
import com.sec.chaton.p065io.entry.DownloadEmoticonEntry;
import com.sec.chaton.p065io.entry.ViewPackageEntry;
import com.sec.chaton.p065io.p066a.C2407b;
import com.sec.chaton.p067j.C2456g;
import com.sec.chaton.p067j.C2472w;
import com.sec.chaton.p067j.EnumC2457h;
import com.sec.chaton.p067j.EnumC2463n;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.EnumC4868cf;
import java.net.URLEncoder;
import java.util.concurrent.Future;

/* compiled from: EmoticonMessageControl.java */
/* renamed from: com.sec.chaton.d.l */
/* loaded from: classes.dex */
public class C2131l {

    /* renamed from: a */
    private Handler f7735a;

    /* renamed from: a */
    public static C2131l m9549a(Context context, Handler handler) {
        return new C2131l(context, handler);
    }

    public C2131l(Context context, Handler handler) {
        this.f7735a = handler;
    }

    /* renamed from: a */
    public Future<C0778b> m9550a(EnumC2463n enumC2463n, String str, int i) {
        return C2472w.m10687a().m10691c().m10664a(new C2045fj(new C2456g(EnumC4868cf.CONTACT, "/anicon/view-package").m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a(VKApiConst.LANG, C4822an.m18247o()).m10641a("platform", "android").m10641a("osversion", Build.VERSION.SDK).m10641a("model", URLEncoder.encode(C4822an.m18231e())).m10641a("packageid", str).m10641a("anicontype", Spam.ACTIVITY_REPORT).m10641a("pixelsize", String.valueOf(i)).m10643b(C2407b.class).m10639a(ViewPackageEntry.class).m10635a()), enumC2463n, 1000, this.f7735a);
    }

    /* renamed from: a */
    public Future<C0778b> m9551a(EnumC2463n enumC2463n, String str, String str2, int i) {
        return C2472w.m10687a().m10691c().m10663a(new C1921au(new C2456g(EnumC4868cf.CONTACT, "/anicon/download").m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a(VKApiConst.LANG, C4822an.m18247o()).m10641a("platform", "android").m10641a("osversion", Build.VERSION.SDK).m10641a("aniconid", str).m10641a("filetype", str2).m10641a("pixelsize", String.valueOf(i)).m10641a("compressiontype", "zip").m10641a("anicontype", Spam.ACTIVITY_REPORT).m10643b(C2407b.class).m10639a(DownloadEmoticonEntry.class).m10635a()), enumC2463n);
    }
}
