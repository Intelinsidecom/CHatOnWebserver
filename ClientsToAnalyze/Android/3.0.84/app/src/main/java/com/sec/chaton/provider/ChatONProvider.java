package com.sec.chaton.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.net.Uri;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.api.access_token.C0440a;
import com.sec.chaton.chat.C1075eq;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.C1383aa;
import com.sec.chaton.p027e.C1384ab;
import com.sec.chaton.p027e.C1385ac;
import com.sec.chaton.p027e.C1386ad;
import com.sec.chaton.p027e.C1387ae;
import com.sec.chaton.p027e.C1388af;
import com.sec.chaton.p027e.C1389ag;
import com.sec.chaton.p027e.C1390ah;
import com.sec.chaton.p027e.C1404av;
import com.sec.chaton.p027e.C1434bj;
import com.sec.chaton.p027e.C1441i;
import com.sec.chaton.p027e.C1442j;
import com.sec.chaton.p027e.C1443k;
import com.sec.chaton.p027e.C1445m;
import com.sec.chaton.p027e.C1446n;
import com.sec.chaton.p027e.C1447o;
import com.sec.chaton.p027e.C1448p;
import com.sec.chaton.p027e.C1449q;
import com.sec.chaton.p027e.C1451s;
import com.sec.chaton.p027e.C1452t;
import com.sec.chaton.p027e.C1453u;
import com.sec.chaton.p027e.C1454v;
import com.sec.chaton.p027e.C1456x;
import com.sec.chaton.p027e.C1457y;
import com.sec.chaton.p027e.C1458z;
import com.sec.chaton.p027e.EnumC1391ai;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p027e.InterfaceC1405aw;
import com.sec.chaton.p027e.InterfaceC1407ay;
import com.sec.chaton.p027e.InterfaceC1408az;
import com.sec.chaton.p027e.InterfaceC1425ba;
import com.sec.chaton.p027e.InterfaceC1427bc;
import com.sec.chaton.p027e.InterfaceC1428bd;
import com.sec.chaton.p027e.InterfaceC1429be;
import com.sec.chaton.p027e.InterfaceC1431bg;
import com.sec.chaton.p027e.InterfaceC1433bi;
import com.sec.chaton.p027e.p028a.C1357af;
import com.sec.chaton.provider.p049a.C2037a;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3189bd;
import com.sec.chaton.util.C3193bh;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3250y;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import twitter4j.internal.http.HttpResponseCode;

/* loaded from: classes.dex */
public class ChatONProvider extends BaseContentProvider {

