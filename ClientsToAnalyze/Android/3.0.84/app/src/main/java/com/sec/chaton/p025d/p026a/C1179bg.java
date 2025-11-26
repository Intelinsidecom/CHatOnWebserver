package com.sec.chaton.p025d.p026a;

import android.app.PendingIntent;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.sec.chaton.IntentControllerActivity;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1075eq;
import com.sec.chaton.chat.notification.C1103a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.C1335m;
import com.sec.chaton.p027e.C1454v;
import com.sec.chaton.p027e.EnumC1391ai;
import com.sec.chaton.p027e.EnumC1444l;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p027e.p028a.C1357af;
import com.sec.chaton.p027e.p028a.C1370n;
import com.sec.chaton.p027e.p028a.C1372p;
import com.sec.chaton.p027e.p028a.C1373q;
import com.sec.chaton.p027e.p028a.C1381y;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p035io.entry.GetUnReadMessageList;
import com.sec.chaton.p035io.entry.inner.Msg;
import com.sec.chaton.p035io.entry.inner.MsgTid;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.settings.downloads.C2646u;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3189bd;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.spp.push.Config;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: GetAllUnReadMessageTask.java */
/* renamed from: com.sec.chaton.d.a.bg */
/* loaded from: classes.dex */
public class C1179bg extends AbstractC1145a {

    /* renamed from: b */
    private String f4669b;

    /* renamed from: c */
    private List<MsgTid> f4670c;

    /* renamed from: e */
    private ContentResolver f4671e;

    /* renamed from: f */
    private HashMap<String, C1182bj> f4672f;

    /* renamed from: g */
    private boolean f4673g;

    /* renamed from: h */
    private boolean f4674h;

    public C1179bg(Handler handler, C1580h c1580h) {
        super(handler, c1580h);
        this.f4669b = "GetAllUnReadMessageTask";
        this.f4673g = false;
        this.f4674h = false;
        this.f4671e = GlobalApplication.m6447a().getContentResolver();
        this.f4672f = new HashMap<>();
        this.f4670c = new ArrayList();
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        return null;
    }

    /* renamed from: a */
    private void m5524a(String str, Msg msg) {
        if (C3250y.f11733a) {
            String strSubstring = msg.value;
            if (strSubstring.length() > 5) {
                strSubstring = strSubstring.substring(0, 4);
            }
            C3250y.m11456e("Type : Message, Sender : " + msg.sender + " MsgServerID : " + msg.f5652id + ", ChatType : " + msg.chattype + ", Tid : " + msg.tid + ", Content : " + strSubstring + ", ContentLength : " + strSubstring.length() + ", MsgType : " + msg.type + ", SessionId : " + msg.sessionid + ", Receiver : " + msg.receiver, this.f4669b);
        }
        if (C1373q.m6172a(this.f4671e, str, EnumC1455w.TEXT, msg, (String) null) == EnumC1444l.INSERT) {
            if (!C3159aa.m10962a().m10979a("chaton_id", "").equals(msg.sender)) {
                m5523a(str);
            }
            this.f4673g = true;
        }
    }

    /* renamed from: b */
    private void m5527b(String str, Msg msg) {
        if (C3250y.f11733a) {
            String strSubstring = msg.value;
            if (strSubstring.length() > 5) {
                strSubstring = strSubstring.substring(0, 4);
            }
            C3250y.m11456e("Type : Message, Sender : " + msg.sender + " MsgServerID : " + msg.f5652id + ", ChatType : " + msg.chattype + ", Tid : " + msg.tid + ", Content : " + strSubstring + ", ContentLength : " + strSubstring.length() + ", MsgType : " + msg.type + ", SessionId : " + msg.sessionid + ", Receiver : " + msg.receiver, this.f4669b);
        }
        try {
            if (C1373q.m6172a(this.f4671e, str, C1373q.m6176a(new JSONObject(msg.value)), msg, (String) null) == EnumC1444l.INSERT) {
                if (!C3159aa.m10962a().m10979a("chaton_id", "").equals(msg.sender)) {
                    m5523a(str);
                }
                this.f4673g = true;
            }
        } catch (JSONException e) {
            C3250y.m11443a(e, this.f4669b);
        }
    }

