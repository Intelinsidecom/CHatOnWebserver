package com.sec.chaton.multimedia.vcard;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class ContactAccessorSdk5 extends AbstractC0840q {
    @Override // com.sec.chaton.multimedia.vcard.AbstractC0840q
    /* renamed from: a */
    public Intent mo3355a() {
        return new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
    }

    @Override // com.sec.chaton.multimedia.vcard.AbstractC0840q
    /* renamed from: a */
    public C0833j mo3356a(ContentResolver contentResolver, Uri uri) {
        C0833j c0833j = new C0833j();
        long j = -1;
        Cursor cursorQuery = contentResolver.query(uri, new String[]{"_id", "display_name"}, null, null, null);
        try {
            if (cursorQuery.moveToFirst()) {
                j = cursorQuery.getLong(0);
            }
            cursorQuery.close();
            cursorQuery = contentResolver.query(ContactsContract.Data.CONTENT_URI, new String[]{"_id", "data1"}, "contact_id=? AND mimetype='vnd.android.cursor.item/name'", new String[]{String.valueOf(j)}, null);
            try {
                if (cursorQuery.moveToFirst()) {
                    for (int i = 0; cursorQuery.getCount() > i; i++) {
                        if (c0833j.f2896b == null) {
                            c0833j.f2896b = cursorQuery.getString(1);
                        }
                        cursorQuery.moveToNext();
                    }
                }
                cursorQuery.close();
                cursorQuery = contentResolver.query(ContactsContract.Data.CONTENT_URI, new String[]{"_id", "data1"}, "contact_id=? AND mimetype='vnd.android.cursor.item/note'", new String[]{String.valueOf(j)}, null);
                try {
                    if (cursorQuery.moveToFirst()) {
                        c0833j.f2898d = cursorQuery.getString(1);
                    }
                    cursorQuery.close();
                    cursorQuery = contentResolver.query(ContactsContract.Data.CONTENT_URI, new String[]{"_id", "data1", "data2", "data3"}, "contact_id=? AND mimetype='vnd.android.cursor.item/phone_v2'", new String[]{String.valueOf(j)}, null);
                    int count = cursorQuery.getCount();
                    try {
                        if (cursorQuery.moveToFirst()) {
                            for (int i2 = 0; count > i2; i2++) {
                                c0833j.m3406a(cursorQuery.getString(2) == null ? 2 : Integer.parseInt(cursorQuery.getString(2)), cursorQuery.getString(1), cursorQuery.getString(3), true);
                                cursorQuery.moveToNext();
                            }
                        }
                        cursorQuery.close();
                        cursorQuery = contentResolver.query(ContactsContract.Data.CONTENT_URI, new String[]{"_id", "data1", "data2", "data3"}, "contact_id=? AND mimetype='vnd.android.cursor.item/email_v2'", new String[]{String.valueOf(j)}, null);
                        int count2 = cursorQuery.getCount();
                        try {
                            if (cursorQuery.moveToFirst()) {
                                for (int i3 = 0; count2 > i3; i3++) {
                                    c0833j.m3407b(TextUtils.isEmpty(cursorQuery.getString(2)) ? 4 : Integer.parseInt(cursorQuery.getString(2)), cursorQuery.getString(1), cursorQuery.getString(3), true);
                                    cursorQuery.moveToNext();
                                }
                            }
                            return c0833j;
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
