package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.C1398ap;
import com.sec.chaton.p027e.EnumC1399aq;
import com.sec.chaton.p027e.p028a.C1353ab;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p035io.entry.GetListSkinEntry;
import com.sec.chaton.p035io.entry.inner.Skin;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.settings.downloads.C2591cd;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3170al;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3364o;
import java.util.ArrayList;

/* compiled from: GetListSkinTask.java */
/* renamed from: com.sec.chaton.d.a.bw */
/* loaded from: classes.dex */
public class C1195bw extends AbstractC1145a {

    /* renamed from: b */
    private static final String f4694b = C1195bw.class.getSimpleName();

    public C1195bw(Handler handler, C1580h c1580h, EnumC1172b enumC1172b) {
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
        Cursor cursorQuery;
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000011", "1001", c0267d);
        }
        if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
            GetListSkinEntry getListSkinEntry = (GetListSkinEntry) c0267d.m1354e();
            if (getListSkinEntry == null) {
                if (C3250y.f11737e) {
                    C3250y.m11442a("Http result object is null.", f4694b);
                    return;
                }
                return;
            }
            if (C3250y.f11734b) {
                C3250y.m11450b(C3364o.m11849a("Skin entry: ", getListSkinEntry), f4694b);
            }
            ArrayList arrayList = new ArrayList();
            try {
                cursorQuery = CommonApplication.m11493l().getContentResolver().query(C1398ap.m6249a(EnumC1399aq.Skin).buildUpon().appendPath("install").build(), null, null, null, null);
                while (cursorQuery.moveToNext()) {
                    try {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("item_id"));
                        if (!C2591cd.m9574b(CommonApplication.m11493l(), string)) {
                            if (C3250y.f11736d) {
                                C3250y.m11455d(C3364o.m11849a("Skin(", string, ") directory isn't valid."), f4694b);
                            }
                            C2591cd.m9587j(CommonApplication.m11493l(), string);
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        throw th;
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                arrayList.add(ContentProviderOperation.newDelete(C1398ap.m6249a(EnumC1399aq.Skin)).withSelection("item_id >= ? AND install = ?", new String[]{"0", "0"}).build());
                for (Skin skin : getListSkinEntry.skins) {
                    if (skin.bgtype.equals("ma_pa") || skin.bgtype.equals("pa_ma")) {
                        skin.bgtype = "pa";
                    }
                    arrayList.add(C1353ab.m5963a(skin));
                }
                C3170al.m11043a(CommonApplication.m11493l(), "com.sec.chaton.provider2", (ArrayList<ContentProviderOperation>) arrayList);
                C3159aa.m10962a().m10984b("new_skin_count", (Integer) 0);
                LocalBroadcastManager.getInstance(CommonApplication.m11493l()).sendBroadcast(new Intent("more_tab_badge_update"));
            } catch (Throwable th2) {
                th = th2;
                cursorQuery = null;
            }
        }
    }
}
