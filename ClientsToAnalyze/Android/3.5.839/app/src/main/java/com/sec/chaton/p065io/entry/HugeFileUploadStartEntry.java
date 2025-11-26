package com.sec.chaton.p065io.entry;

/* loaded from: classes.dex */
public class HugeFileUploadStartEntry extends Entry {
    public Integer chunk_count;
    public String mupload_key;
    public String path;
    public Integer revision;
    public Integer size;
    public Long timestamp;
    public String type;

    @Override // com.sec.chaton.p065io.entry.Entry
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("chunk_count: " + this.chunk_count);
        sb.append(", mupload_key: " + this.mupload_key);
        sb.append(", path: " + this.path);
        sb.append(", size: " + this.size);
        sb.append(", timestamp: " + this.timestamp);
        sb.append(", type: " + this.type);
        return sb.toString();
    }
}
