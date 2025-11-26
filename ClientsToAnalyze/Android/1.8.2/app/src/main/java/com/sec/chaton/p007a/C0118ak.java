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
/* renamed from: com.sec.chaton.a.ak */
/* loaded from: classes.dex */
public final class C0118ak extends GeneratedMessageLite implements InterfaceC0120am {

    /* renamed from: a */
    private static final C0118ak f397a = new C0118ak(true);

    /* renamed from: b */
    private int f398b;

    /* renamed from: c */
    private Object f399c;

    /* renamed from: d */
    private EnumC0116ai f400d;

    /* renamed from: e */
    private List f401e;

    /* renamed from: f */
    private Object f402f;

    /* renamed from: g */
    private boolean f403g;

    /* renamed from: h */
    private byte f404h;

    /* renamed from: i */
    private int f405i;

    private C0118ak(C0119al c0119al) {
        super(c0119al);
        this.f404h = (byte) -1;
        this.f405i = -1;
    }

    private C0118ak(boolean z) {
        this.f404h = (byte) -1;
        this.f405i = -1;
    }

    /* renamed from: a */
    public static C0118ak m817a() {
        return f397a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0118ak getDefaultInstanceForType() {
        return f397a;
    }

    /* renamed from: c */
    public boolean m830c() {
        return (this.f398b & 1) == 1;
    }

    /* renamed from: d */
    public String m831d() {
        Object obj = this.f399c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f399c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: o */
    private ByteString m825o() {
        Object obj = this.f399c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f399c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m832e() {
        return (this.f398b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0116ai m833f() {
        return this.f400d;
    }

    /* renamed from: g */
    public List m834g() {
        return this.f401e;
    }

    /* renamed from: h */
    public int m835h() {
        return this.f401e.size();
    }

    /* renamed from: a */
    public C0144bj m828a(int i) {
        return (C0144bj) this.f401e.get(i);
    }

    /* renamed from: i */
    public boolean m836i() {
        return (this.f398b & 4) == 4;
    }

    /* renamed from: j */
    public String m837j() {
        Object obj = this.f402f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f402f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: p */
    private ByteString m826p() {
        Object obj = this.f402f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f402f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m838k() {
        return (this.f398b & 8) == 8;
    }

    /* renamed from: l */
    public boolean m839l() {
        return this.f403g;
    }

    /* renamed from: q */
    private void m827q() {
        this.f399c = "";
        this.f400d = EnumC0116ai.SINGLE;
        this.f401e = Collections.emptyList();
        this.f402f = "";
        this.f403g = false;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f404h;
        if (b != -1) {
            return b == 1;
        }
        this.f404h = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f398b & 1) == 1) {
            codedOutputStream.writeBytes(1, m825o());
        }
        if ((this.f398b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f400d.getNumber());
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f401e.size()) {
                break;
            }
            codedOutputStream.writeMessage(3, (MessageLite) this.f401e.get(i2));
            i = i2 + 1;
        }
        if ((this.f398b & 4) == 4) {
            codedOutputStream.writeBytes(4, m826p());
        }
        if ((this.f398b & 8) == 8) {
            codedOutputStream.writeBool(5, this.f403g);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = 0;
        int iComputeBoolSize = this.f405i;
        if (iComputeBoolSize == -1) {
            int iComputeBytesSize = (this.f398b & 1) == 1 ? CodedOutputStream.computeBytesSize(1, m825o()) + 0 : 0;
            if ((this.f398b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeEnumSize(2, this.f400d.getNumber());
            }
            while (true) {
                iComputeBoolSize = iComputeBytesSize;
                if (i >= this.f401e.size()) {
                    break;
                }
                iComputeBytesSize = CodedOutputStream.computeMessageSize(3, (MessageLite) this.f401e.get(i)) + iComputeBoolSize;
                i++;
            }
            if ((this.f398b & 4) == 4) {
                iComputeBoolSize += CodedOutputStream.computeBytesSize(4, m826p());
            }
            if ((this.f398b & 8) == 8) {
                iComputeBoolSize += CodedOutputStream.computeBoolSize(5, this.f403g);
            }
            this.f405i = iComputeBoolSize;
        }
        return iComputeBoolSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0118ak m818a(byte[] bArr) {
        return ((C0119al) newBuilder().mergeFrom(bArr)).m846i();
    }

    public static C0119al newBuilder() {
        return C0119al.m845h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public C0119al newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0119al m819a(C0118ak c0118ak) {
        return newBuilder().mergeFrom(c0118ak);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public C0119al toBuilder() {
        return m819a(this);
    }

    static {
        f397a.m827q();
    }
}
