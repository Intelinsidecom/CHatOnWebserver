package com.sec.chaton.trunk.p118a.p119a;

import android.content.ContentProviderOperation;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.p056a.AbstractC1900a;
import com.sec.chaton.p063i.p064a.C2404a;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.trunk.database.p122a.C4664a;
import com.sec.chaton.trunk.entry.GetCommentListEntry;
import com.sec.chaton.trunk.entry.inner.Comment;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import org.apache.http.NameValuePair;

/* compiled from: GetCommentListTask.java */
/* renamed from: com.sec.chaton.trunk.a.a.c */
/* loaded from: classes.dex */
public class C4568c extends AbstractC1900a {

    /* renamed from: b */
    private static final String f16663b = C4568c.class.getSimpleName();

    public C4568c(C2454e c2454e) {
        super(c2454e);
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
            String str = "";
            int i = Integer.MAX_VALUE;
            for (NameValuePair nameValuePair : c0778b.m3109d().m10633d()) {
                String value = nameValuePair.getName().equals("itemid") ? nameValuePair.getValue() : str;
                i = nameValuePair.getName().equals("startcommentid") ? Integer.parseInt(nameValuePair.getValue()) : i;
                str = value;
            }
            GetCommentListEntry getCommentListEntry = (GetCommentListEntry) c0778b.m3110e();
            if (getCommentListEntry == null) {
                if (C4904y.f17875e) {
                    C4904y.m18634a("Http result object is null", f16663b);
                    return;
                }
                return;
            }
            if (C4904y.f17872b) {
                C4904y.m18639b("Save comment to database", f16663b);
            }
            int i2 = i == Integer.MAX_VALUE ? 0 : 1;
            ArrayList arrayList = new ArrayList();
            while (true) {
                int i3 = i2;
                if (i3 < getCommentListEntry.comments.size()) {
                    Comment comment = getCommentListEntry.comments.get(i3);
                    comment.itemid = str;
                    if (C4904y.f17872b) {
                        C4904y.m18639b(String.format(" Comment Id: %s", comment.cid), f16663b);
                    }
                    arrayList.add(C4664a.m17649a(comment));
                    i2 = i3 + 1;
                } else {
                    C4664a.m17660a(CommonApplication.m18732r(), (ArrayList<ContentProviderOperation>) arrayList);
                    return;
                }
            }
        } else {
            C2404a.m10430a("01000016", "0203", c0778b);
        }
    }
}
