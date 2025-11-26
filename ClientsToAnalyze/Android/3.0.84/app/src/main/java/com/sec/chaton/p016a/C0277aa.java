package com.sec.chaton.p016a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.aa */
/* loaded from: classes.dex */
public final class C0277aa extends GeneratedMessageLite implements InterfaceC0279ac {

    /* renamed from: a */
    private static final C0277aa f871a = new C0277aa(true);

    /* renamed from: b */
    private int f872b;

    /* renamed from: c */
    private long f873c;

    /* renamed from: d */
    private Object f874d;

    /* renamed from: e */
    private Object f875e;

    /* renamed from: f */
    private List<C0280ad> f876f;

    /* renamed from: g */
    private byte f877g;

    /* renamed from: h */
    private int f878h;

    private C0277aa(C0278ab c0278ab) {
        super(c0278ab);
        this.f877g = (byte) -1;
        this.f878h = -1;
    }

    private C0277aa(boolean z) {
        this.f877g = (byte) -1;
        this.f878h = -1;
    }

    /* renamed from: a */
    public static C0277aa m1377a() {
        return f871a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0277aa getDefaultInstanceForType() {
        return f871a;
    }

    /* renamed from: c */
    public boolean m1388c() {
        return (this.f872b & 1) == 1;
    }

    /* renamed from: d */
    public long m1389d() {
        return this.f873c;
    }

    /* renamed from: e */
    public boolean m1390e() {
        return (this.f872b & 2) == 2;
    }

    /* renamed from: f */
    public String m1391f() {
        Object obj = this.f874d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f874d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: k */
    private ByteString m1384k() {
        Object obj = this.f874d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f874d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m1392g() {
        return (this.f872b & 4) == 4;
    }

    /* renamed from: h */
    public String m1393h() {
        Object obj = this.f875e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f875e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: l */
    private ByteString m1385l() {
        Object obj = this.f875e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f875e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: m */
    private void m1386m() {
        this.f873c = 0L;
        this.f874d = "";
        this.f875e = "";
        this.f876f = Collections.emptyList();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f877g;
        if (b != -1) {
            return b == 1;
        }
        this.f877g = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f872b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f873c);
        }
        if ((this.f872b & 2) == 2) {
            codedOutputStream.writeBytes(2, m1384k());
        }
        if ((this.f872b & 4) == 4) {
            codedOutputStream.writeBytes(3, m1385l());
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f876f.size()) {
                codedOutputStream.writeMessage(4, this.f876f.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = 0;
        int i2 = this.f878h;
        if (i2 == -1) {
            int iComputeInt64Size = (this.f872b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f873c) + 0 : 0;
            if ((this.f872b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(2, m1384k());
            }
            if ((this.f872b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(3, m1385l());
            }
            while (true) {
                i2 = iComputeInt64Size;
                if (i >= this.f876f.size()) {
                    break;
                }
                iComputeInt64Size = CodedOutputStream.computeMessageSize(4, this.f876f.get(i)) + i2;
                i++;
            }
            this.f878h = i2;
        }
        return i2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0277aa m1378a(byte[] bArr) {
        return ((C0278ab) newBuilder().mergeFrom(bArr)).m1400i();
    }

    public static C0278ab newBuilder() {
        return C0278ab.m1399h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0278ab newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0278ab m1379a(C0277aa c0277aa) {
        return newBuilder().mergeFrom(c0277aa);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0278ab toBuilder() {
        return m1379a(this);
    }

    static {
        f871a.m1386m();
    }
}
