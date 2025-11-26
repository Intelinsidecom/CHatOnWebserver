package com.sec.chaton.trunk.p043c.p044a;

import android.os.Handler;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0503j;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.trunk.database.p046a.C1173b;
import com.sec.chaton.trunk.entry.GetCommentListEntry;
import com.sec.chaton.trunk.entry.inner.Comment;
import com.sec.chaton.util.C1341p;
import java.util.ArrayList;
import org.apache.http.NameValuePair;

/* compiled from: GetCommentListTask.java */
/* renamed from: com.sec.chaton.trunk.c.a.b */
/* loaded from: classes.dex */
public class C1154b extends AbstractRunnableC0153bb {

    /* renamed from: a */
    private static final String f3999a = C1154b.class.getSimpleName();

    public C1154b(Handler handler, C0503j c0503j) {
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
            String str = "";
            int i = Integer.MAX_VALUE;
            for (NameValuePair nameValuePair : c0259g.m931c().m2531d()) {
                String value = nameValuePair.getName().equals("itemid") ? nameValuePair.getValue() : str;
                i = nameValuePair.getName().equals("startcommentid") ? Integer.parseInt(nameValuePair.getValue()) : i;
                str = value;
            }
            GetCommentListEntry getCommentListEntry = (GetCommentListEntry) c0259g.m932d();
            if (getCommentListEntry == null) {
                if (C1341p.f4581e) {
                    C1341p.m4651a("Http result object is null", f3999a);
                    return;
                }
                return;
            }
            if (C1341p.f4578b) {
                C1341p.m4658b("Save comment to database", f3999a);
            }
            int i2 = i == Integer.MAX_VALUE ? 0 : 1;
            ArrayList arrayList = new ArrayList();
            while (true) {
                int i3 = i2;
                if (i3 < getCommentListEntry.comments.size()) {
                    Comment comment = (Comment) getCommentListEntry.comments.get(i3);
                    comment.itemid = str;
                    if (C1341p.f4578b) {
                        C1341p.m4658b(String.format(" Comment Id: %s", comment.cid), f3999a);
                    }
                    arrayList.add(C1173b.m4230a(comment));
                    i2 = i3 + 1;
                } else {
                    C1173b.m4238a(GlobalApplication.m3100a(), arrayList);
                    return;
                }
            }
        }
    }
}
