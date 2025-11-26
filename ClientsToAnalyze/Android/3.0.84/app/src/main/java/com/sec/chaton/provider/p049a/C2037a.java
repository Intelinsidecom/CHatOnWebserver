package com.sec.chaton.provider.p049a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.sec.chaton.p027e.C1434bj;
import com.sec.chaton.p027e.EnumC1391ai;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p035io.entry.ChatListInfoEntry;
import com.sec.chaton.p035io.entry.inner.ChatListInfoEntryDetail;
import com.sec.chaton.p035io.entry.inner.ChatListInfoEntryDetailMemberInfo;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3189bd;
import com.sec.chaton.util.C3193bh;
import com.sec.chaton.util.C3250y;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ChatListSyncOperation.java */
/* renamed from: com.sec.chaton.provider.a.a */
/* loaded from: classes.dex */
public class C2037a {

    /* renamed from: t */
    private static ChatListInfoEntry f7837t;

    /* renamed from: u */
    private static C2037a f7838u;

    /* renamed from: v */
    private static boolean f7839v;

    /* renamed from: w */
    private static boolean f7840w = false;

    /* renamed from: x */
    private static long f7841x;

    /* renamed from: y */
    private static long f7842y;

    /* renamed from: b */
    private EnumC1450r f7844b;

    /* renamed from: c */
    private int f7845c;

    /* renamed from: d */
    private int f7846d;

    /* renamed from: e */
    private String f7847e;

    /* renamed from: f */
    private String f7848f;

    /* renamed from: g */
    private String f7849g;

    /* renamed from: h */
    private String f7850h;

    /* renamed from: i */
    private String f7851i;

    /* renamed from: j */
    private ArrayList<String> f7852j;

    /* renamed from: k */
    private ArrayList<String> f7853k;

    /* renamed from: l */
    private ArrayList<StringBuilder> f7854l;

    /* renamed from: m */
    private StringBuilder f7855m;

    /* renamed from: n */
    private StringBuilder f7856n;

    /* renamed from: r */
    private SQLiteDatabase f7860r;

    /* renamed from: s */
    private ChatListInfoEntryDetail f7861s;

    /* renamed from: o */
    private boolean f7857o = false;

    /* renamed from: p */
    private boolean f7858p = false;

    /* renamed from: q */
    private boolean f7859q = false;

    /* renamed from: a */
    boolean f7843a = false;

    /* renamed from: a */
    public static synchronized C2037a m8119a() {
        if (f7838u == null) {
            f7838u = new C2037a();
        }
        return f7838u;
    }

    /* renamed from: a */
    public static void m8123a(ChatListInfoEntry chatListInfoEntry) {
        if (f7837t != null) {
            f7837t = null;
        }
        f7837t = chatListInfoEntry;
        f7839v = false;
    }

    /* renamed from: b */
    public static boolean m8125b() {
        return f7840w;
    }

    /* renamed from: c */
    public static void m8126c() {
        f7840w = false;
    }

    /* renamed from: d */
    public static void m8127d() {
        f7841x = System.currentTimeMillis();
    }

    /* renamed from: e */
    public static void m8128e() {
        f7839v = false;
    }

    /* renamed from: f */
    public static boolean m8129f() {
        return f7839v;
    }

