package com.sec.chaton.msgsend;

import android.database.Cursor;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p046a.p047a.C0788l;
import com.sec.chaton.p055d.C2119by;
import com.sec.chaton.p057e.C2306z;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p057e.p058a.C2176ab;
import com.sec.chaton.p067j.C2460k;
import com.sec.chaton.p067j.C2466q;
import com.sec.chaton.p067j.EnumC2468s;
import com.sec.chaton.p067j.p070c.C2438e;
import com.sec.chaton.p067j.p070c.C2442i;
import com.sec.chaton.p067j.p070c.RunnableC2440g;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: MessageProcessor.java */
/* renamed from: com.sec.chaton.msgsend.o */
/* loaded from: classes.dex */
public class C2707o {

    /* renamed from: a */
    public static final String f9702a = C2707o.class.getSimpleName();

    /* renamed from: c */
    private static C2707o f9703c;

    /* renamed from: b */
    final Map<String, AbstractC2682a> f9704b = new HashMap();

    private C2707o() {
        if (m11349e()) {
            C2691ai.m11298a(GlobalApplication.m18732r(), EnumC2689ag.REASON_LOADED_MSG_FROM_DB);
        }
    }

    /* renamed from: a */
    public static String m11328a() {
        return "";
    }

    /* renamed from: b */
    public static synchronized C2707o m11331b() {
        if (f9703c == null) {
            f9703c = new C2707o();
        }
        return f9703c;
    }

    /* renamed from: c */
    public synchronized void m11347c() {
        C2684ab.m11290a(f9702a, "__print_all_data()", new Object[0]);
        if (C4904y.f17872b) {
            C2704l c2704lM11323b = C2704l.m11322a().m11323b();
            Set<Map.Entry<String, AbstractC2682a>> setEntrySet = this.f9704b.entrySet();
            C2684ab.m11290a(f9702a, "----------- print all message (%d chatrooms)----------", Integer.valueOf(setEntrySet.size()));
            for (Map.Entry<String, AbstractC2682a> entry : setEntrySet) {
                String key = entry.getKey();
                AbstractC2682a value = entry.getValue();
                C2684ab.m11290a(f9702a, "  [CHATROOM]  key(%s) : %s", key, value);
                value.m11287e();
            }
            c2704lM11323b.m11324c();
            C2684ab.m11290a(f9702a, "%s", c2704lM11323b);
        }
    }

    /* renamed from: a */
    public synchronized AbstractC2682a m11336a(EnumC2301u enumC2301u, String str, EnumC2300t enumC2300t, String[] strArr, String str2, String str3, int i, boolean z, long j, ChatONMsgEntity chatONMsgEntity) {
        return m11327a(enumC2301u, str, enumC2300t, strArr, str2, str3, i, Boolean.valueOf(z), j, chatONMsgEntity);
    }

    /* renamed from: a */
    public synchronized AbstractC2682a m11335a(EnumC2301u enumC2301u, String str, EnumC2300t enumC2300t, String[] strArr, String str2, ChatONMsgEntity chatONMsgEntity) {
        return m11327a(enumC2301u, str, enumC2300t, strArr, str2, (String) null, Integer.MIN_VALUE, (Boolean) null, 0L, chatONMsgEntity);
    }

