package com.sec.chaton.p035io.entry;

/* loaded from: classes.dex */
public class MessageType4Entry extends Entry {
    EntryType mEntryType;

    public enum EntryType {
        ENTRY_TYPE_PUSH,
        ENTRY_TYPE_WHOLE
    }

    public void setEntryType(EntryType entryType) {
        this.mEntryType = entryType;
    }

    public EntryType getEntryType() {
        return this.mEntryType;
    }

    public boolean isPushType() {
        return this.mEntryType == EntryType.ENTRY_TYPE_PUSH;
    }

    public String getDisplayMessage() {
        return "";
    }
}
