package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.C2289i;
import com.sec.chaton.p057e.p058a.C2190d;
import com.sec.chaton.p065io.entry.inner.Address;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.p081n.C2915a;
import com.sec.chaton.p081n.C2918d;
import com.sec.chaton.p081n.InterfaceC2917c;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4815ag;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/* compiled from: UploadAddressTask.java */
/* renamed from: com.sec.chaton.d.a.fe */
/* loaded from: classes.dex */
public class C2040fe extends AbstractC1900a {

    /* renamed from: b */
    InterfaceC2917c f7450b;

    /* renamed from: c */
    private ArrayList<ContentProviderOperation> f7451c;

    /* renamed from: d */
    private ArrayList<ContentProviderOperation> f7452d;

    /* renamed from: e */
    private ArrayList<C2918d> f7453e;

    /* renamed from: g */
    private ArrayList<C2918d> f7454g;

    /* renamed from: h */
    private ArrayList<C2918d> f7455h;

    /* renamed from: i */
    private String f7456i;

    /* renamed from: j */
    private String f7457j;

    /* renamed from: k */
    private String f7458k;

    /* renamed from: l */
    private String f7459l;

    /* renamed from: m */
    private int f7460m;

    /* renamed from: n */
    private String f7461n;

    /* renamed from: o */
    private ArrayList<String> f7462o;

    /* renamed from: p */
    private HashMap<String, ArrayList<String>> f7463p;

    /* renamed from: q */
    private ArrayList<C2918d> f7464q;

    /* renamed from: r */
    private ArrayList<C2918d> f7465r;

    /* renamed from: s */
    private int f7466s;

    /* renamed from: t */
    private String f7467t;

    public C2040fe(C2454e c2454e) {
        super(c2454e);
        this.f7456i = null;
        this.f7457j = null;
        this.f7458k = null;
        this.f7459l = null;
        this.f7460m = 0;
        this.f7461n = "";
        this.f7466s = 0;
        this.f7467t = "+";
        this.f7450b = new C2041ff(this);
        this.f7453e = new ArrayList<>();
        this.f7454g = new ArrayList<>();
        this.f7451c = new ArrayList<>();
        this.f7452d = new ArrayList<>();
    }

    public C2040fe(Handler handler, C2454e c2454e, String str, String str2, String str3) {
        super(c2454e);
        this.f7456i = null;
        this.f7457j = null;
        this.f7458k = null;
        this.f7459l = null;
        this.f7460m = 0;
        this.f7461n = "";
        this.f7466s = 0;
        this.f7467t = "+";
        this.f7450b = new C2041ff(this);
        this.f7453e = new ArrayList<>();
        this.f7454g = new ArrayList<>();
        this.f7451c = new ArrayList<>();
        this.f7452d = new ArrayList<>();
        this.f7456i = str;
        this.f7457j = str2;
        this.f7461n = str3;
    }

    public C2040fe(Handler handler, C2454e c2454e, String str, String str2, String[] strArr, int i) {
        super(c2454e);
        this.f7456i = null;
        this.f7457j = null;
        this.f7458k = null;
        this.f7459l = null;
        this.f7460m = 0;
        this.f7461n = "";
        this.f7466s = 0;
        this.f7467t = "+";
        this.f7450b = new C2041ff(this);
        this.f7453e = new ArrayList<>();
        this.f7454g = new ArrayList<>();
        this.f7451c = new ArrayList<>();
        this.f7452d = new ArrayList<>();
        this.f7455h = new ArrayList<>();
        this.f7458k = str;
        this.f7459l = str2;
        this.f7460m = i;
        if (strArr != null) {
            for (String str3 : strArr) {
                this.f7455h.add(new C2918d(0, str3, 0, "", "", 0));
            }
        }
    }

    public C2040fe(Handler handler, C2454e c2454e, int i, ArrayList<String> arrayList, HashMap<String, ArrayList<String>> map) {
        super(c2454e);
        this.f7456i = null;
        this.f7457j = null;
        this.f7458k = null;
        this.f7459l = null;
        this.f7460m = 0;
        this.f7461n = "";
        this.f7466s = 0;
        this.f7467t = "+";
        this.f7450b = new C2041ff(this);
        this.f7453e = new ArrayList<>();
        this.f7454g = new ArrayList<>();
        this.f7451c = new ArrayList<>();
        this.f7452d = new ArrayList<>();
        this.f7460m = i;
        this.f7462o = arrayList;
        this.f7463p = map;
    }

