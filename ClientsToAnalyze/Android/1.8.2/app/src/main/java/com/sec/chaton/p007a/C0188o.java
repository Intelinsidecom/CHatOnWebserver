package com.sec.chaton.p007a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLite;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.o */
/* loaded from: classes.dex */
public final class C0188o extends GeneratedMessageLite implements InterfaceC0190q {

    /* renamed from: a */
    private static final C0188o f687a = new C0188o(true);

    /* renamed from: b */
    private List f688b;

    /* renamed from: c */
    private byte f689c;

    /* renamed from: d */
    private int f690d;

    private C0188o(C0189p c0189p) {
        super(c0189p);
        this.f689c = (byte) -1;
        this.f690d = -1;
    }

    private C0188o(boolean z) {
        this.f689c = (byte) -1;
        this.f690d = -1;
    }

    /* renamed from: a */
    public static C0188o m1668a() {
        return f687a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0188o getDefaultInstanceForType() {
        return f687a;
    }

    /* renamed from: c */
    public List m1676c() {
        return this.f688b;
    }

    /* renamed from: d */
    public int m1677d() {
        return this.f688b.size();
    }

    /* renamed from: a */
    public C0194u m1674a(int i) {
        return (C0194u) this.f688b.get(i);
    }

    /* renamed from: g */
    private void m1673g() {
        this.f688b = Collections.emptyList();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f689c;
        if (b != -1) {
            return b == 1;
        }
        this.f689c = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f688b.size()) {
                codedOutputStream.writeMessage(1, (MessageLite) this.f688b.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeMessageSize = this.f690d;
        if (iComputeMessageSize == -1) {
            iComputeMessageSize = 0;
            for (int i = 0; i < this.f688b.size(); i++) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(1, (MessageLite) this.f688b.get(i));
            }
            this.f690d = iComputeMessageSize;
        }
        return iComputeMessageSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0188o m1669a(byte[] bArr) {
        return ((C0189p) newBuilder().mergeFrom(bArr)).m1684i();
    }

    public static C0189p newBuilder() {
        return C0189p.m1683h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0189p newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0189p m1670a(C0188o c0188o) {
        return newBuilder().mergeFrom(c0188o);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public C0189p toBuilder() {
        return m1670a(this);
    }

    static {
        f687a.m1673g();
    }
}
