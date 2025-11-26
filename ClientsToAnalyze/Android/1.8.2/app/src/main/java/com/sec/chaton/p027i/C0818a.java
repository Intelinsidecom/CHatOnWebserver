package com.sec.chaton.p027i;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.CursorJoiner;
import android.provider.ContactsContract;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p017e.C0689d;
import com.sec.chaton.util.C1786r;
import java.util.Iterator;

/* compiled from: ContactComparator.java */
/* renamed from: com.sec.chaton.i.a */
/* loaded from: classes.dex */
public class C0818a {
    /* renamed from: a */
    public static void m3461a(InterfaceC0820c interfaceC0820c) {
        ContentResolver contentResolver = GlobalApplication.m3260b().getContentResolver();
        Cursor cursorQuery = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"_id", "data1", "raw_contact_id", "display_name"}, "account_type IS NULL OR account_type NOT LIKE '%.sim'", null, "_id");
        Cursor cursorQuery2 = contentResolver.query(C0689d.f2607a, new String[]{"contacts_id", "conatct_number", "contact_raw_id", "contacts_name"}, null, null, "contacts_id");
        Iterator<CursorJoiner.Result> it = new CursorJoiner(cursorQuery, new String[]{"_id"}, cursorQuery2, new String[]{"contacts_id"}).iterator();
        while (it.hasNext()) {
            switch (C0819b.f3009a[it.next().ordinal()]) {
                case 1:
                    C1786r.m6066e("Added : " + cursorQuery.getString(1) + ", rawId=" + cursorQuery.getLong(2) + ", name=" + cursorQuery.getString(3), "ContactComparator");
                    interfaceC0820c.mo2776a(cursorQuery, cursorQuery2);
                    break;
                case 2:
                    C1786r.m6066e("Deleted : " + cursorQuery2.getString(1) + ", rawId=" + cursorQuery2.getLong(2) + ", name=" + cursorQuery2.getString(3), "ContactComparator");
                    interfaceC0820c.mo2777b(cursorQuery, cursorQuery2);
                    break;
                case 3:
                    String string = cursorQuery.getString(1);
                    String string2 = cursorQuery2.getString(1);
                    if (!string.equals(string2)) {
                        C1786r.m6066e("Number Modified,  " + string2 + " -> " + string, "ContactComparator");
                        interfaceC0820c.mo2778c(cursorQuery, cursorQuery2);
                    }
                    String string3 = cursorQuery.getString(3);
                    String string4 = cursorQuery2.getString(3);
                    if (!string3.equals(string4)) {
                        C1786r.m6066e("Name Modified,  " + string4 + " -> " + string3, "ContactComparator");
                        interfaceC0820c.mo2779d(cursorQuery, cursorQuery2);
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
