package com.sec.chaton.p016a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.o */
/* loaded from: classes.dex */
public final class C0400o extends GeneratedMessageLite implements InterfaceC0402q {

    /* renamed from: a */
    private static final C0400o f1422a = new C0400o(true);

    /* renamed from: b */
    private List<C0406u> f1423b;

    /* renamed from: c */
    private byte f1424c;

    /* renamed from: d */
    private int f1425d;

    private C0400o(C0401p c0401p) {
        super(c0401p);
        this.f1424c = (byte) -1;
        this.f1425d = -1;
    }

    private C0400o(boolean z) {
        this.f1424c = (byte) -1;
        this.f1425d = -1;
    }

    /* renamed from: a */
    public static C0400o m2899a() {
        return f1422a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0400o getDefaultInstanceForType() {
        return f1422a;
    }

    /* renamed from: c */
    public List<C0406u> m2907c() {
        return this.f1423b;
    }

    /* renamed from: d */
    public int m2908d() {
        return this.f1423b.size();
    }

    /* renamed from: a */
    public C0406u m2905a(int i) {
        return this.f1423b.get(i);
    }

    /* renamed from: g */
    private void m2904g() {
        this.f1423b = Collections.emptyList();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f1424c;
        if (b != -1) {
            return b == 1;
        }
        this.f1424c = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f1423b.size()) {
                codedOutputStream.writeMessage(1, this.f1423b.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeMessageSize = this.f1425d;
        if (iComputeMessageSize == -1) {
            iComputeMessageSize = 0;
            for (int i = 0; i < this.f1423b.size(); i++) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(1, this.f1423b.get(i));
            }
            this.f1425d = iComputeMessageSize;
        }
        return iComputeMessageSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0400o m2900a(byte[] bArr) {
        return ((C0401p) newBuilder().mergeFrom(bArr)).m2915i();
    }

    public static C0401p newBuilder() {
        return C0401p.m2914h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0401p newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0401p m2901a(C0400o c0400o) {
        return newBuilder().mergeFrom(c0400o);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public C0401p toBuilder() {
        return m2901a(this);
    }

    static {
        f1422a.m2904g();
    }
}
