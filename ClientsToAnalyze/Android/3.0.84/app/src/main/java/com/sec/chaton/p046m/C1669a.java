package com.sec.chaton.p046m;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.CursorJoiner;
import android.provider.ContactsContract;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.sec.chaton.p027e.C1442j;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.Iterator;

/* compiled from: ContactComparator.java */
/* renamed from: com.sec.chaton.m.a */
/* loaded from: classes.dex */
public class C1669a {
    /* renamed from: a */
    public static void m6945a(InterfaceC1671c interfaceC1671c) {
        Cursor cursorQuery;
        ContentResolver contentResolver = CommonApplication.m11493l().getContentResolver();
        String[] strArr = {"_id", "data1", "raw_contact_id", SlookAirButtonFrequentContactAdapter.DISPLAY_NAME};
        if (C3159aa.m10962a().m10977a("contact_sim_sync", (Boolean) false).booleanValue()) {
            cursorQuery = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, strArr, "account_type IS NOT NULL AND account_type NOT LIKE 'com.kakao.talk' AND account_type NOT LIKE 'net.daum.mypeople' AND account_type NOT LIKE 'com.sgiggle.production.account' AND account_type NOT LIKE 'com.skype.contacts.sync' AND account_type NOT LIKE 'com.whatsapp' AND account_type NOT LIKE + 'com.sec.chaton'", null, "_id");
        } else {
            cursorQuery = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, strArr, "account_type IS NOT NULL AND account_type NOT LIKE 'com.kakao.talk' AND account_type NOT LIKE 'net.daum.mypeople' AND account_type NOT LIKE 'com.sgiggle.production.account' AND account_type NOT LIKE 'com.skype.contacts.sync' AND account_type NOT LIKE 'com.whatsapp' AND account_type NOT LIKE 'com.sec.chaton' AND account_type NOT LIKE '%.sim'", null, "_id");
        }
        Cursor cursorQuery2 = contentResolver.query(C1442j.f5370a, new String[]{"contacts_id", "conatct_number", "contact_raw_id", "contacts_name"}, null, null, "contacts_id");
        Iterator<CursorJoiner.Result> it = new CursorJoiner(cursorQuery, new String[]{"_id"}, cursorQuery2, new String[]{"contacts_id"}).iterator();
        while (it.hasNext()) {
            switch (C1670b.f6154a[it.next().ordinal()]) {
                case 1:
                    C3250y.m11456e("Added : " + cursorQuery.getString(1) + ", rawId=" + cursorQuery.getLong(2) + ", name=" + cursorQuery.getString(3), "ContactComparator");
                    interfaceC1671c.mo5576a(cursorQuery, cursorQuery2);
                    break;
                case 2:
                    C3250y.m11456e("Deleted : " + cursorQuery2.getString(1) + ", rawId=" + cursorQuery2.getLong(2) + ", name=" + cursorQuery2.getString(3), "ContactComparator");
                    interfaceC1671c.mo5577b(cursorQuery, cursorQuery2);
                    break;
                case 3:
                    String string = cursorQuery.getString(1);
                    String string2 = cursorQuery2.getString(1);
                    if (!string.equals(string2)) {
                        C3250y.m11456e("Number Modified,  " + string2 + " -> " + string, "ContactComparator");
                        interfaceC1671c.mo5578c(cursorQuery, cursorQuery2);
                    }
                    String string3 = cursorQuery.getString(3);
                    String string4 = cursorQuery2.getString(3);
                    cursorQuery2.getString(2);
                    if (!string3.equals(string4)) {
                        C3250y.m11456e("Name Modified,  " + cursorQuery2.getString(0) + " -> " + cursorQuery2.getString(1) + " -> " + cursorQuery2.getString(2) + " -> " + cursorQuery2.getString(3), "ContactComparator");
                        C3250y.m11456e("Name Modified,  " + cursorQuery.getString(0) + " -> " + cursorQuery.getString(1) + " -> " + cursorQuery.getString(2) + " -> " + cursorQuery.getString(3), "ContactComparator");
                        C3250y.m11456e("Name Modified,  " + string4 + " -> " + string3, "ContactComparator");
                        interfaceC1671c.mo5579d(cursorQuery, cursorQuery2);
                        break;
                    } else {
                        break;
                    }
            }
        }
        cursorQuery.close();
        cursorQuery2.close();
    }
}
