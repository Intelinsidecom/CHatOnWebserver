package com.sec.chaton.chat.notification;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.sec.chaton.calllog.manager.noti.C1457a;
import com.sec.chaton.p057e.C2281c;
import com.sec.chaton.p057e.p059b.AbstractC2240a;
import com.sec.chaton.p057e.p059b.InterfaceC2243d;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;

/* compiled from: ChatON3rdNotificationTask.java */
/* renamed from: com.sec.chaton.chat.notification.a */
/* loaded from: classes.dex */
public class C1793a extends AbstractC2240a {

    /* renamed from: c */
    private final String f6795c;

    /* renamed from: d */
    private int f6796d;

    /* renamed from: e */
    private String f6797e;

    /* renamed from: f */
    private long f6798f;

    /* renamed from: g */
    private String f6799g;

    /* renamed from: h */
    private int f6800h;

    /* renamed from: i */
    private int f6801i;

    /* renamed from: j */
    private String f6802j;

    /* renamed from: k */
    private String f6803k;

    public C1793a(String str, int i, InterfaceC2243d interfaceC2243d) {
        super(interfaceC2243d);
        this.f6795c = getClass().getName();
        this.f6796d = -1;
        this.f6797e = str;
        this.f6796d = i;
    }

    public C1793a(String str, String str2, int i, long j, int i2, int i3, InterfaceC2243d interfaceC2243d) {
        super(interfaceC2243d);
        this.f6795c = getClass().getName();
        this.f6796d = -1;
        this.f6797e = str;
        this.f6799g = str2;
        this.f6800h = i;
        this.f6798f = j;
        this.f6801i = i3;
        this.f6796d = i2;
    }

    public C1793a(String str, String str2, int i, InterfaceC2243d interfaceC2243d) {
        super(interfaceC2243d);
        this.f6795c = getClass().getName();
        this.f6796d = -1;
        this.f6802j = str;
        this.f6803k = str2;
        this.f6796d = i;
    }

    @Override // com.sec.chaton.p057e.p059b.AbstractC2240a
    /* renamed from: a */
    public Object mo8896a() {
        Cursor cursorQuery;
        try {
            cursorQuery = CommonApplication.m18732r().getContentResolver().query(C2281c.f8184a, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        while (cursorQuery.moveToNext()) {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex("packageName"));
                            if (this.f6796d == C1813b.f6841j) {
                                String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("messageTypeFlag"));
                                m8892a(TextUtils.isEmpty(string2) ? 0 : Integer.parseInt(string2, 2), string, this.f6801i);
                            } else if (this.f6796d == C1457a.f5191a) {
                                m8894b(string);
                            } else if (this.f6796d == C1457a.f5192b) {
                                m8895c(string);
                            } else {
                                m8893a(string);
                            }
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    /* renamed from: a */
    private void m8893a(String str) {
        Intent intent = new Intent();
        intent.setData(new Uri.Builder().scheme(str).build());
        if (this.f6796d == C1813b.f6839h) {
            intent.setAction("com.sec.chaton.chat.CHATROOM_CLOSE");
        } else {
            intent.setAction("com.sec.chaton.chat.MESSAGE_IS_READ");
        }
        intent.putExtra("inbox_no", this.f6797e);
        C4904y.m18641c("[B project] send broadcast, inboxNO : " + this.f6797e + ", ack:" + this.f6796d, this.f6795c);
        CommonApplication.m18732r().sendBroadcast(intent);
    }

    /* renamed from: a */
    private void m8892a(int i, String str, int i2) {
        if (i == 0 || (this.f6800h & i) == this.f6800h) {
            Intent intent = new Intent();
            intent.setData(new Uri.Builder().scheme(str).build());
            intent.setAction("com.sec.chaton.chat.PUSH_RECEIVED");
            intent.putExtra("message_id", this.f6798f);
            intent.putExtra("message_type", this.f6800h);
            intent.putExtra("inbox_no", this.f6797e);
            intent.putExtra("sender_id", this.f6799g);
            intent.putExtra("message_category", i2);
            C4904y.m18641c("[B project] send broadcast, msgID:" + this.f6798f + ",type:" + this.f6800h + ", category" + i2, this.f6795c);
            CommonApplication.m18732r().sendBroadcast(intent);
            return;
        }
        if (C4904y.f17873c) {
            C4904y.m18641c("Not supported msgType. support: " + i + ", current: " + this.f6800h, this.f6795c);
        }
    }

    /* renamed from: b */
    private void m8894b(String str) {
        if (C4904y.f17872b) {
            C4904y.m18639b("[B project] send broadcast FOR sendMissedCallMessage()", this.f6795c);
        }
        Intent intent = new Intent();
        intent.setData(new Uri.Builder().scheme(str).build());
        intent.setAction("com.sec.chaton.calllog.MISSED_CALL");
        intent.putExtra("sender_name", this.f6802j);
        intent.putExtra("received_time", this.f6803k);
        CommonApplication.m18732r().sendBroadcast(intent);
    }

    /* renamed from: c */
    private void m8895c(String str) {
        if (C4904y.f17872b) {
            C4904y.m18639b("[B project] send broadcast FOR sendMissedCallMessage()", this.f6795c);
        }
        Intent intent = new Intent();
        intent.setData(new Uri.Builder().scheme(str).build());
        intent.setAction("com.sec.chaton.calllog.DELETE_MISSED_CALL");
        CommonApplication.m18732r().sendBroadcast(intent);
    }
}