    /* renamed from: a */
    private static final UriMatcher f7831a = m8096b();

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        switch (f7831a.match(uri)) {
            case 100:
                return "vnd.chaton.cursor.dir/vnd.chaton.buddy";
            case 102:
                return "vnd.chaton.cursor.item/vnd.chaton.buddy";
            case 103:
                return "vnd.chaton.cursor.dir/vnd.chaton.buddy";
            case 104:
                return "vnd.chaton.cursor.dir/vnd.chaton.buddy";
            case 105:
                return "vnd.chaton.cursor.dir/vnd.chaton.buddy";
            case 106:
                return "vnd.chaton.cursor.item/vnd.chaton.buddy";
            case 107:
                return "vnd.chaton.cursor.dir/vnd.chaton.buddy";
            case 108:
                return "vnd.chaton.cursor.dir/vnd.chaton.buddy";
            case 109:
                return "vnd.chaton.cursor.dir/vnd.chaton.buddy";
            case 110:
                return "vnd.chaton.cursor.dir/vnd.chaton.buddy";
            case 111:
                return "vnd.chaton.cursor.dir/vnd.chaton.buddy";
            case 115:
                return "vnd.chaton.cursor.dir/vnd.chaton.buddy";
            case 116:
                return "vnd.chaton.cursor.dir/vnd.chaton.buddy";
            case 118:
                return "vnd.chaton.cursor.dir/vnd.chaton.buddy";
            case HttpResponseCode.f13733OK /* 200 */:
                return "vnd.chaton.cursor.dir/vnd.chaton.group";
            case 201:
                return "vnd.chaton.cursor.item/vnd.chaton.group";
            case 203:
                return "vnd.chaton.cursor.dir/vnd.chaton.group";
            case HttpResponseCode.MULTIPLE_CHOICES /* 300 */:
                return "vnd.chaton.cursor.dir/vnd.chaton.contacts";
            case 301:
                return "vnd.chaton.cursor.item/vnd.chaton.contacts";
            case HttpResponseCode.FOUND /* 302 */:
                return "vnd.chaton.cursor.dir/vnd.chaton.contacts";
            case 400:
                return "vnd.chaton.cursor.dir/vnd.chaton.inbox";
            case HttpResponseCode.UNAUTHORIZED /* 401 */:
                return "vnd.chaton.cursor.item/vnd.chaton.inbox";
            case 402:
                return "vnd.chaton.cursor.dir/vnd.chaton.inbox";
            case HttpResponseCode.NOT_FOUND /* 404 */:
                return "vnd.chaton.cursor.dir/vnd.chaton.inbox";
            case 461:
                return "vnd.chaton.cursor.dir/vnd.chaton.inboxbuddyrelation";
            case HttpResponseCode.INTERNAL_SERVER_ERROR /* 500 */:
                return "vnd.chaton.cursor.dir/vnd.chaton.message";
            case 501:
                return "vnd.chaton.cursor.item/vnd.chaton.message";
            case HttpResponseCode.BAD_GATEWAY /* 502 */:
                return "vnd.chaton.cursor.item/vnd.chaton.message";
            case 505:
                return "vnd.chaton.cursor.dir/vnd.chaton.message";
            case 506:
                return "vnd.chaton.cursor.dir/vnd.chaton.message";
            case 507:
                return "vnd.chaton.cursor.dir/vnd.chaton.message";
            case 508:
                return "vnd.chaton.cursor.dir/vnd.chaton.message";
            case 511:
                return "vnd.chaton.cursor.dir/vnd.chaton.message";
            case 512:
                return "vnd.chaton.cursor.dir/vnd.chaton.message";
            case 600:
                return "vnd.chaton.cursor.dir/vnd.chaton.relation";
            case 603:
                return "vnd.chaton.cursor.dir/vnd.chaton.relation";
            case 700:
                return "vnd.chaton.cursor.dir/vnd.chaton.grouprelation";
            case 701:
                return "vnd.chaton.cursor.dir/vnd.chaton.grouprelation";
            case 702:
                return "vnd.chaton.cursor.dir/vnd.chaton.group";
            case 711:
                return "vnd.chaton.cursor.dir/vnd.chaton.grouprelation";
            case 712:
                return "vnd.chaton.cursor.dir/vnd.chaton.grouprelation";
            case 713:
                return "vnd.chaton.cursor.item/vnd.chaton.grouprelation";
            case 900:
                return "vnd.chaton.cursor.dir/vnd.chaton.memo";
            case 902:
                return "vnd.chaton.cursor.dir/vnd.chaton.poston";
            case 903:
                return "vnd.chaton.cursor.dir/vnd.chaton.postoncomments";
            case 904:
                return "vnd.chaton.cursor.dir/vnd.chaton.poston";
            case 905:
                return "vnd.chaton.cursor.dir/vnd.chaton.postoncomments";
            case 906:
                return "vnd.chaton.cursor.dir/vnd.chaton.myposton";
            case 907:
                return "vnd.chaton.cursor.dir/vnd.chaton.buddyposton";
            case 908:
                return "vnd.chaton.cursor.dir/vnd.chaton.myposton";
            case 909:
                return "vnd.chaton.cursor.dir/vnd.chaton.buddyposton";
            case 910:
                return "vnd.chaton.cursor.dir/vnd.chaton.postonmymultimedia";
            case 911:
                return "vnd.chaton.cursor.dir/vnd.chaton.postonbuddymultimedia";
            case 912:
                return "vnd.chaton.cursor.dir/vnd.chaton.postonmymultimedia";
            case 913:
                return "vnd.chaton.cursor.dir/vnd.chaton.postonbuddymultimedia";
            case 914:
                return "vnd.chaton.cursor.dir/vnd.chaton.coverstorysample";
            case 1000:
                return "vnd.chaton.cursor.dir/vnd.chaton.recommendee";
            case 1001:
                return "vnd.chaton.cursor.dir/vnd.chaton.recommendee";
            case 1100:
                return "vnd.chaton.cursor.item/vnd.chaton.buddy";
            case 1300:
                return "com.sec.chaton.provider/buddyextrainfo";
            case 2000:
                return "vnd.chaton.cursor.dir/vnd.chaton.specialbuddy";
            case 2001:
                return "vnd.chaton.cursor.dir/vnd.chaton.specialbuddy";
            default:
                throw new UnsupportedOperationException("UnKonwn Uri : " + uri);
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        C1404av.m6253a(getContext());
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:138:0x068f  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0692  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006d A[Catch: SQLiteConstraintException -> 0x0579, SQLiteFullException -> 0x0597, all -> 0x059e, SQLiteDiskIOException -> 0x0677, SQLiteException -> 0x067f, Exception -> 0x0687, TryCatch #6 {SQLiteException -> 0x067f, Exception -> 0x0687, blocks: (B:6:0x0016, B:8:0x0031, B:9:0x0053, B:11:0x0058, B:12:0x0069, B:14:0x006d, B:16:0x0090, B:17:0x0099, B:18:0x00a3, B:19:0x00ad, B:20:0x00b7, B:22:0x00c1, B:24:0x00cc, B:25:0x00d4, B:26:0x00f1, B:28:0x00fb, B:30:0x0106, B:31:0x010e, B:33:0x012d, B:34:0x013d, B:36:0x0147, B:37:0x0173, B:39:0x0185, B:40:0x0193, B:42:0x01de, B:43:0x0252, B:45:0x025d, B:47:0x0272, B:49:0x029f, B:50:0x02f9, B:51:0x0313, B:53:0x0335, B:55:0x035b, B:57:0x0369, B:59:0x036f, B:62:0x03b7, B:65:0x03c0, B:68:0x03c8, B:70:0x03cc, B:71:0x043c, B:73:0x0453, B:78:0x0467, B:80:0x047c, B:81:0x0482, B:101:0x0574, B:112:0x0593, B:113:0x0596, B:119:0x05a0, B:120:0x05b7, B:121:0x05ce, B:122:0x05e6, B:123:0x05f0, B:124:0x05fb, B:125:0x0606, B:126:0x0611, B:128:0x0630, B:129:0x0662), top: B:145:0x0016, outer: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:150:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v107 */
    /* JADX WARN: Type inference failed for: r2v118 */
    /* JADX WARN: Type inference failed for: r2v121 */
    /* JADX WARN: Type inference failed for: r2v123 */
    /* JADX WARN: Type inference failed for: r2v125 */
    /* JADX WARN: Type inference failed for: r2v127 */
    /* JADX WARN: Type inference failed for: r2v128 */
    /* JADX WARN: Type inference failed for: r2v129, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v131 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v44, types: [android.database.MatrixCursor] */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v76 */
    /* JADX WARN: Type inference failed for: r2v80 */
    /* JADX WARN: Type inference failed for: r2v84 */
    /* JADX WARN: Type inference failed for: r2v87 */
    /* JADX WARN: Type inference failed for: r2v95 */
    /* JADX WARN: Type inference failed for: r2v97 */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.database.Cursor query(android.net.Uri r15, java.lang.String[] r16, java.lang.String r17, java.lang.String[] r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 1782
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.ChatONProvider.query(android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor");
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        Uri uriM8117a;
        String str;
        String str2;
        String asString;
        long jLongValue;
        Uri uriM6244a = ContactsContract.AUTHORITY_URI;
        try {
            try {
                try {
                    try {
                        SQLiteDatabase writableDatabase = C1404av.m6253a(getContext()).getWritableDatabase();
                        int iMatch = f7831a.match(uri);
                        ArrayList arrayList = new ArrayList();
                        if (C3250y.f11734b) {
                            C3250y.m11450b("DB insert start: " + uri.toString(), getClass().getSimpleName());
                        }
                        switch (iMatch) {
                            case 100:
                                jInsertOrThrow = m8095b(writableDatabase, contentValues);
                                uriM6244a = C1441i.f5369a;
                                arrayList.add(uriM6244a);
                                break;
                            case HttpResponseCode.f13733OK /* 200 */:
                                jInsertOrThrow = writableDatabase.insertOrThrow("buddy_group", null, contentValues);
                                uriM6244a = C1446n.f5378a;
                                arrayList.add(uriM6244a);
                                break;
                            case HttpResponseCode.MULTIPLE_CHOICES /* 300 */:
                                jInsertOrThrow = writableDatabase.insertOrThrow("contacts", null, contentValues);
                                uriM6244a = C1442j.m6320a(String.valueOf(jInsertOrThrow));
                                arrayList.add(uriM6244a);
                                break;
                            case 400:
                                jInsertOrThrow = m8103f(writableDatabase, contentValues);
                                uriM6244a = C1449q.m6329a(String.valueOf(jInsertOrThrow));
                                arrayList.add(uriM6244a);
                                break;
                            case 461:
                                jInsertOrThrow = writableDatabase.insertOrThrow("inbox_buddy_relation", null, contentValues);
                                uriM6244a = C1447o.f5379a;
                                arrayList.add(uriM6244a);
                                break;
                            case 471:
                                jInsertOrThrow = writableDatabase.insertOrThrow("inbox_session_id_mapping", null, contentValues);
                                uriM6244a = C1448p.f5380a;
                                arrayList.add(uriM6244a);
                                break;
                            case HttpResponseCode.INTERNAL_SERVER_ERROR /* 500 */:
                                asString = contentValues.containsKey("message_inbox_no") ? contentValues.getAsString("message_inbox_no") : "";
                                jInsertOrThrow = contentValues.containsKey("_id") ? contentValues.getAsLong("_id").longValue() : -1L;
                                jLongValue = contentValues.containsKey("message_sever_id") ? contentValues.getAsLong("message_sever_id").longValue() : -1L;
                                if (C3250y.f11735c) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("DB insert : ").append(uri.toString()).append(", ").append("MsgID : ").append(jInsertOrThrow).append(", ").append("MsgID(ServerNO) : ").append(jLongValue).append(", ").append("InboxNO : ").append(asString);
                                    C3250y.m11453c(sb.toString(), "ChatONProvider");
                                }
                                if (writableDatabase.insertOrThrow("message", null, contentValues) > 0) {
                                    uriM6244a = C1454v.f5393a;
                                    arrayList.add(uriM6244a);
                                }
                                if (C3250y.f11735c) {
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("DB insert end : ").append(uri.toString()).append(", ").append("MsgID : ").append(jInsertOrThrow).append(", ").append("MsgID(ServerNO) : ").append(jLongValue).append(", ").append("InboxNO : ").append(asString);
                                    C3250y.m11453c(sb2.toString(), "ChatONProvider");
                                    break;
                                }
                                break;
                            case 506:
                                asString = contentValues.containsKey("message_inbox_no") ? contentValues.getAsString("message_inbox_no") : "";
                                jInsertOrThrow = contentValues.containsKey("_id") ? contentValues.getAsLong("_id").longValue() : -1L;
                                jLongValue = contentValues.containsKey("message_sever_id") ? contentValues.getAsLong("message_sever_id").longValue() : -1L;
                                if (C3250y.f11735c) {
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("DB insert : ").append(uri.toString()).append(", ").append("MsgID : ").append(jInsertOrThrow).append(", ").append("MsgID(ServerNO) : ").append(jLongValue).append(", ").append("InboxNO : ").append(asString);
                                    C3250y.m11453c(sb3.toString(), "ChatONProvider");
                                }
                                uriM6244a = C1454v.f5393a;
                                arrayList.add(uriM6244a);
                                if (C3250y.f11735c) {
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append("DB insert end : ").append(uri.toString()).append(", ").append("MsgID : ").append(jInsertOrThrow).append(", ").append("MsgID(ServerNO) : ").append(jLongValue).append(", ").append("InboxNO : ").append(asString);
                                    C3250y.m11453c(sb4.toString(), "ChatONProvider");
                                    break;
                                }
                                break;
                            case 507:
                                asString = contentValues.containsKey("message_inbox_no") ? contentValues.getAsString("message_inbox_no") : "";
                                long jLongValue2 = contentValues.containsKey("_id") ? contentValues.getAsLong("_id").longValue() : -1L;
                                long jLongValue3 = contentValues.containsKey("message_sever_id") ? contentValues.getAsLong("message_sever_id").longValue() : -1L;
                                if (C3250y.f11735c) {
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append("DB insert : ").append(uri.toString()).append(", ").append("MsgID : ").append(jLongValue2).append(", ").append("MsgID(ServerNO) : ").append(jLongValue3).append(", ").append("InboxNO : ").append(asString);
                                    C3250y.m11453c(sb5.toString(), "ChatONProvider");
                                }
                                EnumC2040c enumC2040cM8106i = m8106i(writableDatabase, contentValues);
                                if (enumC2040cM8106i == EnumC2040c.RESULT_SUCCESS_INSERT) {
                                    uriM6244a = C1454v.m6345a(String.valueOf(contentValues.getAsLong("_id").longValue()));
                                } else if (enumC2040cM8106i == EnumC2040c.RESULT_SUCCESS_UPDATE) {
                                    uriM6244a = C1454v.f5393a;
                                }
                                arrayList.add(C1454v.f5393a);
                                if (C3250y.f11735c) {
                                    StringBuilder sb6 = new StringBuilder();
                                    sb6.append("DB insert end : ").append(uri.toString()).append(", ").append("MsgID : ").append(jLongValue2).append(", ").append("MsgID(ServerNO) : ").append(jLongValue3).append(", ").append("InboxNO : ").append(asString);
                                    C3250y.m11453c(sb6.toString(), "ChatONProvider");
                                }
                                jInsertOrThrow = 1;
                                break;
                            case 508:
                                jInsertOrThrow = m8105h(writableDatabase, contentValues);
                                arrayList.add(C1454v.f5393a);
                                arrayList.add(C1449q.f5381a);
                                break;
                            case 600:
                                jInsertOrThrow = writableDatabase.insertOrThrow("relation", null, contentValues);
                                uriM6244a = C1389ag.m6244a(String.valueOf(jInsertOrThrow));
                                arrayList.add(uriM6244a);
                                break;
                            case 604:
                                writableDatabase.execSQL(InterfaceC1428bd.f5306a);
                                arrayList.add(uriM6244a);
                                jInsertOrThrow = 1;
                                break;
                            case 700:
                                jInsertOrThrow = writableDatabase.insertOrThrow("grouprelation", null, contentValues);
                                uriM6244a = C1445m.m6324a(String.valueOf(jInsertOrThrow));
                                arrayList.add(uriM6244a);
                                break;
                            case 800:
                                jInsertOrThrow = writableDatabase.insertOrThrow("participant", null, contentValues);
                                uriM6244a = C1457y.f5415a;
                                arrayList.add(uriM6244a);
                                break;
                            case 900:
                                jInsertOrThrow = writableDatabase.insertOrThrow("memo", null, contentValues);
                                uriM6244a = C1452t.f5391a;
                                arrayList.add(uriM6244a);
                                break;
                            case 901:
                                jInsertOrThrow = m8102e(writableDatabase, contentValues);
                                uriM6244a = C1451s.f5390a;
                                arrayList.add(uriM6244a);
                                break;
                            case 902:
                                jInsertOrThrow = writableDatabase.insertOrThrow("poston", null, contentValues);
                                uriM6244a = C1387ae.f5184a;
                                arrayList.add(uriM6244a);
                                break;
                            case 903:
                                jInsertOrThrow = writableDatabase.insertOrThrow("poston_comments", null, contentValues);
                                uriM6244a = C1384ab.f5178a;
                                arrayList.add(uriM6244a);
                                break;
                            case 906:
                                jInsertOrThrow = writableDatabase.insertOrThrow("my_poston", null, contentValues);
                                uriM6244a = C1386ad.f5182a;
                                arrayList.add(uriM6244a);
                                break;
                            case 907:
                                jInsertOrThrow = writableDatabase.insertOrThrow("buddy_poston", null, contentValues);
                                uriM6244a = C1383aa.f5176a;
                                arrayList.add(uriM6244a);
                                break;
                            case 912:
                                jInsertOrThrow = writableDatabase.insertOrThrow("my_multimedia_poston", null, contentValues);
                                uriM6244a = C1385ac.f5180a;
                                arrayList.add(uriM6244a);
                                break;
                            case 913:
                                jInsertOrThrow = writableDatabase.insertOrThrow("buddy_multimedia_poston", null, contentValues);
                                uriM6244a = C1458z.f5416a;
                                arrayList.add(uriM6244a);
                                break;
                            case 914:
                                jInsertOrThrow = m8089a(writableDatabase, contentValues);
                                uriM6244a = C1443k.f5371a;
                                arrayList.add(uriM6244a);
                                break;
                            case 1000:
                                jInsertOrThrow = m8101d(writableDatabase, contentValues);
                                uriM6244a = C1388af.f5186a;
                                arrayList.add(uriM6244a);
                                break;
                            case 2000:
                                jInsertOrThrow = m8100c(writableDatabase, contentValues);
                                uriM6244a = C1390ah.f5188a;
                                arrayList.add(uriM6244a);
                                break;
                            case 3000:
                                jInsertOrThrow = writableDatabase.insertOrThrow("message_notification", null, contentValues);
                                uriM6244a = C1453u.f5392a;
                                arrayList.add(uriM6244a);
                                break;
                            case 4000:
                                jInsertOrThrow = writableDatabase.insertOrThrow("participant_mapping", null, contentValues);
                                uriM6244a = C1456x.f5414a;
                                arrayList.add(uriM6244a);
                                break;
                            default:
                                arrayList.add(ContactsContract.AUTHORITY_URI);
                                C3250y.m11455d("Unknown Uri : " + uri.toString(), "ChatONProvider");
                                break;
                        }
                        if (C3250y.f11734b) {
                            C3250y.m11450b("DB insert end: " + uri.toString(), getClass().getSimpleName());
                        }
                        if (!m8070a() && jInsertOrThrow > -1 && arrayList != null && arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                getContext().getContentResolver().notifyChange((Uri) it.next(), null);
                            }
                        }
                        arrayList.clear();
                        return uriM6244a;
                    } catch (SQLiteDiskIOException e) {
                        C3250y.m11443a(e, "ChatONProvider");
                        uriM8117a = C2036a.m8117a(EnumC2039b.DISK_IO);
                        if (!C3250y.f11734b) {
                            return uriM8117a;
                        }
                        str = "returnUri : " + uriM8117a.toString();
                        str2 = "ChatONProvider";
                        C3250y.m11450b(str, str2);
                        return uriM8117a;
                    } catch (SQLiteFullException e2) {
                        C3250y.m11443a(e2, "ChatONProvider");
                        uriM8117a = C2036a.m8117a(EnumC2039b.FULL);
                        if (!C3250y.f11734b) {
                            return uriM8117a;
                        }
                        str = "returnUri : " + uriM8117a.toString();
                        str2 = "ChatONProvider";
                        C3250y.m11450b(str, str2);
                        return uriM8117a;
                    }
                } catch (SQLiteConstraintException e3) {
                    C3250y.m11443a(e3, "ChatONProvider");
                    uriM8117a = C2036a.m8117a(EnumC2039b.CONSTRAINT);
                    if (!C3250y.f11734b) {
                        return uriM8117a;
                    }
                    str = "returnUri : " + uriM8117a.toString();
                    str2 = "ChatONProvider";
                    C3250y.m11450b(str, str2);
                    return uriM8117a;
                } catch (Exception e4) {
                    C3250y.m11443a(e4, "ChatONProvider");
                    uriM8117a = C2036a.m8117a(EnumC2039b.UNKNOWN);
                    if (!C3250y.f11734b) {
                        return uriM8117a;
                    }
                    str = "returnUri : " + uriM8117a.toString();
                    str2 = "ChatONProvider";
                    C3250y.m11450b(str, str2);
                    return uriM8117a;
                }
            } catch (SQLiteException e5) {
                C3250y.m11443a(e5, "ChatONProvider");
                uriM8117a = C2036a.m8117a(EnumC2039b.NORMAL);
                if (!C3250y.f11734b) {
                    return uriM8117a;
                }
                str = "returnUri : " + uriM8117a.toString();
                str2 = "ChatONProvider";
                C3250y.m11450b(str, str2);
                return uriM8117a;
            }
        } finally {
            if (C3250y.f11734b) {
                C3250y.m11450b("returnUri : " + uriM6244a.toString(), "ChatONProvider");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v43, types: [int] */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v51 */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v53 */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v55 */
    /* JADX WARN: Type inference failed for: r2v56 */
    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) throws Throwable {
        int i;
        String str2;
        String str3;
        ?? r2 = -1;
        int i2 = -1;
        try {
        } catch (Throwable th) {
            th = th;
            r2 = -1;
        }
        try {
            try {
                SQLiteDatabase writableDatabase = C1404av.m6253a(getContext()).getWritableDatabase();
                int iMatch = f7831a.match(uri);
                ArrayList arrayList = new ArrayList();
                if (C3250y.f11734b) {
                    C3250y.m11450b("DB update start: " + uri.toString(), getClass().getSimpleName());
                }
                try {
                    switch (iMatch) {
                        case 405:
                            int iM8104g = m8104g(writableDatabase, contentValues);
                            i2 = iM8104g;
                            if (iM8104g > 0) {
                                arrayList.add(C1449q.f5381a);
                                arrayList.add(C1454v.f5393a);
                                i2 = iM8104g;
                                break;
                            }
                            break;
                        case 410:
                            int iM8088a = m8088a(writableDatabase, contentValues, str, strArr);
                            arrayList.add(uri);
                            i2 = iM8088a;
                            break;
                        case 412:
                            int iM8099c = m8099c(writableDatabase, contentValues, str, strArr);
                            arrayList.add(uri);
                            i2 = iM8099c;
                            break;
                        case HttpResponseCode.INTERNAL_SERVER_ERROR /* 500 */:
                            long jLongValue = contentValues.containsKey("_id") ? contentValues.getAsLong("_id").longValue() : -1L;
                            long jLongValue2 = contentValues.containsKey("message_sever_id") ? contentValues.getAsLong("message_sever_id").longValue() : -1L;
                            if (C3250y.f11735c) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("DB update : ").append(uri.toString()).append(", ").append("MsgID : ").append(jLongValue).append(", ").append("MsgID(ServerNO) : ").append(jLongValue2);
                                C3250y.m11453c(sb.toString(), "ChatONProvider");
                            }
                            int iM6285a = m8097b(uri, iMatch).m6289a(str, strArr).m6285a(writableDatabase, contentValues);
                            if (strArr != null) {
                                C3250y.m11450b("ContentProvider : " + uri.toString() + " : " + strArr[0], getClass().getSimpleName());
                            }
                            C3250y.m11450b("UdateMessage Result : " + String.valueOf(iM6285a), getClass().getSimpleName());
                            arrayList.add(uri);
                            i2 = iM6285a;
                            if (C3250y.f11735c) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("DB update end : ").append(uri.toString()).append(", ").append("MsgID : ").append(jLongValue).append(", ").append("MsgID(ServerNO) : ").append(jLongValue2);
                                C3250y.m11453c(sb2.toString(), "ChatONProvider");
                                i2 = iM6285a;
                                break;
                            }
                            break;
                        case 504:
                            int iM8107j = m8107j(writableDatabase, contentValues);
                            arrayList.add(uri);
                            i2 = iM8107j;
                            break;
                        case 4100:
                            C2037a.m8119a().m8142a(writableDatabase);
                            i2 = 1;
                            arrayList.add(uri);
                            break;
                        case 4200:
                            int iM8094b = m8094b(writableDatabase, contentValues, str, strArr);
                            arrayList.add(uri);
                            i2 = iM8094b;
                            break;
                        default:
                            int iM6285a2 = m8097b(uri, iMatch).m6289a(str, strArr).m6285a(writableDatabase, contentValues);
                            arrayList.add(uri);
                            i2 = iM6285a2;
                            break;
                    }
                    if (C3250y.f11734b) {
                        C3250y.m11450b("DB update end: " + uri.toString(), getClass().getSimpleName());
                    }
                    if (!m8070a() && i2 > 0 && arrayList != null && arrayList.size() > 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            getContext().getContentResolver().notifyChange((Uri) it.next(), null);
                        }
                    }
                    arrayList.clear();
                    if (C3250y.f11734b) {
                        C3250y.m11450b("returnInteger : " + String.valueOf(i2), "ChatONProvider");
                    }
                    return i2;
                } catch (SQLiteConstraintException e) {
                    e = e;
                    C3250y.m11443a(e, "ChatONProvider");
                    i = -3;
                    if (!C3250y.f11734b) {
                        return -3;
                    }
                    str2 = "returnInteger : " + String.valueOf(-3);
                    str3 = "ChatONProvider";
                    C3250y.m11450b(str2, str3);
                    return i;
                } catch (SQLiteDiskIOException e2) {
                    e = e2;
                    C3250y.m11443a(e, "ChatONProvider");
                    i = -5;
                    if (!C3250y.f11734b) {
                        return -5;
                    }
                    str2 = "returnInteger : " + String.valueOf(-5);
                    str3 = "ChatONProvider";
                    C3250y.m11450b(str2, str3);
                    return i;
                } catch (SQLiteFullException e3) {
                    e = e3;
                    C3250y.m11443a(e, "ChatONProvider");
                    i = -4;
                    if (!C3250y.f11734b) {
                        return -4;
                    }
                    str2 = "returnInteger : " + String.valueOf(-4);
                    str3 = "ChatONProvider";
                    C3250y.m11450b(str2, str3);
                    return i;
                } catch (SQLiteException e4) {
                    e = e4;
                    C3250y.m11443a(e, "ChatONProvider");
                    i = -2;
                    if (!C3250y.f11734b) {
                        return -2;
                    }
                    str2 = "returnInteger : " + String.valueOf(-2);
                    str3 = "ChatONProvider";
                    C3250y.m11450b(str2, str3);
                    return i;
                } catch (Exception e5) {
                    e = e5;
                    C3250y.m11443a(e, "ChatONProvider");
                    if (C3250y.f11734b) {
                        C3250y.m11450b("returnInteger : " + String.valueOf(-1), "ChatONProvider");
                    }
                    return -1;
                }
            } catch (SQLiteConstraintException e6) {
                e = e6;
            } catch (SQLiteDiskIOException e7) {
                e = e7;
            } catch (SQLiteFullException e8) {
                e = e8;
            } catch (SQLiteException e9) {
                e = e9;
            } catch (Exception e10) {
                e = e10;
            }
        } catch (Throwable th2) {
            th = th2;
            if (C3250y.f11734b) {
                C3250y.m11450b("returnInteger : " + String.valueOf((int) r2), "ChatONProvider");
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01b8  */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v5 */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int delete(android.net.Uri r6, java.lang.String r7, java.lang.String[] r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 490
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.ChatONProvider.delete(android.net.Uri, java.lang.String, java.lang.String[]):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) {
        if (!C0440a.m3070a(getContext(), Binder.getCallingUid())) {
            throw new SecurityException("Access Token is invalid.");
        }
        int iMatch = f7831a.match(uri);
        C3250y.m11450b("openFile : uri = " + uri.toString(), getClass().getSimpleName());
        switch (iMatch) {
            case 102:
                if ("r".equals(str)) {
                    return ParcelFileDescriptor.open(new File(getContext().getFilesDir(), C3205bt.m11197d(uri.getLastPathSegment())), 268435456);
                }
                return null;
            case 202:
                if ("r".equals(str)) {
                    return ParcelFileDescriptor.open(new File(getContext().getFilesDir(), C3205bt.m11198e(uri.getLastPathSegment())), 268435456);
                }
                return null;
            case HttpResponseCode.UNAUTHORIZED /* 401 */:
                if ("r".equals(str)) {
                    return ParcelFileDescriptor.open(new File(getContext().getFilesDir(), C3205bt.m11195c(uri.getLastPathSegment())), 268435456);
                }
                return null;
            default:
                return null;
        }
    }

    /* renamed from: b */
    private static UriMatcher m8096b() {
        UriMatcher uriMatcher = new UriMatcher(-1);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/buddy_no/*", 102);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/buddy_count", 111);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/hide_buddy_count", 117);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/participants_no_same", 108);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/participants", 107);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/unknown_calllogs", 118);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/profile", 106);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/group", 103);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/alphabetical", 104);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/alphabetical2", 109);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/relation", 105);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/alphabetical_special", 110);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/get_hide_buddy", 112);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/buddygroup_chatonv", 115);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/buddy_included_group", 116);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy", 100);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy_group/group_info", 203);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy_group/group_name/*", 202);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy_group/group_refresh", 714);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy_group/*", 201);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy_group", HttpResponseCode.f13733OK);
        uriMatcher.addURI("com.sec.chaton.provider", "contacts/conatct_number/*", HttpResponseCode.FOUND);
        uriMatcher.addURI("com.sec.chaton.provider", "contacts/*", 301);
        uriMatcher.addURI("com.sec.chaton.provider", "contacts", HttpResponseCode.MULTIPLE_CHOICES);
        uriMatcher.addURI("com.sec.chaton.provider", "grouprelation/group_relation_group/*", 711);
        uriMatcher.addURI("com.sec.chaton.provider", "grouprelation/group_relation_buddy/*", 712);
        uriMatcher.addURI("com.sec.chaton.provider", "grouprelation/group", 713);
        uriMatcher.addURI("com.sec.chaton.provider", "grouprelation/buddy_in", 701);
        uriMatcher.addURI("com.sec.chaton.provider", "grouprelation/buddy_not_in", 702);
        uriMatcher.addURI("com.sec.chaton.provider", "grouprelation", 700);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/chat_list_sync", 4100);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/delete_old_chat_rooms", 4101);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/update_unread_count", 4200);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/update_inbox_with_current_unread_count", 412);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/update_for_push", 410);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/get_inbox_no", HttpResponseCode.NOT_ACCEPTABLE);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/inbox_title_for_search", 411);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/inbox_invalid_update", 405);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/group_title_update", HttpResponseCode.NOT_FOUND);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/buddy_participant_join", HttpResponseCode.FORBIDDEN);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/buddy_participant_join_for_list", 407);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/buddy_participant_join_for_list_of_forward", 408);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/buddy_participant_join_for_list_of_poll", 409);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/inbox_no", 402);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/*", HttpResponseCode.UNAUTHORIZED);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox", 400);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox_buddy_relation", 461);
        uriMatcher.addURI("com.sec.chaton.provider", "message/read_ack", 504);
        uriMatcher.addURI("com.sec.chaton.provider", "message/message_sever_id/*", HttpResponseCode.BAD_GATEWAY);
        uriMatcher.addURI("com.sec.chaton.provider", "message/message_buddy", 505);
        uriMatcher.addURI("com.sec.chaton.provider", "message/message_buddy/*", 509);
        uriMatcher.addURI("com.sec.chaton.provider", "message/message_buddy_noti/*", 513);
        uriMatcher.addURI("com.sec.chaton.provider", "message/media", 514);
        uriMatcher.addURI("com.sec.chaton.provider", "message/get_pendings", 515);
        uriMatcher.addURI("com.sec.chaton.provider", "message/update", 512);
        uriMatcher.addURI("com.sec.chaton.provider", "message/delete", 511);
        uriMatcher.addURI("com.sec.chaton.provider", "message/count/*", 510);
        uriMatcher.addURI("com.sec.chaton.provider", "message/send", 506);
        uriMatcher.addURI("com.sec.chaton.provider", "message/received", 507);
        uriMatcher.addURI("com.sec.chaton.provider", "message/send/inbox", 508);
        uriMatcher.addURI("com.sec.chaton.provider", "message/message_for_search", 516);
        uriMatcher.addURI("com.sec.chaton.provider", "message/*", 501);
        uriMatcher.addURI("com.sec.chaton.provider", "message", HttpResponseCode.INTERNAL_SERVER_ERROR);
        uriMatcher.addURI("com.sec.chaton.provider", "relation/insert", 604);
        uriMatcher.addURI("com.sec.chaton.provider", "relation/day", 603);
        uriMatcher.addURI("com.sec.chaton.provider", "relation", 600);
        uriMatcher.addURI("com.sec.chaton.provider", "participant/name_join_buddy", 802);
        uriMatcher.addURI("com.sec.chaton.provider", "participant/*", 801);
        uriMatcher.addURI("com.sec.chaton.provider", "participant", 800);
        uriMatcher.addURI("com.sec.chaton.provider", "memo", 900);
        uriMatcher.addURI("com.sec.chaton.provider", "memo_sessions", 901);
        uriMatcher.addURI("com.sec.chaton.provider", "poston", 902);
        uriMatcher.addURI("com.sec.chaton.provider", "my_poston", 906);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy_poston", 907);
        uriMatcher.addURI("com.sec.chaton.provider", "poston_comments", 903);
        uriMatcher.addURI("com.sec.chaton.provider", "my_multimedia_poston", 912);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy_multimedia_poston", 913);
        uriMatcher.addURI("com.sec.chaton.provider", "cover_story_sample", 914);
        uriMatcher.addURI("com.sec.chaton.provider", "poston/joined_buddy", 904);
        uriMatcher.addURI("com.sec.chaton.provider", "poston_comments/joined_buddy", 905);
        uriMatcher.addURI("com.sec.chaton.provider", "my_poston/joined_buddy", 908);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy_poston/joined_buddy", 909);
        uriMatcher.addURI("com.sec.chaton.provider", "my_multimedia_poston/joined_my_multimedia", 910);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy_multimedia_poston/joined_buddy_multimedia", 911);
        uriMatcher.addURI("com.sec.chaton.provider", "recommendee", 1000);
        uriMatcher.addURI("com.sec.chaton.provider", "recommendee/recommendee_count", 1001);
        uriMatcher.addURI("com.sec.chaton.provider", "specialbuddy", 2000);
        uriMatcher.addURI("com.sec.chaton.provider", "specialbuddy/specialbuddy_count", 2001);
        uriMatcher.addURI("com.sec.chaton.provider", "me", 1100);
        uriMatcher.addURI("com.sec.chaton.provider", "myextrainfo", 1200);
        uriMatcher.addURI("com.sec.chaton.provider", "buddyextrainfo/#", 1300);
        uriMatcher.addURI("com.sec.chaton.provider", "buddyextrainfoall", 1400);
        uriMatcher.addURI("com.sec.chaton.provider", "message_notification", 3000);
        uriMatcher.addURI("com.sec.chaton.provider", "message_notification/parse_message_noti", 3001);
        uriMatcher.addURI("com.sec.chaton.provider", "participant_mapping", 4000);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox_session_id_mapping", 471);
        uriMatcher.addURI("com.sec.chaton.provider", "setting_info", 5000);
        return uriMatcher;
    }

    /* renamed from: a */
    private C1434bj m8093a(Uri uri, int i) {
        C1434bj c1434bj = new C1434bj();
        switch (i) {
            case 100:
                return c1434bj.m6288a("buddy");
            case 102:
                return c1434bj.m6288a("buddy").m6289a("buddy_no=?", C1441i.m6309b(uri));
            case 103:
                return c1434bj.m6288a(InterfaceC1405aw.f5219a);
            case 104:
                return c1434bj.m6288a(InterfaceC1405aw.f5220b);
            case 105:
                return c1434bj.m6288a(InterfaceC1405aw.f5226h);
            case 106:
                return c1434bj.m6288a(InterfaceC1405aw.f5227i);
            case 107:
                return c1434bj.m6288a(InterfaceC1405aw.f5222d);
            case 108:
                return c1434bj.m6288a(InterfaceC1405aw.f5225g);
            case 109:
                return c1434bj.m6288a(InterfaceC1405aw.f5221c);
            case 110:
                return c1434bj.m6288a(InterfaceC1405aw.f5224f);
            case 111:
                return c1434bj.m6288a(InterfaceC1405aw.f5230l);
            case 112:
                return c1434bj.m6288a(InterfaceC1405aw.f5232n);
            case 115:
                return c1434bj.m6288a("(select buddy_no from buddy where buddy_extra_info like '%voip=1%' and length(buddy_sainfo) > 0 intersect select distinct buddy_no from grouprelation a left outer join buddy as b on a.group_relation_buddy = b.buddy_no)");
            case 116:
                return c1434bj.m6288a("(SELECT r.group_relation_buddy AS buddy_no, g._id AS _id, g.group_name AS group_name FROM grouprelation r JOIN buddy_group g ON r.group_relation_group=g._id WHERE g._id <> 1)");
            case 117:
                return c1434bj.m6288a(InterfaceC1405aw.f5231m);
            case 118:
                return c1434bj.m6288a(InterfaceC1405aw.f5223e);
            case HttpResponseCode.f13733OK /* 200 */:
                return c1434bj.m6288a("buddy_group");
            case 201:
                return c1434bj.m6288a("buddy_group").m6289a("_id=?", C1446n.m6327a(uri));
            case 203:
                return c1434bj.m6288a(InterfaceC1407ay.f5237a);
            case HttpResponseCode.MULTIPLE_CHOICES /* 300 */:
                return c1434bj.m6288a("contacts");
            case 301:
                return c1434bj.m6288a("contacts").m6289a("_id=?", C1442j.m6321a(uri));
            case HttpResponseCode.FOUND /* 302 */:
                return c1434bj.m6288a("contacts").m6289a("conatct_number=?", C1442j.m6322b(uri));
            case 400:
                return c1434bj.m6288a("inbox");
            case HttpResponseCode.UNAUTHORIZED /* 401 */:
                return c1434bj.m6288a("inbox").m6289a("_id=?", C1449q.m6330a(uri));
            case 402:
                return c1434bj.m6288a("inbox").m6289a("inbox_no=?", C1449q.m6332b(uri));
            case HttpResponseCode.FORBIDDEN /* 403 */:
                return c1434bj.m6288a(InterfaceC1425ba.f5292a);
            case HttpResponseCode.NOT_FOUND /* 404 */:
                return c1434bj.m6288a(InterfaceC1425ba.f5295d);
            case HttpResponseCode.NOT_ACCEPTABLE /* 406 */:
                return c1434bj.m6288a(InterfaceC1425ba.f5292a);
            case 407:
                return c1434bj.m6288a("SELECT a.*, r.buddy_no AS relation_buddy_no\tFROM (  SELECT j.buddy_no, j.buddy_name, j.buddy_show_phone_number, j.buddy_extra_info, j.buddy_msisdns, j.buddy_status_message, j.weburl, j.is_buddy, i.* FROM inbox i LEFT OUTER JOIN ( SELECT p.participants_buddy_no AS buddy_no, ifnull(b.buddy_name, p.participants_buddy_name) AS buddy_name,p.participants_inbox_no, b.buddy_show_phone_number, b.buddy_extra_info, b.buddy_msisdns, b.buddy_status_message, b.weburl, b.is_buddy FROM participant p LEFT OUTER JOIN ( SELECT buddy_no,buddy_name, buddy_show_phone_number, buddy_extra_info, buddy_msisdns, buddy_status_message, '' AS weburl, 'Y' AS is_buddy FROM buddy UNION ALL SELECT buddy_no AS buddy_no,buddy_name AS buddy_name,'' AS buddy_show_phone_number, '' AS buddy_extra_info, '' AS buddy_msisdns, msgstatus AS buddy_status_message,weburl, 'Y' AS is_buddy FROM specialbuddy ) b  ON p.participants_buddy_no = b.buddy_no WHERE p.participants_inbox_no NOT null ) j  ON i.inbox_no = j.participants_inbox_no WHERE i.inbox_last_chat_type != 12 GROUP BY i.inbox_no ) a  LEFT OUTER JOIN inbox_buddy_relation r  ON a.inbox_no = r.inbox_no ORDER BY inbox_last_time DESC, a._id");
            case 408:
                return c1434bj.m6288a(InterfaceC1425ba.f5293b);
            case 409:
                return c1434bj.m6288a(InterfaceC1425ba.f5294c);
            case 461:
                return c1434bj.m6288a("inbox_buddy_relation");
            case 471:
                return c1434bj.m6288a("inbox_session_id_mapping");
            case HttpResponseCode.INTERNAL_SERVER_ERROR /* 500 */:
                return c1434bj.m6288a("message");
            case 501:
                String strM6346a = C1454v.m6346a(uri);
                return c1434bj.m6288a("message").m6289a(strM6346a + "=?", strM6346a);
            case HttpResponseCode.BAD_GATEWAY /* 502 */:
                String strM6351b = C1454v.m6351b(uri);
                return c1434bj.m6288a("message").m6289a(strM6351b + "=?", strM6351b);
            case 505:
                return c1434bj.m6288a(InterfaceC1431bg.f5348a);
            case 511:
                return c1434bj.m6288a("message");
            case 600:
                return c1434bj.m6288a("relation");
            case 603:
                return c1434bj.m6288a(InterfaceC1429be.f5307a);
            case 700:
                return c1434bj.m6288a("grouprelation");
            case 701:
                return c1434bj.m6288a(InterfaceC1408az.f5238a);
            case 702:
                return c1434bj.m6288a(InterfaceC1408az.f5239b);
            case 711:
                return c1434bj.m6288a("grouprelation").m6289a("group_relation_group=?", C1445m.m6326b(uri));
            case 712:
                return c1434bj.m6288a("grouprelation").m6289a("group_relation_buddy=?", C1445m.m6325a(uri));
            case 713:
                return c1434bj.m6288a(InterfaceC1408az.f5240c);
            case 714:
                return c1434bj.m6288a(InterfaceC1405aw.f5234p);
            case 800:
                return c1434bj.m6288a(InterfaceC1431bg.f5351d);
            case 801:
                return c1434bj.m6288a(InterfaceC1431bg.f5351d).m6289a("participants_inbox_no=?", C1457y.m6368a(uri));
            case 802:
                return c1434bj.m6288a(InterfaceC1431bg.f5352e);
            case 900:
                return c1434bj.m6288a("memo");
            case 901:
                return c1434bj.m6288a("memo_sessions");
            case 902:
                return c1434bj.m6288a("poston");
            case 903:
                return c1434bj.m6288a("poston_comments");
            case 904:
                return c1434bj.m6288a(InterfaceC1427bc.f5300a);
            case 905:
                return c1434bj.m6288a(InterfaceC1427bc.f5303d);
            case 906:
                return c1434bj.m6288a("my_poston");
            case 907:
                return c1434bj.m6288a("buddy_poston");
            case 908:
                return c1434bj.m6288a(InterfaceC1427bc.f5301b);
            case 909:
                return c1434bj.m6288a(InterfaceC1427bc.f5302c);
            case 910:
                return c1434bj.m6288a(InterfaceC1427bc.f5304e);
            case 911:
                return c1434bj.m6288a(InterfaceC1427bc.f5305f);
            case 912:
                return c1434bj.m6288a("my_multimedia_poston");
            case 913:
                return c1434bj.m6288a("buddy_multimedia_poston");
            case 914:
                return c1434bj.m6288a("cover_story_sample");
            case 1000:
                return c1434bj.m6288a("recommendee");
            case 1001:
                return c1434bj.m6288a(InterfaceC1405aw.f5235q);
            case 1300:
            case 1400:
                return c1434bj.m6288a(InterfaceC1405aw.f5229k);
            case 2000:
                return c1434bj.m6288a("specialbuddy");
            case 2001:
                return c1434bj.m6288a(InterfaceC1405aw.f5233o);
            case 3000:
                return c1434bj.m6288a("message_notification");
            case 4000:
                return c1434bj.m6288a("participant_mapping");
            default:
                return null;
        }
    }

    /* renamed from: b */
    private C1434bj m8097b(Uri uri, int i) {
        C1434bj c1434bj = new C1434bj();
        switch (i) {
            case 100:
                return c1434bj.m6288a("buddy");
            case 102:
                return c1434bj.m6288a("buddy").m6289a("buddy_no=?", C1441i.m6309b(uri));
            case HttpResponseCode.f13733OK /* 200 */:
                return c1434bj.m6288a("buddy_group");
            case 201:
                return c1434bj.m6288a("buddy_group").m6289a("_id=?", C1446n.m6327a(uri));
            case HttpResponseCode.MULTIPLE_CHOICES /* 300 */:
                return c1434bj.m6288a("contacts");
            case 301:
                return c1434bj.m6288a("contacts").m6289a("_id=?", C1442j.m6321a(uri));
            case HttpResponseCode.FOUND /* 302 */:
                return c1434bj.m6288a("contacts").m6289a("conatct_number=?", C1442j.m6322b(uri));
            case 400:
                return c1434bj.m6288a("inbox");
            case HttpResponseCode.UNAUTHORIZED /* 401 */:
                return c1434bj.m6288a("inbox").m6289a("_id=?", C1449q.m6330a(uri));
            case 402:
                return c1434bj.m6288a("inbox").m6289a("inbox_no=?", C1449q.m6332b(uri));
            case 461:
                return c1434bj.m6288a("inbox_buddy_relation");
            case 471:
                return c1434bj.m6288a("inbox_session_id_mapping");
            case HttpResponseCode.INTERNAL_SERVER_ERROR /* 500 */:
                return c1434bj.m6288a("message");
            case 501:
                String strM6346a = C1454v.m6346a(uri);
                return c1434bj.m6288a("message").m6289a(strM6346a + "=?", strM6346a);
            case HttpResponseCode.BAD_GATEWAY /* 502 */:
                String strM6351b = C1454v.m6351b(uri);
                return c1434bj.m6288a("message").m6289a(strM6351b + "=?", strM6351b);
            case 504:
                return c1434bj.m6288a(InterfaceC1433bi.f5357a);
            case 511:
                return c1434bj.m6288a("message");
            case 512:
                return c1434bj.m6288a("message");
            case 600:
                return c1434bj.m6288a("relation");
            case 700:
                return c1434bj.m6288a("grouprelation");
            case 711:
                return c1434bj.m6288a("grouprelation").m6289a("group_relation_group=?", C1445m.m6326b(uri));
            case 712:
                return c1434bj.m6288a("grouprelation").m6289a("group_relation_buddy=?", C1445m.m6325a(uri));
            case 800:
                return c1434bj.m6288a("participant");
            case 801:
                String strM6368a = C1457y.m6368a(uri);
                return c1434bj.m6288a("participant").m6289a(strM6368a + "=?", strM6368a);
            case 802:
                return c1434bj.m6288a(InterfaceC1431bg.f5352e);
            case 900:
                return c1434bj.m6288a("memo");
            case 901:
                return c1434bj.m6288a("memo_sessions");
            case 902:
                return c1434bj.m6288a("poston");
            case 903:
                return c1434bj.m6288a("poston_comments");
            case 906:
                return c1434bj.m6288a("my_poston");
            case 907:
                return c1434bj.m6288a("buddy_poston");
            case 912:
                return c1434bj.m6288a("my_multimedia_poston");
            case 913:
                return c1434bj.m6288a("buddy_multimedia_poston");
            case 914:
                return c1434bj.m6288a("cover_story_sample");
            case 1000:
                return c1434bj.m6288a("recommendee");
            case 2000:
                return c1434bj.m6288a("specialbuddy");
            case 3000:
                return c1434bj.m6288a("message_notification");
            case 3001:
                return c1434bj.m6288a("SELECT noti_buddy_no,noti_inbox_no,noti_sent_time,noti_message,noti_chat_type,noti_msg_type,buddy_name FROM message_notification n LEFT OUTER JOIN (SELECT p.participants_buddy_no AS buddy_no,ifnull (b.buddy_name, p.participants_buddy_name)  AS buddy_name, p.participants_inbox_no FROM participant p LEFT OUTER JOIN (SELECT buddy_no,buddy_name FROM buddy UNION ALL SELECT buddy_no AS buddy_no,buddy_name AS buddy_name FROM specialbuddy) b ON p.participants_buddy_no=b.buddy_no) j ON n.noti_inbox_no=j.participants_inbox_no AND n.noti_buddy_no=j.buddy_no ORDER BY n.noti_sent_time DESC;");
            case 4000:
                return c1434bj.m6288a("participant_mapping");
            default:
                return c1434bj;
        }
    }

    /* renamed from: a */
    private long m8089a(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        try {
            return sQLiteDatabase.insertOrThrow("cover_story_sample", null, contentValues);
        } catch (SQLiteConstraintException e) {
            if (!contentValues.containsKey("coverstory_id")) {
                return 0L;
            }
            return sQLiteDatabase.update("cover_story_sample", contentValues, "coverstory_id=?", new String[]{contentValues.getAsString("coverstory_id")});
        }
    }

    /* renamed from: b */
    private long m8095b(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        try {
            return sQLiteDatabase.insertOrThrow("buddy", null, contentValues);
        } catch (SQLiteConstraintException e) {
            if (!contentValues.containsKey("buddy_no")) {
                return 0L;
            }
            return sQLiteDatabase.update("buddy", contentValues, "buddy_no=?", new String[]{contentValues.getAsString("buddy_no")});
        }
    }

    /* renamed from: c */
    private long m8100c(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        try {
            return sQLiteDatabase.insertOrThrow("specialbuddy", null, contentValues);
        } catch (SQLiteConstraintException e) {
            if (!contentValues.containsKey("buddy_no")) {
                return 0L;
            }
            return sQLiteDatabase.update("specialbuddy", contentValues, "buddy_no=?", new String[]{contentValues.getAsString("buddy_no")});
        }
    }

    /* renamed from: d */
    private long m8101d(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        try {
            return sQLiteDatabase.insertOrThrow("recommendee", null, contentValues);
        } catch (SQLiteConstraintException e) {
            if (!contentValues.containsKey("buddy_no")) {
                return 0L;
            }
            return sQLiteDatabase.update("recommendee", contentValues, "buddy_no=?", new String[]{contentValues.getAsString("buddy_no")});
        }
    }

    @Deprecated
    /* renamed from: e */
    private long m8102e(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        C3250y.m11456e("memoSessionInsertOrUpdatert", "ChatONProvider");
        String[] strArr = {contentValues.getAsString("buddy_no")};
        try {
            return sQLiteDatabase.insertOrThrow("memo_sessions", null, contentValues);
        } catch (SQLiteConstraintException e) {
            if (!contentValues.containsKey("buddy_no")) {
                return 0L;
            }
            return sQLiteDatabase.update("memo_sessions", contentValues, "buddy_no=?", strArr);
        }
    }

    /* renamed from: f */
    private long m8103f(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) throws Throwable {
        Cursor cursorQuery;
        sQLiteDatabase.beginTransaction();
        try {
            if (EnumC1450r.ONETOONE.m6342a() == contentValues.getAsInteger("inbox_chat_type").intValue()) {
                String asString = contentValues.getAsString("buddy_no");
                cursorQuery = sQLiteDatabase.query("inbox_buddy_relation", null, "buddy_no = ?", new String[]{asString}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.getCount() > 0) {
                            cursorQuery.moveToFirst();
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_no"));
                            if (!string.equals(contentValues.getAsString("inbox_no"))) {
                                ContentValues contentValues2 = new ContentValues();
                                contentValues2.put("inbox_valid", "N");
                                contentValues2.put("inbox_title_fixed", "Y");
                                sQLiteDatabase.update("inbox", contentValues2, "inbox_no = ?", new String[]{string});
                                sQLiteDatabase.delete("inbox_buddy_relation", "buddy_no = ?", new String[]{asString});
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        sQLiteDatabase.endTransaction();
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        throw th;
                    }
                }
                m8091a(sQLiteDatabase, contentValues.getAsString("inbox_no"), asString, EnumC1450r.m6339a(contentValues.getAsInteger("inbox_chat_type").intValue()));
                contentValues.remove("buddy_no");
            } else {
                cursorQuery = null;
            }
            long jInsertOrThrow = sQLiteDatabase.insertOrThrow("inbox", null, contentValues);
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return jInsertOrThrow;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    /* renamed from: g */
    private int m8104g(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) throws Throwable {
        Cursor cursor;
        Cursor cursorQuery;
        int iUpdate = 0;
        sQLiteDatabase.beginTransaction();
        try {
            String asString = contentValues.getAsString("buddy_no");
            Cursor cursorQuery2 = sQLiteDatabase.query("inbox_buddy_relation", null, "buddy_no = ?", new String[]{asString}, null, null, null);
            if (cursorQuery2 != null) {
                try {
                    if (cursorQuery2.getCount() > 0) {
                        cursorQuery2.moveToFirst();
                        String string = cursorQuery2.getString(cursorQuery2.getColumnIndex("inbox_no"));
                        if (!TextUtils.isEmpty(string) && (cursorQuery = sQLiteDatabase.query("inbox", new String[]{"inbox_valid"}, "inbox_no = ?", new String[]{asString}, null, null, null)) != null && cursorQuery.getCount() > 0) {
                            cursorQuery.moveToFirst();
                            if ("N".equals(cursorQuery.getString(0))) {
                                sQLiteDatabase.endTransaction();
                                if (cursorQuery2 != null) {
                                    cursorQuery2.close();
                                }
                                return 0;
                            }
                        }
                        sQLiteDatabase.delete("inbox_buddy_relation", "buddy_no = ?", new String[]{asString});
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("inbox_valid", "N");
                        contentValues2.put("inbox_title_fixed", "Y");
                        iUpdate = sQLiteDatabase.update("inbox", contentValues2, "inbox_no = ?", new String[]{string});
                        long jLongValue = contentValues.getAsLong("message_time").longValue();
                        ContentValues contentValues3 = new ContentValues();
                        contentValues3.put("_id", Long.valueOf(C3193bh.m11148a()));
                        contentValues3.put("message_inbox_no", string);
                        contentValues3.put("message_type", (Integer) 1);
                        contentValues3.put("message_content_type", Integer.valueOf(EnumC1455w.SYSTEM.m6364a()));
                        if (contentValues.getAsBoolean("KEY_DEACTIVATED").booleanValue()) {
                            contentValues3.put("message_content", String.format("%d,%s,%s", Integer.valueOf(EnumC1391ai.DEACTIVATED.m6248a()), asString, "deactivated"));
                            ContentValues contentValues4 = new ContentValues();
                            contentValues4.put("message_read_status", (Integer) 0);
                            contentValues4.put("message_sender", C3159aa.m10962a().m10979a("chaton_id", ""));
                            sQLiteDatabase.update("message", contentValues4, "message_inbox_no = ?", new String[]{string});
                            ContentValues contentValues5 = new ContentValues();
                            contentValues5.put("message_type", (Integer) 1);
                            iUpdate = sQLiteDatabase.update("message", contentValues5, "message_inbox_no = ? AND message_type = 2", new String[]{string});
                        } else {
                            contentValues3.put("message_content", String.format("%d,%s,%s", Integer.valueOf(EnumC1391ai.INVALID_USER.m6248a()), asString, C1075eq.m5318a(contentValues.getAsString("buddy_name"))));
                        }
                        contentValues3.put("message_time", Long.valueOf(jLongValue));
                        contentValues3.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(jLongValue)));
                        sQLiteDatabase.insertOrThrow("message", null, contentValues3);
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery2;
                    sQLiteDatabase.endTransaction();
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            int i = iUpdate;
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
            if (cursorQuery2 == null) {
                return i;
            }
            cursorQuery2.close();
            return i;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    /* renamed from: h */
    private long m8105h(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        sQLiteDatabase.beginTransaction();
        try {
            long jInsertOrThrow = sQLiteDatabase.insertOrThrow("message", null, contentValues);
            System.currentTimeMillis();
            String asString = contentValues.getAsString("message_inbox_no");
            int iIntValue = contentValues.getAsInteger("message_content_type").intValue();
            String asString2 = contentValues.getAsString("message_sender");
            int iIntValue2 = contentValues.getAsInteger("message_read_status").intValue();
            long jLongValue = contentValues.getAsLong("message_time").longValue();
            String str = String.format("%d;%d;%s;%s", 1, Integer.valueOf(iIntValue), C1075eq.m5318a(contentValues.getAsString("message_content")), "");
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("inbox_last_msg_sender", asString2);
            contentValues2.put("inbox_last_message", str);
            contentValues2.put("inbox_last_time", Long.valueOf(jLongValue));
            contentValues2.put("inbox_participants", Integer.valueOf(iIntValue2));
            sQLiteDatabase.update("inbox", contentValues2, "inbox_no=?", new String[]{asString});
            sQLiteDatabase.setTransactionSuccessful();
            return jInsertOrThrow;
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x016b A[Catch: all -> 0x0161, TRY_ENTER, TryCatch #0 {all -> 0x0161, blocks: (B:5:0x0044, B:7:0x004a, B:9:0x005f, B:11:0x0067, B:21:0x00c3, B:13:0x0075, B:15:0x0082, B:17:0x0090, B:18:0x00a6, B:20:0x00c1, B:26:0x00cf, B:28:0x0103, B:29:0x010e, B:31:0x0121, B:32:0x012c, B:34:0x0134, B:35:0x013f, B:37:0x0147, B:43:0x0155, B:50:0x016b, B:52:0x0178), top: B:57:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x017f  */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.sec.chaton.provider.EnumC2040c m8106i(android.database.sqlite.SQLiteDatabase r14, android.content.ContentValues r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 386
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.ChatONProvider.m8106i(android.database.sqlite.SQLiteDatabase, android.content.ContentValues):com.sec.chaton.provider.c");
    }

    /* renamed from: a */
    private long m8090a(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("participants_inbox_no", str);
        contentValues.put("participants_buddy_no", str2);
        contentValues.put("participants_buddy_name", GlobalApplication.m6451b().getString(R.string.unknown));
        return sQLiteDatabase.insertOrThrow("participant", null, contentValues);
    }

    /* renamed from: a */
    private long m8091a(SQLiteDatabase sQLiteDatabase, String str, String str2, EnumC1450r enumC1450r) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_no", str);
        contentValues.put("buddy_no", str2);
        contentValues.put("chat_type", Integer.valueOf(enumC1450r.m6342a()));
        return sQLiteDatabase.insertOrThrow("inbox_buddy_relation", null, contentValues);
    }

    /* renamed from: b */
    private void m8098b(SQLiteDatabase sQLiteDatabase, String str, String str2, EnumC1450r enumC1450r) throws SQLException {
        String strM11137a = C3189bd.m11137a();
        if (!TextUtils.isEmpty(str)) {
            m8091a(sQLiteDatabase, strM11137a, str, enumC1450r);
            m8090a(sQLiteDatabase, strM11137a, str);
        }
        String strM5993b = (TextUtils.isEmpty(str) || !str.startsWith("0999")) ? null : C1357af.m5993b(getContext(), str);
        if (str != null && strM5993b != null) {
            C3250y.m11450b("spbd weburl, insertRelationInboxBuddyAndInbox(), " + str.toString() + "/" + strM5993b.toString(), getClass().getSimpleName());
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_no", strM11137a);
        contentValues.put("inbox_chat_type", Integer.valueOf(enumC1450r.m6342a()));
        contentValues.put("inbox_last_chat_type", (Integer) 12);
        if (!TextUtils.isEmpty(str2)) {
            contentValues.put("inbox_session_id", str2);
        }
        if (!TextUtils.isEmpty(strM5993b)) {
            contentValues.put("inbox_web_url", strM5993b);
        }
        sQLiteDatabase.insertOrThrow("inbox", null, contentValues);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x01ac  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.database.Cursor m8092a(android.database.sqlite.SQLiteDatabase r17, com.sec.chaton.p027e.C1434bj r18, java.lang.String[] r19, java.lang.String r20, java.lang.String[] r21, java.lang.String r22) {
        /*
            Method dump skipped, instructions count: 431
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.ChatONProvider.m8092a(android.database.sqlite.SQLiteDatabase, com.sec.chaton.e.bj, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor");
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00bd  */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int m8107j(android.database.sqlite.SQLiteDatabase r10, android.content.ContentValues r11) throws java.lang.Throwable {
        /*
            r9 = this;
            r2 = 0
            r0 = 1
            r1 = 0
            r10.beginTransaction()
            if (r11 == 0) goto Lbd
            java.lang.String r3 = "message_sever_id"
            boolean r3 = r11.containsKey(r3)     // Catch: java.lang.Throwable -> Lb7
            if (r3 == 0) goto Lbd
            java.lang.String r3 = "message_sever_id"
            java.lang.String r3 = r11.getAsString(r3)     // Catch: java.lang.Throwable -> Lb7
            r5 = r3
        L17:
            if (r11 == 0) goto Lba
            java.lang.String r3 = "count"
            boolean r3 = r11.containsKey(r3)     // Catch: java.lang.Throwable -> Lb7
            if (r3 == 0) goto Lba
            java.lang.String r3 = "count"
            java.lang.Integer r3 = r11.getAsInteger(r3)     // Catch: java.lang.Throwable -> Lb7
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> Lb7
            r4 = r3
        L2c:
            boolean r3 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> Lb7
            if (r3 != 0) goto L34
            if (r4 > 0) goto L41
        L34:
            r10.setTransactionSuccessful()     // Catch: java.lang.Throwable -> Lb7
            r10.endTransaction()
            if (r2 == 0) goto L3f
            r2.close()
        L3f:
            r0 = r1
        L40:
            return r0
        L41:
            java.lang.String r1 = "SELECT inbox_no, inbox_chat_type FROM inbox WHERE inbox_no = (SELECT message_inbox_no FROM message WHERE message_sever_id = ?)"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> Lb7
            r6 = 0
            r3[r6] = r5     // Catch: java.lang.Throwable -> Lb7
            android.database.Cursor r1 = r10.rawQuery(r1, r3)     // Catch: java.lang.Throwable -> Lb7
            java.lang.String r3 = ""
            com.sec.chaton.e.r r2 = com.sec.chaton.p027e.EnumC1450r.UNKNOWN     // Catch: java.lang.Throwable -> Lad
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch: java.lang.Throwable -> Lad
            if (r1 == 0) goto L6e
            int r6 = r1.getCount()     // Catch: java.lang.Throwable -> Lad
            if (r6 <= 0) goto L6e
            r1.moveToFirst()     // Catch: java.lang.Throwable -> Lad
            r2 = 0
            java.lang.String r3 = r1.getString(r2)     // Catch: java.lang.Throwable -> Lad
            r2 = 1
            int r2 = r1.getInt(r2)     // Catch: java.lang.Throwable -> Lad
            com.sec.chaton.e.r r2 = com.sec.chaton.p027e.EnumC1450r.m6339a(r2)     // Catch: java.lang.Throwable -> Lad
        L6e:
            com.sec.chaton.e.r r6 = com.sec.chaton.p027e.EnumC1450r.ONETOONE     // Catch: java.lang.Throwable -> Lad
            if (r2 != r6) goto L9b
            java.lang.String r2 = com.sec.chaton.p027e.InterfaceC1433bi.f5358b     // Catch: java.lang.Throwable -> Lad
            r4 = 3
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> Lad
            r6 = 0
            r4[r6] = r3     // Catch: java.lang.Throwable -> Lad
            r3 = 1
            com.sec.chaton.util.ab r6 = com.sec.chaton.util.C3159aa.m10962a()     // Catch: java.lang.Throwable -> Lad
            java.lang.String r7 = "chaton_id"
            java.lang.String r8 = ""
            java.lang.String r6 = r6.m10979a(r7, r8)     // Catch: java.lang.Throwable -> Lad
            r4[r3] = r6     // Catch: java.lang.Throwable -> Lad
            r3 = 2
            r4[r3] = r5     // Catch: java.lang.Throwable -> Lad
            r10.execSQL(r2, r4)     // Catch: java.lang.Throwable -> Lad
        L8f:
            r10.setTransactionSuccessful()     // Catch: java.lang.Throwable -> Lad
            r10.endTransaction()
            if (r1 == 0) goto L40
            r1.close()
            goto L40
        L9b:
            java.lang.String r2 = com.sec.chaton.p027e.InterfaceC1433bi.f5357a     // Catch: java.lang.Throwable -> Lad
            r3 = 3
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> Lad
            r6 = 0
            r3[r6] = r4     // Catch: java.lang.Throwable -> Lad
            r6 = 1
            r3[r6] = r4     // Catch: java.lang.Throwable -> Lad
            r4 = 2
            r3[r4] = r5     // Catch: java.lang.Throwable -> Lad
            r10.execSQL(r2, r3)     // Catch: java.lang.Throwable -> Lad
            goto L8f
        Lad:
            r0 = move-exception
        Lae:
            r10.endTransaction()
            if (r1 == 0) goto Lb6
            r1.close()
        Lb6:
            throw r0
        Lb7:
            r0 = move-exception
            r1 = r2
            goto Lae
        Lba:
            r4 = r1
            goto L2c
        Lbd:
            r5 = r2
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.ChatONProvider.m8107j(android.database.sqlite.SQLiteDatabase, android.content.ContentValues):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007c  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int m8088a(android.database.sqlite.SQLiteDatabase r11, android.content.ContentValues r12, java.lang.String r13, java.lang.String[] r14) throws java.lang.Throwable {
        /*
            r10 = this;
            r9 = 0
            r8 = 0
            r11.beginTransaction()
            java.lang.String r1 = "inbox"
            r0 = 2
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L6f
            r0 = 0
            java.lang.String r3 = "inbox_last_time"
            r2[r0] = r3     // Catch: java.lang.Throwable -> L6f
            r0 = 1
            java.lang.String r3 = "inbox_unread_count"
            r2[r0] = r3     // Catch: java.lang.Throwable -> L6f
            r5 = 0
            r6 = 0
            r7 = 0
            r0 = r11
            r3 = r13
            r4 = r14
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L6f
            if (r1 == 0) goto L7c
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L7a
            if (r0 <= 0) goto L7c
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L7a
            r0 = 0
            long r2 = r1.getLong(r0)     // Catch: java.lang.Throwable -> L7a
            java.lang.String r0 = "inbox_last_time"
            java.lang.Long r0 = r12.getAsLong(r0)     // Catch: java.lang.Throwable -> L7a
            long r4 = r0.longValue()     // Catch: java.lang.Throwable -> L7a
            android.content.ContentValues r0 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L7a
            r0.<init>()     // Catch: java.lang.Throwable -> L7a
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L44
            r0.putAll(r12)     // Catch: java.lang.Throwable -> L7a
        L44:
            r2 = 1
            int r2 = r1.getInt(r2)     // Catch: java.lang.Throwable -> L7a
            java.lang.String r3 = "inbox_unread_count"
            java.lang.Integer r3 = r12.getAsInteger(r3)     // Catch: java.lang.Throwable -> L7a
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> L7a
            int r2 = r2 + r3
            java.lang.String r3 = "inbox_unread_count"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L7a
            r0.put(r3, r2)     // Catch: java.lang.Throwable -> L7a
            java.lang.String r2 = "inbox"
            int r0 = r11.update(r2, r0, r13, r14)     // Catch: java.lang.Throwable -> L7a
        L63:
            r11.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L7a
            r11.endTransaction()
            if (r1 == 0) goto L6e
            r1.close()
        L6e:
            return r0
        L6f:
            r0 = move-exception
            r1 = r8
        L71:
            r11.endTransaction()
            if (r1 == 0) goto L79
            r1.close()
        L79:
            throw r0
        L7a:
            r0 = move-exception
            goto L71
        L7c:
            r0 = r9
            goto L63
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.ChatONProvider.m8088a(android.database.sqlite.SQLiteDatabase, android.content.ContentValues, java.lang.String, java.lang.String[]):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004b  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int m8094b(android.database.sqlite.SQLiteDatabase r11, android.content.ContentValues r12, java.lang.String r13, java.lang.String[] r14) throws java.lang.Throwable {
        /*
            r10 = this;
            r8 = 0
            r11.beginTransaction()
            r9 = -10
            java.lang.String r1 = "inbox"
            r0 = 1
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L3e
            r0 = 0
            java.lang.String r3 = "inbox_unread_count"
            r2[r0] = r3     // Catch: java.lang.Throwable -> L3e
            r5 = 0
            r6 = 0
            r7 = 0
            r0 = r11
            r3 = r13
            r4 = r14
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L3e
            if (r1 == 0) goto L4b
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L49
            if (r0 <= 0) goto L4b
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L49
            r0 = 0
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L49
            if (r0 <= 0) goto L4b
            java.lang.String r0 = "inbox"
            int r0 = r11.update(r0, r12, r13, r14)     // Catch: java.lang.Throwable -> L49
        L32:
            r11.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L49
            r11.endTransaction()
            if (r1 == 0) goto L3d
            r1.close()
        L3d:
            return r0
        L3e:
            r0 = move-exception
            r1 = r8
        L40:
            r11.endTransaction()
            if (r1 == 0) goto L48
            r1.close()
        L48:
            throw r0
        L49:
            r0 = move-exception
            goto L40
        L4b:
            r0 = r9
            goto L32
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.ChatONProvider.m8094b(android.database.sqlite.SQLiteDatabase, android.content.ContentValues, java.lang.String, java.lang.String[]):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0083  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int m8099c(android.database.sqlite.SQLiteDatabase r11, android.content.ContentValues r12, java.lang.String r13, java.lang.String[] r14) throws java.lang.Throwable {
        /*
            r10 = this;
            r8 = 0
            r11.beginTransaction()
            r9 = -10
            java.lang.String r1 = "inbox"
            r0 = 1
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L76
            r0 = 0
            java.lang.String r3 = "inbox_unread_count"
            r2[r0] = r3     // Catch: java.lang.Throwable -> L76
            r5 = 0
            r6 = 0
            r7 = 0
            r0 = r11
            r3 = r13
            r4 = r14
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L76
            if (r1 == 0) goto L83
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L81
            if (r0 <= 0) goto L83
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L81
            r0 = 0
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L81
            java.lang.String r2 = "inbox_unread_count"
            java.lang.Integer r2 = r12.getAsInteger(r2)     // Catch: java.lang.Throwable -> L81
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> L81
            boolean r3 = com.sec.chaton.util.C3250y.f11735c     // Catch: java.lang.Throwable -> L81
            if (r3 == 0) goto L5a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L81
            r3.<init>()     // Catch: java.lang.Throwable -> L81
            java.lang.String r4 = "updateChatRoomWithCurrentUnreadCount - current unread count :"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L81
            java.lang.StringBuilder r3 = r3.append(r0)     // Catch: java.lang.Throwable -> L81
            java.lang.String r4 = ", added unread count : "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L81
            java.lang.StringBuilder r3 = r3.append(r2)     // Catch: java.lang.Throwable -> L81
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L81
            java.lang.String r4 = "ChatONProvider"
            com.sec.chaton.util.C3250y.m11453c(r3, r4)     // Catch: java.lang.Throwable -> L81
        L5a:
            java.lang.String r3 = "inbox_unread_count"
            int r0 = r0 + r2
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L81
            r12.put(r3, r0)     // Catch: java.lang.Throwable -> L81
            java.lang.String r0 = "inbox"
            int r0 = r11.update(r0, r12, r13, r14)     // Catch: java.lang.Throwable -> L81
        L6a:
            r11.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L81
            r11.endTransaction()
            if (r1 == 0) goto L75
            r1.close()
        L75:
            return r0
        L76:
            r0 = move-exception
            r1 = r8
        L78:
            r11.endTransaction()
            if (r1 == 0) goto L80
            r1.close()
        L80:
            throw r0
        L81:
            r0 = move-exception
            goto L78
        L83:
            r0 = r9
            goto L6a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.ChatONProvider.m8099c(android.database.sqlite.SQLiteDatabase, android.content.ContentValues, java.lang.String, java.lang.String[]):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0038 A[Catch: all -> 0x012f, TRY_ENTER, TryCatch #0 {all -> 0x012f, blocks: (B:5:0x0020, B:8:0x0027, B:15:0x0038, B:18:0x0060, B:21:0x0067, B:23:0x006a, B:24:0x0072, B:26:0x0097, B:28:0x009d), top: B:43:0x0020 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int m8087a(android.database.sqlite.SQLiteDatabase r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.ChatONProvider.m8087a(android.database.sqlite.SQLiteDatabase):int");
    }
}
