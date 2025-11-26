package com.sec.chaton.chat.notification;

import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: MessageDataManager.java */
/* renamed from: com.sec.chaton.chat.notification.q */
/* loaded from: classes.dex */
public class C1828q {

    /* renamed from: a */
    public static String f6913a = "event_inbox_unreadcount_change";

    /* renamed from: b */
    public static int f6914b = 0;

    /* renamed from: c */
    public static int f6915c = 1;

    /* renamed from: d */
    public static int f6916d = 2;

    /* renamed from: j */
    private static C1828q f6917j;

    /* renamed from: f */
    private HashMap<String, C1832u> f6919f;

    /* renamed from: g */
    private ArrayList<C1831t> f6920g;

    /* renamed from: h */
    private ArrayList<C1830s> f6921h;

    /* renamed from: n */
    private InterfaceC1829r f6926n;

    /* renamed from: e */
    private final String f6918e = getClass().getSimpleName();

    /* renamed from: i */
    private int f6922i = 0;

    /* renamed from: k */
    private final ReentrantReadWriteLock f6923k = new ReentrantReadWriteLock();

    /* renamed from: l */
    private final Lock f6924l = this.f6923k.readLock();

    /* renamed from: m */
    private final Lock f6925m = this.f6923k.writeLock();

    private C1828q() {
        m8970b();
    }

    /* renamed from: a */
    public static synchronized C1828q m8956a() {
        if (f6917j == null) {
            f6917j = new C1828q();
        }
        return f6917j;
    }

    /* renamed from: b */
    public void m8970b() {
        this.f6925m.lock();
        try {
            if (this.f6919f == null) {
                this.f6919f = new HashMap<>();
            }
            if (this.f6921h == null) {
                this.f6921h = new ArrayList<>();
            }
            if (this.f6920g == null) {
                this.f6920g = new ArrayList<>();
            }
            this.f6919f.clear();
            this.f6921h.clear();
            this.f6920g.clear();
            this.f6922i = 0;
        } finally {
            this.f6925m.unlock();
        }
    }

    /* renamed from: a */
    private int m8955a(String str, String str2) {
        int i;
        int i2 = -1;
        this.f6924l.lock();
        int i3 = 0;
        while (i3 < this.f6920g.size()) {
            try {
                if (str.equals(this.f6920g.get(i3).f6944a)) {
                    i = i2;
                    for (int i4 = 0; i4 < this.f6920g.size(); i4++) {
                        if (str2.equals(this.f6920g.get(i4))) {
                            i = i4;
                        }
                    }
                } else {
                    i = i2;
                }
                i3++;
                i2 = i;
            } finally {
                this.f6924l.unlock();
            }
        }
        return i2;
    }

    /* renamed from: a */
    public boolean m8964a(long j) {
        boolean z;
        this.f6925m.lock();
        int i = 0;
        while (true) {
            try {
                if (i >= this.f6921h.size()) {
                    z = false;
                    break;
                }
                if (this.f6921h.get(i).f6940n != j) {
                    i++;
                } else {
                    this.f6921h.remove(i);
                    if (C4904y.f17873c) {
                        C4904y.m18641c("[deleteMessageFromMsgList] remove msgID:" + j, this.f6918e);
                    }
                    z = true;
                }
            } finally {
                this.f6925m.unlock();
            }
        }
        if (z) {
            m8957a(this.f6921h, false);
            if (this.f6926n != null) {
                this.f6926n.mo8880b(this.f6922i);
            }
        }
        return z;
    }

