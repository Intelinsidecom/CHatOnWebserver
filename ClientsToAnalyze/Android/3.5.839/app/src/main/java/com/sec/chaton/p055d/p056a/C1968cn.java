package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2186al;
import com.sec.chaton.p065io.entry.GetContentCategoryList;
import com.sec.chaton.p065io.entry.inner.ContentCategory;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4815ag;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* compiled from: GetSpecialBuddyContentCategoryTask.java */
/* renamed from: com.sec.chaton.d.a.cn */
/* loaded from: classes.dex */
public class C1968cn extends AbstractC1900a {

    /* renamed from: b */
    String f7261b;

    public C1968cn(C2454e c2454e, String str) {
        super(c2454e);
        this.f7261b = str;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        C4815ag c4815ag = new C4815ag();
        LinkedHashMap linkedHashMap = new LinkedHashMap(5);
        linkedHashMap.put("specialuserid", this.f7261b);
        String strM18172a = c4815ag.m18172a((Object) linkedHashMap);
        C4904y.m18646e(strM18172a, getClass().getSimpleName());
        return strM18172a;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) throws RemoteException, OperationApplicationException {
        if ((c0778b.m3107b() == EnumC2464o.NO_CONTENT || c0778b.m3107b() == EnumC2464o.SUCCESS) && c0778b.m3110e() != null) {
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            GetContentCategoryList getContentCategoryList = (GetContentCategoryList) c0778b.m3110e();
            C4904y.m18641c("the number of ContentCategory from Server : " + getContentCategoryList.contentcategory.size(), getClass().getSimpleName());
            C4904y.m18641c("FollowCount : " + getContentCategoryList.followcount + " LikeCount : " + getContentCategoryList.likecount, getClass().getSimpleName());
            for (ContentCategory contentCategory : getContentCategoryList.contentcategory) {
                C4904y.m18646e("ContentCategory NO : " + contentCategory.ccid + ", Name : " + contentCategory.name, getClass().getSimpleName());
            }
            arrayList.add(C2186al.m9760a(this.f7261b, getContentCategoryList.likecount, getContentCategoryList.followcount));
            arrayList.add(C2186al.m9768b(this.f7261b, getContentCategoryList.likecount, getContentCategoryList.followcount));
            CommonApplication.m18732r().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
        }
    }
}
