package com.sec.chaton.p027e;

import com.sec.common.util.C3364o;
import com.sec.spp.push.Config;

/* compiled from: DatabaseHelper.java */
/* renamed from: com.sec.chaton.e.bh */
/* loaded from: classes.dex */
public interface InterfaceC1432bh {

    /* renamed from: a */
    public static final String f5355a = C3364o.m11849a("CREATE TRIGGER ", "trigger_inbox_before_delete", " BEFORE DELETE ON ", "inbox", " BEGIN", " DELETE FROM ", "inbox_buddy_relation", " WHERE ", "inbox_no", " = old.", "inbox_no", Config.KEYVALUE_SPLIT, " END;");

    /* renamed from: b */
    public static final String f5356b = C3364o.m11849a("CREATE TRIGGER ", "trigger_poll_relation_voter_after_delete", " BEFORE DELETE ON ", "poll_relation_voter", " BEGIN", " DELETE FROM ", "poll_voter", " WHERE ", "poll_voter", ".", "voter_id", " = old.", "voter_id", " AND (SELECT COUNT(", "answer_relation_voter", ".", "voter_id", ") ", "FROM ", "answer_relation_voter", ",", "poll_relation_voter", " ", "WHERE ", "answer_relation_voter", ".", "voter_id", " = ", "poll_relation_voter", ".", "voter_id", ") = 0;", " END;");
}
