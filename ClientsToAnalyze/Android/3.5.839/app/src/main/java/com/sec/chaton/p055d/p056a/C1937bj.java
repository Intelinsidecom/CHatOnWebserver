package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1015an;
import com.sec.chaton.C1066bf;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.chat.C1739gl;
import com.sec.chaton.chat.notification.C1813b;
import com.sec.chaton.chat.notification.C1828q;
import com.sec.chaton.chat.translate.C1850c;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.C2134o;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2231as;
import com.sec.chaton.p057e.EnumC2292l;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.p058a.C2176ab;
import com.sec.chaton.p057e.p058a.C2186al;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p057e.p058a.C2201o;
import com.sec.chaton.p057e.p058a.C2204r;
import com.sec.chaton.p063i.p064a.C2404a;
import com.sec.chaton.p065io.entry.GetUnReadMessageList;
import com.sec.chaton.p065io.entry.inner.Msg;
import com.sec.chaton.p065io.entry.inner.MsgTid;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.settings.p096a.C3460d;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
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
/* renamed from: com.sec.chaton.d.a.bj */
/* loaded from: classes.dex */
public class C1937bj extends AbstractC1900a {

    /* renamed from: b */
    private String f7222b;

    /* renamed from: c */
    private List<MsgTid> f7223c;

    /* renamed from: d */
    private ContentResolver f7224d;

    /* renamed from: e */
    private HashMap<String, C1939bl> f7225e;

    /* renamed from: g */
    private boolean f7226g;

    /* renamed from: h */
    private boolean f7227h;

    public C1937bj(C2454e c2454e) {
        super(c2454e);
        this.f7222b = "GetAllUnReadMessageTask";
        this.f7226g = false;
        this.f7227h = false;
        this.f7224d = GlobalApplication.m10279a().getContentResolver();
        this.f7225e = new HashMap<>();
        this.f7223c = new ArrayList();
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        return null;
    }

    /* renamed from: a */
    private void m9112a(String str, Msg msg, boolean z) {
        if (C4904y.f17872b) {
            String strSubstring = msg.value;
            if (strSubstring.length() > 5) {
                strSubstring = strSubstring.substring(0, 4);
            }
            C4904y.m18639b("Type : Message, Sender : " + msg.sender + " MsgServerID : " + msg.f8574id + ", ChatType : " + msg.chattype + ", Tid : " + msg.tid + ", Content : " + strSubstring + ", ContentLength : " + strSubstring.length() + ", MsgType : " + msg.type + ", SessionId : " + msg.sessionid + ", Receiver : " + msg.receiver, this.f7222b);
        }
        if (C2204r.m10025a(this.f7224d, str, EnumC2214ab.TEXT, msg, (String) null, z) == EnumC2292l.INSERT) {
            if (!C4809aa.m18104a().m18121a("chaton_id", "").equals(msg.sender)) {
                m9111a(str);
            }
            this.f7226g = true;
        }
        if (C2198l.m9962o(GlobalApplication.m18732r().getContentResolver(), str)) {
            C1850c.m9024d().m9035b(Long.valueOf(msg.f8574id), msg.value, false, null, null, str, C4809aa.m18104a().m18121a("chaton_id", "").equals(msg.sender) ? false : true);
            C4904y.m18639b("enable translate, inboxNo : " + str, this.f7222b);
        }
    }

    /* renamed from: b */
    private void m9115b(String str, Msg msg, boolean z) {
        if (C4904y.f17872b) {
            String strSubstring = msg.value;
            if (strSubstring.length() > 5) {
                strSubstring = strSubstring.substring(0, 4);
            }
            C4904y.m18639b("Type : Message, Sender : " + msg.sender + " MsgServerID : " + msg.f8574id + ", ChatType : " + msg.chattype + ", Tid : " + msg.tid + ", Content : " + strSubstring + ", ContentLength : " + strSubstring.length() + ", MsgType : " + msg.type + ", SessionId : " + msg.sessionid + ", Receiver : " + msg.receiver, this.f7222b);
        }
        try {
            if (C2204r.m10025a(this.f7224d, str, C2204r.m10022a(new JSONObject(msg.value)), msg, (String) null, z) == EnumC2292l.INSERT) {
                if (!C4809aa.m18104a().m18121a("chaton_id", "").equals(msg.sender)) {
                    m9111a(str);
                }
                this.f7226g = true;
            }
        } catch (JSONException e) {
            C4904y.m18635a(e, this.f7222b);
        }
    }

