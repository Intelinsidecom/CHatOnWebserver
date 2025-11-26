package com.sec.chaton.msgsend;

import android.database.Cursor;
import android.os.SystemClock;
import android.text.TextUtils;
import com.sec.chaton.chat.notification.C1813b;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p055d.C2142w;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p067j.C2417af;
import com.sec.chaton.p067j.C2422ak;
import com.sec.chaton.p067j.EnumC2468s;
import com.sec.chaton.util.C4844bi;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: ChatONNormalChatRoomEntity.java */
/* renamed from: com.sec.chaton.msgsend.j */
/* loaded from: classes.dex */
public class C2702j extends AbstractC2682a {

    /* renamed from: g */
    public static final String f9684g = C2702j.class.getSimpleName();

    /* renamed from: h */
    C2711s f9685h;

    C2702j(EnumC2301u enumC2301u, String str, EnumC2300t enumC2300t, String[] strArr) {
        super(enumC2301u, str, enumC2300t, strArr);
        this.f9685h = new C2711s();
    }

    /* renamed from: b */
    private boolean m11319b(String str, String str2, int i, long j) {
        C2142w c2142wM9593a = C2142w.m9593a(this.f9622b, this.f9623c);
        C2684ab.m11290a(f9684g, "setReadyMessageControl(), (requested) in inbox(%s): sessionId(%s), serverIp(%s), serverPort(%d)", this.f9622b, str, str2, Integer.valueOf(i));
        c2142wM9593a.m9646b(str);
        c2142wM9593a.m9647c(j);
        C2422ak c2422akM9652j = c2142wM9593a.m9652j();
        if (!m11320a(c2422akM9652j)) {
            C2684ab.m11290a(f9684g, "setReadyMessageControl(), (Last result) #1 has valid TcpContext already (%s)", c2422akM9652j);
            return true;
        }
        if (!TextUtils.isEmpty(str2) && i > 0) {
            c2142wM9593a.mo9252a(this.f9622b, str2, i);
            c2142wM9593a.mo9243a(SystemClock.elapsedRealtime() + 300000);
            C2684ab.m11290a(f9684g, "setReadyMessageControl(), (Last result) #2 set by using params, serverIp(%s), serverPot(%d)", str2, Integer.valueOf(i));
            return true;
        }
        Cursor cursorQuery = GlobalApplication.m18732r().getContentResolver().query(C2299s.f8209a, new String[]{"inbox_server_ip", "inbox_server_port"}, "inbox_no=?", new String[]{this.f9622b}, null);
        if (cursorQuery != null) {
            cursorQuery.moveToFirst();
            str2 = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_server_ip"));
            i = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_server_port"));
            cursorQuery.close();
        }
        if (!TextUtils.isEmpty(str2) && i > 0) {
            C2684ab.m11290a(f9684g, "setReadyMessageControl(), (ongoing result) #3 set by using DB value, serverIp(%s), serverPot(%d)", str2, Integer.valueOf(i));
        } else {
            str2 = C4844bi.m18323a().m18328c().m18329a();
            i = C4844bi.m18323a().m18328c().m18332b();
            if (!TextUtils.isEmpty(str2) && i > 0) {
                C2684ab.m11290a(f9684g, "setReadyMessageControl(), (ongoing result) #4 set by using GLD value, serverIp(%s), serverPot(%d)", str2, Integer.valueOf(i));
            } else {
                C2684ab.m11290a(f9684g, "[ERROR] setReadyMessageControl(), (Last Result) Nothing to use even GLD", new Object[0]);
                return false;
            }
        }
        c2142wM9593a.mo9252a(this.f9622b, str2, i);
        c2142wM9593a.mo9243a(SystemClock.elapsedRealtime() + 300000);
        C2684ab.m11290a(f9684g, "SET READY Message Control, (Last Result) in inbox(%s): new TcpContext (%s) ", this.f9622b, c2142wM9593a.m9652j());
        return true;
    }

