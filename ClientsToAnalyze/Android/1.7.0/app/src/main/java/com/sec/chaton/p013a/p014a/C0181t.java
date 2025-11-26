package com.sec.chaton.p013a.p014a;

import android.app.PendingIntent;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.chat.C0520a;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p013a.C0227z;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0503j;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.p025d.C0662o;
import com.sec.chaton.p025d.EnumC0650c;
import com.sec.chaton.p025d.EnumC0651d;
import com.sec.chaton.p025d.EnumC0664q;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.p025d.EnumC0672y;
import com.sec.chaton.p025d.p026a.C0631k;
import com.sec.chaton.p025d.p026a.C0634n;
import com.sec.chaton.p025d.p026a.C0635o;
import com.sec.chaton.p025d.p026a.C0636p;
import com.sec.chaton.p033io.entry.GetUnReadMessageList;
import com.sec.chaton.p033io.entry.inner.Msg;
import com.sec.chaton.p033io.entry.inner.MsgTid;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1332g;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1351z;
import com.sec.spp.push.Config;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/* compiled from: GetAllUnReadMessageTask.java */
/* renamed from: com.sec.chaton.a.a.t */
/* loaded from: classes.dex */
public class C0181t extends AbstractRunnableC0153bb {

    /* renamed from: a */
    private List f446a;

    /* renamed from: b */
    private ContentResolver f447b;

    /* renamed from: f */
    private HashMap f448f;

    /* renamed from: g */
    private boolean f449g;

    /* renamed from: h */
    private boolean f450h;

