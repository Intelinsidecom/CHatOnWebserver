package com.sec.chaton.p015d.p016a;

import android.app.PendingIntent;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.chat.C0493bg;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.emoticon.anicon.C0921d;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p015d.C0635g;
import com.sec.chaton.p015d.C0639k;
import com.sec.chaton.p017e.C0698m;
import com.sec.chaton.p017e.EnumC0690e;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p017e.EnumC0699n;
import com.sec.chaton.p017e.EnumC0700o;
import com.sec.chaton.p017e.EnumC0705t;
import com.sec.chaton.p017e.p018a.C0657a;
import com.sec.chaton.p017e.p018a.C0660d;
import com.sec.chaton.p017e.p018a.C0662f;
import com.sec.chaton.p017e.p018a.C0665i;
import com.sec.chaton.p017e.p018a.C0670n;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.GetUnReadMessageList;
import com.sec.chaton.p028io.entry.inner.Msg;
import com.sec.chaton.p028io.entry.inner.MsgTid;
import com.sec.chaton.util.C1733ap;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1788t;
import com.sec.chaton.util.C1789u;
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
/* renamed from: com.sec.chaton.d.a.ai */
/* loaded from: classes.dex */
public class C0541ai extends AbstractRunnableC0532a {

    /* renamed from: d */
    private List f2204d;

    /* renamed from: e */
    private ArrayList f2205e;

    /* renamed from: f */
    private ContentResolver f2206f;

    /* renamed from: g */
    private C0635g f2207g;

    /* renamed from: h */
    private HashMap f2208h;

    /* renamed from: i */
    private boolean f2209i;

    /* renamed from: j */
    private boolean f2210j;

    public C0541ai(Handler handler, C0798h c0798h) {
        super(handler, c0798h);
        this.f2209i = false;
        this.f2210j = false;
        this.f2206f = GlobalApplication.m3256a().getContentResolver();
        this.f2208h = new HashMap();
        this.f2204d = new ArrayList();
        this.f2207g = new C0635g(new Handler());
        this.f2205e = new ArrayList();
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        return null;
    }

    /* renamed from: a */
    private void m2734a(String str, Msg msg) {
        C1786r.m6066e("Type : Message, Sender : " + msg.sender + " MsgServerID : " + msg.f3051id + ", ChatType : " + msg.chattype + ", Tid : " + msg.tid + ", Content : " + msg.value + ", MsgType : " + msg.type + ", Receiver : " + msg.receiver, getClass().getSimpleName());
        EnumC0695j enumC0695jM3145a = EnumC0695j.m3145a(msg.chattype.intValue());
        EnumC0699n enumC0699n = EnumC0699n.TEXT;
        if (enumC0695jM3145a == EnumC0695j.GROUPCHAT) {
            EnumC0695j enumC0695j = EnumC0695j.GROUPCHAT;
        } else {
            EnumC0695j enumC0695j2 = EnumC0695j.ONETOONE;
        }
        if (C0665i.m3045a(this.f2206f, str, enumC0699n, msg, (String) null) == EnumC0690e.INSERT) {
            m2733a(str);
            this.f2209i = true;
        }
    }

    /* renamed from: b */
    private void m2736b(String str, Msg msg) {
        C1786r.m6066e("Type : Media, Sender : " + msg.sender + ", ChatType : " + msg.chattype + ", Tid : " + msg.tid + ", Content : " + msg.value + ", MsgType : " + msg.type + ", Receiver : " + msg.receiver, getClass().getSimpleName());
        if (EnumC0695j.m3145a(msg.chattype.intValue()) == EnumC0695j.GROUPCHAT) {
            EnumC0695j enumC0695j = EnumC0695j.GROUPCHAT;
        } else {
            EnumC0695j enumC0695j2 = EnumC0695j.ONETOONE;
        }
        if (msg.value == null) {
            msg.value = "";
        }
        EnumC0699n enumC0699nM3046a = C0665i.m3046a(msg.value);
        String[] strArrSplit = msg.value.split("\n");
        String str2 = null;
        if ((enumC0699nM3046a == EnumC0699n.CONTACT || enumC0699nM3046a == EnumC0699n.CALENDAR || enumC0699nM3046a == EnumC0699n.DOCUMENT) && strArrSplit.length > 5) {
            str2 = strArrSplit[5];
        }
        if (enumC0699nM3046a == EnumC0699n.IMAGE && C0921d.m3794b(msg.value)) {
            enumC0699nM3046a = EnumC0699n.ANICON;
        }
        if (C0665i.m3045a(this.f2206f, str, enumC0699nM3046a, msg, str2) == EnumC0690e.INSERT) {
            m2733a(str);
            this.f2209i = true;
        }
        if (enumC0699nM3046a == EnumC0699n.IMAGE && !this.f2209i && !this.f2210j) {
            C1786r.m6061b("No need to update and insert: " + strArrSplit[3], getClass().getName());
        }
    }

