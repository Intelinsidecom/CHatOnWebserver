package com.sec.chaton.trunk.p118a;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.p066a.C2407b;
import com.sec.chaton.p067j.C2456g;
import com.sec.chaton.p067j.C2472w;
import com.sec.chaton.p067j.EnumC2457h;
import com.sec.chaton.trunk.entry.DeleteItemEntry;
import com.sec.chaton.trunk.entry.GetCommentListEntry;
import com.sec.chaton.trunk.entry.GetItemEntry;
import com.sec.chaton.trunk.entry.GetItemListEntry;
import com.sec.chaton.trunk.entry.GetTrunkListEntry;
import com.sec.chaton.trunk.p118a.p119a.C4566a;
import com.sec.chaton.trunk.p118a.p119a.C4567b;
import com.sec.chaton.trunk.p118a.p119a.C4568c;
import com.sec.chaton.trunk.p118a.p119a.C4569d;
import com.sec.chaton.trunk.p118a.p119a.C4570e;
import com.sec.chaton.trunk.p118a.p119a.C4571f;
import com.sec.chaton.trunk.p118a.p119a.C4572g;
import com.sec.chaton.trunk.p118a.p119a.C4573h;
import com.sec.chaton.trunk.p118a.p119a.C4574i;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.EnumC4868cf;
import java.util.List;
import java.util.concurrent.Future;

/* compiled from: TrunkMessageControl.java */
/* renamed from: com.sec.chaton.trunk.a.a */
/* loaded from: classes.dex */
public class C4565a {

    /* renamed from: a */
    private Context f16657a;

    /* renamed from: b */
    private Handler f16658b;

    public C4565a(Context context, Handler handler) {
        this.f16657a = context;
        this.f16658b = handler;
    }

    /* renamed from: a */
    public C4571f m17517a(List<String> list) {
        C4571f c4571f = new C4571f(new C2456g(EnumC4868cf.CONTACT, "/trunklist").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10639a(GetTrunkListEntry.class).m10643b(C2407b.class).m10635a(), list);
        C2472w.m10687a().m10691c().m10662a(c4571f, 900, this.f16658b);
        return c4571f;
    }

    /* renamed from: a */
    public Future<C0778b> m17524a(boolean z, String str, int i, EnumC4575b enumC4575b, int i2) {
        return m17525a(z, str, i, enumC4575b, i2, null);
    }

    /* renamed from: a */
    public Future<C0778b> m17525a(boolean z, String str, int i, EnumC4575b enumC4575b, int i2, String str2) {
        C2456g c2456gM10643b = new C2456g(EnumC4868cf.CONTACT, "/trunk/itemlist").m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("sessionid", str).m10641a("type", enumC4575b.m17530a()).m10641a("thumbnailsize", String.valueOf(i2)).m10641a(VKApiConst.COUNT, String.valueOf(i)).m10639a(GetItemListEntry.class).m10643b(C2407b.class);
        if (!TextUtils.isEmpty(str2)) {
            c2456gM10643b.m10641a("startitemid", str2);
        }
        return C2472w.m10687a().m10691c().m10662a(new C4569d(c2456gM10643b.m10635a(), z), 902, this.f16658b);
    }

    /* renamed from: a */
    public Future<C0778b> m17519a(String str, String str2, int i, int i2) {
        return C2472w.m10687a().m10691c().m10662a(new C4570e(new C2456g(EnumC4868cf.CONTACT, "/trunk/item").m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("sessionid", str).m10641a("itemid", str2).m10641a("cmtlist", String.valueOf(i)).m10641a("thumbnailsize", String.valueOf(i2)).m10641a("startcommentid", String.valueOf(1)).m10641a("order", "asc").m10639a(GetItemEntry.class).m10643b(C2407b.class).m10635a()), 901, this.f16658b);
    }

    /* renamed from: a */
    public Future<C0778b> m17522a(String str, String str2, String str3, int i, int i2) {
        return C2472w.m10687a().m10691c().m10662a(new C4570e(new C2456g(EnumC4868cf.CONTACT, "/trunk/item").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10639a(GetItemEntry.class).m10643b(C2407b.class).m10635a(), true, str, str2, str3, i, i2), 901, this.f16658b);
    }

    /* renamed from: a */
    public Future<C0778b> m17518a(String str, String str2) {
        return C2472w.m10687a().m10691c().m10662a(new C4567b(new C2456g(EnumC4868cf.CONTACT, "/trunk/item").m10637a(EnumC2457h.DELETE).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("sessionid", str).m10641a("itemid", str2).m10635a()), 905, this.f16658b);
    }

    /* renamed from: a */
    public Future<C0778b> m17521a(String str, String str2, String str3, int i) {
        return C2472w.m10687a().m10691c().m10662a(new C4568c(new C2456g(EnumC4868cf.CONTACT, "/trunk/item/commentlist").m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("sessionid", str).m10641a("itemid", str2).m10641a("startcommentid", str3 == null ? String.valueOf(1) : str3).m10641a(VKApiConst.COUNT, str3 == null ? String.valueOf(i) : String.valueOf(i + 1)).m10641a("order", "asc").m10639a(GetCommentListEntry.class).m10643b(C2407b.class).m10635a()), 903, this.f16658b);
    }

    /* renamed from: a */
    public Future<C0778b> m17520a(String str, String str2, String str3) {
        return C2472w.m10687a().m10691c().m10662a(new C4566a(new C2456g(EnumC4868cf.CONTACT, "/trunk/item/comment").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("mode", "returnlist").m10639a(GetCommentListEntry.class).m10643b(C2407b.class).m10635a(), str, str2, str3), 904, this.f16658b);
    }

    /* renamed from: a */
    public Future<C0778b> m17523a(List<String> list, String str) {
        return C2472w.m10687a().m10691c().m10662a(new C4573h(new C2456g(EnumC4868cf.CONTACT, "/trunk/delitems").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("summary", "true").m10641a("sessionid", str).m10639a(DeleteItemEntry.class).m10643b(C2407b.class).m10635a(), list), 908, this.f16658b);
    }

    /* renamed from: b */
    public Future<C0778b> m17527b(String str, String str2, String str3) {
        return C2472w.m10687a().m10691c().m10662a(new C4574i(new C2456g(EnumC4868cf.CONTACT, "/trunk/item/comment").m10637a(EnumC2457h.DELETE).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("sessionid", str).m10641a("itemid", str2).m10641a("commentid", str3).m10641a("mode", "returnlist").m10639a(GetCommentListEntry.class).m10643b(C2407b.class).m10635a(), str2), 906, this.f16658b);
    }

    /* renamed from: b */
    public Future<C0778b> m17526b(String str, String str2) {
        return C2472w.m10687a().m10691c().m10662a(new C4572g(new C2456g(EnumC4868cf.CONTACT, "/trunk/item/markAsRead").m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("sessionid", str).m10641a("itemid", str2).m10635a()), 907, this.f16658b);
    }
}
