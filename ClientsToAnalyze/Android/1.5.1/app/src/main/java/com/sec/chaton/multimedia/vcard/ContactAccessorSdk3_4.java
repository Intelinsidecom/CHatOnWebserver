package com.sec.chaton.multimedia.vcard;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Contacts;

/* loaded from: classes.dex */
public class ContactAccessorSdk3_4 extends ContactAccessor {
    @Override // com.sec.chaton.multimedia.vcard.ContactAccessor
    /* renamed from: a */
    public Intent mo2613a() {
        return new Intent("android.intent.action.PICK", Contacts.People.CONTENT_URI);
    }

    @Override // com.sec.chaton.multimedia.vcard.ContactAccessor
    /* renamed from: a */
    public ContactStruct mo2614a(ContentResolver contentResolver, Uri uri) {
        ContactStruct contactStruct = new ContactStruct();
        Cursor cursorQuery = contentResolver.query(uri, new String[]{"display_name"}, null, null, null);
        try {
            if (cursorQuery.moveToFirst()) {
                contactStruct.f2281a = cursorQuery.getString(1);
            }
            return contactStruct;
        } finally {
            cursorQuery.close();
        }
    }
}