    public C2040fe(Handler handler, C2454e c2454e, String str, String[] strArr, String[] strArr2, int i) {
        super(c2454e);
        this.f7456i = null;
        this.f7457j = null;
        this.f7458k = null;
        this.f7459l = null;
        this.f7460m = 0;
        this.f7461n = "";
        this.f7466s = 0;
        this.f7467t = "+";
        this.f7450b = new C2041ff(this);
        this.f7453e = new ArrayList<>();
        this.f7454g = new ArrayList<>();
        this.f7451c = new ArrayList<>();
        this.f7452d = new ArrayList<>();
        this.f7464q = new ArrayList<>();
        this.f7465r = new ArrayList<>();
        if (strArr != null) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                this.f7464q.add(new C2918d(0, strArr[i2], 0, "", m9174c(strArr[i2]), 0));
            }
        }
        if (strArr2 != null) {
            for (int i3 = 0; i3 < strArr2.length; i3++) {
                this.f7465r.add(new C2918d(0, strArr2[i3], 0, "", m9174c(strArr2[i3]), 0));
            }
        }
        this.f7459l = str;
        this.f7460m = i;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        if (C2349a.m10301a("sms_feature")) {
            if (this.f7460m == 0 && !this.f7461n.equals("update")) {
                C4904y.m18639b("Cotact Compare Start", "UploadAddressTask");
                C2915a.m12124a(this.f7450b);
                C4904y.m18639b("Cotact Compare End", "UploadAddressTask");
            } else {
                C4904y.m18639b("User do not conduct contact sync", "UploadAddressTask");
            }
        } else if (this.f7460m == 0 && !this.f7461n.equals("update") && !TextUtils.isEmpty(C4809aa.m18104a().m18121a("msisdn", ""))) {
            C4904y.m18639b("Cotact Compare Start", "UploadAddressTask");
            C2915a.m12124a(this.f7450b);
            C4904y.m18639b("Cotact Compare End", "UploadAddressTask");
        } else {
            C4904y.m18639b("User do not conduct contact sync", "UploadAddressTask");
        }
        ArrayList arrayList = new ArrayList();
        Iterator<C2918d> it = this.f7453e.iterator();
        while (it.hasNext()) {
            C2918d next = it.next();
            if (next.m12129e().length() >= 8) {
                Address address = new Address();
                if (next.m12129e().length() > 64) {
                    C4904y.m18646e("Number is too long : " + next.m12129e(), "UploadAddressTask");
                } else {
                    if (next.m12128d() != null) {
                        if (next.m12128d().length() < 48) {
                            address.name = next.m12128d();
                        } else {
                            address.name = next.m12128d().substring(0, 48);
                        }
                    }
                    address.value = next.m12129e();
                    arrayList.add(address);
                }
            }
        }
        if (this.f7456i != null && this.f7457j != null) {
            Address address2 = new Address();
            address2.value = this.f7457j;
            address2.name = this.f7456i;
            arrayList.add(address2);
        }
        if (this.f7460m == 325) {
            Iterator<C2918d> it2 = this.f7455h.iterator();
            while (it2.hasNext()) {
                C2918d next2 = it2.next();
                Address address3 = new Address();
                address3.group = this.f7459l;
                address3.value = this.f7467t + next2.m12126b();
                arrayList.add(address3);
            }
        } else if (this.f7460m == 326) {
            Iterator<C2918d> it3 = this.f7455h.iterator();
            while (it3.hasNext()) {
                C2918d next3 = it3.next();
                Address address4 = new Address();
                address4.group = this.f7458k + "," + this.f7459l;
                address4.value = this.f7467t + next3.m12126b();
                arrayList.add(address4);
            }
        } else if (this.f7460m == 327) {
            Iterator<C2918d> it4 = this.f7455h.iterator();
            while (it4.hasNext()) {
                C2918d next4 = it4.next();
                Address address5 = new Address();
                address5.group = this.f7458k + ", ";
                address5.value = this.f7467t + next4.m12126b();
                arrayList.add(address5);
            }
        } else if (this.f7460m == 328) {
            if (this.f7462o != null && this.f7463p != null) {
                for (int i = 0; i < this.f7462o.size(); i++) {
                    ArrayList<String> arrayList2 = this.f7463p.get(this.f7462o.get(i));
                    if (arrayList2 != null) {
                        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                            Address address6 = new Address();
                            address6.group = this.f7462o.get(i);
                            address6.value = this.f7467t + arrayList2.get(i2);
                            arrayList.add(address6);
                        }
                    }
                }
            }
        } else if (this.f7460m == 329) {
            Iterator<C2918d> it5 = this.f7464q.iterator();
            while (it5.hasNext()) {
                C2918d next5 = it5.next();
                Address address7 = new Address();
                address7.group = this.f7459l;
                address7.value = this.f7467t + next5.m12126b();
                arrayList.add(address7);
            }
            Iterator<C2918d> it6 = this.f7465r.iterator();
            while (it6.hasNext()) {
                C2918d next6 = it6.next();
                Address address8 = new Address();
                address8.group = this.f7459l + ", ";
                address8.value = this.f7467t + next6.m12126b();
                arrayList.add(address8);
            }
        } else if (C4904y.f17872b) {
            C4904y.m18639b("Can't upload group information, groupMode is mandatory", "UploadAddressTask");
        }
        this.f7466s = arrayList.size();
        if (arrayList.size() == 0 && this.f7460m != 328) {
            m18922l();
        }
        C4904y.m18641c("Sent Contact Count : " + arrayList.size(), "UploadAddressTask");
        String strM18172a = new C4815ag().m18172a(arrayList);
        C4904y.m18646e(strM18172a, "UploadAddressTask");
        return strM18172a;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) throws Throwable {
        if (c0778b.m3107b() != EnumC2464o.ERROR) {
            ContentResolver contentResolver = CommonApplication.m18732r().getContentResolver();
            Iterator<C2918d> it = this.f7454g.iterator();
            while (it.hasNext()) {
                C2918d next = it.next();
                String strM9170a = m9170a(next.m12129e());
                Cursor cursorQuery = contentResolver.query(C2289i.f8196a, null, "buddy_raw_contact_id = ? and buddy_no = ?", new String[]{String.valueOf(next.m12127c()), strM9170a}, null);
                if (C4904y.f17872b) {
                    C4904y.m18639b("afterRequest deletedPerson " + next.m12127c() + ", name=" + next.m12128d() + ", num=" + next.m12129e(), "UploadAddressTask");
                }
                while (cursorQuery.moveToNext()) {
                    this.f7451c.add(C2190d.m9805a(String.valueOf(next.m12127c()), strM9170a, cursorQuery.getString(cursorQuery.getColumnIndex("buddy_push_name")), cursorQuery.getString(cursorQuery.getColumnIndex("buddy_original_name"))));
                }
                cursorQuery.close();
            }
            C4904y.m18646e("Start making local Contact", "UploadAddressTask");
            if (this.f7451c.size() > 0) {
                contentResolver.applyBatch("com.sec.chaton.provider", this.f7451c);
            }
            if (this.f7452d.size() > 0) {
                contentResolver.applyBatch("com.android.contacts", this.f7452d);
            }
            C4904y.m18646e("End making local Contact", "UploadAddressTask");
            return;
        }
        if (c0778b.m3107b() == EnumC2464o.ERROR) {
            if ((c0778b.m3111f() == 14007 || c0778b.m3111f() == 10000) && C2349a.m10301a("sms_feature") && TextUtils.isEmpty(C4809aa.m18104a().m18121a("msisdn", ""))) {
                ContentResolver contentResolver2 = CommonApplication.m18732r().getContentResolver();
                C4904y.m18646e("Start making local Contact", "UploadAddressTask");
                if (this.f7451c.size() > 0) {
                    contentResolver2.applyBatch("com.sec.chaton.provider", this.f7451c);
                }
                if (this.f7452d.size() > 0) {
                    contentResolver2.applyBatch("com.android.contacts", this.f7452d);
                }
                C4904y.m18646e("End making local Contact", "UploadAddressTask");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008f A[PHI: r1
  0x008f: PHI (r1v4 android.database.Cursor) = (r1v3 android.database.Cursor), (r1v6 android.database.Cursor) binds: [B:32:0x0099, B:26:0x008d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a0  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m9170a(java.lang.String r9) throws java.lang.Throwable {
        /*
            r8 = 0
            r7 = 0
            java.lang.String r6 = ""
            android.content.Context r0 = com.sec.common.CommonApplication.m18732r()     // Catch: java.lang.Exception -> L94 java.lang.Throwable -> L9c
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Exception -> L94 java.lang.Throwable -> L9c
            android.net.Uri r1 = com.sec.chaton.p057e.C2289i.f8196a     // Catch: java.lang.Exception -> L94 java.lang.Throwable -> L9c
            r2 = 3
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Exception -> L94 java.lang.Throwable -> L9c
            r3 = 0
            java.lang.String r4 = "buddy_no"
            r2[r3] = r4     // Catch: java.lang.Exception -> L94 java.lang.Throwable -> L9c
            r3 = 1
            java.lang.String r4 = "buddy_orginal_number"
            r2[r3] = r4     // Catch: java.lang.Exception -> L94 java.lang.Throwable -> L9c
            r3 = 2
            java.lang.String r4 = "buddy_orginal_numbers"
            r2[r3] = r4     // Catch: java.lang.Exception -> L94 java.lang.Throwable -> L9c
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L94 java.lang.Throwable -> L9c
            if (r1 == 0) goto L8d
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> La4 java.lang.Exception -> La6
            if (r0 == 0) goto L8d
            r1.moveToFirst()     // Catch: java.lang.Throwable -> La4 java.lang.Exception -> La6
        L36:
            java.lang.String r0 = "buddy_orginal_numbers"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> La4 java.lang.Exception -> La6
            java.lang.String r2 = r1.getString(r0)     // Catch: java.lang.Throwable -> La4 java.lang.Exception -> La6
            java.lang.String r0 = "buddy_orginal_number"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> La4 java.lang.Exception -> La6
            java.lang.String r3 = r1.getString(r0)     // Catch: java.lang.Throwable -> La4 java.lang.Exception -> La6
            java.lang.String r0 = "buddy_no"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> La4 java.lang.Exception -> La6
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> La4 java.lang.Exception -> La6
            if (r2 == 0) goto L7c
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> La4 java.lang.Exception -> La6
            r3.<init>()     // Catch: java.lang.Throwable -> La4 java.lang.Exception -> La6
            java.util.List r3 = m9173b(r2)     // Catch: java.lang.Throwable -> La4 java.lang.Exception -> La6
            r2 = r8
        L63:
            int r4 = r3.size()     // Catch: java.lang.Throwable -> La4 java.lang.Exception -> La6
            if (r2 >= r4) goto L87
            java.lang.Object r4 = r3.get(r2)     // Catch: java.lang.Throwable -> La4 java.lang.Exception -> La6
            boolean r4 = r9.equals(r4)     // Catch: java.lang.Throwable -> La4 java.lang.Exception -> La6
            if (r4 == 0) goto L79
            if (r1 == 0) goto L78
        L75:
            r1.close()
        L78:
            return r0
        L79:
            int r2 = r2 + 1
            goto L63
        L7c:
            if (r3 == 0) goto L87
            boolean r2 = r9.equals(r3)     // Catch: java.lang.Throwable -> La4 java.lang.Exception -> La6
            if (r2 == 0) goto L87
            if (r1 == 0) goto L78
            goto L75
        L87:
            boolean r0 = r1.moveToNext()     // Catch: java.lang.Throwable -> La4 java.lang.Exception -> La6
            if (r0 != 0) goto L36
        L8d:
            if (r1 == 0) goto L92
        L8f:
            r1.close()
        L92:
            r0 = r6
            goto L78
        L94:
            r0 = move-exception
            r1 = r7
        L96:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> La4
            if (r1 == 0) goto L92
            goto L8f
        L9c:
            r0 = move-exception
            r1 = r7
        L9e:
            if (r1 == 0) goto La3
            r1.close()
        La3:
            throw r0
        La4:
            r0 = move-exception
            goto L9e
        La6:
            r0 = move-exception
            goto L96
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p055d.p056a.C2040fe.m9170a(java.lang.String):java.lang.String");
    }

    /* renamed from: b */
    public static List<String> m9173b(String str) {
        ArrayList arrayList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(str, "|");
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return arrayList;
    }

    /* renamed from: e */
    public int m9177e() {
        return this.f7466s;
    }

    /* renamed from: c */
    public static String m9174c(String str) {
        return str.replaceAll("[^\\+\\*\\#0-9]", "");
    }
}
