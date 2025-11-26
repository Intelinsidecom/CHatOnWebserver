package com.sec.chaton.database.helper;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.C0062R;
import com.sec.chaton.chat.ChatUtil;
import com.sec.chaton.common.SSMGPB;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.TcpContext;
import com.sec.chaton.p000io.entry.PushEntry;
import com.sec.chaton.p000io.entry.inner.Msg;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class InBoxDatabaseHelper {

    public class InBoxData {

        /* renamed from: a */
        public String f1756a;

        /* renamed from: b */
        public int f1757b;

        /* renamed from: c */
        public int f1758c;

        /* renamed from: d */
        public String f1759d;

        /* renamed from: e */
        public String f1760e;

        /* renamed from: f */
        public long f1761f;

        /* renamed from: g */
        public int f1762g;

        /* renamed from: h */
        public String f1763h;

        /* renamed from: i */
        public long f1764i;

        /* renamed from: j */
        public String f1765j;

        /* renamed from: k */
        public String f1766k;

        /* renamed from: l */
        public int f1767l;

        /* renamed from: m */
        public String f1768m;

        /* renamed from: n */
        public String f1769n;

        /* renamed from: o */
        public int f1770o;
    }

    /* renamed from: a */
    public static int m2238a(ContentResolver contentResolver, String str) {
        Cursor cursorQuery = contentResolver.query(ChatONContract.InBoxTable.f1717a, new String[]{"_id"}, "inbox_no=?", new String[]{str}, null);
        if (cursorQuery == null) {
            return 0;
        }
        int i = cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        cursorQuery.close();
        return i;
    }

    /* renamed from: a */
    public static int m2239a(ContentResolver contentResolver, String str, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_trunk_unread_count", Integer.valueOf(i));
        contentResolver.update(ChatONContract.InBoxTable.f1717a, contentValues, "inbox_session_id=?", new String[]{str});
        return i;
    }

    /* renamed from: a */
    public static int m2240a(ContentResolver contentResolver, String str, SSMGPB.InitChatReply initChatReply, ChatONContract.InBoxTable.ChatType chatType, String str2, String[] strArr, ChatONContract.MessageTable.MsgContentType msgContentType) {
        String str3 = String.format("%d;%d;%s;%s", 1, Integer.valueOf(msgContentType.m2197a()), ChatUtil.m795a(str2), "");
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_chat_type", Integer.valueOf(chatType.m2189a()));
        contentValues.put("inbox_participants", Integer.valueOf(strArr.length));
        contentValues.put("inbox_last_message", str3);
        if (initChatReply.m1604j() == null) {
            contentValues.put("inbox_server_ip", GlobalApplication.m2389g().m3602b().m3603a());
            contentValues.put("inbox_server_port", Integer.valueOf(GlobalApplication.m2389g().m3602b().m3606b()));
        } else {
            contentValues.put("inbox_server_ip", initChatReply.m1604j().m1925d());
            contentValues.put("inbox_server_port", Integer.valueOf(initChatReply.m1604j().m1927f()));
        }
        contentValues.put("inbox_last_msg_sender", ChatONPref.m3519a().getString("msisdn", ""));
        contentValues.put("inbox_last_msg_no", Long.valueOf(initChatReply.m1598d()));
        if (initChatReply.m1600f().equals("null")) {
            ChatONLogWriter.m3509d("String NULL");
        } else if (initChatReply.m1600f() == null) {
            ChatONLogWriter.m3509d("Object NULL");
        }
        contentValues.put("inbox_session_id", initChatReply.m1600f());
        contentValues.put("inbox_last_time", Long.valueOf(initChatReply.m1602h()));
        return contentResolver.update(ChatONContract.InBoxTable.f1717a, contentValues, "inbox_no=?", new String[]{str});
    }

    /* renamed from: a */
    public static int m2241a(ContentResolver contentResolver, String str, InBoxData inBoxData) {
        ContentValues contentValues = new ContentValues();
        Cursor cursorM2306a = ParticipantDatabaseHelper.m2306a(contentResolver, str);
        if (cursorM2306a != null) {
            inBoxData.f1762g = cursorM2306a.getCount();
            if (inBoxData.f1766k.equalsIgnoreCase("n")) {
                inBoxData.f1760e = ChatUtil.m794a(cursorM2306a);
                contentValues.put("inbox_title", inBoxData.f1760e);
            }
            cursorM2306a.close();
        }
        contentValues.put("inbox_participants", Integer.valueOf(inBoxData.f1762g));
        contentValues.put("inbox_last_message", inBoxData.f1759d);
        if (inBoxData.f1769n != null) {
            contentValues.put("inbox_server_ip", inBoxData.f1769n);
            contentValues.put("inbox_server_port", Integer.valueOf(inBoxData.f1770o));
        }
        contentValues.put("inbox_last_msg_sender", inBoxData.f1765j);
        contentValues.put("inbox_last_msg_no", Long.valueOf(inBoxData.f1764i));
        contentValues.put("inbox_session_id", inBoxData.f1763h);
        contentValues.put("inbox_last_time", Long.valueOf(inBoxData.f1761f));
        contentValues.put("inbox_unread_count", Integer.valueOf(inBoxData.f1758c));
        return contentResolver.update(ChatONContract.InBoxTable.f1717a, contentValues, "inbox_no=?", new String[]{str});
    }

    /* renamed from: a */
    public static int m2242a(ContentResolver contentResolver, String str, String str2, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_server_ip", str2);
        contentValues.put("inbox_server_port", Integer.valueOf(i));
        return contentResolver.update(ChatONContract.InBoxTable.f1717a, contentValues, "inbox_no=?", new String[]{str});
    }

    /* renamed from: a */
    public static Uri m2243a(ContentResolver contentResolver, String str, SSMGPB.InitChatReply initChatReply, String str2, ChatONContract.InBoxTable.ChatType chatType, int i, ChatONContract.MessageTable.MsgContentType msgContentType) {
        boolean zEqualsIgnoreCase;
        String strM2265g;
        boolean z;
        if (chatType == ChatONContract.InBoxTable.ChatType.BROADCAST) {
            Cursor cursorQuery = contentResolver.query(ChatONContract.InBoxTable.f1717a, null, "inbox_no=?", new String[]{str}, null);
            if (cursorQuery == null || cursorQuery.getCount() == 0) {
                SharedPreferences sharedPreferencesM3519a = ChatONPref.m3519a();
                int i2 = (sharedPreferencesM3519a.contains("broadcast_count") ? sharedPreferencesM3519a.getInt("broadcast_count", 0) : 0) + 1;
                strM2265g = Integer.toString(i2);
                sharedPreferencesM3519a.edit().putInt("broadcast_count", i2).commit();
                z = true;
                zEqualsIgnoreCase = false;
            } else {
                cursorQuery.moveToFirst();
                strM2265g = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_title"));
                zEqualsIgnoreCase = "Y".equalsIgnoreCase(cursorQuery.getString(cursorQuery.getColumnIndex("inbox_title_fixed")));
                z = false;
            }
        } else {
            zEqualsIgnoreCase = false;
            strM2265g = m2265g(contentResolver, str);
            z = true;
        }
        String str3 = String.format("%d;%d;%s;%s", 1, Integer.valueOf(msgContentType.m2197a()), ChatUtil.m795a(str2), "");
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_no", str);
        contentValues.put("inbox_chat_type", Integer.valueOf(chatType.m2189a()));
        contentValues.put("inbox_participants", Integer.valueOf(i));
        contentValues.put("inbox_last_message", str3);
        if (initChatReply.m1604j() == null) {
            contentValues.put("inbox_server_ip", GlobalApplication.m2389g().m3602b().m3603a());
            contentValues.put("inbox_server_port", Integer.valueOf(GlobalApplication.m2389g().m3602b().m3606b()));
        } else {
            contentValues.put("inbox_server_ip", initChatReply.m1604j().m1925d());
            contentValues.put("inbox_server_port", Integer.valueOf(initChatReply.m1604j().m1927f()));
        }
        contentValues.put("inbox_last_msg_sender", ChatONPref.m3519a().getString("msisdn", ""));
        contentValues.put("inbox_last_msg_no", Long.valueOf(initChatReply.m1598d()));
        contentValues.put("inbox_session_id", initChatReply.m1600f());
        contentValues.put("inbox_last_time", Long.valueOf(initChatReply.m1602h()));
        contentValues.put("inbox_title", strM2265g);
        if (chatType == ChatONContract.InBoxTable.ChatType.BROADCAST && zEqualsIgnoreCase) {
            contentValues.put("inbox_title_fixed", "Y");
        }
        contentValues.put("inbox_last_chat_type", (Integer) 11);
        if (!z) {
            contentValues.put("inbox_is_new", "N");
        }
        try {
            return contentResolver.insert(ChatONContract.InBoxTable.f1717a, contentValues);
        } catch (Exception e) {
            ChatONLogWriter.m3501a(e, "InBoxDatabaseHelper");
            return null;
        }
    }

    /* renamed from: a */
    public static Uri m2244a(ContentResolver contentResolver, String str, ChatONContract.InBoxTable.ChatType chatType, PushEntry pushEntry) {
        StringBuilder sb = new StringBuilder();
        sb.append(2).append(";");
        if (pushEntry.msgType.intValue() == ChatONContract.MessageTable.MsgServerType.MSG.m2198a()) {
            sb.append(ChatONContract.MessageTable.MsgServerType.MSG.m2198a()).append(";").append(ChatUtil.m795a(pushEntry.message)).append(";");
        } else {
            sb.append(MessageDatabaseHelper.m2276a(pushEntry.message, ChatONContract.MessageTable.MsgContentType.m2195a(pushEntry.msgType.intValue())).m2197a()).append(";").append(";");
        }
        if (chatType == ChatONContract.InBoxTable.ChatType.GROUPCHAT) {
            sb.append(ChatUtil.m795a(ParticipantDatabaseHelper.m2317e(contentResolver, str, pushEntry.senderID)));
        }
        String string = sb.toString();
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_last_message", string);
        contentValues.put("inbox_last_time", pushEntry.sentTime);
        contentValues.put("inbox_unread_count", (Integer) 1);
        contentValues.put("inbox_server_ip", pushEntry.f1916IP);
        contentValues.put("inbox_server_port", pushEntry.PORT);
        if (TextUtils.isEmpty(pushEntry.sessionID) || pushEntry.sessionID.equalsIgnoreCase("null")) {
            contentValues.putNull("inbox_session_id");
        } else {
            contentValues.put("inbox_session_id", pushEntry.sessionID);
        }
        contentValues.put("inbox_last_msg_no", pushEntry.msgID);
        contentValues.put("inbox_last_msg_sender", pushEntry.senderID);
        contentValues.put("inbox_no", str);
        contentValues.put("inbox_participants", pushEntry.receiverCount);
        switch (C0214a.f1780b[chatType.ordinal()]) {
            case 1:
            case 2:
                contentValues.put("inbox_chat_type", Integer.valueOf(ChatONContract.InBoxTable.ChatType.ONETOONE.m2189a()));
                contentValues.put("inbox_title", ParticipantDatabaseHelper.m2317e(contentResolver, str, pushEntry.senderID));
                break;
            case 3:
                contentValues.put("inbox_chat_type", Integer.valueOf(ChatONContract.InBoxTable.ChatType.GROUPCHAT.m2189a()));
                contentValues.put("inbox_title", ParticipantDatabaseHelper.m2317e(contentResolver, str, pushEntry.senderID));
                break;
        }
        contentValues.put("inbox_last_chat_type", (Integer) 10);
        try {
            return contentResolver.insert(ChatONContract.InBoxTable.f1717a, contentValues);
        } catch (Exception e) {
            ChatONLogWriter.m3501a(e, "InBoxDatabaseHelper");
            return null;
        }
    }

    /* renamed from: a */
    public static Uri m2245a(ContentResolver contentResolver, String str, ChatONContract.InBoxTable.ChatType chatType, Msg msg, ChatONContract.MessageTable.MsgServerType msgServerType) {
        StringBuilder sb = new StringBuilder();
        sb.append(2).append(";");
        if (msgServerType == ChatONContract.MessageTable.MsgServerType.MSG) {
            sb.append(ChatONContract.MessageTable.MsgServerType.MSG.m2198a()).append(";").append(ChatUtil.m795a(msg.value)).append(";");
        } else {
            sb.append(MessageDatabaseHelper.m2275a(msg.value).m2197a()).append(";").append(";");
        }
        if (chatType == ChatONContract.InBoxTable.ChatType.GROUPCHAT) {
            sb.append(ChatUtil.m795a(ParticipantDatabaseHelper.m2310b(contentResolver, msg.sender, null)));
        }
        String string = sb.toString();
        ContentValues contentValues = new ContentValues();
        Cursor cursorM2306a = ParticipantDatabaseHelper.m2306a(contentResolver, str);
        if (cursorM2306a != null) {
            contentValues.put("inbox_participants", Integer.valueOf(cursorM2306a.getCount()));
            contentValues.put("inbox_title", ChatUtil.m794a(cursorM2306a));
            cursorM2306a.close();
        }
        contentValues.put("inbox_no", str);
        contentValues.put("inbox_chat_type", Integer.valueOf(chatType.m2189a()));
        contentValues.put("inbox_last_message", string);
        contentValues.put("inbox_last_msg_sender", msg.sender);
        contentValues.put("inbox_last_time", msg.time);
        contentValues.put("inbox_last_msg_no", msg.f1917id);
        contentValues.put("inbox_session_id", msg.sessionid);
        contentValues.put("inbox_server_ip", msg.address);
        contentValues.put("inbox_server_port", msg.port);
        contentValues.put("inbox_last_chat_type", (Integer) 10);
        try {
            return contentResolver.insert(ChatONContract.InBoxTable.f1717a, contentValues);
        } catch (Exception e) {
            ChatONLogWriter.m3501a(e, "InBoxDatabaseHelper");
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0052  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m2246a(android.content.ContentResolver r6, com.sec.chaton.database.ChatONContract.InBoxTable.ChatType r7, java.lang.String r8, java.lang.String r9) {
        /*
            r4 = 1
            r5 = 0
            r2 = 0
            int[] r0 = com.sec.chaton.database.helper.C0214a.f1780b
            int r1 = r7.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L2d;
                case 2: goto L2d;
                case 3: goto L3c;
                default: goto Le;
            }
        Le:
            r0 = r2
        Lf:
            if (r0 == 0) goto L52
            int r1 = r0.getCount()     // Catch: java.lang.Throwable -> L4b
            if (r1 <= 0) goto L52
            boolean r1 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L4b
            if (r1 == 0) goto L52
            java.lang.String r1 = "inbox_no"
            int r1 = r0.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L4b
            java.lang.String r1 = r0.getString(r1)     // Catch: java.lang.Throwable -> L4b
        L27:
            if (r0 == 0) goto L2c
            r0.close()
        L2c:
            return r1
        L2d:
            android.net.Uri r1 = com.sec.chaton.database.ChatONContract.InBoxTable.f1717a
            java.lang.String r3 = "inbox_no=?"
            java.lang.String[] r4 = new java.lang.String[r4]
            r4[r5] = r8
            r0 = r6
            r5 = r2
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5)
            goto Lf
        L3c:
            android.net.Uri r1 = com.sec.chaton.database.ChatONContract.InBoxTable.f1717a
            java.lang.String r3 = "inbox_session_id=?"
            java.lang.String[] r4 = new java.lang.String[r4]
            r4[r5] = r9
            r0 = r6
            r5 = r2
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5)
            goto Lf
        L4b:
            r1 = move-exception
            if (r0 == 0) goto L51
            r0.close()
        L51:
            throw r1
        L52:
            r1 = r2
            goto L27
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.database.helper.InBoxDatabaseHelper.m2246a(android.content.ContentResolver, com.sec.chaton.database.ChatONContract$InBoxTable$ChatType, java.lang.String, java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public static String m2247a(ChatONContract.MessageTable.MsgContentType msgContentType, String str) {
        switch (C0214a.f1779a[msgContentType.ordinal()]) {
            case 1:
                return GlobalApplication.m2388f().getString(C0062R.string.media_photo);
            case 2:
                return GlobalApplication.m2388f().getString(C0062R.string.media_video);
            case 3:
                return GlobalApplication.m2388f().getString(C0062R.string.media_voice);
            case 4:
                return GlobalApplication.m2388f().getString(C0062R.string.media_map);
            case 5:
                return GlobalApplication.m2388f().getString(C0062R.string.media_contact);
            case 6:
                return GlobalApplication.m2388f().getString(C0062R.string.media_calendar);
            default:
                return "";
        }
    }

    /* renamed from: a */
    public static ArrayList m2248a(ContentResolver contentResolver) {
        Cursor cursorQuery = contentResolver.query(ChatONContract.InBoxTable.f1717a, new String[]{"inbox_session_id"}, "inbox_session_id!=''", null, null);
        ArrayList arrayList = new ArrayList();
        while (cursorQuery != null && cursorQuery.moveToNext()) {
            arrayList.add(cursorQuery.getString(cursorQuery.getColumnIndex("inbox_session_id")));
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return arrayList;
    }

    /* renamed from: a */
    public static void m2249a(ContentResolver contentResolver, ChatONContract.InBoxTable.ChatType chatType, PushEntry pushEntry, String str) {
        InBoxData inBoxDataM2262d = m2262d(contentResolver, str);
        if (inBoxDataM2262d != null && pushEntry.sentTime.longValue() >= inBoxDataM2262d.f1761f) {
            StringBuilder sb = new StringBuilder();
            sb.append(2).append(";");
            if (pushEntry.msgType.intValue() == 0) {
                sb.append(ChatONContract.MessageTable.MsgServerType.MSG.m2198a()).append(";").append(ChatUtil.m795a(pushEntry.message)).append(";");
            } else {
                sb.append(MessageDatabaseHelper.m2276a(pushEntry.message, ChatONContract.MessageTable.MsgContentType.m2195a(pushEntry.msgType.intValue())).m2197a()).append(";").append(";");
            }
            if (chatType == ChatONContract.InBoxTable.ChatType.GROUPCHAT) {
                sb.append(ChatUtil.m795a(ParticipantDatabaseHelper.m2317e(contentResolver, str, pushEntry.senderID)));
            }
            inBoxDataM2262d.f1759d = sb.toString();
            if (!TextUtils.isEmpty(pushEntry.sessionID) && !pushEntry.sessionID.equalsIgnoreCase("null")) {
                inBoxDataM2262d.f1763h = pushEntry.sessionID;
                inBoxDataM2262d.f1769n = pushEntry.f1916IP;
                inBoxDataM2262d.f1770o = pushEntry.PORT.intValue();
            }
            if (GlobalApplication.f1896c == null || !GlobalApplication.f1896c.equals(str)) {
                inBoxDataM2262d.f1758c++;
            }
            inBoxDataM2262d.f1761f = pushEntry.sentTime.longValue();
            inBoxDataM2262d.f1764i = pushEntry.msgID.longValue();
            inBoxDataM2262d.f1765j = pushEntry.senderID;
            inBoxDataM2262d.f1762g = pushEntry.receiverCount.intValue();
            m2241a(contentResolver, str, inBoxDataM2262d);
        }
    }

    /* renamed from: a */
    public static void m2250a(ContentResolver contentResolver, String str, TcpContext tcpContext) {
        Cursor cursorQuery = contentResolver.query(ChatONContract.InBoxTable.f1717a, new String[]{"inbox_server_ip", "inbox_server_port"}, "inbox_no=?", new String[]{str}, null);
        if (cursorQuery == null || cursorQuery.getCount() <= 0) {
            return;
        }
        cursorQuery.moveToFirst();
        tcpContext.m2785a(cursorQuery.getString(0), cursorQuery.getInt(1));
        cursorQuery.close();
    }

    /* renamed from: a */
    public static void m2251a(ContentResolver contentResolver, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_last_message", str2);
        contentResolver.update(ChatONContract.InBoxTable.f1717a, contentValues, "inbox_no=?", new String[]{str});
    }

    /* renamed from: a */
    public static void m2252a(ContentResolver contentResolver, String str, String str2, String str3, long j, String str4, String str5, Integer num, Long l, int i, ChatONContract.MessageTable.MsgContentType msgContentType) {
        String str6 = String.format("%d;%d;%s;%s", 1, Integer.valueOf(msgContentType.m2197a()), ChatUtil.m795a(str3), "");
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_last_msg_sender", str);
        contentValues.put("inbox_last_message", str6);
        contentValues.put("inbox_last_time", Long.valueOf(j));
        contentValues.put("inbox_session_id", str4);
        contentValues.put("inbox_last_msg_no", l);
        contentValues.put("inbox_participants", Integer.valueOf(i));
        if (str5 != null) {
            contentValues.put("inbox_server_ip", str5);
        }
        if (num != null) {
            contentValues.put("inbox_server_port", num);
        }
        contentResolver.update(ChatONContract.InBoxTable.f1717a, contentValues, "inbox_no=?", new String[]{str2});
    }

    /* renamed from: a */
    public static void m2253a(Context context) throws RemoteException, OperationApplicationException {
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursorQuery = contentResolver.query(ChatONContract.InBoxTable.m2186b(), null, null, null, null);
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        while (cursorQuery.moveToNext()) {
            arrayList.add(ContentProviderOperation.newUpdate(ChatONContract.InBoxTable.f1717a).withSelection("inbox_no=?", new String[]{cursorQuery.getString(cursorQuery.getColumnIndex("inbox_no"))}).withValue("inbox_title", cursorQuery.getString(cursorQuery.getColumnIndex("inbox_title")).replace("\n", " ")).build());
        }
        cursorQuery.close();
        try {
            contentResolver.applyBatch("com.sec.chaton.provider", arrayList);
        } catch (Exception e) {
            ChatONLogWriter.m3501a(e, "");
        }
    }

    /* renamed from: a */
    public static void m2254a(NotifyingAsyncQueryHandler notifyingAsyncQueryHandler, int i, String str, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_participants", Integer.valueOf(i2));
        notifyingAsyncQueryHandler.startUpdate(i, null, ChatONContract.InBoxTable.f1717a, contentValues, "inbox_no=?", new String[]{str});
    }

    /* renamed from: a */
    public static void m2255a(NotifyingAsyncQueryHandler notifyingAsyncQueryHandler, int i, String str, String str2, int i2, ChatONContract.MessageTable.MsgContentType msgContentType) {
        String str3 = String.format("%d;%d;%s;%s", 1, Integer.valueOf(msgContentType.m2197a()), ChatUtil.m795a(str2), "");
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_last_msg_sender", ChatONPref.m3519a().getString("msisdn", ""));
        contentValues.put("inbox_last_message", str3);
        contentValues.put("inbox_last_time", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("inbox_participants", Integer.valueOf(i2));
        notifyingAsyncQueryHandler.startUpdate(i, null, ChatONContract.InBoxTable.f1717a, contentValues, "inbox_no=?", new String[]{str});
    }

    /* renamed from: b */
    public static int m2256b(ContentResolver contentResolver, String str, int i) {
        int i2;
        ContentValues contentValues = new ContentValues();
        String[] strArr = {str};
        Cursor cursorQuery = contentResolver.query(ChatONContract.InBoxTable.f1717a, null, "inbox_session_id=?", strArr, null);
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
        contentValues.put("inbox_unread_count", Integer.valueOf(i3));
        contentResolver.update(ChatONContract.InBoxTable.f1717a, contentValues, "inbox_session_id=?", strArr);
        return i3;
    }

    /* renamed from: b */
    public static int m2257b(ContentResolver contentResolver, String str, InBoxData inBoxData) {
        ContentValues contentValues = new ContentValues();
        Cursor cursorM2306a = ParticipantDatabaseHelper.m2306a(contentResolver, str);
        if (cursorM2306a != null) {
            inBoxData.f1762g = cursorM2306a.getCount();
            cursorM2306a.close();
        }
        contentValues.put("inbox_participants", Integer.valueOf(inBoxData.f1762g));
        contentValues.put("inbox_last_message", inBoxData.f1759d);
        if (inBoxData.f1769n != null) {
            contentValues.put("inbox_server_ip", inBoxData.f1769n);
            contentValues.put("inbox_server_port", Integer.valueOf(inBoxData.f1770o));
        }
        contentValues.put("inbox_last_msg_sender", inBoxData.f1765j);
        contentValues.put("inbox_last_msg_no", Long.valueOf(inBoxData.f1764i));
        contentValues.put("inbox_session_id", inBoxData.f1763h);
        contentValues.put("inbox_last_time", Long.valueOf(inBoxData.f1761f));
        contentValues.put("inbox_unread_count", Integer.valueOf(inBoxData.f1758c));
        return contentResolver.update(ChatONContract.InBoxTable.f1717a, contentValues, "inbox_no=?", new String[]{str});
    }

    /* renamed from: b */
    public static void m2258b(ContentResolver contentResolver, String str) {
        InBoxData inBoxDataM2262d = m2262d(contentResolver, str);
        if (inBoxDataM2262d != null) {
            m2241a(contentResolver, str, inBoxDataM2262d);
        }
    }

    /* renamed from: b */
    public static void m2259b(ContentResolver contentResolver, String str, ChatONContract.InBoxTable.ChatType chatType, Msg msg, ChatONContract.MessageTable.MsgServerType msgServerType) {
        InBoxData inBoxDataM2262d = m2262d(contentResolver, str);
        if (inBoxDataM2262d == null) {
            throw new NullPointerException("InBoxData is null");
        }
        if (msgServerType == ChatONContract.MessageTable.MsgServerType.MSG) {
            inBoxDataM2262d.f1759d = msg.value;
        } else {
            ChatONContract.MessageTable.MsgContentType msgContentTypeM2276a = MessageDatabaseHelper.m2276a(msg.value, ChatONContract.MessageTable.MsgContentType.m2195a(msgServerType.m2198a()));
            inBoxDataM2262d.f1759d = m2247a(msgContentTypeM2276a, msgContentTypeM2276a == ChatONContract.MessageTable.MsgContentType.GEO ? msg.value : msg.value.split("\n")[3]);
        }
        if (chatType == ChatONContract.InBoxTable.ChatType.GROUPCHAT) {
            inBoxDataM2262d.f1759d = ParticipantDatabaseHelper.m2317e(contentResolver, str, msg.sender) + ":" + inBoxDataM2262d.f1759d;
        }
        inBoxDataM2262d.f1761f = msg.time.longValue();
        inBoxDataM2262d.f1769n = msg.address;
        inBoxDataM2262d.f1770o = msg.port.intValue();
        inBoxDataM2262d.f1763h = msg.sessionid;
        inBoxDataM2262d.f1764i = Long.valueOf(msg.f1917id).longValue();
        inBoxDataM2262d.f1757b = chatType.m2189a();
        inBoxDataM2262d.f1765j = msg.sender;
        m2241a(contentResolver, str, inBoxDataM2262d);
    }

    /* renamed from: c */
    public static void m2260c(ContentResolver contentResolver, String str) {
        InBoxData inBoxDataM2262d = m2262d(contentResolver, str);
        if (inBoxDataM2262d != null) {
            m2257b(contentResolver, str, inBoxDataM2262d);
        }
    }

    /* renamed from: c */
    public static void m2261c(ContentResolver contentResolver, String str, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_last_chat_type", Integer.valueOf(i));
        contentResolver.update(ChatONContract.InBoxTable.f1717a, contentValues, "inbox_no=?", new String[]{str});
    }

    /* renamed from: d */
    public static InBoxData m2262d(ContentResolver contentResolver, String str) {
        Cursor cursorQuery = contentResolver.query(ChatONContract.InBoxTable.f1717a, null, "inbox_no=?", new String[]{str}, null);
        if (cursorQuery == null || cursorQuery.getCount() == 0) {
            return null;
        }
        InBoxData inBoxData = new InBoxData();
        cursorQuery.moveToFirst();
        inBoxData.f1756a = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_no"));
        inBoxData.f1757b = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_chat_type"));
        inBoxData.f1760e = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_title"));
        inBoxData.f1766k = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_title_fixed"));
        inBoxData.f1759d = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_last_message"));
        inBoxData.f1767l = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_last_chat_type"));
        inBoxData.f1764i = cursorQuery.getLong(cursorQuery.getColumnIndex("inbox_last_msg_no"));
        inBoxData.f1765j = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_last_msg_sender"));
        inBoxData.f1761f = cursorQuery.getLong(cursorQuery.getColumnIndex("inbox_last_time"));
        inBoxData.f1768m = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_last_temp_msg"));
        inBoxData.f1762g = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_participants"));
        inBoxData.f1763h = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_session_id"));
        inBoxData.f1758c = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_unread_count"));
        inBoxData.f1769n = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_server_ip"));
        inBoxData.f1770o = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_server_port"));
        cursorQuery.close();
        return inBoxData;
    }

    /* renamed from: e */
    public static int m2263e(ContentResolver contentResolver, String str) {
        InBoxData inBoxDataM2262d = m2262d(contentResolver, str);
        if (inBoxDataM2262d == null) {
            GlobalApplication.m2389g().m3601a(GlobalApplication.m2389g().m3602b().m3603a(), GlobalApplication.m2389g().m3602b().m3606b());
            return -1;
        }
        GlobalApplication.m2389g().m3601a(inBoxDataM2262d.f1769n, inBoxDataM2262d.f1770o);
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_server_ip", GlobalApplication.m2389g().m3602b().m3603a());
        contentValues.put("inbox_server_port", Integer.valueOf(GlobalApplication.m2389g().m3602b().m3606b()));
        return contentResolver.update(ChatONContract.InBoxTable.f1717a, contentValues, "inbox_no=?", new String[]{str});
    }

    /* renamed from: f */
    public static boolean m2264f(ContentResolver contentResolver, String str) {
        Cursor cursorQuery = contentResolver.query(ChatONContract.InBoxTable.f1717a, null, "inbox_no=?", new String[]{str}, null);
        int i = 10;
        if (cursorQuery == null || cursorQuery.getCount() <= 0) {
            ChatONLogWriter.m3499a("isInboxParticipantInserted() - can't find inbox", "[InboxDatabaseHelper]");
        } else {
            cursorQuery.moveToFirst();
            i = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_last_chat_type"));
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return i == 11;
    }

    /* renamed from: g */
    private static String m2265g(ContentResolver contentResolver, String str) {
        Cursor cursorM2306a = ParticipantDatabaseHelper.m2306a(contentResolver, str);
        String strM794a = ChatUtil.m794a(cursorM2306a);
        cursorM2306a.close();
        return strM794a;
    }
}
