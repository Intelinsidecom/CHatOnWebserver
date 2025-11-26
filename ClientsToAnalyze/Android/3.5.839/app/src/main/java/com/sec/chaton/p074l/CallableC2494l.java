package com.sec.chaton.p074l;

import android.content.Context;
import android.database.Cursor;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: MigrationWorker.java */
/* renamed from: com.sec.chaton.l.l */
/* loaded from: classes.dex */
public class CallableC2494l implements InterfaceC2493k, Callable<Void> {

    /* renamed from: a */
    private static final String f8942a = CallableC2494l.class.getSimpleName();

    /* renamed from: b */
    private Context f8943b;

    public CallableC2494l(Context context) {
        this.f8943b = context;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() {
        String str;
        String str2;
        if (C4809aa.m18104a().m18120a("profile_image_manager_version", (Integer) 1).intValue() < 2) {
            if (C4904y.f17872b) {
                C4904y.m18639b("Profile image migration started.", f8942a);
            }
            try {
                List<String> listM10748c = m10748c();
                if (listM10748c.isEmpty()) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("Inbox is empty.", f8942a);
                    }
                    C4809aa.m18104a().m18126b("profile_image_manager_version", (Integer) 2);
                    if (C4904y.f17872b) {
                        str = "Profile Image Migration Ended.";
                        str2 = f8942a;
                        C4904y.m18639b(str, str2);
                    }
                } else {
                    File[] fileArrM10747a = m10747a(listM10748c);
                    if (fileArrM10747a != null && fileArrM10747a.length != 0) {
                        for (File file : fileArrM10747a) {
                            File fileM10771b = C2496n.m10771b(this.f8943b, file.getName().split("_chat_profile.png_")[0]);
                            if (C4904y.f17872b) {
                                C4904y.m18639b("Migration Chat Profile Image: " + file.getName(), f8942a);
                            }
                            if (file.renameTo(fileM10771b)) {
                                if (C4904y.f17872b) {
                                    C4904y.m18639b("Chat Profile Image Migration: " + file.getName() + " To " + fileM10771b.getName(), f8942a);
                                }
                            } else if (C4904y.f17875e) {
                                C4904y.m18634a("Can't Migration Chat Profile Image: " + file.getName() + " To " + fileM10771b.getName(), f8942a);
                            }
                        }
                    } else if (C4904y.f17872b) {
                        C4904y.m18639b("There is no migration image.", f8942a);
                    }
                    C4809aa.m18104a().m18126b("profile_image_manager_version", (Integer) 2);
                    if (C4904y.f17872b) {
                        str = "Profile Image Migration Ended.";
                        str2 = f8942a;
                        C4904y.m18639b(str, str2);
                    }
                }
            } catch (Throwable th) {
                C4809aa.m18104a().m18126b("profile_image_manager_version", (Integer) 2);
                if (C4904y.f17872b) {
                    C4904y.m18639b("Profile Image Migration Ended.", f8942a);
                }
                throw th;
            }
        }
        return null;
    }

    /* renamed from: a */
    private File[] m10747a(List<String> list) {
        return C2496n.m10755a(this.f8943b).listFiles(new C2495m(this, list));
    }

    /* renamed from: c */
    private List<String> m10748c() throws Throwable {
        Cursor cursorQuery;
        ArrayList arrayList = new ArrayList();
        try {
            cursorQuery = this.f8943b.getContentResolver().query(C2299s.f8209a, new String[]{"_id"}, null, null, null);
            while (cursorQuery.moveToNext()) {
                try {
                    arrayList.add(cursorQuery.getString(cursorQuery.getColumnIndex("_id")));
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
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    @Override // com.sec.chaton.p074l.InterfaceC2493k
    /* renamed from: b */
    public int mo10714b() {
        return EnumC2508z.MIGRATION.m10808a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(InterfaceC2493k interfaceC2493k) {
        long jMo10714b = mo10714b() - interfaceC2493k.mo10714b();
        if (jMo10714b < 0) {
            return -1;
        }
        if (jMo10714b == 0) {
            return 0;
        }
        return 1;
    }
}
