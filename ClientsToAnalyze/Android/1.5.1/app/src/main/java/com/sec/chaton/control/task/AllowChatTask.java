package com.sec.chaton.control.task;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.common.SSMGPB;
import com.sec.chaton.common.entry.MessageResultEntry;
import com.sec.chaton.common.entry.ResultEntry;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.helper.InBoxDatabaseHelper;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.TcpEnvelope;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.DeviceInfoUtil;

/* loaded from: classes.dex */
public class AllowChatTask extends AbstractNetTask {

    /* renamed from: g */
    long f1463g;

    /* renamed from: h */
    ChatONContract.InBoxTable.ChatType f1464h;

    /* renamed from: i */
    String f1465i;

    /* renamed from: j */
    String f1466j;

    /* renamed from: k */
    String f1467k;

    public AllowChatTask(Handler handler, ChatONContract.InBoxTable.ChatType chatType, String str, String str2, long j, String str3) {
        super(handler);
        this.f1464h = chatType;
        this.f1466j = str2;
        this.f1463g = j;
        this.f1465i = str3;
        this.f1467k = str;
    }

    @Override // com.sec.chaton.control.task.AbstractNetTask
    /* renamed from: a */
    protected TcpEnvelope mo2107a() {
        SSMGPB.AllowChatRequest.Builder builderM860r = SSMGPB.AllowChatRequest.m860r();
        builderM860r.m883a(this.f1463g).m886a(SSMGPB.ChatType.m1239a(this.f1464h.m2189a())).m890b(String.valueOf(this.f1466j)).m893d(ChatONPref.m3519a().getString("uid", "")).m895e(DeviceInfoUtil.m3564a()).m891c(ChatONPref.m3519a().getString("msisdn", ""));
        if (!TextUtils.isEmpty(this.f1465i)) {
            builderM860r.m887a(this.f1465i);
        }
        ChatONLogWriter.m3508c("ch@t[" + builderM860r.getClass().getSimpleName() + "]UID : " + ChatONPref.m3519a().getString("uid", "") + ", ChatType : " + builderM860r.m899h() + ", MsgID : " + builderM860r.m898g() + ", Receiver : " + builderM860r.m902k() + ", Sender : " + builderM860r.m901j() + ", SessionID : " + builderM860r.m900i(), getClass().getSimpleName());
        TcpEnvelope.Builder builder = new TcpEnvelope.Builder();
        builder.m2811a(2).m2813a(builderM860r.build()).m2812a(20000L);
        return builder.m2816b();
    }

    @Override // com.sec.chaton.control.task.AbstractNetTask
    /* renamed from: a */
    protected void mo2108a(int i, Object obj, Object obj2) {
        Message message = new Message();
        message.what = 2;
        if (obj2 == null) {
            if (this.f1456d >= f1453a) {
                InBoxDatabaseHelper.m2263e(GlobalApplication.m2387e().getContentResolver(), this.f1467k);
            }
            ChatONLogWriter.m3508c("Fail to send allowChat message", getClass().getSimpleName());
            message.obj = new MessageResultEntry(false, ResultEntry.Result.NETWORKFAIL, this.f1467k);
            this.f1454b.sendMessage(message);
            return;
        }
        SSMGPB.AllowChatReply allowChatReply = (SSMGPB.AllowChatReply) ((TcpEnvelope) obj2).m2806c();
        ChatONLogWriter.m3508c("ch@t[" + allowChatReply.getClass().getSimpleName() + "]UID : " + ChatONPref.m3519a().getString("uid", "") + ", MsgID : " + allowChatReply.m822d() + ", ResultCode : " + allowChatReply.m824f().m1898d() + ", ResultMsg : " + allowChatReply.m824f().m1900f(), getClass().getSimpleName());
        int iM1898d = allowChatReply.m824f().m1898d();
        if (iM1898d == 1000) {
            message.obj = new MessageResultEntry(true, iM1898d, this.f1467k);
        } else {
            if (iM1898d == 3003) {
                InBoxDatabaseHelper.m2242a(GlobalApplication.m2387e().getContentResolver(), this.f1467k, GlobalApplication.m2389g().m3602b().m3603a(), GlobalApplication.m2389g().m3602b().m3606b());
            }
            message.obj = new MessageResultEntry(false, iM1898d, this.f1467k);
        }
        this.f1454b.sendMessage(message);
    }
}
