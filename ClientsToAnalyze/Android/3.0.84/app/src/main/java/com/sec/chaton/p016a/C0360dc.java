package com.sec.chaton.p016a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.dc */
/* loaded from: classes.dex */
public final class C0360dc extends GeneratedMessageLite implements InterfaceC0362de {

    /* renamed from: a */
    private static final C0360dc f1252a = new C0360dc(true);

    /* renamed from: b */
    private int f1253b;

    /* renamed from: c */
    private long f1254c;

    /* renamed from: d */
    private List<C0356cz> f1255d;

    /* renamed from: e */
    private C0369dl f1256e;

    /* renamed from: f */
    private byte f1257f;

    /* renamed from: g */
    private int f1258g;

    private C0360dc(C0361dd c0361dd) {
        super(c0361dd);
        this.f1257f = (byte) -1;
        this.f1258g = -1;
    }

    private C0360dc(boolean z) {
        this.f1257f = (byte) -1;
        this.f1258g = -1;
    }

    /* renamed from: a */
    public static C0360dc m2401a() {
        return f1252a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0360dc getDefaultInstanceForType() {
        return f1252a;
    }

    /* renamed from: c */
    public boolean m2409c() {
        return (this.f1253b & 1) == 1;
    }

    /* renamed from: d */
    public long m2410d() {
        return this.f1254c;
    }

    /* renamed from: e */
    public boolean m2411e() {
        return (this.f1253b & 2) == 2;
    }

    /* renamed from: f */
    public C0369dl m2412f() {
        return this.f1256e;
    }

    /* renamed from: i */
    private void m2407i() {
        this.f1254c = 0L;
        this.f1255d = Collections.emptyList();
        this.f1256e = C0369dl.m2485a();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f1257f;
        if (b != -1) {
            return b == 1;
        }
        this.f1257f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1253b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f1254c);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f1255d.size()) {
                break;
            }
            codedOutputStream.writeMessage(2, this.f1255d.get(i2));
            i = i2 + 1;
        }
        if ((this.f1253b & 2) == 2) {
            codedOutputStream.writeMessage(3, this.f1256e);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = 0;
        int iComputeMessageSize = this.f1258g;
        if (iComputeMessageSize == -1) {
            int iComputeInt64Size = (this.f1253b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f1254c) + 0 : 0;
            while (true) {
                iComputeMessageSize = iComputeInt64Size;
                if (i >= this.f1255d.size()) {
                    break;
                }
                iComputeInt64Size = CodedOutputStream.computeMessageSize(2, this.f1255d.get(i)) + iComputeMessageSize;
                i++;
            }
            if ((this.f1253b & 2) == 2) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(3, this.f1256e);
            }
            this.f1258g = iComputeMessageSize;
        }
        return iComputeMessageSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0360dc m2402a(byte[] bArr) {
        return ((C0361dd) newBuilder().mergeFrom(bArr)).m2419k();
    }

    public static C0361dd newBuilder() {
        return C0361dd.m2418j();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0361dd newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0361dd m2403a(C0360dc c0360dc) {
        return newBuilder().mergeFrom(c0360dc);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0361dd toBuilder() {
        return m2403a(this);
    }

    static {
        f1252a.m2407i();
    }
}