    /* renamed from: a */
    private void m2732a(Msg msg) {
        C1786r.m6066e("MsgID : " + msg.f3051id + " Time : " + msg.time, getClass().getSimpleName());
        C1786r.m6066e("Type : NOTI, SessionID : " + msg.sessionid + ", ChatType : " + msg.chattype + ", tid : " + msg.tid, getClass().getSimpleName());
        C1786r.m6066e("MSG : " + msg.value, getClass().getSimpleName());
        String strM3014a = C0660d.m3014a(this.f2206f, EnumC0695j.GROUPCHAT, (String) null, msg.sessionid);
        if (strM3014a != null && !TextUtils.isEmpty(msg.value)) {
            String[] strArrSplit = msg.value.split("\n");
            StringBuilder sb = new StringBuilder();
            for (String str : strArrSplit) {
                C1786r.m6066e("Row : " + str, getClass().getSimpleName());
                String[] strArrM2688a = C0493bg.m2688a(str, ",", 3);
                if (strArrM2688a.length > 2) {
                    String str2 = strArrM2688a[1];
                    String strM3084b = C0670n.m3084b(this.f2206f, str2, strArrM2688a[2]);
                    EnumC0705t enumC0705t = EnumC0705t.UNKNOWN;
                    if (EnumC0705t.m3170a(strArrM2688a[0]) == EnumC0705t.ENTER) {
                        if (!C0670n.m3083a(this.f2206f, str2, strM3014a)) {
                            C0670n.m3082a(this.f2206f, strM3014a, str2, strM3084b);
                        }
                        enumC0705t = EnumC0705t.ENTER;
                    } else if (EnumC0705t.m3170a(strArrM2688a[0]) == EnumC0705t.LEAVE) {
                        C0670n.m3090d(this.f2206f, strM3014a, str2);
                        enumC0705t = EnumC0705t.LEAVE;
                    }
                    sb.append(String.format("%d,%s,%s", Integer.valueOf(enumC0705t.m3171a()), str2, C0493bg.m2684a(strM3084b))).append(";");
                }
            }
            C0665i.m3041a(this.f2206f, strM3014a, sb.toString(), msg.time.longValue(), msg.f3051id, msg.sender);
        }
        MsgTid msgTid = new MsgTid();
        msgTid.value = msg.tid;
        this.f2204d.add(msgTid);
    }

