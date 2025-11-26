package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.C1441i;
import com.sec.chaton.p027e.p028a.C1360d;
import com.sec.chaton.p035io.entry.inner.Address;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.p046m.C1669a;
import com.sec.chaton.p046m.C1672d;
import com.sec.chaton.p046m.InterfaceC1671c;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3164af;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/* compiled from: UploadAddressTask.java */
/* renamed from: com.sec.chaton.d.a.ef */
/* loaded from: classes.dex */
public class C1259ef extends AbstractC1145a {

    /* renamed from: b */
    InterfaceC1671c f4829b;

    /* renamed from: c */
    private ArrayList<ContentProviderOperation> f4830c;

    /* renamed from: e */
    private ArrayList<ContentProviderOperation> f4831e;

    /* renamed from: f */
    private ArrayList<C1672d> f4832f;

    /* renamed from: g */
    private ArrayList<C1672d> f4833g;

    /* renamed from: h */
    private ArrayList<C1672d> f4834h;

    /* renamed from: i */
    private String f4835i;

    /* renamed from: j */
    private String f4836j;

    /* renamed from: k */
    private String f4837k;

    /* renamed from: l */
    private String f4838l;

    /* renamed from: m */
    private int f4839m;

    /* renamed from: n */
    private ArrayList<String> f4840n;

    /* renamed from: o */
    private HashMap<String, ArrayList<String>> f4841o;

    /* renamed from: p */
    private ArrayList<C1672d> f4842p;

    /* renamed from: q */
    private ArrayList<C1672d> f4843q;

    /* renamed from: r */
    private int f4844r;

    /* renamed from: s */
    private String f4845s;

    public C1259ef(Handler handler, C1580h c1580h) {
        super(handler, c1580h);
        this.f4835i = null;
        this.f4836j = null;
        this.f4837k = null;
        this.f4838l = null;
        this.f4839m = 0;
        this.f4844r = 0;
        this.f4845s = "+";
        this.f4829b = new C1260eg(this);
        this.f4832f = new ArrayList<>();
        this.f4833g = new ArrayList<>();
        this.f4830c = new ArrayList<>();
        this.f4831e = new ArrayList<>();
    }

    public C1259ef(Handler handler, C1580h c1580h, String str, String str2) {
        super(handler, c1580h);
        this.f4835i = null;
        this.f4836j = null;
        this.f4837k = null;
        this.f4838l = null;
        this.f4839m = 0;
        this.f4844r = 0;
        this.f4845s = "+";
        this.f4829b = new C1260eg(this);
        this.f4832f = new ArrayList<>();
        this.f4833g = new ArrayList<>();
        this.f4830c = new ArrayList<>();
        this.f4831e = new ArrayList<>();
        this.f4835i = str;
        this.f4836j = str2;
    }

    public C1259ef(Handler handler, C1580h c1580h, String str, String str2, String[] strArr, int i) {
        super(handler, c1580h);
        this.f4835i = null;
        this.f4836j = null;
        this.f4837k = null;
        this.f4838l = null;
        this.f4839m = 0;
        this.f4844r = 0;
        this.f4845s = "+";
        this.f4829b = new C1260eg(this);
        this.f4832f = new ArrayList<>();
        this.f4833g = new ArrayList<>();
        this.f4830c = new ArrayList<>();
        this.f4831e = new ArrayList<>();
        this.f4834h = new ArrayList<>();
        this.f4837k = str;
        this.f4838l = str2;
        this.f4839m = i;
        if (strArr != null) {
            for (String str3 : strArr) {
                this.f4834h.add(new C1672d(0, str3, 0, "", ""));
            }
        }
    }

    public C1259ef(Handler handler, C1580h c1580h, int i, ArrayList<String> arrayList, HashMap<String, ArrayList<String>> map) {
        super(handler, c1580h);
        this.f4835i = null;
        this.f4836j = null;
        this.f4837k = null;
        this.f4838l = null;
        this.f4839m = 0;
        this.f4844r = 0;
        this.f4845s = "+";
        this.f4829b = new C1260eg(this);
        this.f4832f = new ArrayList<>();
        this.f4833g = new ArrayList<>();
        this.f4830c = new ArrayList<>();
        this.f4831e = new ArrayList<>();
        this.f4839m = i;
        this.f4840n = arrayList;
        this.f4841o = map;
    }

