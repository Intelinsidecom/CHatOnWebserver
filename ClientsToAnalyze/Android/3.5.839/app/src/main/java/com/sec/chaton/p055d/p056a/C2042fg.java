package com.sec.chaton.p055d.p056a;

import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2180af;
import com.sec.chaton.p063i.p064a.C2404a;
import com.sec.chaton.p065io.entry.GetProfileImageList;
import com.sec.chaton.p065io.entry.inner.ProfileImage;
import com.sec.chaton.p067j.C2433c;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4815ag;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4867ce;
import com.sec.chaton.util.EnumC4868cf;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* compiled from: UploadProfileImageHistoryTask.java */
/* renamed from: com.sec.chaton.d.a.fg */
/* loaded from: classes.dex */
public class C2042fg extends AbstractC1900a {

    /* renamed from: i */
    private static String f7469i = "profile_f_mine_";

    /* renamed from: j */
    private static String f7470j = "profile_t_mine_";

    /* renamed from: b */
    private String f7471b;

    /* renamed from: c */
    private String f7472c;

    /* renamed from: d */
    private String f7473d;

    /* renamed from: e */
    private String f7474e;

    /* renamed from: g */
    private ArrayList<ProfileImage> f7475g;

    /* renamed from: h */
    private String f7476h;

    public C2042fg(C2454e c2454e, String str, String str2, String str3) {
        super(c2454e);
        this.f7476h = C4873ck.m18502c() + "/profilehistory/";
        this.f7471b = str;
        this.f7472c = str2;
        this.f7474e = str3;
        if (C4809aa.m18104a().m18119a("is_file_server_primary ", (Boolean) true).booleanValue()) {
            this.f7473d = C2433c.m10534a(EnumC4867ce.PRIMARY, EnumC4868cf.FILE);
        } else {
            this.f7473d = C2433c.m10534a(EnumC4867ce.SECONDARY, EnumC4868cf.FILE);
        }
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        C4815ag c4815ag = new C4815ag();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.f7471b != null) {
            linkedHashMap.put("profileimageurl", this.f7471b);
        }
        if (this.f7472c != null) {
            linkedHashMap.put("contenttype", this.f7472c);
        }
        if (this.f7473d != null) {
            linkedHashMap.put("hosturl", this.f7473d);
        }
        String strM18172a = c4815ag.m18172a((Object) linkedHashMap);
        C4904y.m18646e(strM18172a, getClass().getSimpleName());
        return strM18172a;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        if (c0778b.m18954n() && c0778b.m3110e() != null && c0778b.m3107b() != EnumC2464o.ERROR) {
            C4809aa.m18104a().m18121a("chaton_id", "");
            GetProfileImageList getProfileImageList = (GetProfileImageList) c0778b.m3110e();
            this.f7475g = getProfileImageList.profileimagelist;
            C2180af.m9734a(getProfileImageList);
            for (int i = 0; i < this.f7475g.size(); i++) {
                ProfileImage profileImage = this.f7475g.get(i);
                if (Spam.ACTIVITY_REPORT.equals(profileImage.represent)) {
                    File file = new File(this.f7476h);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    String str = this.f7476h + f7470j + profileImage.profileimageid;
                    String str2 = this.f7476h + f7469i + profileImage.profileimageid;
                    new File(str);
                    File file2 = new File(str2);
                    new File(this.f7474e);
                    if (C4809aa.m18104a().m18119a("profile_image_update_client", (Boolean) true).booleanValue()) {
                        if (this.f7474e != null) {
                            if (C4904y.f17872b) {
                                C4904y.m18646e("Save Profile image to Local Directory", getClass().getSimpleName());
                            }
                            C4809aa.m18108a("profile_small_image0", profileImage.profileimageid);
                            C4809aa.m18105a("profile_image_update_client", (Boolean) false);
                        } else {
                            return;
                        }
                    } else if (!C4809aa.m18104a().m18121a("profile_small_image0", "").equals(profileImage.profileimageid) && file2.exists()) {
                        C4809aa.m18108a("profile_small_image0", profileImage.profileimageid);
                    }
                }
            }
            return;
        }
        C2404a.m10430a("01000004", "0101", c0778b);
    }
}