    /* renamed from: c */
    private void m5528c(String str, Msg msg) {
        if (C3250y.f11733a) {
            C3250y.m11456e("Type : Media, Sender : " + msg.sender + ", ChatType : " + msg.chattype + ", Tid : " + msg.tid + ", Content : " + msg.value + ", MsgType : " + msg.type + ", SessionId : " + msg.sessionid + ", Receiver : " + msg.receiver, this.f4669b);
        }
        if (msg.value == null) {
            msg.value = "";
        }
        EnumC1455w enumC1455wM6173a = C1373q.m6173a(msg.value);
        String[] strArrSplit = msg.value.split("\n");
        String str2 = null;
        if ((enumC1455wM6173a == EnumC1455w.CONTACT || enumC1455wM6173a == EnumC1455w.CALENDAR || enumC1455wM6173a == EnumC1455w.DOCUMENT || enumC1455wM6173a == EnumC1455w.FILE) && strArrSplit.length > 5) {
            str2 = strArrSplit[5];
        }
        if (enumC1455wM6173a == EnumC1455w.IMAGE && C2646u.m9661b(msg.value)) {
            enumC1455wM6173a = EnumC1455w.ANICON;
        }
        if (C1373q.m6172a(this.f4671e, str, enumC1455wM6173a, msg, str2) == EnumC1444l.INSERT) {
            if (!C3159aa.m10962a().m10979a("chaton_id", "").equals(msg.sender)) {
                m5523a(str);
            }
            this.f4673g = true;
        }
        if (enumC1455wM6173a == EnumC1455w.IMAGE && !this.f4673g && !this.f4674h) {
            C3250y.m11450b("No need to update and insert: " + strArrSplit[3], getClass().getName());
        }
    }

    /* renamed from: a */
    private void m5525a(String str, ArrayList<Msg> arrayList) {
        Iterator<Msg> it = arrayList.iterator();
        while (it.hasNext()) {
            Msg next = it.next();
            if (C3250y.f11733a) {
                C3250y.m11456e("MsgID : " + next.f5652id + " Time : " + next.time, this.f4669b);
                C3250y.m11456e("Type : NOTI, SessionID : " + next.sessionid + ", ChatType : " + next.chattype + ", tid : " + next.tid, this.f4669b);
                C3250y.m11456e("MSG : " + next.value, this.f4669b);
            }
            if (str != null && !TextUtils.isEmpty(next.value)) {
                String[] strArrSplit = next.value.split("\n");
                StringBuilder sb = new StringBuilder();
                for (String str2 : strArrSplit) {
                    C3250y.m11456e("Row : " + str2, this.f4669b);
                    String[] strArrM5325b = C1075eq.m5325b(str2, ",", 3);
                    if (strArrM5325b.length > 2) {
                        String strM6227h = C1381y.m6227h(this.f4671e, strArrM5325b[1]);
                        String strM6215b = C1381y.m6215b(this.f4671e, strM6227h, strArrM5325b[2]);
                        boolean zM6211a = C1381y.m6211a(this.f4671e, strM6227h, str);
                        EnumC1391ai enumC1391ai = EnumC1391ai.UNKNOWN;
                        if (EnumC1391ai.m6247a(strArrM5325b[0]) == EnumC1391ai.ENTER) {
                            if (!zM6211a) {
                                C1381y.m6210a(this.f4671e, str, strM6227h, strM6215b);
                                enumC1391ai = C3159aa.m10962a().m10979a("chaton_id", "").equals(next.sender) ? EnumC1391ai.INVITE : EnumC1391ai.ENTER;
                            }
                        } else if (EnumC1391ai.m6247a(strArrM5325b[0]) == EnumC1391ai.LEAVE && zM6211a) {
                            C1381y.m6219d(this.f4671e, str, strM6227h);
                            enumC1391ai = EnumC1391ai.LEAVE;
                        }
                        if (enumC1391ai != EnumC1391ai.UNKNOWN) {
                            sb.append(String.format("%d,%s,%s", Integer.valueOf(enumC1391ai.m6248a()), strM6227h, C1075eq.m5318a(strM6215b))).append(Config.KEYVALUE_SPLIT);
                        }
                    }
                }
                String string = sb.toString();
                if (!TextUtils.isEmpty(string)) {
                    C1373q.m6167a(this.f4671e, str, string, next.time.longValue(), next.f5652id, next.sender);
                }
            }
            MsgTid msgTid = new MsgTid();
            msgTid.value = next.tid;
            this.f4670c.add(msgTid);
        }
    }

