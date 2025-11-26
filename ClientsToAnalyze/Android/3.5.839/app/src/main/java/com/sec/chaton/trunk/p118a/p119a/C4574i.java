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

/* compiled from: RemoveCommentTask.java */
/* renamed from: com.sec.chaton.trunk.a.a.i */
/* loaded from: classes.dex */
public class C4574i extends AbstractC1900a {

    /* renamed from: b */
    private static final String f16680b = C4574i.class.getSimpleName();

    /* renamed from: c */
    private String f16681c;

    public C4574i(C2454e c2454e, String str) {
        super(c2454e);
        this.f16681c = str;
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
            if (C4904y.f17872b) {
                C4904y.m18639b("Remove comment in database ", f16680b);
            }
            C4664a.m17659a(CommonApplication.m18732r(), C4664a.m17664e(this.f16681c));
            GetCommentListEntry getCommentListEntry = (GetCommentListEntry) c0778b.m3110e();
            if (getCommentListEntry == null) {
                if (C4904y.f17875e) {
                    C4904y.m18634a("Http result object is null", f16680b);
                    return;
                }
                return;
            }
            if (C4904y.f17872b) {
                C4904y.m18639b("Save comment to database", f16680b);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(C4664a.m17654a(getCommentListEntry.trunkitemcomment));
            for (int i = 0; i < getCommentListEntry.comments.size(); i++) {
                Comment comment = getCommentListEntry.comments.get(i);
                comment.itemid = this.f16681c;
                if (C4904y.f17872b) {
                    C4904y.m18639b(String.format(" Comment Id: %s", comment.cid), f16680b);
                }
                arrayList.add(C4664a.m17649a(comment));
            }
            C4664a.m17660a(CommonApplication.m18732r(), (ArrayList<ContentProviderOperation>) arrayList);
            return;
        }
        C2404a.m10430a("01000016", "0202", c0778b);
    }
}
