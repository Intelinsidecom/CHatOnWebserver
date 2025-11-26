package com.sec.chaton.buddy.p050a;

import com.sec.chaton.p065io.entry.inner.SpecialUser;
import com.sec.chaton.privateplugin.data.Spam;
import java.io.Serializable;

/* compiled from: SpecialBuddyItem.java */
/* renamed from: com.sec.chaton.buddy.a.d */
/* loaded from: classes.dex */
public class C1107d implements Serializable {

    /* renamed from: a */
    private String f4252a;

    /* renamed from: b */
    private String f4253b;

    /* renamed from: c */
    private String f4254c;

    /* renamed from: d */
    private String f4255d;

    /* renamed from: e */
    private String f4256e;

    /* renamed from: f */
    private String f4257f;

    /* renamed from: g */
    private String f4258g;

    /* renamed from: h */
    private String f4259h;

    /* renamed from: i */
    private String f4260i;

    /* renamed from: j */
    private String f4261j;

    /* renamed from: k */
    private String f4262k;

    /* renamed from: l */
    private String f4263l;

    /* renamed from: m */
    private String f4264m;

    /* renamed from: a */
    public static C1107d m7081a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        return new C1107d(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13);
    }

    /* renamed from: a */
    public static C1107d m7080a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        return new C1107d(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12);
    }

    /* renamed from: a */
    public static C1107d m7079a(String str, String str2) {
        return new C1107d(str, str2);
    }

    /* renamed from: a */
    public static C1107d m7078a(SpecialUser specialUser) {
        return new C1107d(specialUser);
    }

    private C1107d() {
    }

    private C1107d(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        this.f4252a = str;
        this.f4253b = str2;
        this.f4254c = str3;
        this.f4255d = str4;
        this.f4256e = str5;
        this.f4257f = str6;
        this.f4258g = str7;
        this.f4259h = str8;
        this.f4260i = str9;
        this.f4261j = str10;
        this.f4262k = str11;
        this.f4263l = str12;
        this.f4264m = str13;
    }

    private C1107d(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        this.f4252a = str;
        this.f4253b = str2;
        this.f4254c = str3;
        this.f4255d = str4;
        this.f4256e = str5;
        this.f4257f = str6;
        this.f4258g = str7;
        this.f4259h = str8;
        this.f4260i = str9;
        this.f4261j = str10;
        this.f4263l = str11;
        this.f4264m = str12;
    }

    private C1107d(SpecialUser specialUser) {
        this.f4252a = specialUser.specialuserid;
        this.f4253b = specialUser.name;
        this.f4254c = specialUser.description;
        this.f4255d = specialUser.followcount;
        this.f4256e = specialUser.likecount;
        this.f4257f = specialUser.msgstatus;
        this.f4258g = specialUser.photoloaded;
        this.f4259h = specialUser.status;
        this.f4260i = specialUser.url;
        this.f4261j = specialUser.weburl;
        this.f4263l = specialUser.tel;
        this.f4264m = specialUser.usertype;
    }

    private C1107d(String str, String str2) {
        this.f4252a = str;
        this.f4253b = str2;
        this.f4264m = Spam.ACTIVITY_CANCEL;
        this.f4258g = "y";
    }

    /* renamed from: a */
    public String m7082a() {
        return this.f4252a;
    }

    /* renamed from: b */
    public String m7084b() {
        return this.f4253b;
    }

    /* renamed from: c */
    public String m7086c() {
        return this.f4254c;
    }

    /* renamed from: d */
    public String m7087d() {
        return this.f4255d;
    }

    /* renamed from: e */
    public String m7088e() {
        return this.f4256e;
    }

    /* renamed from: f */
    public String m7089f() {
        return this.f4257f;
    }

    /* renamed from: g */
    public String m7090g() {
        return this.f4258g;
    }

    /* renamed from: h */
    public String m7091h() {
        return this.f4260i;
    }

    /* renamed from: i */
    public String m7092i() {
        return this.f4263l;
    }

    /* renamed from: a */
    public void m7083a(String str) {
        this.f4255d = str;
    }

    /* renamed from: b */
    public void m7085b(String str) {
        this.f4256e = str;
    }

    /* renamed from: j */
    public EnumC1109f m7093j() {
        for (EnumC1109f enumC1109f : EnumC1109f.values()) {
            if (enumC1109f.m7095a().equals(this.f4264m)) {
                return enumC1109f;
            }
        }
        return EnumC1109f.NONE;
    }
}
