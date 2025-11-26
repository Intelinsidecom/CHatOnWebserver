package com.sec.chaton.p081n;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.CursorJoiner;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.p057e.C2290j;
import com.sec.chaton.p057e.p058a.C2190d;
import com.sec.chaton.smsplugin.p102b.C3782a;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: ContactComparator.java */
/* renamed from: com.sec.chaton.n.a */
/* loaded from: classes.dex */
public class C2915a {
    /* renamed from: a */
    public static void m12124a(InterfaceC2917c interfaceC2917c) {
        Cursor cursorQuery;
        ContentResolver contentResolver = CommonApplication.m18732r().getContentResolver();
        String[] strArr = {"_id", "data1", "raw_contact_id", SlookAirButtonFrequentContactAdapter.DISPLAY_NAME, "contact_id"};
        if (C4809aa.m18104a().m18119a("contact_sim_sync", (Boolean) false).booleanValue()) {
            cursorQuery = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, strArr, "account_type IS NOT NULL AND account_type NOT LIKE 'net.daum.android.air' AND account_type NOT LIKE 'net.daum.mypeople' AND account_type NOT LIKE 'com.sgiggle.production.account' AND account_type NOT LIKE 'com.skype.contacts.sync' AND account_type NOT LIKE 'com.whatsapp' AND account_type NOT LIKE 'com.linkedin.android' AND account_type NOT LIKE 'com.facebook.katana' AND account_type NOT LIKE 'com.invi.android' AND account_type NOT LIKE + 'com.sec.chaton'", null, "_id");
        } else {
            cursorQuery = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, strArr, "account_type IS NOT NULL AND account_type NOT LIKE 'net.daum.android.air' AND account_type NOT LIKE 'net.daum.mypeople' AND account_type NOT LIKE 'com.sgiggle.production.account' AND account_type NOT LIKE 'com.skype.contacts.sync' AND account_type NOT LIKE 'com.whatsapp' AND account_type NOT LIKE 'com.linkedin.android' AND account_type NOT LIKE 'com.facebook.katana' AND account_type NOT LIKE 'com.invi.android' AND account_type NOT LIKE 'com.sec.chaton' AND account_type NOT LIKE '%.sim'", null, "_id");
        }
        Cursor cursorQuery2 = contentResolver.query(C2290j.f8197a, new String[]{"contacts_id", "conatct_number", "contact_raw_id", "contacts_name", "contacts_contact_id"}, null, null, "contacts_id");
        CursorJoiner cursorJoiner = new CursorJoiner(cursorQuery, new String[]{"_id"}, cursorQuery2, new String[]{"contacts_id"});
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        Iterator<CursorJoiner.Result> it = cursorJoiner.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                switch (C2916b.f10781a[it.next().ordinal()]) {
                    case 1:
                        if (i2 >= 1000) {
                            break;
                        } else {
                            C4904y.m18646e("Added : " + cursorQuery.getString(1) + ", rawId=" + cursorQuery.getLong(2) + ", name=" + cursorQuery.getString(3), "ContactComparator");
                            interfaceC2917c.mo9178a(cursorQuery, cursorQuery2);
                            if (C2349a.m10301a("sms_feature") && cursorQuery.getString(1) != null && cursorQuery.getString(1).replaceAll("[^\\+\\*\\#0-9]", "").length() >= 8 && !map.containsKey(Integer.valueOf(cursorQuery.getInt(4)))) {
                                map.put(Integer.valueOf(cursorQuery.getInt(4)), cursorQuery.getString(3));
                                arrayList.add(cursorQuery.getString(2));
                                arrayList.add(cursorQuery.getString(4));
                            }
                            String string = cursorQuery.getString(1);
                            if (!TextUtils.isEmpty(string)) {
                                arrayList2.add(string);
                            }
                            i2++;
                            break;
                        }
                        break;
                    case 2:
                        C4904y.m18646e("Deleted : " + cursorQuery2.getString(1) + ", rawId=" + cursorQuery2.getLong(2) + ", name=" + cursorQuery2.getString(3), "ContactComparator");
                        interfaceC2917c.mo9179b(cursorQuery, cursorQuery2);
                        if (C2349a.m10301a("sms_feature") && !map.containsKey(Integer.valueOf(cursorQuery2.getInt(4)))) {
                            map.put(Integer.valueOf(cursorQuery2.getInt(4)), cursorQuery2.getString(3));
                            arrayList.add(cursorQuery2.getString(2));
                            arrayList.add(cursorQuery2.getString(4));
                        }
                        String string2 = cursorQuery2.getString(1);
                        if (!TextUtils.isEmpty(string2)) {
                            arrayList2.add(string2);
                            break;
                        } else {
                            break;
                        }
                        break;
                    case 3:
                        String string3 = cursorQuery.getString(1);
                        String string4 = cursorQuery2.getString(1);
                        if (cursorQuery.getInt(cursorQuery.getColumnIndex("contact_id")) != cursorQuery2.getInt(cursorQuery2.getColumnIndex("contacts_contact_id"))) {
                            if (C4904y.f17871a) {
                                C4904y.m18646e("contact ID Modified,  " + cursorQuery2.getInt(4) + " -> " + cursorQuery.getInt(4), "ContactComparator");
                            }
                            interfaceC2917c.mo9182e(cursorQuery, cursorQuery2);
                            if (C2349a.m10301a("sms_feature") && cursorQuery.getString(1) != null && cursorQuery.getString(1).replaceAll("[^\\+\\*\\#0-9]", "").length() >= 8) {
                                if (!map.containsKey(Integer.valueOf(cursorQuery2.getInt(4)))) {
                                    map.put(Integer.valueOf(cursorQuery2.getInt(4)), cursorQuery.getString(3));
                                    arrayList.add(cursorQuery2.getString(2));
                                    arrayList.add(cursorQuery2.getString(4));
                                }
                                if (!map.containsKey(Integer.valueOf(cursorQuery.getInt(4)))) {
                                    map.put(Integer.valueOf(cursorQuery.getInt(4)), cursorQuery2.getString(3));
                                    arrayList.add(cursorQuery.getString(2));
                                    arrayList.add(cursorQuery.getString(4));
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            if (!string3.equals(string4)) {
                                C4904y.m18646e("Number Modified,  " + string4 + " -> " + string3, "ContactComparator");
                                interfaceC2917c.mo9180c(cursorQuery, cursorQuery2);
                                if (C2349a.m10301a("sms_feature") && cursorQuery.getString(1) != null && cursorQuery.getString(1).replaceAll("[^\\+\\*\\#0-9]", "").length() >= 8 && !map.containsKey(Integer.valueOf(cursorQuery.getInt(4)))) {
                                    map.put(Integer.valueOf(cursorQuery.getInt(4)), cursorQuery.getString(3));
                                    arrayList.add(cursorQuery.getString(2));
                                    arrayList.add(cursorQuery.getString(4));
                                }
                                if (!TextUtils.isEmpty(string4)) {
                                    arrayList2.add(string4);
                                }
                                if (!TextUtils.isEmpty(string3)) {
                                    arrayList2.add(string3);
                                }
                            }
                            String string5 = cursorQuery.getString(3);
                            String string6 = cursorQuery2.getString(3);
                            cursorQuery2.getString(2);
                            if (!string5.equals(string6)) {
                                C4904y.m18646e("Name Modified,  " + cursorQuery2.getString(0) + " -> " + cursorQuery2.getString(1) + " -> " + cursorQuery2.getString(2) + " -> " + cursorQuery2.getString(3), "ContactComparator");
                                C4904y.m18646e("Name Modified,  " + cursorQuery.getString(0) + " -> " + cursorQuery.getString(1) + " -> " + cursorQuery.getString(2) + " -> " + cursorQuery.getString(3), "ContactComparator");
                                C4904y.m18646e("Name Modified,  " + string6 + " -> " + string5, "ContactComparator");
                                interfaceC2917c.mo9181d(cursorQuery, cursorQuery2);
                                if (C2349a.m10301a("sms_feature") && cursorQuery.getString(1) != null && cursorQuery.getString(1).replaceAll("[^\\+\\*\\#0-9]", "").length() >= 8 && !map.containsKey(Integer.valueOf(cursorQuery.getInt(4)))) {
                                    map.put(Integer.valueOf(cursorQuery.getInt(4)), cursorQuery.getString(3));
                                    arrayList.add(cursorQuery.getString(2));
                                    arrayList.add(cursorQuery.getString(4));
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        break;
                }
                i = i2;
            } else {
                if (C2349a.m10301a("sms_feature")) {
                    C2190d.m9812a(cursorQuery, map, (ArrayList<String>) arrayList2);
                    if (!arrayList.isEmpty()) {
                        C3890m.m14994a("ContactComparator", "updateContactCacheName from contactComparator");
                        C3782a.m14214a((ArrayList<String>) arrayList);
                    }
                }
                cursorQuery.close();
                cursorQuery2.close();
                return;
            }
        }
    }
}
