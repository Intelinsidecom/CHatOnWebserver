package com.sec.chaton.settings.moreapps.p098a;

import android.content.ContentProviderOperation;
import android.content.Intent;
import android.support.v4.content.C0096i;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.p056a.AbstractC1900a;
import com.sec.chaton.p057e.C2264bj;
import com.sec.chaton.p057e.p058a.C2177ac;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.settings.moreapps.entry.CurationList;
import com.sec.chaton.settings.moreapps.entry.EventList;
import com.sec.chaton.settings.moreapps.entry.PlusListEntry;
import com.sec.chaton.settings.moreapps.entry.RecommendList;
import com.sec.chaton.util.C4821am;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: GetPlusListTask.java */
/* renamed from: com.sec.chaton.settings.moreapps.a.b */
/* loaded from: classes.dex */
public class C3668b extends AbstractC1900a {
    public C3668b(C2454e c2454e) {
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
        if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
            PlusListEntry plusListEntry = (PlusListEntry) c0778b.m18928p();
            if (plusListEntry == null) {
                if (C4904y.f17875e) {
                    C4904y.m18634a("Http result object is null", this.f18194f);
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(C2177ac.m9702a());
            if (plusListEntry.curation == null && plusListEntry.recommend == null && plusListEntry.event != null) {
                if (C4904y.f17875e) {
                    C4904y.m18634a("There is unknown data.", this.f18194f);
                    return;
                }
                return;
            }
            if (plusListEntry.curation != null && plusListEntry.curation.count > 0) {
                Iterator<CurationList> it = plusListEntry.curation.curationList.iterator();
                while (it.hasNext()) {
                    arrayList.add(C2177ac.m9703a(it.next()));
                }
            }
            if (plusListEntry.recommend != null && plusListEntry.recommend.count > 0) {
                Iterator<RecommendList> it2 = plusListEntry.recommend.recommendList.iterator();
                while (it2.hasNext()) {
                    arrayList.add(C2177ac.m9705a(it2.next()));
                }
            }
            if (plusListEntry.event != null && plusListEntry.event.count > 0) {
                Iterator<EventList> it3 = plusListEntry.event.eventList.iterator();
                while (it3.hasNext()) {
                    arrayList.add(C2177ac.m9704a(it3.next()));
                }
            }
            C4821am.m18190a(CommonApplication.m18732r(), "com.sec.chaton.provider2", (ArrayList<ContentProviderOperation>) arrayList);
            if (plusListEntry.event != null && plusListEntry.event.count > 0) {
                C0096i.m358a(CommonApplication.m18732r()).m363a(new Intent("promotion_event_update"));
                return;
            }
            return;
        }
        if (c0778b.m3107b() == EnumC2464o.NO_CONTENT) {
            C4821am.m18189a(CommonApplication.m18732r(), "com.sec.chaton.provider2", ContentProviderOperation.newDelete(C2264bj.f8054a).build());
            if (C4904y.f17872b) {
                C4904y.m18639b("No Content, clear moreapps table", this.f18194f);
            }
        }
    }
}
