package com.sec.chaton.p015b;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import java.io.IOException;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.at */
/* loaded from: classes.dex */
public final class C0280at extends GeneratedMessageLite implements InterfaceC0351y {

    /* renamed from: a */
    private static final C0280at f734a = new C0280at(true);

    /* renamed from: b */
    private int f735b;

    /* renamed from: c */
    private long f736c;

    /* renamed from: d */
    private LazyStringList f737d;

    /* renamed from: e */
    private byte f738e;

    /* renamed from: f */
    private int f739f;

    private C0280at(C0310bw c0310bw) {
        super(c0310bw);
        this.f738e = (byte) -1;
        this.f739f = -1;
    }

    private C0280at(boolean z) {
        this.f738e = (byte) -1;
        this.f739f = -1;
    }

    /* renamed from: a */
    public static C0280at m1215a() {
        return f734a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0280at getDefaultInstanceForType() {
        return f734a;
    }

    /* renamed from: c */
    public boolean m1221c() {
        return (this.f735b & 1) == 1;
    }

    /* renamed from: d */
    public long m1222d() {
        return this.f736c;
    }

    /* renamed from: e */
    public List m1223e() {
        return this.f737d;
    }

    /* renamed from: h */
    private void m1219h() {
        this.f736c = 0L;
        this.f737d = LazyStringArrayList.EMPTY;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f738e;
        if (b != -1) {
            return b == 1;
        }
        this.f738e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f735b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f736c);
        }
        for (int i = 0; i < this.f737d.size(); i++) {
            codedOutputStream.writeBytes(2, this.f737d.getByteString(i));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.f739f;
        if (i == -1) {
            int iComputeInt64Size = (this.f735b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f736c) + 0 : 0;
            int iComputeBytesSizeNoTag = 0;
            for (int i2 = 0; i2 < this.f737d.size(); i2++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f737d.getByteString(i2));
            }
            int size = iComputeInt64Size + iComputeBytesSizeNoTag + (m1223e().size() * 1);
            this.f739f = size;
            return size;
        }
        return i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0280at m1216a(byte[] bArr) {
        return ((C0310bw) newBuilder().mergeFrom(bArr)).m1594i();
    }

    public static C0310bw newBuilder() {
        return C0310bw.m1593h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public C0310bw newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0310bw m1217a(C0280at c0280at) {
        return newBuilder().mergeFrom(c0280at);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0310bw toBuilder() {
        return m1217a(this);
    }

    static {
        f734a.m1219h();
    }
}
