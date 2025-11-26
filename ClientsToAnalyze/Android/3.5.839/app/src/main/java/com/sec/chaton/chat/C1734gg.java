package com.sec.chaton.chat;

import android.text.TextUtils;
import com.sec.chaton.chat.notification.C1830s;
import com.sec.chaton.p046a.C0815aw;
import com.sec.chaton.p046a.C0818az;
import com.sec.chaton.p046a.C0826bg;
import com.sec.chaton.p046a.C0852cf;
import com.sec.chaton.p046a.C0855ci;
import com.sec.chaton.p046a.C0858cl;
import com.sec.chaton.p046a.C0861co;
import com.sec.chaton.p046a.C0870cx;
import com.sec.chaton.p046a.C0874da;
import com.sec.chaton.p046a.C0895dv;
import com.sec.chaton.p046a.C0898dy;
import com.sec.chaton.p046a.C0902eb;
import com.sec.chaton.p046a.C0905ee;
import com.sec.chaton.p046a.C0927f;
import com.sec.chaton.p046a.C0929fb;
import com.sec.chaton.p046a.C0932fe;
import com.sec.chaton.p046a.C0935fh;
import com.sec.chaton.p046a.C0947ft;
import com.sec.chaton.p046a.C0950fw;
import com.sec.chaton.p046a.C0957gc;
import com.sec.chaton.p046a.C0966gl;
import com.sec.chaton.p046a.C0969go;
import com.sec.chaton.p046a.C0973i;
import com.sec.chaton.p046a.EnumC0908eh;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p065io.entry.PushEntry;
import com.sec.chaton.p072k.p073a.C2477a;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ChatMessageLogWriter.java */
/* renamed from: com.sec.chaton.chat.gg */
/* loaded from: classes.dex */
public class C1734gg {

    /* renamed from: a */
    public static String f6533a = C1734gg.class.getSimpleName();

