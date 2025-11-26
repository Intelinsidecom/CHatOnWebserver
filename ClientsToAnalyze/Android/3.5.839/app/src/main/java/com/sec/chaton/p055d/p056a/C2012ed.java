package com.sec.chaton.p055d.p056a;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.ContactsContract;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.localbackup.C2560s;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p049b.C1057b;
import com.sec.chaton.p065io.entry.SkipSMSVerifyServer;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4815ag;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.spp.push.Config;
import java.net.URLEncoder;
import java.util.LinkedHashMap;

/* compiled from: RegistrationTask.java */
/* renamed from: com.sec.chaton.d.a.ed */
/* loaded from: classes.dex */
public class C2012ed extends AbstractC1900a {

    /* renamed from: b */
    protected String f7390b;

    /* renamed from: c */
    protected String f7391c;

    /* renamed from: d */
    private String f7392d;

    /* renamed from: e */
    private String f7393e;

    /* renamed from: g */
    private Context f7394g;

    /* renamed from: h */
    private ContentResolver f7395h;

    public C2012ed(C2454e c2454e, String str, String str2, String str3, String str4) {
        super(c2454e);
        this.f7392d = str;
        this.f7393e = str2;
        this.f7390b = str4;
        this.f7391c = str3;
        this.f7394g = CommonApplication.m18732r();
        this.f7395h = this.f7394g.getContentResolver();
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        C4815ag c4815ag = new C4815ag();
        LinkedHashMap linkedHashMap = new LinkedHashMap(5);
        linkedHashMap.put("msisdn", this.f7392d);
        linkedHashMap.put("imei", C4822an.m18228d());
        if (GlobalApplication.f8355a != null) {
            linkedHashMap.put("regid", GlobalApplication.f8355a);
        }
        linkedHashMap.put("pushtype", "SPP");
        linkedHashMap.put("osversion", "android " + Build.VERSION.SDK);
        linkedHashMap.put("imsi", C4822an.m18238h());
        linkedHashMap.put("model", URLEncoder.encode(C4822an.m18231e()));
        linkedHashMap.put("name", this.f7393e);
        linkedHashMap.put("token", this.f7391c);
        linkedHashMap.put("authnum", this.f7390b);
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
            C4859bx.m18412h();
            SkipSMSVerifyServer skipSMSVerifyServer = (SkipSMSVerifyServer) c0778b.m3110e();
            C4809aa.m18104a().m18128b("msisdn", this.f7392d);
            C4809aa.m18104a().m18128b("chaton_id", skipSMSVerifyServer.chatonid);
            C4809aa.m18104a().m18128b("uid", skipSMSVerifyServer.uid);
            C4822an.m18216a("agree_disclaimer", (Object) true);
            C4809aa.m18108a("Push Name", this.f7393e);
            C4904y.m18641c("Success, UID : " + skipSMSVerifyServer.uid + " chatonID : " + skipSMSVerifyServer.chatonid, getClass().getSimpleName());
            this.f7395h.delete(ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").build(), "account_type=?", new String[]{Config.CHATON_PACKAGE_NAME});
            if (C2349a.m10301a("local_backup_feature")) {
                new C2560s().m10972a();
            }
        }
    }
}