    /* renamed from: c */
    private void m9117c(String str, Msg msg, boolean z) {
        if (C4904y.f17872b) {
            C4904y.m18639b("Type : Media, Sender : " + msg.sender + ", ChatType : " + msg.chattype + ", Tid : " + msg.tid + ", Content : " + msg.value + ", MsgType : " + msg.type + ", SessionId : " + msg.sessionid + ", Receiver : " + msg.receiver, this.f7222b);
        }
        if (msg.value == null) {
            msg.value = "";
        }
        EnumC2214ab enumC2214abM10019a = C2204r.m10019a(msg.value);
        String[] strArrSplit = msg.value.split("\n");
        String str2 = ((enumC2214abM10019a == EnumC2214ab.CONTACT || enumC2214abM10019a == EnumC2214ab.CALENDAR || enumC2214abM10019a == EnumC2214ab.DOCUMENT || enumC2214abM10019a == EnumC2214ab.FILE) && strArrSplit.length > 5) ? strArrSplit[5] : null;
        if (enumC2214abM10019a == EnumC2214ab.IMAGE && C3460d.m13778b(msg.value)) {
            enumC2214abM10019a = EnumC2214ab.ANICON;
        }
        if (C2204r.m10025a(this.f7224d, str, enumC2214abM10019a, msg, str2, z) == EnumC2292l.INSERT) {
            if (!C4809aa.m18104a().m18121a("chaton_id", "").equals(msg.sender)) {
                m9111a(str);
            }
            this.f7226g = true;
        }
        if (enumC2214abM10019a == EnumC2214ab.IMAGE && !this.f7226g && !this.f7227h) {
            C4904y.m18639b("No need to update and insert: " + strArrSplit[3], getClass().getName());
        }
        if (C2198l.m9962o(GlobalApplication.m18732r().getContentResolver(), str)) {
            C1850c.m9024d().m9035b(Long.valueOf(msg.f8574id), msg.value, false, null, null, str, C4809aa.m18104a().m18121a("chaton_id", "").equals(msg.sender) ? false : true);
            C4904y.m18639b("enable translate, inboxNo : " + str, this.f7222b);
        }
    }

    /* renamed from: a */
    private void m9113a(String str, ArrayList<Msg> arrayList) {
        Iterator<Msg> it = arrayList.iterator();
        while (it.hasNext()) {
            Msg next = it.next();
            if (C4904y.f17872b) {
                C4904y.m18639b("MsgID : " + next.f8574id + " Time : " + next.time, this.f7222b);
                C4904y.m18639b("Type : NOTI, SessionID : " + next.sessionid + ", ChatType : " + next.chattype + ", tid : " + next.tid, this.f7222b);
                C4904y.m18639b("MSG : " + next.value, this.f7222b);
            }
            if (str != null && !TextUtils.isEmpty(next.value)) {
                String[] strArrSplit = next.value.split("\n");
                StringBuilder sb = new StringBuilder();
                for (String str2 : strArrSplit) {
                    C4904y.m18639b("Row : " + str2, this.f7222b);
                    String[] strArrM8650b = C1736gi.m8650b(str2, ",", 3);
                    if (strArrM8650b.length > 2) {
                        String strM9697g = C2176ab.m9697g(this.f7224d, strArrM8650b[1]);
                        String strM9685b = C2176ab.m9685b(this.f7224d, strM9697g, strArrM8650b[2]);
                        boolean zM9681a = C2176ab.m9681a(this.f7224d, strM9697g, str);
                        EnumC2231as enumC2231as = EnumC2231as.UNKNOWN;
                        if (EnumC2231as.m10099a(strArrM8650b[0]) == EnumC2231as.ENTER) {
                            if (!zM9681a) {
                                if (!C4809aa.m18104a().m18121a("chaton_id", "").equals(strM9697g)) {
                                    C2176ab.m9676a(this.f7224d, str, strM9697g, strM9685b);
                                }
                                enumC2231as = C4809aa.m18104a().m18121a("chaton_id", "").equals(next.sender) ? EnumC2231as.INVITE : EnumC2231as.ENTER;
                            }
                        } else if (EnumC2231as.m10099a(strArrM8650b[0]) == EnumC2231as.LEAVE && zM9681a) {
                            C2176ab.m9692d(this.f7224d, str, strM9697g);
                            enumC2231as = EnumC2231as.LEAVE;
                        }
                        if (enumC2231as != EnumC2231as.UNKNOWN) {
                            sb.append(String.format("%d,%s,%s", Integer.valueOf(enumC2231as.m10100a()), strM9697g, C1736gi.m8632a(strM9685b))).append(Config.KEYVALUE_SPLIT);
                        }
                    }
                }
                String string = sb.toString();
                if (!TextUtils.isEmpty(string)) {
                    C2204r.m10013a(this.f7224d, str, string, next.time.longValue(), next.f8574id, next.sender);
                }
            }
            MsgTid msgTid = new MsgTid();
            msgTid.value = next.tid;
            this.f7223c.add(msgTid);
        }
    }

