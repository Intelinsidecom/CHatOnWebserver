package com.sec.chaton.p055d.p056a;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Build;
import android.text.TextUtils;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1015an;
import com.sec.chaton.C1066bf;
import com.sec.chaton.R;
import com.sec.chaton.chat.notification.C1813b;
import com.sec.chaton.chat.notification.C1828q;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2292l;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p057e.p058a.C2176ab;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p057e.p058a.C2204r;
import com.sec.chaton.p065io.entry.LiveChatDeliveryMessageEntry;
import com.sec.chaton.p065io.entry.inner.LiveChatDeliveryMessageEntryDetail;
import com.sec.chaton.p065io.entry.inner.LiveChatSendMessageResponseEntry;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.specialbuddy.p117a.C4529e;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.spp.push.Config;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LiveChatDeliveryMessageTask.java */
/* renamed from: com.sec.chaton.d.a.dm */
/* loaded from: classes.dex */
public class C1994dm extends AbstractC1900a {

    /* renamed from: b */
    private final String f7323b;

    /* renamed from: c */
    private long f7324c;

    /* renamed from: d */
    private String f7325d;

    /* renamed from: e */
    private int f7326e;

    /* renamed from: g */
    private String f7327g;

    /* renamed from: h */
    private String f7328h;

    /* renamed from: i */
    private ContentResolver f7329i;

