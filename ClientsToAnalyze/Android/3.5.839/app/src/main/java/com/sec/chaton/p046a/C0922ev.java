package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ev */
/* loaded from: classes.dex */
public final class C0922ev extends GeneratedMessageLite implements InterfaceC0924ex {

    /* renamed from: a */
    private static final C0922ev f2880a = new C0922ev(true);

    /* renamed from: b */
    private int f2881b;

    /* renamed from: c */
    private Object f2882c;

    /* renamed from: d */
    private List<C0925ey> f2883d;

    /* renamed from: e */
    private long f2884e;

    /* renamed from: f */
    private byte f2885f;

    /* renamed from: g */
    private int f2886g;

    private C0922ev(C0923ew c0923ew) {
        super(c0923ew);
        this.f2885f = (byte) -1;
        this.f2886g = -1;
    }

    private C0922ev(boolean z) {
        this.f2885f = (byte) -1;
        this.f2886g = -1;
    }

    /* renamed from: a */
    public static C0922ev m5002a() {
        return f2880a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0922ev getDefaultInstanceForType() {
        return f2880a;
    }

    /* renamed from: c */
    public boolean m5011c() {
        return (this.f2881b & 1) == 1;
    }

    /* renamed from: d */
    public String m5012d() {
        Object obj = this.f2882c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2882c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: j */
    private ByteString m5008j() {
        Object obj = this.f2882c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2882c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public List<C0925ey> m5013e() {
        return this.f2883d;
    }

    /* renamed from: f */
    public boolean m5014f() {
        return (this.f2881b & 2) == 2;
    }

    /* renamed from: g */
    public long m5015g() {
        return this.f2884e;
    }

    /* renamed from: k */
    private void m5009k() {
        this.f2882c = "";
        this.f2883d = Collections.emptyList();
        this.f2884e = 0L;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2885f;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2885f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2881b & 1) == 1) {
            codedOutputStream.writeBytes(1, m5008j());
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f2883d.size()) {
                break;
            }
            codedOutputStream.writeMessage(2, this.f2883d.get(i2));
            i = i2 + 1;
        }
        if ((this.f2881b & 2) == 2) {
            codedOutputStream.writeInt64(3, this.f2884e);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = 0;
        int iComputeInt64Size = this.f2886g;
        if (iComputeInt64Size == -1) {
            int iComputeBytesSize = (this.f2881b & 1) == 1 ? CodedOutputStream.computeBytesSize(1, m5008j()) + 0 : 0;
            while (true) {
                iComputeInt64Size = iComputeBytesSize;
                if (i >= this.f2883d.size()) {
                    break;
                }
                iComputeBytesSize = CodedOutputStream.computeMessageSize(2, this.f2883d.get(i)) + iComputeInt64Size;
                i++;
            }
            if ((this.f2881b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(3, this.f2884e);
            }
            this.f2886g = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0922ev m5003a(byte[] bArr) {
        return ((C0923ew) newBuilder().mergeFrom(bArr)).m5022i();
    }

    public static C0923ew newBuilder() {
        return C0923ew.m5021h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0923ew newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0923ew m5004a(C0922ev c0922ev) {
        return newBuilder().mergeFrom(c0922ev);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0923ew toBuilder() {
        return m5004a(this);
    }

    static {
        f2880a.m5009k();
    }
}
