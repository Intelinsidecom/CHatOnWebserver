package com.sec.chaton.provider;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.OperationApplicationException;
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
import com.sec.amsoma.AMSLibs;
import com.sec.chaton.access_token.C0231a;
import com.sec.chaton.chat.C0520a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C0620a;
import com.sec.chaton.p025d.C0653f;
import com.sec.chaton.p025d.C0654g;
import com.sec.chaton.p025d.C0656i;
import com.sec.chaton.p025d.C0657j;
import com.sec.chaton.p025d.C0658k;
import com.sec.chaton.p025d.C0659l;
import com.sec.chaton.p025d.C0661n;
import com.sec.chaton.p025d.C0662o;
import com.sec.chaton.p025d.C0666s;
import com.sec.chaton.p025d.C0667t;
import com.sec.chaton.p025d.C0668u;
import com.sec.chaton.p025d.C0670w;
import com.sec.chaton.p025d.C0671x;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.p025d.InterfaceC0637b;
import com.sec.chaton.p025d.InterfaceC0652e;
import com.sec.chaton.p025d.InterfaceC0655h;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1348w;
import com.sec.chaton.util.C1351z;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ChatONProvider extends ContentProvider {

    /* renamed from: b */
    private static final UriMatcher f2937b = m3423b();

    /* renamed from: a */
    private final ThreadLocal f2938a = new ThreadLocal();

    /* renamed from: a */
    private boolean m3421a() {
        return (this.f2938a == null || this.f2938a.get() == null || !((Boolean) this.f2938a.get()).booleanValue()) ? false : true;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        switch (f2937b.match(uri)) {
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
            case 200:
                return "vnd.chaton.cursor.dir/vnd.chaton.group";
            case 201:
                return "vnd.chaton.cursor.item/vnd.chaton.group";
            case 203:
                return "vnd.chaton.cursor.dir/vnd.chaton.group";
            case 300:
                return "vnd.chaton.cursor.dir/vnd.chaton.contacts";
            case 301:
                return "vnd.chaton.cursor.item/vnd.chaton.contacts";
            case 302:
                return "vnd.chaton.cursor.dir/vnd.chaton.contacts";
            case AMSLibs.ENUM_VIP_AMS_SAVE_THUMBNAIL_IMAGE_SIZE /* 400 */:
                return "vnd.chaton.cursor.dir/vnd.chaton.inbox";
            case 401:
                return "vnd.chaton.cursor.item/vnd.chaton.inbox";
            case 402:
                return "vnd.chaton.cursor.dir/vnd.chaton.inbox";
            case 404:
                return "vnd.chaton.cursor.dir/vnd.chaton.inbox";
            case 461:
                return "vnd.chaton.cursor.dir/vnd.chaton.inboxbuddyrelation";
            case 500:
                return "vnd.chaton.cursor.dir/vnd.chaton.message";
            case 501:
                return "vnd.chaton.cursor.item/vnd.chaton.message";
            case 502:
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
            case 1000:
                return "vnd.chaton.cursor.dir/vnd.chaton.recommendee";
            case 1100:
                return "vnd.chaton.cursor.item/vnd.chaton.buddy";
            case 1300:
                return "com.sec.chaton.provider/buddyextrainfo";
            default:
                throw new UnsupportedOperationException("UnKonwn Uri : " + uri);
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        C0656i.m2982a(getContext());
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x059b  */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.database.Cursor query(android.net.Uri r15, java.lang.String[] r16, java.lang.String r17, java.lang.String[] r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 1480
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.ChatONProvider.query(android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor");
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        Uri uriM3431a;
        String str;
        String simpleName;
        long jInsertOrThrow = 1;
        Uri uriM2991a = ContactsContract.AUTHORITY_URI;
        try {
            try {
                try {
                    try {
                        try {
                            int iMatch = f2937b.match(uri);
                            SQLiteDatabase writableDatabase = C0656i.m2982a(getContext()).getWritableDatabase();
                            ArrayList arrayList = new ArrayList();
                            switch (iMatch) {
                                case 100:
                                    jInsertOrThrow = m3417a(writableDatabase, contentValues);
                                    uriM2991a = C0667t.f2310a;
                                    arrayList.add(uriM2991a);
                                    break;
                                case 200:
                                    jInsertOrThrow = writableDatabase.insertOrThrow("buddy_group", null, contentValues);
                                    uriM2991a = C0661n.f2288a;
                                    arrayList.add(uriM2991a);
                                    break;
                                case 300:
                                    jInsertOrThrow = writableDatabase.insertOrThrow("contacts", null, contentValues);
                                    uriM2991a = C0657j.m2987a(String.valueOf(jInsertOrThrow));
                                    arrayList.add(uriM2991a);
                                    break;
                                case AMSLibs.ENUM_VIP_AMS_SAVE_THUMBNAIL_IMAGE_SIZE /* 400 */:
                                    C1341p.m4658b("DB insert : " + uri.toString(), getClass().getSimpleName());
                                    jInsertOrThrow = m3426c(writableDatabase, contentValues);
                                    uriM2991a = C0671x.m3038a(String.valueOf(jInsertOrThrow));
                                    arrayList.add(uriM2991a);
                                    C1341p.m4658b("DB insert end: " + uri.toString(), getClass().getSimpleName());
                                    break;
                                case 461:
                                    jInsertOrThrow = writableDatabase.insertOrThrow("inbox_buddy_relation", null, contentValues);
                                    uriM2991a = C0620a.f2171a;
                                    arrayList.add(uriM2991a);
                                    break;
                                case 500:
                                    C1341p.m4658b("DB insert : " + uri.toString(), getClass().getSimpleName());
                                    if (writableDatabase.insertOrThrow("message", null, contentValues) > 0) {
                                        jInsertOrThrow = contentValues.getAsLong("_id").longValue();
                                        uriM2991a = C0662o.f2289a;
                                        arrayList.add(uriM2991a);
                                    } else {
                                        jInsertOrThrow = -1;
                                    }
                                    C1341p.m4658b("DB insert end: " + uri.toString(), getClass().getSimpleName());
                                    break;
                                case 506:
                                    C1341p.m4658b("DB insert : " + uri.toString(), getClass().getSimpleName());
                                    jInsertOrThrow = m3429f(writableDatabase, contentValues);
                                    uriM2991a = C0662o.f2289a;
                                    arrayList.add(uriM2991a);
                                    C1341p.m4658b("DB insert end: " + uri.toString(), getClass().getSimpleName());
                                    break;
                                case 507:
                                    C1341p.m4658b("DB insert : " + uri.toString(), getClass().getSimpleName());
                                    EnumC0851c enumC0851cM3430g = m3430g(writableDatabase, contentValues);
                                    if (enumC0851cM3430g == EnumC0851c.RESULT_SUCCESS_INSERT) {
                                        uriM2991a = C0662o.m3000b(String.valueOf(contentValues.getAsLong("_id").longValue()));
                                    } else if (enumC0851cM3430g == EnumC0851c.RESULT_SUCCESS_UPDATE) {
                                        uriM2991a = C0662o.f2289a;
                                    }
                                    arrayList.add(C0662o.f2289a);
                                    C1341p.m4658b("DB insert end: " + uri.toString(), getClass().getSimpleName());
                                    break;
                                case 508:
                                    C1341p.m4658b("DB insert : " + uri.toString(), getClass().getSimpleName());
                                    jInsertOrThrow = m3428e(writableDatabase, contentValues);
                                    arrayList.add(C0662o.f2289a);
                                    arrayList.add(C0671x.f2315a);
                                    C1341p.m4658b("DB insert end: " + uri.toString(), getClass().getSimpleName());
                                    break;
                                case 600:
                                    jInsertOrThrow = writableDatabase.insertOrThrow("relation", null, contentValues);
                                    uriM2991a = C0658k.m2991a(String.valueOf(jInsertOrThrow));
                                    arrayList.add(uriM2991a);
                                    break;
                                case 604:
                                    C1341p.m4658b("QUERY : INSERT INTO relation (relation_buddy_id,relation_date,relation_last_msg_time,relation_send,relation_received,relation_point) SELECT buddy_no,date('NOW', 'localtime', '0 DAY'),last_msg_time,ifnull(send,0),ifnull(recevied,0),CASE WHEN (send+recevied) IS NULL THEN 0 ELSE (send + recevied) END FROM (SELECT buddy_no,message_date,last_msg_time,IFNULL(MAX(send),0) AS send,IFNULL(MAX(recevied),0) AS recevied FROM (SELECT buddy_no,message_date,last_msg_time,message_type,(CASE WHEN message_type = 1 THEN MAX(cnt) END) AS send,(CASE WHEN message_type IN (2,5,4,3) THEN MAX(cnt) END) AS recevied FROM (SELECT a.buddy_no AS buddy_no,b.message_type,SUBSTR(b.message_time_text,1,10) AS message_date,MAX(b.message_time_text) AS last_msg_time,COUNT(b.message_inbox_no) AS cnt FROM inbox_buddy_relation a,message b WHERE a.inbox_no = b.message_inbox_no AND b.message_type IN (1,2,5,4,3) AND b.message_time_text BETWEEN date('NOW', 'localtime', '-7 DAY') || '00:00:00' AND date('NOW', 'localtime', '0 DAY') || '99:99:99' GROUP BY message_inbox_no,message_type) a WHERE buddy_no IN (SELECT buddy_no FROM buddy) GROUP BY buddy_no,message_type) GROUP BY buddy_no)", null);
                                    writableDatabase.execSQL("INSERT INTO relation (relation_buddy_id,relation_date,relation_last_msg_time,relation_send,relation_received,relation_point) SELECT buddy_no,date('NOW', 'localtime', '0 DAY'),last_msg_time,ifnull(send,0),ifnull(recevied,0),CASE WHEN (send+recevied) IS NULL THEN 0 ELSE (send + recevied) END FROM (SELECT buddy_no,message_date,last_msg_time,IFNULL(MAX(send),0) AS send,IFNULL(MAX(recevied),0) AS recevied FROM (SELECT buddy_no,message_date,last_msg_time,message_type,(CASE WHEN message_type = 1 THEN MAX(cnt) END) AS send,(CASE WHEN message_type IN (2,5,4,3) THEN MAX(cnt) END) AS recevied FROM (SELECT a.buddy_no AS buddy_no,b.message_type,SUBSTR(b.message_time_text,1,10) AS message_date,MAX(b.message_time_text) AS last_msg_time,COUNT(b.message_inbox_no) AS cnt FROM inbox_buddy_relation a,message b WHERE a.inbox_no = b.message_inbox_no AND b.message_type IN (1,2,5,4,3) AND b.message_time_text BETWEEN date('NOW', 'localtime', '-7 DAY') || '00:00:00' AND date('NOW', 'localtime', '0 DAY') || '99:99:99' GROUP BY message_inbox_no,message_type) a WHERE buddy_no IN (SELECT buddy_no FROM buddy) GROUP BY buddy_no,message_type) GROUP BY buddy_no)");
                                    arrayList.add(uriM2991a);
                                    break;
                                case 700:
                                    jInsertOrThrow = writableDatabase.insertOrThrow("grouprelation", null, contentValues);
                                    uriM2991a = C0668u.m3033a(String.valueOf(jInsertOrThrow));
                                    arrayList.add(uriM2991a);
                                    break;
                                case 800:
                                    jInsertOrThrow = writableDatabase.insertOrThrow("participant", null, contentValues);
                                    uriM2991a = C0654g.f2279a;
                                    arrayList.add(uriM2991a);
                                    break;
                                case 900:
                                    jInsertOrThrow = writableDatabase.insertOrThrow("memo", null, contentValues);
                                    uriM2991a = C0659l.f2286a;
                                    arrayList.add(uriM2991a);
                                    break;
                                case 901:
                                    C1341p.m4662e("MEMO_SESSIONS insert", "ChatONProvider");
                                    jInsertOrThrow = m3422b(writableDatabase, contentValues);
                                    uriM2991a = C0653f.f2278a;
                                    arrayList.add(uriM2991a);
                                    break;
                                case 1000:
                                    C1341p.m4662e("RECOMMENDEE insert", "ChatONProvider");
                                    jInsertOrThrow = writableDatabase.insertOrThrow("recommendee", null, contentValues);
                                    uriM2991a = C0670w.f2314a;
                                    arrayList.add(uriM2991a);
                                    break;
                                default:
                                    arrayList.add(ContactsContract.AUTHORITY_URI);
                                    C1341p.m4661d("Unknown Uri : " + uri.toString(), "ChatONProvider");
                                    jInsertOrThrow = -1;
                                    break;
                            }
                            if (!m3421a() && jInsertOrThrow > -1 && arrayList != null && arrayList.size() > 0) {
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    getContext().getContentResolver().notifyChange((Uri) it.next(), null);
                                }
                            }
                            arrayList.clear();
                            return uriM2991a;
                        } catch (SQLiteConstraintException e) {
                            C1341p.m4653a(e, GlobalApplication.m3100a().getClass().getSimpleName());
                            uriM3431a = C0849a.m3431a(EnumC0850b.CONSTRAINT);
                            if (!C1341p.f4578b) {
                                return uriM3431a;
                            }
                            str = "returnUri : " + uriM3431a.toString();
                            simpleName = GlobalApplication.m3100a().getClass().getSimpleName();
                            C1341p.m4658b(str, simpleName);
                            return uriM3431a;
                        } catch (Exception e2) {
                            C1341p.m4653a(e2, GlobalApplication.m3100a().getClass().getSimpleName());
                            uriM3431a = C0849a.m3431a(EnumC0850b.UNKNOWN);
                            if (!C1341p.f4578b) {
                                return uriM3431a;
                            }
                            str = "returnUri : " + uriM3431a.toString();
                            simpleName = GlobalApplication.m3100a().getClass().getSimpleName();
                            C1341p.m4658b(str, simpleName);
                            return uriM3431a;
                        }
                    } catch (SQLiteDiskIOException e3) {
                        C1341p.m4653a(e3, GlobalApplication.m3100a().getClass().getSimpleName());
                        uriM3431a = C0849a.m3431a(EnumC0850b.DISK_IO);
                        if (!C1341p.f4578b) {
                            return uriM3431a;
                        }
                        str = "returnUri : " + uriM3431a.toString();
                        simpleName = GlobalApplication.m3100a().getClass().getSimpleName();
                        C1341p.m4658b(str, simpleName);
                        return uriM3431a;
                    }
                } catch (SQLiteException e4) {
                    C1341p.m4653a(e4, GlobalApplication.m3100a().getClass().getSimpleName());
                    uriM3431a = C0849a.m3431a(EnumC0850b.NORMAL);
                    if (!C1341p.f4578b) {
                        return uriM3431a;
                    }
                    str = "returnUri : " + uriM3431a.toString();
                    simpleName = GlobalApplication.m3100a().getClass().getSimpleName();
                    C1341p.m4658b(str, simpleName);
                    return uriM3431a;
                }
            } catch (SQLiteFullException e5) {
                C1341p.m4653a(e5, GlobalApplication.m3100a().getClass().getSimpleName());
                uriM3431a = C0849a.m3431a(EnumC0850b.FULL);
                if (!C1341p.f4578b) {
                    return uriM3431a;
                }
                str = "returnUri : " + uriM3431a.toString();
                simpleName = GlobalApplication.m3100a().getClass().getSimpleName();
                C1341p.m4658b(str, simpleName);
                return uriM3431a;
            }
        } finally {
            if (C1341p.f4578b) {
                C1341p.m4658b("returnUri : " + uriM2991a.toString(), GlobalApplication.m3100a().getClass().getSimpleName());
            }
        }
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) throws Throwable {
        int i;
        String str2;
        String simpleName;
        int iMatch;
        SQLiteDatabase writableDatabase;
        ArrayList arrayList;
        int iM3017a = 1;
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                iMatch = f2937b.match(uri);
                writableDatabase = C0656i.m2982a(getContext()).getWritableDatabase();
                arrayList = new ArrayList();
            } catch (SQLiteConstraintException e) {
                e = e;
            } catch (SQLiteDiskIOException e2) {
                e = e2;
            } catch (SQLiteFullException e3) {
                e = e3;
            } catch (SQLiteException e4) {
                e = e4;
            } catch (Exception e5) {
                e = e5;
            }
            try {
                switch (iMatch) {
                    case 405:
                        C1341p.m4658b("DB update : " + uri.toString(), getClass().getSimpleName());
                        iM3017a = m3427d(writableDatabase, contentValues);
                        if (iM3017a > 0) {
                            arrayList.add(C0671x.f2315a);
                            arrayList.add(C0662o.f2289a);
                        }
                        C1341p.m4658b("DB update end : " + uri.toString(), getClass().getSimpleName());
                        break;
                    case 500:
                        C1341p.m4658b("DB update : " + uri.toString(), getClass().getSimpleName());
                        iM3017a = m3424b(uri, iMatch).m3021a(str, strArr).m3017a(writableDatabase, contentValues);
                        if (strArr != null) {
                            C1341p.m4658b("ContentProvider : " + uri.toString() + " : " + strArr[0], getClass().getSimpleName());
                        }
                        C1341p.m4658b("UdateMessage Result : " + String.valueOf(iM3017a), getClass().getSimpleName());
                        arrayList.add(uri);
                        C1341p.m4658b("DB update end : " + uri.toString(), getClass().getSimpleName());
                        break;
                    case 504:
                        writableDatabase.execSQL("UPDATE message SET message_read_status= CASE WHEN message_read_status IS 0 THEN 0  ELSE (message_read_status-1) END WHERE message_sever_id=?", new String[]{C0662o.m3004c(uri)});
                        arrayList.add(uri);
                        break;
                    default:
                        iM3017a = m3424b(uri, iMatch).m3021a(str, strArr).m3017a(writableDatabase, contentValues);
                        arrayList.add(uri);
                        break;
                }
                if (!m3421a() && iM3017a > 0 && arrayList != null && arrayList.size() > 0) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        getContext().getContentResolver().notifyChange((Uri) it.next(), null);
                    }
                }
                arrayList.clear();
                if (C1341p.f4578b) {
                    C1341p.m4658b("returnInteger : " + String.valueOf(iM3017a), GlobalApplication.m3100a().getClass().getSimpleName());
                }
                return iM3017a;
            } catch (SQLiteConstraintException e6) {
                e = e6;
                C1341p.m4653a(e, GlobalApplication.m3100a().getClass().getSimpleName());
                i = -3;
                if (!C1341p.f4578b) {
                    return -3;
                }
                str2 = "returnInteger : " + String.valueOf(-3);
                simpleName = GlobalApplication.m3100a().getClass().getSimpleName();
                C1341p.m4658b(str2, simpleName);
                return i;
            } catch (SQLiteDiskIOException e7) {
                e = e7;
                C1341p.m4653a(e, GlobalApplication.m3100a().getClass().getSimpleName());
                i = -5;
                if (!C1341p.f4578b) {
                    return -5;
                }
                str2 = "returnInteger : " + String.valueOf(-5);
                simpleName = GlobalApplication.m3100a().getClass().getSimpleName();
                C1341p.m4658b(str2, simpleName);
                return i;
            } catch (SQLiteFullException e8) {
                e = e8;
                C1341p.m4653a(e, GlobalApplication.m3100a().getClass().getSimpleName());
                i = -4;
                if (!C1341p.f4578b) {
                    return -4;
                }
                str2 = "returnInteger : " + String.valueOf(-4);
                simpleName = GlobalApplication.m3100a().getClass().getSimpleName();
                C1341p.m4658b(str2, simpleName);
                return i;
            } catch (SQLiteException e9) {
                e = e9;
                C1341p.m4653a(e, GlobalApplication.m3100a().getClass().getSimpleName());
                i = -2;
                if (!C1341p.f4578b) {
                    return -2;
                }
                str2 = "returnInteger : " + String.valueOf(-2);
                simpleName = GlobalApplication.m3100a().getClass().getSimpleName();
                C1341p.m4658b(str2, simpleName);
                return i;
            } catch (Exception e10) {
                e = e10;
                C1341p.m4653a(e, GlobalApplication.m3100a().getClass().getSimpleName());
                if (C1341p.f4578b) {
                    C1341p.m4658b("returnInteger : " + String.valueOf(-1), GlobalApplication.m3100a().getClass().getSimpleName());
                }
                return -1;
            }
        } catch (Throwable th2) {
            th = th2;
            iM3017a = -1;
            if (C1341p.f4578b) {
                C1341p.m4658b("returnInteger : " + String.valueOf(iM3017a), GlobalApplication.m3100a().getClass().getSimpleName());
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01fb  */
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
            Method dump skipped, instructions count: 568
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.ChatONProvider.delete(android.net.Uri, java.lang.String, java.lang.String[]):int");
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList arrayList) {
        SQLiteDatabase writableDatabase = C0656i.m2982a(getContext()).getWritableDatabase();
        HashSet hashSet = new HashSet();
        writableDatabase.beginTransaction();
        int size = arrayList.size();
        try {
            try {
                this.f2938a.set(true);
                ContentProviderResult[] contentProviderResultArr = new ContentProviderResult[size];
                for (int i = 0; i < size; i++) {
                    contentProviderResultArr[i] = ((ContentProviderOperation) arrayList.get(i)).apply(this, contentProviderResultArr, i);
                    hashSet.add(((ContentProviderOperation) arrayList.get(i)).getUri());
                }
                writableDatabase.setTransactionSuccessful();
                return contentProviderResultArr;
            } catch (SQLiteException e) {
                e.printStackTrace();
                throw new OperationApplicationException(e);
            }
        } finally {
            this.f2938a.set(false);
            writableDatabase.endTransaction();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                getContext().getContentResolver().notifyChange((Uri) it.next(), null);
            }
        }
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) {
        int iMatch = f2937b.match(uri);
        if (!C0231a.m886a(getContext(), Binder.getCallingUid())) {
            throw new SecurityException("Access Token is invalid.");
        }
        switch (iMatch) {
            case 102:
                if ("r".equals(str)) {
                    return ParcelFileDescriptor.open(new File(getContext().getFilesDir(), C1348w.m4693b(uri.getLastPathSegment())), 268435456);
                }
            default:
                return null;
        }
    }

    /* renamed from: b */
    private static UriMatcher m3423b() {
        UriMatcher uriMatcher = new UriMatcher(-1);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/buddy_no/*", 102);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/participants_no_same", 108);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/participants", 107);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/profile", 106);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/group", 103);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/alphabetical", 104);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/alphabetical2", 109);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/relation", 105);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy", 100);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy_group/group_info", 203);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy_group/*", 201);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy_group", 200);
        uriMatcher.addURI("com.sec.chaton.provider", "contacts/conatct_number/*", 302);
        uriMatcher.addURI("com.sec.chaton.provider", "contacts/*", 301);
        uriMatcher.addURI("com.sec.chaton.provider", "contacts", 300);
        uriMatcher.addURI("com.sec.chaton.provider", "grouprelation/group_relation_group/*", 711);
        uriMatcher.addURI("com.sec.chaton.provider", "grouprelation/group_relation_buddy/*", 712);
        uriMatcher.addURI("com.sec.chaton.provider", "grouprelation/group", 713);
        uriMatcher.addURI("com.sec.chaton.provider", "grouprelation/buddy_in", 701);
        uriMatcher.addURI("com.sec.chaton.provider", "grouprelation/buddy_not_in", 702);
        uriMatcher.addURI("com.sec.chaton.provider", "grouprelation", 700);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/get_inbox_no", 406);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/inbox_invalid_update", 405);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/group_title_update", 404);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/buddy_participant_join", 403);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/inbox_no", 402);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/*", 401);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox", AMSLibs.ENUM_VIP_AMS_SAVE_THUMBNAIL_IMAGE_SIZE);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox_buddy_relation", 461);
        uriMatcher.addURI("com.sec.chaton.provider", "message/read_ack/*", 504);
        uriMatcher.addURI("com.sec.chaton.provider", "message/message_sever_id/*", 502);
        uriMatcher.addURI("com.sec.chaton.provider", "message/message_buddy", 505);
        uriMatcher.addURI("com.sec.chaton.provider", "message/message_buddy/*", 509);
        uriMatcher.addURI("com.sec.chaton.provider", "message/update", 512);
        uriMatcher.addURI("com.sec.chaton.provider", "message/delete", 511);
        uriMatcher.addURI("com.sec.chaton.provider", "message/count/*", 510);
        uriMatcher.addURI("com.sec.chaton.provider", "message/send", 506);
        uriMatcher.addURI("com.sec.chaton.provider", "message/received", 507);
        uriMatcher.addURI("com.sec.chaton.provider", "message/send/inbox", 508);
        uriMatcher.addURI("com.sec.chaton.provider", "message/*", 501);
        uriMatcher.addURI("com.sec.chaton.provider", "message", 500);
        uriMatcher.addURI("com.sec.chaton.provider", "relation/insert", 604);
        uriMatcher.addURI("com.sec.chaton.provider", "relation/day", 603);
        uriMatcher.addURI("com.sec.chaton.provider", "relation", 600);
        uriMatcher.addURI("com.sec.chaton.provider", "participant/name_join_buddy", 802);
        uriMatcher.addURI("com.sec.chaton.provider", "participant/*", 801);
        uriMatcher.addURI("com.sec.chaton.provider", "participant", 800);
        uriMatcher.addURI("com.sec.chaton.provider", "memo", 900);
        uriMatcher.addURI("com.sec.chaton.provider", "memo_sessions", 901);
        uriMatcher.addURI("com.sec.chaton.provider", "recommendee", 1000);
        uriMatcher.addURI("com.sec.chaton.provider", "me", 1100);
        uriMatcher.addURI("com.sec.chaton.provider", "myextrainfo", 1200);
        uriMatcher.addURI("com.sec.chaton.provider", "buddyextrainfo/#", 1300);
        uriMatcher.addURI("com.sec.chaton.provider", "buddyextrainfoall", 1400);
        return uriMatcher;
    }

    /* renamed from: a */
    private C0666s m3420a(Uri uri, int i) {
        C0666s c0666s = new C0666s();
        switch (i) {
            case 100:
                return c0666s.m3020a("buddy");
            case 102:
                return c0666s.m3020a("buddy").m3021a("buddy_no=?", C0667t.m3027b(uri));
            case 103:
                return c0666s.m3020a(InterfaceC0655h.f2280a);
            case 104:
                return c0666s.m3020a("(SELECT a.*,CASE WHEN b.relation_send IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_send END AS relation_send,CASE WHEN b.relation_received IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_received END AS relation_received,CASE WHEN b.relation_point IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_point END AS relation_point,CASE WHEN b.relation_icon IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_icon END AS relation_icon,CASE WHEN b.relation_increase IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_increase END AS relation_increase,CASE WHEN b.relation_rank IS NULL THEN 9999999 WHEN a.buddy_relation_hide = 'Y' THEN 9999999 ELSE b.relation_rank END AS relation_rank FROM (SELECT 1 AS group_relation_group,'Favorites' AS group_name,1 AS group_type,b.buddy_no,b.buddy_name,b.buddy_status_message,b.buddy_email,b.buddy_samsung_email,b.buddy_orginal_number,b.buddy_relation_hide,b.buddy_birthday,b.buddy_raw_contact_id,b.buddy_push_name,b.buddy_is_new,b.buddy_profile_status,b.buddy_is_profile_updated,b.buddy_show_phone_number,b.buddy_extra_info,b.buddy_is_status_updated FROM ( SELECT group_relation_buddy FROM grouprelation WHERE group_relation_group = 1 ) a JOIN buddy b ON a.group_relation_buddy = b.buddy_no UNION ALL SELECT null AS group_relation_group,null AS group_name,2 AS group_type,buddy_no,buddy_name,buddy_status_message,buddy_email,buddy_samsung_email,buddy_orginal_number,buddy_relation_hide,buddy_birthday,buddy_raw_contact_id,buddy_push_name,buddy_is_new,buddy_profile_status,buddy_is_profile_updated,buddy_show_phone_number,buddy_extra_info,buddy_is_status_updated FROM buddy) a LEFT OUTER JOIN (SELECT * FROM relation WHERE relation_date = date('now','localtime','0 day')) b ON a.buddy_no = b.relation_buddy_id)");
            case 105:
                return c0666s.m3020a("(SELECT b.buddy_no,b.buddy_name,b.buddy_status_message,b.buddy_birthday,b.buddy_email,b.buddy_samsung_email,b.buddy_orginal_number,b.buddy_msg_send,b.buddy_msg_received,b.buddy_relation_hide,b.buddy_raw_contact_id,b.buddy_push_name,b.buddy_is_new,b.buddy_profile_status,b.buddy_is_profile_updated,b.buddy_is_status_updated,b.buddy_show_phone_number,b.buddy_extra_info,CASE WHEN c.relation_send IS NULL THEN 0 WHEN b.buddy_relation_hide = 'Y' THEN 0 ELSE c.relation_send END AS relation_send,CASE WHEN c.relation_received IS NULL THEN 0 WHEN b.buddy_relation_hide = 'Y' THEN 0 ELSE c.relation_received END AS relation_received,CASE WHEN c.relation_point IS NULL THEN 0 WHEN b.buddy_relation_hide = 'Y' THEN 0 ELSE c.relation_point END AS relation_point,CASE WHEN c.relation_icon IS NULL THEN 0 WHEN b.buddy_relation_hide = 'Y' THEN 0 ELSE c.relation_icon END AS relation_icon,CASE WHEN c.relation_increase IS NULL THEN 0 WHEN b.buddy_relation_hide = 'Y' THEN 0 ELSE c.relation_increase END AS relation_increase,CASE WHEN c.relation_rank IS NULL THEN 9999999 WHEN b.buddy_relation_hide = 'Y' THEN 9999999 ELSE c.relation_rank END AS relation_rank,1 AS group_type FROM (SELECT * FROM grouprelation WHERE group_relation_group = 1) a JOIN buddy b ON a.group_relation_buddy = b.buddy_no LEFT OUTER JOIN  ( SELECT * FROM relation WHERE relation_date = DATE('NOW', 'localtime', '0 DAY') ) c  ON a.group_relation_buddy = c.relation_buddy_id WHERE c.relation_date = DATE('NOW', 'localtime', '0 DAY') OR c.relation_date is null) d UNION ALL SELECT * FROM (SELECT a.buddy_no,a.buddy_name,a.buddy_status_message,a.buddy_birthday,a.buddy_email,a.buddy_samsung_email,a.buddy_orginal_number,a.buddy_msg_send,a.buddy_msg_received,a.buddy_relation_hide,a.buddy_raw_contact_id,a.buddy_push_name,a.buddy_is_new,a.buddy_profile_status,a.buddy_is_profile_updated,a.buddy_is_status_updated,a.buddy_show_phone_number,a.buddy_extra_info,CASE WHEN b.relation_send IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_send END AS relation_send,CASE WHEN b.relation_received IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_received END AS relation_received,CASE WHEN b.relation_point IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_point END AS relation_point,CASE WHEN b.relation_icon IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_icon END AS relation_icon,CASE WHEN b.relation_increase IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_increase END AS relation_increase,CASE WHEN b.relation_rank IS NULL THEN 9999999 WHEN a.buddy_relation_hide = 'Y' THEN 9999999 ELSE b.relation_rank END AS relation_rank,2 AS group_type FROM buddy a LEFT OUTER JOIN  ( SELECT * FROM relation WHERE relation_date = DATE('NOW', 'localtime', '0 DAY') ) b  ON a.buddy_no = b.relation_buddy_id WHERE b.relation_date = DATE('NOW', 'localtime', '0 DAY') OR b.relation_date is null)");
            case 106:
                return c0666s.m3020a("(SELECT a.*,CASE WHEN b.group_relation_buddy IS NULL THEN 'N' ELSE 'Y' END AS is_favorite FROM (SELECT b.buddy_no,b.buddy_name,b.buddy_status_message,b.buddy_email,b.buddy_samsung_email,b.buddy_orginal_number,b.buddy_birthday,b.buddy_relation_hide,b.buddy_raw_contact_id,b.buddy_push_name,b.buddy_is_new,b.buddy_profile_status,b.buddy_is_profile_updated,b.buddy_is_status_updated,b.buddy_show_phone_number,b.buddy_extra_info,CASE WHEN c.relation_send IS NULL THEN 0 WHEN b.buddy_relation_hide = 'Y' THEN 0 ELSE c.relation_send END AS relation_send,CASE WHEN c.relation_received IS NULL THEN 0 WHEN b.buddy_relation_hide = 'Y' THEN 0 ELSE c.relation_received END AS relation_received,CASE WHEN c.relation_point IS NULL THEN 0 WHEN b.buddy_relation_hide = 'Y' THEN 0 ELSE c.relation_point END AS relation_point,CASE WHEN c.relation_icon IS NULL THEN 0 WHEN b.buddy_relation_hide = 'Y' THEN 0 ELSE c.relation_icon END AS relation_icon,CASE WHEN c.relation_increase IS NULL THEN 0 WHEN b.buddy_relation_hide = 'Y' THEN 0 ELSE c.relation_increase END AS relation_increase,CASE WHEN c.relation_rank IS NULL THEN 0 WHEN b.buddy_relation_hide = 'Y' THEN 0 ELSE c.relation_rank END AS relation_rank FROM buddy b LEFT OUTER JOIN ( SELECT * FROM relation WHERE relation_date =  '1' ) c ON b.buddy_no = c.relation_buddy_id) a LEFT OUTER JOIN (SELECT group_relation_buddy FROM grouprelation WHERE group_relation_group = 1) b ON a.buddy_no = b.group_relation_buddy)");
            case 107:
                return c0666s.m3020a(InterfaceC0655h.f2281b);
            case 108:
                return c0666s.m3020a("(SELECT buddy_no,buddy_name,buddy_status_message,buddy_profile_status FROM buddy UNION ALL SELECT participants_buddy_no AS buddy_no,MAX(participants_buddy_name) AS buddy_name,'' AS buddy_status_message,'' AS buddy_profile_status FROM participant WHERE participants_buddy_no NOT IN (SELECT buddy_no FROM buddy) GROUP BY participants_buddy_no)");
            case 109:
                return c0666s.m3020a("(SELECT a.*,CASE WHEN b.relation_send IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_send END AS relation_send,CASE WHEN b.relation_received IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_received END AS relation_received,CASE WHEN b.relation_point IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_point END AS relation_point,CASE WHEN b.relation_icon IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_icon END AS relation_icon,CASE WHEN b.relation_increase IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_increase END AS relation_increase,CASE WHEN b.relation_rank IS NULL THEN 9999999 WHEN a.buddy_relation_hide = 'Y' THEN 9999999 ELSE b.relation_rank END AS relation_rank FROM (SELECT b.buddyno_list AS group_relation_group,group_name,group_type,_id AS buddy_no,group_name AS buddy_name,null AS buddy_status_message,b.buddyno_list AS buddy_email,b.buddyname_list AS buddy_samsung_email,null AS buddy_orginal_number,null AS buddy_relation_hide,null AS buddy_birthday,null AS buddy_raw_contact_id,null AS buddy_push_name,group_is_new AS buddy_is_new,null AS buddy_profile_status,null AS buddy_is_profile_updated,1 AS buddy_show_phone_number,null AS buddy_extra_info,null AS buddy_is_status_updated FROM buddy_group a LEFT OUTER JOIN(SELECT group_relation_group,group_concat(group_relation_buddy, '%%' || group_relation_group || '%%') AS buddyno_list,group_concat(buddy_name, '%%' || group_relation_group || '%%') AS buddyname_list FROM (SELECT a.group_relation_group,a.group_relation_buddy,TRIM(b.buddy_name) AS buddy_name FROM grouprelation a,buddy b WHERE a.group_relation_buddy = b.buddy_no AND group_relation_group != 1) GROUP BY group_relation_group) b ON a._id = b.group_relation_group WHERE a.group_type != 1 UNION ALL SELECT 1 AS group_relation_group,'Favorites' AS group_name,1 AS group_type,b.buddy_no,b.buddy_name,b.buddy_status_message,b.buddy_email,b.buddy_samsung_email,b.buddy_orginal_number,b.buddy_relation_hide,b.buddy_birthday,b.buddy_raw_contact_id,b.buddy_push_name,b.buddy_is_new,b.buddy_profile_status,b.buddy_is_profile_updated,buddy_show_phone_number,buddy_extra_info,b.buddy_is_status_updated FROM ( SELECT group_relation_buddy FROM grouprelation WHERE group_relation_group = 1 ) a JOIN buddy b ON a.group_relation_buddy = b.buddy_no UNION ALL SELECT null AS group_relation_group,null AS group_name,2 AS group_type,buddy_no,buddy_name,buddy_status_message,buddy_email,buddy_samsung_email,buddy_orginal_number,buddy_relation_hide,buddy_birthday,buddy_raw_contact_id,buddy_push_name,buddy_is_new,buddy_profile_status,buddy_is_profile_updated,buddy_show_phone_number,buddy_extra_info,buddy_is_status_updated FROM buddy) a LEFT OUTER JOIN (SELECT * FROM relation WHERE relation_date = date('now','localtime','0 day')) b ON a.buddy_no = b.relation_buddy_id)");
            case 200:
                return c0666s.m3020a("buddy_group");
            case 201:
                return c0666s.m3020a("buddy_group").m3021a("_id=?", C0661n.m2993a(uri));
            case 203:
                return c0666s.m3020a("(SELECT a._id,a.group_name,a.group_type,ifnull(b.cnt,0) AS cnt FROM buddy_group a LEFT OUTER JOIN (SELECT group_relation_group,COUNT(*) AS cnt FROM grouprelation GROUP BY group_relation_group HAVING group_relation_group > 1) b ON a._id=b.group_relation_group WHERE a._id != 1)f");
            case 300:
                return c0666s.m3020a("contacts");
            case 301:
                return c0666s.m3020a("contacts").m3021a("_id=?", C0657j.m2988a(uri));
            case 302:
                return c0666s.m3020a("contacts").m3021a("conatct_number=?", C0657j.m2989b(uri));
            case AMSLibs.ENUM_VIP_AMS_SAVE_THUMBNAIL_IMAGE_SIZE /* 400 */:
                return c0666s.m3020a("inbox");
            case 401:
                return c0666s.m3020a("inbox").m3021a("_id=?", C0671x.m3039a(uri));
            case 402:
                return c0666s.m3020a("inbox").m3021a("inbox_no=?", C0671x.m3041b(uri));
            case 403:
                return c0666s.m3020a("(SELECT _id,inbox_no,inbox_chat_type,inbox_last_message,inbox_title,inbox_title_fixed,inbox_last_time,inbox_lang_from,inbox_unread_count,inbox_lang_to,inbox_translated,inbox_server_ip,inbox_server_port,inbox_participants,inbox_session_id,inbox_last_msg_no,inbox_last_msg_sender,inbox_last_temp_msg,inbox_last_chat_type,inbox_is_new,inbox_trunk_unread_count,inbox_valid,buddy_no,inbox_enable_noti,inbox_last_timestamp,buddy_status_message,buddy_name FROM (SELECT * FROM inbox a LEFT OUTER JOIN (SELECT buddy_no,buddy_name,buddy_status_message FROM buddy UNION ALL SELECT participants_buddy_no AS buddy_no,ifnull(MAX(participants_buddy_name),participants_buddy_no) AS buddy_name,'' AS buddy_status_message FROM participant WHERE participants_buddy_no NOT IN (SELECT buddy_no FROM buddy) GROUP BY participants_buddy_no) b ON b.buddy_no = ( SELECT buddy_no FROM inbox_buddy_relation WHERE inbox_no = a.inbox_no ) ))");
            case 404:
                return c0666s.m3020a(InterfaceC0637b.f2216a);
            case 406:
                return c0666s.m3020a("(SELECT _id,inbox_no,inbox_chat_type,inbox_last_message,inbox_title,inbox_title_fixed,inbox_last_time,inbox_lang_from,inbox_unread_count,inbox_lang_to,inbox_translated,inbox_server_ip,inbox_server_port,inbox_participants,inbox_session_id,inbox_last_msg_no,inbox_last_msg_sender,inbox_last_temp_msg,inbox_last_chat_type,inbox_is_new,inbox_trunk_unread_count,inbox_valid,buddy_no,inbox_enable_noti,inbox_last_timestamp,buddy_status_message,buddy_name FROM (SELECT * FROM inbox a LEFT OUTER JOIN (SELECT buddy_no,buddy_name,buddy_status_message FROM buddy UNION ALL SELECT participants_buddy_no AS buddy_no,ifnull(MAX(participants_buddy_name),participants_buddy_no) AS buddy_name,'' AS buddy_status_message FROM participant WHERE participants_buddy_no NOT IN (SELECT buddy_no FROM buddy) GROUP BY participants_buddy_no) b ON b.buddy_no = ( SELECT buddy_no FROM inbox_buddy_relation WHERE inbox_no = a.inbox_no ) ))");
            case 461:
                return c0666s.m3020a("inbox_buddy_relation");
            case 500:
                return c0666s.m3020a("message");
            case 501:
                String strM2997a = C0662o.m2997a(uri);
                return c0666s.m3020a("message").m3021a(strM2997a + "=?", strM2997a);
            case 502:
                String strM3001b = C0662o.m3001b(uri);
                return c0666s.m3020a("message").m3021a(strM3001b + "=?", strM3001b);
            case 505:
                return c0666s.m3020a(InterfaceC0652e.f2275a);
            case 511:
                return c0666s.m3020a("message");
            case 600:
                return c0666s.m3020a("relation");
            case 603:
                return c0666s.m3020a("(SELECT b.relation_date,a.buddy_no,a.buddy_name,a.buddy_status_message,a.buddy_email,a.buddy_samsung_email,a.buddy_orginal_number,a.buddy_msg_send,a.buddy_msg_received,a.buddy_relation_hide,IFNULL(b.relation_send,0) AS relation_send,IFNULL(b.relation_received,0) AS relation_received,IFNULL(b.relation_point,0) AS relation_point,IFNULL(b.relation_icon,6) AS relation_icon,IFNULL(b.relation_increase,0) AS relation_increase,IFNULL(b.relation_rank,9999999) AS relation_rank,IFNULL(a.buddy_profile_status,0) AS buddy_profile_status,IFNULL(b.relation_last_msg_time,DATETIME('NOW', 'localtime')) AS relation_last_msg_time,2 AS group_type FROM buddy a JOIN relation b ON a.buddy_no = b.relation_buddy_id)");
            case 700:
                return c0666s.m3020a("grouprelation");
            case 701:
                return c0666s.m3020a("(SELECT b.buddy_no,b.buddy_name,b.buddy_status_message,b.buddy_email,b.buddy_samsung_email,b.buddy_orginal_number,b.buddy_msg_send,b.buddy_msg_received,b.buddy_relation_hide,b.buddy_birthday,b.buddy_raw_contact_id,b.buddy_push_name,b.buddy_is_new,b.buddy_profile_status,b.buddy_is_profile_updated,b.buddy_is_status_updated,b.buddy_show_phone_number,b.buddy_extra_info,a.group_relation_group FROM grouprelation a JOIN buddy b ON a.group_relation_buddy = b.buddy_no)");
            case 702:
                return c0666s.m3020a("(SELECT * FROM (SELECT * FROM (SELECT buddy_no,buddy_name,buddy_status_message,buddy_email,buddy_samsung_email,buddy_orginal_number,buddy_relation_hide,buddy_birthday,buddy_raw_contact_id,buddy_push_name,buddy_is_new,buddy_profile_status,buddy_is_profile_updated,buddy_is_status_updated,ifnull(b.group_relation_group,9999) AS group_relation_group,ifnull(c.group_type,3) AS group_type FROM buddy a LEFT OUTER JOIN grouprelation b ON a.buddy_no=b.group_relation_buddy LEFT OUTER JOIN buddy_group c ON b.group_relation_group=c._id) GROUP BY buddy_no))");
            case 711:
                return c0666s.m3020a("grouprelation").m3021a("group_relation_group=?", C0668u.m3035b(uri));
            case 712:
                return c0666s.m3020a("grouprelation").m3021a("group_relation_buddy=?", C0668u.m3034a(uri));
            case 713:
                return c0666s.m3020a("(SELECT a._id,a.group_name,c.* FROM buddy_group a LEFT OUTER JOIN grouprelation b ON a._id = b.group_relation_group LEFT OUTER JOIN buddy c ON b.group_relation_buddy = c.buddy_no)");
            case 800:
                return c0666s.m3020a("(SELECT ifnull(b.buddy_no,c.participants_buddy_no) AS buddy_no,ifnull(b.buddy_status_message,'') AS buddy_status_message,ifnull(b.buddy_name,c.participants_buddy_name) AS buddy_name,c.participants_inbox_no AS participants_inbox_no,c.participants_buddy_no AS participants_buddy_no,c.rowid AS rowid FROM (SELECT ifnull(participants_buddy_name,'') AS participants_buddy_name,participants_buddy_no,participants_inbox_no,rowid FROM participant) c LEFT OUTER JOIN buddy b ON c.participants_buddy_no = b.buddy_no)");
            case 801:
                return c0666s.m3020a("(SELECT ifnull(b.buddy_no,c.participants_buddy_no) AS buddy_no,ifnull(b.buddy_status_message,'') AS buddy_status_message,ifnull(b.buddy_name,c.participants_buddy_name) AS buddy_name,c.participants_inbox_no AS participants_inbox_no,c.participants_buddy_no AS participants_buddy_no,c.rowid AS rowid FROM (SELECT ifnull(participants_buddy_name,'') AS participants_buddy_name,participants_buddy_no,participants_inbox_no,rowid FROM participant) c LEFT OUTER JOIN buddy b ON c.participants_buddy_no = b.buddy_no)").m3021a("participants_inbox_no=?", C0654g.m2981a(uri));
            case 802:
                return c0666s.m3020a("(SELECT buddy_no,buddy_name,b.participants_inbox_no FROM (SELECT buddy_no,buddy_name FROM buddy UNION ALL SELECT participants_buddy_no AS buddy_no,MAX(participants_buddy_name) AS buddy_name FROM participant WHERE participants_buddy_no NOT IN (SELECT buddy_no FROM buddy) GROUP BY participants_buddy_no) a LEFT OUTER JOIN participant b ON b.participants_buddy_no=buddy_no)");
            case 900:
                return c0666s.m3020a("memo");
            case 901:
                return c0666s.m3020a("memo_sessions");
            case 1000:
                return c0666s.m3020a("recommendee");
            case 1300:
            case 1400:
                return c0666s.m3020a("(SELECT buddy_no,buddy_orginal_number,buddy_extra_info FROM buddy)");
            default:
                return null;
        }
    }

    /* renamed from: b */
    private C0666s m3424b(Uri uri, int i) {
        C0666s c0666s = new C0666s();
        switch (i) {
            case 100:
                return c0666s.m3020a("buddy");
            case 102:
                return c0666s.m3020a("buddy").m3021a("buddy_no=?", C0667t.m3027b(uri));
            case 200:
                return c0666s.m3020a("buddy_group");
            case 201:
                return c0666s.m3020a("buddy_group").m3021a("_id=?", C0661n.m2993a(uri));
            case 300:
                return c0666s.m3020a("contacts");
            case 301:
                return c0666s.m3020a("contacts").m3021a("_id=?", C0657j.m2988a(uri));
            case 302:
                return c0666s.m3020a("contacts").m3021a("conatct_number=?", C0657j.m2989b(uri));
            case AMSLibs.ENUM_VIP_AMS_SAVE_THUMBNAIL_IMAGE_SIZE /* 400 */:
                return c0666s.m3020a("inbox");
            case 401:
                return c0666s.m3020a("inbox").m3021a("_id=?", C0671x.m3039a(uri));
            case 402:
                return c0666s.m3020a("inbox").m3021a("inbox_no=?", C0671x.m3041b(uri));
            case 461:
                return c0666s.m3020a("inbox_buddy_relation");
            case 500:
                return c0666s.m3020a("message");
            case 501:
                String strM2997a = C0662o.m2997a(uri);
                return c0666s.m3020a("message").m3021a(strM2997a + "=?", strM2997a);
            case 502:
                String strM3001b = C0662o.m3001b(uri);
                return c0666s.m3020a("message").m3021a(strM3001b + "=?", strM3001b);
            case 511:
                return c0666s.m3020a("message");
            case 512:
                return c0666s.m3020a("message");
            case 600:
                return c0666s.m3020a("relation");
            case 700:
                return c0666s.m3020a("grouprelation");
            case 711:
                return c0666s.m3020a("grouprelation").m3021a("group_relation_group=?", C0668u.m3035b(uri));
            case 712:
                return c0666s.m3020a("grouprelation").m3021a("group_relation_buddy=?", C0668u.m3034a(uri));
            case 800:
                return c0666s.m3020a("participant");
            case 801:
                String strM2981a = C0654g.m2981a(uri);
                return c0666s.m3020a("participant").m3021a(strM2981a + "=?", strM2981a);
            case 802:
                return c0666s.m3020a("(SELECT buddy_no,buddy_name,b.participants_inbox_no FROM (SELECT buddy_no,buddy_name FROM buddy UNION ALL SELECT participants_buddy_no AS buddy_no,MAX(participants_buddy_name) AS buddy_name FROM participant WHERE participants_buddy_no NOT IN (SELECT buddy_no FROM buddy) GROUP BY participants_buddy_no) a LEFT OUTER JOIN participant b ON b.participants_buddy_no=buddy_no)");
            case 900:
                return c0666s.m3020a("memo");
            case 901:
                return c0666s.m3020a("memo_sessions");
            case 1000:
                return c0666s.m3020a("recommendee");
            default:
                return c0666s;
        }
    }

    /* renamed from: a */
    private long m3417a(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        try {
            return sQLiteDatabase.insertOrThrow("buddy", null, contentValues);
        } catch (SQLiteConstraintException e) {
            if (!contentValues.containsKey("buddy_no")) {
                return 0L;
            }
            return sQLiteDatabase.update("buddy", contentValues, "buddy_no=?", new String[]{contentValues.getAsString("buddy_no")});
        }
    }

    /* renamed from: b */
    private long m3422b(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        C1341p.m4662e("memoSessionInsertOrUpdatert", "ChatONProvider");
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

    /* renamed from: c */
    private long m3426c(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) throws Throwable {
        Cursor cursorQuery;
        sQLiteDatabase.beginTransaction();
        try {
            if (EnumC0665r.ONETOONE.m3012a() == contentValues.getAsInteger("inbox_chat_type").intValue()) {
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
                m3418a(sQLiteDatabase, contentValues.getAsString("inbox_no"), asString, EnumC0665r.m3011a(contentValues.getAsInteger("inbox_chat_type").intValue()));
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

    /* JADX WARN: Removed duplicated region for block: B:21:0x0102  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int m3427d(android.database.sqlite.SQLiteDatabase r12, android.content.ContentValues r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.ChatONProvider.m3427d(android.database.sqlite.SQLiteDatabase, android.content.ContentValues):int");
    }

    /* renamed from: e */
    private long m3428e(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        sQLiteDatabase.beginTransaction();
        Cursor cursor = null;
        try {
            long jInsertOrThrow = sQLiteDatabase.insertOrThrow("message", null, contentValues);
            System.currentTimeMillis();
            String asString = contentValues.getAsString("message_inbox_no");
            int iIntValue = contentValues.getAsInteger("message_content_type").intValue();
            String asString2 = contentValues.getAsString("message_sender");
            int iIntValue2 = contentValues.getAsInteger("message_read_status").intValue();
            long jLongValue = contentValues.getAsLong("message_time").longValue();
            String str = String.format("%d;%d;%s;%s", 1, Integer.valueOf(iIntValue), C0520a.m2713a(contentValues.getAsString("message_content")), "");
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
            if (0 != 0) {
                cursor.close();
            }
        }
    }

    /* renamed from: f */
    private long m3429f(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        Cursor cursor = null;
        sQLiteDatabase.beginTransaction();
        try {
            long jInsertOrThrow = sQLiteDatabase.insertOrThrow("message", null, contentValues);
            sQLiteDatabase.setTransactionSuccessful();
            return jInsertOrThrow;
        } finally {
            sQLiteDatabase.endTransaction();
            if (0 != 0) {
                cursor.close();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x017e  */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.sec.chaton.provider.EnumC0851c m3430g(android.database.sqlite.SQLiteDatabase r14, android.content.ContentValues r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 384
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.ChatONProvider.m3430g(android.database.sqlite.SQLiteDatabase, android.content.ContentValues):com.sec.chaton.provider.c");
    }

    /* renamed from: a */
    private long m3418a(SQLiteDatabase sQLiteDatabase, String str, String str2, EnumC0665r enumC0665r) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_no", str);
        contentValues.put("buddy_no", str2);
        contentValues.put("chat_type", Integer.valueOf(enumC0665r.m3012a()));
        return sQLiteDatabase.insertOrThrow("inbox_buddy_relation", null, contentValues);
    }

    /* renamed from: b */
    private void m3425b(SQLiteDatabase sQLiteDatabase, String str, String str2, EnumC0665r enumC0665r) throws SQLException {
        String strM4716a = C1351z.m4716a();
        if (!TextUtils.isEmpty(str)) {
            m3418a(sQLiteDatabase, strM4716a, str, enumC0665r);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_no", strM4716a);
        contentValues.put("inbox_chat_type", Integer.valueOf(enumC0665r.m3012a()));
        contentValues.put("inbox_last_chat_type", (Integer) 12);
        if (!TextUtils.isEmpty(str2)) {
            contentValues.put("inbox_session_id", str2);
        }
        sQLiteDatabase.insertOrThrow("inbox", null, contentValues);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x01ac  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.database.Cursor m3419a(android.database.sqlite.SQLiteDatabase r17, com.sec.chaton.p025d.C0666s r18, java.lang.String[] r19, java.lang.String r20, java.lang.String[] r21, java.lang.String r22) {
        /*
            Method dump skipped, instructions count: 431
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.ChatONProvider.m3419a(android.database.sqlite.SQLiteDatabase, com.sec.chaton.d.s, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor");
    }
}
