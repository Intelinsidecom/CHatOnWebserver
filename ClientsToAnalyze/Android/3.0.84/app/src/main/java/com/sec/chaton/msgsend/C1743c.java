package com.sec.chaton.msgsend;

import android.database.Cursor;
import android.os.SystemClock;
import android.text.TextUtils;
import com.sec.chaton.chat.notification.C1103a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p020c.C0822g;
import com.sec.chaton.p025d.C1337o;
import com.sec.chaton.p027e.C1449q;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p027e.p028a.C1373q;
import com.sec.chaton.p037j.C1544ac;
import com.sec.chaton.p037j.C1596x;
import com.sec.chaton.util.C3194bi;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: ChatONChatRoomEntity.java */
/* renamed from: com.sec.chaton.msgsend.c */
/* loaded from: classes.dex */
public class C1743c {

    /* renamed from: a */
    public static final String f6429a = C1743c.class.getSimpleName();

    /* renamed from: b */
    private final String f6430b;

    /* renamed from: c */
    private final EnumC1450r f6431c;

    /* renamed from: d */
    private String[] f6432d;

    /* renamed from: f */
    private long f6434f = -1;

    /* renamed from: g */
    private long f6435g = -1;

    /* renamed from: h */
    private long f6436h = -1;

    /* renamed from: i */
    private long f6437i = -1;

    /* renamed from: j */
    private long f6438j = -1;

    /* renamed from: k */
    private long f6439k = -1;

    /* renamed from: e */
    private LinkedHashMap<Long, ChatONMsgEntity> f6433e = new LinkedHashMap<>();

    /* renamed from: k */
    private boolean m7166k() {
        if (this.f6434f < 0) {
            return false;
        }
        long jM4374c = C0822g.m4374c() * 2;
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j = jUptimeMillis - this.f6434f;
        if (j > jM4374c) {
            C1759s.m7260a(f6429a, "IsInProgressAllowChat(), force to release, diff(%d) = current(%d) - request(%d), wait for msgId(%d), Threshold(%d)", Long.valueOf(j), Long.valueOf(jUptimeMillis), Long.valueOf(this.f6434f), Long.valueOf(this.f6437i), Long.valueOf(jM4374c));
            if (C1757q.m7257g()) {
                C1760t.m7262a("force to release ALLOW-CHAT", C1752l.m7200a());
            }
            m7165c(this.f6437i);
            m7173a(false, -1L);
            return false;
        }
        C1759s.m7260a(f6429a, "IsInProgressAllowChat(), wait more ... , diff(%d) = current(%d) - request(%d), wait for msgId(%d), Threshold(%d)", Long.valueOf(j), Long.valueOf(jUptimeMillis), Long.valueOf(this.f6434f), Long.valueOf(this.f6437i), Long.valueOf(jM4374c));
        return true;
    }

    /* renamed from: l */
    private boolean m7167l() {
        if (this.f6435g < 0) {
            return false;
        }
        long jM4376e = C0822g.m4376e() * 2;
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j = jUptimeMillis - this.f6435g;
        if (j > jM4376e) {
            C1759s.m7260a(f6429a, "IsInProgressInitChat(), force to elease, diff(%d) = current(%d) - request(%d), wait for msgId(%d), Threshold(%d)", Long.valueOf(j), Long.valueOf(jUptimeMillis), Long.valueOf(this.f6435g), Long.valueOf(this.f6438j), Long.valueOf(jM4376e));
            if (C1757q.m7257g()) {
                C1760t.m7262a("force to release INIT-CHAT", C1752l.m7200a());
            }
            m7165c(this.f6438j);
            m7184b(false, -1L);
            return false;
        }
        C1759s.m7260a(f6429a, "IsInProgressInitChat(), wait more ... , diff(%d) = current(%d) - request(%d), wait for msgId(%d), Threshold(%d)", Long.valueOf(j), Long.valueOf(jUptimeMillis), Long.valueOf(this.f6435g), Long.valueOf(this.f6438j), Long.valueOf(jM4376e));
        return true;
    }

