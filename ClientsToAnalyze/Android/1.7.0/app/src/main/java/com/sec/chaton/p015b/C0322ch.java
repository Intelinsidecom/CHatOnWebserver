package com.sec.chaton.p015b;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLite;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.ch */
/* loaded from: classes.dex */
public final class C0322ch extends GeneratedMessageLite implements InterfaceC0345s {

    /* renamed from: a */
    private static final C0322ch f908a = new C0322ch(true);

    /* renamed from: b */
    private List f909b;

    /* renamed from: c */
    private byte f910c;

    /* renamed from: d */
    private int f911d;

    private C0322ch(C0307bt c0307bt) {
        super(c0307bt);
        this.f910c = (byte) -1;
        this.f911d = -1;
    }

    private C0322ch(boolean z) {
        this.f910c = (byte) -1;
        this.f911d = -1;
    }

    /* renamed from: a */
    public static C0322ch m1739a() {
        return f908a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0322ch getDefaultInstanceForType() {
        return f908a;
    }

    /* renamed from: c */
    public List m1746c() {
        return this.f909b;
    }

    /* renamed from: d */
    public int m1747d() {
        return this.f909b.size();
    }

    /* renamed from: a */
    public C0344r m1744a(int i) {
        return (C0344r) this.f909b.get(i);
    }

    /* renamed from: g */
    private void m1743g() {
        this.f909b = Collections.emptyList();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f910c;
        if (b != -1) {
            return b == 1;
        }
        this.f910c = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f909b.size()) {
                codedOutputStream.writeMessage(1, (MessageLite) this.f909b.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeMessageSize = this.f911d;
        if (iComputeMessageSize == -1) {
            iComputeMessageSize = 0;
            for (int i = 0; i < this.f909b.size(); i++) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(1, (MessageLite) this.f909b.get(i));
            }
            this.f911d = iComputeMessageSize;
        }
        return iComputeMessageSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0322ch m1740a(byte[] bArr) {
        return ((C0307bt) newBuilder().mergeFrom(bArr)).m1540i();
    }

    public static C0307bt newBuilder() {
        return C0307bt.m1539h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0307bt newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0307bt m1738a(C0322ch c0322ch) {
        return newBuilder().mergeFrom(c0322ch);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public C0307bt toBuilder() {
        return m1738a(this);
    }

    static {
        f908a.m1743g();
    }
}