    /* renamed from: a */
    public void m8142a(SQLiteDatabase sQLiteDatabase) {
        this.f7860r = sQLiteDatabase;
        this.f7860r.beginTransaction();
        try {
            this.f7852j = new ArrayList<>();
            this.f7853k = new ArrayList<>();
            this.f7854l = new ArrayList<>();
            f7840w = false;
            for (int i = 0; i < f7837t.chatroominfodetail.size(); i++) {
                if (C3250y.f11733a) {
                    C3250y.m11456e("============== ChatRoom#" + i + " ==============", getClass().getSimpleName());
                }
                this.f7861s = f7837t.chatroominfodetail.get(i);
                m8147g();
                this.f7844b = EnumC1450r.m6339a(Integer.parseInt(this.f7861s.chattype));
                this.f7845c = this.f7861s.chatroommemberinfo.size();
                if (C3250y.f11733a) {
                    if (this.f7861s.activated.equals("false")) {
                        C3250y.m11456e("Deactivated ChatRoom#" + i + " activated : " + this.f7861s.activated + " , sessionid : " + this.f7861s.sessionid + " , chattype : " + this.f7861s.chattype + " , ip : " + this.f7861s.f5641ip + ", port : " + this.f7861s.port + " ,  creatorChatOnId : " + this.f7861s.creatorchatonid, getClass().getSimpleName());
                    } else {
                        C3250y.m11456e("ChatRoom#" + i + " activated : " + this.f7861s.activated + " , sessionid : " + this.f7861s.sessionid + " , chattype : " + this.f7861s.chattype + " , ip : " + this.f7861s.f5641ip + ", port : " + this.f7861s.port + " ,  creatorChatOnId : " + this.f7861s.creatorchatonid, getClass().getSimpleName());
                    }
                }
                if (this.f7844b == EnumC1450r.BROADCAST) {
                    if (C3250y.f11733a) {
                        C3250y.m11456e("Not Supported chat room type Chat TYPE ==>> " + this.f7844b.toString(), getClass().getSimpleName());
                        C3250y.m11456e("========================================", getClass().getSimpleName());
                    }
                } else if (this.f7844b == EnumC1450r.BROADCAST2 && !C3159aa.m10962a().m10979a("chaton_id", "").equals(this.f7861s.creatorchatonid)) {
                    if (C3250y.f11733a) {
                        C3250y.m11456e("Not Supported receiver of BR2  ==>> " + this.f7844b.toString(), getClass().getSimpleName());
                        C3250y.m11456e("creator  ==>> " + this.f7861s.creatorchatonid, getClass().getSimpleName());
                        C3250y.m11456e("========================================", getClass().getSimpleName());
                    }
                } else if (this.f7844b == EnumC1450r.ONETOONE && this.f7845c == 1) {
                    m8131o();
                    if (C3250y.f11733a) {
                        C3250y.m11456e("No ChatMember list", getClass().getSimpleName());
                        C3250y.m11456e("========================================", getClass().getSimpleName());
                    }
                } else if (this.f7845c == 0) {
                    if (C3250y.f11733a) {
                        C3250y.m11456e("No ChatMember list", getClass().getSimpleName());
                        C3250y.m11456e("========================================", getClass().getSimpleName());
                    }
                } else {
                    m8133q();
                    if (!TextUtils.isEmpty(this.f7861s.activated) && this.f7861s.activated.equals("false") && this.f7844b == EnumC1450r.ONETOONE) {
                        m8134r();
                        if (C3250y.f11733a) {
                            C3250y.m11456e("This chat room was deactivated...", getClass().getSimpleName());
                            C3250y.m11456e("========================================", getClass().getSimpleName());
                        }
                    } else {
                        if (C3250y.f11733a) {
                            C3250y.m11456e("My ChatON ID :: " + C3159aa.m10962a().m10979a("chaton_id", (String) null), getClass().getSimpleName());
                        }
                        for (int i2 = 0; i2 < this.f7845c; i2++) {
                            ChatListInfoEntryDetailMemberInfo chatListInfoEntryDetailMemberInfo = this.f7861s.chatroommemberinfo.get(i2);
                            if (this.f7844b == EnumC1450r.BROADCAST2) {
                                chatListInfoEntryDetailMemberInfo.insession = "true";
                            }
                            if (C3159aa.m10962a().m10979a("chaton_id", (String) null).equals(chatListInfoEntryDetailMemberInfo.userid)) {
                                if (C3250y.f11735c) {
                                    if (chatListInfoEntryDetailMemberInfo.insession.equals("false")) {
                                        C3250y.m11453c("[ME] Exit ChatMember #" + i2 + " ==>> insession : " + chatListInfoEntryDetailMemberInfo.insession + ",userID : " + chatListInfoEntryDetailMemberInfo.userid + " , name : " + chatListInfoEntryDetailMemberInfo.name + " , title : " + chatListInfoEntryDetailMemberInfo.title + ", starttime : " + chatListInfoEntryDetailMemberInfo.starttime + " , profileImageAddr : " + chatListInfoEntryDetailMemberInfo.profileimageaddr + " ,  profileImagePath : " + chatListInfoEntryDetailMemberInfo.profileimagepath, getClass().getSimpleName());
                                    } else {
                                        C3250y.m11453c("[ME] ChatMember #" + i2 + " ==>> insession : " + chatListInfoEntryDetailMemberInfo.insession + ",userID : " + chatListInfoEntryDetailMemberInfo.userid + " , name : " + chatListInfoEntryDetailMemberInfo.name + " , title : " + chatListInfoEntryDetailMemberInfo.title + ", starttime : " + chatListInfoEntryDetailMemberInfo.starttime + " , profileImageAddr : " + chatListInfoEntryDetailMemberInfo.profileimageaddr + " ,  profileImagePath : " + chatListInfoEntryDetailMemberInfo.profileimagepath, getClass().getSimpleName());
                                    }
                                }
                            } else if (C3250y.f11733a) {
                                if (chatListInfoEntryDetailMemberInfo.insession.equals("false")) {
                                    C3250y.m11456e("Exit ChatMember #" + i2 + " ==>> insession : " + chatListInfoEntryDetailMemberInfo.insession + ",userID : " + chatListInfoEntryDetailMemberInfo.userid + " , name : " + chatListInfoEntryDetailMemberInfo.name + " , title : " + chatListInfoEntryDetailMemberInfo.title + ", starttime : " + chatListInfoEntryDetailMemberInfo.starttime + " , profileImageAddr : " + chatListInfoEntryDetailMemberInfo.profileimageaddr + " ,  profileImagePath : " + chatListInfoEntryDetailMemberInfo.profileimagepath, getClass().getSimpleName());
                                } else {
                                    C3250y.m11456e("ChatMember #" + i2 + " ==>> insession : " + chatListInfoEntryDetailMemberInfo.insession + ",userID : " + chatListInfoEntryDetailMemberInfo.userid + " , name : " + chatListInfoEntryDetailMemberInfo.name + " , title : " + chatListInfoEntryDetailMemberInfo.title + ", starttime : " + chatListInfoEntryDetailMemberInfo.starttime + " , profileImageAddr : " + chatListInfoEntryDetailMemberInfo.profileimageaddr + " ,  profileImagePath : " + chatListInfoEntryDetailMemberInfo.profileimagepath, getClass().getSimpleName());
                                }
                            }
                            m8124a(chatListInfoEntryDetailMemberInfo);
                        }
                        if (C3250y.f11733a) {
                            C3250y.m11456e(" makeUserList :: Participants count(" + this.f7852j.size() + ") ChatType(" + this.f7844b.toString() + ")", getClass().getSimpleName());
                        }
                        if (this.f7858p) {
                            this.f7858p = false;
                            m8132p();
                            if (C3250y.f11733a) {
                                C3250y.m11456e("In chat list, Mutidevice close Chat room  ", getClass().getSimpleName());
                                C3250y.m11456e("========================================", getClass().getSimpleName());
                            }
                        } else if (!this.f7852j.contains(C3159aa.m10962a().m10979a("chaton_id", (String) null))) {
                            if (C3250y.f11733a) {
                                C3250y.m11456e("In chat list, My chaton id was not inculded.... wrong chat list ", getClass().getSimpleName());
                                C3250y.m11456e("========================================", getClass().getSimpleName());
                            }
                        } else {
                            if (this.f7859q) {
                                this.f7859q = false;
                                this.f7855m.setLength(this.f7855m.length() - 2);
                            }
                            if (this.f7844b == EnumC1450r.ONETOONE && !TextUtils.isEmpty(this.f7850h)) {
                                this.f7846d = 1;
                                this.f7848f = m8150j();
                            } else {
                                this.f7850h = null;
                                this.f7851i = null;
                                this.f7848f = m8150j();
                                this.f7846d--;
                                m8130n();
                            }
                            if (this.f7844b != EnumC1450r.ONETOONE) {
                                if (TextUtils.isEmpty(this.f7847e)) {
                                    if (TextUtils.isEmpty(this.f7855m.toString())) {
                                        this.f7847e = null;
                                    } else {
                                        this.f7847e = this.f7855m.toString();
                                    }
                                }
                            } else if (!TextUtils.isEmpty(this.f7850h)) {
                                this.f7847e = this.f7851i;
                            } else {
                                this.f7847e = null;
                            }
                            if (C3250y.f11733a) {
                                C3250y.m11456e("InBoxNo :: " + this.f7848f + " Title :: " + this.f7847e, getClass().getSimpleName());
                            }
                            m8149i();
                            m8136t();
                            m8137u();
                            m8138v();
                            if (C3250y.f11733a) {
                                C3250y.m11456e("========================================", getClass().getSimpleName());
                            }
                            f7840w = true;
                        }
                    }
                }
            }
            m8139w();
            this.f7860r.setTransactionSuccessful();
            f7842y = System.currentTimeMillis();
            if (C3250y.f11733a) {
                C3250y.m11456e("==========duration :: " + ((f7842y - f7841x) / 1000) + "==========", getClass().getSimpleName());
            }
        } finally {
            this.f7860r.endTransaction();
            f7839v = true;
            m8147g();
        }
    }

