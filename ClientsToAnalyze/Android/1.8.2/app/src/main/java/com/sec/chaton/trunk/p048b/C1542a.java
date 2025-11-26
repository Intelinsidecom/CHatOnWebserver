package com.sec.chaton.trunk.p048b;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.p022h.C0800j;
import com.sec.chaton.p022h.EnumC0801k;
import com.sec.chaton.trunk.entry.GetCommentListEntry;
import com.sec.chaton.trunk.entry.GetItemEntry;
import com.sec.chaton.trunk.entry.GetItemListEntry;
import com.sec.chaton.trunk.entry.GetTrunkListEntry;
import com.sec.chaton.trunk.p048b.p049a.C1543a;
import com.sec.chaton.trunk.p048b.p049a.C1544b;
import com.sec.chaton.trunk.p048b.p049a.C1545c;
import com.sec.chaton.trunk.p048b.p049a.C1546d;
import com.sec.chaton.trunk.p048b.p049a.C1547e;
import com.sec.chaton.trunk.p048b.p049a.C1548f;
import com.sec.chaton.trunk.p048b.p049a.C1549g;
import com.sec.chaton.trunk.p048b.p049a.C1550h;
import com.sec.chaton.trunk.p050c.C1575g;
import com.sec.chaton.trunk.p051d.C1579c;
import com.sec.chaton.trunk.p051d.C1580d;
import com.sec.chaton.trunk.p051d.C1581e;
import com.sec.chaton.trunk.p051d.C1582f;
import com.sec.chaton.util.C1721ad;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.EnumC1765bu;
import java.util.List;

/* compiled from: TrunkMessageControl.java */
/* renamed from: com.sec.chaton.trunk.b.a */
/* loaded from: classes.dex */
public class C1542a {

    /* renamed from: a */
    private Context f5597a;

    /* renamed from: b */
    private Handler f5598b;

    public C1542a(Context context, Handler handler) {
        this.f5597a = context;
        this.f5598b = handler;
    }

    /* renamed from: a */
    public C1548f m5401a(List list) {
        C1548f c1548f = new C1548f(this.f5598b, new C0800j(EnumC1765bu.CONTACT, "/trunklist").m3406a(EnumC0801k.POST).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3405a(900).m3407a(GetTrunkListEntry.class).m3410b(C1582f.class).m3404a(), list);
        C1575g.m5447a().offer(c1548f);
        return c1548f;
    }

    /* renamed from: a */
    public C1546d m5398a(boolean z, String str, int i, EnumC1551b enumC1551b, int i2) {
        return m5399a(z, str, i, enumC1551b, i2, null);
    }

    /* renamed from: a */
    public C1546d m5399a(boolean z, String str, int i, EnumC1551b enumC1551b, int i2, String str2) {
        C0800j c0800jM3410b = new C0800j(EnumC1765bu.CONTACT, "/trunk/itemlist").m3406a(EnumC0801k.GET).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3409a("sessionid", str).m3409a("type", enumC1551b.m5406a()).m3409a("thumbnailsize", String.valueOf(i2)).m3409a("count", String.valueOf(i)).m3405a(902).m3407a(GetItemListEntry.class).m3410b(C1580d.class);
        if (!TextUtils.isEmpty(str2)) {
            c0800jM3410b.m3409a("startitemid", str2);
        }
        C1546d c1546d = new C1546d(this.f5598b, c0800jM3410b.m3404a(), z);
        C1575g.m5447a().offer(c1546d);
        return c1546d;
    }

    /* renamed from: a */
    public C1547e m5400a(String str, String str2, int i, int i2) {
        C1547e c1547e = new C1547e(this.f5598b, new C0800j(EnumC1765bu.CONTACT, "/trunk/item").m3406a(EnumC0801k.GET).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3409a("sessionid", str).m3409a("itemid", str2).m3409a("cmtlist", String.valueOf(i)).m3409a("thumbnailsize", String.valueOf(i2)).m3405a(901).m3407a(GetItemEntry.class).m3410b(C1581e.class).m3404a());
        if (C1575g.m5447a().offer(c1547e)) {
            return c1547e;
        }
        return null;
    }

    /* renamed from: a */
    public C1544b m5396a(String str, String str2) {
        C1544b c1544b = new C1544b(this.f5598b, new C0800j(EnumC1765bu.CONTACT, "/trunk/item").m3406a(EnumC0801k.DELETE).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3409a("sessionid", str).m3409a("itemid", str2).m3405a(905).m3404a());
        if (C1575g.m5447a().offer(c1544b)) {
            return c1544b;
        }
        return null;
    }

    /* renamed from: a */
    public C1545c m5397a(String str, String str2, String str3, int i) {
        C1545c c1545c = new C1545c(this.f5598b, new C0800j(EnumC1765bu.CONTACT, "/trunk/item/commentlist").m3406a(EnumC0801k.GET).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3409a("sessionid", str).m3409a("itemid", str2).m3409a("startcommentid", str3 == null ? String.valueOf(Integer.MAX_VALUE) : str3).m3409a("count", str3 == null ? String.valueOf(i) : String.valueOf(i + 1)).m3405a(903).m3407a(GetCommentListEntry.class).m3410b(C1579c.class).m3404a());
        if (C1575g.m5447a().offer(c1545c)) {
            return c1545c;
        }
        return null;
    }

    /* renamed from: a */
    public C1543a m5395a(String str, String str2, String str3) {
        C1543a c1543a = new C1543a(this.f5598b, new C0800j(EnumC1765bu.CONTACT, "/trunk/item/comment").m3406a(EnumC0801k.POST).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3405a(904).m3404a(), str, str2, str3);
        if (C1575g.m5447a().offer(c1543a)) {
            return c1543a;
        }
        return null;
    }

    /* renamed from: b */
    public C1550h m5403b(String str, String str2, String str3) {
        C1550h c1550h = new C1550h(this.f5598b, new C0800j(EnumC1765bu.CONTACT, "/trunk/item/comment").m3406a(EnumC0801k.DELETE).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3409a("sessionid", str).m3409a("itemid", str2).m3409a("commentid", str3).m3405a(906).m3404a());
        if (C1575g.m5447a().offer(c1550h)) {
            return c1550h;
        }
        return null;
    }

    /* renamed from: b */
    public C1549g m5402b(String str, String str2) {
        C1549g c1549g = new C1549g(this.f5598b, new C0800j(EnumC1765bu.CONTACT, "/trunk/item/markAsRead").m3406a(EnumC0801k.GET).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3409a("sessionid", str).m3409a("itemid", str2).m3405a(907).m3404a());
        if (C1575g.m5447a().offer(c1549g)) {
            return c1549g;
        }
        return null;
    }
}
