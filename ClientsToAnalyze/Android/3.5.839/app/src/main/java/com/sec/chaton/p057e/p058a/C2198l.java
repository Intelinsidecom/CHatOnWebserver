package com.sec.chaton.p057e.p058a;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1066bf;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p050a.EnumC1109f;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.chat.EnumC1774ht;
import com.sec.chaton.chat.notification.C1813b;
import com.sec.chaton.chat.notification.C1828q;
import com.sec.chaton.chat.translate.C1850c;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p046a.C0870cx;
import com.sec.chaton.p055d.C2142w;
import com.sec.chaton.p057e.C2220ah;
import com.sec.chaton.p057e.C2297q;
import com.sec.chaton.p057e.C2298r;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.p057e.C2306z;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p057e.InterfaceC2273bs;
import com.sec.chaton.p057e.InterfaceC2278bx;
import com.sec.chaton.p057e.InterfaceC2280bz;
import com.sec.chaton.p065io.entry.PushEntry;
import com.sec.chaton.p067j.C2422ak;
import com.sec.chaton.p067j.p070c.C2434a;
import com.sec.chaton.p067j.p070c.C2438e;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.specialbuddy.EnumC4549n;
import com.sec.chaton.trunk.database.p122a.C4664a;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4810ab;
import com.sec.chaton.util.C4844bi;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4894o;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5052r;
import com.sec.spp.push.Config;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: InBoxDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.l */
/* loaded from: classes.dex */
public class C2198l {
    /* renamed from: a */
    public static long m9914a(ContentResolver contentResolver, String str) {
        long j;
        Cursor cursorQuery = contentResolver.query(C2299s.f8209a, new String[]{"inbox_last_time"}, "inbox_no=?", new String[]{str}, null);
        if (cursorQuery == null) {
            return 0L;
        }
        if (!cursorQuery.moveToFirst()) {
            j = 0;
        } else {
            j = cursorQuery.getLong(0);
        }
        cursorQuery.close();
        return j;
    }

    /* renamed from: b */
    public static String m9939b(ContentResolver contentResolver, String str) {
        Cursor cursorQuery = contentResolver.query(C2299s.f8209a, new String[]{"inbox_no"}, "inbox_session_id=?", new String[]{str}, null);
        if (cursorQuery != null) {
            string = cursorQuery.moveToFirst() ? cursorQuery.getString(0) : null;
            cursorQuery.close();
        }
        return string;
    }