    /* renamed from: a */
    boolean m11320a(C2422ak c2422ak) {
        if (c2422ak == null) {
            return true;
        }
        return TextUtils.isEmpty(c2422ak.m10493d()) && c2422ak.m10494e() > 0;
    }

    /* renamed from: a */
    private C2688af m11315a(C2142w c2142w, C2688af c2688af) throws InterruptedException {
        C2684ab.m11290a(f9684g, "sendAllInboxMsgByUnit()", new Object[0]);
        Iterator<Map.Entry<Long, ChatONMsgEntity>> it = this.f9626f.entrySet().iterator();
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            ChatONMsgEntity value = it.next().getValue();
            if (!value.m11258c()) {
                C2684ab.m11290a(f9684g, " Check to send (One Unit): (No need to resend msg) %s", value);
            } else {
                C2684ab.m11290a(f9684g, " Check to send (One Unit): %s", value);
                try {
                    Thread.sleep(50L);
                } catch (InterruptedException e) {
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e, f9684g);
                    }
                }
                if (c2142w.m9249a(value, this.f9624d)) {
                    value.m11253a();
                } else {
                    value.m11252a(EnumC2692aj.FAILED);
                    arrayList.add(value.m11260e());
                }
                c2688af.f9645b++;
            }
        }
        C2684ab.m11290a(f9684g, "Request to send (%d/%d)", Integer.valueOf(c2688af.f9645b), Integer.valueOf(c2688af.f9644a));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            C2684ab.m11290a(f9684g, "Remove INVALID MESSAGE : %s ", this.f9626f.remove(Long.valueOf(((Long) it2.next()).longValue())));
        }
        return c2688af;
    }

    /* renamed from: b */
    private C2688af m11317b(C2142w c2142w, C2688af c2688af) throws InterruptedException {
        C2684ab.m11290a(f9684g, "sendAllInboxMsgByUsingBulk()", new Object[0]);
        Set<Map.Entry<Long, ChatONMsgEntity>> setEntrySet = this.f9626f.entrySet();
        String strM9650h = c2142w.m9650h();
        Object[] array = setEntrySet.toArray();
        ArrayList<ChatONMsgEntity> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : array) {
            ChatONMsgEntity chatONMsgEntity = (ChatONMsgEntity) ((Map.Entry) obj).getValue();
            if (!chatONMsgEntity.m11258c()) {
                C2684ab.m11290a(f9684g, " Check to send (Bulk check): (No need to resend msg) %s", chatONMsgEntity);
            } else {
                C2684ab.m11290a(f9684g, " Check to send (Bulk check): %s", chatONMsgEntity);
                if (chatONMsgEntity.m11261f() == EnumC2214ab.TEXT) {
                    if (this.f9685h.m11357c(EnumC2714v.RELEASE_SERIALCHAT).m11363e() == EnumC2715w.REQUEST_IDLE) {
                        chatONMsgEntity.m11253a();
                        arrayList.add(chatONMsgEntity);
                    }
                } else {
                    int size = arrayList.size();
                    if (size > 0) {
                        c2688af.f9645b += size;
                        c2142w.m9622a(this.f9623c, strM9650h, this.f9624d, arrayList);
                        this.f9685h.m11355a(EnumC2714v.RELEASE_SERIALCHAT, arrayList.get(size - 1).m11260e().longValue());
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
                        C2684ab.m11290a(f9684g, "sendAllInboxMsgByUsingBulk(), sleep a little time ...  : properDelay(%d ms)", Integer.valueOf(i));
                        Thread.sleep(i);
                    } catch (InterruptedException e) {
                        if (C4904y.f17875e) {
                            C4904y.m18635a(e, f9684g);
                        }
                    }
                    chatONMsgEntity.m11253a();
                    if (!c2142w.m9249a(chatONMsgEntity, this.f9624d)) {
                        chatONMsgEntity.m11252a(EnumC2692aj.FAILED);
                        arrayList2.add(chatONMsgEntity.m11260e());
                    }
                    c2688af.f9645b++;
                }
            }
        }
        int size2 = arrayList.size();
        if (size2 > 0) {
            c2688af.f9645b += arrayList.size();
            c2142w.m9622a(this.f9623c, strM9650h, this.f9624d, arrayList);
            this.f9685h.m11355a(EnumC2714v.RELEASE_SERIALCHAT, arrayList.get(size2 - 1).m11260e().longValue());
        }
        arrayList.clear();
        C2684ab.m11290a(f9684g, "Request to send (%d/%d)", Integer.valueOf(c2688af.f9645b), Integer.valueOf(c2688af.f9644a));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            C2684ab.m11290a(f9684g, "Remove INVALID MESSAGE : %s ", this.f9626f.remove(Long.valueOf(((Long) it.next()).longValue())));
        }
        return c2688af;
    }

    /* renamed from: f */
    EnumC2715w m11321f() {
        EnumC2715w enumC2715wM11363e = this.f9685h.m11357c(EnumC2714v.RELEASE_INITCHAT).m11363e();
        switch (C2703k.f9686a[enumC2715wM11363e.ordinal()]) {
            case 1:
            case 2:
                return enumC2715wM11363e;
            default:
                EnumC2715w enumC2715wM11363e2 = this.f9685h.m11357c(EnumC2714v.RELEASE_ALLOWCHAT).m11363e();
                switch (C2703k.f9686a[enumC2715wM11363e2.ordinal()]) {
                    case 1:
                    case 2:
                        return enumC2715wM11363e2;
                    default:
                        EnumC2715w enumC2715wM11363e3 = this.f9685h.m11357c(EnumC2714v.RELEASE_SERIALCHAT).m11363e();
                        switch (C2703k.f9686a[enumC2715wM11363e3.ordinal()]) {
                            case 1:
                            case 2:
                                return enumC2715wM11363e3;
                            default:
                                return EnumC2715w.REQUEST_IDLE;
                        }
                }
        }
    }

    @Override // com.sec.chaton.msgsend.AbstractC2682a
    /* renamed from: a */
    C2688af mo11272a() throws InterruptedException {
        C2688af c2688afM11317b;
        C2684ab.m11290a(f9684g, "sendAllInboxMsg() is called", new Object[0]);
        if (!m11286d()) {
            C2684ab.m11290a(f9684g, "This inbox(%s) is NOT AVAILABLE", this.f9622b);
            return new C2688af(EnumC2687ae.IS_NOT_VALID_ROOM);
        }
        if (this.f9626f != null && this.f9626f.size() <= 0) {
            C2684ab.m11290a(f9684g, "This inbox(%s) has no msg", this.f9622b);
            return new C2688af(EnumC2687ae.EMPTY_ROOM);
        }
        switch (C2703k.f9686a[m11321f().ordinal()]) {
            case 1:
                return new C2688af(EnumC2687ae.REQ_PREVIOUS_IN_PROGRESS);
            case 2:
                Iterator<Long> it = this.f9685h.m11353a().iterator();
                while (it.hasNext()) {
                    m11283b(it.next().longValue());
                }
                break;
        }
        C2704l c2704lM11323b = C2704l.m11322a().m11323b();
        C2688af c2688af = new C2688af(EnumC2687ae.NOTHING_TODO);
        c2688af.f9644a = this.f9626f.size();
        c2688af.f9645b = 0;
        C2142w c2142wM9593a = C2142w.m9593a(this.f9622b, this.f9623c);
        if (c2142wM9593a == null) {
            C2684ab.m11290a(f9684g, "[ERROR !!] it's impossible to get MessageControl", new Object[0]);
            c2688af.f9646c = EnumC2687ae.UNDETERMINED_STATUS;
            return c2688af;
        }
        C2684ab.m11290a(f9684g, "sendAllInboxMsg(room info): %s", this);
        C2684ab.m11290a(f9684g, "sendAllInboxMsg(tcp context info): %s", c2142wM9593a.m9652j());
        boolean zM9658q = c2142wM9593a.m9658q();
        C2422ak c2422akM9652j = c2142wM9593a.m9652j();
        if (c2422akM9652j == null) {
            c2688af.f9646c = EnumC2687ae.UNDETERMINED_STATUS;
            C4904y.m18634a("sendAllInboxMsg(), tcpContext is null, inbox is : " + this.f9622b, f9684g);
            return c2688af;
        }
        boolean z = (C2417af.m10450a(c2422akM9652j) || this.f9623c == EnumC2300t.BROADCAST) ? false : true;
        Set<Map.Entry<Long, ChatONMsgEntity>> setEntrySet = this.f9626f.entrySet();
        ArrayList arrayList = new ArrayList();
        if (zM9658q || z) {
            Iterator<Map.Entry<Long, ChatONMsgEntity>> it2 = setEntrySet.iterator();
            while (true) {
                if (it2.hasNext()) {
                    ChatONMsgEntity value = it2.next().getValue();
                    if (!value.m11258c()) {
                        C2684ab.m11290a(f9684g, " Check to send (init/allow): (No need to resend msg) %s", value);
                    } else {
                        C2684ab.m11290a(f9684g, " Check to send (init/allow):  %s", value);
                        value.m11253a();
                        if (zM9658q) {
                            this.f9685h.m11355a(EnumC2714v.RELEASE_INITCHAT, value.m11260e().longValue());
                        } else {
                            this.f9685h.m11355a(EnumC2714v.RELEASE_ALLOWCHAT, value.m11260e().longValue());
                        }
                        if (!c2142wM9593a.m9249a(value, this.f9624d)) {
                            if (zM9658q) {
                                this.f9685h.m11354a(EnumC2714v.RELEASE_INITCHAT);
                            } else {
                                this.f9685h.m11354a(EnumC2714v.RELEASE_ALLOWCHAT);
                            }
                            value.m11252a(EnumC2692aj.FAILED);
                            arrayList.add(value.m11260e());
                        } else {
                            c2688af.f9645b++;
                            if (zM9658q) {
                                c2688af.f9646c = EnumC2687ae.REQ_INIT_CHAT;
                            } else {
                                c2688af.f9646c = EnumC2687ae.REQ_ALLOW_CHAT;
                            }
                        }
                    }
                }
            }
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                C2684ab.m11290a(f9684g, "Remove INVALID MESSAGE : %s ", this.f9626f.remove(Long.valueOf(((Long) it3.next()).longValue())));
            }
            return c2688af;
        }
        if (this.f9622b != null && !C1813b.m8906b().m8931a(this.f9622b)) {
            c2142wM9593a.mo9243a(SystemClock.elapsedRealtime() + 300000);
        }
        if (this.f9623c == EnumC2300t.BROADCAST) {
            c2688afM11317b = m11315a(c2142wM9593a, c2688af);
        } else {
            c2688afM11317b = m11317b(c2142wM9593a, c2688af);
        }
        if (c2688afM11317b.f9645b <= 0) {
            c2688afM11317b.f9646c = EnumC2687ae.NOTHING_TODO;
        } else {
            c2688afM11317b.f9646c = EnumC2687ae.REQ_SEND_SUCCESS_ALL;
        }
        c2704lM11323b.m11324c();
        C2684ab.m11290a(f9684g, "elapsed in sending all messages : (%s)", c2704lM11323b);
        return c2688afM11317b;
    }

    @Override // com.sec.chaton.msgsend.AbstractC2682a
    public String toString() {
        String str;
        String str2;
        if (!m11286d()) {
            str = "(not available msg entity)";
        } else {
            str = "queue count: " + this.f9626f.size();
        }
        if (this.f9624d == null) {
            str2 = "(null)";
        } else {
            str2 = "receiver count: " + this.f9624d.length;
        }
        return "[ChatRoomEntity]" + str + ", receiver count: " + str2 + ", inboxNo: " + this.f9622b + ", chatType: " + this.f9623c + ", block manager info: " + this.f9685h;
    }

    @Override // com.sec.chaton.msgsend.AbstractC2682a
    /* renamed from: a */
    boolean mo11279a(String str, String str2, int i, long j) {
        return m11319b(str, str2, i, j);
    }

    @Override // com.sec.chaton.msgsend.AbstractC2682a
    /* renamed from: a */
    EnumC2689ag mo11273a(EnumC2693ak enumC2693ak, EnumC2468s enumC2468s, long j) {
        EnumC2689ag enumC2689ag = EnumC2689ag.UNDETERMINED;
        if (enumC2693ak != EnumC2693ak.SEND_TYPE_ALLOW_CHAT) {
            if (enumC2693ak == EnumC2693ak.SEND_TYPE_CHAT_REQUEST) {
                return m11316a(enumC2468s, j);
            }
            if (enumC2693ak == EnumC2693ak.SEND_TYPE_INIT_CHAT) {
                return m11318b(enumC2468s, j);
            }
            return enumC2689ag;
        }
        return enumC2689ag;
    }

    /* renamed from: a */
    private EnumC2689ag m11316a(EnumC2468s enumC2468s, long j) {
        EnumC2714v enumC2714vM11352a = this.f9685h.m11352a(j);
        C2684ab.m11290a(f9684g, "updateChatRequest(), result(%s), incoming(%d)", enumC2714vM11352a, Long.valueOf(j));
        EnumC2689ag enumC2689ag = EnumC2689ag.UNDETERMINED;
        switch (C2703k.f9687b[enumC2468s.ordinal()]) {
            case 1:
                m11276a(j, EnumC2692aj.FAILED, (String) null, (Integer) null);
                if (enumC2714vM11352a.m11367a(EnumC2714v.RELEASE_ALLOWCHAT)) {
                    return EnumC2689ag.REASON_LATEST_ALLOW_CHAT_FAIL;
                }
                return EnumC2689ag.REASON_LATEST_SENT_MSG_FAIL;
            case 2:
            case 3:
                m11276a(j, EnumC2692aj.PENDING, (String) null, (Integer) null);
                if (enumC2714vM11352a.m11367a(EnumC2714v.RELEASE_ALLOWCHAT)) {
                    return EnumC2689ag.REASON_LATEST_ALLOW_CHAT_FAIL;
                }
                return EnumC2689ag.REASON_LATEST_SENT_MSG_FAIL;
            case 4:
            case 5:
                m11276a(j, EnumC2692aj.SENDED, (String) null, (Integer) null);
                if (enumC2714vM11352a.m11367a(EnumC2714v.RELEASE_ALLOWCHAT)) {
                    return EnumC2689ag.REASON_LATEST_ALLOW_CHAT_SUCCESS;
                }
                if (enumC2714vM11352a.m11367a(EnumC2714v.RELEASE_SERIALCHAT)) {
                    return EnumC2689ag.REASON_LATEST_SENT_MSG_SUCCESS;
                }
                break;
        }
        return enumC2689ag;
    }

    /* renamed from: b */
    private EnumC2689ag m11318b(EnumC2468s enumC2468s, long j) {
        EnumC2300t enumC2300tB = m11282b();
        C2684ab.m11290a(f9684g, "updateInitChat(), result(%s), incoming(%d)", this.f9685h.m11352a(j), Long.valueOf(j));
        EnumC2689ag enumC2689ag = EnumC2689ag.UNDETERMINED;
        switch (C2703k.f9687b[enumC2468s.ordinal()]) {
            case 1:
                m11276a(j, EnumC2692aj.FAILED, (String) null, (Integer) null);
                break;
            case 2:
            case 3:
            default:
                m11276a(j, EnumC2692aj.PENDING, (String) null, (Integer) null);
                break;
            case 4:
            case 5:
                m11276a(j, EnumC2692aj.SENDED, (String) null, (Integer) null);
                if (enumC2300tB == EnumC2300t.BROADCAST) {
                    break;
                } else {
                    break;
                }
        }
        return EnumC2689ag.REASON_LATEST_INIT_CHAT_FAIL;
    }

    @Override // com.sec.chaton.msgsend.AbstractC2682a
    /* renamed from: a */
    void mo11274a(long j) {
        C2684ab.m11290a(f9684g, "setFileUploadResult(), result(%s), incoming(%d)", this.f9685h.m11352a(j), Long.valueOf(j));
    }
}
