package com.sec.chaton.control;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.chat.DeliveryReplyHolder;
import com.sec.chaton.common.SSMGPB;
import com.sec.chaton.common.entry.ResultEntry;
import com.sec.chaton.control.TaskContainer;
import com.sec.chaton.control.task.AllowChatTask;
import com.sec.chaton.control.task.AnnounceChangeTask;
import com.sec.chaton.control.task.AnswerBackTask;
import com.sec.chaton.control.task.ChatTask;
import com.sec.chaton.control.task.DeliveryChatReplyTask;
import com.sec.chaton.control.task.DeliveryChatTask;
import com.sec.chaton.control.task.EndChatTask;
import com.sec.chaton.control.task.FileDownloadTask2;
import com.sec.chaton.control.task.FileUploadTask2;
import com.sec.chaton.control.task.GetBuddyNicknameTask;
import com.sec.chaton.control.task.InitChatRoomTask;
import com.sec.chaton.control.task.InviteChatTask;
import com.sec.chaton.control.task.MediaChatTask;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.helper.InBoxDatabaseHelper;
import com.sec.chaton.database.helper.MessageDatabaseHelper;
import com.sec.chaton.database.helper.NotifyingAsyncQueryHandler;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.NetResultReceiver;
import com.sec.chaton.network.TcpClient;
import com.sec.chaton.network.TcpContext;
import com.sec.chaton.network.TcpEnvelope;
import com.sec.chaton.network.clientapi.AnnounceChange;
import com.sec.chaton.network.clientapi.AnswerBack;
import com.sec.chaton.network.clientapi.DeliveryChat;
import com.sec.chaton.network.clientapi.Disconnect;
import com.sec.chaton.util.AesCipher;
import com.sec.chaton.util.ChatONFileUtil;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.MessageIDGenerator;
import com.sec.chaton.util.StorageStateInfoUtil;
import com.sec.pns.msg.frontend.MsgFrontendCommon;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class MessageControl implements NetResultReceiver.Receiver {

    /* renamed from: e */
    public static HashMap f1362e = new HashMap();

    /* renamed from: q */
    private static NotifyingAsyncQueryHandler f1363q;

    /* renamed from: a */
    NetResultReceiver f1364a;

    /* renamed from: g */
    private Handler f1369g;

    /* renamed from: h */
    private String f1370h;

    /* renamed from: i */
    private TcpContext f1371i;

    /* renamed from: j */
    private ChatFragment f1372j;

    /* renamed from: l */
    private String f1374l;

    /* renamed from: k */
    private boolean f1373k = false;

    /* renamed from: m */
    private boolean f1375m = false;

    /* renamed from: b */
    public boolean f1365b = true;

    /* renamed from: c */
    public Map f1366c = new HashMap();

    /* renamed from: d */
    public Map f1367d = new HashMap();

    /* renamed from: n */
    private Map f1376n = new HashMap();

    /* renamed from: o */
    private boolean f1377o = false;

    /* renamed from: p */
    private ArrayList f1378p = new ArrayList();

    /* renamed from: r */
    private Handler f1379r = new HandlerC0184m(this);

    /* renamed from: f */
    NotifyingAsyncQueryHandler.AsyncQueryListener f1368f = new C0186o(this);

    public class FileResultEntry extends ResultEntry {
    }

    public MessageControl(Handler handler, String str) {
        this.f1369g = handler;
        this.f1370h = str;
        this.f1374l = str;
        this.f1364a = new NetResultReceiver(this.f1369g, this);
        f1363q = new NotifyingAsyncQueryHandler(GlobalApplication.m2387e().getContentResolver(), this.f1368f);
    }

    /* renamed from: a */
    public static synchronized MessageControl m2011a(Handler handler, String str) {
        if (f1362e.containsKey(str)) {
            ((MessageControl) f1362e.get(str)).f1369g = handler;
            ((MessageControl) f1362e.get(str)).f1370h = str;
            ((MessageControl) f1362e.get(str)).f1374l = str;
            ((MessageControl) f1362e.get(str)).f1364a = new NetResultReceiver(handler, (NetResultReceiver.Receiver) f1362e.get(str));
        } else {
            f1362e.put(str, new MessageControl(handler, str));
        }
        return (MessageControl) f1362e.get(str);
    }

    /* renamed from: a */
    public static synchronized MessageControl m2012a(String str) {
        return f1362e != null ? (MessageControl) f1362e.get(str) : null;
    }

    /* renamed from: a */
    public static synchronized void m2014a() {
        Iterator it = new ArrayList(f1362e.values()).iterator();
        while (it.hasNext()) {
            MessageControl messageControl = (MessageControl) it.next();
            if (messageControl != null) {
                messageControl.m2055c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2015a(int i, int i2, int i3, Object obj) {
        Message messageObtain = Message.obtain();
        messageObtain.arg1 = i;
        messageObtain.arg2 = i2;
        messageObtain.what = i3;
        messageObtain.obj = obj;
        this.f1369g.sendMessage(messageObtain);
    }

    /* renamed from: a */
    public static void m2017a(String str, String str2, String str3) {
        f1363q.startQuery(99, new String[]{str2, str3}, ChatONContract.MessageTable.f1726a, null, "message_inbox_no='" + str + "' AND message_content_type='" + ChatONContract.MessageTable.MsgContentType.IMAGE.m2197a() + "' OR message_content_type='" + ChatONContract.MessageTable.MsgContentType.VIDEO.m2197a() + "' AND message_content is not null AND message_download_uri is null", null, null);
    }

    @Override // com.sec.chaton.network.NetResultReceiver.Receiver
    /* renamed from: a */
    public void mo2027a(int i, Object obj) {
    }

    @Override // com.sec.chaton.network.NetResultReceiver.Receiver
    /* renamed from: a */
    public void mo2028a(int i, Object obj, Object obj2) {
        if (obj2 != null) {
            TcpEnvelope tcpEnvelope = (TcpEnvelope) obj2;
            switch (tcpEnvelope.m2805b()) {
                case 6:
                    SSMGPB.DeliveryChat deliveryChat = (SSMGPB.DeliveryChat) tcpEnvelope.m2806c();
                    ChatONLogWriter.m3506b("DeliveryChat From Server : Session ID = " + deliveryChat.m1258d(), getClass().getSimpleName());
                    m2038a(deliveryChat);
                    break;
                case MsgFrontendCommon.__NotiAcks__ /* 10 */:
                    m2037a((SSMGPB.AnswerBack) tcpEnvelope.m2806c());
                    break;
                case 16:
                    m2036a((SSMGPB.AnnounceChange) tcpEnvelope.m2806c());
                    break;
            }
        }
    }

    /* renamed from: a */
    public void m2029a(long j) {
        if (this.f1366c.containsKey(Long.valueOf(j))) {
            ((FileUploadTask2) this.f1366c.get(Long.valueOf(j))).cancel(true);
        }
        MessageDatabaseHelper.m2278a(GlobalApplication.m2387e().getContentResolver(), Long.valueOf(j));
    }

    /* renamed from: a */
    public void m2030a(long j, ChatONContract.InBoxTable.ChatType chatType, String str, String[] strArr, boolean z, String str2) {
        TaskContainer taskContainer = new TaskContainer(this.f1379r, this.f1371i);
        taskContainer.m2085a(TaskContainer.TaskType.NetTask, new MediaChatTask(taskContainer.m2086b(), this.f1370h, j, null, "", ChatONContract.MessageTable.MsgContentType.GEO, chatType, str, strArr, "", z, str2));
        this.f1376n.put(Long.valueOf(taskContainer.m2083a()), taskContainer);
        if (!z) {
            MessageDatabaseHelper.m2289a(f1363q, 0, Long.valueOf(j));
        }
        taskContainer.m2088d();
    }

    /* renamed from: a */
    public void m2031a(long j, ChatONContract.InBoxTable.ChatType chatType, String str, String[] strArr, boolean z, String str2, File file, String str3, String str4, ChatONContract.MessageTable.MsgContentType msgContentType) {
        TaskContainer taskContainer = new TaskContainer(this.f1379r, this.f1371i);
        taskContainer.m2085a(TaskContainer.TaskType.NetTask, new MediaChatTask(taskContainer.m2086b(), this.f1370h, j, file, str3, msgContentType, chatType, str, strArr, str4, z, str2));
        this.f1376n.put(Long.valueOf(taskContainer.m2083a()), taskContainer);
        taskContainer.m2088d();
    }

    /* renamed from: a */
    public void m2032a(long j, String str, ChatONContract.MessageTable.MsgContentType msgContentType, ChatONContract.InBoxTable.ChatType chatType, String str2, String[] strArr, String str3, boolean z) {
        TaskContainer taskContainer = new TaskContainer(this.f1379r, this.f1371i);
        if (z) {
            taskContainer.m2085a(TaskContainer.TaskType.NetTask, new InitChatRoomTask(taskContainer.m2086b(), str, j, msgContentType, chatType, strArr, str3));
        } else {
            switch (C0189r.f1449a[chatType.ordinal()]) {
                case 1:
                case 2:
                    MessageDatabaseHelper.m2289a(f1363q, 0, Long.valueOf(j));
                    break;
            }
            taskContainer.m2085a(TaskContainer.TaskType.NetTask, new ChatTask(taskContainer.m2086b(), j, this.f1370h, msgContentType, chatType, str2, str3));
        }
        this.f1376n.put(Long.valueOf(taskContainer.m2083a()), taskContainer);
        taskContainer.m2088d();
    }

    /* renamed from: a */
    public void m2033a(View view, int i, String str, boolean z, String str2, long j, ChatONContract.MessageTable.MsgContentType msgContentType, ChatONContract.InBoxTable.ChatType chatType, String str3) {
        String[] strArrSplit = str.split("\n");
        ChatONLogWriter.m3506b("[downloadFile2]", getClass().getName());
        FileDownloadTask2 fileDownloadTask2M2129a = new FileDownloadTask2.Builder().m2127a(strArrSplit[2]).m2122a(this.f1369g).m2126a(msgContentType).m2123a(view).m2130b(strArrSplit[4]).m2131c(strArrSplit[3]).m2128a(z).m2132d(str2).m2121a(j).m2125a(chatType).m2120a(i).m2124a(this.f1372j).m2133e(str3).m2129a();
        fileDownloadTask2M2129a.execute(new String[0]);
        this.f1367d.put(Long.valueOf(j), fileDownloadTask2M2129a);
        ChatONLogWriter.m3506b("msdid : " + j + ", keyset=" + this.f1367d.keySet(), getClass().getName());
        ChatONLogWriter.m3506b("fileDownloadInProgress : " + this.f1367d + ", addr=" + this.f1367d.hashCode(), getClass().getName());
    }

    /* renamed from: a */
    public void m2034a(View view, File file, String str, ChatONContract.MessageTable.MsgContentType msgContentType, ChatONContract.InBoxTable.ChatType chatType, String str2, String[] strArr, boolean z, String str3, long j) {
        MessageDatabaseHelper.m2301c(GlobalApplication.m2387e().getContentResolver(), Long.valueOf(j));
        AsyncTaskC0188q asyncTaskC0188q = new AsyncTaskC0188q(this, this.f1369g, file, msgContentType, str, file.getName().substring(0, file.getName().indexOf(".")), this.f1370h, j, str3, j, file, str, msgContentType, chatType, str2, strArr, z, str3);
        asyncTaskC0188q.m2137a(view);
        asyncTaskC0188q.execute(new String[0]);
        this.f1366c.put(Long.valueOf(j), asyncTaskC0188q);
    }

    /* renamed from: a */
    public void m2035a(ChatFragment chatFragment) {
        this.f1372j = chatFragment;
    }

    /* renamed from: a */
    public void m2036a(SSMGPB.AnnounceChange announceChange) {
        new AnnounceChangeTask(this.f1369g, announceChange, this.f1370h).m2110a(this.f1371i);
    }

    /* renamed from: a */
    public void m2037a(SSMGPB.AnswerBack answerBack) {
        new AnswerBackTask(this.f1369g, answerBack).m2110a(this.f1371i);
    }

    /* renamed from: a */
    public void m2038a(SSMGPB.DeliveryChat deliveryChat) {
        TaskContainer taskContainer = new TaskContainer(this.f1379r, this.f1371i);
        taskContainer.m2085a(TaskContainer.TaskType.NetTask, new DeliveryChatTask(taskContainer.m2086b(), this.f1370h, deliveryChat, this));
        taskContainer.m2088d();
    }

    /* renamed from: a */
    public void m2039a(ChatONContract.InBoxTable.ChatType chatType, String str) {
        DeliveryReplyHolder deliveryReplyHolderM802b = DeliveryReplyHolder.m802b(this.f1370h);
        if (!TcpClient.m2759a(this.f1371i)) {
            deliveryReplyHolderM802b.m803a();
        } else {
            if (deliveryReplyHolderM802b.m805b()) {
                return;
            }
            new DeliveryChatReplyTask(this.f1369g, this.f1370h, chatType, str).m2110a(this.f1371i);
        }
    }

    /* renamed from: a */
    public void m2040a(ChatONContract.InBoxTable.ChatType chatType, String str, String str2, String[] strArr) {
        TaskContainer taskContainer = new TaskContainer(this.f1379r, this.f1371i);
        taskContainer.m2085a(TaskContainer.TaskType.NetTask, new EndChatTask(taskContainer.m2086b(), chatType, str, str2, strArr));
        this.f1376n.put(Long.valueOf(taskContainer.m2083a()), taskContainer);
        taskContainer.m2088d();
    }

    /* renamed from: a */
    public void m2041a(ChatONContract.InBoxTable.ChatType chatType, String str, String[] strArr, boolean z, String str2) {
        TaskContainer taskContainer = new TaskContainer(this.f1379r, this.f1371i);
        String str3 = "geo\n\n\n" + str2;
        long jM3598a = MessageIDGenerator.m3598a();
        taskContainer.m2085a(TaskContainer.TaskType.NetTask, new MediaChatTask(taskContainer.m2086b(), this.f1370h, jM3598a, null, "", ChatONContract.MessageTable.MsgContentType.GEO, chatType, str, strArr, "", z, str3));
        this.f1376n.put(Long.valueOf(taskContainer.m2083a()), taskContainer);
        if ((TextUtils.isEmpty(str) || str.equals("null")) && chatType != ChatONContract.InBoxTable.ChatType.BROADCAST && !this.f1372j.f734D.isShowing()) {
            this.f1372j.f734D.show();
        }
        MessageDatabaseHelper.m2291a(f1363q, 11, String.valueOf(jM3598a), this.f1370h, ChatONContract.MessageTable.MsgContentType.GEO, str3, strArr.length);
        taskContainer.m2088d();
    }

    /* renamed from: a */
    public void m2042a(ChatONContract.MessageTable.MsgContentType msgContentType, ChatONContract.InBoxTable.ChatType chatType, String str, String[] strArr, String str2) {
        TaskContainer taskContainer = new TaskContainer(this.f1379r, this.f1371i);
        long jM3598a = MessageIDGenerator.m3598a();
        taskContainer.m2085a(TaskContainer.TaskType.NetTask, new ChatTask(taskContainer.m2086b(), jM3598a, this.f1370h, msgContentType, chatType, str, str2));
        this.f1376n.put(Long.valueOf(taskContainer.m2083a()), taskContainer);
        MessageDatabaseHelper.m2291a(f1363q, 11, String.valueOf(jM3598a), this.f1370h, msgContentType, str2, strArr.length);
        InBoxDatabaseHelper.m2255a(f1363q, 1, this.f1370h, str2, strArr.length, msgContentType);
        taskContainer.m2088d();
    }

    /* renamed from: a */
    public void m2043a(ChatONContract.MessageTable.MsgContentType msgContentType, String str, String[] strArr, String[] strArr2) {
        TaskContainer taskContainer = new TaskContainer(this.f1379r, this.f1371i);
        taskContainer.m2085a(TaskContainer.TaskType.NetTask, new InviteChatTask(taskContainer.m2086b(), msgContentType, str, strArr, strArr2, this.f1370h));
        this.f1376n.put(Long.valueOf(taskContainer.m2083a()), taskContainer);
        taskContainer.m2088d();
    }

    /* renamed from: a */
    public void m2044a(File file, String str, ChatONContract.MessageTable.MsgContentType msgContentType, ChatONContract.InBoxTable.ChatType chatType, String str2, String[] strArr, boolean z, String str3) {
        long jM3598a = MessageIDGenerator.m3598a();
        String string = Uri.fromFile(file).toString();
        String strSubstring = file.getName().substring(0, file.getName().indexOf("."));
        if (ChatONContract.MessageTable.MsgContentType.GEO != msgContentType) {
            if (StorageStateInfoUtil.m3677a() && !file.getAbsolutePath().contains(GlobalApplication.m2387e().getExternalFilesDir(null).getAbsolutePath())) {
                String str4 = GlobalApplication.m2387e().getExternalFilesDir(null).getAbsolutePath() + "/" + this.f1370h;
                String strValueOf = String.valueOf(System.currentTimeMillis());
                strSubstring = strValueOf;
                string = ChatONFileUtil.m3479a(file.getAbsolutePath(), str4, strValueOf + file.getName().substring(file.getName().indexOf(".")));
            }
            MessageDatabaseHelper.m2298b(GlobalApplication.m2387e().getContentResolver(), String.valueOf(jM3598a), this.f1370h, msgContentType, string, strArr.length);
        } else {
            MessageDatabaseHelper.m2274a(GlobalApplication.m2387e().getContentResolver(), String.valueOf(jM3598a), this.f1370h, msgContentType, string, strArr.length);
        }
        AsyncTaskC0185n asyncTaskC0185n = new AsyncTaskC0185n(this, this.f1369g, file, msgContentType, str, strSubstring, this.f1370h, jM3598a, str3, jM3598a, file, str, msgContentType, chatType, str2, strArr, z, str3);
        if ((TextUtils.isEmpty(str2) || str2.equals("null")) && chatType != ChatONContract.InBoxTable.ChatType.BROADCAST && !this.f1372j.f734D.isShowing()) {
            this.f1372j.f734D.show();
        }
        asyncTaskC0185n.execute(new String[0]);
        this.f1366c.put(Long.valueOf(jM3598a), asyncTaskC0185n);
    }

    /* renamed from: a */
    public void m2045a(String str, ChatONContract.MessageTable.MsgContentType msgContentType, ChatONContract.InBoxTable.ChatType chatType, String[] strArr, String str2) {
        TaskContainer taskContainer = new TaskContainer(this.f1379r, this.f1371i);
        taskContainer.m2085a(TaskContainer.TaskType.NetTask, new InitChatRoomTask(taskContainer.m2086b(), str, msgContentType, chatType, strArr, str2));
        this.f1376n.put(Long.valueOf(taskContainer.m2083a()), taskContainer);
        taskContainer.m2088d();
    }

    /* renamed from: a */
    public void m2046a(String str, boolean z, String str2, long j, ChatONContract.MessageTable.MsgContentType msgContentType, ChatONContract.InBoxTable.ChatType chatType, String str3, ProgressDialog progressDialog) {
        String[] strArrSplit = str.split("\n");
        new AsyncTaskC0187p(this, strArrSplit[2], strArrSplit[4], strArrSplit[3], z, str2, j, chatType, str3, msgContentType, progressDialog).execute(new String[0]);
    }

    /* renamed from: a */
    public void m2047a(ArrayList arrayList) {
        TaskContainer taskContainer = new TaskContainer(this.f1379r, this.f1371i);
        taskContainer.m2085a(TaskContainer.TaskType.NetTask, new GetBuddyNicknameTask(taskContainer.m2086b(), arrayList, this.f1370h));
        this.f1376n.put(Long.valueOf(taskContainer.m2083a()), taskContainer);
        taskContainer.m2088d();
    }

    /* renamed from: a */
    public void m2048a(boolean z) {
        this.f1373k = z;
    }

    /* renamed from: a */
    public boolean m2049a(ChatONContract.InBoxTable.ChatType chatType, String str, Long l, String str2, String str3) {
        if (TcpClient.m2761b(this.f1371i)) {
            if (chatType != ChatONContract.InBoxTable.ChatType.BROADCAST) {
                m2047a((ArrayList) null);
            }
            return false;
        }
        Long lValueOf = l == null ? Long.valueOf(MessageIDGenerator.m3598a()) : l;
        TaskContainer taskContainer = new TaskContainer(this.f1379r, this.f1371i);
        taskContainer.m2085a(TaskContainer.TaskType.NetTask, new AllowChatTask(taskContainer.m2086b(), chatType, str3, str, lValueOf.longValue(), str2));
        if (chatType != ChatONContract.InBoxTable.ChatType.BROADCAST) {
            taskContainer.m2085a(TaskContainer.TaskType.NetTask, new GetBuddyNicknameTask(taskContainer.m2086b(), null, this.f1370h));
        }
        taskContainer.m2088d();
        this.f1376n.put(Long.valueOf(taskContainer.m2083a()), taskContainer);
        return true;
    }

    /* renamed from: a */
    public boolean m2050a(String str, String str2, int i) {
        boolean z;
        String str3;
        String simpleName;
        TcpContext.Builder builder = new TcpContext.Builder();
        this.f1370h = str;
        try {
            builder.m2796a(str).m2798b(str2).m2794a(i).m2795a((AesCipher) null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            try {
                this.f1371i = builder.m2797a();
                m2051b();
                z = true;
                str3 = "ChatRoom Info : InboxNO = " + this.f1370h + " SERVER = " + str2;
                simpleName = getClass().getSimpleName();
            } catch (NoSuchFieldException e2) {
                ChatONLogWriter.m3499a("TCP Context buiilder" + e2, toString());
                this.f1371i = null;
                z = false;
                str3 = "ChatRoom Info : InboxNO = " + this.f1370h + " SERVER = " + str2;
                simpleName = getClass().getSimpleName();
            }
            ChatONLogWriter.m3511e(str3, simpleName);
            return z;
        } catch (Throwable th) {
            ChatONLogWriter.m3511e("ChatRoom Info : InboxNO = " + this.f1370h + " SERVER = " + str2, getClass().getSimpleName());
            throw th;
        }
    }

    /* renamed from: b */
    public void m2051b() {
        DeliveryChat.m2821a(this.f1371i, this.f1364a);
        AnswerBack.m2820a(this.f1371i, this.f1364a);
        Disconnect.m2823a(this.f1371i, this.f1364a);
        AnnounceChange.m2819a(this.f1371i, this.f1364a);
        this.f1371i.f2478m = this.f1364a;
    }

    /* renamed from: b */
    public void m2052b(long j) {
        if (this.f1367d.containsKey(Long.valueOf(j))) {
            ((FileDownloadTask2) this.f1367d.get(Long.valueOf(j))).cancel(true);
        }
        MessageDatabaseHelper.m2299b(GlobalApplication.m2387e().getContentResolver(), Long.valueOf(j));
    }

    /* renamed from: b */
    public void m2053b(String str) {
        this.f1374l = str;
    }

    /* renamed from: b */
    public void m2054b(boolean z) {
        this.f1377o = z;
    }

    /* renamed from: c */
    public void m2055c() {
        if (this.f1371i != null) {
            TcpClient.m2766e(this.f1371i);
            f1362e.remove(this.f1370h);
        }
    }

    /* renamed from: c */
    public void m2056c(long j) {
        if (this.f1371i != null) {
            this.f1371i.m2784a(j);
        }
    }

    /* renamed from: d */
    public void m2057d() {
        DeliveryReplyHolder.m801a(this.f1370h);
        if (this.f1371i == null || !TcpClient.m2759a(this.f1371i)) {
            return;
        }
        TcpClient.m2764d(this.f1371i);
    }

    /* renamed from: e */
    public void m2058e() {
        DeliveryReplyHolder.m801a(this.f1370h);
        if (this.f1371i != null) {
            TcpClient.m2763c(this.f1371i);
        }
    }

    /* renamed from: f */
    public boolean m2059f() {
        return this.f1373k;
    }

    /* renamed from: g */
    public boolean m2060g() {
        return this.f1377o;
    }

    /* renamed from: h */
    public String m2061h() {
        return this.f1374l;
    }

    /* renamed from: i */
    public void m2062i() {
        Handler handler = new Handler();
        handler.post(new RunnableC0190s(this, handler));
    }
}
