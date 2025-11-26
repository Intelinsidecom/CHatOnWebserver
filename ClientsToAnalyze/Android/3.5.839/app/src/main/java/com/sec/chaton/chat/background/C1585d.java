package com.sec.chaton.chat.background;

import android.app.Service;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.chat.notification.C1813b;
import com.sec.chaton.p055d.C2142w;
import com.sec.chaton.p057e.C2281c;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p057e.p058a.C2202p;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.smsplugin.p102b.C3790i;
import com.sec.chaton.specialbuddy.EnumC4549n;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4843bh;
import com.sec.chaton.util.C4844bi;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;

/* compiled from: GetMessageJobContainer.java */
/* renamed from: com.sec.chaton.chat.background.d */
/* loaded from: classes.dex */
public class C1585d extends C1587f {

    /* renamed from: v */
    private final String f6026v;

    /* renamed from: w */
    private long f6027w;

    /* renamed from: x */
    private int f6028x;

    public C1585d(Handler handler, Looper looper, Service service, int i, int i2) {
        super(handler, looper, service, i, i2);
        this.f6026v = "GetMessageJonContainer";
        this.f6042m = handler;
        this.f6037h = null;
        this.f6041l = C4843bh.m18322a();
        this.f6043n = false;
        this.f6045p = -1L;
        this.f6048s = service;
        this.f6049t = i;
        this.f6050u = i2;
        m8452a(new HandlerC1586e(this, looper));
    }

    @Override // com.sec.chaton.chat.background.C1587f
    /* renamed from: a */
    public int mo8445a(C1589h c1589h) {
        if (c1589h == null) {
            return 4;
        }
        this.f6040k = c1589h.m8458c();
        this.f6032c = c1589h.m8470o();
        this.f6045p = c1589h.m8464i();
        this.f6031b = c1589h.m8463h();
        this.f6034e = c1589h.m8456a();
        this.f6028x = c1589h.m8457b();
        return (TextUtils.isEmpty(this.f6032c) || this.f6045p == -1 || TextUtils.isEmpty(this.f6031b) || TextUtils.isEmpty(this.f6034e)) ? 4 : 1;
    }

    @Override // com.sec.chaton.chat.background.C1587f
    /* renamed from: a */
    public boolean mo8446a() {
        if (this.f6050u == 1) {
            if (C4904y.f17873c) {
                C4904y.m18641c("Need to network", "GetMessageJonContainer");
            }
            int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
            if (-3 == iM10677a || -2 == iM10677a) {
                return mo8449a(false, 2, this.f6045p);
            }
            if (!mo8448a((EnumC2300t) null)) {
                return mo8449a(false, 9, this.f6045p);
            }
            if (this.f6035f == EnumC2300t.UNKNOWN) {
                return mo8449a(false, 5, this.f6045p);
            }
            int iMo8450b = mo8450b(this.f6035f);
            if (iMo8450b != 1) {
                return mo8449a(false, iMo8450b, this.f6045p);
            }
            return true;
        }
        if (C4904y.f17873c) {
            C4904y.m18641c("No need to network", "GetMessageJonContainer");
        }
        mo8447a(this.f6041l);
        return mo8449a(true, 1, this.f6045p);
    }

    @Override // com.sec.chaton.chat.background.C1587f
    /* renamed from: a */
    public boolean mo8449a(boolean z, int i, long j) {
        if (TextUtils.isEmpty(this.f6031b)) {
            if (C4904y.f17873c) {
                C4904y.m18641c("packagename is empty", "GetMessageJonContainer");
            }
            return false;
        }
        m8443a(i);
        return true;
    }

