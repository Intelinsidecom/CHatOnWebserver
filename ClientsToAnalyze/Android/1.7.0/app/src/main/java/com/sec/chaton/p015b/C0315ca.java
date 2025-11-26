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
/* renamed from: com.sec.chaton.b.ca */
/* loaded from: classes.dex */
public final class C0315ca extends GeneratedMessageLite implements InterfaceC0337k {

    /* renamed from: a */
    private static final C0315ca f886a = new C0315ca(true);

    /* renamed from: b */
    private int f887b;

    /* renamed from: c */
    private Object f888c;

    /* renamed from: d */
    private List f889d;

    /* renamed from: e */
    private C0313bz f890e;

    /* renamed from: f */
    private byte f891f;

    /* renamed from: g */
    private int f892g;

    private C0315ca(C0324cj c0324cj) {
        super(c0324cj);
        this.f891f = (byte) -1;
        this.f892g = -1;
    }

    private C0315ca(boolean z) {
        this.f891f = (byte) -1;
        this.f892g = -1;
    }

    /* renamed from: a */
    public static C0315ca m1664a() {
        return f886a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0315ca getDefaultInstanceForType() {
        return f886a;
    }

    /* renamed from: c */
    public boolean m1674c() {
        return (this.f887b & 1) == 1;
    }

    /* renamed from: d */
    public String m1675d() {
        Object obj = this.f888c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f888c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: k */
    private ByteString m1670k() {
        Object obj = this.f888c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f888c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public List m1676e() {
        return this.f889d;
    }

    /* renamed from: f */
    public int m1677f() {
        return this.f889d.size();
    }

    /* renamed from: a */
    public C0285ay m1672a(int i) {
        return (C0285ay) this.f889d.get(i);
    }

    /* renamed from: g */
    public boolean m1678g() {
        return (this.f887b & 2) == 2;
    }

    /* renamed from: h */
    public C0313bz m1679h() {
        return this.f890e;
    }

    /* renamed from: l */
    private void m1671l() {
        this.f888c = "";
        this.f889d = Collections.emptyList();
        this.f890e = C0313bz.m1619a();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f891f;
        if (b != -1) {
            return b == 1;
        }
        this.f891f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f887b & 1) == 1) {
            codedOutputStream.writeBytes(1, m1670k());
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f889d.size()) {
                break;
            }
            codedOutputStream.writeMessage(2, (MessageLite) this.f889d.get(i2));
            i = i2 + 1;
        }
        if ((this.f887b & 2) == 2) {
            codedOutputStream.writeMessage(3, this.f890e);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = 0;
        int iComputeMessageSize = this.f892g;
        if (iComputeMessageSize == -1) {
            int iComputeBytesSize = (this.f887b & 1) == 1 ? CodedOutputStream.computeBytesSize(1, m1670k()) + 0 : 0;
            while (true) {
                iComputeMessageSize = iComputeBytesSize;
                if (i >= this.f889d.size()) {
                    break;
                }
                iComputeBytesSize = CodedOutputStream.computeMessageSize(2, (MessageLite) this.f889d.get(i)) + iComputeMessageSize;
                i++;
            }
            if ((this.f887b & 2) == 2) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(3, this.f890e);
            }
            this.f892g = iComputeMessageSize;
        }
        return iComputeMessageSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0315ca m1665a(byte[] bArr) {
        return ((C0324cj) newBuilder().mergeFrom(bArr)).m1755m();
    }

    public static C0324cj newBuilder() {
        return C0324cj.m1754l();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0324cj newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0324cj m1666a(C0315ca c0315ca) {
        return newBuilder().mergeFrom(c0315ca);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0324cj toBuilder() {
        return m1666a(this);
    }

    static {
        f886a.m1671l();
    }
}
