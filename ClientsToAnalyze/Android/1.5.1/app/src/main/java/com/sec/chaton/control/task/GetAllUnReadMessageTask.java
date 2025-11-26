package com.sec.chaton.control.task;

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
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.chat.ChatUtil;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.control.HttpMessageControl;
import com.sec.chaton.control.MessageControl;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.helper.BuddyDatabaseHelper;
import com.sec.chaton.database.helper.InBoxDatabaseHelper;
import com.sec.chaton.database.helper.MessageDatabaseHelper;
import com.sec.chaton.database.helper.ParticipantDatabaseHelper;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.p000io.entry.GetUnReadMessageList;
import com.sec.chaton.p000io.entry.inner.Msg;
import com.sec.chaton.p000io.entry.inner.MsgTid;
import com.sec.chaton.util.ChatONFileUtil;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONNotificationManager;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.InBoxNoGenerator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/* loaded from: classes.dex */
public class GetAllUnReadMessageTask extends AbstractHttpTask2 {

    /* renamed from: a */
    private List f1579a;

    /* renamed from: b */
    private ArrayList f1580b;

    /* renamed from: c */
    private ContentResolver f1581c;

    /* renamed from: d */
    private HttpMessageControl f1582d;

    /* renamed from: e */
    private HashMap f1583e;

    /* renamed from: f */
    private boolean f1584f;

    /* renamed from: g */
    private boolean f1585g;

    public class InboxMsg {

        /* renamed from: b */
        private String f1587b;

        /* renamed from: c */
        private boolean f1588c;

        /* renamed from: d */
        private ArrayList f1589d = new ArrayList();

        /* renamed from: e */
        private ArrayList f1590e = new ArrayList();

        /* renamed from: f */
        private int f1591f = 0;

        public InboxMsg(String str, boolean z) {
            this.f1587b = str;
            this.f1588c = z;
        }

        /* renamed from: a */
        public void m2145a(int i) {
            this.f1591f = i;
        }

        /* renamed from: a */
        public void m2146a(Msg msg) {
            if (msg.type.equals("noti")) {
                this.f1590e.add(msg);
            } else {
                this.f1589d.add(msg);
            }
        }

        /* renamed from: a */
        public boolean m2147a() {
            return this.f1588c;
        }

        /* renamed from: b */
        public ArrayList m2148b() {
            return this.f1589d;
        }

        /* renamed from: c */
        public ArrayList m2149c() {
            return this.f1590e;
        }

        /* renamed from: d */
        public int m2150d() {
            return this.f1591f;
        }
    }

    public GetAllUnReadMessageTask(Handler handler, HttpEnvelope httpEnvelope) {
        super(handler, httpEnvelope);
        this.f1584f = false;
        this.f1585g = false;
        this.f1581c = GlobalApplication.m2386d().getContentResolver();
        this.f1583e = new HashMap();
        this.f1579a = new ArrayList();
        this.f1582d = new HttpMessageControl(new Handler());
        this.f1580b = new ArrayList();
    }

    /* renamed from: a */
    private void m2139a(Msg msg) {
        ChatONLogWriter.m3511e("MsgID : " + msg.f1917id + " Time : " + msg.time, getClass().getSimpleName());
        ChatONLogWriter.m3511e("Type : NOTI, SessionID : " + msg.sessionid + ", ChatType : " + msg.chattype + ", tid : " + msg.tid, getClass().getSimpleName());
        ChatONLogWriter.m3511e("MSG : " + msg.value, getClass().getSimpleName());
        String strM2246a = InBoxDatabaseHelper.m2246a(this.f1581c, ChatONContract.InBoxTable.ChatType.GROUPCHAT, (String) null, msg.sessionid);
        if (strM2246a != null && !TextUtils.isEmpty(msg.value)) {
            String[] strArrSplit = msg.value.split("\n");
            StringBuilder sb = new StringBuilder();
            for (String str : strArrSplit) {
                ChatONLogWriter.m3511e("Row : " + str, getClass().getSimpleName());
                String[] strArrM799a = ChatUtil.m799a(str, ",", 3);
                if (strArrM799a.length > 2) {
                    String str2 = strArrM799a[1];
                    String strM2310b = ParticipantDatabaseHelper.m2310b(this.f1581c, str2, strArrM799a[2]);
                    sb.append(String.format("%s,%s,%s", strArrM799a[0], str2, ChatUtil.m795a(strM2310b))).append(";");
                    if (strArrM799a[0].equals("ENTER")) {
                        if (!ParticipantDatabaseHelper.m2309a(this.f1581c, str2, strM2246a)) {
                            ParticipantDatabaseHelper.m2308a(this.f1581c, strM2246a, str2, strM2310b);
                        }
                    } else if (strArrM799a[0].equals("LEAVE")) {
                        ParticipantDatabaseHelper.m2316d(this.f1581c, strM2246a, str2);
                    }
                }
            }
            MessageDatabaseHelper.m2273a(this.f1581c, strM2246a, sb.toString(), msg.time.longValue(), msg.f1917id);
        }
        MsgTid msgTid = new MsgTid();
        msgTid.value = msg.tid;
        this.f1579a.add(msgTid);
    }

