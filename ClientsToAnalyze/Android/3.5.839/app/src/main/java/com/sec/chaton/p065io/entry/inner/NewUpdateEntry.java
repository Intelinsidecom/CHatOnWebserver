package com.sec.chaton.p065io.entry.inner;

import com.sec.chaton.p065io.entry.Entry;
import com.sec.chaton.p065io.entry.EntryField;

/* loaded from: classes.dex */
public class NewUpdateEntry extends Entry {
    public String action;

    @EntryField(type = NewUpdateAdditionalEntry.class)
    public NewUpdateAdditionalEntry additional;
    public String created;
    public String push_message;

    @EntryField(type = NewUpdateSenderEntry.class)
    public NewUpdateSenderEntry sender;
    public String service;
    public String status;
    public String unread;
    public String url_scheme;
}
