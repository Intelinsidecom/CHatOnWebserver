package com.sec.chaton.p065io.entry;

import com.sec.chaton.p065io.entry.inner.LiveChatDeliveryMessageEntryDetail;
import com.sec.chaton.p065io.entry.inner.LiveChatSendMessageResponseEntry;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class LiveChatDeliveryMessageEntry extends Entry {
    public String receivetime;

    @EntryField(type = LiveChatSendMessageResponseEntry.class)
    public ArrayList<LiveChatSendMessageResponseEntry> responsemessagelist;
    public LiveChatDeliveryMessageEntryDetail result;
}
