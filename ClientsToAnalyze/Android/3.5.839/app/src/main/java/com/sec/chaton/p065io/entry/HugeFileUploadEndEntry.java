package com.sec.chaton.p065io.entry;

/* loaded from: classes.dex */
public class HugeFileUploadEndEntry extends Entry {
    public Integer auth_code;
    public Integer chunk_count;
    public Long expired_time;
    public Integer max_upload_count;
    public String mupload_key;
    public String path;
    public String public_url;
    public Integer revision;
    public Integer size;
    public Long timestamp;
    public String type;
    public Integer upload_count;

    @Override // com.sec.chaton.p065io.entry.Entry
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("chunk_count: " + this.chunk_count);
        sb.append(", mupload_key: " + this.mupload_key);
        sb.append(", path: " + this.path);
        sb.append(", size: " + this.size);
        sb.append(", timestamp: " + this.timestamp);
        sb.append(", type: " + this.type);
        sb.append(", public_url: " + this.public_url);
        sb.append(", auth_code: " + this.auth_code);
        sb.append(", expired_time: " + this.expired_time);
        sb.append(", max_upload_count: " + this.max_upload_count);
        sb.append(", upload_count: " + this.upload_count);
        return sb.toString();
    }
}
