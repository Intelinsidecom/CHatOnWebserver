package com.sec.chaton.trunk.p048b.p049a;

import android.os.Handler;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p015d.p016a.AbstractRunnableC0532a;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.trunk.database.p052a.C1584a;
import com.sec.chaton.trunk.entry.GetItemEntry;
import com.sec.chaton.trunk.entry.inner.Comment;
import com.sec.chaton.util.C1786r;
import java.util.ArrayList;
import org.apache.http.NameValuePair;

/* compiled from: GetItemTask.java */
/* renamed from: com.sec.chaton.trunk.b.a.e */
/* loaded from: classes.dex */
public class C1547e extends AbstractRunnableC0532a {

    /* renamed from: d */
    private static final String f5606d = C1547e.class.getSimpleName();

    public C1547e(Handler handler, C0798h c0798h) {
        super(handler, c0798h);
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        return null;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) {
        if (c0101b.m665b() == EnumC0803m.SUCCESS) {
            String value = "";
            ArrayList arrayList = new ArrayList();
            String value2 = "";
            for (NameValuePair nameValuePair : c0101b.m669c().m3396d()) {
                if (nameValuePair.getName().equals("itemid")) {
                    value2 = nameValuePair.getValue();
                }
                value = nameValuePair.getName().equals("sessionid") ? nameValuePair.getValue() : value;
            }
            GetItemEntry getItemEntry = (GetItemEntry) c0101b.m671d();
            if (getItemEntry == null) {
                if (C1786r.f6455e) {
                    C1786r.m6054a("Http result object is null", f5606d);
                    return;
                }
                return;
            }
            if (C1786r.f6452b) {
                C1786r.m6061b("Save trunk item to database", f5606d);
            }
            getItemEntry.item.sessionid = value;
            arrayList.add(C1584a.m5466a(getItemEntry.item));
            if (C1786r.f6452b) {
                C1786r.m6061b("Save trunk comment to database", f5606d);
            }
            for (Comment comment : getItemEntry.item.comment) {
                comment.itemid = value2;
                arrayList.add(C1584a.m5464a(comment));
                if (C1786r.f6452b) {
                    C1786r.m6061b("===========================", f5606d);
                    C1786r.m6061b(comment.toString(), f5606d);
                }
            }
            C1584a.m5472a(GlobalApplication.m3260b(), arrayList);
        }
    }
}
