package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.text.TextUtils;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p063i.p064a.C2404a;
import com.sec.chaton.p065io.entry.DownloadEmoticonEntry;
import com.sec.chaton.p065io.entry.inner.Anicon;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4821am;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.NameValuePair;

/* compiled from: DownloadEmoticonTask.java */
/* renamed from: com.sec.chaton.d.a.au */
/* loaded from: classes.dex */
public class C1921au extends AbstractC1900a {

    /* renamed from: b */
    private static final String f7167b = C1921au.class.getSimpleName();

    public C1921au(C2454e c2454e) {
        super(c2454e);
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        String value;
        C2404a.m10430a("01000011", "0101", c0778b);
        if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
            DownloadEmoticonEntry downloadEmoticonEntry = (DownloadEmoticonEntry) c0778b.m3110e();
            if (downloadEmoticonEntry == null) {
                if (C4904y.f17875e) {
                    C4904y.m18634a("Http result object is null.", f7167b);
                    return;
                }
                return;
            }
            Iterator<NameValuePair> it = c0778b.m3109d().m10633d().iterator();
            while (true) {
                if (!it.hasNext()) {
                    value = null;
                    break;
                }
                NameValuePair next = it.next();
                if (next.getName().equals("packageid")) {
                    value = next.getValue();
                    break;
                }
            }
            if (TextUtils.isEmpty(value)) {
                value = downloadEmoticonEntry.anicon.packageid;
            }
            ArrayList arrayList = new ArrayList();
            if (C4904y.f17872b) {
                C4904y.m18639b("Save emoticon package to database.", f7167b);
            }
            Anicon anicon = downloadEmoticonEntry.anicon;
            if (anicon != null) {
                anicon.packageid = value;
                if (C4904y.f17872b) {
                    C4904y.m18639b(anicon.toString(), f7167b);
                }
            }
            C4821am.m18190a(CommonApplication.m18732r(), "com.sec.chaton.provider2", (ArrayList<ContentProviderOperation>) arrayList);
        }
    }
}
