package com.sec.p004a.p005a.p006a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLite;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.ak */
/* loaded from: classes.dex */
public final class C0077ak extends GeneratedMessageLite implements InterfaceC0100s {

    /* renamed from: a */
    private static final C0077ak f95a = new C0077ak(true);

    /* renamed from: b */
    private List f96b;

    /* renamed from: c */
    private byte f97c;

    /* renamed from: d */
    private int f98d;

    private C0077ak(C0095n c0095n) {
        super(c0095n);
        this.f97c = (byte) -1;
        this.f98d = -1;
    }

    private C0077ak(boolean z) {
        this.f97c = (byte) -1;
        this.f98d = -1;
    }

    /* renamed from: a */
    public static C0077ak m265a() {
        return f95a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0077ak getDefaultInstanceForType() {
        return f95a;
    }

    /* renamed from: c */
    public List m272c() {
        return this.f96b;
    }

    /* renamed from: d */
    public int m273d() {
        return this.f96b.size();
    }

    /* renamed from: g */
    private void m270g() {
        this.f96b = Collections.emptyList();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f97c;
        if (b != -1) {
            return b == 1;
        }
        this.f97c = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f96b.size()) {
                codedOutputStream.writeMessage(1, (MessageLite) this.f96b.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeMessageSize = this.f98d;
        if (iComputeMessageSize == -1) {
            iComputeMessageSize = 0;
            for (int i = 0; i < this.f96b.size(); i++) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(1, (MessageLite) this.f96b.get(i));
            }
            this.f98d = iComputeMessageSize;
        }
        return iComputeMessageSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0077ak m266a(byte[] bArr) {
        return ((C0095n) newBuilder().mergeFrom(bArr)).m446i();
    }

    public static C0095n newBuilder() {
        return C0095n.m445h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0095n newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0095n m267a(C0077ak c0077ak) {
        return newBuilder().mergeFrom(c0077ak);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public C0095n toBuilder() {
        return m267a(this);
    }

    static {
        f95a.m270g();
    }
}
