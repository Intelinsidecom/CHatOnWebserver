package com.sec.chaton.p007a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLite;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.cd */
/* loaded from: classes.dex */
public final class C0165cd extends GeneratedMessageLite implements InterfaceC0167cf {

    /* renamed from: a */
    private static final C0165cd f601a = new C0165cd(true);

    /* renamed from: b */
    private int f602b;

    /* renamed from: c */
    private long f603c;

    /* renamed from: d */
    private List f604d;

    /* renamed from: e */
    private C0171cj f605e;

    /* renamed from: f */
    private byte f606f;

    /* renamed from: g */
    private int f607g;

    private C0165cd(C0166ce c0166ce) {
        super(c0166ce);
        this.f606f = (byte) -1;
        this.f607g = -1;
    }

    private C0165cd(boolean z) {
        this.f606f = (byte) -1;
        this.f607g = -1;
    }

    /* renamed from: a */
    public static C0165cd m1392a() {
        return f601a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0165cd getDefaultInstanceForType() {
        return f601a;
    }

    /* renamed from: c */
    public boolean m1401c() {
        return (this.f602b & 1) == 1;
    }

    /* renamed from: d */
    public long m1402d() {
        return this.f603c;
    }

    /* renamed from: e */
    public List m1403e() {
        return this.f604d;
    }

    /* renamed from: a */
    public C0162ca m1399a(int i) {
        return (C0162ca) this.f604d.get(i);
    }

    /* renamed from: f */
    public boolean m1404f() {
        return (this.f602b & 2) == 2;
    }

    /* renamed from: g */
    public C0171cj m1405g() {
        return this.f605e;
    }

    /* renamed from: j */
    private void m1398j() {
        this.f603c = 0L;
        this.f604d = Collections.emptyList();
        this.f605e = C0171cj.m1459a();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f606f;
        if (b != -1) {
            return b == 1;
        }
        this.f606f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f602b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f603c);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f604d.size()) {
                break;
            }
            codedOutputStream.writeMessage(2, (MessageLite) this.f604d.get(i2));
            i = i2 + 1;
        }
        if ((this.f602b & 2) == 2) {
            codedOutputStream.writeMessage(3, this.f605e);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = 0;
        int iComputeMessageSize = this.f607g;
        if (iComputeMessageSize == -1) {
            int iComputeInt64Size = (this.f602b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f603c) + 0 : 0;
            while (true) {
                iComputeMessageSize = iComputeInt64Size;
                if (i >= this.f604d.size()) {
                    break;
                }
                iComputeInt64Size = CodedOutputStream.computeMessageSize(2, (MessageLite) this.f604d.get(i)) + iComputeMessageSize;
                i++;
            }
            if ((this.f602b & 2) == 2) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(3, this.f605e);
            }
            this.f607g = iComputeMessageSize;
        }
        return iComputeMessageSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0165cd m1393a(byte[] bArr) {
        return ((C0166ce) newBuilder().mergeFrom(bArr)).m1412k();
    }

    public static C0166ce newBuilder() {
        return C0166ce.m1411j();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0166ce newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0166ce m1394a(C0165cd c0165cd) {
        return newBuilder().mergeFrom(c0165cd);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0166ce toBuilder() {
        return m1394a(this);
    }

    static {
        f601a.m1398j();
    }
}
