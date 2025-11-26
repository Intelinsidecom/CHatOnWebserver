package com.sec.chaton.calllog.manager.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.provider.Settings;
import com.sec.chaton.R;
import com.sec.chaton.calllog.manager.p021a.C0839a;
import com.sec.chaton.calllog.manager.p022b.C0841a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: CallLogList.java */
/* renamed from: com.sec.chaton.calllog.manager.model.d */
/* loaded from: classes.dex */
public class C0845d {

    /* renamed from: a */
    private static final String f3218a = C0845d.class.getSimpleName();

    /* renamed from: b */
    private C0839a f3219b;

    public C0845d() {
        this.f3219b = null;
        this.f3219b = new C0839a();
    }

    /* renamed from: a */
    public int m4479a(ArrayList<CallLogDBData> arrayList) {
        C3250y.m11453c("createCallLogDBList()", f3218a);
        ArrayList<ContentValues> arrayList2 = new ArrayList<>();
        Iterator<CallLogDBData> it = arrayList.iterator();
        while (it.hasNext()) {
            CallLogDBData next = it.next();
            if (next.m4466b()) {
                arrayList2.add(next.m4465a());
            } else {
                C3250y.m11442a("NO CALLDATE!!!!!!!!!", f3218a);
            }
        }
        int iM4433a = this.f3219b.m4433a(arrayList2);
        m4480a(true, arrayList.get(0).groupcallkey > 0);
        return iM4433a < 0 ? -1 : 0;
    }

    /* renamed from: b */
    public int m4490b(ArrayList<CallLogData> arrayList) {
        C3250y.m11453c("deleteCallLog()", f3218a);
        for (int i = 0; i < arrayList.size(); i++) {
            CallLogData callLogData = arrayList.get(i);
            if (callLogData.groupcallkey != null && !callLogData.groupcallkey.isEmpty()) {
                Iterator<Integer> it = m4488a(callLogData.groupcallkey.get(0).intValue()).iterator();
                while (it.hasNext()) {
                    if (this.f3219b.m4432a(callLogData.m4470a(it.next().intValue())) < 0) {
                        return -1;
                    }
                }
            } else {
                Iterator<List<Integer>> it2 = callLogData.totalIDList.iterator();
                while (it2.hasNext()) {
                    Iterator<Integer> it3 = it2.next().iterator();
                    while (it3.hasNext()) {
                        if (this.f3219b.m4432a(callLogData.m4470a(it3.next().intValue())) < 0) {
                            return -1;
                        }
                    }
                }
            }
        }
        return 0;
    }

    /* renamed from: a */
    public int m4480a(boolean z, boolean z2) {
        int iM4434a;
        C3250y.m11453c("autoDeleteOldestCallLog()", f3218a);
        int iM4492c = m4492c();
        int i = iM4492c - 500;
        if (i <= 0) {
            iM4434a = 0;
        } else if (z || i > 1) {
            iM4434a = 0;
            for (int i2 = 0; i2 < iM4492c - 500 && (iM4434a = this.f3219b.m4434a(z2)) >= 0; i2++) {
            }
        } else {
            iM4434a = this.f3219b.m4434a(z2);
            if (iM4434a < 0) {
                return -1;
            }
        }
        return iM4434a < 0 ? -1 : 0;
    }

