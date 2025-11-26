package com.sec.chaton.p055d.p056a;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.TabActivity;
import com.sec.chaton.p046a.C0886dm;
import com.sec.chaton.p046a.p047a.C0788l;
import com.sec.chaton.p055d.C2096bb;
import com.sec.chaton.p055d.C2134o;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p065io.entry.InboxExtraEntry;
import com.sec.chaton.p065io.entry.inner.TopicChatType;
import com.sec.chaton.p065io.entry.specialbuddy.SpecialBuddyTopicChatEntry;
import com.sec.chaton.p067j.C2426ao;
import com.sec.chaton.p072k.p073a.C2477a;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;

/* compiled from: JoinTopicChatTask.java */
/* renamed from: com.sec.chaton.d.a.dl */
/* loaded from: classes.dex */
public class C1993dl extends AbstractC1981d {

    /* renamed from: h */
    private final String f7319h;

    /* renamed from: i */
    private Handler f7320i;

    /* renamed from: j */
    private SpecialBuddyTopicChatEntry f7321j;

    /* renamed from: k */
    private boolean f7322k;

    public C1993dl(Handler handler, SpecialBuddyTopicChatEntry specialBuddyTopicChatEntry) {
        super(handler);
        this.f7319h = getClass().getSimpleName();
        this.f7322k = false;
        this.f7320i = handler;
        this.f7321j = specialBuddyTopicChatEntry;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1981d, com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: b */
    protected C2426ao mo9093b() {
        String string;
        Cursor cursorQuery = CommonApplication.m18732r().getContentResolver().query(C2299s.f8209a, null, "inbox_session_id =? ", new String[]{this.f7321j.sessionid}, null);
        if (cursorQuery == null || cursorQuery.getCount() <= 0) {
            string = "";
        } else {
            this.f7322k = true;
            cursorQuery.moveToFirst();
            string = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_no"));
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        if (this.f7322k) {
            if (C4904y.f17873c) {
                C4904y.m18641c("The inbox has already exist. Go to chat room.", this.f7319h);
            }
            m9143a(string);
            return null;
        }
        if (C4904y.f17873c) {
            C4904y.m18641c("The inbox has not exist. Do task.", this.f7319h);
        }
        return C2096bb.m9360a().m9365a(this.f7321j.sessionid, this.f7321j.suid);
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1981d, com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: a */
    protected void mo9092a(int i, Object obj, Object obj2) {
        String str;
        super.mo9092a(i, obj, obj2);
        Message message = new Message();
        message.what = 49;
        int iM5229d = -1;
        if (obj2 != null) {
            C0886dm c0886dm = (C0886dm) ((C2426ao) obj2).m10513c();
            if (c0886dm.m4581f() != null) {
                iM5229d = c0886dm.m4581f().m5229d();
            }
            if (C4904y.f17873c) {
                C4904y.m18641c("result message: " + c0886dm.m4581f().m5231f() + ", code:" + c0886dm.m4581f().m5229d(), this.f7319h);
            }
            if (iM5229d == 1000 || iM5229d == 3005 || iM5229d == 7003) {
                message.obj = new C0788l(true, iM5229d);
                InboxExtraEntry inboxExtraEntry = new InboxExtraEntry();
                if (TextUtils.isEmpty(this.f7321j.ctid)) {
                    if (C4904y.f17873c) {
                        C4904y.m18641c("Join topic chat for CP", this.f7319h);
                    }
                    str = this.f7321j.channelname;
                    inboxExtraEntry.topicchattype = new TopicChatType(this.f7321j.suid, null, this.f7321j.channelname);
                } else {
                    if (C4904y.f17873c) {
                        C4904y.m18641c("Join topic chat for Contents", this.f7319h);
                    }
                    str = this.f7321j.contenttitle;
                    inboxExtraEntry.topicchattype = new TopicChatType(this.f7321j.suid, this.f7321j.ctid, this.f7321j.channelname);
                }
                String strM10710a = new C2477a().m10710a(inboxExtraEntry);
                if (C4904y.f17873c) {
                    C4904y.m18641c("topicChatExtra:" + strM10710a, this.f7319h);
                }
                String strM9925a = C2198l.m9925a(CommonApplication.m18732r().getContentResolver(), EnumC2300t.TOPIC, this.f7321j.suid, this.f7321j.sessionid);
                ContentValues contentValues = new ContentValues();
                contentValues.put("inbox_title", str);
                contentValues.put("inbox_title_fixed", "Y");
                contentValues.put("inbox_room_type", Integer.valueOf(EnumC2301u.NORMAL.m10212a()));
                contentValues.put("inbox_chat_type", Integer.valueOf(EnumC2300t.TOPIC.m10210a()));
                contentValues.put("inbox_last_chat_type", (Integer) 10);
                contentValues.put("inbox_last_tid", Spam.ACTIVITY_CANCEL);
                contentValues.put("inbox_enable_noti", "N");
                contentValues.put("inbox_topic_type", strM10710a);
                CommonApplication.m18732r().getContentResolver().update(C2299s.f8209a, contentValues, "inbox_no=?", new String[]{strM9925a});
                C2134o.m9576c(null, this.f7321j.sessionid, str);
                m9143a(strM9925a);
                return;
            }
            if (iM5229d == 3004) {
                if (C4904y.f17873c) {
                    C4904y.m18641c("Failed to send JoinTopicChat, Session is full. Result Code:" + iM5229d, this.f7319h);
                }
                message.obj = new C0788l(false, iM5229d);
                this.f7320i.sendMessage(message);
                return;
            }
            message.obj = new C0788l(false, iM5229d);
            this.f7320i.sendMessage(message);
            return;
        }
        if (!this.f7322k) {
            if (C4904y.f17873c) {
                C4904y.m18641c("Failed to send JoinTopicChat, Result object is null. Result Code:" + i, this.f7319h);
            }
            message.obj = new C0788l(false, -1);
            this.f7320i.sendMessage(message);
        }
    }

    /* renamed from: a */
    private void m9143a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("chaton://chatroom?");
        sb.append("inboxNo=").append(str);
        sb.append("&chatType=").append(String.valueOf(EnumC2300t.TOPIC.m10210a()));
        Intent intent = new Intent(CommonApplication.m18732r(), (Class<?>) TabActivity.class);
        intent.setAction("android.intent.action.SEND");
        intent.setData(Uri.parse(sb.toString()));
        intent.addFlags(268435456);
        if (sb.toString().startsWith("chaton://")) {
            CommonApplication.m18732r().startActivity(intent);
        }
    }
}
