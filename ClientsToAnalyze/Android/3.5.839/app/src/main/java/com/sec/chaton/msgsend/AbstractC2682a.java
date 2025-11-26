package com.sec.chaton.msgsend;

import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p057e.p058a.C2204r;
import com.sec.chaton.p067j.EnumC2468s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: BaseChatONChatRoomEntity.java */
/* renamed from: com.sec.chaton.msgsend.a */
/* loaded from: classes.dex */
public abstract class AbstractC2682a {

    /* renamed from: a */
    public static final String f9621a = AbstractC2682a.class.getSimpleName();

    /* renamed from: b */
    protected final String f9622b;

    /* renamed from: c */
    protected final EnumC2300t f9623c;

    /* renamed from: d */
    protected String[] f9624d;

    /* renamed from: e */
    protected final EnumC2301u f9625e;

    /* renamed from: f */
    protected LinkedHashMap<Long, ChatONMsgEntity> f9626f = new LinkedHashMap<>();

    /* renamed from: a */
    abstract C2688af mo11272a();

    /* renamed from: a */
    abstract EnumC2689ag mo11273a(EnumC2693ak enumC2693ak, EnumC2468s enumC2468s, long j);

    /* renamed from: a */
    abstract void mo11274a(long j);

    /* renamed from: a */
    abstract boolean mo11279a(String str, String str2, int i, long j);

    /* renamed from: a */
    static AbstractC2682a m11268a(EnumC2301u enumC2301u, String str, EnumC2300t enumC2300t, String[] strArr) {
        switch (C2694b.f9674a[enumC2301u.ordinal()]) {
            case 1:
                return new C2697e(enumC2301u, str, enumC2300t, strArr);
            case 2:
                return new C2702j(enumC2301u, str, enumC2300t, strArr);
            default:
                return null;
        }
    }

    AbstractC2682a(EnumC2301u enumC2301u, String str, EnumC2300t enumC2300t, String[] strArr) {
        this.f9625e = enumC2301u;
        this.f9622b = str;
        this.f9623c = enumC2300t;
        this.f9624d = strArr;
    }

    /* renamed from: b */
    protected boolean m11283b(long j) {
        ChatONMsgEntity chatONMsgEntity = this.f9626f.get(Long.valueOf(j));
        if (chatONMsgEntity == null) {
            return false;
        }
        if (chatONMsgEntity.m11267l() == EnumC2692aj.SENDING) {
            chatONMsgEntity.m11252a(EnumC2692aj.PENDING);
            C2204r.m9999a(GlobalApplication.m18732r().getContentResolver(), Long.valueOf(j));
        }
        return true;
    }

    /* renamed from: b */
    public EnumC2300t m11282b() {
        return this.f9623c;
    }

    /* renamed from: a */
    void m11275a(String[] strArr) {
        this.f9624d = strArr;
    }

    /* renamed from: c */
    void m11285c() {
        if (this.f9626f != null) {
            this.f9626f.clear();
            this.f9626f = null;
        }
        C2684ab.m11290a(f9621a, "release(), %s MSG all are released", this.f9622b);
    }

    /* renamed from: d */
    boolean m11286d() {
        return this.f9626f != null;
    }

    /* renamed from: b */
    private ChatONMsgEntity m11269b(ChatONMsgEntity chatONMsgEntity) {
        return this.f9626f.put(chatONMsgEntity.m11260e(), chatONMsgEntity);
    }

    /* renamed from: a */
    public boolean m11278a(ChatONMsgEntity chatONMsgEntity) {
        if (!m11286d()) {
            C2684ab.m11290a(f9621a, "This inbox is NOT AVAILABLE", new Object[0]);
            return false;
        }
        switch (C2694b.f9675b[chatONMsgEntity.m11267l().ordinal()]) {
            case 1:
            case 2:
                break;
            default:
                ChatONMsgEntity chatONMsgEntityM11269b = m11269b(chatONMsgEntity);
                C2684ab.m11290a(f9621a, "new msg entity %s ", chatONMsgEntity);
                if (chatONMsgEntityM11269b != null) {
                    C2684ab.m11290a(f9621a, "exist msg entity : %s ", chatONMsgEntityM11269b);
                    break;
                } else {
                    break;
                }
        }
        return false;
    }

