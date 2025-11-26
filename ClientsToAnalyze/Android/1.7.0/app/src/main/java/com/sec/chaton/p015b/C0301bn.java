package com.sec.chaton.p015b;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLite;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.bn */
/* loaded from: classes.dex */
public final class C0301bn extends GeneratedMessageLite implements InterfaceC0350x {

    /* renamed from: a */
    private static final C0301bn f813a = new C0301bn(true);

    /* renamed from: b */
    private int f814b;

    /* renamed from: c */
    private long f815c;

    /* renamed from: d */
    private List f816d;

    /* renamed from: e */
    private C0313bz f817e;

    /* renamed from: f */
    private byte f818f;

    /* renamed from: g */
    private int f819g;

    private C0301bn(C0293bf c0293bf) {
        super(c0293bf);
        this.f818f = (byte) -1;
        this.f819g = -1;
    }

    private C0301bn(boolean z) {
        this.f818f = (byte) -1;
        this.f819g = -1;
    }

    /* renamed from: a */
    public static C0301bn m1432a() {
        return f813a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0301bn getDefaultInstanceForType() {
        return f813a;
    }

    /* renamed from: c */
    public boolean m1439c() {
        return (this.f814b & 1) == 1;
    }

    /* renamed from: d */
    public long m1440d() {
        return this.f815c;
    }

    /* renamed from: e */
    public boolean m1441e() {
        return (this.f814b & 2) == 2;
    }

    /* renamed from: f */
    public C0313bz m1442f() {
        return this.f817e;
    }

    /* renamed from: i */
    private void m1437i() {
        this.f815c = 0L;
        this.f816d = Collections.emptyList();
        this.f817e = C0313bz.m1619a();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f818f;
        if (b != -1) {
            return b == 1;
        }
        this.f818f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f814b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f815c);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f816d.size()) {
                break;
            }
            codedOutputStream.writeMessage(2, (MessageLite) this.f816d.get(i2));
            i = i2 + 1;
        }
        if ((this.f814b & 2) == 2) {
            codedOutputStream.writeMessage(3, this.f817e);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = 0;
        int iComputeMessageSize = this.f819g;
        if (iComputeMessageSize == -1) {
            int iComputeInt64Size = (this.f814b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f815c) + 0 : 0;
            while (true) {
                iComputeMessageSize = iComputeInt64Size;
                if (i >= this.f816d.size()) {
                    break;
                }
                iComputeInt64Size = CodedOutputStream.computeMessageSize(2, (MessageLite) this.f816d.get(i)) + iComputeMessageSize;
                i++;
            }
            if ((this.f814b & 2) == 2) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(3, this.f817e);
            }
            this.f819g = iComputeMessageSize;
        }
        return iComputeMessageSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0301bn m1433a(byte[] bArr) {
        return ((C0293bf) newBuilder().mergeFrom(bArr)).m1301k();
    }

    public static C0293bf newBuilder() {
        return C0293bf.m1300j();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0293bf newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0293bf m1431a(C0301bn c0301bn) {
        return newBuilder().mergeFrom(c0301bn);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0293bf toBuilder() {
        return m1431a(this);
    }

    static {
        f813a.m1437i();
    }
}
