package com.google.protobuf;

import java.io.IOException;

/* loaded from: classes.dex */
public class InvalidProtocolBufferException extends IOException {
    public InvalidProtocolBufferException(String str) {
        super(str);
    }

    /* renamed from: a */
    static InvalidProtocolBufferException m342a() {
        return new InvalidProtocolBufferException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    /* renamed from: b */
    static InvalidProtocolBufferException m343b() {
        return new InvalidProtocolBufferException("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* renamed from: c */
    static InvalidProtocolBufferException m344c() {
        return new InvalidProtocolBufferException("CodedInputStream encountered a malformed varint.");
    }

    /* renamed from: d */
    static InvalidProtocolBufferException m345d() {
        return new InvalidProtocolBufferException("Protocol message contained an invalid tag (zero).");
    }

    /* renamed from: e */
    static InvalidProtocolBufferException m346e() {
        return new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
    }

    /* renamed from: f */
    static InvalidProtocolBufferException m347f() {
        return new InvalidProtocolBufferException("Protocol message tag had invalid wire type.");
    }

    /* renamed from: g */
    static InvalidProtocolBufferException m348g() {
        return new InvalidProtocolBufferException("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    /* renamed from: h */
    static InvalidProtocolBufferException m349h() {
        return new InvalidProtocolBufferException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }
}