    /* renamed from: a */
    public boolean m11277a(long j, String str) {
        if (!m11286d()) {
            C2684ab.m11290a(f9621a, "This inbox is NOT AVAILABLE", new Object[0]);
            return false;
        }
        ChatONMsgEntity chatONMsgEntity = this.f9626f.get(Long.valueOf(j));
        if (chatONMsgEntity == null) {
            C2684ab.m11290a(f9621a, "not exist!!", new Object[0]);
            return false;
        }
        C2684ab.m11290a(f9621a, "UpdateMsg() #1 [Current] : %s", chatONMsgEntity);
        C2684ab.m11290a(f9621a, "UpdateMsg() #2 [Change New] : chatMsg(%s->%s)", chatONMsgEntity.m11262g(), str);
        chatONMsgEntity.m11254a(str);
        return true;
    }

    /* renamed from: a */
    public boolean m11276a(long j, EnumC2692aj enumC2692aj, String str, Integer num) {
        if (!m11286d()) {
            C2684ab.m11290a(f9621a, "This inbox is NOT AVAILABLE", new Object[0]);
            return false;
        }
        ChatONMsgEntity chatONMsgEntity = this.f9626f.get(Long.valueOf(j));
        if (chatONMsgEntity == null) {
            C2684ab.m11290a(f9621a, "not exist!!", new Object[0]);
            return false;
        }
        C2684ab.m11290a(f9621a, "UpdateMsg() #1 [Current] : %s", chatONMsgEntity);
        C2684ab.m11290a(f9621a, "UpdateMsg() #2 [Change New] : Status(%s->%s) / FormattedMsg (%s->%s) / IsFileUploaded (%d->%d)", chatONMsgEntity.m11267l(), enumC2692aj, chatONMsgEntity.m11265j(), str, Integer.valueOf(chatONMsgEntity.m11266k()), num);
        if (enumC2692aj != null && enumC2692aj != EnumC2692aj.UNKNOWN_STATUS) {
            chatONMsgEntity.m11252a(enumC2692aj);
            switch (C2694b.f9675b[enumC2692aj.ordinal()]) {
                case 3:
                    break;
                default:
                    chatONMsgEntity.m11255a(false);
                    break;
            }
        }
        if (str != null) {
            chatONMsgEntity.m11256b(str);
        }
        if (num != null && num.intValue() >= 0) {
            chatONMsgEntity.m11251a(num.intValue());
        }
        if (enumC2692aj == null || enumC2692aj != EnumC2692aj.SENDED) {
            return true;
        }
        chatONMsgEntity.m11257b();
        return m11284c(j) != null;
    }

    /* renamed from: c */
    public ChatONMsgEntity m11284c(long j) {
        if (!m11286d()) {
            C2684ab.m11290a(f9621a, "This inbox is NOT AVAILABLE", new Object[0]);
            return null;
        }
        ChatONMsgEntity chatONMsgEntityRemove = this.f9626f.remove(Long.valueOf(j));
        C2684ab.m11290a(f9621a, "REMOVE MSG (inboxNo(%s), requestMsgId(%d)) : remove result (%s)", this.f9622b, Long.valueOf(j), chatONMsgEntityRemove);
        return chatONMsgEntityRemove;
    }

    /* renamed from: a */
    public int m11270a(ArrayList<Integer> arrayList) {
        if (this.f9626f == null || this.f9626f.size() <= 0) {
            C2684ab.m11290a(f9621a, "This inbox(%s) has no msg", this.f9622b);
            return -1;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        C2704l c2704lM11323b = C2704l.m11322a().m11323b();
        Iterator<Map.Entry<Long, ChatONMsgEntity>> it = this.f9626f.entrySet().iterator();
        ArrayList arrayList2 = new ArrayList();
        while (it.hasNext()) {
            ChatONMsgEntity value = it.next().getValue();
            if (!arrayList.contains(value.m11267l())) {
                arrayList2.add(value.m11260e());
            }
        }
        int size = arrayList2.size();
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            C2684ab.m11290a(f9621a, "Remove Request MESSAGE : %s ", this.f9626f.remove(Long.valueOf(((Long) it2.next()).longValue())));
        }
        C2684ab.m11290a(f9621a, "Remove Request MESSAGE result : total(%d), %s ", Integer.valueOf(size), c2704lM11323b.m11324c());
        return size;
    }

