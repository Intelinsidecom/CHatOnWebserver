package com.sec.chaton.provider.p089a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.p057e.C2283cb;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2231as;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.p058a.C2176ab;
import com.sec.chaton.p057e.p058a.C2204r;
import com.sec.chaton.p065io.entry.ChatListInfoEntry;
import com.sec.chaton.p065io.entry.inner.ChatListInfoEntryDetail;
import com.sec.chaton.p065io.entry.inner.ChatListInfoEntryDetailMemberInfo;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4839bd;
import com.sec.chaton.util.C4843bh;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ChatListSyncOperation.java */
/* renamed from: com.sec.chaton.provider.a.a */
/* loaded from: classes.dex */
public class C3035a {

    /* renamed from: s */
    private static ChatListInfoEntry f11247s;

    /* renamed from: t */
    private static C3035a f11248t;

    /* renamed from: u */
    private static boolean f11249u;

    /* renamed from: w */
    private static long f11251w;

    /* renamed from: x */
    private static long f11252x;

    /* renamed from: c */
    private EnumC2300t f11254c;

    /* renamed from: d */
    private int f11255d;

    /* renamed from: e */
    private int f11256e;

    /* renamed from: f */
    private String f11257f;

    /* renamed from: g */
    private String f11258g;

    /* renamed from: h */
    private String f11259h;

    /* renamed from: i */
    private String f11260i;

    /* renamed from: j */
    private ArrayList<String> f11261j;

    /* renamed from: k */
    private ArrayList<String> f11262k;

    /* renamed from: l */
    private ArrayList<StringBuilder> f11263l;

    /* renamed from: m */
    private StringBuilder f11264m;

    /* renamed from: n */
    private StringBuilder f11265n;

    /* renamed from: q */
    private SQLiteDatabase f11268q;

    /* renamed from: r */
    private ChatListInfoEntryDetail f11269r;

    /* renamed from: a */
    public static final String f11246a = C3035a.class.getSimpleName();

    /* renamed from: v */
    private static boolean f11250v = false;

    /* renamed from: o */
    private boolean f11266o = false;

    /* renamed from: p */
    private boolean f11267p = false;

    /* renamed from: b */
    boolean f11253b = false;

    /* renamed from: a */
    public static synchronized C3035a m12458a() {
        if (f11248t == null) {
            f11248t = new C3035a();
        }
        return f11248t;
    }

    /* renamed from: a */
    public static void m12462a(ChatListInfoEntry chatListInfoEntry) {
        if (f11247s != null) {
            f11247s = null;
        }
        f11247s = chatListInfoEntry;
        f11249u = false;
    }

    /* renamed from: b */
    public static boolean m12464b() {
        return f11250v;
    }

    /* renamed from: c */
    public static void m12465c() {
        f11250v = false;
    }

    /* renamed from: d */
    public static void m12466d() {
        f11251w = System.currentTimeMillis();
    }

    /* renamed from: e */
    public static void m12467e() {
        f11249u = false;
    }

    /* renamed from: f */
    public static boolean m12470f() {
        return f11249u;
    }

