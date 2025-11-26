package com.sec.chaton.p015b;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLite;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.cc */
/* loaded from: classes.dex */
public final class C0317cc extends GeneratedMessageLite implements InterfaceC0338l {

    /* renamed from: a */
    private static final C0317cc f893a = new C0317cc(true);

    /* renamed from: b */
    private int f894b;

    /* renamed from: c */
    private Object f895c;

    /* renamed from: d */
    private List f896d;

    /* renamed from: e */
    private C0313bz f897e;

    /* renamed from: f */
    private byte f898f;

    /* renamed from: g */
    private int f899g;

    private C0317cc(C0262ab c0262ab) {
        super(c0262ab);
        this.f898f = (byte) -1;
        this.f899g = -1;
    }

    private C0317cc(boolean z) {
        this.f898f = (byte) -1;
        this.f899g = -1;
    }

    /* renamed from: a */
    public static C0317cc m1686a() {
        return f893a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0317cc getDefaultInstanceForType() {
        return f893a;
    }

    /* renamed from: c */
    public boolean m1694c() {
        return (this.f894b & 1) == 1;
    }

    /* renamed from: d */
    public String m1695d() {
        Object obj = this.f895c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f895c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: i */
    private ByteString m1691i() {
        Object obj = this.f895c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f895c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m1696e() {
        return (this.f894b & 2) == 2;
    }

    /* renamed from: f */
    public C0313bz m1697f() {
        return this.f897e;
    }

    /* renamed from: j */
    private void m1692j() {
        this.f895c = "";
        this.f896d = Collections.emptyList();
        this.f897e = C0313bz.m1619a();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f898f;
        if (b != -1) {
            return b == 1;
        }
        this.f898f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f894b & 1) == 1) {
            codedOutputStream.writeBytes(1, m1691i());
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f896d.size()) {
                break;
            }
            codedOutputStream.writeMessage(2, (MessageLite) this.f896d.get(i2));
            i = i2 + 1;
        }
        if ((this.f894b & 2) == 2) {
            codedOutputStream.writeMessage(3, this.f897e);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = 0;
        int iComputeMessageSize = this.f899g;
        if (iComputeMessageSize == -1) {
            int iComputeBytesSize = (this.f894b & 1) == 1 ? CodedOutputStream.computeBytesSize(1, m1691i()) + 0 : 0;
            while (true) {
                iComputeMessageSize = iComputeBytesSize;
                if (i >= this.f896d.size()) {
                    break;
                }
                iComputeBytesSize = CodedOutputStream.computeMessageSize(2, (MessageLite) this.f896d.get(i)) + iComputeMessageSize;
                i++;
            }
            if ((this.f894b & 2) == 2) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(3, this.f897e);
            }
            this.f899g = iComputeMessageSize;
        }
        return iComputeMessageSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0317cc m1687a(byte[] bArr) {
        return ((C0262ab) newBuilder().mergeFrom(bArr)).m965m();
    }

    public static C0262ab newBuilder() {
        return C0262ab.m964l();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0262ab newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0262ab m1684a(C0317cc c0317cc) {
        return newBuilder().mergeFrom(c0317cc);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0262ab toBuilder() {
        return m1684a(this);
    }

    static {
        f893a.m1692j();
    }
}
