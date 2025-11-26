package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.chat.C1075eq;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.EnumC1391ai;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p027e.p028a.C1370n;
import com.sec.chaton.p027e.p028a.C1372p;
import com.sec.chaton.p027e.p028a.C1373q;
import com.sec.chaton.p027e.p028a.C1381y;
import com.sec.chaton.p035io.entry.GetAllMessageList;
import com.sec.chaton.p035io.entry.inner.Message;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.settings.downloads.C2646u;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.spp.push.Config;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: GetAllMessagesTask.java */
/* renamed from: com.sec.chaton.d.a.bd */
/* loaded from: classes.dex */
public class C1176bd extends AbstractC1145a {

    /* renamed from: b */
    ContentResolver f4653b;

    /* renamed from: c */
    private String f4654c;

    /* renamed from: e */
    private String f4655e;

    /* renamed from: f */
    private EnumC1450r f4656f;

    public C1176bd(Handler handler, C1580h c1580h, String str, String str2, EnumC1450r enumC1450r) {
        super(handler, c1580h);
        this.f4654c = str;
        this.f4655e = str2;
        this.f4656f = enumC1450r;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) throws RemoteException, OperationApplicationException {
        String str;
        if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
            GetAllMessageList getAllMessageList = (GetAllMessageList) c0267d.m1354e();
            boolean zBooleanValue = getAllMessageList.has_more.booleanValue();
            C3250y.m11453c("has_more : " + zBooleanValue, getClass().getSimpleName());
            ArrayList<Message> arrayList = getAllMessageList.messages;
            if (arrayList.size() <= 0) {
                if (C3250y.f11734b) {
                    C3250y.m11450b("allMessage.messages.size() is 0", getClass().getSimpleName());
                    return;
                }
                return;
            }
            Collections.sort(arrayList, new C1177be(this));
            this.f4653b = GlobalApplication.m11493l().getContentResolver();
            ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
            Message message = null;
            ArrayList<Message> arrayList3 = new ArrayList<>();
            C1372p c1372pM6140d = C1370n.m6140d(this.f4653b, this.f4654c);
            if (c1372pM6140d != null) {
                for (Message message2 : arrayList) {
                    message2.sender = C1381y.m6227h(this.f4653b, message2.sender);
                    if (C3250y.f11735c) {
                        String strSubstring = message2.msg;
                        if (strSubstring.length() > 5) {
                            strSubstring = strSubstring.substring(0, 4);
                        }
                        C3250y.m11453c("Msg : " + strSubstring + ",Tid : " + message2.tid + ", Type : " + message2.type + ", MsgId : " + message2.f5649id + ", Sender : " + message2.sender + ", Time : " + message2.time, getClass().getSimpleName());
                    }
                    if (C1373q.m6192b(this.f4653b, message2.sender, message2.f5649id, this.f4655e)) {
                        if (message2.type.equals(Config.NOTIFICATION_INTENT_MSG)) {
                            m5517a(arrayList2, message2);
                        } else if (message2.type.equals("media")) {
                            m5520c(arrayList2, message2);
                        } else if (message2.type.equals("content")) {
                            m5519b(arrayList2, message2);
                        } else {
                            if (message2.type.equals("noti")) {
                                arrayList3.add(message2);
                            }
                            message2 = message;
                        }
                        message = message2;
                    }
                }
                if (arrayList3.size() > 0) {
                    m5518a(arrayList2, arrayList3);
                }
                if (TextUtils.isEmpty(c1372pM6140d.f5126e) && message != null) {
                    arrayList2.add(m5516a(c1372pM6140d, message));
                }
                if (zBooleanValue) {
                    str = arrayList.get(0).tid;
                } else {
                    str = "-1";
                }
                arrayList2.add(C1370n.m6115a(this.f4654c, str));
                try {
                    if (arrayList2.size() > 0) {
                        this.f4653b.applyBatch("com.sec.chaton.provider", arrayList2);
                        return;
                    }
                    return;
                } catch (Exception e) {
                    C3250y.m11442a(e.getMessage(), getClass().getSimpleName());
                    return;
                }
            }
            return;
        }
        if (c0267d.m1351b() == EnumC1587o.NO_CONTENT) {
            ArrayList<ContentProviderOperation> arrayList4 = new ArrayList<>();
            arrayList4.add(C1370n.m6115a(this.f4654c, "-1"));
            try {
                if (arrayList4.size() > 0) {
                    GlobalApplication.m11493l().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList4);
                }
            } catch (Exception e2) {
                C3250y.m11442a(e2.getMessage(), getClass().getSimpleName());
            }
            if (C3250y.f11734b) {
                C3250y.m11450b("GetAllMessages fail. code : " + c0267d.m1351b(), getClass().getSimpleName());
                return;
            }
            return;
        }
        if (C3250y.f11734b) {
            C3250y.m11450b("GetAllMessages fail. code : " + c0267d.m1351b(), getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private ContentProviderOperation m5516a(C1372p c1372p, Message message) {
        c1372p.f5128g = message.time.longValue();
        c1372p.f5131j = Long.valueOf(message.f5649id).longValue();
        c1372p.f5132k = message.sender;
        c1372p.f5124c = this.f4656f.m6342a();
        StringBuilder sb = new StringBuilder();
        if (message.sender.equals(C3159aa.m10962a().m10979a("chaton_id", ""))) {
            sb.append(1).append(Config.KEYVALUE_SPLIT);
        } else {
            sb.append(2).append(Config.KEYVALUE_SPLIT);
        }
        sb.append(C1373q.m6175a(message.msg, message.type).m6364a()).append(Config.KEYVALUE_SPLIT);
        if (message.sender.startsWith("0999")) {
            try {
                sb.append(C1075eq.m5318a(new JSONObject(message.msg).getString("push_message")));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            sb.append(C1075eq.m5318a(message.msg));
        }
        sb.append(Config.KEYVALUE_SPLIT);
        if (this.f4656f == EnumC1450r.GROUPCHAT) {
            sb.append(C1075eq.m5318a(C1381y.m6222f(this.f4653b, message.sender)));
        }
        c1372p.f5126e = sb.toString();
        return C1370n.m6139c(this.f4653b, this.f4654c, c1372p);
    }

    /* renamed from: a */
    private void m5517a(ArrayList<ContentProviderOperation> arrayList, Message message) {
        arrayList.add(C1373q.m6164a(this.f4653b, this.f4654c, EnumC1455w.TEXT, message, this.f4655e, (String) null));
    }

    /* renamed from: b */
    private void m5519b(ArrayList<ContentProviderOperation> arrayList, Message message) {
        try {
            arrayList.add(C1373q.m6164a(this.f4653b, this.f4654c, C1373q.m6176a(new JSONObject(message.msg)), message, this.f4655e, (String) null));
        } catch (JSONException e) {
            C3250y.m11443a(e, this.f11982d);
        }
    }

    /* renamed from: c */
    private void m5520c(ArrayList<ContentProviderOperation> arrayList, Message message) {
        String str;
        EnumC1455w enumC1455wM6173a = C1373q.m6173a(message.msg);
        String[] strArrSplit = message.msg.split("\n");
        if ((enumC1455wM6173a == EnumC1455w.CONTACT || enumC1455wM6173a == EnumC1455w.CALENDAR || enumC1455wM6173a == EnumC1455w.DOCUMENT || enumC1455wM6173a == EnumC1455w.FILE) && strArrSplit.length >= 6) {
            str = strArrSplit[5];
        } else {
            str = null;
        }
        if (enumC1455wM6173a == EnumC1455w.IMAGE && C2646u.m9661b(message.msg)) {
            enumC1455wM6173a = EnumC1455w.ANICON;
        }
        if (enumC1455wM6173a == EnumC1455w.IMAGE || enumC1455wM6173a == EnumC1455w.AMS || enumC1455wM6173a == EnumC1455w.AUDIO) {
            if (strArrSplit.length >= 5) {
                String str2 = strArrSplit[2];
                String str3 = strArrSplit[4];
                String str4 = strArrSplit[3];
                String str5 = this.f4654c;
                long jLongValue = Long.valueOf(message.f5649id).longValue();
                EnumC1450r enumC1450r = this.f4656f;
                String str6 = message.sender;
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new RunnableC1178bf(this, enumC1455wM6173a, str2, str3, str4, str5, jLongValue, enumC1450r, str6, handler, message.msg));
            } else if (strArrSplit.length >= 4) {
                C3250y.m11450b("No need to update and insert: " + strArrSplit[3], getClass().getName());
            } else {
                C3250y.m11442a("Token Error", getClass().getName());
            }
        }
        arrayList.add(C1373q.m6164a(this.f4653b, this.f4654c, enumC1455wM6173a, message, this.f4655e, str));
    }

    /* renamed from: a */
    private void m5518a(ArrayList<ContentProviderOperation> arrayList, ArrayList<Message> arrayList2) {
        Iterator<Message> it = arrayList2.iterator();
        while (it.hasNext()) {
            Message next = it.next();
            if (!TextUtils.isEmpty(next.msg)) {
                String[] strArrSplit = next.msg.split("\n");
                StringBuilder sb = new StringBuilder();
                for (String str : strArrSplit) {
                    C3250y.m11456e("Row : " + str, getClass().getSimpleName());
                    String[] strArrM5325b = C1075eq.m5325b(str, ",", 3);
                    if (strArrM5325b.length > 2) {
                        String str2 = strArrM5325b[1];
                        String strM6215b = C1381y.m6215b(this.f4653b, str2, strArrM5325b[2]);
                        EnumC1391ai enumC1391ai = EnumC1391ai.UNKNOWN;
                        if (EnumC1391ai.m6247a(strArrM5325b[0]) == EnumC1391ai.ENTER) {
                            if (C3159aa.m10962a().m10979a("chaton_id", "").equals(next.sender)) {
                                enumC1391ai = EnumC1391ai.INVITE;
                            } else {
                                enumC1391ai = EnumC1391ai.ENTER;
                            }
                        } else if (EnumC1391ai.m6247a(strArrM5325b[0]) == EnumC1391ai.LEAVE) {
                            enumC1391ai = EnumC1391ai.LEAVE;
                            arrayList.add(C1381y.m6207a("", str2, strM6215b));
                        }
                        if (enumC1391ai != EnumC1391ai.UNKNOWN) {
                            sb.append(String.format("%d,%s,%s", Integer.valueOf(enumC1391ai.m6248a()), str2, C1075eq.m5318a(strM6215b))).append(Config.KEYVALUE_SPLIT);
                        }
                    }
                }
                String string = sb.toString();
                if (!TextUtils.isEmpty(string)) {
                    C1373q.m6167a(this.f4653b, this.f4654c, string, next.time.longValue(), next.f5649id, next.sender);
                }
            }
        }
    }
}