    /* renamed from: d */
    public synchronized void m11348d() {
        C2684ab.m11290a(f9702a, "deleteAll()", new Object[0]);
        C2704l c2704lM11323b = C2704l.m11322a().m11323b();
        Iterator<Map.Entry<String, AbstractC2682a>> it = this.f9704b.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().m11285c();
        }
        this.f9704b.clear();
        c2704lM11323b.m11324c();
        C2684ab.m11290a(f9702a, "elapsed in 'DELETE ALL INBOX & MSG (%s) ", c2704lM11323b);
    }

    /* renamed from: a */
    public synchronized boolean m11340a(String str) {
        boolean z;
        C2684ab.m11290a(f9702a, "deleteInbox(), inboxNo(%s)", str);
        AbstractC2682a abstractC2682a = this.f9704b.get(str);
        if (abstractC2682a == null) {
            C2684ab.m11290a(f9702a, "not exist inbox : %s ", str);
            z = false;
        } else {
            abstractC2682a.m11285c();
            this.f9704b.remove(str);
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    synchronized int m11334a(String str, ArrayList<Long> arrayList, ArrayList<Integer> arrayList2) {
        int iM11271a;
        C2684ab.m11290a(f9702a, "deleteAllMsgWithExceptionMsgList(), inboxNo(%s)", str);
        AbstractC2682a abstractC2682a = this.f9704b.get(str);
        if (abstractC2682a == null) {
            C2684ab.m11290a(f9702a, "not exist inbox : %s ", str);
            iM11271a = -1;
        } else {
            iM11271a = abstractC2682a.m11271a(arrayList, arrayList2);
        }
        return iM11271a;
    }

    /* renamed from: a */
    public synchronized int m11333a(String str, ArrayList<Integer> arrayList) {
        int iM11270a;
        C2684ab.m11290a(f9702a, "deleteAllMsgWithExceptionStatus(), inboxNo(%s)", str);
        AbstractC2682a abstractC2682a = this.f9704b.get(str);
        if (abstractC2682a == null) {
            C2684ab.m11290a(f9702a, "not exist inbox : %s ", str);
            iM11270a = -1;
        } else {
            iM11270a = abstractC2682a.m11270a(arrayList);
        }
        return iM11270a;
    }

    /* renamed from: b */
    public synchronized int m11345b(String str, ArrayList<Integer> arrayList) {
        int iM11280b;
        C2684ab.m11290a(f9702a, "deleteAllMsgWithStatus(), inboxNo(%s)", str);
        AbstractC2682a abstractC2682a = this.f9704b.get(str);
        if (abstractC2682a == null) {
            C2684ab.m11290a(f9702a, "not exist inbox : %s ", str);
            iM11280b = -1;
        } else {
            iM11280b = abstractC2682a.m11280b(arrayList);
        }
        return iM11280b;
    }

    /* renamed from: b */
    public synchronized int m11346b(String str, ArrayList<Long> arrayList, ArrayList<Integer> arrayList2) {
        int iM11281b;
        C2684ab.m11290a(f9702a, "deleteMsgWithTargetList(), inboxNo(%s)", str);
        AbstractC2682a abstractC2682a = this.f9704b.get(str);
        if (abstractC2682a == null) {
            C2684ab.m11290a(f9702a, "not exist inbox : %s ", str);
            iM11281b = -1;
        } else {
            iM11281b = abstractC2682a.m11281b(arrayList, arrayList2);
        }
        return iM11281b;
    }

    /* renamed from: a */
    public synchronized boolean m11341a(String str, long j) {
        boolean z = false;
        synchronized (this) {
            C2684ab.m11290a(f9702a, "deleteMsg(), inboxNo(%s), msgId(%d)", str, Long.valueOf(j));
            AbstractC2682a abstractC2682a = this.f9704b.get(str);
            if (abstractC2682a == null) {
                C2684ab.m11290a(f9702a, "not exist inbox : %s ", str);
            } else {
                z = abstractC2682a.m11284c(j) != null;
            }
        }
        return z;
    }

    /* renamed from: e */
    public synchronized boolean m11349e() {
        boolean z;
        C2684ab.m11290a(f9702a, "loadMessageFromDB()", new Object[0]);
        C2704l c2704lM11323b = C2704l.m11322a().m11323b();
        Cursor cursorM11332f = m11332f();
        if (cursorM11332f == null) {
            C2684ab.m11290a(f9702a, "query result is (null)", new Object[0]);
            z = false;
        } else {
            C2684ab.m11290a(f9702a, "query result COUNT is (%d)", Integer.valueOf(cursorM11332f.getCount()));
            if (this.f9704b.size() > 0) {
                C2684ab.m11290a(f9702a, "Some MSGs are already exist in MessageList", new Object[0]);
            }
            int columnIndex = cursorM11332f.getColumnIndex("message_inbox_no");
            int columnIndex2 = cursorM11332f.getColumnIndex("inbox_session_id");
            int columnIndex3 = cursorM11332f.getColumnIndex("inbox_chat_type");
            int columnIndex4 = cursorM11332f.getColumnIndex("_id");
            int columnIndex5 = cursorM11332f.getColumnIndex("message_content_type");
            int columnIndex6 = cursorM11332f.getColumnIndex("message_content");
            int columnIndex7 = cursorM11332f.getColumnIndex("message_content_translated");
            int columnIndex8 = cursorM11332f.getColumnIndex("message_type");
            int columnIndex9 = cursorM11332f.getColumnIndex("message_download_uri");
            int columnIndex10 = cursorM11332f.getColumnIndex("message_formatted");
            int columnIndex11 = cursorM11332f.getColumnIndex("message_is_file_upload");
            int columnIndex12 = cursorM11332f.getColumnIndex("inbox_server_ip");
            int columnIndex13 = cursorM11332f.getColumnIndex("inbox_server_port");
            int columnIndex14 = cursorM11332f.getColumnIndex("inbox_valid");
            int columnIndex15 = cursorM11332f.getColumnIndex("lasst_session_merge_time");
            int columnIndex16 = cursorM11332f.getColumnIndex("inbox_room_type");
            cursorM11332f.moveToPosition(-1);
            while (cursorM11332f.moveToNext()) {
                String string = cursorM11332f.getString(columnIndex);
                String string2 = cursorM11332f.getString(columnIndex2);
                EnumC2300t enumC2300tM10207a = EnumC2300t.m10207a(cursorM11332f.getInt(columnIndex3));
                long j = cursorM11332f.getLong(columnIndex4);
                EnumC2214ab enumC2214abM10070a = EnumC2214ab.m10070a(cursorM11332f.getInt(columnIndex5));
                String string3 = cursorM11332f.getString(columnIndex6);
                String string4 = cursorM11332f.getString(columnIndex7);
                int i = cursorM11332f.getInt(columnIndex8);
                String string5 = cursorM11332f.getString(columnIndex9);
                String string6 = cursorM11332f.getString(columnIndex10);
                int i2 = cursorM11332f.getInt(columnIndex11);
                String string7 = cursorM11332f.getString(columnIndex12);
                int i3 = cursorM11332f.getInt(columnIndex13);
                boolean zEquals = "Y".equals(cursorM11332f.getString(columnIndex14));
                long j2 = cursorM11332f.getLong(columnIndex15);
                EnumC2301u enumC2301uM10211a = EnumC2301u.m10211a(cursorM11332f.getInt(columnIndex16));
                if (zEquals) {
                    m11336a(enumC2301uM10211a, string, enumC2300tM10207a, (String[]) null, string2, string7, i3, zEquals, j2, new ChatONMsgEntity(j, enumC2214abM10070a, string3, string4, string5, string6, i2, i));
                }
            }
            cursorM11332f.close();
            c2704lM11323b.m11324c();
            C2684ab.m11290a(f9702a, "LoadMessageFromDB - end (%s) ", c2704lM11323b);
            m11347c();
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    public synchronized void m11337a(EnumC2689ag enumC2689ag) {
        C2684ab.m11290a(f9702a, "sendAllChatONMsg(), reason(%s)", enumC2689ag);
        C2684ab.m11290a(f9702a, " -------------- (ACTION !!) SEND ALL CHATON MSG in actually here. (%s) -------------- ", enumC2689ag);
        if (C2717y.m11406i()) {
            C2685ac.m11292a("Try to send all", m11328a());
        }
        C2704l c2704lM11323b = C2704l.m11322a().m11323b();
        HashMap map = new HashMap();
        for (Map.Entry<String, AbstractC2682a> entry : this.f9704b.entrySet()) {
            String key = entry.getKey();
            C2688af c2688afMo11272a = entry.getValue().mo11272a();
            C2684ab.m11290a(f9702a, "inbox(%s) sending messages result : (%s)", key, c2688afMo11272a);
            switch (C2708p.f9705a[c2688afMo11272a.f9646c.ordinal()]) {
                case 1:
                    map.put(key, c2688afMo11272a);
                    break;
            }
        }
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            String str = (String) ((Map.Entry) it.next()).getKey();
            AbstractC2682a abstractC2682a = this.f9704b.get(str);
            if (abstractC2682a != null) {
                C2684ab.m11290a(f9702a, "sendAllChatONMsg() - REMOVE Useless Room", abstractC2682a);
                abstractC2682a.m11285c();
                this.f9704b.remove(str);
            }
        }
        c2704lM11323b.m11324c();
        C2684ab.m11290a(f9702a, "elapsed in sending all messages : (%s) ", c2704lM11323b);
    }

    /* renamed from: a */
    public synchronized boolean m11339a(int i, String str, C2119by c2119by, boolean z) {
        boolean z2;
        C0788l c0788l = (C0788l) c2119by.m9463a();
        if (c0788l == null) {
            C2684ab.m11290a(f9702a, "ERROR in setServerResult_direct(), oResultEntry is NULL ------------------------ ", new Object[0]);
            C2684ab.m11290a(f9702a, "ERROR in setServerResult_direct(), oResultEntry is NULL ------------------------ ", new Object[0]);
            C2684ab.m11290a(f9702a, "ERROR in setServerResult_direct(), oResultEntry is NULL ------------------------ ", new Object[0]);
            z2 = false;
        } else {
            int iM3152g = c0788l.m3152g();
            boolean z3 = c0788l.f2172a;
            long jM3153h = c0788l.m3153h();
            C2684ab.m11290a(f9702a, "setServerResult_direct(),  -- Result -- GpbType(%s, %d), inboxNo(%s), msgId(%d), resultCode(%d), result(%s)", C2460k.m10659c(i), Integer.valueOf(i), str, Long.valueOf(jM3153h), Integer.valueOf(iM3152g), Boolean.valueOf(z3));
            if (z) {
                switch (i) {
                    case 0:
                    case 106:
                        if (C2466q.m10670a(iM3152g)) {
                            m11330a(EnumC2693ak.SEND_TYPE_INIT_CHAT, str, EnumC2468s.RETRY_WITH_TIMEOUT, jM3153h);
                            break;
                        } else if (c0788l.f2172a) {
                            m11330a(EnumC2693ak.SEND_TYPE_INIT_CHAT, str, EnumC2468s.SUCCESS_NORMALLY, jM3153h);
                            break;
                        } else {
                            m11330a(EnumC2693ak.SEND_TYPE_INIT_CHAT, str, EnumC2468s.FAILED, jM3153h);
                            break;
                        }
                    case 2:
                        if (iM3152g == 2006 || iM3152g == 3008) {
                            m11329a(EnumC2693ak.SEND_TYPE_ALLOW_CHAT, str, EnumC2468s.RETRY_WITH_CHANGING_SERVER);
                            break;
                        } else if (C2466q.m10670a(iM3152g)) {
                            m11329a(EnumC2693ak.SEND_TYPE_ALLOW_CHAT, str, EnumC2468s.RETRY_WITH_TIMEOUT);
                            break;
                        } else if (c0788l.f2172a) {
                            m11329a(EnumC2693ak.SEND_TYPE_ALLOW_CHAT, str, EnumC2468s.SUCCESS_NORMALLY);
                            break;
                        } else {
                            m11329a(EnumC2693ak.SEND_TYPE_ALLOW_CHAT, str, EnumC2468s.FAILED);
                            break;
                        }
                    case 4:
                    case 102:
                        if (C2466q.m10670a(iM3152g)) {
                            m11330a(EnumC2693ak.SEND_TYPE_CHAT_REQUEST, str, EnumC2468s.RETRY_WITH_TIMEOUT, jM3153h);
                            break;
                        } else if (iM3152g == 2006 || iM3152g == 3008) {
                            m11330a(EnumC2693ak.SEND_TYPE_CHAT_REQUEST, str, EnumC2468s.RETRY_WITH_CHANGING_SERVER, jM3153h);
                            break;
                        } else if (iM3152g != 900) {
                            if (iM3152g == 5100) {
                                int iM3154i = c0788l.m3154i();
                                if (iM3154i == 7002 || iM3154i == 7003) {
                                    m11330a(EnumC2693ak.SEND_TYPE_CHAT_REQUEST, str, EnumC2468s.RETRY_WITH_TIMEOUT, jM3153h);
                                    break;
                                } else {
                                    m11330a(EnumC2693ak.SEND_TYPE_CHAT_REQUEST, str, EnumC2468s.FAILED, jM3153h);
                                    break;
                                }
                            } else if (c0788l.f2172a) {
                                m11330a(EnumC2693ak.SEND_TYPE_CHAT_REQUEST, str, EnumC2468s.SUCCESS_NORMALLY, jM3153h);
                                break;
                            } else {
                                m11330a(EnumC2693ak.SEND_TYPE_CHAT_REQUEST, str, EnumC2468s.FAILED, jM3153h);
                                break;
                            }
                        }
                        break;
                    case 8:
                        if (!C2466q.m10670a(iM3152g)) {
                            if (iM3152g == 3003 || iM3152g == 10000) {
                                m11329a(EnumC2693ak.SEND_TYPE_ALLOW_CHAT, str, EnumC2468s.SUCCESS_NORMALLY);
                                break;
                            } else if (c0788l.f2172a) {
                                m11340a(str);
                                break;
                            }
                        }
                        break;
                }
            } else {
                switch (i) {
                    case 2:
                        if (c0788l.m3152g() == 3003) {
                            m11329a(EnumC2693ak.SEND_TYPE_ALLOW_CHAT, str, EnumC2468s.SUCCESS_NORMALLY);
                            break;
                        }
                        break;
                    case 6:
                    case 34:
                    case 36:
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
    public synchronized boolean m11343a(String str, long j, String str2) {
        AbstractC2682a abstractC2682a;
        C2684ab.m11290a(f9702a, "updateMsgMessage(), inboxNo(%s), msgId(%d), chatMsg(%s)", str, Long.valueOf(j), str2);
        abstractC2682a = this.f9704b.get(str);
        return abstractC2682a == null ? false : abstractC2682a.m11277a(j, str2);
    }

    /* renamed from: a */
    public synchronized boolean m11342a(String str, long j, EnumC2692aj enumC2692aj, String str2, Integer num) {
        AbstractC2682a abstractC2682a;
        C2684ab.m11290a(f9702a, "updateMsg(), inboxNo(%s), msgId(%d), sendStatus(%s), formattedMsg(%s), isFileUploaded(%s)", str, Long.valueOf(j), enumC2692aj, str2, num);
        abstractC2682a = null;
        if (this.f9704b != null) {
            abstractC2682a = this.f9704b.get(str);
        }
        return abstractC2682a == null ? false : abstractC2682a.m11276a(j, enumC2692aj, str2, num);
    }

    /* renamed from: a */
    private synchronized AbstractC2682a m11327a(EnumC2301u enumC2301u, String str, EnumC2300t enumC2300t, String[] strArr, String str2, String str3, int i, Boolean bool, long j, ChatONMsgEntity chatONMsgEntity) {
        AbstractC2682a abstractC2682aM11268a;
        C2684ab.m11290a(f9702a, "addMsg(), RoomType(%s), inboxNo(%s), chatType(%s), sesseionId(%s), serverIP(%s), serverPort(%d), isInboxValid(%s), lastSessionMergeTime(%d), msgEntity(%s)", enumC2301u, str, enumC2300t, str2, str3, Integer.valueOf(i), bool, Long.valueOf(j), chatONMsgEntity);
        abstractC2682aM11268a = this.f9704b.get(str);
        if (abstractC2682aM11268a == null) {
            C2684ab.m11290a(f9702a, "New managed inbox is created!! addMsg(), inboxNo(%s), chatType(%s), sesseionId(%s), serverIP(%s), serverPort(%d), isInboxValid(%s), lastSessionMergeTime(%d)", str, enumC2300t, str2, str3, Integer.valueOf(i), bool, Long.valueOf(j));
            if (strArr == null && (strArr = C2176ab.m9689c(GlobalApplication.m18732r().getContentResolver(), str)) == null) {
                C2684ab.m11290a(f9702a, "[ERROR] no participant, so make it FAILED !!!!!!!!! inboxNo(%s), chatType(%s), Msg(%s)", str, enumC2300t, chatONMsgEntity);
                chatONMsgEntity.m11252a(EnumC2692aj.FAILED);
            }
            abstractC2682aM11268a = AbstractC2682a.m11268a(enumC2301u, str, enumC2300t, strArr);
            if (abstractC2682aM11268a == null) {
                abstractC2682aM11268a = null;
            } else {
                if (!abstractC2682aM11268a.mo11279a(str2, str3, i, j)) {
                    Boolean.valueOf(false);
                }
                this.f9704b.put(str, abstractC2682aM11268a);
            }
        } else {
            C2684ab.m11290a(f9702a, "addMsg in exist inbox (%s)", str);
            if (strArr != null) {
                abstractC2682aM11268a.m11275a(strArr);
            }
        }
        if (!abstractC2682aM11268a.m11278a(chatONMsgEntity)) {
            abstractC2682aM11268a = null;
        }
        return abstractC2682aM11268a;
    }

    /* renamed from: a */
    public synchronized boolean m11344a(String str, String str2) {
        boolean z;
        AbstractC2682a abstractC2682a = this.f9704b.get(str);
        if (abstractC2682a == null) {
            z = false;
        } else {
            abstractC2682a.m11275a(new String[]{str2});
            z = true;
        }
        return z;
    }

    /* renamed from: f */
    private synchronized Cursor m11332f() {
        Cursor cursorQuery;
        C2684ab.m11290a(f9702a, "queryAllPendings()", new Object[0]);
        C2704l c2704lM11323b = C2704l.m11322a().m11323b();
        String strM18121a = C4809aa.m18104a().m18121a("chaton_id", "");
        C2684ab.m11290a(f9702a, "My ChatonID is (%s)", strM18121a);
        if (TextUtils.isEmpty(strM18121a)) {
            cursorQuery = null;
        } else {
            cursorQuery = GlobalApplication.m18732r().getContentResolver().query(C2306z.m10227f(), null, null, new String[]{strM18121a}, null);
            c2704lM11323b.m11324c();
            C2684ab.m11290a(f9702a, "elapsed (%s)", c2704lM11323b);
            if (cursorQuery == null) {
                cursorQuery = null;
            }
        }
        return cursorQuery;
    }

    /* renamed from: a */
    private synchronized void m11329a(EnumC2693ak enumC2693ak, String str, EnumC2468s enumC2468s) {
        m11330a(enumC2693ak, str, enumC2468s, -1L);
    }

    /* renamed from: a */
    private synchronized void m11330a(EnumC2693ak enumC2693ak, String str, EnumC2468s enumC2468s, long j) {
        C2684ab.m11290a(f9702a, "setMsgSendResult(), msgSendType(%s), inboxNo(%s), msgResult(%s), msgId(%d)", enumC2693ak, str, enumC2468s, Long.valueOf(j));
        if (str == null) {
            C2684ab.m11290a(f9702a, "request inboxNo is NULL", new Object[0]);
        } else if (this.f9704b == null) {
            C2684ab.m11290a(f9702a, "mInboxMap is NULL", new Object[0]);
        } else {
            AbstractC2682a abstractC2682a = this.f9704b.get(str);
            if (abstractC2682a == null) {
                C2684ab.m11290a(f9702a, "not exist inbox : %s ", str);
            } else {
                EnumC2689ag enumC2689agMo11273a = abstractC2682a.mo11273a(enumC2693ak, enumC2468s, j);
                if (!EnumC2689ag.UNDETERMINED.equals(enumC2689agMo11273a)) {
                    C2691ai.m11298a(GlobalApplication.m18732r(), enumC2689agMo11273a);
                }
            }
        }
    }

    /* renamed from: a */
    public synchronized boolean m11338a(int i, int i2, int i3, C2442i c2442i) {
        boolean z;
        if (c2442i == null) {
            C2684ab.m11290a(f9702a, "FileUpload result is NULL !! ", new Object[0]);
            z = false;
        } else {
            long jM10609b = c2442i.m10609b();
            boolean zM10608a = c2442i.m10608a();
            RunnableC2440g runnableC2440gM10573a = C2438e.m10572a().m10573a(jM10609b);
            if (runnableC2440gM10573a == null) {
                C2684ab.m11290a(f9702a, "FileUploadTask is not in MANAGER !! ", new Object[0]);
                z = false;
            } else {
                String strM10592a = runnableC2440gM10573a.m10592a();
                C2684ab.m11290a(f9702a, "setFileUploadCompleteResult(),  -------- Result -- fileUploadResultType(%d), inboxNo(%s), msgId(%d), resultCode(%d), result(%s)", Integer.valueOf(i), strM10592a, Long.valueOf(jM10609b), Integer.valueOf(i2), Boolean.valueOf(zM10608a));
                if (zM10608a) {
                    m11342a(strM10592a, jM10609b, null, null, 1);
                } else {
                    if (this.f9704b != null) {
                        AbstractC2682a abstractC2682a = this.f9704b.get(strM10592a);
                        if (abstractC2682a == null) {
                            C2684ab.m11290a(f9702a, "not exist inbox : %s ", strM10592a);
                            z = false;
                        } else {
                            abstractC2682a.mo11274a(jM10609b);
                        }
                    }
                    if (RunnableC2440g.m10589a(i2, i3)) {
                        m11342a(strM10592a, jM10609b, EnumC2692aj.PENDING, null, null);
                    } else {
                        m11342a(strM10592a, jM10609b, EnumC2692aj.FAILED, null, null);
                    }
                    C2691ai.m11298a(GlobalApplication.m18732r(), EnumC2689ag.REASON_LATEST_SENT_MSG_FAIL);
                }
                z = true;
            }
        }
        return z;
    }
}
