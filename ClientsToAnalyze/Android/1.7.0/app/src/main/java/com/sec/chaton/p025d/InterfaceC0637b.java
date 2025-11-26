package com.sec.chaton.p025d;

/* compiled from: DatabaseHelper.java */
/* renamed from: com.sec.chaton.d.b */
/* loaded from: classes.dex */
public interface InterfaceC0637b {

    /* renamed from: a */
    public static final String f2216a = "(SELECT c.participants_buddy_name AS inbox_title,a.inbox_no FROM inbox a,(SELECT participants_inbox_no,group_concat(participants_buddy_name, \", \") AS participants_buddy_name FROM (SELECT ifnull(b.buddy_name,MAX(p.participants_buddy_name)) AS participants_buddy_name,p.participants_buddy_no,p.participants_inbox_no,p.rowid FROM participant p LEFT OUTER JOIN buddy b ON p.participants_buddy_no=b.buddy_no GROUP BY p.participants_buddy_no,p.participants_inbox_no ORDER BY p.rowid DESC)  GROUP BY participants_inbox_no) c WHERE a.inbox_no=c.participants_inbox_no AND (a.inbox_chat_type=" + EnumC0665r.GROUPCHAT.m3012a() + " OR a.inbox_chat_type=" + EnumC0665r.ONETOONE.m3012a() + ") AND a.inbox_title_fixed='N')";
}
