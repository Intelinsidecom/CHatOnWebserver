package com.sec.chaton.receiver;

import android.app.PendingIntent;
import android.content.Intent;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.control.MessageControl;
import com.sec.chaton.control.PushControlFactory;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.helper.MessageDatabaseHelper;
import com.sec.chaton.database.task.AbstractQueryTask;
import com.sec.chaton.database.task.PushReceivedTask;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p000io.entry.PushEntry;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONNotificationManager;

/* renamed from: com.sec.chaton.receiver.a */
/* loaded from: classes.dex */
class C0400a implements AbstractQueryTask.OnQueryTaskResult {

    /* renamed from: a */
    final /* synthetic */ PushReceiver f2804a;

    C0400a(PushReceiver pushReceiver) {
        this.f2804a = pushReceiver;
    }

    @Override // com.sec.chaton.database.task.AbstractQueryTask.OnQueryTaskResult
    /* renamed from: a */
    public void mo654a(int i, boolean z, Object obj) {
        int iIntValue;
        if (!z || obj == null) {
            return;
        }
        PushReceivedTask.PushResult pushResult = (PushReceivedTask.PushResult) obj;
        PushEntry pushEntryM2324c = pushResult.m2324c();
        if (!pushResult.m2327f() && (GlobalApplication.f1896c == null || !GlobalApplication.f1896c.equals(pushResult.m2325d()))) {
            Intent intent = new Intent(HomeActivity.m358a(this.f2804a.f2803c, ChatONContract.InBoxTable.ChatType.m2188a(pushEntryM2324c.chatType.intValue()) != ChatONContract.InBoxTable.ChatType.WEB_AUTH));
            switch (ChatONContract.InBoxTable.ChatType.m2188a(pushEntryM2324c.chatType.intValue())) {
                case ONETOONE:
                case BROADCAST:
                    intent.putExtra("inboxNO", pushResult.m2325d());
                    intent.putExtra("chatType", ChatONContract.InBoxTable.ChatType.ONETOONE.m2189a());
                    intent.putExtra("fromPush", 1);
                    intent.putExtra(ChatFragment.f729h, 1);
                    iIntValue = ChatONContract.InBoxTable.ChatType.ONETOONE.m2189a();
                    break;
                case GROUPCHAT:
                    intent.putExtra("inboxNO", pushResult.m2325d());
                    intent.putExtra("chatType", ChatONContract.InBoxTable.ChatType.GROUPCHAT.m2189a());
                    intent.putExtra("fromPush", 1);
                    intent.putExtra(ChatFragment.f729h, 1);
                    iIntValue = ChatONContract.InBoxTable.ChatType.GROUPCHAT.m2189a();
                    break;
                case WEB_AUTH:
                    intent.putExtra("inboxNO", pushResult.m2325d());
                    intent.putExtra("chatType", ChatONContract.InBoxTable.ChatType.WEB_AUTH.m2189a());
                    intent.putExtra("fromPush", 1);
                    intent.putExtra("Content", pushEntryM2324c.message);
                    iIntValue = pushEntryM2324c.chatType.intValue();
                    break;
                default:
                    iIntValue = 0;
                    break;
            }
            PendingIntent activity = PendingIntent.getActivity(this.f2804a.f2803c, 0, intent, 268435456);
            String str = pushEntryM2324c.message;
            if (pushEntryM2324c.msgType.intValue() != ChatONContract.MessageTable.MsgServerType.MSG.m2198a()) {
                ChatONContract.MessageTable.MsgContentType.m2196a(MessageDatabaseHelper.m2275a(pushEntryM2324c.message));
            }
            ChatONLogWriter.m3508c("[NOTI] ChatType: " + ChatONContract.InBoxTable.ChatType.m2188a(pushEntryM2324c.chatType.intValue()).toString() + ", Memory Address:" + this, this.f2804a.getClass().getSimpleName());
            ChatONNotificationManager.m3515a(this.f2804a.f2803c).m3518a(pushEntryM2324c.senderID, pushEntryM2324c.message, pushResult.m2325d(), activity, pushEntryM2324c.msgID.longValue(), MessageDatabaseHelper.m2275a(pushEntryM2324c.message), pushResult.m2326e(), iIntValue);
        }
        ChatONContract.InBoxTable.ChatType chatTypeM2188a = ChatONContract.InBoxTable.ChatType.m2188a(pushEntryM2324c.chatType.intValue());
        if (GlobalApplication.f1896c == null || !pushResult.m2325d().equals(GlobalApplication.f1896c)) {
            MessageControl messageControlM2012a = MessageControl.m2012a(pushResult.m2325d());
            if (messageControlM2012a != null) {
                messageControlM2012a.m2057d();
            }
        } else {
            PushReceiver.f2800e.m765a(pushEntryM2324c.f1916IP, pushEntryM2324c.PORT.intValue(), pushEntryM2324c.sessionID, chatTypeM2188a);
        }
        if (pushResult.m2323b()) {
            PushControlFactory.m2072a().mo1975a(pushResult.m2322a());
        }
    }
}
