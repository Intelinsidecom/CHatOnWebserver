package com.sec.chaton.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class ChatON2ndAppProvider extends ContentProvider {

    /* renamed from: a */
    private static final String f11230a = ChatON2ndAppProvider.class.getSimpleName();

    /* renamed from: b */
    private UriMatcher f11231b;

    /* renamed from: a */
    private void m12393a() {
        this.f11231b = new UriMatcher(-1);
        this.f11231b.addURI("com.sec.chaton.provider.chaton2ndApp", "user_registration_infomation", 0);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        m12393a();
        return true;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        switch (this.f11231b.match(uri)) {
            case 0:
                return "vnd.chaton.cursor.dir/vnd.chaton.user.registration";
            default:
                return null;
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (C4904y.f17872b) {
            C4904y.m18639b("ChatON2ndAppProvider.query()", f11230a);
        }
        if (this.f11231b.match(uri) != 0) {
            return null;
        }
        String[] strArr3 = {"uid", "imei", "chaton_number"};
        String strM18121a = C4809aa.m18104a().m18121a("uid", "");
        String strM18121a2 = C4809aa.m18104a().m18121a("imei", "");
        String strM18121a3 = C4809aa.m18104a().m18121a("chaton_id", "");
        if (C4904y.f17872b) {
            C4904y.m18639b("UID: " + strM18121a + ", IMEI: " + strM18121a2 + ", ChatON Number: " + strM18121a3, f11230a);
        }
        MatrixCursor matrixCursor = new MatrixCursor(strArr3);
        if (!TextUtils.isEmpty(strM18121a)) {
            matrixCursor.addRow(new String[]{strM18121a, strM18121a2, strM18121a3});
            return matrixCursor;
        }
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