    /* renamed from: a */
    public void m12486a(SQLiteDatabase sQLiteDatabase) {
        try {
            try {
                this.f11261j = new ArrayList<>();
                this.f11262k = new ArrayList<>();
                this.f11263l = new ArrayList<>();
                f11250v = false;
                if (C4904y.f17872b) {
                    C4904y.m18639b("My ChatON ID :: " + C4809aa.m18104a().m18121a("chaton_id", (String) null), f11246a);
                }
                int size = f11247s.chatroominfodetail.size();
                for (int i = size - 1; i >= 0; i--) {
                    this.f11269r = f11247s.chatroominfodetail.get(i);
                    m12493g();
                    this.f11254c = EnumC2300t.m10207a(Integer.parseInt(this.f11269r.chattype));
                    this.f11255d = this.f11269r.chatroommemberinfo.size();
                    if (this.f11254c == EnumC2300t.BROADCAST || this.f11254c == EnumC2300t.TOPIC) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("Skip ChatRoom[" + (i + 1) + "/" + size + "] Not Supported chat room type Chat TYPE ==>> " + this.f11254c.toString(), f11246a);
                        }
                        f11247s.chatroominfodetail.remove(i);
                    } else if (this.f11254c == EnumC2300t.BROADCAST2 && !C4809aa.m18104a().m18121a("chaton_id", "").equals(this.f11269r.creatorchatonid)) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("Skip ChatRoom[" + (i + 1) + "/" + size + "] Not Supported receiver of BR2  ==>> " + this.f11254c.toString(), f11246a);
                            C4904y.m18639b("creator  ==>> " + this.f11269r.creatorchatonid, getClass().getSimpleName());
                        }
                        f11247s.chatroominfodetail.remove(i);
                    } else if (this.f11254c == EnumC2300t.ONETOONE && this.f11255d == 1) {
                        m12473j();
                    } else if (this.f11255d == 0) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("Skip ChatRoom[" + (i + 1) + "/" + size + "] No ChatMember list", f11246a);
                            C4904y.m18639b("========================================", f11246a);
                        }
                        f11247s.chatroominfodetail.remove(i);
                    }
                }
                try {
                    this.f11268q = sQLiteDatabase;
                    this.f11268q.beginTransaction();
                    int size2 = f11247s.chatroominfodetail.size();
                    if (C4904y.f17872b) {
                        C4904y.m18639b(":: BeginTransaction :: modifiedLength[" + size2 + "] My ChatON ID [" + C4809aa.m18104a().m18121a("chaton_id", (String) null) + "]", C3035a.class.getSimpleName());
                    }
                    for (int i2 = 0; i2 < size2; i2++) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("ChatRoom#" + i2 + " activated : " + this.f11269r.activated + " , sessionid : " + this.f11269r.sessionid + " , chattype : " + this.f11269r.chattype + " , ip : " + this.f11269r.f8563ip + ", port : " + this.f11269r.port + " ,  creatorChatOnId : " + this.f11269r.creatorchatonid, getClass().getSimpleName());
                            if (this.f11269r.activated.equals("false")) {
                                C4904y.m18639b("This chatroom is deactivated.", C3035a.class.getSimpleName());
                            }
                        }
                        this.f11269r = f11247s.chatroominfodetail.get(i2);
                        m12493g();
                        this.f11254c = EnumC2300t.m10207a(Integer.parseInt(this.f11269r.chattype));
                        this.f11255d = this.f11269r.chatroommemberinfo.size();
                        if (this.f11269r.needToBeRemoved) {
                            m12474k();
                            if (C4904y.f17872b) {
                                C4904y.m18639b("No ChatMember list", f11246a);
                                C4904y.m18639b("========================================", f11246a);
                            }
                        } else {
                            String strM12475l = m12475l();
                            if (!TextUtils.isEmpty(this.f11269r.activated) && this.f11269r.activated.equals("false") && this.f11254c == EnumC2300t.ONETOONE) {
                                m12469f(strM12475l);
                                if (C4904y.f17872b) {
                                    C4904y.m18639b("This chat room was deactivated...", f11246a);
                                    C4904y.m18639b("========================================", f11246a);
                                }
                            } else {
                                for (int i3 = 0; i3 < this.f11255d; i3++) {
                                    ChatListInfoEntryDetailMemberInfo chatListInfoEntryDetailMemberInfo = this.f11269r.chatroommemberinfo.get(i3);
                                    if (this.f11254c == EnumC2300t.BROADCAST2) {
                                        chatListInfoEntryDetailMemberInfo.insession = "true";
                                    }
                                    if (C4904y.f17872b) {
                                        C4904y.m18639b((C4809aa.m18104a().m18121a("chaton_id", "").equals(chatListInfoEntryDetailMemberInfo.userid) ? "[ME] " : "") + "ChatMember #" + i3 + " ==>> insession : " + chatListInfoEntryDetailMemberInfo.insession + ",userID : " + chatListInfoEntryDetailMemberInfo.userid + " , name : " + chatListInfoEntryDetailMemberInfo.name + " , title : " + chatListInfoEntryDetailMemberInfo.title + ", starttime : " + chatListInfoEntryDetailMemberInfo.starttime + " , profileImageAddr : " + chatListInfoEntryDetailMemberInfo.profileimageaddr + " ,  profileImagePath : " + chatListInfoEntryDetailMemberInfo.profileimagepath, f11246a);
                                    }
                                    if (m12463a(chatListInfoEntryDetailMemberInfo)) {
                                        m12474k();
                                        if (C4904y.f17872b) {
                                            C4904y.m18639b("Mutidevice close Chat room  ", f11246a);
                                            C4904y.m18639b("========================================", f11246a);
                                        }
                                    }
                                }
                                if (C4904y.f17872b) {
                                    C4904y.m18639b(" makeUserList :: Participants count(" + this.f11261j.size() + ") ChatType(" + this.f11254c.toString() + ")", f11246a);
                                }
                                if (this.f11261j.contains(C4809aa.m18104a().m18121a("chaton_id", (String) null))) {
                                    if (this.f11267p) {
                                        this.f11267p = false;
                                        this.f11264m.setLength(this.f11264m.length() - 2);
                                    }
                                    if (this.f11254c == EnumC2300t.ONETOONE) {
                                        this.f11256e = 1;
                                        this.f11258g = m12482s();
                                        if (TextUtils.isEmpty(this.f11258g) && C4904y.f17872b) {
                                            C4904y.m18639b("inboxNo is empty.", f11246a);
                                        }
                                    } else {
                                        this.f11259h = null;
                                        this.f11260i = null;
                                        this.f11258g = m12482s();
                                        this.f11256e--;
                                        m12472i();
                                    }
                                    if (this.f11254c != EnumC2300t.ONETOONE) {
                                        if (TextUtils.isEmpty(this.f11257f)) {
                                            if (TextUtils.isEmpty(this.f11264m.toString())) {
                                                this.f11257f = null;
                                            } else {
                                                this.f11257f = this.f11264m.toString();
                                            }
                                        }
                                    } else if (TextUtils.isEmpty(this.f11259h)) {
                                        this.f11257f = null;
                                        if (C4904y.f17875e) {
                                            C4904y.m18634a("ERROR :: no sender id with ONETOONE chat room - title is empty.", f11246a);
                                        }
                                    } else {
                                        this.f11257f = this.f11260i;
                                    }
                                    if (C4904y.f17872b) {
                                        C4904y.m18639b("InBoxNo :: " + this.f11258g + " Title :: " + this.f11257f, f11246a);
                                    }
                                    m12477n();
                                    m12478o();
                                    m12471g(strM12475l);
                                    m12479p();
                                    m12480q();
                                    if (C4904y.f17872b) {
                                        C4904y.m18639b("========================================", f11246a);
                                    }
                                    f11250v = true;
                                } else if (C4904y.f17872b) {
                                    C4904y.m18639b("My chaton id was not inculded", f11246a);
                                    C4904y.m18639b("========================================", f11246a);
                                }
                            }
                        }
                    }
                    m12481r();
                    this.f11268q.setTransactionSuccessful();
                    f11252x = System.currentTimeMillis();
                    if (C4904y.f17872b) {
                        C4904y.m18639b("==========duration :: " + ((f11252x - f11251w) / 1000) + "==========", f11246a);
                    }
                } catch (Exception e) {
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e, f11246a);
                    }
                } finally {
                    this.f11268q.endTransaction();
                    f11249u = true;
                }
            } catch (Exception e2) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e2, f11246a);
                }
            }
        } finally {
            m12493g();
        }
    }

    /* renamed from: g */
    public void m12493g() {
        this.f11261j.clear();
        this.f11262k.clear();
        this.f11263l.clear();
        this.f11254c = EnumC2300t.UNKNOWN;
        this.f11255d = 0;
        this.f11266o = false;
        this.f11267p = false;
        this.f11253b = false;
        this.f11256e = 1;
        this.f11259h = "";
        this.f11260i = "";
        this.f11257f = "";
        if (this.f11264m != null) {
            this.f11264m = null;
        }
        this.f11264m = new StringBuilder();
        if (this.f11265n != null) {
            this.f11265n = null;
        }
        this.f11265n = new StringBuilder();
    }

    /* renamed from: i */
    private void m12472i() throws SQLException {
        if (TextUtils.isEmpty(this.f11258g)) {
            this.f11258g = C4839bd.m18311a();
            this.f11253b = true;
            int i = 0;
            for (int i2 = 0; i2 < this.f11261j.size(); i2++) {
                if (!this.f11261j.get(i2).equals("empty") && !this.f11261j.get(i2).equals(C4809aa.m18104a().m18121a("chaton_id", (String) null))) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("participants_buddy_no", this.f11261j.get(i2));
                    contentValues.put("participants_inbox_no", this.f11258g);
                    contentValues.put("participants_buddy_name", this.f11262k.get(i2));
                    m12487a("participant", contentValues);
                    i++;
                }
            }
            if (C4904y.f17872b) {
                C4904y.m18639b("Insert Participants data in table - count[" + i + "]", f11246a);
            }
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("inbox_no", this.f11258g);
            contentValues2.put("inbox_chat_type", Integer.valueOf(this.f11254c.m10210a()));
            contentValues2.put("inbox_last_chat_type", (Integer) 11);
            contentValues2.put("inbox_session_id", this.f11269r.sessionid);
            contentValues2.put("inbox_last_time", (Integer) 0);
            contentValues2.put("inbox_enable_noti", C4809aa.m18104a().m18119a("Setting alert_new_groupchat", (Boolean) true).booleanValue() ? "Y" : "N");
            m12487a("inbox", contentValues2);
            return;
        }
        if (this.f11254c == EnumC2300t.BROADCAST2) {
            m12468e(this.f11258g);
        }
    }

    /* renamed from: e */
    private void m12468e(String str) throws SQLException {
        Cursor cursorM12485a = m12485a("participant", "participants_inbox_no=?", new String[]{str}, null, null);
        ArrayList arrayList = new ArrayList();
        if (cursorM12485a != null && cursorM12485a.getCount() > 0 && cursorM12485a.moveToFirst()) {
            do {
                arrayList.add(cursorM12485a.getString(cursorM12485a.getColumnIndex("participants_buddy_no")));
            } while (cursorM12485a.moveToNext());
        }
        if (cursorM12485a != null) {
            cursorM12485a.close();
        }
        for (int i = 0; i < this.f11261j.size(); i++) {
            if (!this.f11261j.get(i).equals("empty") && !this.f11261j.get(i).equals(C4809aa.m18104a().m18121a("chaton_id", (String) null)) && (arrayList == null || !arrayList.contains(this.f11261j.get(i)))) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("Insert additional Participants_name : " + this.f11262k.get(i) + "Participants_id : " + this.f11261j.get(i), f11246a);
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("participants_buddy_no", this.f11261j.get(i));
                contentValues.put("participants_inbox_no", this.f11258g);
                contentValues.put("participants_buddy_name", this.f11262k.get(i));
                m12487a("participant", contentValues);
            }
        }
    }

    /* renamed from: j */
    private void m12473j() {
        if (!TextUtils.isEmpty(this.f11269r.chatroommemberinfo.get(0).insession) && this.f11269r.chatroommemberinfo.get(0).insession.equals("false") && C4809aa.m18104a().m18121a("chaton_id", "").equals(this.f11269r.chatroommemberinfo.get(0).userid)) {
            this.f11269r.needToBeRemoved = true;
            if (C4904y.f17872b) {
                C4904y.m18639b(" Delete  ChatRoom :: In this chat room, No Participants - my insession false", f11246a);
            }
        }
    }

    /* renamed from: k */
    private void m12474k() {
        this.f11258g = m12494h();
        if (!TextUtils.isEmpty(this.f11258g)) {
            m12488a("inbox", "inbox_no=?", new String[]{this.f11258g});
            m12488a("participant", "participants_inbox_no=?", new String[]{this.f11258g});
            m12488a(VKApiConst.MESSAGE, "message_inbox_no=?", new String[]{this.f11258g});
            m12488a("inbox_buddy_relation", "inbox_no=?", new String[]{this.f11258g});
        }
    }

    /* renamed from: l */
    private String m12475l() throws SQLException {
        String string = "";
        if (!TextUtils.isEmpty(this.f11269r.oldsessionid)) {
            String[] strArrSplit = this.f11269r.oldsessionid.split(",");
            StringBuilder sb = new StringBuilder();
            for (String str : strArrSplit) {
                sb.append("'").append(str.trim()).append("'");
                sb.append(",");
                ContentValues contentValues = new ContentValues();
                contentValues.put("inbox_session_id", this.f11269r.sessionid);
                contentValues.put("inbox_old_session_id", str);
                m12487a("inbox_session_id_mapping", contentValues);
            }
            sb.setLength(sb.length() - 1);
            string = sb.toString();
        }
        if (!TextUtils.isEmpty(string) && C4904y.f17872b) {
            C4904y.m18639b(" makeOldSessionID :: " + string, f11246a);
        }
        return string;
    }

    /* renamed from: a */
    private boolean m12463a(ChatListInfoEntryDetailMemberInfo chatListInfoEntryDetailMemberInfo) {
        if (chatListInfoEntryDetailMemberInfo.insession.equals("true")) {
            if (!TextUtils.isEmpty(chatListInfoEntryDetailMemberInfo.olduserid) && !chatListInfoEntryDetailMemberInfo.olduserid.equalsIgnoreCase("null")) {
                this.f11263l.add(m12460a(chatListInfoEntryDetailMemberInfo.olduserid, chatListInfoEntryDetailMemberInfo.userid));
                this.f11261j.add(chatListInfoEntryDetailMemberInfo.userid);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("empty");
                this.f11263l.add(sb);
                this.f11261j.add(chatListInfoEntryDetailMemberInfo.userid);
            }
            this.f11262k.add(chatListInfoEntryDetailMemberInfo.name);
            if (C4809aa.m18104a().m18121a("chaton_id", "").equals(chatListInfoEntryDetailMemberInfo.userid)) {
                if (TextUtils.isEmpty(chatListInfoEntryDetailMemberInfo.title) || this.f11254c == EnumC2300t.ONETOONE) {
                    return false;
                }
                this.f11266o = true;
                this.f11257f = chatListInfoEntryDetailMemberInfo.title;
                return false;
            }
            this.f11264m.append(chatListInfoEntryDetailMemberInfo.name).append(", ");
            this.f11267p = true;
            this.f11256e++;
            if (this.f11254c != EnumC2300t.ONETOONE) {
                return false;
            }
            this.f11259h = chatListInfoEntryDetailMemberInfo.userid;
            this.f11260i = chatListInfoEntryDetailMemberInfo.name;
            return false;
        }
        if (C4809aa.m18104a().m18121a("chaton_id", (String) null).equals(chatListInfoEntryDetailMemberInfo.userid)) {
            if (TextUtils.isEmpty(chatListInfoEntryDetailMemberInfo.title) || this.f11254c == EnumC2300t.ONETOONE) {
                return true;
            }
            this.f11266o = true;
            this.f11257f = chatListInfoEntryDetailMemberInfo.title;
            return true;
        }
        if (this.f11254c != EnumC2300t.ONETOONE) {
            return false;
        }
        this.f11259h = chatListInfoEntryDetailMemberInfo.userid;
        this.f11260i = chatListInfoEntryDetailMemberInfo.name;
        return false;
    }

    /* renamed from: f */
    private void m12469f(String str) throws SQLException {
        if (!TextUtils.isEmpty(str)) {
            if (m12492d(str)) {
                m12476m();
            }
        } else if (m12483t()) {
            m12476m();
        }
    }

    /* renamed from: m */
    private void m12476m() throws SQLException {
        for (int i = 0; i < this.f11255d; i++) {
            if (this.f11269r.chatroommemberinfo.get(i).insession.equals("true") && !TextUtils.isEmpty(this.f11269r.chatroommemberinfo.get(i).olduserid)) {
                for (String str : this.f11269r.chatroommemberinfo.get(i).olduserid.split(",")) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("participants_buddy_no", this.f11269r.chatroommemberinfo.get(i).userid);
                    contentValues.put("participants_old_buddy_no", str.trim());
                    m12487a("participant_mapping", contentValues);
                }
            }
        }
    }

    /* renamed from: a */
    private StringBuilder m12460a(String str, String str2) throws SQLException {
        StringBuilder sb = new StringBuilder();
        String strTrim = "";
        for (String str3 : str.split(",")) {
            if (!strTrim.equals(str3.trim())) {
                strTrim = str3.trim();
                ContentValues contentValues = new ContentValues();
                contentValues.put("participants_buddy_no", str2);
                contentValues.put("participants_old_buddy_no", str3);
                m12487a("participant_mapping", contentValues);
                sb.append("'").append(strTrim).append("'");
                sb.append(",");
            }
        }
        sb.append("'").append(str2).append("'");
        if (C4904y.f17872b) {
            C4904y.m18639b(" makeOldUserList :: " + sb.toString(), f11246a);
        }
        return sb;
    }

    /* renamed from: a */
    public ContentValues m12484a(String str) {
        ContentValues contentValues = new ContentValues();
        Cursor cursorM12485a = m12485a("inbox", "inbox_no=?", new String[]{str}, new String[]{"inbox_last_message", "inbox_last_msg_sender", "inbox_last_msg_no", "inbox_last_time", "inbox_unread_count", "inbox_trunk_unread_count"}, null);
        if (cursorM12485a != null && cursorM12485a.getCount() > 0) {
            cursorM12485a.moveToFirst();
            contentValues.put("inbox_last_message", cursorM12485a.getString(0));
            contentValues.put("inbox_last_msg_sender", cursorM12485a.getString(1));
            contentValues.put("inbox_last_msg_no", Long.valueOf(cursorM12485a.getLong(2)));
            contentValues.put("inbox_last_time", Long.valueOf(cursorM12485a.getLong(3)));
            contentValues.put("inbox_unread_count", Integer.valueOf(cursorM12485a.getInt(4)));
            contentValues.put("inbox_trunk_unread_count", Integer.valueOf(cursorM12485a.getInt(5)));
        }
        if (cursorM12485a != null) {
            cursorM12485a.close();
        }
        return contentValues;
    }

    /* renamed from: b */
    public List<String> m12490b(String str) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorM12485a = m12485a("inbox", "inbox_session_id IN (" + str + ")", null, new String[]{"inbox_no"}, null);
        if (cursorM12485a != null && cursorM12485a.getCount() > 0) {
            cursorM12485a.moveToFirst();
            do {
                arrayList.add(cursorM12485a.getString(0));
            } while (cursorM12485a.moveToNext());
        }
        if (cursorM12485a != null) {
            cursorM12485a.close();
        }
        return arrayList;
    }

    /* renamed from: n */
    private void m12477n() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_no", this.f11258g);
        if (this.f11253b) {
            if (this.f11254c != EnumC2300t.ONETOONE && this.f11266o) {
                contentValues.put("inbox_title_fixed", "Y");
                contentValues.put("inbox_title", this.f11257f);
            } else {
                contentValues.put("inbox_title", this.f11257f);
            }
        }
        if (this.f11269r.f8563ip != null) {
            contentValues.put("inbox_server_ip", this.f11269r.f8563ip);
            contentValues.put("inbox_server_port", this.f11269r.port);
        }
        contentValues.put("inbox_participants", Integer.valueOf(this.f11256e));
        contentValues.put("inbox_session_id", this.f11269r.sessionid);
        m12489a("inbox", "inbox_no=?", new String[]{this.f11258g}, contentValues);
    }

    /* renamed from: o */
    private void m12478o() {
        String str;
        int i;
        if (!TextUtils.isEmpty(this.f11269r.lastmsgsender)) {
            if (TextUtils.isEmpty(this.f11269r.lastmsgbody)) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("failed to update last message : empty lastmsgbody", f11246a);
                    return;
                }
                return;
            }
            if (this.f11269r.lastmsgtimestamp.longValue() <= 0) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("failed to update last message : empty lastmsgtimestamp", f11246a);
                    return;
                }
                return;
            }
            if (C4809aa.m18104a().m18121a("chaton_id", "").equals(this.f11269r.lastmsgsender)) {
                str = "";
                i = 1;
            } else {
                String strM9693e = C2176ab.m9693e(CommonApplication.m18732r().getContentResolver(), this.f11258g, this.f11269r.lastmsgsender);
                if (TextUtils.isEmpty(strM9693e)) {
                    str = "";
                    i = 2;
                } else {
                    str = strM9693e;
                    i = 2;
                }
            }
            String str2 = String.format("%d;%d;%s;%s", Integer.valueOf(i), Integer.valueOf(C2204r.m10021a(this.f11269r.lastmsgbody, this.f11269r.lastmsgtype).m10076a()), C1736gi.m8632a(this.f11269r.lastmsgbody), str);
            ContentValues contentValues = new ContentValues();
            contentValues.put("inbox_last_message", str2);
            contentValues.put("inbox_last_msg_sender", this.f11269r.lastmsgsender);
            contentValues.put("inbox_last_time", this.f11269r.lastmsgtimestamp);
            if (C4904y.f17872b) {
                String strSubstring = this.f11269r.lastmsgbody;
                if (strSubstring.length() > 4) {
                    strSubstring = strSubstring.substring(0, 4);
                }
                C4904y.m18639b("update last msg[" + strSubstring + "], sender[" + this.f11269r.lastmsgsender + "], time[" + this.f11269r.lastmsgtimestamp + "], buddyName[" + str + "]", f11246a);
            }
            m12489a("inbox", "inbox_no=? AND (inbox_last_time IS NULL OR inbox_last_time =0 OR inbox_last_time<?)", new String[]{this.f11258g, Long.toString(this.f11269r.lastmsgtimestamp.longValue())}, contentValues);
        }
    }

    /* renamed from: g */
    private void m12471g(String str) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            List<String> listM12490b = m12490b(str);
            ArrayList arrayList = new ArrayList();
            arrayList.add(m12484a(this.f11258g));
            for (String str2 : listM12490b) {
                this.f11265n.append("'").append(str2).append("'");
                this.f11265n.append(",");
                sb.append(str2).append(",");
                arrayList.add(m12484a(str2));
                m12488a("inbox", "inbox_no=?", new String[]{str2});
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
            m12489a("inbox", "inbox_no=?", new String[]{this.f11258g}, contentValues);
            if (C4904y.f17872b) {
                C4904y.m18639b("MergeInbox List :: " + sb.toString(), f11246a);
            }
        }
    }

    /* renamed from: p */
    private void m12479p() {
        this.f11265n.append("'").append(this.f11258g).append("'");
        String string = this.f11265n.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("message_inbox_no").append(" IN (").append(string).append(")");
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_session_id", this.f11269r.sessionid);
        contentValues.put("message_inbox_no", this.f11258g);
        m12489a(VKApiConst.MESSAGE, sb.toString(), (String[]) null, contentValues);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f11261j.size() - 1) {
                if (!this.f11261j.get(i2).equals("empty") && !this.f11261j.get(i2).equals(C4809aa.m18104a().m18121a("chaton_id", (String) null))) {
                    String string2 = this.f11263l.get(i2).toString();
                    if (!string2.equals("empty")) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("message_sender").append(" IN (").append(string2).append(")");
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("message_sender", this.f11261j.get(i2));
                        m12489a(VKApiConst.MESSAGE, sb2.toString(), (String[]) null, contentValues2);
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("participants_buddy_no").append(" IN (").append(string2).append(")").append(" AND ").append("participants_inbox_no").append(" IN (").append(string).append(")");
                        ContentValues contentValues3 = new ContentValues();
                        contentValues3.put("participants_buddy_no", this.f11261j.get(i2));
                        contentValues3.put("participants_inbox_no", this.f11258g);
                        contentValues3.put("participants_buddy_name", this.f11262k.get(i2));
                        m12489a("participant", sb3.toString(), (String[]) null, contentValues3);
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("buddy_no").append(" IN (").append(string2).append(")").append(" AND ").append("inbox_no").append(" IN (").append(string).append(")");
                        ContentValues contentValues4 = new ContentValues();
                        contentValues4.put("buddy_no", this.f11261j.get(i2));
                        contentValues4.put("inbox_no", this.f11258g);
                        m12489a("inbox_buddy_relation", sb4.toString(), (String[]) null, contentValues4);
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: q */
    private void m12480q() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        int iIndexOf = this.f11261j.indexOf(C4809aa.m18104a().m18121a("chaton_id", (String) null));
        if (iIndexOf != -1) {
            String string = this.f11263l.get(iIndexOf).toString();
            if (!string.equals("empty")) {
                sb.append("participants_buddy_no").append(" IN (" + string + ") AND ").append("participants_inbox_no").append(" = ?");
                sb2.append("message_sender").append(" IN (" + string + ") AND ").append("message_inbox_no").append(" = ?");
                sb3.append("inbox_last_msg_sender").append(" IN (" + string + ") AND ").append("inbox_no").append(" = ?");
                ContentValues contentValues = new ContentValues();
                contentValues.put("message_sender", C4809aa.m18104a().m18121a("chaton_id", (String) null));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("inbox_last_msg_sender", C4809aa.m18104a().m18121a("chaton_id", (String) null));
                if (!TextUtils.isEmpty(this.f11258g)) {
                    m12489a(VKApiConst.MESSAGE, sb2.toString(), new String[]{this.f11258g}, contentValues);
                    m12488a("participant", sb.toString(), new String[]{this.f11258g});
                    m12489a("inbox", sb3.toString(), new String[]{this.f11258g}, contentValues2);
                }
            }
        }
    }

    /* renamed from: r */
    private void m12481r() {
        StringBuilder sb = new StringBuilder();
        String strM18121a = C4809aa.m18104a().m18121a("old_chaton_id", (String) null);
        if (!TextUtils.isEmpty(strM18121a)) {
            sb.append("message_sender").append(" = ?");
            ContentValues contentValues = new ContentValues();
            contentValues.put("message_sender", C4809aa.m18104a().m18121a("chaton_id", (String) null));
            if (!TextUtils.isEmpty(strM18121a)) {
                m12489a(VKApiConst.MESSAGE, sb.toString(), new String[]{strM18121a}, contentValues);
            }
        }
    }

    /* renamed from: a */
    private String m12459a(String str, String str2, EnumC2300t enumC2300t, String str3) throws SQLException {
        String strM18311a = C4839bd.m18311a();
        this.f11253b = true;
        if (!TextUtils.isEmpty(str)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("inbox_no", strM18311a);
            contentValues.put("buddy_no", str);
            contentValues.put("chat_type", Integer.valueOf(enumC2300t.m10210a()));
            this.f11268q.insertOrThrow("inbox_buddy_relation", null, contentValues);
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("participants_inbox_no", strM18311a);
            contentValues2.put("participants_buddy_no", str);
            contentValues2.put("participants_buddy_name", str3);
            this.f11268q.insertOrThrow("participant", null, contentValues2);
        }
        ContentValues contentValues3 = new ContentValues();
        contentValues3.put("inbox_no", strM18311a);
        contentValues3.put("inbox_chat_type", Integer.valueOf(enumC2300t.m10210a()));
        if (enumC2300t == EnumC2300t.ONETOONE) {
            contentValues3.put("inbox_last_chat_type", (Integer) 11);
        } else {
            contentValues3.put("inbox_last_chat_type", (Integer) 12);
        }
        if (!TextUtils.isEmpty(str2)) {
            contentValues3.put("inbox_session_id", str2);
        }
        contentValues3.put("inbox_last_time", (Integer) 0);
        this.f11268q.insertOrThrow("inbox", null, contentValues3);
        return strM18311a;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x007b A[Catch: all -> 0x008a, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x008a, blocks: (B:13:0x0061, B:15:0x0067, B:18:0x007b), top: B:39:0x0061 }] */
    /* renamed from: s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m12482s() {
        /*
            r7 = this;
            r4 = 1
            r6 = 0
            r5 = 0
            int[] r0 = com.sec.chaton.provider.p089a.C3036b.f11270a
            com.sec.chaton.e.t r1 = r7.f11254c
            int r1 = r1.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L3b;
                case 2: goto L91;
                case 3: goto L91;
                case 4: goto L91;
                default: goto L10;
            }
        L10:
            boolean r0 = com.sec.chaton.util.C4904y.f17875e
            if (r0 == 0) goto L3a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "getInBoxNOForChatListSync() has wrong chat type["
            java.lang.StringBuilder r0 = r0.append(r1)
            com.sec.chaton.e.t r1 = r7.f11254c
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = "]"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.Class<com.sec.chaton.provider.a.a> r1 = com.sec.chaton.provider.p089a.C3035a.class
            java.lang.String r1 = r1.getSimpleName()
            com.sec.chaton.util.C4904y.m18634a(r0, r1)
        L3a:
            return r5
        L3b:
            java.lang.String r0 = r7.f11259h
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L47
            java.lang.String r5 = ""
            goto L3a
        L47:
            java.lang.String r1 = "inbox_buddy_relation"
            java.lang.String r2 = "buddy_no=?"
            java.lang.String[] r3 = new java.lang.String[r4]
            java.lang.String r0 = r7.f11259h
            r3[r6] = r0
            java.lang.String[] r4 = new java.lang.String[r4]
            java.lang.String r0 = "inbox_no"
            r4[r6] = r0
            r0 = r7
            android.database.Cursor r1 = r0.m12485a(r1, r2, r3, r4, r5)
            if (r1 == 0) goto L7b
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L8a
            if (r0 <= 0) goto L7b
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L8a
            java.lang.String r0 = "inbox_no"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L8a
            java.lang.String r5 = r1.getString(r0)     // Catch: java.lang.Throwable -> L8a
        L75:
            if (r1 == 0) goto L3a
            r1.close()
            goto L3a
        L7b:
            java.lang.String r0 = r7.f11259h     // Catch: java.lang.Throwable -> L8a
            com.sec.chaton.io.entry.inner.ChatListInfoEntryDetail r2 = r7.f11269r     // Catch: java.lang.Throwable -> L8a
            java.lang.String r2 = r2.sessionid     // Catch: java.lang.Throwable -> L8a
            com.sec.chaton.e.t r3 = r7.f11254c     // Catch: java.lang.Throwable -> L8a
            java.lang.String r4 = r7.f11260i     // Catch: java.lang.Throwable -> L8a
            java.lang.String r5 = r7.m12459a(r0, r2, r3, r4)     // Catch: java.lang.Throwable -> L8a
            goto L75
        L8a:
            r0 = move-exception
            if (r1 == 0) goto L90
            r1.close()
        L90:
            throw r0
        L91:
            com.sec.chaton.io.entry.inner.ChatListInfoEntryDetail r0 = r7.f11269r
            java.lang.String r0 = r0.sessionid
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L3a
            java.lang.String r2 = "inbox"
            java.lang.String r3 = "inbox_session_id=?"
            java.lang.String[] r4 = new java.lang.String[r4]
            com.sec.chaton.io.entry.inner.ChatListInfoEntryDetail r0 = r7.f11269r
            java.lang.String r0 = r0.sessionid
            r4[r6] = r0
            r1 = r7
            r6 = r5
            android.database.Cursor r1 = r1.m12485a(r2, r3, r4, r5, r6)
            if (r1 == 0) goto Lc8
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> Lcf
            if (r0 <= 0) goto Lc8
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> Lcf
            if (r0 == 0) goto Lc8
            java.lang.String r0 = "inbox_no"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> Lcf
            java.lang.String r5 = r1.getString(r0)     // Catch: java.lang.Throwable -> Lcf
        Lc8:
            if (r1 == 0) goto L3a
            r1.close()
            goto L3a
        Lcf:
            r0 = move-exception
            if (r1 == 0) goto Ld5
            r1.close()
        Ld5:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.p089a.C3035a.m12482s():java.lang.String");
    }

    /* renamed from: h */
    public String m12494h() {
        Cursor cursorM12485a = m12485a("inbox", "inbox_session_id=?", new String[]{this.f11269r.sessionid}, new String[]{"inbox_no", "inbox_valid"}, null);
        String string = "";
        if (cursorM12485a != null && cursorM12485a.getCount() > 0) {
            cursorM12485a.moveToFirst();
            string = cursorM12485a.getString(0);
            if (cursorM12485a.getString(1).equals("N")) {
                string = "INVALID_INBOX";
            }
        }
        if (cursorM12485a != null) {
            cursorM12485a.close();
        }
        return string;
    }

    /* renamed from: c */
    public long m12491c(String str) {
        long j;
        Cursor cursorM12485a = m12485a("inbox", "inbox_no=?", new String[]{str}, new String[]{"inbox_last_time"}, null);
        if (cursorM12485a == null) {
            return 0L;
        }
        if (!cursorM12485a.moveToFirst()) {
            j = 0;
        } else {
            j = cursorM12485a.getLong(0);
        }
        cursorM12485a.close();
        return j;
    }

    /* renamed from: t */
    private boolean m12483t() throws SQLException {
        String str;
        String string;
        String str2;
        long jCurrentTimeMillis;
        Cursor cursorM12485a = m12485a("inbox", "inbox_session_id=?", new String[]{this.f11269r.sessionid}, new String[]{"inbox_no", "inbox_valid"}, null);
        String string2 = "";
        if (cursorM12485a == null || cursorM12485a.getCount() <= 0) {
            str = "";
        } else {
            cursorM12485a.moveToFirst();
            String string3 = cursorM12485a.getString(0);
            string2 = cursorM12485a.getString(1);
            str = string3;
        }
        if (!TextUtils.isEmpty(str)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("message_sender", C4809aa.m18104a().m18121a("chaton_id", (String) null));
            contentValues.put("message_session_id", this.f11269r.sessionid);
            m12489a(VKApiConst.MESSAGE, "message_inbox_no=?", new String[]{str}, contentValues);
            if (!string2.equals("N")) {
                Cursor cursorM12485a2 = m12485a("participant", "participants_inbox_no=?", new String[]{str}, null, null);
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("inbox_valid", "N");
                contentValues2.put("inbox_session_id", this.f11269r.sessionid);
                contentValues2.put("inbox_last_msg_sender", C4809aa.m18104a().m18121a("chaton_id", ""));
                m12489a("inbox", "inbox_no=?", new String[]{str}, contentValues2);
                ContentValues contentValues3 = new ContentValues();
                if (cursorM12485a2 == null || cursorM12485a2.getCount() <= 0) {
                    string = "";
                    str2 = "";
                } else {
                    cursorM12485a2.moveToFirst();
                    String string4 = cursorM12485a2.getString(cursorM12485a2.getColumnIndex("participants_buddy_no"));
                    string = cursorM12485a2.getString(cursorM12485a2.getColumnIndex("participants_buddy_name"));
                    str2 = string4;
                }
                if (cursorM12485a2 != null) {
                    cursorM12485a2.close();
                }
                m12488a("inbox_buddy_relation", "inbox_no=?", new String[]{str});
                long jM12491c = m12491c(str);
                if (jM12491c == 0) {
                    jCurrentTimeMillis = System.currentTimeMillis();
                } else {
                    jCurrentTimeMillis = jM12491c + 1;
                }
                contentValues3.put("message_inbox_no", str);
                contentValues3.put("_id", Long.valueOf(C4843bh.m18322a()));
                contentValues3.put("message_type", (Integer) 1);
                contentValues3.put("message_content_type", Integer.valueOf(EnumC2214ab.SYSTEM.m10076a()));
                contentValues3.put("message_content", String.format("%d,%s,%s", Integer.valueOf(EnumC2231as.DEACTIVATED.m10100a()), str2, string));
                contentValues3.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(jCurrentTimeMillis)));
                contentValues3.put("message_time", Long.valueOf(jCurrentTimeMillis));
                m12487a(VKApiConst.MESSAGE, contentValues3);
            }
            if (cursorM12485a != null) {
                cursorM12485a.close();
            }
            return true;
        }
        if (cursorM12485a != null) {
            cursorM12485a.close();
        }
        return false;
    }

    /* renamed from: d */
    public boolean m12492d(String str) throws SQLException {
        boolean z;
        String[] strArr = {"inbox_no", "inbox_valid"};
        Cursor cursorM12485a = m12485a("inbox", "inbox_session_id IN (" + str + ")", null, strArr, null);
        C4904y.m18639b("upateInboxInvalidAndChangeSessionId() mOldSessionIDs[" + str + "] is invalided.", f11246a);
        if (cursorM12485a == null || cursorM12485a.getCount() <= 0) {
            z = false;
        } else {
            m12461a(cursorM12485a);
            Cursor cursorM12485a2 = m12485a("inbox", "inbox_session_id IN ('" + this.f11269r.sessionid + "')", null, strArr, null);
            C4904y.m18639b("upateInboxInvalidAndChangeSessionId() mNewSessionIDs[" + this.f11269r.sessionid + "] is invalided.", f11246a);
            if (cursorM12485a2 != null && cursorM12485a2.getCount() > 0) {
                m12461a(cursorM12485a2);
            }
            if (cursorM12485a2 != null) {
                cursorM12485a2.close();
            }
            z = true;
        }
        if (cursorM12485a != null) {
            cursorM12485a.close();
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x017a  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m12461a(android.database.Cursor r15) throws android.database.SQLException {
        /*
            Method dump skipped, instructions count: 385
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.p089a.C3035a.m12461a(android.database.Cursor):void");
    }

    /* renamed from: a */
    public Cursor m12485a(String str, String str2, String[] strArr, String[] strArr2, String str3) {
        return new C2283cb().m10145a(str).m10146a(str2, strArr).m10143a(this.f11268q, strArr2, str3);
    }

    /* renamed from: a */
    public void m12487a(String str, ContentValues contentValues) throws SQLException {
        this.f11268q.insertOrThrow(str, null, contentValues);
    }

    /* renamed from: a */
    public void m12488a(String str, String str2, String[] strArr) {
        new C2283cb().m10145a(str).m10146a(str2, strArr).m10141a(this.f11268q);
    }

    /* renamed from: a */
    public void m12489a(String str, String str2, String[] strArr, ContentValues contentValues) {
        new C2283cb().m10145a(str).m10146a(str2, strArr).m10142a(this.f11268q, contentValues);
    }
}