    /* renamed from: a */
    private static String m8585a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.length() > i) {
            return str.substring(0, i);
        }
        return str;
    }

    /* renamed from: a */
    public static String m8584a(String str) {
        return m8585a(str, 5);
    }

    /* renamed from: a */
    public static void m8609a(ArrayList<C1830s> arrayList, String str) {
        if (C4904y.f17873c && arrayList != null) {
            int size = arrayList.size() > 7 ? 7 : arrayList.size();
            for (int i = 0; i < size; i++) {
                C1830s c1830s = arrayList.get(i);
                StringBuilder sb = new StringBuilder("[NOTIPannel] ");
                String strM8585a = m8585a(c1830s.f6929c, 5);
                if (strM8585a == null) {
                    strM8585a = "null";
                }
                sb.append("Sender ID : ").append(c1830s.f6927a).append(", ").append("Sender : ").append(c1830s.f6928b).append(", ").append("InboxNO: ").append(c1830s.f6931e).append(", ").append("MsgID : ").append(String.valueOf(c1830s.f6940n)).append(", ").append("ChatMsg : ").append(strM8585a).append(", ").append("ChatMsgLength : ").append(c1830s.f6929c.length());
                C4904y.m18641c(sb.toString(), str);
            }
        }
    }

    /* renamed from: a */
    public static void m8589a(String str, long j, String str2, String str3, EnumC2214ab enumC2214ab, String str4) {
        if (C4904y.f17873c) {
            StringBuilder sb = new StringBuilder();
            String strM8585a = m8585a(str3, 5);
            if (strM8585a == null) {
                strM8585a = "null";
            }
            sb.append("UID : ").append(C4809aa.m18104a().m18121a("uid", "")).append(", ").append("InboxNo : ").append(str).append(", ").append("Sender : ").append(str2).append(", ").append("MsgID : ").append(String.valueOf(j)).append(", ").append("ContentType : ").append(enumC2214ab).append(", ").append("ChatMsg : ").append(strM8585a).append(", ").append("ChatMsgLength : ").append(str3.length());
            C4904y.m18641c(sb.toString(), str4);
        }
    }

    /* renamed from: a */
    public static void m8608a(String str, String str2) {
        if (C4904y.f17873c) {
            try {
                PushEntry pushEntry = (PushEntry) new C2477a(str).m10709a(PushEntry.class);
                String strM8585a = m8585a(pushEntry.message, 5);
                int length = 0;
                if (pushEntry.message != null) {
                    length = pushEntry.message.length();
                }
                pushEntry.message = strM8585a;
                StringBuilder sb = new StringBuilder(pushEntry.toString());
                sb.append("ChatMsgLength : ").append(String.valueOf(length)).append("\n");
                C4904y.m18641c(sb.toString(), str2);
            } catch (Exception e) {
                C4904y.m18635a(e, f6533a);
            }
        }
    }

    /* renamed from: a */
    public static void m8592a(String str, C0826bg c0826bg, String str2) {
        if (C4904y.f17873c) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < c0826bg.m3602g().size()) {
                    String strM8585a = m8585a(c0826bg.m3596a(i2).m4156j(), 5);
                    if (strM8585a == null) {
                        strM8585a = "null";
                    }
                    sb.append("[").append(i2).append("] ").append("ChatType : ").append(c0826bg.m3596a(i2).m4162p()).append(", ").append("Sender : ").append(c0826bg.m3596a(i2).m4150d()).append(", ").append("Receiver : ").append(TextUtils.join(",", c0826bg.m3596a(i2).m4151e())).append(", ").append("Time : ").append(c0826bg.m3596a(i2).m4158l()).append(", ").append("MsgID : ").append(c0826bg.m3596a(i2).m4154h()).append(", ").append("MsgType : ").append(c0826bg.m3596a(i2).m4160n()).append(", ").append("ChatMsg : ").append(strM8585a).append(", ").append("ChatMsgLength : ").append(c0826bg.m3596a(i2).m4156j().length());
                    i = i2 + 1;
                } else {
                    StringBuilder sb2 = new StringBuilder("[DeliveryChat]");
                    sb2.append("UID : ").append(C4809aa.m18104a().m18121a("uid", "")).append(", ").append("InboxNo : ").append(str).append(", ").append("ChatType : ").append(c0826bg.m3601f()).append(", ").append("SessionID : ").append(c0826bg.m3599d()).append(", ").append("InboxMessageCount : ").append(c0826bg.m3603h()).append(", ").append("NextPaginationKey : ").append(c0826bg.m3609n()).append(sb.toString());
                    C4904y.m18641c(sb2.toString(), str2);
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    public static void m8605a(String str, C0932fe c0932fe, String str2) {
        if (C4904y.f17873c) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < c0932fe.m5170m().size(); i++) {
                sb.append("[").append(i).append("] ").append("ChatType : ").append(c0932fe.m5158a(i).m4214n()).append(", ").append("Sender : ").append(c0932fe.m5158a(i).m4204d()).append(", ").append("Time : ").append(c0932fe.m5158a(i).m4210j()).append(", ").append("MsgID : ").append(c0932fe.m5158a(i).m4208h()).append(", ").append("MsgType : ").append(c0932fe.m5158a(i).m4212l());
            }
            StringBuilder sb2 = new StringBuilder("[ReadMessageRequest]");
            sb2.append("UID : ").append(C4809aa.m18104a().m18121a("uid", "")).append(", ").append("ReqeustMsgId : ").append(c0932fe.m5161d()).append(", ").append("InboxNo : ").append(str).append(", ").append("SessionID : ").append(c0932fe.m5163f()).append(", ").append("InboxReplyItemCount : ").append(c0932fe.m5171n()).append(", ").append("LastSessionMergeTimestamp : ").append(c0932fe.m5165h()).append(sb.toString());
            C4904y.m18641c(sb2.toString(), str2);
        }
    }

    /* renamed from: a */
    public static void m8604a(String str, C0929fb c0929fb, String str2) {
        if (C4904y.f17873c) {
            StringBuilder sb = new StringBuilder("[ReadMessageReply]");
            sb.append("InboxNo : ").append(str).append(", ").append("ReqeustMsgId : ").append(c0929fb.m5114d());
            if (c0929fb.m5116f() != null) {
                sb.append(", ").append("ResultCode : ").append(c0929fb.m5116f().m5229d()).append(", ").append("ResultMsg : ").append(c0929fb.m5116f().m5231f());
            }
            C4904y.m18641c(sb.toString(), str2);
        }
    }

    /* renamed from: a */
    public static void m8595a(String str, C0858cl c0858cl, String str2) {
        if (C4904y.f17873c) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < c0858cl.m4035e().size(); i++) {
                sb.append("[").append(i).append("] ").append("ChatType : ").append(c0858cl.m4031a(i).m4162p()).append(", ").append("Sender : ").append(c0858cl.m4031a(i).m4150d()).append(", ").append("Receiver : ").append(TextUtils.join(",", c0858cl.m4031a(i).m4151e())).append(", ").append("Time : ").append(c0858cl.m4031a(i).m4158l()).append(", ").append("MsgID : ").append(c0858cl.m4031a(i).m4154h()).append(", ").append("MsgType : ").append(c0858cl.m4031a(i).m4160n()).append(", ").append("ChatMsg : ").append(m8585a(c0858cl.m4031a(i).m4156j(), 5)).append(", ").append("InboxKey : ").append(c0858cl.m4031a(i).m4164r()).append(", ").append("ChatMsgLength : ").append(c0858cl.m4031a(i).m4156j().length());
            }
            StringBuilder sb2 = new StringBuilder("[ForwardStoredMessage]");
            sb2.append("UID : ").append(C4809aa.m18104a().m18121a("uid", "")).append(", ").append("InboxNo : ").append(str).append(", ").append("SessionID : ").append(c0858cl.m4034d()).append(", ").append("InboxMessageCount : ").append(c0858cl.m4036f()).append(", ").append("HasMoreResult : ").append(c0858cl.m4038h()).append(", ").append("NextPaginationKey : ").append(c0858cl.m4040j()).append(sb.toString());
            C4904y.m18641c(sb2.toString(), str2);
        }
    }

    /* renamed from: a */
    public static void m8596a(String str, C0861co c0861co, String str2) {
        if (C4904y.f17873c) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < c0861co.m4093i().size(); i++) {
                sb.append("[").append(i).append("] ").append("ChatType : ").append(c0861co.m4085a(i).m4214n()).append(", ").append("Sender : ").append(c0861co.m4085a(i).m4204d()).append(", ").append("Receiver : ").append(c0861co.m4085a(i).m4206f()).append(", ").append("Time : ").append(c0861co.m4085a(i).m4210j()).append(", ").append("MsgID : ").append(c0861co.m4085a(i).m4208h()).append(", ").append("MsgType : ").append(c0861co.m4085a(i).m4212l()).append(", ").append("InboxKey : ").append(c0861co.m4085a(i).m4216p());
            }
            StringBuilder sb2 = new StringBuilder("[ForwardStoredMessageReply]");
            sb2.append("UID : ").append(C4809aa.m18104a().m18121a("uid", "")).append(", ").append("InboxNo : ").append(str).append(", ").append("SessionID : ").append(c0861co.m4092h()).append(", ").append("InboxMessageCount : ").append(c0861co.m4094j()).append(", ").append("NextPaginationKey : ").append(c0861co.m4098n()).append(sb.toString());
            C4904y.m18641c(sb2.toString(), str2);
        }
    }

    /* renamed from: a */
    public static void m8593a(String str, C0852cf c0852cf, String str2) {
        if (C4904y.f17873c) {
            StringBuilder sb = new StringBuilder();
            sb.append("ChatType : ").append(c0852cf.m3934f().m4162p()).append(", ").append("Sender : ").append(c0852cf.m3934f().m4150d()).append(", ").append("Receiver : ").append(TextUtils.join(",", c0852cf.m3934f().m4151e())).append(", ").append("Time : ").append(c0852cf.m3934f().m4158l()).append(", ").append("MsgID : ").append(c0852cf.m3934f().m4154h()).append(", ").append("MsgType : ").append(c0852cf.m3934f().m4160n()).append(", ").append("ChatMsg : ").append(m8585a(c0852cf.m3934f().m4156j(), 5)).append(", ").append("ChatMsgLength : ").append(c0852cf.m3934f().m4156j().length());
            StringBuilder sb2 = new StringBuilder("[ForwardOnlineMessage]");
            sb2.append("UID : ").append(C4809aa.m18104a().m18121a("uid", "")).append(", ").append("InboxNo : ").append(str).append(", ").append("SessionID : ").append(c0852cf.m3932d()).append(", ").append(sb.toString());
            C4904y.m18641c(sb2.toString(), str2);
        }
    }

    /* renamed from: a */
    public static void m8594a(String str, C0855ci c0855ci, String str2) {
        if (C4904y.f17873c) {
            StringBuilder sb = new StringBuilder();
            sb.append("ChatType : ").append(c0855ci.m3986j().m4214n()).append(", ").append("Sender : ").append(c0855ci.m3986j().m4204d()).append(", ").append("Receiver : ").append(c0855ci.m3986j().m4206f()).append(", ").append("Time : ").append(c0855ci.m3986j().m4210j()).append(", ").append("MsgID : ").append(c0855ci.m3986j().m4208h()).append(", ").append("MsgType : ").append(c0855ci.m3986j().m4212l());
            StringBuilder sb2 = new StringBuilder("[ForwardOnlineMessageReply]");
            sb2.append("UID : ").append(C4809aa.m18104a().m18121a("uid", "")).append(", ").append("InboxNo : ").append(str).append(", ").append("SessionID : ").append(c0855ci.m3984h()).append(", ").append(sb.toString());
            C4904y.m18641c(sb2.toString(), str2);
        }
    }

    /* renamed from: a */
    public static void m8591a(String str, C0818az c0818az, String str2) {
        if (C4904y.f17873c) {
            StringBuilder sb = new StringBuilder("p#ch@t[ChatRequest],");
            String strM8585a = m8585a(c0818az.m3539s(), 5);
            if (strM8585a == null) {
                strM8585a = "null";
            }
            sb.append("UID : ").append(C4809aa.m18104a().m18121a("uid", "")).append(", ").append("InboxNo : ").append(str).append(", ").append("ChatType : ").append(c0818az.m3528h()).append(", ").append("SessionID : ").append(c0818az.m3530j()).append(", ").append("Sender : ").append(c0818az.m3532l()).append(", ").append("Receiver : ").append(TextUtils.join(",", c0818az.m3533m())).append(", ").append("Time : " + System.currentTimeMillis()).append(", ").append("MsgID : ").append(c0818az.m3524d()).append(", ").append("MsgType : ").append(c0818az.m3526f()).append(", ").append("ChatMsg : ").append(strM8585a).append(", ").append("ChatMsgLength : ").append(c0818az.m3539s().length()).append(", ").append("LastSessionMergeTime : ").append(c0818az.m3543w());
            C4904y.m18641c(sb.toString(), str2);
        }
    }

    /* renamed from: a */
    public static void m8590a(String str, C0815aw c0815aw, String str2) {
        if (C4904y.f17873c) {
            StringBuilder sb = new StringBuilder("p#ch@t[ChatReply],");
            sb.append("UID : ").append(C4809aa.m18104a().m18121a("uid", "")).append(", ").append("InboxNo : ").append(str).append(", ").append("SessionID : ").append(c0815aw.m3446f()).append(", ").append("Time : " + System.currentTimeMillis()).append(", ").append("ReceivedTime : ").append(c0815aw.m3450j()).append(", ").append("MsgID : ").append(c0815aw.m3444d()).append(", ").append("ResultCode : ").append(c0815aw.m3452l().m5229d()).append(", ").append("ResultMessage : ").append(c0815aw.m3452l().m5231f()).append(", ").append("Server_address : ").append(c0815aw.m3448h() != null ? c0815aw.m3448h().m5561d() : "null").append(", ").append("Server_port : ").append(c0815aw.m3448h() != null ? Integer.valueOf(c0815aw.m3448h().m5563f()) : "null");
            C4904y.m18641c(sb.toString(), str2);
        }
    }

    /* renamed from: a */
    public static void m8607a(String str, C0973i c0973i, String str2) {
        if (C4904y.f17873c) {
            StringBuilder sb = new StringBuilder("[AllowChatRequest]");
            sb.append("UID : ").append(C4809aa.m18104a().m18121a("uid", "")).append(", ").append("InboxNo : ").append(str).append(", ").append("ChatType : ").append(c0973i.m5773f()).append(", ").append("SessionID : ").append(c0973i.m5775h()).append(", ").append("Sender : ").append(c0973i.m5777j()).append(", ").append("Receiver : ").append(c0973i.m5779l()).append(", ").append("MsgID : ").append(c0973i.m5771d()).append(", ").append("LastSessionMergeTime : ").append(c0973i.m5789v()).append(", ").append("MaxMessageCount : ").append(c0973i.m5785r()).append("NeedOrderedChatMemberList : ").append(c0973i.m5791x());
            C4904y.m18641c(sb.toString(), str2);
        }
    }

    /* renamed from: a */
    public static void m8603a(String str, C0927f c0927f, String str2) {
        if (C4904y.f17873c) {
            StringBuilder sb = new StringBuilder("[AllowChatReply]");
            sb.append("UID : ").append(C4809aa.m18104a().m18121a("uid", "")).append(", ").append("InboxNo : ").append(str).append(", ").append("MsgID : ").append(c0927f.m5083d()).append(", ").append("ResultCode : ").append(c0927f.m5085f().m5229d()).append(", ").append("ResultMsg : ").append(c0927f.m5085f().m5231f()).append(", ").append("OrderedChatMemberListCount : ").append(c0927f.m5087h());
            if (c0927f.m5086g() != null) {
                sb.append(", ").append("OrderedChatMemberList : ");
                for (int i = 0; i < c0927f.m5086g().size(); i++) {
                    sb.append("[").append(i).append("]").append(c0927f.m5080a(i));
                }
            }
            C4904y.m18641c(sb.toString(), str2);
        }
    }

    /* renamed from: a */
    public static void m8606a(String str, C0947ft c0947ft, String str2) {
        if (C4904y.f17873c) {
            List<C0950fw> listM5422r = c0947ft.m5422r();
            StringBuilder sb = new StringBuilder();
            EnumC0908eh enumC0908eh = EnumC0908eh.TEXT;
            int i = 0;
            Iterator<C0950fw> it = listM5422r.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    C0950fw next = it.next();
                    String strM8585a = m8585a(next.m5472h(), 5);
                    if (strM8585a == null) {
                        strM8585a = "null";
                    }
                    sb.append("[").append(i2).append("]").append("MsgID : ").append(next.m5468d()).append(", ").append("MsgType : ").append(next.m5470f()).append(", ").append("ChatMsg : ").append(strM8585a).append(", ").append("ChatMsgLength : ").append(next.m5472h().length());
                    i = i2 + 1;
                } else {
                    StringBuilder sb2 = new StringBuilder("[SerialChatRequest],");
                    sb2.append("UID : ").append(C4809aa.m18104a().m18121a("uid", "")).append(", ").append("InboxNo : ").append(str).append(", ").append("ChatType : ").append(c0947ft.m5410f()).append(", ").append("SessionID : ").append(c0947ft.m5412h()).append(", ").append("Sender : ").append(c0947ft.m5414j()).append(", ").append("Receiver : ").append(TextUtils.join(",", c0947ft.m5415k())).append(", ").append("Time : " + System.currentTimeMillis()).append(", ").append("LastSessionMergeTime : ").append(c0947ft.m5421q()).append(", ").append(sb.toString());
                    C4904y.m18641c(sb2.toString(), str2);
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    public static void m8598a(String str, C0874da c0874da, String str2) {
        if (C4904y.f17873c) {
            StringBuilder sb = new StringBuilder("p#ch@t[InitChatRequest],");
            String strM8585a = m8585a(c0874da.m4352s(), 5);
            if (strM8585a == null) {
                strM8585a = "null";
            }
            sb.append("UID : ").append(C4809aa.m18104a().m18121a("uid", "")).append(", ").append("InboxNo : ").append(str).append(", ").append("ChatType : ").append(c0874da.m4341h()).append(", ").append("SessionID : ").append("N/A").append(", ").append("Sender : ").append(c0874da.m4349p()).append(", ").append("Receiver : ").append(TextUtils.join(",", c0874da.m4350q())).append(", ").append("Time : " + System.currentTimeMillis()).append(", ").append("MsgID : ").append(c0874da.m4337d()).append(", ").append("MsgType : ").append(c0874da.m4339f()).append(", ").append("ChatMsg : ").append(strM8585a).append(", ").append("ChatMsgLength : ").append(c0874da.m4352s().length());
            C4904y.m18641c(sb.toString(), str2);
        }
    }

    /* renamed from: a */
    public static void m8597a(String str, C0870cx c0870cx, String str2) {
        if (C4904y.f17873c) {
            StringBuilder sb = new StringBuilder("p#ch@t[InitChatReply],");
            sb.append("UID : ").append(C4809aa.m18104a().m18121a("uid", "")).append(", ").append("InboxNo : ").append(str).append(", ").append("SessionID : ").append(c0870cx.m4252f()).append(", ").append("Time : ").append(System.currentTimeMillis()).append(", ").append("ReceivedTime : ").append(c0870cx.m4254h()).append(", ").append("MsgID : ").append(c0870cx.m4250d()).append(", ").append("ResultCode : ").append(c0870cx.m4258l() != null ? Integer.valueOf(c0870cx.m4258l().m5229d()) : "null").append(", ").append("ResultMessage : ").append(c0870cx.m4256j() != null ? c0870cx.m4258l().m5231f() : "null").append(", ").append("ServerInfo(address) : ").append(c0870cx.m4256j() != null ? c0870cx.m4256j().m5561d() : "null(broadcast)").append(", ").append("ServerInfo(address) : ").append(c0870cx.m4256j() != null ? Integer.valueOf(c0870cx.m4256j().m5563f()) : "null(broadcast)");
            C4904y.m18641c(sb.toString(), str2);
        }
    }

    /* renamed from: a */
    public static void m8601a(String str, C0902eb c0902eb, String str2) {
        if (C4904y.f17873c) {
            StringBuilder sb = new StringBuilder("p#ch@t[MirrorAcknowledge],");
            sb.append("UID : ").append(C4809aa.m18104a().m18121a("uid", "")).append(", ").append("InboxNo : ").append(str).append(", ").append("SessionID : ").append(c0902eb.m4821d()).append(", ").append("Time : ").append(System.currentTimeMillis()).append(", ").append("MsgID : ").append(c0902eb.m4823f()).append(", ").append("Receiver : ").append(c0902eb.m4825h());
            C4904y.m18641c(sb.toString(), str2);
        }
    }

    /* renamed from: a */
    public static void m8602a(String str, C0905ee c0905ee, String str2) {
        if (C4904y.f17873c) {
            StringBuilder sb = new StringBuilder("p#ch@t[MirrorAcknowledgeReply],");
            sb.append("UID : ").append(C4809aa.m18104a().m18121a("uid", "")).append(", ").append("InboxNo : ").append(str).append(", ").append("SessionID : ").append(c0905ee.m4861f()).append(", ").append("Time : ").append(System.currentTimeMillis()).append(", ").append("ResultCode : ").append(c0905ee.m4863h() != null ? Integer.valueOf(c0905ee.m4863h().m5229d()) : "null").append(", ").append("ResultMessage : ").append(c0905ee.m4863h() != null ? c0905ee.m4863h().m5231f() : "null");
            C4904y.m18641c(sb.toString(), str2);
        }
    }

    /* renamed from: a */
    public static void m8600a(String str, C0898dy c0898dy, String str2) {
        if (C4904y.f17873c) {
            StringBuilder sb = new StringBuilder("p#ch@t[MessageCancelRequest],");
            sb.append("UID : ").append(C4809aa.m18104a().m18121a("uid", "")).append(", ").append("InboxNo : ").append(str).append(", ").append("RequestID : ").append(c0898dy.m4759d()).append(", ").append("MsgID : ").append(c0898dy.m4773r()).append(", ").append("SessionID : ").append(c0898dy.m4765j()).append(", ").append("ChatType : ").append(c0898dy.m4767l()).append(", ").append("Sender : ").append(c0898dy.m4769n()).append(", ").append("Receiver : ").append(c0898dy.m4771p()).append(", ").append("LastSessionMergeTimestamp : ").append(c0898dy.m4775t()).append(", ").append("TrunkFilename : ").append(c0898dy.m4777v()).append(", ").append("TrunkFileOwnerUid : ").append(c0898dy.m4781z()).append(", ").append("Time : ").append(System.currentTimeMillis());
            C4904y.m18641c(sb.toString(), str2);
        }
    }

    /* renamed from: a */
    public static void m8599a(String str, C0895dv c0895dv, String str2) {
        if (C4904y.f17873c) {
            StringBuilder sb = new StringBuilder("p#ch@t[MessageCancelReply],");
            sb.append("UID : ").append(C4809aa.m18104a().m18121a("uid", "")).append(", ").append("InboxNo : ").append(str).append(", ").append("SessionID : ").append(c0895dv.m4699f()).append(", ").append("RequestID : ").append(c0895dv.m4697d()).append(", ").append("Time : ").append(System.currentTimeMillis()).append(", ").append("ResultCode : ").append(c0895dv.m4701h() != null ? Integer.valueOf(c0895dv.m4701h().m5229d()) : "null").append(", ").append("ResultMessage : ").append(c0895dv.m4701h() != null ? c0895dv.m4701h().m5231f() : "null");
            C4904y.m18641c(sb.toString(), str2);
        }
    }

    /* renamed from: a */
    public static void m8587a(C0966gl c0966gl, String str) {
        if (C4904y.f17873c) {
            StringBuilder sb = new StringBuilder("p#ch@t[UndoMessage],");
            sb.append("UID : ").append(C4809aa.m18104a().m18121a("uid", "")).append(", ").append("MsgId : ").append(c0966gl.m5663h()).append(", ").append("Sender : ").append(c0966gl.m5661f()).append(", ").append("SessionId : ").append(c0966gl.m5659d());
            C4904y.m18641c(sb.toString(), str);
        }
    }

    /* renamed from: a */
    public static void m8588a(C0969go c0969go, String str) {
        if (C4904y.f17873c) {
            StringBuilder sb = new StringBuilder("p#ch@t[UndoMessageReply],");
            sb.append("UID : ").append(C4809aa.m18104a().m18121a("uid", "")).append(", ").append("MsgId : ").append(c0969go.m5715n()).append(", ").append("Sender : ").append(c0969go.m5711j()).append(", ").append("Receiver : ").append(c0969go.m5713l()).append(", ").append("SessionId : ").append(c0969go.m5709h());
            C4904y.m18641c(sb.toString(), str);
        }
    }

    /* renamed from: a */
    public static void m8586a(int i, String str, int i2, long j, String str2, String str3) {
        if (C4904y.f17873c) {
            switch (i) {
                case 1:
                    m8597a(str, C0870cx.newBuilder().m4275a("").m4277b(0L).m4269a(j).m4273a(C0935fh.newBuilder().m5252a(i2).m5257a("Failed")).build(), str3);
                    break;
                case 5:
                    m8590a(str, C0815aw.newBuilder().m3469a(str2).m3471b(0L).m3463a(j).m3468a(C0957gc.newBuilder().m5573a("").m5570a(0).build()).m3467a(C0935fh.newBuilder().m5252a(i2).m5257a("Failed")).build(), str3);
                    break;
            }
        }
    }
}