    /* renamed from: a */
    private void m9114a(List<Msg> list) throws Throwable {
        HashMap map = new HashMap();
        for (Msg msg : list) {
            if (C4904y.f17872b) {
                C4904y.m18639b("Type : ANS , Sender : " + msg.sender + ", Receiver : " + msg.receiver + ", ChatType : " + msg.chattype + ", MsgID : " + msg.f8574id + ", tid : " + msg.tid, this.f7222b);
            }
            MsgTid msgTid = new MsgTid();
            msgTid.value = msg.tid;
            this.f7223c.add(msgTid);
            String strM10028a = C2204r.m10028a(msg.f8574id, false);
            if (map.containsKey(strM10028a)) {
                ((ArrayList) map.get(strM10028a)).add(C1739gl.m8663a(Long.valueOf(msg.f8574id).longValue(), msg.receiver));
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(C1739gl.m8663a(Long.valueOf(msg.f8574id).longValue(), msg.receiver));
                map.put(strM10028a, arrayList);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            C1736gi.m8647b((String) entry.getKey(), (ArrayList<C1739gl>) entry.getValue());
        }
    }

    /* renamed from: b */
    private boolean m9116b(List<Msg> list) throws Throwable {
        boolean z;
        for (Msg msg : list) {
            if (C4904y.f17872b) {
                C4904y.m18639b("Type : MACK , Sender : " + msg.sender + ", Receiver : " + msg.receiver + ", ChatType : " + msg.chattype + ", MsgID : " + msg.f8574id + ", tid : " + msg.tid, this.f7222b);
            }
            MsgTid msgTid = new MsgTid();
            msgTid.value = msg.tid;
            this.f7223c.add(msgTid);
            String strM10028a = C2204r.m10028a(msg.f8574id, true);
            if (TextUtils.isEmpty(strM10028a)) {
                C4904y.m18634a("handleMirrorAck Error - inboxNO is empty. You can not reach here", this.f7222b);
            } else {
                if (!this.f7225e.containsKey(strM10028a)) {
                    this.f7225e.put(strM10028a, new C1939bl(this, strM10028a, true));
                    C4904y.m18639b("inbox:" + strM10028a + " is created in inboxMsgMap", this.f7222b);
                }
                this.f7225e.get(strM10028a).f7235g = msg;
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, C1939bl>> it = this.f7225e.entrySet().iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            C1939bl value = it.next().getValue();
            Msg msgM9128e = value.m9128e();
            if (msgM9128e != null) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("handleMirrorAck - inboxNo : " + value.m9122a() + ", LastMirrorAck msgid : " + msgM9128e.f8574id, this.f7222b);
                }
                if (!TextUtils.isEmpty(C2204r.m10027a(msgM9128e.receiver, Long.valueOf(msgM9128e.f8574id).longValue(), false))) {
                    arrayList.add(value.m9122a());
                }
                z = true;
            } else {
                z = z2;
            }
            z2 = z;
        }
        C0991aa.m6037a().m18961c(new C1015an((String[]) arrayList.toArray(new String[0])));
        C0991aa.m6037a().m18961c(new C1066bf(C1828q.f6913a, -1));
        return z2;
    }

    /* renamed from: c */
    private void m9118c(List<Msg> list) throws Throwable {
        for (Msg msg : list) {
            if (C4904y.f17872b) {
                C4904y.m18639b("Type : UNDO , Sender : " + msg.sender + ", Receiver : " + msg.receiver + ", ChatType : " + msg.chattype + ", MsgID : " + msg.f8574id + ", tid : " + msg.tid, this.f7222b);
            }
            C2204r.m10029a(Long.valueOf(msg.f8574id).longValue(), msg.sender);
        }
    }

