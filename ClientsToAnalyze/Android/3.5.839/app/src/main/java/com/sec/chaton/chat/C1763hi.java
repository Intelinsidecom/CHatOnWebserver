package com.sec.chaton.chat;

import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.ListView;
import com.sec.chaton.p055d.C2134o;
import com.sec.chaton.p057e.C2306z;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.p057e.p059b.C2244e;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;

/* compiled from: MessageLoader.java */
/* renamed from: com.sec.chaton.chat.hi */
/* loaded from: classes.dex */
public class C1763hi {

    /* renamed from: d */
    private Context f6621d;

    /* renamed from: e */
    private ListView f6622e;

    /* renamed from: f */
    private C1723fw f6623f;

    /* renamed from: g */
    private C2210x f6624g;

    /* renamed from: h */
    private String f6625h;

    /* renamed from: j */
    private Handler f6627j;

    /* renamed from: k */
    private C1763hi f6628k;

    /* renamed from: o */
    private boolean f6632o;

    /* renamed from: a */
    final String f6618a = "MessageLoader";

    /* renamed from: i */
    private int f6626i = 0;

    /* renamed from: l */
    private boolean f6629l = true;

    /* renamed from: m */
    private boolean f6630m = false;

    /* renamed from: n */
    private long f6631n = 0;

    /* renamed from: p */
    private long f6633p = 0;

    /* renamed from: q */
    private EnumC1769ho f6634q = EnumC1769ho.NONE;

    /* renamed from: b */
    InterfaceC2211y f6619b = new C1766hl(this);

    /* renamed from: c */
    Handler f6620c = new HandlerC1767hm(this);

    /* renamed from: a */
    public long m8768a() {
        return this.f6631n;
    }

    /* renamed from: a */
    public void m8770a(long j) {
        this.f6631n = j;
    }

    /* renamed from: b */
    public long m8772b() {
        return this.f6633p;
    }

    /* renamed from: b */
    public void m8773b(long j) {
        this.f6633p = j;
    }

