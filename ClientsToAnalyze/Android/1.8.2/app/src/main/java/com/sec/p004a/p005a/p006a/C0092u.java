package com.sec.p004a.p005a.p006a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLite;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.u */
/* loaded from: classes.dex */
public final class C0092u extends GeneratedMessageLite implements InterfaceC0094w {

    /* renamed from: a */
    private static final C0092u f185a = new C0092u(true);

    /* renamed from: b */
    private List f186b;

    /* renamed from: c */
    private byte f187c;

    /* renamed from: d */
    private int f188d;

    private C0092u(C0093v c0093v) {
        super(c0093v);
        this.f187c = (byte) -1;
        this.f188d = -1;
    }

    private C0092u(boolean z) {
        this.f187c = (byte) -1;
        this.f188d = -1;
    }

    /* renamed from: a */
    public static C0092u m521a() {
        return f185a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0092u getDefaultInstanceForType() {
        return f185a;
    }

    /* renamed from: c */
    public List m528c() {
        return this.f186b;
    }

    /* renamed from: d */
    public int m529d() {
        return this.f186b.size();
    }

    /* renamed from: g */
    private void m526g() {
        this.f186b = Collections.emptyList();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f187c;
        if (b != -1) {
            return b == 1;
        }
        this.f187c = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f186b.size()) {
                codedOutputStream.writeMessage(1, (MessageLite) this.f186b.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeMessageSize = this.f188d;
        if (iComputeMessageSize == -1) {
            iComputeMessageSize = 0;
            for (int i = 0; i < this.f186b.size(); i++) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(1, (MessageLite) this.f186b.get(i));
            }
            this.f188d = iComputeMessageSize;
        }
        return iComputeMessageSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0092u m522a(byte[] bArr) {
        return ((C0093v) newBuilder().mergeFrom(bArr)).m536i();
    }

    public static C0093v newBuilder() {
        return C0093v.m535h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0093v newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0093v m523a(C0092u c0092u) {
        return newBuilder().mergeFrom(c0092u);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public C0093v toBuilder() {
        return m523a(this);
    }

    static {
        f185a.m526g();
    }
}
