package com.sec.chaton.calllog.manager.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.provider.Settings;
import com.sec.chaton.R;
import com.sec.chaton.calllog.manager.p052a.C1450a;
import com.sec.chaton.calllog.manager.p053b.C1452a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: CallLogList.java */
/* renamed from: com.sec.chaton.calllog.manager.model.d */
/* loaded from: classes.dex */
public class C1456d {

    /* renamed from: a */
    private static final String f5188a = C1456d.class.getSimpleName();

    /* renamed from: b */
    private C1450a f5189b;

    public C1456d() {
        this.f5189b = null;
        this.f5189b = new C1450a();
    }

    /* renamed from: a */
    public int m7634a(ArrayList<CallLogDBData> arrayList) {
        C4904y.m18641c("createCallLogDBList()", f5188a);
        ArrayList<ContentValues> arrayList2 = new ArrayList<>();
        Iterator<CallLogDBData> it = arrayList.iterator();
        while (it.hasNext()) {
            CallLogDBData next = it.next();
            if (next.m7620b()) {
                arrayList2.add(next.m7619a());
            } else {
                C4904y.m18634a("NO CALLDATE!!!!!!!!!", f5188a);
            }
        }
        int iM7587a = this.f5189b.m7587a(arrayList2);
        m7635a(true, arrayList.get(0).groupcallkey > 0);
        return iM7587a < 0 ? -1 : 0;
    }

    /* renamed from: b */
    public int m7645b(ArrayList<CallLogData> arrayList) {
        C4904y.m18641c("deleteCallLog()", f5188a);
        for (int i = 0; i < arrayList.size(); i++) {
            CallLogData callLogData = arrayList.get(i);
            if (callLogData.groupcallkey != null && !callLogData.groupcallkey.isEmpty()) {
                Iterator<Integer> it = m7643a(callLogData.groupcallkey.get(0).intValue()).iterator();
                while (it.hasNext()) {
                    if (this.f5189b.m7586a(callLogData.m7624a(it.next().intValue())) < 0) {
                        return -1;
                    }
                }
            } else {
                Iterator<List<Integer>> it2 = callLogData.totalIDList.iterator();
                while (it2.hasNext()) {
                    Iterator<Integer> it3 = it2.next().iterator();
                    while (it3.hasNext()) {
                        if (this.f5189b.m7586a(callLogData.m7624a(it3.next().intValue())) < 0) {
                            return -1;
                        }
                    }
                }
            }
        }
        return 0;
    }

    /* renamed from: a */
    public int m7635a(boolean z, boolean z2) {
        int iM7588a;
        C4904y.m18641c("autoDeleteOldestCallLog()", f5188a);
        int iM7647c = m7647c();
        int i = iM7647c - 500;
        if (i <= 0) {
            iM7588a = 0;
        } else if (z || i > 1) {
            iM7588a = 0;
            for (int i2 = 0; i2 < iM7647c - 500 && (iM7588a = this.f5189b.m7588a(z2)) >= 0; i2++) {
            }
        } else {
            iM7588a = this.f5189b.m7588a(z2);
            if (iM7588a < 0) {
                return -1;
            }
        }
        return iM7588a < 0 ? -1 : 0;
    }