    /* renamed from: a */
    private void m8443a(int i) {
        Cursor cursorQuery;
        if (C4904y.f17873c) {
            C4904y.m18641c("result_code : " + String.valueOf(i), "GetMessageJonContainer");
            C4904y.m18641c("request_id : " + String.valueOf(this.f6040k), "GetMessageJonContainer");
            C4904y.m18641c("request_msg_id: " + String.valueOf(this.f6045p), "GetMessageJonContainer");
        }
        Intent intent = new Intent("com.sec.chaton.chat.background.RES_FULL_MESSAGE");
        intent.setData(new Uri.Builder().scheme(this.f6031b).build());
        intent.putExtra("request_id", this.f6040k);
        if (i == 1) {
            if (this.f6028x == 0) {
                cursorQuery = CommonApplication.m18732r().getContentResolver().query(C2281c.m10136a(), null, null, new String[]{this.f6032c, Long.toString(this.f6045p)}, null);
            } else {
                cursorQuery = CommonApplication.m18732r().getContentResolver().query(C2281c.m10137b(), null, null, new String[]{this.f6032c, Long.toString(this.f6045p), String.valueOf(this.f6028x)}, null);
            }
            if (cursorQuery == null || cursorQuery.getCount() == 0) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                    i = 0;
                } else {
                    i = 0;
                }
            } else {
                intent.putExtra("inbox_no", this.f6032c);
                intent.putExtra("message_id", this.f6045p);
                cursorQuery.moveToFirst();
                int i2 = cursorQuery.getString(cursorQuery.getColumnIndex("sender_chatonv_available")).equals("true") ? 1 : 0;
                intent.putExtra("message_type", cursorQuery.getInt(cursorQuery.getColumnIndex("message_type")));
                intent.putExtra(VKApiConst.MESSAGE, cursorQuery.getString(cursorQuery.getColumnIndex(VKApiConst.MESSAGE)));
                intent.putExtra("sender_id", cursorQuery.getString(cursorQuery.getColumnIndex("sender_id")));
                intent.putExtra("sender_name", cursorQuery.getString(cursorQuery.getColumnIndex("sender_name")));
                intent.putExtra("sender_phoneNumber", cursorQuery.getString(cursorQuery.getColumnIndex("sender_phoneNumber")));
                intent.putExtra("chat_type", cursorQuery.getInt(cursorQuery.getColumnIndex("chat_type")));
                intent.putExtra("received_time", cursorQuery.getLong(cursorQuery.getColumnIndex("received_time")));
                intent.putExtra("sender_chatonv_available", i2);
                intent.putExtra("chatroom_title", cursorQuery.getString(cursorQuery.getColumnIndex("chatroom_title")));
                intent.putExtra("message_category", this.f6028x);
                intent.putExtra("is_enable_noti", cursorQuery.getString(cursorQuery.getColumnIndex("is_enable_noti")));
                int i3 = cursorQuery.getInt(cursorQuery.getColumnIndex("room_type"));
                cursorQuery.close();
                m8444a(i3, cursorQuery.getInt(cursorQuery.getColumnIndex("message_type")));
            }
        }
        intent.putExtra("result_code", i);
        CommonApplication.m18732r().sendBroadcast(intent);
    }

    @Override // com.sec.chaton.chat.background.C1587f
    /* renamed from: a */
    protected boolean mo8448a(EnumC2300t enumC2300t) {
        if (TextUtils.isEmpty(this.f6032c)) {
            return false;
        }
        Cursor cursorQuery = CommonApplication.m18732r().getContentResolver().query(C2299s.f8209a, null, "inbox_no=?", new String[]{this.f6032c}, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.moveToFirst();
            this.f6038i = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_server_ip"));
            this.f6039j = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_server_port"));
            this.f6035f = EnumC2300t.m10207a(cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_chat_type")));
            this.f6033d = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_session_id"));
            this.f6027w = cursorQuery.getLong(cursorQuery.getColumnIndex("lasst_session_merge_time"));
            cursorQuery.close();
            if (this.f6035f == EnumC2300t.BROADCAST || this.f6033d == null || "null".equals(this.f6033d)) {
                this.f6033d = "";
                this.f6035f = EnumC2300t.BROADCAST;
            }
            this.f6037h = C2142w.m9593a(this.f6032c, this.f6035f);
            if (this.f6037h == null) {
                return false;
            }
            this.f6037h.m9246a(this.f6030a);
            this.f6037h.mo9243a(Long.MAX_VALUE);
            if (TextUtils.isEmpty(this.f6038i)) {
                this.f6037h.mo9252a(this.f6032c, C4844bi.m18323a().m18328c().m18329a(), C4844bi.m18323a().m18328c().m18332b());
            } else {
                this.f6037h.mo9252a(this.f6032c, this.f6038i, this.f6039j);
            }
            if (this.f6035f == EnumC2300t.BROADCAST || this.f6033d == null || "null".equals(this.f6033d)) {
                this.f6037h.m9648e(this.f6032c);
            } else {
                this.f6037h.mo9266b(this.f6027w);
            }
            return true;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return false;
    }

    @Override // com.sec.chaton.chat.background.C1587f
    /* renamed from: b */
    protected int mo8450b(EnumC2300t enumC2300t) {
        if (!this.f6037h.mo9247a(this.f6035f, this.f6034e, Long.valueOf(this.f6045p), this.f6033d, this.f6032c, this.f6027w)) {
            mo8449a(true, 1, this.f6045p);
            mo8447a(this.f6041l);
            this.f6037h.m9644b(this.f6035f, this.f6033d);
        }
        return 1;
    }

    @Override // com.sec.chaton.chat.background.C1587f
    /* renamed from: a */
    protected boolean mo8447a(long j) {
        if (this.f6042m == null) {
            return false;
        }
        Message messageObtainMessage = this.f6042m.obtainMessage();
        messageObtainMessage.what = 1;
        messageObtainMessage.obj = new Long(j);
        return this.f6042m.sendMessage(messageObtainMessage);
    }

    /* renamed from: a */
    private void m8444a(int i, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_unread_count", (Integer) 0);
        if (EnumC2301u.m10211a(i) == EnumC2301u.LIVE) {
            if (EnumC2214ab.m10070a(i2) == EnumC2214ab.LIVECONTENTS) {
                CommonApplication.m18732r().getContentResolver().update(C2299s.m10186a(this.f6032c, EnumC4549n.LIVECONTENTS), contentValues, "inbox_no = ?", new String[]{this.f6032c});
            } else {
                CommonApplication.m18732r().getContentResolver().update(C2299s.m10186a(this.f6032c, EnumC4549n.LIVECHAT), contentValues, "inbox_no = ?", new String[]{this.f6032c});
            }
        } else {
            if (EnumC2301u.m10211a(i) == EnumC2301u.SMS) {
                C3790i.m14317a(CommonApplication.m18732r(), Long.valueOf(this.f6032c).longValue(), false).m14355b();
            } else {
                C2142w c2142wM9606c = C2142w.m9606c(this.f6032c);
                if (c2142wM9606c != null) {
                    c2142wM9606c.mo9227a(this.f6035f, this.f6033d);
                }
                if (C4822an.m18203M()) {
                    String strM9988e = C2202p.m9988e(CommonApplication.m18732r().getContentResolver(), this.f6032c);
                    if (!TextUtils.isEmpty(strM9988e)) {
                        C3790i.m14317a(CommonApplication.m18732r(), Long.valueOf(strM9988e).longValue(), false).m14355b();
                    }
                }
            }
            CommonApplication.m18732r().getContentResolver().update(C2299s.m10198k(), contentValues, "inbox_no = ?", new String[]{this.f6032c});
        }
        C1813b.m8906b().m8922a(this.f6032c, C1813b.f6840i);
    }
}
