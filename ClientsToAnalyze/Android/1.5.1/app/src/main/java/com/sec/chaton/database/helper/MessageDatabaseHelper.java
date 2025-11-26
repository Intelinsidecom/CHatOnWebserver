package com.sec.chaton.database.helper;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.common.SSMGPB;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p000io.entry.PushEntry;
import com.sec.chaton.p000io.entry.inner.Msg;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.MessageIDGenerator;
import com.sec.chaton.util.StorageStateInfoUtil;
import java.text.SimpleDateFormat;

/* loaded from: classes.dex */
public class MessageDatabaseHelper {
    /* renamed from: a */
    public static Uri m2272a(ContentResolver contentResolver, String str, ChatONContract.MessageTable.MsgContentType msgContentType, Msg msg, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(MessageIDGenerator.m3598a()));
        contentValues.put("message_sever_id", msg.f1917id);
        contentValues.put("message_inbox_no", str);
        contentValues.put("message_content", msg.value);
        contentValues.put("message_time", msg.time);
        contentValues.put("message_tid", msg.tid);
        contentValues.put("message_type", (Integer) 2);
        contentValues.put("message_sender", msg.sender);
        contentValues.put("message_content_type", Integer.valueOf(msgContentType.m2197a()));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(msg.time));
        contentValues.put("message_need_update", "N");
        if (str2 != null) {
            contentValues.put("message_formatted", str2);
        }
        return contentResolver.insert(ChatONContract.MessageTable.f1726a, contentValues);
    }

    /* renamed from: a */
    public static Uri m2273a(ContentResolver contentResolver, String str, String str2, long j, String str3) {
        if (m2295a(contentResolver, str3, str)) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(MessageIDGenerator.m3598a()));
        contentValues.put("message_sever_id", str3);
        contentValues.put("message_inbox_no", str);
        contentValues.put("message_type", (Integer) 1);
        contentValues.put("message_content_type", Integer.valueOf(ChatONContract.MessageTable.MsgContentType.SYSTEM.m2197a()));
        contentValues.put("message_content", str2);
        contentValues.put("message_time", Long.valueOf(j));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(j)));
        return contentResolver.insert(ChatONContract.MessageTable.f1726a, contentValues);
    }

    /* renamed from: a */
    public static Uri m2274a(ContentResolver contentResolver, String str, String str2, ChatONContract.MessageTable.MsgContentType msgContentType, String str3, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", str);
        contentValues.put("message_inbox_no", str2);
        contentValues.put("message_read_status", Integer.valueOf(i));
        contentValues.put("message_content_type", Integer.valueOf(msgContentType.m2197a()));
        contentValues.put("message_content", str3);
        contentValues.put("message_sender", ChatONPref.m3519a().getString("msisdn", ""));
        long jCurrentTimeMillis = System.currentTimeMillis();
        contentValues.put("message_time", Long.valueOf(jCurrentTimeMillis));
        contentValues.put("message_type", (Integer) 0);
        contentValues.put("message_is_failed", (Integer) 1);
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(jCurrentTimeMillis)));
        return contentResolver.insert(ChatONContract.MessageTable.f1726a, contentValues);
    }

    /* renamed from: a */
    public static ChatONContract.MessageTable.MsgContentType m2275a(String str) {
        return m2276a(str, (ChatONContract.MessageTable.MsgContentType) null);
    }

    /* renamed from: a */
    public static ChatONContract.MessageTable.MsgContentType m2276a(String str, ChatONContract.MessageTable.MsgContentType msgContentType) {
        if (msgContentType == ChatONContract.MessageTable.MsgContentType.TEXT) {
            return ChatONContract.MessageTable.MsgContentType.TEXT;
        }
        String[] strArrSplit = str.split("\n");
        return strArrSplit[0].equals("image") ? ChatONContract.MessageTable.MsgContentType.IMAGE : strArrSplit[0].equals("video") ? ChatONContract.MessageTable.MsgContentType.VIDEO : strArrSplit[0].equals("geo") ? ChatONContract.MessageTable.MsgContentType.GEO : strArrSplit[0].equals("audio") ? ChatONContract.MessageTable.MsgContentType.AUDIO : strArrSplit[0].equals("contact") ? ChatONContract.MessageTable.MsgContentType.CONTACT : strArrSplit[0].equals("calendar") ? ChatONContract.MessageTable.MsgContentType.CALENDAR : ChatONContract.MessageTable.MsgContentType.TEXT;
    }

    /* renamed from: a */
    public static void m2277a(ContentResolver contentResolver) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_type", (Integer) (-1));
        contentValues.put("message_is_failed", (Integer) 2);
        ChatONLogWriter.m3508c("updateAllSendingMsgToFail() - count:" + contentResolver.update(ChatONContract.MessageTable.f1726a, contentValues, "message_type=0", null), "MessageDatabaseHelper");
    }

    /* renamed from: a */
    public static void m2278a(ContentResolver contentResolver, Long l) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_type", (Integer) (-1));
        contentValues.put("message_is_failed", (Integer) 2);
        contentResolver.update(ChatONContract.MessageTable.f1726a, contentValues, "_id=" + l, null);
    }

    /* renamed from: a */
    public static void m2279a(ContentResolver contentResolver, Long l, Long l2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_type", (Integer) (-1));
        contentValues.put("message_is_failed", (Integer) 2);
        contentValues.put("_id", l2);
        contentResolver.update(ChatONContract.MessageTable.f1726a, contentValues, "_id=" + l, null);
    }

    /* renamed from: a */
    public static void m2280a(ContentResolver contentResolver, Long l, Long l2, boolean z) {
        ContentValues contentValues = new ContentValues();
        if (!z) {
            contentValues.put("message_type", (Integer) (-1));
        }
        contentValues.put("message_is_failed", (Integer) 3);
        contentValues.put("_id", l2);
        contentResolver.update(ChatONContract.MessageTable.f1726a, contentValues, "_id=" + l, null);
    }

    /* renamed from: a */
    public static void m2281a(ContentResolver contentResolver, Long l, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_type", (Integer) (-1));
        contentValues.put("message_is_failed", (Integer) 2);
        contentValues.put("message_formatted", str);
        contentResolver.update(ChatONContract.MessageTable.f1726a, contentValues, "_id=" + l, null);
    }

    /* renamed from: a */
    public static void m2282a(ContentResolver contentResolver, Long l, String str, long j, Long l2, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_time", l);
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(l));
        contentValues.put("message_session_id", str);
        contentValues.put("message_sever_id", Long.valueOf(j));
        contentValues.put("message_type", (Integer) 1);
        contentValues.put("message_is_failed", (Integer) 0);
        contentValues.put("message_read_status", Integer.valueOf(i));
        contentResolver.update(ChatONContract.MessageTable.f1726a, contentValues, "_id=?", new String[]{String.valueOf(l2)});
    }

    /* renamed from: a */
    public static void m2283a(ContentResolver contentResolver, Long l, boolean z) {
        ContentValues contentValues = new ContentValues();
        if (!z) {
            contentValues.put("message_type", (Integer) (-1));
        }
        contentValues.put("message_is_failed", (Integer) 3);
        contentResolver.update(ChatONContract.MessageTable.f1726a, contentValues, "_id=" + l, null);
    }

    /* renamed from: a */
    public static void m2284a(ContentResolver contentResolver, String str, ChatONContract.MessageTable.MsgContentType msgContentType, Msg msg, ChatONContract.InBoxTable.ChatType chatType, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_need_update", "N");
        contentValues.put("message_content", msg.value);
        contentValues.put("message_content_type", Integer.valueOf(msgContentType.m2197a()));
        contentValues.put("message_time", msg.time);
        contentValues.put("message_tid", msg.tid);
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(msg.time));
        if (str2 != null) {
            contentValues.put("message_formatted", str2);
        }
        contentResolver.update(ChatONContract.MessageTable.f1726a, contentValues, "message_sever_id=? AND message_inbox_no=? AND message_sender=?", new String[]{msg.f1917id, str, msg.sender});
    }

    /* renamed from: a */
    public static void m2285a(ContentResolver contentResolver, String str, Long l, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_formatted", str2);
        contentValues.put("message_inbox_no", str);
        if (m2292a(contentResolver, String.valueOf(l))) {
            contentResolver.update(ChatONContract.MessageTable.f1726a, contentValues, "_id=?", new String[]{String.valueOf(l)});
        } else {
            contentValues.put("_id", Long.valueOf(MessageIDGenerator.m3598a()));
            contentResolver.insert(ChatONContract.MessageTable.f1726a, contentValues);
        }
    }

    /* renamed from: a */
    public static void m2286a(ContentResolver contentResolver, String str, String str2, Long l, ChatONContract.InBoxTable.ChatType chatType, boolean z) {
        ContentValues contentValues = new ContentValues();
        if (z) {
            contentValues.put("message_type", (Integer) 3);
        } else {
            contentValues.put("message_type", (Integer) 4);
        }
        if (m2296a(contentResolver, str, String.valueOf(l), str2)) {
            contentResolver.update(ChatONContract.MessageTable.f1726a, contentValues, "message_sever_id=? AND message_inbox_no=? AND message_sender=?", new String[]{String.valueOf(l), str2, str});
        }
    }

    /* renamed from: a */
    public static void m2287a(ContentResolver contentResolver, String str, String str2, Long l, String str3, ChatONContract.InBoxTable.ChatType chatType, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_content", str3);
        contentValues.put("message_stored_ext", Integer.valueOf(z ? 1 : 0));
        contentResolver.update(ChatONContract.MessageTable.f1726a, contentValues, "_id=?", new String[]{String.valueOf(l)});
    }

    /* renamed from: a */
    public static void m2288a(ContentResolver contentResolver, String str, String str2, Long l, String str3, ChatONContract.InBoxTable.ChatType chatType, boolean z, boolean z2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_download_uri", str3);
        contentValues.put("message_inbox_no", str2);
        contentValues.put("message_sever_id", l);
        contentValues.put("message_sender", str);
        contentValues.put("message_stored_ext", Integer.valueOf(z ? 1 : 0));
        if (z2) {
            contentValues.put("message_type", (Integer) 2);
        } else {
            contentValues.put("message_type", (Integer) 4);
        }
        if (m2296a(contentResolver, str, String.valueOf(l), str2)) {
            contentResolver.update(ChatONContract.MessageTable.f1726a, contentValues, "message_sever_id=? AND message_inbox_no=? AND message_sender=?", new String[]{String.valueOf(l), str2, str});
        } else {
            ChatONLogWriter.m3506b("updateMediaURI(Insert)XXX", GlobalApplication.m2387e().getClass().getName());
        }
    }

    /* renamed from: a */
    public static void m2289a(NotifyingAsyncQueryHandler notifyingAsyncQueryHandler, int i, Long l) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_type", (Integer) 0);
        contentValues.put("message_is_failed", (Integer) 1);
        notifyingAsyncQueryHandler.startUpdate(i, null, ChatONContract.MessageTable.f1726a, contentValues, "_id=?", new String[]{String.valueOf(l)});
    }

    /* renamed from: a */
    public static void m2290a(NotifyingAsyncQueryHandler notifyingAsyncQueryHandler, int i, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(MessageIDGenerator.m3598a()));
        contentValues.put("message_inbox_no", str);
        contentValues.put("message_type", (Integer) 1);
        contentValues.put("message_content_type", Integer.valueOf(ChatONContract.MessageTable.MsgContentType.SYSTEM.m2197a()));
        contentValues.put("message_content", str2);
        long jCurrentTimeMillis = System.currentTimeMillis();
        contentValues.put("message_time", Long.valueOf(jCurrentTimeMillis));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(jCurrentTimeMillis)));
        notifyingAsyncQueryHandler.startInsert(i, null, ChatONContract.MessageTable.f1726a, contentValues);
    }

    /* renamed from: a */
    public static void m2291a(NotifyingAsyncQueryHandler notifyingAsyncQueryHandler, int i, String str, String str2, ChatONContract.MessageTable.MsgContentType msgContentType, String str3, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", str);
        contentValues.put("message_inbox_no", str2);
        contentValues.put("message_read_status", Integer.valueOf(i2));
        contentValues.put("message_content_type", Integer.valueOf(msgContentType.m2197a()));
        contentValues.put("message_content", str3);
        contentValues.put("message_sender", ChatONPref.m3519a().getString("msisdn", ""));
        long jCurrentTimeMillis = System.currentTimeMillis();
        contentValues.put("message_time", Long.valueOf(jCurrentTimeMillis));
        contentValues.put("message_type", (Integer) 0);
        contentValues.put("message_is_failed", (Integer) 1);
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(jCurrentTimeMillis)));
        notifyingAsyncQueryHandler.startInsert(i, null, ChatONContract.MessageTable.f1726a, contentValues);
    }

    /* renamed from: a */
    public static boolean m2292a(ContentResolver contentResolver, String str) {
        Cursor cursorQuery = contentResolver.query(ChatONContract.MessageTable.f1726a, null, "_id=?", new String[]{str}, null);
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
    public static boolean m2293a(ContentResolver contentResolver, String str, ChatONContract.MessageTable.MsgContentType msgContentType, SSMGPB.InboxMessage inboxMessage, String str2, Long l, String str3, ChatONContract.InBoxTable.ChatType chatType) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_content", inboxMessage.m1554j());
        contentValues.put("message_sever_id", Long.valueOf(inboxMessage.m1552h()));
        contentValues.put("message_time", Long.valueOf(inboxMessage.m1556l()));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(inboxMessage.m1556l())));
        contentValues.put("message_sender", inboxMessage.m1548d());
        contentValues.put("message_session_id", str);
        contentValues.put("message_read_status", Integer.valueOf(inboxMessage.m1550f()));
        contentValues.put("message_content_type", Integer.valueOf(msgContentType.m2197a()));
        contentValues.put("message_inbox_no", str2);
        contentValues.put("message_type", (Integer) 2);
        contentValues.put("message_need_update", "N");
        if (str3 != null) {
            contentValues.put("message_formatted", str3);
        }
        if (m2296a(contentResolver, inboxMessage.m1548d(), String.valueOf(l), str2)) {
            if (m2300b(contentResolver, inboxMessage.m1548d(), String.valueOf(l), str2)) {
                contentResolver.update(ChatONContract.MessageTable.f1726a, contentValues, "message_sever_id=? AND message_inbox_no=? AND message_sender=?", new String[]{String.valueOf(l), str2, inboxMessage.m1548d()});
            }
            return true;
        }
        contentValues.put("_id", Long.valueOf(MessageIDGenerator.m3598a()));
        contentResolver.insert(ChatONContract.MessageTable.f1726a, contentValues);
        return false;
    }

    /* renamed from: a */
    public static boolean m2294a(ContentResolver contentResolver, String str, ChatONContract.MessageTable.MsgContentType msgContentType, PushEntry pushEntry, ChatONContract.InBoxTable.ChatType chatType) {
        if (m2296a(contentResolver, pushEntry.senderID, String.valueOf(pushEntry.msgID), str)) {
            return true;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_inbox_no", str);
        contentValues.put("message_content", pushEntry.message);
        contentValues.put("message_sender", pushEntry.senderID);
        contentValues.put("message_session_id", pushEntry.sessionID);
        contentValues.put("message_sever_id", pushEntry.msgID);
        contentValues.put("message_time", pushEntry.sentTime);
        contentValues.put("message_type", (Integer) 2);
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(pushEntry.sentTime));
        contentValues.put("message_content_type", Integer.valueOf(msgContentType.m2197a()));
        contentValues.put("message_need_update", "Y");
        contentValues.put("_id", pushEntry.msgID);
        contentResolver.insert(ChatONContract.MessageTable.f1726a, contentValues);
        return false;
    }

    /* renamed from: a */
    public static boolean m2295a(ContentResolver contentResolver, String str, String str2) {
        Cursor cursorQuery = contentResolver.query(ChatONContract.MessageTable.f1726a, null, "message_sever_id=? AND message_inbox_no=? AND message_content_type=?", new String[]{str, str2, String.valueOf(ChatONContract.MessageTable.MsgContentType.SYSTEM.m2197a())}, null);
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
    public static boolean m2296a(ContentResolver contentResolver, String str, String str2, String str3) {
        Cursor cursorQuery = contentResolver.query(ChatONContract.MessageTable.f1726a, null, "message_sever_id=? AND message_inbox_no=? AND message_sender=?", new String[]{str2, str3, str}, null);
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
    public static Uri m2297b(ContentResolver contentResolver, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(MessageIDGenerator.m3598a()));
        contentValues.put("message_inbox_no", str);
        contentValues.put("message_type", (Integer) 1);
        contentValues.put("message_content_type", Integer.valueOf(ChatONContract.MessageTable.MsgContentType.SYSTEM.m2197a()));
        contentValues.put("message_content", str2);
        long jCurrentTimeMillis = System.currentTimeMillis();
        contentValues.put("message_time", Long.valueOf(jCurrentTimeMillis));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(jCurrentTimeMillis)));
        return contentResolver.insert(ChatONContract.MessageTable.f1726a, contentValues);
    }

    /* renamed from: b */
    public static Uri m2298b(ContentResolver contentResolver, String str, String str2, ChatONContract.MessageTable.MsgContentType msgContentType, String str3, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", str);
        contentValues.put("message_inbox_no", str2);
        contentValues.put("message_read_status", Integer.valueOf(i));
        contentValues.put("message_content_type", Integer.valueOf(msgContentType.m2197a()));
        contentValues.put("message_download_uri", str3);
        contentValues.put("message_sender", ChatONPref.m3519a().getString("msisdn", ""));
        long jCurrentTimeMillis = System.currentTimeMillis();
        contentValues.put("message_time", Long.valueOf(jCurrentTimeMillis));
        contentValues.put("message_type", (Integer) 0);
        contentValues.put("message_is_failed", (Integer) 1);
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(jCurrentTimeMillis)));
        contentValues.put("message_stored_ext", Integer.valueOf(StorageStateInfoUtil.m3677a() ? 1 : 0));
        return contentResolver.insert(ChatONContract.MessageTable.f1726a, contentValues);
    }

    /* renamed from: b */
    public static void m2299b(ContentResolver contentResolver, Long l) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_type", (Integer) 5);
        contentResolver.update(ChatONContract.MessageTable.f1726a, contentValues, "_id=" + l, null);
    }

    /* renamed from: b */
    public static boolean m2300b(ContentResolver contentResolver, String str, String str2, String str3) {
        Cursor cursorQuery = contentResolver.query(ChatONContract.MessageTable.f1726a, null, "message_sever_id=? AND message_inbox_no=? AND message_sender=? AND message_need_update=?", new String[]{str2, str3, str, "Y"}, null);
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

    /* renamed from: c */
    public static void m2301c(ContentResolver contentResolver, Long l) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_type", (Integer) 0);
        contentResolver.update(ChatONContract.MessageTable.f1726a, contentValues, "_id=" + l, null);
    }
}
