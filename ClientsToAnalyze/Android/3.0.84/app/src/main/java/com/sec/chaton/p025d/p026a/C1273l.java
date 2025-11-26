package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.EnumC1327e;
import com.sec.chaton.p027e.C1398ap;
import com.sec.chaton.p027e.p028a.C1351a;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p035io.entry.AmsItemGetListEntry;
import com.sec.chaton.p035io.entry.inner.AmsItem;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.settings.downloads.C2642q;
import com.sec.chaton.settings2.PrefFragmentChats;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3170al;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3364o;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.NameValuePair;

/* compiled from: AmsItemGetListTask.java */
/* renamed from: com.sec.chaton.d.a.l */
/* loaded from: classes.dex */
public class C1273l extends AbstractC1145a {

    /* renamed from: b */
    private static final String f4878b = C1273l.class.getSimpleName();

    public C1273l(Handler handler, C1580h c1580h, EnumC1172b enumC1172b) {
        super(handler, c1580h, enumC1172b);
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) throws Throwable {
        EnumC1327e enumC1327e;
        String str;
        EnumC1327e enumC1327eM5701a;
        Cursor cursor = null;
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            Iterator<NameValuePair> it = c0267d.m1353d().m6706f().iterator();
            while (true) {
                if (!it.hasNext()) {
                    enumC1327eM5701a = null;
                    break;
                }
                NameValuePair next = it.next();
                if (next.getName().equals(PrefFragmentChats.TYPE)) {
                    enumC1327eM5701a = EnumC1327e.m5701a(next.getValue());
                    break;
                }
            }
            if (enumC1327eM5701a != null) {
                switch (C1274m.f4879a[enumC1327eM5701a.ordinal()]) {
                    case 1:
                        C1533b.m6522a("01000011", "2001", c0267d);
                        break;
                    case 2:
                        C1533b.m6522a("01000011", "2101", c0267d);
                        break;
                    case 3:
                        C1533b.m6522a("01000011", "2201", c0267d);
                        break;
                }
            }
        }
        if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
            AmsItemGetListEntry amsItemGetListEntry = (AmsItemGetListEntry) c0267d.m1354e();
            if (amsItemGetListEntry == null) {
                if (C3250y.f11737e) {
                    C3250y.m11442a("Http result object is null.", f4878b);
                    return;
                }
                return;
            }
            Iterator<NameValuePair> it2 = c0267d.m1353d().m6706f().iterator();
            while (true) {
                if (it2.hasNext()) {
                    NameValuePair next2 = it2.next();
                    if (next2.getName().equals(PrefFragmentChats.TYPE)) {
                        EnumC1327e enumC1327eM5701a2 = EnumC1327e.m5701a(next2.getValue());
                        if (enumC1327eM5701a2 == null) {
                            if (C3250y.f11737e) {
                                C3250y.m11442a("Unknown ams type.", f4878b);
                                return;
                            }
                            return;
                        }
                        enumC1327e = enumC1327eM5701a2;
                    }
                } else {
                    enumC1327e = null;
                }
            }
            if (enumC1327e != null) {
                try {
                    Cursor cursorQuery = CommonApplication.m11493l().getContentResolver().query(C1398ap.m6249a(enumC1327e.m5703b()).buildUpon().appendPath("install").build(), null, null, null, null);
                    while (cursorQuery.moveToNext()) {
                        try {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex("item_id"));
                            if (!C2642q.m9637a(CommonApplication.m11493l(), enumC1327e, string)) {
                                if (C3250y.f11736d) {
                                    C3250y.m11455d(C3364o.m11849a("Ams item(", string, ") isn't valid."), f4878b);
                                }
                                C2642q.m9641c(CommonApplication.m11493l(), enumC1327e, string);
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor = cursorQuery;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(ContentProviderOperation.newDelete(C1398ap.m6249a(enumC1327e.m5703b())).withSelection(C3364o.m11849a("install", " = ?"), new String[]{"0"}).build());
                    if (C3250y.f11734b) {
                        C3250y.m11450b("Save ams item to database.", f4878b);
                    }
                    for (AmsItem amsItem : amsItemGetListEntry.items) {
                        amsItem.amstype = enumC1327e;
                        if (C3250y.f11734b) {
                            C3250y.m11450b(amsItem.toString(), f4878b);
                        }
                        arrayList.add(C1351a.m5950a(amsItem));
                    }
                    C3170al.m11043a(CommonApplication.m11493l(), "com.sec.chaton.provider2", (ArrayList<ContentProviderOperation>) arrayList);
                    switch (C1274m.f4879a[enumC1327e.ordinal()]) {
                        case 1:
                            str = "new_ams_item_template_count";
                            break;
                        case 2:
                            str = "new_ams_item_background_count";
                            break;
                        case 3:
                            str = "new_ams_item_stamp_count";
                            break;
                        default:
                            str = null;
                            break;
                    }
                    C3159aa.m10962a().m10984b(str, (Integer) 0);
                    LocalBroadcastManager.getInstance(CommonApplication.m11493l()).sendBroadcast(new Intent("more_tab_badge_update"));
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
    }
}
