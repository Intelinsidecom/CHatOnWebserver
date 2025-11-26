package com.sec.chaton.p025d;

import com.sec.chaton.p033io.entry.inner.Buddy;

/* compiled from: DatabaseHelper.java */
/* renamed from: com.sec.chaton.d.p */
/* loaded from: classes.dex */
public interface InterfaceC0663p {

    /* renamed from: a */
    public static final String f2290a = "CREATE TABLE buddy (_id INTEGER PRIMARY KEY AUTOINCREMENT,buddy_no VARCHAR(25) NOT NULL,buddy_name VARCHAR(80) NOT NULL,buddy_status_message VARCHAR(255),buddy_email VARCHAR(80),buddy_samsung_email VARCHAR(80),buddy_orginal_number VARCHAR(25),buddy_birthday VARCHAR(10) NOT NULL DEFAULT '',buddy_msg_send INTEGER DEFAULT 0,buddy_msg_received INTEGER DEFAULT 0,buddy_relation_hide CHAR(1) NOT NULL DEFAULT 'N',buddy_raw_contact_id NUMBER DEFAULT 0, buddy_push_name VARCHAR(25),buddy_is_new CHAR(1) NOT NULL DEFAULT 'Y',buddy_profile_status INTEGER NOT NULL DEFAULT " + Buddy.BuddyImageStatus.NONE_PROFILE.getCode() + ",UNIQUE (buddy_no))";
}
