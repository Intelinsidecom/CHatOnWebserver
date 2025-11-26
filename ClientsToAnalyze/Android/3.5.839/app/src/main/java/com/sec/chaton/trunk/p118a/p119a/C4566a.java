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
import com.sec.chaton.util.C4815ag;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: AddCommentTask.java */
/* renamed from: com.sec.chaton.trunk.a.a.a */
/* loaded from: classes.dex */
public class C4566a extends AbstractC1900a {

    /* renamed from: b */
    private String f16659b;

    /* renamed from: c */
    private String f16660c;

    /* renamed from: d */
    private String f16661d;

    public C4566a(C2454e c2454e, String str, String str2, String str3) {
        super(c2454e);
        this.f16659b = str;
        this.f16660c = str2;
        this.f16661d = str3;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        HashMap map = new HashMap();
        map.put("sessionid", this.f16659b);
        map.put("itemid", this.f16660c);
        map.put("comment", this.f16661d);
        String strM18172a = new C4815ag().m18172a((Object) map);
        C4904y.m18646e(strM18172a, this.f18194f);
        return strM18172a;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
            GetCommentListEntry getCommentListEntry = (GetCommentListEntry) c0778b.m3110e();
            if (getCommentListEntry == null) {
                if (C4904y.f17875e) {
                    C4904y.m18634a("Http result object is null", this.f18194f);
                    return;
                }
                return;
            }
            if (C4904y.f17872b) {
                C4904y.m18639b("Save comment to database", this.f18194f);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(C4664a.m17654a(getCommentListEntry.trunkitemcomment));
            for (int i = 0; i < getCommentListEntry.comments.size(); i++) {
                Comment comment = getCommentListEntry.comments.get(i);
                comment.itemid = this.f16660c;
                if (C4904y.f17872b) {
                    C4904y.m18639b(String.format(" Comment Id: %s", comment.cid), this.f18194f);
                }
                arrayList.add(C4664a.m17649a(comment));
            }
            C4664a.m17660a(CommonApplication.m18732r(), (ArrayList<ContentProviderOperation>) arrayList);
            return;
        }
        C2404a.m10430a("01000016", "0201", c0778b);
    }
}
