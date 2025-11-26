package com.sec.chaton.trunk.p043c.p044a;

import android.os.Handler;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0503j;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.trunk.database.p046a.C1173b;
import com.sec.chaton.trunk.entry.GetItemEntry;
import com.sec.chaton.trunk.entry.inner.Comment;
import com.sec.chaton.util.C1341p;
import java.util.ArrayList;
import org.apache.http.NameValuePair;

/* compiled from: GetItemTask.java */
/* renamed from: com.sec.chaton.trunk.c.a.h */
/* loaded from: classes.dex */
public class C1160h extends AbstractRunnableC0153bb {

    /* renamed from: a */
    private static final String f4008a = C1160h.class.getSimpleName();

    public C1160h(Handler handler, C0503j c0503j) {
        super(handler, c0503j);
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public String mo670a() {
        return null;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public void mo671a(C0259g c0259g) {
        if (c0259g.m928b() == EnumC0518y.SUCCESS) {
            String value = "";
            ArrayList arrayList = new ArrayList();
            String value2 = "";
            for (NameValuePair nameValuePair : c0259g.m931c().m2531d()) {
                if (nameValuePair.getName().equals("itemid")) {
                    value2 = nameValuePair.getValue();
                }
                value = nameValuePair.getName().equals("sessionid") ? nameValuePair.getValue() : value;
            }
            GetItemEntry getItemEntry = (GetItemEntry) c0259g.m932d();
            if (getItemEntry == null) {
                if (C1341p.f4581e) {
                    C1341p.m4651a("Http result object is null", f4008a);
                    return;
                }
                return;
            }
            if (C1341p.f4578b) {
                C1341p.m4658b("Save trunk item to database", f4008a);
            }
            getItemEntry.item.sessionid = value;
            arrayList.add(C1173b.m4232a(getItemEntry.item));
            if (C1341p.f4578b) {
                C1341p.m4658b("Save trunk comment to database", f4008a);
            }
            for (Comment comment : getItemEntry.item.comment) {
                comment.itemid = value2;
                arrayList.add(C1173b.m4230a(comment));
                if (C1341p.f4578b) {
                    C1341p.m4658b("===========================", f4008a);
                    C1341p.m4658b(comment.toString(), f4008a);
                }
            }
            C1173b.m4238a(GlobalApplication.m3100a(), arrayList);
        }
    }
}
