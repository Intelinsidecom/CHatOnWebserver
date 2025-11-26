package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.p028a.C1358b;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p035io.entry.DownloadEmoticonEntry;
import com.sec.chaton.p035io.entry.inner.Anicon;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3170al;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.NameValuePair;

/* compiled from: DownloadEmoticonTask.java */
/* renamed from: com.sec.chaton.d.a.au */
/* loaded from: classes.dex */
public class C1166au extends AbstractC1145a {

    /* renamed from: b */
    private static final String f4627b = C1166au.class.getSimpleName();

    public C1166au(Handler handler, C1580h c1580h, EnumC1172b enumC1172b) {
        super(handler, c1580h, enumC1172b);
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        String value;
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000011", "0101", c0267d);
        }
        if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
            DownloadEmoticonEntry downloadEmoticonEntry = (DownloadEmoticonEntry) c0267d.m1354e();
            if (downloadEmoticonEntry == null) {
                if (C3250y.f11737e) {
                    C3250y.m11442a("Http result object is null.", f4627b);
                    return;
                }
                return;
            }
            Iterator<NameValuePair> it = c0267d.m1353d().m6706f().iterator();
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
            if (C3250y.f11734b) {
                C3250y.m11450b("Save emoticon package to database.", f4627b);
            }
            Anicon anicon = downloadEmoticonEntry.anicon;
            if (anicon != null) {
                anicon.packageid = value;
                if (C3250y.f11734b) {
                    C3250y.m11450b(anicon.toString(), f4627b);
                }
                arrayList.add(C1358b.m6002a(anicon));
            }
            C3170al.m11043a(CommonApplication.m11493l(), "com.sec.chaton.provider2", (ArrayList<ContentProviderOperation>) arrayList);
        }
    }
}
