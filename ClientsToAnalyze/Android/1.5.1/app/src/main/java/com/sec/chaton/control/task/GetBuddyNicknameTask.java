package com.sec.chaton.control.task;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.chat.ChatUtil;
import com.sec.chaton.common.SSMGPB;
import com.sec.chaton.common.entry.MessageResultEntry;
import com.sec.chaton.common.entry.ResultEntry;
import com.sec.chaton.control.MessageControl;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.helper.InBoxDatabaseHelper;
import com.sec.chaton.database.helper.ParticipantDatabaseHelper;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.TcpEnvelope;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.MessageIDGenerator;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class GetBuddyNicknameTask extends AbstractNetTask {

    /* renamed from: g */
    private ArrayList f1592g;

    /* renamed from: h */
    private String f1593h;

    /* renamed from: i */
    private ContentResolver f1594i;

    public GetBuddyNicknameTask(Handler handler, ArrayList arrayList, String str) {
        super(handler);
        this.f1592g = arrayList;
        this.f1593h = str;
        this.f1594i = GlobalApplication.m2387e().getContentResolver();
        this.f1457e = -1L;
    }

    @Override // com.sec.chaton.control.task.AbstractNetTask
    /* renamed from: a */
    protected TcpEnvelope mo2107a() {
        if (this.f1457e == -1) {
            this.f1457e = MessageIDGenerator.m3598a();
        }
        SSMGPB.NicknameRequest.Builder builderM1876a = SSMGPB.NicknameRequest.m1864g().m1876a(this.f1457e);
        if (this.f1592g == null) {
            this.f1592g = ParticipantDatabaseHelper.m2307a(this.f1594i, this.f1593h, ParticipantDatabaseHelper.m2312b(this.f1594i, this.f1593h));
        }
        if (this.f1592g.size() <= 0) {
            ChatONLogWriter.m3506b("unknown participant count 0.", getClass().getSimpleName());
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f1592g.size()) {
                ChatONLogWriter.m3508c("ch@t[" + builderM1876a.getClass().getSimpleName() + "]UID : " + ChatONPref.m3519a().getString("uid", "") + ", MsgID : " + builderM1876a.m1886g() + ", Users : " + ChatONLogWriter.m3494a(builderM1876a.m1887h()), getClass().getSimpleName());
                return new TcpEnvelope.Builder().m2813a(builderM1876a.build()).m2811a(18).m2816b();
            }
            builderM1876a.m1879a(((String) this.f1592g.get(i2)).toString());
            i = i2 + 1;
        }
    }

    @Override // com.sec.chaton.control.task.AbstractNetTask
    /* renamed from: a */
    protected void mo2108a(int i, Object obj, Object obj2) {
        StringBuilder sb = new StringBuilder();
        Message message = new Message();
        message.what = 18;
        if (obj2 == null) {
            ChatONLogWriter.m3508c("Fail to get Nickname", getClass().getSimpleName());
            if (this.f1592g == null || this.f1592g.size() <= 0) {
                message.obj = new MessageResultEntry(false, ResultEntry.Result.FAIL);
            } else {
                message.obj = new MessageResultEntry(false, ResultEntry.Result.NETWORKFAIL);
                if (this.f1456d >= f1453a) {
                    InBoxDatabaseHelper.m2263e(this.f1594i, this.f1593h);
                    MessageControl messageControlM2012a = MessageControl.m2012a(this.f1593h);
                    if (messageControlM2012a != null && messageControlM2012a.m2059f()) {
                        messageControlM2012a.m2055c();
                        return;
                    }
                }
            }
            this.f1454b.sendMessage(message);
            return;
        }
        SSMGPB.NicknameReply nicknameReply = (SSMGPB.NicknameReply) ((TcpEnvelope) obj2).m2806c();
        for (int i2 = 0; i2 < nicknameReply.m1835e().size(); i2++) {
            sb.append("[" + i2 + "] User : " + nicknameReply.m1831a(i2).m1803d()).append(", Nickname : " + nicknameReply.m1831a(i2).m1805f());
        }
        ChatONLogWriter.m3508c("ch@t[" + nicknameReply.getClass().getSimpleName() + "]UID : " + ChatONPref.m3519a().getString("uid", "") + ", ResultCode : " + nicknameReply.m1837g().m1898d() + ", ResultMessage : " + nicknameReply.m1837g().m1900f() + ", MsgID : " + nicknameReply.m1834d() + ", NicknameList : " + sb.toString(), getClass().getSimpleName());
        int iM1898d = nicknameReply.m1837g().m1898d();
        if (iM1898d == 1000 || iM1898d == 1001) {
            MessageControl messageControlM2012a2 = MessageControl.m2012a(this.f1593h);
            if (messageControlM2012a2 == null || !messageControlM2012a2.m2059f()) {
                String strM1805f = null;
                InBoxDatabaseHelper.InBoxData inBoxDataM2262d = InBoxDatabaseHelper.m2262d(this.f1594i, this.f1593h);
                if (inBoxDataM2262d != null) {
                    boolean z = false;
                    for (int i3 = 0; i3 < nicknameReply.m1835e().size(); i3++) {
                        if (ParticipantDatabaseHelper.m2311b(this.f1594i, nicknameReply.m1831a(i3).m1803d(), this.f1593h, nicknameReply.m1831a(i3).m1805f())) {
                            z = true;
                            if (nicknameReply.m1831a(i3).m1803d().equals(inBoxDataM2262d.f1765j)) {
                                strM1805f = nicknameReply.m1831a(i3).m1805f();
                            }
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("participants_buddy_name", nicknameReply.m1831a(i3).m1805f());
                            this.f1594i.update(ChatONContract.ParticipantTable.f1741a, contentValues, "participants_buddy_no=?", new String[]{nicknameReply.m1831a(i3).m1803d()});
                        }
                    }
                    if (z) {
                        if (strM1805f != null) {
                            String[] strArrSplit = inBoxDataM2262d.f1759d.split(";");
                            if (strArrSplit.length == 4) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(strArrSplit[0]).append(";").append(strArrSplit[1]).append(";").append(strArrSplit[2]).append(";").append(ChatUtil.m795a(strM1805f));
                                inBoxDataM2262d.f1759d = sb2.toString();
                            }
                        }
                        ChatONLogWriter.m3508c("InBoxDatabaseHelper.updateInBox", getClass().getSimpleName());
                        InBoxDatabaseHelper.m2241a(this.f1594i, this.f1593h, inBoxDataM2262d);
                    }
                    message.obj = new MessageResultEntry(true, nicknameReply.m1837g().m1898d());
                }
            } else {
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= nicknameReply.m1835e().size()) {
                        ChatONLogWriter.m3508c("temp connection - clearMessageControl() call!", getClass().getSimpleName());
                        MessageControl.m2012a(this.f1593h).m2055c();
                        return;
                    }
                    String strM1805f2 = nicknameReply.m1831a(i5).m1805f();
                    String strM1803d = nicknameReply.m1831a(i5).m1803d();
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("participants_buddy_name", strM1805f2);
                    this.f1594i.update(ChatONContract.ParticipantTable.f1741a, contentValues2, "participants_buddy_no=?", new String[]{strM1803d});
                    Cursor cursorQuery = this.f1594i.query(ChatONContract.InBoxTable.f1717a, null, "inbox_last_msg_sender=?", new String[]{strM1803d}, null);
                    if (cursorQuery != null) {
                        while (cursorQuery.moveToNext()) {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_no"));
                            InBoxDatabaseHelper.InBoxData inBoxDataM2262d2 = InBoxDatabaseHelper.m2262d(this.f1594i, string);
                            if (inBoxDataM2262d2 != null) {
                                String[] strArrSplit2 = inBoxDataM2262d2.f1759d.split(";");
                                if (strArrSplit2.length == 4) {
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append(strArrSplit2[0]).append(";").append(strArrSplit2[1]).append(";").append(strArrSplit2[2]).append(";").append(ChatUtil.m795a(strM1805f2));
                                    inBoxDataM2262d2.f1759d = sb3.toString();
                                }
                                ChatONLogWriter.m3508c("InBoxDatabaseHelper.updateInBox", getClass().getSimpleName());
                                InBoxDatabaseHelper.m2241a(this.f1594i, string, inBoxDataM2262d2);
                            }
                        }
                        cursorQuery.close();
                    }
                    i4 = i5 + 1;
                }
            }
        } else {
            ChatONLogWriter.m3509d("reply.getResult().getResultCode():" + nicknameReply.m1837g().m1898d());
            message.obj = new MessageResultEntry(false, nicknameReply.m1837g().m1898d());
        }
        this.f1454b.sendMessage(message);
    }
}
