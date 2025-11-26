package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import java.io.IOException;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.fh */
/* loaded from: classes.dex */
public final class C0935fh extends GeneratedMessageLite implements InterfaceC0937fj {

    /* renamed from: a */
    private static final C0935fh f2950a = new C0935fh(true);

    /* renamed from: b */
    private int f2951b;

    /* renamed from: c */
    private int f2952c;

    /* renamed from: d */
    private Object f2953d;

    /* renamed from: e */
    private C0963gi f2954e;

    /* renamed from: f */
    private C0919es f2955f;

    /* renamed from: g */
    private LazyStringList f2956g;

    /* renamed from: h */
    private LazyStringList f2957h;

    /* renamed from: i */
    private LazyStringList f2958i;

    /* renamed from: j */
    private LazyStringList f2959j;

    /* renamed from: k */
    private LazyStringList f2960k;

    /* renamed from: l */
    private byte f2961l;

    /* renamed from: m */
    private int f2962m;

    private C0935fh(C0936fi c0936fi) {
        super(c0936fi);
        this.f2961l = (byte) -1;
        this.f2962m = -1;
    }

    private C0935fh(boolean z) {
        this.f2961l = (byte) -1;
        this.f2962m = -1;
    }

    /* renamed from: a */
    public static C0935fh m5211a() {
        return f2950a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0935fh getDefaultInstanceForType() {
        return f2950a;
    }

    /* renamed from: c */
    public boolean m5228c() {
        return (this.f2951b & 1) == 1;
    }

    /* renamed from: d */
    public int m5229d() {
        return this.f2952c;
    }

    /* renamed from: e */
    public boolean m5230e() {
        return (this.f2951b & 2) == 2;
    }

    /* renamed from: f */
    public String m5231f() {
        Object obj = this.f2953d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2953d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: r */
    private ByteString m5225r() {
        Object obj = this.f2953d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2953d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m5232g() {
        return (this.f2951b & 4) == 4;
    }

    /* renamed from: h */
    public C0963gi m5233h() {
        return this.f2954e;
    }

    /* renamed from: i */
    public boolean m5234i() {
        return (this.f2951b & 8) == 8;
    }

    /* renamed from: j */
    public C0919es m5235j() {
        return this.f2955f;
    }

    /* renamed from: k */
    public List<String> m5236k() {
        return this.f2956g;
    }

    /* renamed from: l */
    public List<String> m5237l() {
        return this.f2957h;
    }

    /* renamed from: m */
    public List<String> m5238m() {
        return this.f2958i;
    }

    /* renamed from: n */
    public List<String> m5239n() {
        return this.f2959j;
    }

    /* renamed from: o */
    public List<String> m5240o() {
        return this.f2960k;
    }

    /* renamed from: s */
    private void m5226s() {
        this.f2952c = 0;
        this.f2953d = "";
        this.f2954e = C0963gi.m5611a();
        this.f2955f = C0919es.m4979a();
        this.f2956g = LazyStringArrayList.EMPTY;
        this.f2957h = LazyStringArrayList.EMPTY;
        this.f2958i = LazyStringArrayList.EMPTY;
        this.f2959j = LazyStringArrayList.EMPTY;
        this.f2960k = LazyStringArrayList.EMPTY;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2961l;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2961l = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2951b & 1) == 1) {
            codedOutputStream.writeInt32(1, this.f2952c);
        }
        if ((this.f2951b & 2) == 2) {
            codedOutputStream.writeBytes(2, m5225r());
        }
        if ((this.f2951b & 4) == 4) {
            codedOutputStream.writeMessage(3, this.f2954e);
        }
        if ((this.f2951b & 8) == 8) {
            codedOutputStream.writeMessage(4, this.f2955f);
        }
        for (int i = 0; i < this.f2956g.size(); i++) {
            codedOutputStream.writeBytes(5, this.f2956g.getByteString(i));
        }
        for (int i2 = 0; i2 < this.f2957h.size(); i2++) {
            codedOutputStream.writeBytes(6, this.f2957h.getByteString(i2));
        }
        for (int i3 = 0; i3 < this.f2958i.size(); i3++) {
            codedOutputStream.writeBytes(7, this.f2958i.getByteString(i3));
        }
        for (int i4 = 0; i4 < this.f2959j.size(); i4++) {
            codedOutputStream.writeBytes(8, this.f2959j.getByteString(i4));
        }
        for (int i5 = 0; i5 < this.f2960k.size(); i5++) {
            codedOutputStream.writeBytes(9, this.f2960k.getByteString(i5));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.f2962m;
        if (i == -1) {
            int iComputeInt32Size = (this.f2951b & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.f2952c) + 0 : 0;
            if ((this.f2951b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(2, m5225r());
            }
            if ((this.f2951b & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeMessageSize(3, this.f2954e);
            }
            if ((this.f2951b & 8) == 8) {
                iComputeInt32Size += CodedOutputStream.computeMessageSize(4, this.f2955f);
            }
            int iComputeBytesSizeNoTag = 0;
            for (int i2 = 0; i2 < this.f2956g.size(); i2++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f2956g.getByteString(i2));
            }
            int size = iComputeInt32Size + iComputeBytesSizeNoTag + (m5236k().size() * 1);
            int iComputeBytesSizeNoTag2 = 0;
            for (int i3 = 0; i3 < this.f2957h.size(); i3++) {
                iComputeBytesSizeNoTag2 += CodedOutputStream.computeBytesSizeNoTag(this.f2957h.getByteString(i3));
            }
            int size2 = size + iComputeBytesSizeNoTag2 + (m5237l().size() * 1);
            int iComputeBytesSizeNoTag3 = 0;
            for (int i4 = 0; i4 < this.f2958i.size(); i4++) {
                iComputeBytesSizeNoTag3 += CodedOutputStream.computeBytesSizeNoTag(this.f2958i.getByteString(i4));
            }
            int size3 = size2 + iComputeBytesSizeNoTag3 + (m5238m().size() * 1);
            int iComputeBytesSizeNoTag4 = 0;
            for (int i5 = 0; i5 < this.f2959j.size(); i5++) {
                iComputeBytesSizeNoTag4 += CodedOutputStream.computeBytesSizeNoTag(this.f2959j.getByteString(i5));
            }
            int size4 = (m5239n().size() * 1) + size3 + iComputeBytesSizeNoTag4;
            int iComputeBytesSizeNoTag5 = 0;
            for (int i6 = 0; i6 < this.f2960k.size(); i6++) {
                iComputeBytesSizeNoTag5 += CodedOutputStream.computeBytesSizeNoTag(this.f2960k.getByteString(i6));
            }
            int size5 = iComputeBytesSizeNoTag5 + size4 + (m5240o().size() * 1);
            this.f2962m = size5;
            return size5;
        }
        return i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0936fi newBuilder() {
        return C0936fi.m5245l();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public C0936fi newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0936fi m5212a(C0935fh c0935fh) {
        return newBuilder().mergeFrom(c0935fh);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public C0936fi toBuilder() {
        return m5212a(this);
    }

    static {
        f2950a.m5226s();
    }
}
