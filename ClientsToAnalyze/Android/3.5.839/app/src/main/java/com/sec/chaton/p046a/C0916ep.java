package com.sec.chaton.p046a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import java.io.IOException;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ep */
/* loaded from: classes.dex */
public final class C0916ep extends GeneratedMessageLite implements InterfaceC0918er {

    /* renamed from: a */
    private static final C0916ep f2865a = new C0916ep(true);

    /* renamed from: b */
    private int f2866b;

    /* renamed from: c */
    private long f2867c;

    /* renamed from: d */
    private LazyStringList f2868d;

    /* renamed from: e */
    private byte f2869e;

    /* renamed from: f */
    private int f2870f;

    private C0916ep(C0917eq c0917eq) {
        super(c0917eq);
        this.f2869e = (byte) -1;
        this.f2870f = -1;
    }

    private C0916ep(boolean z) {
        this.f2869e = (byte) -1;
        this.f2870f = -1;
    }

    /* renamed from: a */
    public static C0916ep m4954a() {
        return f2865a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0916ep getDefaultInstanceForType() {
        return f2865a;
    }

    /* renamed from: c */
    public boolean m4960c() {
        return (this.f2866b & 1) == 1;
    }

    /* renamed from: d */
    public long m4961d() {
        return this.f2867c;
    }

    /* renamed from: e */
    public List<String> m4962e() {
        return this.f2868d;
    }

    /* renamed from: h */
    private void m4958h() {
        this.f2867c = 0L;
        this.f2868d = LazyStringArrayList.EMPTY;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2869e;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2869e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2866b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f2867c);
        }
        for (int i = 0; i < this.f2868d.size(); i++) {
            codedOutputStream.writeBytes(2, this.f2868d.getByteString(i));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.f2870f;
        if (i == -1) {
            int iComputeInt64Size = (this.f2866b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f2867c) + 0 : 0;
            int iComputeBytesSizeNoTag = 0;
            for (int i2 = 0; i2 < this.f2868d.size(); i2++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f2868d.getByteString(i2));
            }
            int size = iComputeInt64Size + iComputeBytesSizeNoTag + (m4962e().size() * 1);
            this.f2870f = size;
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
    public static C0916ep m4955a(byte[] bArr) {
        return ((C0917eq) newBuilder().mergeFrom(bArr)).m4969i();
    }

    public static C0917eq newBuilder() {
        return C0917eq.m4968h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public C0917eq newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0917eq m4956a(C0916ep c0916ep) {
        return newBuilder().mergeFrom(c0916ep);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0917eq toBuilder() {
        return m4956a(this);
    }

    static {
        f2865a.m4958h();
    }
}
