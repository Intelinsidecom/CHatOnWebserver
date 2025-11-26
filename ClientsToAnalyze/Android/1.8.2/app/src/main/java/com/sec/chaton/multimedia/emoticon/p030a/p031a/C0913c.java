package com.sec.chaton.multimedia.emoticon.p030a.p031a;

import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.emoticon.entry.GetPackageListEntry;
import com.sec.chaton.multimedia.emoticon.entry.inner.Package;
import com.sec.chaton.multimedia.emoticon.p032b.C0952g;
import com.sec.chaton.multimedia.emoticon.p032b.p033a.C0946a;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p015d.p016a.AbstractRunnableC0532a;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.util.C1786r;
import com.sec.common.p056b.p060d.C1828c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.apache.http.NameValuePair;

/* compiled from: GetPackageListTask.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.a.a.c */
/* loaded from: classes.dex */
public class C0913c extends AbstractRunnableC0532a {

    /* renamed from: d */
    private static final String f3380d = C0913c.class.getSimpleName();

    public C0913c(Handler handler, C0798h c0798h) {
        super(handler, c0798h);
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        return null;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) {
        String value;
        Cursor cursorQuery = null;
        if (c0101b.m665b() == EnumC0803m.SUCCESS) {
            GetPackageListEntry getPackageListEntry = (GetPackageListEntry) c0101b.m671d();
            if (getPackageListEntry == null) {
                if (C1786r.f6455e) {
                    C1786r.m6054a("Http result object is null.", f3380d);
                    return;
                }
                return;
            }
            Iterator it = c0101b.m669c().m3396d().iterator();
            while (true) {
                if (!it.hasNext()) {
                    value = null;
                    break;
                }
                NameValuePair nameValuePair = (NameValuePair) it.next();
                if (nameValuePair.getName().equals("categoryid")) {
                    value = nameValuePair.getValue();
                    break;
                }
            }
            Uri uri = C0952g.f3515a;
            ArrayList arrayList = new ArrayList();
            try {
                cursorQuery = GlobalApplication.m3260b().getContentResolver().query(uri, null, null, null, null);
                if (cursorQuery != null) {
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(cursorQuery.getString(cursorQuery.getColumnIndex("package_id")));
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                if (C1786r.f6452b) {
                    C1786r.m6061b("Save emoticon package to database.", f3380d);
                }
                Collections.reverse(getPackageListEntry.packges);
                for (Package r0 : getPackageListEntry.packges) {
                    r0.categoryid = value;
                    if (C1786r.f6452b) {
                        C1786r.m6061b(r0.toString(), f3380d);
                    }
                    arrayList.remove(r0.f3539id);
                    arrayList2.add(C0946a.m3808a(r0));
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    String str = (String) it2.next();
                    if (C1786r.f6453c) {
                        C1786r.m6063c(C1828c.m6207a("Delete expired package.( ", str, " )"), f3380d);
                    }
                    arrayList2.add(C0946a.m3809a(str));
                }
                C0946a.m3813a(GlobalApplication.m3260b(), arrayList2);
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
    }
}