    public C1259ef(Handler handler, C1580h c1580h, String str, String[] strArr, String[] strArr2, int i) {
        super(handler, c1580h);
        this.f4835i = null;
        this.f4836j = null;
        this.f4837k = null;
        this.f4838l = null;
        this.f4839m = 0;
        this.f4844r = 0;
        this.f4845s = "+";
        this.f4829b = new C1260eg(this);
        this.f4832f = new ArrayList<>();
        this.f4833g = new ArrayList<>();
        this.f4830c = new ArrayList<>();
        this.f4831e = new ArrayList<>();
        this.f4842p = new ArrayList<>();
        this.f4843q = new ArrayList<>();
        if (strArr != null) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                this.f4842p.add(new C1672d(0, strArr[i2], 0, "", m5572c(strArr[i2])));
            }
        }
        if (strArr2 != null) {
            for (int i3 = 0; i3 < strArr2.length; i3++) {
                this.f4843q.add(new C1672d(0, strArr2[i3], 0, "", m5572c(strArr2[i3])));
            }
        }
        this.f4838l = str;
        this.f4839m = i;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        if (this.f4839m == 0 && !TextUtils.isEmpty(C3159aa.m10962a().m10979a("msisdn", ""))) {
            C3250y.m11450b("Cotact Compare Start", "UploadAddressTask");
            C1669a.m6945a(this.f4829b);
            C3250y.m11450b("Cotact Compare End", "UploadAddressTask");
        } else {
            C3250y.m11450b("User do not conduct contact sync", "UploadAddressTask");
        }
        ArrayList arrayList = new ArrayList();
        Iterator<C1672d> it = this.f4832f.iterator();
        while (it.hasNext()) {
            C1672d next = it.next();
            if (next.m6949d().length() >= 8) {
                Address address = new Address();
                if (next.m6949d().length() > 64) {
                    C3250y.m11456e("Number is too long : " + next.m6949d(), "UploadAddressTask");
                } else {
                    if (next.m6948c() != null) {
                        if (next.m6948c().length() < 48) {
                            address.name = next.m6948c();
                        } else {
                            address.name = next.m6948c().substring(0, 48);
                        }
                    }
                    address.value = next.m6949d();
                    arrayList.add(address);
                }
            }
        }
        if (this.f4835i != null && this.f4836j != null) {
            Address address2 = new Address();
            address2.value = this.f4836j;
            address2.name = this.f4835i;
            arrayList.add(address2);
        }
        if (this.f4839m == 325) {
            Iterator<C1672d> it2 = this.f4834h.iterator();
            while (it2.hasNext()) {
                C1672d next2 = it2.next();
                Address address3 = new Address();
                address3.group = this.f4838l;
                address3.value = this.f4845s + next2.m6946a();
                arrayList.add(address3);
            }
        } else if (this.f4839m == 326) {
            Iterator<C1672d> it3 = this.f4834h.iterator();
            while (it3.hasNext()) {
                C1672d next3 = it3.next();
                Address address4 = new Address();
                address4.group = this.f4837k + "," + this.f4838l;
                address4.value = this.f4845s + next3.m6946a();
                arrayList.add(address4);
            }
        } else if (this.f4839m == 327) {
            Iterator<C1672d> it4 = this.f4834h.iterator();
            while (it4.hasNext()) {
                C1672d next4 = it4.next();
                Address address5 = new Address();
                address5.group = this.f4837k + ", ";
                address5.value = this.f4845s + next4.m6946a();
                arrayList.add(address5);
            }
        } else if (this.f4839m == 328) {
            if (this.f4840n != null && this.f4841o != null) {
                for (int i = 0; i < this.f4840n.size(); i++) {
                    ArrayList<String> arrayList2 = this.f4841o.get(this.f4840n.get(i));
                    if (arrayList2 != null) {
                        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                            Address address6 = new Address();
                            address6.group = this.f4840n.get(i);
                            address6.value = this.f4845s + arrayList2.get(i2);
                            arrayList.add(address6);
                        }
                    }
                }
            }
        } else if (this.f4839m == 329) {
            Iterator<C1672d> it5 = this.f4842p.iterator();
            while (it5.hasNext()) {
                C1672d next5 = it5.next();
                Address address7 = new Address();
                address7.group = this.f4838l;
                address7.value = this.f4845s + next5.m6946a();
                arrayList.add(address7);
            }
            Iterator<C1672d> it6 = this.f4843q.iterator();
            while (it6.hasNext()) {
                C1672d next6 = it6.next();
                Address address8 = new Address();
                address8.group = this.f4838l + ", ";
                address8.value = this.f4845s + next6.m6946a();
                arrayList.add(address8);
            }
        } else {
            C3250y.m11450b("Can't upload group information, groupMode is mandatory", "UploadAddressTask");
        }
        this.f4844r = arrayList.size();
        if (arrayList.size() == 0 && this.f4839m != 328) {
            m11680p();
        }
        C3250y.m11453c("Sent Contact Count : " + arrayList.size(), "UploadAddressTask");
        String strM11026a = new C3164af().m11026a(arrayList);
        C3250y.m11456e(strM11026a, "UploadAddressTask");
        return strM11026a;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) throws RemoteException, OperationApplicationException {
        if (c0267d.m1351b() != EnumC1587o.ERROR) {
            ContentResolver contentResolver = CommonApplication.m11493l().getContentResolver();
            Iterator<C1672d> it = this.f4833g.iterator();
            while (it.hasNext()) {
                C1672d next = it.next();
                String strM5568a = m5568a(next.m6949d());
                Cursor cursorQuery = contentResolver.query(C1441i.f5369a, null, "buddy_raw_contact_id = ? and buddy_no = ?", new String[]{String.valueOf(next.m6947b()), strM5568a}, null);
                C3250y.m11450b("afterRequest deletedPerson " + next.m6947b() + ", name=" + next.m6948c() + ", num=" + next.m6949d(), "UploadAddressTask");
                while (cursorQuery.moveToNext()) {
                    this.f4830c.add(C1360d.m6023a(String.valueOf(next.m6947b()), strM5568a, cursorQuery.getString(cursorQuery.getColumnIndex("buddy_push_name")), cursorQuery.getString(cursorQuery.getColumnIndex("buddy_original_name"))));
                }
                cursorQuery.close();
            }
            C3250y.m11456e("Start making local Contact", "UploadAddressTask");
            if (this.f4830c.size() > 0) {
                contentResolver.applyBatch("com.sec.chaton.provider", this.f4830c);
            }
            if (this.f4831e.size() > 0) {
                contentResolver.applyBatch("com.android.contacts", this.f4831e);
            }
            C3250y.m11456e("End making local Contact", "UploadAddressTask");
        }
    }

    /* renamed from: a */
    public static String m5568a(String str) {
        Cursor cursorQuery = CommonApplication.m11493l().getContentResolver().query(C1441i.f5369a, new String[]{"buddy_no", "buddy_orginal_number", "buddy_orginal_numbers"}, null, null, null);
        if (cursorQuery != null) {
            try {
                try {
                    cursorQuery.moveToFirst();
                    do {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_orginal_numbers"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_orginal_number"));
                        String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_no"));
                        if (string != null) {
                            new ArrayList();
                            List<String> listM5571b = m5571b(string);
                            for (int i = 0; i < listM5571b.size(); i++) {
                                if (str.equals(listM5571b.get(i))) {
                                    if (cursorQuery == null) {
                                        return string3;
                                    }
                                }
                            }
                        } else if (string2 != null && str.equals(string2)) {
                            return cursorQuery != null ? string3 : string3;
                        }
                    } while (cursorQuery.moveToNext());
                } catch (Exception e) {
                    e.printStackTrace();
                    if (cursorQuery != null) {
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        return "";
    }

    /* renamed from: b */
    public static List<String> m5571b(String str) {
        ArrayList arrayList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(str, "|");
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return arrayList;
    }

    /* renamed from: i */
    public int m5575i() {
        return this.f4844r;
    }

    /* renamed from: c */
    public static String m5572c(String str) {
        return str.replaceAll("[^\\+\\*\\#0-9]", "");
    }
}
