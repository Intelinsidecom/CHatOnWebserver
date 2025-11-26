package com.sec.chaton.control.task;

import android.app.PendingIntent;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.C0062R;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.chat.ChatUtil;
import com.sec.chaton.chat.DeliveryReplyHolder;
import com.sec.chaton.common.SSMGPB;
import com.sec.chaton.common.entry.MessageResultEntry;
import com.sec.chaton.common.entry.ResultEntry;
import com.sec.chaton.control.MessageControl;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.helper.BuddyDatabaseHelper;
import com.sec.chaton.database.helper.InBoxDatabaseHelper;
import com.sec.chaton.database.helper.MessageDatabaseHelper;
import com.sec.chaton.database.helper.ParticipantDatabaseHelper;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.TcpClient;
import com.sec.chaton.network.TcpEnvelope;
import com.sec.chaton.util.ChatONFileUtil;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONNotificationManager;
import com.sec.chaton.util.ChatONPref;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class DeliveryChatTask extends AbstractNetTask {

    /* renamed from: g */
    private String f1500g;

    /* renamed from: h */
    private SSMGPB.DeliveryChat f1501h;

    /* renamed from: i */
    private ContentResolver f1502i;

    /* renamed from: j */
    private String f1503j;

    /* renamed from: k */
    private DeliveryReplyHolder f1504k;

    /* renamed from: l */
    private List f1505l;

    public DeliveryChatTask(Handler handler, String str, SSMGPB.DeliveryChat deliveryChat, MessageControl messageControl) {
        super(handler);
        this.f1500g = str;
        this.f1501h = deliveryChat;
        this.f1502i = GlobalApplication.m2387e().getContentResolver();
        this.f1503j = null;
        this.f1505l = new ArrayList();
        this.f1458f = messageControl;
    }

    @Override // com.sec.chaton.control.task.AbstractNetTask
    /* renamed from: a */
    protected TcpEnvelope mo2107a() throws IOException, RemoteException, OperationApplicationException {
        SSMGPB.InboxMessage inboxMessage;
        int i;
        SSMGPB.InboxMessage inboxMessage2;
        boolean z;
        boolean z2;
        boolean z3;
        int i2;
        String strM2061h = this.f1458f.m2059f() ? this.f1458f.m2061h() : this.f1500g;
        this.f1504k = DeliveryReplyHolder.m802b(strM2061h);
        ChatONContract.InBoxTable.ChatType chatTypeM2188a = ChatONContract.InBoxTable.ChatType.m2188a(this.f1501h.m1260f().m1240a());
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < this.f1501h.m1261g().size(); i3++) {
            sb.append("[" + i3 + "] ChatMsg : " + this.f1501h.m1255a(i3).m1554j()).append(", MsgType : " + this.f1501h.m1255a(i3).m1558n()).append(", MsgID : " + this.f1501h.m1255a(i3).m1552h()).append(", Time : " + this.f1501h.m1255a(i3).m1556l()).append(", ChatType : " + this.f1501h.m1255a(i3).m1560p()).append(", ReceiversList : " + ChatONLogWriter.m3494a(this.f1501h.m1255a(i3).m1549e())).append(", Sender : " + this.f1501h.m1255a(i3).m1548d());
        }
        ChatONLogWriter.m3508c("ch@t[" + this.f1501h.getClass().getSimpleName() + "]UID : " + ChatONPref.m3519a().getString("uid", "") + ", ChatType : " + this.f1501h.m1260f() + ", InboxMessageCount : " + this.f1501h.m1262h() + ", SessionID : " + this.f1501h.m1258d() + sb.toString(), getClass().getSimpleName());
        SSMGPB.DeliveryChatReply.Builder builderM1315a = SSMGPB.DeliveryChatReply.m1295j().m1315a(ChatONPref.m3519a().getString("uid", ""));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = this.f1501h.m1261g().iterator();
        while (it.hasNext()) {
            arrayList2.add((SSMGPB.InboxMessage) it.next());
        }
        Collections.sort(arrayList2, new C0194c(this));
        ArrayList arrayList4 = new ArrayList();
        InBoxDatabaseHelper.InBoxData inBoxDataM2262d = InBoxDatabaseHelper.m2262d(this.f1502i, strM2061h);
        if (inBoxDataM2262d == null) {
            ChatONLogWriter.m3499a("Error - InBoxData does not exist.", getClass().getSimpleName());
            return null;
        }
        Iterator it2 = arrayList2.iterator();
        boolean z4 = false;
        SSMGPB.InboxMessage inboxMessage3 = null;
        int i4 = 0;
        SSMGPB.InboxMessage inboxMessage4 = null;
        while (it2.hasNext()) {
            SSMGPB.InboxMessage inboxMessage5 = (SSMGPB.InboxMessage) it2.next();
            switch (inboxMessage5.m1558n().m1793a()) {
                case 0:
                case 1:
                    ChatONLogWriter.m3508c("Delivery Chat, InboxNO : " + this.f1500g + ", Sender : " + inboxMessage5.m1548d() + ", MsgType : " + inboxMessage5.m1558n() + ", ChatMsg : " + inboxMessage5.m1554j() + ", MsgID" + inboxMessage5.m1552h(), getClass().getSimpleName());
                    SSMGPB.InboxMessage inboxMessage6 = inboxMessage4 == null ? inboxMessage5 : inboxMessage4;
                    ChatONContract.MessageTable.MsgContentType msgContentTypeM2276a = MessageDatabaseHelper.m2276a(inboxMessage5.m1554j(), ChatONContract.MessageTable.MsgContentType.m2195a(inboxMessage5.m1558n().m1793a()));
                    if (!MessageDatabaseHelper.m2296a(this.f1502i, inboxMessage5.m1548d(), String.valueOf(inboxMessage5.m1552h()), strM2061h)) {
                        z2 = true;
                        z3 = false;
                    } else if (MessageDatabaseHelper.m2300b(this.f1502i, inboxMessage5.m1548d(), String.valueOf(inboxMessage5.m1552h()), strM2061h)) {
                        z2 = false;
                        z3 = true;
                    } else {
                        z2 = false;
                        z3 = false;
                    }
                    String[] strArrSplit = inboxMessage5.m1554j().split("\n");
                    if (msgContentTypeM2276a == ChatONContract.MessageTable.MsgContentType.CONTACT || msgContentTypeM2276a == ChatONContract.MessageTable.MsgContentType.CALENDAR) {
                        this.f1503j = strArrSplit[5];
                    }
                    MessageDatabaseHelper.m2293a(this.f1502i, this.f1501h.m1258d(), msgContentTypeM2276a, inboxMessage5, strM2061h, Long.valueOf(inboxMessage5.m1552h()), this.f1503j, chatTypeM2188a);
                    if (msgContentTypeM2276a != ChatONContract.MessageTable.MsgContentType.TEXT && msgContentTypeM2276a == ChatONContract.MessageTable.MsgContentType.IMAGE) {
                        if (z2 || z3) {
                            ChatONFileUtil.m3480a(strArrSplit[2], strArrSplit[4], strArrSplit[3], true, strM2061h, inboxMessage5.m1552h(), chatTypeM2188a, inboxMessage5.m1548d());
                        } else {
                            ChatONLogWriter.m3506b("No need to update and insert: " + strArrSplit[3], getClass().getName());
                        }
                    }
                    if (GlobalApplication.f1896c == null || !GlobalApplication.f1896c.equals(strM2061h)) {
                        this.f1504k.m804a(inboxMessage5);
                        i2 = z2 ? i4 + 1 : i4;
                    } else {
                        arrayList.add(SSMGPB.DeliveryChatReplyItem.m1337l().m1352a(inboxMessage5.m1552h()).m1356a(inboxMessage5.m1548d()).m1355a(inboxMessage5.m1558n()).m1359b(ChatONPref.m3519a().getString("msisdn", "")).build());
                        i2 = i4;
                    }
                    if (z2 || z3) {
                        inboxMessage2 = inboxMessage6;
                        inboxMessage = inboxMessage5;
                        i = i2;
                        z = z2;
                        continue;
                    } else {
                        inboxMessage2 = inboxMessage6;
                        inboxMessage = inboxMessage3;
                        i = i2;
                        z = z2;
                    }
                    inboxMessage3 = inboxMessage;
                    i4 = i;
                    boolean z5 = z;
                    inboxMessage4 = inboxMessage2;
                    z4 = z5;
                    break;
                case 2:
                    arrayList4.add(inboxMessage5);
                    arrayList.add(SSMGPB.DeliveryChatReplyItem.m1337l().m1352a(inboxMessage5.m1552h()).m1356a(inboxMessage5.m1548d()).m1355a(inboxMessage5.m1558n()).m1359b(ChatONPref.m3519a().getString("msisdn", "")).build());
                    inboxMessage = inboxMessage3;
                    i = i4;
                    boolean z6 = z4;
                    inboxMessage2 = inboxMessage4;
                    z = z6;
                    continue;
                    inboxMessage3 = inboxMessage;
                    i4 = i;
                    boolean z52 = z;
                    inboxMessage4 = inboxMessage2;
                    z4 = z52;
                case 3:
                    this.f1502i.update(ChatONContract.MessageTable.m2191a(String.valueOf(inboxMessage5.m1552h())), null, null, null);
                    arrayList.add(SSMGPB.DeliveryChatReplyItem.m1337l().m1352a(inboxMessage5.m1552h()).m1356a(inboxMessage5.m1548d()).m1355a(inboxMessage5.m1558n()).m1359b(inboxMessage5.m1545a(0)).build());
                    break;
            }
            inboxMessage = inboxMessage3;
            i = i4;
            boolean z7 = z4;
            inboxMessage2 = inboxMessage4;
            z = z7;
            inboxMessage3 = inboxMessage;
            i4 = i;
            boolean z522 = z;
            inboxMessage4 = inboxMessage2;
            z4 = z522;
        }
        if (inboxMessage4 != null && !InBoxDatabaseHelper.m2264f(this.f1502i, strM2061h)) {
            ArrayList<ContentProviderOperation> arrayList5 = new ArrayList<>();
            String strM1548d = inboxMessage4.m1548d();
            if (!ParticipantDatabaseHelper.m2309a(this.f1502i, strM1548d, strM2061h)) {
                arrayList5.add(ParticipantDatabaseHelper.m2305a(strM2061h, strM1548d));
                if (!arrayList3.contains(strM1548d) && BuddyDatabaseHelper.m2220a(this.f1502i, strM1548d).equals(strM1548d)) {
                    arrayList3.add(strM1548d);
                }
            }
            int iM1550f = inboxMessage4.m1550f();
            for (int i5 = 0; i5 < iM1550f; i5++) {
                String strM1545a = inboxMessage4.m1545a(i5);
                if (!strM1545a.equals(ChatONPref.m3519a().getString("msisdn", "")) && !ParticipantDatabaseHelper.m2309a(this.f1502i, strM1545a, strM2061h)) {
                    ChatONLogWriter.m3511e("Insert Participants : " + strM1545a, getClass().getSimpleName());
                    arrayList5.add(ParticipantDatabaseHelper.m2305a(strM2061h, strM1545a));
                    if (!arrayList3.contains(strM1545a) && BuddyDatabaseHelper.m2220a(this.f1502i, strM1545a).equals(strM1545a)) {
                        arrayList3.add(strM1545a);
                    }
                }
            }
            if (!arrayList3.contains(inboxMessage4.m1548d()) && GlobalApplication.m2388f().getString(C0062R.string.unknown).equals(ParticipantDatabaseHelper.m2315d(this.f1502i, inboxMessage4.m1548d()))) {
                arrayList3.add(inboxMessage4.m1548d());
            }
            try {
                if (arrayList5.size() > 0) {
                    this.f1502i.applyBatch("com.sec.chaton.provider", arrayList5);
                }
            } catch (Exception e) {
                ChatONLogWriter.m3499a(e.getMessage(), getClass().getSimpleName());
            }
            InBoxDatabaseHelper.m2261c(this.f1502i, strM2061h, 11);
        }
        if (inboxMessage3 != null) {
            if (inboxMessage3.m1556l() >= inBoxDataM2262d.f1761f) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(2).append(";");
                sb2.append(MessageDatabaseHelper.m2276a(inboxMessage3.m1554j(), ChatONContract.MessageTable.MsgContentType.m2195a(inboxMessage3.m1558n().m1793a())).m2197a()).append(";");
                sb2.append(ChatUtil.m795a(inboxMessage3.m1554j())).append(";");
                sb2.append(ChatUtil.m795a(ParticipantDatabaseHelper.m2315d(this.f1502i, inboxMessage3.m1548d())));
                inBoxDataM2262d.f1759d = sb2.toString();
                inBoxDataM2262d.f1764i = inboxMessage3.m1552h();
                inBoxDataM2262d.f1765j = inboxMessage3.m1548d();
                inBoxDataM2262d.f1761f = inboxMessage3.m1556l();
            }
            Iterator it3 = arrayList4.iterator();
            while (it3.hasNext()) {
                SSMGPB.InboxMessage inboxMessage7 = (SSMGPB.InboxMessage) it3.next();
                String[] strArrSplit2 = inboxMessage7.m1554j().split("\n");
                StringBuilder sb3 = new StringBuilder();
                for (String str : strArrSplit2) {
                    String[] strArrM799a = ChatUtil.m799a(str, ",", 3);
                    if (strArrM799a.length > 2) {
                        String str2 = strArrM799a[1];
                        String strM2310b = ParticipantDatabaseHelper.m2310b(this.f1502i, str2, strArrM799a[2]);
                        if (strArrM799a[0].equals("ENTER")) {
                            if (!ParticipantDatabaseHelper.m2309a(this.f1502i, str2, strM2061h)) {
                                sb3.append(String.format("%s,%s,%s", strArrM799a[0], str2, ChatUtil.m795a(strM2310b))).append(";");
                                ParticipantDatabaseHelper.m2308a(this.f1502i, strM2061h, str2, strM2310b);
                            }
                        } else if (strArrM799a[0].equals("LEAVE") && ParticipantDatabaseHelper.m2309a(this.f1502i, str2, strM2061h)) {
                            sb3.append(String.format("%s,%s,%s", strArrM799a[0], str2, ChatUtil.m795a(strM2310b))).append(";");
                            ParticipantDatabaseHelper.m2316d(this.f1502i, strM2061h, str2);
                        }
                    }
                }
                if (sb3.length() > 0) {
                    MessageDatabaseHelper.m2273a(this.f1502i, strM2061h, sb3.toString(), inboxMessage7.m1556l(), Long.toString(inboxMessage7.m1552h()));
                }
            }
            inBoxDataM2262d.f1758c += i4;
            InBoxDatabaseHelper.m2241a(this.f1502i, strM2061h, inBoxDataM2262d);
            if (z4 && !this.f1458f.m2060g() && (GlobalApplication.f1896c == null || !GlobalApplication.f1896c.equals(strM2061h))) {
                ChatONContract.MessageTable.MsgContentType msgContentTypeM2276a2 = MessageDatabaseHelper.m2276a(inboxMessage3.m1554j(), ChatONContract.MessageTable.MsgContentType.m2195a(inboxMessage3.m1558n().m1793a()));
                Intent intent = new Intent(HomeActivity.m358a(GlobalApplication.m2387e(), true));
                switch (chatTypeM2188a) {
                    case ONETOONE:
                    case BROADCAST:
                        intent.putExtra("inboxNO", strM2061h);
                        intent.putExtra("chatType", ChatONContract.InBoxTable.ChatType.ONETOONE.m2189a());
                        intent.putExtra(ChatFragment.f729h, 1);
                        break;
                    case GROUPCHAT:
                        intent.putExtra("inboxNO", strM2061h);
                        intent.putExtra("chatType", ChatONContract.InBoxTable.ChatType.GROUPCHAT.m2189a());
                        intent.putExtra(ChatFragment.f729h, 1);
                        break;
                }
                PendingIntent activity = PendingIntent.getActivity(GlobalApplication.m2387e(), 0, intent, 268435456);
                ChatONLogWriter.m3508c("[NOTI] ChatType: " + chatTypeM2188a + ", unReadCount: " + inBoxDataM2262d.f1758c + ", Memory Address:" + this, getClass().getSimpleName());
                ChatONNotificationManager.m3515a(GlobalApplication.m2387e()).m3518a(inboxMessage3.m1548d(), inboxMessage3.m1554j(), strM2061h, activity, inboxMessage3.m1552h(), msgContentTypeM2276a2, inBoxDataM2262d.f1758c, chatTypeM2188a.m2189a());
            }
        } else {
            Iterator it4 = arrayList4.iterator();
            while (it4.hasNext()) {
                SSMGPB.InboxMessage inboxMessage8 = (SSMGPB.InboxMessage) it4.next();
                String[] strArrSplit3 = inboxMessage8.m1554j().split("\n");
                StringBuilder sb4 = new StringBuilder();
                for (String str3 : strArrSplit3) {
                    String[] strArrM799a2 = ChatUtil.m799a(str3, ",", 3);
                    if (strArrM799a2.length > 2) {
                        String str4 = strArrM799a2[1];
                        String strM2310b2 = ParticipantDatabaseHelper.m2310b(this.f1502i, str4, strArrM799a2[2]);
                        sb4.append(String.format("%s,%s,%s", strArrM799a2[0], str4, ChatUtil.m795a(strM2310b2))).append(";");
                        if (strArrM799a2[0].equals("ENTER")) {
                            if (!ParticipantDatabaseHelper.m2309a(this.f1502i, str4, strM2061h)) {
                                ParticipantDatabaseHelper.m2308a(this.f1502i, strM2061h, str4, strM2310b2);
                            }
                        } else if (strArrM799a2[0].equals("LEAVE")) {
                            ParticipantDatabaseHelper.m2316d(this.f1502i, strM2061h, str4);
                        }
                    }
                }
                MessageDatabaseHelper.m2273a(this.f1502i, strM2061h, sb4.toString(), inboxMessage8.m1556l(), Long.toString(inboxMessage8.m1552h()));
            }
        }
        if (!arrayList3.isEmpty()) {
            this.f1458f.m2047a(arrayList3);
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            builderM1315a.m1313a((SSMGPB.DeliveryChatReplyItem) it5.next());
        }
        StringBuilder sb5 = new StringBuilder();
        for (int i6 = 0; i6 < builderM1315a.m1324g().size(); i6++) {
            sb5.append("[" + i6 + "] Receiver : " + builderM1315a.m1317a(i6).m1343f()).append(", MsgType : " + builderM1315a.m1317a(i6).m1347j()).append(", MsgID : " + builderM1315a.m1317a(i6).m1345h()).append(", Sender : " + builderM1315a.m1317a(i6).m1341d());
        }
        ChatONLogWriter.m3508c("ch@t[" + builderM1315a.getClass().getSimpleName() + "]UID : " + ChatONPref.m3519a().getString("uid", "") + ", DeliveryChatReplyItemsCount: " + builderM1315a.m1325h() + sb5.toString(), getClass().getSimpleName());
        TcpClient.m2758a(this.f1455c, new TcpEnvelope.Builder().m2811a(7).m2813a(builderM1315a.build()).m2816b());
        if (this.f1458f.m2059f()) {
            TcpClient.m2764d(this.f1455c);
        }
        return null;
    }

    @Override // com.sec.chaton.control.task.AbstractNetTask
    /* renamed from: a */
    protected void mo2108a(int i, Object obj, Object obj2) {
        StringBuilder sb = new StringBuilder();
        if (obj2 != null) {
            SSMGPB.DeliveryChatReply deliveryChatReply = (SSMGPB.DeliveryChatReply) ((TcpEnvelope) obj2).m2806c();
            for (int i2 = 0; i2 < deliveryChatReply.m1301e().size(); i2++) {
                sb.append("[" + i2 + "] MsgID : " + deliveryChatReply.m1297a(i2).m1345h()).append(", MsgType : " + deliveryChatReply.m1297a(i2).m1347j()).append(", Receiver : " + deliveryChatReply.m1297a(i2).m1343f()).append(", Sender : " + deliveryChatReply.m1297a(i2).m1341d());
            }
            ChatONLogWriter.m3508c("ch@t[" + deliveryChatReply.getClass().getSimpleName() + "]UID : " + ChatONPref.m3519a().getString("uid", "") + ", DeliveryChatReplyItemsCount : " + deliveryChatReply.m1302f() + ", ResultCode : " + deliveryChatReply.m1304h().m1898d() + ", ResultMsg : " + deliveryChatReply.m1304h().m1900f() + ", DeliveryChatReplyItemsCount :" + deliveryChatReply.m1302f() + sb.toString(), getClass().getSimpleName());
        } else {
            ChatONLogWriter.m3508c("Error", getClass().getSimpleName());
        }
        Message message = new Message();
        message.what = 6;
        message.obj = new MessageResultEntry(true, ResultEntry.Result.SUCCESS);
        this.f1454b.sendMessage(message);
    }
}
