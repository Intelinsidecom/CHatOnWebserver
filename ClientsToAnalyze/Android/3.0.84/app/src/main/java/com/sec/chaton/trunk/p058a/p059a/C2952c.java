package com.sec.chaton.trunk.p058a.p059a;

import android.content.ContentProviderOperation;
import android.os.Handler;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.p026a.AbstractC1145a;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.trunk.database.p062a.C3044a;
import com.sec.chaton.trunk.entry.GetCommentListEntry;
import com.sec.chaton.trunk.entry.inner.Comment;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import org.apache.http.NameValuePair;

/* compiled from: GetCommentListTask.java */
/* renamed from: com.sec.chaton.trunk.a.a.c */
/* loaded from: classes.dex */
public class C2952c extends AbstractC1145a {

    /* renamed from: b */
    private static final String f10718b = C2952c.class.getSimpleName();

    public C2952c(Handler handler, C1580h c1580h) {
        super(handler, c1580h);
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
            String str = "";
            int i = Integer.MAX_VALUE;
            for (NameValuePair nameValuePair : c0267d.m1353d().m6706f()) {
                String value = nameValuePair.getName().equals("itemid") ? nameValuePair.getValue() : str;
                i = nameValuePair.getName().equals("startcommentid") ? Integer.parseInt(nameValuePair.getValue()) : i;
                str = value;
            }
            GetCommentListEntry getCommentListEntry = (GetCommentListEntry) c0267d.m1354e();
            if (getCommentListEntry == null) {
                if (C3250y.f11737e) {
                    C3250y.m11442a("Http result object is null", f10718b);
                    return;
                }
                return;
            }
            if (C3250y.f11734b) {
                C3250y.m11450b("Save comment to database", f10718b);
            }
            int i2 = i == Integer.MAX_VALUE ? 0 : 1;
            ArrayList arrayList = new ArrayList();
            while (true) {
                int i3 = i2;
                if (i3 < getCommentListEntry.comments.size()) {
                    Comment comment = getCommentListEntry.comments.get(i3);
                    comment.itemid = str;
                    if (C3250y.f11734b) {
                        C3250y.m11450b(String.format(" Comment Id: %s", comment.cid), f10718b);
                    }
                    arrayList.add(C3044a.m10555a(comment));
                    i2 = i3 + 1;
                } else {
                    C3044a.m10565a(CommonApplication.m11493l(), (ArrayList<ContentProviderOperation>) arrayList);
                    return;
                }
            }
        } else if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000016", "0203", c0267d);
        }
    }
}
