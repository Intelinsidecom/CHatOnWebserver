package com.sec.chaton.p055d.p056a;

import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2180af;
import com.sec.chaton.p063i.p064a.C2404a;
import com.sec.chaton.p065io.entry.GetProfileImageList;
import com.sec.chaton.p065io.entry.inner.ProfileImage;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4815ag;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* compiled from: UpdateProfileImageHistoryTask.java */
/* renamed from: com.sec.chaton.d.a.fd */
/* loaded from: classes.dex */
public class C2039fd extends AbstractC1900a {

    /* renamed from: d */
    private static String f7447d = "profile_f_mine_";

    /* renamed from: b */
    private String f7448b;

    /* renamed from: c */
    private ArrayList<ProfileImage> f7449c;

    public C2039fd(C2454e c2454e, String str) {
        super(c2454e);
        this.f7448b = str;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        C4815ag c4815ag = new C4815ag();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.f7448b != null) {
            linkedHashMap.put("profileimageid", this.f7448b);
        }
        String strM18172a = c4815ag.m18172a((Object) linkedHashMap);
        C4904y.m18646e(strM18172a, getClass().getSimpleName());
        return strM18172a;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
            GetProfileImageList getProfileImageList = (GetProfileImageList) c0778b.m3110e();
            this.f7449c = getProfileImageList.profileimagelist;
            C4809aa.m18108a("profile_image_status", "updated");
            C2180af.m9734a(getProfileImageList);
            String str = C4873ck.m18502c() + "/profilehistory/";
            String str2 = CommonApplication.m18732r().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/";
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f7449c.size()) {
                    ProfileImage profileImage = this.f7449c.get(i2);
                    if (Spam.ACTIVITY_REPORT.equals(profileImage.represent) && new File(str + f7447d + profileImage.profileimageid).exists()) {
                        C4809aa.m18108a("profile_small_image0", profileImage.profileimageid);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        } else {
            C2404a.m10430a("01000004", "0103", c0778b);
        }
    }
}
