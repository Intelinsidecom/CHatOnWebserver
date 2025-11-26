package com.sec.chaton.p046a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.em */
/* loaded from: classes.dex */
public final class C0913em extends GeneratedMessageLite implements InterfaceC0915eo {

    /* renamed from: a */
    private static final C0913em f2854a = new C0913em(true);

    /* renamed from: b */
    private int f2855b;

    /* renamed from: c */
    private long f2856c;

    /* renamed from: d */
    private List<C0910ej> f2857d;

    /* renamed from: e */
    private C0935fh f2858e;

    /* renamed from: f */
    private byte f2859f;

    /* renamed from: g */
    private int f2860g;

    private C0913em(C0914en c0914en) {
        super(c0914en);
        this.f2859f = (byte) -1;
        this.f2860g = -1;
    }

    private C0913em(boolean z) {
        this.f2859f = (byte) -1;
        this.f2860g = -1;
    }

    /* renamed from: a */
    public static C0913em m4918a() {
        return f2854a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0913em getDefaultInstanceForType() {
        return f2854a;
    }

    /* renamed from: c */
    public boolean m4926c() {
        return (this.f2855b & 1) == 1;
    }

    /* renamed from: d */
    public long m4927d() {
        return this.f2856c;
    }

    /* renamed from: e */
    public boolean m4928e() {
        return (this.f2855b & 2) == 2;
    }

    /* renamed from: f */
    public C0935fh m4929f() {
        return this.f2858e;
    }

    /* renamed from: i */
    private void m4924i() {
        this.f2856c = 0L;
        this.f2857d = Collections.emptyList();
        this.f2858e = C0935fh.m5211a();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2859f;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2859f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2855b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f2856c);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f2857d.size()) {
                break;
            }
            codedOutputStream.writeMessage(2, this.f2857d.get(i2));
            i = i2 + 1;
        }
        if ((this.f2855b & 2) == 2) {
            codedOutputStream.writeMessage(3, this.f2858e);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = 0;
        int iComputeMessageSize = this.f2860g;
        if (iComputeMessageSize == -1) {
            int iComputeInt64Size = (this.f2855b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f2856c) + 0 : 0;
            while (true) {
                iComputeMessageSize = iComputeInt64Size;
                if (i >= this.f2857d.size()) {
                    break;
                }
                iComputeInt64Size = CodedOutputStream.computeMessageSize(2, this.f2857d.get(i)) + iComputeMessageSize;
                i++;
            }
            if ((this.f2855b & 2) == 2) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(3, this.f2858e);
            }
            this.f2860g = iComputeMessageSize;
        }
        return iComputeMessageSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0913em m4919a(byte[] bArr) {
        return ((C0914en) newBuilder().mergeFrom(bArr)).m4936k();
    }

    public static C0914en newBuilder() {
        return C0914en.m4935j();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0914en newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0914en m4920a(C0913em c0913em) {
        return newBuilder().mergeFrom(c0913em);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0914en toBuilder() {
        return m4920a(this);
    }

    static {
        f2854a.m4924i();
    }
}