    /* renamed from: a */
    private boolean m8755a(EnumC1769ho enumC1769ho) {
        return this.f6634q == EnumC1769ho.NONE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public synchronized boolean m8760b(EnumC1769ho enumC1769ho) {
        boolean z;
        if (m8755a(enumC1769ho) || enumC1769ho == EnumC1769ho.NONE) {
            if (C4904y.f17872b) {
                C4904y.m18639b("setLoadStauts(" + enumC1769ho + ") success - current:" + this.f6634q, "MessageLoader");
            }
            this.f6634q = enumC1769ho;
            z = true;
        } else {
            if (C4904y.f17872b) {
                C4904y.m18639b("setLoadStauts(" + enumC1769ho + ") fail - current:" + this.f6634q, "MessageLoader");
            }
            z = false;
        }
        return z;
    }

    public C1763hi(Context context, ListView listView, C1723fw c1723fw, String str, Handler handler) {
        this.f6628k = null;
        this.f6632o = false;
        this.f6621d = context;
        this.f6622e = listView;
        this.f6628k = this;
        this.f6623f = c1723fw;
        this.f6623f.m8563a(this.f6628k);
        this.f6624g = new C2210x(this.f6621d.getContentResolver(), this.f6619b);
        this.f6625h = str;
        this.f6627j = handler;
        this.f6632o = false;
    }

    /* renamed from: c */
    public void m8774c() {
        if (m8760b(EnumC1769ho.LOADING)) {
            int i = this.f6626i;
            if (i < 100) {
                i = 100;
            }
            this.f6624g.startQuery(0, null, C2306z.m10214a(i), null, "message_inbox_no=?", new String[]{this.f6625h}, null);
        }
    }

    /* renamed from: a */
    public void m8769a(int i, int i2) {
        new Handler().postDelayed(new RunnableC1764hj(this, i, i2), 1300L);
    }

    /* renamed from: d */
    public void m8775d() {
        if (!this.f6629l) {
            m8760b(EnumC1769ho.NONE);
            this.f6627j.sendEmptyMessage(0);
        } else if (m8760b(EnumC1769ho.LOADING_MORE_FROM_LOCAL)) {
            this.f6624g.startQuery(2, null, C2306z.m10214a(this.f6626i + 50), null, "message_inbox_no=?", new String[]{this.f6625h}, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8752a(String str) {
        new Handler().postDelayed(new RunnableC1765hk(this, str), 1000L);
    }

    /* renamed from: e */
    public void m8776e() {
        this.f6627j.sendEmptyMessage(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8748a(Cursor cursor) {
        Message messageM10105c = C2244e.m10103a().m10105c();
        messageM10105c.obj = cursor;
        C2244e.m10103a().m10104b().sendMessage(messageM10105c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8747a(int i) {
        this.f6622e.setSelection(this.f6623f.mo871a().getCount() - i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m8757b(int i, int i2) {
        this.f6622e.setSelectionFromTop(this.f6623f.mo871a().getCount() - i, i2);
    }

    /* renamed from: a */
    public boolean m8771a(String str, EnumC2300t enumC2300t, String str2, boolean z) {
        long j;
        long j2 = 0;
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            if (!C4904y.f17873c) {
                return false;
            }
            C4904y.m18641c("requestMoreMessageToServer - network is not available", "MessageLoader");
            return false;
        }
        if (enumC2300t != EnumC2300t.TOPIC) {
            if (!C4822an.m18255w()) {
                if (!C4904y.f17873c) {
                    return false;
                }
                C4904y.m18641c("requestMoreMessageToServer - did not mapping samsung account", "MessageLoader");
                return false;
            }
            if (!C4822an.m18204N()) {
                if (!C4904y.f17873c) {
                    return false;
                }
                C4904y.m18641c("requestMoreMessageToServer - isNeedToSyncDataForMultidevice() : false", "MessageLoader");
                return false;
            }
        }
        if (str.equals("-1")) {
            if (!C4904y.f17873c) {
                return false;
            }
            C4904y.m18641c("requestMoreMessageToServer - lastTid is -1", "MessageLoader");
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            if (!C4904y.f17873c) {
                return false;
            }
            C4904y.m18641c("requestMoreMessageToServer - session is null", "MessageLoader");
            return false;
        }
        if (!z) {
            if (!C4904y.f17873c) {
                return false;
            }
            C4904y.m18641c("requestMoreMessageToServer - inbox is invalid", "MessageLoader");
            return false;
        }
        if (this.f6630m) {
            if (!C4904y.f17873c) {
                return false;
            }
            C4904y.m18641c("requestMoreMessageToServer - mIsRequestingToServer is ture", "MessageLoader");
            return false;
        }
        if (this.f6632o) {
            if (!C4904y.f17873c) {
                return false;
            }
            C4904y.m18641c("requestMoreMessageToServer - mIsErrorOccurred is ture", "MessageLoader");
            return false;
        }
        if (str.equals(Spam.ACTIVITY_CANCEL)) {
            try {
                Cursor cursor = (Cursor) this.f6622e.getAdapter().getItem(1);
                if (cursor != null) {
                    long j3 = cursor.getLong(cursor.getColumnIndex("message_time"));
                    if (C4904y.f17873c) {
                        C4904y.m18641c("requestMoreMessageToServer()-lastMsg : " + cursor.getString(cursor.getColumnIndex("message_content")), "MessageLoader");
                    }
                    j = j3;
                } else {
                    j = 0;
                }
                j2 = j;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        C2134o.m9572a(this.f6620c, this.f6625h, str2, enumC2300t, str, Long.valueOf(j2), 50);
        this.f6630m = true;
        if (C4904y.f17873c) {
            C4904y.m18641c("loadMessageFromServer - inboxNo:" + this.f6625h + ",sessionId:" + str2 + ",tid:" + str + ",count:50", "MessageLoader");
        }
        return true;
    }
}
