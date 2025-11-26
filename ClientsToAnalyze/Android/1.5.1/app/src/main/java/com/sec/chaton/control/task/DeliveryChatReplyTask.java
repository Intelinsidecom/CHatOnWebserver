package com.sec.chaton.control.task;

import android.content.ContentResolver;
import android.os.Handler;
import com.sec.chaton.chat.DeliveryReplyHolder;
import com.sec.chaton.common.SSMGPB;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.TcpEnvelope;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import java.util.Iterator;

/* loaded from: classes.dex */
public class DeliveryChatReplyTask extends AbstractNetTask {

    /* renamed from: g */
    private String f1495g;

    /* renamed from: h */
    private ChatONContract.InBoxTable.ChatType f1496h;

    /* renamed from: i */
    private String f1497i;

    /* renamed from: j */
    private DeliveryReplyHolder f1498j;

    /* renamed from: k */
    private ContentResolver f1499k;

    public DeliveryChatReplyTask(Handler handler, String str, ChatONContract.InBoxTable.ChatType chatType, String str2) {
        super(handler);
        this.f1495g = str;
        this.f1496h = chatType;
        this.f1497i = str2;
        this.f1499k = GlobalApplication.m2387e().getContentResolver();
    }

    @Override // com.sec.chaton.control.task.AbstractNetTask
    /* renamed from: a */
    protected TcpEnvelope mo2107a() {
        this.f1498j = DeliveryReplyHolder.m802b(this.f1495g);
        SSMGPB.DeliveryChatReply.Builder builderM1315a = SSMGPB.DeliveryChatReply.m1295j().m1315a(ChatONPref.m3519a().getString("uid", ""));
        Iterator it = this.f1498j.m806c().iterator();
        while (it.hasNext()) {
            SSMGPB.InboxMessage inboxMessage = (SSMGPB.InboxMessage) it.next();
            builderM1315a.m1313a(SSMGPB.DeliveryChatReplyItem.m1337l().m1352a(inboxMessage.m1552h()).m1356a(inboxMessage.m1548d()).m1355a(inboxMessage.m1558n()).m1359b(ChatONPref.m3519a().getString("msisdn", "")).build());
        }
        this.f1498j.m803a();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < builderM1315a.m1324g().size(); i++) {
            sb.append("[" + i + "] Receiver : " + builderM1315a.m1317a(i).m1343f()).append(", MsgType : " + builderM1315a.m1317a(i).m1347j()).append(", MsgID : " + builderM1315a.m1317a(i).m1345h()).append(", Sender : " + builderM1315a.m1317a(i).m1341d());
        }
        ChatONLogWriter.m3508c("ch@t[" + builderM1315a.getClass().getSimpleName() + "]UID : " + ChatONPref.m3519a().getString("uid", "") + ", DeliveryChatReplyItemsCount: " + builderM1315a.m1325h() + sb.toString(), getClass().getSimpleName());
        return new TcpEnvelope.Builder().m2811a(7).m2813a(builderM1315a.build()).m2812a(20000L).m2816b();
    }

    @Override // com.sec.chaton.control.task.AbstractNetTask
    /* renamed from: a */
    protected void mo2108a(int i, Object obj, Object obj2) {
    }
}
