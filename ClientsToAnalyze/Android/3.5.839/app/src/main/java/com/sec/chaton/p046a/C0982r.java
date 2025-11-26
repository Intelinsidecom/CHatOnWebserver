package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.r */
/* loaded from: classes.dex */
public final class C0982r extends GeneratedMessageLite implements InterfaceC0984t {

    /* renamed from: a */
    private static final C0982r f3208a = new C0982r(true);

    /* renamed from: b */
    private int f3209b;

    /* renamed from: c */
    private List<C0988x> f3210c;

    /* renamed from: d */
    private Object f3211d;

    /* renamed from: e */
    private long f3212e;

    /* renamed from: f */
    private byte f3213f;

    /* renamed from: g */
    private int f3214g;

    private C0982r(C0983s c0983s) {
        super(c0983s);
        this.f3213f = (byte) -1;
        this.f3214g = -1;
    }

    private C0982r(boolean z) {
        this.f3213f = (byte) -1;
        this.f3214g = -1;
    }

    /* renamed from: a */
    public static C0982r m5925a() {
        return f3208a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0982r getDefaultInstanceForType() {
        return f3208a;
    }

    /* renamed from: c */
    public List<C0988x> m5935c() {
        return this.f3210c;
    }

    /* renamed from: d */
    public int m5936d() {
        return this.f3210c.size();
    }

    /* renamed from: a */
    public C0988x m5933a(int i) {
        return this.f3210c.get(i);
    }

    /* renamed from: e */
    public boolean m5937e() {
        return (this.f3209b & 1) == 1;
    }

    /* renamed from: f */
    public String m5938f() {
        Object obj = this.f3211d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f3211d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: k */
    private ByteString m5931k() {
        Object obj = this.f3211d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f3211d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m5939g() {
        return (this.f3209b & 2) == 2;
    }

    /* renamed from: h */
    public long m5940h() {
        return this.f3212e;
    }

    /* renamed from: l */
    private void m5932l() {
        this.f3210c = Collections.emptyList();
        this.f3211d = "";
        this.f3212e = 0L;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f3213f;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f3213f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f3210c.size()) {
                break;
            }
            codedOutputStream.writeMessage(1, this.f3210c.get(i2));
            i = i2 + 1;
        }
        if ((this.f3209b & 1) == 1) {
            codedOutputStream.writeBytes(2, m5931k());
        }
        if ((this.f3209b & 2) == 2) {
            codedOutputStream.writeInt64(3, this.f3212e);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f3214g;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = 0;
            for (int i = 0; i < this.f3210c.size(); i++) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(1, this.f3210c.get(i));
            }
            if ((this.f3209b & 1) == 1) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(2, m5931k());
            }
            if ((this.f3209b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(3, this.f3212e);
            }
            this.f3214g = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0982r m5926a(byte[] bArr) {
        return ((C0983s) newBuilder().mergeFrom(bArr)).m5947i();
    }

    public static C0983s newBuilder() {
        return C0983s.m5946h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0983s newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0983s m5927a(C0982r c0982r) {
        return newBuilder().mergeFrom(c0982r);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0983s toBuilder() {
        return m5927a(this);
    }

    static {
        f3208a.m5932l();
    }
}