    public C0181t(Handler handler, C0503j c0503j) {
        super(handler, c0503j);
        this.f449g = false;
        this.f450h = false;
        this.f447b = GlobalApplication.m3105f().getContentResolver();
        this.f448f = new HashMap();
        this.f446a = new ArrayList();
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public String mo670a() {
        return null;
    }

    /* renamed from: a */
    private void m719a(String str, Msg msg) {
        if (C1341p.f4578b) {
            C1341p.m4662e("Type : Message, Sender : " + msg.sender + " MsgServerID : " + msg.f2448id + ", ChatType : " + msg.chattype + ", Tid : " + msg.tid + ", Content : " + msg.value + ", MsgType : " + msg.type + ", Receiver : " + msg.receiver, getClass().getSimpleName());
        }
        EnumC0665r enumC0665rM3011a = EnumC0665r.m3011a(msg.chattype.intValue());
        EnumC0651d enumC0651d = EnumC0651d.TEXT;
        if (enumC0665rM3011a == EnumC0665r.GROUPCHAT) {
            EnumC0665r enumC0665r = EnumC0665r.GROUPCHAT;
        } else {
            EnumC0665r enumC0665r2 = EnumC0665r.ONETOONE;
        }
        if (C0635o.m2934a(this.f447b, str, enumC0651d, msg, (String) null) == EnumC0672y.INSERT) {
            m718a(str);
            this.f449g = true;
        }
    }

    /* renamed from: b */
    private void m721b(String str, Msg msg) {
        if (C1341p.f4578b) {
            C1341p.m4662e("Type : Media, Sender : " + msg.sender + ", ChatType : " + msg.chattype + ", Tid : " + msg.tid + ", Content : " + msg.value + ", MsgType : " + msg.type + ", Receiver : " + msg.receiver, getClass().getSimpleName());
        }
        if (EnumC0665r.m3011a(msg.chattype.intValue()) == EnumC0665r.GROUPCHAT) {
            EnumC0665r enumC0665r = EnumC0665r.GROUPCHAT;
        } else {
            EnumC0665r enumC0665r2 = EnumC0665r.ONETOONE;
        }
        if (msg.value == null) {
            msg.value = "";
        }
        EnumC0651d enumC0651dM2931a = C0635o.m2931a(msg.value);
        String[] strArrSplit = msg.value.split("\n");
        String str2 = null;
        if ((enumC0651dM2931a == EnumC0651d.CONTACT || enumC0651dM2931a == EnumC0651d.CALENDAR) && strArrSplit.length > 5) {
            str2 = strArrSplit[5];
        }
        if (C0635o.m2934a(this.f447b, str, enumC0651dM2931a, msg, str2) == EnumC0672y.INSERT) {
            m718a(str);
            this.f449g = true;
        }
        if (enumC0651dM2931a == EnumC0651d.IMAGE && !this.f449g && !this.f450h) {
            C1341p.m4658b("No need to update and insert: " + strArrSplit[3], getClass().getName());
        }
    }

    /* renamed from: a */
    private void m720a(String str, ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Msg msg = (Msg) it.next();
            if (C1341p.f4578b) {
                C1341p.m4662e("MsgID : " + msg.f2448id + " Time : " + msg.time, getClass().getSimpleName());
                C1341p.m4662e("Type : NOTI, SessionID : " + msg.sessionid + ", ChatType : " + msg.chattype + ", tid : " + msg.tid, getClass().getSimpleName());
                C1341p.m4662e("MSG : " + msg.value, getClass().getSimpleName());
            }
            if (str != null && !TextUtils.isEmpty(msg.value)) {
                String[] strArrSplit = msg.value.split("\n");
                StringBuilder sb = new StringBuilder();
                for (String str2 : strArrSplit) {
                    C1341p.m4662e("Row : " + str2, getClass().getSimpleName());
                    String[] strArrM2717a = C0520a.m2717a(str2, ",", 3);
                    if (strArrM2717a.length > 2) {
                        String str3 = strArrM2717a[1];
                        String strM2866b = C0631k.m2866b(this.f447b, str3, strArrM2717a[2]);
                        EnumC0664q enumC0664q = EnumC0664q.UNKNOWN;
                        if (EnumC0664q.m3009a(strArrM2717a[0]) == EnumC0664q.ENTER) {
                            if (!C0631k.m2864a(this.f447b, str3, str)) {
                                C0631k.m2863a(this.f447b, str, str3, strM2866b);
                            }
                            enumC0664q = EnumC0664q.ENTER;
                        } else if (EnumC0664q.m3009a(strArrM2717a[0]) == EnumC0664q.LEAVE) {
                            C0631k.m2871d(this.f447b, str, str3);
                            enumC0664q = EnumC0664q.LEAVE;
                        }
                        sb.append(String.format("%d,%s,%s", Integer.valueOf(enumC0664q.m3010a()), str3, C0520a.m2713a(strM2866b))).append(";");
                    }
                }
                C0635o.m2929a(this.f447b, str, sb.toString(), msg.time.longValue(), msg.f2448id, msg.sender);
            }
            MsgTid msgTid = new MsgTid();
            msgTid.value = msg.tid;
            this.f446a.add(msgTid);
        }
    }

