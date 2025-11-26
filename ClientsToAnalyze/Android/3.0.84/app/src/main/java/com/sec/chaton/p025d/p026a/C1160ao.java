package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3223ck;
import com.sec.common.CommonApplication;
import java.io.File;

/* compiled from: DeleteProfileImageHistoryTask.java */
/* renamed from: com.sec.chaton.d.a.ao */
/* loaded from: classes.dex */
public class C1160ao extends AbstractC1145a {

    /* renamed from: b */
    private String f4601b;

    /* renamed from: c */
    private boolean f4602c;

    public C1160ao(Handler handler, C1580h c1580h, String str, boolean z) {
        super(handler, c1580h);
        this.f4601b = str;
        this.f4602c = z;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
            String str = C3223ck.m11329c() + "/profilehistory/";
            if (this.f4602c) {
                C3159aa.m10966a("profile_image_status", "deleted");
                String strM10979a = C3159aa.m10962a().m10979a("chaton_id", "");
                String str2 = (CommonApplication.m11493l().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/") + "myprofile.png_";
                C3205bt.m11182a(CommonApplication.m11493l()).m11227b(strM10979a);
                File file = new File(str2);
                if (file.exists()) {
                    file.delete();
                }
            }
            String str3 = str + "profile_t_mine_" + this.f4601b;
            String str4 = str + "profile_f_mine_" + this.f4601b;
            File file2 = new File(str3);
            File file3 = new File(str4);
            if (file2.exists()) {
                file2.delete();
            }
            if (file3.exists()) {
                file3.delete();
                return;
            }
            return;
        }
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000004", "0102", c0267d);
        }
    }
}