    /* renamed from: b */
    private ContentProviderOperation m2735b(Msg msg) {
        C1786r.m6066e("Type : ANS , Sender : " + msg.sender + ", ChatType : " + msg.chattype + ", MsgID : " + msg.f3051id + ", tid : " + msg.tid, getClass().getSimpleName());
        String str = msg.f3051id;
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C0698m.m3149a(str));
        builderNewUpdate.withValue("message_sever_id", str);
        MsgTid msgTid = new MsgTid();
        msgTid.value = msg.tid;
        this.f2204d.add(msgTid);
        return builderNewUpdate.build();
    }

    /* renamed from: a */
    private void m2733a(String str) {
        if (this.f2208h.containsKey(str)) {
            ((C0544al) this.f2208h.get(str)).m2739a(((C0544al) this.f2208h.get(str)).m2744d() + 1);
        } else {
            C1786r.m6054a("Error - inboxNO:" + str + " is not in inboxMsgMap. You can not reach here", getClass().getSimpleName());
        }
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) throws JSONException, RemoteException, OperationApplicationException {
        EnumC0699n enumC0699nM3046a;
        if (c0101b.m665b() == EnumC0803m.SUCCESS) {
            GetUnReadMessageList getUnReadMessageList = (GetUnReadMessageList) c0101b.m671d();
            if (getUnReadMessageList == null) {
                C1786r.m6054a("Error - HttpResultObject is null", getClass().getSimpleName());
                return;
            }
            if (getUnReadMessageList.msg.size() <= 0) {
                if (C1786r.f6452b) {
                    C1786r.m6061b("unReadMessage.msg.size() is 0", getClass().getSimpleName());
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Msg msg = null;
            String str = "";
            Iterator it = getUnReadMessageList.msg.iterator();
            while (it.hasNext()) {
                Msg msg2 = (Msg) it.next();
                if (msg2.type.equals("ans")) {
                    arrayList2.add(msg2);
                } else {
                    arrayList.add(msg2);
                }
            }
            Collections.sort(arrayList, new C0542aj(this));
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Msg msg3 = (Msg) it2.next();
                if (msg3.type.equals("media") || msg3.type.equals(Config.NOTIFICATION_INTENT_MSG) || msg3.type.equals("noti")) {
                    if (C0665i.m3072b(this.f2206f, msg3.sender, msg3.f3051id, msg3.sessionid)) {
                        EnumC0695j enumC0695j = (msg3.type.equals("noti") || EnumC0695j.m3145a(msg3.chattype.intValue()) == EnumC0695j.GROUPCHAT) ? EnumC0695j.GROUPCHAT : EnumC0695j.ONETOONE;
                        String strM3014a = C0660d.m3014a(this.f2206f, enumC0695j, msg3.sender, msg3.sessionid);
                        if (strM3014a == null) {
                            String strM5916a = C1733ap.m5916a();
                            C1786r.m6066e("can't find inbox. inboxNO:" + strM5916a + " is generated", getClass().getSimpleName());
                            if (msg3.type.equals("noti")) {
                                C1786r.m6063c("( msg type noti )can't find inbox. inboxNO:" + strM5916a + " is generated", getClass().getSimpleName());
                                strM3014a = strM5916a;
                            } else {
                                C0660d.m3013a(this.f2206f, strM5916a, enumC0695j, msg3, msg3.type.equals(Config.NOTIFICATION_INTENT_MSG) ? EnumC0700o.MSG : EnumC0700o.MEDIA);
                                strM3014a = strM5916a;
                            }
                        }
                        if (!this.f2208h.containsKey(strM3014a)) {
                            this.f2208h.put(strM3014a, new C0544al(this, strM3014a, true));
                            C1786r.m6066e("inbox:" + strM3014a + " is created in inboxMsgMap", getClass().getSimpleName());
                        }
                        if (msg3.type.equals("noti")) {
                            ((C0544al) this.f2208h.get(strM3014a)).m2740a(msg3);
                            msg3 = msg;
                        } else {
                            this.f2209i = false;
                            ((C0544al) this.f2208h.get(strM3014a)).m2740a(msg3);
                            C1786r.m6066e("MsgID : " + msg3.f3051id + " Time : " + msg3.time, getClass().getSimpleName());
                            if (msg3.type.equals(Config.NOTIFICATION_INTENT_MSG)) {
                                m2734a(strM3014a, msg3);
                                str = strM3014a;
                            } else {
                                if (msg3.type.equals("media")) {
                                    m2736b(strM3014a, msg3);
                                }
                                str = strM3014a;
                            }
                        }
                        msg = msg3;
                    }
                }
            }
            for (Map.Entry entry : this.f2208h.entrySet()) {
                String str2 = (String) entry.getKey();
                C0544al c0544al = (C0544al) entry.getValue();
                m2737a(str2, c0544al, c0544al.m2741a());
            }
            ArrayList<ContentProviderOperation> arrayList3 = new ArrayList<>();
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                arrayList3.add(m2735b((Msg) it3.next()));
            }
            try {
                try {
                    if (arrayList3.size() > 0) {
                        this.f2206f.applyBatch("com.sec.chaton.provider", arrayList3);
                    }
                } catch (Exception e) {
                    C1786r.m6054a(e.getMessage(), getClass().getSimpleName());
                }
                arrayList3.clear();
                this.f2207g.m2888a(this.f2204d);
                if (msg != null) {
                    C0662f c0662fM3030d = C0660d.m3030d(this.f2206f, str);
                    if (c0662fM3030d == null) {
                        C1786r.m6054a("Error - InBoxData does not exist.", getClass().getSimpleName());
                    } else if (msg.time.longValue() < c0662fM3030d.f2539f) {
                        C1786r.m6063c("already received msg. so don't have to show notification", getClass().getSimpleName());
                    } else if (this.f2209i && (GlobalApplication.f2776b == null || !GlobalApplication.f2776b.equals(str))) {
                        if (msg.type.equals("media")) {
                            enumC0699nM3046a = C0665i.m3046a(msg.value);
                        } else {
                            enumC0699nM3046a = EnumC0699n.TEXT;
                        }
                        Intent intent = new Intent(HomeActivity.m585a(GlobalApplication.m3260b(), true));
                        EnumC0695j enumC0695jM3145a = EnumC0695j.m3145a(msg.chattype.intValue());
                        switch (enumC0695jM3145a) {
                            case ONETOONE:
                            case BROADCAST:
                                intent.putExtra("inboxNO", str);
                                intent.putExtra("chatType", EnumC0695j.ONETOONE.m3146a());
                                intent.putExtra("fromPush", 1);
                                intent.putExtra(ChatFragment.f1754j, 1);
                                intent.putExtra("buddyNO", msg.sender);
                                break;
                            case GROUPCHAT:
                                intent.putExtra("inboxNO", str);
                                intent.putExtra("chatType", EnumC0695j.GROUPCHAT.m3146a());
                                intent.putExtra("fromPush", 1);
                                intent.putExtra(ChatFragment.f1754j, 1);
                                intent.putExtra("buddyNO", msg.sender);
                                break;
                        }
                        PendingIntent activity = PendingIntent.getActivity(GlobalApplication.m3260b(), 0, intent, 268435456);
                        C1786r.m6063c("[NOTI] ChatType: " + enumC0695jM3145a + ", unReadCount: " + c0662fM3030d.f2536c + ", Memory Address:" + this, getClass().getSimpleName());
                        String string = msg.value;
                        if (msg.sender.startsWith("0999")) {
                            try {
                                string = new JSONObject(msg.value).getString("title");
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        }
                        C1788t.m6070a(GlobalApplication.m3260b()).m6074a(msg.sender, string, str, activity, Long.valueOf(msg.f3051id).longValue(), enumC0699nM3046a, c0662fM3030d.f2536c, enumC0695jM3145a.m3146a(), c0662fM3030d.f2550q, c0662fM3030d.f2541h);
                    }
                }
                if (this.f2205e.size() > 0) {
                    String strValueOf = String.valueOf(System.currentTimeMillis());
                    if (Looper.myLooper() == null) {
                        Looper.prepare();
                    }
                    C0639k c0639kM2904a = C0639k.m2904a(this.f2161c, strValueOf, EnumC0695j.GROUPCHAT);
                    c0639kM2904a.m2947a(strValueOf, GlobalApplication.m3263d().m5922b().m5923a(), GlobalApplication.m3263d().m5922b().m5926b());
                    c0639kM2904a.m2944a(true);
                    c0639kM2904a.m2943a(this.f2205e);
                }
            } catch (Throwable th) {
                arrayList3.clear();
                throw th;
            }
        }
    }

    /* renamed from: a */
    public void m2737a(String str, C0544al c0544al, boolean z) throws RemoteException, OperationApplicationException {
        ArrayList arrayListM2742b = c0544al.m2742b();
        C0662f c0662fM3030d = C0660d.m3030d(this.f2206f, str);
        if (c0662fM3030d == null) {
            Iterator it = c0544al.m2743c().iterator();
            while (it.hasNext()) {
                m2732a((Msg) it.next());
            }
            return;
        }
        if (arrayListM2742b.size() > 0) {
            Msg msg = (Msg) arrayListM2742b.get(arrayListM2742b.size() - 1);
            Msg msg2 = (Msg) arrayListM2742b.get(0);
            C1786r.m6066e("<LastMsg> - MsgID : " + msg.f3051id + " Time : " + msg.time, getClass().getSimpleName());
            if (!C0660d.m3032f(this.f2206f, str)) {
                ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                if (!C0670n.m3083a(this.f2206f, msg2.sender, str)) {
                    C1786r.m6066e("GetAllUnreadMessageTask - InboxNO :" + str + "Insert sender : " + msg2.sender, getClass().getSimpleName());
                    arrayList.add(C0670n.m3078a(str, msg2.sender));
                    if (C0657a.m2983c(this.f2206f, msg2.sender).equals(msg2.sender) && !this.f2205e.contains(msg2.sender)) {
                        this.f2205e.add(msg2.sender);
                    }
                }
                if (!TextUtils.isEmpty(msg2.receiver)) {
                    StringTokenizer stringTokenizer = new StringTokenizer(msg2.receiver, ",");
                    while (stringTokenizer.hasMoreTokens()) {
                        String strNextToken = stringTokenizer.nextToken();
                        if (!strNextToken.equals(C1789u.m6075a().getString("msisdn", "")) && !C0670n.m3083a(this.f2206f, strNextToken, str)) {
                            C1786r.m6066e("GetAllUnreadMessageTask - InboxNO :" + str + "Insert receiver : " + strNextToken, getClass().getSimpleName());
                            arrayList.add(C0670n.m3078a(str, strNextToken));
                            if (C0657a.m2983c(this.f2206f, strNextToken).equals(strNextToken) && !this.f2205e.contains(strNextToken)) {
                                this.f2205e.add(strNextToken);
                            }
                        }
                    }
                    try {
                        if (arrayList.size() > 0) {
                            this.f2206f.applyBatch("com.sec.chaton.provider", arrayList);
                        }
                    } catch (Exception e) {
                        C1786r.m6054a(e.getMessage(), getClass().getSimpleName());
                    }
                }
                C0660d.m3029c(this.f2206f, str, 11);
                c0662fM3030d.f2545l = 11;
            }
            Iterator it2 = c0544al.m2743c().iterator();
            while (it2.hasNext()) {
                m2732a((Msg) it2.next());
            }
            if (msg.time.longValue() >= c0662fM3030d.f2539f) {
                c0662fM3030d.f2539f = msg.time.longValue();
                c0662fM3030d.f2542i = Long.valueOf(msg.f3051id).longValue();
                c0662fM3030d.f2543j = msg.sender;
                EnumC0695j enumC0695jM3145a = EnumC0695j.m3145a(msg.chattype.intValue());
                if (enumC0695jM3145a == EnumC0695j.BROADCAST) {
                    c0662fM3030d.f2535b = EnumC0695j.ONETOONE.m3146a();
                } else {
                    c0662fM3030d.f2535b = enumC0695jM3145a.m3146a();
                    c0662fM3030d.f2547n = msg.address;
                    c0662fM3030d.f2548o = msg.port.intValue();
                    c0662fM3030d.f2541h = msg.sessionid;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(2).append(";");
                if (msg.type.equals("media")) {
                    sb.append(C0665i.m3046a(msg.value).m3162a()).append(";");
                } else {
                    sb.append(EnumC0699n.TEXT.m3162a()).append(";");
                }
                String strM2684a = C0493bg.m2684a(msg.value);
                C1786r.m6061b("updateWithLastMsg - (lastmsg) last msg sender : " + msg.sender.toString(), getClass().getSimpleName());
                C1786r.m6061b("updateWithLastMsg - (lastmsg) last msg msg : " + msg.value.toString(), getClass().getSimpleName());
                if (msg.sender.startsWith("0999")) {
                    try {
                        sb.append(new JSONObject(strM2684a).getString("title")).append(";");
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                } else {
                    sb.append(strM2684a).append(";");
                }
                if (enumC0695jM3145a == EnumC0695j.GROUPCHAT) {
                    sb.append(C0493bg.m2684a(C0670n.m3089d(this.f2206f, msg.sender)));
                }
                C1786r.m6061b("updateWithLastMsg - (lastmsg) DB. LastMsg : " + sb.toString(), getClass().getSimpleName());
                c0662fM3030d.f2537d = sb.toString();
            }
            c0662fM3030d.f2536c = ((C0544al) this.f2208h.get(str)).m2744d() + c0662fM3030d.f2536c;
        } else {
            Iterator it3 = c0544al.m2743c().iterator();
            while (it3.hasNext()) {
                m2732a((Msg) it3.next());
            }
        }
        C0660d.m3005a(this.f2206f, str, c0662fM3030d);
        C1786r.m6066e("updateInBox inboxNO:" + str, getClass().getSimpleName());
    }
}
