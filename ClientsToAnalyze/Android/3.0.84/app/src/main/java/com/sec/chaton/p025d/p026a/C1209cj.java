package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.p028a.C1357af;
import com.sec.chaton.p035io.entry.GetContentCategoryList;
import com.sec.chaton.p035io.entry.inner.ContentCategory;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3164af;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* compiled from: GetSpecialBuddyContentCategoryTask.java */
/* renamed from: com.sec.chaton.d.a.cj */
/* loaded from: classes.dex */
public class C1209cj extends AbstractC1145a {

    /* renamed from: b */
    String f4714b;

    public C1209cj(Handler handler, C1580h c1580h, String str) {
        super(handler, c1580h);
        this.f4714b = str;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        C3164af c3164af = new C3164af();
        LinkedHashMap linkedHashMap = new LinkedHashMap(5);
        linkedHashMap.put("specialuserid", this.f4714b);
        String strM11026a = c3164af.m11026a((Object) linkedHashMap);
        C3250y.m11456e(strM11026a, getClass().getSimpleName());
        return strM11026a;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) throws RemoteException, OperationApplicationException {
        if ((c0267d.m1351b() == EnumC1587o.NO_CONTENT || c0267d.m1351b() == EnumC1587o.SUCCESS) && c0267d.m1354e() != null) {
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            GetContentCategoryList getContentCategoryList = (GetContentCategoryList) c0267d.m1354e();
            C3250y.m11453c("the number of ContentCategory from Server : " + getContentCategoryList.contentcategory.size(), getClass().getSimpleName());
            C3250y.m11453c("FollowCount : " + getContentCategoryList.followcount + " LikeCount : " + getContentCategoryList.likecount, getClass().getSimpleName());
            for (ContentCategory contentCategory : getContentCategoryList.contentcategory) {
                C3250y.m11456e("ContentCategory NO : " + contentCategory.ccid + ", Name : " + contentCategory.name, getClass().getSimpleName());
            }
            arrayList.add(C1357af.m5985a(this.f4714b, getContentCategoryList.likecount, getContentCategoryList.followcount));
            CommonApplication.m11493l().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
        }
    }
}
