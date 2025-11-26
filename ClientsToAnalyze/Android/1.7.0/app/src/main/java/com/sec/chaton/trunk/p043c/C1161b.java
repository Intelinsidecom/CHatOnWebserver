package com.sec.chaton.trunk.p043c;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.p018c.C0519z;
import com.sec.chaton.p018c.EnumC0511r;
import com.sec.chaton.trunk.entry.GetCommentListEntry;
import com.sec.chaton.trunk.entry.GetItemEntry;
import com.sec.chaton.trunk.entry.GetItemListEntry;
import com.sec.chaton.trunk.entry.GetTrunkListEntry;
import com.sec.chaton.trunk.p041a.C1097a;
import com.sec.chaton.trunk.p041a.C1099c;
import com.sec.chaton.trunk.p041a.C1100d;
import com.sec.chaton.trunk.p041a.C1102f;
import com.sec.chaton.trunk.p042b.C1132c;
import com.sec.chaton.trunk.p043c.p044a.C1153a;
import com.sec.chaton.trunk.p043c.p044a.C1154b;
import com.sec.chaton.trunk.p043c.p044a.C1155c;
import com.sec.chaton.trunk.p043c.p044a.C1156d;
import com.sec.chaton.trunk.p043c.p044a.C1157e;
import com.sec.chaton.trunk.p043c.p044a.C1158f;
import com.sec.chaton.trunk.p043c.p044a.C1159g;
import com.sec.chaton.trunk.p043c.p044a.C1160h;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1336k;
import com.sec.chaton.util.EnumC1333h;
import java.util.List;

/* compiled from: TrunkMessageControl.java */
/* renamed from: com.sec.chaton.trunk.c.b */
/* loaded from: classes.dex */
public class C1161b {

    /* renamed from: a */
    private Context f4009a;

    /* renamed from: b */
    private Handler f4010b;

    public C1161b(Context context, Handler handler) {
        this.f4009a = context;
        this.f4010b = handler;
    }

    /* renamed from: a */
    public C1159g m4198a(List list) {
        C1159g c1159g = new C1159g(this.f4010b, new C0519z(EnumC1333h.CONTACT, "/trunklist").m2581a(EnumC0511r.POST).m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("imei", C1336k.m4621a()).m2580a(900).m2582a(GetTrunkListEntry.class).m2586b(C1099c.class).m2579a(), list);
        C1132c.m4162a().offer(c1159g);
        return c1159g;
    }

    /* renamed from: a */
    public C1155c m4195a(boolean z, String str, int i, EnumC1152a enumC1152a, int i2) {
        return m4196a(z, str, i, enumC1152a, i2, null);
    }

    /* renamed from: a */
    public C1155c m4196a(boolean z, String str, int i, EnumC1152a enumC1152a, int i2, String str2) {
        C0519z c0519zM2586b = new C0519z(EnumC1333h.CONTACT, "/trunk/itemlist").m2581a(EnumC0511r.GET).m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("imei", C1336k.m4621a()).m2584a("sessionid", str).m2584a("type", enumC1152a.m4192a()).m2584a("thumbnailsize", String.valueOf(i2)).m2584a("count", String.valueOf(i)).m2580a(902).m2582a(GetItemListEntry.class).m2586b(C1102f.class);
        if (!TextUtils.isEmpty(str2)) {
            c0519zM2586b.m2584a("startitemid", str2);
        }
        C1155c c1155c = new C1155c(this.f4010b, c0519zM2586b.m2579a(), z);
        C1132c.m4162a().offer(c1155c);
        return c1155c;
    }

    /* renamed from: a */
    public C1160h m4199a(String str, String str2, int i, int i2) {
        C1160h c1160h = new C1160h(this.f4010b, new C0519z(EnumC1333h.CONTACT, "/trunk/item").m2581a(EnumC0511r.GET).m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("imei", C1336k.m4621a()).m2584a("sessionid", str).m2584a("itemid", str2).m2584a("cmtlist", String.valueOf(i)).m2584a("thumbnailsize", String.valueOf(i2)).m2580a(901).m2582a(GetItemEntry.class).m2586b(C1100d.class).m2579a());
        if (C1132c.m4162a().offer(c1160h)) {
            return c1160h;
        }
        return null;
    }

    /* renamed from: a */
    public C1156d m4197a(String str, String str2) {
        C1156d c1156d = new C1156d(this.f4010b, new C0519z(EnumC1333h.CONTACT, "/trunk/item").m2581a(EnumC0511r.DELETE).m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("imei", C1336k.m4621a()).m2584a("sessionid", str).m2584a("itemid", str2).m2580a(905).m2579a());
        if (C1132c.m4162a().offer(c1156d)) {
            return c1156d;
        }
        return null;
    }

    /* renamed from: a */
    public C1154b m4194a(String str, String str2, String str3, int i) {
        C1154b c1154b = new C1154b(this.f4010b, new C0519z(EnumC1333h.CONTACT, "/trunk/item/commentlist").m2581a(EnumC0511r.GET).m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("imei", C1336k.m4621a()).m2584a("sessionid", str).m2584a("itemid", str2).m2584a("startcommentid", str3 == null ? String.valueOf(Integer.MAX_VALUE) : str3).m2584a("count", str3 == null ? String.valueOf(i) : String.valueOf(i + 1)).m2580a(903).m2582a(GetCommentListEntry.class).m2586b(C1097a.class).m2579a());
        if (C1132c.m4162a().offer(c1154b)) {
            return c1154b;
        }
        return null;
    }

    /* renamed from: a */
    public C1153a m4193a(String str, String str2, String str3) {
        C1153a c1153a = new C1153a(this.f4010b, new C0519z(EnumC1333h.CONTACT, "/trunk/item/comment").m2581a(EnumC0511r.POST).m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("imei", C1336k.m4621a()).m2580a(904).m2579a(), str, str2, str3);
        if (C1132c.m4162a().offer(c1153a)) {
            return c1153a;
        }
        return null;
    }

    /* renamed from: b */
    public C1157e m4200b(String str, String str2, String str3) {
        C1157e c1157e = new C1157e(this.f4010b, new C0519z(EnumC1333h.CONTACT, "/trunk/item/comment").m2581a(EnumC0511r.DELETE).m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("imei", C1336k.m4621a()).m2584a("sessionid", str).m2584a("itemid", str2).m2584a("commentid", str3).m2580a(906).m2579a());
        if (C1132c.m4162a().offer(c1157e)) {
            return c1157e;
        }
        return null;
    }

    /* renamed from: b */
    public C1158f m4201b(String str, String str2) {
        C1158f c1158f = new C1158f(this.f4010b, new C0519z(EnumC1333h.CONTACT, "/trunk/item/markAsRead").m2581a(EnumC0511r.GET).m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("imei", C1336k.m4621a()).m2584a("sessionid", str).m2584a("itemid", str2).m2580a(907).m2579a());
        if (C1132c.m4162a().offer(c1158f)) {
            return c1158f;
        }
        return null;
    }
}
