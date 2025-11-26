package com.sec.chaton.p055d.p056a;

import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2180af;
import com.sec.chaton.p063i.p064a.C2404a;
import com.sec.chaton.p065io.entry.GetProfileImageList;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4873ck;
import java.io.File;

/* compiled from: DeleteProfileImageHistoryTask.java */
/* renamed from: com.sec.chaton.d.a.am */
/* loaded from: classes.dex */
public class C1913am extends AbstractC1900a {

    /* renamed from: b */
    private String f7136b;

    /* renamed from: c */
    private boolean f7137c;

    public C1913am(C2454e c2454e, String str, boolean z) {
        super(c2454e);
        this.f7136b = str;
        this.f7137c = z;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
            String str = C4873ck.m18502c() + "/profilehistory/";
            if (this.f7137c) {
                C4809aa.m18108a("profile_image_status", "deleted");
            }
            C2180af.m9734a((GetProfileImageList) c0778b.m3110e());
            String str2 = str + "profile_t_mine_" + this.f7136b;
            String str3 = str + "profile_f_mine_" + this.f7136b;
            File file = new File(str2);
            File file2 = new File(str3);
            if (file.exists()) {
                file.delete();
            }
            if (file2.exists()) {
                file2.delete();
                return;
            }
            return;
        }
        C2404a.m10430a("01000004", "0102", c0778b);
    }
}