    /* renamed from: g */
    public void m8147g() {
        this.f7852j.clear();
        this.f7853k.clear();
        this.f7854l.clear();
        this.f7844b = EnumC1450r.UNKNOWN;
        this.f7845c = 0;
        this.f7857o = false;
        this.f7858p = false;
        this.f7859q = false;
        this.f7843a = false;
        this.f7846d = 1;
        this.f7850h = "";
        this.f7851i = "";
        this.f7849g = "";
        this.f7847e = "";
        if (this.f7855m != null) {
            this.f7855m = null;
        }
        this.f7855m = new StringBuilder();
        if (this.f7856n != null) {
            this.f7856n = null;
        }
        this.f7856n = new StringBuilder();
    }

    /* renamed from: n */
    private void m8130n() throws SQLException {
        if (TextUtils.isEmpty(this.f7848f)) {
            this.f7848f = C3189bd.m11137a();
            this.f7843a = true;
            for (int i = 0; i < this.f7852j.size(); i++) {
                if (!this.f7852j.get(i).equals("empty") && !this.f7852j.get(i).equals(C3159aa.m10962a().m10979a("chaton_id", (String) null))) {
                    if (C3250y.f11733a) {
                        C3250y.m11456e("Insert Participants_name : " + this.f7853k.get(i) + "Participants_id : " + this.f7852j.get(i), getClass().getSimpleName());
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("participants_buddy_no", this.f7852j.get(i));
                    contentValues.put("participants_inbox_no", this.f7848f);
                    contentValues.put("participants_buddy_name", this.f7853k.get(i));
                    m8143a("participant", contentValues);
                }
            }
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("inbox_no", this.f7848f);
            contentValues2.put("inbox_chat_type", Integer.valueOf(this.f7844b.m6342a()));
            contentValues2.put("inbox_last_chat_type", (Integer) 11);
            contentValues2.put("inbox_session_id", this.f7861s.sessionid);
            contentValues2.put("inbox_last_time", (Integer) 0);
            m8143a("inbox", contentValues2);
        }
    }

    /* renamed from: o */
    private void m8131o() {
        if (!TextUtils.isEmpty(this.f7861s.chatroommemberinfo.get(0).insession) && this.f7861s.chatroommemberinfo.get(0).insession.equals("false") && C3159aa.m10962a().m10979a("chaton_id", (String) null).equals(this.f7861s.chatroommemberinfo.get(0).userid)) {
            m8132p();
            if (C3250y.f11733a) {
                C3250y.m11456e(" Delete  ChatRoom :: In this chat room, No Participants - my insession false", getClass().getSimpleName());
            }
        }
    }

    /* renamed from: p */
    private void m8132p() {
        this.f7848f = m8151k();
        if (!TextUtils.isEmpty(this.f7848f)) {
            m8144a("inbox", "inbox_no=?", new String[]{this.f7848f});
            m8144a("participant", "participants_inbox_no=?", new String[]{this.f7848f});
            m8144a("message", "message_inbox_no=?", new String[]{this.f7848f});
            m8144a("inbox_buddy_relation", "inbox_no=?", new String[]{this.f7848f});
        }
    }

    /* renamed from: q */
    private void m8133q() throws SQLException {
        if (!TextUtils.isEmpty(this.f7861s.oldsessionid)) {
            String[] strArrSplit = this.f7861s.oldsessionid.split(",");
            StringBuilder sb = new StringBuilder();
            for (String str : strArrSplit) {
                sb.append("'").append(str.trim()).append("'");
                sb.append(",");
                ContentValues contentValues = new ContentValues();
                contentValues.put("inbox_session_id", this.f7861s.sessionid);
                contentValues.put("inbox_old_session_id", str);
                m8143a("inbox_session_id_mapping", contentValues);
            }
            sb.setLength(sb.length() - 1);
            this.f7849g = sb.toString();
        }
        if (C3250y.f11733a) {
            C3250y.m11456e(" makeOldSessionID :: " + this.f7849g, getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private void m8124a(ChatListInfoEntryDetailMemberInfo chatListInfoEntryDetailMemberInfo) {
        if (chatListInfoEntryDetailMemberInfo.insession.equals("true")) {
            if (!TextUtils.isEmpty(chatListInfoEntryDetailMemberInfo.olduserid) && !chatListInfoEntryDetailMemberInfo.olduserid.equalsIgnoreCase("null")) {
                this.f7854l.add(m8121a(chatListInfoEntryDetailMemberInfo.olduserid, chatListInfoEntryDetailMemberInfo.userid));
                this.f7852j.add(chatListInfoEntryDetailMemberInfo.userid);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("empty");
                this.f7854l.add(sb);
                this.f7852j.add(chatListInfoEntryDetailMemberInfo.userid);
            }
            this.f7853k.add(chatListInfoEntryDetailMemberInfo.name);
            if (C3159aa.m10962a().m10979a("chaton_id", (String) null).equals(chatListInfoEntryDetailMemberInfo.userid)) {
                if (!TextUtils.isEmpty(chatListInfoEntryDetailMemberInfo.title) && this.f7844b != EnumC1450r.ONETOONE) {
                    this.f7857o = true;
                    this.f7847e = chatListInfoEntryDetailMemberInfo.title;
                    return;
                }
                return;
            }
            this.f7855m.append(chatListInfoEntryDetailMemberInfo.name).append(", ");
            this.f7859q = true;
            this.f7846d++;
            if (this.f7844b == EnumC1450r.ONETOONE) {
                this.f7850h = chatListInfoEntryDetailMemberInfo.userid;
                this.f7851i = chatListInfoEntryDetailMemberInfo.name;
                return;
            }
            return;
        }
        if (C3159aa.m10962a().m10979a("chaton_id", (String) null).equals(chatListInfoEntryDetailMemberInfo.userid)) {
            this.f7858p = true;
            if (!TextUtils.isEmpty(chatListInfoEntryDetailMemberInfo.title) && this.f7844b != EnumC1450r.ONETOONE) {
                this.f7857o = true;
                this.f7847e = chatListInfoEntryDetailMemberInfo.title;
                return;
            }
            return;
        }
        if (this.f7844b == EnumC1450r.ONETOONE) {
            this.f7850h = chatListInfoEntryDetailMemberInfo.userid;
            this.f7851i = chatListInfoEntryDetailMemberInfo.name;
        }
    }

    /* renamed from: r */
    private void m8134r() throws SQLException {
        if (!TextUtils.isEmpty(this.f7861s.oldsessionid)) {
            if (m8153m()) {
                m8135s();
            }
        } else if (m8152l()) {
            m8135s();
        }
    }

    /* renamed from: s */
    private void m8135s() throws SQLException {
        for (int i = 0; i < this.f7845c; i++) {
            if (this.f7861s.chatroommemberinfo.get(i).insession.equals("true") && !TextUtils.isEmpty(this.f7861s.chatroommemberinfo.get(i).olduserid)) {
                for (String str : this.f7861s.chatroommemberinfo.get(i).olduserid.split(",")) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("participants_buddy_no", this.f7861s.chatroommemberinfo.get(i).userid);
                    contentValues.put("participants_old_buddy_no", str.trim());
                    m8143a("participant_mapping", contentValues);
                }
            }
        }
    }

    /* renamed from: a */
    private StringBuilder m8121a(String str, String str2) throws SQLException {
        StringBuilder sb = new StringBuilder();
        String strTrim = "";
        for (String str3 : str.split(",")) {
            if (!strTrim.equals(str3.trim())) {
                strTrim = str3.trim();
                ContentValues contentValues = new ContentValues();
                contentValues.put("participants_buddy_no", str2);
                contentValues.put("participants_old_buddy_no", str3);
                m8143a("participant_mapping", contentValues);
                sb.append("'").append(strTrim).append("'");
                sb.append(",");
            }
        }
        sb.append("'").append(str2).append("'");
        if (C3250y.f11733a) {
            C3250y.m11456e(" makeOldUserList :: " + sb.toString(), getClass().getSimpleName());
        }
        return sb;
    }

    /* renamed from: a */
    public ContentValues m8140a(String str) {
        ContentValues contentValues = new ContentValues();
        Cursor cursorM8141a = m8141a("inbox", "inbox_no=?", new String[]{str}, new String[]{"inbox_last_message", "inbox_last_msg_sender", "inbox_last_msg_no", "inbox_last_time", "inbox_unread_count", "inbox_trunk_unread_count"}, null);
        if (cursorM8141a != null && cursorM8141a.getCount() > 0) {
            cursorM8141a.moveToFirst();
            contentValues.put("inbox_last_message", cursorM8141a.getString(0));
            contentValues.put("inbox_last_msg_sender", cursorM8141a.getString(1));
            contentValues.put("inbox_last_msg_no", Long.valueOf(cursorM8141a.getLong(2)));
            contentValues.put("inbox_last_time", Long.valueOf(cursorM8141a.getLong(3)));
            contentValues.put("inbox_unread_count", Integer.valueOf(cursorM8141a.getInt(4)));
            contentValues.put("inbox_trunk_unread_count", Integer.valueOf(cursorM8141a.getInt(5)));
        }
        if (cursorM8141a != null) {
            cursorM8141a.close();
        }
        return contentValues;
    }

    /* renamed from: h */
    public List<String> m8148h() {
        ArrayList arrayList = new ArrayList();
        Cursor cursorM8141a = m8141a("inbox", "inbox_session_id IN (" + this.f7849g + ")", null, new String[]{"inbox_no"}, null);
        if (cursorM8141a != null && cursorM8141a.getCount() > 0) {
            cursorM8141a.moveToFirst();
            do {
                arrayList.add(cursorM8141a.getString(0));
            } while (cursorM8141a.moveToNext());
        }
        if (cursorM8141a != null) {
            cursorM8141a.close();
        }
        return arrayList;
    }

    /* renamed from: i */
    public void m8149i() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_no", this.f7848f);
        if (this.f7843a) {
            if (this.f7844b != EnumC1450r.ONETOONE && this.f7857o) {
                contentValues.put("inbox_title_fixed", "Y");
                contentValues.put("inbox_title", this.f7847e);
            } else {
                contentValues.put("inbox_title", this.f7847e);
            }
        }
        if (this.f7861s.f5641ip != null) {
            contentValues.put("inbox_server_ip", this.f7861s.f5641ip);
            contentValues.put("inbox_server_port", this.f7861s.port);
        }
        contentValues.put("inbox_participants", Integer.valueOf(this.f7846d));
        contentValues.put("inbox_session_id", this.f7861s.sessionid);
        m8145a("inbox", "inbox_no=?", new String[]{this.f7848f}, contentValues);
    }

    /* renamed from: t */
    private void m8136t() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.f7849g)) {
            List<String> listM8148h = m8148h();
            ArrayList arrayList = new ArrayList();
            arrayList.add(m8140a(this.f7848f));
            for (String str : listM8148h) {
                this.f7856n.append("'").append(str).append("'");
                this.f7856n.append(",");
                sb.append(str).append(",");
                arrayList.add(m8140a(str));
                m8144a("inbox", "inbox_no=?", new String[]{str});
            }
            ContentValues contentValues = (ContentValues) arrayList.get(0);
            for (int i = 1; i < arrayList.size(); i++) {
                ContentValues contentValues2 = (ContentValues) arrayList.get(i);
                if (contentValues2.getAsLong("inbox_last_time").longValue() >= contentValues.getAsLong("inbox_last_time").longValue()) {
                    contentValues2.put("inbox_unread_count", Integer.valueOf(contentValues2.getAsInteger("inbox_unread_count").intValue() + contentValues.getAsInteger("inbox_unread_count").intValue()));
                    contentValues2.put("inbox_trunk_unread_count", Integer.valueOf(contentValues.getAsInteger("inbox_trunk_unread_count").intValue() + contentValues2.getAsInteger("inbox_trunk_unread_count").intValue()));
                    contentValues = contentValues2;
                } else {
                    contentValues.put("inbox_unread_count", Integer.valueOf(contentValues2.getAsInteger("inbox_unread_count").intValue() + contentValues.getAsInteger("inbox_unread_count").intValue()));
                    contentValues.put("inbox_trunk_unread_count", Integer.valueOf(contentValues2.getAsInteger("inbox_trunk_unread_count").intValue() + contentValues.getAsInteger("inbox_trunk_unread_count").intValue()));
                }
            }
            if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
                contentValues.put("inbox_old_no", sb.toString());
            }
            m8145a("inbox", "inbox_no=?", new String[]{this.f7848f}, contentValues);
            if (C3250y.f11733a) {
                C3250y.m11456e("MergeInbox List :: " + sb.toString(), getClass().getSimpleName());
            }
        }
    }

    /* renamed from: u */
    private void m8137u() {
        this.f7856n.append("'").append(this.f7848f).append("'");
        String string = this.f7856n.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("message_inbox_no").append(" IN (").append(string).append(")");
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_session_id", this.f7861s.sessionid);
        contentValues.put("message_inbox_no", this.f7848f);
        m8145a("message", sb.toString(), (String[]) null, contentValues);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f7852j.size() - 1) {
                if (!this.f7852j.get(i2).equals("empty") && !this.f7852j.get(i2).equals(C3159aa.m10962a().m10979a("chaton_id", (String) null))) {
                    String string2 = this.f7854l.get(i2).toString();
                    if (!string2.equals("empty")) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("message_sender").append(" IN (").append(string2).append(")");
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("message_sender", this.f7852j.get(i2));
                        m8145a("message", sb2.toString(), (String[]) null, contentValues2);
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("participants_buddy_no").append(" IN (").append(string2).append(")").append(" AND ").append("participants_inbox_no").append(" IN (").append(string).append(")");
                        ContentValues contentValues3 = new ContentValues();
                        contentValues3.put("participants_buddy_no", this.f7852j.get(i2));
                        contentValues3.put("participants_inbox_no", this.f7848f);
                        contentValues3.put("participants_buddy_name", this.f7853k.get(i2));
                        m8145a("participant", sb3.toString(), (String[]) null, contentValues3);
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("buddy_no").append(" IN (").append(string2).append(")").append(" AND ").append("inbox_no").append(" IN (").append(string).append(")");
                        ContentValues contentValues4 = new ContentValues();
                        contentValues4.put("buddy_no", this.f7852j.get(i2));
                        contentValues4.put("inbox_no", this.f7848f);
                        m8145a("inbox_buddy_relation", sb4.toString(), (String[]) null, contentValues4);
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: v */
    private void m8138v() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int iIndexOf = this.f7852j.indexOf(C3159aa.m10962a().m10979a("chaton_id", (String) null));
        if (iIndexOf != -1) {
            String string = this.f7854l.get(iIndexOf).toString();
            if (!string.equals("empty")) {
                sb.append("participants_buddy_no").append(" IN (" + string + ") AND ").append("participants_inbox_no").append(" = ?");
                sb2.append("message_sender").append(" IN (" + string + ") AND ").append("message_inbox_no").append(" = ?");
                ContentValues contentValues = new ContentValues();
                contentValues.put("message_sender", C3159aa.m10962a().m10979a("chaton_id", (String) null));
                if (!TextUtils.isEmpty(this.f7848f)) {
                    m8145a("message", sb2.toString(), new String[]{this.f7848f}, contentValues);
                    m8144a("participant", sb.toString(), new String[]{this.f7848f});
                }
            }
        }
    }

    /* renamed from: w */
    private void m8139w() {
        StringBuilder sb = new StringBuilder();
        String strM10979a = C3159aa.m10962a().m10979a("old_chaton_id", (String) null);
        if (!TextUtils.isEmpty(strM10979a)) {
            sb.append("message_sender").append(" = ?");
            ContentValues contentValues = new ContentValues();
            contentValues.put("message_sender", C3159aa.m10962a().m10979a("chaton_id", (String) null));
            if (!TextUtils.isEmpty(strM10979a)) {
                m8145a("message", sb.toString(), new String[]{strM10979a}, contentValues);
            }
        }
    }

    /* renamed from: a */
    private String m8120a(String str, String str2, EnumC1450r enumC1450r, String str3) throws SQLException {
        String strM11137a = C3189bd.m11137a();
        this.f7843a = true;
        if (!TextUtils.isEmpty(str)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("inbox_no", strM11137a);
            contentValues.put("buddy_no", str);
            contentValues.put("chat_type", Integer.valueOf(enumC1450r.m6342a()));
            this.f7860r.insertOrThrow("inbox_buddy_relation", null, contentValues);
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("participants_inbox_no", strM11137a);
            contentValues2.put("participants_buddy_no", str);
            contentValues2.put("participants_buddy_name", str3);
            this.f7860r.insertOrThrow("participant", null, contentValues2);
        }
        ContentValues contentValues3 = new ContentValues();
        contentValues3.put("inbox_no", strM11137a);
        contentValues3.put("inbox_chat_type", Integer.valueOf(enumC1450r.m6342a()));
        if (enumC1450r == EnumC1450r.ONETOONE) {
            contentValues3.put("inbox_last_chat_type", (Integer) 11);
        } else {
            contentValues3.put("inbox_last_chat_type", (Integer) 12);
        }
        if (!TextUtils.isEmpty(str2)) {
            contentValues3.put("inbox_session_id", str2);
        }
        contentValues3.put("inbox_last_time", (Integer) 0);
        this.f7860r.insertOrThrow("inbox", null, contentValues3);
        return strM11137a;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0053 A[Catch: all -> 0x0062, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0062, blocks: (B:7:0x003a, B:9:0x0040, B:12:0x0053), top: B:33:0x003a }] */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String m8150j() {
        /*
            r7 = this;
            r4 = 1
            r6 = 0
            r5 = 0
            int[] r0 = com.sec.chaton.provider.p049a.C2038b.f7862a
            com.sec.chaton.e.r r1 = r7.f7844b
            int r1 = r1.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L11;
                case 2: goto L69;
                case 3: goto L69;
                default: goto L10;
            }
        L10:
            return r5
        L11:
            com.sec.chaton.e.bj r0 = new com.sec.chaton.e.bj
            r0.<init>()
            java.lang.String r1 = com.sec.chaton.p027e.InterfaceC1425ba.f5292a
            com.sec.chaton.e.bj r0 = r0.m6288a(r1)
            java.lang.String r1 = com.sec.chaton.p027e.InterfaceC1425ba.f5292a
            r0.m6288a(r1)
            java.lang.String r1 = "inbox"
            java.lang.String r2 = "inbox_session_id=?"
            java.lang.String[] r3 = new java.lang.String[r4]
            com.sec.chaton.io.entry.inner.ChatListInfoEntryDetail r0 = r7.f7861s
            java.lang.String r0 = r0.sessionid
            r3[r6] = r0
            java.lang.String[] r4 = new java.lang.String[r4]
            java.lang.String r0 = "inbox_no"
            r4[r6] = r0
            r0 = r7
            android.database.Cursor r1 = r0.m8141a(r1, r2, r3, r4, r5)
            if (r1 == 0) goto L53
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L62
            if (r0 <= 0) goto L53
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L62
            java.lang.String r0 = "inbox_no"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L62
            java.lang.String r5 = r1.getString(r0)     // Catch: java.lang.Throwable -> L62
        L4d:
            if (r1 == 0) goto L10
            r1.close()
            goto L10
        L53:
            java.lang.String r0 = r7.f7850h     // Catch: java.lang.Throwable -> L62
            com.sec.chaton.io.entry.inner.ChatListInfoEntryDetail r2 = r7.f7861s     // Catch: java.lang.Throwable -> L62
            java.lang.String r2 = r2.sessionid     // Catch: java.lang.Throwable -> L62
            com.sec.chaton.e.r r3 = r7.f7844b     // Catch: java.lang.Throwable -> L62
            java.lang.String r4 = r7.f7851i     // Catch: java.lang.Throwable -> L62
            java.lang.String r5 = r7.m8120a(r0, r2, r3, r4)     // Catch: java.lang.Throwable -> L62
            goto L4d
        L62:
            r0 = move-exception
            if (r1 == 0) goto L68
            r1.close()
        L68:
            throw r0
        L69:
            com.sec.chaton.io.entry.inner.ChatListInfoEntryDetail r0 = r7.f7861s
            java.lang.String r0 = r0.sessionid
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L10
            java.lang.String r2 = "inbox"
            java.lang.String r3 = "inbox_session_id=?"
            java.lang.String[] r4 = new java.lang.String[r4]
            com.sec.chaton.io.entry.inner.ChatListInfoEntryDetail r0 = r7.f7861s
            java.lang.String r0 = r0.sessionid
            r4[r6] = r0
            r1 = r7
            r6 = r5
            android.database.Cursor r1 = r1.m8141a(r2, r3, r4, r5, r6)
            if (r1 == 0) goto L9d
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> La4
            if (r0 <= 0) goto L9d
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> La4
            if (r0 == 0) goto L9d
            java.lang.String r0 = "inbox_no"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> La4
            java.lang.String r5 = r1.getString(r0)     // Catch: java.lang.Throwable -> La4
        L9d:
            if (r1 == 0) goto L10
            r1.close()
            goto L10
        La4:
            r0 = move-exception
            if (r1 == 0) goto Laa
            r1.close()
        Laa:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.p049a.C2037a.m8150j():java.lang.String");
    }

    /* renamed from: k */
    public String m8151k() {
        Cursor cursorM8141a = m8141a("inbox", "inbox_session_id=?", new String[]{this.f7861s.sessionid}, new String[]{"inbox_no", "inbox_valid"}, null);
        String string = "";
        if (cursorM8141a != null && cursorM8141a.getCount() > 0) {
            cursorM8141a.moveToFirst();
            string = cursorM8141a.getString(0);
            if (cursorM8141a.getString(1).equals("N")) {
                string = "INVALID_INBOX";
            }
        }
        if (cursorM8141a != null) {
            cursorM8141a.close();
        }
        return string;
    }

    /* renamed from: b */
    public long m8146b(String str) {
        long j;
        Cursor cursorM8141a = m8141a("inbox", "inbox_no=?", new String[]{str}, new String[]{"inbox_last_time"}, null);
        if (cursorM8141a == null) {
            return 0L;
        }
        if (!cursorM8141a.moveToFirst()) {
            j = 0;
        } else {
            j = cursorM8141a.getLong(0);
        }
        cursorM8141a.close();
        return j;
    }

    /* renamed from: l */
    public boolean m8152l() throws SQLException {
        String str;
        String string;
        String str2;
        long jCurrentTimeMillis;
        Cursor cursorM8141a = m8141a("inbox", "inbox_session_id=?", new String[]{this.f7861s.sessionid}, new String[]{"inbox_no", "inbox_valid"}, null);
        String string2 = "";
        if (cursorM8141a == null || cursorM8141a.getCount() <= 0) {
            str = "";
        } else {
            cursorM8141a.moveToFirst();
            String string3 = cursorM8141a.getString(0);
            string2 = cursorM8141a.getString(1);
            str = string3;
        }
        if (!TextUtils.isEmpty(str)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("message_sender", C3159aa.m10962a().m10979a("chaton_id", (String) null));
            contentValues.put("message_session_id", this.f7861s.sessionid);
            m8145a("message", "message_inbox_no=?", new String[]{str}, contentValues);
            if (!string2.equals("N")) {
                Cursor cursorM8141a2 = m8141a("participant", "participants_inbox_no=?", new String[]{str}, null, null);
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("inbox_valid", "N");
                contentValues2.put("inbox_session_id", this.f7861s.sessionid);
                contentValues2.put("inbox_last_msg_sender", C3159aa.m10962a().m10979a("chaton_id", ""));
                m8145a("inbox", "inbox_no=?", new String[]{str}, contentValues2);
                ContentValues contentValues3 = new ContentValues();
                if (cursorM8141a2 == null || cursorM8141a2.getCount() <= 0) {
                    string = "";
                    str2 = "";
                } else {
                    cursorM8141a2.moveToFirst();
                    String string4 = cursorM8141a2.getString(cursorM8141a2.getColumnIndex("participants_buddy_no"));
                    string = cursorM8141a2.getString(cursorM8141a2.getColumnIndex("participants_buddy_name"));
                    str2 = string4;
                }
                if (cursorM8141a2 != null) {
                    cursorM8141a2.close();
                }
                m8144a("inbox_buddy_relation", "inbox_no=?", new String[]{str});
                long jM8146b = m8146b(str);
                if (jM8146b == 0) {
                    jCurrentTimeMillis = System.currentTimeMillis();
                } else {
                    jCurrentTimeMillis = jM8146b + 1;
                }
                contentValues3.put("_id", Long.valueOf(C3193bh.m11148a()));
                contentValues3.put("message_inbox_no", str);
                contentValues3.put("message_type", (Integer) 1);
                contentValues3.put("message_content_type", Integer.valueOf(EnumC1455w.SYSTEM.m6364a()));
                contentValues3.put("message_content", String.format("%d,%s,%s", Integer.valueOf(EnumC1391ai.DEACTIVATED.m6248a()), str2, string));
                contentValues3.put("message_time", Long.valueOf(jCurrentTimeMillis));
                contentValues3.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(jCurrentTimeMillis)));
                m8143a("message", contentValues3);
            }
            if (cursorM8141a != null) {
                cursorM8141a.close();
            }
            return true;
        }
        if (cursorM8141a != null) {
            cursorM8141a.close();
        }
        return false;
    }

    /* renamed from: m */
    public boolean m8153m() throws SQLException {
        boolean z;
        String[] strArr = {"inbox_no", "inbox_valid"};
        Cursor cursorM8141a = m8141a("inbox", "inbox_session_id IN (" + this.f7849g + ")", null, strArr, null);
        C3250y.m11450b("upateInboxInvalidAndChangeSessionId() mOldSessionIDs[" + this.f7849g + "] is invalided.", getClass().getSimpleName());
        if (cursorM8141a == null || cursorM8141a.getCount() <= 0) {
            z = false;
        } else {
            m8122a(cursorM8141a);
            Cursor cursorM8141a2 = m8141a("inbox", "inbox_session_id IN ('" + this.f7861s.sessionid + "')", null, strArr, null);
            C3250y.m11450b("upateInboxInvalidAndChangeSessionId() mNewSessionIDs[" + this.f7861s.sessionid + "] is invalided.", getClass().getSimpleName());
            if (cursorM8141a2 != null && cursorM8141a2.getCount() > 0) {
                m8122a(cursorM8141a2);
            }
            if (cursorM8141a2 != null) {
                cursorM8141a2.close();
            }
            z = true;
        }
        if (cursorM8141a != null) {
            cursorM8141a.close();
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x015f  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m8122a(android.database.Cursor r15) throws android.database.SQLException {
        /*
            Method dump skipped, instructions count: 358
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.p049a.C2037a.m8122a(android.database.Cursor):void");
    }

    /* renamed from: a */
    public Cursor m8141a(String str, String str2, String[] strArr, String[] strArr2, String str3) {
        return new C1434bj().m6288a(str).m6289a(str2, strArr).m6286a(this.f7860r, strArr2, str3);
    }

    /* renamed from: a */
    public void m8143a(String str, ContentValues contentValues) throws SQLException {
        this.f7860r.insertOrThrow(str, null, contentValues);
    }

    /* renamed from: a */
    public void m8144a(String str, String str2, String[] strArr) {
        new C1434bj().m6288a(str).m6289a(str2, strArr).m6284a(this.f7860r);
    }

    /* renamed from: a */
    public void m8145a(String str, String str2, String[] strArr, ContentValues contentValues) {
        new C1434bj().m6288a(str).m6289a(str2, strArr).m6285a(this.f7860r, contentValues);
    }
}