    /* renamed from: a */
    private ContentProviderOperation m717a(Msg msg) {
        if (C1341p.f4578b) {
            C1341p.m4662e("Type : ANS , Sender : " + msg.sender + ", ChatType : " + msg.chattype + ", MsgID : " + msg.f2448id + ", tid : " + msg.tid, getClass().getSimpleName());
        }
        String str = msg.f2448id;
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C0662o.m2996a(str));
        builderNewUpdate.withValue("message_sever_id", str);
        MsgTid msgTid = new MsgTid();
        msgTid.value = msg.tid;
        this.f446a.add(msgTid);
        return builderNewUpdate.build();
    }

    /* renamed from: a */
    private void m718a(String str) {
        if (this.f448f.containsKey(str)) {
            ((C0171j) this.f448f.get(str)).m709a(((C0171j) this.f448f.get(str)).m714e() + 1);
        } else {
            C1341p.m4651a("Error - inboxNO:" + str + " is not in inboxMsgMap. You can not reach here", getClass().getSimpleName());
        }
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public void mo671a(C0259g c0259g) throws IllegalStateException, IllegalAccessException, NoSuchMethodException, RemoteException, SecurityException, IOException, IllegalArgumentException, OperationApplicationException, InvocationTargetException {
        EnumC0651d enumC0651dM2931a;
        if (c0259g.m928b() == EnumC0518y.SUCCESS) {
            GetUnReadMessageList getUnReadMessageList = (GetUnReadMessageList) c0259g.m932d();
            if (getUnReadMessageList == null || getUnReadMessageList.msg == null) {
                C1341p.m4651a("Error - HttpResultObject is null", getClass().getSimpleName());
                return;
            }
            if (getUnReadMessageList.msg.size() <= 0) {
                if (C1341p.f4578b) {
                    C1341p.m4658b("unReadMessage.msg.size() is 0", getClass().getSimpleName());
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Msg msg = null;
            String str = "";
            Collections.sort(getUnReadMessageList.msg, new C0167f(this));
            long jLongValue = 0;
            int size = getUnReadMessageList.msg.size();
            if (size > 0) {
                jLongValue = ((Msg) getUnReadMessageList.msg.get(size - 1)).time.longValue();
                C1323bs.m4578a("get_all_unread_message_timestamp", Long.valueOf(jLongValue));
            }
            if (C1341p.f4578b) {
                C1341p.m4658b("get_all_unread_message_timestamp : " + Long.toString(jLongValue), getClass().getSimpleName());
            }
            Iterator it = getUnReadMessageList.msg.iterator();
            while (it.hasNext()) {
                Msg msg2 = (Msg) it.next();
                if (msg2.type.equals("ans")) {
                    arrayList2.add(msg2);
                } else {
                    arrayList.add(msg2);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Msg msg3 = (Msg) it2.next();
                if (msg3.type.equals("media") || msg3.type.equals(Config.NOTIFICATION_INTENT_MSG) || msg3.type.equals("noti")) {
                    if (C0635o.m2946b(this.f447b, msg3.sender, msg3.f2448id, msg3.sessionid)) {
                        EnumC0665r enumC0665r = (msg3.type.equals("noti") || EnumC0665r.m3011a(msg3.chattype.intValue()) == EnumC0665r.GROUPCHAT) ? EnumC0665r.GROUPCHAT : EnumC0665r.ONETOONE;
                        String strM2901a = C0634n.m2901a(this.f447b, enumC0665r, msg3.sender, msg3.sessionid);
                        if (strM2901a == null) {
                            String strM4716a = C1351z.m4716a();
                            C1341p.m4662e("can't find inbox. inboxNO:" + strM4716a + " is generated", getClass().getSimpleName());
                            if (msg3.type.equals("noti")) {
                                C1341p.m4660c("( msg type noti )can't find inbox. inboxNO:" + strM4716a + " is generated", getClass().getSimpleName());
                                strM2901a = strM4716a;
                            } else {
                                C0634n.m2900a(this.f447b, strM4716a, enumC0665r, msg3, msg3.type.equals(Config.NOTIFICATION_INTENT_MSG) ? EnumC0650c.MSG : EnumC0650c.MEDIA);
                                strM2901a = strM4716a;
                            }
                        }
                        if (!this.f448f.containsKey(strM2901a)) {
                            this.f448f.put(strM2901a, new C0171j(this, strM2901a, true));
                            C1341p.m4662e("inbox:" + strM2901a + " is created in inboxMsgMap", getClass().getSimpleName());
                            boolean z = false;
                            if (!C0634n.m2915e(this.f447b, strM2901a)) {
                                ArrayList<ContentProviderOperation> arrayList3 = new ArrayList<>();
                                if (!C0631k.m2864a(this.f447b, msg3.sender, strM2901a)) {
                                    C1341p.m4662e("GetAllUnreadMessageTask - InboxNO :" + strM2901a + "Insert sender : " + msg3.sender, getClass().getSimpleName());
                                    arrayList3.add(C0631k.m2860a(strM2901a, msg3.sender));
                                    z = true;
                                }
                                if (!TextUtils.isEmpty(msg3.receiver)) {
                                    StringTokenizer stringTokenizer = new StringTokenizer(msg3.receiver, ",");
                                    while (stringTokenizer.hasMoreTokens()) {
                                        String strNextToken = stringTokenizer.nextToken();
                                        if (!strNextToken.equals(C1323bs.m4575a().getString("msisdn", ""))) {
                                            C1341p.m4662e("GetAllUnreadMessageTask - InboxNO :" + strM2901a + "Insert receiver : " + strNextToken, getClass().getSimpleName());
                                            arrayList3.add(C0631k.m2860a(strM2901a, strNextToken));
                                            z = true;
                                        }
                                    }
                                    try {
                                        if (arrayList3.size() > 0) {
                                            this.f447b.applyBatch("com.sec.chaton.provider", arrayList3);
                                        }
                                    } catch (Exception e) {
                                        C1341p.m4651a(e.getMessage(), getClass().getSimpleName());
                                    }
                                }
                                C0634n.m2912c(this.f447b, strM2901a, 11);
                            }
                            if (z) {
                                C0227z.m877a(null, strM2901a, msg3.sessionid, 0L);
                            }
                        }
                        if (msg3.type.equals("noti")) {
                            ((C0171j) this.f448f.get(strM2901a)).m710a(msg3);
                            msg3 = msg;
                        } else {
                            this.f449g = false;
                            ((C0171j) this.f448f.get(strM2901a)).m710a(msg3);
                            C1341p.m4662e("MsgID : " + msg3.f2448id + " Time : " + msg3.time, getClass().getSimpleName());
                            if (msg3.type.equals(Config.NOTIFICATION_INTENT_MSG)) {
                                m719a(strM2901a, msg3);
                                str = strM2901a;
                            } else {
                                if (msg3.type.equals("media")) {
                                    m721b(strM2901a, msg3);
                                }
                                str = strM2901a;
                            }
                        }
                        msg = msg3;
                    }
                }
            }
            Iterator it3 = this.f448f.entrySet().iterator();
            while (it3.hasNext()) {
                C0171j c0171j = (C0171j) ((Map.Entry) it3.next()).getValue();
                m722a(c0171j, c0171j.m711b());
            }
            ArrayList<ContentProviderOperation> arrayList4 = new ArrayList<>();
            Iterator it4 = arrayList2.iterator();
            while (it4.hasNext()) {
                arrayList4.add(m717a((Msg) it4.next()));
            }
            try {
                try {
                    if (arrayList4.size() > 0) {
                        this.f447b.applyBatch("com.sec.chaton.provider", arrayList4);
                    }
                } catch (Exception e2) {
                    C1341p.m4651a(e2.getMessage(), getClass().getSimpleName());
                }
                arrayList4.clear();
                C0227z.m878a(null, this.f446a);
                if (msg != null) {
                    C0636p c0636pM2913c = C0634n.m2913c(this.f447b, str);
                    if (c0636pM2913c == null) {
                        C1341p.m4651a("Error - InBoxData does not exist.", getClass().getSimpleName());
                        return;
                    }
                    if (msg.time.longValue() < c0636pM2913c.f2204g) {
                        C1341p.m4660c("already received msg. so don't have to show notification", getClass().getSimpleName());
                        return;
                    }
                    if (this.f449g) {
                        if (GlobalApplication.f2408b == null || !GlobalApplication.f2408b.equals(str)) {
                            if (msg.type.equals("media")) {
                                enumC0651dM2931a = C0635o.m2931a(msg.value);
                            } else {
                                enumC0651dM2931a = EnumC0651d.TEXT;
                            }
                            Intent intent = new Intent(HomeActivity.m630a(GlobalApplication.m3100a(), true));
                            EnumC0665r enumC0665rM3011a = EnumC0665r.m3011a(msg.chattype.intValue());
                            switch (enumC0665rM3011a) {
                                case ONETOONE:
                                case BROADCAST:
                                    intent.putExtra("inboxNO", str);
                                    intent.putExtra("chatType", EnumC0665r.ONETOONE.m3012a());
                                    intent.putExtra("fromPush", 1);
                                    intent.putExtra(ChatFragment.f1735h, 1);
                                    intent.putExtra("buddyNO", msg.sender);
                                    break;
                                case GROUPCHAT:
                                    intent.putExtra("inboxNO", str);
                                    intent.putExtra("chatType", EnumC0665r.GROUPCHAT.m3012a());
                                    intent.putExtra("fromPush", 1);
                                    intent.putExtra(ChatFragment.f1735h, 1);
                                    intent.putExtra("buddyNO", msg.sender);
                                    break;
                            }
                            PendingIntent activity = PendingIntent.getActivity(GlobalApplication.m3100a(), 0, intent, 268435456);
                            C1341p.m4660c("[NOTI] ChatType: " + enumC0665rM3011a + ", unReadCount: " + c0636pM2913c.f2201d + ", Memory Address:" + this, getClass().getSimpleName());
                            C1332g.m4605a(GlobalApplication.m3100a()).m4611a(msg.sender, msg.value, str, activity, Long.valueOf(msg.f2448id).longValue(), enumC0651dM2931a, c0636pM2913c.f2201d, enumC0665rM3011a.m3012a(), msg.sessionid, c0636pM2913c.f2198a, C0631k.m2872e(this.f447b, str, msg.sender), c0636pM2913c.f2215r);
                        }
                    }
                }
            } catch (Throwable th) {
                arrayList4.clear();
                throw th;
            }
        }
    }

    /* renamed from: a */
    public void m722a(C0171j c0171j, boolean z) {
        String strM708a = c0171j.m708a();
        ArrayList arrayListM712c = c0171j.m712c();
        C0636p c0636pM2913c = C0634n.m2913c(this.f447b, strM708a);
        if (c0636pM2913c == null) {
            m720a((String) null, c0171j.m713d());
            return;
        }
        if (arrayListM712c.size() > 0) {
            Msg msg = (Msg) arrayListM712c.get(arrayListM712c.size() - 1);
            C1341p.m4662e("<LastMsg> - MsgID : " + msg.f2448id + " Time : " + msg.time, getClass().getSimpleName());
            m720a(strM708a, c0171j.m713d());
            if (msg.time.longValue() >= c0636pM2913c.f2204g) {
                c0636pM2913c.f2204g = msg.time.longValue();
                c0636pM2913c.f2207j = Long.valueOf(msg.f2448id).longValue();
                c0636pM2913c.f2208k = msg.sender;
                EnumC0665r enumC0665rM3011a = EnumC0665r.m3011a(msg.chattype.intValue());
                if (enumC0665rM3011a == EnumC0665r.BROADCAST) {
                    c0636pM2913c.f2200c = EnumC0665r.ONETOONE.m3012a();
                } else {
                    c0636pM2913c.f2200c = enumC0665rM3011a.m3012a();
                    c0636pM2913c.f2212o = msg.address;
                    c0636pM2913c.f2213p = msg.port.intValue();
                    c0636pM2913c.f2206i = msg.sessionid;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(2).append(";");
                if (msg.type.equals("media")) {
                    sb.append(C0635o.m2931a(msg.value).m2978a()).append(";");
                } else {
                    sb.append(EnumC0651d.TEXT.m2978a()).append(";");
                }
                sb.append(C0520a.m2713a(msg.value)).append(";");
                if (enumC0665rM3011a == EnumC0665r.GROUPCHAT) {
                    sb.append(C0520a.m2713a(C0631k.m2870d(this.f447b, msg.sender)));
                }
                c0636pM2913c.f2202e = sb.toString();
            }
            c0636pM2913c.f2201d = ((C0171j) this.f448f.get(strM708a)).m714e() + c0636pM2913c.f2201d;
        } else {
            m720a(strM708a, c0171j.m713d());
        }
        C0634n.m2891a(this.f447b, strM708a, c0636pM2913c);
        C1341p.m4662e("updateInBox inboxNO:" + strM708a, getClass().getSimpleName());
    }
}
