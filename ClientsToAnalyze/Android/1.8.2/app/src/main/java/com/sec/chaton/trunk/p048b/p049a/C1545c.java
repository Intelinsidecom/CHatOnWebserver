package com.sec.chaton.trunk.p048b.p049a;

import android.os.Handler;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p015d.p016a.AbstractRunnableC0532a;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.trunk.database.p052a.C1584a;
import com.sec.chaton.trunk.entry.GetCommentListEntry;
import com.sec.chaton.trunk.entry.inner.Comment;
import com.sec.chaton.util.C1786r;
import java.util.ArrayList;
import org.apache.http.NameValuePair;

/* compiled from: GetCommentListTask.java */
/* renamed from: com.sec.chaton.trunk.b.a.c */
/* loaded from: classes.dex */
public class C1545c extends AbstractRunnableC0532a {

    /* renamed from: d */
    private static final String f5603d = C1545c.class.getSimpleName();

    public C1545c(Handler handler, C0798h c0798h) {
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
            String str = "";
            int i = Integer.MAX_VALUE;
            for (NameValuePair nameValuePair : c0101b.m669c().m3396d()) {
                String value = nameValuePair.getName().equals("itemid") ? nameValuePair.getValue() : str;
                i = nameValuePair.getName().equals("startcommentid") ? Integer.parseInt(nameValuePair.getValue()) : i;
                str = value;
            }
            GetCommentListEntry getCommentListEntry = (GetCommentListEntry) c0101b.m671d();
            if (getCommentListEntry == null) {
                if (C1786r.f6455e) {
                    C1786r.m6054a("Http result object is null", f5603d);
                    return;
                }
                return;
            }
            if (C1786r.f6452b) {
                C1786r.m6061b("Save comment to database", f5603d);
            }
            int i2 = i == Integer.MAX_VALUE ? 0 : 1;
            ArrayList arrayList = new ArrayList();
            while (true) {
                int i3 = i2;
                if (i3 < getCommentListEntry.comments.size()) {
                    Comment comment = (Comment) getCommentListEntry.comments.get(i3);
                    comment.itemid = str;
                    if (C1786r.f6452b) {
                        C1786r.m6061b(String.format(" Comment Id: %s", comment.cid), f5603d);
                    }
                    arrayList.add(C1584a.m5464a(comment));
                    i2 = i3 + 1;
                } else {
                    C1584a.m5472a(GlobalApplication.m3260b(), arrayList);
                    return;
                }
            }
        }
    }
}