    /* renamed from: m */
    private boolean m7168m() {
        if (this.f6439k <= 0) {
            return false;
        }
        long jM4375d = C0822g.m4375d() * 2;
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j = jUptimeMillis - this.f6436h;
        if (j > jM4375d) {
            C1759s.m7260a(f6429a, "IsInProgressSerialChat(), force to elease, diff(%d) = current(%d) - request(%d), wait for msgId(%d), Threshold(%d)", Long.valueOf(j), Long.valueOf(jUptimeMillis), Long.valueOf(this.f6436h), Long.valueOf(this.f6439k), Long.valueOf(jM4375d));
            if (C1757q.m7257g()) {
                C1760t.m7262a("force to release SERIAL-CHAT", C1752l.m7200a());
            }
            m7165c(this.f6439k);
            m7172a(-1L);
            return false;
        }
        C1759s.m7260a(f6429a, "IsInProgressSerialChat(), wait more ... , diff(%d) = current(%d) - request(%d), wait for msgId(%d), Threshold(%d)", Long.valueOf(j), Long.valueOf(jUptimeMillis), Long.valueOf(this.f6436h), Long.valueOf(this.f6439k), Long.valueOf(jM4375d));
        return true;
    }

    /* renamed from: c */
    private boolean m7165c(long j) {
        ChatONMsgEntity chatONMsgEntity = this.f6433e.get(Long.valueOf(j));
        if (chatONMsgEntity == null) {
            return false;
        }
        if (chatONMsgEntity.m7150l() == EnumC1741aa.SENDING) {
            chatONMsgEntity.m7135a(EnumC1741aa.PENDING);
            C1373q.m6155a(GlobalApplication.m11493l().getContentResolver(), Long.valueOf(j));
        }
        return true;
    }

    C1743c(String str, EnumC1450r enumC1450r, String[] strArr) {
        this.f6430b = str;
        this.f6431c = enumC1450r;
        this.f6432d = strArr;
    }

    /* renamed from: a */
    public EnumC1450r m7171a() {
        return this.f6431c;
    }

    /* renamed from: a */
    void m7174a(String[] strArr) {
        this.f6432d = strArr;
    }

    /* renamed from: b */
    void m7183b() {
        if (this.f6433e != null) {
            this.f6433e.clear();
            this.f6433e = null;
        }
        C1759s.m7260a(f6429a, "release(), %s MSG all are released", this.f6430b);
    }

    /* renamed from: a */
    public boolean m7179a(String str, String str2, int i, long j) {
        C1337o c1337oM5795a = C1337o.m5795a(this.f6430b, this.f6431c);
        C1759s.m7260a(f6429a, "setReadyMessageControl(), (requested) in inbox(%s): sessionId(%s), serverIp(%s), serverPort(%d)", this.f6430b, str, str2, Integer.valueOf(i));
        c1337oM5795a.m5889b(str);
        c1337oM5795a.m5886b(j);
        C1544ac c1544acM5898f = c1337oM5795a.m5898f();
        if (!m7177a(c1544acM5898f)) {
            C1759s.m7260a(f6429a, "setReadyMessageControl(), (Last result) #1 has valid TcpContext already (%s)", c1544acM5898f);
            return true;
        }
        if (!TextUtils.isEmpty(str2) && i > 0) {
            c1337oM5795a.m5880a(this.f6430b, str2, i);
            c1337oM5795a.m5893c(SystemClock.elapsedRealtime() + 480000);
            C1759s.m7260a(f6429a, "setReadyMessageControl(), (Last result) #2 set by using params, serverIp(%s), serverPot(%d)", str2, Integer.valueOf(i));
            return true;
        }
        Cursor cursorQuery = GlobalApplication.m11493l().getContentResolver().query(C1449q.f5381a, new String[]{"inbox_server_ip", "inbox_server_port"}, "inbox_no=?", new String[]{this.f6430b}, null);
        if (cursorQuery != null) {
            cursorQuery.moveToFirst();
            str2 = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_server_ip"));
            i = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_server_port"));
            cursorQuery.close();
        }
        if (!TextUtils.isEmpty(str2) && i > 0) {
            C1759s.m7260a(f6429a, "setReadyMessageControl(), (ongoing result) #3 set by using DB value, serverIp(%s), serverPot(%d)", str2, Integer.valueOf(i));
        } else {
            str2 = C3194bi.m11149a().m11154c().m11155a();
            i = C3194bi.m11149a().m11154c().m11158b();
            if (!TextUtils.isEmpty(str2) && i > 0) {
                C1759s.m7260a(f6429a, "setReadyMessageControl(), (ongoing result) #4 set by using GLD value, serverIp(%s), serverPot(%d)", str2, Integer.valueOf(i));
            } else {
                C1759s.m7260a(f6429a, "[ERROR] setReadyMessageControl(), (Last Result) Nothing to use even GLD", new Object[0]);
                return false;
            }
        }
        c1337oM5795a.m5880a(this.f6430b, str2, i);
        c1337oM5795a.m5893c(SystemClock.elapsedRealtime() + 480000);
        C1759s.m7260a(f6429a, "SET READY Message Control, (Last Result) in inbox(%s): new TcpContext (%s) ", this.f6430b, c1337oM5795a.m5898f());
        return true;
    }

