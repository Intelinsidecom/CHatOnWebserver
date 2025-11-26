package com.sec.chaton.p015d.p016a;

import android.os.Handler;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.GetContentCategoryList;
import com.sec.chaton.p028io.entry.inner.ContentCategory;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1793y;
import java.util.LinkedHashMap;

/* compiled from: GetSpecialBuddyContentCategoryTask.java */
/* renamed from: com.sec.chaton.d.a.ay */
/* loaded from: classes.dex */
public class C0557ay extends AbstractRunnableC0532a {

    /* renamed from: d */
    String f2234d;

    public C0557ay(Handler handler, C0798h c0798h, String str) {
        super(handler, c0798h);
        this.f2234d = str;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        C1793y c1793y = new C1793y();
        LinkedHashMap linkedHashMap = new LinkedHashMap(5);
        linkedHashMap.put("specialuserid", this.f2234d);
        String strM6112a = c1793y.m6112a((Object) linkedHashMap);
        C1786r.m6066e(strM6112a, getClass().getSimpleName());
        return strM6112a;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) {
        if ((c0101b.m665b() == EnumC0803m.NO_CONTENT || c0101b.m665b() == EnumC0803m.SUCCESS) && c0101b.m671d() != null) {
            GetContentCategoryList getContentCategoryList = (GetContentCategoryList) c0101b.m671d();
            C1786r.m6063c("the number of ContentCategory from Server : " + getContentCategoryList.contentcategory.size(), getClass().getSimpleName());
            C1786r.m6063c("FollowCount : " + getContentCategoryList.followcount + " LikeCount : " + getContentCategoryList.likecount, getClass().getSimpleName());
            for (ContentCategory contentCategory : getContentCategoryList.contentcategory) {
                C1786r.m6066e("ContentCategory NO : " + contentCategory.ccid + ", Name : " + contentCategory.name, getClass().getSimpleName());
            }
        }
    }
}
