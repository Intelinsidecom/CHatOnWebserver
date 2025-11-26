package com.sec.chaton.provider;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.sec.chaton.access_token.C0203a;
import com.sec.chaton.chat.C0493bg;
import com.sec.chaton.coolots.AbstractC0521a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015d.p016a.C0577br;
import com.sec.chaton.p017e.C0688c;
import com.sec.chaton.p017e.C0689d;
import com.sec.chaton.p017e.C0691f;
import com.sec.chaton.p017e.C0692g;
import com.sec.chaton.p017e.C0694i;
import com.sec.chaton.p017e.C0698m;
import com.sec.chaton.p017e.C0701p;
import com.sec.chaton.p017e.C0706u;
import com.sec.chaton.p017e.C0711z;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p017e.EnumC0699n;
import com.sec.chaton.p017e.EnumC0705t;
import com.sec.chaton.p017e.InterfaceC0707v;
import com.sec.chaton.p017e.InterfaceC0708w;
import com.sec.chaton.p017e.InterfaceC0710y;
import com.sec.chaton.util.C1733ap;
import com.sec.chaton.util.C1735ar;
import com.sec.chaton.util.C1746bb;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import twitter4j.MediaEntity;
import twitter4j.internal.http.HttpResponseCode;

/* loaded from: classes.dex */
public class ChatONProvider extends ContentProvider {

    /* renamed from: b */
    private static final UriMatcher f3965b = m4101b();

    /* renamed from: a */
    private final ThreadLocal f3966a = new ThreadLocal();

