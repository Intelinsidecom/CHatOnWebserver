package com.sec.chaton.p016a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import java.io.IOException;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.df */
/* loaded from: classes.dex */
public final class C0363df extends GeneratedMessageLite implements InterfaceC0365dh {

    /* renamed from: a */
    private static final C0363df f1263a = new C0363df(true);

    /* renamed from: b */
    private int f1264b;

    /* renamed from: c */
    private long f1265c;

    /* renamed from: d */
    private LazyStringList f1266d;

    /* renamed from: e */
    private byte f1267e;

    /* renamed from: f */
    private int f1268f;

    private C0363df(C0364dg c0364dg) {
        super(c0364dg);
        this.f1267e = (byte) -1;
        this.f1268f = -1;
    }

    private C0363df(boolean z) {
        this.f1267e = (byte) -1;
        this.f1268f = -1;
    }

    /* renamed from: a */
    public static C0363df m2437a() {
        return f1263a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0363df getDefaultInstanceForType() {
        return f1263a;
    }

    /* renamed from: c */
    public boolean m2443c() {
        return (this.f1264b & 1) == 1;
    }

    /* renamed from: d */
    public long m2444d() {
        return this.f1265c;
    }

    /* renamed from: e */
    public List<String> m2445e() {
        return this.f1266d;
    }

    /* renamed from: h */
    private void m2441h() {
        this.f1265c = 0L;
        this.f1266d = LazyStringArrayList.EMPTY;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f1267e;
        if (b != -1) {
            return b == 1;
        }
        this.f1267e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1264b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f1265c);
        }
        for (int i = 0; i < this.f1266d.size(); i++) {
            codedOutputStream.writeBytes(2, this.f1266d.getByteString(i));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.f1268f;
        if (i == -1) {
            int iComputeInt64Size = (this.f1264b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f1265c) + 0 : 0;
            int iComputeBytesSizeNoTag = 0;
            for (int i2 = 0; i2 < this.f1266d.size(); i2++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f1266d.getByteString(i2));
            }
            int size = iComputeInt64Size + iComputeBytesSizeNoTag + (m2445e().size() * 1);
            this.f1268f = size;
            return size;
        }
        return i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0363df m2438a(byte[] bArr) {
        return ((C0364dg) newBuilder().mergeFrom(bArr)).m2452i();
    }

    public static C0364dg newBuilder() {
        return C0364dg.m2451h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public C0364dg newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0364dg m2439a(C0363df c0363df) {
        return newBuilder().mergeFrom(c0363df);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0364dg toBuilder() {
        return m2439a(this);
    }

    static {
        f1263a.m2441h();
    }
}
