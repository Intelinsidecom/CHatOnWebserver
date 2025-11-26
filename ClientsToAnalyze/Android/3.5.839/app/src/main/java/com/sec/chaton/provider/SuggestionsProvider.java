package com.sec.chaton.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Binder;
import android.text.TextUtils;
import android.text.format.DateFormat;
import com.sec.chaton.R;
import com.sec.chaton.api.access_token.C1041a;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.C2268bn;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p065io.entry.ApplinkMsgEntry;
import com.sec.chaton.search.C3408b;
import com.sec.chaton.search.C3410d;
import com.sec.chaton.search.C3411e;
import com.sec.chaton.search.EnumC3413g;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5034k;
import com.sec.spp.push.Config;
import java.util.Arrays;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SuggestionsProvider extends ContentProvider {

    /* renamed from: a */
    public static final String f11240a = SuggestionsProvider.class.getSimpleName();

    /* renamed from: b */
    private static final UriMatcher f11241b = m12448a();

    /* renamed from: c */
    private C3408b f11242c;

    /* renamed from: a */
    private static UriMatcher m12448a() {
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
        this.f11242c = new C3408b();
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (C4904y.f17871a) {
            C4904y.m18646e("query(), uri =" + uri, f11240a);
            C4904y.m18646e("query(), projection =" + strArr, f11240a);
            C4904y.m18646e("query(), selection =" + str, f11240a);
            C4904y.m18646e("query(), selectionArgs =" + strArr2, f11240a);
        }
        if (!C1041a.m6138a(getContext(), Binder.getCallingUid())) {
            throw new SecurityException("Access Token is invalid.");
        }
        SQLiteDatabase readableDatabase = C2268bn.m10126a(getContext()).getReadableDatabase();
        switch (f11241b.match(uri)) {
            case 2:
                if (strArr2 == null) {
                    throw new IllegalArgumentException("selectionArgs must be provided for the Uri: " + uri);
                }
                return null;
            case 3:
                if (uri.getPathSegments().size() <= 1) {
                    throw new IllegalArgumentException("selectionArgs must be provided for the Uri: " + uri);
                }
                return m12449a(readableDatabase, uri);
            default:
                return null;
        }
    }

    /* renamed from: a */
    private Cursor m12449a(SQLiteDatabase sQLiteDatabase, Uri uri) {
        this.f11242c.m13230a();
        C3410d c3410dM13251a = new C3411e(getContext(), uri).m13256a((String[]) null).m13254a((String) null).m13257b((String[]) null).m13255a(false).m13253a(EnumC3413g.BUDDY_TYPE).m13252a(new C3040e(this)).m13251a();
        if (c3410dM13251a.m13240f() == null && c3410dM13251a.m13241g() == null && c3410dM13251a.m13237c().length > 0) {
            this.f11242c.m13231a(c3410dM13251a);
        }
        this.f11242c.m13231a(new C3411e(getContext(), uri).m13256a((String[]) null).m13254a((String) null).m13257b((String[]) null).m13255a(false).m13253a(EnumC3413g.CHAT_TYPE).m13252a(new C3041f(this)).m13251a());
        this.f11242c.m13231a(new C3411e(getContext(), uri).m13256a((String[]) null).m13254a((String) null).m13257b((String[]) null).m13255a(false).m13253a(EnumC3413g.CHAT_TITLE_TYPE).m13252a(new C3042g(this)).m13251a());
        return this.f11242c.m13228a(sQLiteDatabase);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0085 A[Catch: all -> 0x0117, TryCatch #0 {all -> 0x0117, blocks: (B:4:0x000b, B:6:0x0011, B:8:0x0039, B:9:0x003e, B:12:0x0078, B:13:0x007f, B:15:0x0085, B:17:0x0089, B:20:0x0098, B:22:0x009c, B:23:0x00a7, B:25:0x00ad, B:26:0x00b8, B:28:0x00bc, B:29:0x00c8, B:32:0x00dd, B:19:0x008d, B:33:0x00fd, B:38:0x0109, B:40:0x010d), top: B:49:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x011e A[PHI: r0
  0x011e: PHI (r0v7 java.lang.String) = (r0v5 java.lang.String), (r0v19 java.lang.String) binds: [B:14:0x0083, B:27:0x00ba] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.database.MatrixCursor m12450a(android.database.Cursor r14, com.sec.chaton.search.C3410d r15) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.SuggestionsProvider.m12450a(android.database.Cursor, com.sec.chaton.search.d):android.database.MatrixCursor");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0090 A[Catch: all -> 0x0109, TryCatch #0 {all -> 0x0109, blocks: (B:4:0x0009, B:6:0x000f, B:8:0x0060, B:9:0x0065, B:12:0x0085, B:13:0x008a, B:15:0x0090, B:17:0x0094, B:18:0x009f, B:20:0x00a3, B:21:0x00ae, B:23:0x00b4, B:24:0x00bf, B:26:0x00c3, B:27:0x00ce, B:28:0x00ee, B:33:0x00fa, B:35:0x00fe, B:37:0x0102), top: B:44:0x0009 }] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.database.MatrixCursor m12454b(android.database.Cursor r11, com.sec.chaton.search.C3410d r12) {
        /*
            r10 = this;
            android.database.MatrixCursor r5 = new android.database.MatrixCursor
            java.lang.String[] r0 = com.sec.chaton.search.C3408b.f12373d
            r5.<init>(r0)
            if (r11 == 0) goto Lf4
            boolean r0 = r11.moveToFirst()     // Catch: java.lang.Throwable -> L109
            if (r0 == 0) goto Lf4
        Lf:
            java.lang.String r0 = "inbox_title"
            int r0 = r11.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L109
            java.lang.String r0 = r11.getString(r0)     // Catch: java.lang.Throwable -> L109
            java.lang.String r1 = "inbox_last_message"
            int r1 = r11.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L109
            java.lang.String r1 = r11.getString(r1)     // Catch: java.lang.Throwable -> L109
            java.lang.String r2 = "inbox_room_type"
            int r2 = r11.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L109
            int r2 = r11.getInt(r2)     // Catch: java.lang.Throwable -> L109
            java.lang.String r3 = "inbox_last_msg_sender"
            int r3 = r11.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L109
            java.lang.String r3 = r11.getString(r3)     // Catch: java.lang.Throwable -> L109
            java.lang.String r4 = "inbox_chat_type"
            int r4 = r11.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L109
            int r4 = r11.getInt(r4)     // Catch: java.lang.Throwable -> L109
            com.sec.chaton.e.t r6 = com.sec.chaton.p057e.EnumC2300t.m10207a(r4)     // Catch: java.lang.Throwable -> L109
            java.lang.String r7 = r10.m12452a(r2, r1, r3, r6)     // Catch: java.lang.Throwable -> L109
            java.lang.String r1 = "inbox_last_time"
            int r1 = r11.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L109
            long r2 = r11.getLong(r1)     // Catch: java.lang.Throwable -> L109
            r1 = 0
            r8 = 0
            int r4 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r4 == 0) goto L110
            java.lang.String r1 = r10.m12453a(r2)     // Catch: java.lang.Throwable -> L109
            r4 = r1
        L65:
            java.lang.String r1 = "inbox_no"
            int r1 = r11.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L109
            java.lang.String r3 = r11.getString(r1)     // Catch: java.lang.Throwable -> L109
            java.lang.String r1 = "participants_buddy_no"
            int r1 = r11.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L109
            java.lang.String r2 = r11.getString(r1)     // Catch: java.lang.Throwable -> L109
            r1 = 0
            java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> L109
            com.sec.chaton.e.t r1 = com.sec.chaton.p057e.EnumC2300t.ONETOONE     // Catch: java.lang.Throwable -> L109
            if (r6 != r1) goto Lfa
            if (r2 == 0) goto Lee
            r1 = 0
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> L109
        L8a:
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L109
            if (r3 == 0) goto Lce
            com.sec.chaton.e.t r3 = com.sec.chaton.p057e.EnumC2300t.GROUPCHAT     // Catch: java.lang.Throwable -> L109
            if (r6 != r3) goto L9f
            android.content.res.Resources r0 = com.sec.chaton.global.GlobalApplication.m10283b()     // Catch: java.lang.Throwable -> L109
            r3 = 2131428933(0x7f0b0645, float:1.8479524E38)
            java.lang.String r0 = r0.getString(r3)     // Catch: java.lang.Throwable -> L109
        L9f:
            com.sec.chaton.e.t r3 = com.sec.chaton.p057e.EnumC2300t.ONETOONE     // Catch: java.lang.Throwable -> L109
            if (r6 != r3) goto Lae
            android.content.res.Resources r0 = com.sec.chaton.global.GlobalApplication.m10283b()     // Catch: java.lang.Throwable -> L109
            r3 = 2131427682(0x7f0b0162, float:1.8476987E38)
            java.lang.String r0 = r0.getString(r3)     // Catch: java.lang.Throwable -> L109
        Lae:
            boolean r3 = com.sec.chaton.p057e.EnumC2300t.m10208a(r6)     // Catch: java.lang.Throwable -> L109
            if (r3 == 0) goto Lbf
            android.content.res.Resources r0 = com.sec.chaton.global.GlobalApplication.m10283b()     // Catch: java.lang.Throwable -> L109
            r3 = 2131428933(0x7f0b0645, float:1.8479524E38)
            java.lang.String r0 = r0.getString(r3)     // Catch: java.lang.Throwable -> L109
        Lbf:
            com.sec.chaton.e.t r3 = com.sec.chaton.p057e.EnumC2300t.MONOLOGUE     // Catch: java.lang.Throwable -> L109
            if (r6 != r3) goto Lce
            android.content.res.Resources r0 = com.sec.chaton.global.GlobalApplication.m10283b()     // Catch: java.lang.Throwable -> L109
            r3 = 2131428296(0x7f0b03c8, float:1.8478232E38)
            java.lang.String r0 = r0.getString(r3)     // Catch: java.lang.Throwable -> L109
        Lce:
            r3 = 4
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L109
            android.net.Uri r1 = com.sec.chaton.search.C3408b.m13224a(r2, r1)     // Catch: java.lang.Throwable -> L109
            r8 = 3
            java.lang.String[] r8 = new java.lang.String[r8]     // Catch: java.lang.Throwable -> L109
            r9 = 0
            r8[r9] = r0     // Catch: java.lang.Throwable -> L109
            r0 = 1
            r8[r0] = r7     // Catch: java.lang.Throwable -> L109
            r0 = 2
            r8[r0] = r4     // Catch: java.lang.Throwable -> L109
            java.util.List r0 = java.util.Arrays.asList(r8)     // Catch: java.lang.Throwable -> L109
            android.content.Intent r2 = com.sec.chaton.search.C3408b.m13220a(r2, r6)     // Catch: java.lang.Throwable -> L109
            com.sec.chaton.search.C3408b.m13222a(r5, r3, r1, r0, r2)     // Catch: java.lang.Throwable -> L109
        Lee:
            boolean r0 = r11.moveToNext()     // Catch: java.lang.Throwable -> L109
            if (r0 != 0) goto Lf
        Lf4:
            if (r11 == 0) goto Lf9
            r11.close()
        Lf9:
            return r5
        Lfa:
            com.sec.chaton.e.t r1 = com.sec.chaton.p057e.EnumC2300t.GROUPCHAT     // Catch: java.lang.Throwable -> L109
            if (r6 == r1) goto L102
            com.sec.chaton.e.t r1 = com.sec.chaton.p057e.EnumC2300t.TOPIC     // Catch: java.lang.Throwable -> L109
            if (r6 != r1) goto Lee
        L102:
            r1 = 1
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> L109
            r2 = r3
            goto L8a
        L109:
            r0 = move-exception
            if (r11 == 0) goto L10f
            r11.close()
        L10f:
            throw r0
        L110:
            r4 = r1
            goto L65
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.SuggestionsProvider.m12454b(android.database.Cursor, com.sec.chaton.search.d):android.database.MatrixCursor");
    }

    /* renamed from: a */
    private String m12453a(long j) {
        return C5034k.m19093a(j, System.currentTimeMillis()) ? DateFormat.getTimeFormat(getContext()).format(new Date(j)) : DateFormat.getDateFormat(getContext()).format(new Date(j));
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:99:0x025d -> B:108:0x00b0). Please report as a decompilation issue!!! */
    /* renamed from: a */
    private String m12452a(int i, String str, String str2, EnumC2300t enumC2300t) throws Resources.NotFoundException, NumberFormatException {
        String[] strArr;
        String strM8646b;
        String strM8646b2;
        String strM8646b3;
        String strM8646b4;
        String strM8646b5;
        String strM8646b6;
        if (str != null) {
            String[] strArrSplit = str.split(Config.KEYVALUE_SPLIT);
            String str3 = null;
            if (strArrSplit.length > 2) {
                str3 = strArrSplit[2];
            }
            if (EnumC2301u.m10211a(i) == EnumC2301u.SMS && strArrSplit.length == 2) {
                String string = getContext().getResources().getString(R.string.no_subject_view);
                if (!string.contains("(")) {
                    string = "(" + string + ")";
                }
                strArr = new String[]{strArrSplit[0], strArrSplit[1], string};
            } else {
                strArr = strArrSplit;
            }
            if (strArr.length >= 2) {
                int i2 = Integer.parseInt(strArr[0]);
                EnumC2214ab enumC2214abM10070a = EnumC2214ab.m10070a(Integer.parseInt(strArr[1]));
                if ((i2 == 1 || i2 == 2) && enumC2214abM10070a != EnumC2214ab.SYSTEM) {
                    if (C4809aa.m18104a().m18121a("chaton_id", "").equals(str2)) {
                        return EnumC2214ab.m10075a(enumC2214abM10070a, strArr, !TextUtils.isEmpty(str3) ? "mixed".equals(str3.split("\n")[0]) : false);
                    }
                    if (enumC2300t == EnumC2300t.GROUPCHAT || enumC2300t == EnumC2300t.TOPIC) {
                        if (strArr.length < 4) {
                            strM8646b = GlobalApplication.m10283b().getString(R.string.unknown);
                        } else {
                            strM8646b = C1736gi.m8646b(strArr[3]);
                        }
                        if (enumC2214abM10070a == EnumC2214ab.TEXT) {
                            if (strArr.length < 3) {
                                strM8646b4 = "";
                            } else {
                                strM8646b4 = C1736gi.m8646b(strArr[2]);
                                if (C1736gi.m8652d(strM8646b4)) {
                                    strM8646b4 = new StringBuilder(strM8646b4).substring(1);
                                }
                            }
                            return strM8646b + ": " + strM8646b4;
                        }
                        if (enumC2214abM10070a == EnumC2214ab.APPLINK) {
                            if (strArr.length < 3) {
                                strM8646b3 = "";
                            } else {
                                strM8646b3 = C1736gi.m8646b(strArr[2]);
                            }
                            return strM8646b + ": " + ApplinkMsgEntry.getDisplayMessage(strM8646b3);
                        }
                        if (enumC2214abM10070a == EnumC2214ab.POLL) {
                            String string2 = "";
                            if (strArr.length < 3) {
                                strM8646b2 = "";
                            } else {
                                strM8646b2 = C1736gi.m8646b(strArr[2]);
                            }
                            try {
                                if (new JSONObject(strM8646b2).getJSONObject("push_message").getString("content_type").equals("result")) {
                                    string2 = CommonApplication.m18732r().getString(R.string.poll_result_now_available);
                                } else {
                                    string2 = CommonApplication.m18732r().getString(R.string.poll_title);
                                }
                            } catch (JSONException e) {
                                C4904y.m18635a(e, getClass().getSimpleName());
                            }
                            return strM8646b + ":" + string2;
                        }
                        return strM8646b + ": " + EnumC2214ab.m10074a(enumC2214abM10070a, str3, TextUtils.isEmpty(str3) ? false : "mixed".equals(str3.split("\n")[0]));
                    }
                    if (enumC2214abM10070a == EnumC2214ab.TEXT) {
                        if (strArr.length < 3) {
                            return "";
                        }
                        String strM8646b7 = C1736gi.m8646b(strArr[2]);
                        if (C1736gi.m8652d(strM8646b7)) {
                            return new StringBuilder(strM8646b7).substring(1);
                        }
                        return strM8646b7;
                    }
                    if (enumC2214abM10070a == EnumC2214ab.APPLINK) {
                        if (strArr.length < 3) {
                            strM8646b6 = "";
                        } else {
                            strM8646b6 = C1736gi.m8646b(strArr[2]);
                        }
                        return ApplinkMsgEntry.getDisplayMessage(strM8646b6);
                    }
                    if (enumC2214abM10070a == EnumC2214ab.POLL) {
                        String string3 = "";
                        if (strArr.length < 3) {
                            strM8646b5 = "";
                        } else {
                            strM8646b5 = C1736gi.m8646b(strArr[2]);
                        }
                        try {
                            if (new JSONObject(strM8646b5).getJSONObject("push_message").getString("content_type").equals("result")) {
                                string3 = CommonApplication.m18732r().getString(R.string.poll_result_now_available);
                            } else {
                                string3 = CommonApplication.m18732r().getString(R.string.poll_title);
                            }
                        } catch (JSONException e2) {
                            C4904y.m18635a(e2, getClass().getSimpleName());
                        }
                        return string3;
                    }
                    return EnumC2214ab.m10074a(enumC2214abM10070a, str3, TextUtils.isEmpty(str3) ? false : "mixed".equals(str3.split("\n")[0]));
                }
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public MatrixCursor m12456c(Cursor cursor, C3410d c3410d) {
        MatrixCursor matrixCursor = new MatrixCursor(C3408b.f12373d);
        if (cursor != null) {
            try {
                if (cursor.moveToFirst()) {
                    do {
                        String string = cursor.getString(cursor.getColumnIndex("buddy_no"));
                        C3408b.m13222a(matrixCursor, 0, C3408b.m13224a(string, false), Arrays.asList(cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("suggest_text_2")), null), C3408b.m13220a(string, EnumC2300t.ONETOONE));
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