    /* renamed from: a */
    private void m2140a(String str) {
        if (!this.f1583e.containsKey(str)) {
            ChatONLogWriter.m3499a("Error - inboxNO:" + str + " is not in inboxMsgMap. You can not reach here", getClass().getSimpleName());
        } else {
            ((InboxMsg) this.f1583e.get(str)).m2145a(((InboxMsg) this.f1583e.get(str)).m2150d() + 1);
        }
    }

    /* renamed from: a */
    private void m2141a(String str, Msg msg) {
        ChatONLogWriter.m3511e("Type : Message, Sender : " + msg.sender + " MsgServerID : " + msg.f1917id + ", ChatType : " + msg.chattype + ", Tid : " + msg.tid + ", Content : " + msg.value + ", MsgType : " + msg.type + ", Receiver : " + msg.receiver, getClass().getSimpleName());
        ChatONContract.InBoxTable.ChatType chatTypeM2188a = ChatONContract.InBoxTable.ChatType.m2188a(msg.chattype.intValue());
        ChatONContract.MessageTable.MsgContentType msgContentType = ChatONContract.MessageTable.MsgContentType.TEXT;
        ChatONContract.InBoxTable.ChatType chatType = chatTypeM2188a == ChatONContract.InBoxTable.ChatType.GROUPCHAT ? ChatONContract.InBoxTable.ChatType.GROUPCHAT : ChatONContract.InBoxTable.ChatType.ONETOONE;
        if (MessageDatabaseHelper.m2296a(this.f1581c, msg.sender, msg.f1917id, str)) {
            if (MessageDatabaseHelper.m2300b(this.f1581c, msg.sender, msg.f1917id, str)) {
                MessageDatabaseHelper.m2284a(this.f1581c, str, msgContentType, msg, chatType, (String) null);
            }
        } else {
            MessageDatabaseHelper.m2272a(this.f1581c, str, msgContentType, msg, (String) null);
            m2140a(str);
            this.f1584f = true;
        }
    }

    /* renamed from: b */
    private void m2142b(Msg msg) {
        ChatONLogWriter.m3511e("Type : ANS , Sender : " + msg.sender + ", ChatType : " + msg.chattype + ", MsgID : " + msg.f1917id + ", tid : " + msg.tid, getClass().getSimpleName());
        this.f1581c.update(ChatONContract.MessageTable.m2191a(msg.f1917id), null, null, null);
        MsgTid msgTid = new MsgTid();
        msgTid.value = msg.tid;
        this.f1579a.add(msgTid);
    }

