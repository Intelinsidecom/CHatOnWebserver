package com.sec.p013a.p014a.p015a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.u */
/* loaded from: classes.dex */
public final class C0256u extends GeneratedMessageLite implements InterfaceC0258w {

    /* renamed from: a */
    private static final C0256u f608a = new C0256u(true);

    /* renamed from: b */
    private List<C0253r> f609b;

    /* renamed from: c */
    private byte f610c;

    /* renamed from: d */
    private int f611d;

    private C0256u(C0257v c0257v) {
        super(c0257v);
        this.f610c = (byte) -1;
        this.f611d = -1;
    }

    private C0256u(boolean z) {
        this.f610c = (byte) -1;
        this.f611d = -1;
    }

    /* renamed from: a */
    public static C0256u m1033a() {
        return f608a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0256u getDefaultInstanceForType() {
        return f608a;
    }

    /* renamed from: c */
    public List<C0253r> m1040c() {
        return this.f609b;
    }

    /* renamed from: d */
    public int m1041d() {
        return this.f609b.size();
    }

    /* renamed from: g */
    private void m1038g() {
        this.f609b = Collections.emptyList();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f610c;
        if (b != -1) {
            return b == 1;
        }
        this.f610c = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f609b.size()) {
                codedOutputStream.writeMessage(1, this.f609b.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeMessageSize = this.f611d;
        if (iComputeMessageSize == -1) {
            iComputeMessageSize = 0;
            for (int i = 0; i < this.f609b.size(); i++) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(1, this.f609b.get(i));
            }
            this.f611d = iComputeMessageSize;
        }
        return iComputeMessageSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0256u m1034a(byte[] bArr) {
        return ((C0257v) newBuilder().mergeFrom(bArr)).m1048i();
    }

    public static C0257v newBuilder() {
        return C0257v.m1047h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0257v newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0257v m1035a(C0256u c0256u) {
        return newBuilder().mergeFrom(c0256u);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public C0257v toBuilder() {
        return m1035a(this);
    }

    static {
        f608a.m1038g();
    }
}