    /* renamed from: a */
    public ArrayList<CallLogData> m7638a(CallLogDBData callLogDBData, boolean z) {
        ArrayList<CallLogData> arrayListM7630a = null;
        Cursor cursorM7594b = this.f5189b.m7594b(callLogDBData.m7619a());
        try {
            try {
                arrayListM7630a = m7630a(cursorM7594b, 1, z);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return arrayListM7630a;
        } finally {
            cursorM7594b.close();
        }
    }

    /* renamed from: a */
    public ArrayList<CallLogData> m7640a(ArrayList<Integer> arrayList, boolean z) {
        ArrayList<CallLogData> arrayListM7630a = null;
        Cursor cursorM7595b = this.f5189b.m7595b(arrayList);
        try {
            try {
                arrayListM7630a = m7630a(cursorM7595b, 0, z);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return arrayListM7630a;
        } finally {
            cursorM7595b.close();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006d  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.HashMap<java.util.Set<java.lang.String>, java.lang.String> m7642a() {
        /*
            r10 = this;
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            com.sec.chaton.calllog.manager.a.a r1 = r10.f5189b
            android.database.Cursor r6 = r1.m7597c()
            if (r6 == 0) goto Lba
        L17:
            boolean r1 = r6.moveToNext()     // Catch: android.database.SQLException -> L67 java.lang.Throwable -> L81
            if (r1 == 0) goto L88
            java.lang.String r1 = "buddy_no"
            int r1 = r6.getColumnIndex(r1)     // Catch: android.database.SQLException -> L67 java.lang.Throwable -> L81
            java.lang.String r2 = r6.getString(r1)     // Catch: android.database.SQLException -> L67 java.lang.Throwable -> L81
            java.lang.String r1 = "group_name"
            int r1 = r6.getColumnIndex(r1)     // Catch: android.database.SQLException -> L67 java.lang.Throwable -> L81
            java.lang.String r1 = r6.getString(r1)     // Catch: android.database.SQLException -> L67 java.lang.Throwable -> L81
            java.lang.String r7 = "_id"
            int r7 = r6.getColumnIndex(r7)     // Catch: android.database.SQLException -> L67 java.lang.Throwable -> L81
            long r7 = r6.getLong(r7)     // Catch: android.database.SQLException -> L67 java.lang.Throwable -> L81
            java.lang.Long r9 = java.lang.Long.valueOf(r7)     // Catch: android.database.SQLException -> L67 java.lang.Throwable -> L81
            boolean r9 = r4.containsKey(r9)     // Catch: android.database.SQLException -> L67 java.lang.Throwable -> L81
            if (r9 != 0) goto L4f
            java.lang.Long r9 = java.lang.Long.valueOf(r7)     // Catch: android.database.SQLException -> L67 java.lang.Throwable -> L81
            r4.put(r9, r1)     // Catch: android.database.SQLException -> L67 java.lang.Throwable -> L81
        L4f:
            java.lang.Long r1 = java.lang.Long.valueOf(r7)     // Catch: android.database.SQLException -> L67 java.lang.Throwable -> L81
            boolean r1 = r5.containsKey(r1)     // Catch: android.database.SQLException -> L67 java.lang.Throwable -> L81
            if (r1 == 0) goto L71
            java.lang.Long r1 = java.lang.Long.valueOf(r7)     // Catch: android.database.SQLException -> L67 java.lang.Throwable -> L81
            java.lang.Object r1 = r5.get(r1)     // Catch: android.database.SQLException -> L67 java.lang.Throwable -> L81
            java.util.Set r1 = (java.util.Set) r1     // Catch: android.database.SQLException -> L67 java.lang.Throwable -> L81
            r1.add(r2)     // Catch: android.database.SQLException -> L67 java.lang.Throwable -> L81
            goto L17
        L67:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L81
            if (r6 == 0) goto L70
        L6d:
            r6.close()
        L70:
            return r3
        L71:
            java.util.HashSet r1 = new java.util.HashSet     // Catch: android.database.SQLException -> L67 java.lang.Throwable -> L81
            r1.<init>()     // Catch: android.database.SQLException -> L67 java.lang.Throwable -> L81
            r1.add(r2)     // Catch: android.database.SQLException -> L67 java.lang.Throwable -> L81
            java.lang.Long r2 = java.lang.Long.valueOf(r7)     // Catch: android.database.SQLException -> L67 java.lang.Throwable -> L81
            r5.put(r2, r1)     // Catch: android.database.SQLException -> L67 java.lang.Throwable -> L81
            goto L17
        L81:
            r1 = move-exception
            if (r6 == 0) goto L87
            r6.close()
        L87:
            throw r1
        L88:
            java.util.Set r1 = r5.keySet()     // Catch: android.database.SQLException -> L67 java.lang.Throwable -> L81
            java.util.Iterator r7 = r1.iterator()     // Catch: android.database.SQLException -> L67 java.lang.Throwable -> L81
        L90:
            boolean r1 = r7.hasNext()     // Catch: android.database.SQLException -> L67 java.lang.Throwable -> L81
            if (r1 == 0) goto Lba
            java.lang.Object r1 = r7.next()     // Catch: android.database.SQLException -> L67 java.lang.Throwable -> L81
            java.lang.Long r1 = (java.lang.Long) r1     // Catch: android.database.SQLException -> L67 java.lang.Throwable -> L81
            long r8 = r1.longValue()     // Catch: android.database.SQLException -> L67 java.lang.Throwable -> L81
            java.lang.Long r1 = java.lang.Long.valueOf(r8)     // Catch: android.database.SQLException -> L67 java.lang.Throwable -> L81
            java.lang.Object r1 = r5.get(r1)     // Catch: android.database.SQLException -> L67 java.lang.Throwable -> L81
            r0 = r1
            java.util.Set r0 = (java.util.Set) r0     // Catch: android.database.SQLException -> L67 java.lang.Throwable -> L81
            r2 = r0
            java.lang.Long r1 = java.lang.Long.valueOf(r8)     // Catch: android.database.SQLException -> L67 java.lang.Throwable -> L81
            java.lang.Object r1 = r4.get(r1)     // Catch: android.database.SQLException -> L67 java.lang.Throwable -> L81
            java.lang.String r1 = (java.lang.String) r1     // Catch: android.database.SQLException -> L67 java.lang.Throwable -> L81
            r3.put(r2, r1)     // Catch: android.database.SQLException -> L67 java.lang.Throwable -> L81
            goto L90
        Lba:
            if (r6 == 0) goto L70
            goto L6d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.calllog.manager.model.C1456d.m7642a():java.util.HashMap");
    }

    /* renamed from: a */
    public ArrayList<CallLogData> m7637a(long j, boolean z) {
        ArrayList<CallLogData> arrayListM7630a = null;
        Cursor cursorM7590a = this.f5189b.m7590a(j);
        try {
            try {
                arrayListM7630a = m7630a(cursorM7590a, 2, z);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return arrayListM7630a;
        } finally {
            cursorM7590a.close();
        }
    }

    /* renamed from: b */
    public int m7644b() {
        int i = 0;
        Cursor cursorM7598d = this.f5189b.m7598d();
        try {
            try {
                if (cursorM7598d.moveToFirst()) {
                    i = cursorM7598d.getInt(0);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return i;
        } finally {
            cursorM7598d.close();
        }
    }

    /* renamed from: a */
    public ArrayList<Integer> m7639a(String str, int i) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Cursor cursorM7591a = this.f5189b.m7591a(str, i);
        if (cursorM7591a == null || cursorM7591a.getCount() <= 0) {
            if (cursorM7591a != null) {
            }
        } else {
            try {
                try {
                    if (cursorM7591a.moveToFirst()) {
                        do {
                            arrayList.add(Integer.valueOf(cursorM7591a.getInt(0)));
                        } while (cursorM7591a.moveToNext());
                    }
                } catch (SQLException e) {
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e, f5188a);
                    }
                }
            } finally {
                cursorM7591a.close();
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    public int m7647c() {
        return m7648d() + m7649e();
    }

    /* renamed from: d */
    public int m7648d() {
        int i = 0;
        Cursor cursorM7599e = this.f5189b.m7599e();
        try {
            try {
                if (cursorM7599e.moveToFirst()) {
                    i = cursorM7599e.getInt(0);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return i;
        } finally {
            cursorM7599e.close();
        }
    }

    /* renamed from: e */
    public int m7649e() {
        int i = 0;
        Cursor cursorM7600f = this.f5189b.m7600f();
        try {
            try {
                if (cursorM7600f.moveToFirst()) {
                    i = cursorM7600f.getInt(0) - 1;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return i;
        } finally {
            cursorM7600f.close();
        }
    }

    /* renamed from: a */
    public ArrayList<CallLogData> m7636a(int i, boolean z) {
        ArrayList<CallLogData> arrayListM7630a = null;
        Cursor cursorM7589a = this.f5189b.m7589a(i);
        try {
            try {
                arrayListM7630a = m7630a(cursorM7589a, 1, z);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return arrayListM7630a;
        } finally {
            cursorM7589a.close();
        }
    }

    /* renamed from: a */
    public ArrayList<CallLogData> m7641a(boolean z) {
        ArrayList<CallLogData> arrayListM7630a = null;
        Cursor cursorM7601g = this.f5189b.m7601g();
        try {
            try {
                arrayListM7630a = m7630a(cursorM7601g, 0, z);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return arrayListM7630a;
        } finally {
            cursorM7601g.close();
        }
    }

    /* renamed from: b */
    public ArrayList<CallLogData> m7646b(boolean z) {
        ArrayList<CallLogData> arrayListM7630a = null;
        Cursor cursorM7602h = this.f5189b.m7602h();
        try {
            try {
                arrayListM7630a = m7630a(cursorM7602h, 2, z);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return arrayListM7630a;
        } finally {
            cursorM7602h.close();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0032 A[DONT_GENERATE] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<java.lang.Integer> m7643a(int r4) {
        /*
            r3 = this;
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.sec.chaton.calllog.manager.a.a r0 = r3.f5189b
            android.database.Cursor r2 = r0.m7593b(r4)
            if (r2 == 0) goto L30
            r2.moveToFirst()     // Catch: android.database.SQLException -> L36 java.lang.Throwable -> L3d
            boolean r0 = r2.isAfterLast()     // Catch: android.database.SQLException -> L36 java.lang.Throwable -> L3d
            if (r0 != 0) goto L30
        L16:
            java.lang.String r0 = "_id"
            int r0 = r2.getColumnIndex(r0)     // Catch: android.database.SQLException -> L36 java.lang.Throwable -> L3d
            if (r0 < 0) goto L2a
            int r0 = r2.getInt(r0)     // Catch: android.database.SQLException -> L36 java.lang.Throwable -> L3d
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: android.database.SQLException -> L36 java.lang.Throwable -> L3d
            r1.add(r0)     // Catch: android.database.SQLException -> L36 java.lang.Throwable -> L3d
        L2a:
            boolean r0 = r2.moveToNext()     // Catch: android.database.SQLException -> L36 java.lang.Throwable -> L3d
            if (r0 != 0) goto L16
        L30:
            if (r2 == 0) goto L35
        L32:
            r2.close()
        L35:
            return r1
        L36:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L3d
            if (r2 == 0) goto L35
            goto L32
        L3d:
            r0 = move-exception
            if (r2 == 0) goto L43
            r2.close()
        L43:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.calllog.manager.model.C1456d.m7643a(int):java.util.List");
    }

    protected void finalize() {
        this.f5189b.m7596b();
    }

    /* renamed from: a */
    private ArrayList<CallLogData> m7630a(Cursor cursor, int i, boolean z) {
        ArrayList<CallLogData> arrayList = new ArrayList<>();
        if (cursor != null) {
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                CallLogData callLogData = new CallLogData(cursor);
                while (cursor.moveToNext()) {
                    switch (callLogData.m7623a(cursor, i)) {
                        case 1:
                            m7631a(arrayList, callLogData, z);
                            callLogData = new CallLogData(cursor);
                            if (i != 1) {
                                break;
                            } else {
                                m7632a(arrayList);
                                break;
                            }
                        case 2:
                            if (i != 0) {
                                break;
                            } else {
                                m7631a(arrayList, callLogData, z);
                                callLogData = new CallLogData(cursor);
                                break;
                            }
                        case 4:
                            m7631a(arrayList, callLogData, z);
                            callLogData = new CallLogData(cursor);
                            if (i != 1) {
                                break;
                            } else {
                                m7632a(arrayList);
                                break;
                            }
                        case 6:
                            m7631a(arrayList, callLogData, z);
                            callLogData = new CallLogData(cursor);
                            if (i != 1) {
                                break;
                            } else {
                                m7632a(arrayList);
                                break;
                            }
                    }
                }
                m7631a(arrayList, callLogData, z);
                if (i == 1) {
                    m7632a(arrayList);
                }
            }
            cursor.close();
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m7631a(ArrayList<CallLogData> arrayList, CallLogData callLogData, boolean z) {
        if (z) {
            if (arrayList.size() <= 0) {
                arrayList.add(m7629a(callLogData));
            } else if (arrayList.size() > 0 && !C1452a.m7605a().m7617c(arrayList.get(arrayList.size() - 1).userInfo.get(0).f5184j, callLogData.userInfo.get(0).f5184j)) {
                arrayList.add(m7629a(callLogData));
            }
        }
        if (callLogData.groupcallkey != null && !callLogData.groupcallkey.isEmpty()) {
            Iterator<C1455c> it = callLogData.userInfo.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C1455c next = it.next();
                if (C4809aa.m18104a().m18121a("chaton_id", "").equals(next.f5175a)) {
                    callLogData.myCalllogtype = next.f5186l;
                    callLogData.myDuration = next.f5185k;
                    callLogData.userInfo.remove(callLogData.userInfo.indexOf(next));
                    ArrayList<Integer> arrayListM7639a = m7639a(next.f5175a, callLogData.groupcallkey.get(0).intValue());
                    for (int i = 0; i < arrayListM7639a.size(); i++) {
                        if (callLogData.totalIDList.get(0).contains(arrayListM7639a.get(i))) {
                            callLogData.totalIDList.get(0).remove(callLogData.totalIDList.get(0).indexOf(arrayListM7639a.get(i)));
                        }
                    }
                }
            }
        }
        arrayList.add(callLogData);
    }

    /* renamed from: a */
    private SeperatorCallLog m7629a(CallLogData callLogData) {
        int iM7611a = (int) C1452a.m7605a().m7611a(callLogData.userInfo.get(0).f5184j);
        SeperatorCallLog seperatorCallLog = new SeperatorCallLog();
        if (iM7611a == 0 || iM7611a == -1) {
            seperatorCallLog.seperatorname = GlobalApplication.m18732r().getResources().getString(R.string.calllog_seperator_1);
            seperatorCallLog.displaytype = 0;
        } else if (iM7611a == 1) {
            seperatorCallLog.seperatorname = GlobalApplication.m18732r().getResources().getString(R.string.calllog_seperator_2);
            seperatorCallLog.displaytype = 1;
        } else if (iM7611a >= 2) {
            seperatorCallLog.seperatorname = callLogData.userInfo.get(0).f5184j;
        } else {
            seperatorCallLog.seperatorname = callLogData.userInfo.get(0).f5184j;
        }
        return seperatorCallLog;
    }

    /* renamed from: a */
    private boolean m7632a(List<CallLogData> list) {
        if (list.size() < 2 || !list.get(list.size() - 2).m7626a(list.get(list.size() - 1))) {
            return false;
        }
        list.remove(list.size() - 1);
        return true;
    }

    /* renamed from: f */
    public static String m7633f() {
        String string = Settings.System.getString(GlobalApplication.m18732r().getContentResolver(), "date_format");
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