    /* renamed from: a */
    private boolean m4099a() {
        return (this.f3966a == null || this.f3966a.get() == null || !((Boolean) this.f3966a.get()).booleanValue()) ? false : true;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        switch (f3965b.match(uri)) {
            case MediaEntity.Size.FIT /* 100 */:
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
            case HttpResponseCode.f7897OK /* 200 */:
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
            case 2000:
                return "vnd.chaton.cursor.dir/vnd.chaton.specialbuddy";
            default:
                throw new UnsupportedOperationException("UnKonwn Uri : " + uri);
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        C0706u.m3172a(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor cursorM3181a;
        Cursor cursorRawQuery;
        SQLiteDatabase readableDatabase = C0706u.m3172a(getContext()).getReadableDatabase();
        if (!C0203a.m1794a(getContext(), Binder.getCallingUid())) {
            throw new SecurityException("Access Token is invalid.");
        }
        int iMatch = f3965b.match(uri);
        C0711z c0711zM4097a = m4097a(uri, iMatch);
        MatrixCursor matrixCursor = null;
        switch (iMatch) {
            case HttpResponseCode.NOT_ACCEPTABLE /* 406 */:
                if (c0711zM4097a == null) {
                    return null;
                }
                return m4096a(readableDatabase, c0711zM4097a, strArr, str, strArr2, str2);
            case 509:
                C1786r.m6061b("DB query : " + uri.toString(), getClass().getSimpleName());
                String strM3158d = C0698m.m3158d(uri);
                if (TextUtils.isEmpty(strM3158d)) {
                    cursorRawQuery = null;
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (String str3 : strArr2) {
                        arrayList.add(str3);
                    }
                    arrayList.add(strM3158d);
                    arrayList.add(arrayList.get(0));
                    cursorRawQuery = readableDatabase.rawQuery(InterfaceC0710y.f2663b, (String[]) arrayList.toArray(new String[0]));
                }
                C1786r.m6061b("DB query end: " + uri.toString(), getClass().getSimpleName());
                return cursorRawQuery;
            case 510:
                String strM3159e = C0698m.m3159e(uri);
                if (TextUtils.isEmpty(strM3159e)) {
                    return null;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(strM3159e);
                arrayList2.add(strM3159e);
                arrayList2.add(C1789u.m6075a().getString("msisdn", ""));
                return readableDatabase.rawQuery(InterfaceC0710y.f2664c, (String[]) arrayList2.toArray(new String[0]));
            case 1000:
            case 2000:
                Cursor cursorM3181a2 = c0711zM4097a.m3184a(str, strArr2).m3181a(readableDatabase, strArr, str2);
                if (cursorM3181a2 != null) {
                    cursorM3181a2.setNotificationUri(getContext().getContentResolver(), uri);
                    return cursorM3181a2;
                }
                return cursorM3181a2;
            case 1100:
                String string = C1789u.m6075a().getString("msisdn", "");
                String string2 = C1789u.m6075a().getString("Push Name", "");
                String string3 = C1789u.m6075a().getString("country_code", "");
                String string4 = C1789u.m6075a().getString("country_ISO", "");
                C1786r.m6061b("Querued my info from " + Binder.getCallingUid() + " : id=" + string + ", name=" + string2 + ", country_num=" + string3 + ", country_iso_code=" + string4, "ChatONProvider");
                MatrixCursor matrixCursor2 = new MatrixCursor(new String[]{"id", "name", "country_num", "country_iso_code"});
                matrixCursor2.addRow(new String[]{string, string2, string3, string4});
                return matrixCursor2;
            case 1200:
                String[] strArr3 = {"id", "voip", "voicecall_support", "videocall_support"};
                String string5 = C1789u.m6075a().getString("msisdn", "");
                String str4 = AbstractC0521a.m2697a(GlobalApplication.m3260b()) ? "ON" : "OFF";
                String str5 = C1789u.m6075a().getInt("enable_voice_call", 0) == 1 ? "ON" : "OFF";
                String str6 = C1789u.m6075a().getInt("enable_video_call", 0) == 1 ? "ON" : "OFF";
                C1786r.m6061b("Querued my extra info : id=" + string5 + ", voip=" + str4 + ", voicecall_support=" + str5 + ", videocall_support=" + str6, "ChatONProvider");
                MatrixCursor matrixCursor3 = new MatrixCursor(strArr3);
                matrixCursor3.addRow(new String[]{string5, str4, str5, str6});
                return matrixCursor3;
            case 1300:
                String strM3122a = C0688c.m3122a(uri);
                C1786r.m6061b("BUDDYEXTRAINFO : id =" + strM3122a, "ChatONProvider");
                if (TextUtils.isEmpty(strM3122a)) {
                    return null;
                }
                String[] strArr4 = {"buddy_no", "buddy_orginal_number", "buddy_extra_info"};
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(strM3122a);
                String[] strArr5 = (String[]) arrayList3.toArray(new String[0]);
                Cursor cursorM3181a3 = null;
                if (readableDatabase != null) {
                    cursorM3181a3 = c0711zM4097a.m3184a("buddy_no = ?", strArr5).m3181a(readableDatabase, strArr4, null);
                }
                if (cursorM3181a != null && cursorM3181a.moveToFirst()) {
                    matrixCursor = new MatrixCursor(new String[]{"id", "orgnum", "voip", "voicecall_support", "videocall_support"});
                    int columnIndex = cursorM3181a.getColumnIndex("buddy_no");
                    int columnIndex2 = cursorM3181a.getColumnIndex("buddy_orginal_number");
                    int columnIndex3 = cursorM3181a.getColumnIndex("buddy_extra_info");
                    String string6 = cursorM3181a.getString(columnIndex);
                    String string7 = cursorM3181a.getString(columnIndex2);
                    String string8 = cursorM3181a.getString(columnIndex3);
                    String str7 = C0577br.m2764a(string8) ? "ON" : "OFF";
                    String str8 = C0577br.m2765b(string8) ? "ON" : "OFF";
                    String str9 = C0577br.m2766c(string8) ? "ON" : "OFF";
                    C1786r.m6061b("Querued buddy extra info : id=" + string6 + ", orgnum=" + string7 + ", voip=" + str7 + ", voicecall_support=" + str8 + ", videocall_support=" + str9, "ChatONProvider");
                    matrixCursor.addRow(new String[]{string6, string7, str7, str8, str9});
                }
            case 1400:
                cursorM3181a = null;
                String[] strArr6 = {"buddy_no", "buddy_orginal_number", "buddy_extra_info"};
                if (readableDatabase != null) {
                    cursorM3181a = c0711zM4097a.m3181a(readableDatabase, strArr6, null);
                }
                String[] strArr7 = {"id", "orgnum", "voip", "voicecall_support", "videocall_support"};
                if (cursorM3181a != null) {
                    try {
                        if (cursorM3181a.moveToFirst()) {
                            matrixCursor = new MatrixCursor(strArr7);
                            int columnIndex4 = cursorM3181a.getColumnIndex("buddy_no");
                            int columnIndex5 = cursorM3181a.getColumnIndex("buddy_orginal_number");
                            int columnIndex6 = cursorM3181a.getColumnIndex("buddy_extra_info");
                            do {
                                String string9 = cursorM3181a.getString(columnIndex4);
                                String string10 = cursorM3181a.getString(columnIndex5);
                                String string11 = cursorM3181a.getString(columnIndex6);
                                String str10 = C0577br.m2764a(string11) ? "ON" : "OFF";
                                String str11 = C0577br.m2765b(string11) ? "ON" : "OFF";
                                String str12 = C0577br.m2766c(string11) ? "ON" : "OFF";
                                C1786r.m6061b("Querued buddy extra info : id=" + string9 + ", orgnum=" + string10 + ", voip=" + str10 + ", voicecall_support=" + str11 + ", videocall_support=" + str12, "ChatONProvider");
                                matrixCursor.addRow(new String[]{string9, string10, str10, str11, str12});
                            } while (cursorM3181a.moveToNext());
                        }
                    } finally {
                        if (cursorM3181a != null) {
                            cursorM3181a.close();
                        }
                    }
                }
                if (cursorM3181a != null) {
                    cursorM3181a.close();
                    return matrixCursor;
                }
                return matrixCursor;
            default:
                if (c0711zM4097a == null) {
                    return null;
                }
                return c0711zM4097a.m3184a(str, strArr2).m3181a(readableDatabase, strArr, str2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005f A[LOOP:0: B:13:0x0059->B:15:0x005f, LOOP_END] */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.net.Uri insert(android.net.Uri r11, android.content.ContentValues r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 854
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.ChatONProvider.insert(android.net.Uri, android.content.ContentValues):android.net.Uri");
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) throws Throwable {
        int i;
        SQLiteDatabase writableDatabase = C0706u.m3172a(getContext()).getWritableDatabase();
        int iMatch = f3965b.match(uri);
        ArrayList arrayList = new ArrayList();
        switch (iMatch) {
            case 405:
                C1786r.m6061b("DB update : " + uri.toString(), getClass().getSimpleName());
                int iM4104d = m4104d(writableDatabase, contentValues);
                if (iM4104d > 0) {
                    arrayList.add(C0694i.f2616a);
                    arrayList.add(C0698m.f2626a);
                }
                C1786r.m6061b("DB update end : " + uri.toString(), getClass().getSimpleName());
                i = iM4104d;
                break;
            case HttpResponseCode.INTERNAL_SERVER_ERROR /* 500 */:
                C1786r.m6061b("DB update : " + uri.toString(), getClass().getSimpleName());
                int iM3180a = m4102b(uri, iMatch).m3184a(str, strArr).m3180a(writableDatabase, contentValues);
                if (strArr != null) {
                    C1786r.m6061b("ContentProvider : " + uri.toString() + " : " + strArr[0], getClass().getSimpleName());
                }
                C1786r.m6061b("UdateMessage Result : " + String.valueOf(iM3180a), getClass().getSimpleName());
                arrayList.add(uri);
                C1786r.m6061b("DB update end : " + uri.toString(), getClass().getSimpleName());
                i = iM3180a;
                break;
            case 504:
                writableDatabase.execSQL("UPDATE message SET message_read_status= CASE WHEN message_read_status IS 0 THEN 0  ELSE (message_read_status-1) END WHERE message_sever_id=?", new String[]{C0698m.m3157c(uri)});
                arrayList.add(uri);
                i = 1;
                break;
            default:
                int iM3180a2 = m4102b(uri, iMatch).m3184a(str, strArr).m3180a(writableDatabase, contentValues);
                arrayList.add(uri);
                i = iM3180a2;
                break;
        }
        if (!m4099a() && i > 0 && arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                getContext().getContentResolver().notifyChange((Uri) it.next(), null);
            }
        }
        arrayList.clear();
        return i;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        C1786r.m6061b("DB delete : " + uri.toString(), getClass().getSimpleName());
        int iM3179a = m4102b(uri, f3965b.match(uri)).m3184a(str, strArr).m3179a(C0706u.m3172a(getContext()).getWritableDatabase());
        if (iM3179a > 0) {
            C1786r.m6061b("DB delete Success : " + uri.toString(), getClass().getSimpleName());
            if (!m4099a()) {
                getContext().getContentResolver().notifyChange(uri, null);
            }
        }
        C1786r.m6061b("DB delete end : " + uri.toString(), getClass().getSimpleName());
        return iM3179a;
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList arrayList) {
        SQLiteDatabase writableDatabase = C0706u.m3172a(getContext()).getWritableDatabase();
        HashSet hashSet = new HashSet();
        writableDatabase.beginTransaction();
        int size = arrayList.size();
        try {
            this.f3966a.set(true);
            ContentProviderResult[] contentProviderResultArr = new ContentProviderResult[size];
            for (int i = 0; i < size; i++) {
                contentProviderResultArr[i] = ((ContentProviderOperation) arrayList.get(i)).apply(this, contentProviderResultArr, i);
                hashSet.add(((ContentProviderOperation) arrayList.get(i)).getUri());
            }
            writableDatabase.setTransactionSuccessful();
            return contentProviderResultArr;
        } finally {
            this.f3966a.set(false);
            writableDatabase.endTransaction();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                getContext().getContentResolver().notifyChange((Uri) it.next(), null);
            }
        }
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) {
        int iMatch = f3965b.match(uri);
        if (!C0203a.m1794a(getContext(), Binder.getCallingUid())) {
            throw new SecurityException("Access Token is invalid.");
        }
        switch (iMatch) {
            case 102:
                if ("r".equals(str)) {
                    return ParcelFileDescriptor.open(new File(getContext().getFilesDir(), C1746bb.m5953b(uri.getLastPathSegment())), 268435456);
                }
            default:
                return null;
        }
    }

    /* renamed from: b */
    private static UriMatcher m4101b() {
        UriMatcher uriMatcher = new UriMatcher(-1);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/buddy_no/*", 102);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/participants_no_same", 108);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/participants", 107);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/profile", 106);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/group", 103);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/alphabetical", 104);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/alphabetical2", 109);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/relation", 105);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/alphabetical_special", 110);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy", 100);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy_group/group_info", 203);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy_group/*", 201);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy_group", HttpResponseCode.f7897OK);
        uriMatcher.addURI("com.sec.chaton.provider", "contacts/conatct_number/*", HttpResponseCode.FOUND);
        uriMatcher.addURI("com.sec.chaton.provider", "contacts/*", 301);
        uriMatcher.addURI("com.sec.chaton.provider", "contacts", HttpResponseCode.MULTIPLE_CHOICES);
        uriMatcher.addURI("com.sec.chaton.provider", "grouprelation/group_relation_group/*", 711);
        uriMatcher.addURI("com.sec.chaton.provider", "grouprelation/group_relation_buddy/*", 712);
        uriMatcher.addURI("com.sec.chaton.provider", "grouprelation/group", 713);
        uriMatcher.addURI("com.sec.chaton.provider", "grouprelation/buddy_in", 701);
        uriMatcher.addURI("com.sec.chaton.provider", "grouprelation/buddy_not_in", 702);
        uriMatcher.addURI("com.sec.chaton.provider", "grouprelation", 700);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/get_inbox_no", HttpResponseCode.NOT_ACCEPTABLE);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/inbox_invalid_update", 405);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/group_title_update", HttpResponseCode.NOT_FOUND);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/buddy_participant_join", HttpResponseCode.FORBIDDEN);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/inbox_no", 402);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/*", HttpResponseCode.UNAUTHORIZED);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox", 400);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox_buddy_relation", 461);
        uriMatcher.addURI("com.sec.chaton.provider", "message/read_ack/*", 504);
        uriMatcher.addURI("com.sec.chaton.provider", "message/message_sever_id/*", HttpResponseCode.BAD_GATEWAY);
        uriMatcher.addURI("com.sec.chaton.provider", "message/message_buddy", 505);
        uriMatcher.addURI("com.sec.chaton.provider", "message/message_buddy/*", 509);
        uriMatcher.addURI("com.sec.chaton.provider", "message/count/*", 510);
        uriMatcher.addURI("com.sec.chaton.provider", "message/send", 506);
        uriMatcher.addURI("com.sec.chaton.provider", "message/received", 507);
        uriMatcher.addURI("com.sec.chaton.provider", "message/send/inbox", 508);
        uriMatcher.addURI("com.sec.chaton.provider", "message/*", 501);
        uriMatcher.addURI("com.sec.chaton.provider", "message", HttpResponseCode.INTERNAL_SERVER_ERROR);
        uriMatcher.addURI("com.sec.chaton.provider", "relation/insert", 604);
        uriMatcher.addURI("com.sec.chaton.provider", "relation/day", 603);
        uriMatcher.addURI("com.sec.chaton.provider", "relation", 600);
        uriMatcher.addURI("com.sec.chaton.provider", "participant/*", 801);
        uriMatcher.addURI("com.sec.chaton.provider", "participant", 800);
        uriMatcher.addURI("com.sec.chaton.provider", "memo", 900);
        uriMatcher.addURI("com.sec.chaton.provider", "memo_sessions", 901);
        uriMatcher.addURI("com.sec.chaton.provider", "recommendee", 1000);
        uriMatcher.addURI("com.sec.chaton.provider", "specialbuddy", 2000);
        uriMatcher.addURI("com.sec.chaton.provider", "me", 1100);
        uriMatcher.addURI("com.sec.chaton.provider", "myextrainfo", 1200);
        uriMatcher.addURI("com.sec.chaton.provider", "buddyextrainfo/#", 1300);
        uriMatcher.addURI("com.sec.chaton.provider", "buddyextrainfoall", 1400);
        return uriMatcher;
    }

    /* renamed from: a */
    private C0711z m4097a(Uri uri, int i) {
        C0711z c0711z = new C0711z();
        switch (i) {
            case MediaEntity.Size.FIT /* 100 */:
                return c0711z.m3183a("buddy");
            case 102:
                return c0711z.m3183a("buddy").m3184a("buddy_no=?", C0688c.m3124b(uri));
            case 103:
                return c0711z.m3183a(InterfaceC0707v.f2658a);
            case 104:
                return c0711z.m3183a("(SELECT a.*,CASE WHEN b.relation_send IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_send END AS relation_send,CASE WHEN b.relation_received IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_received END AS relation_received,CASE WHEN b.relation_point IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_point END AS relation_point,CASE WHEN b.relation_icon IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_icon END AS relation_icon,CASE WHEN b.relation_increase IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_increase END AS relation_increase,CASE WHEN b.relation_rank IS NULL THEN 9999999 WHEN a.buddy_relation_hide = 'Y' THEN 9999999 ELSE b.relation_rank END AS relation_rank FROM (SELECT 1 AS group_relation_group,'Favorites' AS group_name,1 AS group_type,b.buddy_no,b.buddy_name,b.buddy_status_message,b.buddy_email,b.buddy_samsung_email,b.buddy_orginal_number,b.buddy_relation_hide,b.buddy_birthday,b.buddy_raw_contact_id,b.buddy_push_name,b.buddy_is_new,b.buddy_profile_status,b.buddy_is_profile_updated,b.buddy_show_phone_number,b.buddy_extra_info,b.buddy_is_status_updated FROM ( SELECT group_relation_buddy FROM grouprelation WHERE group_relation_group = 1 ) a JOIN buddy b ON a.group_relation_buddy = b.buddy_no UNION ALL SELECT null AS group_relation_group,null AS group_name,2 AS group_type,buddy_no,buddy_name,buddy_status_message,buddy_email,buddy_samsung_email,buddy_orginal_number,buddy_relation_hide,buddy_birthday,buddy_raw_contact_id,buddy_push_name,buddy_is_new,buddy_profile_status,buddy_is_profile_updated,buddy_show_phone_number,buddy_extra_info,buddy_is_status_updated FROM buddy) a LEFT OUTER JOIN (SELECT * FROM relation WHERE relation_date = date('now','localtime','0 day')) b ON a.buddy_no = b.relation_buddy_id)");
            case 105:
                return c0711z.m3183a("(SELECT b.buddy_no,b.buddy_name,b.buddy_status_message,b.buddy_birthday,b.buddy_email,b.buddy_samsung_email,b.buddy_orginal_number,b.buddy_msg_send,b.buddy_msg_received,b.buddy_relation_hide,b.buddy_raw_contact_id,b.buddy_push_name,b.buddy_is_new,b.buddy_profile_status,b.buddy_is_profile_updated,b.buddy_is_status_updated,b.buddy_show_phone_number,b.buddy_extra_info,CASE WHEN c.relation_send IS NULL THEN 0 WHEN b.buddy_relation_hide = 'Y' THEN 0 ELSE c.relation_send END AS relation_send,CASE WHEN c.relation_received IS NULL THEN 0 WHEN b.buddy_relation_hide = 'Y' THEN 0 ELSE c.relation_received END AS relation_received,CASE WHEN c.relation_point IS NULL THEN 0 WHEN b.buddy_relation_hide = 'Y' THEN 0 ELSE c.relation_point END AS relation_point,CASE WHEN c.relation_icon IS NULL THEN 0 WHEN b.buddy_relation_hide = 'Y' THEN 0 ELSE c.relation_icon END AS relation_icon,CASE WHEN c.relation_increase IS NULL THEN 0 WHEN b.buddy_relation_hide = 'Y' THEN 0 ELSE c.relation_increase END AS relation_increase,CASE WHEN c.relation_rank IS NULL THEN 9999999 WHEN b.buddy_relation_hide = 'Y' THEN 9999999 ELSE c.relation_rank END AS relation_rank,1 AS group_type FROM (SELECT * FROM grouprelation WHERE group_relation_group = 1) a JOIN buddy b ON a.group_relation_buddy = b.buddy_no LEFT OUTER JOIN  ( SELECT * FROM relation WHERE relation_date = '1' ) c  ON a.group_relation_buddy = c.relation_buddy_id WHERE c.relation_date = '1' OR c.relation_date is null) d UNION ALL SELECT * FROM (SELECT a.buddy_no,a.buddy_name,a.buddy_status_message,a.buddy_birthday,a.buddy_email,a.buddy_samsung_email,a.buddy_orginal_number,a.buddy_msg_send,a.buddy_msg_received,a.buddy_relation_hide,a.buddy_raw_contact_id,a.buddy_push_name,a.buddy_is_new,a.buddy_profile_status,a.buddy_is_profile_updated,a.buddy_is_status_updated,a.buddy_show_phone_number,a.buddy_extra_info,CASE WHEN b.relation_send IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_send END AS relation_send,CASE WHEN b.relation_received IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_received END AS relation_received,CASE WHEN b.relation_point IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_point END AS relation_point,CASE WHEN b.relation_icon IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_icon END AS relation_icon,CASE WHEN b.relation_increase IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_increase END AS relation_increase,CASE WHEN b.relation_rank IS NULL THEN 9999999 WHEN a.buddy_relation_hide = 'Y' THEN 9999999 ELSE b.relation_rank END AS relation_rank,2 AS group_type FROM buddy a LEFT OUTER JOIN  ( SELECT * FROM relation WHERE relation_date = '1' ) b  ON a.buddy_no = b.relation_buddy_id WHERE b.relation_date = '1' OR b.relation_date is null)");
            case 106:
                return c0711z.m3183a("(SELECT a.*,CASE WHEN b.group_relation_buddy IS NULL THEN 'N' ELSE 'Y' END AS is_favorite FROM (SELECT b.buddy_no,b.buddy_name,b.buddy_status_message,b.buddy_email,b.buddy_samsung_email,b.buddy_orginal_number,b.buddy_birthday,b.buddy_relation_hide,b.buddy_raw_contact_id,b.buddy_push_name,b.buddy_is_new,b.buddy_profile_status,b.buddy_is_profile_updated,b.buddy_is_status_updated,b.buddy_show_phone_number,b.buddy_extra_info,CASE WHEN c.relation_send IS NULL THEN 0 WHEN b.buddy_relation_hide = 'Y' THEN 0 ELSE c.relation_send END AS relation_send,CASE WHEN c.relation_received IS NULL THEN 0 WHEN b.buddy_relation_hide = 'Y' THEN 0 ELSE c.relation_received END AS relation_received,CASE WHEN c.relation_point IS NULL THEN 0 WHEN b.buddy_relation_hide = 'Y' THEN 0 ELSE c.relation_point END AS relation_point,CASE WHEN c.relation_icon IS NULL THEN 0 WHEN b.buddy_relation_hide = 'Y' THEN 0 ELSE c.relation_icon END AS relation_icon,CASE WHEN c.relation_increase IS NULL THEN 0 WHEN b.buddy_relation_hide = 'Y' THEN 0 ELSE c.relation_increase END AS relation_increase,CASE WHEN c.relation_rank IS NULL THEN 0 WHEN b.buddy_relation_hide = 'Y' THEN 0 ELSE c.relation_rank END AS relation_rank FROM buddy b LEFT OUTER JOIN ( SELECT * FROM relation WHERE relation_date = DATE('now', 'localtime', '0 day') ) c ON b.buddy_no = c.relation_buddy_id) a LEFT OUTER JOIN (SELECT group_relation_buddy FROM grouprelation WHERE group_relation_group = 1) b ON a.buddy_no = b.group_relation_buddy)");
            case 107:
                return c0711z.m3183a(InterfaceC0707v.f2659b);
            case 108:
                return c0711z.m3183a("(SELECT buddy_no,buddy_name,buddy_status_message,buddy_profile_status FROM buddy UNION ALL SELECT participants_buddy_no AS buddy_no,MAX(participants_buddy_name) AS buddy_name,'' AS buddy_status_message,'' AS buddy_profile_status FROM participant WHERE participants_buddy_no NOT IN (SELECT buddy_no FROM buddy) GROUP BY participants_buddy_no)");
            case 109:
                return c0711z.m3183a("(SELECT a.*,CASE WHEN b.relation_send IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_send END AS relation_send,CASE WHEN b.relation_received IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_received END AS relation_received,CASE WHEN b.relation_point IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_point END AS relation_point,CASE WHEN b.relation_icon IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_icon END AS relation_icon,CASE WHEN b.relation_increase IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_increase END AS relation_increase,CASE WHEN b.relation_rank IS NULL THEN 9999999 WHEN a.buddy_relation_hide = 'Y' THEN 9999999 ELSE b.relation_rank END AS relation_rank FROM (SELECT b.buddyno_list AS group_relation_group,group_name,group_type,_id AS buddy_no,group_name AS buddy_name,null AS buddy_status_message,b.buddyno_list AS buddy_email,b.buddyname_list AS buddy_samsung_email,null AS buddy_orginal_number,null AS buddy_relation_hide,null AS buddy_birthday,null AS buddy_raw_contact_id,null AS buddy_push_name,group_is_new AS buddy_is_new,null AS buddy_profile_status,null AS buddy_is_profile_updated,1 AS buddy_show_phone_number,null AS buddy_extra_info,null AS buddy_is_status_updated FROM buddy_group a LEFT OUTER JOIN(SELECT group_relation_group,group_concat(group_relation_buddy, '%%' || group_relation_group || '%%') AS buddyno_list,group_concat(buddy_name, '%%' || group_relation_group || '%%') AS buddyname_list FROM (SELECT a.group_relation_group,a.group_relation_buddy,TRIM(b.buddy_name) AS buddy_name FROM grouprelation a,buddy b WHERE a.group_relation_buddy = b.buddy_no AND group_relation_group != 1) GROUP BY group_relation_group) b ON a._id = b.group_relation_group WHERE a.group_type != 1 UNION ALL SELECT 1 AS group_relation_group,'Favorites' AS group_name,1 AS group_type,b.buddy_no,b.buddy_name,b.buddy_status_message,b.buddy_email,b.buddy_samsung_email,b.buddy_orginal_number,b.buddy_relation_hide,b.buddy_birthday,b.buddy_raw_contact_id,b.buddy_push_name,b.buddy_is_new,b.buddy_profile_status,b.buddy_is_profile_updated,buddy_show_phone_number,buddy_extra_info,b.buddy_is_status_updated FROM ( SELECT group_relation_buddy FROM grouprelation WHERE group_relation_group = 1 ) a JOIN buddy b ON a.group_relation_buddy = b.buddy_no UNION ALL SELECT null AS group_relation_group,null AS group_name,2 AS group_type,buddy_no,buddy_name,buddy_status_message,buddy_email,buddy_samsung_email,buddy_orginal_number,buddy_relation_hide,buddy_birthday,buddy_raw_contact_id,buddy_push_name,buddy_is_new,buddy_profile_status,buddy_is_profile_updated,buddy_show_phone_number,buddy_extra_info,buddy_is_status_updated FROM buddy) a LEFT OUTER JOIN (SELECT * FROM relation WHERE relation_date = date('now','localtime','0 day')) b ON a.buddy_no = b.relation_buddy_id)");
            case 110:
                return c0711z.m3183a("(SELECT a.*,CASE WHEN b.relation_send IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_send END AS relation_send,CASE WHEN b.relation_received IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_received END AS relation_received,CASE WHEN b.relation_point IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_point END AS relation_point,CASE WHEN b.relation_icon IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_icon END AS relation_icon,CASE WHEN b.relation_increase IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_increase END AS relation_increase,CASE WHEN b.relation_rank IS NULL THEN 9999999 WHEN a.buddy_relation_hide = 'Y' THEN 9999999 ELSE b.relation_rank END AS relation_rank FROM (SELECT 1 AS group_relation_group,'Favorites' AS group_name,1 AS group_type,b.buddy_no,b.buddy_name,b.buddy_status_message,b.buddy_email,b.buddy_samsung_email,b.buddy_orginal_number,b.buddy_relation_hide,b.buddy_birthday,b.buddy_raw_contact_id,b.buddy_push_name,b.buddy_is_new,b.buddy_profile_status,b.buddy_is_profile_updated,b.buddy_show_phone_number,b.buddy_extra_info,b.buddy_is_status_updated FROM ( SELECT group_relation_buddy FROM grouprelation WHERE group_relation_group = 1 ) a JOIN ( SELECT buddy_no,buddy_name,buddy_status_message,buddy_email,buddy_samsung_email,buddy_orginal_number,buddy_relation_hide,buddy_birthday,buddy_raw_contact_id,buddy_push_name,buddy_is_new,buddy_profile_status,buddy_is_profile_updated,buddy_show_phone_number,buddy_extra_info,buddy_is_status_updated FROM buddy UNION ALL SELECT buddy_no,buddy_name,msgstatus AS buddy_status_message,'' AS buddy_email,'' AS buddy_samsung_email,'' AS buddy_orginal_number,'' AS buddy_relation_hide,'' AS buddy_birthday,'' AS buddy_raw_contact_id,'' AS buddy_push_name,'' AS buddy_is_new,'' AS buddy_profile_status,'' AS buddy_is_profile_updated,'' AS buddy_show_phone_number,'' AS buddy_extra_info,'' AS buddy_is_status_updated FROM specialbuddy) b ON a.group_relation_buddy = b.buddy_no UNION ALL SELECT null AS group_relation_group,null AS group_name,2 AS group_type,buddy_no,buddy_name,buddy_status_message,buddy_email,buddy_samsung_email,buddy_orginal_number,buddy_relation_hide,buddy_birthday,buddy_raw_contact_id,buddy_push_name,buddy_is_new,buddy_profile_status,buddy_is_profile_updated,buddy_show_phone_number,buddy_extra_info,buddy_is_status_updated FROM ( SELECT buddy_no,buddy_name,buddy_status_message,buddy_email,buddy_samsung_email,buddy_orginal_number,buddy_relation_hide,buddy_birthday,buddy_raw_contact_id,buddy_push_name,buddy_is_new,buddy_profile_status,buddy_is_profile_updated,buddy_show_phone_number,buddy_extra_info,buddy_is_status_updated FROM buddy UNION ALL SELECT buddy_no,buddy_name,msgstatus AS buddy_status_message,'' AS buddy_email,'' AS buddy_samsung_email,'' AS buddy_orginal_number,'' AS buddy_relation_hide,'' AS buddy_birthday,'' AS buddy_raw_contact_id,'' AS buddy_push_name,'' AS buddy_is_new,'' AS buddy_profile_status,'' AS buddy_is_profile_updated,'' AS buddy_show_phone_number,'' AS buddy_extra_info,'' AS buddy_is_status_updated FROM specialbuddy)) a LEFT OUTER JOIN (SELECT * FROM relation WHERE relation_date = date('now','localtime','0 day')) b ON a.buddy_no = b.relation_buddy_id)");
            case HttpResponseCode.f7897OK /* 200 */:
                return c0711z.m3183a("buddy_group");
            case 201:
                return c0711z.m3183a("buddy_group").m3184a("_id=?", C0692g.m3138a(uri));
            case 203:
                return c0711z.m3183a("(SELECT a._id,a.group_name,a.group_type,ifnull(b.cnt,0) AS cnt FROM buddy_group a LEFT OUTER JOIN (SELECT group_relation_group,COUNT(*) AS cnt FROM grouprelation GROUP BY group_relation_group HAVING group_relation_group > 1) b ON a._id=b.group_relation_group WHERE a._id != 1)f");
            case HttpResponseCode.MULTIPLE_CHOICES /* 300 */:
                return c0711z.m3183a("contacts");
            case 301:
                return c0711z.m3183a("contacts").m3184a("_id=?", C0689d.m3131a(uri));
            case HttpResponseCode.FOUND /* 302 */:
                return c0711z.m3183a("contacts").m3184a("conatct_number=?", C0689d.m3132b(uri));
            case 400:
                return c0711z.m3183a("inbox");
            case HttpResponseCode.UNAUTHORIZED /* 401 */:
                return c0711z.m3183a("inbox").m3184a("_id=?", C0694i.m3140a(uri));
            case 402:
                return c0711z.m3183a("inbox").m3184a("inbox_no=?", C0694i.m3142b(uri));
            case HttpResponseCode.FORBIDDEN /* 403 */:
                return c0711z.m3183a("(SELECT _id,inbox_no,inbox_chat_type,inbox_last_message,inbox_title,inbox_title_fixed,inbox_last_time,inbox_lang_from,inbox_unread_count,inbox_lang_to,inbox_translated,inbox_server_ip,inbox_server_port,inbox_participants,inbox_session_id,inbox_last_msg_no,inbox_last_msg_sender,inbox_last_temp_msg,inbox_last_chat_type,inbox_is_new,inbox_trunk_unread_count,inbox_enable_noti,inbox_last_timestamp,inbox_web_url,inbox_valid,buddy_no,buddy_status_message,buddy_name FROM (SELECT * FROM inbox a LEFT OUTER JOIN (SELECT buddy_no,buddy_name,buddy_status_message FROM buddy UNION ALL SELECT buddy_no AS buddy_no,buddy_name AS buddy_name,msgstatus AS buddy_status_message FROM specialbuddy UNION ALL SELECT participants_buddy_no AS buddy_no,ifnull(MAX(participants_buddy_name),participants_buddy_no) AS buddy_name,'' AS buddy_status_message FROM participant WHERE participants_buddy_no NOT IN (SELECT buddy_no FROM buddy UNION ALL SELECT buddy_no AS buddy_no FROM specialbuddy) GROUP BY participants_buddy_no) b ON b.buddy_no = ( SELECT buddy_no FROM inbox_buddy_relation WHERE inbox_no = a.inbox_no ) ))");
            case HttpResponseCode.NOT_FOUND /* 404 */:
                return c0711z.m3183a(InterfaceC0708w.f2660a);
            case HttpResponseCode.NOT_ACCEPTABLE /* 406 */:
                return c0711z.m3183a("(SELECT _id,inbox_no,inbox_chat_type,inbox_last_message,inbox_title,inbox_title_fixed,inbox_last_time,inbox_lang_from,inbox_unread_count,inbox_lang_to,inbox_translated,inbox_server_ip,inbox_server_port,inbox_participants,inbox_session_id,inbox_last_msg_no,inbox_last_msg_sender,inbox_last_temp_msg,inbox_last_chat_type,inbox_is_new,inbox_trunk_unread_count,inbox_enable_noti,inbox_last_timestamp,inbox_web_url,inbox_valid,buddy_no,buddy_status_message,buddy_name FROM (SELECT * FROM inbox a LEFT OUTER JOIN (SELECT buddy_no,buddy_name,buddy_status_message FROM buddy UNION ALL SELECT buddy_no AS buddy_no,buddy_name AS buddy_name,msgstatus AS buddy_status_message FROM specialbuddy UNION ALL SELECT participants_buddy_no AS buddy_no,ifnull(MAX(participants_buddy_name),participants_buddy_no) AS buddy_name,'' AS buddy_status_message FROM participant WHERE participants_buddy_no NOT IN (SELECT buddy_no FROM buddy UNION ALL SELECT buddy_no AS buddy_no FROM specialbuddy) GROUP BY participants_buddy_no) b ON b.buddy_no = ( SELECT buddy_no FROM inbox_buddy_relation WHERE inbox_no = a.inbox_no ) ))");
            case 461:
                return c0711z.m3183a("inbox_buddy_relation");
            case HttpResponseCode.INTERNAL_SERVER_ERROR /* 500 */:
                return c0711z.m3183a("message");
            case 501:
                String strM3150a = C0698m.m3150a(uri);
                return c0711z.m3183a("message").m3184a(strM3150a + "=?", strM3150a);
            case HttpResponseCode.BAD_GATEWAY /* 502 */:
                String strM3154b = C0698m.m3154b(uri);
                return c0711z.m3183a("message").m3184a(strM3154b + "=?", strM3154b);
            case 505:
                return c0711z.m3183a(InterfaceC0710y.f2662a);
            case 600:
                return c0711z.m3183a("relation");
            case 603:
                return c0711z.m3183a("(SELECT b.relation_date,a.buddy_no,a.buddy_name,a.buddy_status_message,a.buddy_email,a.buddy_samsung_email,a.buddy_orginal_number,a.buddy_msg_send,a.buddy_msg_received,a.buddy_relation_hide,IFNULL(b.relation_send,0) AS relation_send,IFNULL(b.relation_received,0) AS relation_received,IFNULL(b.relation_point,0) AS relation_point,IFNULL(b.relation_icon,6) AS relation_icon,IFNULL(b.relation_increase,0) AS relation_increase,IFNULL(b.relation_rank,9999999) AS relation_rank,IFNULL(a.buddy_profile_status,0) AS buddy_profile_status,IFNULL(b.relation_last_msg_time,DATETIME('NOW', 'localtime')) AS relation_last_msg_time,2 AS group_type FROM buddy a JOIN relation b ON a.buddy_no = b.relation_buddy_id)");
            case 700:
                return c0711z.m3183a("grouprelation");
            case 701:
                return c0711z.m3183a("(SELECT b.buddy_no,b.buddy_name,b.buddy_status_message,b.buddy_email,b.buddy_samsung_email,b.buddy_orginal_number,b.buddy_msg_send,b.buddy_msg_received,b.buddy_relation_hide,b.buddy_birthday,b.buddy_raw_contact_id,b.buddy_push_name,b.buddy_is_new,b.buddy_profile_status,b.buddy_is_profile_updated,b.buddy_is_status_updated,a.group_relation_group FROM grouprelation a JOIN buddy b ON a.group_relation_buddy = b.buddy_no)");
            case 702:
                return c0711z.m3183a("(SELECT * FROM (SELECT * FROM (SELECT buddy_no,buddy_name,buddy_status_message,buddy_email,buddy_samsung_email,buddy_orginal_number,buddy_relation_hide,buddy_birthday,buddy_raw_contact_id,buddy_push_name,buddy_is_new,buddy_profile_status,buddy_is_profile_updated,buddy_is_status_updated,ifnull(b.group_relation_group,9999) AS group_relation_group,ifnull(c.group_type,3) AS group_type FROM buddy a LEFT OUTER JOIN grouprelation b ON a.buddy_no=b.group_relation_buddy LEFT OUTER JOIN buddy_group c ON b.group_relation_group=c._id) GROUP BY buddy_no))");
            case 711:
                return c0711z.m3183a("grouprelation").m3184a("group_relation_group=?", C0691f.m3137b(uri));
            case 712:
                return c0711z.m3183a("grouprelation").m3184a("group_relation_buddy=?", C0691f.m3135a(uri));
            case 713:
                return c0711z.m3183a("(SELECT a._id,a.group_name,c.* FROM buddy_group a LEFT OUTER JOIN grouprelation b ON a._id = b.group_relation_group LEFT OUTER JOIN buddy c ON b.group_relation_buddy = c.buddy_no)");
            case 800:
                return c0711z.m3183a("participant");
            case 801:
                return c0711z.m3183a("(SELECT ifnull(b.buddy_no,c.participants_buddy_no) AS buddy_no,ifnull(b.buddy_status_message,'') AS buddy_status_message,ifnull(b.buddy_name,c.participants_buddy_name) AS buddy_name,c.participants_inbox_no AS participants_inbox_no,c.participants_buddy_no AS participants_buddy_no,c.rowid AS rowid FROM (SELECT ifnull(participants_buddy_name,participants_buddy_no) AS participants_buddy_name,participants_buddy_no,participants_inbox_no,rowid FROM participant) c LEFT OUTER JOIN ( SELECT buddy_no, buddy_status_message, buddy_name FROM buddy UNION ALL SELECT buddy_no AS buddy_no, msgstatus AS buddy_status_message, buddy_name AS buddy_name FROM specialbuddy ) b ON c.participants_buddy_no = b.buddy_no)").m3184a("participants_inbox_no=?", C0701p.m3165a(uri));
            case 900:
                return c0711z.m3183a("memo");
            case 901:
                return c0711z.m3183a("memo_sessions");
            case 1000:
                return c0711z.m3183a("recommendee");
            case 1300:
            case 1400:
                return c0711z.m3183a("(SELECT buddy_no,buddy_orginal_number,buddy_extra_info FROM buddy)");
            case 2000:
                return c0711z.m3183a("specialbuddy");
            default:
                return null;
        }
    }

    /* renamed from: b */
    private C0711z m4102b(Uri uri, int i) {
        C0711z c0711z = new C0711z();
        switch (i) {
            case MediaEntity.Size.FIT /* 100 */:
                return c0711z.m3183a("buddy");
            case 102:
                return c0711z.m3183a("buddy").m3184a("buddy_no=?", C0688c.m3124b(uri));
            case HttpResponseCode.f7897OK /* 200 */:
                return c0711z.m3183a("buddy_group");
            case 201:
                return c0711z.m3183a("buddy_group").m3184a("_id=?", C0692g.m3138a(uri));
            case HttpResponseCode.MULTIPLE_CHOICES /* 300 */:
                return c0711z.m3183a("contacts");
            case 301:
                return c0711z.m3183a("contacts").m3184a("_id=?", C0689d.m3131a(uri));
            case HttpResponseCode.FOUND /* 302 */:
                return c0711z.m3183a("contacts").m3184a("conatct_number=?", C0689d.m3132b(uri));
            case 400:
                return c0711z.m3183a("inbox");
            case HttpResponseCode.UNAUTHORIZED /* 401 */:
                return c0711z.m3183a("inbox").m3184a("_id=?", C0694i.m3140a(uri));
            case 402:
                return c0711z.m3183a("inbox").m3184a("inbox_no=?", C0694i.m3142b(uri));
            case 461:
                return c0711z.m3183a("inbox_buddy_relation");
            case HttpResponseCode.INTERNAL_SERVER_ERROR /* 500 */:
                return c0711z.m3183a("message");
            case 501:
                String strM3150a = C0698m.m3150a(uri);
                return c0711z.m3183a("message").m3184a(strM3150a + "=?", strM3150a);
            case HttpResponseCode.BAD_GATEWAY /* 502 */:
                String strM3154b = C0698m.m3154b(uri);
                return c0711z.m3183a("message").m3184a(strM3154b + "=?", strM3154b);
            case 600:
                return c0711z.m3183a("relation");
            case 700:
                return c0711z.m3183a("grouprelation");
            case 711:
                return c0711z.m3183a("grouprelation").m3184a("group_relation_group=?", C0691f.m3137b(uri));
            case 712:
                return c0711z.m3183a("grouprelation").m3184a("group_relation_buddy=?", C0691f.m3135a(uri));
            case 800:
                return c0711z.m3183a("participant");
            case 801:
                String strM3165a = C0701p.m3165a(uri);
                return c0711z.m3183a("participant").m3184a(strM3165a + "=?", strM3165a);
            case 900:
                return c0711z.m3183a("memo");
            case 901:
                return c0711z.m3183a("memo_sessions");
            case 1000:
                return c0711z.m3183a("recommendee");
            case 2000:
                return c0711z.m3183a("specialbuddy");
            default:
                return c0711z;
        }
    }

    /* renamed from: a */
    private long m4095a(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
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
    private long m4100b(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        C1786r.m6066e("memoSessionInsertOrUpdatert", "ChatONProvider");
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
    private long m4103c(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) throws Throwable {
        Cursor cursorQuery;
        sQLiteDatabase.beginTransaction();
        try {
            if (EnumC0695j.ONETOONE.m3146a() == contentValues.getAsInteger("inbox_chat_type").intValue()) {
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
                ContentValues contentValues3 = new ContentValues();
                contentValues3.put("inbox_no", contentValues.getAsString("inbox_no"));
                contentValues3.put("buddy_no", asString);
                sQLiteDatabase.insertOrThrow("inbox_buddy_relation", null, contentValues3);
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

    /* JADX WARN: Removed duplicated region for block: B:21:0x00fb  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int m4104d(android.database.sqlite.SQLiteDatabase r12, android.content.ContentValues r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.ChatONProvider.m4104d(android.database.sqlite.SQLiteDatabase, android.content.ContentValues):int");
    }

    /* renamed from: e */
    private long m4105e(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
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
            String str = String.format("%d;%d;%s;%s", 1, Integer.valueOf(iIntValue), C0493bg.m2684a(contentValues.getAsString("message_content")), "");
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
    private long m4106f(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
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
    private com.sec.chaton.provider.EnumC1069a m4107g(android.database.sqlite.SQLiteDatabase r14, android.content.ContentValues r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 384
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.ChatONProvider.m4107g(android.database.sqlite.SQLiteDatabase, android.content.ContentValues):com.sec.chaton.provider.a");
    }

    /* renamed from: a */
    private void m4098a(SQLiteDatabase sQLiteDatabase, String str, String str2) throws SQLException {
        String strM5916a = C1733ap.m5916a();
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_no", strM5916a);
        contentValues.put("buddy_no", str);
        sQLiteDatabase.insertOrThrow("inbox_buddy_relation", null, contentValues);
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("inbox_no", strM5916a);
        contentValues2.put("inbox_chat_type", Integer.valueOf(EnumC0695j.ONETOONE.m3146a()));
        contentValues2.put("inbox_last_chat_type", (Integer) 12);
        if (!TextUtils.isEmpty(str2)) {
            contentValues2.put("inbox_session_id", str2);
        }
        sQLiteDatabase.insertOrThrow("inbox", null, contentValues2);
    }

    /* renamed from: a */
    private Cursor m4096a(SQLiteDatabase sQLiteDatabase, C0711z c0711z, String[] strArr, String str, String[] strArr2, String str2) {
        sQLiteDatabase.beginTransaction();
        String str3 = strArr2[1];
        String[] strArr3 = {strArr2[0]};
        boolean z = false;
        try {
            Cursor cursorM3181a = c0711z.m3184a(str, strArr3).m3181a(sQLiteDatabase, strArr, str2);
            if (cursorM3181a == null || cursorM3181a.getCount() == 0) {
                m4098a(sQLiteDatabase, strArr2[0], str3);
                z = true;
            } else {
                cursorM3181a.moveToFirst();
                String string = cursorM3181a.getString(cursorM3181a.getColumnIndex("inbox_session_id"));
                if (TextUtils.isEmpty(string)) {
                    if (!TextUtils.isEmpty(str3)) {
                        String string2 = cursorM3181a.getString(cursorM3181a.getColumnIndex("inbox_no"));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("inbox_session_id", str3);
                        sQLiteDatabase.update("inbox", contentValues, "inbox_no=?", new String[]{string2});
                        z = true;
                    }
                } else if (!TextUtils.isEmpty(str3) && !string.equals(str3)) {
                    String string3 = cursorM3181a.getString(cursorM3181a.getColumnIndex("inbox_no"));
                    sQLiteDatabase.delete("inbox_buddy_relation", "inbox_no=?", new String[]{string3});
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("inbox_valid", "N");
                    sQLiteDatabase.update("inbox", contentValues2, "inbox_no = ?", new String[]{string3});
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    String string4 = cursorM3181a.getString(cursorM3181a.getColumnIndex("buddy_name"));
                    ContentValues contentValues3 = new ContentValues();
                    contentValues3.put("_id", Long.valueOf(C1735ar.m5918a()));
                    contentValues3.put("message_inbox_no", string3);
                    contentValues3.put("message_type", (Integer) 1);
                    contentValues3.put("message_content_type", Integer.valueOf(EnumC0699n.SYSTEM.m3162a()));
                    contentValues3.put("message_content", String.format("%d,%s,%s", Integer.valueOf(EnumC0705t.INVALID_USER.m3171a()), strArr2[0], C0493bg.m2684a(string4)));
                    contentValues3.put("message_time", Long.valueOf(jCurrentTimeMillis));
                    contentValues3.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(jCurrentTimeMillis)));
                    sQLiteDatabase.insertOrThrow("message", null, contentValues3);
                    m4098a(sQLiteDatabase, strArr2[0], str3);
                    z = true;
                }
            }
            sQLiteDatabase.setTransactionSuccessful();
            if (z) {
                if (cursorM3181a != null) {
                    cursorM3181a.close();
                }
                return c0711z.m3184a(str, strArr3).m3181a(sQLiteDatabase, strArr, str2);
            }
            return cursorM3181a;
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }
}