    /* renamed from: a */
    public static String m9925a(ContentResolver contentResolver, EnumC2300t enumC2300t, String str, String str2) {
        String string = null;
        String strM7095a = EnumC1109f.NONE.m7095a();
        if (str.startsWith("0999")) {
            strM7095a = C2186al.m9761a(contentResolver, str);
            if (strM7095a.equals(EnumC1109f.NONE.m7095a())) {
                if (C4904y.f17873c) {
                    C4904y.m18641c("[getOrMakeInBoxNO] unfollowed live CP. Set usert type as Contents", "InBoxDatabaseHelper");
                }
                strM7095a = EnumC1109f.CONTENTS.m7095a();
            }
        }
        Cursor cursorQuery = contentResolver.query(C2299s.m10202o(), null, "buddy_no=?", new String[]{str, str2, String.valueOf(enumC2300t.m10210a()), strM7095a}, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() > 0) {
                    cursorQuery.moveToFirst();
                    string = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_no"));
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
    public static Uri m9924a(ContentResolver contentResolver, String str, C0870cx c0870cx, String str2, EnumC2300t enumC2300t, String[] strArr, EnumC2214ab enumC2214ab, EnumC2301u enumC2301u) {
        boolean zEqualsIgnoreCase;
        String strM9968u;
        boolean z;
        C2201o c2201oM9951e;
        if (enumC2300t != EnumC2300t.BROADCAST) {
            zEqualsIgnoreCase = false;
            strM9968u = m9968u(contentResolver, str);
            z = true;
        } else {
            Cursor cursorQuery = contentResolver.query(C2299s.f8209a, null, "inbox_no=?", new String[]{str}, null);
            if (cursorQuery == null || cursorQuery.getCount() == 0) {
                C4810ab c4810abM18104a = C4809aa.m18104a();
                int iIntValue = 0;
                if (c4810abM18104a.m18129b("broadcast_count")) {
                    iIntValue = c4810abM18104a.m18120a("broadcast_count", (Integer) 0).intValue();
                }
                strM9968u = m9968u(contentResolver, str);
                c4810abM18104a.m18126b("broadcast_count", Integer.valueOf(iIntValue + 1));
                z = true;
                zEqualsIgnoreCase = false;
            } else {
                cursorQuery.moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_title"));
                if (TextUtils.isEmpty(string)) {
                    string = m9968u(contentResolver, str);
                }
                zEqualsIgnoreCase = "Y".equalsIgnoreCase(cursorQuery.getString(cursorQuery.getColumnIndex("inbox_title_fixed")));
                strM9968u = string;
                z = false;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
        String str3 = String.format("%d;%d;%s;%s", 1, Integer.valueOf(enumC2214ab.m10076a()), C1736gi.m8632a(str2), "");
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_no", str);
        contentValues.put("inbox_chat_type", Integer.valueOf(enumC2300t.m10210a()));
        contentValues.put("inbox_participants", Integer.valueOf(strArr.length));
        contentValues.put("inbox_last_message", str3);
        if (c0870cx.m4256j() == null) {
            contentValues.put("inbox_server_ip", C4844bi.m18323a().m18328c().m18329a());
        } else {
            contentValues.put("inbox_server_ip", c0870cx.m4256j().m5561d());
        }
        contentValues.put("inbox_server_port", Integer.valueOf(C4844bi.m18323a().m18328c().m18332b()));
        contentValues.put("inbox_last_msg_sender", C4809aa.m18104a().m18121a("chaton_id", ""));
        contentValues.put("inbox_last_msg_no", Long.valueOf(c0870cx.m4250d()));
        contentValues.put("inbox_session_id", c0870cx.m4252f());
        contentValues.put("inbox_last_time", Long.valueOf(c0870cx.m4254h()));
        contentValues.put("inbox_title", strM9968u);
        if (enumC2300t == EnumC2300t.BROADCAST && zEqualsIgnoreCase) {
            contentValues.put("inbox_title_fixed", "Y");
        }
        contentValues.put("inbox_last_chat_type", (Integer) 11);
        if (!z) {
            contentValues.put("inbox_is_new", "N");
        } else {
            contentValues.put("inbox_is_new", "Y");
        }
        if (enumC2300t == EnumC2300t.ONETOONE) {
            contentValues.put("buddy_no", strArr[0]);
        }
        if (enumC2300t == EnumC2300t.GROUPCHAT || enumC2300t == EnumC2300t.TOPIC) {
            contentValues.put("inbox_enable_noti", C4809aa.m18104a().m18119a("Setting alert_new_groupchat", (Boolean) true).booleanValue() ? "Y" : "N");
        } else {
            contentValues.put("inbox_enable_noti", "Y");
        }
        if (enumC2300t != EnumC2300t.ONETOONE) {
            contentValues.put("inbox_last_tid", "-1");
        }
        if (enumC2300t == EnumC2300t.ONETOONE && (c2201oM9951e = m9951e(contentResolver, str)) != null) {
            if (c2201oM9951e.f7860w) {
                contentValues.put("inbox_enable_translate", "Y");
            }
            if (c2201oM9951e.f7861x) {
                contentValues.put("translate_outgoing_message", "Y");
            }
            if (!TextUtils.isEmpty(c2201oM9951e.f7862y)) {
                contentValues.put("inbox_translate_my_language", c2201oM9951e.f7862y);
            }
            if (!TextUtils.isEmpty(c2201oM9951e.f7863z)) {
                contentValues.put("inbox_translate_buddy_language", c2201oM9951e.f7863z);
            }
        }
        contentValues.put("inbox_room_type", Integer.valueOf(enumC2301u.m10212a()));
        return contentResolver.insert(C2299s.f8209a, contentValues);
    }

    /* renamed from: a */
    public static void m9928a(ContentResolver contentResolver, C2201o c2201o, EnumC2300t enumC2300t, PushEntry pushEntry) throws NumberFormatException {
        ContentValues contentValues = new ContentValues();
        EnumC2301u enumC2301u = EnumC2301u.NORMAL;
        EnumC2214ab enumC2214abM10020a = C2204r.m10020a(pushEntry.message, pushEntry.msgType.intValue());
        EnumC1774ht enumC1774htM8782a = EnumC1774ht.m8782a(pushEntry.userType);
        if (enumC1774htM8782a == EnumC1774ht.PUT_LIVE_CONTENTS) {
            enumC2214abM10020a = EnumC2214ab.LIVECONTENTS;
            enumC2301u = EnumC2301u.LIVE;
        } else if (enumC1774htM8782a == EnumC1774ht.PUT_LIVE_CHAT) {
            enumC2301u = EnumC2301u.LIVE;
        }
        contentValues.put("inbox_room_type", Integer.valueOf(enumC2301u.m10212a()));
        StringBuilder sb = new StringBuilder();
        sb.append(2).append(Config.KEYVALUE_SPLIT).append(enumC2214abM10020a.m10076a()).append(Config.KEYVALUE_SPLIT);
        sb.append(C1736gi.m8632a(pushEntry.message));
        sb.append(Config.KEYVALUE_SPLIT);
        if (pushEntry.isMirror) {
            sb.append(C1736gi.m8632a(CommonApplication.m18732r().getString(R.string.buddy_profile_interaction_me)));
        } else if (enumC2300t == EnumC2300t.GROUPCHAT || enumC2300t == EnumC2300t.TOPIC) {
            sb.append(C1736gi.m8632a(C2176ab.m9693e(contentResolver, c2201o.f7839b, pushEntry.senderID)));
        }
        contentValues.put("inbox_last_message", sb.toString());
        if (!TextUtils.isEmpty(pushEntry.sessionID) && !pushEntry.sessionID.equalsIgnoreCase("null")) {
            contentValues.put("inbox_session_id", c2201o.f7846i);
            contentValues.put("inbox_server_ip", pushEntry.f8555IP);
            contentValues.put("inbox_server_port", pushEntry.PORT);
        } else if (TextUtils.isEmpty(c2201o.f7852o)) {
            contentValues.put("inbox_server_ip", C4844bi.m18323a().m18328c().m18329a());
            contentValues.put("inbox_server_port", Integer.valueOf(C4844bi.m18323a().m18328c().m18332b()));
        }
        int i = ((C1813b.m8906b().m8931a(c2201o.f7839b) && (TextUtils.isEmpty(pushEntry.userType) || C1813b.m8906b().m8933b(c2201o.f7839b) == EnumC4549n.m17246a(pushEntry.userType).m17247a())) || pushEntry.isMirror) ? 0 : 1;
        contentValues.put("inbox_unread_count", Integer.valueOf(i));
        contentValues.put("inbox_participants", pushEntry.receiverCount);
        if (pushEntry.isMirror) {
            contentValues.put("inbox_last_msg_sender", pushEntry.receiver);
        } else {
            contentValues.put("inbox_last_msg_sender", pushEntry.senderID);
        }
        contentValues.put("inbox_last_msg_no", pushEntry.msgID);
        contentValues.put("inbox_last_time", pushEntry.sentTime);
        if (c2201o.f7850m != 11) {
            contentValues.put("inbox_last_chat_type", (Integer) 10);
        }
        if (TextUtils.isEmpty(c2201o.f7843f)) {
            switch (C2200n.f7837a[enumC2300t.ordinal()]) {
                case 1:
                case 2:
                    contentValues.put("inbox_chat_type", Integer.valueOf(EnumC2300t.ONETOONE.m10210a()));
                    contentValues.put("inbox_title", C2176ab.m9693e(contentResolver, c2201o.f7839b, pushEntry.senderID));
                    break;
                case 3:
                    contentValues.put("inbox_chat_type", Integer.valueOf(EnumC2300t.GROUPCHAT.m10210a()));
                    if (C4809aa.m18104a().m18121a("chaton_id", "").equals(pushEntry.senderID)) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("Update from push - do not update inbox title, receiver is me : - " + pushEntry.senderID, "InBoxDatabaseHelper");
                            break;
                        }
                    } else {
                        contentValues.put("inbox_title", C2176ab.m9693e(contentResolver, c2201o.f7839b, pushEntry.senderID));
                        break;
                    }
                    break;
                case 4:
                    contentValues.put("inbox_chat_type", Integer.valueOf(EnumC2300t.BROADCAST2.m10210a()));
                    contentValues.put("inbox_title", C2176ab.m9693e(contentResolver, c2201o.f7839b, pushEntry.senderID));
                    break;
            }
        }
        contentResolver.update(C2299s.m10203p(), contentValues, "inbox_no=?", new String[]{c2201o.f7839b});
        C0991aa.m6037a().m18962d(new C1066bf(c2201o.f7839b, i));
        C0991aa.m6037a().m18962d(new C1066bf(C1828q.f6913a, -1));
    }

    /* renamed from: a */
    public static ContentProviderOperation m9920a(String str, String[] strArr, ContentValues contentValues) {
        return ContentProviderOperation.newUpdate(C2299s.f8209a).withValues(contentValues).withSelection(str, strArr).build();
    }

    /* renamed from: b */
    public static ContentProviderOperation m9938b(String str, String[] strArr, ContentValues contentValues) {
        return ContentProviderOperation.newUpdate(C2297q.f8207a).withValues(contentValues).withSelection(str, strArr).build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m9918a(String str, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("lasst_session_merge_time", Long.valueOf(j));
        return ContentProviderOperation.newUpdate(C2299s.f8209a).withValues(contentValues).withSelection("inbox_no=?", new String[]{str}).build();
    }

    /* renamed from: a */
    public static int m9912a(ContentResolver contentResolver, String str, String str2, String str3, long j, String str4, String str5, Integer num, Long l, int i, EnumC2214ab enumC2214ab) {
        String str6 = String.format("%d;%d;%s;%s", 1, Integer.valueOf(enumC2214ab.m10076a()), C1736gi.m8632a(str3), "");
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_last_msg_sender", str);
        contentValues.put("inbox_last_message", str6);
        contentValues.put("inbox_last_time", Long.valueOf(j));
        contentValues.put("inbox_session_id", str4);
        contentValues.put("inbox_last_msg_no", l);
        if (!TextUtils.isEmpty(str5) && num != null && num.intValue() > 0) {
            contentValues.put("inbox_server_ip", str5);
            contentValues.put("inbox_server_port", num);
        }
        return contentResolver.update(C2299s.f8209a, contentValues, "inbox_no=?", new String[]{str2});
    }

    /* renamed from: c */
    public static ContentProviderOperation m9946c(ContentResolver contentResolver, String str) {
        C2206t c2206tM10052c = C2204r.m10052c(contentResolver, str);
        if (c2206tM10052c == null) {
            C4904y.m18639b("updateInBoxAfterMergeSync - MessageData is null", "[InboxDatabaseHelper]");
            return null;
        }
        String str2 = String.format("%d;%d;%s;%s", Integer.valueOf(c2206tM10052c.f7880i), Integer.valueOf(c2206tM10052c.f7877f), C1736gi.m8632a(c2206tM10052c.f7879h), "");
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_last_msg_sender", c2206tM10052c.f7881j);
        contentValues.put("inbox_last_message", str2);
        contentValues.put("inbox_last_time", Long.valueOf(c2206tM10052c.f7878g));
        contentValues.put("inbox_last_msg_no", Long.valueOf(c2206tM10052c.f7872a));
        contentValues.put("inbox_last_chat_type", Integer.valueOf(c2206tM10052c.f7880i));
        return ContentProviderOperation.newUpdate(C2299s.f8209a).withValues(contentValues).withSelection("inbox_no=?", new String[]{str}).build();
    }

    /* renamed from: d */
    public static int m9949d(ContentResolver contentResolver, String str) {
        C2201o c2201oM9951e = m9951e(contentResolver, str);
        if (c2201oM9951e != null) {
            return m9935b(contentResolver, str, c2201oM9951e);
        }
        return -1;
    }

    /* renamed from: a */
    public static ContentProviderOperation m9915a(ContentResolver contentResolver, String str, int i) {
        ContentValues contentValues = new ContentValues();
        String[] strArr = {str};
        contentValues.put("inbox_trunk_unread_count", Integer.valueOf(i));
        return ContentProviderOperation.newUpdate(C2299s.f8209a).withValues(contentValues).withSelection("inbox_session_id=?", strArr).build();
    }

    /* renamed from: a */
    public static ContentProviderResult[] m9933a(Context context, ArrayList<ContentProviderOperation> arrayList) {
        return context.getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
    }

    /* renamed from: b */
    public static int m9934b(ContentResolver contentResolver, String str, int i) {
        int i2;
        ContentValues contentValues = new ContentValues();
        String[] strArr = {str};
        Cursor cursorQuery = contentResolver.query(C2299s.f8209a, null, "inbox_session_id=?", strArr, null);
        if (cursorQuery == null || cursorQuery.getCount() <= 0) {
            i2 = 0;
        } else {
            cursorQuery.moveToFirst();
            i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_trunk_unread_count"));
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        int i3 = i2 - i;
        if (i3 < 0) {
            i3 = 0;
        }
        contentValues.put("inbox_trunk_unread_count", Integer.valueOf(i3));
        if (contentResolver.update(C2299s.f8209a, contentValues, "inbox_session_id=?", strArr) <= 0) {
            return -1;
        }
        return i3;
    }

    /* renamed from: u */
    private static String m9968u(ContentResolver contentResolver, String str) {
        String strM8629a = "";
        Cursor cursorM9675a = C2176ab.m9675a(contentResolver, str);
        if (cursorM9675a != null && cursorM9675a.getCount() > 0) {
            strM8629a = C1736gi.m8629a(cursorM9675a);
        }
        if (cursorM9675a != null) {
            cursorM9675a.close();
        }
        return strM8629a;
    }

    /* renamed from: e */
    public static C2201o m9951e(ContentResolver contentResolver, String str) {
        Cursor cursorQuery = contentResolver.query(C2299s.f8209a, null, "inbox_no=?", new String[]{str}, null);
        if (cursorQuery == null) {
            return null;
        }
        if (cursorQuery.getCount() == 0) {
            if (cursorQuery.isClosed()) {
                return null;
            }
            cursorQuery.close();
            return null;
        }
        C2201o c2201o = new C2201o();
        cursorQuery.moveToFirst();
        c2201o.f7838a = cursorQuery.getLong(cursorQuery.getColumnIndex("_id"));
        c2201o.f7839b = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_no"));
        c2201o.f7840c = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_chat_type"));
        c2201o.f7843f = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_title"));
        c2201o.f7849l = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_title_fixed"));
        c2201o.f7842e = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_last_message"));
        c2201o.f7850m = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_last_chat_type"));
        c2201o.f7847j = cursorQuery.getLong(cursorQuery.getColumnIndex("inbox_last_msg_no"));
        c2201o.f7848k = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_last_msg_sender"));
        c2201o.f7844g = cursorQuery.getLong(cursorQuery.getColumnIndex("inbox_last_time"));
        c2201o.f7851n = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_last_temp_msg"));
        c2201o.f7845h = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_participants"));
        c2201o.f7846i = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_session_id"));
        c2201o.f7841d = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_unread_count"));
        c2201o.f7852o = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_server_ip"));
        c2201o.f7853p = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_server_port"));
        c2201o.f7854q = cursorQuery.getLong(cursorQuery.getColumnIndex("inbox_last_timestamp"));
        c2201o.f7855r = "Y".equals(cursorQuery.getString(cursorQuery.getColumnIndex("inbox_enable_noti")));
        c2201o.f7856s = cursorQuery.getLong(cursorQuery.getColumnIndex("lasst_session_merge_time"));
        c2201o.f7857t = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_old_no"));
        c2201o.f7858u = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_trunk_unread_count"));
        c2201o.f7859v = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_room_type"));
        c2201o.f7860w = "Y".equals(cursorQuery.getString(cursorQuery.getColumnIndex("inbox_enable_translate")));
        c2201o.f7861x = "Y".equals(cursorQuery.getString(cursorQuery.getColumnIndex("translate_outgoing_message")));
        c2201o.f7862y = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_translate_my_language"));
        c2201o.f7863z = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_translate_buddy_language"));
        cursorQuery.close();
        return c2201o;
    }

    /* renamed from: a */
    private static ContentValues m9922a(C2201o c2201o) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_participants", Integer.valueOf(c2201o.f7845h));
        contentValues.put("inbox_last_message", c2201o.f7842e);
        if (c2201o.f7852o != null) {
            contentValues.put("inbox_server_ip", c2201o.f7852o);
            contentValues.put("inbox_server_port", Integer.valueOf(c2201o.f7853p));
        }
        contentValues.put("inbox_last_msg_sender", c2201o.f7848k);
        contentValues.put("inbox_last_msg_no", Long.valueOf(c2201o.f7847j));
        contentValues.put("inbox_session_id", c2201o.f7846i);
        contentValues.put("inbox_last_time", Long.valueOf(c2201o.f7844g));
        contentValues.put("inbox_unread_count", Integer.valueOf(c2201o.f7841d));
        contentValues.put("inbox_last_chat_type", Integer.valueOf(c2201o.f7850m));
        contentValues.put("inbox_last_timestamp", Long.valueOf(c2201o.f7854q));
        return contentValues;
    }

    /* renamed from: a */
    public static ContentValues m9921a(ContentResolver contentResolver, String str, C2201o c2201o) {
        ContentValues contentValuesM9922a = m9922a(c2201o);
        Cursor cursorM9675a = C2176ab.m9675a(contentResolver, str);
        if (cursorM9675a != null) {
            c2201o.f7845h = cursorM9675a.getCount();
            contentValuesM9922a.put("inbox_participants", Integer.valueOf(c2201o.f7845h));
            if (c2201o.f7849l.equalsIgnoreCase("n")) {
                c2201o.f7843f = C1736gi.m8629a(cursorM9675a);
                contentValuesM9922a.put("inbox_title", c2201o.f7843f);
            }
            cursorM9675a.close();
        }
        return contentValuesM9922a;
    }

    /* renamed from: b */
    public static int m9935b(ContentResolver contentResolver, String str, C2201o c2201o) {
        return contentResolver.update(C2299s.f8209a, m9921a(contentResolver, str, c2201o), "inbox_no=?", new String[]{str});
    }

    /* renamed from: a */
    public static int m9908a(ContentResolver contentResolver, String str, C2201o c2201o, int i) {
        ContentValues contentValuesM9921a = m9921a(contentResolver, str, c2201o);
        contentValuesM9921a.put("inbox_unread_count", Integer.valueOf(i));
        return contentResolver.update(C2299s.m10199l(), contentValuesM9921a, "inbox_no=?", new String[]{str});
    }

    /* renamed from: c */
    public static ContentProviderOperation m9947c(ContentResolver contentResolver, String str, C2201o c2201o) {
        ContentValues contentValuesM9922a = m9922a(c2201o);
        contentValuesM9922a.put("inbox_title", c2201o.f7843f);
        contentValuesM9922a.put("inbox_no", c2201o.f7839b);
        return ContentProviderOperation.newUpdate(C2299s.f8209a).withValues(contentValuesM9922a).withSelection("inbox_no=?", new String[]{str}).build();
    }

    /* renamed from: a */
    public static int m9909a(ContentResolver contentResolver, String str, String str2, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_server_ip", str2);
        contentValues.put("inbox_server_port", Integer.valueOf(i));
        return contentResolver.update(C2299s.f8209a, contentValues, "inbox_no=?", new String[]{str});
    }

    /* renamed from: a */
    public static void m9929a(ContentResolver contentResolver, String str, C2422ak c2422ak) {
        Cursor cursorQuery = contentResolver.query(C2299s.f8209a, new String[]{"inbox_server_ip", "inbox_server_port"}, "inbox_no=?", new String[]{str}, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.moveToFirst();
            c2422ak.m10489a(cursorQuery.getString(0), cursorQuery.getInt(1));
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
    }

    /* renamed from: f */
    public static int m9953f(ContentResolver contentResolver, String str) {
        C2201o c2201oM9951e = m9951e(contentResolver, str);
        if (c2201oM9951e == null || TextUtils.isEmpty(c2201oM9951e.f7852o)) {
            C4844bi.m18323a().m18326a(C4844bi.m18323a().m18328c().m18329a(), C4844bi.m18323a().m18328c().m18332b());
            return -1;
        }
        C4844bi.m18323a().m18326a(c2201oM9951e.f7852o, c2201oM9951e.f7853p);
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_server_ip", C4844bi.m18323a().m18328c().m18329a());
        contentValues.put("inbox_server_port", Integer.valueOf(C4844bi.m18323a().m18328c().m18332b()));
        return contentResolver.update(C2299s.f8209a, contentValues, "inbox_no=?", new String[]{str});
    }

    /* renamed from: c */
    public static int m9943c(ContentResolver contentResolver, String str, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_last_chat_type", Integer.valueOf(i));
        return contentResolver.update(C2299s.f8209a, contentValues, "inbox_no=?", new String[]{str});
    }

    /* renamed from: g */
    public static boolean m9954g(ContentResolver contentResolver, String str) {
        int i;
        long j;
        Cursor cursorQuery = contentResolver.query(C2299s.f8209a, null, "inbox_no=?", new String[]{str}, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.moveToFirst();
            i = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_last_chat_type"));
            j = cursorQuery.getLong(cursorQuery.getColumnIndex("inbox_last_timestamp"));
        } else {
            C4904y.m18634a("isInboxParticipantInserted() - can't find inbox", "[InboxDatabaseHelper]");
            i = 10;
            j = 0;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return i != 11 && j == 0;
    }

    /* renamed from: h */
    public static boolean m9955h(ContentResolver contentResolver, String str) {
        Cursor cursorQuery = contentResolver.query(C2299s.f8209a, null, "inbox_no=?", new String[]{str}, null);
        int i = 10;
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.moveToFirst();
            i = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_last_chat_type"));
        } else {
            C4904y.m18634a("isInboxParticipantInserted() - can't find inbox", "[InboxDatabaseHelper]");
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return i == 11;
    }

    /* renamed from: a */
    public static ContentProviderOperation m9919a(String str, String str2) {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C2299s.f8209a);
        builderNewUpdate.withSelection("inbox_no=?", new String[]{str});
        builderNewUpdate.withValue("inbox_last_tid", str2);
        return builderNewUpdate.build();
    }

    /* renamed from: a */
    public static int m9910a(ContentResolver contentResolver, String str, String str2, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("buddy_no", str);
        contentValues.put("buddy_name", str2);
        contentValues.put("message_time", Long.valueOf(j));
        contentValues.put("KEY_DEACTIVATED", (Boolean) false);
        return contentResolver.update(C2299s.m10200m(), contentValues, null, null);
    }

    /* renamed from: a */
    public static int m9907a(ContentResolver contentResolver, String str, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("buddy_no", str);
        contentValues.put("message_time", Long.valueOf(j));
        contentValues.put("KEY_DEACTIVATED", (Boolean) true);
        return contentResolver.update(C2299s.m10200m(), contentValues, null, null);
    }

    /* renamed from: a */
    public static int m9913a(ContentResolver contentResolver, String str, boolean z) {
        String str2 = z ? "Y" : "N";
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_enable_noti", str2);
        return contentResolver.update(C2299s.f8209a, contentValues, "inbox_no=?", new String[]{str});
    }

    /* renamed from: i */
    public static boolean m9956i(ContentResolver contentResolver, String str) {
        Cursor cursorQuery = contentResolver.query(C2299s.f8209a, null, "inbox_no=?", new String[]{str}, null);
        String string = "Y";
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.moveToFirst();
            string = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_enable_noti"));
        } else {
            C4904y.m18639b("isEnableNoti() - can't find inbox", "[InboxDatabaseHelper]");
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return string.equals("Y");
    }

    /* renamed from: a */
    public static void m9931a(SQLiteDatabase sQLiteDatabase) throws Throwable {
        Cursor cursorQuery;
        C4904y.m18639b("migrationInBoxBuddyRelation", "InBoxDatabaseHelper");
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS inbox_buddy_relation");
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8147g);
            sQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS trigger_inbox_before_delete");
            sQLiteDatabase.execSQL(InterfaceC2280bz.f8182a);
            cursorQuery = sQLiteDatabase.query("inbox", null, "inbox_chat_type = ? AND inbox_valid = ?", new String[]{Integer.toString(EnumC2300t.ONETOONE.m10210a()), "Y"}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        while (cursorQuery.moveToNext()) {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_no"));
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("buddy_no", string);
                            contentValues.put("inbox_no", string);
                            sQLiteDatabase.insert("inbox_buddy_relation", null, contentValues);
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
    public static void m9941b(SQLiteDatabase sQLiteDatabase) throws Throwable {
        Cursor cursorQuery;
        C4904y.m18639b("migrationMessageReadCount", "InBoxDatabaseHelper");
        sQLiteDatabase.beginTransaction();
        try {
            cursorQuery = sQLiteDatabase.query("inbox", new String[]{"inbox_no", "inbox_participants"}, null, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        cursorQuery.moveToPosition(-1);
                        while (cursorQuery.moveToNext()) {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_no"));
                            int i = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_participants"));
                            sQLiteDatabase.execSQL(C5052r.m19199a("UPDATE ", VKApiConst.MESSAGE, " SET ", "message_read_status", " = ", "CASE WHEN ", "message_read_status", " > ? THEN 0 ELSE (? - ", "message_read_status", ") END", " WHERE ", "message_inbox_no", " = ? AND ", "message_read_status", " IS NOT NULL"), new String[]{String.valueOf(i), String.valueOf(i), string});
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
    public static int m9906a(ContentResolver contentResolver, long j) {
        return contentResolver.delete(C2297q.f8207a, "buddy_no =?", new String[]{String.valueOf(j)});
    }

    /* renamed from: j */
    public static int m9957j(ContentResolver contentResolver, String str) {
        return contentResolver.delete(C2297q.f8207a, "chat_type = '" + Integer.toString(EnumC2300t.GROUPCHAT.m10210a()) + "' AND inbox_no =?", new String[]{str});
    }

    /* renamed from: a */
    public static ContentProviderOperation m9917a(String str) {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C2297q.f8207a);
        builderNewDelete.withSelection("buddy_no IN ( SELECT group_relation_group FROM grouprelation WHERE group_relation_buddy = ? )", new String[]{str});
        return builderNewDelete.build();
    }

    /* renamed from: a */
    public static int m9905a(ContentResolver contentResolver) {
        Cursor cursorQuery = contentResolver.query(C2299s.f8209a, null, "inbox_unread_count > 0", null, null);
        if (cursorQuery == null) {
            return 0;
        }
        if (cursorQuery.getCount() != 0) {
            int i = 0;
            while (cursorQuery.moveToNext()) {
                i += cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_unread_count"));
            }
            cursorQuery.close();
            return i;
        }
        cursorQuery.close();
        return 0;
    }

    /* renamed from: k */
    public static int m9958k(ContentResolver contentResolver, String str) {
        Cursor cursorQuery = contentResolver.query(C2299s.f8209a, null, "inbox_no=?", new String[]{str}, null);
        if (cursorQuery == null) {
            return 0;
        }
        if (cursorQuery.getCount() == 0) {
            cursorQuery.close();
            return 0;
        }
        cursorQuery.moveToFirst();
        int i = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_unread_count"));
        cursorQuery.close();
        return i;
    }

    /* renamed from: a */
    public static Uri m9923a(ContentResolver contentResolver, String str, int i, EnumC2300t enumC2300t) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_no", str);
        contentValues.put("buddy_no", Integer.valueOf(i));
        contentValues.put("chat_type", Integer.valueOf(enumC2300t.m10210a()));
        return contentResolver.insert(C2297q.f8207a, contentValues);
    }

    /* renamed from: l */
    public static boolean m9959l(ContentResolver contentResolver, String str) {
        Cursor cursorQuery = contentResolver.query(C2297q.f8207a, null, "inbox_no=?", new String[]{str}, null);
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

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m9960m(android.content.ContentResolver r6, java.lang.String r7) {
        /*
            r2 = 0
            android.net.Uri r1 = com.sec.chaton.p057e.C2297q.f8207a
            java.lang.String r3 = "buddy_no=?"
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]
            r0 = 0
            r4[r0] = r7
            r0 = r6
            r5 = r2
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)
            if (r1 == 0) goto L2e
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L34
            if (r0 <= 0) goto L2e
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L34
            java.lang.String r0 = "inbox_no"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L34
            java.lang.String r2 = r1.getString(r0)     // Catch: java.lang.Throwable -> L34
            if (r1 == 0) goto L2d
            r1.close()
        L2d:
            return r2
        L2e:
            if (r1 == 0) goto L2d
            r1.close()
            goto L2d
        L34:
            r0 = move-exception
            if (r1 == 0) goto L3a
            r1.close()
        L3a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2198l.m9960m(android.content.ContentResolver, java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public static ContentProviderOperation m9916a(ContentResolver contentResolver, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_session_id", str2);
        contentValues.put("inbox_old_session_id", str);
        return ContentProviderOperation.newInsert(C2298r.f8208a).withValues(contentValues).build();
    }

    /* renamed from: n */
    public static String m9961n(ContentResolver contentResolver, String str) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor = null;
        try {
            cursorQuery = contentResolver.query(C2298r.f8208a, new String[]{"inbox_session_id"}, "inbox_old_session_id = ?", new String[]{str}, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        cursorQuery.moveToFirst();
                        str = cursorQuery.getString(0);
                    }
                } catch (Exception e) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return str;
                } catch (Throwable th) {
                    cursor = cursorQuery;
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception e2) {
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
        }
        return str;
    }

    /* renamed from: a */
    public static String m9926a(EnumC2300t enumC2300t, String[] strArr) {
        String str;
        boolean z;
        HashSet hashSet = new HashSet(strArr.length);
        for (String str2 : strArr) {
            hashSet.add(str2);
        }
        Cursor cursorQuery = GlobalApplication.m10279a().getContentResolver().query(C2299s.f8209a, null, "inbox_chat_type=? AND inbox_participants=?", new String[]{String.valueOf(enumC2300t.m10210a()), String.valueOf(hashSet.size())}, "inbox_last_time DESC");
        if (cursorQuery == null || cursorQuery.getCount() <= 0) {
            str = null;
        } else {
            Cursor cursorQuery2 = null;
            str = null;
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_no"));
                cursorQuery2 = GlobalApplication.m10279a().getContentResolver().query(C2220ah.f7942a, new String[]{"participants_buddy_no"}, "participants_inbox_no = ?", new String[]{string}, null);
                while (true) {
                    if (!cursorQuery2.moveToNext()) {
                        z = true;
                        break;
                    }
                    if (!hashSet.contains(cursorQuery2.getString(0))) {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    str = string;
                }
            }
            if (cursorQuery2 != null) {
                cursorQuery2.close();
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return str;
    }

    /* renamed from: b */
    public static int m9937b(ContentResolver contentResolver, String str, boolean z) {
        String str2 = z ? "Y" : "N";
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_enable_translate", str2);
        return contentResolver.update(C2299s.f8209a, contentValues, "inbox_no=?", new String[]{str});
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007d  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m9927a() {
        /*
            r6 = 0
            android.content.ContentValues r7 = new android.content.ContentValues
            r7.<init>()
            java.lang.String r0 = ""
            android.content.Context r0 = com.sec.chaton.global.GlobalApplication.m18732r()
            android.content.ContentResolver r0 = r0.getContentResolver()
            android.net.Uri r1 = com.sec.chaton.p057e.C2299s.f8209a     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L83
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L83
            r3 = 0
            java.lang.String r4 = "inbox_no"
            r2[r3] = r4     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L83
            java.lang.String r3 = "inbox_enable_translate=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L83
            r5 = 0
            java.lang.String r8 = "Y"
            r4[r5] = r8     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L83
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L83
            if (r1 == 0) goto L73
            int r2 = r1.getCount()     // Catch: java.lang.Exception -> L62 java.lang.Throwable -> L81
            if (r2 <= 0) goto L73
            r2 = -1
            r1.moveToPosition(r2)     // Catch: java.lang.Exception -> L62 java.lang.Throwable -> L81
        L39:
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Exception -> L62 java.lang.Throwable -> L81
            if (r2 == 0) goto L73
            java.lang.String r2 = "inbox_no"
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Exception -> L62 java.lang.Throwable -> L81
            java.lang.String r2 = r1.getString(r2)     // Catch: java.lang.Exception -> L62 java.lang.Throwable -> L81
            java.lang.String r3 = "inbox_enable_translate"
            java.lang.String r4 = "N"
            r7.put(r3, r4)     // Catch: java.lang.Exception -> L62 java.lang.Throwable -> L81
            android.net.Uri r3 = com.sec.chaton.p057e.C2299s.f8209a     // Catch: java.lang.Exception -> L62 java.lang.Throwable -> L81
            java.lang.String r4 = "inbox_no=?"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Exception -> L62 java.lang.Throwable -> L81
            r6 = 0
            r5[r6] = r2     // Catch: java.lang.Exception -> L62 java.lang.Throwable -> L81
            r0.update(r3, r7, r4, r5)     // Catch: java.lang.Exception -> L62 java.lang.Throwable -> L81
            goto L39
        L62:
            r0 = move-exception
        L63:
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L81
            java.lang.String r2 = "InBoxDatabaseHelper"
            com.sec.chaton.util.C4904y.m18634a(r0, r2)     // Catch: java.lang.Throwable -> L81
            if (r1 == 0) goto L72
            r1.close()
        L72:
            return
        L73:
            if (r1 == 0) goto L72
            r1.close()
            goto L72
        L79:
            r0 = move-exception
            r1 = r6
        L7b:
            if (r1 == 0) goto L80
            r1.close()
        L80:
            throw r0
        L81:
            r0 = move-exception
            goto L7b
        L83:
            r0 = move-exception
            r1 = r6
            goto L63
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2198l.m9927a():void");
    }

    /* renamed from: c */
    public static int m9945c(ContentResolver contentResolver, String str, boolean z) {
        String str2 = z ? "Y" : "N";
        ContentValues contentValues = new ContentValues();
        contentValues.put("translate_outgoing_message", str2);
        return contentResolver.update(C2299s.f8209a, contentValues, "inbox_no=?", new String[]{str});
    }

    /* renamed from: a */
    public static void m9930a(ContentResolver contentResolver, String str, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_translate_my_language", str2);
        contentValues.put("inbox_translate_buddy_language", str3);
        contentResolver.update(C2299s.f8209a, contentValues, "inbox_no=?", new String[]{str});
    }

    /* renamed from: o */
    public static boolean m9962o(ContentResolver contentResolver, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursorQuery = contentResolver.query(C2299s.f8209a, null, "inbox_no=?", new String[]{str}, null);
        String string = "N";
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.moveToFirst();
            string = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_enable_translate"));
            if (string == null) {
                string = "N";
            }
        } else {
            C4904y.m18639b("isEnableTranslate() - can't find inbox", "[InboxDatabaseHelper]");
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return string.equals("Y");
    }

    /* renamed from: p */
    public static String m9963p(ContentResolver contentResolver, String str) {
        String strM9013d;
        C1850c c1850cM9024d = C1850c.m9024d();
        String str2 = c1850cM9024d.m9039e().f7017r;
        if (!TextUtils.isEmpty(str)) {
            Cursor cursorQuery = contentResolver.query(C2299s.f8209a, new String[]{"inbox_translate_my_language"}, "inbox_no=?", new String[]{str}, null);
            if (cursorQuery != null) {
                strM9013d = cursorQuery.moveToFirst() ? c1850cM9024d.m9039e().m9013d(cursorQuery.getString(0)) : str2;
                cursorQuery.close();
            } else {
                strM9013d = str2;
            }
            return strM9013d;
        }
        return str2;
    }

    /* renamed from: q */
    public static String m9964q(ContentResolver contentResolver, String str) {
        String strM9014e;
        C1850c c1850cM9024d = C1850c.m9024d();
        String str2 = c1850cM9024d.m9039e().f7017r;
        if (!TextUtils.isEmpty(str)) {
            Cursor cursorQuery = contentResolver.query(C2299s.f8209a, new String[]{"inbox_translate_buddy_language"}, "inbox_no=?", new String[]{str}, null);
            if (cursorQuery != null) {
                strM9014e = cursorQuery.moveToFirst() ? c1850cM9024d.m9039e().m9014e(cursorQuery.getString(0)) : str2;
                cursorQuery.close();
            } else {
                strM9014e = str2;
            }
            return strM9014e;
        }
        return str2;
    }

    /* renamed from: b */
    public static void m9940b() {
        C4904y.m18639b("updateInboxAfterSamsungAccountMapping() change oldID[" + C4809aa.m18104a().m18121a("old_chaton_id", "") + "] to newID[" + C4809aa.m18104a().m18121a("chaton_id", "") + "]", "[InboxDatabaseHelper]");
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_last_msg_sender", C4809aa.m18104a().m18121a("chaton_id", ""));
        GlobalApplication.m18732r().getContentResolver().update(C2299s.f8209a, contentValues, "inbox_last_msg_sender=?", new String[]{C4809aa.m18104a().m18121a("old_chaton_id", "")});
    }

    /* renamed from: c */
    public static void m9948c(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorRawQuery = null;
        ContentValues contentValues = new ContentValues();
        try {
            cursorRawQuery = sQLiteDatabase.rawQuery(InterfaceC2273bs.f8104m, null);
            if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
                cursorRawQuery.moveToPosition(-1);
                while (cursorRawQuery.moveToNext()) {
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("buddy_no"));
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("inbox_no"));
                    if (string.startsWith("0999")) {
                        contentValues.put("inbox_room_type", Integer.valueOf(EnumC2301u.LIVE.m10212a()));
                        sQLiteDatabase.update("inbox", contentValues, "inbox_no=?", new String[]{string2});
                    }
                }
            }
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    /* renamed from: a */
    public static int m9911a(ContentResolver contentResolver, String str, String str2, String str3, long j, Long l, EnumC2214ab enumC2214ab, int i) {
        String str4 = String.format("%d;%d;%s;%s", 1, Integer.valueOf(enumC2214ab.m10076a()), C1736gi.m8632a(str3), "");
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_last_msg_sender", str);
        contentValues.put("inbox_last_message", str4);
        contentValues.put("inbox_last_time", Long.valueOf(j));
        contentValues.put("inbox_last_msg_no", l);
        contentValues.put("inbox_last_chat_type", (Integer) 11);
        String strM9968u = m9968u(contentResolver, str2);
        contentValues.put("inbox_unread_count", Integer.valueOf(i));
        contentValues.put("inbox_title", strM9968u);
        return contentResolver.update(C2299s.f8209a, contentValues, "inbox_no=?", new String[]{str2});
    }

    /* renamed from: d */
    public static void m9950d(SQLiteDatabase sQLiteDatabase) throws Throwable {
        Cursor cursorQuery;
        ContentValues contentValues = new ContentValues();
        try {
            cursorQuery = sQLiteDatabase.query("inbox", null, "inbox_room_type=? AND inbox_valid!=?", new String[]{Integer.toString(EnumC2301u.LIVE.m10212a()), "N"}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        cursorQuery.moveToPosition(-1);
                        String string = "";
                        int columnIndex = cursorQuery.getColumnIndex("inbox_last_message");
                        int columnIndex2 = cursorQuery.getColumnIndex("inbox_no");
                        while (cursorQuery.moveToNext()) {
                            if (!TextUtils.isEmpty(string)) {
                                string = cursorQuery.getString(columnIndex);
                                String string2 = cursorQuery.getString(columnIndex2);
                                String[] strArrSplit = string.split(Config.KEYVALUE_SPLIT);
                                if (strArrSplit.length > 1) {
                                    strArrSplit[1] = Integer.toString(EnumC2214ab.LIVECONTENTS.m10076a());
                                    if (C4904y.f17873c) {
                                        C4904y.m18641c("adjusted last mesasge :" + strArrSplit[0] + strArrSplit[1], "InBoxDatabaseHelper");
                                    }
                                }
                                StringBuilder sb = new StringBuilder();
                                for (int i = 0; i < strArrSplit.length; i++) {
                                    sb.append(strArrSplit[i]);
                                    if (i != strArrSplit.length - 1) {
                                        sb.append(Config.KEYVALUE_SPLIT);
                                    }
                                }
                                contentValues.put("inbox_last_message", sb.toString());
                                sQLiteDatabase.update("inbox", contentValues, "inbox_no=?", new String[]{string2});
                            }
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

    /* renamed from: a */
    public static boolean m9932a(ContentResolver contentResolver, ArrayList<String> arrayList) {
        String string;
        String string2;
        boolean z;
        ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
        Iterator<String> it = arrayList.iterator();
        boolean z2 = true;
        while (it.hasNext()) {
            String next = it.next();
            m9942b(next);
            String strM18501b = C4873ck.m18501b();
            C4894o.m18606a(strM18501b + "/" + next);
            Cursor cursorQuery = contentResolver.query(C2299s.f8209a, new String[]{"inbox_old_no", "inbox_session_id"}, "inbox_no=?", new String[]{next}, null);
            if (cursorQuery == null) {
                string = "";
                string2 = null;
            } else {
                if (!cursorQuery.moveToFirst()) {
                    string = "";
                    string2 = null;
                } else {
                    string2 = cursorQuery.getString(0);
                    string = cursorQuery.getString(1);
                }
                cursorQuery.close();
            }
            if (!TextUtils.isEmpty(string2)) {
                String[] strArrSplit = string2.split(",");
                if (strArrSplit.length > 0) {
                    for (String str : strArrSplit) {
                        m9942b(str);
                        C4894o.m18606a(strM18501b + "/" + str);
                    }
                }
            }
            arrayList2.add(ContentProviderOperation.newDelete(C2299s.f8209a).withSelection("inbox_no=?", new String[]{next}).build());
            arrayList2.add(ContentProviderOperation.newDelete(C2306z.f8229a).withSelection("message_inbox_no=?", new String[]{next}).build());
            arrayList2.add(ContentProviderOperation.newDelete(C2220ah.f7942a).withSelection("participants_inbox_no=?", new String[]{next}).build());
            C2142w c2142wM9606c = C2142w.m9606c(next);
            if (c2142wM9606c != null) {
                c2142wM9606c.mo9274d();
                C2142w.m9610d(next);
            }
            try {
                if (!TextUtils.isEmpty(string)) {
                    C4664a.m17659a(CommonApplication.m18732r(), C4664a.m17655a(string));
                } else {
                    C2434a.m10540a().m10544a(next);
                    C2438e.m10572a().m10579a(next);
                }
                z = z2;
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            Iterator<String> it2 = C2176ab.m9694e(GlobalApplication.m18732r().getContentResolver(), next).iterator();
            while (it2.hasNext()) {
                C2496n.m10790e(CommonApplication.m18732r(), it2.next());
            }
            z2 = z;
        }
        try {
            if (arrayList2.size() > 0) {
                contentResolver.applyBatch("com.sec.chaton.provider", arrayList2);
            }
        } catch (OperationApplicationException e2) {
            C4904y.m18634a(e2.toString(), "InBoxDatabaseHelper");
            z2 = false;
        } catch (RemoteException e3) {
            C4904y.m18634a(e3.toString(), "InBoxDatabaseHelper");
            z2 = false;
        }
        arrayList2.clear();
        if (C4904y.f17872b) {
            C4904y.m18639b("deleteEndChatRoom() result[" + z2 + "]", "InBoxDatabaseHelper");
        }
        return z2;
    }

    /* renamed from: b */
    private static void m9942b(String str) {
        File[] fileArrListFiles = CommonApplication.m18732r().getFilesDir().getAbsoluteFile().listFiles(new C2199m(str));
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file : fileArrListFiles) {
                C4904y.m18639b("[Delete File] " + file + " : " + file.delete(), "InBoxDatabaseHelper");
            }
        }
    }

    /* renamed from: r */
    public static boolean m9965r(ContentResolver contentResolver, String str) throws Throwable {
        Cursor cursorQuery;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            cursorQuery = contentResolver.query(C2299s.f8209a, new String[]{"inbox_no"}, "inbox_no=?", new String[]{str}, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() != 0) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return true;
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
            return false;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /* renamed from: s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m9966s(android.content.ContentResolver r8, java.lang.String r9) throws java.lang.Throwable {
        /*
            r6 = 0
            java.lang.String r7 = ""
            android.net.Uri r1 = com.sec.chaton.p057e.C2299s.f8209a     // Catch: java.lang.Throwable -> L3a
            r0 = 1
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L3a
            r0 = 0
            java.lang.String r3 = "inbox_session_id"
            r2[r0] = r3     // Catch: java.lang.Throwable -> L3a
            java.lang.String r3 = "inbox_no =?"
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L3a
            r0 = 0
            r4[r0] = r9     // Catch: java.lang.Throwable -> L3a
            r5 = 0
            r0 = r8
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L3a
            if (r1 == 0) goto L44
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L42
            if (r0 <= 0) goto L44
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L42
            java.lang.String r0 = "inbox_session_id"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L42
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L42
        L34:
            if (r1 == 0) goto L39
            r1.close()
        L39:
            return r0
        L3a:
            r0 = move-exception
            r1 = r6
        L3c:
            if (r1 == 0) goto L41
            r1.close()
        L41:
            throw r0
        L42:
            r0 = move-exception
            goto L3c
        L44:
            r0 = r7
            goto L34
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2198l.m9966s(android.content.ContentResolver, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /* renamed from: t */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m9967t(android.content.ContentResolver r8, java.lang.String r9) throws java.lang.Throwable {
        /*
            r6 = 0
            java.lang.String r7 = ""
            android.net.Uri r1 = com.sec.chaton.p057e.C2299s.f8209a     // Catch: java.lang.Throwable -> L3a
            r0 = 1
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L3a
            r0 = 0
            java.lang.String r3 = "inbox_no"
            r2[r0] = r3     // Catch: java.lang.Throwable -> L3a
            java.lang.String r3 = "inbox_session_id =?"
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L3a
            r0 = 0
            r4[r0] = r9     // Catch: java.lang.Throwable -> L3a
            r5 = 0
            r0 = r8
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L3a
            if (r1 == 0) goto L44
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L42
            if (r0 <= 0) goto L44
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L42
            java.lang.String r0 = "inbox_no"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L42
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L42
        L34:
            if (r1 == 0) goto L39
            r1.close()
        L39:
            return r0
        L3a:
            r0 = move-exception
            r1 = r6
        L3c:
            if (r1 == 0) goto L41
            r1.close()
        L41:
            throw r0
        L42:
            r0 = move-exception
            goto L3c
        L44:
            r0 = r7
            goto L34
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2198l.m9967t(android.content.ContentResolver, java.lang.String):java.lang.String");
    }

    /* renamed from: e */
    public static void m9952e(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        ContentValues contentValues = new ContentValues();
        try {
            contentValues.put("inbox_last_timestamp", (Integer) 0);
            sQLiteDatabase.update("inbox", contentValues, "inbox_chat_type=?", new String[]{String.valueOf(EnumC2300t.GROUPCHAT.m10210a())});
        } finally {
            if (0 != 0) {
                cursor.close();
            }
        }
    }

    /* renamed from: b */
    public static int m9936b(ContentResolver contentResolver, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        if (C4904y.f17873c) {
            C4904y.m18641c("title: " + str2, "InBoxDatabaseHelper");
        }
        contentValues.put("inbox_title", str2);
        contentValues.put("inbox_title_fixed", "Y");
        return contentResolver.update(C2299s.m10206s(), contentValues, "inbox_no=?", new String[]{str});
    }

    /* renamed from: c */
    public static int m9944c(ContentResolver contentResolver, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        if (C4904y.f17873c) {
            C4904y.m18641c("title: " + str2, "InBoxDatabaseHelper");
        }
        contentValues.put("inbox_title", str2);
        contentValues.put("inbox_title_fixed", "Y");
        return contentResolver.update(C2299s.m10206s(), contentValues, "inbox_session_id=?", new String[]{str});
    }
}
