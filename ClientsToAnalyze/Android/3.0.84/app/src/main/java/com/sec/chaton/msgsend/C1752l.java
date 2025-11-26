package com.sec.chaton.msgsend;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0272i;
import com.sec.chaton.p025d.C1323bi;
import com.sec.chaton.p027e.C1454v;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p027e.p028a.C1381y;
import com.sec.chaton.p037j.C1579g;
import com.sec.chaton.p037j.C1589q;
import com.sec.chaton.p037j.EnumC1591s;
import com.sec.chaton.p037j.p040c.C1561g;
import com.sec.chaton.p037j.p040c.C1565k;
import com.sec.chaton.p037j.p040c.RunnableC1563i;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: MessageProcessor.java */
/* renamed from: com.sec.chaton.msgsend.l */
/* loaded from: classes.dex */
public class C1752l {

    /* renamed from: a */
    public static final String f6458a = C1752l.class.getSimpleName();

    /* renamed from: c */
    private static C1752l f6459c;

    /* renamed from: b */
    final Map<String, C1743c> f6460b = new HashMap();

    private C1752l() {
        if (m7221e()) {
            C1766z.m7268a(GlobalApplication.m11493l(), EnumC1764x.REASON_LOADED_MSG_FROM_DB);
        }
    }

    /* renamed from: a */
    public static synchronized String m7200a() {
        String str;
        int i;
        int i2 = 0;
        synchronized (C1752l.class) {
            if (f6459c == null) {
                str = "(not instantiated yet)";
            } else {
                Iterator<Map.Entry<String, C1743c>> it = f6459c.f6460b.entrySet().iterator();
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                while (it.hasNext()) {
                    C1743c value = it.next().getValue();
                    int iM7188f = value.m7188f();
                    int iM7189g = value.m7189g();
                    if (iM7188f > 0) {
                        i5++;
                        i3 += iM7188f;
                    }
                    if (iM7189g > 0) {
                        i4++;
                        i = i2 + iM7189g;
                    } else {
                        i = i2;
                    }
                    i4 = i4;
                    i2 = i;
                }
                str = String.format("inbox(%d,%d), msg(%d,%d)", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i3));
            }
        }
        return str;
    }

    /* renamed from: b */
    public static synchronized C1752l m7203b() {
        if (f6459c == null) {
            f6459c = new C1752l();
        }
        return f6459c;
    }

    /* renamed from: c */
    public synchronized void m7219c() {
        C1759s.m7260a(f6458a, "__print_all_data()", new Object[0]);
        if (C3250y.f11734b) {
            C1749i c1749iM7196b = C1749i.m7195a().m7196b();
            Set<Map.Entry<String, C1743c>> setEntrySet = this.f6460b.entrySet();
            C1759s.m7260a(f6458a, "----------- print all room info (%d chatrooms)----------", Integer.valueOf(setEntrySet.size()));
            for (Map.Entry<String, C1743c> entry : setEntrySet) {
                C1759s.m7260a(f6458a, "  [CHATROOM]  key(%s) : %s", entry.getKey(), entry.getValue());
            }
            Set<Map.Entry<String, C1743c>> setEntrySet2 = this.f6460b.entrySet();
            C1759s.m7260a(f6458a, "----------- print all message (%d chatrooms)----------", Integer.valueOf(setEntrySet2.size()));
            for (Map.Entry<String, C1743c> entry2 : setEntrySet2) {
                String key = entry2.getKey();
                C1743c value = entry2.getValue();
                C1759s.m7260a(f6458a, "  [CHATROOM]  key(%s) : %s", key, value);
                value.m7192j();
            }
            c1749iM7196b.m7197c();
            C1759s.m7260a(f6458a, "%s", c1749iM7196b);
        }
    }

    /* renamed from: a */
    public synchronized C1743c m7209a(String str, EnumC1450r enumC1450r, String[] strArr, String str2, String str3, int i, boolean z, long j, ChatONMsgEntity chatONMsgEntity) {
        return m7199a(str, enumC1450r, strArr, str2, str3, i, Boolean.valueOf(z), j, chatONMsgEntity);
    }

    /* renamed from: a */
    public synchronized C1743c m7208a(String str, EnumC1450r enumC1450r, String[] strArr, String str2, ChatONMsgEntity chatONMsgEntity) {
        return m7199a(str, enumC1450r, strArr, str2, (String) null, Integer.MIN_VALUE, (Boolean) null, 0L, chatONMsgEntity);
    }

    /* renamed from: d */
    public synchronized void m7220d() {
        C1759s.m7260a(f6458a, "deleteAll()", new Object[0]);
        C1749i c1749iM7196b = C1749i.m7195a().m7196b();
        Iterator<Map.Entry<String, C1743c>> it = this.f6460b.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().m7183b();
        }
        this.f6460b.clear();
        c1749iM7196b.m7197c();
        C1759s.m7260a(f6458a, "elapsed in 'DELETE ALL INBOX & MSG (%s) ", c1749iM7196b);
    }

    /* renamed from: a */
    public synchronized boolean m7213a(String str) {
        boolean z;
        C1759s.m7260a(f6458a, "deleteInbox(), inboxNo(%s)", str);
        C1743c c1743c = this.f6460b.get(str);
        if (c1743c == null) {
            C1759s.m7260a(f6458a, "not exist inbox : %s ", str);
            z = false;
        } else {
            c1743c.m7183b();
            this.f6460b.remove(str);
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    synchronized int m7207a(String str, ArrayList<Long> arrayList, ArrayList<Integer> arrayList2) {
        int iM7170a;
        C1759s.m7260a(f6458a, "deleteAllMsgWithExceptionMsgList(), inboxNo(%s)", str);
        C1743c c1743c = this.f6460b.get(str);
        if (c1743c == null) {
            C1759s.m7260a(f6458a, "not exist inbox : %s ", str);
            iM7170a = -1;
        } else {
            iM7170a = c1743c.m7170a(arrayList, arrayList2);
        }
        return iM7170a;
    }

    /* renamed from: a */
    public synchronized int m7206a(String str, ArrayList<Integer> arrayList) {
        int iM7169a;
        C1759s.m7260a(f6458a, "deleteAllMsgWithExceptionStatus(), inboxNo(%s)", str);
        C1743c c1743c = this.f6460b.get(str);
        if (c1743c == null) {
            C1759s.m7260a(f6458a, "not exist inbox : %s ", str);
            iM7169a = -1;
        } else {
            iM7169a = c1743c.m7169a(arrayList);
        }
        return iM7169a;
    }

    /* renamed from: b */
    public synchronized int m7217b(String str, ArrayList<Integer> arrayList) {
        int iM7180b;
        C1759s.m7260a(f6458a, "deleteAllMsgWithStatus(), inboxNo(%s)", str);
        C1743c c1743c = this.f6460b.get(str);
        if (c1743c == null) {
            C1759s.m7260a(f6458a, "not exist inbox : %s ", str);
            iM7180b = -1;
        } else {
            iM7180b = c1743c.m7180b(arrayList);
        }
        return iM7180b;
    }

    /* renamed from: b */
    public synchronized int m7218b(String str, ArrayList<Long> arrayList, ArrayList<Integer> arrayList2) {
        int iM7181b;
        C1759s.m7260a(f6458a, "deleteMsgWithTargetList(), inboxNo(%s)", str);
        C1743c c1743c = this.f6460b.get(str);
        if (c1743c == null) {
            C1759s.m7260a(f6458a, "not exist inbox : %s ", str);
            iM7181b = -1;
        } else {
            iM7181b = c1743c.m7181b(arrayList, arrayList2);
        }
        return iM7181b;
    }

    /* renamed from: a */
    public synchronized boolean m7214a(String str, long j) {
        boolean z = false;
        synchronized (this) {
            C1759s.m7260a(f6458a, "deleteMsg(), inboxNo(%s), msgId(%d)", str, Long.valueOf(j));
            C1743c c1743c = this.f6460b.get(str);
            if (c1743c == null) {
                C1759s.m7260a(f6458a, "not exist inbox : %s ", str);
            } else {
                z = c1743c.m7182b(j) != null;
            }
        }
        return z;
    }

    /* renamed from: e */
    public synchronized boolean m7221e() {
        boolean z;
        C1759s.m7260a(f6458a, "loadMessageFromDB()", new Object[0]);
        C1749i c1749iM7196b = C1749i.m7195a().m7196b();
        Cursor cursorM7205f = m7205f();
        if (cursorM7205f == null) {
            C1759s.m7260a(f6458a, "query result is (null)", new Object[0]);
            z = false;
        } else {
            C1759s.m7260a(f6458a, "query result COUNT is (%d)", Integer.valueOf(cursorM7205f.getCount()));
            if (this.f6460b.size() > 0) {
                C1759s.m7260a(f6458a, "Some MSGs are already exist in MessageList", new Object[0]);
            }
            cursorM7205f.moveToPosition(-1);
            while (cursorM7205f.moveToNext()) {
                String string = cursorM7205f.getString(cursorM7205f.getColumnIndex("message_inbox_no"));
                String string2 = cursorM7205f.getString(cursorM7205f.getColumnIndex("inbox_session_id"));
                EnumC1450r enumC1450rM6339a = EnumC1450r.m6339a(cursorM7205f.getInt(cursorM7205f.getColumnIndex("inbox_chat_type")));
                long j = cursorM7205f.getLong(cursorM7205f.getColumnIndex("_id"));
                EnumC1455w enumC1455wM6358a = EnumC1455w.m6358a(cursorM7205f.getInt(cursorM7205f.getColumnIndex("message_content_type")));
                String string3 = cursorM7205f.getString(cursorM7205f.getColumnIndex("message_content"));
                String string4 = cursorM7205f.getString(cursorM7205f.getColumnIndex("message_content_translated"));
                int i = cursorM7205f.getInt(cursorM7205f.getColumnIndex("message_type"));
                String string5 = cursorM7205f.getString(cursorM7205f.getColumnIndex("message_download_uri"));
                String string6 = cursorM7205f.getString(cursorM7205f.getColumnIndex("message_formatted"));
                int i2 = cursorM7205f.getInt(cursorM7205f.getColumnIndex("message_is_file_upload"));
                String string7 = cursorM7205f.getString(cursorM7205f.getColumnIndex("inbox_server_ip"));
                int i3 = cursorM7205f.getInt(cursorM7205f.getColumnIndex("inbox_server_port"));
                boolean zEquals = "Y".equals(cursorM7205f.getString(cursorM7205f.getColumnIndex("inbox_valid")));
                long j2 = cursorM7205f.getLong(cursorM7205f.getColumnIndex("lasst_session_merge_time"));
                if (zEquals) {
                    m7209a(string, enumC1450rM6339a, (String[]) null, string2, string7, i3, zEquals, j2, new ChatONMsgEntity(j, enumC1455wM6358a, string3, string4, string5, string6, i2, i));
                }
            }
            cursorM7205f.close();
            c1749iM7196b.m7197c();
            C1759s.m7260a(f6458a, "LoadMessageFromDB - end (%s) ", c1749iM7196b);
            m7219c();
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    public synchronized void m7210a(EnumC1764x enumC1764x) {
        C1759s.m7260a(f6458a, "sendAllChatONMsg(), reason(%s)", enumC1764x);
        C1759s.m7260a(f6458a, " -------------- (ACTION !!) SEND ALL CHATON MSG in actually here. (%s) -------------- ", enumC1764x);
        if (C1757q.m7257g()) {
            C1760t.m7262a("Try to send all", m7200a());
        }
        C1749i c1749iM7196b = C1749i.m7195a().m7196b();
        HashMap map = new HashMap();
        for (Map.Entry<String, C1743c> entry : this.f6460b.entrySet()) {
            String key = entry.getKey();
            C1763w c1763wM7191i = entry.getValue().m7191i();
            C1759s.m7260a(f6458a, "inbox(%s) sending messages result : (%s)", key, c1763wM7191i);
            switch (C1753m.f6461a[c1763wM7191i.f6496c.ordinal()]) {
                case 1:
                    map.put(key, c1763wM7191i);
                    break;
            }
        }
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            String str = (String) ((Map.Entry) it.next()).getKey();
            C1743c c1743c = this.f6460b.get(str);
            if (c1743c != null) {
                C1759s.m7260a(f6458a, "sendAllChatONMsg() - REMOVE Useless Room", c1743c);
                c1743c.m7183b();
                this.f6460b.remove(str);
            }
        }
        c1749iM7196b.m7197c();
        C1759s.m7260a(f6458a, "elapsed in sending all messages : (%s) ", c1749iM7196b);
    }

    /* renamed from: a */
    public synchronized boolean m7212a(int i, String str, C1323bi c1323bi, boolean z) {
        boolean z2;
        C0272i c0272i = (C0272i) c1323bi.m5689a();
        if (c0272i == null) {
            C1759s.m7260a(f6458a, "ERROR in setServerResult_direct(), oResultEntry is NULL ------------------------ ", new Object[0]);
            C1759s.m7260a(f6458a, "ERROR in setServerResult_direct(), oResultEntry is NULL ------------------------ ", new Object[0]);
            C1759s.m7260a(f6458a, "ERROR in setServerResult_direct(), oResultEntry is NULL ------------------------ ", new Object[0]);
            z2 = false;
        } else {
            int iM1365f = c0272i.m1365f();
            boolean z3 = c0272i.f858a;
            long jM1366g = c0272i.m1366g();
            C1759s.m7260a(f6458a, "setServerResult_direct(),  -- Result -- GpbType(%s, %d), inboxNo(%s), msgId(%d), resultCode(%d), result(%s)", C1579g.m6697c(i), Integer.valueOf(i), str, Long.valueOf(jM1366g), Integer.valueOf(iM1365f), Boolean.valueOf(z3));
            if (z) {
                switch (i) {
                    case 0:
                    case 106:
                        if (C1589q.m6726a(iM1365f)) {
                            m7204b(str, EnumC1591s.RETRY_WITH_TIMEOUT, jM1366g);
                            break;
                        } else if (c0272i.f858a) {
                            m7204b(str, EnumC1591s.SUCCESS_NORMALLY, jM1366g);
                            break;
                        } else {
                            m7204b(str, EnumC1591s.FAILED, jM1366g);
                            break;
                        }
                    case 2:
                        if (iM1365f == 2006 || iM1365f == 3008) {
                            m7201a(str, EnumC1591s.RETRY_WITH_CHANGING_SERVER);
                            break;
                        } else if (C1589q.m6726a(iM1365f) || iM1365f == 7002 || iM1365f == 7003) {
                            m7201a(str, EnumC1591s.RETRY_WITH_TIMEOUT);
                            break;
                        } else if (c0272i.f858a) {
                            m7201a(str, EnumC1591s.SUCCESS_NORMALLY);
                            break;
                        } else {
                            m7201a(str, EnumC1591s.FAILED);
                            break;
                        }
                        break;
                    case 4:
                    case 102:
                        if (C1589q.m6726a(iM1365f) || iM1365f == 26 || iM1365f == 7002 || iM1365f == 7003) {
                            m7202a(str, EnumC1591s.RETRY_WITH_TIMEOUT, jM1366g);
                            break;
                        } else if (iM1365f == 2006 || iM1365f == 3008) {
                            m7202a(str, EnumC1591s.RETRY_WITH_CHANGING_SERVER, jM1366g);
                            break;
                        } else if (iM1365f != 900) {
                            if (c0272i.f858a) {
                                m7202a(str, EnumC1591s.SUCCESS_NORMALLY, jM1366g);
                                break;
                            } else {
                                m7202a(str, EnumC1591s.FAILED, jM1366g);
                                break;
                            }
                        }
                        break;
                    case 8:
                        if (!C1589q.m6726a(iM1365f) && iM1365f != 7002 && iM1365f != 7003) {
                            if (iM1365f == 3003 || iM1365f == 10000) {
                                m7201a(str, EnumC1591s.SUCCESS_NORMALLY);
                                break;
                            } else if (c0272i.f858a) {
                                m7213a(str);
                                break;
                            }
                        }
                        break;
                }
            } else {
                switch (i) {
                    case 2:
                        if (c0272i.m1365f() == 3003) {
                            m7201a(str, EnumC1591s.SUCCESS_NORMALLY);
                            break;
                        }
                        break;
                    case 6:
                    case 103:
                    case 104:
                    case 107:
                        break;
                }
            }
            z2 = true;
        }
        return z2;
    }

    /* renamed from: a */
    public synchronized boolean m7216a(String str, long j, String str2) {
        C1743c c1743c;
        C1759s.m7260a(f6458a, "updateMsgMessage(), inboxNo(%s), msgId(%d), chatMsg(%s)", str, Long.valueOf(j), str2);
        c1743c = this.f6460b.get(str);
        return c1743c == null ? false : c1743c.m7176a(j, str2);
    }

    /* renamed from: a */
    public synchronized boolean m7215a(String str, long j, EnumC1741aa enumC1741aa, String str2, Integer num) {
        C1743c c1743c;
        C1759s.m7260a(f6458a, "updateMsg(), inboxNo(%s), msgId(%d), sendStatus(%s), formattedMsg(%s), isFileUploaded(%s)", str, Long.valueOf(j), enumC1741aa, str2, num);
        c1743c = null;
        if (this.f6460b != null) {
            c1743c = this.f6460b.get(str);
        }
        return c1743c == null ? false : c1743c.m7175a(j, enumC1741aa, str2, num);
    }

    /* renamed from: a */
    private synchronized C1743c m7199a(String str, EnumC1450r enumC1450r, String[] strArr, String str2, String str3, int i, Boolean bool, long j, ChatONMsgEntity chatONMsgEntity) {
        C1743c c1743c;
        C1759s.m7260a(f6458a, "addMsg(), inboxNo(%s), chatType(%s), sesseionId(%s), serverIP(%s), serverPort(%d), isInboxValid(%s), lastSessionMergeTime(%d), msgEntity(%s)", str, enumC1450r, str2, str3, Integer.valueOf(i), bool, Long.valueOf(j), chatONMsgEntity);
        c1743c = this.f6460b.get(str);
        if (c1743c == null) {
            C1759s.m7260a(f6458a, "New manged inbox is created!! addMsg(), inboxNo(%s), chatType(%s), sesseionId(%s), serverIP(%s), serverPort(%d), isInboxValid(%s), lastSessionMergeTime(%d)", str, enumC1450r, str2, str3, Integer.valueOf(i), bool, Long.valueOf(j));
            if (strArr == null && (strArr = C1381y.m6217c(GlobalApplication.m11493l().getContentResolver(), str)) == null) {
                C1759s.m7260a(f6458a, "[ERROR] no participant, so make it FAILED !!!!!!!!! inboxNo(%s), chatType(%s), Msg(%s)", str, enumC1450r, chatONMsgEntity);
                chatONMsgEntity.m7135a(EnumC1741aa.FAILED);
            }
            c1743c = new C1743c(str, enumC1450r, strArr);
            if (!c1743c.m7179a(str2, str3, i, j)) {
                Boolean.valueOf(false);
            }
            this.f6460b.put(str, c1743c);
        } else {
            C1759s.m7260a(f6458a, "addMsg in exist inbox (%s)", str);
            if (strArr != null) {
                c1743c.m7174a(strArr);
            }
        }
        if (!c1743c.m7178a(chatONMsgEntity)) {
            c1743c = null;
        }
        return c1743c;
    }

    /* renamed from: f */
    private synchronized Cursor m7205f() {
        Cursor cursorQuery;
        C1759s.m7260a(f6458a, "queryAllPendings()", new Object[0]);
        C1749i c1749iM7196b = C1749i.m7195a().m7196b();
        String strM10979a = C3159aa.m10962a().m10979a("chaton_id", "");
        C1759s.m7260a(f6458a, "My ChatonID is (%s)", strM10979a);
        if (TextUtils.isEmpty(strM10979a)) {
            cursorQuery = null;
        } else {
            cursorQuery = GlobalApplication.m11493l().getContentResolver().query(C1454v.m6357f(), null, null, new String[]{strM10979a}, null);
            c1749iM7196b.m7197c();
            C1759s.m7260a(f6458a, "elapsed (%s)", c1749iM7196b);
            if (cursorQuery == null) {
                cursorQuery = null;
            }
        }
        return cursorQuery;
    }

    /* renamed from: a */
    private synchronized void m7201a(String str, EnumC1591s enumC1591s) {
        C1759s.m7260a(f6458a, "updateAllowChat(), inboxNo(%s), msgResult(%s)", str, enumC1591s);
        if (str == null) {
            C1759s.m7260a(f6458a, "request inbox is NULL", new Object[0]);
        } else {
            C1759s.m7260a(f6458a, "updateAllowChat(), -- do nothing anymore...", new Object[0]);
        }
    }

    /* renamed from: a */
    private synchronized void m7202a(String str, EnumC1591s enumC1591s, long j) {
        boolean z;
        boolean z2;
        boolean z3;
        C1759s.m7260a(f6458a, "updateChatRequest(), inboxNo(%s), msgResult(%s), msgId(%d)", str, enumC1591s, Long.valueOf(j));
        if (str == null) {
            C1759s.m7260a(f6458a, "request inbox is NULL", new Object[0]);
        } else {
            if (this.f6460b != null) {
                C1743c c1743c = this.f6460b.get(str);
                if (c1743c == null) {
                    C1759s.m7260a(f6458a, "not exist inbox : %s ", str);
                } else {
                    long jM7186d = c1743c.m7186d();
                    if (jM7186d == j) {
                        C1759s.m7260a(f6458a, "IS THE SAME ALLOW CHAT MSG ID (true) : %d / %d", Long.valueOf(jM7186d), Long.valueOf(j));
                        c1743c.m7173a(false, -1L);
                        z3 = true;
                    } else {
                        C1759s.m7260a(f6458a, "IS THE SAME ALLOW CHAT MSG ID (false) : %d / %d", Long.valueOf(jM7186d), Long.valueOf(j));
                        z3 = false;
                    }
                    if (c1743c.m7171a() != EnumC1450r.BROADCAST) {
                        long jM7185c = c1743c.m7185c();
                        if (jM7185c == j) {
                            C1759s.m7260a(f6458a, "IS THE SAME INIT CHAT MSG ID (true) : %d / %d", Long.valueOf(jM7185c), Long.valueOf(j));
                            c1743c.m7184b(false, -1L);
                        } else {
                            C1759s.m7260a(f6458a, "IS THE SAME INIT CHAT MSG ID (false) : %d / %d", Long.valueOf(jM7185c), Long.valueOf(j));
                        }
                    }
                    if (c1743c.m7171a() != EnumC1450r.BROADCAST) {
                        long jM7190h = c1743c.m7190h();
                        if (jM7190h == j) {
                            C1759s.m7260a(f6458a, "IS THE SAME SerialChat last member MSG ID (true) : %d / %d", Long.valueOf(jM7190h), Long.valueOf(j));
                            c1743c.m7172a(-1L);
                            z = true;
                            z2 = z3;
                        } else {
                            C1759s.m7260a(f6458a, "IS THE SAME SerialChat last member MSG ID (false) : %d / %d", Long.valueOf(jM7190h), Long.valueOf(j));
                            z = false;
                            z2 = z3;
                        }
                    } else {
                        z = false;
                        z2 = z3;
                    }
                }
            } else {
                z = false;
                z2 = false;
            }
            Context contextL = GlobalApplication.m11493l();
            switch (C1753m.f6462b[enumC1591s.ordinal()]) {
                case 1:
                    m7215a(str, j, EnumC1741aa.FAILED, (String) null, (Integer) null);
                    if (z2) {
                        C1766z.m7268a(contextL, EnumC1764x.REASON_LATEST_ALLOW_CHAT_FAIL);
                        break;
                    } else {
                        C1766z.m7268a(contextL, EnumC1764x.REASON_LATEST_SENT_MSG_FAIL);
                        break;
                    }
                case 2:
                case 3:
                    m7215a(str, j, EnumC1741aa.PENDING, (String) null, (Integer) null);
                    if (z2) {
                        C1766z.m7268a(contextL, EnumC1764x.REASON_LATEST_ALLOW_CHAT_FAIL);
                        break;
                    } else {
                        C1766z.m7268a(contextL, EnumC1764x.REASON_LATEST_SENT_MSG_FAIL);
                        break;
                    }
                case 4:
                case 5:
                    m7215a(str, j, EnumC1741aa.SENDED, (String) null, (Integer) null);
                    if (z2) {
                        C1766z.m7268a(contextL, EnumC1764x.REASON_LATEST_ALLOW_CHAT_SUCCESS);
                        break;
                    } else if (z) {
                        C1766z.m7268a(contextL, EnumC1764x.REASON_LATEST_SENT_MSG_SUCCESS);
                        break;
                    }
                    break;
            }
        }
    }

    /* renamed from: b */
    private synchronized void m7204b(String str, EnumC1591s enumC1591s, long j) {
        C1759s.m7260a(f6458a, "updateInitChat(), inboxNo(%s), msgResult(%s), msgId(%d)", str, enumC1591s, Long.valueOf(j));
        if (str == null) {
            C1759s.m7260a(f6458a, "request inbox is NULL", new Object[0]);
        } else {
            C1743c c1743c = this.f6460b.get(str);
            if (c1743c == null) {
                C1759s.m7260a(f6458a, "not exist inbox : %s ", str);
            } else {
                EnumC1450r enumC1450rM7171a = c1743c.m7171a();
                if (enumC1450rM7171a != EnumC1450r.BROADCAST) {
                    long jM7185c = c1743c.m7185c();
                    if (jM7185c == j) {
                        C1759s.m7260a(f6458a, "IS THE SAME INIT CHAT MSG ID (true) : %d / %d", Long.valueOf(jM7185c), Long.valueOf(j));
                        c1743c.m7184b(false, -1L);
                    } else {
                        C1759s.m7260a(f6458a, "IS THE SAME INIT CHAT MSG ID (false) : %d / %d", Long.valueOf(jM7185c), Long.valueOf(j));
                    }
                }
                Context contextL = GlobalApplication.m11493l();
                switch (C1753m.f6462b[enumC1591s.ordinal()]) {
                    case 1:
                        m7215a(str, j, EnumC1741aa.FAILED, (String) null, (Integer) null);
                        C1766z.m7268a(contextL, EnumC1764x.REASON_LATEST_INIT_CHAT_FAIL);
                        break;
                    case 2:
                    case 3:
                    default:
                        m7215a(str, j, EnumC1741aa.PENDING, (String) null, (Integer) null);
                        C1766z.m7268a(contextL, EnumC1764x.REASON_LATEST_INIT_CHAT_FAIL);
                        break;
                    case 4:
                    case 5:
                        m7215a(str, j, EnumC1741aa.SENDED, (String) null, (Integer) null);
                        if (enumC1450rM7171a != EnumC1450r.BROADCAST) {
                            C1766z.m7268a(contextL, EnumC1764x.REASON_LATEST_INIT_CHAT_SUCCESS);
                            break;
                        }
                        break;
                }
            }
        }
    }

    /* renamed from: a */
    public synchronized boolean m7211a(int i, int i2, int i3, C1565k c1565k) {
        boolean z;
        if (c1565k == null) {
            C1759s.m7260a(f6458a, "FileUpload result is NULL !! ", new Object[0]);
            z = false;
        } else {
            long jM6665b = c1565k.m6665b();
            boolean zM6664a = c1565k.m6664a();
            RunnableC1563i runnableC1563iM6629a = C1561g.m6628a().m6629a(jM6665b);
            if (runnableC1563iM6629a == null) {
                C1759s.m7260a(f6458a, "FileUploadTask is not in MANAGER !! ", new Object[0]);
                z = false;
            } else {
                String strM6648a = runnableC1563iM6629a.m6648a();
                C1759s.m7260a(f6458a, "setFileUploadCompleteResult(),  -------- Result -- fileUploadResultType(%d), inboxNo(%s), msgId(%d), resultCode(%d), result(%s)", Integer.valueOf(i), strM6648a, Long.valueOf(jM6665b), Integer.valueOf(i2), Boolean.valueOf(zM6664a));
                if (zM6664a) {
                    m7215a(strM6648a, jM6665b, (EnumC1741aa) null, (String) null, (Integer) 1);
                } else {
                    if (this.f6460b != null) {
                        C1743c c1743c = this.f6460b.get(strM6648a);
                        if (c1743c == null) {
                            C1759s.m7260a(f6458a, "not exist inbox : %s ", strM6648a);
                            z = false;
                        } else {
                            long jM7186d = c1743c.m7186d();
                            if (jM7186d == jM6665b) {
                                C1759s.m7260a(f6458a, "IS THE SAME ALLOW CHAT MSG ID (true) : %d / %d", Long.valueOf(jM7186d), Long.valueOf(jM6665b));
                                c1743c.m7173a(false, -1L);
                            } else {
                                C1759s.m7260a(f6458a, "IS THE SAME ALLOW CHAT MSG ID (false) : %d / %d", Long.valueOf(jM7186d), Long.valueOf(jM6665b));
                            }
                            if (c1743c.m7171a() != EnumC1450r.BROADCAST) {
                                long jM7185c = c1743c.m7185c();
                                if (jM7185c == jM6665b) {
                                    C1759s.m7260a(f6458a, "IS THE SAME INIT CHAT MSG ID (true) : %d / %d", Long.valueOf(jM7185c), Long.valueOf(jM6665b));
                                    c1743c.m7184b(false, -1L);
                                } else {
                                    C1759s.m7260a(f6458a, "IS THE SAME INIT CHAT MSG ID (false) : %d / %d", Long.valueOf(jM7185c), Long.valueOf(jM6665b));
                                }
                            }
                        }
                    }
                    if (RunnableC1563i.m6645a(i2, i3)) {
                        m7215a(strM6648a, jM6665b, EnumC1741aa.PENDING, (String) null, (Integer) null);
                    } else {
                        m7215a(strM6648a, jM6665b, EnumC1741aa.FAILED, (String) null, (Integer) null);
                    }
                    C1766z.m7268a(GlobalApplication.m11493l(), EnumC1764x.REASON_LATEST_SENT_MSG_FAIL);
                }
                z = true;
            }
        }
        return z;
    }
}
