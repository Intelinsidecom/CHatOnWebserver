package com.sec.chaton.database.task;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.helper.InBoxDatabaseHelper;
import com.sec.chaton.database.helper.MessageDatabaseHelper;
import com.sec.chaton.database.helper.ParticipantDatabaseHelper;
import com.sec.chaton.database.task.AbstractQueryTask;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p000io.entry.PushEntry;
import com.sec.chaton.util.ChatONJsonParser;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.InBoxNoGenerator;

/* loaded from: classes.dex */
public class PushReceivedTask extends AbstractQueryTask {

    /* renamed from: a */
    private String f1794a;

    /* renamed from: b */
    private String f1795b;

    /* renamed from: c */
    private String f1796c;

    /* renamed from: e */
    private String f1797e;

    /* renamed from: f */
    private boolean f1798f;

    public class PushResult {

        /* renamed from: b */
        private boolean f1800b;

        /* renamed from: c */
        private PushEntry f1801c;

        /* renamed from: d */
        private String f1802d;

        /* renamed from: e */
        private String f1803e;

        /* renamed from: f */
        private int f1804f;

        /* renamed from: g */
        private int f1805g;

        /* renamed from: h */
        private ChatONContract.MessageTable.MsgContentType f1806h;

        /* renamed from: i */
        private boolean f1807i;

        public PushResult(String str, boolean z, PushEntry pushEntry, String str2, int i, int i2, ChatONContract.MessageTable.MsgContentType msgContentType, boolean z2) {
            this.f1800b = z;
            this.f1801c = pushEntry;
            this.f1802d = str;
            this.f1803e = str2;
            this.f1804f = i;
            this.f1805g = i2;
            this.f1806h = msgContentType;
            this.f1807i = z2;
        }

        /* renamed from: a */
        public String m2322a() {
            return this.f1802d;
        }

        /* renamed from: b */
        public boolean m2323b() {
            return this.f1800b;
        }

        /* renamed from: c */
        public PushEntry m2324c() {
            return this.f1801c;
        }

        /* renamed from: d */
        public String m2325d() {
            return this.f1803e;
        }

        /* renamed from: e */
        public int m2326e() {
            return this.f1805g;
        }

        /* renamed from: f */
        public boolean m2327f() {
            return this.f1807i;
        }
    }

    public PushReceivedTask(AbstractQueryTask.OnQueryTaskResult onQueryTaskResult, String str, boolean z, String str2, String str3, String str4) {
        super(onQueryTaskResult, new Handler(Looper.getMainLooper()));
        this.f1798f = z;
        this.f1794a = str2;
        this.f1795b = str3;
        this.f1797e = str4;
        this.f1796c = str;
    }

    @Override // com.sec.chaton.database.task.AbstractQueryTask
    /* renamed from: a */
    public Object mo2320a() {
        boolean zM2294a;
        String str;
        try {
            PushEntry pushEntry = (PushEntry) new ChatONJsonParser(this.f1797e).m3493a(PushEntry.class);
            if (!ChatONPref.m3519a().getString("msisdn", "").equals(pushEntry.receiver)) {
                return null;
            }
            ContentResolver contentResolver = GlobalApplication.m2387e().getContentResolver();
            ChatONContract.InBoxTable.ChatType chatTypeM2188a = ChatONContract.InBoxTable.ChatType.m2188a(pushEntry.chatType.intValue());
            if (chatTypeM2188a == null) {
                return null;
            }
            if (chatTypeM2188a == ChatONContract.InBoxTable.ChatType.WEB_AUTH) {
                return new PushResult(this.f1796c, this.f1798f, pushEntry, "", 0, 0, ChatONContract.MessageTable.MsgContentType.TEXT, false);
            }
            ChatONContract.MessageTable.MsgContentType msgContentTypeM2275a = ChatONContract.MessageTable.MsgContentType.TEXT != ChatONContract.MessageTable.MsgContentType.m2195a(pushEntry.msgType.intValue()) ? MessageDatabaseHelper.m2275a(pushEntry.message) : ChatONContract.MessageTable.MsgContentType.TEXT;
            String strM2246a = InBoxDatabaseHelper.m2246a(contentResolver, chatTypeM2188a, pushEntry.senderID, pushEntry.sessionID);
            if (strM2246a != null) {
                boolean zM2294a2 = MessageDatabaseHelper.m2294a(contentResolver, strM2246a, msgContentTypeM2275a, pushEntry, chatTypeM2188a);
                if (zM2294a2) {
                    zM2294a = zM2294a2;
                    str = strM2246a;
                } else {
                    if (!ParticipantDatabaseHelper.m2309a(contentResolver, pushEntry.senderID, strM2246a)) {
                        ParticipantDatabaseHelper.m2308a(contentResolver, strM2246a, pushEntry.senderID, this.f1794a);
                    }
                    InBoxDatabaseHelper.m2249a(contentResolver, chatTypeM2188a, pushEntry, strM2246a);
                    zM2294a = zM2294a2;
                    str = strM2246a;
                }
            } else {
                String strM3594a = ChatONContract.InBoxTable.ChatType.GROUPCHAT == chatTypeM2188a ? InBoxNoGenerator.m3594a(ChatONContract.InBoxTable.ChatType.GROUPCHAT, pushEntry.sessionID) : InBoxNoGenerator.m3596a(ChatONContract.InBoxTable.ChatType.ONETOONE, new String[]{pushEntry.senderID});
                if (!ParticipantDatabaseHelper.m2309a(contentResolver, pushEntry.senderID, strM3594a)) {
                    ParticipantDatabaseHelper.m2308a(contentResolver, strM3594a, pushEntry.senderID, this.f1794a);
                }
                InBoxDatabaseHelper.m2244a(contentResolver, strM3594a, chatTypeM2188a, pushEntry);
                zM2294a = MessageDatabaseHelper.m2294a(contentResolver, strM3594a, msgContentTypeM2275a, pushEntry, chatTypeM2188a);
                str = strM3594a;
            }
            Cursor cursorQuery = contentResolver.query(ChatONContract.InBoxTable.f1717a, null, "inbox_unread_count > 0", null, null);
            int i = 0;
            while (cursorQuery.moveToNext()) {
                i = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_unread_count")) + i;
            }
            cursorQuery.close();
            return new PushResult(this.f1796c, this.f1798f, pushEntry, str, InBoxDatabaseHelper.m2238a(contentResolver, str), i, msgContentTypeM2275a, zM2294a);
        } catch (Exception e) {
            ChatONLogWriter.m3501a(e, getClass().getSimpleName());
            return null;
        }
    }
}
