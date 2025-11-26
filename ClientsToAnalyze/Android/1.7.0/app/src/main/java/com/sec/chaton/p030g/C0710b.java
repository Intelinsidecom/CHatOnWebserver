package com.sec.chaton.p030g;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.CursorJoiner;
import android.provider.ContactsContract;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C0657j;
import com.sec.chaton.util.C1341p;
import java.util.Iterator;

/* compiled from: ContactComparator.java */
/* renamed from: com.sec.chaton.g.b */
/* loaded from: classes.dex */
public class C0710b {
    /* renamed from: a */
    public static void m3098a(InterfaceC0712d interfaceC0712d) {
        ContentResolver contentResolver = GlobalApplication.m3100a().getContentResolver();
        Cursor cursorQuery = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"_id", "data1", "raw_contact_id", "display_name"}, "account_type IS NULL OR account_type NOT LIKE '%.sim'", null, "_id");
        Cursor cursorQuery2 = contentResolver.query(C0657j.f2284a, new String[]{"contacts_id", "conatct_number", "contact_raw_id", "contacts_name"}, null, null, "contacts_id");
        Iterator<CursorJoiner.Result> it = new CursorJoiner(cursorQuery, new String[]{"_id"}, cursorQuery2, new String[]{"contacts_id"}).iterator();
        while (it.hasNext()) {
            switch (C0711c.f2406a[it.next().ordinal()]) {
                case 1:
                    C1341p.m4662e("Added : " + cursorQuery.getString(1) + ", rawId=" + cursorQuery.getLong(2) + ", name=" + cursorQuery.getString(3), "ContactComparator");
                    interfaceC0712d.mo674a(cursorQuery, cursorQuery2);
                    break;
                case 2:
                    C1341p.m4662e("Deleted : " + cursorQuery2.getString(1) + ", rawId=" + cursorQuery2.getLong(2) + ", name=" + cursorQuery2.getString(3), "ContactComparator");
                    interfaceC0712d.mo675b(cursorQuery, cursorQuery2);
                    break;
                case 3:
                    String string = cursorQuery.getString(1);
                    String string2 = cursorQuery2.getString(1);
                    if (!string.equals(string2)) {
                        C1341p.m4662e("Number Modified,  " + string2 + " -> " + string, "ContactComparator");
                        interfaceC0712d.mo676c(cursorQuery, cursorQuery2);
                    }
                    String string3 = cursorQuery.getString(3);
                    String string4 = cursorQuery2.getString(3);
                    if (!string3.equals(string4)) {
                        C1341p.m4662e("Name Modified,  " + string4 + " -> " + string3, "ContactComparator");
                        interfaceC0712d.mo677d(cursorQuery, cursorQuery2);
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