    /* renamed from: b */
    private void m2143b(String str, Msg msg) throws IOException {
        ChatONLogWriter.m3511e("Type : Media, Sender : " + msg.sender + ", ChatType : " + msg.chattype + ", Tid : " + msg.tid + ", Content : " + msg.value + ", MsgType : " + msg.type + ", Receiver : " + msg.receiver, getClass().getSimpleName());
        ChatONContract.InBoxTable.ChatType chatType = ChatONContract.InBoxTable.ChatType.m2188a(msg.chattype.intValue()) == ChatONContract.InBoxTable.ChatType.GROUPCHAT ? ChatONContract.InBoxTable.ChatType.GROUPCHAT : ChatONContract.InBoxTable.ChatType.ONETOONE;
        if (msg.value == null) {
            msg.value = "";
        }
        ChatONContract.MessageTable.MsgContentType msgContentTypeM2275a = MessageDatabaseHelper.m2275a(msg.value);
        String[] strArrSplit = msg.value.split("\n");
        String str2 = ((msgContentTypeM2275a == ChatONContract.MessageTable.MsgContentType.CONTACT || msgContentTypeM2275a == ChatONContract.MessageTable.MsgContentType.CALENDAR) && strArrSplit.length > 5) ? strArrSplit[5] : null;
        if (!MessageDatabaseHelper.m2296a(this.f1581c, msg.sender, msg.f1917id, str)) {
            MessageDatabaseHelper.m2272a(this.f1581c, str, msgContentTypeM2275a, msg, str2);
            m2140a(str);
            this.f1584f = true;
        } else if (MessageDatabaseHelper.m2300b(this.f1581c, msg.sender, msg.f1917id, str)) {
            MessageDatabaseHelper.m2284a(this.f1581c, str, msgContentTypeM2275a, msg, chatType, str2);
            this.f1585g = true;
        }
        if (msgContentTypeM2275a == ChatONContract.MessageTable.MsgContentType.IMAGE) {
            String str3 = strArrSplit[3];
            if (this.f1584f || this.f1585g) {
                ChatONFileUtil.m3480a(strArrSplit[2], strArrSplit[4], strArrSplit[3], true, str, Long.parseLong(msg.f1917id), chatType, msg.sender);
            } else {
                ChatONLogWriter.m3506b("No need to update and insert: " + strArrSplit[3], getClass().getName());
            }
        }
    }

