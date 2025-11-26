package com.sec.chaton.p057e.p058a;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.p137vk.sdk.api.VKApiConst;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1015an;
import com.sec.chaton.C1066bf;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.chat.EnumC1774ht;
import com.sec.chaton.chat.notification.C1813b;
import com.sec.chaton.chat.notification.C1828q;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgsend.C2695c;
import com.sec.chaton.msgsend.EnumC2692aj;
import com.sec.chaton.multimedia.doc.EnumC2758b;
import com.sec.chaton.multimedia.doc.FileExplorerActivity;
import com.sec.chaton.p046a.C0864cr;
import com.sec.chaton.p046a.EnumC0908eh;
import com.sec.chaton.p055d.C2142w;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.p057e.C2306z;
import com.sec.chaton.p057e.EnumC2213aa;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2215ac;
import com.sec.chaton.p057e.EnumC2216ad;
import com.sec.chaton.p057e.EnumC2231as;
import com.sec.chaton.p057e.EnumC2292l;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p065io.entry.PushEntry;
import com.sec.chaton.p065io.entry.inner.Message;
import com.sec.chaton.p065io.entry.inner.Msg;
import com.sec.chaton.provider.C3037b;
import com.sec.chaton.settings.p096a.C3460d;
import com.sec.chaton.specialbuddy.EnumC4548m;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4821am;
import com.sec.chaton.util.C4843bh;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4874cl;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.spp.push.Config;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: MessageDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.r */
/* loaded from: classes.dex */
public class C2204r {
    /* renamed from: a */
    public static boolean m10038a(ContentResolver contentResolver, String str, String str2, String str3) {
        Cursor cursorQuery = contentResolver.query(C2306z.f8229a, new String[]{"message_type"}, "message_sever_id=? AND message_inbox_no=? AND message_sender=?", new String[]{str2, str3, str}, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() != 0) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return true;
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m10049b(ContentResolver contentResolver, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return true;
        }
        Cursor cursorQuery = contentResolver.query(C2306z.f8229a, null, "message_sever_id=? AND message_session_id=? AND message_sender=?", new String[]{str2, str3, str}, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() != 0) {
                    cursorQuery.moveToFirst();
                    if ("Y".equals(cursorQuery.getString(cursorQuery.getColumnIndex("message_need_update")))) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return true;
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return false;
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m10037a(ContentResolver contentResolver, String str, String str2) {
        Cursor cursorQuery = contentResolver.query(C2306z.f8229a, null, "message_sever_id=? AND message_inbox_no=? AND message_content_type=?", new String[]{str, str2, String.valueOf(EnumC2214ab.SYSTEM.m10076a())}, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() != 0) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return true;
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m10035a(ContentResolver contentResolver, String str) {
        Cursor cursorQuery = contentResolver.query(C2306z.f8229a, null, "_id=?", new String[]{str}, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() != 0) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return true;
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public static EnumC2214ab m10021a(String str, String str2) {
        EnumC2214ab enumC2214ab = EnumC2214ab.UNDEFINED;
        if (Config.NOTIFICATION_INTENT_MSG.equals(str2)) {
            return EnumC2214ab.TEXT;
        }
        if ("media".equals(str2)) {
            return m10019a(str);
        }
        if ("content".equals(str2)) {
            try {
                return m10022a(new JSONObject(str));
            } catch (JSONException e) {
                C4904y.m18635a(e, "MessageDatabaseHelper");
                return EnumC2214ab.TEXT;
            }
        }
        return enumC2214ab;
    }

    /* renamed from: a */
    public static EnumC0908eh m10018a(EnumC2214ab enumC2214ab) {
        EnumC0908eh enumC0908eh = EnumC0908eh.TEXT;
        switch (C2205s.f7869a[enumC2214ab.ordinal()]) {
        }
        return EnumC0908eh.TEXT;
    }

    /* renamed from: a */
    public static EnumC2214ab m10020a(String str, int i) {
        EnumC2214ab enumC2214ab = EnumC2214ab.UNDEFINED;
        switch (i) {
            case 0:
                return EnumC2214ab.TEXT;
            case 1:
                return m10019a(str);
            case 2:
            case 3:
            default:
                return EnumC2214ab.UNDEFINED;
            case 4:
                try {
                    return m10022a(new JSONObject(str));
                } catch (JSONException e) {
                    C4904y.m18635a(e, "MessageDatabaseHelper");
                    return EnumC2214ab.TEXT;
                }
        }
    }

    /* renamed from: a */
    public static EnumC2214ab m10022a(JSONObject jSONObject) throws JSONException {
        String string = jSONObject.getString("type");
        if ("poll".equalsIgnoreCase(string)) {
            return EnumC2214ab.POLL;
        }
        if ("link".equalsIgnoreCase(string)) {
            return EnumC2214ab.APPLINK;
        }
        if ("specialbuddy".equalsIgnoreCase(string)) {
            return EnumC2214ab.LIVECONTENTS;
        }
        if ("live_share".equalsIgnoreCase(string)) {
            return EnumC2214ab.LIVESHARE;
        }
        if ("live_recommend".equalsIgnoreCase(string)) {
            return EnumC2214ab.LIVERECOMMEND;
        }
        return EnumC2214ab.UNDEFINED;
    }

    /* renamed from: a */
    public static EnumC2214ab m10019a(String str) {
        EnumC2214ab enumC2214ab = EnumC2214ab.UNDEFINED;
        String[] strArrSplit = str.split("\n");
        if (strArrSplit == null || strArrSplit.length < 4) {
            return EnumC2214ab.UNDEFINED;
        }
        String str2 = strArrSplit[0];
        if ("mixed".equals(str2)) {
            str2 = strArrSplit[1];
        }
        if (SlookAirButtonRecentMediaAdapter.IMAGE_TYPE.equals(str2)) {
            EnumC2214ab enumC2214ab2 = EnumC2214ab.IMAGE;
            if (C3460d.m13778b(str)) {
                return EnumC2214ab.ANICON;
            }
            return enumC2214ab2;
        }
        if ("video".equals(str2)) {
            return EnumC2214ab.VIDEO;
        }
        if ("geo".equals(str2)) {
            return EnumC2214ab.GEO;
        }
        if ("audio".equals(str2)) {
            return EnumC2214ab.AUDIO;
        }
        if ("contact".equals(str2)) {
            return EnumC2214ab.CONTACT;
        }
        if ("calendar".equals(str2)) {
            return EnumC2214ab.CALENDAR;
        }
        if ("doc".equals(str2)) {
            if (FileExplorerActivity.m11581d(strArrSplit[3]) != EnumC2758b.UNKNOWN) {
                return EnumC2214ab.DOCUMENT;
            }
        } else if ("file".equals(str2)) {
            if (FileExplorerActivity.m11581d(strArrSplit[3]) != EnumC2758b.UNKNOWN) {
                return EnumC2214ab.FILE;
            }
        } else {
            if ("ams".equals(str2)) {
                return EnumC2214ab.AMS;
            }
            if ("anicon".equals(str2)) {
                return EnumC2214ab.ANICON;
            }
            if ("glympse".equals(str2)) {
                return EnumC2214ab.GLYMPSE;
            }
            if ("hugefile".equals(str2)) {
                return EnumC2214ab.HUGEFILE;
            }
        }
        return enumC2214ab;
    }

    /* renamed from: a */
    public static boolean m10036a(ContentResolver contentResolver, String str, EnumC2214ab enumC2214ab, PushEntry pushEntry, EnumC2300t enumC2300t) throws NumberFormatException {
        ContentValues contentValues = new ContentValues();
        if (C4809aa.m18104a().m18121a("chaton_id", "").equals(pushEntry.senderID)) {
            contentValues.put("_id", pushEntry.msgID);
        } else {
            contentValues.put("_id", Long.valueOf(C4843bh.m18322a()));
        }
        contentValues.put("message_sever_id", pushEntry.msgID);
        contentValues.put("message_inbox_no", str);
        contentValues.put("message_content", pushEntry.message);
        contentValues.put("message_time", pushEntry.sentTime);
        if (C4809aa.m18104a().m18121a("chaton_id", "").equals(pushEntry.senderID)) {
            contentValues.put("message_type", (Integer) 1);
        } else {
            contentValues.put("message_type", (Integer) 2);
        }
        if (C4809aa.m18104a().m18121a("chaton_id", "").equals(pushEntry.senderID)) {
            contentValues.put("message_read_status", (Integer) 0);
        }
        if (!TextUtils.isEmpty(pushEntry.userType)) {
            int i = Integer.parseInt(pushEntry.userType);
            EnumC2213aa enumC2213aa = EnumC2213aa.ACK_NOT_YET;
            EnumC2215ac enumC2215ac = EnumC2215ac.UNREAD;
            if (!TextUtils.isEmpty(pushEntry.reliability)) {
                if (C1813b.m8906b().m8931a(str) && C1813b.m8906b().m8933b(str) == i) {
                    if (EnumC4548m.LIVENONEREPORTREAD.equals(pushEntry.reliability)) {
                        enumC2215ac = EnumC2215ac.READ_SERVER;
                        enumC2213aa = EnumC2213aa.ACK_DONE;
                    } else {
                        enumC2215ac = EnumC4548m.LIVEREPORTONLY.equals(pushEntry.reliability) ? EnumC2215ac.READ_SERVER : EnumC2215ac.READ_LOCAL;
                    }
                } else {
                    enumC2215ac = EnumC2215ac.UNREAD;
                    if (EnumC4548m.LIVENONEREPORTREAD.equals(pushEntry.reliability)) {
                        enumC2213aa = EnumC2213aa.ACK_DONE;
                    }
                }
            }
            contentValues.put("message_is_ack", Integer.valueOf(enumC2213aa.m10069a()));
            contentValues.put("message_is_read", Integer.valueOf(enumC2215ac.m10080a()));
            if (C4809aa.m18104a().m18121a("chaton_id", "").equals(pushEntry.senderID) && EnumC1774ht.m8782a(pushEntry.userType) == EnumC1774ht.PUT_LIVE_CHAT) {
                contentValues.put("message_read_status", (Integer) 1);
            } else {
                contentValues.put("message_read_status", (Integer) 0);
            }
        }
        contentValues.put("message_sender", pushEntry.senderID);
        contentValues.put("message_session_id", pushEntry.sessionID);
        contentValues.put("message_content_type", Integer.valueOf(enumC2214ab.m10076a()));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(pushEntry.sentTime));
        contentValues.put("message_need_update", "Y");
        contentValues.put("message_is_truncated", pushEntry.truncated.booleanValue() ? "Y" : "N");
        Uri uriInsert = contentResolver.insert(C2306z.m10222c(), contentValues);
        if (uriInsert != null) {
            return C3037b.m12496a(uriInsert) || C2306z.m10217a(uriInsert, 2) == null;
        }
        return false;
    }

    /* renamed from: a */
    public static EnumC2292l m10025a(ContentResolver contentResolver, String str, EnumC2214ab enumC2214ab, Msg msg, String str2, boolean z) {
        EnumC2292l enumC2292l = EnumC2292l.FAIL;
        ContentValues contentValues = new ContentValues();
        if (C4809aa.m18104a().m18121a("chaton_id", "").equals(msg.sender)) {
            contentValues.put("_id", msg.f8574id);
        } else {
            contentValues.put("_id", Long.valueOf(C4843bh.m18322a()));
        }
        contentValues.put("message_sever_id", msg.f8574id);
        contentValues.put("message_inbox_no", str);
        if (z) {
            contentValues.put("message_content", GlobalApplication.m18732r().getString(R.string.message_is_recalled));
            return enumC2292l;
        }
        contentValues.put("message_content", msg.value);
        contentValues.put("message_time", msg.time);
        contentValues.put("message_tid", msg.tid);
        if (msg.msgTranslated != null) {
            contentValues.put("message_content_translated", msg.msgTranslated);
        }
        if (msg.msgFromLang != null) {
            contentValues.put("message_from_lang", msg.msgFromLang);
        }
        if (msg.msgToLang != null) {
            contentValues.put("message_to_lang", msg.msgToLang);
        }
        if (C4809aa.m18104a().m18121a("chaton_id", "").equals(msg.sender)) {
            contentValues.put("message_type", (Integer) 1);
        } else {
            contentValues.put("message_type", (Integer) 2);
        }
        contentValues.put("message_sender", msg.sender);
        contentValues.put("message_session_id", msg.sessionid);
        contentValues.put("message_content_type", Integer.valueOf(enumC2214ab.m10076a()));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(msg.time));
        contentValues.put("message_need_update", "N");
        contentValues.put("message_read_status", (Integer) 0);
        contentValues.put("message_is_truncated", "N");
        if (str2 != null) {
            contentValues.put("message_formatted", str2);
        }
        Uri uriInsert = contentResolver.insert(C2306z.m10222c(), contentValues);
        if (uriInsert != null) {
            if (!C3037b.m12496a(uriInsert) && C2306z.m10217a(uriInsert, 2) != null) {
                return EnumC2292l.INSERT;
            }
            return EnumC2292l.UPDATE;
        }
        return enumC2292l;
    }

    /* renamed from: a */
    public static ContentProviderOperation m10009a(ContentResolver contentResolver, String str, EnumC2214ab enumC2214ab, Message message, String str2, String str3) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C2306z.m10222c());
        ContentValues contentValues = new ContentValues();
        if (C4809aa.m18104a().m18121a("chaton_id", "").equals(message.sender)) {
            contentValues.put("_id", message.f8571id);
        } else {
            contentValues.put("_id", Long.valueOf(C4843bh.m18322a()));
        }
        contentValues.put("message_sever_id", message.f8571id);
        contentValues.put("message_inbox_no", str);
        contentValues.put("message_content", message.msg);
        contentValues.put("message_time", message.time);
        contentValues.put("message_tid", message.tid);
        if (C4809aa.m18104a().m18121a("chaton_id", "").equals(message.sender)) {
            contentValues.put("message_type", (Integer) 1);
            if (message.readcount.intValue() > message.sendcount.intValue()) {
                if (C4904y.f17875e) {
                    C4904y.m18634a("msg.id : " + message.f8571id + ", msg.readcount : " + message.readcount + ", msg.sendcount : " + message.sendcount, "MessageDatabaseHelper");
                }
                message.readcount = message.sendcount;
            }
            contentValues.put("message_read_status", message.readcount);
        } else {
            contentValues.put("message_type", (Integer) 2);
            contentValues.put("message_read_status", (Integer) 0);
        }
        contentValues.put("message_sender", message.sender);
        contentValues.put("message_session_id", str2);
        contentValues.put("message_content_type", Integer.valueOf(enumC2214ab.m10076a()));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(message.time));
        contentValues.put("message_need_update", "N");
        contentValues.put("message_is_truncated", "N");
        if (str3 != null) {
            contentValues.put("message_formatted", str3);
        }
        builderNewInsert.withValues(contentValues);
        return builderNewInsert.build();
    }

    /* renamed from: a */
    public static EnumC2292l m10024a(ContentResolver contentResolver, String str, EnumC2214ab enumC2214ab, C0864cr c0864cr, String str2, String str3, String str4, EnumC2300t enumC2300t, String str5, String str6, String str7, boolean z) {
        EnumC2292l enumC2292l = EnumC2292l.FAIL;
        ContentValues contentValues = new ContentValues();
        if (C4809aa.m18104a().m18121a("chaton_id", "").equals(str3)) {
            contentValues.put("_id", Long.valueOf(c0864cr.m4154h()));
        } else {
            contentValues.put("_id", Long.valueOf(C4843bh.m18322a()));
        }
        contentValues.put("message_sever_id", Long.valueOf(c0864cr.m4154h()));
        contentValues.put("message_inbox_no", str2);
        if (z) {
            contentValues.put("message_content", GlobalApplication.m18732r().getString(R.string.message_is_recalled));
            return enumC2292l;
        }
        contentValues.put("message_content", c0864cr.m4156j());
        contentValues.put("message_time", Long.valueOf(c0864cr.m4158l()));
        if (str7 != null) {
            contentValues.put("message_content_translated", str7);
        }
        if (str5 != null) {
            contentValues.put("message_from_lang", str5);
        }
        if (str6 != null) {
            contentValues.put("message_to_lang", str6);
        }
        if (C4809aa.m18104a().m18121a("chaton_id", "").equals(str3)) {
            contentValues.put("message_type", (Integer) 1);
        } else {
            contentValues.put("message_type", (Integer) 2);
        }
        contentValues.put("message_sender", str3);
        contentValues.put("message_session_id", str);
        contentValues.put("message_content_type", Integer.valueOf(enumC2214ab.m10076a()));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(c0864cr.m4158l())));
        contentValues.put("message_need_update", "N");
        contentValues.put("message_read_status", (Integer) 0);
        contentValues.put("message_is_truncated", "N");
        if (!TextUtils.isEmpty(str4)) {
            contentValues.put("message_formatted", str4);
        }
        Uri uriInsert = contentResolver.insert(C2306z.m10222c(), contentValues);
        if (uriInsert != null) {
            if (!C3037b.m12496a(uriInsert) && C2306z.m10217a(uriInsert, 2) != null) {
                return EnumC2292l.INSERT;
            }
            return EnumC2292l.UPDATE;
        }
        return enumC2292l;
    }

    /* renamed from: a */
    public static Uri m10016a(ContentResolver contentResolver, String str, String str2, EnumC2214ab enumC2214ab, String str3, String str4, int i, int i2) {
        return m10017a(contentResolver, str, str2, enumC2214ab, str3, str4, i, i2, null, null);
    }

    /* renamed from: a */
    public static Uri m10017a(ContentResolver contentResolver, String str, String str2, EnumC2214ab enumC2214ab, String str3, String str4, int i, int i2, String str5, String str6) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", str);
        contentValues.put("message_inbox_no", str2);
        contentValues.put("message_read_status", (Integer) 0);
        contentValues.put("message_content_type", Integer.valueOf(enumC2214ab.m10076a()));
        contentValues.put("message_content", str3);
        contentValues.put("message_need_update", "N");
        if (!TextUtils.isEmpty(str5)) {
            contentValues.put("message_from_lang", str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            contentValues.put("message_to_lang", str6);
        }
        if (str4 != null) {
            contentValues.put("message_content_translated", str4);
        }
        contentValues.put("message_sender", C4809aa.m18104a().m18121a("chaton_id", ""));
        long jCurrentTimeMillis = System.currentTimeMillis();
        contentValues.put("message_time", Long.valueOf(jCurrentTimeMillis));
        contentValues.put("message_type", Integer.valueOf(i2));
        contentValues.put("message_is_failed", (Integer) 1);
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(jCurrentTimeMillis)));
        return contentResolver.insert(C2306z.f8229a, contentValues);
    }

    /* renamed from: a */
    public static Uri m10014a(ContentResolver contentResolver, String str, String str2, EnumC2214ab enumC2214ab, String str3, int i, String str4, int i2, String str5) {
        return m10015a(contentResolver, str, str2, enumC2214ab, str3, i, str4, i2, null, null, null);
    }

    /* renamed from: a */
    public static Uri m10015a(ContentResolver contentResolver, String str, String str2, EnumC2214ab enumC2214ab, String str3, int i, String str4, int i2, String str5, String str6, String str7) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", str);
        contentValues.put("message_sever_id", str);
        contentValues.put("message_inbox_no", str2);
        contentValues.put("message_read_status", (Integer) 0);
        contentValues.put("message_content_type", Integer.valueOf(enumC2214ab.m10076a()));
        contentValues.put("message_download_uri", str3);
        contentValues.put("message_sender", C4809aa.m18104a().m18121a("chaton_id", ""));
        contentValues.put("message_need_update", "N");
        long jCurrentTimeMillis = System.currentTimeMillis();
        contentValues.put("message_time", Long.valueOf(jCurrentTimeMillis));
        contentValues.put("message_type", Integer.valueOf(i2));
        if (!TextUtils.isEmpty(str6)) {
            contentValues.put("message_from_lang", str6);
        }
        if (!TextUtils.isEmpty(str7)) {
            contentValues.put("message_to_lang", str7);
        }
        contentValues.put("message_is_failed", (Integer) 1);
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(jCurrentTimeMillis)));
        contentValues.put("message_stored_ext", Integer.valueOf(C4873ck.m18500a() ? 1 : 0));
        contentValues.put("message_content", str4);
        if (!TextUtils.isEmpty(str5)) {
            contentValues.put("message_content_translated", str5);
        }
        return contentResolver.insert(C2306z.f8229a, contentValues);
    }

    /* renamed from: a */
    public static void m10033a(C2210x c2210x, int i, String str, String str2, String str3) {
        long jCurrentTimeMillis;
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(C4843bh.m18322a()));
        contentValues.put("message_inbox_no", str);
        contentValues.put("message_type", (Integer) 1);
        contentValues.put("message_content_type", Integer.valueOf(EnumC2214ab.SYSTEM.m10076a()));
        contentValues.put("message_content", str2);
        long jM9914a = C2198l.m9914a(GlobalApplication.m18732r().getContentResolver(), str);
        if (jM9914a == 0) {
            jCurrentTimeMillis = System.currentTimeMillis();
        } else {
            jCurrentTimeMillis = jM9914a + 1;
        }
        contentValues.put("message_time", Long.valueOf(jCurrentTimeMillis));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(jCurrentTimeMillis)));
        contentValues.put("message_sender", str3);
        c2210x.startInsert(i, null, C2306z.f8229a, contentValues);
    }

    /* renamed from: b */
    public static void m10048b(C2210x c2210x, int i, String str, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        long jCurrentTimeMillis = System.currentTimeMillis();
        contentValues.put("message_time", Long.valueOf(jCurrentTimeMillis));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(jCurrentTimeMillis)));
        contentValues.put("_id", Long.valueOf(C4843bh.m18322a()));
        contentValues.put("message_inbox_no", str);
        contentValues.put("message_type", (Integer) 1);
        contentValues.put("message_content_type", Integer.valueOf(EnumC2214ab.SYSTEM.m10076a()));
        contentValues.put("message_content", str2);
        contentValues.put("message_sender", str3);
        c2210x.startInsert(i, null, C2306z.f8229a, contentValues);
    }

    /* renamed from: c */
    public static void m10054c(C2210x c2210x, int i, String str, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        long jCurrentTimeMillis = System.currentTimeMillis();
        contentValues.put("message_time", Long.valueOf(jCurrentTimeMillis));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(jCurrentTimeMillis)));
        contentValues.put("_id", Long.valueOf(C4843bh.m18322a()));
        contentValues.put("message_inbox_no", str);
        contentValues.put("message_type", (Integer) 1);
        contentValues.put("message_content_type", Integer.valueOf(EnumC2214ab.SYSTEM.m10076a()));
        contentValues.put("message_content", str2);
        contentValues.put("message_sender", str3);
        c2210x.startInsert(i, null, C2306z.f8229a, contentValues);
    }

    /* renamed from: a */
    public static long m10008a(C2210x c2210x, int i, String str, String str2, long j) {
        ContentValues contentValues = new ContentValues();
        long jM18322a = C4843bh.m18322a();
        contentValues.put("_id", Long.valueOf(jM18322a));
        contentValues.put("message_inbox_no", str);
        contentValues.put("message_type", (Integer) 1);
        contentValues.put("message_content_type", Integer.valueOf(EnumC2214ab.SYSTEM.m10076a()));
        contentValues.put("message_content", str2);
        contentValues.put("message_time", Long.valueOf(j));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(j)));
        contentValues.put("message_sender", str);
        c2210x.startInsert(i, null, C2306z.f8229a, contentValues);
        return jM18322a;
    }

    /* renamed from: b */
    public static long m10043b(C2210x c2210x, int i, String str, String str2, long j) {
        ContentValues contentValues = new ContentValues();
        long jM18322a = C4843bh.m18322a();
        contentValues.put("_id", Long.valueOf(jM18322a));
        contentValues.put("message_inbox_no", str);
        contentValues.put("message_type", (Integer) 1);
        contentValues.put("message_content_type", Integer.valueOf(EnumC2214ab.SYSTEM.m10076a()));
        contentValues.put("message_content", str2);
        contentValues.put("message_time", Long.valueOf(j));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(j)));
        contentValues.put("message_sender", "web_only");
        c2210x.startInsert(i, null, C2306z.f8229a, contentValues);
        return jM18322a;
    }

    /* renamed from: a */
    public static Uri m10013a(ContentResolver contentResolver, String str, String str2, long j, String str3, String str4) {
        if (m10037a(contentResolver, str3, str)) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(C4843bh.m18322a()));
        contentValues.put("message_sever_id", str3);
        contentValues.put("message_inbox_no", str);
        contentValues.put("message_type", (Integer) 1);
        contentValues.put("message_content_type", Integer.valueOf(EnumC2214ab.SYSTEM.m10076a()));
        contentValues.put("message_content", str2);
        contentValues.put("message_time", Long.valueOf(j));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(j)));
        contentValues.put("message_sender", str4);
        return contentResolver.insert(C2306z.f8229a, contentValues);
    }

    /* renamed from: a */
    public static long m10007a(ContentResolver contentResolver, String str, String str2, long j, String str3) {
        long jM18322a = C4843bh.m18322a();
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(jM18322a));
        contentValues.put("message_inbox_no", str);
        contentValues.put("message_type", (Integer) 1);
        contentValues.put("message_content_type", Integer.valueOf(EnumC2214ab.SYSTEM.m10076a()));
        contentValues.put("message_content", str2);
        contentValues.put("message_time", Long.valueOf(j));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(j)));
        contentValues.put("message_sender", str3);
        contentResolver.insert(C2306z.f8229a, contentValues);
        return jM18322a;
    }

    /* renamed from: a */
    public static ContentProviderOperation m10010a(String str, String str2, long j, String str3) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C2306z.f8229a);
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(C4843bh.m18322a()));
        contentValues.put("message_inbox_no", str);
        contentValues.put("message_type", (Integer) 1);
        contentValues.put("message_content_type", Integer.valueOf(EnumC2214ab.SYSTEM.m10076a()));
        contentValues.put("message_content", str2);
        contentValues.put("message_time", Long.valueOf(j));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(j)));
        contentValues.put("message_sender", str3);
        builderNewInsert.withValues(contentValues);
        return builderNewInsert.build();
    }

    /* renamed from: a */
    public static int m10005a(ContentResolver contentResolver, String str, String str2, Long l, String str3, EnumC2300t enumC2300t, boolean z, boolean z2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_download_uri", str3);
        contentValues.put("message_inbox_no", str2);
        contentValues.put("message_sever_id", l);
        contentValues.put("message_sender", str);
        contentValues.put("message_stored_ext", Integer.valueOf(z ? 1 : 0));
        if (z2) {
            if (C4809aa.m18104a().m18121a("chaton_id", "").equals(str)) {
                contentValues.put("message_type", (Integer) 1);
            } else {
                contentValues.put("message_type", (Integer) 2);
            }
        } else {
            contentValues.put("message_type", (Integer) 4);
        }
        if (m10038a(contentResolver, str, String.valueOf(l), str2)) {
            return contentResolver.update(C2306z.m10226e(), contentValues, "message_sever_id=? AND message_inbox_no=? AND message_sender=?", new String[]{String.valueOf(l), str2, str});
        }
        C4904y.m18639b("updateMediaURI(Insert)XXX", CommonApplication.m18732r().getClass().getName());
        return -1;
    }

    /* renamed from: a */
    public static int m10004a(ContentResolver contentResolver, String str, String str2, Long l, EnumC2300t enumC2300t, boolean z) {
        if (!m10038a(contentResolver, str, String.valueOf(l), str2)) {
            return -1;
        }
        ContentValues contentValues = new ContentValues();
        if (z) {
            contentValues.put("message_type", (Integer) 3);
        } else {
            contentValues.put("message_type", (Integer) 4);
        }
        return contentResolver.update(C2306z.m10226e(), contentValues, "message_sever_id=? AND message_inbox_no=? AND message_sender=?", new String[]{String.valueOf(l), str2, str});
    }

    /* renamed from: a */
    public static int m10006a(ContentResolver contentResolver, String str, String str2, Long l, String str3, String str4, EnumC2300t enumC2300t, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_content", str3);
        if (!TextUtils.isEmpty(str4)) {
            contentValues.put("message_content_translated", str4);
        }
        contentValues.put("message_stored_ext", Integer.valueOf(z ? 1 : 0));
        return contentResolver.update(C2306z.m10226e(), contentValues, "_id=?", new String[]{String.valueOf(l)});
    }

    /* renamed from: a */
    public static void m10030a(ContentResolver contentResolver, String str, Long l, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_formatted", str2);
        contentValues.put("message_inbox_no", str);
        if (m10035a(contentResolver, String.valueOf(l))) {
            contentResolver.update(C2306z.f8229a, contentValues, "_id=?", new String[]{String.valueOf(l)});
        } else {
            contentValues.put("_id", Long.valueOf(C4843bh.m18322a()));
            contentResolver.insert(C2306z.f8229a, contentValues);
        }
    }

    /* renamed from: a */
    public static void m10031a(ContentResolver contentResolver, String str, Long l, String str2, String str3) {
        if (m10038a(contentResolver, str3, String.valueOf(l), str)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("message_formatted", str2);
            contentResolver.update(C2306z.m10226e(), contentValues, "message_sever_id= ?", new String[]{String.valueOf(l)});
        }
    }

    /* renamed from: a */
    public static int m10002a(ContentResolver contentResolver, Long l, String str, long j, Long l2, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_time", l);
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(l));
        contentValues.put("message_session_id", str);
        contentValues.put("message_sever_id", Long.valueOf(j));
        contentValues.put("message_type", (Integer) 1);
        contentValues.put("message_is_failed", (Integer) 0);
        contentValues.put("message_need_update", "N");
        return contentResolver.update(C2306z.f8229a, contentValues, "_id=?", new String[]{String.valueOf(l2)});
    }

    /* renamed from: b */
    public static ContentProviderOperation m10044b(ContentResolver contentResolver, Long l, String str, long j, Long l2, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_time", l);
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(l));
        contentValues.put("message_session_id", str);
        contentValues.put("message_sever_id", Long.valueOf(j));
        contentValues.put("message_type", (Integer) 1);
        contentValues.put("message_is_failed", (Integer) 0);
        contentValues.put("message_need_update", "N");
        return m10011a("_id=?", new String[]{String.valueOf(l2)}, contentValues);
    }

    /* renamed from: c */
    public static int m10051c(ContentResolver contentResolver, Long l, String str, long j, Long l2, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_time", l);
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(l));
        contentValues.put("message_session_id", str);
        contentValues.put("message_sever_id", Long.valueOf(j));
        contentValues.put("message_type", (Integer) 1);
        contentValues.put("message_is_failed", (Integer) 0);
        contentValues.put("message_need_update", "N");
        contentValues.put("message_read_status", Integer.valueOf(i));
        return contentResolver.update(C2306z.f8229a, contentValues, "_id=?", new String[]{String.valueOf(l2)});
    }

    /* renamed from: a */
    public static int m10000a(ContentResolver contentResolver, Long l, Long l2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_type", (Integer) (-1));
        contentValues.put("message_is_failed", (Integer) 2);
        if (l2.longValue() != -1) {
            contentValues.put("_id", l2);
        }
        return contentResolver.update(C2306z.f8229a, contentValues, "_id= ?", new String[]{Long.toString(l.longValue())});
    }

    /* renamed from: a */
    public static int m9999a(ContentResolver contentResolver, Long l) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_type", (Integer) 6);
        return contentResolver.update(C2306z.f8229a, contentValues, "_id= ?", new String[]{Long.toString(l.longValue())});
    }

    /* renamed from: b */
    public static int m10041b(ContentResolver contentResolver, Long l) {
        return m10000a(contentResolver, l, (Long) (-1L));
    }

    /* renamed from: c */
    public static int m10050c(ContentResolver contentResolver, Long l) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_type", (Integer) 5);
        int iUpdate = contentResolver.update(C2306z.m10226e(), contentValues, "message_sever_id= ?", new String[]{Long.toString(l.longValue())});
        if (C4904y.f17872b) {
            C4904y.m18639b("updatedRow: " + iUpdate + "(_id:" + l + ")", "MessageDatabaseHelper");
        }
        return iUpdate;
    }

    /* renamed from: d */
    public static int m10055d(ContentResolver contentResolver, Long l) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_is_failed", (Integer) 1);
        contentValues.put("message_is_file_upload", (Integer) 1);
        return contentResolver.update(C2306z.m10226e(), contentValues, "_id=?", new String[]{Long.toString(l.longValue())});
    }

    /* renamed from: e */
    public static int m10056e(ContentResolver contentResolver, Long l) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_type", (Integer) 0);
        contentValues.put("message_is_failed", (Integer) 1);
        return contentResolver.update(C2306z.m10226e(), contentValues, "_id=?", new String[]{String.valueOf(l)});
    }

    /* renamed from: a */
    public static int m9998a(ContentResolver contentResolver, C2695c c2695c, EnumC2692aj enumC2692aj) {
        ContentProviderResult[] contentProviderResultArrM18190a;
        ArrayList arrayList = new ArrayList();
        String[] strArrM11308c = c2695c.m11308c();
        ContentValues contentValues = new ContentValues();
        switch (C2205s.f7870b[enumC2692aj.ordinal()]) {
            case 1:
                contentValues.put("message_type", (Integer) (-1));
                contentValues.put("message_is_failed", (Integer) 2);
                break;
            case 2:
                contentValues.put("message_type", (Integer) 1);
                contentValues.put("message_is_failed", (Integer) 0);
                break;
            case 3:
                contentValues.put("message_type", (Integer) 6);
                break;
            case 4:
                contentValues.put("message_type", (Integer) 0);
                contentValues.put("message_is_failed", (Integer) 1);
                break;
            default:
                return -1;
        }
        for (String str : strArrM11308c) {
            arrayList.add(m10011a("_id=?", new String[]{str}, contentValues));
        }
        try {
            contentProviderResultArrM18190a = C4821am.m18190a(GlobalApplication.m18732r(), "com.sec.chaton.provider", (ArrayList<ContentProviderOperation>) arrayList);
        } catch (Exception e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, C2204r.class.getSimpleName());
            }
            contentProviderResultArrM18190a = null;
        }
        if (contentProviderResultArrM18190a == null) {
            return 0;
        }
        return contentProviderResultArrM18190a.length;
    }

    /* renamed from: a */
    public static int m10001a(ContentResolver contentResolver, Long l, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_type", (Integer) 6);
        contentValues.put("message_formatted", str);
        return contentResolver.update(C2306z.f8229a, contentValues, "_id=?", new String[]{Long.toString(l.longValue())});
    }

    /* renamed from: b */
    public static int m10042b(ContentResolver contentResolver, Long l, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_type", (Integer) (-1));
        contentValues.put("message_is_failed", (Integer) 2);
        contentValues.put("message_formatted", str);
        return contentResolver.update(C2306z.f8229a, contentValues, "_id=?", new String[]{Long.toString(l.longValue())});
    }

    /* renamed from: a */
    public static int m9997a(ContentResolver contentResolver) {
        int iUpdate = 0;
        try {
            iUpdate = contentResolver.update(C2306z.m10229h(), new ContentValues(), null, null);
        } catch (IllegalArgumentException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, "MessageDatabaseHelper");
            }
        }
        Log.i("ChatON", "[MessageDatabaseHelper]updateAllSendingMsgToFail() - count:" + iUpdate);
        return iUpdate;
    }

    /* renamed from: b */
    public static int m10040b(ContentResolver contentResolver) {
        int iUpdate = 0;
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("message_type", (Integer) (-1));
            contentValues.put("message_is_failed", (Integer) 2);
            iUpdate = contentResolver.update(C2306z.f8229a, contentValues, "message_type=6", null);
        } catch (IllegalArgumentException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, "MessageDatabaseHelper");
            }
        }
        Log.i("ChatON", "[MessageDatabaseHelper]updateAllPendingMsgToFail() - count:" + iUpdate);
        return iUpdate;
    }

    /* renamed from: b */
    public static C2206t m10045b(ContentResolver contentResolver, String str, String str2) {
        Cursor cursorQuery = contentResolver.query(C2306z.f8229a, null, "message_sever_id=? AND message_sender=?", new String[]{str, str2}, null);
        if (cursorQuery == null || cursorQuery.getCount() == 0) {
            if (cursorQuery == null) {
                return null;
            }
            cursorQuery.close();
            return null;
        }
        cursorQuery.moveToFirst();
        C2206t c2206t = new C2206t();
        c2206t.f7872a = cursorQuery.getLong(cursorQuery.getColumnIndex("_id"));
        c2206t.f7873b = cursorQuery.getLong(cursorQuery.getColumnIndex("message_sever_id"));
        c2206t.f7874c = cursorQuery.getString(cursorQuery.getColumnIndex("message_inbox_no"));
        c2206t.f7875d = cursorQuery.getString(cursorQuery.getColumnIndex("message_session_id"));
        c2206t.f7876e = cursorQuery.getInt(cursorQuery.getColumnIndex("message_read_status"));
        c2206t.f7877f = cursorQuery.getInt(cursorQuery.getColumnIndex("message_content_type"));
        c2206t.f7878g = cursorQuery.getLong(cursorQuery.getColumnIndex("message_time"));
        c2206t.f7879h = cursorQuery.getString(cursorQuery.getColumnIndex("message_content"));
        c2206t.f7880i = cursorQuery.getInt(cursorQuery.getColumnIndex("message_type"));
        c2206t.f7881j = cursorQuery.getString(cursorQuery.getColumnIndex("message_sender"));
        c2206t.f7882k = cursorQuery.getString(cursorQuery.getColumnIndex("message_download_uri"));
        c2206t.f7883l = cursorQuery.getString(cursorQuery.getColumnIndex("message_formatted"));
        c2206t.f7884m = cursorQuery.getString(cursorQuery.getColumnIndex("message_tid"));
        c2206t.f7885n = cursorQuery.getInt(cursorQuery.getColumnIndex("message_stored_ext"));
        c2206t.f7886o = cursorQuery.getString(cursorQuery.getColumnIndex("message_need_update"));
        c2206t.f7887p = cursorQuery.getInt(cursorQuery.getColumnIndex("message_is_failed"));
        c2206t.f7888q = cursorQuery.getInt(cursorQuery.getColumnIndex("message_is_file_upload"));
        cursorQuery.close();
        return c2206t;
    }

    /* renamed from: a */
    public static void m10032a(SQLiteDatabase sQLiteDatabase) throws Throwable {
        Cursor cursorQuery;
        EnumC2231as enumC2231asM10099a;
        if (C4904y.f17872b) {
            C4904y.m18639b("migrationAnnounceChangeMessage", "MessageDatabaseHelper");
        }
        sQLiteDatabase.beginTransaction();
        try {
            cursorQuery = sQLiteDatabase.query(VKApiConst.MESSAGE, new String[]{"message_content", "message_inbox_no", "_id"}, "message_content_type = ?", new String[]{Integer.toString(EnumC2214ab.SYSTEM.m10076a())}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        EnumC2231as enumC2231as = EnumC2231as.UNKNOWN;
                        while (cursorQuery.moveToNext()) {
                            String string = cursorQuery.getString(0);
                            String string2 = cursorQuery.getString(1);
                            String string3 = cursorQuery.getString(2);
                            if (C4904y.f17872b) {
                                C4904y.m18639b(string, "migrationAnnounceChangeMessage");
                            }
                            String[] strArrSplit = string.split(Config.KEYVALUE_SPLIT);
                            if (strArrSplit.length > 0) {
                                StringBuilder sb = new StringBuilder();
                                for (String str : strArrSplit) {
                                    ArrayList<String> arrayListM18508a = C4874cl.m18508a(str, ',');
                                    if (arrayListM18508a.size() > 0 && (enumC2231asM10099a = EnumC2231as.m10099a(arrayListM18508a.get(0))) != EnumC2231as.UNKNOWN) {
                                        sb.append(String.format("%d,%s,%s", Integer.valueOf(enumC2231asM10099a.m10100a()), arrayListM18508a.get(1), arrayListM18508a.get(2))).append(Config.KEYVALUE_SPLIT);
                                    }
                                }
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("message_content", sb.toString());
                                sQLiteDatabase.update(VKApiConst.MESSAGE, contentValues, "_id=? AND message_inbox_no=? AND message_content_type=?", new String[]{string3, string2, Integer.toString(EnumC2214ab.SYSTEM.m10076a())});
                                if (C4904y.f17872b) {
                                    C4904y.m18639b(sb.toString(), "migrationInBoxBuddyRelation");
                                }
                            }
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
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    /* renamed from: b */
    public static void m10047b(SQLiteDatabase sQLiteDatabase) throws Throwable {
        Cursor cursorQuery;
        if (C4904y.f17872b) {
            C4904y.m18639b("migrationIsFileUploadField", "MessageDatabaseHelper");
        }
        sQLiteDatabase.beginTransaction();
        try {
            cursorQuery = sQLiteDatabase.query(VKApiConst.MESSAGE, new String[]{"message_is_failed", "message_inbox_no", "_id"}, "message_is_failed = ?", new String[]{Integer.toString(3)}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        while (cursorQuery.moveToNext()) {
                            int i = cursorQuery.getInt(0);
                            String string = cursorQuery.getString(1);
                            String string2 = cursorQuery.getString(2);
                            if (C4904y.f17872b) {
                                C4904y.m18639b(String.format("The Type of Failed : %d", Integer.valueOf(i)), "migrationIsFileUploadField");
                            }
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("message_is_failed", (Integer) 2);
                            contentValues.put("message_is_file_upload", (Integer) 1);
                            sQLiteDatabase.update(VKApiConst.MESSAGE, contentValues, "_id=? AND message_inbox_no=?", new String[]{string2, string});
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
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    /* renamed from: a */
    public static ContentProviderOperation m10011a(String str, String[] strArr, ContentValues contentValues) {
        return ContentProviderOperation.newUpdate(C2306z.f8229a).withValues(contentValues).withSelection(str, strArr).build();
    }

    /* renamed from: b */
    public static void m10046b(ContentResolver contentResolver, String str) {
        StringBuilder sb = new StringBuilder();
        String strM18121a = C4809aa.m18104a().m18121a("chaton_id", "");
        sb.append("message_inbox_no").append(" = ? ");
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_read_status", (Integer) 1);
        contentValues.put("message_sender", strM18121a);
        contentResolver.update(C2306z.f8229a, contentValues, sb.toString(), new String[]{str});
    }

    /* renamed from: a */
    public static String m10026a(ContentResolver contentResolver, Long l, boolean z) {
        String str;
        String string = null;
        if (z) {
            str = "message_sever_id=?";
        } else {
            str = "_id=?";
        }
        Cursor cursorQuery = contentResolver.query(C2306z.f8229a, new String[]{"message_content_translated"}, str, new String[]{String.valueOf(l)}, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() > 0) {
                    cursorQuery.moveToFirst();
                    string = cursorQuery.getString(0);
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        return string;
    }

    /* renamed from: a */
    public static int m10003a(ContentResolver contentResolver, String str, Long l, String str2, String str3, boolean z) {
        String str4;
        ContentValues contentValues = new ContentValues();
        if (str != null) {
            contentValues.put("message_content_translated", str);
        }
        if (str2 != null) {
            contentValues.put("message_from_lang", str2);
        }
        if (str3 != null) {
            contentValues.put("message_to_lang", str3);
        }
        if (z) {
            str4 = "message_sever_id=?";
        } else {
            str4 = "_id=?";
        }
        return contentResolver.update(C2306z.m10226e(), contentValues, str4, new String[]{String.valueOf(l)});
    }

    /* renamed from: f */
    public static int m10057f(ContentResolver contentResolver, Long l) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_is_spoken", "Y");
        return contentResolver.update(C2306z.m10226e(), contentValues, "_id=?", new String[]{String.valueOf(l)});
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0078  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m10034a(long r11, boolean r13) throws java.lang.Throwable {
        /*
            r9 = 0
            r7 = 1
            r8 = 0
            android.content.Context r0 = com.sec.chaton.global.GlobalApplication.m18732r()
            android.content.ContentResolver r0 = r0.getContentResolver()
            com.sec.chaton.e.ac r6 = com.sec.chaton.p057e.EnumC2215ac.UNREAD
            java.lang.String r3 = "_id=?"
            if (r13 == 0) goto L15
            java.lang.String r3 = "message_sever_id=?"
        L15:
            android.net.Uri r1 = com.sec.chaton.p057e.C2306z.f8229a     // Catch: java.lang.Exception -> L55 java.lang.Throwable -> L68
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Exception -> L55 java.lang.Throwable -> L68
            r4 = 0
            java.lang.String r5 = "message_is_read"
            r2[r4] = r5     // Catch: java.lang.Exception -> L55 java.lang.Throwable -> L68
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Exception -> L55 java.lang.Throwable -> L68
            r5 = 0
            java.lang.String r10 = java.lang.String.valueOf(r11)     // Catch: java.lang.Exception -> L55 java.lang.Throwable -> L68
            r4[r5] = r10     // Catch: java.lang.Exception -> L55 java.lang.Throwable -> L68
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L55 java.lang.Throwable -> L68
            if (r1 == 0) goto L78
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            if (r0 <= 0) goto L78
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            java.lang.String r0 = "message_is_read"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            com.sec.chaton.e.ac r6 = com.sec.chaton.p057e.EnumC2215ac.m10079a(r0)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            r0 = r6
        L4a:
            if (r1 == 0) goto L4f
            r1.close()
        L4f:
            com.sec.chaton.e.ac r1 = com.sec.chaton.p057e.EnumC2215ac.READ_SERVER
            if (r0 != r1) goto L70
            r0 = r7
        L54:
            return r0
        L55:
            r0 = move-exception
            r1 = r9
        L57:
            boolean r2 = com.sec.chaton.util.C4904y.f17875e     // Catch: java.lang.Throwable -> L72
            if (r2 == 0) goto L61
            java.lang.String r2 = "MessageDatabaseHelper"
            com.sec.chaton.util.C4904y.m18635a(r0, r2)     // Catch: java.lang.Throwable -> L72
        L61:
            if (r1 == 0) goto L76
            r1.close()
            r0 = r6
            goto L4f
        L68:
            r0 = move-exception
            r1 = r9
        L6a:
            if (r1 == 0) goto L6f
            r1.close()
        L6f:
            throw r0
        L70:
            r0 = r8
            goto L54
        L72:
            r0 = move-exception
            goto L6a
        L74:
            r0 = move-exception
            goto L57
        L76:
            r0 = r6
            goto L4f
        L78:
            r0 = r6
            goto L4a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2204r.m10034a(long, boolean):boolean");
    }

    /* renamed from: c */
    public static void m10053c(SQLiteDatabase sQLiteDatabase) throws Throwable {
        Cursor cursorQuery;
        C4904y.m18639b("migrationMessageIsRead", "MessageDatabaseHelper");
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("message_is_read", Integer.valueOf(EnumC2215ac.READ_SERVER.m10080a()));
            sQLiteDatabase.update(VKApiConst.MESSAGE, contentValues, null, null);
            cursorQuery = sQLiteDatabase.query("inbox", new String[]{"inbox_no", "inbox_unread_count"}, "inbox_unread_count > 0", null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        while (cursorQuery.moveToNext()) {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_no"));
                            String strM18121a = C4809aa.m18104a().m18121a("chaton_id", "");
                            int i = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_unread_count"));
                            ContentValues contentValues2 = new ContentValues();
                            contentValues2.put("message_is_read", Integer.valueOf(EnumC2215ac.UNREAD.m10080a()));
                            sQLiteDatabase.update(VKApiConst.MESSAGE, contentValues2, "message_sever_id IN (SELECT message_sever_id FROM message WHERE message_inbox_no =? AND message_sender != ? AND message_content_type != " + EnumC2214ab.SYSTEM.m10076a() + " ORDER BY message_time DESC LIMIT " + String.valueOf(i) + ")", new String[]{string, strM18121a});
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006c  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m10028a(java.lang.String r9, boolean r10) throws java.lang.Throwable {
        /*
            r7 = 0
            android.content.Context r0 = com.sec.chaton.global.GlobalApplication.m18732r()
            android.content.ContentResolver r0 = r0.getContentResolver()
            java.lang.String r6 = ""
            java.lang.String r3 = "_id=?"
            if (r10 == 0) goto L14
            java.lang.String r3 = "message_sever_id=?"
        L14:
            android.net.Uri r1 = com.sec.chaton.p057e.C2306z.f8229a     // Catch: java.lang.Exception -> L4b java.lang.Throwable -> L5e
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Exception -> L4b java.lang.Throwable -> L5e
            r4 = 0
            java.lang.String r5 = "message_inbox_no"
            r2[r4] = r5     // Catch: java.lang.Exception -> L4b java.lang.Throwable -> L5e
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Exception -> L4b java.lang.Throwable -> L5e
            r5 = 0
            java.lang.String r8 = java.lang.String.valueOf(r9)     // Catch: java.lang.Exception -> L4b java.lang.Throwable -> L5e
            r4[r5] = r8     // Catch: java.lang.Exception -> L4b java.lang.Throwable -> L5e
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L4b java.lang.Throwable -> L5e
            if (r1 == 0) goto L6c
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
            if (r0 <= 0) goto L6c
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
            java.lang.String r0 = "message_inbox_no"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
            java.lang.String r6 = r1.getString(r0)     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
            r0 = r6
        L45:
            if (r1 == 0) goto L4a
            r1.close()
        L4a:
            return r0
        L4b:
            r0 = move-exception
            r1 = r7
        L4d:
            boolean r2 = com.sec.chaton.util.C4904y.f17875e     // Catch: java.lang.Throwable -> L66
            if (r2 == 0) goto L57
            java.lang.String r2 = "MessageDatabaseHelper"
            com.sec.chaton.util.C4904y.m18635a(r0, r2)     // Catch: java.lang.Throwable -> L66
        L57:
            if (r1 == 0) goto L6a
            r1.close()
            r0 = r6
            goto L4a
        L5e:
            r0 = move-exception
            r1 = r7
        L60:
            if (r1 == 0) goto L65
            r1.close()
        L65:
            throw r0
        L66:
            r0 = move-exception
            goto L60
        L68:
            r0 = move-exception
            goto L4d
        L6a:
            r0 = r6
            goto L4a
        L6c:
            r0 = r6
            goto L45
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2204r.m10028a(java.lang.String, boolean):java.lang.String");
    }

    /* renamed from: a */
    public static boolean m10039a(ArrayList<ContentProviderOperation> arrayList, long j, String str) {
        if (C4904y.f17872b) {
            C4904y.m18639b("updateOrDeleteWithdrawnMessage - cancelMsgId(" + j + "), sender(" + str + ")", "MessageDatabaseHelper");
        }
        String string = GlobalApplication.m18732r().getString(R.string.message_is_recalled);
        boolean z = !C4809aa.m18104a().m18121a("chaton_id", "").equals(str);
        if (z) {
            if (m10034a(j, z)) {
                ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C2306z.f8229a);
                builderNewUpdate.withSelection("message_sever_id=?", new String[]{String.valueOf(j)});
                builderNewUpdate.withValue("message_content", string);
                builderNewUpdate.withValue("message_content_type", Integer.valueOf(EnumC2214ab.TEXT.m10076a()));
                builderNewUpdate.withValue("message_status", Integer.valueOf(EnumC2216ad.WITHDRAW_SUCCESS.m10083a()));
                arrayList.add(builderNewUpdate.build());
                if (!C4904y.f17872b) {
                    return true;
                }
                C4904y.m18639b("updateOrDeleteWithdrawnMessage - CASE 1 : cancelMsgId(" + j + "), sender(" + str + "), isReceivedMessage(" + z + ")", "MessageDatabaseHelper");
                return true;
            }
            ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C2306z.f8229a);
            builderNewDelete.withSelection("message_sever_id=?", new String[]{String.valueOf(j)});
            arrayList.add(builderNewDelete.build());
            if (C4904y.f17872b) {
                C4904y.m18639b("updateOrDeleteWithdrawnMessage - CASE 2 : cancelMsgId(" + j + "), sender(" + str + "), isReceivedMessage(" + z + ")", "MessageDatabaseHelper");
            }
            return false;
        }
        ContentProviderOperation.Builder builderNewUpdate2 = ContentProviderOperation.newUpdate(C2306z.f8229a);
        builderNewUpdate2.withSelection("_id=?", new String[]{String.valueOf(j)});
        builderNewUpdate2.withValue("message_status", Integer.valueOf(EnumC2216ad.WITHDRAW_SUCCESS.m10083a()));
        arrayList.add(builderNewUpdate2.build());
        if (!C4904y.f17872b) {
            return true;
        }
        C4904y.m18639b("updateOrDeleteWithdrawnMessage - CASE 3 : cancelMsgId(" + j + "), sender(" + str + "), isReceivedMessage(" + z + ")", "MessageDatabaseHelper");
        return true;
    }

    /* renamed from: a */
    public static ContentProviderOperation m10012a(boolean z, long j, String str, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            if (C4904y.f17872b) {
                C4904y.m18639b("updateInboxLastMessageWithdraw - inboxNo is null", "MessageDatabaseHelper");
            }
            return null;
        }
        if (!z2) {
            if (C4904y.f17872b) {
                C4904y.m18639b("updateInboxLastMessageWithdraw - isReceivedMessage is false", "MessageDatabaseHelper");
            }
            return null;
        }
        String string = GlobalApplication.m18732r().getString(R.string.message_is_recalled);
        C2201o c2201oM9951e = C2198l.m9951e(GlobalApplication.m18732r().getContentResolver(), str);
        if (c2201oM9951e == null) {
            if (C4904y.f17872b) {
                C4904y.m18639b("updateInboxLastMessageWithdraw - inboxData is null", "MessageDatabaseHelper");
            }
            return null;
        }
        int i = c2201oM9951e.f7841d - 1;
        if (i < 0) {
            i = 0;
        }
        if (j == c2201oM9951e.f7847j) {
            if (z) {
                String string2 = c2201oM9951e.f7842e;
                if (!TextUtils.isEmpty(string2)) {
                    String[] strArrSplit = string2.split(Config.KEYVALUE_SPLIT);
                    strArrSplit[1] = String.valueOf(EnumC2214ab.TEXT.m10076a());
                    if (strArrSplit.length > 2) {
                        strArrSplit[2] = C1736gi.m8632a(string);
                    }
                    StringBuilder sb = new StringBuilder();
                    for (String str2 : strArrSplit) {
                        sb.append(str2).append(Config.KEYVALUE_SPLIT);
                    }
                    if (strArrSplit != null && strArrSplit.length == 4) {
                        sb.setLength(sb.length() - 1);
                    }
                    string2 = sb.toString();
                }
                ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C2299s.f8209a);
                builderNewUpdate.withSelection("inbox_no=?", new String[]{str});
                builderNewUpdate.withValue("inbox_last_message", string2);
                if (C4904y.f17872b) {
                    C4904y.m18639b("updateInboxLastMessageWithdraw - CASE 1 : isUpdate(" + z + "), cancelMsgId(" + j + "), inboxNo(" + str + ")", "MessageDatabaseHelper");
                }
                return builderNewUpdate.build();
            }
            ContentValues contentValuesM8659k = C1736gi.m8659k(str);
            if (contentValuesM8659k == null) {
                C2142w c2142wM9606c = C2142w.m9606c(str);
                if (c2142wM9606c != null) {
                    c2142wM9606c.mo9274d();
                }
                ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C2299s.f8209a);
                builderNewDelete.withSelection("inbox_no=?", new String[]{str});
                if (C4904y.f17872b) {
                    C4904y.m18639b("updateInboxLastMessageWithdraw - CASE 2 : isUpdate(" + z + "), cancelMsgId(" + j + "), inboxNo(" + str + ")", "MessageDatabaseHelper");
                }
                return builderNewDelete.build();
            }
            ContentProviderOperation.Builder builderNewUpdate2 = ContentProviderOperation.newUpdate(C2299s.f8209a);
            builderNewUpdate2.withSelection("inbox_no=?", new String[]{str});
            builderNewUpdate2.withValues(contentValuesM8659k);
            builderNewUpdate2.withValue("inbox_unread_count", Integer.valueOf(i));
            if (C4904y.f17872b) {
                C4904y.m18639b("updateInboxLastMessageWithdraw - CASE 3 : isUpdate(" + z + "), cancelMsgId(" + j + "), inboxNo(" + str + ")", "MessageDatabaseHelper");
            }
            return builderNewUpdate2.build();
        }
        if (!z) {
            ContentProviderOperation.Builder builderNewUpdate3 = ContentProviderOperation.newUpdate(C2299s.f8209a);
            builderNewUpdate3.withSelection("inbox_no=?", new String[]{str});
            builderNewUpdate3.withValue("inbox_unread_count", Integer.valueOf(i));
            if (C4904y.f17872b) {
                C4904y.m18639b("updateInboxLastMessageWithdraw - CASE 4 : isUpdate(" + z + "), cancelMsgId(" + j + "), inboxNo(" + str + ")", "MessageDatabaseHelper");
            }
            return builderNewUpdate3.build();
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("updateInboxLastMessageWithdraw - CASE 5 : isUpdate(" + z + "), cancelMsgId(" + j + "), inboxNo(" + str + ")", "MessageDatabaseHelper");
        }
        return null;
    }

    /* renamed from: a */
    public static void m10029a(long j, String str) throws Throwable {
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        boolean zM10039a = m10039a(arrayList, j, str);
        boolean z = C4809aa.m18104a().m18121a("chaton_id", "").equals(str) ? false : true;
        String strM10028a = m10028a(String.valueOf(j), z);
        ContentProviderOperation contentProviderOperationM10012a = m10012a(zM10039a, j, strM10028a, z);
        if (contentProviderOperationM10012a != null) {
            arrayList.add(contentProviderOperationM10012a);
        } else if (C4904y.f17872b) {
            C4904y.m18639b("updateWithdraw - inboxOperaion is null, inboxNo(" + strM10028a + ")", "MessageDatabaseHelper");
        }
        try {
            if (arrayList.size() > 0) {
                GlobalApplication.m18732r().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
                if (contentProviderOperationM10012a != null) {
                    C0991aa.m6037a().m18961c(new C1015an(new String[]{strM10028a}));
                    C0991aa.m6037a().m18961c(new C1066bf(C1828q.f6913a, -1));
                }
            }
        } catch (Exception e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, "MessageDatabaseHelper");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x020e  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m10027a(java.lang.String r12, long r13, boolean r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 530
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2204r.m10027a(java.lang.String, long, boolean):java.lang.String");
    }

    /* renamed from: a */
    public static EnumC2292l m10023a(ContentResolver contentResolver, EnumC2214ab enumC2214ab, String str, String str2, String str3, long j, String str4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_type", (Integer) 2);
        contentValues.put("_id", Long.valueOf(C4843bh.m18322a()));
        contentValues.put("message_content_type", Integer.valueOf(enumC2214ab.m10076a()));
        contentValues.put("message_inbox_no", str);
        contentValues.put("message_sender", str3);
        contentValues.put("message_sever_id", Long.valueOf(j));
        contentValues.put("message_read_status", (Integer) 0);
        contentValues.put("message_content", str2);
        contentValues.put("message_time", str4);
        contentValues.put("message_need_update", "N");
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(Long.parseLong(str4))));
        contentValues.put("message_is_ack", Integer.valueOf(EnumC2213aa.ACK_DONE.m10069a()));
        if (C1813b.m8906b().m8931a(str)) {
            contentValues.put("message_is_read", Integer.valueOf(EnumC2215ac.READ_SERVER.m10080a()));
        } else {
            contentValues.put("message_is_read", Integer.valueOf(EnumC2215ac.UNREAD.m10080a()));
        }
        EnumC2292l enumC2292l = EnumC2292l.FAIL;
        Uri uriInsert = contentResolver.insert(C2306z.m10222c(), contentValues);
        if (uriInsert != null) {
            if (!C3037b.m12496a(uriInsert) && C2306z.m10217a(uriInsert, 2) != null) {
                return EnumC2292l.INSERT;
            }
            return EnumC2292l.UPDATE;
        }
        return enumC2292l;
    }

    /* renamed from: c */
    public static C2206t m10052c(ContentResolver contentResolver, String str) {
        C2206t c2206t = null;
        Cursor cursorQuery = contentResolver.query(C2306z.f8229a, null, "message_inbox_no=?", new String[]{String.valueOf(str)}, "message_time DESC LIMIT 1");
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() > 0) {
                    cursorQuery.moveToFirst();
                    c2206t = new C2206t();
                    c2206t.f7872a = cursorQuery.getLong(cursorQuery.getColumnIndex("_id"));
                    c2206t.f7873b = cursorQuery.getLong(cursorQuery.getColumnIndex("message_sever_id"));
                    c2206t.f7874c = cursorQuery.getString(cursorQuery.getColumnIndex("message_inbox_no"));
                    c2206t.f7875d = cursorQuery.getString(cursorQuery.getColumnIndex("message_session_id"));
                    c2206t.f7876e = cursorQuery.getInt(cursorQuery.getColumnIndex("message_read_status"));
                    c2206t.f7877f = cursorQuery.getInt(cursorQuery.getColumnIndex("message_content_type"));
                    c2206t.f7878g = cursorQuery.getLong(cursorQuery.getColumnIndex("message_time"));
                    c2206t.f7879h = cursorQuery.getString(cursorQuery.getColumnIndex("message_content"));
                    c2206t.f7880i = cursorQuery.getInt(cursorQuery.getColumnIndex("message_type"));
                    c2206t.f7881j = cursorQuery.getString(cursorQuery.getColumnIndex("message_sender"));
                    c2206t.f7882k = cursorQuery.getString(cursorQuery.getColumnIndex("message_download_uri"));
                    c2206t.f7883l = cursorQuery.getString(cursorQuery.getColumnIndex("message_formatted"));
                    c2206t.f7884m = cursorQuery.getString(cursorQuery.getColumnIndex("message_tid"));
                    c2206t.f7885n = cursorQuery.getInt(cursorQuery.getColumnIndex("message_stored_ext"));
                    c2206t.f7886o = cursorQuery.getString(cursorQuery.getColumnIndex("message_need_update"));
                    c2206t.f7887p = cursorQuery.getInt(cursorQuery.getColumnIndex("message_is_failed"));
                    c2206t.f7888q = cursorQuery.getInt(cursorQuery.getColumnIndex("message_is_file_upload"));
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        return c2206t;
    }
}
