package com.sec.chaton.p057e;

import com.sec.common.util.C5052r;
import com.sec.spp.push.Config;

/* compiled from: DatabaseHelper.java */
/* renamed from: com.sec.chaton.e.bz */
/* loaded from: classes.dex */
public interface InterfaceC2280bz {

    /* renamed from: a */
    public static final String f8182a = C5052r.m19199a("CREATE TRIGGER ", "trigger_inbox_before_delete", " BEFORE DELETE ON ", "inbox", " BEGIN", " DELETE FROM ", "inbox_buddy_relation", " WHERE ", "inbox_no", " = old.", "inbox_no", Config.KEYVALUE_SPLIT, " DELETE FROM ", "participant", " WHERE ", "participants_inbox_no", " = old.", "inbox_no", Config.KEYVALUE_SPLIT, " END;");

    /* renamed from: b */
    public static final String f8183b = C5052r.m19199a("CREATE TRIGGER ", "trigger_poll_relation_voter_after_delete", " BEFORE DELETE ON ", "poll_relation_voter", " BEGIN", " DELETE FROM ", "poll_voter", " WHERE ", "poll_voter", ".", "voter_id", " = old.", "voter_id", " AND (SELECT COUNT(", "answer_relation_voter", ".", "voter_id", ") ", "FROM ", "answer_relation_voter", ",", "poll_relation_voter", " ", "WHERE ", "answer_relation_voter", ".", "voter_id", " = ", "poll_relation_voter", ".", "voter_id", ") = 0;", " END;");
}
