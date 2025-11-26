package com.sec.chaton.p007a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLite;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.an */
/* loaded from: classes.dex */
public final class C0121an extends GeneratedMessageLite implements InterfaceC0126as {

    /* renamed from: a */
    private static final C0121an f412a = new C0121an(true);

    /* renamed from: b */
    private int f413b;

    /* renamed from: c */
    private Object f414c;

    /* renamed from: d */
    private List f415d;

    /* renamed from: e */
    private C0171cj f416e;

    /* renamed from: f */
    private byte f417f;

    /* renamed from: g */
    private int f418g;

    private C0121an(C0122ao c0122ao) {
        super(c0122ao);
        this.f417f = (byte) -1;
        this.f418g = -1;
    }

    private C0121an(boolean z) {
        this.f417f = (byte) -1;
        this.f418g = -1;
    }

    /* renamed from: a */
    public static C0121an m861a() {
        return f412a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0121an getDefaultInstanceForType() {
        return f412a;
    }

    /* renamed from: c */
    public boolean m872c() {
        return (this.f413b & 1) == 1;
    }

    /* renamed from: d */
    public String m873d() {
        Object obj = this.f414c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f414c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: k */
    private ByteString m868k() {
        Object obj = this.f414c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f414c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public List m874e() {
        return this.f415d;
    }

    /* renamed from: f */
    public int m875f() {
        return this.f415d.size();
    }

    /* renamed from: a */
    public C0123ap m870a(int i) {
        return (C0123ap) this.f415d.get(i);
    }

    /* renamed from: g */
    public boolean m876g() {
        return (this.f413b & 2) == 2;
    }

    /* renamed from: h */
    public C0171cj m877h() {
        return this.f416e;
    }

    /* renamed from: l */
    private void m869l() {
        this.f414c = "";
        this.f415d = Collections.emptyList();
        this.f416e = C0171cj.m1459a();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f417f;
        if (b != -1) {
            return b == 1;
        }
        this.f417f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f413b & 1) == 1) {
            codedOutputStream.writeBytes(1, m868k());
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f415d.size()) {
                break;
            }
            codedOutputStream.writeMessage(2, (MessageLite) this.f415d.get(i2));
            i = i2 + 1;
        }
        if ((this.f413b & 2) == 2) {
            codedOutputStream.writeMessage(3, this.f416e);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = 0;
        int iComputeMessageSize = this.f418g;
        if (iComputeMessageSize == -1) {
            int iComputeBytesSize = (this.f413b & 1) == 1 ? CodedOutputStream.computeBytesSize(1, m868k()) + 0 : 0;
            while (true) {
                iComputeMessageSize = iComputeBytesSize;
                if (i >= this.f415d.size()) {
                    break;
                }
                iComputeBytesSize = CodedOutputStream.computeMessageSize(2, (MessageLite) this.f415d.get(i)) + iComputeMessageSize;
                i++;
            }
            if ((this.f413b & 2) == 2) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(3, this.f416e);
            }
            this.f418g = iComputeMessageSize;
        }
        return iComputeMessageSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0121an m862a(byte[] bArr) {
        return ((C0122ao) newBuilder().mergeFrom(bArr)).m884m();
    }

    public static C0122ao newBuilder() {
        return C0122ao.m883l();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0122ao newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0122ao m863a(C0121an c0121an) {
        return newBuilder().mergeFrom(c0121an);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0122ao toBuilder() {
        return m863a(this);
    }

    static {
        f412a.m869l();
    }
}