    /* renamed from: a */
    public boolean m8965a(C1830s c1830s) {
        boolean z;
        this.f6925m.lock();
        try {
            this.f6919f.put(c1830s.f6931e, new C1832u(this, c1830s.f6936j, c1830s.f6937k, c1830s.f6935i, c1830s.f6934h, c1830s.f6938l));
            int iM8955a = m8955a(c1830s.f6927a, c1830s.f6931e);
            if (iM8955a >= 0) {
                this.f6920g.remove(iM8955a);
            }
            this.f6920g.add(0, new C1831t(this, c1830s.f6927a, c1830s.f6928b, c1830s.f6931e));
            int i = 0;
            while (true) {
                if (i >= this.f6922i) {
                    z = false;
                    break;
                }
                if (this.f6921h.get(i).f6940n != c1830s.f6940n) {
                    i++;
                } else {
                    this.f6921h.set(i, c1830s);
                    if (C4904y.f17873c) {
                        C4904y.m18641c("MsgID has already exist: " + c1830s.f6940n, this.f6918e);
                    }
                    z = true;
                }
            }
            if (!z) {
                this.f6921h.add(0, c1830s);
                this.f6922i = this.f6921h.size();
                if (this.f6926n != null) {
                    this.f6926n.mo8877a(this.f6922i);
                }
            }
            return z;
        } finally {
            this.f6925m.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00e1  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m8963a(java.lang.String r7, boolean r8, boolean r9) {
        /*
            r6 = this;
            r2 = 0
            java.util.concurrent.locks.Lock r0 = r6.f6925m
            r0.lock()
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lda
            r4.<init>()     // Catch: java.lang.Throwable -> Lda
            r3 = r2
            r1 = r2
        Ld:
            java.util.ArrayList<com.sec.chaton.chat.notification.s> r0 = r6.f6921h     // Catch: java.lang.Throwable -> Lda
            int r0 = r0.size()     // Catch: java.lang.Throwable -> Lda
            if (r3 >= r0) goto L74
            java.util.ArrayList<com.sec.chaton.chat.notification.s> r0 = r6.f6921h     // Catch: java.lang.Throwable -> Lda
            java.lang.Object r0 = r0.get(r3)     // Catch: java.lang.Throwable -> Lda
            com.sec.chaton.chat.notification.s r0 = (com.sec.chaton.chat.notification.C1830s) r0     // Catch: java.lang.Throwable -> Lda
            java.lang.String r0 = r0.f6931e     // Catch: java.lang.Throwable -> Lda
            boolean r0 = r7.equals(r0)     // Catch: java.lang.Throwable -> Lda
            if (r0 != 0) goto L34
            java.util.ArrayList<com.sec.chaton.chat.notification.s> r0 = r6.f6921h     // Catch: java.lang.Throwable -> Lda
            java.lang.Object r0 = r0.get(r3)     // Catch: java.lang.Throwable -> Lda
            r4.add(r0)     // Catch: java.lang.Throwable -> Lda
            r0 = r1
        L2f:
            int r1 = r3 + 1
            r3 = r1
            r1 = r0
            goto Ld
        L34:
            if (r8 != 0) goto Le1
            if (r9 == 0) goto L56
            java.util.ArrayList<com.sec.chaton.chat.notification.s> r0 = r6.f6921h     // Catch: java.lang.Throwable -> Lda
            java.lang.Object r0 = r0.get(r3)     // Catch: java.lang.Throwable -> Lda
            com.sec.chaton.chat.notification.s r0 = (com.sec.chaton.chat.notification.C1830s) r0     // Catch: java.lang.Throwable -> Lda
            int r0 = r0.f6933g     // Catch: java.lang.Throwable -> Lda
            com.sec.chaton.e.ab r5 = com.sec.chaton.p057e.EnumC2214ab.LIVECONTENTS     // Catch: java.lang.Throwable -> Lda
            int r5 = r5.m10076a()     // Catch: java.lang.Throwable -> Lda
            if (r0 == r5) goto Le1
            java.util.ArrayList<com.sec.chaton.chat.notification.s> r0 = r6.f6921h     // Catch: java.lang.Throwable -> Lda
            java.lang.Object r0 = r0.get(r3)     // Catch: java.lang.Throwable -> Lda
            r4.add(r0)     // Catch: java.lang.Throwable -> Lda
            int r0 = r1 + 1
            goto L2f
        L56:
            java.util.ArrayList<com.sec.chaton.chat.notification.s> r0 = r6.f6921h     // Catch: java.lang.Throwable -> Lda
            java.lang.Object r0 = r0.get(r3)     // Catch: java.lang.Throwable -> Lda
            com.sec.chaton.chat.notification.s r0 = (com.sec.chaton.chat.notification.C1830s) r0     // Catch: java.lang.Throwable -> Lda
            int r0 = r0.f6933g     // Catch: java.lang.Throwable -> Lda
            com.sec.chaton.e.ab r5 = com.sec.chaton.p057e.EnumC2214ab.LIVECONTENTS     // Catch: java.lang.Throwable -> Lda
            int r5 = r5.m10076a()     // Catch: java.lang.Throwable -> Lda
            if (r0 != r5) goto Le1
            java.util.ArrayList<com.sec.chaton.chat.notification.s> r0 = r6.f6921h     // Catch: java.lang.Throwable -> Lda
            java.lang.Object r0 = r0.get(r3)     // Catch: java.lang.Throwable -> Lda
            r4.add(r0)     // Catch: java.lang.Throwable -> Lda
            int r0 = r1 + 1
            goto L2f
        L74:
            java.util.ArrayList<com.sec.chaton.chat.notification.s> r0 = r6.f6921h     // Catch: java.lang.Throwable -> Lda
            r0.clear()     // Catch: java.lang.Throwable -> Lda
            java.util.ArrayList<com.sec.chaton.chat.notification.s> r0 = r6.f6921h     // Catch: java.lang.Throwable -> Lda
            r0.addAll(r4)     // Catch: java.lang.Throwable -> Lda
            r4.clear()     // Catch: java.lang.Throwable -> Lda
            if (r1 != 0) goto L88
            java.util.HashMap<java.lang.String, com.sec.chaton.chat.notification.u> r0 = r6.f6919f     // Catch: java.lang.Throwable -> Lda
            r0.remove(r7)     // Catch: java.lang.Throwable -> Lda
        L88:
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lda
            r3.<init>()     // Catch: java.lang.Throwable -> Lda
        L8d:
            java.util.ArrayList<com.sec.chaton.chat.notification.t> r0 = r6.f6920g     // Catch: java.lang.Throwable -> Lda
            int r0 = r0.size()     // Catch: java.lang.Throwable -> Lda
            if (r2 >= r0) goto Lb4
            java.util.ArrayList<com.sec.chaton.chat.notification.t> r0 = r6.f6920g     // Catch: java.lang.Throwable -> Lda
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Throwable -> Lda
            com.sec.chaton.chat.notification.t r0 = (com.sec.chaton.chat.notification.C1831t) r0     // Catch: java.lang.Throwable -> Lda
            java.lang.String r0 = r0.f6946c     // Catch: java.lang.Throwable -> Lda
            boolean r0 = r7.equals(r0)     // Catch: java.lang.Throwable -> Lda
            if (r0 == 0) goto La7
            if (r1 <= 0) goto Lb0
        La7:
            java.util.ArrayList<com.sec.chaton.chat.notification.t> r0 = r6.f6920g     // Catch: java.lang.Throwable -> Lda
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Throwable -> Lda
            r3.add(r0)     // Catch: java.lang.Throwable -> Lda
        Lb0:
            int r0 = r2 + 1
            r2 = r0
            goto L8d
        Lb4:
            java.util.ArrayList<com.sec.chaton.chat.notification.t> r0 = r6.f6920g     // Catch: java.lang.Throwable -> Lda
            r0.clear()     // Catch: java.lang.Throwable -> Lda
            java.util.ArrayList<com.sec.chaton.chat.notification.t> r0 = r6.f6920g     // Catch: java.lang.Throwable -> Lda
            r0.addAll(r3)     // Catch: java.lang.Throwable -> Lda
            r3.clear()     // Catch: java.lang.Throwable -> Lda
            java.util.ArrayList<com.sec.chaton.chat.notification.s> r0 = r6.f6921h     // Catch: java.lang.Throwable -> Lda
            int r0 = r0.size()     // Catch: java.lang.Throwable -> Lda
            r6.f6922i = r0     // Catch: java.lang.Throwable -> Lda
            com.sec.chaton.chat.notification.r r0 = r6.f6926n     // Catch: java.lang.Throwable -> Lda
            if (r0 == 0) goto Ld4
            com.sec.chaton.chat.notification.r r0 = r6.f6926n     // Catch: java.lang.Throwable -> Lda
            int r1 = r6.f6922i     // Catch: java.lang.Throwable -> Lda
            r0.mo8880b(r1)     // Catch: java.lang.Throwable -> Lda
        Ld4:
            java.util.concurrent.locks.Lock r0 = r6.f6925m
            r0.unlock()
            return
        Lda:
            r0 = move-exception
            java.util.concurrent.locks.Lock r1 = r6.f6925m
            r1.unlock()
            throw r0
        Le1:
            r0 = r1
            goto L2f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.notification.C1828q.m8963a(java.lang.String, boolean, boolean):void");
    }

    /* renamed from: c */
    public String[] m8971c() {
        this.f6924l.lock();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f6920g.size(); i++) {
            try {
                String str = this.f6920g.get(i).f6945b;
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            } catch (Throwable th) {
                this.f6924l.unlock();
                throw th;
            }
        }
        this.f6924l.unlock();
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* renamed from: a */
    public boolean m8966a(Long l) {
        boolean z;
        this.f6924l.lock();
        try {
            Iterator<C1830s> it = this.f6921h.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                if (it.next().f6940n == l.longValue()) {
                    z = true;
                    break;
                }
            }
            return z;
        } finally {
            this.f6924l.unlock();
        }
    }

    /* renamed from: a */
    public boolean m8967a(String str) {
        this.f6924l.lock();
        boolean z = false;
        try {
            if (this.f6919f.containsKey(str)) {
                z = true;
            }
            return z;
        } finally {
            this.f6924l.unlock();
        }
    }

    /* renamed from: a */
    public int m8957a(ArrayList<C1830s> arrayList, boolean z) {
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(arrayList);
        this.f6925m.lock();
        try {
            this.f6919f.clear();
            this.f6920g.clear();
            this.f6921h.clear();
            this.f6922i = arrayList2.size();
            if (this.f6922i != 0) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    C1830s c1830s = (C1830s) it.next();
                    if (!this.f6919f.containsKey(c1830s.f6931e)) {
                        this.f6919f.put(c1830s.f6931e, new C1832u(this, c1830s.f6936j, c1830s.f6937k, c1830s.f6935i, c1830s.f6934h, c1830s.f6938l));
                        if (C4904y.f17873c) {
                            C4904y.m18641c("[insertMsgListFromDB] From DB inboxList: " + (this.f6919f.size() - 1) + ", " + c1830s.f6931e, this.f6918e);
                        }
                    }
                    if (TextUtils.isEmpty(c1830s.f6927a)) {
                        if (C4904y.f17873c) {
                            C4904y.m18641c("[insertMsgListFromDB] sender no is null. Set buddy Name.", this.f6918e);
                        }
                        c1830s.f6927a = c1830s.f6928b;
                    }
                    if (TextUtils.isEmpty(c1830s.f6928b)) {
                        if (C4904y.f17873c) {
                            C4904y.m18641c("[insertMsgListFromDB] sender name is null. Set unknown.", this.f6918e);
                        }
                        c1830s.f6927a = CommonApplication.m18732r().getResources().getString(R.string.unknown);
                    }
                    if (m8955a(c1830s.f6927a, c1830s.f6931e) < 0) {
                        this.f6920g.add(new C1831t(this, c1830s.f6927a, c1830s.f6928b, c1830s.f6931e));
                        if (C4904y.f17873c) {
                            C4904y.m18641c("[insertMsgListFromDB] From DB buddyInfoList: " + (this.f6920g.size() - 1) + ", " + c1830s.f6927a, this.f6918e);
                        }
                    }
                }
                this.f6921h.addAll(arrayList2);
                if (z && this.f6926n != null) {
                    this.f6926n.mo8877a(this.f6922i);
                }
            }
            return -1;
        } finally {
            if (!arrayList2.isEmpty()) {
                arrayList2.clear();
            }
            this.f6925m.unlock();
        }
    }

