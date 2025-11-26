package com.sec.chaton.multimedia.vcard;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

/* loaded from: classes.dex */
public class ContactAccessorSdk5 extends ContactAccessor {
    @Override // com.sec.chaton.multimedia.vcard.ContactAccessor
    /* renamed from: a */
    public Intent mo2613a() {
        return new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
    }

    @Override // com.sec.chaton.multimedia.vcard.ContactAccessor
    /* renamed from: a */
    public ContactStruct mo2614a(ContentResolver contentResolver, Uri uri) {
        ContactStruct contactStruct = new ContactStruct();
        Cursor cursorQuery = contentResolver.query(uri, new String[]{"_id", "display_name"}, null, null, null);
        try {
            long j = cursorQuery.moveToFirst() ? cursorQuery.getLong(0) : -1L;
            cursorQuery.close();
            cursorQuery = contentResolver.query(ContactsContract.Data.CONTENT_URI, new String[]{"_id", "data2", "data3"}, "contact_id=? AND mimetype='vnd.android.cursor.item/name'", new String[]{String.valueOf(j)}, null);
            try {
                if (cursorQuery.moveToFirst()) {
                    for (int i = 0; cursorQuery.getCount() > i; i++) {
                        if (contactStruct.f2281a == null) {
                            contactStruct.f2281a = cursorQuery.getString(1);
                        }
                        if (contactStruct.f2282b == null) {
                            contactStruct.f2282b = cursorQuery.getString(2);
                        }
                        cursorQuery.moveToNext();
                    }
                }
                cursorQuery.close();
                cursorQuery = contentResolver.query(ContactsContract.Data.CONTENT_URI, new String[]{"_id", "data1"}, "contact_id=? AND mimetype='vnd.android.cursor.item/note'", new String[]{String.valueOf(j)}, null);
                try {
                    if (cursorQuery.moveToFirst()) {
                        contactStruct.f2284d = cursorQuery.getString(1);
                    }
                    cursorQuery.close();
                    cursorQuery = contentResolver.query(ContactsContract.Data.CONTENT_URI, new String[]{"_id", "data1", "data2", "data3"}, "contact_id=? AND mimetype='vnd.android.cursor.item/phone_v2'", new String[]{String.valueOf(j)}, null);
                    int count = cursorQuery.getCount();
                    try {
                        if (cursorQuery.moveToFirst()) {
                            for (int i2 = 0; count > i2; i2++) {
                                contactStruct.m2616a(cursorQuery.getString(2) == null ? 2 : Integer.parseInt(cursorQuery.getString(2)), cursorQuery.getString(1), cursorQuery.getString(3), true);
                                cursorQuery.moveToNext();
                            }
                        }
                        cursorQuery.close();
                        cursorQuery = contentResolver.query(ContactsContract.Data.CONTENT_URI, new String[]{"_id", "data1", "data2", "data3"}, "contact_id=? AND mimetype='vnd.android.cursor.item/email_v2'", new String[]{String.valueOf(j)}, null);
                        int count2 = cursorQuery.getCount();
                        try {
                            if (cursorQuery.moveToFirst()) {
                                for (int i3 = 0; count2 > i3; i3++) {
                                    contactStruct.m2617b(Integer.parseInt(cursorQuery.getString(2)), cursorQuery.getString(1), cursorQuery.getString(3), true);
                                    cursorQuery.moveToNext();
                                }
                            }
                            return contactStruct;
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