    /* renamed from: a */
    private void m9111a(String str) {
        if (this.f7225e.containsKey(str)) {
            this.f7225e.get(str).m9123a(this.f7225e.get(str).m9127d() + 1);
        } else {
            C4904y.m18634a("Error - inboxNO:" + str + " is not in inboxMsgMap. You can not reach here", this.f7222b);
        }
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) throws Throwable {
        String str;
        String strM9925a;
        String str2;
        if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
            GetUnReadMessageList getUnReadMessageList = (GetUnReadMessageList) c0778b.m3110e();
            if (getUnReadMessageList == null || getUnReadMessageList.msg == null) {
                C4904y.m18634a("Error - HttpResultObject is null", this.f7222b);
                return;
            }
            if (getUnReadMessageList.msg.size() <= 0) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("unReadMessage.msg.size() is 0", this.f7222b);
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            String str3 = "";
            Msg msg = null;
            Collections.sort(getUnReadMessageList.msg, new C1938bk(this));
            Iterator<Msg> it = getUnReadMessageList.msg.iterator();
            while (it.hasNext()) {
                Msg next = it.next();
                next.sender = C2176ab.m9697g(this.f7224d, next.sender);
                if (!TextUtils.isEmpty(next.sessionid)) {
                    next.sessionid = C2198l.m9961n(this.f7224d, next.sessionid);
                }
                if (next.type.equals("ans")) {
                    arrayList2.add(next);
                } else if (next.type.equals("mack")) {
                    arrayList3.add(next);
                } else if (next.type.equals("undo")) {
                    arrayList4.add(next);
                    arrayList5.add(next.f8574id);
                } else if (!TextUtils.isEmpty(next.sender) && (!next.sender.startsWith("0999") || C2186al.m9775c(CommonApplication.m18732r(), next.sender))) {
                    arrayList.add(next);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ch@t[c <~~ s] MsgID : ");
            Iterator<Msg> it2 = getUnReadMessageList.msg.iterator();
            while (it2.hasNext()) {
                sb.append(it2.next().f8574id + ",");
            }
            sb.append("API type : ").append(108);
            C4904y.m18647f(sb.toString(), this.f7222b);
            GlobalApplication.m18732r().getString(R.string.message_is_recalled);
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                Msg msg2 = (Msg) it3.next();
                if (msg2 == null || !msg2.isValid()) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("msg is invalid", "GetAllUnReadMessageTask");
                    }
                } else if (msg2.type.equals("media") || msg2.type.equals(Config.NOTIFICATION_INTENT_MSG) || msg2.type.equals("noti") || msg2.type.equals("content")) {
                    if (C2204r.m10049b(this.f7224d, msg2.sender, msg2.f8574id, msg2.sessionid)) {
                        EnumC2300t enumC2300tM10207a = EnumC2300t.m10207a(msg2.chattype.intValue());
                        if (enumC2300tM10207a == EnumC2300t.BROADCAST && !C4809aa.m18104a().m18121a("chaton_id", "").equals(msg2.sender)) {
                            enumC2300tM10207a = EnumC2300t.ONETOONE;
                        }
                        String str4 = msg2.sender;
                        if (enumC2300tM10207a == EnumC2300t.ONETOONE && C4809aa.m18104a().m18121a("chaton_id", "").equals(str4)) {
                            str4 = msg2.receiver;
                        }
                        if (enumC2300tM10207a == EnumC2300t.TOPIC) {
                            strM9925a = C2198l.m9939b(this.f7224d, msg2.sessionid);
                            if (TextUtils.isEmpty(strM9925a)) {
                                if (C4904y.f17873c) {
                                    C4904y.m18641c("It is topic chat and inboxNo is null. Throw the message away.", this.f7222b);
                                }
                                MsgTid msgTid = new MsgTid();
                                msgTid.value = msg2.tid;
                                this.f7223c.add(msgTid);
                            }
                        } else {
                            strM9925a = C2198l.m9925a(this.f7224d, enumC2300tM10207a, str4, msg2.sessionid);
                        }
                        if (!this.f7225e.containsKey(strM9925a)) {
                            this.f7225e.put(strM9925a, new C1939bl(this, strM9925a, true));
                            C4904y.m18639b("inbox:" + strM9925a + " is created in inboxMsgMap", this.f7222b);
                            boolean z = false;
                            if (!C2198l.m9955h(this.f7224d, strM9925a)) {
                                ArrayList<ContentProviderOperation> arrayList6 = new ArrayList<>();
                                if (!C4809aa.m18104a().m18121a("chaton_id", "").equals(msg2.sender) && !C2176ab.m9681a(this.f7224d, msg2.sender, strM9925a)) {
                                    C4904y.m18639b("GetAllUnreadMessageTask - InboxNO :" + strM9925a + "Insert sender : " + msg2.sender, this.f7222b);
                                    arrayList6.add(C2176ab.m9670a(strM9925a, msg2.sender));
                                    z = true;
                                }
                                if ((enumC2300tM10207a != EnumC2300t.ONETOONE || C4809aa.m18104a().m18121a("chaton_id", "").equals(msg2.sender)) && !TextUtils.isEmpty(msg2.receiver)) {
                                    StringTokenizer stringTokenizer = new StringTokenizer(msg2.receiver, ",");
                                    while (stringTokenizer.hasMoreTokens()) {
                                        String strM9697g = C2176ab.m9697g(this.f7224d, stringTokenizer.nextToken());
                                        if (!strM9697g.equals(C4809aa.m18104a().m18121a("chaton_id", "")) && !strM9697g.equals(C4809aa.m18104a().m18121a("old_chaton_id", ""))) {
                                            C4904y.m18639b("GetAllUnreadMessageTask - InboxNO :" + strM9925a + "Insert receiver : " + strM9697g, this.f7222b);
                                            arrayList6.add(C2176ab.m9670a(strM9925a, strM9697g));
                                            z = true;
                                        }
                                    }
                                }
                                try {
                                    if (arrayList6.size() > 0) {
                                        this.f7224d.applyBatch("com.sec.chaton.provider", arrayList6);
                                    }
                                } catch (Exception e) {
                                    C4904y.m18634a(e.getMessage(), this.f7222b);
                                }
                                C2198l.m9943c(this.f7224d, strM9925a, 11);
                                C2198l.m9949d(this.f7224d, strM9925a);
                            }
                            if (z) {
                                C2134o.m9570a((Handler) null, strM9925a, msg2.sessionid, 0L);
                            }
                        }
                        if (msg2.type.equals("noti")) {
                            this.f7225e.get(strM9925a).m9124a(msg2);
                            msg2 = msg;
                            str2 = str3;
                        } else {
                            this.f7226g = false;
                            this.f7225e.get(strM9925a).m9124a(msg2);
                            boolean z2 = false;
                            if (msg2.type.equals(Config.NOTIFICATION_INTENT_MSG) || msg2.type.equals("media") || msg2.type.equals("content")) {
                                if (arrayList5.contains(msg2.f8574id)) {
                                    z2 = true;
                                    if (C4904y.f17872b) {
                                        C4904y.m18639b("undo message : type(" + msg2.type + "), id(" + msg2.f8574id + ")", this.f7222b);
                                    }
                                }
                                if (msg2.type.equals(Config.NOTIFICATION_INTENT_MSG)) {
                                    m9112a(strM9925a, msg2, z2);
                                } else if (msg2.type.equals("media")) {
                                    m9117c(strM9925a, msg2, z2);
                                } else if (msg2.type.equals("content")) {
                                    m9115b(strM9925a, msg2, z2);
                                }
                            }
                            MsgTid msgTid2 = new MsgTid();
                            msgTid2.value = msg2.tid;
                            this.f7223c.add(msgTid2);
                            str2 = strM9925a;
                        }
                        msg = msg2;
                        str3 = str2;
                    }
                }
            }
            Iterator<Map.Entry<String, C1939bl>> it4 = this.f7225e.entrySet().iterator();
            while (it4.hasNext()) {
                m9119a(it4.next().getValue());
            }
            m9114a(arrayList2);
            boolean zM9116b = m9116b(arrayList3);
            m9118c(arrayList4);
            if (zM9116b || (msg != null && !TextUtils.isEmpty(str3))) {
                C1813b.m8906b().m8934b(C1813b.f6835d);
            }
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
            if (this.f7223c.size() > 0) {
                C2134o.m9574a((Handler) null, this.f7223c, jLongValue, str);
            } else {
                if (jLongValue != 0) {
                    C4809aa.m18107a("get_all_unread_message_timestamp", Long.valueOf(jLongValue));
                }
                C4809aa.m18108a("get_all_unread_message_nextstartkey", str);
                if (C4904y.f17872b) {
                    C4904y.m18639b("get_all_unread_message_timestamp : " + Long.toString(jLongValue) + ", get_all_unread_message_nextstartkey : " + str, this.f7222b);
                }
                if (!TextUtils.isEmpty(str)) {
                    C2134o.m9567a(null);
                }
            }
            C0991aa.m6037a().m18961c(new C1015an((String[]) this.f7225e.keySet().toArray(new String[0])));
            C0991aa.m6037a().m18962d(new C1066bf(C1828q.f6913a, -1));
            return;
        }
        C2404a.m10430a("01000006", "1001", c0778b);
    }

    /* renamed from: a */
    public void m9119a(C1939bl c1939bl) {
        int iM9127d;
        String strM9122a = c1939bl.m9122a();
        ArrayList<Msg> arrayListM9125b = c1939bl.m9125b();
        C2201o c2201oM9951e = C2198l.m9951e(this.f7224d, strM9122a);
        if (c2201oM9951e == null) {
            m9113a((String) null, c1939bl.m9126c());
            return;
        }
        if (arrayListM9125b.size() > 0) {
            Msg msg = arrayListM9125b.get(arrayListM9125b.size() - 1);
            C4904y.m18639b("<LastMsg> - MsgID : " + msg.f8574id + " Time : " + msg.time, this.f7222b);
            m9113a(strM9122a, c1939bl.m9126c());
            if (msg.time.longValue() >= c2201oM9951e.f7844g) {
                c2201oM9951e.f7844g = msg.time.longValue();
                c2201oM9951e.f7847j = Long.valueOf(msg.f8574id).longValue();
                c2201oM9951e.f7848k = msg.sender;
                EnumC2300t enumC2300tM10207a = EnumC2300t.m10207a(msg.chattype.intValue());
                if (enumC2300tM10207a == EnumC2300t.BROADCAST) {
                    c2201oM9951e.f7840c = EnumC2300t.ONETOONE.m10210a();
                } else {
                    c2201oM9951e.f7840c = enumC2300tM10207a.m10210a();
                    c2201oM9951e.f7852o = msg.address;
                    c2201oM9951e.f7853p = msg.port.intValue();
                    c2201oM9951e.f7846i = msg.sessionid;
                }
                StringBuilder sb = new StringBuilder();
                if (msg.sender.equals(C4809aa.m18104a().m18121a("chaton_id", ""))) {
                    sb.append(1).append(Config.KEYVALUE_SPLIT);
                } else {
                    sb.append(2).append(Config.KEYVALUE_SPLIT);
                }
                EnumC2214ab enumC2214abM10021a = C2204r.m10021a(msg.value, msg.type);
                if (msg.sender.startsWith("0999")) {
                    enumC2214abM10021a = EnumC2214ab.LIVECONTENTS;
                }
                sb.append(enumC2214abM10021a.m10076a()).append(Config.KEYVALUE_SPLIT);
                if (C4904y.f17872b) {
                    C4904y.m18639b("updateWithLastMsg - (lastmsg) last msg sender : " + msg.sender.toString(), this.f7222b);
                }
                if (msg.sender.startsWith("0999")) {
                    try {
                        sb.append(C1736gi.m8632a(new JSONObject(msg.value).getString("push_message")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    sb.append(C1736gi.m8632a(msg.value));
                }
                sb.append(Config.KEYVALUE_SPLIT);
                if (enumC2300tM10207a == EnumC2300t.GROUPCHAT || enumC2300tM10207a == EnumC2300t.TOPIC) {
                    sb.append(C1736gi.m8632a(C2176ab.m9695f(this.f7224d, msg.sender)));
                }
                c2201oM9951e.f7842e = sb.toString();
            }
            iM9127d = this.f7225e.get(strM9122a).m9127d();
            if (C1813b.m8906b().m8931a(strM9122a)) {
                iM9127d = 0;
            }
        } else {
            m9113a(strM9122a, c1939bl.m9126c());
            iM9127d = 0;
        }
        C2198l.m9908a(this.f7224d, strM9122a, c2201oM9951e, iM9127d);
        C4904y.m18639b("updateInBox inboxNO:" + strM9122a, this.f7222b);
    }
}