    /* renamed from: a */
    boolean m7177a(C1544ac c1544ac) {
        if (c1544ac == null) {
            return true;
        }
        return TextUtils.isEmpty(c1544ac.m6557d()) && c1544ac.m6558e() > 0;
    }

    /* renamed from: c */
    public long m7185c() {
        return this.f6438j;
    }

    /* renamed from: d */
    public long m7186d() {
        return this.f6437i;
    }

    /* renamed from: a */
    public void m7173a(boolean z, long j) {
        if (z) {
            this.f6434f = SystemClock.uptimeMillis();
            this.f6437i = j;
            C1759s.m7260a(f6429a, "setInProgressAllowChat(), inProgressAllowChat(%s), mInboxNo(%s), msgId(%d)", Boolean.valueOf(z), this.f6430b, Long.valueOf(j));
        } else {
            this.f6434f = -1L;
            this.f6437i = -1L;
        }
        C1759s.m7260a(f6429a, "setInProgressAllowChat(), ---- set result (inboxNo:%s) : inProgressAllowChat(%s) msgId(%d), requestTime(%d) ---- ", this.f6430b, Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(this.f6434f));
    }

    /* renamed from: b */
    public void m7184b(boolean z, long j) {
        if (this.f6431c == EnumC1450r.BROADCAST) {
            C1759s.m7260a(f6429a, "setInProgressInitChat(), IGNORED - BROADCAST ROOM,  inProgressInitChat(%s), mInboxNo(%s), msgId(%d)", Long.valueOf(this.f6438j), this.f6430b, Long.valueOf(j));
            return;
        }
        if (z) {
            this.f6435g = SystemClock.uptimeMillis();
            this.f6438j = j;
            C1759s.m7260a(f6429a, "setInProgressInitChat(), inProgressInitChat(%s), mInboxNo(%s), msgId(%d)", Long.valueOf(this.f6438j), this.f6430b, Long.valueOf(j));
        } else {
            this.f6435g = -1L;
            this.f6438j = -1L;
        }
        C1759s.m7260a(f6429a, "setInProgressInitChat(),  ---- set result (%s), msgId(%d) : reqInProgress(%s), nowInProgress(%d) ---- ", this.f6430b, Long.valueOf(j), Boolean.valueOf(z), Long.valueOf(this.f6435g));
    }

    /* renamed from: e */
    boolean m7187e() {
        return this.f6433e != null;
    }

    /* renamed from: f */
    public int m7188f() {
        if (this.f6433e == null) {
            return 0;
        }
        return this.f6433e.size();
    }

