package com.sec.chaton.sync;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.CursorJoiner;
import android.provider.ContactsContract;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.ChatONLogWriter;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ContactComparator {

    public interface ContactChangeAction {
        /* renamed from: a */
        void mo2160a(Cursor cursor, Cursor cursor2);

        /* renamed from: b */
        void mo2161b(Cursor cursor, Cursor cursor2);

        /* renamed from: c */
        void mo2162c(Cursor cursor, Cursor cursor2);

        /* renamed from: d */
        void mo2163d(Cursor cursor, Cursor cursor2);
    }

    /* renamed from: a */
    public static int m3293a() {
        Cursor cursorQuery = GlobalApplication.m2387e().getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI, new String[]{"_id", "version"}, "account_type != 'com.sec.chaton'", null, null);
        int i = 0;
        while (cursorQuery.moveToNext()) {
            i += cursorQuery.getInt(1);
        }
        cursorQuery.close();
        return i;
    }

    /* renamed from: a */
    public static void m3294a(ContactChangeAction contactChangeAction) {
        ContentResolver contentResolver = GlobalApplication.m2387e().getContentResolver();
        Cursor cursorQuery = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"_id", "data1", "raw_contact_id", "display_name"}, "account_name IS NULL OR account_name NOT LIKE '%.sim'", null, "_id");
        Cursor cursorQuery2 = contentResolver.query(ChatONContract.ContactsTable.f1714a, new String[]{"contacts_id", "conatct_number", "contact_raw_id", "contacts_name"}, null, null, "contacts_id");
        Iterator<CursorJoiner.Result> it = new CursorJoiner(cursorQuery, new String[]{"_id"}, cursorQuery2, new String[]{"contacts_id"}).iterator();
        while (it.hasNext()) {
            switch (C0526a.f3312a[it.next().ordinal()]) {
                case 1:
                    ChatONLogWriter.m3511e("Added : " + cursorQuery.getString(1), "ContactComparator");
                    contactChangeAction.mo2160a(cursorQuery, cursorQuery2);
                    break;
                case 2:
                    ChatONLogWriter.m3511e("Deleted : " + cursorQuery2.getString(1), "ContactComparator");
                    contactChangeAction.mo2161b(cursorQuery, cursorQuery2);
                    break;
                case 3:
                    String string = cursorQuery.getString(1);
                    String string2 = cursorQuery2.getString(1);
                    if (!string.equals(string2)) {
                        ChatONLogWriter.m3511e("Number Modified,  " + string2 + " -> " + string, "ContactComparator");
                        contactChangeAction.mo2162c(cursorQuery, cursorQuery2);
                    }
                    String string3 = cursorQuery.getString(3);
                    String string4 = cursorQuery2.getString(3);
                    if (!string3.equals(string4)) {
                        ChatONLogWriter.m3511e("Name Modified,  " + string4 + " -> " + string3, "ContactComparator");
                        contactChangeAction.mo2163d(cursorQuery, cursorQuery2);
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
