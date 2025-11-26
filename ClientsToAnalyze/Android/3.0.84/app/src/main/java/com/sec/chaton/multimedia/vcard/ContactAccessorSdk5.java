package com.sec.chaton.multimedia.vcard;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;

/* loaded from: classes.dex */
public class ContactAccessorSdk5 extends AbstractC1927a {
    @Override // com.sec.chaton.multimedia.vcard.AbstractC1927a
    /* renamed from: a */
    public Intent mo7831a() {
        return new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
    }

    @Override // com.sec.chaton.multimedia.vcard.AbstractC1927a
    /* renamed from: a */
    public C1928b mo7832a(ContentResolver contentResolver, Uri uri) {
        C1928b c1928b = new C1928b();
        long j = -1;
        Cursor cursorQuery = contentResolver.query(uri, new String[]{"_id", SlookAirButtonFrequentContactAdapter.DISPLAY_NAME}, null, null, null);
        try {
            if (cursorQuery.moveToFirst()) {
                j = cursorQuery.getLong(0);
            }
            cursorQuery.close();
            cursorQuery = contentResolver.query(ContactsContract.Data.CONTENT_URI, new String[]{"_id", "data1"}, "contact_id=? AND mimetype='vnd.android.cursor.item/name'", new String[]{String.valueOf(j)}, null);
            try {
                if (cursorQuery.moveToFirst()) {
                    for (int i = 0; cursorQuery.getCount() > i; i++) {
                        if (c1928b.f7392b == null) {
                            c1928b.f7392b = cursorQuery.getString(1);
                        }
                        cursorQuery.moveToNext();
                    }
                }
                cursorQuery.close();
                cursorQuery = contentResolver.query(ContactsContract.Data.CONTENT_URI, new String[]{"_id", "data1"}, "contact_id=? AND mimetype='vnd.android.cursor.item/note'", new String[]{String.valueOf(j)}, null);
                try {
                    if (cursorQuery.moveToFirst()) {
                        c1928b.f7394d = cursorQuery.getString(1);
                    }
                    cursorQuery.close();
                    cursorQuery = contentResolver.query(ContactsContract.Data.CONTENT_URI, new String[]{"_id", "data1", "data2", "data3"}, "contact_id=? AND mimetype='vnd.android.cursor.item/phone_v2'", new String[]{String.valueOf(j)}, null);
                    int count = cursorQuery.getCount();
                    try {
                        if (cursorQuery.moveToFirst()) {
                            for (int i2 = 0; count > i2; i2++) {
                                c1928b.m7864a(cursorQuery.getString(2) == null ? 2 : Integer.parseInt(cursorQuery.getString(2)), cursorQuery.getString(1), cursorQuery.getString(3), true);
                                cursorQuery.moveToNext();
                            }
                        }
                        cursorQuery.close();
                        cursorQuery = contentResolver.query(ContactsContract.Data.CONTENT_URI, new String[]{"_id", "data1", "data2", "data3"}, "contact_id=? AND mimetype='vnd.android.cursor.item/email_v2'", new String[]{String.valueOf(j)}, null);
                        int count2 = cursorQuery.getCount();
                        try {
                            if (cursorQuery.moveToFirst()) {
                                for (int i3 = 0; count2 > i3; i3++) {
                                    c1928b.m7865b(TextUtils.isEmpty(cursorQuery.getString(2)) ? 4 : Integer.parseInt(cursorQuery.getString(2)), cursorQuery.getString(1), cursorQuery.getString(3), true);
                                    cursorQuery.moveToNext();
                                }
                            }
                            return c1928b;
                        } finally {
                        }
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }
}
