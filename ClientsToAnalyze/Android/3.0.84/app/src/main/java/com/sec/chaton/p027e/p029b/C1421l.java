package com.sec.chaton.p027e.p029b;

import android.database.Cursor;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.chat.notification.C1103a;
import com.sec.chaton.chat.notification.C1109e;
import com.sec.chaton.chat.notification.C1111g;
import com.sec.chaton.chat.notification.C1113i;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.C1449q;
import com.sec.chaton.p027e.C1454v;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import twitter4j.Query;

/* compiled from: MessageNotificationUpdateTask.java */
/* renamed from: com.sec.chaton.e.b.l */
/* loaded from: classes.dex */
public class C1421l extends AbstractC1410a {

    /* renamed from: c */
    public ArrayList<C1111g> f5269c;

    /* renamed from: d */
    private String f5270d;

    /* renamed from: e */
    private C1103a f5271e;

    /* renamed from: f */
    private int f5272f;

    /* renamed from: g */
    private boolean f5273g;

    public C1421l(InterfaceC1413d interfaceC1413d, int i, boolean z) {
        super(interfaceC1413d);
        this.f5270d = getClass().getSimpleName();
        this.f5272f = i;
        this.f5273g = z;
        this.f5271e = C1103a.m5432a(CommonApplication.m11493l());
        if (this.f5269c == null) {
            this.f5269c = new ArrayList<>();
        }
    }

    @Override // com.sec.chaton.p027e.p029b.AbstractC1410a
    /* renamed from: a */
    public Object mo6263a() {
        if (m6268b()) {
            this.f5271e.m5452a(this.f5272f, this.f5273g);
            return null;
        }
        if (C3250y.f11734b) {
            C3250y.m11450b("noti is null", "MessageNotificationUpdateTask");
            return null;
        }
        return null;
    }

    /* renamed from: b */
    private boolean m6268b() throws NumberFormatException {
        Cursor cursorQuery = CommonApplication.m11493l().getContentResolver().query(C1449q.f5381a, new String[]{"inbox_no", "inbox_unread_count", "inbox_chat_type", "inbox_session_id", "inbox_server_ip", "inbox_server_port", "lasst_session_merge_time", "inbox_participants"}, "inbox_unread_count > 0", null, null);
        if (cursorQuery == null) {
            return false;
        }
        while (cursorQuery.moveToNext()) {
            String string = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_no"));
            String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_server_ip"));
            int i = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_server_port"));
            String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_session_id"));
            long j = cursorQuery.getLong(cursorQuery.getColumnIndex("lasst_session_merge_time"));
            int i2 = Integer.parseInt(cursorQuery.getString(cursorQuery.getColumnIndex("inbox_participants")));
            Cursor cursorQuery2 = CommonApplication.m11493l().getContentResolver().query(C1454v.m6349b(cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_unread_count"))), null, "message_inbox_no=?", new String[]{string}, null);
            if (cursorQuery2 == null) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return false;
            }
            while (cursorQuery2.moveToNext()) {
                String string4 = cursorQuery2.getString(cursorQuery2.getColumnIndex("message_content"));
                String[] strArrSplit = string4.split("\n");
                String strReplaceAll = cursorQuery2.getString(cursorQuery2.getColumnIndex("buddy_name")).replaceAll("\n+", " ");
                C1103a c1103a = this.f5271e;
                c1103a.getClass();
                this.f5269c.add(new C1111g(c1103a, cursorQuery2.getString(cursorQuery2.getColumnIndex("message_sender")), string4, cursorQuery2.getString(cursorQuery2.getColumnIndex("message_inbox_no")), Long.valueOf(cursorQuery2.getLong(cursorQuery2.getColumnIndex("message_time"))), strReplaceAll, cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_chat_type")), cursorQuery2.getInt(cursorQuery2.getColumnIndex("message_content_type")), string3, string2, i, j, i2, cursorQuery2.getString(cursorQuery2.getColumnIndex("message_is_truncated")), cursorQuery2.getLong(cursorQuery2.getColumnIndex("message_sever_id")), Query.MIXED.equals(strArrSplit[0])));
            }
            if (cursorQuery2 != null) {
                cursorQuery2.close();
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        Collections.sort(this.f5269c, new C1422m(this));
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        if (!m6269c()) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    private boolean m6269c() {
        this.f5271e.f4463m = this.f5269c.size();
        this.f5271e.m5470e(this.f5271e.f4463m);
        if (this.f5271e.f4463m == 0) {
            return false;
        }
        Iterator<C1111g> it = this.f5269c.iterator();
        while (it.hasNext()) {
            C1111g next = it.next();
            if (!this.f5271e.f4460j.containsKey(next.f4502e)) {
                C1103a c1103a = this.f5271e;
                c1103a.getClass();
                this.f5271e.f4460j.put(next.f4502e, new C1113i(c1103a, next.f4507j, next.f4508k, next.f4506i, next.f4505h, next.f4509l));
                if (C3250y.f11735c) {
                    C3250y.m11453c("[NOTIPannel] parseCursor inboxList: " + (this.f5271e.f4460j.size() - 1) + ", " + next.f4502e, this.f5270d);
                }
            }
            int iM5448a = this.f5271e.m5448a(next.f4498a, next.f4502e);
            if (C3250y.f11735c) {
                C3250y.m11453c("[NOTIPannel] get buddy Info ret = " + iM5448a, this.f5270d);
            }
            if (iM5448a < 0) {
                if (TextUtils.isEmpty(next.f4499b)) {
                    next.f4499b = GlobalApplication.m6451b().getString(R.string.unknown);
                }
                C1103a c1103a2 = this.f5271e;
                c1103a2.getClass();
                this.f5271e.f4461k.add(new C1109e(c1103a2, next.f4498a, next.f4499b, next.f4502e));
                if (C3250y.f11735c) {
                    C3250y.m11453c("[NOTIPannel] parseCursor buddyInfoList: " + (this.f5271e.f4461k.size() - 1) + "," + next.f4498a, this.f5270d);
                }
            }
            this.f5271e.f4462l.add(next);
            if (C3250y.f11735c) {
                C3250y.m11453c("[NOTIPannel] parseCursor LatestMsgList: " + this.f5271e.f4462l.size() + ", sender :" + next.f4498a + ", sender name :" + next.f4499b + ", msgID:" + next.f4511n, this.f5270d);
            }
        }
        this.f5269c.clear();
        this.f5269c = null;
        return true;
    }
}