    /* renamed from: a */
    public ArrayList<CallLogData> m4483a(CallLogDBData callLogDBData, boolean z) {
        ArrayList<CallLogData> arrayListM4476a = null;
        Cursor cursorM4440b = this.f3219b.m4440b(callLogDBData.m4465a());
        try {
            try {
                arrayListM4476a = m4476a(cursorM4440b, 1, z);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return arrayListM4476a;
        } finally {
            cursorM4440b.close();
        }
    }

    /* renamed from: a */
    public ArrayList<CallLogData> m4485a(ArrayList<Integer> arrayList, boolean z) {
        ArrayList<CallLogData> arrayListM4476a = null;
        Cursor cursorM4441b = this.f3219b.m4441b(arrayList);
        try {
            try {
                arrayListM4476a = m4476a(cursorM4441b, 0, z);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return arrayListM4476a;
        } finally {
            cursorM4441b.close();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006a  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.HashMap<java.util.Set<java.lang.String>, java.lang.String> m4487a() {
        /*
            r10 = this;
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            com.sec.chaton.calllog.manager.a.a r1 = r10.f3219b
            android.database.Cursor r6 = r1.m4443c()
            if (r6 == 0) goto Lb7
        L17:
            boolean r1 = r6.moveToNext()     // Catch: android.database.SQLException -> L64 java.lang.Throwable -> L7e
            if (r1 == 0) goto L85
            java.lang.String r1 = "buddy_no"
            int r1 = r6.getColumnIndex(r1)     // Catch: android.database.SQLException -> L64 java.lang.Throwable -> L7e
            java.lang.String r2 = r6.getString(r1)     // Catch: android.database.SQLException -> L64 java.lang.Throwable -> L7e
            java.lang.String r1 = "group_name"
            int r1 = r6.getColumnIndex(r1)     // Catch: android.database.SQLException -> L64 java.lang.Throwable -> L7e
            java.lang.String r1 = r6.getString(r1)     // Catch: android.database.SQLException -> L64 java.lang.Throwable -> L7e
            java.lang.String r7 = "_id"
            int r7 = r6.getColumnIndex(r7)     // Catch: android.database.SQLException -> L64 java.lang.Throwable -> L7e
            long r7 = r6.getLong(r7)     // Catch: android.database.SQLException -> L64 java.lang.Throwable -> L7e
            java.lang.Long r9 = java.lang.Long.valueOf(r7)     // Catch: android.database.SQLException -> L64 java.lang.Throwable -> L7e
            boolean r9 = r4.containsKey(r9)     // Catch: android.database.SQLException -> L64 java.lang.Throwable -> L7e
            if (r9 != 0) goto L4c
            java.lang.Long r9 = java.lang.Long.valueOf(r7)     // Catch: android.database.SQLException -> L64 java.lang.Throwable -> L7e
            r4.put(r9, r1)     // Catch: android.database.SQLException -> L64 java.lang.Throwable -> L7e
        L4c:
            java.lang.Long r1 = java.lang.Long.valueOf(r7)     // Catch: android.database.SQLException -> L64 java.lang.Throwable -> L7e
            boolean r1 = r5.containsKey(r1)     // Catch: android.database.SQLException -> L64 java.lang.Throwable -> L7e
            if (r1 == 0) goto L6e
            java.lang.Long r1 = java.lang.Long.valueOf(r7)     // Catch: android.database.SQLException -> L64 java.lang.Throwable -> L7e
            java.lang.Object r1 = r5.get(r1)     // Catch: android.database.SQLException -> L64 java.lang.Throwable -> L7e
            java.util.Set r1 = (java.util.Set) r1     // Catch: android.database.SQLException -> L64 java.lang.Throwable -> L7e
            r1.add(r2)     // Catch: android.database.SQLException -> L64 java.lang.Throwable -> L7e
            goto L17
        L64:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L7e
            if (r6 == 0) goto L6d
        L6a:
            r6.close()
        L6d:
            return r3
        L6e:
            java.util.HashSet r1 = new java.util.HashSet     // Catch: android.database.SQLException -> L64 java.lang.Throwable -> L7e
            r1.<init>()     // Catch: android.database.SQLException -> L64 java.lang.Throwable -> L7e
            r1.add(r2)     // Catch: android.database.SQLException -> L64 java.lang.Throwable -> L7e
            java.lang.Long r2 = java.lang.Long.valueOf(r7)     // Catch: android.database.SQLException -> L64 java.lang.Throwable -> L7e
            r5.put(r2, r1)     // Catch: android.database.SQLException -> L64 java.lang.Throwable -> L7e
            goto L17
        L7e:
            r1 = move-exception
            if (r6 == 0) goto L84
            r6.close()
        L84:
            throw r1
        L85:
            java.util.Set r1 = r5.keySet()     // Catch: android.database.SQLException -> L64 java.lang.Throwable -> L7e
            java.util.Iterator r7 = r1.iterator()     // Catch: android.database.SQLException -> L64 java.lang.Throwable -> L7e
        L8d:
            boolean r1 = r7.hasNext()     // Catch: android.database.SQLException -> L64 java.lang.Throwable -> L7e
            if (r1 == 0) goto Lb7
            java.lang.Object r1 = r7.next()     // Catch: android.database.SQLException -> L64 java.lang.Throwable -> L7e
            java.lang.Long r1 = (java.lang.Long) r1     // Catch: android.database.SQLException -> L64 java.lang.Throwable -> L7e
            long r8 = r1.longValue()     // Catch: android.database.SQLException -> L64 java.lang.Throwable -> L7e
            java.lang.Long r1 = java.lang.Long.valueOf(r8)     // Catch: android.database.SQLException -> L64 java.lang.Throwable -> L7e
            java.lang.Object r1 = r5.get(r1)     // Catch: android.database.SQLException -> L64 java.lang.Throwable -> L7e
            r0 = r1
            java.util.Set r0 = (java.util.Set) r0     // Catch: android.database.SQLException -> L64 java.lang.Throwable -> L7e
            r2 = r0
            java.lang.Long r1 = java.lang.Long.valueOf(r8)     // Catch: android.database.SQLException -> L64 java.lang.Throwable -> L7e
            java.lang.Object r1 = r4.get(r1)     // Catch: android.database.SQLException -> L64 java.lang.Throwable -> L7e
            java.lang.String r1 = (java.lang.String) r1     // Catch: android.database.SQLException -> L64 java.lang.Throwable -> L7e
            r3.put(r2, r1)     // Catch: android.database.SQLException -> L64 java.lang.Throwable -> L7e
            goto L8d
        Lb7:
            if (r6 == 0) goto L6d
            goto L6a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.calllog.manager.model.C0845d.m4487a():java.util.HashMap");
    }

    /* renamed from: a */
    public ArrayList<CallLogData> m4482a(long j, boolean z) {
        ArrayList<CallLogData> arrayListM4476a = null;
        Cursor cursorM4436a = this.f3219b.m4436a(j);
        try {
            try {
                arrayListM4476a = m4476a(cursorM4436a, 2, z);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return arrayListM4476a;
        } finally {
            cursorM4436a.close();
        }
    }

    /* renamed from: b */
    public int m4489b() {
        int i = 0;
        Cursor cursorM4444d = this.f3219b.m4444d();
        try {
            try {
                if (cursorM4444d.moveToFirst()) {
                    i = cursorM4444d.getInt(0);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return i;
        } finally {
            cursorM4444d.close();
        }
    }

    /* renamed from: a */
    public ArrayList<Integer> m4484a(String str, int i) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Cursor cursorM4437a = this.f3219b.m4437a(str, i);
        if (cursorM4437a != null && cursorM4437a.getCount() > 0) {
            try {
                try {
                    if (cursorM4437a.moveToFirst()) {
                        do {
                            arrayList.add(Integer.valueOf(cursorM4437a.getInt(0)));
                        } while (cursorM4437a.moveToNext());
                    }
                } catch (SQLException e) {
                    if (C3250y.f11737e) {
                        C3250y.m11443a(e, f3218a);
                    }
                }
            } finally {
                cursorM4437a.close();
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    public int m4492c() {
        return m4493d() + m4494e();
    }

    /* renamed from: d */
    public int m4493d() {
        int i = 0;
        Cursor cursorM4445e = this.f3219b.m4445e();
        try {
            try {
                if (cursorM4445e.moveToFirst()) {
                    i = cursorM4445e.getInt(0);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return i;
        } finally {
            cursorM4445e.close();
        }
    }

    /* renamed from: e */
    public int m4494e() {
        int i = 0;
        Cursor cursorM4446f = this.f3219b.m4446f();
        try {
            try {
                if (cursorM4446f.moveToFirst()) {
                    i = cursorM4446f.getInt(0) - 1;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return i;
        } finally {
            cursorM4446f.close();
        }
    }

    /* renamed from: a */
    public ArrayList<CallLogData> m4481a(int i, boolean z) {
        ArrayList<CallLogData> arrayListM4476a = null;
        Cursor cursorM4435a = this.f3219b.m4435a(i);
        try {
            try {
                arrayListM4476a = m4476a(cursorM4435a, 1, z);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return arrayListM4476a;
        } finally {
            cursorM4435a.close();
        }
    }

    /* renamed from: a */
    public ArrayList<CallLogData> m4486a(boolean z) {
        ArrayList<CallLogData> arrayListM4476a = null;
        Cursor cursorM4447g = this.f3219b.m4447g();
        try {
            try {
                arrayListM4476a = m4476a(cursorM4447g, 0, z);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return arrayListM4476a;
        } finally {
            cursorM4447g.close();
        }
    }

    /* renamed from: b */
    public ArrayList<CallLogData> m4491b(boolean z) {
        ArrayList<CallLogData> arrayListM4476a = null;
        Cursor cursorM4448h = this.f3219b.m4448h();
        try {
            try {
                arrayListM4476a = m4476a(cursorM4448h, 2, z);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return arrayListM4476a;
        } finally {
            cursorM4448h.close();
        }
    }

    /* renamed from: a */
    public List<Integer> m4488a(int i) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorM4439b = this.f3219b.m4439b(i);
        if (cursorM4439b != null) {
            try {
                try {
                    cursorM4439b.moveToFirst();
                    if (!cursorM4439b.isAfterLast()) {
                        do {
                            int columnIndex = cursorM4439b.getColumnIndex("_id");
                            if (columnIndex >= 0) {
                                arrayList.add(Integer.valueOf(cursorM4439b.getInt(columnIndex)));
                            }
                        } while (cursorM4439b.moveToNext());
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } finally {
                cursorM4439b.close();
            }
        }
        return arrayList;
    }

    protected void finalize() {
        this.f3219b.m4442b();
    }

    /* renamed from: a */
    private ArrayList<CallLogData> m4476a(Cursor cursor, int i, boolean z) {
        ArrayList<CallLogData> arrayList = new ArrayList<>();
        if (cursor != null) {
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                CallLogData callLogData = new CallLogData(cursor);
                while (cursor.moveToNext()) {
                    switch (callLogData.m4469a(cursor, i)) {
                        case 1:
                            m4477a(arrayList, callLogData, z);
                            callLogData = new CallLogData(cursor);
                            if (i != 1) {
                                break;
                            } else {
                                m4478a(arrayList);
                                break;
                            }
                        case 2:
                            if (i != 0) {
                                break;
                            } else {
                                m4477a(arrayList, callLogData, z);
                                callLogData = new CallLogData(cursor);
                                break;
                            }
                        case 4:
                            m4477a(arrayList, callLogData, z);
                            callLogData = new CallLogData(cursor);
                            if (i != 1) {
                                break;
                            } else {
                                m4478a(arrayList);
                                break;
                            }
                        case 6:
                            m4477a(arrayList, callLogData, z);
                            callLogData = new CallLogData(cursor);
                            if (i != 1) {
                                break;
                            } else {
                                m4478a(arrayList);
                                break;
                            }
                    }
                }
                m4477a(arrayList, callLogData, z);
                if (i == 1) {
                    m4478a(arrayList);
                }
            }
            cursor.close();
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m4477a(ArrayList<CallLogData> arrayList, CallLogData callLogData, boolean z) {
        if (z) {
            if (arrayList.size() <= 0) {
                arrayList.add(m4475a(callLogData));
            } else if (arrayList.size() > 0 && !C0841a.m4451a().m4463c(arrayList.get(arrayList.size() - 1).userInfo.get(0).f3214j, callLogData.userInfo.get(0).f3214j)) {
                arrayList.add(m4475a(callLogData));
            }
        }
        if (callLogData.groupcallkey != null && !callLogData.groupcallkey.isEmpty()) {
            Iterator<C0844c> it = callLogData.userInfo.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C0844c next = it.next();
                if (C3159aa.m10962a().m10979a("chaton_id", "").equals(next.f3205a)) {
                    callLogData.myCalllogtype = next.f3216l;
                    callLogData.myDuration = next.f3215k;
                    callLogData.userInfo.remove(callLogData.userInfo.indexOf(next));
                    ArrayList<Integer> arrayListM4484a = m4484a(next.f3205a, callLogData.groupcallkey.get(0).intValue());
                    for (int i = 0; i < arrayListM4484a.size(); i++) {
                        if (callLogData.totalIDList.get(0).contains(arrayListM4484a.get(i))) {
                            callLogData.totalIDList.get(0).remove(callLogData.totalIDList.get(0).indexOf(arrayListM4484a.get(i)));
                        }
                    }
                }
            }
        }
        arrayList.add(callLogData);
    }

    /* renamed from: a */
    private SeperatorCallLog m4475a(CallLogData callLogData) {
        int iM4455a = (int) C0841a.m4451a().m4455a(callLogData.userInfo.get(0).f3214j);
        SeperatorCallLog seperatorCallLog = new SeperatorCallLog();
        if (iM4455a == 0 || iM4455a == -1) {
            seperatorCallLog.seperatorname = GlobalApplication.m11493l().getResources().getString(R.string.calllog_seperator_1);
            seperatorCallLog.displaytype = 0;
        } else if (iM4455a == 1) {
            seperatorCallLog.seperatorname = GlobalApplication.m11493l().getResources().getString(R.string.calllog_seperator_2);
            seperatorCallLog.displaytype = 1;
        } else if (iM4455a >= 2) {
            seperatorCallLog.seperatorname = C0841a.m4451a().m4459a(callLogData.userInfo.get(0).f3214j, m4495f());
        } else {
            seperatorCallLog.seperatorname = C0841a.m4451a().m4459a(callLogData.userInfo.get(0).f3214j, m4495f());
        }
        return seperatorCallLog;
    }

    /* renamed from: a */
    private boolean m4478a(List<CallLogData> list) {
        if (list.size() < 2 || !list.get(list.size() - 2).m4472a(list.get(list.size() - 1))) {
            return false;
        }
        list.remove(list.size() - 1);
        return true;
    }

    /* renamed from: f */
    public String m4495f() {
        String string = Settings.System.getString(GlobalApplication.m11493l().getContentResolver(), "date_format");
        if (string == null) {
            return "yyyy/MM/dd";
        }
        if (string.equals("MM-dd-yyyy")) {
            return "MM/dd/yyyy";
        }
        if (string.equals("dd-MM-yyyy")) {
            return "dd/MM/yyyy";
        }
        if (string.equals("yyyy-MM-dd")) {
            return "yyyy/MM/dd";
        }
        return string;
    }
}
