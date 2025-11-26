package com.sec.chaton.multimedia.skin.p035a.p036a;

import android.content.ContentProviderOperation;
import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.skin.C1003c;
import com.sec.chaton.multimedia.skin.entry.GetListSkinEntry;
import com.sec.chaton.multimedia.skin.entry.inner.Skin;
import com.sec.chaton.multimedia.skin.p037b.C1002c;
import com.sec.chaton.multimedia.skin.p037b.p038a.C1000a;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p015d.p016a.AbstractRunnableC0532a;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.common.p056b.p060d.C1828c;
import java.util.ArrayList;

/* compiled from: GetListSkinTask.java */
/* renamed from: com.sec.chaton.multimedia.skin.a.a.b */
/* loaded from: classes.dex */
public class C0997b extends AbstractRunnableC0532a {

    /* renamed from: d */
    private static final String f3688d = C0997b.class.getSimpleName();

    public C0997b(Handler handler, C0798h c0798h) {
        super(handler, c0798h);
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        return null;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) throws Throwable {
        Cursor cursorQuery;
        if (c0101b.m665b() == EnumC0803m.SUCCESS) {
            GetListSkinEntry getListSkinEntry = (GetListSkinEntry) c0101b.m671d();
            if (getListSkinEntry == null) {
                if (C1786r.f6455e) {
                    C1786r.m6054a("Http result object is null.", f3688d);
                    return;
                }
                return;
            }
            if (C1786r.f6452b) {
                C1786r.m6061b(C1828c.m6207a("Skin entry: ", getListSkinEntry), f3688d);
            }
            ArrayList arrayList = new ArrayList();
            try {
                cursorQuery = GlobalApplication.m3260b().getContentResolver().query(C1002c.f3694a.buildUpon().appendPath("install").build(), null, null, null, null);
                while (cursorQuery.moveToNext()) {
                    try {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("skin_id"));
                        if (!C1003c.m3944b(GlobalApplication.m3260b(), string)) {
                            if (C1786r.f6454d) {
                                C1786r.m6065d(C1828c.m6207a("Skin(", string, ") directory isn't valid."), f3688d);
                            }
                            C1003c.m3953j(GlobalApplication.m3260b(), string);
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
                arrayList.add(ContentProviderOperation.newDelete(C1002c.f3694a).withSelection("skin_id >= ? AND install = ?", new String[]{"0", "0"}).build());
                for (Skin skin : getListSkinEntry.skins) {
                    if (skin.bgtype.equals("ma_pa")) {
                        skin.bgtype = "pa";
                    }
                    arrayList.add(C1000a.m3929a(skin));
                }
                C1000a.m3934a(GlobalApplication.m3260b(), arrayList);
                C1789u.m6075a().edit().putInt("new_skin_count", 0);
                LocalBroadcastManager.getInstance(GlobalApplication.m3260b()).sendBroadcast(new Intent("setting_tab_badge_update"));
            } catch (Throwable th2) {
                th = th2;
                cursorQuery = null;
            }
        }
    }
}