    /* renamed from: g */
    public int m7189g() {
        int i = 0;
        if (this.f6433e == null) {
            return 0;
        }
        Iterator<Map.Entry<Long, ChatONMsgEntity>> it = this.f6433e.entrySet().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = it.next().getValue().m7141c() ? i2 + 1 : i2;
        }
    }

    /* renamed from: b */
    private ChatONMsgEntity m7163b(ChatONMsgEntity chatONMsgEntity) {
        return this.f6433e.put(chatONMsgEntity.m7143e(), chatONMsgEntity);
    }

    /* renamed from: a */
    public boolean m7178a(ChatONMsgEntity chatONMsgEntity) {
        if (!m7187e()) {
            C1759s.m7260a(f6429a, "This inbox is NOT AVAILABLE", new Object[0]);
            return false;
        }
        switch (C1744d.f6440a[chatONMsgEntity.m7150l().ordinal()]) {
            case 1:
            case 2:
                break;
            default:
                ChatONMsgEntity chatONMsgEntityM7163b = m7163b(chatONMsgEntity);
                C1759s.m7260a(f6429a, "new msg entity %s ", chatONMsgEntity);
                if (chatONMsgEntityM7163b != null) {
                    C1759s.m7260a(f6429a, "exist msg entity : %s ", chatONMsgEntityM7163b);
                    break;
                } else {
                    break;
                }
        }
        return false;
    }

    /* renamed from: a */
    private C1763w m7162a(C1337o c1337o, C1763w c1763w) throws InterruptedException {
        C1759s.m7260a(f6429a, "sendAllInboxMsgByUnit()", new Object[0]);
        Iterator<Map.Entry<Long, ChatONMsgEntity>> it = this.f6433e.entrySet().iterator();
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            ChatONMsgEntity value = it.next().getValue();
            if (!value.m7141c()) {
                C1759s.m7260a(f6429a, " Check to send (One Unit): (No need to resend msg) %s", value);
            } else {
                C1759s.m7260a(f6429a, " Check to send (One Unit): %s", value);
                try {
                    Thread.sleep(50L);
                } catch (InterruptedException e) {
                    if (C3250y.f11737e) {
                        C3250y.m11443a(e, f6429a);
                    }
                }
                if (c1337o.m5877a(value, this.f6432d)) {
                    value.m7136a();
                } else {
                    value.m7135a(EnumC1741aa.FAILED);
                    arrayList.add(value.m7143e());
                }
                c1763w.f6495b++;
            }
        }
        C1759s.m7260a(f6429a, "Request to send (%d/%d)", Integer.valueOf(c1763w.f6495b), Integer.valueOf(c1763w.f6494a));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            C1759s.m7260a(f6429a, "Remove INVALID MESSAGE : %s ", this.f6433e.remove(Long.valueOf(((Long) it2.next()).longValue())));
        }
        return c1763w;
    }

    /* renamed from: a */
    public void m7172a(long j) {
        if (j > 0) {
            this.f6436h = SystemClock.uptimeMillis();
        } else {
            this.f6436h = -1L;
        }
        C1759s.m7260a(f6429a, "setSerialChatLastMember(), MsgID (%d) -> (%d), requestTime(%d)", Long.valueOf(this.f6439k), Long.valueOf(j), Long.valueOf(this.f6436h));
        this.f6439k = j;
    }

    /* renamed from: h */
    public long m7190h() {
        return this.f6439k;
    }

    /* renamed from: b */
    private C1763w m7164b(C1337o c1337o, C1763w c1763w) throws InterruptedException {
        C1759s.m7260a(f6429a, "sendAllInboxMsgByUsingBulk()", new Object[0]);
        Set<Map.Entry<Long, ChatONMsgEntity>> setEntrySet = this.f6433e.entrySet();
        String strM5895d = c1337o.m5895d();
        Object[] array = setEntrySet.toArray();
        ArrayList<ChatONMsgEntity> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : array) {
            ChatONMsgEntity chatONMsgEntity = (ChatONMsgEntity) ((Map.Entry) obj).getValue();
            if (!chatONMsgEntity.m7141c()) {
                C1759s.m7260a(f6429a, " Check to send (Bulk check): (No need to resend msg) %s", chatONMsgEntity);
            } else {
                C1759s.m7260a(f6429a, " Check to send (Bulk check): %s", chatONMsgEntity);
                if (chatONMsgEntity.m7144f() != EnumC1455w.TEXT) {
                    int size = arrayList.size();
                    if (size > 0) {
                        c1763w.f6495b += size;
                        c1337o.m5845a(this.f6431c, strM5895d, this.f6432d, arrayList);
                        m7172a(arrayList.get(size - 1).m7143e().longValue());
                    }
                    arrayList.clear();
                    int i = size * 10;
                    if (i < 10) {
                        i = 10;
                    }
                    if (i > 1000) {
                        i = 1000;
                    }
                    try {
                        C1759s.m7260a(f6429a, "sendAllInboxMsgByUsingBulk(), sleep a little time ...  : properDelay(%d ms)", Integer.valueOf(i));
                        Thread.sleep(i);
                    } catch (InterruptedException e) {
                        if (C3250y.f11737e) {
                            C3250y.m11443a(e, f6429a);
                        }
                    }
                    chatONMsgEntity.m7136a();
                    if (!c1337o.m5877a(chatONMsgEntity, this.f6432d)) {
                        chatONMsgEntity.m7135a(EnumC1741aa.FAILED);
                        arrayList2.add(chatONMsgEntity.m7143e());
                    }
                    c1763w.f6495b++;
                } else if (m7190h() <= 0) {
                    chatONMsgEntity.m7136a();
                    arrayList.add(chatONMsgEntity);
                }
            }
        }
        int size2 = arrayList.size();
        if (size2 > 0) {
            c1763w.f6495b += arrayList.size();
            c1337o.m5845a(this.f6431c, strM5895d, this.f6432d, arrayList);
            m7172a(arrayList.get(size2 - 1).m7143e().longValue());
        }
        arrayList.clear();
        C1759s.m7260a(f6429a, "Request to send (%d/%d)", Integer.valueOf(c1763w.f6495b), Integer.valueOf(c1763w.f6494a));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            C1759s.m7260a(f6429a, "Remove INVALID MESSAGE : %s ", this.f6433e.remove(Long.valueOf(((Long) it.next()).longValue())));
        }
        return c1763w;
    }

    /* renamed from: i */
    public C1763w m7191i() throws InterruptedException {
        C1763w c1763wM7164b;
        C1759s.m7260a(f6429a, "sendAllInboxMsg()", new Object[0]);
        if (!m7187e()) {
            C1759s.m7260a(f6429a, "This inbox(%s) is NOT AVAILABLE", this.f6430b);
            return new C1763w(EnumC1762v.IS_NOT_VALID_ROOM);
        }
        if (this.f6433e != null && this.f6433e.size() <= 0) {
            C1759s.m7260a(f6429a, "This inbox(%s) has no msg", this.f6430b);
            return new C1763w(EnumC1762v.EMPTY_ROOM);
        }
        if (m7167l()) {
            C1759s.m7260a(f6429a, "This inbox(%s) is IN PROGRESS INIT-CHAT-REQUEST (msgId : %d). Hold ON !!", this.f6430b, Long.valueOf(m7185c()));
            m7192j();
            return new C1763w(EnumC1762v.REQ_INIT_CHAT);
        }
        if (m7166k()) {
            C1759s.m7260a(f6429a, "This inbox(%s) is IN PROGRESS ALLOW-CHAT-REQUEST (msgId : %d). Hold ON !!", this.f6430b, Long.valueOf(m7186d()));
            m7192j();
            return new C1763w(EnumC1762v.REQ_ALLOW_CHAT);
        }
        if (m7168m()) {
            C1759s.m7260a(f6429a, "This inbox(%s) is IN PROGRESS SERIAL-CHAT-REQUEST (msgId : %d). Hold ON !!", this.f6430b, Long.valueOf(m7190h()));
            m7192j();
            return new C1763w(EnumC1762v.REQ_SERIAL_CHAT_WAIT);
        }
        C1749i c1749iM7196b = C1749i.m7195a().m7196b();
        C1763w c1763w = new C1763w(EnumC1762v.NOTHING_TODO);
        c1763w.f6494a = this.f6433e.size();
        c1763w.f6495b = 0;
        C1337o c1337oM5795a = C1337o.m5795a(this.f6430b, this.f6431c);
        if (c1337oM5795a == null) {
            C1759s.m7260a(f6429a, "[ERROR !!] it's impossible to get MessageControl", new Object[0]);
            c1763w.f6496c = EnumC1762v.UNDETERMINED_STATUS;
            return c1763w;
        }
        C1759s.m7260a(f6429a, "(sendAllInboxMsg : %s)", this);
        C1759s.m7260a(f6429a, "(sendAllInboxMsg with TCP Context : %s)", c1337oM5795a.m5898f());
        boolean zM5908q = c1337oM5795a.m5908q();
        C1544ac c1544acM5898f = c1337oM5795a.m5898f();
        if (c1544acM5898f == null) {
            c1763w.f6496c = EnumC1762v.UNDETERMINED_STATUS;
            C3250y.m11442a("sendAllInboxMsg(), tcpContext is null, inbox is : " + this.f6430b, f6429a);
            return c1763w;
        }
        boolean z = (C1596x.m6753a(c1544acM5898f) || this.f6431c == EnumC1450r.BROADCAST) ? false : true;
        Set<Map.Entry<Long, ChatONMsgEntity>> setEntrySet = this.f6433e.entrySet();
        ArrayList arrayList = new ArrayList();
        if (zM5908q || z) {
            Iterator<Map.Entry<Long, ChatONMsgEntity>> it = setEntrySet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ChatONMsgEntity value = it.next().getValue();
                if (!value.m7141c()) {
                    C1759s.m7260a(f6429a, " Check to send (init/allow): (No need to resend msg) %s", value);
                } else {
                    C1759s.m7260a(f6429a, " Check to send (init/allow):  %s", value);
                    value.m7136a();
                    if (zM5908q) {
                        m7184b(true, value.m7143e().longValue());
                    } else {
                        m7173a(true, value.m7143e().longValue());
                    }
                    if (!c1337oM5795a.m5877a(value, this.f6432d)) {
                        if (zM5908q) {
                            m7184b(false, -1L);
                        } else {
                            m7173a(false, -1L);
                        }
                        value.m7135a(EnumC1741aa.FAILED);
                        arrayList.add(value.m7143e());
                    } else {
                        c1763w.f6495b++;
                        if (zM5908q) {
                            c1763w.f6496c = EnumC1762v.REQ_INIT_CHAT;
                        } else {
                            c1763w.f6496c = EnumC1762v.REQ_ALLOW_CHAT;
                        }
                    }
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                C1759s.m7260a(f6429a, "Remove INVALID MESSAGE : %s ", this.f6433e.remove(Long.valueOf(((Long) it2.next()).longValue())));
            }
            return c1763w;
        }
        if (this.f6430b != null && !C1103a.m5432a(GlobalApplication.m11493l()).m5458a(this.f6430b)) {
            c1337oM5795a.m5893c(SystemClock.elapsedRealtime() + 480000);
        }
        if (this.f6431c == EnumC1450r.BROADCAST) {
            c1763wM7164b = m7162a(c1337oM5795a, c1763w);
        } else {
            c1763wM7164b = m7164b(c1337oM5795a, c1763w);
        }
        if (c1763wM7164b.f6495b <= 0) {
            c1763wM7164b.f6496c = EnumC1762v.NOTHING_TODO;
        } else {
            c1763wM7164b.f6496c = EnumC1762v.REQ_SEND_SUCCESS_ALL;
        }
        c1749iM7196b.m7197c();
        C1759s.m7260a(f6429a, "elapsed in sending all messages : (%s)", c1749iM7196b);
        return c1763wM7164b;
    }

    /* renamed from: a */
    public boolean m7176a(long j, String str) {
        if (!m7187e()) {
            C1759s.m7260a(f6429a, "This inbox is NOT AVAILABLE", new Object[0]);
            return false;
        }
        ChatONMsgEntity chatONMsgEntity = this.f6433e.get(Long.valueOf(j));
        if (chatONMsgEntity == null) {
            C1759s.m7260a(f6429a, "not exist!!", new Object[0]);
            return false;
        }
        C1759s.m7260a(f6429a, "UpdateMsg() #1 [Current] : %s", chatONMsgEntity);
        C1759s.m7260a(f6429a, "UpdateMsg() #2 [Change New] : chatMsg(%s->%s)", chatONMsgEntity.m7145g(), str);
        chatONMsgEntity.m7137a(str);
        return true;
    }

    /* renamed from: a */
    public boolean m7175a(long j, EnumC1741aa enumC1741aa, String str, Integer num) {
        if (!m7187e()) {
            C1759s.m7260a(f6429a, "This inbox is NOT AVAILABLE", new Object[0]);
            return false;
        }
        ChatONMsgEntity chatONMsgEntity = this.f6433e.get(Long.valueOf(j));
        if (chatONMsgEntity == null) {
            C1759s.m7260a(f6429a, "not exist!!", new Object[0]);
            return false;
        }
        C1759s.m7260a(f6429a, "UpdateMsg() #1 [Current] : %s", chatONMsgEntity);
        C1759s.m7260a(f6429a, "UpdateMsg() #2 [Change New] : Status(%s->%s) / FormattedMsg (%s->%s) / IsFileUploaded (%d->%d)", chatONMsgEntity.m7150l(), enumC1741aa, chatONMsgEntity.m7148j(), str, Integer.valueOf(chatONMsgEntity.m7149k()), num);
        if (enumC1741aa != null && enumC1741aa != EnumC1741aa.UNKNOWN_STATUS) {
            chatONMsgEntity.m7135a(enumC1741aa);
            switch (C1744d.f6440a[enumC1741aa.ordinal()]) {
                case 3:
                    break;
                default:
                    chatONMsgEntity.m7138a(false);
                    break;
            }
        }
        if (str != null) {
            chatONMsgEntity.m7139b(str);
        }
        if (num != null && num.intValue() >= 0) {
            chatONMsgEntity.m7134a(num.intValue());
        }
        if (enumC1741aa == null || enumC1741aa != EnumC1741aa.SENDED) {
            return true;
        }
        chatONMsgEntity.m7140b();
        return m7182b(j) != null;
    }

    /* renamed from: b */
    public ChatONMsgEntity m7182b(long j) {
        if (!m7187e()) {
            C1759s.m7260a(f6429a, "This inbox is NOT AVAILABLE", new Object[0]);
            return null;
        }
        ChatONMsgEntity chatONMsgEntityRemove = this.f6433e.remove(Long.valueOf(j));
        C1759s.m7260a(f6429a, "REMOVE MSG (inboxNo(%s), requestMsgId(%d)) : remove result (%s)", this.f6430b, Long.valueOf(j), chatONMsgEntityRemove);
        return chatONMsgEntityRemove;
    }

    /* renamed from: a */
    public int m7169a(ArrayList<Integer> arrayList) {
        if (this.f6433e == null || this.f6433e.size() <= 0) {
            C1759s.m7260a(f6429a, "This inbox(%s) has no msg", this.f6430b);
            return -1;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        C1749i c1749iM7196b = C1749i.m7195a().m7196b();
        Iterator<Map.Entry<Long, ChatONMsgEntity>> it = this.f6433e.entrySet().iterator();
        ArrayList arrayList2 = new ArrayList();
        while (it.hasNext()) {
            ChatONMsgEntity value = it.next().getValue();
            if (!arrayList.contains(value.m7150l())) {
                arrayList2.add(value.m7143e());
            }
        }
        int size = arrayList2.size();
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            C1759s.m7260a(f6429a, "Remove Request MESSAGE : %s ", this.f6433e.remove(Long.valueOf(((Long) it2.next()).longValue())));
        }
        C1759s.m7260a(f6429a, "Remove Request MESSAGE result : total(%d), %s ", Integer.valueOf(size), c1749iM7196b.m7197c());
        return size;
    }

    /* renamed from: b */
    public int m7180b(ArrayList<Integer> arrayList) {
        if (this.f6433e == null || this.f6433e.size() <= 0) {
            C1759s.m7260a(f6429a, "This inbox(%s) has no msg", this.f6430b);
            return -1;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        C1749i c1749iM7196b = C1749i.m7195a().m7196b();
        Iterator<Map.Entry<Long, ChatONMsgEntity>> it = this.f6433e.entrySet().iterator();
        ArrayList arrayList2 = new ArrayList();
        while (it.hasNext()) {
            ChatONMsgEntity value = it.next().getValue();
            if (arrayList.contains(value.m7150l())) {
                arrayList2.add(value.m7143e());
            }
        }
        int size = arrayList2.size();
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            C1759s.m7260a(f6429a, "Remove Request MESSAGE : %s ", this.f6433e.remove(Long.valueOf(((Long) it2.next()).longValue())));
        }
        C1759s.m7260a(f6429a, "Remove Request MESSAGE result : total(%d), %s ", Integer.valueOf(size), c1749iM7196b.m7197c());
        return size;
    }

    /* renamed from: a */
    public int m7170a(ArrayList<Long> arrayList, ArrayList<Integer> arrayList2) {
        if (this.f6433e == null || this.f6433e.size() <= 0) {
            C1759s.m7260a(f6429a, "This inbox(%s) has no msg", this.f6430b);
            return -1;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        C1749i c1749iM7196b = C1749i.m7195a().m7196b();
        Iterator<Map.Entry<Long, ChatONMsgEntity>> it = this.f6433e.entrySet().iterator();
        ArrayList arrayList3 = new ArrayList();
        while (it.hasNext()) {
            ChatONMsgEntity value = it.next().getValue();
            if (!arrayList.contains(value.m7143e()) && arrayList2.contains(Integer.valueOf(value.m7150l().m7157a()))) {
                arrayList3.add(value.m7143e());
            }
        }
        int size = arrayList3.size();
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            C1759s.m7260a(f6429a, "Remove Request MESSAGE : %s ", this.f6433e.remove(Long.valueOf(((Long) it2.next()).longValue())));
        }
        C1759s.m7260a(f6429a, "Remove Request MESSAGE result : total(%d), %s ", Integer.valueOf(size), c1749iM7196b.m7197c());
        return size;
    }

    /* renamed from: b */
    public int m7181b(ArrayList<Long> arrayList, ArrayList<Integer> arrayList2) {
        int i = -1;
        if (this.f6433e == null || this.f6433e.size() <= 0) {
            C1759s.m7260a(f6429a, "This inbox(%s) has no msg", this.f6430b);
        } else if (arrayList != null && arrayList.size() > 0) {
            C1749i c1749iM7196b = C1749i.m7195a().m7196b();
            Iterator<Long> it = arrayList.iterator();
            i = 0;
            while (it.hasNext()) {
                long jLongValue = it.next().longValue();
                ChatONMsgEntity chatONMsgEntity = this.f6433e.get(Long.valueOf(jLongValue));
                if (chatONMsgEntity != null && arrayList2.contains(Integer.valueOf(chatONMsgEntity.m7150l().m7157a()))) {
                    ChatONMsgEntity chatONMsgEntityRemove = this.f6433e.remove(Long.valueOf(jLongValue));
                    C1759s.m7260a(f6429a, "Remove Request MESSAGE : %s ", chatONMsgEntityRemove);
                    if (chatONMsgEntityRemove != null) {
                        i++;
                    }
                }
                i = i;
            }
            C1759s.m7260a(f6429a, "Remove Request MESSAGE result : total(%d), %s ", Integer.valueOf(i), c1749iM7196b.m7197c());
        }
        return i;
    }

    /* renamed from: j */
    public void m7192j() {
        if (!m7187e()) {
            C1759s.m7260a(f6429a, "__print_all_msg(), This inbox is NOT AVAILABLE", new Object[0]);
            return;
        }
        Set<Map.Entry<Long, ChatONMsgEntity>> setEntrySet = this.f6433e.entrySet();
        Iterator<Map.Entry<Long, ChatONMsgEntity>> it = setEntrySet.iterator();
        C1759s.m7260a(f6429a, "----------- print all msg (%d msg)----------", Integer.valueOf(setEntrySet.size()));
        while (it.hasNext()) {
            C1759s.m7260a(f6429a, "%s", it.next().getValue());
        }
    }

    public String toString() {
        String strValueOf;
        String strValueOf2;
        if (!m7187e()) {
            strValueOf = "MsgEntity(null)";
        } else {
            strValueOf = String.valueOf(this.f6433e.size());
        }
        if (this.f6432d == null) {
            strValueOf2 = "null";
        } else {
            strValueOf2 = String.valueOf(this.f6432d.length);
        }
        return String.format("[Inbox] inboxNo(%s), chatType(%s), recv(%s), MsgEnitity(%s), inProgressInitChat(%d), inProgressAllowChat(%d, msgId(%d))", this.f6430b, this.f6431c, strValueOf2, strValueOf, Long.valueOf(this.f6435g), Long.valueOf(this.f6434f), Long.valueOf(this.f6437i));
    }
}
