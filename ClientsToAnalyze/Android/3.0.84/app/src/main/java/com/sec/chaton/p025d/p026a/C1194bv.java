package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.Intent;
import android.database.SQLException;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.C1398ap;
import com.sec.chaton.p027e.EnumC1399aq;
import com.sec.chaton.p027e.p028a.C1367k;
import com.sec.chaton.p027e.p028a.C1369m;
import com.sec.chaton.p035io.entry.GetFontListEntry;
import com.sec.chaton.p035io.entry.inner.FontFilter;
import com.sec.chaton.p035io.entry.inner.FontPackage;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.settings.downloads.C2570bj;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3170al;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3364o;
import java.util.ArrayList;

/* compiled from: GetFontListTask.java */
/* renamed from: com.sec.chaton.d.a.bv */
/* loaded from: classes.dex */
public class C1194bv extends AbstractC1145a {

    /* renamed from: b */
    private static final String f4693b = C1194bv.class.getSimpleName();

    public C1194bv(Handler handler, C1580h c1580h, EnumC1172b enumC1172b) {
        super(handler, c1580h, enumC1172b);
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) throws SQLException {
        if (C3250y.f11734b) {
            C3250y.m11450b("download_font, afterRequest(), request list result : " + c0267d.m1351b(), f4693b);
        }
        if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
            GetFontListEntry getFontListEntry = (GetFontListEntry) c0267d.m1354e();
            if (getFontListEntry == null) {
                if (C3250y.f11737e) {
                    C3250y.m11442a("Http result object is null.", f4693b);
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<ContentProviderOperation> arrayListM9510a = C2570bj.m9510a(CommonApplication.m11493l());
            if (arrayListM9510a != null && arrayListM9510a.size() >= 0) {
                arrayList.addAll(arrayListM9510a);
            }
            if (C3250y.f11734b) {
                C3250y.m11450b("Remove all filters not installed from database.", f4693b);
            }
            C1367k.m6097a(CommonApplication.m11493l());
            if (C3250y.f11734b) {
                C3250y.m11450b("Remove all font packages from database.", f4693b);
            }
            arrayList.add(ContentProviderOperation.newDelete(C1398ap.m6249a(EnumC1399aq.Font)).withSelection(C3364o.m11849a("install", " = ?"), new String[]{"0"}).build());
            if (C3250y.f11734b) {
                C3250y.m11450b("Save font items to database.", f4693b);
            }
            for (FontPackage fontPackage : getFontListEntry.fontlist.font) {
                if (C3250y.f11734b) {
                    C3250y.m11450b(fontPackage.toString(), f4693b);
                }
                arrayList.add(C1367k.m6094a(fontPackage));
            }
            if (C3250y.f11734b) {
                C3250y.m11450b("Save font filter list to database.", f4693b);
            }
            for (FontFilter fontFilter : getFontListEntry.fontfilterlist.fontFilter) {
                if (C3250y.f11734b) {
                    C3250y.m11450b(fontFilter.toString(), f4693b);
                }
                arrayList.add(C1369m.m6100a(fontFilter));
            }
            ContentProviderResult[] contentProviderResultArrM11043a = C3170al.m11043a(CommonApplication.m11493l(), "com.sec.chaton.provider2", (ArrayList<ContentProviderOperation>) arrayList);
            if (C3250y.f11734b) {
                for (ContentProviderResult contentProviderResult : contentProviderResultArrM11043a) {
                    C3250y.m11450b("download_font, applyBatch : - " + contentProviderResult.toString() + "\n", f4693b);
                }
            }
            C3159aa.m10962a().m10984b("new_font_count", (Integer) 0);
            LocalBroadcastManager.getInstance(CommonApplication.m11493l()).sendBroadcast(new Intent("more_tab_badge_update"));
        }
    }
}
