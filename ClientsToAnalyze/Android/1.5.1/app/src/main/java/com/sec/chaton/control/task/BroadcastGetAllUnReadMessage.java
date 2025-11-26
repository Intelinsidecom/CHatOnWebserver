package com.sec.chaton.control.task;

import android.content.ContentResolver;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.control.HttpMessageControl;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.helper.InBoxDatabaseHelper;
import com.sec.chaton.database.helper.MessageDatabaseHelper;
import com.sec.chaton.database.helper.ParticipantDatabaseHelper;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.p000io.entry.GetUnReadMessageList;
import com.sec.chaton.p000io.entry.inner.Msg;
import com.sec.chaton.p000io.entry.inner.MsgTid;
import com.sec.chaton.util.ChatONFileUtil;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.InBoxNoGenerator;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class BroadcastGetAllUnReadMessage extends AbstractHttpTask2 {

    /* renamed from: a */
    private HashMap f1479a;

    /* renamed from: b */
    private List f1480b;

    /* renamed from: c */
    private List f1481c;

    /* renamed from: d */
    private ContentResolver f1482d;

    /* renamed from: e */
    private HttpMessageControl f1483e;

    /* renamed from: f */
    private String f1484f;

    /* renamed from: a */
    private void m2112a(Msg msg) {
        String str;
        ChatONLogWriter.m3511e("Type : Message, Sender : " + msg.sender + "MsgServerID : " + msg.f1917id + ", ChatType : " + msg.chattype + ", Tid : " + msg.tid + ", Content : " + msg.value + ", MsgType : " + msg.type, getClass().getSimpleName());
        ChatONContract.InBoxTable.ChatType chatTypeM2188a = ChatONContract.InBoxTable.ChatType.m2188a(msg.chattype.intValue());
        ChatONContract.MessageTable.MsgServerType msgServerType = ChatONContract.MessageTable.MsgServerType.MSG;
        ChatONContract.MessageTable.MsgContentType msgContentType = ChatONContract.MessageTable.MsgContentType.TEXT;
        ChatONContract.InBoxTable.ChatType chatType = chatTypeM2188a == ChatONContract.InBoxTable.ChatType.GROUPCHAT ? ChatONContract.InBoxTable.ChatType.GROUPCHAT : ChatONContract.InBoxTable.ChatType.ONETOONE;
        String strM2246a = InBoxDatabaseHelper.m2246a(this.f1482d, chatType, msg.sender, msg.sessionid);
        if (strM2246a != null) {
            InBoxDatabaseHelper.m2259b(this.f1482d, strM2246a, chatType, msg, msgServerType);
            str = strM2246a;
        } else {
            String strM3596a = InBoxNoGenerator.m3596a(chatType, new String[]{msg.sender});
            InBoxDatabaseHelper.m2245a(this.f1482d, strM3596a, chatType, msg, msgServerType);
            str = strM3596a;
        }
        ParticipantDatabaseHelper.m2305a(str, msg.sender);
        if (!MessageDatabaseHelper.m2296a(this.f1482d, msg.sender, msg.f1917id, str)) {
            MessageDatabaseHelper.m2272a(this.f1482d, str, msgContentType, msg, (String) null);
            m2113a(str, this.f1479a);
        } else if (MessageDatabaseHelper.m2300b(this.f1482d, msg.sender, msg.f1917id, this.f1484f)) {
            MessageDatabaseHelper.m2284a(this.f1482d, str, msgContentType, msg, chatType, (String) null);
        }
        InBoxDatabaseHelper.m2259b(this.f1482d, str, chatType, msg, msgServerType);
    }

    /* renamed from: a */
    private void m2113a(String str, Map map) {
        if (map.containsKey(str)) {
            map.put(str, Integer.valueOf(((Integer) map.get(str)).intValue() + 1));
        } else {
            map.put(str, 1);
        }
    }

    /* renamed from: b */
    private void m2114b(Msg msg) throws IOException {
        String str;
        ChatONLogWriter.m3511e("Type : Media, Sender : " + msg.sender + ", ChatType : " + msg.chattype + ", Tid : " + msg.tid + ", Content : " + msg.value + ", MsgType : " + msg.type, getClass().getSimpleName());
        ChatONContract.InBoxTable.ChatType chatType = ChatONContract.InBoxTable.ChatType.m2188a(msg.chattype.intValue()) == ChatONContract.InBoxTable.ChatType.GROUPCHAT ? ChatONContract.InBoxTable.ChatType.GROUPCHAT : ChatONContract.InBoxTable.ChatType.ONETOONE;
        ChatONContract.MessageTable.MsgServerType msgServerType = ChatONContract.MessageTable.MsgServerType.MEDIA;
        String strM2246a = InBoxDatabaseHelper.m2246a(this.f1482d, chatType, msg.sender, msg.sessionid);
        if (strM2246a != null) {
            InBoxDatabaseHelper.m2259b(this.f1482d, strM2246a, chatType, msg, msgServerType);
            str = strM2246a;
        } else {
            String strM3596a = InBoxNoGenerator.m3596a(chatType, new String[]{msg.sender});
            InBoxDatabaseHelper.m2245a(this.f1482d, strM3596a, chatType, msg, msgServerType);
            str = strM3596a;
        }
        ParticipantDatabaseHelper.m2305a(str, msg.sender);
        ChatONContract.MessageTable.MsgContentType msgContentTypeM2275a = MessageDatabaseHelper.m2275a(msg.value);
        String[] strArrSplit = msg.value.split("\n");
        String str2 = ((msgContentTypeM2275a == ChatONContract.MessageTable.MsgContentType.CONTACT || msgContentTypeM2275a == ChatONContract.MessageTable.MsgContentType.CALENDAR) && strArrSplit.length > 5) ? strArrSplit[5] : null;
        if (!MessageDatabaseHelper.m2296a(this.f1482d, msg.sender, msg.f1917id, str)) {
            MessageDatabaseHelper.m2272a(this.f1482d, str, msgContentTypeM2275a, msg, str2);
            m2113a(str, this.f1479a);
        } else if (MessageDatabaseHelper.m2300b(this.f1482d, msg.sender, msg.f1917id, this.f1484f)) {
            MessageDatabaseHelper.m2284a(this.f1482d, str, msgContentTypeM2275a, msg, chatType, str2);
        }
        String str3 = strArrSplit[4];
        if (msgContentTypeM2275a == ChatONContract.MessageTable.MsgContentType.IMAGE) {
            ChatONFileUtil.m3480a(strArrSplit[2], strArrSplit[4], strArrSplit[3], true, str, Long.parseLong(msg.f1917id), chatType, msg.sender);
        }
        InBoxDatabaseHelper.m2259b(this.f1482d, str, chatType, msg, msgServerType);
        ContentResolver contentResolver = this.f1482d;
        if (msgContentTypeM2275a == ChatONContract.MessageTable.MsgContentType.GEO) {
            str3 = msg.value;
        }
        InBoxDatabaseHelper.m2251a(contentResolver, str, InBoxDatabaseHelper.m2247a(msgContentTypeM2275a, str3));
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public void afterRequest(HttpEntry httpEntry) throws IOException {
        if (httpEntry.m1951b() == HttpResultCode.SUCCESS) {
            Iterator it = ((GetUnReadMessageList) httpEntry.m1955d()).msg.iterator();
            while (it.hasNext()) {
                Msg msg = (Msg) it.next();
                if (!msg.type.equals("ans")) {
                    this.f1480b.add(msg);
                }
            }
            Collections.sort(this.f1480b, new C0203l(this));
            for (Msg msg2 : this.f1480b) {
                if (msg2.type.equals("msg") || msg2.type.equals("media")) {
                    if (msg2.chattype.intValue() == ChatONContract.InBoxTable.ChatType.BROADCAST.m2189a() && msg2.sender.equals(this.f1484f)) {
                        if (msg2.type.equals("msg")) {
                            m2112a(msg2);
                        } else if (msg2.type.equals("media")) {
                            m2114b(msg2);
                        }
                        MsgTid msgTid = new MsgTid();
                        msgTid.value = msg2.tid;
                        this.f1481c.add(msgTid);
                    }
                }
            }
            this.f1483e.m2003a(this.f1481c);
        }
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public String beforeRequest() {
        return null;
    }
}
