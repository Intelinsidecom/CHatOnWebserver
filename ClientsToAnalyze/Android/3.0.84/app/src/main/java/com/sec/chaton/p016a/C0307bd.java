package com.sec.chaton.p016a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.bd */
/* loaded from: classes.dex */
public final class C0307bd extends GeneratedMessageLite implements InterfaceC0309bf {

    /* renamed from: a */
    private static final C0307bd f1006a = new C0307bd(true);

    /* renamed from: b */
    private int f1007b;

    /* renamed from: c */
    private Object f1008c;

    /* renamed from: d */
    private EnumC0302az f1009d;

    /* renamed from: e */
    private List<C0333cc> f1010e;

    /* renamed from: f */
    private Object f1011f;

    /* renamed from: g */
    private boolean f1012g;

    /* renamed from: h */
    private Object f1013h;

    /* renamed from: i */
    private byte f1014i;

    /* renamed from: j */
    private int f1015j;

    private C0307bd(C0308be c0308be) {
        super(c0308be);
        this.f1014i = (byte) -1;
        this.f1015j = -1;
    }

    private C0307bd(boolean z) {
        this.f1014i = (byte) -1;
        this.f1015j = -1;
    }

    /* renamed from: a */
    public static C0307bd m1710a() {
        return f1006a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0307bd getDefaultInstanceForType() {
        return f1006a;
    }

    /* renamed from: c */
    public boolean m1725c() {
        return (this.f1007b & 1) == 1;
    }

    /* renamed from: d */
    public String m1726d() {
        Object obj = this.f1008c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1008c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: q */
    private ByteString m1719q() {
        Object obj = this.f1008c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1008c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m1727e() {
        return (this.f1007b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0302az m1728f() {
        return this.f1009d;
    }

    /* renamed from: g */
    public List<C0333cc> m1729g() {
        return this.f1010e;
    }

    /* renamed from: h */
    public int m1730h() {
        return this.f1010e.size();
    }

    /* renamed from: a */
    public C0333cc m1723a(int i) {
        return this.f1010e.get(i);
    }

    /* renamed from: i */
    public boolean m1731i() {
        return (this.f1007b & 4) == 4;
    }

    /* renamed from: j */
    public String m1732j() {
        Object obj = this.f1011f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1011f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: r */
    private ByteString m1720r() {
        Object obj = this.f1011f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1011f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m1733k() {
        return (this.f1007b & 8) == 8;
    }

    /* renamed from: l */
    public boolean m1734l() {
        return this.f1012g;
    }

    /* renamed from: m */
    public boolean m1735m() {
        return (this.f1007b & 16) == 16;
    }

    /* renamed from: n */
    public String m1736n() {
        Object obj = this.f1013h;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1013h = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: s */
    private ByteString m1721s() {
        Object obj = this.f1013h;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1013h = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: t */
    private void m1722t() {
        this.f1008c = "";
        this.f1009d = EnumC0302az.SINGLE;
        this.f1010e = Collections.emptyList();
        this.f1011f = "";
        this.f1012g = false;
        this.f1013h = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f1014i;
        if (b != -1) {
            return b == 1;
        }
        this.f1014i = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1007b & 1) == 1) {
            codedOutputStream.writeBytes(1, m1719q());
        }
        if ((this.f1007b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f1009d.getNumber());
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f1010e.size()) {
                break;
            }
            codedOutputStream.writeMessage(3, this.f1010e.get(i2));
            i = i2 + 1;
        }
        if ((this.f1007b & 4) == 4) {
            codedOutputStream.writeBytes(4, m1720r());
        }
        if ((this.f1007b & 8) == 8) {
            codedOutputStream.writeBool(5, this.f1012g);
        }
        if ((this.f1007b & 16) == 16) {
            codedOutputStream.writeBytes(6, m1721s());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = 0;
        int iComputeBytesSize = this.f1015j;
        if (iComputeBytesSize == -1) {
            int iComputeBytesSize2 = (this.f1007b & 1) == 1 ? CodedOutputStream.computeBytesSize(1, m1719q()) + 0 : 0;
            if ((this.f1007b & 2) == 2) {
                iComputeBytesSize2 += CodedOutputStream.computeEnumSize(2, this.f1009d.getNumber());
            }
            while (true) {
                iComputeBytesSize = iComputeBytesSize2;
                if (i >= this.f1010e.size()) {
                    break;
                }
                iComputeBytesSize2 = CodedOutputStream.computeMessageSize(3, this.f1010e.get(i)) + iComputeBytesSize;
                i++;
            }
            if ((this.f1007b & 4) == 4) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(4, m1720r());
            }
            if ((this.f1007b & 8) == 8) {
                iComputeBytesSize += CodedOutputStream.computeBoolSize(5, this.f1012g);
            }
            if ((this.f1007b & 16) == 16) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(6, m1721s());
            }
            this.f1015j = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0307bd m1711a(byte[] bArr) {
        return ((C0308be) newBuilder().mergeFrom(bArr)).m1743i();
    }

    public static C0308be newBuilder() {
        return C0308be.m1742h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public C0308be newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0308be m1712a(C0307bd c0307bd) {
        return newBuilder().mergeFrom(c0307bd);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public C0308be toBuilder() {
        return m1712a(this);
    }

    static {
        f1006a.m1722t();
    }
}
