package com.sec.chaton.settings.moreapps.p098a;

import android.content.ContentProviderOperation;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.p056a.AbstractC1900a;
import com.sec.chaton.p057e.C2262bh;
import com.sec.chaton.p057e.p058a.C2207u;
import com.sec.chaton.p065io.entry.GetMoreAppList;
import com.sec.chaton.p065io.entry.inner.MoreAppList;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4821am;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;

/* compiled from: GetMoreAppListTask.java */
/* renamed from: com.sec.chaton.settings.moreapps.a.a */
/* loaded from: classes.dex */
public class C3667a extends AbstractC1900a {
    public C3667a(C2454e c2454e) {
        super(c2454e);
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    protected String mo9086c() {
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    protected void mo9084a(C0778b c0778b) {
        C4904y.m18646e("afterRequest", this.f18194f);
        if (c0778b.m18954n() && c0778b.m3110e() != null && c0778b.m3107b() != EnumC2464o.ERROR) {
            GetMoreAppList getMoreAppList = (GetMoreAppList) c0778b.m3110e();
            ArrayList arrayList = new ArrayList();
            ArrayList<MoreAppList> arrayList2 = getMoreAppList.plus;
            arrayList.add(C2207u.m10058a());
            if (arrayList2 != null && arrayList2.size() > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList2.size()) {
                        break;
                    }
                    MoreAppList moreAppList = arrayList2.get(i2);
                    C4904y.m18646e(" id : " + moreAppList.f8573id + " title : " + moreAppList.title + " priority : " + moreAppList.priority + " type : " + moreAppList.type + " contenturl : " + moreAppList.contenturl + " appid: " + moreAppList.appid + " linkurl: " + moreAppList.linkurl + " samsungappsurl: " + moreAppList.samsungappsurl + " downloadurl: " + moreAppList.downloadurl, this.f18194f);
                    arrayList.add(C2207u.m10059a(moreAppList));
                    i = i2 + 1;
                }
            } else {
                C4904y.m18646e("list is null", this.f18194f);
            }
            C4821am.m18190a(CommonApplication.m18732r(), "com.sec.chaton.provider2", (ArrayList<ContentProviderOperation>) arrayList);
            return;
        }
        if (c0778b.m3107b() == EnumC2464o.NO_CONTENT) {
            C4821am.m18189a(CommonApplication.m18732r(), "com.sec.chaton.provider2", ContentProviderOperation.newDelete(C2262bh.f8053a).build());
            if (C4904y.f17872b) {
                C4904y.m18639b("No Content, clear moreapps table", this.f18194f);
            }
        }
    }
}
