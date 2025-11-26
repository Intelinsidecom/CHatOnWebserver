package com.sec.chaton.p057e.p059b;

import com.sec.chaton.C0991aa;
import com.sec.chaton.C1009ah;
import com.sec.chaton.chat.notification.C1813b;
import com.sec.chaton.chat.notification.C1828q;
import com.sec.chaton.chat.notification.C1830s;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;

/* compiled from: MessageNotificationUpdateTask.java */
/* renamed from: com.sec.chaton.e.b.l */
/* loaded from: classes.dex */
public class C2251l extends AbstractC2240a {

    /* renamed from: c */
    public ArrayList<C1830s> f8009c;

    /* renamed from: d */
    private final String f8010d;

    /* renamed from: e */
    private final int f8011e;

    /* renamed from: f */
    private final int f8012f;

    /* renamed from: g */
    private final C1813b f8013g;

    /* renamed from: h */
    private final C1828q f8014h;

    /* renamed from: i */
    private final boolean f8015i;

    /* renamed from: j */
    private final C1830s f8016j;

    /* renamed from: k */
    private final int f8017k;

    /* renamed from: l */
    private final int f8018l;

    /* renamed from: m */
    private boolean f8019m;

    /* renamed from: n */
    private final String[] f8020n;

    public C2251l(InterfaceC2243d interfaceC2243d, int i, boolean z, boolean z2) {
        super(interfaceC2243d);
        this.f8010d = getClass().getSimpleName();
        this.f8011e = 0;
        this.f8012f = 1;
        this.f8019m = false;
        this.f8020n = new String[]{"transport_type", "_id", "thread_id", "address", "body", "date", "type", "status", "sub", "sub_cs", "date", "m_type", "msg_box"};
        this.f8017k = i;
        this.f8013g = C1813b.m8906b();
        this.f8014h = C1828q.m8956a();
        this.f8009c = new ArrayList<>();
        this.f8015i = z;
        this.f8016j = null;
        this.f8018l = 1;
        this.f8019m = z2;
    }

    public C2251l(InterfaceC2243d interfaceC2243d, int i, boolean z, C1830s c1830s) {
        super(interfaceC2243d);
        this.f8010d = getClass().getSimpleName();
        this.f8011e = 0;
        this.f8012f = 1;
        this.f8019m = false;
        this.f8020n = new String[]{"transport_type", "_id", "thread_id", "address", "body", "date", "type", "status", "sub", "sub_cs", "date", "m_type", "msg_box"};
        this.f8017k = i;
        this.f8013g = C1813b.m8906b();
        this.f8014h = C1828q.m8956a();
        this.f8009c = new ArrayList<>();
        this.f8015i = z;
        this.f8018l = 0;
        this.f8016j = c1830s;
    }

    @Override // com.sec.chaton.p057e.p059b.AbstractC2240a
    /* renamed from: a */
    public Object mo8896a() {
        boolean z;
        int i;
        int iM8974f = this.f8014h.m8974f();
        if (iM8974f == 0) {
            int iM9905a = C2198l.m9905a(CommonApplication.m18732r().getContentResolver());
            if (iM9905a != iM8974f) {
                i = iM9905a;
                z = true;
            } else {
                i = iM9905a;
                z = false;
            }
        } else {
            z = false;
            i = -1;
        }
        if (this.f8018l == 0) {
            if (C4904y.f17873c) {
                C4904y.m18641c("[doQuery] !! TASK STARTED !! msdID:" + this.f8016j.f6940n + ", inboxUnreadCount:" + i + ", unreadCount:" + iM8974f, this.f8010d);
            }
            if (z) {
                if (C4904y.f17873c) {
                    C4904y.m18641c("message count is different with inbox table. Do task.", this.f8010d);
                }
                if (m10106b()) {
                    this.f8014h.m8957a(this.f8009c, true);
                } else {
                    if (C4904y.f17873c) {
                        C4904y.m18641c("Can not read database. Clear all message data and insert new message only.", this.f8010d);
                    }
                    this.f8014h.m8970b();
                }
            }
            if (this.f8016j.f6931e != null) {
                this.f8014h.m8965a(this.f8016j);
                this.f8013g.m8919a(this.f8017k, this.f8015i, "", false, false);
            }
        } else {
            if (C4904y.f17873c) {
                C4904y.m18641c("[doQuery] !! TASK STARTED !! inboxUnreadCount:" + i + ", unreadCount:" + iM8974f, this.f8010d);
            }
            if (this.f8019m || z || (i == -1 && iM8974f != C2198l.m9905a(CommonApplication.m18732r().getContentResolver()))) {
                if (C4904y.f17873c) {
                    C4904y.m18641c("message count is different with inbox table. Do task.", this.f8010d);
                }
                if (m10106b()) {
                    if (this.f8009c.size() > 0) {
                        this.f8014h.m8957a(this.f8009c, true);
                        this.f8013g.m8936c(this.f8017k);
                    } else {
                        if (C4904y.f17873c) {
                            C4904y.m18641c("[doQuery] inbox which has unread message not exist", this.f8010d);
                        }
                        C1813b.m8906b().m8938d();
                        C0991aa.m6037a().m18962d(new C1009ah());
                    }
                } else {
                    if (C4904y.f17873c) {
                        C4904y.m18641c("Can not read database. Do not update notification", this.f8010d);
                    }
                    C0991aa.m6037a().m18962d(new C1009ah());
                }
            } else if (iM8974f == 0 && i == iM8974f) {
                if (C4904y.f17873c) {
                    C4904y.m18641c("[doQuery] inbox which has unread message not exist", this.f8010d);
                }
                C1813b.m8906b().m8938d();
                C0991aa.m6037a().m18962d(new C1009ah());
            }
        }
        return new Object();
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x03f1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0045 A[SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m10106b() throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 1410
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p059b.C2251l.m10106b():boolean");
    }
}
