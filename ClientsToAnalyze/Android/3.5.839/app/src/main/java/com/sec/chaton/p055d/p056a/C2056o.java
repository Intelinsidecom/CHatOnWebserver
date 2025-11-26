package com.sec.chaton.p055d.p056a;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.localbackup.C2560s;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p049b.C1057b;
import com.sec.chaton.p065io.entry.AutoRegisterAccounEntry;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4815ag;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.spp.push.Config;
import java.net.URLEncoder;
import java.util.LinkedHashMap;

/* compiled from: AutoResigtrationAccountTask.java */
/* renamed from: com.sec.chaton.d.a.o */
/* loaded from: classes.dex */
public class C2056o extends AbstractC1900a {

    /* renamed from: b */
    private ContentResolver f7516b;

    /* renamed from: c */
    private Context f7517c;

    public C2056o(C2454e c2454e) {
        super(c2454e);
        this.f7517c = GlobalApplication.m18732r();
        this.f7516b = this.f7517c.getContentResolver();
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        C4815ag c4815ag = new C4815ag();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("imei", C4822an.m18228d());
        linkedHashMap.put("imsi", C4822an.m18238h());
        linkedHashMap.put("authcode", C4809aa.m18104a().m18121a("samsung_account_token", ""));
        linkedHashMap.put("emailsamsung", C4809aa.m18104a().m18121a("samsung_account_email", ""));
        if (!TextUtils.isEmpty(C4809aa.m18104a().m18121a("samsung_account_api_server", ""))) {
            linkedHashMap.put("api_server", C4809aa.m18104a().m18121a("samsung_account_api_server", ""));
        }
        if (GlobalApplication.f8355a != null) {
            linkedHashMap.put("regid", GlobalApplication.f8355a);
        }
        linkedHashMap.put("pushtype", "SPP");
        linkedHashMap.put("osversion", "android " + Build.VERSION.SDK);
        linkedHashMap.put("model", URLEncoder.encode(C4822an.m18231e()));
        if (C2349a.m10301a("mum_enable_feature")) {
            long jM6155a = C1057b.m6155a();
            C4904y.m18641c("MUMID : " + jM6155a, getClass().getSimpleName());
            if (jM6155a >= 0) {
                linkedHashMap.put("mumid", Long.toString(jM6155a));
            }
        }
        String strM18172a = c4815ag.m18172a((Object) linkedHashMap);
        C4904y.m18646e(strM18172a, getClass().getSimpleName());
        return strM18172a;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
            AutoRegisterAccounEntry autoRegisterAccounEntry = (AutoRegisterAccounEntry) c0778b.m3110e();
            if (!TextUtils.isEmpty(autoRegisterAccounEntry.chatonid) && !TextUtils.isEmpty(autoRegisterAccounEntry.uid)) {
                C4859bx.m18412h();
                C4809aa.m18108a("chaton_id", autoRegisterAccounEntry.chatonid);
                C4809aa.m18108a("uid", autoRegisterAccounEntry.uid);
                C4809aa.m18108a("Push Name", autoRegisterAccounEntry.name);
                C4904y.m18641c("Success, UID : " + autoRegisterAccounEntry.uid + " ChatON ID : " + autoRegisterAccounEntry.chatonid + " Name : " + autoRegisterAccounEntry.name, getClass().getSimpleName());
                C4809aa.m18104a().m18123a("samsung_account_token");
                this.f7516b.delete(ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").build(), "account_type=?", new String[]{Config.CHATON_PACKAGE_NAME});
                if (C2349a.m10301a("local_backup_feature")) {
                    new C2560s().m10972a();
                }
            }
        }
    }
}
