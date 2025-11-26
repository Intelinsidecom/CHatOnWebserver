package com.sec.chaton.p025d.p026a;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.localbackup.C1658q;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p018b.C0454b;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p035io.entry.SkipSMSVerifyServer;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3164af;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.net.URLEncoder;
import java.util.LinkedHashMap;

/* compiled from: SkipSMSVerifyTask.java */
/* renamed from: com.sec.chaton.d.a.du */
/* loaded from: classes.dex */
public class C1247du extends AbstractC1145a {

    /* renamed from: b */
    private String f4812b;

    /* renamed from: c */
    private Context f4813c;

    /* renamed from: e */
    private ContentResolver f4814e;

    public C1247du(Handler handler, C1580h c1580h, String str) {
        super(handler, c1580h);
        this.f4812b = str;
        this.f4813c = CommonApplication.m11493l();
        this.f4814e = this.f4813c.getContentResolver();
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        C3164af c3164af = new C3164af();
        LinkedHashMap linkedHashMap = new LinkedHashMap(5);
        linkedHashMap.put("imei", C3171am.m11045a());
        if (GlobalApplication.f5511a != null) {
            linkedHashMap.put("regid", GlobalApplication.f5511a);
        }
        linkedHashMap.put("pushtype", "SPP");
        linkedHashMap.put("osversion", "android " + Build.VERSION.SDK);
        linkedHashMap.put("imsi", C3171am.m11062e());
        linkedHashMap.put("model", URLEncoder.encode(C3171am.m11055b()));
        linkedHashMap.put("name", this.f4812b);
        if (C1493a.m6463a("mum_enable_feature")) {
            long jM3079a = C0454b.m3079a();
            C3250y.m11453c("MUMID : " + jM3079a, getClass().getSimpleName());
            if (jM3079a >= 0) {
                linkedHashMap.put("mumid", Long.toString(jM3079a));
            }
        }
        String strM11026a = c3164af.m11026a((Object) linkedHashMap);
        C3250y.m11456e(strM11026a, getClass().getSimpleName());
        return strM11026a;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
            SkipSMSVerifyServer skipSMSVerifyServer = (SkipSMSVerifyServer) c0267d.m1354e();
            if (!TextUtils.isEmpty(skipSMSVerifyServer.chatonid) && !TextUtils.isEmpty(skipSMSVerifyServer.uid)) {
                C3159aa.m10966a("uid", skipSMSVerifyServer.uid);
                C3171am.m11050a("agree_disclaimer", (Object) true);
                C3159aa.m10966a("Push Name", this.f4812b);
                C3159aa.m10966a("chaton_id", skipSMSVerifyServer.chatonid);
                C3250y.m11453c("Success, UID : " + skipSMSVerifyServer.uid + " chatonid : " + skipSMSVerifyServer.chatonid, getClass().getSimpleName());
                this.f4814e.delete(ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").build(), "account_type=?", new String[]{"com.sec.chaton"});
                new C1658q().m6941a();
                return;
            }
            return;
        }
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000002", "0104", c0267d);
        }
    }
}