    public C1994dm(C2454e c2454e, String str, String str2, long j, String str3, int i) {
        super(c2454e);
        this.f7323b = C1994dm.class.getSimpleName();
        this.f7325d = str2;
        this.f7324c = j;
        this.f7327g = str3;
        this.f7326e = i;
        this.f7329i = CommonApplication.m18732r().getContentResolver();
        this.f7328h = str;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    protected String mo9086c() throws JSONException {
        String strM9144e = m9144e();
        if (C4904y.f17873c) {
            C4904y.m18641c("payload: " + strM9144e, this.f7323b);
        }
        if (!TextUtils.isEmpty(strM9144e)) {
            return C4529e.m17224a(strM9144e);
        }
        return strM9144e;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    protected void mo9084a(C0778b c0778b) throws Throwable {
        Cursor cursor;
        if (C4904y.f17873c) {
            C4904y.m18641c("[After request]", this.f7323b);
        }
        if (c0778b.m3107b() != EnumC2464o.SUCCESS || c0778b.m3110e() == null) {
            if (C4904y.f17873c) {
                C4904y.m18641c("Http failed, Code:" + c0778b.m3107b(), this.f7323b);
            }
            C2204r.m10041b(this.f7329i, Long.valueOf(this.f7324c));
            return;
        }
        LiveChatDeliveryMessageEntry liveChatDeliveryMessageEntry = (LiveChatDeliveryMessageEntry) c0778b.m3110e();
        LiveChatDeliveryMessageEntryDetail liveChatDeliveryMessageEntryDetail = liveChatDeliveryMessageEntry.result;
        ArrayList<LiveChatSendMessageResponseEntry> arrayList = liveChatDeliveryMessageEntry.responsemessagelist;
        String str = liveChatDeliveryMessageEntry.receivetime;
        if (!liveChatDeliveryMessageEntryDetail.code.equals("1000")) {
            if (C4904y.f17873c) {
                C4904y.m18641c("Result : Failed, Code:" + liveChatDeliveryMessageEntryDetail.code, this.f7323b);
            }
            C2204r.m10041b(this.f7329i, Long.valueOf(this.f7324c));
            return;
        }
        if (C4904y.f17873c) {
            C4904y.m18641c("Result : Success", this.f7323b);
        }
        C2204r.m10051c(this.f7329i, Long.valueOf(Long.parseLong(str)), null, this.f7324c, Long.valueOf(this.f7324c), 1);
        if (arrayList == null || arrayList.size() == 0) {
            C2198l.m9911a(this.f7329i, this.f7325d, this.f7328h, this.f7327g, Long.parseLong(str), Long.valueOf(this.f7324c), EnumC2214ab.m10070a(this.f7326e), 0);
        } else {
            String str2 = "";
            EnumC2214ab enumC2214ab = EnumC2214ab.UNDEFINED;
            int i = 0;
            CommonApplication.m18732r().getResources().getString(R.string.unknown);
            String strM9693e = C2176ab.m9693e(this.f7329i, this.f7328h, this.f7325d);
            Iterator<LiveChatSendMessageResponseEntry> it = arrayList.iterator();
            long j = 0;
            String str3 = "";
            while (it.hasNext()) {
                LiveChatSendMessageResponseEntry next = it.next();
                String str4 = next.senttime;
                EnumC2214ab enumC2214abM10020a = EnumC2214ab.UNDEFINED;
                str2 = next.msg;
                long j2 = Long.parseLong(next.msgid);
                if (!TextUtils.isEmpty(next.msgid) || !TextUtils.isEmpty(next.msg)) {
                    enumC2214abM10020a = C2204r.m10020a(str2, Integer.parseInt(next.msgType));
                    if (C2204r.m10023a(this.f7329i, enumC2214abM10020a, this.f7328h, str2, this.f7325d, j2, str4) == EnumC2292l.INSERT && !C1813b.m8906b().m8931a(this.f7328h)) {
                        int i2 = i + 1;
                        if (C4904y.f17873c) {
                            C4904y.m18641c("show notification", this.f7323b);
                        }
                        try {
                            Cursor cursorQuery = this.f7329i.query(C2299s.f8209a, null, "inbox_no=?", new String[]{this.f7328h}, null);
                            boolean z = true;
                            if (cursorQuery != null) {
                                try {
                                    if (cursorQuery.getCount() > 0) {
                                        cursorQuery.moveToFirst();
                                        z = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_enable_noti")).equals("Y");
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    cursor = cursorQuery;
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    throw th;
                                }
                            }
                            C0991aa.m6037a().m18961c(new C1066bf(C1828q.f6913a, -1));
                            C1813b.m8906b().m8926a(this.f7325d, str2, this.f7328h, j2, enumC2214abM10020a, EnumC2300t.ONETOONE.m10210a(), "", strM9693e, z, Long.parseLong(str4), "", 0, 0, 0L, "N", EnumC2301u.LIVE);
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            i = i2;
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = null;
                        }
                    }
                } else if (C4904y.f17873c) {
                    C4904y.m18641c("No metadata and msg. Do not DB operation", this.f7323b);
                }
                j = j2;
                str3 = str4;
                enumC2214ab = enumC2214abM10020a;
            }
            C2198l.m9911a(this.f7329i, this.f7325d, this.f7328h, str2, Long.parseLong(str3), Long.valueOf(j), enumC2214ab, i);
        }
        C0991aa.m6037a().m18961c(new C1015an(new String[]{this.f7328h}));
    }

    /* renamed from: e */
    private String m9144e() throws JSONException {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("android ").append(Build.VERSION.RELEASE);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", C4809aa.m18104a().m18121a("chaton_id", ""));
            jSONObject.put("name", C4809aa.m18104a().m18121a("Push Name", ""));
            jSONObject.put("iso2", C4822an.m18257y());
            jSONObject.put("osversion", sb.toString());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("msgid", Long.toString(this.f7324c));
            jSONObject2.put("msgtype", C2204r.m10018a(EnumC2214ab.m10070a(this.f7326e)).getNumber());
            jSONObject2.put("chattype", Integer.toString(EnumC2300t.ONETOONE.m10210a()));
            jSONObject2.put(Config.NOTIFICATION_INTENT_SENDER, jSONObject);
            jSONObject2.put("receiver", this.f7325d);
            jSONObject2.put(Config.NOTIFICATION_INTENT_MSG, this.f7327g);
            return jSONObject2.toString();
        } catch (JSONException e) {
            if (C4904y.f17873c) {
                C4904y.m18641c("Can not covert to JSON", this.f7323b);
            }
            return null;
        }
    }
}
