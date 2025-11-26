package com.sec.chaton.p065io.entry;

/* loaded from: classes.dex */
public class LiveChatFeedbackResponseEntry extends Entry {
    public String reportreadtime;
    public Result result;

    public class Result extends Entry {
        public String code;
        public String msg;
    }
}
