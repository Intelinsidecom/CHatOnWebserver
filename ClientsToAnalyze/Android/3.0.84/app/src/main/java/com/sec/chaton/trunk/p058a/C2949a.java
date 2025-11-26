package com.sec.chaton.trunk.p058a;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.p035io.p036a.C1537b;
import com.sec.chaton.p037j.C1582j;
import com.sec.chaton.p037j.C1595w;
import com.sec.chaton.p037j.EnumC1583k;
import com.sec.chaton.settings2.PrefFragmentChats;
import com.sec.chaton.trunk.entry.GetCommentListEntry;
import com.sec.chaton.trunk.entry.GetItemEntry;
import com.sec.chaton.trunk.entry.GetItemListEntry;
import com.sec.chaton.trunk.entry.GetTrunkListEntry;
import com.sec.chaton.trunk.p058a.p059a.C2950a;
import com.sec.chaton.trunk.p058a.p059a.C2951b;
import com.sec.chaton.trunk.p058a.p059a.C2952c;
import com.sec.chaton.trunk.p058a.p059a.C2953d;
import com.sec.chaton.trunk.p058a.p059a.C2954e;
import com.sec.chaton.trunk.p058a.p059a.C2955f;
import com.sec.chaton.trunk.p058a.p059a.C2956g;
import com.sec.chaton.trunk.p058a.p059a.C2957h;
import com.sec.chaton.trunk.p058a.p059a.C2958i;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.EnumC3219cg;
import java.util.List;

/* compiled from: TrunkMessageControl.java */
/* renamed from: com.sec.chaton.trunk.a.a */
/* loaded from: classes.dex */
public class C2949a {

    /* renamed from: a */
    private Context f10712a;

    /* renamed from: b */
    private Handler f10713b;

    public C2949a(Context context, Handler handler) {
        this.f10712a = context;
        this.f10713b = handler;
    }

    /* renamed from: a */
    public C2955f m10427a(List<String> list) {
        C2955f c2955f = new C2955f(this.f10713b, new C1582j(EnumC3219cg.CONTACT, "/trunklist").m6710a(EnumC1583k.POST).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6709a(900).m6712a(GetTrunkListEntry.class).m6717b(C1537b.class).m6708a(), list);
        C1595w.m6742a().m6746c().m6723a(c2955f);
        return c2955f;
    }

    /* renamed from: a */
    public C2953d m10423a(boolean z, String str, int i, EnumC2959b enumC2959b, int i2) {
        return m10424a(z, str, i, enumC2959b, i2, null);
    }

    /* renamed from: a */
    public C2953d m10424a(boolean z, String str, int i, EnumC2959b enumC2959b, int i2, String str2) {
        C1582j c1582jM6717b = new C1582j(EnumC3219cg.CONTACT, "/trunk/itemlist").m6710a(EnumC1583k.GET).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("sessionid", str).m6714a(PrefFragmentChats.TYPE, enumC2959b.m10434a()).m6714a("thumbnailsize", String.valueOf(i2)).m6714a("count", String.valueOf(i)).m6709a(902).m6712a(GetItemListEntry.class).m6717b(C1537b.class);
        if (!TextUtils.isEmpty(str2)) {
            c1582jM6717b.m6714a("startitemid", str2);
        }
        C2953d c2953d = new C2953d(this.f10713b, c1582jM6717b.m6708a(), z);
        C1595w.m6742a().m6746c().m6723a(c2953d);
        return c2953d;
    }

    /* renamed from: a */
    public C2954e m10425a(String str, String str2, int i, int i2) {
        C2954e c2954e = new C2954e(this.f10713b, new C1582j(EnumC3219cg.CONTACT, "/trunk/item").m6710a(EnumC1583k.GET).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("sessionid", str).m6714a("itemid", str2).m6714a("cmtlist", String.valueOf(i)).m6714a("thumbnailsize", String.valueOf(i2)).m6714a("startcommentid", String.valueOf(1)).m6714a("order", "asc").m6709a(901).m6712a(GetItemEntry.class).m6717b(C1537b.class).m6708a());
        C1595w.m6742a().m6746c().m6723a(c2954e);
        return c2954e;
    }

    /* renamed from: a */
    public C2954e m10426a(String str, String str2, String str3, int i, int i2) {
        C2954e c2954e = new C2954e(this.f10713b, new C1582j(EnumC3219cg.CONTACT, "/trunk/item").m6710a(EnumC1583k.POST).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6709a(901).m6712a(GetItemEntry.class).m6717b(C1537b.class).m6708a(), true, str, str2, str3, i, i2);
        C1595w.m6742a().m6746c().m6723a(c2954e);
        return c2954e;
    }

    /* renamed from: a */
    public C2951b m10421a(String str, String str2) {
        C2951b c2951b = new C2951b(this.f10713b, new C1582j(EnumC3219cg.CONTACT, "/trunk/item").m6710a(EnumC1583k.DELETE).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("sessionid", str).m6714a("itemid", str2).m6709a(905).m6708a());
        C1595w.m6742a().m6746c().m6723a(c2951b);
        return c2951b;
    }

    /* renamed from: a */
    public C2952c m10422a(String str, String str2, String str3, int i) {
        C2952c c2952c = new C2952c(this.f10713b, new C1582j(EnumC3219cg.CONTACT, "/trunk/item/commentlist").m6710a(EnumC1583k.GET).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("sessionid", str).m6714a("itemid", str2).m6714a("startcommentid", str3 == null ? String.valueOf(1) : str3).m6714a("count", str3 == null ? String.valueOf(i) : String.valueOf(i + 1)).m6714a("order", "asc").m6709a(903).m6712a(GetCommentListEntry.class).m6717b(C1537b.class).m6708a());
        C1595w.m6742a().m6746c().m6723a(c2952c);
        return c2952c;
    }

    /* renamed from: a */
    public C2950a m10420a(String str, String str2, String str3) {
        C2950a c2950a = new C2950a(this.f10713b, new C1582j(EnumC3219cg.CONTACT, "/trunk/item/comment").m6710a(EnumC1583k.POST).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6709a(904).m6708a(), str, str2, str3);
        C1595w.m6742a().m6746c().m6723a(c2950a);
        return c2950a;
    }

    /* renamed from: a */
    public C2957h m10428a(List<String> list, String str) {
        C2957h c2957h = new C2957h(this.f10713b, new C1582j(EnumC3219cg.CONTACT, "/trunk/delitems").m6710a(EnumC1583k.POST).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("sessionid", str).m6709a(908).m6708a(), list);
        C1595w.m6742a().m6746c().m6723a(c2957h);
        return c2957h;
    }

    /* renamed from: b */
    public C2958i m10430b(String str, String str2, String str3) {
        C2958i c2958i = new C2958i(this.f10713b, new C1582j(EnumC3219cg.CONTACT, "/trunk/item/comment").m6710a(EnumC1583k.DELETE).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("sessionid", str).m6714a("itemid", str2).m6714a("commentid", str3).m6709a(906).m6708a());
        C1595w.m6742a().m6746c().m6723a(c2958i);
        return c2958i;
    }

    /* renamed from: b */
    public C2956g m10429b(String str, String str2) {
        C2956g c2956g = new C2956g(this.f10713b, new C1582j(EnumC3219cg.CONTACT, "/trunk/item/markAsRead").m6710a(EnumC1583k.GET).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("sessionid", str).m6714a("itemid", str2).m6709a(907).m6708a());
        C1595w.m6742a().m6746c().m6723a(c2956g);
        return c2956g;
    }
}
