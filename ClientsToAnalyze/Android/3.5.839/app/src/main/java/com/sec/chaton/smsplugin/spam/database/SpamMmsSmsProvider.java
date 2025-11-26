package com.sec.chaton.smsplugin.spam.database;

import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.provider.Telephony;
import android.text.TextUtils;
import android.util.Log;
import com.p137vk.sdk.VKAccessToken;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.amsoma.AMSLibs;
import com.sec.chaton.smsplugin.spam.C4012bp;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class SpamMmsSmsProvider extends ContentProvider {

    /* renamed from: a */
    private static final UriMatcher f14507a = new UriMatcher(-1);

    /* renamed from: b */
    private static final String[] f14508b = {"_id", "date", "date_sent", "read", "thread_id", "locked"};

    /* renamed from: c */
    private static final String[] f14509c = {"ct_cls", "ct_l", "ct_t", "d_rpt", "exp", "m_cls", "m_id", "m_size", "m_type", "msg_box", "pri", "read_status", "resp_st", "resp_txt", "retr_st", "retr_txt_cs", "rpt_a", "rr", "st", "sub", "sub_cs", "tr_id", VKApiConst.VERSION};

    /* renamed from: d */
    private static final String[] f14510d = {"address", "body", "person", "reply_path_present", "service_center", "status", "subject", "type", VKApiConst.ERROR_CODE, "callback_number", "reserved", "teleservice_id", "link_url"};

    /* renamed from: e */
    private static final String[] f14511e = {"body", "type", "href", "si_id", VKAccessToken.CREATED, "si_expires", "action"};

    /* renamed from: f */
    private static final String[] f14512f = new String[(((f14508b.length + f14509c.length) + f14511e.length) - 2) + f14510d.length];

    /* renamed from: g */
    private static final Set<String> f14513g = new HashSet();

    /* renamed from: h */
    private static final Set<String> f14514h = new HashSet();

    /* renamed from: i */
    private static final Set<String> f14515i = new HashSet();

    /* renamed from: j */
    private static final String[] f14516j = new String[0];

    /* renamed from: k */
    private SQLiteOpenHelper f14517k;

    /* renamed from: l */
    private int f14518l = 0;

    /* renamed from: m */
    private final Uri f14519m = Uri.parse("content://com.android.contacts/data/phone_emails/filter");

    static {
        f14507a.addURI(C4012bp.f14465a, "spam-filter", AMSLibs.ENUM_VIP_AMS_SAVE_THUMBNAIL_IMAGE_SIZE);
        f14507a.addURI(C4012bp.f14465a, "spam-filter/#", 401);
        f14507a.addURI(C4012bp.f14465a, "spam-messages", 402);
        m15488a();
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.f14517k = C4025a.m15497a(getContext());
        this.f14518l = 0;
        Log.d("TP/SpamMmsSmsProvider", "set contact matching CLI digits:" + this.f14518l);
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        SQLiteDatabase readableDatabase = this.f14517k.getReadableDatabase();
        C4026b.m15502a();
        int iMatch = f14507a.match(uri);
        Log.v("TP/SpamMmsSmsProvider", "query,matched:" + iMatch);
        switch (iMatch) {
            case AMSLibs.ENUM_VIP_AMS_SAVE_THUMBNAIL_IMAGE_SIZE /* 400 */:
                return readableDatabase.query("spam_filter", strArr, str, strArr2, null, null, str2);
            case 401:
            default:
                throw new IllegalStateException("Unrecognized URI:" + uri);
            case 402:
                Cursor cursorM15486a = m15486a(strArr, str, str2);
                if (cursorM15486a != null) {
                    cursorM15486a.setNotificationUri(getContext().getContentResolver(), Telephony.MmsSms.CONTENT_URI);
                }
                Log.d("TP/SpamMmsSmsProvider", "match " + iMatch + ":" + C4026b.m15503b());
                return cursorM15486a;
        }
    }

    /* renamed from: a */
    private static String m15487a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        return TextUtils.isEmpty(str2) ? str : str + " AND " + str2;
    }

    /* renamed from: a */
    private static String[] m15491a(String[] strArr) {
        return strArr == null ? f14512f : strArr;
    }

    /* renamed from: a */
    private Cursor m15486a(String[] strArr, String str, String str2) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        SQLiteQueryBuilder sQLiteQueryBuilder2 = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setDistinct(true);
        sQLiteQueryBuilder2.setDistinct(true);
        sQLiteQueryBuilder.setTables("spam_pdu");
        sQLiteQueryBuilder2.setTables("spam_sms");
        String[] strArrM15491a = m15491a(strArr);
        String[] strArrM15492a = m15492a(m15491a(strArr), 1000);
        String[] strArrM15492a2 = m15492a(strArrM15491a, 1);
        String strBuildUnionSubQuery = sQLiteQueryBuilder.buildUnionSubQuery("transport_type", strArrM15492a, new HashSet(f14513g), 0, "mms", m15487a(m15487a(str, "msg_box != 3"), "(msg_box != 3 AND (m_type = 128 OR m_type = 132 OR m_type = 130))"), null, null);
        HashSet hashSet = new HashSet(f14514h);
        hashSet.add(VKApiConst.GROUP_ID);
        hashSet.add("group_type");
        String strBuildUnionSubQuery2 = sQLiteQueryBuilder2.buildUnionSubQuery("transport_type", strArrM15492a2, hashSet, 0, "sms", m15487a(str, "(type != 3)"), null, null);
        SQLiteQueryBuilder sQLiteQueryBuilder3 = new SQLiteQueryBuilder();
        sQLiteQueryBuilder3.setDistinct(true);
        String strBuildUnionQuery = sQLiteQueryBuilder3.buildUnionQuery(new String[]{strBuildUnionSubQuery2, strBuildUnionSubQuery}, null, null);
        SQLiteQueryBuilder sQLiteQueryBuilder4 = new SQLiteQueryBuilder();
        sQLiteQueryBuilder4.setTables("(" + strBuildUnionQuery + ")");
        return this.f14517k.getReadableDatabase().rawQuery(sQLiteQueryBuilder4.buildQuery(strArrM15491a, null, null, null, str2, null), f14516j);
    }

    /* renamed from: a */
    private static String[] m15492a(String[] strArr, int i) {
        int length = strArr.length;
        String[] strArr2 = new String[length + 1];
        strArr2[0] = "date * " + i + " AS normalized_date";
        System.arraycopy(strArr, 0, strArr2, 1, length);
        return strArr2;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return "vnd.android-dir/mms-sms";
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) throws NumberFormatException {
        int iDelete;
        SQLiteDatabase writableDatabase = this.f14517k.getWritableDatabase();
        switch (f14507a.match(uri)) {
            case AMSLibs.ENUM_VIP_AMS_SAVE_THUMBNAIL_IMAGE_SIZE /* 400 */:
                iDelete = writableDatabase.delete("spam_filter", str, strArr);
                if (iDelete > 0) {
                    m15493a(C4012bp.f14468d);
                }
                return iDelete;
            case 401:
                try {
                    iDelete = writableDatabase.delete("spam_filter", "_id=" + Integer.parseInt(uri.getLastPathSegment()), null);
                    if (iDelete > 0) {
                        m15493a(C4012bp.f14468d);
                    }
                    return iDelete;
                } catch (Exception e) {
                    throw new IllegalArgumentException("Bad spam filter id: " + uri.toString());
                }
            default:
                throw new UnsupportedOperationException("SpamMmsSmsProvider does not support deletes, inserts, or updates for this URI.");
        }
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        SQLiteDatabase writableDatabase = this.f14517k.getWritableDatabase();
        switch (f14507a.match(uri)) {
            case AMSLibs.ENUM_VIP_AMS_SAVE_THUMBNAIL_IMAGE_SIZE /* 400 */:
                long jInsert = writableDatabase.insert("spam_filter", null, contentValues);
                if (jInsert > 0) {
                    Uri uriWithAppendedPath = Uri.withAppendedPath(C4012bp.f14468d, Long.toString(jInsert));
                    Log.d("TP/SpamMmsSmsProvider", "insert " + uriWithAppendedPath + " succeeded");
                    m15493a(uri);
                    return uriWithAppendedPath;
                }
                Log.e("TP/SpamMmsSmsProvider", "insert: failed! " + contentValues.toString());
                return null;
            default:
                throw new UnsupportedOperationException("SpamMmsSmsProvider does not support deletes, inserts, or updates for this URI.");
        }
    }

    /* renamed from: a */
    public void m15493a(Uri uri) {
        getContext().getContentResolver().notifyChange(uri, null);
    }

    /* renamed from: a */
    public static void m15490a(Context context) {
        Intent intent = new Intent("android.provider.Telephony.Threads.action.READ_CHANGED");
        Log.v("TP/SpamMmsSmsProvider", "Broadcasting intent: " + intent);
        context.sendBroadcast(intent);
    }

    /* renamed from: a */
    public static void m15489a(int i, Context context) {
        boolean z = i > 0;
        Log.d("TP/SpamMmsSmsProvider", "need read changed broadcast:" + z);
        if (z) {
            m15490a(context);
        }
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        SQLiteDatabase writableDatabase = this.f14517k.getWritableDatabase();
        Log.v("TP/SpamMmsSmsProvider", "update uri: " + uri);
        switch (f14507a.match(uri)) {
            case 401:
                int iUpdate = writableDatabase.update("spam_filter", contentValues, m15487a(str, "_id=" + uri.getLastPathSegment()), strArr);
                if (iUpdate > 0) {
                    m15493a(C4012bp.f14468d);
                }
                return iUpdate;
            default:
                throw new UnsupportedOperationException("SpamMmsSmsProvider does not support deletes, inserts, or updates for this URI.");
        }
    }

    /* renamed from: a */
    private static void m15488a() {
        int length = f14508b.length;
        int length2 = f14509c.length;
        int length3 = f14510d.length;
        HashSet hashSet = new HashSet();
        for (int i = 0; i < length; i++) {
            try {
                f14513g.add(f14508b[i]);
            } catch (NoSuchMethodError e) {
                Log.e("TP/SpamMmsSmsProvider", "initializeColumnSets - NoSuchMethodError : MMS_SMS_COLUMNS[" + i + "] = " + f14508b[i]);
            }
            f14514h.add(f14508b[i]);
            f14515i.add(f14508b[i]);
            hashSet.add(f14508b[i]);
        }
        for (int i2 = 0; i2 < length2; i2++) {
            f14513g.add(f14509c[i2]);
            hashSet.add(f14509c[i2]);
        }
        for (int i3 = 0; i3 < length3; i3++) {
            f14514h.add(f14510d[i3]);
            hashSet.add(f14510d[i3]);
        }
        int length4 = f14511e.length;
        for (int i4 = 0; i4 < length4; i4++) {
            f14515i.add(f14511e[i4]);
            hashSet.add(f14511e[i4]);
        }
        Iterator it = hashSet.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            f14512f[i5] = (String) it.next();
            i5++;
        }
    }
}
