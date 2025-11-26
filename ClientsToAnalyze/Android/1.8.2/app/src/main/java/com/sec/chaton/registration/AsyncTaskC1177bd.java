package com.sec.chaton.registration;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.sec.chaton.util.C1789u;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.bd */
/* loaded from: classes.dex */
class AsyncTaskC1177bd extends AsyncTask {
    private AsyncTaskC1177bd() {
    }

    /* synthetic */ AsyncTaskC1177bd(RunnableC1168av runnableC1168av) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Context... contextArr) {
        boolean z;
        ContentResolver contentResolver = contextArr[0].getContentResolver();
        String string = C1789u.m6075a().getString("msisdn", "");
        if (!TextUtils.isEmpty(string)) {
            Cursor cursorQuery = contentResolver.query(ContactsContract.Settings.CONTENT_URI.buildUpon().appendQueryParameter("account_name", string).appendQueryParameter("account_type", "com.sec.chaton").build(), new String[]{"should_sync", "ungrouped_visible"}, null, null, null);
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("account_name", string);
                contentValues.put("account_type", "com.sec.chaton");
                if (cursorQuery != null && cursorQuery.moveToFirst()) {
                    contentValues.put("should_sync", Integer.valueOf(cursorQuery.getInt(0)));
                    z = true;
                } else {
                    contentValues.put("should_sync", (Integer) 1);
                    z = false;
                }
                contentValues.put("ungrouped_visible", (Integer) 1);
                if (z) {
                    contentResolver.update(ContactsContract.Settings.CONTENT_URI, contentValues, "account_type =?  AND account_name =?", new String[]{contentValues.getAsString("account_type"), contentValues.getAsString("account_name")});
                } else {
                    contentResolver.insert(ContactsContract.Settings.CONTENT_URI, contentValues);
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        return null;
    }
}