    /* renamed from: a */
    private void m5526a(List<Msg> list) {
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        HashMap map = new HashMap();
        for (Msg msg : list) {
            if (C3250y.f11733a) {
                C3250y.m11456e("Type : ANS , Sender : " + msg.sender + ", Receiver : " + msg.receiver + ", ChatType : " + msg.chattype + ", MsgID : " + msg.f5652id + ", tid : " + msg.tid, this.f4669b);
            }
            String str = msg.receiver;
            if (!TextUtils.isEmpty(str) && !str.equals(C3159aa.m10962a().m10979a("chaton_id", ""))) {
                map.put(msg.f5652id, Integer.valueOf(map.containsKey(msg.f5652id) ? ((Integer) map.get(msg.f5652id)).intValue() + 1 : 1));
            }
            MsgTid msgTid = new MsgTid();
            msgTid.value = msg.tid;
            this.f4670c.add(msgTid);
        }
        for (Map.Entry entry : map.entrySet()) {
            try {
                ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C1454v.m6343a());
                builderNewUpdate.withValue("message_sever_id", entry.getKey()).withValue("count", entry.getValue());
                arrayList.add(builderNewUpdate.build());
            } finally {
                arrayList.clear();
            }
        }
        try {
            if (arrayList.size() > 0) {
                this.f4671e.applyBatch("com.sec.chaton.provider", arrayList);
            }
        } catch (Exception e) {
            C3250y.m11442a(e.getMessage(), this.f4669b);
        }
    }

    /* renamed from: a */
    private void m5523a(String str) {
        if (this.f4672f.containsKey(str)) {
            this.f4672f.get(str).m5532a(this.f4672f.get(str).m5536d() + 1);
        } else {
            C3250y.m11442a("Error - inboxNO:" + str + " is not in inboxMsgMap. You can not reach here", this.f4669b);
        }
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) throws Throwable {
        String str;
        EnumC1450r enumC1450rM6339a;
        if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
            GetUnReadMessageList getUnReadMessageList = (GetUnReadMessageList) c0267d.m1354e();
            if (getUnReadMessageList == null || getUnReadMessageList.msg == null) {
                C3250y.m11442a("Error - HttpResultObject is null", this.f4669b);
                return;
            }
            if (getUnReadMessageList.msg.size() <= 0) {
                if (C3250y.f11734b) {
                    C3250y.m11450b("unReadMessage.msg.size() is 0", this.f4669b);
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Collections.sort(getUnReadMessageList.msg, new C1180bh(this));
            Iterator<Msg> it = getUnReadMessageList.msg.iterator();
            while (it.hasNext()) {
                Msg next = it.next();
                next.sender = C1381y.m6227h(this.f4671e, next.sender);
                if (!TextUtils.isEmpty(next.sessionid)) {
                    String strM6147k = C1370n.m6147k(this.f4671e, next.sessionid);
                    if (!strM6147k.equals(next.sessionid) && !next.type.equals("ans") && !next.type.equals("noti")) {
                        MsgTid msgTid = new MsgTid();
                        msgTid.value = next.tid;
                        this.f4670c.add(msgTid);
                    }
                    next.sessionid = strM6147k;
                }
                if (next.type.equals("ans")) {
                    arrayList2.add(next);
                } else if (!TextUtils.isEmpty(next.sender) && (!next.sender.startsWith("0999") || C1357af.m5998c(CommonApplication.m11493l(), next.sender))) {
                    arrayList.add(next);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ch@t[c <~~ s] MsgID : ");
            Iterator<Msg> it2 = getUnReadMessageList.msg.iterator();
            while (it2.hasNext()) {
                sb.append(it2.next().f5652id + ",");
            }
            sb.append("API type : ").append(108);
            C3250y.m11457f(sb.toString(), this.f4669b);
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                Msg msg = (Msg) it3.next();
                if (msg == null || !msg.isValid()) {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("msg is invalid", "GetAllUnReadMessageTask");
                    }
                } else if (msg.type.equals("media") || msg.type.equals(Config.NOTIFICATION_INTENT_MSG) || msg.type.equals("noti") || msg.type.equals("content")) {
                    if (C1373q.m6192b(this.f4671e, msg.sender, msg.f5652id, msg.sessionid)) {
                        if (msg.type.equals("noti")) {
                            enumC1450rM6339a = EnumC1450r.GROUPCHAT;
                        } else {
                            enumC1450rM6339a = EnumC1450r.m6339a(msg.chattype.intValue());
                            if (enumC1450rM6339a == EnumC1450r.BROADCAST && !C3159aa.m10962a().m10979a("chaton_id", "").equals(msg.sender)) {
                                enumC1450rM6339a = EnumC1450r.ONETOONE;
                            }
                        }
                        String str2 = msg.sender;
                        if (enumC1450rM6339a == EnumC1450r.ONETOONE && C3159aa.m10962a().m10979a("chaton_id", "").equals(str2)) {
                            str2 = msg.receiver;
                        }
                        String strM6122a = C1370n.m6122a(this.f4671e, enumC1450rM6339a, str2, msg.sessionid);
                        boolean z = true;
                        if (strM6122a == null) {
                            strM6122a = C3189bd.m11137a();
                            C3250y.m11456e("can't find inbox. inboxNO:" + strM6122a + " is generated", this.f4669b);
                            if (msg.type.equals("noti")) {
                                C3250y.m11453c("( msg type noti )can't find inbox. inboxNO:" + strM6122a + " is generated", this.f4669b);
                                z = false;
                            } else {
                                C1370n.m6121a(this.f4671e, strM6122a, enumC1450rM6339a, msg, C1373q.m6175a(msg.value, msg.type));
                            }
                        }
                        if (!this.f4672f.containsKey(strM6122a)) {
                            this.f4672f.put(strM6122a, new C1182bj(this, strM6122a, true));
                            C3250y.m11456e("inbox:" + strM6122a + " is created in inboxMsgMap", this.f4669b);
                            if (z) {
                                boolean z2 = false;
                                if (!C1370n.m6142f(this.f4671e, strM6122a)) {
                                    ArrayList<ContentProviderOperation> arrayList3 = new ArrayList<>();
                                    if (!C3159aa.m10962a().m10979a("chaton_id", "").equals(msg.sender) && !C1381y.m6211a(this.f4671e, msg.sender, strM6122a)) {
                                        C3250y.m11456e("GetAllUnreadMessageTask - InboxNO :" + strM6122a + "Insert sender : " + msg.sender, this.f4669b);
                                        arrayList3.add(C1381y.m6206a(strM6122a, msg.sender));
                                        z2 = true;
                                    }
                                    if ((enumC1450rM6339a != EnumC1450r.ONETOONE || C3159aa.m10962a().m10979a("chaton_id", "").equals(msg.sender)) && !TextUtils.isEmpty(msg.receiver)) {
                                        StringTokenizer stringTokenizer = new StringTokenizer(msg.receiver, ",");
                                        while (stringTokenizer.hasMoreTokens()) {
                                            String strM6227h = C1381y.m6227h(this.f4671e, stringTokenizer.nextToken());
                                            if (!strM6227h.equals(C3159aa.m10962a().m10979a("chaton_id", "")) && !strM6227h.equals(C3159aa.m10962a().m10979a("old_chaton_id", ""))) {
                                                C3250y.m11456e("GetAllUnreadMessageTask - InboxNO :" + strM6122a + "Insert receiver : " + strM6227h, this.f4669b);
                                                arrayList3.add(C1381y.m6206a(strM6122a, strM6227h));
                                                z2 = true;
                                            }
                                        }
                                    }
                                    try {
                                        if (arrayList3.size() > 0) {
                                            this.f4671e.applyBatch("com.sec.chaton.provider", arrayList3);
                                        }
                                    } catch (Exception e) {
                                        C3250y.m11442a(e.getMessage(), this.f4669b);
                                    }
                                    C1370n.m6137c(this.f4671e, strM6122a, 11);
                                }
                                if (z2) {
                                    C1335m.m5784a((Handler) null, strM6122a, msg.sessionid, 0L);
                                }
                            }
                        }
                        if (msg.type.equals("noti")) {
                            this.f4672f.get(strM6122a).m5533a(msg);
                        } else {
                            this.f4673g = false;
                            this.f4672f.get(strM6122a).m5533a(msg);
                            C3250y.m11456e("MsgID : " + msg.f5652id + " Time : " + msg.time, this.f4669b);
                            if (msg.type.equals(Config.NOTIFICATION_INTENT_MSG)) {
                                m5524a(strM6122a, msg);
                            } else if (msg.type.equals("media")) {
                                m5528c(strM6122a, msg);
                            } else if (msg.type.equals("content")) {
                                m5527b(strM6122a, msg);
                            }
                            m5522a(msg, strM6122a);
                        }
                    }
                }
            }
            Iterator<Map.Entry<String, C1182bj>> it4 = this.f4672f.entrySet().iterator();
            while (it4.hasNext()) {
                m5529a(it4.next().getValue());
            }
            m5526a(arrayList2);
            long jLongValue = 0;
            int size = getUnReadMessageList.msg.size();
            if (size > 0) {
                jLongValue = getUnReadMessageList.msg.get(size - 1).time.longValue();
            }
            if (TextUtils.isEmpty(getUnReadMessageList.nextstartkey)) {
                str = "";
            } else {
                str = getUnReadMessageList.nextstartkey;
            }
            if (this.f4670c.size() > 0) {
                C1335m.m5787a((Handler) null, this.f4670c, jLongValue, str);
                return;
            }
            if (jLongValue != 0) {
                C3159aa.m10965a("get_all_unread_message_timestamp", Long.valueOf(jLongValue));
            }
            C3159aa.m10966a("get_all_unread_message_nextstartkey", str);
            if (C3250y.f11734b) {
                C3250y.m11450b("get_all_unread_message_timestamp : " + Long.toString(jLongValue) + ", get_all_unread_message_nextstartkey : " + str, this.f4669b);
            }
            if (!TextUtils.isEmpty(str)) {
                C1335m.m5781a((Handler) null);
                return;
            }
            return;
        }
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000006", "1001", c0267d);
        }
    }

    /* renamed from: a */
    private void m5522a(Msg msg, String str) throws Throwable {
        String string;
        if (msg != null) {
            C1372p c1372pM6140d = C1370n.m6140d(this.f4671e, str);
            if (c1372pM6140d == null) {
                C3250y.m11442a("Error - InBoxData does not exist.", this.f4669b);
                return;
            }
            if (msg.time.longValue() < c1372pM6140d.f5128g) {
                C3250y.m11453c("already received msg. so don't have to show notification", this.f4669b);
                return;
            }
            if (this.f4673g && !C1103a.m5432a(GlobalApplication.m11493l()).m5458a(str) && !msg.sender.equals(C3159aa.m10962a().m10979a("chaton_id", ""))) {
                EnumC1455w enumC1455wM6175a = C1373q.m6175a(msg.value, msg.type);
                Intent intentM1171a = IntentControllerActivity.m1171a(CommonApplication.m11493l(), true);
                intentM1171a.putExtra("callChatList", true);
                EnumC1450r enumC1450rM6339a = EnumC1450r.m6339a(msg.chattype.intValue());
                switch (enumC1450rM6339a) {
                    case ONETOONE:
                    case BROADCAST:
                        intentM1171a.putExtra("inboxNO", str);
                        intentM1171a.putExtra("chatType", EnumC1450r.ONETOONE.m6342a());
                        intentM1171a.putExtra("fromPush", 1);
                        intentM1171a.putExtra("buddyNO", msg.sender);
                        break;
                    case GROUPCHAT:
                        intentM1171a.putExtra("inboxNO", str);
                        intentM1171a.putExtra("chatType", EnumC1450r.GROUPCHAT.m6342a());
                        intentM1171a.putExtra("fromPush", 1);
                        intentM1171a.putExtra("buddyNO", msg.sender);
                        break;
                    case BROADCAST2:
                        intentM1171a.putExtra("inboxNO", str);
                        intentM1171a.putExtra("chatType", EnumC1450r.BROADCAST2.m6342a());
                        intentM1171a.putExtra("fromPush", 1);
                        intentM1171a.putExtra("buddyNO", msg.sender);
                        break;
                }
                int iM6102a = C1370n.m6102a(this.f4671e);
                PendingIntent.getActivity(CommonApplication.m11493l(), -1, intentM1171a, 268435456);
                if (C3250y.f11734b) {
                    C3250y.m11453c("[NOTI] ChatType: " + enumC1450rM6339a + ", unReadCount: " + iM6102a + ", Memory Address:" + this, this.f4669b);
                }
                String string2 = msg.value;
                if (msg.sender.startsWith("0999")) {
                    try {
                        string2 = new JSONObject(msg.value).getString("push_message");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (enumC1455wM6175a == EnumC1455w.POLL) {
                    try {
                        string = new JSONObject(string2).getJSONObject("push_message").toString();
                    } catch (JSONException e2) {
                        C3250y.m11443a(e2, this.f4669b);
                    }
                } else {
                    string = string2;
                }
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                C1103a.m5432a(CommonApplication.m11493l()).m5455a(msg.sender, string, str, Long.valueOf(msg.f5652id).longValue(), enumC1455wM6175a, enumC1450rM6339a.m6342a(), msg.sessionid, C1381y.m6220e(this.f4671e, str, msg.sender), c1372pM6140d.f5139r, msg.time.longValue(), c1372pM6140d.f5136o, c1372pM6140d.f5137p, c1372pM6140d.f5129h, c1372pM6140d.f5140s, "N");
            }
        }
    }

    /* renamed from: a */
    public void m5529a(C1182bj c1182bj) {
        int iM5536d;
        String strM5531a = c1182bj.m5531a();
        ArrayList<Msg> arrayListM5534b = c1182bj.m5534b();
        C1372p c1372pM6140d = C1370n.m6140d(this.f4671e, strM5531a);
        if (c1372pM6140d == null) {
            m5525a((String) null, c1182bj.m5535c());
            return;
        }
        if (arrayListM5534b.size() > 0) {
            Msg msg = arrayListM5534b.get(arrayListM5534b.size() - 1);
            C3250y.m11456e("<LastMsg> - MsgID : " + msg.f5652id + " Time : " + msg.time, this.f4669b);
            m5525a(strM5531a, c1182bj.m5535c());
            if (msg.time.longValue() >= c1372pM6140d.f5128g) {
                c1372pM6140d.f5128g = msg.time.longValue();
                c1372pM6140d.f5131j = Long.valueOf(msg.f5652id).longValue();
                c1372pM6140d.f5132k = msg.sender;
                EnumC1450r enumC1450rM6339a = EnumC1450r.m6339a(msg.chattype.intValue());
                if (enumC1450rM6339a == EnumC1450r.BROADCAST) {
                    c1372pM6140d.f5124c = EnumC1450r.ONETOONE.m6342a();
                } else {
                    c1372pM6140d.f5124c = enumC1450rM6339a.m6342a();
                    c1372pM6140d.f5136o = msg.address;
                    c1372pM6140d.f5137p = msg.port.intValue();
                    c1372pM6140d.f5130i = msg.sessionid;
                }
                StringBuilder sb = new StringBuilder();
                if (msg.sender.equals(C3159aa.m10962a().m10979a("chaton_id", ""))) {
                    sb.append(1).append(Config.KEYVALUE_SPLIT);
                } else {
                    sb.append(2).append(Config.KEYVALUE_SPLIT);
                }
                sb.append(C1373q.m6175a(msg.value, msg.type).m6364a()).append(Config.KEYVALUE_SPLIT);
                C3250y.m11450b("updateWithLastMsg - (lastmsg) last msg sender : " + msg.sender.toString(), this.f4669b);
                if (msg.sender.startsWith("0999")) {
                    try {
                        sb.append(C1075eq.m5318a(new JSONObject(msg.value).getString("push_message")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    sb.append(C1075eq.m5318a(msg.value));
                }
                sb.append(Config.KEYVALUE_SPLIT);
                if (enumC1450rM6339a == EnumC1450r.GROUPCHAT) {
                    sb.append(C1075eq.m5318a(C1381y.m6222f(this.f4671e, msg.sender)));
                }
                c1372pM6140d.f5126e = sb.toString();
            }
            iM5536d = this.f4672f.get(strM5531a).m5536d();
            if (C1103a.m5432a(GlobalApplication.m11493l()).m5458a(strM5531a)) {
                iM5536d = 0;
            }
        } else {
            m5525a(strM5531a, c1182bj.m5535c());
            iM5536d = 0;
        }
        C1370n.m6105a(this.f4671e, strM5531a, c1372pM6140d, iM5536d);
        C3250y.m11456e("updateInBox inboxNO:" + strM5531a, this.f4669b);
    }
}