    /* renamed from: a */
    public C1830s m8959a(String str, String str2, String str3, Long l, String str4, int i, int i2, String str5, String str6, int i3, long j, int i4, String str7, long j2, boolean z, EnumC2301u enumC2301u, int i5) {
        return new C1830s(str, str2, str3, l, str4, i, i2, str5, str6, i3, j, i4, str7, j2, z, enumC2301u, i5);
    }

    /* renamed from: d */
    public C1830s m8972d() {
        C1830s c1830s;
        Lock lock;
        this.f6924l.lock();
        try {
            try {
                c1830s = this.f6921h.get(0);
                lock = this.f6924l;
            } catch (Exception e) {
                if (C4904y.f17873c) {
                    C4904y.m18641c("[getLatestMessage] exception! return null", this.f6918e);
                }
                c1830s = null;
                lock = this.f6924l;
            }
            lock.unlock();
            return c1830s;
        } catch (Throwable th) {
            this.f6924l.unlock();
            throw th;
        }
    }

    /* renamed from: a */
    public C1830s m8958a(int i) {
        this.f6924l.lock();
        try {
            return this.f6921h.get(i);
        } finally {
            this.f6924l.unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003f, code lost:
    
        if (r6.f6926n == null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0041, code lost:
    
        r6.f6926n.mo8876a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0048, code lost:
    
        if (com.sec.chaton.util.C4904y.f17873c == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004a, code lost:
    
        com.sec.chaton.util.C4904y.m18641c("[updateMessageID] change message ID from:" + r7 + ", to:" + r8, r6.f6918e);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002f, code lost:
    
        r6.f6921h.get(r1).f6940n = java.lang.Long.parseLong(r8);
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m8962a(java.lang.String r7, java.lang.String r8, boolean r9) {
        /*
            r6 = this;
            java.util.concurrent.locks.Lock r0 = r6.f6925m
            r0.lock()
            r0 = 0
            r1 = r0
        L7:
            java.util.ArrayList<com.sec.chaton.chat.notification.s> r0 = r6.f6921h     // Catch: java.lang.Throwable -> L78
            int r0 = r0.size()     // Catch: java.lang.Throwable -> L78
            if (r1 >= r0) goto L6e
            java.util.ArrayList<com.sec.chaton.chat.notification.s> r0 = r6.f6921h     // Catch: java.lang.Throwable -> L78
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L78
            com.sec.chaton.chat.notification.s r0 = (com.sec.chaton.chat.notification.C1830s) r0     // Catch: java.lang.Throwable -> L78
            long r2 = r0.f6940n     // Catch: java.lang.Throwable -> L78
            long r4 = java.lang.Long.parseLong(r7)     // Catch: java.lang.Throwable -> L78
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 != 0) goto L74
            java.util.ArrayList<com.sec.chaton.chat.notification.s> r0 = r6.f6921h     // Catch: java.lang.Throwable -> L78
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L78
            com.sec.chaton.chat.notification.s r0 = (com.sec.chaton.chat.notification.C1830s) r0     // Catch: java.lang.Throwable -> L78
            int r0 = r0.f6943q     // Catch: java.lang.Throwable -> L78
            int r2 = com.sec.chaton.chat.notification.C1828q.f6914b     // Catch: java.lang.Throwable -> L78
            if (r0 == r2) goto L74
            java.util.ArrayList<com.sec.chaton.chat.notification.s> r0 = r6.f6921h     // Catch: java.lang.Throwable -> L78
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L78
            com.sec.chaton.chat.notification.s r0 = (com.sec.chaton.chat.notification.C1830s) r0     // Catch: java.lang.Throwable -> L78
            long r1 = java.lang.Long.parseLong(r8)     // Catch: java.lang.Throwable -> L78
            r0.f6940n = r1     // Catch: java.lang.Throwable -> L78
            com.sec.chaton.chat.notification.r r0 = r6.f6926n     // Catch: java.lang.Throwable -> L78
            if (r0 == 0) goto L46
            com.sec.chaton.chat.notification.r r0 = r6.f6926n     // Catch: java.lang.Throwable -> L78
            r0.mo8876a()     // Catch: java.lang.Throwable -> L78
        L46:
            boolean r0 = com.sec.chaton.util.C4904y.f17873c     // Catch: java.lang.Throwable -> L78
            if (r0 == 0) goto L6e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L78
            r0.<init>()     // Catch: java.lang.Throwable -> L78
            java.lang.String r1 = "[updateMessageID] change message ID from:"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L78
            java.lang.StringBuilder r0 = r0.append(r7)     // Catch: java.lang.Throwable -> L78
            java.lang.String r1 = ", to:"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L78
            java.lang.StringBuilder r0 = r0.append(r8)     // Catch: java.lang.Throwable -> L78
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L78
            java.lang.String r1 = r6.f6918e     // Catch: java.lang.Throwable -> L78
            com.sec.chaton.util.C4904y.m18641c(r0, r1)     // Catch: java.lang.Throwable -> L78
        L6e:
            java.util.concurrent.locks.Lock r0 = r6.f6925m
            r0.unlock()
            return
        L74:
            int r0 = r1 + 1
            r1 = r0
            goto L7
        L78:
            r0 = move-exception
            java.util.concurrent.locks.Lock r1 = r6.f6925m
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.notification.C1828q.m8962a(java.lang.String, java.lang.String, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0029, code lost:
    
        r4.f6921h.get(r1).f6929c = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0035, code lost:
    
        if (r4.f6926n == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0037, code lost:
    
        r4.f6926n.mo8876a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001f, code lost:
    
        if (com.sec.chaton.util.C4904y.f17873c == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
    
        com.sec.chaton.util.C4904y.m18641c("[updateMessageContent] change message content", r4.f6918e);
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m8960a(long r5, java.lang.String r7) {
        /*
            r4 = this;
            java.util.concurrent.locks.Lock r0 = r4.f6925m
            r0.lock()
            r0 = 0
            r1 = r0
        L7:
            java.util.ArrayList<com.sec.chaton.chat.notification.s> r0 = r4.f6921h     // Catch: java.lang.Throwable -> L46
            int r0 = r0.size()     // Catch: java.lang.Throwable -> L46
            if (r1 >= r0) goto L3c
            java.util.ArrayList<com.sec.chaton.chat.notification.s> r0 = r4.f6921h     // Catch: java.lang.Throwable -> L46
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L46
            com.sec.chaton.chat.notification.s r0 = (com.sec.chaton.chat.notification.C1830s) r0     // Catch: java.lang.Throwable -> L46
            long r2 = r0.f6940n     // Catch: java.lang.Throwable -> L46
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 != 0) goto L42
            boolean r0 = com.sec.chaton.util.C4904y.f17873c     // Catch: java.lang.Throwable -> L46
            if (r0 == 0) goto L29
            java.lang.String r0 = "[updateMessageContent] change message content"
            java.lang.String r2 = r4.f6918e     // Catch: java.lang.Throwable -> L46
            com.sec.chaton.util.C4904y.m18641c(r0, r2)     // Catch: java.lang.Throwable -> L46
        L29:
            java.util.ArrayList<com.sec.chaton.chat.notification.s> r0 = r4.f6921h     // Catch: java.lang.Throwable -> L46
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L46
            com.sec.chaton.chat.notification.s r0 = (com.sec.chaton.chat.notification.C1830s) r0     // Catch: java.lang.Throwable -> L46
            r0.f6929c = r7     // Catch: java.lang.Throwable -> L46
            com.sec.chaton.chat.notification.r r0 = r4.f6926n     // Catch: java.lang.Throwable -> L46
            if (r0 == 0) goto L3c
            com.sec.chaton.chat.notification.r r0 = r4.f6926n     // Catch: java.lang.Throwable -> L46
            r0.mo8876a()     // Catch: java.lang.Throwable -> L46
        L3c:
            java.util.concurrent.locks.Lock r0 = r4.f6925m
            r0.unlock()
            return
        L42:
            int r0 = r1 + 1
            r1 = r0
            goto L7
        L46:
            r0 = move-exception
            java.util.concurrent.locks.Lock r1 = r4.f6925m
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.notification.C1828q.m8960a(long, java.lang.String):void");
    }

    /* renamed from: b */
    public ArrayList<C1830s> m8969b(int i) {
        ArrayList<C1830s> arrayList = new ArrayList<>();
        this.f6924l.lock();
        try {
            if (i > this.f6922i) {
                i = this.f6922i;
            }
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(this.f6921h.get(i2));
            }
            return arrayList;
        } finally {
            this.f6924l.unlock();
        }
    }

    /* renamed from: e */
    public ArrayList<C1830s> m8973e() {
        ArrayList<C1830s> arrayList = new ArrayList<>();
        this.f6924l.lock();
        try {
            arrayList.addAll(this.f6921h);
            return arrayList;
        } finally {
            this.f6924l.unlock();
        }
    }

    /* renamed from: b */
    public C1832u m8968b(String str) {
        this.f6924l.lock();
        try {
            return this.f6919f.get(str);
        } finally {
            this.f6924l.unlock();
        }
    }

    /* renamed from: f */
    public int m8974f() {
        this.f6924l.lock();
        try {
            return this.f6921h.size();
        } finally {
            this.f6924l.unlock();
        }
    }

    /* renamed from: g */
    public int m8975g() {
        this.f6924l.lock();
        try {
            return this.f6919f.size();
        } finally {
            this.f6924l.unlock();
        }
    }

    /* renamed from: h */
    public void m8976h() {
        this.f6924l.lock();
    }

    /* renamed from: i */
    public void m8977i() {
        this.f6924l.unlock();
    }

    /* renamed from: a */
    public void m8961a(InterfaceC1829r interfaceC1829r) {
        this.f6926n = interfaceC1829r;
    }
}
