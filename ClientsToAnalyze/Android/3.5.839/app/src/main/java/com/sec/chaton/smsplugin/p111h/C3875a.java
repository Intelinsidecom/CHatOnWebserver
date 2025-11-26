package com.sec.chaton.smsplugin.p111h;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SqliteWrapper;
import android.net.Uri;
import android.provider.Telephony;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.google.android.p134a.p135a.C5082e;
import com.sec.google.android.p134a.p135a.C5097t;

/* compiled from: AddressUtils.java */
@SuppressLint({"NewApi"})
/* renamed from: com.sec.chaton.smsplugin.h.a */
/* loaded from: classes.dex */
public class C3875a {
    /* renamed from: a */
    public static String m14950a(Context context, Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        Uri.Builder builderBuildUpon = Telephony.Mms.CONTENT_URI.buildUpon();
        builderBuildUpon.appendPath(lastPathSegment).appendPath("addr");
        Cursor cursorQuery = SqliteWrapper.query(context, context.getContentResolver(), builderBuildUpon.build(), new String[]{"address", "charset"}, "type=137", (String[]) null, (String) null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    String string = cursorQuery.getString(0);
                    if (!TextUtils.isEmpty(string)) {
                        return new C5082e(cursorQuery.getInt(1), C5097t.m19436a(string)).m19308c();
                    }
                }
            } finally {
                cursorQuery.close();
            }
        }
        return context.getString(R.string.hidden_sender_address);
    }
}
