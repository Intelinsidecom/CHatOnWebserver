package com.sec.chaton.p015b;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import java.io.IOException;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.ah */
/* loaded from: classes.dex */
public final class C0268ah extends GeneratedMessageLite implements InterfaceC0291bd {

    /* renamed from: a */
    private static final C0268ah f684a = new C0268ah(true);

    /* renamed from: b */
    private int f685b;

    /* renamed from: c */
    private long f686c;

    /* renamed from: d */
    private EnumC0275ao f687d;

    /* renamed from: e */
    private EnumC0323ci f688e;

    /* renamed from: f */
    private Object f689f;

    /* renamed from: g */
    private Object f690g;

    /* renamed from: h */
    private long f691h;

    /* renamed from: i */
    private Object f692i;

    /* renamed from: j */
    private LazyStringList f693j;

    /* renamed from: k */
    private Object f694k;

    /* renamed from: l */
    private byte f695l;

    /* renamed from: m */
    private int f696m;

    private C0268ah(C0304bq c0304bq) {
        super(c0304bq);
        this.f695l = (byte) -1;
        this.f696m = -1;
    }

    private C0268ah(boolean z) {
        this.f695l = (byte) -1;
        this.f696m = -1;
    }

    /* renamed from: a */
    public static C0268ah m1084a() {
        return f684a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0268ah getDefaultInstanceForType() {
        return f684a;
    }

    /* renamed from: c */
    public boolean m1101c() {
        return (this.f685b & 1) == 1;
    }

    /* renamed from: d */
    public long m1102d() {
        return this.f686c;
    }

    /* renamed from: e */
    public boolean m1103e() {
        return (this.f685b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0275ao m1104f() {
        return this.f687d;
    }

    /* renamed from: g */
    public boolean m1105g() {
        return (this.f685b & 4) == 4;
    }

    /* renamed from: h */
    public EnumC0323ci m1106h() {
        return this.f688e;
    }

    /* renamed from: i */
    public boolean m1107i() {
        return (this.f685b & 8) == 8;
    }

    /* renamed from: j */
    public String m1108j() {
        Object obj = this.f689f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f689f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: v */
    private ByteString m1095v() {
        Object obj = this.f689f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f689f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m1109k() {
        return (this.f685b & 16) == 16;
    }

    /* renamed from: l */
    public String m1110l() {
        Object obj = this.f690g;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f690g = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: w */
    private ByteString m1096w() {
        Object obj = this.f690g;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f690g = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: m */
    public boolean m1111m() {
        return (this.f685b & 32) == 32;
    }

    /* renamed from: n */
    public long m1112n() {
        return this.f691h;
    }

    /* renamed from: o */
    public boolean m1113o() {
        return (this.f685b & 64) == 64;
    }

    /* renamed from: p */
    public String m1114p() {
        Object obj = this.f692i;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f692i = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: x */
    private ByteString m1097x() {
        Object obj = this.f692i;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f692i = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: q */
    public List m1115q() {
        return this.f693j;
    }

    /* renamed from: r */
    public boolean m1116r() {
        return (this.f685b & 128) == 128;
    }

    /* renamed from: s */
    public String m1117s() {
        Object obj = this.f694k;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f694k = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: y */
    private ByteString m1098y() {
        Object obj = this.f694k;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f694k = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: z */
    private void m1099z() {
        this.f686c = 0L;
        this.f687d = EnumC0275ao.TEXT;
        this.f688e = EnumC0323ci.SINGLE;
        this.f689f = "";
        this.f690g = "";
        this.f691h = 0L;
        this.f692i = "";
        this.f693j = LazyStringArrayList.EMPTY;
        this.f694k = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f695l;
        if (b != -1) {
            return b == 1;
        }
        this.f695l = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f685b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f686c);
        }
        if ((this.f685b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f687d.getNumber());
        }
        if ((this.f685b & 4) == 4) {
            codedOutputStream.writeEnum(3, this.f688e.getNumber());
        }
        if ((this.f685b & 8) == 8) {
            codedOutputStream.writeBytes(4, m1095v());
        }
        if ((this.f685b & 16) == 16) {
            codedOutputStream.writeBytes(5, m1096w());
        }
        if ((this.f685b & 32) == 32) {
            codedOutputStream.writeInt64(6, this.f691h);
        }
        if ((this.f685b & 64) == 64) {
            codedOutputStream.writeBytes(7, m1097x());
        }
        for (int i = 0; i < this.f693j.size(); i++) {
            codedOutputStream.writeBytes(8, this.f693j.getByteString(i));
        }
        if ((this.f685b & 128) == 128) {
            codedOutputStream.writeBytes(9, m1098y());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int size = this.f696m;
        if (size == -1) {
            int iComputeInt64Size = (this.f685b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f686c) + 0 : 0;
            if ((this.f685b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(2, this.f687d.getNumber());
            }
            if ((this.f685b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(3, this.f688e.getNumber());
            }
            if ((this.f685b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(4, m1095v());
            }
            if ((this.f685b & 16) == 16) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(5, m1096w());
            }
            if ((this.f685b & 32) == 32) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(6, this.f691h);
            }
            if ((this.f685b & 64) == 64) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(7, m1097x());
            }
            int iComputeBytesSizeNoTag = 0;
            for (int i = 0; i < this.f693j.size(); i++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f693j.getByteString(i));
            }
            size = iComputeInt64Size + iComputeBytesSizeNoTag + (m1115q().size() * 1);
            if ((this.f685b & 128) == 128) {
                size += CodedOutputStream.computeBytesSize(9, m1098y());
            }
            this.f696m = size;
        }
        return size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0268ah m1085a(byte[] bArr) {
        return ((C0304bq) newBuilder().mergeFrom(bArr)).m1468o();
    }

    public static C0304bq newBuilder() {
        return C0304bq.m1467n();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public C0304bq newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0304bq m1087a(C0268ah c0268ah) {
        return newBuilder().mergeFrom(c0268ah);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public C0304bq toBuilder() {
        return m1087a(this);
    }

    static {
        f684a.m1099z();
    }
}
