package com.sec.chaton.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Binder;
import com.sec.chaton.api.access_token.C0440a;
import com.sec.chaton.p027e.C1404av;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.search.C2380b;
import com.sec.chaton.search.C2382d;
import com.sec.chaton.search.C2383e;
import com.sec.chaton.search.EnumC2385g;
import com.sec.chaton.util.C3250y;
import java.util.Arrays;

/* loaded from: classes.dex */
public class SuggestionsProvider extends ContentProvider {

    /* renamed from: a */
    public static final String f7833a = SuggestionsProvider.class.getSimpleName();

    /* renamed from: b */
    private static final UriMatcher f7834b = m8111a();

    /* renamed from: c */
    private C2380b f7835c;

    /* renamed from: a */
    private static UriMatcher m8111a() {
        UriMatcher uriMatcher = new UriMatcher(-1);
        uriMatcher.addURI("com.sec.chaton.provider.SuggestionsProvider", "search_suggest_query", 2);
        uriMatcher.addURI("com.sec.chaton.provider.SuggestionsProvider", "search_suggest_query/*", 2);
        uriMatcher.addURI("com.sec.chaton.provider.SuggestionsProvider", "search/search_suggest_regex_query", 3);
        uriMatcher.addURI("com.sec.chaton.provider.SuggestionsProvider", "search/search_suggest_regex_query/*", 3);
        uriMatcher.addURI("com.sec.chaton.provider.SuggestionsProvider", "search_suggest_shortcut", 4);
        uriMatcher.addURI("com.sec.chaton.provider.SuggestionsProvider", "search_suggest_shortcut/*", 4);
        return uriMatcher;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.f7835c = new C2380b();
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (C3250y.f11733a) {
            C3250y.m11456e("query(), uri =" + uri, f7833a);
            C3250y.m11456e("query(), projection =" + strArr, f7833a);
            C3250y.m11456e("query(), selection =" + str, f7833a);
            C3250y.m11456e("query(), selectionArgs =" + strArr2, f7833a);
        }
        if (!C0440a.m3070a(getContext(), Binder.getCallingUid())) {
            throw new SecurityException("Access Token is invalid.");
        }
        SQLiteDatabase readableDatabase = C1404av.m6253a(getContext()).getReadableDatabase();
        switch (f7834b.match(uri)) {
            case 2:
                if (strArr2 == null) {
                    throw new IllegalArgumentException("selectionArgs must be provided for the Uri: " + uri);
                }
                return null;
            case 3:
                if (uri.getPathSegments().size() <= 1) {
                    throw new IllegalArgumentException("selectionArgs must be provided for the Uri: " + uri);
                }
                return m8112a(readableDatabase, uri);
            default:
                return null;
        }
    }

