package com.sec.chaton.p017e;

/* compiled from: DatabaseHelper.java */
/* renamed from: com.sec.chaton.e.w */
/* loaded from: classes.dex */
public interface InterfaceC0708w {

    /* renamed from: a */
    public static final String f2660a = "(SELECT c.participants_buddy_name AS inbox_title,a.inbox_no FROM inbox a,(SELECT participants_inbox_no,group_concat(participants_buddy_name) AS participants_buddy_name FROM (SELECT ifnull(b.buddy_name,MAX(p.participants_buddy_name)) AS participants_buddy_name,p.participants_buddy_no,p.participants_inbox_no,p.rowid FROM participant p LEFT OUTER JOIN ( SELECT buddy_no, buddy_name FROM buddy UNION ALL SELECT buddy_no AS buddy_no, buddy_name AS buddy_name FROM specialbuddy ) b ON p.participants_buddy_no=b.buddy_no GROUP BY p.participants_buddy_no,p.participants_inbox_no ORDER BY p.rowid DESC)  GROUP BY participants_inbox_no) c WHERE a.inbox_no=c.participants_inbox_no AND (a.inbox_chat_type=" + EnumC0695j.GROUPCHAT.m3146a() + " OR a.inbox_chat_type=" + EnumC0695j.ONETOONE.m3146a() + ") AND a.inbox_title_fixed='N')";
}