    /* renamed from: b */
    public int m11280b(ArrayList<Integer> arrayList) {
        if (this.f9626f == null || this.f9626f.size() <= 0) {
            C2684ab.m11290a(f9621a, "This inbox(%s) has no msg", this.f9622b);
            return -1;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        C2704l c2704lM11323b = C2704l.m11322a().m11323b();
        Iterator<Map.Entry<Long, ChatONMsgEntity>> it = this.f9626f.entrySet().iterator();
        ArrayList arrayList2 = new ArrayList();
        while (it.hasNext()) {
            ChatONMsgEntity value = it.next().getValue();
            if (arrayList.contains(value.m11267l())) {
                arrayList2.add(value.m11260e());
            }
        }
        int size = arrayList2.size();
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            C2684ab.m11290a(f9621a, "Remove Request MESSAGE : %s ", this.f9626f.remove(Long.valueOf(((Long) it2.next()).longValue())));
        }
        C2684ab.m11290a(f9621a, "Remove Request MESSAGE result : total(%d), %s ", Integer.valueOf(size), c2704lM11323b.m11324c());
        return size;
    }

    /* renamed from: a */
    public int m11271a(ArrayList<Long> arrayList, ArrayList<Integer> arrayList2) {
        if (this.f9626f == null || this.f9626f.size() <= 0) {
            C2684ab.m11290a(f9621a, "This inbox(%s) has no msg", this.f9622b);
            return -1;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        C2704l c2704lM11323b = C2704l.m11322a().m11323b();
        Iterator<Map.Entry<Long, ChatONMsgEntity>> it = this.f9626f.entrySet().iterator();
        ArrayList arrayList3 = new ArrayList();
        while (it.hasNext()) {
            ChatONMsgEntity value = it.next().getValue();
            if (!arrayList.contains(value.m11260e()) && arrayList2.contains(Integer.valueOf(value.m11267l().m11302a()))) {
                arrayList3.add(value.m11260e());
            }
        }
        int size = arrayList3.size();
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            C2684ab.m11290a(f9621a, "Remove Request MESSAGE : %s ", this.f9626f.remove(Long.valueOf(((Long) it2.next()).longValue())));
        }
        C2684ab.m11290a(f9621a, "Remove Request MESSAGE result : total(%d), %s ", Integer.valueOf(size), c2704lM11323b.m11324c());
        return size;
    }

    /* renamed from: b */
    public int m11281b(ArrayList<Long> arrayList, ArrayList<Integer> arrayList2) {
        int i = -1;
        if (this.f9626f == null || this.f9626f.size() <= 0) {
            C2684ab.m11290a(f9621a, "This inbox(%s) has no msg", this.f9622b);
        } else if (arrayList != null && arrayList.size() > 0) {
            C2704l c2704lM11323b = C2704l.m11322a().m11323b();
            Iterator<Long> it = arrayList.iterator();
            i = 0;
            while (it.hasNext()) {
                long jLongValue = it.next().longValue();
                ChatONMsgEntity chatONMsgEntity = this.f9626f.get(Long.valueOf(jLongValue));
                if (chatONMsgEntity != null && arrayList2.contains(Integer.valueOf(chatONMsgEntity.m11267l().m11302a()))) {
                    ChatONMsgEntity chatONMsgEntityRemove = this.f9626f.remove(Long.valueOf(jLongValue));
                    C2684ab.m11290a(f9621a, "Remove Request MESSAGE : %s ", chatONMsgEntityRemove);
                    if (chatONMsgEntityRemove != null) {
                        i++;
                    }
                }
                i = i;
            }
            C2684ab.m11290a(f9621a, "Remove Request MESSAGE result : total(%d), %s ", Integer.valueOf(i), c2704lM11323b.m11324c());
        }
        return i;
    }

    /* renamed from: e */
    public void m11287e() {
        if (!m11286d()) {
            C2684ab.m11290a(f9621a, "__print_all_msg(), This inbox is NOT AVAILABLE", new Object[0]);
            return;
        }
        Set<Map.Entry<Long, ChatONMsgEntity>> setEntrySet = this.f9626f.entrySet();
        Iterator<Map.Entry<Long, ChatONMsgEntity>> it = setEntrySet.iterator();
        C2684ab.m11290a(f9621a, "----------- print all msg (%d msg)----------", Integer.valueOf(setEntrySet.size()));
        while (it.hasNext()) {
            C2684ab.m11290a(f9621a, "%s", it.next().getValue());
        }
    }

    public String toString() {
        String strValueOf;
        String strValueOf2;
        if (!m11286d()) {
            strValueOf = "MsgEntity(null)";
        } else {
            strValueOf = String.valueOf(this.f9626f.size());
        }
        if (this.f9624d == null) {
            strValueOf2 = "null";
        } else {
            strValueOf2 = String.valueOf(this.f9624d.length);
        }
        return String.format("[Inbox] roomType(%s), inboxNo(%s), chatType(%s), recv(%s), MsgEnitity(%s), ", this.f9625e, this.f9622b, this.f9623c, strValueOf2, strValueOf);
    }
}
