package com.sec.chaton.p025d;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import com.sec.chaton.p025d.p026a.C1208ci;
import com.sec.chaton.p025d.p026a.C1224cy;
import com.sec.chaton.p025d.p026a.EnumC1172b;
import com.sec.chaton.p035io.entry.GetSoundListEntry;
import com.sec.chaton.p035io.entry.InstallSoundEntry;
import com.sec.chaton.p035io.p036a.C1537b;
import com.sec.chaton.p037j.C1582j;
import com.sec.chaton.p037j.C1595w;
import com.sec.chaton.p037j.EnumC1583k;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.EnumC3219cg;
import java.net.URLEncoder;

/* compiled from: SoundMessageControl.java */
/* renamed from: com.sec.chaton.d.bc */
/* loaded from: classes.dex */
public class C1317bc {

    /* renamed from: a */
    private Handler f4983a;

    public C1317bc(Context context, Handler handler) {
        this.f4983a = handler;
    }

    /* renamed from: a */
    public C1208ci m5671a(EnumC1172b enumC1172b, String str) {
        C1208ci c1208ci = new C1208ci(this.f4983a, new C1582j(EnumC3219cg.CONTACT, "/effectsound").m6710a(EnumC1583k.GET).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("platform", "android").m6714a("osversion", Build.VERSION.SDK).m6714a("model", URLEncoder.encode(C3171am.m11055b())).m6714a("filetype", str).m6714a("lang", C3171am.m11074l()).m6709a(1000).m6717b(C1537b.class).m6712a(GetSoundListEntry.class).m6708a(), enumC1172b);
        C1595w.m6742a().m6746c().m6723a(c1208ci);
        return c1208ci;
    }

    /* renamed from: a */
    public C1224cy m5672a(EnumC1172b enumC1172b, String str, String str2) {
        C1224cy c1224cy = new C1224cy(this.f4983a, new C1582j(EnumC3219cg.CONTACT, "/effectsound/download").m6710a(EnumC1583k.GET).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("id", str).m6714a("filetype", str2).m6709a(1001).m6717b(C1537b.class).m6712a(InstallSoundEntry.class).m6708a(), enumC1172b);
        C1595w.m6742a().m6746c().m6723a(c1224cy);
        return c1224cy;
    }
}