    /* renamed from: a */
    private Cursor m8112a(SQLiteDatabase sQLiteDatabase, Uri uri) {
        this.f7835c.m8847a();
        C2382d c2382dM8867a = new C2383e(getContext(), uri).m8872a((String[]) null).m8870a((String) null).m8873b((String[]) null).m8871a(false).m8869a(EnumC2385g.BUDDY_TYPE).m8868a(new C2041d(this)).m8867a();
        if (c2382dM8867a.m8856f() == null && c2382dM8867a.m8857g() == null && c2382dM8867a.m8853c().length > 0) {
            this.f7835c.m8848a(c2382dM8867a);
        }
        this.f7835c.m8848a(new C2383e(getContext(), uri).m8872a((String[]) null).m8870a((String) null).m8873b((String[]) null).m8871a(false).m8869a(EnumC2385g.CHAT_TYPE).m8868a(new C2042e(this)).m8867a());
        return this.f7835c.m8845a(sQLiteDatabase);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007d A[Catch: all -> 0x00e3, TryCatch #0 {all -> 0x00e3, blocks: (B:4:0x0009, B:6:0x000f, B:8:0x0034, B:9:0x0046, B:12:0x0072, B:13:0x0077, B:15:0x007d, B:17:0x0081, B:18:0x008c, B:20:0x0090, B:21:0x009b, B:23:0x00a1, B:24:0x00ac, B:25:0x00cc, B:30:0x00d8, B:32:0x00dc), top: B:39:0x0009 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.database.MatrixCursor m8113a(android.database.Cursor r11, com.sec.chaton.search.C2382d r12) {
        /*
            r10 = this;
            android.database.MatrixCursor r5 = new android.database.MatrixCursor
            java.lang.String[] r0 = com.sec.chaton.search.C2380b.f8844d
            r5.<init>(r0)
            if (r11 == 0) goto Ld2
            boolean r0 = r11.moveToFirst()     // Catch: java.lang.Throwable -> Le3
            if (r0 == 0) goto Ld2
        Lf:
            java.lang.String r0 = "inbox_title"
            int r0 = r11.getColumnIndex(r0)     // Catch: java.lang.Throwable -> Le3
            java.lang.String r0 = r11.getString(r0)     // Catch: java.lang.Throwable -> Le3
            java.lang.String r1 = "message_content"
            int r1 = r11.getColumnIndex(r1)     // Catch: java.lang.Throwable -> Le3
            java.lang.String r6 = r11.getString(r1)     // Catch: java.lang.Throwable -> Le3
            java.lang.String r1 = "message_time"
            int r1 = r11.getColumnIndex(r1)     // Catch: java.lang.Throwable -> Le3
            long r2 = r11.getLong(r1)     // Catch: java.lang.Throwable -> Le3
            r1 = 0
            r7 = 0
            int r4 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r4 == 0) goto Lea
            android.content.Context r1 = com.sec.common.CommonApplication.m11493l()     // Catch: java.lang.Throwable -> Le3
            java.text.DateFormat r1 = android.text.format.DateFormat.getDateFormat(r1)     // Catch: java.lang.Throwable -> Le3
            java.util.Date r4 = new java.util.Date     // Catch: java.lang.Throwable -> Le3
            r4.<init>(r2)     // Catch: java.lang.Throwable -> Le3
            java.lang.String r1 = r1.format(r4)     // Catch: java.lang.Throwable -> Le3
            r4 = r1
        L46:
            java.lang.String r1 = "message_inbox_no"
            int r1 = r11.getColumnIndex(r1)     // Catch: java.lang.Throwable -> Le3
            java.lang.String r3 = r11.getString(r1)     // Catch: java.lang.Throwable -> Le3
            java.lang.String r1 = "inbox_chat_type"
            int r1 = r11.getColumnIndex(r1)     // Catch: java.lang.Throwable -> Le3
            int r1 = r11.getInt(r1)     // Catch: java.lang.Throwable -> Le3
            com.sec.chaton.e.r r7 = com.sec.chaton.p027e.EnumC1450r.m6339a(r1)     // Catch: java.lang.Throwable -> Le3
            java.lang.String r1 = "participants_buddy_no"
            int r1 = r11.getColumnIndex(r1)     // Catch: java.lang.Throwable -> Le3
            java.lang.String r2 = r11.getString(r1)     // Catch: java.lang.Throwable -> Le3
            r1 = 0
            java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> Le3
            com.sec.chaton.e.r r1 = com.sec.chaton.p027e.EnumC1450r.ONETOONE     // Catch: java.lang.Throwable -> Le3
            if (r7 != r1) goto Ld8
            if (r2 == 0) goto Lcc
            r1 = 0
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> Le3
        L77:
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> Le3
            if (r3 == 0) goto Lac
            com.sec.chaton.e.r r3 = com.sec.chaton.p027e.EnumC1450r.GROUPCHAT     // Catch: java.lang.Throwable -> Le3
            if (r7 != r3) goto L8c
            android.content.res.Resources r0 = com.sec.chaton.global.GlobalApplication.m6451b()     // Catch: java.lang.Throwable -> Le3
            r3 = 2131427667(0x7f0b0153, float:1.8476957E38)
            java.lang.String r0 = r0.getString(r3)     // Catch: java.lang.Throwable -> Le3
        L8c:
            com.sec.chaton.e.r r3 = com.sec.chaton.p027e.EnumC1450r.ONETOONE     // Catch: java.lang.Throwable -> Le3
            if (r7 != r3) goto L9b
            android.content.res.Resources r0 = com.sec.chaton.global.GlobalApplication.m6451b()     // Catch: java.lang.Throwable -> Le3
            r3 = 2131427506(0x7f0b00b2, float:1.847663E38)
            java.lang.String r0 = r0.getString(r3)     // Catch: java.lang.Throwable -> Le3
        L9b:
            boolean r3 = com.sec.chaton.p027e.EnumC1450r.m6340a(r7)     // Catch: java.lang.Throwable -> Le3
            if (r3 == 0) goto Lac
            android.content.res.Resources r0 = com.sec.chaton.global.GlobalApplication.m6451b()     // Catch: java.lang.Throwable -> Le3
            r3 = 2131427667(0x7f0b0153, float:1.8476957E38)
            java.lang.String r0 = r0.getString(r3)     // Catch: java.lang.Throwable -> Le3
        Lac:
            r3 = 2
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> Le3
            android.net.Uri r1 = com.sec.chaton.search.C2380b.m8842a(r2, r1)     // Catch: java.lang.Throwable -> Le3
            r8 = 3
            java.lang.String[] r8 = new java.lang.String[r8]     // Catch: java.lang.Throwable -> Le3
            r9 = 0
            r8[r9] = r0     // Catch: java.lang.Throwable -> Le3
            r0 = 1
            r8[r0] = r6     // Catch: java.lang.Throwable -> Le3
            r0 = 2
            r8[r0] = r4     // Catch: java.lang.Throwable -> Le3
            java.util.List r0 = java.util.Arrays.asList(r8)     // Catch: java.lang.Throwable -> Le3
            android.content.Intent r2 = com.sec.chaton.search.C2380b.m8839a(r2, r7)     // Catch: java.lang.Throwable -> Le3
            com.sec.chaton.search.C2380b.m8840a(r5, r3, r1, r0, r2)     // Catch: java.lang.Throwable -> Le3
        Lcc:
            boolean r0 = r11.moveToNext()     // Catch: java.lang.Throwable -> Le3
            if (r0 != 0) goto Lf
        Ld2:
            if (r11 == 0) goto Ld7
            r11.close()
        Ld7:
            return r5
        Ld8:
            com.sec.chaton.e.r r1 = com.sec.chaton.p027e.EnumC1450r.GROUPCHAT     // Catch: java.lang.Throwable -> Le3
            if (r7 != r1) goto Lcc
            r1 = 1
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> Le3
            r2 = r3
            goto L77
        Le3:
            r0 = move-exception
            if (r11 == 0) goto Le9
            r11.close()
        Le9:
            throw r0
        Lea:
            r4 = r1
            goto L46
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.SuggestionsProvider.m8113a(android.database.Cursor, com.sec.chaton.search.d):android.database.MatrixCursor");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public MatrixCursor m8115b(Cursor cursor, C2382d c2382d) {
        MatrixCursor matrixCursor = new MatrixCursor(C2380b.f8844d);
        if (cursor != null) {
            try {
                if (cursor.moveToFirst()) {
                    do {
                        String string = cursor.getString(cursor.getColumnIndex("buddy_no"));
                        C2380b.m8840a(matrixCursor, 0, C2380b.m8842a(string, false), Arrays.asList(cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("suggest_text_2")), null), C2380b.m8839a(string, EnumC1450r.ONETOONE));
                    } while (cursor.moveToNext());
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
