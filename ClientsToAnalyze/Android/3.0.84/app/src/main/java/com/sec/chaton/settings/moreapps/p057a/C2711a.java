package com.sec.chaton.settings.moreapps.p057a;

import android.content.ContentProviderOperation;
import android.os.Handler;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.p026a.AbstractC1145a;
import com.sec.chaton.p027e.p028a.C1376t;
import com.sec.chaton.p035io.entry.GetMoreAppList;
import com.sec.chaton.p035io.entry.inner.MoreAppList;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3170al;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;

/* compiled from: GetMoreAppListTask.java */
/* renamed from: com.sec.chaton.settings.moreapps.a.a */
/* loaded from: classes.dex */
public class C2711a extends AbstractC1145a {
    public C2711a(Handler handler, C1580h c1580h) {
        super(handler, c1580h);
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    protected String mo5496f() {
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    protected void mo5488a(C0267d c0267d) {
        C3250y.m11456e("afterRequest", this.f11982d);
        if (c0267d.m11704n() && c0267d.m1354e() != null && c0267d.m1351b() != EnumC1587o.ERROR) {
            GetMoreAppList getMoreAppList = (GetMoreAppList) c0267d.m1354e();
            ArrayList arrayList = new ArrayList();
            ArrayList<MoreAppList> arrayList2 = getMoreAppList.more;
            arrayList.add(C1376t.m6198a());
            if (arrayList2 != null && arrayList2.size() > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList2.size()) {
                        break;
                    }
                    MoreAppList moreAppList = arrayList2.get(i2);
                    C3250y.m11456e(" id : " + moreAppList.f5651id + " title : " + moreAppList.title + " priority : " + moreAppList.priority + " type : " + moreAppList.type + " contenturl : " + moreAppList.contenturl + " appid: " + moreAppList.appid + " linkurl: " + moreAppList.linkurl + " samsungappsurl: " + moreAppList.samsungappsurl + " downloadurl: " + moreAppList.downloadurl, this.f11982d);
                    arrayList.add(C1376t.m6199a(moreAppList));
                    i = i2 + 1;
                }
            } else {
                C3250y.m11456e("list is null", this.f11982d);
            }
            C3170al.m11043a(CommonApplication.m11493l(), "com.sec.chaton.provider2", (ArrayList<ContentProviderOperation>) arrayList);
        }
    }
}