    /* renamed from: a */
    public void m2144a(String str, InboxMsg inboxMsg, boolean z) throws RemoteException, OperationApplicationException {
        ArrayList arrayListM2148b = inboxMsg.m2148b();
        InBoxDatabaseHelper.InBoxData inBoxDataM2262d = InBoxDatabaseHelper.m2262d(this.f1581c, str);
        if (inBoxDataM2262d == null) {
            Iterator it = inboxMsg.m2149c().iterator();
            while (it.hasNext()) {
                m2139a((Msg) it.next());
            }
            return;
        }
        if (arrayListM2148b.size() > 0) {
            Msg msg = (Msg) arrayListM2148b.get(arrayListM2148b.size() - 1);
            Msg msg2 = (Msg) arrayListM2148b.get(0);
            ChatONLogWriter.m3511e("<LastMsg> - MsgID : " + msg.f1917id + " Time : " + msg.time, getClass().getSimpleName());
            if (!InBoxDatabaseHelper.m2264f(this.f1581c, str)) {
                ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                if (!ParticipantDatabaseHelper.m2309a(this.f1581c, msg2.sender, str)) {
                    ChatONLogWriter.m3511e("GetAllUnreadMessageTask - InboxNO :" + str + "Insert sender : " + msg2.sender, getClass().getSimpleName());
                    arrayList.add(ParticipantDatabaseHelper.m2305a(str, msg2.sender));
                    if (BuddyDatabaseHelper.m2220a(this.f1581c, msg2.sender).equals(msg2.sender) && !this.f1580b.contains(msg2.sender)) {
                        this.f1580b.add(msg2.sender);
                    }
                }
                if (!TextUtils.isEmpty(msg2.receiver)) {
                    StringTokenizer stringTokenizer = new StringTokenizer(msg2.receiver, ",");
                    while (stringTokenizer.hasMoreTokens()) {
                        String strNextToken = stringTokenizer.nextToken();
                        if (!strNextToken.equals(ChatONPref.m3519a().getString("msisdn", "")) && !ParticipantDatabaseHelper.m2309a(this.f1581c, strNextToken, str)) {
                            ChatONLogWriter.m3511e("GetAllUnreadMessageTask - InboxNO :" + str + "Insert receiver : " + strNextToken, getClass().getSimpleName());
                            arrayList.add(ParticipantDatabaseHelper.m2305a(str, strNextToken));
                            if (BuddyDatabaseHelper.m2220a(this.f1581c, strNextToken).equals(strNextToken) && !this.f1580b.contains(strNextToken)) {
                                this.f1580b.add(strNextToken);
                            }
                        }
                    }
                    try {
                        if (arrayList.size() > 0) {
                            this.f1581c.applyBatch("com.sec.chaton.provider", arrayList);
                        }
                    } catch (Exception e) {
                        ChatONLogWriter.m3499a(e.getMessage(), getClass().getSimpleName());
                    }
                }
                InBoxDatabaseHelper.m2261c(this.f1581c, str, 11);
            }
            Iterator it2 = inboxMsg.m2149c().iterator();
            while (it2.hasNext()) {
                m2139a((Msg) it2.next());
            }
            if (msg.time.longValue() >= inBoxDataM2262d.f1761f) {
                inBoxDataM2262d.f1761f = msg.time.longValue();
                inBoxDataM2262d.f1764i = Long.valueOf(msg.f1917id).longValue();
                inBoxDataM2262d.f1765j = msg.sender;
                ChatONContract.InBoxTable.ChatType chatTypeM2188a = ChatONContract.InBoxTable.ChatType.m2188a(msg.chattype.intValue());
                if (chatTypeM2188a == ChatONContract.InBoxTable.ChatType.BROADCAST) {
                    inBoxDataM2262d.f1757b = ChatONContract.InBoxTable.ChatType.ONETOONE.m2189a();
                } else {
                    inBoxDataM2262d.f1757b = chatTypeM2188a.m2189a();
                    inBoxDataM2262d.f1769n = msg.address;
                    inBoxDataM2262d.f1770o = msg.port.intValue();
                    inBoxDataM2262d.f1763h = msg.sessionid;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(2).append(";");
                if (msg.type.equals("media")) {
                    sb.append(MessageDatabaseHelper.m2275a(msg.value).m2197a()).append(";");
                } else {
                    sb.append(ChatONContract.MessageTable.MsgContentType.TEXT.m2197a()).append(";");
                }
                sb.append(ChatUtil.m795a(msg.value)).append(";");
                if (chatTypeM2188a == ChatONContract.InBoxTable.ChatType.GROUPCHAT) {
                    sb.append(ChatUtil.m795a(ParticipantDatabaseHelper.m2315d(this.f1581c, msg.sender)));
                }
                inBoxDataM2262d.f1759d = sb.toString();
            }
            inBoxDataM2262d.f1758c = ((InboxMsg) this.f1583e.get(str)).m2150d() + inBoxDataM2262d.f1758c;
        } else {
            Iterator it3 = inboxMsg.m2149c().iterator();
            while (it3.hasNext()) {
                m2139a((Msg) it3.next());
            }
        }
        InBoxDatabaseHelper.m2241a(this.f1581c, str, inBoxDataM2262d);
        ChatONLogWriter.m3511e("updateInBox inboxNO:" + str, getClass().getSimpleName());
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public void afterRequest(HttpEntry httpEntry) throws IOException, RemoteException, OperationApplicationException {
        String str;
        if (httpEntry.m1951b() == HttpResultCode.SUCCESS) {
            GetUnReadMessageList getUnReadMessageList = (GetUnReadMessageList) httpEntry.m1955d();
            if (getUnReadMessageList == null) {
                ChatONLogWriter.m3499a("Error - HttpResultObject is null", getClass().getSimpleName());
                return;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator it = getUnReadMessageList.msg.iterator();
            while (it.hasNext()) {
                Msg msg = (Msg) it.next();
                if (msg.type.equals("ans")) {
                    arrayList2.add(msg);
                } else {
                    arrayList.add(msg);
                }
            }
            Collections.sort(arrayList, new C0193b(this));
            Iterator it2 = arrayList.iterator();
            Msg msg2 = null;
            String str2 = "";
            while (it2.hasNext()) {
                Msg msg3 = (Msg) it2.next();
                ChatONContract.InBoxTable.ChatType chatType = (msg3.type.equals("noti") || ChatONContract.InBoxTable.ChatType.m2188a(msg3.chattype.intValue()) == ChatONContract.InBoxTable.ChatType.GROUPCHAT) ? ChatONContract.InBoxTable.ChatType.GROUPCHAT : ChatONContract.InBoxTable.ChatType.ONETOONE;
                String strM2246a = InBoxDatabaseHelper.m2246a(this.f1581c, chatType, msg3.sender, msg3.sessionid);
                if (strM2246a == null) {
                    strM2246a = InBoxNoGenerator.m3596a(chatType, new String[]{msg3.sender});
                    ChatONLogWriter.m3511e("can't find inbox. inboxNO:" + strM2246a + " is generated", getClass().getSimpleName());
                    if (msg3.type.equals("noti")) {
                        ChatONLogWriter.m3508c("( msg type noti )can't find inbox. inboxNO:" + strM2246a + " is generated", getClass().getSimpleName());
                    } else {
                        InBoxDatabaseHelper.m2245a(this.f1581c, strM2246a, chatType, msg3, msg3.type.equals("msg") ? ChatONContract.MessageTable.MsgServerType.MSG : ChatONContract.MessageTable.MsgServerType.MEDIA);
                    }
                }
                if (!this.f1583e.containsKey(strM2246a)) {
                    this.f1583e.put(strM2246a, new InboxMsg(strM2246a, true));
                    ChatONLogWriter.m3511e("inbox:" + strM2246a + " is created in inboxMsgMap", getClass().getSimpleName());
                }
                if (msg3.type.equals("noti")) {
                    ((InboxMsg) this.f1583e.get(strM2246a)).m2146a(msg3);
                    str = str2;
                    msg3 = msg2;
                } else {
                    this.f1584f = false;
                    ((InboxMsg) this.f1583e.get(strM2246a)).m2146a(msg3);
                    ChatONLogWriter.m3511e("MsgID : " + msg3.f1917id + " Time : " + msg3.time, getClass().getSimpleName());
                    if (msg3.type.equals("msg")) {
                        m2141a(strM2246a, msg3);
                        str = strM2246a;
                    } else {
                        if (msg3.type.equals("media")) {
                            m2143b(strM2246a, msg3);
                        }
                        str = strM2246a;
                    }
                }
                str2 = str;
                msg2 = msg3;
            }
            for (Map.Entry entry : this.f1583e.entrySet()) {
                String str3 = (String) entry.getKey();
                InboxMsg inboxMsg = (InboxMsg) entry.getValue();
                m2144a(str3, inboxMsg, inboxMsg.m2147a());
            }
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                m2142b((Msg) it3.next());
            }
            this.f1582d.m2003a(this.f1579a);
            if (msg2 != null) {
                InBoxDatabaseHelper.InBoxData inBoxDataM2262d = InBoxDatabaseHelper.m2262d(this.f1581c, str2);
                if (inBoxDataM2262d == null) {
                    ChatONLogWriter.m3499a("Error - InBoxData does not exist.", getClass().getSimpleName());
                } else if (msg2.time.longValue() < inBoxDataM2262d.f1761f) {
                    ChatONLogWriter.m3508c("already received msg. so don't have to show notification", getClass().getSimpleName());
                } else if (this.f1584f && (GlobalApplication.f1896c == null || !GlobalApplication.f1896c.equals(str2))) {
                    ChatONContract.MessageTable.MsgContentType msgContentTypeM2275a = msg2.type.equals("media") ? MessageDatabaseHelper.m2275a(msg2.value) : ChatONContract.MessageTable.MsgContentType.TEXT;
                    Intent intent = new Intent(HomeActivity.m358a(GlobalApplication.m2387e(), true));
                    ChatONContract.InBoxTable.ChatType chatTypeM2188a = ChatONContract.InBoxTable.ChatType.m2188a(msg2.chattype.intValue());
                    switch (chatTypeM2188a) {
                        case ONETOONE:
                        case BROADCAST:
                            intent.putExtra("inboxNO", str2);
                            intent.putExtra("chatType", ChatONContract.InBoxTable.ChatType.ONETOONE.m2189a());
                            intent.putExtra(ChatFragment.f729h, 1);
                            break;
                        case GROUPCHAT:
                            intent.putExtra("inboxNO", str2);
                            intent.putExtra("chatType", ChatONContract.InBoxTable.ChatType.GROUPCHAT.m2189a());
                            intent.putExtra(ChatFragment.f729h, 1);
                            break;
                    }
                    PendingIntent activity = PendingIntent.getActivity(GlobalApplication.m2387e(), 0, intent, 268435456);
                    ChatONLogWriter.m3508c("[NOTI] ChatType: " + chatTypeM2188a + ", unReadCount: " + inBoxDataM2262d.f1758c + ", Memory Address:" + this, getClass().getSimpleName());
                    ChatONNotificationManager.m3515a(GlobalApplication.m2387e()).m3518a(msg2.sender, msg2.value, str2, activity, Long.valueOf(msg2.f1917id).longValue(), msgContentTypeM2275a, inBoxDataM2262d.f1758c, chatTypeM2188a.m2189a());
                }
            }
            if (this.f1580b.size() > 0) {
                String strValueOf = String.valueOf(System.currentTimeMillis());
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                MessageControl messageControlM2011a = MessageControl.m2011a(this.mUiHandler, strValueOf);
                messageControlM2011a.m2050a(strValueOf, GlobalApplication.m2389g().m3602b().m3603a(), GlobalApplication.m2389g().m3602b().m3606b());
                messageControlM2011a.m2048a(true);
                messageControlM2011a.m2047a(this.f1580b);
            }
        }
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public String beforeRequest() {
        return null;
    }
}
